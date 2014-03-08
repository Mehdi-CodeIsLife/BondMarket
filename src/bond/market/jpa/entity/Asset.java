package bond.market.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Asset")
public abstract class Asset implements Serializable{
	
	@Id @GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name="id")
	private Company company; //la société émettrice de l'asset
	
	@Column(name="strike")
	private float strike;   //le prix de l'exercice
		
	public Asset(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public float getStrike() {
		return strike;
	}

	public void setStrike(float strike) {
		this.strike = strike;
	}

	
}
