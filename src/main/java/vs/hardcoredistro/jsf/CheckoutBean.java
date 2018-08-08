package vs.hardcoredistro.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import vs.hardcoredistro.entities.OrderedAlbum;
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

    private List<OrderedAlbum> albumsToOrder;

    @PostConstruct
    public void init() {
        albumsToOrder = new ArrayList<>(cartBean.getOrderedAlbums());
    }

    public String buy() {
        boolean purchaseCompleted = purchaseService.create(albumsToOrder, "vasouv");
        if (purchaseCompleted) {
            return "checkout-complete.xhtml";
        }
        showMessage();
        return "checkout.xhtml";
    }
    
    private void showMessage(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Some albums were not in availability. Please check quantity"));
    }

    public boolean checkAvailability() {
        boolean allAvailable = false;
        for (OrderedAlbum orderedAlbum : albumsToOrder) {
            if (orderedAlbum.getQuantity() <= stockService.findByID(orderedAlbum.getAlbum().getId()).getStock()) {
                allAvailable = true;
            }
        }
        return allAvailable;
    }

    public List<OrderedAlbum> getAlbumsToOrder() {
        return albumsToOrder;
    }

    public void setAlbumsToOrder(List<OrderedAlbum> albumsToOrder) {
        this.albumsToOrder = albumsToOrder;
    }

}
