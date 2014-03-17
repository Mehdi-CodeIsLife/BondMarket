package jboss.as.bond.market.helper;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import jboss.as.bond.market.model.PortfolioLine;
import jboss.as.bond.market.repository.PortFolioLineRepository;

@Stateless
public class PortFolioLineHelper {
	
	@EJB
	private PortFolioLineRepository pr;
	
	@EJB
	private TradHelper th;
	
	public void save(PortfolioLine p){
		pr.save(p);
	}

	public List<PortfolioLine> getPFLine(int pf_id) {
		return pr.findPFLines(pf_id);
	}

	public void sell(PortfolioLine pfl, int quantity_to_sell, float price) {
		th.sell(pfl, quantity_to_sell, price);
	}
}
