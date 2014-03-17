package jboss.as.bond.market.mb;

import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import jboss.as.bond.market.helper.InvestisorHelper;
import jboss.as.bond.market.helper.TradHelper;
import jboss.as.bond.market.model.Asset;
import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Trad;
import jboss.as.bond.market.repository.TradRepository;

@ManagedBean
@RequestScoped
public class TradController {
	
	@EJB
	private TradRepository tr;
	
	@EJB
	private TradHelper th;
	
	@EJB
	private InvestisorHelper ih;
	
	public TradController() {}
	
	private int id;
	private Date calledAt;
	private float price;
	private Date puttedAt;
	private int quantity;
	private	Asset asset;
	private Investisor buyer;
	private Investisor owner;
	
	@ManagedProperty(value = "#{param.id}")
	private int inv_id;
	@ManagedProperty(value = "#{param.asset_id}")
	private int asset_id;
	
	public void buy(Trad t){
		th.buyTransaction(t, inv_id);
	}
	
	public void bid(Trad t){
		th.bidAuction(t, inv_id);
	}
	
	public int getInv_id() {
		return inv_id;
	}

	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}

	public int getAsset_id() {
		return asset_id;
	}

	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}

	public List<Trad> trads(){
		return tr.findAll();
	}
	
	public void investisorButFromCompany(){
		if(this.inv_id != 0 && this.asset_id != 0){
			ih.excuteTrad(inv_id, asset_id, quantity);
		}
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCalledAt() {
		return calledAt;
	}
	public void setCalledAt(Date calledAt) {
		this.calledAt = calledAt;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getPuttedAt() {
		return puttedAt;
	}
	public void setPuttedAt(Date puttedAt) {
		this.puttedAt = puttedAt;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public Investisor getBuyer() {
		return buyer;
	}
	public void setBuyer(Investisor buyer) {
		this.buyer = buyer;
	}
	public Investisor getOwner() {
		return owner;
	}
	public void setOwner(Investisor owner) {
		this.owner = owner;
	}
	
	

}
