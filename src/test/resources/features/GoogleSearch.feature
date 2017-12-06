@GoogleSearch
Feature: Google Search

  @Smoke
  Scenario: Simple search
    Given I am on Google
    When I search for gobshites
    Then results for scouse scum will be displayed
    And the database will contain a user id