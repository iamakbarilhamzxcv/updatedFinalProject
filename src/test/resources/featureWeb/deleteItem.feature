@delete
Feature: Delete Item

  Background:
    Given user already login with username "moblaze11" and password "@Testing123"
    Then user will be redirect to home page

  @delete-OneItem
  Scenario: delete one item
    When user click cart menu
    Then user will be redirect to cart page
    And user will see item to buy
    Then user click delete item
    And user will see item to buy