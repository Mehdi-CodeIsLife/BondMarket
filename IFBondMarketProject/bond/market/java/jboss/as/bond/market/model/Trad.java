package jboss.as.bond.market.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public  class Trad implements Serializable {
	
	private int id;
	private Investisor investisorByOwner;
	private Investisor investisorByBuyer;
	private Date calledAt;
	private float price;
	private Date puttedAt;
	private int quantity;
	private Asset asset;
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	public Investisor getInvestisorByOwner() {
		return this.investisorByOwner;
	}

	public void setInvestisorByOwner(Investisor investisorByOwner) {
		this.investisorByOwner = investisorByOwner;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buyer")
	public Investisor getInvestisorByBuyer() {
		return this.investisorByBuyer;
	}

	public void setInvestisorByBuyer(Investisor investisorByBuyer) {
		this.investisorByBuyer = investisorByBuyer;
	}

	@Column(name = "calledAt", length = 10)
	public Date getCalledAt() {
		return this.calledAt;
	}

	public void setCalledAt(Date calledAt) {
		this.calledAt = calledAt;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "puttedAt", length = 10)
	public Date getPuttedAt() {
		return this.puttedAt;
	}

	public void setPuttedAt(Date puttedAt) {
		this.puttedAt = puttedAt;
	}

	@Column(name = "quantity")
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@OneToOne
	@JoinColumn(name = "asset")
	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	

}
