@Regression
Feature: Manage conversations feature

  User story:
  As a user, I should be able to manage the conversations.

  Scenario: 1.Verify the users can copy the conversation link.
  - confirmation message should be “ Conversation link copied to clipboard.”
    Given user are in the talk page
    When user clicks on three dots icon next to the group chat
    And selects copy link from the pop up menu
    Then "Conversation link copied to clipboard." message appears on the right

@favorites
  Scenario: 2. Verify users can add a conversation to favorites.
  - after adding to favorites, the app changes from the “Add to favorite” to “Remove from favorite”.
    Given user are in the talk page
  # add favourite icon to the POM and build a logic around it
    When user clicks on three dots icon next to the group chat
    And user clicks on the Add to favourites option
    Then the app changes from the “Add to favorite” to “Remove from favorite”.