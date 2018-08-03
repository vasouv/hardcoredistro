package vs.hardcoredistro.jsf.admin;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import vs.hardcoredistro.entities.Album;
import vs.hardcoredistro.services.AlbumService;
import vs.hardcoredistro.services.StockService;

@Named
@SessionScoped
public class EditAlbumBean implements Serializable{

    @Inject
    private StockService stockService;

    @Inject
    private AlbumService albumService;

    private Album selectedToEdit;

    private int editQuantity;

    public String editAlbum() {
        albumService.update(selectedToEdit);
        stockService.updateByID(selectedToEdit.getId(), editQuantity);
        return "albums.xhtml";
    }

    /*
     *
     * ACCESSOR METHODS
     *
     */
    public Album getSelectedToEdit() {
        return selectedToEdit;
    }

    public void setSelectedToEdit(Album selectedToEdit) {
        this.selectedToEdit = selectedToEdit;
    }

    public void setQuantity(int quantity) {
        this.editQuantity = quantity;
    }

    public int getQuantity() {
        return stockService.findByID(selectedToEdit.getId()).getStock();
    }

}
