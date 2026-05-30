package stepdefinitions;

import interactions.ClickSafe;
import question.CurrentPageUrl;
import question.PaymentFormValidated;
import question.ProductIsInCart;
import question.ProductIsInCheckout;
import question.UserIsAuthenticated;
import tasks.EnterAccount;
import tasks.FillPaymentForm;
import tasks.PurchaseProduct;
import tasks.SignInWithEmail;
import userinterfaces.ProductPurchase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import utils.TestData;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PurchaseStepDefinitions {

    Actor actor;

    @Given("that the user enters the application")
    public void thatTheUserEntersTheApplication() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("User");

        actor.wasAbleTo(
                Open.url(TestData.APP_URL)
        );
    }

    @When("the user enters the account section")
    public void theUserEntersTheAccountSection() {
        actor.attemptsTo(
                EnterAccount.go()
        );
    }

    @When("the user completes the purchase process")
    public void theUserCompletesThePurchaseProcess() {
        actor.attemptsTo(
                PurchaseProduct.flow()
        );
    }

    @Then("the products should be added to the cart")
    public void theProductsShouldBeAddedToTheCart() {
        actor.should(
                seeThat(ProductIsInCart.valid(), equalTo(true))
        );
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        actor.attemptsTo(
                ClickSafe.on(ProductPurchase.CHECKOUT_BUTTON)
        );
    }

    @Then("the user should be on the checkout page")
    public void theUserShouldBeOnTheCheckoutPage() {
        actor.should(seeThat(CurrentPageUrl.value(), containsString("checkouts")));
    }

    @Then("the order summary should contain the purchased products")
    public void theOrderSummaryShouldContainThePurchasedProducts() {
        actor.should(
                seeThat(ProductIsInCheckout.valid(), equalTo(true))
        );
    }
    @When("the user fills in the payment form")
    public void theUserFillsInThePaymentForm() {
        actor.attemptsTo(
                FillPaymentForm.andSubmit()
        );
    }

    @Then("the payment form validation should be triggered")
    public void thePaymentFormValidationShouldBeTriggered() {
        actor.should(
                seeThat(PaymentFormValidated.successfully(), equalTo(true))
        );
    }

    @When("the user initiates sign in with email {string}")
    public void theUserInitiatesSignInWithEmail(String email) {
        actor.attemptsTo(SignInWithEmail.using(TestData.USER_EMAIL));
    }

    @Then("the user should return to checkout as authenticated")
    public void theUserShouldReturnToCheckoutAsAuthenticated() {
        actor.should(
                seeThat(UserIsAuthenticated.inCheckout(), equalTo(true))
        );
    }
}