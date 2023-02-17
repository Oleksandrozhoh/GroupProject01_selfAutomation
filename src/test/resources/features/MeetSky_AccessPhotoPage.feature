@regression

Feature: photo page functionality
  user story:As a user, I should be able to access to the photo page.


  Scenario:1.Verify the user can access to the photo page
 Given user are at the home page.
 When  user clicks on the  photo .
 Then  user should be able to access to the photo page.


Scenario: Verify the users see 6 options in the Photos page as shown in the design.
  Given user at photo page.
  Then user clicks on the navigation button.



  Scenario: Verify the “Photo View” .

    When user at photo page.
    Then user can see photo view

    Scenario: checkbox under the Settings on the Photos page.
      When user at photo page.
      Then user can see checkbox under settings