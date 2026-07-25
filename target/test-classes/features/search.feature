Feature: Search functionality

  Scenario: User searches for a keyword
    Given I open the homepage
    When I search for "Selenium"
    Then the search box should contain "Selenium"
