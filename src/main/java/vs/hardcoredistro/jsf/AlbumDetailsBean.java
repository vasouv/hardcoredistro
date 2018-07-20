package vs.hardcoredistro.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import vs.hardcoredistro.entities.Album;

@Named
@RequestScoped
public class AlbumDetailsBean {

	private Album albumDetails;

	public Album getAlbumDetails() {
		return albumDetails;
	}

	public void setAlbumDetails(Album albumDetails) {
		this.albumDetails = albumDetails;
	}

}
