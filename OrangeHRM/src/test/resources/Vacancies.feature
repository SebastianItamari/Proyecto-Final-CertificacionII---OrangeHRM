Feature: Vacancies information in Recruitment section

  Background: Operations with information of vacancies
    Given I am in OrangeHRM web page

    @UpdateTheFirstVacancy
    Scenario: Update the information of the first vacancy
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      And I click on the login button
      And I click on Recruitment button
      And I click on Vacancies button
      And I click on the first edit icon
      And I update the vacancy information with
        | Associate Chief Executive Officer | Chief Executive Officer | This is an updated vacancy | 2 |
      And I click on the save button
      When I click on Vacancies button
      Then A vacancy appears with the values
        | Associate Chief Executive Officer | Chief Executive Officer |
      And I logout of OrangeHRM
