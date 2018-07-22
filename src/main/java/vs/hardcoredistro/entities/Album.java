package vs.hardcoredistro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ALBUM")
public class Album {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "title")
	private String title;

	@NotNull
	@Column(name = "band")
	private String band;

	@NotNull
	@Column(name = "release")
	private int year;

	@NotNull
	@Column(name = "details")
	private String details;

	@NotNull
	@Column(name = "label")
	private String label;

	@NotNull
	@Column(name = "photo_url")
	private String photoUrl;

	@NotNull
	@Column(name = "quantity")
	private int quantity;

	@NotNull
	@Column(name = "price")
	private double price;

	public Album() {

	}

	public Album(@NotNull String title, @NotNull String band, @NotNull String label, @NotNull int year,
			@NotNull String details, @NotNull String photoUrl, @NotNull int quantity, @NotNull double price) {
		super();
		this.title = title;
		this.band = band;
		this.label = label;
		this.year = year;
		this.details = details;
		this.photoUrl = photoUrl;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
