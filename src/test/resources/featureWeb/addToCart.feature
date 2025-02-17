@web
Feature: Add to cart

  Background:
    Given user already login with username "moblaze11" and password "@Testing123"
    Then user will be redirect to home page

  @addToCart-OneItem
  Scenario: add one item without scrolling page
    And user click an item
    Then user will be redirect to product page
    When user click add to cart button
    Then user able to see alert product added

  @addToCart-TwoItem
  Scenario: add two item with scrolling page
    And user click an item
    Then user will be redirect to product page
    When user click add to cart button
    Then user able to see alert product added
    When user click home menu
    Then user will be redirect to home page
    And user click laptops categories
    And user click another item
    Then user will be redirect to product page
    When user click add to cart button
    Then user able to see alert product added
