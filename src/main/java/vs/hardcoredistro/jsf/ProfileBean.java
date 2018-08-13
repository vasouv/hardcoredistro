package vs.hardcoredistro.jsf;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import vs.hardcoredistro.auth.LoggedInUser;
import vs.hardcoredistro.entities.Customer;
import vs.hardcoredistro.services.CustomerService;

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

    private Customer currentCustomer;

    @PostConstruct
    public void init() {
        currentCustomer = customerService.findByName(loggedInUser.getLoggedInUser());
    }
    
    public String editInfo() {
        customerService.update(currentCustomer);
        return "profile.xhtml";
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

}
