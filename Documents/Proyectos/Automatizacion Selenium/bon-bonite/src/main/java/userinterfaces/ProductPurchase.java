package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPurchase {
    public static final Target ACCOUNT_MENU = Target.the("Account menu icon")
            .locatedBy("//a[@href='https://www.bon-bonite.com/mi-cuenta']");
    public static final Target POPUP_CLOSE_BUTTON = Target.the("Popup close button")
            .locatedBy("//button[@aria-label='Close' and @data-close-small-btn]");
    public static final Target MENU_SHOES = Target.the("Shoes menu")
            .locatedBy("//a[@data-float-element-trigger='HeaderDropdownMenu-shoes']");
    public static final Target MENU_HANDBAGS = Target.the("Handbags menu")
            .locatedBy("//a[@data-float-element-trigger='HeaderDropdownMenu-handbags']");
    public static final Target SHOES_ONE = Target.the("Platform tennis shoes in sand white leather")
            .locatedBy("//a[@aria-label='Platform tennis shoes in sand white leather']");
    public static final Target COLOR_SWATCH_CAPPUCCINO = Target.the("Color swatch Cappuccino")
            .locatedBy("//div[@data-value='Caramel']");
    public static final Target SIZE_7 = Target.the("Size 7")
            .locatedBy("//div[@class='swatch-button-title-text']//span[normalize-space()='7']");
    public static final Target INCREASE_QUANTITY = Target.the("Increase quantity button")
            .locatedBy("//button[contains(@class,'quantity__btn')]");
    public static final Target CART_ITEM_COUNT = Target.the("Cart product count")
            .locatedBy("//span[contains(@class,'cart-drawer__header-product-count')]");
    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart button")
            .locatedBy("//button[@aria-label='Add to cart']");
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button")
            .locatedBy("//button[@id='checkout' and @form='CartDrawerForm']");
    public static final Target CART_DRAWER_ICON = Target.the("Cart drawer icon")
            .locatedBy("//button[@data-sidebar-button and @aria-label='Cart']");
    public static final Target ORDER_SUMMARY_PRODUCT = Target.the("Order summary product name")
            .locatedBy("//*[contains(@class,'_1tx8jg7i') and contains(text(),'Platform tennis shoes')]");
    public static final Target CHECKOUT_EMAIL = Target.the("Checkout email field")
            .locatedBy("//input[@id='email' and @name='email']");
    public static final Target CHECKOUT_FIRST_NAME = Target.the("First name field")
            .locatedBy("//input[@name='firstName' and @autocomplete='shipping given-name']");
    public static final Target CHECKOUT_LAST_NAME = Target.the("Last name field")
            .locatedBy("//input[@name='lastName' and @autocomplete='shipping family-name']");
    public static final Target CHECKOUT_ADDRESS = Target.the("Address field")
            .locatedBy("//input[@id='shipping-address1' and @name='address1']");
    public static final Target CHECKOUT_CITY = Target.the("City field")
            .locatedBy("//input[@name='city' and @autocomplete='shipping address-level2']");
    public static final Target CHECKOUT_ZIP = Target.the("ZIP code field")
            .locatedBy("//input[@name='postalCode' and @autocomplete='shipping postal-code']");
    public static final Target CHECKOUT_CARD_NUMBER = Target.the("Card number field")
            .locatedBy("//input[@id='number' and @name='number' and @autocomplete='cc-number']");
    public static final Target CHECKOUT_CARD_EXPIRY = Target.the("Card expiry field")
            .locatedBy("//input[@id='expiry' and @name='expiry' and @autocomplete='cc-exp']");
    public static final Target CHECKOUT_CARD_CVV = Target.the("Card CVV field")
            .locatedBy("//input[@id='verification_value' and @autocomplete='cc-csc']");
    public static final Target CHECKOUT_CARD_NAME = Target.the("Card name field")
            .locatedBy("//input[@autocomplete='cc-name' or @placeholder='Name on card']");
    public static final Target CHECKBOX_USE_SHIPPING_AS_BILLING = Target.the("Use shipping address as billing")
            .locatedBy("//input[@id='billingAddressCheckbox' and @name='billingAddress']");
    public static final Target PAY_NOW_BUTTON = Target.the("Pay now button")
            .locatedBy("//button[@id='checkout-pay-button' and @aria-label='Pay now']");
    public static final Target PAY_NOW_ERROR = Target.the("Payment error banner")
            .locatedBy("//div[@id='PaymentErrorBanner' and @role='alert']");
    public static final Target LINK_SIGN_IN = Target.the("Sign in link")
            .locatedBy("//a[contains(@href,'authentication') or contains(@href,'login') or contains(normalize-space(.),'Sign in')]");
    public static final Target SIGNIN_EMAIL_FIELD = Target.the("Sign in email field")
            .locatedBy("//input[@id='customer-authentication-web-email']");
    public static final Target SIGNIN_CONTINUE_BUTTON = Target.the("Sign in continue button")
            .locatedBy("//button[@aria-label='Continue' and @type='submit']");
    public static final Target OTP_FIELD = Target.the("OTP input field")
            .locatedBy("//input[@autocomplete='one-time-code' and @inputmode='numeric' and @maxlength='6']");
    public static final Target CHECKOUT_AUTHENTICATED_USER = Target.the("Authenticated user email indicator")
            .locatedBy("//span[contains(@class,'rermvf1') and contains(text(),'@')]");
}
