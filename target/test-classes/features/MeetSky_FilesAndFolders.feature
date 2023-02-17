@Regression
Feature: Files & folders feature

  User story:
  As a user, I should be able to manage files & folders.

  @SelectAnyFileCheckbox
  Scenario: Verify any file or folder can be selected.

    Given User is at the file page
    When user clicks on any file or folder checkbox
    Then User should see the checkbox selected indicating that the file or folder is selected.

  @SelectAllFilesCheckbox
    Scenario: Verify all the files & folders are selected after clicking the top checkbox.

      Given User is at the file page
      When User should be able to click the Select All checkbox.
      Then User should see all the files and folders checkboxes selected automatically.
