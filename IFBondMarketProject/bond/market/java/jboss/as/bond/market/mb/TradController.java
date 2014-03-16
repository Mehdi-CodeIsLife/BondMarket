package jboss.as.bond.market.mb;

import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import jboss.as.bond.market.model.Asset;
import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Trad;
import jboss.as.bond.market.repository.TradRepository;

@ManagedBean
@RequestScoped
public class TradController {
	
	@EJB
	private TradRepository tr;
	
	public TradController() {}
	
	private int id;
	private Date calledAt;
	private float price;
	private Date puttedAt;
	private int quantity;
	private	Asset asset;
	private Investisor buyer;
	private Investisor owner;
	
	
	public List<Trad> trads(){
		return tr.findAll();
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
