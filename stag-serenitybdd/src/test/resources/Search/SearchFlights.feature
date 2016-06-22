Feature: Search flights
  In order to book flights,
  As a customer,
  I should be able to search for flights

  Scenario: Search one-way flight from Melbourne to Perth
    Given I browse the site as a guest
    When I navigate to search for flights
    And I want a one way flight
    And I want to fly from Melbourne to Perth
    And I submit my search
    Then I should see a list of search results

