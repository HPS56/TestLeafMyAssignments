package week6.day1.homeassignments;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class NewLegalEntities extends SalesForceBase {
	
	// Test Method to create an new Legal Entity
	@Test
	public void addNewLegalEntities() {
		
		boolean status = false; //setting up default for asserting the conditions
		getElementToClickByXpath( "//div[@class='slds-icon-waffle']");
		getElementToClickByXpath( "//button[@aria-label='View All Applications']");
		getElementToClickByXpath( "//p[text()='Legal Entities']");
		getElementToClickByXpath( "(//a[@title='New'])[1]");
		getElementToInputByXpath( "//input[@name='Name']", "TestLead");
		getElementToInputByXpath( "(//textarea)[2]", "Salesforce");
		getElementToClickByXpath( "//button[contains(@id,'combobox-button')]");
		getElementToClickByXpath( "//lightning-base-combobox-item[@data-value='Active']");
		getElementToClickByXpath( "//button[@name='SaveEdit']");
		String confMessage = getElementToGetTextByXpath( "//span[contains(@class,'toast')]");
		// Using assert class check whether the confirmation msg is as expected
		status = confMessage.equalsIgnoreCase("Legal Entity \"TestLead\" was created.");
		assertEquals(status, true);

	}
}
