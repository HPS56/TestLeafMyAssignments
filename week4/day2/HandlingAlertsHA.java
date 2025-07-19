/*
 * Automate the Leafground webpage to interact with a prompt dialog and perform actions using Selenium WebDriver
 * Psuedo Code:
 * 	Initialize ChromeDriver
 * 	Load the URL (https://www.leafground.com/alert.xhtml) & Maximize the browser window
 *	Use implict wait to handle loads, locate web element for prompt dialog and click
 *	Switch to alerts using Alert., enter the text in the prompt box and cancel the alert
 *	Print the text entered and confirmation message after dismissing the alert
 *	(//div[@class='card'])[5]/button
 *	
 */
package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingAlertsHA {

	public static void main(String[] args) {
		// Initialise ChromeOptions to pass arguments
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");

		// Getting new instance of the Chromedriver
		ChromeDriver newChromeBrowser = new ChromeDriver(options);

		// Launching url, refereshing and maximising window
		newChromeBrowser.get("https://www.leafground.com/alert.xhtml");
		// newChromeBrowser.navigate();
		newChromeBrowser.manage().window().maximize();

		// Adding ImplicitlyWait to driver instance
		newChromeBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Locating prompt dialog box button and performing actions to display alert box
		// with prompt
		newChromeBrowser.findElement(By.xpath("(//div[@class='card'])[5]/button")).click();

		// Switching to Alert and using alert Interface to handle alerts
		Alert promptAlert = newChromeBrowser.switchTo().alert();
		
		System.out.print("\nPrompt Message : ");
		System.out.println(promptAlert.getText()); // Printing Prompt Dialog Alert message
		System.out.println("\n---------------------------Alert Dismiss------------------------------------");
		// Alert actions to enter text and dismiss the alert
		promptAlert.sendKeys("Interacting with Prompt alert box");
		promptAlert.dismiss();
		System.out.println(newChromeBrowser.findElement(By.xpath("//span[@id='confirm_result']")).getText());

		// Repeating actions again to perform accept and print entered text
		newChromeBrowser.findElement(By.xpath("(//div[@class='card'])[5]/button")).click();
		promptAlert = newChromeBrowser.switchTo().alert();

		// Alert actions to enter text and accept the alert
		System.out.println("\n--------------------------Alert Accept-------------------------------------");
		promptAlert.sendKeys("Interacting with Prompt alert box");
		promptAlert.accept();

		// Confirming the action performed on the alert
		System.out.println(newChromeBrowser.findElement(By.xpath("//span[@id='confirm_result']")).getText());

		newChromeBrowser.quit(); // Closing driver instance

	}

}
