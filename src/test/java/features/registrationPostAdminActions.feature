Feature: Admin Panel User Management
  Background:
    Given the User is logged into admin Panel
    And the User is on admin user Panel

    Scenario Outline: Remove user with given username
      Given user with <username> exists
      When removing user with <username>
      Then the user removed successfully message is displayed

      Examples:
      |username|
      |test    |