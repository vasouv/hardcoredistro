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
import vs.hardcoredistro.entities.Stock;
import vs.hardcoredistro.services.StockService;

@Named
@RequestScoped
public class StoreBean {

    @Inject
    private StockService stockService;

    @Inject
    private CartBean cart;

    private List<Stock> albumsInStock;

    private Album selected;

    @PostConstruct
    public void init() {
        albumsInStock = new ArrayList<>(stockService.findAll());
    }

    public void addToCart() {
        cart.add(selected);
        showAddedAlbum();
    }

    private void showAddedAlbum() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Added album", selected.getTitle()));
    }

    /*
     * ACCESSOR METHODS
     */
    
    public List<Stock> getAlbumsInStock() {
        return albumsInStock;
    }

    public Album getSelected() {
        return selected;
    }

    public void setSelected(Album selected) {
        this.selected = selected;
    }

}
