Feature: Second Controller
  This feature tests the functionality exposed by first controller

  Scenario: Execute the secondController get call
    Given the application is bootstraped
    When I make a Get call
    Then I should receive the expected output