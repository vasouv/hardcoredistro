package vs.hardcoredistro.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import vs.hardcoredistro.entities.Album;
import vs.hardcoredistro.entities.Stock;

@Stateless
public class StockService {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private AlbumService albumService;

	public List<Stock> findAll() {
		return em.createQuery("select s from Stock s").getResultList();
	}

	public void create(String albumTitle, int stock) {
		Album found = albumService.findByTitle(albumTitle);
		Stock forFound = new Stock(stock, found);
		em.persist(forFound);
	}

	public void create(Long albumID, int stock) {
		Album found = albumService.findByID(albumID);
		Stock forFound = new Stock(stock, found);
		em.persist(forFound);
	}

}
