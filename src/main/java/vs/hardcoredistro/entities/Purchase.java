package vs.hardcoredistro.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PURCHASE")
public class Purchase {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "date_placed")
	private LocalDate datePlaced;

	@NotNull
	@Column(name = "total_amount")
	private double totalAmount;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "purchase_status")
	private PurchaseStatus purchaseStatus;

	@Column(name = "date_shipped")
	private LocalDate dateShipped;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany
	@JoinTable(name = "PURCHASE_ALBUM", joinColumns = {
			@JoinColumn(name = "purchase_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "album_id", referencedColumnName = "id") })
	private List<Album> albums;

	public Purchase() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(LocalDate datePlaced) {
		this.datePlaced = datePlaced;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public PurchaseStatus getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public LocalDate getDateShipped() {
		return dateShipped;
	}

	public void setDateShipped(LocalDate dateShipped) {
		this.dateShipped = dateShipped;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

}
