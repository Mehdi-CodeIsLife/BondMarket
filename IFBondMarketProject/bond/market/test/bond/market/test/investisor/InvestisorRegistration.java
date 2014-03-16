package bond.market.test.investisor;

import static org.junit.Assert.*;

import java.util.logging.Logger;
import javax.inject.Inject;

import org.junit.Test;

import jboss.as.bond.market.helper.InvestisorHelper;
import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Role;


public class InvestisorRegistration {
	
	public class InvestisorRegistrationTest {
	    
	    public  void createTestArchive() {
//	        return ShrinkWrap.create(WebArchive.class, "test.war")
//	                .addClasses(Investisor.class, InvestisorRegistration.class, Resources.class)
//	                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
//	                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
//	                // Deploy our test datasource
//	                .addAsWebInfResource("test-ds.xml");
	    }

	    @Inject
	    InvestisorHelper ih;

	    @Inject
	    Logger log;

	    @Test
	    public void testRegister() throws Exception {
	        Investisor newInvestisor = new Investisor();
	        newInvestisor.setUsername("if name");
	        newInvestisor.setEmail("groupe@dauphine.if.com");
	        newInvestisor.setIsActive(false);
	        newInvestisor.addRole(new Role(3, "Invesitsor"));
	        
	        
	        ih.setInv(newInvestisor);
	        assertNotNull(newInvestisor.getId());
	        log.info(newInvestisor.getUsername() + " was persisted with id " + newInvestisor.getId());
	    }

	}
	
}
