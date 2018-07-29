package vs.hardcoredistro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int stock;

	@OneToOne
	private Album album;

	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(int stock, Album album) {
		super();
		this.stock = stock;
		this.album = album;
	}

	public Long getId() {
		return id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", stock=" + stock + ", album=" + album + "]";
	}

}
