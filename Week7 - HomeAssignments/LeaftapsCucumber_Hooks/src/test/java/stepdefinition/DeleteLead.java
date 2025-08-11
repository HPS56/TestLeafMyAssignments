package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 * Step definition to perform Delete Lead actions
 */

public class DeleteLead {

	WebDriver driver = Hooks.driver;
	WebDriverWait driverWait = Hooks.driverWait;

	@When("I click on Delete")
	public void i_click_on_delete() {
		driver.findElement(By.linkText("Delete")).click();
	}

	@Then("the Lead is successfully deleted")
	public void the_lead_is_successfully_deleted() {
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leads']")));
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.toLowerCase().contains("my leads"));
	}

}
