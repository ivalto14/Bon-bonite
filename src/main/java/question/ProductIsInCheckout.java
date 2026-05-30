package question;

import userinterfaces.ProductPurchase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductIsInCheckout implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        return !ProductPurchase.ORDER_SUMMARY_PRODUCT
                .resolveAllFor(actor)
                .isEmpty();
    }

    public static ProductIsInCheckout valid() {
        return new ProductIsInCheckout();

    }
}