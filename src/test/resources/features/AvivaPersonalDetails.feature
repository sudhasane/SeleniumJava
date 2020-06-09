Feature: Car Insurance Quote details Test

  Scenario: Aviva Insurer details
    Given I am on Aviav insurance quote page
    And I fill following insurer personal details
      | Title            | Mrs                    |
      | First name       | sudha                  |
      | Last name        | sane                   |
      | DateOfBirthDay   | 10                     |
      | DateOfBirthMonth | 10                     |
      | DateOfBirthYear  | 1990                   |
      | PostCode         | CB19JU                 |
      | EmailAddress     | vanisekhar75@gmail.com |
      | TelephoneNumber  | 07587656566            |

  @smoke
  Scenario: Aviva Insurer quote fields
    When I am on Aviav insurance quote page
    Then I should see inputs with required filed labels
    |First name|Last name|Date of birth|What is your postcode?|Email address|Preferred telephone number|

  Scenario: Vlidate error messages while filling insurer details
    Given I am on Aviav insurance quote page
    And I click on continue button
    Then error message should be displayed
      | Title | Please select |
    When I fill insurer personal details
      | Title | Mrs |
    And I click on continue button
    Then error message should be displayed
      | First name | Please enter your first name |
    When I fill insurer personal details
      | First name | sudha |
    And I click on continue button
    Then error message should be displayed
      | Last name | Please enter your last name |




