package jboss.as.bond.market.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
	
	 // use @SuppressWarnings to tell IDE to ignore warnings about field not being referenced directly
    @Produces
    @PersistenceContext (unitName = "IFBondMarketProject")  
    private EntityManager em;

 
}