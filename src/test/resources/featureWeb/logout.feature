@logout
Feature: Logout

  Background:
    Given user already login with username "moblaze11" and password "@Testing123"
    Then user will be redirect to home page

  @logout-fromHomePage
  Scenario: user logout from home page
    When user click logout menu
    Then user is on login page