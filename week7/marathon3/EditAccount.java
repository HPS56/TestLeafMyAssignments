package week7.marathon3;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * Test method to validate whether Delete account is working as expected
 * Data is parameterised and read from excel file
 */

public class EditAccount extends SalesforceBaseClass {
	// Before test method to set the filename to read the data for test from the excel
	@BeforeTest
	public void setValues() {
		fileName = "EditAccount"; // setting the filename
	}
	
	/*
	 * Test method to perform action associated to Edit account flow; Test depends
	 * on Create Account as it will fail without an account; Used data provider
	 * annotation to get data from file; Dependency set using dependsonmethod
	 * annotation
	 */
	@Test(dataProvider = "fetchData", dependsOnMethods = { "runCreateAccount" })
	public void runEditAccount(String accountName, String accountType, String accountIndustry, String accBillingAddress,
			String accShipingAddress) {

		// Input account name to edit and perform search by passing 'Enter'
		inputByXpath("//input[@placeholder='Search this list...']", accountName, true);
		waitForSpinner(); // wait for search result to load
		// JS Click to display the option for the first record
		jsClickbyXpath("//table/tbody/tr[1]/td[6]//button");
		waitForSpinner();
		// Click on Edit to update the record
		clickByXpath("//a[@title='Edit']");
		// JS click to select type drop down
		jsClickbyXpath("//button[@aria-label='Type']");
		// Click to select account type
		clickByXpath("//lightning-base-combobox-item[@data-value='" + accountType + "']");
		// JS click to select industry drop down
		jsClickbyXpath("//button[@aria-label='Industry']");
		// Click to select value for industry drop down
		clickByXpath("//lightning-base-combobox-item[@data-value='" + accountIndustry + "']");
		// Input to textarea for billing and shipping address
		inputByXpath("//label[text()='Billing Street']/following::textarea", accBillingAddress, false);
		inputByXpath("(//label[text()='Shipping Street']/following::textarea)", accShipingAddress, false);
		// JS click to select customer Priority drop down
		jsClickbyXpath("//button[@aria-label='Customer Priority']");
		// Click to select value for Customer priority drop down
		clickByXpath("//lightning-base-combobox-item[@data-value='Low']");
		// Click on SLA drop down
		clickByXpath("//button[@aria-label='SLA']");
		// Click to select value for SLA
		clickByXpath("//lightning-base-combobox-item[@data-value='Silver']");
		// JS click to select status drop down
		jsClickbyXpath("//button[@aria-label='Active']");
		// Click to select value from drop down
		clickByXpath("//lightning-base-combobox-item[@data-value='No']");
		// Generating 9 digit random number and prefix with '9' to form a mobile number
		long number = (long) (Math.random() * 1_000_000_000L);
		String phoneNumber = "9" + String.format("%09d", number);
		System.out.println(phoneNumber);
		// Input mobile number which is randomly generated
		inputByXpath("//input[@name='Phone']", phoneNumber, false);
		// JS click to select opportunity drop down
		jsClickbyXpath("//button[@aria-label='Upsell Opportunity']");
		// Click to select value from drop down
		clickByXpath("//lightning-base-combobox-item[@data-value='No']");
		// Click on Save button to process edit
		clickByXpath("//button[@name='SaveEdit']");
		waitForSpinner();
		// Get phone number using get text method after edit is saved
		String enteredPhoneNumber = getTextByXpath("//table/tbody/tr[1]/td[4]");
		System.out.println(enteredPhoneNumber);
		// Assert to check if the phone number entered and phone number retrieved after edit is same 
		Assert.assertTrue(enteredPhoneNumber.contains(phoneNumber), "verify the mobileNumber");

	}
}
