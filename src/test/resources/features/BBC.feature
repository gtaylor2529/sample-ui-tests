@BBC
Feature: BBC

  Scenario: Navigate to News
    Given I am on BBC
    When I navigate to the BBC News page
    Then the BBC News page will be displayed
    And the database will contain a user id