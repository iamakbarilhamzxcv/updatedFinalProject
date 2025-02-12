@login
Feature: Login

  @valid-Login
  Scenario: Login with valid username and password
    Given user go to the target web
    Then user is on login page
    And user click the log in menu
    And user input username on text box with "moblaze11"
    And user input password on the text box  with "@Testing123"
    When user click log in button
    Then user will be redirect to home page

  @invalid-Login
  Scenario: Login with invalid username and password
    Given user go to the target web
    Then user is on login page
    And user click the log in menu
    And user input username on text box with "falsemoblaze11"
    And user input password on the text box  with "@Testing321"
    When user click log in button
    Then user able to see alert error login