package vs.hardcoredistro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderedAlbum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int quantity;

	@ManyToOne
	private Album album;

	@ManyToOne
	private Purchase purchase;

	public OrderedAlbum() {
		// TODO Auto-generated constructor stub
	}

	public OrderedAlbum(int quantity, Album album, Purchase purchase) {
		super();
		this.quantity = quantity;
		this.album = album;
		this.purchase = purchase;
	}

	public OrderedAlbum(int quantity, Album album) {
		super();
		this.quantity = quantity;
		this.album = album;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Long getId() {
		return id;
	}

}
