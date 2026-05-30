package tasks;

import interactions.ClickSafe;
import interactions.SwitchToDefaultContent;
import interactions.SwitchToIframe;
import userinterfaces.ProductPurchase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.TestData;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillPaymentForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        // 1. Esperar y llenar datos de entrega (en el DOM principal)
        actor.attemptsTo(
                WaitUntil.the(ProductPurchase.CHECKOUT_FIRST_NAME, isVisible())
                        .forNoMoreThan(15).seconds(),
                Enter.theValue(TestData.FIRST_NAME).into(ProductPurchase.CHECKOUT_FIRST_NAME),
                Enter.theValue(TestData.LAST_NAME).into(ProductPurchase.CHECKOUT_LAST_NAME),
                Enter.theValue(TestData.ADDRESS).into(ProductPurchase.CHECKOUT_ADDRESS),
                Enter.theValue(TestData.CITY).into(ProductPurchase.CHECKOUT_CITY),
                Enter.theValue(TestData.ZIP_CODE).into(ProductPurchase.CHECKOUT_ZIP)
        );

        // 2. Marcar checkbox billing = shipping
        actor.attemptsTo(
                WaitUntil.the(ProductPurchase.CHECKBOX_USE_SHIPPING_AS_BILLING, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(ProductPurchase.CHECKBOX_USE_SHIPPING_AS_BILLING)
        );

        // 3. Cambiar al iframe de tarjeta — Shopify Payments usa un iframe de seguridad
        actor.attemptsTo(
                SwitchToIframe.locatedBy("iframe[name*='card-fields-number'], iframe[id*='card-fields-number'], iframe[title*='Field container for: Card number']")
        );
        actor.attemptsTo(
                Enter.theValue(TestData.CARD_NUMBER).into(ProductPurchase.CHECKOUT_CARD_NUMBER)
        );

        // 4. Iframe de expiry
        actor.attemptsTo(SwitchToDefaultContent.now());
        actor.attemptsTo(
                SwitchToIframe.locatedBy("iframe[name*='card-fields-expiry'], iframe[id*='card-fields-expiry'], iframe[title*='Field container for: Expiration date']")
        );
        actor.attemptsTo(
                Enter.theValue(TestData.CARD_EXPIRY).into(ProductPurchase.CHECKOUT_CARD_EXPIRY)
        );

        // 5. Iframe de CVV
        actor.attemptsTo(SwitchToDefaultContent.now());
        actor.attemptsTo(
                SwitchToIframe.locatedBy("iframe[name*='card-fields-verification'], iframe[id*='card-fields-verification'], iframe[title*='Field container for: Security code']")
        );
        actor.attemptsTo(
                Enter.theValue(TestData.CARD_CVV).into(ProductPurchase.CHECKOUT_CARD_CVV)
        );

        // 6. Iframe de nombre
        actor.attemptsTo(SwitchToDefaultContent.now());
        actor.attemptsTo(
                SwitchToIframe.locatedBy("iframe[name*='card-fields-name'], iframe[id*='card-fields-name'], iframe[title*='Field container for: Name on card']")
        );
        actor.attemptsTo(
                Enter.theValue(TestData.CARD_NAME).into(ProductPurchase.CHECKOUT_CARD_NAME)
        );

        // 7. Volver al DOM principal y hacer clic en Pay Now
        actor.attemptsTo(SwitchToDefaultContent.now());
        actor.attemptsTo(
                ClickSafe.on(ProductPurchase.PAY_NOW_BUTTON)
        );
    }

    public static FillPaymentForm andSubmit() {
        return Tasks.instrumented(FillPaymentForm.class);
    }
}