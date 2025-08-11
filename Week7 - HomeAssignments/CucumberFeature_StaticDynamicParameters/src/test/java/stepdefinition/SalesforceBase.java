package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.testng.AbstractTestNGCucumberTests;

/*
 * Base Class for Salesfroce application to cover
 * Setting Driver, Implicit wait and Explicit wait
 * Reusable actions to interact with Web Elements to click, input and get text
 * Pre-conditions for test @beforemethod and @aftermethod
 */

public class SalesforceBase extends AbstractTestNGCucumberTests {
	// Declaring global class members to use within package
	public static RemoteWebDriver driver; // Instance for remote driver
	public static WebDriverWait dWait; // Driver wait for explicit conditions
	public static ChromeOptions options; // Chrome options if chromedriver is to be created

	// Method to wait for the spinner element to disappear to confirm the page or
	// action is complete
	public void waitForSpinner() {
		// Using try catch block to handle and close the browser gracefully if the
		// condition is not met within given time
		try {
			dWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@part,'spinner')]")));
		} catch (Exception e) {
			System.out.println("Page load is not completed, closing browser and exiting test");
			closeBrowser();
		}
	}

	// Explicit wait method for presence and visibility of element
	public WebElement waitForElementToLoad(String Xpath) {
		// Using try catch block to handle and close the browser gracefully if the
		// condition is not met within given time
		try {
			return dWait.until(ExpectedConditions
					.visibilityOf(dWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)))));
		} catch (Exception e) {
			System.out.println("Element not located within time limit for xpath " + Xpath);
			closeBrowser();
			return null;
		}
	}

	// Reusable method to input values and send keys based on boolean flag
	public void inputByXpath(String xPath, String value, boolean sendEnter) {
		// Calls to wait method and gets element method
		WebElement input = waitForElementToLoad(xPath);
		// Clearing any values already exist in the input box
		input.clear();
		// Taking the sendEnter parameter to check and send "enter" keys
		if (sendEnter) {
			input.sendKeys(value, Keys.ENTER);
		} else {
			input.sendKeys(value);
		}

	}

	// Reusable method to get element using wait and perform click action
	public void clickByXpath(String xPath) {// Method to click
		WebElement button = waitForElementToLoad(xPath);
		// Using Action class to Scroll to Element to click
		Actions act = new Actions(driver);
		act.moveToElement(button).pause(30).click().perform();
	}

	// Reusable method to get a text value of the web element
	public String getTextByXpath(String xPath) {
		WebElement element = driver.findElement(By.xpath(xPath));
		return element.getText();
	}

	// Reusable method to perform a click using JavaScript for complex elements
	public void jsClickbyXpath(String xPath) {
		driver.executeScript("arguments[0].click()", waitForElementToLoad(xPath));
	}

	public void launchBrowser(String url) {
		// Declaring ChomeOptions to suppress warnings and notifications
		options = new ChromeOptions();
		options.addArguments("guest");
		driver = new ChromeDriver(options);

		// Launch the browser with url from parameter and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		// Setting timeout from the parameter for both implicit and explicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		dWait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	// Method to close the browser once the test is executed
	
	public void closeBrowser() {
		if (driver!= null)	driver.quit();
	}
}
