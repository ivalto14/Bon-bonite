package question;

import userinterfaces.ProductPurchase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProductIsInCart implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        try {

            actor.attemptsTo(
                    WaitUntil.the(ProductPurchase.CART_ITEM_COUNT, isVisible())
                            .forNoMoreThan(15).seconds()
            );

            String text = ProductPurchase.CART_ITEM_COUNT
                    .resolveFor(actor)
                    .getText();

            int quantity = Integer.parseInt(
                    text.replaceAll("[^0-9]", "")
            );

            return quantity > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public static ProductIsInCart valid() {
        return new ProductIsInCart();
    }
}
