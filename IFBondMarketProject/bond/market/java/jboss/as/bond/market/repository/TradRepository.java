package jboss.as.bond.market.repository;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jboss.as.bond.market.model.Trad;
import jboss.as.bond.market.model.Transaction;


@Stateless
public class TradRepository {
	
	public TradRepository() {}
	
	@PersistenceContext
	EntityManager em;
		
	public Trad findById(Long id) {
        return em.find(Trad.class, id);
    }
	
	public List<Trad> findAll(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trad> criteria = cb.createQuery(Trad.class);
        Root<Trad> Trad = criteria.from(Trad.class);
        criteria.select(Trad);
        return em.createQuery(criteria).getResultList();
	}
	
    public List<Trad> findByDate(Date date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trad> criteria = cb.createQuery(Trad.class);
        Root<Trad> Trad = criteria.from(Trad.class);
     
        criteria.select(Trad).where(cb.equal(Trad.get("puttedAt"), date));
        return em.createQuery(criteria).getResultList();
    }

    public List<Trad> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trad> criteria = cb.createQuery(Trad.class);
        Root<Trad> Trad = criteria.from(Trad.class);
        
        criteria.select(Trad).orderBy(cb.asc(Trad.get("name")));
        return em.createQuery(criteria).getResultList();
    }
    
    public void save(Trad t){
    	em.persist(t);
    }
    
    public Trad find(int id){
    	return em.find(Trad.class, id);
    }
	
    public void update(Trad t){
    	if(t instanceof Transaction)
    		em.persist(t);
    }
	
}
