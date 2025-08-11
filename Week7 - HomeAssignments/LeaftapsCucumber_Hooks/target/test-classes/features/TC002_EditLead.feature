Feature: Edit an Existing Lead in Leaftaps Application

Background:
	Given I have successfully logged into Leaftaps at 'http://leaftaps.com/opentaps/' as a 'demosalesmanager'
	When I click on the CRM/SFA link
	Then Im on the HomePage

	
Scenario Outline:
	Given I am on the Find Leads page
	When I search for an existing lead using phone number "<PhoneNumber>"
	Then the Lead details associated with the phone number are retrieved
	When I click on the first record
	And I click on Edit
	Then the Edit Lead details page is displayed
	When I update the company name to "<LeadCompanyName>"
	And I click on Save
	Then the company name is updated successfully
Examples:
| LeadCompanyName 		| PhoneNumber 			|
| Cognizant				| 9888988889			|
| TestLeaf 				| 9888988881			|
| Cognizant		 		| 9888988882			|
