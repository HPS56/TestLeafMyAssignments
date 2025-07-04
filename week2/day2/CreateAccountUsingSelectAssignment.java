/*
 * Assignment Details:
 * A web page that contains various fields, dropdowns and buttons. Your task is to automate interactions with these WebElement using Selenium WebDriver
 * 
 * Pseudo code
 * Initialize Selenium WebDriver and navigate to "http://leaftaps.com/opentaps/control/main"
 * Identify element locators --> preference to use "id" if available
 * Login with username and password --> Navigate to CRM/SFA page
 * Navigate to Accounts tab --> Create a new account
 * Identify select dropdown webelement and use different technique select value
 * Create an account
 * Verify the account name is as expected
 */

package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountUsingSelectAssignment {

	public static void main(String[] args) {
		// generating unique id as account name can't be repeated
		String accountName = "Test"+ Math.random();
		
		// Initialise ChromeOptions to pass arguments
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");										
		
		// Getting new instance of the Chromedriver
		ChromeDriver newChromeBrowser = new ChromeDriver(options);
		
		// Launching Leaftap url and maximising window
		newChromeBrowser.get("http://leaftaps.com/opentaps/control/main");
		newChromeBrowser.manage().window().maximize();

		// Getting elements to key in values for login page and submission 
		WebElement userName = newChromeBrowser.findElement(By.id("username"));
		userName.sendKeys("demosalesmanager");
		WebElement pwd = newChromeBrowser.findElement(By.id("password"));
		pwd.sendKeys("crmsfa");
		WebElement submit = newChromeBrowser.findElement(By.className("decorativeSubmit"));
		submit.click();
		
		// Getting CRM/SFA link	and navigating to CRM page		
		WebElement crmSFA = newChromeBrowser.findElement(By.partialLinkText("CRM/SFA"));
		crmSFA.click();
		
		// Getting accounts link and navigating to account main page
		WebElement accounts = newChromeBrowser.findElement(By.partialLinkText("Accounts"));
		accounts.click();
		
		// Getting Create Account and navigating to account creation page
		WebElement createAccount = newChromeBrowser.findElement(By.partialLinkText("Create Account"));
		createAccount.click();
		
		// Getting account name input element
		WebElement accName = newChromeBrowser.findElement(By.id("accountName"));
		accName.sendKeys(accountName);
		
		// Getting elements to key in values for account creation and submission
		WebElement accountDescription = newChromeBrowser.findElement(By.name("description"));
		accountDescription.sendKeys("Selenium Automation Tester");
		WebElement numberOfEmployees = newChromeBrowser.findElement(By.id("numberEmployees"));
		numberOfEmployees.sendKeys("10");
		WebElement siteName = newChromeBrowser.findElement(By.id("officeSiteName"));
		siteName.sendKeys("Leaftaps");
		
		// Identifying Industry drop down using name attribute and selecting using Index
		WebElement industryDD = newChromeBrowser.findElement(By.name("industryEnumId"));
		Select selectIndustryDD = new Select(industryDD);
		selectIndustryDD.selectByIndex(2);
		
		// Identifying Ownership drop down using name attribute and selecting using Visible Text		
		WebElement owneshipDD = newChromeBrowser.findElement(By.name("ownershipEnumId"));
		Select selectOwnershipDD = new Select(owneshipDD);
		selectOwnershipDD.selectByVisibleText("S-Corporation");
		
		// Identifying Source drop down using id attribute and selecting using Value		
		WebElement sourceDD = newChromeBrowser.findElement(By.id("dataSourceId"));
		Select selectSourceDD = new Select(sourceDD);
		selectSourceDD.selectByValue("LEAD_EMPLOYEE");

		// Identifying Marketing Campaign drop down using id attribute and selecting using Index		
		WebElement marketingCampaignDD = newChromeBrowser.findElement(By.id("marketingCampaignId"));
		Select selectmarketingDD = new Select(marketingCampaignDD);
		selectmarketingDD.selectByIndex(6);
		
		// Identifying Marketing Campaign drop down using id attribute and selecting using Index		
		WebElement stateDD = newChromeBrowser.findElement(By.id("generalStateProvinceGeoId"));
		Select selectStateDD = new Select(stateDD);
		selectStateDD.selectByValue("TX");
		
		//Getting Create Account submit button
		WebElement submitCreateAccount = newChromeBrowser.findElement(By.className("smallSubmit"));
		submitCreateAccount.click();
		
		// Getting account name to validate using xpath
		WebElement getAccountName = newChromeBrowser.findElement(By.xpath("//span[text()='Account Name']/ancestor::td/following-sibling::td/span"));
		String actualAccountName = getAccountName.getText();
		
		// If block to verify whether the browser is on the right page
		if (actualAccountName.contains(accountName)) {
			System.out.println("Account Name is matching, Expected : "+accountName+ " Actual : "+actualAccountName);
		}else {
			System.out.println("Account Name is NOT matching, Expected : "+accountName+ " Actual : "+actualAccountName);
		}
		
		// Closing the current browser window
		newChromeBrowser.close();

	}

}
