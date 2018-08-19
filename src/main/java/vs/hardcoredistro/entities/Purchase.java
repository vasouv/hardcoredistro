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
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate datePlaced;

    private double totalAmount;

    @Enumerated(EnumType.STRING)
    private PurchaseStatus purchaseStatus;

    private LocalDate dateShipped;

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase", fetch = FetchType.EAGER)
    private List<OrderedAlbum> orderedAlbums;

    public Purchase() {
        // TODO Auto-generated constructor stub
    }

    public Purchase(LocalDate datePlaced, Customer customer, List<OrderedAlbum> albums, PurchaseStatus purchaseStatus) {
        super();
        this.datePlaced = datePlaced;
        this.customer = customer;
        this.orderedAlbums = albums;
        this.purchaseStatus = purchaseStatus;
    }

    public Long getId() {
        return id;
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

    public void setTotalAmount() {
        if (orderedAlbums.isEmpty()) {
            setTotalAmount(0);
        } else {
            totalAmount = 0.0;
            for (OrderedAlbum orderedAlbum : orderedAlbums) {
                totalAmount += orderedAlbum.getAlbum().getPrice() * orderedAlbum.getQuantity();
            }
            setTotalAmount(totalAmount);
        }
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

    public List<OrderedAlbum> getOrderedAlbums() {
        return orderedAlbums;
    }

    public void setOrderedAlbums(List<OrderedAlbum> albums) {
        this.orderedAlbums = albums;
    }

    @Override
    public String toString() {
        return "Purchase{" + "id=" + id + ", datePlaced=" + datePlaced + ", totalAmount=" + totalAmount + ", purchaseStatus=" + purchaseStatus + ", dateShipped=" + dateShipped + ", customer=" + customer + ", orderedAlbums=" + orderedAlbums + '}';
    }

}
