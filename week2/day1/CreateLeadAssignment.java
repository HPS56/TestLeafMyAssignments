package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadAssignment {

	public static void main(String[] args) {

			// Initialise ChromeOptions to pass arguments to launch browser as guest
			ChromeOptions options = new ChromeOptions();
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
			
			// Getting Leads link				
			WebElement leads = newChromeBrowser.findElement(By.partialLinkText("Leads"));

			// Clicking Leads link
			leads.click();
			
			// Getting Create Leads link				
			WebElement createLeads = newChromeBrowser.findElement(By.partialLinkText("Create Lead"));

			// Clicking on Create Leads link
			createLeads.click();

			// Locating Company Name and inputting values
			WebElement companyName = newChromeBrowser.findElement(By.id("createLeadForm_companyName"));
			companyName.sendKeys("TestLeaf");

			// Locating First Name and inputting values			
			WebElement firstName = newChromeBrowser.findElement(By.id("createLeadForm_firstName"));
			firstName.sendKeys("Harikumar");
			
			// Locating Last Name and inputting values
			WebElement lastName = newChromeBrowser.findElement(By.id("createLeadForm_lastName"));
			lastName.sendKeys("P");
			
			// Instantiating select with dropdown web element for Source
			Select sourceDropDown = new Select(newChromeBrowser.findElement(By.id("createLeadForm_dataSourceId")));
			
			// selecting Employee by Index
			sourceDropDown.selectByIndex(4);
			
			// Instantiating select with dropdown web element for Marketing Campaign			
			Select mcDropDown = new Select(newChromeBrowser.findElement(By.id("createLeadForm_marketingCampaignId")));

			// selecting Automobile by visible text
			mcDropDown.selectByVisibleText("Automobile");
			
			// Instantiating select with dropdown web element for Ownership			
			Select ownershipDropDown = new Select(newChromeBrowser.findElement(By.id("createLeadForm_ownershipEnumId")));
			
			// selecting Employee by Value (option)
			ownershipDropDown.selectByValue("OWN_CCORP");
			
			//Getting element to submit the details
			WebElement submitBtn = newChromeBrowser.findElement(By.className("smallSubmit"));
			submitBtn.click();
			
			// Getting the browser title	
			String browserTitle = newChromeBrowser.getTitle();

			// If block to verify whether the browser is on the right page
			if (browserTitle.equals("View Lead | opentaps CRM")) {
				System.out.println("Browser is currently in : "+browserTitle+" page, which is expected");
			}else {
				System.out.println("Browser is currently in : "+browserTitle+" page, which is NOT expected");
			}
			
			// Closing the current browser window
			newChromeBrowser.close();
	}

}
