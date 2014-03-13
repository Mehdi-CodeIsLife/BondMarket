package jboss.as.bond.market.helper;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import jboss.as.bond.market.model.Investisor;
import jboss.as.bond.market.model.Profile;
import jboss.as.bond.market.model.Role;
import jboss.as.bond.market.repository.RoleRepository;

public class InvestisorHelper  {
	
	private Investisor inv;
	
	@Inject
    private EntityManager em;  
	
	public void bindUser(Investisor investisor){
		this.setInv(investisor);
	}
	
	public void buildInvestisor(){
		this.inv = new Investisor();
		Role role = new RoleRepository().findByName("investisor");
		if(role == null)
			throw new NoResultException();
		inv.setRole(role);
		inv.setProfile(new Profile());
	}
	
	public void save(){
		
		
		try {
			InitialContext ic = new InitialContext();
			UserTransaction utx = (UserTransaction) ic.lookup("java:comp/UserTransaction");
			utx.begin();
			em.persist(this.inv);
			utx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.close();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.close();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.close();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.close();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.close();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.close();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public Investisor getInv() {
		return inv;
	}

	public void setInv(Investisor inv) {
		this.inv = inv;
	}
	
	
	
}
