package jboss.as.bond.market.helper;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.context.FacesContext;

import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Portfolio;
import jboss.as.bond.market.repository.PortfolioRepository;


@Stateful
public class PortFolioHelper  {
	
	@EJB
	private PortfolioRepository pr;
	
	@EJB
	private InvestisorHelper ih;
	
	private Portfolio pf;
	
	public  PortFolioHelper() {}
	
	public void bind(String title, int owner_id){
		Investisor owner = this.getInvestisorById(owner_id);
		if(owner != null)
			this.setPf(new Portfolio(owner, title, null));	
	}
	
	public List<Portfolio> getMyPortFolios(int inv_id){
		return pr.getMyPortFolios(inv_id);
	}
	
	public Investisor getInvestisorById(int id){
		return ih.getById(id);
	}
	
	public void save(){
		pr.save(this.pf);
	}

	public Portfolio getPf() {
		return pf;
	}

	public void setPf(Portfolio pf) {
		this.pf = pf;
	}
	
	
	
	
	
	
}
