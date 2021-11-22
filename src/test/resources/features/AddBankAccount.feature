#Author: janithriarosha@gmail.com
Feature: Add a bank account
  
  As a Xero User
  In order to manage my business successfully
  I want to be able to add an ANZ (NZ) bank account inside any Xero Organisation

  Scenario: Add ANZ bank account
    Given I have logged in to my xero account
    And I have selected Bank Account from the menu
    When I select to add a bank account
    And I add my ANZ bank details
    Then I can see my ANZ account added successfully
