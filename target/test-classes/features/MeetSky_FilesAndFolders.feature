Feature: Files & folders feature

  User story:
  As a user, I should be able to manage files & folders.

  Scenario: Verify any file or folder can be selected.
    Given user are at the home page.
    When user clicks on the Files module..
    Then user launched to the Files page
    When user clicks on any file or folder checkbox
    Then User should see the checkbox selected indicating that the file or folder is selected.

      @Alvin
    Scenario: Verify all the files & folders are selected after clicking the top checkbox.
      When user clicks on the Files module..
      Then user launched to the Files page
      When User should be able to click the "all folders" checkbox.
      Then User should see all the files and folders checkboxes selected automatically.
