package vs.hardcoredistro.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import vs.hardcoredistro.auth.LoggedInUser;
import vs.hardcoredistro.entities.Customer;
import vs.hardcoredistro.entities.Purchase;
import vs.hardcoredistro.services.CustomerService;
import vs.hardcoredistro.services.PurchaseService;

/**
 *
 * @author vasouv
 */
@Named
@RequestScoped
public class ProfileBean {

    @Inject
    private CustomerService customerService;

    @Inject
    private LoggedInUser loggedInUser;

    @Inject
    private PurchaseService purchaseService;

    private Customer currentCustomer;
    private List<Purchase> userPurchases;

    @PostConstruct
    public void init() {
        currentCustomer = customerService.findByName(loggedInUser.getLoggedInUser());
        userPurchases = new ArrayList<>(purchaseService.findByCustomerName(loggedInUser.getLoggedInUser()));
    }

    public String editInfo() {
        customerService.update(currentCustomer);
        return "profile.xhtml";
    }
    
    // ACCESSOR METHODS

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public List<Purchase> getUserPurchases() {
        return userPurchases;
    }

    public void setUserPurchases(List<Purchase> userPurchases) {
        this.userPurchases = userPurchases;
    }

}
