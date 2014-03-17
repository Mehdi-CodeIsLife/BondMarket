package jboss.as.bond.market.repository;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jboss.as.bond.market.helper.InvestisorHelper;
import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Portfolio;
import jboss.as.bond.market.model.PortfolioLine;


@Stateless
public class PortfolioRepository {
	
	public  PortfolioRepository() {}
	
	@PersistenceContext
	EntityManager em;
	
	@EJB
	InvestisorHelper ih;
	
	
	public Portfolio findById(Long id) {
        return em.find(Portfolio.class, id);
    }
	
	public List<Portfolio> getMyPortFolios(int id){
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Portfolio> criteria = cb.createQuery(Portfolio.class);
        Root<Portfolio> pfs = criteria.from(Portfolio.class);
        criteria.select(pfs).where(cb.equal(pfs.get("investisor"), id));
        return em.createQuery(criteria).getResultList();
	}
	
	
    
    public List<PortfolioLine> findAllPFLines(int p_id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PortfolioLine> criteria = cb.createQuery(PortfolioLine.class);
        Root<PortfolioLine> pfl = criteria.from(PortfolioLine.class);
        
        criteria.select(pfl).where(cb.equal(pfl.get("pf").get("id"), p_id));
        return em.createQuery(criteria).getResultList();
    }
    
    public void save(Portfolio p){
    	em.persist(p);
    	em.flush();
    }
    
    public void remove(Portfolio p){
    	em.remove(em.contains(p) ? p : em.merge(p));
    }

    public Investisor getById(int id) {
		return ih.getById(id);
	}

	
}
