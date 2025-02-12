@checkout
Feature: Checkout

  Background:
    Given user already login with username "moblaze11" and password "@Testing123"
    Then user will be redirect to home page

  @checkout-ItemExist
  Scenario: checkout the added items
    When user click cart menu
    Then user will be redirect to cart page
    And user will see item to buy
    And user will see total price equals to sum of each item price
    When user click place order button
    Then user fill the required data
    And user click purchase button
    Then user will see success purchase pop up
    And user click ok button


  @checkout-ItemNotExist
  Scenario: checkout the not added items
    When user click cart menu
    Then user will be redirect to cart page
    And user will see item to buy

  @checkout-ItemExistButNotFillRequiredData
  Scenario: checkout the added items and not fill the required data
    When user click cart menu
    Then user will be redirect to cart page
    And user will see item to buy
    And user will see total price equals to sum of each item price
    When  user click place order button
    And user click purchase button
    And user will see alert to fill out the data