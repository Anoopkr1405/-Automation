Feature: User Open FreeListing

  @regression
  Scenario: FreeListing
    Given the user clicks on FreeListing
    When FreeListing is opened user enters wrong details and click on start now button
    Then the user print the invalid displayed message and navigate back to justdial website
