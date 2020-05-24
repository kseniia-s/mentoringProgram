Feature: Repository

  Background:
    Given opened browser with github home page 'https://github.com/'
    Then user is logged in

  Scenario Outline: Search for repository
    When user search for repository '<reponame>'
    Then repository list are shown on results page
    And user opens the first repository by clicking on the title
    Then repository '<reponame>' is opened

    Examples:
      | reponame |
      | spring   |