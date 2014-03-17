package jboss.as.bond.market.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jboss.as.bond.market.model.User;
import jboss.as.bond.market.util.Encryp;

@Stateless
public class UserRepository {

	@PersistenceContext
	EntityManager em;
	
	
	public UserRepository(){}

	public User findUser(int id){
		return em.find(User.class, id);
	}
	
	public void save(User u){
		em.persist(u);
	}
	
	public void remove(User p){
    	em.remove(em.contains(p) ? p : em.merge(p));
    }

	public User findUserByEmail(String email){
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> ur = criteria.from(User.class);
        criteria.select(ur).where(cb.equal(ur.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
	}

	public int check_login(String email, String password){
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> ur = criteria.from(User.class);
        criteria.select(ur).where(cb.equal(ur.get("email"), email));
        User u = em.createQuery(criteria).getSingleResult();
    	
       if( new Encryp().decode(u.getPassword()).equals(password))
    	   return u.getId();
       return 0;
	}
	
	
}
