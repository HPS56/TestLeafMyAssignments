Feature: Delete an Existing Lead in Leaftaps Application

Background:
	Given I have successfully logged into Leaftaps at 'http://leaftaps.com/opentaps/' as a 'demosalesmanager'
	When I click on the CRM/SFA link
	Then Im on the HomePage

	
Scenario Outline:
	Given I am on the Find Leads page
	When I search for an existing lead using phone number "<PhoneNumber>"
	Then the Lead details associated with the phone number are retrieved
	When I click on the first record
	Then the Edit Lead details page is displayed
	When I click on Delete
	Then the Lead is successfully deleted
Examples:
| PhoneNumber 			|
| 9888988889			|
| 9888988881			|
| 9888988882			|