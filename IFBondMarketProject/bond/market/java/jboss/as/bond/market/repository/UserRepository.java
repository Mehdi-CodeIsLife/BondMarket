package jboss.as.bond.market.repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jboss.as.bond.market.model.User;

@Stateless
public class UserRepository {

	@PersistenceContext
	EntityManager em;
	
	
	public UserRepository(){}

	public User findUser(int id){
		return em.find(User.class, id);
	}

	public User findUserByEmail(String email){
		Query q = em.createQuery("Select u From User u where email = :email", User.class);
		q.setParameter("email", email);
		if(q.getMaxResults() == 1)
			return (User) q.getSingleResult();
		return null;
	}

	public int check_login(String email, String password){
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> ur = criteria.from(User.class);
        criteria.select(ur).where(cb.equal(ur.get("email"), email));
        User u = em.createQuery(criteria).getSingleResult();
    	
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			 
	        byte byteData[] = md.digest();
	        
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<byteData.length;i++) {
	    		String hex=Integer.toHexString(0xff & byteData[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
	    	System.out.println("Digest(in hex format):: " + hexString.toString());
	    	System.out.println(u.getPassword());
	        
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return u.getId();
	}
	
	
}
