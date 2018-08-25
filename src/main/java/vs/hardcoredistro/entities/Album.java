package vs.hardcoredistro.entities;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String band;

    private int yearOfRelease;

    private String details;

    private String label;

    private String photoUrl;

    private BigDecimal price;

    public Album() {

    }

    public Album(String title, String band, int year, String details,
        String label, String photoUrl, BigDecimal price) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Album [id=" + id + ", title=" + title + ", band=" + band + ", year=" + yearOfRelease + ", details=" + details
            + ", label=" + label + ", photoUrl=" + photoUrl + ", price=" + price + "]";
    }

}
