@Regression
Feature: Login page features

  User story:
  As a user, I should be able to access all the features on the login page.

  @LoginFunctionality
  Scenario: 1.Users should be able to log in with valid credentials should land on the "Dashboard" page after successful login.

    Given user is at the login page
    When enters valid username to username input box
    And enters valid password to password input box
    And clicks login button
    Then land on the Dashboard page after successful login.

  @InvalidLoginOrPassword
  Scenario: 2.Invalid username or password. message should be displayed for invalid login attempt.

    Given user is at the login page
    When enters invalid username to username input box
    And enters valid password to password input box
    And clicks login button
    Then user should see the warning message - Wrong username or password


  Scenario: 3.Please fill out this field. message should be displayed for any empty field

    Given user is at the login page
    When user leaves username empty
    And clicks login button
    Then Please fill out this field. message should be displayed for any empty field


  Scenario: 4.The password text box displays the characters entered by a user as bullet point
    Given user is at the login page
    When enters password to password input box
    Then password text box displays the characters entered by a user as bullet point