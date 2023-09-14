Feature: Login in OrangeHRM page

  Background: User login into OrangeHRM
    Given I am in OrangeHRM web page

    @LoginInOrangeHRM
    Scenario Outline: Login into Sauce Demo page with many values
      Given I set the user name field with "<name>"
      And I set the password field with "<password>"
      When I click on the login button
      Then The dashboard page should be displayed
      And I logout of OrangeHRM
      Examples:
        | name  | password |
        | Sebas | wrong    |
        | Admin | admin123 |
        | Xd    | brrr     |
