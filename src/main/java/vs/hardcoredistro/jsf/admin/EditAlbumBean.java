package vs.hardcoredistro.jsf.admin;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import vs.hardcoredistro.entities.Album;

@Named
@RequestScoped
public class EditAlbumBean {

	private Album selectedToEdit;
	
	/**
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

}
