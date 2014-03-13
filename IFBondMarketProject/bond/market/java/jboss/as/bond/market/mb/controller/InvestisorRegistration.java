package jboss.as.bond.market.mb.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jboss.as.bond.market.helper.InvestisorHelper;
import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Profile;

@ManagedBean
@RequestScoped
public class InvestisorRegistration implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private String email; 
	private String password;
	private String confirmPassword;
	private String firstname;
	private String lastname;
	private String phone;
	
	@Inject 
    private EntityManager em;  

	public InvestisorRegistration(){};
	
	public String response() throws NamingException{
		
		InvestisorHelper investisorHelper = new InvestisorHelper();
		investisorHelper.buildInvestisor();
		Investisor inv = investisorHelper.getInv();
		inv.setEmail(getEmail());
		inv.setPassword(getPassword());
		inv.setProfile(new Profile(getFirstname(), getLastname(), getPhone(), inv ));
		
		investisorHelper.bindUser(inv);
		investisorHelper.save();
		
		System.out.println(investisorHelper.getInv());
		
		return "saved !!!";
	}
	

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
