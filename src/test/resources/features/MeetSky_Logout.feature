  @Regression
  Feature: Logout functionality
  User story:
  As a user I should be able to logout.

  @LogoutFunctionality

  Scenario: 1. Users can log out by using log out button inside profile info and ends up in login page.
    Given user are at the home page.
    When User clicks on the profile button
    And User presses log out button
    Then User lands on the login page

  @BackButton
  Scenario: 2. Users cannot go to the home page again by clicking the step back button after successfully logged out
    Given  User is at login page
    When User clicks back button
    Then User stays at login page

    @AwayFromTheKeyboard
    Scenario: 3. Users must be logged out if the user is away from keyboard for 3 minutes (AFK-away from keyboard)
    (if the user does not do any mouse or keyboard action for 3 minutes)
    Given user are at the home page.
    When User doesn't perform any action for 3 minutes
    Then User is logged out automatically


