package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateFacebookLogin {

	public static void main(String[] args) {
		// Getting new instance of the Chrome driver
		ChromeDriver newChromeBrowser = new ChromeDriver();
		
		// Launching facebook url
		newChromeBrowser.get("https://www.facebook.com/");
		
		// Maximising browser window
		newChromeBrowser.manage().window().maximize();

		// Getting UserName element
		WebElement userName = newChromeBrowser.findElement(By.id("email"));

		// Inputting UserName value
		userName.sendKeys("testleaf.2023@gmail.com");

		// Getting password element
		WebElement pwd = newChromeBrowser.findElement(By.name("pass"));
		
		// Inputting password value		
		pwd.sendKeys("Tuna@321");
		
		// Getting Login button element		
		WebElement submit = newChromeBrowser.findElement(By.name("login"));
		
		// Clicking on Login button		
		submit.click();
		
		// Getting Find Your Account and Login link				
		WebElement findYourAccount = newChromeBrowser.findElement(By.partialLinkText("Find your account and log in."));

		// Clicking on  Find Your Account and Login link
		findYourAccount.click();
		
		// Getting the browser title	
		String browserTitle = newChromeBrowser.getTitle();
		
		// If block to verify whether the browser is on the right page
		if (browserTitle.equals("Forgotten Password | Can't Log In | Facebook")) {
			System.out.println("Browser is currently in : "+browserTitle+" page, which is expected");
		}else {
			System.out.println("Browser is currently in : "+browserTitle+" page, which is NOT expected");
		}
		
		// Closing the current browser window
		newChromeBrowser.close();
		
	}

}
