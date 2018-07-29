package vs.hardcoredistro.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import vs.hardcoredistro.entities.Customer;

@Stateless
public class CustomerService {

	@PersistenceContext
	private EntityManager em;

	public List<Customer> findAll() {
		TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
		List<Customer> all = query.getResultList();
		return all;
	}

	public Customer findByName(String name) {
		return (Customer) em.createQuery("select c from Customer c where c.name=:cname").setParameter("cname", name)
				.getSingleResult();
	}

	public void create(Customer c) {
		em.persist(c);
	}

}
