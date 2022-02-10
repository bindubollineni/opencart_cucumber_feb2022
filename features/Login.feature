Feature: Login
  @sanity
  Scenario: Successful Login with valid credentials
    Given User Launch browser
    And opens URL "https://demo.opencart.com/"
    When User navigate to MyAccount menu
    And Click on Login
    And User enters Email as "bankbank@gmail.com" and password as "bank"
    And Click Login button
    Then User navigates to MyAccount Page