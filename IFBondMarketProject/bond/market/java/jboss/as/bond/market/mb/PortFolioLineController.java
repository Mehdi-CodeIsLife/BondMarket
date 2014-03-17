package jboss.as.bond.market.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import jboss.as.bond.market.helper.PortFolioLineHelper;
import jboss.as.bond.market.model.PortfolioLine;

@ManagedBean
@RequestScoped
public class PortFolioLineController {

	@EJB
	private PortFolioLineHelper plh;
	
	private int pf_id;
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	private int quantity_to_sell;
	private int pfl_id;
	private float price;

	
	public List<PortfolioLine> findAll(){
		return plh.getPFLine(this.pf_id);
	}
	
	public void sell(PortfolioLine pfl){
		plh.sell(pfl, quantity_to_sell, price );
	}

	public int getPf_id() {
		return pf_id;
	}

	public void setPf_id(int pf_id) {
		this.pf_id = pf_id;
	}

	public int getPfl_id() {
		return pfl_id;
	}

	public void setPfl_id(int pfl_id) {
		this.pfl_id = pfl_id;
	}

	public int getQuantity_to_sell() {
		return quantity_to_sell;
	}

	public void setQuantity_to_sell(int quantity_to_sell) {
		this.quantity_to_sell = quantity_to_sell;
	}
}
