@Regression
#As a user, I should be able to create group channels.
#1.Verify the users can create channels and add the other users by clicking the + icon on the Talk page.
#    - users able to write a channel name
#    - Users able to add all the users by searching and selecting
# 2. Verify users have 8 action options to do with a channel as shown in design.

  Feature: Group Channels feature
    User story:
    As a user, I should be able to create group channels.

   @wip
  Scenario: Verify the users can create channels and add the other users by clicking the + icon on the Talk page.
    Given User is at the talk page
    When User clicks on the create button and to write a channel name
    And User able to add all the users by searching and selecting
    Then User should see the group channel name

    @wip
  Scenario: Verify the users can create channels and add the other users by clicking the + icon on the Talk page.
  Given User is at the talk page
  When User clicks on the dots button
  Then user able to see 8 actions to do with channel
      
