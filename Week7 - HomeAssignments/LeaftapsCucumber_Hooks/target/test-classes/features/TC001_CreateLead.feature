Feature:Create a New Lead in Leaftaps Application

Background:
	Given I have successfully logged into Leaftaps at 'http://leaftaps.com/opentaps/' as a 'demosalesmanager'
	When I click on the CRM/SFA link
	Then Im on the HomePage

	
Scenario Outline:
	Given Im on the Create Leads Page
	When I enter the Company Name as "<LeadCompanyName>", First Name as "<LeadFirstName>", Surname as "<LeadSecondName>" and PhoneNumber as "<PhoneNumber>"
	And I click submit button
	Then the Lead is successfully created
Examples:
| LeadCompanyName 		| LeadFirstName 			| LeadSecondName			| PhoneNumber 			|
| TestLeaf			 	| Sarah 					| McCarthy					| 9888988889			|
| TCS 					| Mike 						| Sands						| 9888988881			|
| Cognizant		 		| Wilson		 			| Waters					| 9888988882			|
	