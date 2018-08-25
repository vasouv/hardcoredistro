package vs.hardcoredistro.services;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import vs.hardcoredistro.entities.Customer;
import vs.hardcoredistro.entities.OrderedAlbum;
import vs.hardcoredistro.entities.Purchase;
import vs.hardcoredistro.entities.PurchaseStatus;

@Stateless
public class PurchaseService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private CustomerService customerService;

    @Inject
    private StockService stockService;

    public List<Purchase> findAll() {
        TypedQuery<Purchase> query = em.createQuery("select p from Purchase p", Purchase.class);
        List<Purchase> all = query.getResultList();
        return all;
    }

    public List<Purchase> findByCustomerName(String customerName) {
        return em.createQuery("select p from Purchase p where p.customer.name=:cname")
            .setParameter("cname", customerName)
            .getResultList();
    }

    public void create(Purchase toPlace) {
        em.persist(toPlace);
    }

    public void cancel(Long purchaseID) {
        Purchase toCancel = em.find(Purchase.class, purchaseID);
        stockService.increaseStockForAlbums(toCancel.getOrderedAlbums());
        toCancel.setPurchaseStatus(PurchaseStatus.CANCELLED);
        em.merge(toCancel);
    }

    public void create(List<OrderedAlbum> albumsToOrder, String customerName) {
        Customer customer = customerService.findByName(customerName);
        Purchase pur = new Purchase(LocalDate.now(), customer, albumsToOrder, PurchaseStatus.PENDING);
        em.persist(pur);
    }

    public void ship(Long purchaseID) {
        Purchase toShip = em.find(Purchase.class, purchaseID);
        toShip.setPurchaseStatus(PurchaseStatus.SHIPPED);
        toShip.setDateShipped(LocalDate.now());
        em.merge(toShip);
    }

}
