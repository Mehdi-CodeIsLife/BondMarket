package jboss.as.bond.market.helper;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import jboss.as.bond.market.repository.RoleRepository;
import jboss.as.bond.market.repository.UserRepository;

@Stateless
public class UserHelper {
	
	
	@EJB
	UserRepository ar;
	
	@EJB
	private RoleRepository roleRep;
	
	
	public boolean checkEmailAvailable(String email){
		if(ar.findUserByEmail(email)!= null)
			return false;
		return true;
	}
	
}
