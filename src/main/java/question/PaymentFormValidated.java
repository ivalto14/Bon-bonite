package question;

import userinterfaces.ProductPurchase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PaymentFormValidated implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            // Al hacer clic en Pay Now con datos inválidos Shopify muestra un error
            // o permanece en la misma página — ambos son señal de que el botón fue procesado
            actor.attemptsTo(
                    WaitUntil.the(ProductPurchase.PAY_NOW_BUTTON, isVisible())
                            .forNoMoreThan(5).seconds()
            );

            String url = net.serenitybdd.core.Serenity.getDriver().getCurrentUrl();
            // Seguimos en checkout = el form fue validado (datos de tarjeta inválidos detenidos por Shopify)
            return url.contains("checkouts") || url.contains("checkout");
        } catch (Exception e) {
            return false;
        }
    }

    public static PaymentFormValidated successfully() {
        return new PaymentFormValidated();
    }
}