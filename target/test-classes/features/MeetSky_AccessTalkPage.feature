@Khrystyna
Feature: Access Talk Page
  User story:
  As a user, I should be able to access to the Talk page.

  Background:
    Given user are at the home page.
    When user clicks on Talk module

  @clickToggle
  Scenario:1. Verify the app compress the app navigator by clicking the “app-navigation-toggle”.
    When user clicks on Talk module
    And user clicks on app-navigation-toggle("hamburger" sign)
    Then user sees app compresses the app navigator

    @sendMessage
    Scenario:2. Verify users can send direct messages.
    The message should display in the conversation area.
      And user search for "User20"
      And user clicks on displayed option from list
      And user write message in message box
      And user clicks Send button
      Then user sees message in conversation area

      @user20
      Scenario: 3. Verify users see the “You created the conversation” Message after sending the first message.
        And user search for "User20"
      And user clicks on displayed option from list
       And user write message in message box
       And user clicks Send button
       Then user see the You created the conversation after first message
