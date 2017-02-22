Feature: Private endpoints

  @group1
  Scenario: Readiness endpoint group1
    Given I intend to get readiness status of the library service
    When I get the readiness status of the library service
    Then I get a successful response

  @group2
  Scenario: Readiness endpoint group2
    Given I intend to get readiness status of the library service
    When I get the readiness status of the library service
    Then I get a successful response