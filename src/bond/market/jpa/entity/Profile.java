package bond.market.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Profile implements Serializable{
	
	@Id @GeneratedValue
	private int id;
	
	@OneToOne(mappedBy="profile")
	private Investisor user;
	
	@Column(name="firstname")
	private String firtname;
	
	@Column(name="lastname")
	private String lastname;
	
	public Profile(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Investisor getUser() {
		return user;
	}

	public void setUser(Investisor user) {
		this.user = user;
	}

	public String getFirtname() {
		return firtname;
	}

	public void setFirtname(String firtname) {
		this.firtname = firtname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
}
