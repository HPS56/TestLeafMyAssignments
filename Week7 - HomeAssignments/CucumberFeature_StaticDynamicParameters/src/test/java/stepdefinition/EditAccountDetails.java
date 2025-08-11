package stepdefinition;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditAccountDetails extends SalesforceBase {
	String enteredPhoneNumber;

	@Given("I am logged into the Salesforce application at {string} with valid credentials")
	public void loginToSalesforce(String url) {
		// Calling method in base class to launch browser
		launchBrowser(url);
		// Entering username
		inputByXpath("//input[@id='username']", "vidyar@testleaf.com", false);
		// Entering passowrd
		inputByXpath("//input[@id='password']", "Sales@123", false);
		// Click on Login
		clickByXpath("//input[@id='Login']");
		// Invoking method to make sure the spinner is disappeared before perform next
		// actions
		waitForSpinner();
	}

	@When("I open the App Launcher")
	public void openAppLauncher() {
		// Click on waffle-icon to launch App menu
		clickByXpath("//button[@title='App Launcher']");
		waitForSpinner();
		// Click view all option to get full menu
		clickByXpath("//button[text()='View All']");
		waitForSpinner();
		// Click to navigate to Sales main page
		clickByXpath("//p[text()='Sales']/ancestor::a");
		waitForSpinner();
	}

	@And("I navigate to the {string} section")
	public void navigateToSection(String section) {
		// Click to navigate to Account option
		clickByXpath("//one-app-nav-bar-item-root[contains(@data-target-selection-name,'" + section + "')]");
		waitForSpinner();

	}

	@And("I search for the account with a unique name")
	public void searchUniqueAccount() {
		// Input account name to edit and perform search by passing 'Enter'
		inputByXpath("//input[@placeholder='Search this list...']", "Harikumar", true);
		waitForSpinner(); // wait for search result to load

	}

	@And("I click Edit on the first search result")
	public void clickEditOnFirstResult() {
		// JS Click to display the option for the first record
		jsClickbyXpath("//table/tbody/tr[1]/td[6]//button");
		waitForSpinner();
		// Click on Edit to update the record
		clickByXpath("//a[@title='Edit']");

	}

	@When("I set the Type field to {string}")
	public void i_set_the_field_to(String type) {
		// JS click to select type drop down
		jsClickbyXpath("//button[@aria-label='Type']");
		// Click to select account type
		clickByXpath("//lightning-base-combobox-item[@data-value='" + type + "']");

	}

	@When("I set the Industry field to {string}")
	public void i_set_the_industry_field_to(String industryType) {
		// JS click to select industry drop down
		jsClickbyXpath("//button[@aria-label='Industry']");
		// Click to select value for industry drop down
		clickByXpath("//lightning-base-combobox-item[@data-value='" + industryType + "']");
	}

	@When("I set the Billing Address field to {string}")
	public void i_set_the_billing_address_field_to(String billingAddress) {
		// Input to textarea for shipping address
		inputByXpath("//label[text()='Billing Street']/following::textarea", billingAddress, false);
	}

	@When("I set the Shipping Address field to {string}")
	public void i_set_the_shipping_address_field_to(String shippingAddress) {
		// Input to textarea for shipping address
		inputByXpath("(//label[text()='Shipping Street']/following::textarea)", shippingAddress, false);
	}

	@When("I set the Customer Priority field to {string}")
	public void i_set_the_customer_priority_field_to(String string) {
		// JS click to select customer Priority drop down
		jsClickbyXpath("//button[@aria-label='Customer Priority']");
		// Click to select value for Customer priority drop down
		clickByXpath("//lightning-base-combobox-item[@data-value='Low']");
	}

	@When("I set the Phone field to {string}")
	public void i_set_the_phone_field_to(String string) {
		// Input mobile number which is randomly generated
		inputByXpath("//input[@name='Phone']", string, false);

	}

	@When("I set the Upsell Opportunity field to {string}")
	public void i_set_the_upsell_opportunity_field_to(String string) {
		// JS click to select opportunity drop down
		jsClickbyXpath("//button[@aria-label='Upsell Opportunity']");
		// Click to select value from drop down
		clickByXpath("//lightning-base-combobox-item[@data-value='No']");

	}

	@When("I save the changes")
	public void i_save_the_changes() {
		// Click on Save button to process edit
		clickByXpath("//button[@name='SaveEdit']");
		waitForSpinner();
	}

	@Then("the account details should be updated successfully")
	public void verifyUpdateSuccess() {
		// Get phone number using get text method after edit is saved
		enteredPhoneNumber = getTextByXpath("//table/tbody/tr[1]/td[4]");
	}

	@And("the displayed phone number should be {string}")
	public void verifyPhoneNumber(String expectedPhone) {
		// Assert to check if the phone number entered and phone number retrieved after
		// edit is same
		Assert.assertTrue(enteredPhoneNumber.contains(expectedPhone), "verify the mobileNumber");
		closeBrowser();

	}
}
