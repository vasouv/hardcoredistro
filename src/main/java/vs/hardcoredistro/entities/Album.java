package vs.hardcoredistro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "ALBUM")
public class Album {

	@Id
//	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
//	@Column(name = "title")
	private String title;

	@NotNull
//	@Column(name = "band")
	private String band;

	@NotNull
//	@Column(name = "release")
	private int yearOfRelease;

	@NotNull
//	@Column(name = "details")
	private String details;

	@NotNull
//	@Column(name = "label")
	private String label;

	@NotNull
//	@Column(name = "photo_url")
	private String photoUrl;

	@NotNull
//	@Column(name = "price")
	private double price;

	public Album() {

	}

	public Album(@NotNull String title, @NotNull String band, @NotNull int year, @NotNull String details,
			@NotNull String label, @NotNull String photoUrl, @NotNull double price) {
		super();
		this.title = title;
		this.band = band;
		this.yearOfRelease = year;
		this.details = details;
		this.label = label;
		this.photoUrl = photoUrl;
		this.price = price;
	}

	public Long getId() {
		return id;
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

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", band=" + band + ", year=" + yearOfRelease + ", details=" + details
				+ ", label=" + label + ", photoUrl=" + photoUrl + ", price=" + price + "]";
	}

}
