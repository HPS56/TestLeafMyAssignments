Feature: Create New Account in Salesforce

	Background:
		Given I am logged into the Salesforce application at 'https://login.salesforce.com/' with valid credentials
		
	Scenario Outline:
		Given I open the App Launcher
		And I navigate to the "Account" section
		And I click on the New button
		When I enter the Account Name "<AccountName>" and Ownership Type "<OwnershipType>"
		And I click on Save button
		Then the account is saved successfully
		And the account name retrieved should be "<AccountName>"
		
		Examples:
		| AccountName 	| OwnershipType 	|
		| Harikumar		| Public			|
		| Sarah			| Public			|
		
