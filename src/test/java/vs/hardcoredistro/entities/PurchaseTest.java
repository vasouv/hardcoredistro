package vs.hardcoredistro.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author vasou
 */
public class PurchaseTest {

    Album jomsviking = new Album("Jomsviking", "Amon Amarth", 2017, "Viking death metal", "Metal Blade", "http://www.lasertimepodcast.com/wp-content/uploads/2016/02/iron-maiden-eddie-wallpaper-.jpg", new BigDecimal("17.00"));
    Album firepower = new Album("Firepower", "Judas Priest", 2018, "Great comeback", "Capitol", "http://www.lasertimepodcast.com/wp-content/uploads/2016/02/iron-maiden-eddie-wallpaper-.jpg", new BigDecimal("19.00"));
    Album incorruptible = new Album("Incorruptible", "Iced Earth", 2017, "havent listened much", "Dont know", "http://www.lasertimepodcast.com/wp-content/uploads/2016/02/iron-maiden-eddie-wallpaper-.jpg", new BigDecimal("18.00"));
    Album lastStand = new Album("The Last Stand", "Sabaton", 2016, "awesoooommee", "Nuclear Blast", "http://www.lasertimepodcast.com/wp-content/uploads/2016/02/iron-maiden-eddie-wallpaper-.jpg", new BigDecimal("16.00"));
    Album prequelle = new Album("Prequelle", "Ghost", 2018, "heavy rock at its best", "metal blade", "http://www.lasertimepodcast.com/wp-content/uploads/2016/02/iron-maiden-eddie-wallpaper-.jpg", new BigDecimal("19.00"));

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

    //Now I need to actually mock my services
    
    @Test
    @Ignore
    public void purchaseTotalAmountIs0WithEmptyOrderedAlbums() {
        //purchaseWithEmptyList.setTotalAmount();
        assertEquals(new BigDecimal("0.00"), purchaseWithEmptyList.getTotalAmount());
    }

    @Test
    @Ignore
    public void purchaseTotalAmountIsCalculatedFromOrderedAlbums() {
        //purchaseWithOrderedAlbums.setTotalAmount();
        BigDecimal expected = new BigDecimal("0.00");
        for (OrderedAlbum withOrderedAlbum : withOrderedAlbums) {
            BigDecimal albumTotal = withOrderedAlbum.getAlbum().getPrice().multiply(new BigDecimal(withOrderedAlbum.getQuantity()));
            expected = expected.add(albumTotal);
        }
        assertEquals(expected, purchaseWithOrderedAlbums.getTotalAmount());
    }

}
