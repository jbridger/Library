Feature: Private endpoints

  Scenario: Readiness endpoint
    Given I intend to get readiness status of the library service
    When I get the readiness status of the library service
    Then I get a successful response