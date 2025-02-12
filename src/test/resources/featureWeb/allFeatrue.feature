@web
Feature: all feature

  Background:
    Given user already login with username "moblaze11" and password "@Testing123"
    Then user will be redirect to home page

  @web-allfeature
  Scenario: testing allfeature from login, add to cart, checkout, delete item, play video, send message, and logout
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

    When user click cart menu
    Then user will be redirect to cart page
    And user will see item to buy
    And user will see total price equals to sum of each item price
    When user click place order button
    Then user fill the required data
    And user click purchase button
    Then user will see success purchase pop up
    And user click ok button

    And user click an item
    Then user will be redirect to product page
    When user click add to cart button
    Then user able to see alert product added

    When user click cart menu
    Then user will be redirect to cart page
    And user will see item to buy
    Then user click delete item
    And user will see item to buy

    When user click about us menu
    Then user click video play button
    And user click close video button

    When user click contact menu
    Then user fill contact email and message
    And user click send message button
    And user will see thanks pop up

    When user click logout menu
    Then user is on login page

