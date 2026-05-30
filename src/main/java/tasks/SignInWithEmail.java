package tasks;

import interactions.ClickSafe;
import userinterfaces.ProductPurchase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SignInWithEmail implements Task {

    private final String email;

    public SignInWithEmail(String email) {
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // 1. Clic en Sign in desde la pantalla de checkout
        actor.attemptsTo(
                WaitUntil.the(ProductPurchase.LINK_SIGN_IN, isVisible())
                        .forNoMoreThan(10).seconds(),
                ClickSafe.on(ProductPurchase.LINK_SIGN_IN)
        );

        // 2. Ingresar email y continuar
        actor.attemptsTo(
                WaitUntil.the(ProductPurchase.SIGNIN_EMAIL_FIELD, isVisible())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(ProductPurchase.SIGNIN_EMAIL_FIELD),
                ClickSafe.on(ProductPurchase.SIGNIN_CONTINUE_BUTTON)
        );

        // 3. Esperar a que aparezca el campo OTP
        actor.attemptsTo(
                WaitUntil.the(ProductPurchase.OTP_FIELD, isVisible())
                        .forNoMoreThan(15).seconds()
        );

        // 4. Esperar hasta 120 segundos a que el usuario ingrese el OTP manualmente
        // Una vez ingresado Shopify redirige al checkout y muestra el email autenticado
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        long deadline = System.currentTimeMillis() + 120_000;

        while (System.currentTimeMillis() < deadline) {
            try {
                String url = driver.getCurrentUrl();
                boolean backOnCheckout = url.contains("checkouts") || url.contains("checkout.shopify");
                boolean emailVisible = !driver.findElements(
                        org.openqa.selenium.By.xpath("//span[contains(@class,'rermvf1') and contains(text(),'@')]")
                ).isEmpty();

                if (backOnCheckout && emailVisible) break;

            } catch (Exception ignored) {}
            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        }
    }
    public static SignInWithEmail using(String email) {
        return Tasks.instrumented(SignInWithEmail.class, email);
    }
}