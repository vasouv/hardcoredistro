package vs.hardcoredistro.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import vs.hardcoredistro.entities.Album;
import java.io.Serializable;

@Named
@SessionScoped
public class CartBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Album> albumsInCart;

	@PostConstruct
	public void init() {
		albumsInCart = new ArrayList<>();
	}

	public void add(Album album) {
		albumsInCart.add(album);
	}

	public void clear() {
		albumsInCart.clear();
	}

	public void remove(Album album) {
		albumsInCart.remove(album);
	}

	public double totalAmount() {
		if (albumsInCart.size() == 0) {
			return 0;
		}
		double total = 0;
		for (Album album : albumsInCart) {
			total += album.getPrice();
		}
		return total;
	}

	public List<Album> getAlbumsInCart() {
		return albumsInCart;
	}

}
