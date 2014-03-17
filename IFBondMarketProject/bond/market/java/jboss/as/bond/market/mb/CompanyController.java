package jboss.as.bond.market.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import jboss.as.bond.market.model.Company;
import jboss.as.bond.market.repository.CompanyRepository;

@ManagedBean
@RequestScoped
public class CompanyController {

	@EJB
	CompanyRepository cr;
	
	@ManagedProperty(value = "#{param.company_id}")
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
	
	public Company fetchCompany(){
		Company c = cr.find(this.getId());
		this.setName(c.getName());
		this.setCategory(c.getCategory());
		this.setDescription(c.getDescription());
		return c;
	}
	
	public List<Company> getCompanies(){
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
