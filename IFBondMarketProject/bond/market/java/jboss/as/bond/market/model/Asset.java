package jboss.as.bond.market.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public  class Asset implements Serializable {
	
	private int id;
	private Company company;
	private float strike;
	private int quantity;
	
	private Set<PortfolioLine> pf_line = new HashSet<PortfolioLine>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company")
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "strike", precision = 12, scale = 0)
	public float getStrike() {
		return this.strike;
	}

	public void setStrike(float strike) {
		this.strike = strike;
	}
	
	@OneToMany(mappedBy="asset")
	public Set<PortfolioLine> getPf_line() {
		return pf_line;
	}

	public void setPf_line(Set<PortfolioLine> pf_line) {
		this.pf_line = pf_line;
	}
	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
