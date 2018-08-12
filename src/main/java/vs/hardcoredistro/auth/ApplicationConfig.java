package vs.hardcoredistro.auth;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

/**
 *
 * @author vasouv
 */
@FacesConfig
@ApplicationScoped
@CustomFormAuthenticationMechanismDefinition(
    loginToContinue = @LoginToContinue(
        loginPage = "/login.xhtml",
        useForwardToLogin = false,
        errorPage = ""
    )
)
@EmbeddedIdentityStoreDefinition({
    @Credentials(
        callerName = "admin@example.com",
        password = "secret1",
        groups = {"VIEW_USER_PAGES", "VIEW_ADMIN_PAGES"}
    ),
    @Credentials(
        callerName = "user@example.com",
        password = "secret2",
        groups = {"VIEW_USER_PAGES"}
    )
})
public class ApplicationConfig {

}
