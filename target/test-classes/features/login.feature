Feature: Login functionality

  Scenario: User logs in with valid credentials
    Given I open the login page
    When I enter username "testuser"
    And I enter password "password123"
    And I click the login button
    Then I should see the dashboard page
   