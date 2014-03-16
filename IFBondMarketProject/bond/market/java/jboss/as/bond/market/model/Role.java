package jboss.as.bond.market.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "Role", catalog = "BondMarket")
public class Role implements java.io.Serializable {

	private int id;
	private String name;
	

	public Role() {
	}

	

	public Role(int id, String name) {
		this.id = id;
		this.name = name;
	}



	@ManyToMany(mappedBy = "roles") 
	private Set<User> users = new HashSet<User>();
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
