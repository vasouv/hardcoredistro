package vs.hardcoredistro.jsf.admin;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import vs.hardcoredistro.entities.Customer;
import vs.hardcoredistro.services.CustomerService;

/**
 *
 * @author vasouv
 */
@Named
@RequestScoped
public class CustomerManager {

    @Inject
    private CustomerService customerService;

    private List<Customer> customers;

    @PostConstruct
    public void init() {
        customers = new ArrayList<>(customerService.findAll());
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
