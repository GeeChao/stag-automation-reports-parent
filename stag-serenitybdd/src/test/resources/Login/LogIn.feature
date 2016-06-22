Feature: Log in
  In order to manage my travel plans,
  As a customer,
  I should be able to login using my credentials

  Scenario: Login with valid credentials
    Given I am on the login page
    When I log in with valid user credentials
    Then I should be logged in successfully

  Scenario: Login with invalid credentials
    Given I am on the login page
    When I log in with invalid user credentials
    Then I receive an invalid login error message
    And I am still on the login page

  Scenario: Login with valid credentials
    Given I am on the login page
    When I log in with invalid user credentials
    Then I should be logged in successfully