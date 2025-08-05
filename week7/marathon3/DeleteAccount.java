package week7.marathon3;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * Test method to validate whether Delete account is working as expected
 * Data is parameterised and read from excel file
 */

public class DeleteAccount extends SalesforceBaseClass {
	// Before test method to set the filename to read the data for test from the
	// excel
	@BeforeTest
	public void setValues() {
		fileName = "CreateAccount"; // re-purposing existing file from create account
	}

	/*
	 * Test method to perform action associated to delete account flow; Test depends
	 * on Create Account as it will fail without an account; Used data provider
	 * annotation to get data from file; Dependency set using dependsonmethod
	 * annotation
	 */
	@Test(dataProvider = "fetchData", dependsOnMethods = { "runCreateAccount" })
	public void runDeleteAccount(String accountName, String ownershipType) {

		// Input account name and send enter to perform search
		inputByXpath("//input[@placeholder='Search this list...']", accountName, true);
		waitForSpinner(); // Wait for search to complete
		// Get the count of rows returned before delete is performed
		String noOfItems = getTextByXpath("//span[@aria-label='Recently Viewed']");
		// Split the string value and store as integer
		String[] s = noOfItems.split(" ");
		int countBeforeDelete = Integer.parseInt(s[0]);
		// JS Click to get the sub menu for first record displayed
		jsClickbyXpath("//table/tbody/tr[1]/td[6]//button");
		waitForSpinner();
		// Click delete option from sub menu
		clickByXpath("//a[@title='Delete']");
		waitForSpinner();
		// Click delete button on the confirmation box
		clickByXpath("//button[@title='Delete']");
		waitForSpinner();
		// Get the count of rows returned after delete is performed
		noOfItems = getTextByXpath("//span[@aria-label='Recently Viewed']");
		s = noOfItems.split(" ");
		int countAfterDelete = Integer.parseInt(s[0]);
		// Compare the before and after count to confirm the delete is successful
		Assert.assertTrue(countBeforeDelete == (countAfterDelete + 1), "Verify the account has deleted");
	}
}
