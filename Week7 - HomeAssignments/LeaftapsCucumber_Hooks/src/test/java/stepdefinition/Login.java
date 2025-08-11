package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 * Steps to handle login to page to support background for all feature files
 */

public class Login {

	WebDriver driver = Hooks.driver;

	@Given("I have successfully logged into Leaftaps at {string} as a {string}")
	public void i_have_successfully_logged_into_leaftaps_at_as_a(String url, String userName) {
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

	}

	@When("I click on the CRM\\/SFA link")
	public void i_click_on_the_crm_sfa_link() {
		driver.findElement(By.linkText("CRM/SFA")).click();

	}

	@Then("Im on the HomePage")
	public void im_on_the_home_page() {
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.toLowerCase().contains("my home"));
	}

}
