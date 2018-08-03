package vs.hardcoredistro.startup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.omnifaces.cdi.Eager;

import vs.hardcoredistro.entities.Album;
import vs.hardcoredistro.entities.Customer;
import vs.hardcoredistro.entities.OrderedAlbum;
import vs.hardcoredistro.entities.Purchase;
import vs.hardcoredistro.entities.PurchaseStatus;
import vs.hardcoredistro.services.AlbumService;
import vs.hardcoredistro.services.CustomerService;
import vs.hardcoredistro.services.PurchaseService;
import vs.hardcoredistro.services.StockService;

@Eager
@Startup
@ApplicationScoped
public class InititalizerBean {

    @Inject
    private CustomerService customerService;

    @Inject
    private AlbumService albumService;

    @Inject
    private StockService stockService;

    @Inject
    private PurchaseService purchaseService;

    @PostConstruct
    public void init() {

        // Creating and persisting albums
        Album jomsviking = new Album("Jomsviking", "Amon Amarth", 2017, "Viking death metal", "Metal Blade", "none", 17.5);
        Album firepower = new Album("Firepower", "Judas Priest", 2018, "Great comeback", "Capitol", "some url", 19.4);
        Album incorruptible = new Album("Incorruptible", "Iced Earth", 2017, "havent listened much", "Dont know", "there is", 18.3);
        Album lastStand = new Album("The Last Stand", "Sabaton", 2016, "awesoooommee", "Nuclear Blast", "oeoeoeoe", 15.6);
        Album prequelle = new Album("Prequelle", "Ghost", 2018, "heavy rock at its best", "metal blade", "there is no url", 19.2);

        albumService.create(jomsviking);
        albumService.create(firepower);
        albumService.create(incorruptible);
        albumService.create(lastStand);
        albumService.create(prequelle);
        
        // Creating and persisting customers
        Customer vasouv = new Customer("vasouv", "1234567", "vasouv");
        Customer john = new Customer("john", "987654", "john");
        Customer chris = new Customer("chris", "22222", "chris");

        customerService.create(vasouv);
        customerService.create(john);
        customerService.create(chris);
        
        // Creating and persisting stock for albums
        stockService.create(jomsviking.getTitle(), 5);
        stockService.create(firepower.getTitle(), 7);
        stockService.create(incorruptible.getTitle(), 3);
        stockService.create(lastStand.getTitle(), 1);
        stockService.create(prequelle.getTitle(), 10);

        // Ordered albums for vasouv
        OrderedAlbum v1 = new OrderedAlbum(2, firepower);
        OrderedAlbum v2 = new OrderedAlbum(1, incorruptible);
        List<OrderedAlbum> forVasouv = new ArrayList<>();
        forVasouv.add(v1);
        forVasouv.add(v2);

        // Purchase for vasouv
        Purchase pVasouv = new Purchase(LocalDate.now(), vasouv, forVasouv);
        pVasouv.setPurchaseStatus(PurchaseStatus.PENDING);
        pVasouv.setTotalAmount();

        // Ordered albums for john
        OrderedAlbum j1 = new OrderedAlbum(2, firepower);
        OrderedAlbum j2 = new OrderedAlbum(3, jomsviking);
        OrderedAlbum j3 = new OrderedAlbum(5, incorruptible);
        List<OrderedAlbum> forJohn = new ArrayList<>();
        forJohn.add(j1);
        forJohn.add(j2);
        forJohn.add(j3);

        // Purchase for john
        Purchase pJohn = new Purchase(LocalDate.now(), john, forJohn);
        pJohn.setPurchaseStatus(PurchaseStatus.PENDING);
        pJohn.setTotalAmount();

        // Persists purchases
        purchaseService.create(pVasouv);
        purchaseService.create(pJohn);

        // New orderd albums for vasouv
        OrderedAlbum v3 = new OrderedAlbum(3, jomsviking);
        OrderedAlbum v4 = new OrderedAlbum(2, incorruptible);
        OrderedAlbum v5 = new OrderedAlbum(1, firepower);
        List<OrderedAlbum> forVasouvAgain = new ArrayList<>();
        forVasouvAgain.add(v3);
        forVasouvAgain.add(v4);
        forVasouvAgain.add(v5);

        // New purchase persistence
        Purchase newVasouv = new Purchase(LocalDate.now(), vasouv, forVasouvAgain);
        newVasouv.setPurchaseStatus(PurchaseStatus.SHIPPED);
        newVasouv.setTotalAmount();
        newVasouv.setDateShipped(LocalDate.now());
        
        purchaseService.create(newVasouv);

    }

}
