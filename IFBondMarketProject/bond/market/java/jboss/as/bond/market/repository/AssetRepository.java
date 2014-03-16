package jboss.as.bond.market.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jboss.as.bond.market.model.Asset;

@Stateless
public class AssetRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Asset> findAll(){
		return   em.createQuery("Select c From Asset c", Asset.class).getResultList();
	}
	
	public Asset find(int id){
		return em.find(Asset.class, id);
	}
	
	public void save(Asset a){
		em.persist(a);
	}
	
	public void remove(Asset a){
		em.remove(a);
	}
	
	
}
