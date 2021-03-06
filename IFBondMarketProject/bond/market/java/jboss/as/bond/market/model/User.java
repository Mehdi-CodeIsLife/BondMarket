package jboss.as.bond.market.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jboss.as.bond.market.util.Encryp;


@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public  class User implements Serializable {

	private int id;
	private Set<Role> roles = new HashSet<Role>(0);
	private Date createdAt;
	private String email;
	private String password;
	private Boolean isActive = true; // disable for investisors
	private String username;


	public User(){}

	public User(Date createdAt, String email, String password,
			Boolean isActive, String username) {
		this.createdAt = createdAt;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.username = username;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToMany(fetch=FetchType.EAGER) 
	@JoinTable(name = "User_Role", joinColumns = { @JoinColumn(name = "user_id") },
	inverseJoinColumns = { @JoinColumn(name = "role_id") })
	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role r){
		this.roles.add(r);
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdAt", length = 10)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date date){
		this.createdAt = date;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("************************************");
		System.out.println(new Encryp().encode(password));
		System.out.println("************************************");
		this.password = new Encryp().encode(password);
	}

}
