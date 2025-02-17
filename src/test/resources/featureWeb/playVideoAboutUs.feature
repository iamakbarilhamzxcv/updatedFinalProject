@web
Feature: Play Video
  Background:
    Given user already login with username "moblaze11" and password "@Testing123"
    Then user will be redirect to home page

  @playVideo-AboutUs
  Scenario: user can play video about us
    When user click about us menu
    Then user click video play button
    And user click close video button