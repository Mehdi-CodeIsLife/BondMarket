package bond.market.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Portfolio implements Serializable{
	@Id @GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Asset asset;
	
	@ManyToOne
	@JoinColumn(name="protfolios")
	private Investisor owner;
	
	@Column(name="quantity")
	private int quantity;
	
	
}
