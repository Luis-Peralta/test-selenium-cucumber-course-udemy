Feature: Test search google functionality

    @TestGoogle
Scenario: Search thing in google
    Given I'm in google
    When Search thing
    And Click on the search button
    Then The result match with search
