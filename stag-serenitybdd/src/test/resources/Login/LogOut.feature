Feature: Log out
  In order to secure my account,
  As a customer,
  I should be able to log out of my session safely.

  Scenario: Log out securely
    Given I am on the login page
    When I log in with valid user credentials
    And I navigate to log out
    Then I should be logged out successfully
