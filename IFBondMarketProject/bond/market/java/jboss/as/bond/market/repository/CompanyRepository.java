package jboss.as.bond.market.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jboss.as.bond.market.model.Asset;
import jboss.as.bond.market.model.Company;

@Stateless
public class CompanyRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Company> findAll(){
		return   em.createQuery("Select c From Company c", Company.class).getResultList();
	}
	
	public Company find(int id){
		return em.find(Company.class, id);
	}

	public List<Asset> getCompanyAsset(int id){
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Asset> criteria = cb.createQuery(Asset.class);
        Root<Asset> ur = criteria.from(Asset.class);
        criteria.select(ur).where(cb.equal(ur.get("company"), id));
        return em.createQuery(criteria).getResultList();
	}
	
	
}
