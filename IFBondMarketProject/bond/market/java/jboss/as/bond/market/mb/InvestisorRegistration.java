package jboss.as.bond.market.mb;

import java.util.Date;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Profile;

@ManagedBean
@RequestScoped
public class InvestisorRegistration {
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
    protected UserTransaction t; 
	
	
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

	public String response() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		Profile profile = new Profile(firstname, lastname, termTrading, 
									  market_capitalization, derivatives);
		Investisor inv = new Investisor( profile, new Date(), email, 
										 false, firstname+"."+lastname, password);
		t.begin();
		em.persist(inv);
		t.commit();
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
