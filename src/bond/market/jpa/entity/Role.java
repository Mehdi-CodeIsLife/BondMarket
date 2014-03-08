package bond.market.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Role implements Serializable{
	@Id @GeneratedValue
	private int id;
	@Column(name="name")
	private String name;
	public int getId() {
		return id;
	}
	
	public Role(){}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
