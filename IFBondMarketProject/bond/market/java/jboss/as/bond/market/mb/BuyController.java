package jboss.as.bond.market.mb;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;

import jboss.as.bond.market.helper.PortFolioHelper;

@RequestScoped
public class BuyController {
	
	@EJB
	PortFolioHelper ph;
	
	public BuyController(){}
	
	private int quantity;
	private int inv_id;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getInv_id() {
		return inv_id;
	}
	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}
	
	
	public void buy(){
		
	}
	
}
