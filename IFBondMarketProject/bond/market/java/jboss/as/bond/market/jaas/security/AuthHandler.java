package jboss.as.bond.market.jaas.security;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jboss.as.bond.market.model.Role;
import jboss.as.bond.market.model.User;
import jboss.as.bond.market.repository.UserRepository;


@Stateful
public class AuthHandler {

	@PersistenceContext
	EntityManager em;

	@EJB
	private UserRepository ur;

	public AuthHandler(){}

	private Set<String> roles;

	private User current;
	private boolean isAuthentified = false;

	public void loginHandler(String email, String password){
		User findUserByEmail = ur.findUserByEmail(email);
		
		if(findUserByEmail != null)
		this.attemptLogin(findUserByEmail, password);
		if(this.isAuthentified()){
			Iterator<Role> it = findUserByEmail.getRoles().iterator();
			while(it.hasNext())
				roles.add(it.next().getName());
			
		}
	}
	
	public boolean isCredentialCompliant(String email, String password){

		Query q = em.createQuery("Select u.password from User u where u.email = :email", User.class);
		q.setParameter("email", email);
		String hashedPassword = (String) q.getSingleResult();
		if(q.getMaxResults() > 0){
			return MessageDigest.isEqual(hashedPassword.getBytes(), ((String) q.getSingleResult()).getBytes());
		}
		return false;
	}
	
	public void attemptLogin(User u, String password){
		if(this.isAuthentified)
			return;
		if(this.isCredentialCompliant(u.getEmail(), password)){
			if( getAnnotationValue() != null ){
				Iterator<Role> itr = u.getRoles().iterator();
				while(itr.hasNext())
					if( ((Role)itr.next()).getName().equals(getAnnotationValue()) ){
						this.current = u;
						this.setAuthentified(true);
					}
			}
		}
	}
	
	public String getAnnotationValue(){
		if(this.getClass().isAnnotationPresent(SecuredAppPath.class))
			this.getClass().getAnnotation(SecuredAppPath.class).role();
		return null;
	}

	public boolean isAuthentified(){
		return this.isAuthentified;
	}

	public User getCurrent() {
		return current;
	}

	public void setAuthentified(){
		this.isAuthentified = true;
	}

	public boolean isAuthorized(){
		Iterator<String> it = roles.iterator();
		while(it.hasNext())
			if(it.next() == this.getAnnotationValue())
				return true;
		return false;
	}

	public void setCurrent(User current) {
		this.current = current;
	}


	public void setAuthentified(boolean isAuthentified) {
		this.isAuthentified = isAuthentified;
	}

	
}
