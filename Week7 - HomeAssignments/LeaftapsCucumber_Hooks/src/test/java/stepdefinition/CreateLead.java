package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 * Step definition to perform Create Lead actions
 */

public class CreateLead {
	
	// Hooks can't be extended, hence taking instance for data instances
	WebDriver driver = Hooks.driver;
	WebDriverWait driverWait = Hooks.driverWait;
	
	@Given("Im on the Create Leads Page")
	public void i_navigate_to_create_leads_page() {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

	}
	@When("I enter the Company Name as {string}, First Name as {string}, Surname as {string} and PhoneNumber as {string}")
	public void i_enter_the(String cName, String fName, String lName, String phoneNumber) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryPhoneNumber']")).sendKeys(phoneNumber);
	}
	@When("I click submit button")
	public void i_click_submit_button() {
		driver.findElement(By.name("submitButton")).click();
   
	}
	@Then("the Lead is successfully created")
	public void the_lead_is_successfully_created() {
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leads']")));
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.toLowerCase().contains("view lead"));	    
	}

}
