Feature: Update details
  In order to manage my account,
  As a customer,
  I should be able to update my personal details

  Scenario: Update address
    Given I am on the login page
    When I log in with valid user credentials
    And I should be logged in successfully
    And I navigate to my profile page
    And I update my address to 385 Bourke Street
    Then I should receive a message saying I updated my details correctly