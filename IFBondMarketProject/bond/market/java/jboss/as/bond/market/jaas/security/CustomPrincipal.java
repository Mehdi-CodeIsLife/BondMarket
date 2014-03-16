package jboss.as.bond.market.jaas.security;

import java.io.Serializable;

import org.jboss.security.SimplePrincipal;

@SuppressWarnings("serial")
public class CustomPrincipal extends SimplePrincipal implements Serializable {

	public CustomPrincipal(String name, String password) {
		super(name);
	}
	
	


}
