package vs.hardcoredistro.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import vs.hardcoredistro.entities.Purchase;

/**
 *
 * @author vasouv
 */
@Named
@RequestScoped
public class UserPurchaseDetails {

    private Purchase selected;

    public Purchase getSelected() {
        return selected;
    }

    public void setSelected(Purchase selected) {
        this.selected = selected;
    }

}
