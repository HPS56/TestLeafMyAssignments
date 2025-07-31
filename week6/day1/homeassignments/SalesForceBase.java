package week6.day1.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
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
 * Parent Class for Salesforce application to hold re-usable methods and pre-conditions
 */

public class SalesForceBase {
	public RemoteWebDriver driver;
	public WebDriverWait dWait;
	public ChromeOptions options;

	public WebElement waitForElementToLoad(String Xpath) {// Explicit wait method to for presence and visibility of element
		return dWait.until(ExpectedConditions
				.visibilityOf(dWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)))));
	}

	public void getElementToInputByXpath(String xPath, String value) {// Method to input values
		// Calls to wait method and gets elements
		WebElement input = waitForElementToLoad(xPath);
		input.sendKeys(value);
	}

	public void getElementToClickByXpath(String xPath) {// Method to click
		WebElement button = waitForElementToLoad(xPath);
		// Using Action class to Scroll to Element to click
		Actions act = new Actions(driver);
		act.moveToElement(button).pause(30).click().perform();
	}

	public String getElementToGetTextByXpath(String xPath) {// Method to get text value
		WebElement element = waitForElementToLoad(xPath);
		return element.getText();
	}

	/* 
	 * Pre-Condition before the test steps are executed, using static parameter from TestNG to read values from testNG.xml
	 */
	@Parameters({ "url", "username", "password", "browser", "wait" })
	@BeforeMethod
	public void launchBrowser(String url, String username, String password, String browser, int wait) {
		options = new ChromeOptions();
		options.addArguments("guest");

		// To create requested instance of the browser, defaults to chrome if the options is not available.
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(options);
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			if (driver != null)
				driver = new ChromeDriver(options);
		}

		driver.get(url);
		driver.manage().window().maximize();
		// Using both implicit and explicit wait as the web app is not stable.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
		dWait = new WebDriverWait(driver, Duration.ofSeconds(wait));

		getElementToInputByXpath("//input[@id='username']", username);
		getElementToInputByXpath("//input[@id='password']", password);
		getElementToClickByXpath("//input[@id='Login']");

	}
	// Method to close the browser once the test is executed
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	// Method to return 2d array to perform data drive test
	@DataProvider(name = "getData")
	public String[][] setData() {
		String[][] parameters = new String[2][2];

		parameters[0][0] = "Hari";
		parameters[0][1] = "Salesforce force automation by Hari";

		parameters[1][0] = "Arun";
		parameters[1][1] = "Salesforce force automation by Arun";

		return parameters;

	}
}