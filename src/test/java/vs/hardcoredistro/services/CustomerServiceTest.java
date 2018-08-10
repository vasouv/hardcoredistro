package vs.hardcoredistro.services;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import vs.hardcoredistro.entities.Customer;

/**
 *
 * @author vasouv
 */
public class CustomerServiceTest {

    Customer vasouv = new Customer("vasouv", "1234567", "vasouv", "Themistokleous", "Xanthi", "67133", "Greece");

    @Mock
    CustomerService customerService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void customerIsFound() {

        when(customerService.findByName("vasouv")).thenReturn(vasouv);

        assertEquals(vasouv.getName(), customerService.findByName("vasouv").getName());
        assertEquals(vasouv.getId(), customerService.findByName("vasouv").getId());

    }

    @Test
    public void customerIsNotFound() {

        when(customerService.findByName("alex")).thenReturn(null);

        assertEquals(null, customerService.findByName("alex"));

    }

    @Test
    public void customerIsPersisted() {

        Customer john = new Customer("john", "12345", "John", "kallithea", "Xanthi", "67100", "Greece");

        doNothing().when(customerService).create(any());

        customerService.create(john);

        verify(customerService).create(john);

    }

}
