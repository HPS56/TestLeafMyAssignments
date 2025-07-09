package week3.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BreakoutAdvancedXPath {

	public static void main(String[] args) {
		// Initialise ChromeOptions to pass arguments
		ChromeOptions options = new ChromeOptions();
		
		// Passing argument guest to disable alerts during automation
		options.addArguments("guest");										
		
		// Getting new instance of the Chrome driver
		ChromeDriver newChromeBrowser = new ChromeDriver(options);
		
		// Launching Leaftap url
		newChromeBrowser.get("http://leaftaps.com/opentaps/control/main");
		
		// Maximising browser window
		newChromeBrowser.manage().window().maximize();
		newChromeBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Getting UserName element
		WebElement userName = newChromeBrowser.findElement(By.xpath("//label[text()='Username']/following-sibling::input"));

		// Inputting UserName value
		userName.sendKeys("demosalesmanager");

		// Getting password element
		WebElement pwd = newChromeBrowser.findElement(By.xpath("//input[@id='username']/following::input"));
		
		// Inputting password value		
		pwd.sendKeys("crmsfa");
		
		// Getting Login button element		
		WebElement submit = newChromeBrowser.findElement(By.xpath("//input[@id='username']/parent::p/following::input[2]"));
		submit.click();

	}

}
