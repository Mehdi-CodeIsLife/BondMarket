package jboss.as.bond.market.helper;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.NoResultException;

import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Profile;
import jboss.as.bond.market.model.Role;
import jboss.as.bond.market.repository.InvestisorRepository;
import jboss.as.bond.market.repository.RoleRepository;

@Stateful
public class InvestisorHelper  {
	
	private Investisor inv;
	
	@EJB
	private InvestisorRepository invRep;
	
	@EJB
	private RoleRepository roleRep;
	
	@EJB
	UserHelper uh;
	
	public InvestisorHelper() {
	}
	
	public void excuteTrad(){}
	
	public void bindUser(Investisor investisor){
		this.setInv(investisor);
	}
	
	public Investisor getById(int id){
		return this.invRep.find(id);
	}
	
	public boolean checkEmailAvailable(String email){
		return uh.checkEmailAvailable(email);
	}
	
	public void buildInvestisor(){
		this.inv = new Investisor();
		Role role = roleRep.findByName("investisor");
		if(role == null)
			throw new NoResultException();
		
		inv.addRole(role);
		inv.setIsActive(false);
		inv.setCreatedAt(new Date());
		inv.setProfile(new Profile());
	}
	
	public void fillProprieties(String password, String email, String lastname, String firstname, String market_capitalization, String termTrading, String derivatives) {
		buildInvestisor();
		getInv().setEmail(email);
		getInv().setUsername(email);
		getInv().setPassword(password);
		getInv().setProfile(new Profile(firstname, lastname, termTrading, market_capitalization, derivatives));
	}
	
	public void save(Investisor user){
		if(checkEmailAvailable(user.getEmail()))
			invRep.save(user);
	}
	
	public Investisor getInv() {
		return inv;
	}

	public void setInv(Investisor inv) {
		this.inv = inv;
	}

	public List<Investisor> findAll() {
		return invRep.findAll();
	}

	public void remove(Investisor inv2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
