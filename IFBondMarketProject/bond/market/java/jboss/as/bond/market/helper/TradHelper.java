package jboss.as.bond.market.helper;


import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;

import jboss.as.bond.market.model.Auction;
import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Portfolio;
import jboss.as.bond.market.model.PortfolioLine;
import jboss.as.bond.market.model.Trad;
import jboss.as.bond.market.repository.TradRepository;

@SuppressWarnings("unused")
@Stateless
public class TradHelper {
	
	@EJB
	private TradRepository tr;
	
	@EJB
	private InvestisorHelper ih;
	
	@EJB
	private PortFolioHelper ph;
	
	@EJB
	private PortFolioLineHelper plh;
	
	
	public void save(Trad t){
		tr.save(t);
	}
	
	public void buyTrad(Trad t, Investisor buyer){
		t.setInvestisorByBuyer(buyer);
		tr.update(t);
	}

	public void sell(PortfolioLine pfl, int quantity_to_sell, float price) {
		Trad t = new Trad();
		t.setAsset(pfl.getAsset());
		t.setCalledAt(new Date());
		t.setInvestisorByOwner(pfl.getPf().getInvestisor());
		t.setPrice(price);
		t.setQuantity(quantity_to_sell);
		tr.save(t);
	}

	public void buyTransaction(Trad t, int inv_id) {
		Investisor inv = ih.getById(inv_id);
		t.setInvestisorByBuyer(inv);
		t.setCalledAt(new Date());
		
//		Set<Portfolio> pfs = inv.getPortfolios();
//		Iterator<Portfolio> it = pfs.iterator();
//		while(it.hasNext())
//			it.next().
		//TODO : merge trad in portfolio line !!! critical
		
	}

	public void bidAuction(Trad t, int inv_id) {
		if(t instanceof Auction){
			Investisor inv = ih.getById(inv_id);
			t.setInvestisorByBuyer(inv);
			tr.save(t);
		}
		
	}
	
	
	
}
