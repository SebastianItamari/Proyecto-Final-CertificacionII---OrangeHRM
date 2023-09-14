Feature: Text posting

  Background: Post texts in Buzz section
    Given I am in OrangeHRM web page

    @PostInBuzzSection
    Scenario Outline: Post many texts in Buzz section
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      And I click on the login button
      And I click on Buzz button
      And I set the post field with "<postText>"
      And I click on post button
      When I click on Buzz button
      Then The post "<textPosted>" is displayed
      And I logout of OrangeHRM
      Examples:
        | postText     | textPosted |
        | I'm tired    | I'm tired  |
        | Xd           | Xd         |
        | Hello World! | Hola       |
