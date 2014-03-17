package jboss.as.bond.market.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jboss.as.bond.market.model.PortfolioLine;

@Stateless
public class PortFolioLineRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(PortfolioLine p ){
		em.persist(p);
	}

	public List<PortfolioLine> findPFLines(int pf_id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PortfolioLine> criteria = cb.createQuery(PortfolioLine.class);
        Root<PortfolioLine> pfs = criteria.from(PortfolioLine.class);
        criteria.select(pfs).where(cb.equal(pfs.get("pf"), pf_id));
        return em.createQuery(criteria).getResultList();
	}
	
	
}
