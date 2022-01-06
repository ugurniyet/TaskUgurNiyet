
Feature: Arrange the demo call date and time


  Scenario Outline: user should be able to access getting started page after filling valid informatio
    Given the user is on qa-testing website
    When user enters the following "<firstName>","<lastName>","<workMail>","<company>","<phone>"
    When user clicks on get a demo button
    Then user should land on getting started page
    Then user should be able to select date and time
    Then user should go to schedule page
    Examples:
      | firstName | lastName  | workMail                    | company | phone      |
      | Brendan   | Schneider | b.scheneirder@toyota.com.tr | toyota  | 5074566787 |
      | Stephan   | Haley     | s.haley@honda.com.tr        | honda   | 5332355265 |

  @wip @functional
    Scenario Outline: the user cannot select non-available days
      Given the user is on qa-testing website
      When user enters the following "<firstName>","<lastName>","<workMail>","<company>","<phone>"
      When user clicks on get a demo button
      Then unavailable days should not be selectable
      Examples:
        | firstName | lastName  | workMail                    | company | phone      |
        | Brendan   | Schneider | b.scheneirder@toyota.com.tr | toyota  | 5074566787 |


  @wip @non-functional
  Scenario Outline: user should be able to access getting started page after filling valid informatio
    Given the user is on qa-testing website
    When user enters the following "<firstName>","<lastName>","<workMail>","<company>","<phone>"
    When user clicks on get a demo button
    And user should land on getting started page
    And user should be able to select date and time
    Then main title on the page should change from "Now select a time on the calendar below:"
    Examples:
      | firstName | lastName  | workMail                    | company | phone      |
      | Stephan   | Haley     | s.haley@honda.com.tr        | honda   | 5332355265 |


