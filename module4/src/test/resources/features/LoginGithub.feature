Feature: User login

Scenario: Login as existing user
    Given opened browser with github home page 'https://github.com/'
    When user clicks on Sign in button
    And user fills a login form
    |userName|password|
    |fitah20745@homedepinst.com|htcnhernehbpfwbz1!|
    And user clicks on Sign in button at the login form
    Then user is logged in