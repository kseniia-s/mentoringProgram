Feature: User login

Scenario: Login as existing user
    Given opened browser with github home page 'https://github.com/'
    When user clicks on Sign in button
    And user fills a login form with predefined username and password
    And user clicks on Sign in button at the login form
    Then user is logged in