package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FacebookCreateNewAccountAssignment {
	
	public static void main(String[] args) {
		
		// Initialise ChromeOptions to pass arguments
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");										
		
		// Getting new instance of the Chromedriver
		ChromeDriver newChromeBrowser = new ChromeDriver(options);
		
		// Launching Leaftap url and maximising window
		newChromeBrowser.get("https://en-gb.facebook.com/");
		newChromeBrowser.manage().window().maximize();

		// Getting elements navigate to create new account page 
		WebElement submit = newChromeBrowser.findElement(By.xpath("//a[text()='Create new account']"));
		submit.click();
		
		// Identify elements to successfully create new account 
		
		WebElement firstName = newChromeBrowser.findElement(By.name("firstname"));						
		firstName.sendKeys("Harikumar");
		
		WebElement surName = newChromeBrowser.findElement(By.name("lastname"));
		surName.sendKeys("Panneer Selvam");
		
		WebElement dayDropDown = newChromeBrowser.findElement(By.id("day"));
		Select selectDayDD = new Select(dayDropDown);
		selectDayDD.selectByValue("1");
		
		WebElement monthDropDown = newChromeBrowser.findElement(By.id("month"));
		Select SelectMonthDD = new Select(monthDropDown);
		SelectMonthDD.selectByValue("1");
		
		WebElement yearDropDown = newChromeBrowser.findElement(By.id("year"));
		Select selectYearDD = new Select(yearDropDown);
		selectYearDD.selectByValue("2000");
		
		WebElement sexMale = newChromeBrowser.findElement(By.xpath("//label[text()='Male']//input"));
		sexMale.click();
		
		WebElement mobileNumber = newChromeBrowser.findElement(By.name("reg_email__"));
		mobileNumber.sendKeys("7777777777");
		
		WebElement password = newChromeBrowser.findElement(By.id("password_step_input"));
		password.sendKeys("p@ssW@rd#$2025");
		
		WebElement pageSubmit = newChromeBrowser.findElement(By.name("websubmit"));
		pageSubmit.click();
		
		newChromeBrowser.close();
		
	}

}
