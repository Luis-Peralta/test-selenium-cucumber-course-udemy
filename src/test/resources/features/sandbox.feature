
Feature: Test different actions in a sandbox page

  Scenario: I will try different actions in this webpage
    Given Navigate Sandbox Page
    And Select dropdown

  @TestThree
  Scenario Outline: I want to validate that the text is inside the list
    Given I navigate to the list page
    When I search <state> in the list
    Then I can find the <city> in the list
    Examples:
      | state    | city             |
      | New York | Troy, New York   |
      | Las vegas| Las Vegas, Nevada|
