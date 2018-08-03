package vs.hardcoredistro.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
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

    public Album findByID(Long id) {
        return em.find(Album.class, id);
    }

    public Album findByTitle(String title) {
        return (Album) em.createQuery("select a from Album a where a.title=:title").setParameter("title", title).getSingleResult();
    }

    public void create(Album album) {
        em.persist(album);
    }

    public void remove(Album selected) {
        Album toRemove = em.find(Album.class, selected.getId());
        em.remove(toRemove);
    }

}
