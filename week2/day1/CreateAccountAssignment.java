/*
 * Assignment Details:
 * A web page that contains various fields, dropdowns and buttons. Your task is to automate interactions with these
 * WebElement using Selenium WebDriver
 * 
 * Pseudo code
 * Initialize Selenium WebDriver and navigate to "http://leaftaps.com/opentaps/control/main"
 * Identify element locators --> preference to use "id" if available
 * Login with username and password --> Navigate to CRM/SFA page
 * Navigate to Accounts tab --> Create a new account
 * Verify the Title is as expected
 */

package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccountAssignment {

	public static void main(String[] args) {
		
		// generating unique id as account name can't be repeated
		double generateUniqueId = Math.random();
		
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

		// Getting UserName element
		WebElement userName = newChromeBrowser.findElement(By.id("username"));

		// Inputting UserName value
		userName.sendKeys("demosalesmanager");

		// Getting password element
		WebElement pwd = newChromeBrowser.findElement(By.id("password"));
		
		// Inputting password value		
		pwd.sendKeys("crmsfa");
		
		// Getting Login button element		
		WebElement submit = newChromeBrowser.findElement(By.className("decorativeSubmit"));
		
		// Clicking on Login button		
		submit.click();
		
		// Getting CRM/SFA link				
		WebElement crmSFA = newChromeBrowser.findElement(By.partialLinkText("CRM/SFA"));

		// Clicking on link
		crmSFA.click();
		
		// Getting accounts link				
		WebElement accounts = newChromeBrowser.findElement(By.partialLinkText("Accounts"));

		// Clicking Leads link
		accounts.click();
		
		// Getting Create Account link
		WebElement createAccount = newChromeBrowser.findElement(By.partialLinkText("Create Account"));

		// Clicking Leads link
		createAccount.click();
		
		// Getting account name input element
		WebElement accountName = newChromeBrowser.findElement(By.id("accountName"));
		
		// Entering Inputs
		accountName.sendKeys("Test"+generateUniqueId);
		
		// Getting description input element
		WebElement accountDescription = newChromeBrowser.findElement(By.name("description"));
		
		// Entering Inputs
		accountDescription.sendKeys("Selenium Automation Tester");
		
		// Getting Number of Employees input element
		WebElement numberOfEmployees = newChromeBrowser.findElement(By.id("numberEmployees"));
				
		// Entering Inputs
		numberOfEmployees.sendKeys("10");
		
		//officeSiteName
		// Getting Office Site input element
		WebElement siteName = newChromeBrowser.findElement(By.id("officeSiteName"));
				
		// Entering Inputs
		siteName.sendKeys("Leaftaps");
		
		// Getting Create Account submit button
		WebElement submitCreateAccount = newChromeBrowser.findElement(By.className("smallSubmit"));

		// Clicking to submit
		submitCreateAccount.click();
		
		// Getting the browser title	
		String browserTitle = newChromeBrowser.getTitle();
		
		// If block to verify whether the browser is on the right page
		if (browserTitle.equals("Account Details | opentaps CRM")) {
			System.out.println("Browser is currently in : "+browserTitle+" page, which is expected");
		}else {
			System.out.println("Browser is currently in : "+browserTitle+" page, which is NOT expected");
		}
		
		// Closing the current browser window
		newChromeBrowser.close();
		
	}

}
