package stepdefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccount extends SalesforceBase {

	String toastMessage;

	@Given("I click on the New button")
	public void i_click_on_the_new_button() {
		// Click new to create an account
		clickByXpath("//a[@title='New']");

	}

	@When("I enter the Account Name {string} and Ownership Type {string}")
	public void i_enter_the_account_name_and_ownership(String accountName, String ownershipType) {
		// Input value for the account name
		inputByXpath("//label[text()='Account Name']/following::input", accountName, false);
		// Using JS click to select Ownership
		jsClickbyXpath("//button[@aria-label='Ownership']");
		// Click to select Ownership Type
		clickByXpath("//lightning-base-combobox-item[@data-value='" + ownershipType + "']");

	}

	@When("I click on Save button")
	public void i_click_on_save_button() {
		// Click to save and create account
		clickByXpath("//button[@name='SaveEdit']");

	}

	@Then("the account is saved successfully")
	public void the_account_is_saved_successfully() {
		// Getting text from the toast message to confirm whether account is created
		toastMessage = getTextByXpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
		System.out.println(toastMessage);

	}

	@Then("the account name retrieved should be {string}")
	public void the_account_name_retrieved_is_as_expected(String accountName) {
		// Using assert to to confirm the account has been created for the given name
		// using "contains"
		Assert.assertTrue(toastMessage.contains(accountName), "Verify the Account name");
		closeBrowser();

	}

}
