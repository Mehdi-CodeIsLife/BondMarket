package jboss.as.bond.market.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import jboss.as.bond.market.helper.InvestisorHelper;

@ManagedBean
@SessionScoped
public class InvestisorRegistration {

	
	@EJB
	private InvestisorHelper invHelper;
	
	private String email;
	private String password;
	private String confirmPassword;
	private String firstname;
	private String lastname;
	private String termTrading;
	private String market_capitalization;
	private String derivatives;

	
	public String getDerivatives() {
		return derivatives;
	}

	public void setDerivatives(String derivatives) {
		this.derivatives = derivatives;
	}

	public String response(){
		invHelper.fillProprieties(password, email, lastname, firstname, market_capitalization, termTrading, derivatives);
		invHelper.save(invHelper.getInv());
		return "confirm";
	}

	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getTermTrading() {
		return termTrading;
	}

	public void setTermTrading(String termTrading) {
		this.termTrading = termTrading;
	}

	public String getMarket_capitalization() {
		return market_capitalization;
	}

	public void setMarket_capitalization(String market_capitalization) {
		this.market_capitalization = market_capitalization;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
}
