package jboss.as.bond.market.service;

import javax.ejb.Stateful;


@Stateful
public class LoginRequestHandler {
	
	private int id;
	private String username;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
