package week6.day2.homeassignments;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import week6.day1.homeassignments.SalesForceBase;

public class CreatNewLEParameters extends SalesForceBase {
	// Test Method to create Legal Entities by taking values through parameters (@Dataprovider)
	@Test(dataProvider = "getData")
  public void runCreateNewLEParameter(String name, String expectedValue) {

		boolean status = false;//setting up default for asserting the conditions
		getElementToClickByXpath("//div[@class='slds-icon-waffle']");
		getElementToClickByXpath("//button[@aria-label='View All Applications']");
		getElementToClickByXpath("//p[text()='Legal Entities']");
		getElementToClickByXpath("(//a[@title='New'])");
		getElementToInputByXpath("//input[@name='Name']", "Salesforce force automation by "+ name);
		getElementToClickByXpath("//button[contains(@id,'combobox-button')]");
		getElementToClickByXpath("//lightning-base-combobox-item[@data-value='Active']");
		getElementToClickByXpath("//button[@name='SaveEdit']");
		String confMessage = getElementToGetTextByXpath("//span[contains(@class,'toast')]");
		// Using assert class check whether the confirmation msg is as expected
		status = confMessage.equalsIgnoreCase("Legal Entity \""+expectedValue+"\" was created.");
		assertEquals(status, true);
	}
}
