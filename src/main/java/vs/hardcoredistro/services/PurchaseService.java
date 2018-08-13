package vs.hardcoredistro.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import vs.hardcoredistro.auth.LoggedInUser;

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

    @Inject
    private LoggedInUser loggedInUser;

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

    public boolean create(List<OrderedAlbum> albumsToOrder, String customerName) {

        boolean purchaseCompleted = false;

        if (stockService.albumListHasWantedQuantity(albumsToOrder)) {
            stockService.decreaseStockForAlbums(albumsToOrder);
            Customer customer = customerService.findByName(customerName);
            Purchase pur = new Purchase(LocalDate.now(), customer, albumsToOrder, PurchaseStatus.PENDING);
            pur.setTotalAmount();
            em.persist(pur);
            purchaseCompleted = true;
        }

        return purchaseCompleted;
    }

    public Purchase first() {
        return em.find(Purchase.class, 1L);
    }

    public List<Purchase> vasouv() {
        return em.createQuery("select p from Purchase p where p.customer.name=:cname")
            .setParameter("cname", "vasouv")
            .getResultList();
    }

    public void ship(Long purchaseID) {
        Purchase toShip = em.find(Purchase.class, purchaseID);
        toShip.setPurchaseStatus(PurchaseStatus.SHIPPED);
        toShip.setDateShipped(LocalDate.now());
        em.merge(toShip);
    }

}
