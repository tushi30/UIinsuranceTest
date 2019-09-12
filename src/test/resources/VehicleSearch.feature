@run
Feature: Vehicle Inquiry
  #Valid  user should be able to search insurance status using vehicle registration

  Scenario: Valid vehicle search
    Given An authorised user navigates to the covercheck website
    When The User  enters the desired registration number in the enter reg field
    And The user clicks on the find vehicle link
    Then the vehicle reg search result is displayed



 Scenario: Invalid registration search
    Given An authorised user navigates to the covercheck website
    When The User  enters an invalid registration number in the enter reg field
    And The user clicks on the find vehicle link
    Then An error message is displayed



  Scenario: Blank Registration search
    Given An authorised user navigates to the covercheck website
    When The User leaves registration number field blank
    And The user clicks on the find vehicle link
    Then An error message is displayed "Please enter a valid car registration"