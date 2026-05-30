package question;

import userinterfaces.ProductPurchase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UserIsAuthenticated implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            String url = driver.getCurrentUrl();

            boolean onCheckout = url.contains("checkouts") || url.contains("checkout");
            if (!onCheckout) return false;

            // Valida que el email autenticado sea visible en la pantalla
            actor.attemptsTo(
                    WaitUntil.the(ProductPurchase.CHECKOUT_AUTHENTICATED_USER, isVisible())
                            .forNoMoreThan(10).seconds()
            );

            String emailText = ProductPurchase.CHECKOUT_AUTHENTICATED_USER
                    .resolveFor(actor)
                    .getText()
                    .trim();

            return emailText.contains("@");

        } catch (Exception e) {
            return false;
        }
    }

    public static UserIsAuthenticated inCheckout() {
        return new UserIsAuthenticated();
    }
}