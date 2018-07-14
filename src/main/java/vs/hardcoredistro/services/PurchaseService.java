package vs.hardcoredistro.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import vs.hardcoredistro.entities.Purchase;

@Stateless
public class PurchaseService {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Purchase> findAll() {
		TypedQuery<Purchase> query = em.createQuery("select p from Purchase p",Purchase.class);
		List<Purchase> all = query.getResultList();
		return all;
	}
	

}
