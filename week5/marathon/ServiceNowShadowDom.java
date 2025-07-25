/*
 * Marathon TestCase ServiceNow : Validate whether the user is able to add Apple iPhone 13 to cart and submit on service now portal (Shadow DOM)
 * 	Psuedo Code:
 * 		1.	Navigate to ''Service Now' url using get method of drive instance
 * 		2.	Locate default DOM Elements -> username, password and Log in Button
 * 		3.  Import Library for 'io.github.sukgu.Shadow' to locate elements within Shadow DOM
 * 		4.	Create and instance of the Shadow Class and get elements navigate -> All -> Service Catalog
 * 		5.	Use Shadow Class to get and navigate to Mobiles (within Iframe) and select Apple iPhone 13
 * 		6.	use Shadow Class to set the below fields
 * 		7.	Lost or Stole -> Yes
 * 		8.	Previous mobile # -> 99
 * 		9.	Data -> Unlimited
 * 		10.	Color -> Blue
 * 		11.	Storage -> 512GB
 * 		12.	Click -> 'Order Now' to place a request
 * 		13.	Check if the req number has been successfully generated or not
 * 		14.	Confirm to end user
 */
package week5.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class ServiceNowShadowDom {
	/*
	 * Reusable method to get web element Accepts driver instance and xpath as
	 * string Returns a web element
	 */
	public WebElement getWebElement(ChromeDriver driver, String xPath) {
		return (driver.findElement(By.xpath(xPath)));
	}

	/*
	 * Reusable method to get shadow dom web element using sukgu.shadow libraries
	 * string Returns a web element
	 */
	public WebElement getShadowWebElement(ChromeDriver driver, String xPath) {
		Shadow sh = new Shadow(driver);
		sh.setImplicitWait(5); // using implicit wait to handle delays
		return (sh.findElementByXPath(xPath));
	}

	@Test
	public void runServiceNow() throws InterruptedException {
		// Instance for Chrome with options->guest & adding implicit wait
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("guest");
		ChromeDriver cDriver = new ChromeDriver(cOptions);
		cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Navigating to salesforce url
		cDriver.get("https://dev209663.service-now.com");
		cDriver.manage().window().maximize();

		// Using normal method to get web elements for standard DOM
		// For user name, password and login button
		getWebElement(cDriver, "//input[@id='user_name']").sendKeys("admin");
		getWebElement(cDriver, "//input[@id='user_password']").sendKeys("qy/Q6A=vOM3x");
		getWebElement(cDriver, "//button[@id='sysverb_login']").click();
		Thread.sleep(10000); // Increased wait as the page load is too long

		// Using Shadow get web element method to navigate to service catalog
		getShadowWebElement(cDriver, "//div[text()='All']").click();
		getShadowWebElement(cDriver, "//span[text()='Service Catalog']").click();

		// Navigating to mobile by using shadow methods
		// Passing driver instance after switching to iframe
		cDriver.switchTo().frame(getShadowWebElement(cDriver, "//iframe"));
		getShadowWebElement(cDriver, "//a[contains(@aria-label,'Mobiles')]").click();

		// Navigating to Apple iPhone 13 page and setting the criteria as per
		// requirement
		getShadowWebElement(cDriver, "//strong[contains(text(),'Apple iPhone 13')]").click();
		getShadowWebElement(cDriver, "//label[text()='Yes']").click();
		getShadowWebElement(cDriver, "//input[@class='cat_item_option sc-content-pad form-control']").sendKeys("99");

		// Getting the web element for the select drop down using shadow methods
		// Passing the web element to standard select methods to select by value
		WebElement selectDataElement = getShadowWebElement(cDriver, "//select[@class='form-control cat_item_option ']");
		Select selectData = new Select(selectDataElement);
		selectData.selectByValue("Unlimited");

		// Setting further options using shadow methods and submitting to generate REQ#
		getShadowWebElement(cDriver, "//label[text()='Blue']").click();
		getShadowWebElement(cDriver, "//label[text()='512 GB [add £221.69]']").click();
		getShadowWebElement(cDriver, "//button[@id='oi_order_now_button']").click();

		// Getting the REQ# to confirm successful submission
		String reqText = getWebElement(cDriver, "(//div[@class='order_summary']//b)[2]").getText();

		if (reqText.substring(0, 3).equals("REQ")) {
			System.out.println("Mobile successfully added to cart, Request Numbner is : " + reqText);
		} else {
			System.out.println("Mobile not added to cart, Request Numbner is not generated");
		}

		cDriver.close(); // Close driver instance

	}
}