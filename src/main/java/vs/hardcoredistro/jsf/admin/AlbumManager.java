package vs.hardcoredistro.jsf.admin;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import vs.hardcoredistro.entities.Album;
import vs.hardcoredistro.services.AlbumService;

@Named
@RequestScoped
public class AlbumManager {
	
	@Inject
	private AlbumService albumService;

	private Album selected;

	public void removeAlbum() {
		albumService.remove(selected);
	}

	public void disableAlbum() {
		albumService.disable(selected);
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

}
