package vs.hardcoredistro.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import vs.hardcoredistro.entities.Album;
import java.io.Serializable;
import java.math.BigDecimal;
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
        boolean found = false;
        for (OrderedAlbum album1 : getOrderedAlbums()) {
            if (album1.getAlbum().equals(album)) {
                found = true;
                album1.setQuantity(album1.getQuantity()+1);
                break;
            }
        }
        if (!found) {
            getOrderedAlbums().add(oa);
        }
    }

    public void clear() {
        orderedAlbums.clear();
    }

    public void remove(OrderedAlbum oa) {
        orderedAlbums.remove(oa);
    }

    public BigDecimal totalAmount() {
        if (orderedAlbums.isEmpty()) {
            return new BigDecimal("0.00");
        }
        BigDecimal total = new BigDecimal("0.00");
        for (OrderedAlbum orderedAlbum : orderedAlbums) {
            BigDecimal orderedAlbumTotal = orderedAlbum.getAlbum().getPrice().multiply(new BigDecimal(orderedAlbum.getQuantity()));
            total = total.add(orderedAlbumTotal);
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
