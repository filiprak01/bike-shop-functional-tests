Feature: Login scenarios

  Background:
    Given the User is on login page

    Scenario Outline: Login with correct username and password
      Given the User entered <username> and <password>
      When the User is trying to login
      Then the User can see homepage with correct login message

      Examples:
        | username | password |
        | user2    | TestPassword|


    Scenario Outline: Login with incorrect username and password
      Given the User entered <username> and <password>
      When the User is trying to login
      Then the User can see login page with incorrect login message

      Examples:
        |username|password|
        |wrong_username|TestPassword|
        |user2          | wrong_password|
