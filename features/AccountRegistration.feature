Feature: Account Registration
  @regression
  Scenario: Successful Account Registration with valid user details
    Given User Launch browser
    And opens URL "https://demo.opencart.com/"
    When User navigate to MyAccount menu
    And Click on Register
    When User provides Valid user details
    And Click on Continue
    Then user should see "Your Account Has Been Created!" message

