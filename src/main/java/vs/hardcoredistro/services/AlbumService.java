package vs.hardcoredistro.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import vs.hardcoredistro.entities.Album;

@Stateless
public class AlbumService {

	@PersistenceContext
	private EntityManager em;

	public List<Album> findAll() {
		TypedQuery<Album> query = em.createQuery("select a from Album a", Album.class);
		List<Album> all = query.getResultList();
		return all;
	}

	public void remove(Album selected) {
		Album toRemove = em.find(Album.class, selected.getId());
		em.remove(toRemove);

	}

	public void disable(Album selected) {
		Album toDisable = em.find(Album.class, selected.getId());
		toDisable.setQuantity(1);
		em.merge(toDisable);
	}

}
