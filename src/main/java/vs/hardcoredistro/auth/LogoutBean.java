package vs.hardcoredistro.auth;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author vasouv
 */
@Named
@RequestScoped
public class LogoutBean {

    public String logout() {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();

        try {
            request.logout();
            request.getSession().invalidate();
        } catch (ServletException e) {
            facesContext.addMessage(null, new FacesMessage("Logout failed"));
        }
        return "/index.xhtml";

    }

}
