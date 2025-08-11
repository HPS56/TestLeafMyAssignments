package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/*
 * Cucumber hooks, to handle setup and tear down for all tests
 */

public class Hooks {
	// Hooks Class variables to consume in step definitions
	public static WebDriver driver;
	public static WebDriverWait driverWait;
	
	@Before
	public void testSetUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		driver = new ChromeDriver(options);
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	@After
	public void testTearDown() {
		if (driver!=null) driver.quit();
		
	}

}
