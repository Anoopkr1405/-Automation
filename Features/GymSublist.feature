Feature: User clicks Gym in fitness

  @regression
  Scenario: Gym sub-Menu items
    When user clicks on Gym nearby location gyms are displayed
    Then user print the sub-Menu items of Gyms and store it in excel
    And user print available dropdown list of Sub-Menu gym items
