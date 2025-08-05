package week7.marathon3;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * Test method to validate whether create account is working as expected
 * Data is parameterised and read from excel file
 */

public class CreateAccount extends SalesforceBaseClass {

	// Before test method to set the filename to read the data for test from the
	// excel
	@BeforeTest
	public void setValues() {
		fileName = "CreateAccount";
	}

	/*
	 * Test method to perform action associated to Create account flow; Used
	 * dataprovider annotation to get data from file; Dependency set using
	 * dependsonmethod annotation
	 */
	@Test(dataProvider = "fetchData")
	public void runCreateAccount(String accountName, String ownershipType) {

		// Click new to create an account
		clickByXpath("//a[@title='New']");
		// Input value for the account name
		inputByXpath("//label[text()='Account Name']/following::input", accountName, false);
		// Using JS click to select Ownership
		jsClickbyXpath("//button[@aria-label='Ownership']");
		// Click to select Ownership Type
		clickByXpath("//lightning-base-combobox-item[@data-value='" + ownershipType + "']");
		// Click to save and create account
		clickByXpath("//button[@name='SaveEdit']");
		// Getting text from the toast message to confirm whether account is created
		String toastMessage = getTextByXpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
		System.out.println(toastMessage);
		// Using assert to to confirm the account has been created for the given name
		// using "contains"
		Assert.assertTrue(toastMessage.contains(accountName), "Verify the Account name");
	}
}
