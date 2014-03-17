package jboss.as.bond.market.helper;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import jboss.as.bond.market.model.Company;
import jboss.as.bond.market.repository.CompanyRepository;

@Stateless
public class CompanyHelper {
	
	@EJB
	private CompanyRepository cr;
	
	public void updateInfo(String info, int c_id){
		Company c = cr.find(c_id);
		c.setDescription(info);
		cr.save(c);
	}
	
}
