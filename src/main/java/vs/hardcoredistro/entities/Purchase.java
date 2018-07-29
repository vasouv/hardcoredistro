package vs.hardcoredistro.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "PURCHASE")
public class Purchase {

	@Id
//	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
//	@Column(name = "date_placed")
	private LocalDate datePlaced;

	@NotNull
//	@Column(name = "total_amount")
	private double totalAmount;

	@NotNull
	@Enumerated(EnumType.STRING)
//	@Column(name = "purchase_status")
	private PurchaseStatus purchaseStatus;

//	@Column(name = "date_shipped")
	private LocalDate dateShipped;

	@ManyToOne
//	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase", fetch = FetchType.EAGER)
//	@JoinTable(name = "PURCHASE_ALBUM", joinColumns = {
//			@JoinColumn(name = "purchase_id", referencedColumnName = "id") }, inverseJoinColumns = {
//					@JoinColumn(name = "album_id", referencedColumnName = "id") })
	private List<OrderedAlbum> albums;

	public Purchase() {
		// TODO Auto-generated constructor stub
	}

	public Purchase(@NotNull LocalDate datePlaced, Customer customer, List<OrderedAlbum> albums) {
		super();
		this.datePlaced = datePlaced;
		this.customer = customer;
		this.albums = albums;
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

	public List<OrderedAlbum> getAlbums() {
		return albums;
	}

	public void setAlbums(List<OrderedAlbum> albums) {
		this.albums = albums;
	}

}
