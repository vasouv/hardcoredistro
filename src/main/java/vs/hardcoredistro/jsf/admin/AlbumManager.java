package vs.hardcoredistro.jsf.admin;

import java.math.BigDecimal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Faces;

import vs.hardcoredistro.entities.Album;
import vs.hardcoredistro.services.AlbumService;
import vs.hardcoredistro.services.StockService;

@Named
@RequestScoped
public class AlbumManager {

    @Inject
    private AlbumService albumService;

    @Inject
    private StockService stockService;

    private Album selected;

    // properties for new album
    private String title;
    private String band;
    private String description;
    private String label;
    private int yearOfRelease;
    private BigDecimal price;
    private int quantity;
    private String photoUrl;

    public void removeAlbum() {
        stockService.removeByID(selected.getId());
        albumService.remove(selected);
        Faces.redirect("admin/albums.xhtml");
    }

    public void disableAlbum() {
        stockService.disableAlbum(selected.getId());
        Faces.redirect("admin/albums.xhtml");
    }

    public String createAlbum() {
        Album newAlbum = new Album(title, band, yearOfRelease, description, label, photoUrl, price);
        albumService.create(newAlbum);
        stockService.create(newAlbum.getTitle(), quantity);
        return "albums.xhtml";
    }

    /*
     * ACCESSOR METHODS
     */
    public Album getSelected() {
        return selected;
    }

    public void setSelected(Album selected) {
        this.selected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
