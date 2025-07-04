package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWithCheckBoxAssignment {

	// Creating a method to get web elements by passing web driver and xpath
	public static WebElement GetWebElementByXpath (WebDriver webDriverName, String xPath ){
		
		WebElement getWebElement = webDriverName.findElement(By.xpath(xPath));
		return getWebElement;
	}
	
	// Creating a method to get notification about state change for different checkbox types
	public static void GetNotification (WebDriver webDriverName,String checkBoxName ){
		
		String xPathSpan = "//div[contains(@class,'ui-growl-message')]//span";
		String xPathPara = "//div[contains(@class,'ui-growl-message')]//p";
		
		// Using Web Driver Wait to validate whether the notification is triggered and visible
		WebDriverWait wait = new WebDriverWait(webDriverName, Duration.ofSeconds(10));
		WebElement notification = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathSpan)));
		WebElement status = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathPara)));
		System.out.println(checkBoxName+" : " + notification.getText() +" "+status.getText());
		
		// Wait to validate the notification is disabled, to avoid overlapping notification
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPathSpan)));
	}

	public static void main(String[] args) {

		// Initialise ChromeOptions to pass arguments
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");

		// Getting new instance of the Chromedriver
		ChromeDriver newChromeBrowser = new ChromeDriver(options);

		// Launching Leaftap url and maximising window
		newChromeBrowser.get("https://leafground.com/checkbox.xhtml");
		newChromeBrowser.manage().window().maximize();
		
		// Clicking Basic Checkbox using xpath accessing span element
		WebElement basicCheckBox = GetWebElementByXpath(newChromeBrowser,"//span[text()='Basic']");
		basicCheckBox.click();

		// Clicking Ajax Checkbox using xpath accessing span element
		WebElement ajaxCheckBox = GetWebElementByXpath(newChromeBrowser,"//span[text()='Ajax']");
		ajaxCheckBox.click();
		
		// Getting notification on the state of the checkbox after its clicked
		GetNotification(newChromeBrowser, "Ajax CheckBox");

		// Clicking Lanugage Checkboxes using xpath accessing label element
		WebElement languageJava = GetWebElementByXpath(newChromeBrowser,"//label[text()='Java']");
		languageJava.click();
		WebElement languagePython = GetWebElementByXpath(newChromeBrowser,"//label[text()='Python']");
		languagePython.click();
		WebElement languageJavaScript = GetWebElementByXpath(newChromeBrowser,"//label[text()='Javascript']");
		languageJavaScript.click();
		WebElement languageCSharp = GetWebElementByXpath(newChromeBrowser,"//label[text()='C-Sharp']");
		languageCSharp.click();
		WebElement languageOthers = GetWebElementByXpath(newChromeBrowser,"//label[text()='Others']");
		languageOthers.click();
		
		// Clicking TriState Checkbox using xpath accessing div element containing data-iconstates attribute and printing different state
		WebElement ajaxTriState = GetWebElementByXpath(newChromeBrowser,"//div[contains(@data-iconstates, 'closethick')]");
		ajaxTriState.click();
		GetNotification(newChromeBrowser, "TriState Checkbox");
		ajaxTriState.click();
		GetNotification(newChromeBrowser, "TriState Checkbox");

		// Clicking Toggle Checkbox using xpath accessing div element and printing state
		WebElement toggleSwitch = GetWebElementByXpath(newChromeBrowser,"//div[contains(@class, 'toggleswitch-slider')]");
		toggleSwitch.click();
		GetNotification(newChromeBrowser, "Toggle CheckBox");
		
		// Checking for disabled checkbox using xpath accessing disabled attribute
		WebElement disabledCheckbox = GetWebElementByXpath(newChromeBrowser,"//span[text()='Disabled']/parent::div//input");
		System.out.println("Is there a checkbox disabled : "+disabledCheckbox.getAttribute("disabled"));

		// Clicking multicheckbox to enable visibility of the checkboxes
		WebElement multiCheckBox = GetWebElementByXpath(newChromeBrowser,"//ul[@data-label='Cities']");
		multiCheckBox.click();
		
		// Clicking multicheckbox to using Xpath accessing data-item-value attribute		
		WebElement labelMiami = GetWebElementByXpath(newChromeBrowser,"//li[@data-item-value='Miami']/div");
		labelMiami.click();
		
		//Closing browser instance 
		newChromeBrowser.close();
				
	}

}
