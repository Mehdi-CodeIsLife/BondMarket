package jboss.as.bond.market.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import jboss.as.bond.market.helper.AssetHelper;
import jboss.as.bond.market.model.Company;

@ManagedBean
@RequestScoped
public class AssetController {
	
	@EJB
	private AssetHelper ah;
	
	private int id;
	private float strike;
	private Company company;
	
	public AssetController(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getStrike() {
		return strike;
	}
	public void setStrike(float strike) {
		this.strike = strike;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
		
}
