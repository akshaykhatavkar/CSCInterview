Feature: Advance search of Github

  Scenario: User can do advance search of closed repo
    Given I am on GitHub Page
    And I search for "react"
    And I click on Advanced Search
    And I select language as "JavaScript"
    And I select state as "closed"
    And I enter stars as ">45"
    And I enter followers as ">50"
    And I select license as "Boost Software License 1.0"
    And I click on Search
    Then Only 1 result should be displayed
    And Repo "mvoloskov/decider" should be available at position 1
    Given User nagivates to the repo
    Then Print first 300 chars of ReadMe
