package jboss.as.bond.market.helper;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import jboss.as.bond.market.model.Asset;
import jboss.as.bond.market.repository.AssetRepository;

@Stateful
public class AssetHelper {
	
	@EJB
	private AssetRepository ar;
	
	private Asset asset;
	
	public void save(){
		ar.save(this.asset);
	}
	
	public Asset find(int id){
		return ar.find(id);
	}
	
	public void bind(){
		
	}
}
