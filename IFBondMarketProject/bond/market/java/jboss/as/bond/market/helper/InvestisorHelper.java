package jboss.as.bond.market.helper;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
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
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
    protected UserTransaction t; 
	
	
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
	
	public void save() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		t.begin();
		em.persist(this.inv);
		t.commit();
		
	}
	
	public Investisor getInv() {
		return inv;
	}

	public void setInv(Investisor inv) {
		this.inv = inv;
	}
	
	
	
}
