package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 * Step definition to perform Edit Lead actions
 */

public class EditLead {

	WebDriver driver = Hooks.driver;
	WebDriverWait driverWait = Hooks.driverWait;

	@Given("I am on the Find Leads page")
	public void i_am_on_the_find_leads_page() {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();

	}

	@When("I search for an existing lead using phone number {string}")
	public void i_search_for_an_existing_lead_using_phone_number(String pNumber) {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}

	@Then("the Lead details associated with the phone number are retrieved")
	public void the_lead_details_associated_with_the_phone_number_are_retrieved() {
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.toLowerCase().contains("find leads"));

	}

	@When("I click on the first record")
	public void i_click_on_the_first_record() {
		WebElement leadRecord = driver
				.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		// Using Explicit wait until the element is detached from DOM
		driverWait.until(ExpectedConditions.stalenessOf(leadRecord));
		// Re-fetching the element once the results are updated after search
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

	}

	@And("I click on Edit")
	public void i_click_on_Edit() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@Then("the Edit Lead details page is displayed")
	public void the_edit_lead_details_page_is_displayed() {
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.toLowerCase().contains("opentaps crm"));
	}

	@When("I update the company name to {string}")
	public void i_update_the_company_name_to(String cNmae) {
		WebElement cNameWebElement = driver.findElement(By.id("updateLeadForm_companyName"));
		cNameWebElement.clear();
		cNameWebElement.sendKeys(cNmae);
	}

	@When("I click on Save")
	public void i_click_on_save() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("the company name is updated successfully")
	public void the_company_name_is_updated_successfully() {
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leads']")));
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.toLowerCase().contains("view lead"));

	}

}
