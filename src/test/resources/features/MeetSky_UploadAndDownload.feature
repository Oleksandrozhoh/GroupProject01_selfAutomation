@Regression
Feature: Upload and Download feature

  User story:
  As a user, I should be able to manage a file.
  @UploadFIle
  Scenario: 1.Verify users can upload a file by clicking the + icon on the Files page.
 - File name should be displayed on the file page after successful upload.

    Given User is at the file page
    When user clicks on the + icon
    When user select upload file from pop up menu
    Then file name should be displayed on the file page after successful upload.

  @RenameFunctionality
    Scenario: 2.Verify the users can rename a file by clicking the 3 dots.
    - File name should be different after renaming it.

      Given User is at the file page
      When user clicks on the 3 dots icon
      And user select rename from pop up menu
      And user types new file name
      Then file name should be different after renaming it

  @DownloadFunctionality
      Scenario: 3.Verify the users can download a file by clicking the 3 dots.

        Given User is at the file page
        When user clicks on the 3 dots icon
        And user select download from pop up menu
        Then file should be downloaded to users computer