package vs.hardcoredistro.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vasou
 */
public class PurchaseTest {

    Album jomsviking = new Album("Jomsviking", "Amon Amarth", 2017, "Viking death metal", "Metal Blade", "none", 17.5);
    Album firepower = new Album("Firepower", "Judas Priest", 2018, "Great comeback", "Capitol", "some url", 19.4);
    Album incorruptible = new Album("Incorruptible", "Iced Earth", 2017, "havent listened much", "Dont know", "there is", 18.3);
    Album lastStand = new Album("The Last Stand", "Sabaton", 2016, "awesoooommee", "Nuclear Blast", "oeoeoeoe", 15.6);
    Album prequelle = new Album("Prequelle", "Ghost", 2018, "heavy rock at its best", "metal blade", "there is no url", 19.2);

    Customer vasouv = new Customer("vasouv", "1234567", "vasouv", "Themistokleous", "Xanthi", "67133", "Greece");
    Customer john = new Customer("john", "987654", "john", "Kallithea", "Xanthi", "67100", "Greece");
    Customer chris = new Customer("chris", "22222", "chris", "Sardewn", "Xanthi", "67133", "Greece");

    List<OrderedAlbum> albumsToOrder;

    List<OrderedAlbum> emptyOrderedAlbums;
    List<OrderedAlbum> withOrderedAlbums;

    Purchase purchaseWithEmptyList;
    Purchase purchaseWithOrderedAlbums;

    @Before
    public void before() {

        albumsToOrder = new ArrayList<>();
        albumsToOrder.add(new OrderedAlbum(2, firepower));
        albumsToOrder.add(new OrderedAlbum(1, incorruptible));

        emptyOrderedAlbums = new ArrayList<>();
        withOrderedAlbums = new ArrayList<>(albumsToOrder);

        purchaseWithEmptyList = new Purchase(LocalDate.now(), vasouv, emptyOrderedAlbums, PurchaseStatus.PENDING);
        purchaseWithOrderedAlbums = new Purchase(LocalDate.now(), vasouv, withOrderedAlbums, PurchaseStatus.PENDING);
    }

    @Test
    public void purchaseTotalAmountIs0WithEmptyOrderedAlbums() {
        purchaseWithEmptyList.setTotalAmount();
        assertEquals(0.0, purchaseWithEmptyList.getTotalAmount(), 0.0);
    }

    @Test
    public void purchaseTotalAmountIsCalculatedFromOrderedAlbums() {

        purchaseWithOrderedAlbums.setTotalAmount();
        double expected = 0.0;
        for (OrderedAlbum withOrderedAlbum : withOrderedAlbums) {
            expected += withOrderedAlbum.getAlbum().getPrice() * withOrderedAlbum.getQuantity();
        }
        assertEquals(expected, purchaseWithOrderedAlbums.getTotalAmount(), 0.0);
    }

}
