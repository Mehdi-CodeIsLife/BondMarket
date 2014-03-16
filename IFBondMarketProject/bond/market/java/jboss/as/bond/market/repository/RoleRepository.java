package jboss.as.bond.market.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jboss.as.bond.market.model.Role;

@Stateless
public class RoleRepository {
	
	@PersistenceContext
	EntityManager em;
  
	public RoleRepository(){}
	
	public Role findById(Long id) {
        return em.find(Role.class, id);
    }

    public Role findByName(String name) {
    	Query q = em.createQuery("SELECT r FROM Role r WHERE r.name = :name");
        q.setParameter("name", name);
        return (Role) q.getSingleResult();
      }
	
}
