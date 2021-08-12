Feature: Creates activtiy record

  #Scenario: Admin can add new employee record
  #Given admin creates employee
  #When he performs a POST call
  #Then status code 200 is returned
  Scenario Outline: Admin can add new employee record
    Given user creates an activity with <Id> <Title> <Duedate> <Completed>
    When user performs a POST call
    Then status code 200 is returned
    And "<keys>" has expected values
    |id|
    |title|
    Examples: 
      | Id | Title            | Duedate                  | Completed |
      |  4 | NewsActivity     | 2021-08-10T23:31:20.367Z | true      |
      |  5 | DiscoverActivity | 2021-08-10T23:31:20.367Z | false     |
      |  6 | NewshhjkjhkActivity     | 2021-08-11T01:31:20.367Z | true      |
