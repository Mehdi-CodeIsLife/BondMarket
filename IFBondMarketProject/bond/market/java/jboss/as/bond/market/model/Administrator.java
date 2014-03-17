package jboss.as.bond.market.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Administrator", catalog = "BondMarket")
public class Administrator extends User  {

	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(Date createdAt, String email, String password,
			Boolean isActive, String username) {
		super(createdAt, email, password, isActive, username);
		// TODO Auto-generated constructor stub
	}

	
}
