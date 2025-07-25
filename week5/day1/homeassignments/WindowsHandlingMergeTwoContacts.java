/*
 * Objective: Automate interactions with a webpage, focusing on window handling, using Selenium WebDriver.
 * Assignment Detail: To merge two contacts in Leaftap CRM application
 * Psuedo Code:
 * 	1. Get instance of a web driver, with options as guest
 * 	2. Launch the URL and Maximise the browser window
 * 	3. Locate Elements to enter username and password
 * 	4. Navigate to Merge Contacts page
 * 	5. Get the id of the parent window using getWindowHandle 
 * 	5. Use getWindowHandles to select the contacts which needs to be merged
 * 	6. Merge the contacts and print the title page after the merge is performed  
 */

package week5.day1.homeassignments;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowsHandlingMergeTwoContacts {

	public static void main(String[] args) throws InterruptedException {
		// Initialise ChromeOptions to pass arguments to launch browser as guest
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");

		// Getting instance of Chrome driver & launching URL
		ChromeDriver newChromeBrowser = new ChromeDriver(options);
		newChromeBrowser.get("http://leaftaps.com/opentaps/control/main");
		// Maximising browser window
		newChromeBrowser.manage().window().maximize();

		// Getting elements and entering username/password
		newChromeBrowser.findElement(By.id("username")).sendKeys("DemoCSR2");
		newChromeBrowser.findElement(By.id("password")).sendKeys("crmsfa");

		// Getting Login button element and perform click
		newChromeBrowser.findElement(By.className("decorativeSubmit")).click();

		// Getting CRM/SFA link to navigate to main page
		newChromeBrowser.findElement(By.partialLinkText("CRM/SFA")).click();

		// Navigate to contacts page
		newChromeBrowser.findElement(By.xpath("//a[text()='Contacts']")).click();

		// Locate Merge Contact and perform Click
		newChromeBrowser.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Storing the id of the parent window to switch later
		String parentWindow = newChromeBrowser.getWindowHandle();

		// Locating and clicking on the lookup icon to select contact
		newChromeBrowser.findElement(By.xpath("(//tbody//img)[1]")).click();
		Thread.sleep(2000); // To load the new window for lookup

		// Getting all the windows id to handle the child window (lookup)
		Set<String> windows = newChromeBrowser.getWindowHandles();

		// Iterating through the ids and if its not matching with parent, the drive is
		// switched to the new window using id
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				newChromeBrowser.switchTo().window(window);
			}
		}
		// Selecting the first contact listed in the table
		newChromeBrowser.findElement(By.xpath("(//tbody)[3]//a")).click();

		// Assigning control back to the parent window to select 2nd contact
		newChromeBrowser.switchTo().window(parentWindow);

		// Repeating the above step for 2nd contact selection
		newChromeBrowser.findElement(By.xpath("(//tbody//img)[2]")).click();
		Thread.sleep(2000);
		windows = newChromeBrowser.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				newChromeBrowser.switchTo().window(window);
			}
		}
		newChromeBrowser.findElement(By.xpath("(//tbody)[4]//a")).click();
		newChromeBrowser.switchTo().window(parentWindow);

		// Performing the merge of select contacts
		newChromeBrowser.findElement(By.xpath("//a[text()='Merge']")).click();

		// Getting the alert and accepting it to process merge
		Alert mergeAlert = newChromeBrowser.switchTo().alert();
		mergeAlert.accept();

		Thread.sleep(2000); // To allow for merge process

		// Getting the page title and checking if the merge is successful or not to
		// confirm to end user
		String pageTitle = newChromeBrowser.getTitle();
		if (pageTitle.equals("View Contact | opentaps CRM")) {
			System.out.println("Mege is successful and curent browser page is : " + pageTitle);
		} else {
			System.out.println("Mege is NOY successful and curent browser page is : " + pageTitle);
		}

		newChromeBrowser.quit(); // Closing browser

	}

}
