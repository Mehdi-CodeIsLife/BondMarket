package jboss.as.bond.market.managed.ejb.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jboss.as.bond.market.model.Investisor;


public class InverstisorDao implements Dao<Investisor>{
	
	@PersistenceContext
	EntityManager em;

    public Investisor getByEmail(String email) {
    	try {
            Query query = em.createQuery("select u from Investisor u where u.email = ?");
            query.setParameter(1, email);
            return (Investisor) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


	@Override
	public Investisor find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Investisor user) {
		em.remove(user);
	}

	@Override
	public void save(Investisor user) {
		em.persist(user);
	}

}	
