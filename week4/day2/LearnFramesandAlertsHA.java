/*
 * Automate interactions with frames, trigger alerts, and verify the displayed text based on actions using 
 * Selenium WebDriver on the given application
 * Psuedo Code:
 * 	1. Create instance of chrome driver and launch the given URL
 * 	2. Check for iframe use in the webpage and switch to iframe using Alerts
 * 	3. Perform click action and validate whether the event has been registered by printing message 
 */
package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnFramesandAlertsHA {

	public static void main(String[] args) {
		// Initialise ChromeOptions to pass arguments
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");

		// Getting new instance of the Chromedriver
		ChromeDriver newChromeBrowser = new ChromeDriver(options);

		// Launching url, refereshing and maximising window
		newChromeBrowser.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		newChromeBrowser.navigate();
		newChromeBrowser.manage().window().maximize();

		// Adding ImplicitlyWait to driver instance
		newChromeBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// switching to iframe using id / name
		newChromeBrowser.switchTo().frame("iframeResult");

		// Clicking button 'Try it'
		newChromeBrowser.findElement(By.xpath("//button[text()='Try it']")).click();

		// Switching to alert to handle
		Alert alert = newChromeBrowser.switchTo().alert();
		// accepting alert
		alert.accept();
		// printing the message displayed after accepting
		System.out.println("Message after accepting alert : " + newChromeBrowser.findElement(By.id("demo")).getText());

		// Code to perform dismiss on alert and printing the message
		newChromeBrowser.findElement(By.xpath("//button[text()='Try it']")).click();
		alert.dismiss();
		System.out.println("Message after dismissing alert : " + newChromeBrowser.findElement(By.id("demo")).getText());

		// closing driver
		newChromeBrowser.quit();

	}

}
