package jboss.as.bond.market.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jboss.as.bond.market.model.Investisor;

@Stateless
public class InvestisorRepository {
	
	@PersistenceContext
    private EntityManager em;
	

	public void save(Investisor inv){
		em.persist(inv);
	}
	
	public void remove(Investisor p){
    	em.remove(em.contains(p) ? p : em.merge(p));
    }
	
	public Investisor find(int id){
		return em.find(Investisor.class, id);
	}

	public List<Investisor> findAll() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Investisor> criteria = cb.createQuery(Investisor.class);
        Root<Investisor> ur = criteria.from(Investisor.class);
        criteria.select(ur).where(cb.equal(ur.get("isActive"), false));
        return em.createQuery(criteria).getResultList();
	}
	
}
