Feature: Comment posts

  Background: Comment on posts from Buzz section
    Given I am in OrangeHRM web page

    @WriteACommentInTheFirstPost
    Scenario: Comment the first post
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      And I click on the login button
      And I click on Buzz button
      And I click on the first comment icon
      When I comment "xd" on the first post
      Then Comment "xd" is displayed
      And I logout of OrangeHRM
