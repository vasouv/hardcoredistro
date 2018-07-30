package vs.hardcoredistro.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import vs.hardcoredistro.entities.Album;
import vs.hardcoredistro.services.AlbumService;
import vs.hardcoredistro.jsf.CartBean;

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
		showAddedAlbum();
	}
	
	private void showAddedAlbum() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Added album", selected.getTitle()));
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
