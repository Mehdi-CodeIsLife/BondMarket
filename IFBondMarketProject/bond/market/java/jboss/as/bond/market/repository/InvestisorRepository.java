package jboss.as.bond.market.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

import jboss.as.bond.market.model.Investisor;


public class InvestisorRepository {
	
	@Inject
    private EntityManager em;

    @Inject
    private UserTransaction utx;
	
	public Investisor findById(Long id) {
        return em.find(Investisor.class, id);
    }

    public Investisor findByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Investisor> criteria = cb.createQuery(Investisor.class);
        Root<Investisor> Investisor = criteria.from(Investisor.class);
        criteria.select(Investisor).where(cb.equal(Investisor.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Investisor> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Investisor> criteria = cb.createQuery(Investisor.class);
        Root<Investisor> Investisor = criteria.from(Investisor.class);
        criteria.select(Investisor).orderBy(cb.asc(Investisor.get("name")));
        return em.createQuery(criteria).getResultList();
    }
}
