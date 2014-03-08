package bond.market.jpa.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public abstract class Trading implements Serializable{
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name="puttedAt")
	private Date puttedAt;
	
	@Column(name="calledAt")
	private Date calledAt;
	
	@Column(name="price")
	private float price;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Investisor owner;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=true)
	private Investisor buyer;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=true)
	private Asset asset;
	
	@Column(name="quantity")
	private int quantity;
	
	public Trading(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPuttedAt() {
		return puttedAt;
	}

	public void setPuttedAt(Date puttedAt) {
		this.puttedAt = puttedAt;
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

	public Investisor getOwner() {
		return owner;
	}

	public void setOwner(Investisor owner) {
		this.owner = owner;
	}

	public Investisor getBuyer() {
		return buyer;
	}

	public void setBuyer(Investisor buyer) {
		this.buyer = buyer;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
