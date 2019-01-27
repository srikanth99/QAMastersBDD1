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

  #  @smoke @loginValidations
  #Scenario: User can see valiation message for invalid credentials
  #    Given User is on the home page
  #    When User selects SignIn link
  #    Then User should be on the login page
  #    When User enter email as " " and password as " "
  #    And User selects SignIn
  #    Then User should see error message as "An email address required."
  #
  #
  #     @smoke @loginValidations
  #    Scenario: User can see valiation message for invalid credentials
  #        Given User is on the home page
  #        When User selects SignIn link
  #        Then User should be on the login page
  #        When User enter email as "DFDSFDS" and password as " "
  #        And User selects SignIn
  #        Then User should see error message as "Invalid email address."

  @smoke @loginValidations
  Scenario Outline: User can see valiation message for invalid credentials
    Given User is on the home page
     When User selects SignIn link
     Then User should be on the login page
     When User enter email as "<username>" and password as "<password>"
     And User selects SignIn
     Then User should see error message as "<error_message>"
    Examples:
      | username                   | password      | error_message              |
      |                            |               | An email address required. |
      | fgdfgds                    |               | Invalid email address.     |
      | testaccount@mailinator.com | wrongpassword | Authentication Failes.     |


