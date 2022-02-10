Feature: Login

  Background: Common steps for Login
    Given User Launch browser
    And opens URL "https://demo.opencart.com/"
    When User navigate to MyAccount menu
    And Click on Login

  Scenario Outline: Login Data Driven
#    Given User Launch browser
#    And opens URL "https://demo.opencart.com/"
#    When User navigate to MyAccount menu
#    And Click on Login
    And User enters Email as "<email>" and password as "<password>"
    And Click Login button
    Then User navigates to MyAccount Page

    Examples:
      | email              | password |
      | bankbank@gmail.com | bank     |
      | bankbank@gmail.com | bank123  |
@sanity @regression
    Scenario Outline: Login Data Driven2
#      Given User Launch browser
#      And opens URL "https://demo.opencart.com/"
#      When User navigate to MyAccount menu
#      And Click on Login
      Then Check User navigates to MyAccount Page by passing email and password with excel row "<row_index>"

      Examples:
      |row_index|
      |1        |
      |2        |
      |3        |
