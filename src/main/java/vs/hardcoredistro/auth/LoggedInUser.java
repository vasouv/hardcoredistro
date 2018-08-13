package vs.hardcoredistro.auth;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author vasouv
 */
@Named
@SessionScoped
public class LoggedInUser implements Serializable {

    public String getLoggedInUser() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getUserPrincipal().getName();
    }

}
