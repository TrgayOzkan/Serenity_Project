@ui
Feature: Fortna Search Data Driven

  As a user ,
  I should be able to search by keyword
  and get my result for multiple set of data


  Scenario Outline: User search by keyword "<keyword>"
    Given user is at home page
    When user search for keyword "<keyword>"
    Then the title should start with "<keyword>"
    Examples:
      | keyword                        |
      | serenity                       |
      | selenium                       |
      | steve jobs                     |
      | sdet jobs                      |



