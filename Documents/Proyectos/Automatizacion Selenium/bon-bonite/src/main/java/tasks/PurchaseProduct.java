package tasks;

import interactions.ClickSafe;
import userinterfaces.ProductPurchase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.MoveMouse;

public class PurchaseProduct  implements Task {

    public static PurchaseProduct flow() {
        return Tasks.instrumented(PurchaseProduct.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                MoveMouse.to(ProductPurchase.MENU_SHOES),
                ClickSafe.on(ProductPurchase.MENU_SHOES),
                ClickSafe.on(ProductPurchase.SHOES_ONE),
                ClickSafe.on(ProductPurchase.COLOR_SWATCH_CAPPUCCINO),
                ClickSafe.on(ProductPurchase.SIZE_7),
                ClickSafe.on(ProductPurchase.INCREASE_QUANTITY),
                ClickSafe.on(ProductPurchase.ADD_TO_CART_BUTTON)

        );
    }
}
