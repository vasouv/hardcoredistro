package vs.hardcoredistro.jsf.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Faces;

import vs.hardcoredistro.entities.Purchase;
import vs.hardcoredistro.services.PurchaseService;

@Named
@RequestScoped
public class PurchasesManager {

    @Inject
    private PurchaseService purchaseService;

    private List<Purchase> purchases;

    private Purchase selected;

    @PostConstruct
    public void init() {
        purchases = new ArrayList<>(purchaseService.findAll());
    }

    public void shipPurchase(Long purchaseID) {
        purchaseService.ship(purchaseID);
        Faces.redirect("admin/purchases.xhtml");
    }

    public void cancelPurchase() {
        purchaseService.cancel(selected.getId());
        Faces.redirect("admin/purchases.xhtml");
    }

    // ACCESSOR METHODS
    
    public List<Purchase> getPurchases() {
        return purchaseService.findAll();
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Purchase getSelected() {
        return selected;
    }

    public void setSelected(Purchase selected) {
        this.selected = selected;
    }

}
