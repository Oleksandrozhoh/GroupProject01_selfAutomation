@Regression
Feature: New folder creation

  User Story :
  As a user, I should be able to manage folders.

  Scenario: 1.Verify users can create a new folder by clicking the + icon on the Files page.
    Given User is at the file page
    When user clicks on the + icon
    And user clicks on new folder and type a name
    Then user should see new folder with the name displayed on the Files page
