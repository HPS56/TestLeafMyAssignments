package week7.marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

/*
 * Base Class for Salesfroce application to cover
 * Setting Driver, Implicit wait and Explicit wait
 * Reusable actions to interact with Web Elements to click, input and get text
 * Pre-conditions for test @beforemethod and @aftermethod
 * Data integration using Excel and @dataprovider annotations
 */

public class SalesforceBaseClass {
	// Declaring global class members to use within package
	public RemoteWebDriver driver; // Instance for remote driver
	public WebDriverWait dWait; // Driver wait for explicit conditions
	public ChromeOptions options; // Chrome options if chromedriver is to be created
	public String fileName; // To store the filename of the excel file to use for test

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
			System.out.println("Element not located within time limit for xpath "+Xpath);
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

	// Before Method to take common static parameters to setup pre-requisitie before
	// test method
	@Parameters({ "url", "username", "password", "browser", "explicitwait", "implicitwait" })
	@BeforeMethod
	public void launchBrowser(String url, String username, String password, String browser, int explicitWait,
			int implicitWait) {
		// Declaring ChomeOptions to suppress warnings and notifications
		options = new ChromeOptions();
		options.addArguments("guest");
		// Taking the parameter 'browser' to check the value using switch and create
		// specific browser instance
		switch (browser.toLowerCase()) {
		case "chrome": // For Chrome
			driver = new ChromeDriver(options);
			break;
		case "edge": // For Edge
			driver = new EdgeDriver();
			break;
		default: // Provides default browser as chrome, if the parameter doesnt match the above
					// cases
			if (driver != null)
				driver = new ChromeDriver(options);
		}
		// Launch the browser with url from parameter and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		// Setting timeout from the parameter for both implicit and explicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		dWait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));

		// Entering username
		inputByXpath("//input[@id='username']", username, false);
		// Entering passowrd
		inputByXpath("//input[@id='password']", password, false);
		// Click on Login
		clickByXpath("//input[@id='Login']");
		// Invoking method to make sure the spinner is disappeared before perform next
		// actions
		waitForSpinner();
		// Click on waffle-icon to launch App menu
		clickByXpath("//button[@title='App Launcher']");
		waitForSpinner();
		// Click view all option to get full menu
		clickByXpath("//button[text()='View All']");
		waitForSpinner();
		// Click to navigate to Sales main page
		clickByXpath("//p[text()='Sales']/ancestor::a");
		waitForSpinner();
		// Click to navigate to Account option
		clickByXpath("//one-app-nav-bar-item-root[contains(@data-target-selection-name,'Account')]");
		waitForSpinner();
	}

	// Method to close the browser once the test is executed
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	// Using DataProvider annotation for data driven test using excel
	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {
		// Returns 2 dimension array based on the filename
		return ExcelIntegration.readExcel(fileName);
	}
}
