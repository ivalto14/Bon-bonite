package tasks;

import interactions.ClickSafe;
import userinterfaces.ProductPurchase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class EnterAccount implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductPurchase.ACCOUNT_MENU)
        );

        try { Thread.sleep(1500); } catch (InterruptedException ignored) {}
        boolean popupVisible = ProductPurchase.POPUP_CLOSE_BUTTON
                .resolveFor(actor)
                .isVisible();

        if (popupVisible) {
            actor.attemptsTo(
                    ClickSafe.on(ProductPurchase.POPUP_CLOSE_BUTTON)
            );
        }
    }

    public static EnterAccount go() {
        return Tasks.instrumented(EnterAccount.class);
    }
}