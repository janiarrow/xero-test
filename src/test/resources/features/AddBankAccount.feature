#Author: janithriarosha@gmail.com
Feature: Add an ANZ bank account
  
  As a Xero User
  In order to manage my business successfully
  I want to be able to add an ANZ (NZ) bank account inside any Xero Organisation

  Scenario Outline: Add my ANZ everyday bank account 
    Given I have logged in to my xero account
    And I have selected Bank Account from the menu
    When I select to add a bank account
    And add my ANZ "Everyday" bank details with <accountName> and <accountNumber>
    And select the bank to send transactions to Xero later
    Then I can see my ANZ account <accountName> has been added successfully
    
    Examples:
    |accountName	|accountNumber|
		|testAc6767		|1231231231231|
		
	Scenario Outline: Add my ANZ loan bank account 
    Given I have logged in to my xero account
    And I have selected Bank Account from the menu
    When I select to add a bank account
   	And add my ANZ "Loan" bank details with <accountName> and <accountNumber>
    And select the bank to send transactions to Xero later
    Then I can see my ANZ account <accountName> has been added successfully
    
    Examples:
    |accountName			|accountNumber|
		|loantest1213781			|34523523423423|
		
	Scenario Outline: Add my ANZ credit card account
    Given I have logged in to my xero account
    And I have selected Bank Account from the menu
    When I select to add a bank account
   	And add my ANZ "Credit Card" bank details with <accountName> and <accountNumber>
    And select the bank to send transactions to Xero later
    Then I can see my ANZ account <accountName> has been added successfully
    
    Examples:
    |accountName			|accountNumber|
		|cctes127878			|1233				|