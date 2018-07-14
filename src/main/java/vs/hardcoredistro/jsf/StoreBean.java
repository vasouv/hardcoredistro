package vs.hardcoredistro.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import vs.hardcoredistro.services.AlbumService;
import vs.hardcoredistro.entities.Album;

@Named
@RequestScoped
public class StoreBean {

	@Inject
	private AlbumService albumService;
	
	@Inject
	private CartBean cart;

	private List<Album> albums;
	
	private Album selected;

	@PostConstruct
	public void init() {
		albums = new ArrayList<>(albumService.findAll());
	}
	
	public void addToCart() {
		cart.add(selected);
	}
	
	public List<Album> getAlbums() {
		return albums;
	}
	
	public Album getSelected() {
		return selected;
	}
	
	public void setSelected(Album selected) {
		this.selected = selected;
	}

}
