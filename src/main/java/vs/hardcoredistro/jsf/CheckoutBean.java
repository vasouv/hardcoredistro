package vs.hardcoredistro.jsf;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.omnifaces.cdi.Param;
import org.omnifaces.util.Faces;
import vs.hardcoredistro.auth.LoggedInUser;
import vs.hardcoredistro.entities.OrderedAlbum;
import vs.hardcoredistro.services.PaymentService;
import vs.hardcoredistro.services.PurchaseService;
import vs.hardcoredistro.services.StockService;

/**
 *
 * @author vasouv
 */
@Named
@RequestScoped
public class CheckoutBean {

    @Inject
    private CartBean cartBean;

    @Inject
    private StockService stockService;

    @Inject
    private PurchaseService purchaseService;

    @Inject
    private LoggedInUser loggedInUser;

    @Inject
    private PaymentService paymentService;

    private List<OrderedAlbum> albumsToOrder;

    @Inject
    @ConfigProperty(name = "apiKey")
    private String apiKey;

    // Injects the stripeToken field returned from Stripe once the payment is processed
    @Inject
    @Param
    private String stripeToken;

    // Injects the user's email returned from Stripe
    @Inject
    @Param
    private String email;

    @PostConstruct
    public void init() {
        albumsToOrder = new ArrayList<>(cartBean.getOrderedAlbums());

        if (stripeToken != null && !stripeToken.isEmpty()) {
            createCharge();
        }
    }

    private void createCharge() {
        try {
            reserveAlbums();
            Charge charge = paymentService.charge(stripeToken, getTotal(), "EUR");
            if (charge != null) {
                purchaseService.create(albumsToOrder, loggedInUser.getLoggedInUser());
                Faces.redirect("user/checkout-complete.xhtml");
            } else {
                revertAlbums();
                Faces.redirect("user/checkout-failure.xhtml");
            }
        } catch (StripeException ex) {
            revertAlbums();
            Faces.redirect("user/checkout-failure.xhtml");
            ex.printStackTrace();
        }
    }

    private void reserveAlbums() {
        stockService.decreaseStockForAlbums(albumsToOrder);
    }

    private void revertAlbums() {
        stockService.increaseStockForAlbums(albumsToOrder);
    }

    private void showMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Some albums were not in availability. Please check quantity"));
    }

    public BigDecimal getTotalAmount() {
        BigDecimal total = new BigDecimal("0.00");
        for (OrderedAlbum orderedAlbum : albumsToOrder) {
            BigDecimal orderedAlbumTotal = orderedAlbum.getAlbum().getPrice().multiply(new BigDecimal(orderedAlbum.getQuantity()));
            total = total.add(orderedAlbumTotal);
        }
        return total;
    }

    /*
    * 1. Rounding up to zero decimals to create integer
    * 2. Multiply *100 so we don't charge cents instead of EUR
     */
    public BigDecimal getTotal() {
        BigDecimal forStripe = getTotalAmount();
        forStripe = forStripe.setScale(0, BigDecimal.ROUND_UP);
        return forStripe.multiply(new BigDecimal("100"));
    }

    // ACCESSOR METHODS
    public List<OrderedAlbum> getAlbumsToOrder() {
        return albumsToOrder;
    }

    public void setAlbumsToOrder(List<OrderedAlbum> albumsToOrder) {
        this.albumsToOrder = albumsToOrder;
    }

    public String getApiKey() {
        return apiKey;
    }

}
