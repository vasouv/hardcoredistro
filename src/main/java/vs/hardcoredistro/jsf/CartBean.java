package vs.hardcoredistro.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import vs.hardcoredistro.entities.Album;
import java.io.Serializable;
import vs.hardcoredistro.entities.OrderedAlbum;

@Named
@SessionScoped
public class CartBean implements Serializable {

    private List<OrderedAlbum> orderedAlbums;

    @PostConstruct
    public void init() {
        orderedAlbums = new ArrayList<>();
    }

    public void add(Album album) {
        OrderedAlbum oa = new OrderedAlbum(1, album);
        orderedAlbums.add(oa);
    }

    public void clear() {
        orderedAlbums.clear();
    }
    
    public void remove(OrderedAlbum oa) {
        orderedAlbums.remove(oa);
    }
    
    public double totalAmount() {
        if (orderedAlbums.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (OrderedAlbum album : orderedAlbums) {
            total += album.getAlbum().getPrice() * album.getQuantity();
        }
        return total;
    }
    
    /*
    * ACCESSOR METHODS
    */

    public List<OrderedAlbum> getOrderedAlbums() {
        return orderedAlbums;
    }

    public void setOrderedAlbums(List<OrderedAlbum> orderedAlbums) {
        this.orderedAlbums = orderedAlbums;
    }

}
