package vs.hardcoredistro.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author vasou
 */
@Stateless
public class PaymentService {

    @Inject
    @ConfigProperty(name = "privKey")
    private String privateKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = privateKey;
    }

    public Charge charge(String token, BigDecimal chargeAmount, String currency) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeAmount);
        chargeParams.put("currency", currency);
        chargeParams.put("source", token);
        return Charge.create(chargeParams);
    }

}
