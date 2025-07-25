/*
 * Objective	:	Learn to automate interactions using Selenium WebDriver's Actions class to simulate mouse and keyboard actions
 * Details		:	Launch 'BigBasket' webpage, navigate to 'Boiled rice products' using mouse over menu
 * 					select 'Tamil Ponni Rice - 5kgs' pack and add to cart
 * 					print price and application successful msg
 * Psuedo Code	:
 * 					1.	Create a browser instance and launch 'BigBasket'
 * 					2.	Click 'Shop by Categoery'.
 * 					3.	Using action class Navigate to - > 'Foodgrains, Oil & Masala'
 * 					4.  -> 'Rice & Rice Products' -> 'Boiled & Steam Rice'
 * 					5.	Locate brand checkbok and select 'bb Royal' to filter
 * 					6.	Locate 'Tamil Ponni Boiled Rice' and peform click
 * 					7.	Get parent window id using getWindowHandle()
 * 					8.	Handle the new window using getWindowHandles.
 * 					9.	Select 5kg bag and add to cart
 * 					10.	Get the price, print price and successful msg from application
 */

package week5.day2.homeassignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassBigBasket {
	public void storeScreenShot(File file, String fileName) throws IOException {
		/*
		 * Reusable method to save screenshot in the project folder 
		 * Creates new / replace the existing file
		 * Accepts file and filename, paths are fixed to test objective
		 */
		String projectPath = System.getProperty("user.dir");
		File destFile = new File(projectPath + "/screenshots/bigbasket/" + fileName + ".png");
		destFile.getParentFile().mkdirs();
		FileUtils.copyFile(file, destFile);
		System.out.println(destFile.getAbsolutePath());
	}
	/*
	 * Reusable method to get web element 
	 * Accepts driver instance and xpath as string
	 * Returns a web element
	 */
	public WebElement getWebElement(ChromeDriver driver, String xPath) {
		return (driver.findElement(By.xpath(xPath)));
	}

	@Test
	public void runActionBigBasket() throws InterruptedException, IOException {
		// Instance for Chrome with options->guest & adding implicit wait
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("guest");
		ChromeDriver cDriver = new ChromeDriver(cOptions);
		cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Launching Amazon.in and setting window size -> Max
		cDriver.get("https://www.bigbasket.com/");
		cDriver.manage().window().maximize();

		Actions action = new Actions(cDriver);

		// Get WebElement->'Shop by Category' and perform actions
		WebElement shopByCat = getWebElement(cDriver,
				"(//div[@id='siteLayout']//button[contains(@id,'headlessui-menu-button')])[4]");
		action.moveToElement(shopByCat).pause(30).click().perform();
		Thread.sleep(2000); // To wait for menu load
		
		// Get WebElement to navigate -> foodgrains -> rice products -> boiled rice
		WebElement foodGrains = getWebElement(cDriver, "(//a[contains(text(),'Foodgrains')])[2]");
		action.moveToElement(foodGrains).pause(30).perform();
		Thread.sleep(2000); // To wait for menu load
		WebElement productRice = getWebElement(cDriver, "(//a[contains(text(),'Rice Products')])");
		action.moveToElement(productRice).pause(30).perform();
		Thread.sleep(2000); // To wait for menu load
		// Capturing screenshot of mouse over menu
		File sShotMouseOver = cDriver.getScreenshotAs(OutputType.FILE);
		storeScreenShot(sShotMouseOver, "bigBasketMouseOverMenu");
		WebElement boiledRice = getWebElement(cDriver, "(//a[contains(text(),'Boiled')])");
		action.moveToElement(boiledRice).pause(30).click().perform();

		// Locating check box to select brand as 'bb Royal'
		WebElement riceBrand = getWebElement(cDriver, "//input[@id='i-bbRoyal']");
		action.scrollToElement(riceBrand).pause(30).moveToElement(riceBrand).pause(30).click().perform();
		Thread.sleep(2000);

		// Assigning parent window id to change window controls
		String parentWindowId = cDriver.getWindowHandle();

		// Locating and clicking on 'Tamil Ponni Rice'
		WebElement tamilPonni = getWebElement(cDriver, "(//a[contains(@href,'Tamil+Ponni')])[2]");
		action.moveToElement(tamilPonni).pause(30).click().perform();
		// Capturing Screenshot of the product
		File sShotProduct = cDriver.getScreenshotAs(OutputType.FILE);
		storeScreenShot(sShotProduct, "bigBasketProduct");

		// Block to handle new window 
		Thread.sleep(2000); // To wait for windows to load
		Set<String> windows = cDriver.getWindowHandles();
		// Looping through set to get to child window
		for (String window : windows) {
			if (!parentWindowId.equals(window)) {
				cDriver.switchTo().window(window);
			}
		}
		
		// Locating element to select bag size as 5kg
		WebElement riceBag5 = getWebElement(cDriver, "(//span[text()='5 kg'])");
		action.moveToElement(riceBag5).pause(30).click().perform();

		// Adding the selected product to cart and getting a screenshot
		WebElement addToCart = getWebElement(cDriver, "(//button[text()='Add to basket'])[2]");
		action.scrollToElement(addToCart).pause(30).moveToElement(addToCart).pause(30).click().perform();
		Thread.sleep(2000);
		File sShotAddToCart = cDriver.getScreenshotAs(OutputType.FILE);
		storeScreenShot(sShotAddToCart, "bigBasketCart");

		// Getting webelemnts to print the successful msg and price
		WebElement confirmMsg = getWebElement(cDriver, "(//p[contains(@class,'flex')])[2]");
		System.out.println(confirmMsg.getText());
		WebElement price = getWebElement(cDriver, "(//td)[1]");
		System.out.println("Tamil Ponni Boiled Rice " + price.getText());

		cDriver.close(); // Closing Child window
		cDriver.quit();	// Closing main window

	}

}
