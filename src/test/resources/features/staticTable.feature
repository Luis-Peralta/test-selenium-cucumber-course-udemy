@Grid
Feature: Test different actions in a static table

  Rule: The user can return values and validate them

  Background:
    Given Navigate to the grid page and then the static table

  @Smoke
  Scenario: I'm going to obtain a value of the static table
    Then I can obtain the value of table

  @Regression
  Scenario: As a engineer, I want to validate the static table is displayed
    Then I can validate if it's displayed