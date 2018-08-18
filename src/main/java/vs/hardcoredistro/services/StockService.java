package vs.hardcoredistro.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import vs.hardcoredistro.entities.Album;
import vs.hardcoredistro.entities.OrderedAlbum;
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

    public Stock findByID(Long albumID) {
        return (Stock) em.createQuery("select s from Stock s where s.album.id=:aid").setParameter("aid", albumID).getSingleResult();
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

    public void disableAlbum(Long albumId) {
        Stock forFound = findByID(albumId);
        forFound.setStock(0);
        em.merge(forFound);
    }

    public void updateByID(Long albumId, int quantity) {
        Stock forAlbum = findByID(albumId);
        forAlbum.setStock(quantity);
        em.merge(forAlbum);
    }
    
    public void removeByID(Long albumID) {
        Stock forAlbum = findByID(albumID);
        em.remove(forAlbum);
    }
    

    public boolean albumHasWantedQuantity(Long albumId, int wantedQuantity) {
        Stock forAlbum = findByID(albumId);
        return wantedQuantity <= forAlbum.getStock();
    }

    public boolean albumListHasWantedQuantity(List<OrderedAlbum> orderedAlbums) {
        boolean allAlbumsHaveQuantity = true;
        for (OrderedAlbum orderedAlbum : orderedAlbums) {
            Stock forAlbum = findByID(orderedAlbum.getAlbum().getId());
            if (orderedAlbum.getQuantity() > forAlbum.getStock()) {
                allAlbumsHaveQuantity = false;
                break;
            }
        }
        return allAlbumsHaveQuantity;
    }

    public void decreaseStockForAlbums(List<OrderedAlbum> albumsToOrder) {
        for (OrderedAlbum orderedAlbum : albumsToOrder) {
            Stock forAlbum = findByID(orderedAlbum.getAlbum().getId());
            forAlbum.setStock(forAlbum.getStock() - orderedAlbum.getQuantity());
            em.merge(forAlbum);
        }
    }

    public void increaseStockForAlbums(List<OrderedAlbum> albumsToOrder) {
        for (OrderedAlbum orderedAlbum : albumsToOrder) {
            Stock forAlbum = findByID(orderedAlbum.getAlbum().getId());
            forAlbum.setStock(forAlbum.getStock() + orderedAlbum.getQuantity());
            em.merge(forAlbum);
        }
    }

}
