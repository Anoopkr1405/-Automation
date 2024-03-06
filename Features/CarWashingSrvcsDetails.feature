Feature: Identify Car Washing Services

  @sanity @regression
  Scenario: Car Washing Services
    Given the user navigate to justdial website
    Then the user handles the popup
    And the user select current Location and enter car washing services in search box
    When the user click on AllFilters and select rating greater than four
    Then name and contact number of Car washing services are printed
