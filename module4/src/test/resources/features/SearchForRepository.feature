Feature: Repository

  Background:
    Given opened browser with github home page 'https://github.com/'
    Then user is logged in

  Scenario: Search for repository
    When user search for repository 'mentoringProgram'
    Then repository list are shown on results page
    And user opens the first repository by clicking on the title
    Then repository 'mentoringProgram' is opened