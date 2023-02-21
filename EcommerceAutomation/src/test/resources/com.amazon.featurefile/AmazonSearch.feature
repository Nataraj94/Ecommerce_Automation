Feature: To Validate the Amazon search functionality

  @Login
  Scenario: To validate the login page
    Given user navigate to url
    When User clicks the sign-in button
    And User enters the valid Login credential and click sign-in button
    And User clicks the sign-out button and navigate to homepage
    Then verify weather the user sign-out successfully

  @SearchBar
  Scenario: To validate the cart in amazon application
    Given user navigate to url
    When User enters value in search bar and click the item
    And user can select the product and add to cart
    Then User verify the selected product and remove product from cart