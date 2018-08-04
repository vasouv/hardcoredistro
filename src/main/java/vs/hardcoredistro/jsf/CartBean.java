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

    private static final long serialVersionUID = 1L;

    private List<Album> albumsInCart;
    private List<OrderedAlbum> orderedAlbums;

    @PostConstruct
    public void init() {
        albumsInCart = new ArrayList<>();
        orderedAlbums = new ArrayList<>();
    }

    public void add(Album album) {
        OrderedAlbum oa = new OrderedAlbum(1, album);
        orderedAlbums.add(oa);
//        albumsInCart.add(album);
    }

    public void clear() {
        orderedAlbums.clear();
//        albumsInCart.clear();
    }
    
    public void remove(OrderedAlbum oa) {
        orderedAlbums.remove(oa);
    }
    
//    public void remove(Album album) {
//        albumsInCart.remove(album);
//    }

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

    public List<Album> getAlbumsInCart() {
        return albumsInCart;
    }

    public List<OrderedAlbum> getOrderedAlbums() {
        return orderedAlbums;
    }

    public void setOrderedAlbums(List<OrderedAlbum> orderedAlbums) {
        this.orderedAlbums = orderedAlbums;
    }

}
