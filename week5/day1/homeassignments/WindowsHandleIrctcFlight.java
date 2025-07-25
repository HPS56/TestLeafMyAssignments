/*
 * Objective: Automate interactions with a webpage, focusing on window handling, using Selenium WebDriver.
 * Assignment Detail: To nagivate to a page and open a new tab --> print the page title of the new tab and close the parent tab
 * Psuedo Code:
 * 	1. Get instance of a web driver, with options as guest
 * 	2. Launch the URL and Maximise the browser window
 * 	3. Locate Elements handle the confirmation pop-up
 * 	4. Locate flight booking link and perform click
 * 	5. Get the id of the parent window using getWindowHandle 
 * 	5. Use getWindowHandles to select identify the child window 
 * 	6. Print the child window title
 * 	7. Close the parent window by switching driver  
 */

package week5.day1.homeassignments;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowsHandleIrctcFlight {

	public static void main(String[] args) throws InterruptedException {
		// Initialise ChromeOptions to pass arguments to launch browser as guest
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");

		// Getting instance of Chrome driver & launching URL
		ChromeDriver newChromeBrowser = new ChromeDriver(options);
		newChromeBrowser.get("https://www.irctc.co.in/");
		// Maximising browser window and add implicitly wait
		newChromeBrowser.manage().window().maximize();
		newChromeBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(240));
		
		// Handling pop-up page
		newChromeBrowser.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		// Locating and clicking on the lookup icon to select contact
		newChromeBrowser.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
		
		Thread.sleep(2000); // To load the new window for Flights

		// Getting parent window id and all the windows ids
		String parentWindow = newChromeBrowser.getWindowHandle();
		Set<String> windows = newChromeBrowser.getWindowHandles();

		// Iterating through the ids and if its not matching with parent,
		// the drive is switched to the new window using id
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				newChromeBrowser.switchTo().window(window);
			}
		}
		
		// Printing the page title of the new child window opened for flight booking
		System.out.println("The title of the child window opened now is : "+newChromeBrowser.getTitle());

		// Switching to parent window to close and continue with flight booking.
		newChromeBrowser.switchTo().window(parentWindow).close();
		
		// Closing driver instance
		newChromeBrowser.quit();
		

	}

}
