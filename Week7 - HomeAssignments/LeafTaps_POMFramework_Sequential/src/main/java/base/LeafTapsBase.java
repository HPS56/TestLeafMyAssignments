package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/*
 * Base Class for LeafTaps to initialise WebDrivers, Options and Waits
 * Handles Pre and Post conditions for all test cases
 */

public class LeafTapsBase {

	public static WebDriver driver;
	public static WebDriverWait driverWait;

	@BeforeMethod
	public void setup() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("guest");
		driver = new ChromeDriver(chromeOptions);
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");

	}

	@AfterMethod
	public void teardown() {
		if (driver != null)
			driver.quit();

	}

}
