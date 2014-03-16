package jboss.as.bond.market.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import jboss.as.bond.market.model.Company;
import jboss.as.bond.market.repository.CompanyRepository;
import jboss.as.bond.market.service.LoginRequestHandler;

@ManagedBean
@SessionScoped
public class CompanyController {

	@EJB
	CompanyRepository cr;
	
	@EJB
	LoginRequestHandler lrq;
	
	private int id;
	private String name;
	private String category;
	private String description;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Company> getCompanies(){
		System.out.println("**************************************");
		System.out.println(lrq.getId());
    	System.out.println("*********************************");
		return cr.findAll();
	}
	
	@SuppressWarnings("rawtypes")
	public List getAssets(){
		return cr.getCompanyAsset(getId());
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	

}
