Feature: registration scenario
  Background:
    Given the User is on registration page


    Scenario Outline:
      Given the User enters <username>, <email>, <phone_number>, <password>, <password_confirmation>
      When the User is trying to register
      Then the <warning> message should be displayed


      Examples:
        |username|email|phone_number|password|password_confirmation|warning|
        |user2    |test2@test.pl|123456789|NewPassword|NewPassword   |Username already exist! Please try some other username.|
        |test2    |test2@test.pl|123456789|NewPassword|Password   |Passwords didn't match!!                                   |
        |test2    |filip.rak.20001@gmail.com|123456789|NewPassword|NewPassword   |Email Already Registered!!                 |

    Scenario Outline:
      Given the User enters <username>, <email>, <phone_number>, <password>, <password_confirmation>
      When the User is trying to register
      Then the account creation message is displayed

      Examples:
        |username|email|phone_number|password|password_confirmation|
        |test    |test@test.pl|123456789|NewPassword|NewPassword   |