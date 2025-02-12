@message
Feature: Send Message

  Background:
    Given user already login with username "moblaze11" and password "@Testing123"
    Then user will be redirect to home page

  @send-message
  Scenario: user can send message
    When user click contact menu
    Then user fill contact email and message
    And user click send message button
    And user will see thanks pop up