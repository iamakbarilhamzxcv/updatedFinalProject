@web
Feature: Delete Item

  Background:
    Given user already login with username "moblaze11" and password "@Testing123"
    Then user will be redirect to home page

  @delete-OneItem
  Scenario: delete one item
    And user click an item
    Then user will be redirect to product page
    When user click add to cart button
    Then user able to see alert product added
    When user click home menu
    Then user will be redirect to home page

    When user click cart menu
    Then user will be redirect to cart page
    And user will see item to buy
    Then user click delete item
    And user will see item to buy