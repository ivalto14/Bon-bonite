Feature: Purchase product

  @green @cart
  Scenario: Purchase product successfully
    Given that the user enters the application
    When the user enters the account section
    And the user completes the purchase process
    Then the products should be added to the cart

  @green @checkout
  Scenario: Validate checkout page is reached
    Given that the user enters the application
    When the user enters the account section
    And the user completes the purchase process
    And the user proceeds to checkout
    Then the user should be on the checkout page

  @green @summary
  Scenario: Validate products are shown in checkout summary
    Given that the user enters the application
    When the user enters the account section
    And the user completes the purchase process
    And the user proceeds to checkout
    Then the order summary should contain the purchased products

  @green @payment
  Scenario: Complete payment form with card data
    Given that the user enters the application
    When the user enters the account section
    And the user completes the purchase process
    And the user proceeds to checkout
    And the user fills in the payment form
    Then the payment form validation should be triggered

  @green @signin
  Scenario: Sign in with email and OTP validation
    Given that the user enters the application
    When the user enters the account section
    And the user completes the purchase process
    And the user proceeds to checkout
    And the user initiates sign in with email "email"
    Then the user should return to checkout as authenticated