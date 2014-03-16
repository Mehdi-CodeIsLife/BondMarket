package jboss.as.bond.market.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "PortfolioLine", catalog = "BondMarket")
public class PortfolioLine implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	
	
	@ManyToOne
	private Portfolio pf;
	
	@OneToOne
	private Asset asset;
	
	@Column(name="quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Portfolio getPf() {
		return pf;
	}

	public void setPf(Portfolio pf) {
		this.pf = pf;
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
