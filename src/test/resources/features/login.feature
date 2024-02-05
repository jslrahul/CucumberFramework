Feature: cucumber login automation
  Decsription: This is the sample automation framework for the beginners

  Scenario: Login with valid credentials
    Given User is on the home page
    When User enters the username as "rahul"
    And User enters the password as "12345"
    Then Login should be successful

  Scenario: Login with invalid credentials
    Given User is on the home page
    When User enters the invalid username as "jsl.132tt@gmail.com"
    And User enters the password as "12345"
    Then Error message should be displayed

  Scenario: User logs out from the application
    When User click on log out button
    Then Logout should be successful
