Narrative:
As a tester
I want to be sure
That Wikipedia's features and pages work as expected

Scenario: Events for the searched day are shown
Given an opened browser with an https://en.wikipedia.org/wiki/Main_Page
When user searches events that occurred in the same day as today
Then events for the searched day are shown

Scenario: Number of articles with Geo-points changes
Given an opened browser with an https://en.wikipedia.org/wiki/Main_Page
When user searches events that occurred in the same day as today
Then articles with Geo-points mentioning are shown
When user changes the date to tomorrow using a calendar
Then articles with Geo-points mentioning are shown
And the number of articles with Geo-points mentioning is changed