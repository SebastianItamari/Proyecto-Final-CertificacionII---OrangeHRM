Feature: Employees information in PIM section

  Background: Operations with information of employees
    Given I am in OrangeHRM web page

    @AddEmployeesSuccessfully
    Scenario: Add employees with correct values
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      And I click on the login button
      And I click on PIM button
      And I click on Add Employee Button
      And I fill the employee information with
        | Sebastian | Pedro | Itamari |
      And I click on save button
      And I click on Add Employee Button
      And I click on Employee List Button
      And I set the employee name field with "Sebastian Pedro Itamari"
      When I click on search button
      Then Register of added employee is displayed
      And I logout of OrangeHRM