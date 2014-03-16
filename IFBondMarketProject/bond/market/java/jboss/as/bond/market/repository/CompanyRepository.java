package jboss.as.bond.market.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	@SuppressWarnings("unchecked")
	public List<Asset> getCompanyAsset(int id){
		Query q =em.createQuery("Select a From Asset a LEFT JOIN a.company ON c.id = :id");
		q.setParameter("id", id);
		return q.getResultList();
	}
	
}
