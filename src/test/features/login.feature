@regression
Feature: User login on Automation practice website
  As a user
  I want to see the login page
  So that I can login successfully

  @smoke @validLogin
  Scenario: User can able to login successfully with valid credentials
    Given User is on the home page
    When User selects SignIn link
    Then User should be on the login page
    When User enter email as "testaccount@mailinator.com" and password as "Password1"
    And User selects SignIn
    Then User should be login successfully
    And User should see his name as "john smith"

  @smoke @youtTagName
