package jboss.as.bond.market.helper;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.NoResultException;

import jboss.as.bond.market.model.Administrator;
import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Role;
import jboss.as.bond.market.repository.RoleRepository;
import jboss.as.bond.market.repository.UserRepository;

@Stateful
public class AdminHelper {
	
	@EJB
	InvestisorHelper ih;
	
	@EJB
	UserRepository ar;
	
	@EJB
	UserHelper ah;
	
	@EJB
	private RoleRepository roleRep;
	
	public void activeProfile(int id){
		Investisor inv = ih.getById(id);
		inv.setIsActive(true);
		ih.save(inv);
	}
	
	public void save(Administrator ad){
		if(ah.checkEmailAvailable(ad.getEmail()))
			ar.save(ad);
	}
	
	public void saveData(String email, String username, String password){
		Administrator administrator = new Administrator(new Date(), email, password, true, username);
		Role role = roleRep.findByName("Administrator");
		if(role == null)
			throw new NoResultException();
		administrator.addRole(role);
		save(administrator);	
	}

	public void declineProfile(int id) {
		Investisor inv = ih.getById(id);
		ih.remove(inv);
	}
	
	
}
