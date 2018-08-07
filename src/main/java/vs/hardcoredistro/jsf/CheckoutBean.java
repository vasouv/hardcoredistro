package vs.hardcoredistro.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import vs.hardcoredistro.entities.OrderedAlbum;
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

    private List<OrderedAlbum> albumsToOrder;

    @PostConstruct
    public void init() {
        albumsToOrder = new ArrayList<>(cartBean.getOrderedAlbums());
    }
    
    public boolean checkAvailability(){
        boolean allAvailable = false;
        for (OrderedAlbum orderedAlbum : albumsToOrder) {
            if(orderedAlbum.getQuantity() <= stockService.findByID(orderedAlbum.getAlbum().getId()).getStock()){
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
