Feature: Testing Assessment

  @run
  Scenario Outline: Hotel App
    Given user is on the landing page
    When user logs in
    And Validate the user is on search page
    And Seach Hotel "<Location>"
    Then Verify that the list of location "<Location>" returned
    Examples:
      | Location |
      |   Sydney |


