package jboss.as.bond.market.model;
// default package
// Generated Mar 13, 2014 4:27:29 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AssetOption generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "AssetOption", catalog = "BondMarket")
public class AssetOption extends Asset{

	private Date settlement;

	public AssetOption() {
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "settlement", length = 10)
	public Date getSettlement() {
		return this.settlement;
	}

	public void setSettlement(Date settlement) {
		this.settlement = settlement;
	}

}
