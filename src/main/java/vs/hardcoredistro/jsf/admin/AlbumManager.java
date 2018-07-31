package vs.hardcoredistro.jsf.admin;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	private String nTitle;
	private String nBand;
	private String nDesc;
	private String nLabel;
	private int nYearOfRelease;
	private double nPrice;
	private int nQuantity;
	private String nPhotoURL;

	public void removeAlbum() {
		albumService.remove(selected);
	}

	public void disableAlbum() {
		albumService.disable(selected);
	}

	public String createAlbum() {
		Album newAlbum = new Album(nTitle, nBand, nYearOfRelease, nDesc, nLabel, nPhotoURL, nPrice);
		albumService.create(newAlbum);
		stockService.create(newAlbum.getTitle(), nQuantity);
		return "albums.xhtml";
	}

	/**
	 * ACCESSOR METHODS
	 */

	public Album getSelected() {
		return selected;
	}

	public void setSelected(Album selected) {
		this.selected = selected;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnDesc() {
		return nDesc;
	}

	public void setnDesc(String nDesc) {
		this.nDesc = nDesc;
	}

	public String getnLabel() {
		return nLabel;
	}

	public void setnLabel(String nLabel) {
		this.nLabel = nLabel;
	}

	public double getnPrice() {
		return nPrice;
	}

	public void setnPrice(double nPrice) {
		this.nPrice = nPrice;
	}

	public int getnQuantity() {
		return nQuantity;
	}

	public void setnQuantity(int nQuantity) {
		this.nQuantity = nQuantity;
	}

	public String getnPhotoURL() {
		return nPhotoURL;
	}

	public void setnPhotoURL(String nPhotoURL) {
		this.nPhotoURL = nPhotoURL;
	}

	public String getnBand() {
		return nBand;
	}

	public void setnBand(String nBand) {
		this.nBand = nBand;
	}

	public int getnYearOfRelease() {
		return nYearOfRelease;
	}

	public void setnYearOfRelease(int yearOfRelease) {
		this.nYearOfRelease = yearOfRelease;
	}

}
