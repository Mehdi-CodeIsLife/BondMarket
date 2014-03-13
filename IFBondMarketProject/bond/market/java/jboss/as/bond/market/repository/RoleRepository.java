package jboss.as.bond.market.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jboss.as.bond.market.model.Role;

public class RoleRepository {
	
	@Inject
	private EntityManager em;  
	
	public Role findById(Long id) {
        return em.find(Role.class, id);
    }

    public Role findByName(String name) {
    	
    	
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Role> criteria = cb.createQuery(Role.class);
        Root<Role> role = criteria.from(Role.class);
        criteria.select(role).where(cb.equal(role.get("name"), name));
        return em.createQuery(criteria).getSingleResult();
    }
	
}
