package jboss.as.bond.market.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jboss.as.bond.market.model.Investisor;

@Stateless
public class InvestisorRepository {
	
	@PersistenceContext
    private EntityManager em;
	

	public void save(Investisor inv){
		em.persist(inv);
	}
	
	public Investisor find(int id){
		return em.find(Investisor.class, id);
	}
	
}
