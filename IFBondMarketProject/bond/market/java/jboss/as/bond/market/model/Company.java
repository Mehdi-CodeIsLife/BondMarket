package jboss.as.bond.market.model;

// Generated Mar 12, 2014 4:18:30 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name = "Company", catalog = "BondMarket")
public class Company implements java.io.Serializable {

	private Integer id;
	private String category;
	private String description;
	private String name;
	private Set<StockOption> stockOptions = new HashSet<StockOption>(0);
	private Set<Member> members = new HashSet<Member>(0);
	private Set<AssetOption> assetOptions = new HashSet<AssetOption>(0);
	private Set<SecurityAsset> securityAssets = new HashSet<SecurityAsset>(0);

	public Company() {
	}

	public Company(String category, String description, String name,
			Set<StockOption> stockOptions, Set<Member> members,
			Set<AssetOption> assetOptions, Set<SecurityAsset> securityAssets) {
		this.category = category;
		this.description = description;
		this.name = name;
		this.stockOptions = stockOptions;
		this.members = members;
		this.assetOptions = assetOptions;
		this.securityAssets = securityAssets;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "category")
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<StockOption> getStockOptions() {
		return this.stockOptions;
	}

	public void setStockOptions(Set<StockOption> stockOptions) {
		this.stockOptions = stockOptions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Member> getMembers() {
		return this.members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<AssetOption> getAssetOptions() {
		return this.assetOptions;
	}

	public void setAssetOptions(Set<AssetOption> assetOptions) {
		this.assetOptions = assetOptions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<SecurityAsset> getSecurityAssets() {
		return this.securityAssets;
	}

	public void setSecurityAssets(Set<SecurityAsset> securityAssets) {
		this.securityAssets = securityAssets;
	}

}