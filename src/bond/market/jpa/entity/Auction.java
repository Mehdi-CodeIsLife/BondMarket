package bond.market.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * entity correspend au contrat par enchères
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="Auction")
public class Auction extends Trading{
	
	@Column(name="auction")
	private float auction;
	
	public Auction(){}
	
}
