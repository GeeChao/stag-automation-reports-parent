@Demo
Feature: Demo feature
  In order to demonstrate extent reports,
  I should be able to create a dummy feature that writes to the html file

  @Meetup
  Scenario: Test cucumber scenario 1
    Given I have created a scenario
    When I run this test
    Then it should write the results to the HTML file

  @Meetup
  Scenario: Test cucumber scenario 2
    Given I have created a scenario
    When I run this test
    Then it should write the results to the HTML file

  @WorkInProgress
  Scenario: Test cucumber scenario 3
    Given I have created a scenario
    When I run this test
    Then it should pass
