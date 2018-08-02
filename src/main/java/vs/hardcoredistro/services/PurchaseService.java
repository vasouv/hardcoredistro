package vs.hardcoredistro.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import vs.hardcoredistro.entities.Customer;
import vs.hardcoredistro.entities.OrderedAlbum;
import vs.hardcoredistro.entities.Purchase;

@Stateless
public class PurchaseService {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private CustomerService customerService;

	public List<Purchase> findAll() {
		TypedQuery<Purchase> query = em.createQuery("select p from Purchase p", Purchase.class);
		List<Purchase> all = query.getResultList();
		return all;
	}

	public void create(Purchase toPlace) {
//		Customer toBuy = customerService.findByName(toPlace.getCustomer().getName());
//		List<OrderedAlbum> toOrder = new ArrayList<>(toPlace.getOrderedAlbums());
//		Purchase newPurchase = new Purchase(toPlace.getDatePlaced(), toBuy, toOrder);
                System.out.println("Before persist: "+toPlace);
		em.persist(toPlace);
	}

	public Purchase first() {
		return em.find(Purchase.class, 1L);
	}

	public List<Purchase> vasouv() {
		return em.createQuery("select p from Purchase p where p.customer.name=:cname").setParameter("cname", "vasouv")
				.getResultList();
	}

}
