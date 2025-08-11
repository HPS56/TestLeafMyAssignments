Feature: Edit Account Details in Salesforce

  Background:
    Given I am logged into the Salesforce application at 'https://login.salesforce.com/' with valid credentials

  Scenario: Update account information and verify changes
  Given I open the App Launcher
  And I navigate to the "Account" section
  And I search for the account with a unique name
  When I click Edit on the first search result
  And I set the Type field to "Technology Partner"
  And I set the Industry field to "Healthcare"
  And I set the Billing Address field to "69, TestLeaf"
  And I set the Shipping Address field to "69, TestLeaf"
  And I set the Customer Priority field to "Low"
  And I set the Phone field to "9988665544"
  And I set the Upsell Opportunity field to "No"
  And I save the changes
  Then the account details should be updated successfully
  And the displayed phone number should be "9988665544"
