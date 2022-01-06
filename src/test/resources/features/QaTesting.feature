
Feature: Get a Demo  Feature
  @functional
  Scenario Outline: user should be able to access getting started page after filling valid information
    Given the user is on qa-testing website
    When user enters the following "<firstName>","<lastName>","<workMail>","<company>","<phone>"
    When user clicks on get a demo button
    Then user should land on getting started page
    Examples:
      | firstName | lastName  | workMail                    | company | phone      |
      | Brendan   | Schneider | b.scheneirder@toyota.com.tr | toyota  | 5074566787 |
      | Stephan   | Haley     | s.haley@honda.com.tr        | honda   | 5332355265 |

  @functional
  Scenario Outline: user should NOT be able to access getting started page if any input is missing
    Given the user is on qa-testing website
    When user enters the following "<firstName>","<lastName>","<workMail>","<company>","<phone>"
    When user clicks on get a demo button
    Then user should see a warning and stay on the same page
    Examples:
      | firstName | lastName  | workMail                    | company | phone      |
      |           | Schneider | b.scheneirder@toyota.com.tr | toyota  | 5074566787 |
      | Brendan   |           | b.scheneirder@toyota.com.tr | toyota  | 5074566787 |
      | Stephan   | Haley     |                             | honda   | 5332355265 |
      | Brendan   | Schneider | b.scheneirder@toyota.com.tr |         | 5074566787 |
      | Stephan   | Haley     | s.haley@honda.com.tr        | honda   |            |


  @functional
  Scenario Outline: mail input box should not accept common mail extensions
    Given the user is on qa-testing website
    When user enters the following "<firstName>","<lastName>","<workMail>","<company>","<phone>"
    When user clicks on get a demo button
    Then user should see please use your work email warning and stay on the same page
    Examples:
      | firstName | lastName  | workMail                  | company | phone      |
      | Brendan   | Schneider | b.scheneirder@gmail.com   | toyota  | 5074566787 |
      | Brendan   | Schneider | b.scheneirder@hotmail.com | toyota  | 5074566787 |
      | Brendan   | Schneider | b.scheneirder@outlook.com | toyota  | 5074566787 |
      | Brendan   | Schneider | b.scheneirder@aol.com     | toyota  | 5074566787 |


  @functional
  Scenario: preferred countries should be on top of the countries phone list
    Given the user is on qa-testing website
    When the user clicks on the flag button in telephone input
    Then country phone code list dropdown should open
    And preferred countries "United Kingdom", "United States" should be on top of the list

  @non-functional @wip
  Scenario: input boxes should have the same size
    Given the user is on qa-testing website
    Then all input boxes should have same size

  @non-functional
  Scenario: paragraph indicator buttons should have the same color code
    Given the user is on qa-testing website
    Then buttons for paragraphs should have the same color code




