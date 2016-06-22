Feature: Search hotels
  In order to book hotels,
  As a customer,
  I should be able to search for hotels

  @pending
  Scenario: Search hotels in Singapore
    Given I browse the site as a guest
    When I navigate to search for hotels
    And I select Singapore as my location
    And I check in from today until 30/07/2016
    And I submit my search
    Then I should see a list of hotel results

  @ignore
  Scenario: Search hotels in Dubai
    Given I browse the site as a guest
    When I navigate to search for hotels
    And I select Australia as my location
    And I check in from today until 30/07/2016
    And I submit my search
    Then I should see a list of hotel results