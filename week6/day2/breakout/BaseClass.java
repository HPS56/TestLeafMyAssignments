package week6.day2.breakout;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
	public String fileName;
	public RemoteWebDriver driver;

	@Parameters({ "url", "uName", "pWord", "browser" })
	@BeforeMethod
	public void preCondition(String url, String uName, String pWord, String browser) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(option);
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			if (driver != null)
				driver = new ChromeDriver(option);
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

	}

	@AfterMethod
	public void postCondition() {
		driver.quit();
	}

	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {

		return ReadExcelIntegration.readExcel(fileName);

	}
}
