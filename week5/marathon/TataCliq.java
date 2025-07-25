/*
 * Marathon TestCase TataCliq : Validate whether the user is able to view the results for watches and verify the add product is in the cart
 * 	Psuedo Code:
 * 		1.	Navigate to TataCliq using get method of drive instance
 * 		2.	Locate Objects -> mouse over Brands -> Watches -> Featured Brand (click first brand on the list)
 * 		3.  Set Sort result by 'Newest Arrivals' using select
 * 		4.	Check Radio Button 'Men' to narrow down results for Men's Watches
 * 		5.	Get the list of web elements to print the price of all watches in the result page
 * 		6.	Iterate through the web elements and gettext to store prices in a array list
 * 		7.	Print the array list to display to the end user
 * 		8.	Get the location to choose the first product in the result page
 * 		9.	Get the parent window id using getWindowHandle, as the selected product opens in the new window
 * 		10.	Once the new Window is loaded, use getWindowHandles() to iterate and switchTo child window
 * 		11.	Get the price in the product page and compare with the price of the result page using get(index) from array list
 * 		12.	Confirm to user whether the price matches or not
 * 		13.	Get location to add the product to cart and confirm the count of item in cart to end user
 * 		14.	Get location of Cart and perform click, take a screenshot and print the path of the stored screenshot
 */
package week5.marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TataCliq {
	public void storeScreenShot(File file, String fileName) throws IOException {
		/*
		 * Reusable method to save screenshot in the project folder Creates new /
		 * replace the existing file Accepts file and filename, paths are fixed to test
		 * objective
		 */
		String projectPath = System.getProperty("user.dir");
		File destFile = new File(projectPath + "/screenshots/marathon/tatacliq/" + fileName + ".png");
		destFile.getParentFile().mkdirs();
		FileUtils.copyFile(file, destFile);
		System.out.println(destFile.getAbsolutePath());
	}

	/*
	 * Reusable method to get web element Accepts driver instance and xpath as
	 * string Returns a web element
	 */
	public WebElement getWebElement(ChromeDriver driver, String xPath) {
		return (driver.findElement(By.xpath(xPath)));
	}

	@Test
	public void runTataCliq() throws InterruptedException, IOException {
		// Instance for Chrome with options->guest & adding implicit wait
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("guest");
		ChromeDriver cDriver = new ChromeDriver(cOptions);
		cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Launching tatacliq and setting window size -> Max
		cDriver.get("https://www.tatacliq.com/");
		cDriver.manage().window().maximize();

		// Creating action class by passing driver
		Actions action = new Actions(cDriver);

		// Get WebElement to navigate to ->'Brand'->'Watches'->FeaturedBrand using action-> mouse over
		WebElement brands = getWebElement(cDriver, "//div[text()='Brands']");
		action.moveToElement(brands).pause(30).perform();
		Thread.sleep(2000); // wait to load
		WebElement watches = getWebElement(cDriver, "//div[text()='Watches & Accessories']");
		action.moveToElement(watches).pause(30).perform();
		Thread.sleep(2000); // wait to load
		WebElement featureBrand = getWebElement(cDriver, "//div[@class='DesktopHeader__featureBrands']/div[2]");
		action.moveToElement(featureBrand).pause(30).click().perform();
		Thread.sleep(2000); // wait to load

		// Passing the web element to select class to set drop down to 'New Arrivals'
		Select selectSort = new Select(getWebElement(cDriver, "//select[@class='SelectBoxDesktop__hideSelect']"));
		selectSort.selectByVisibleText("New Arrivals");
		Thread.sleep(2000);  // wait to load

		// Getting web element to select radio button 'Men'
		getWebElement(cDriver, "(//div[text()='Men'])[1]").click();
		Thread.sleep(2000); // wait to load

		// Getting List of web elements using contains xpath, store in arraly list and print
		List<WebElement> priceWebElements = cDriver
				.findElements(By.xpath("(//div[contains(@class,'ProductDescription__price')])//h3"));
		ArrayList<String> priceList = new ArrayList<String>();
		for (WebElement priceElement : priceWebElements) { // Iterating each element to add price in array list
			priceList.add(priceElement.getText());
		}
		System.out.println("The price of all the watches with set criteria are : \n" + priceList);

		String parentWindow = cDriver.getWindowHandle(); // Getting parent window id 

		// Selecting first product from the list and getting all window ids to switch to child window
		getWebElement(cDriver, "(//div[@class='PlpComponent__base'])[1]").click();
		Thread.sleep(2000);
		Set<String> browserWindows = cDriver.getWindowHandles();
		for (String window : browserWindows) {	// 
			if (!parentWindow.equals(window))
				cDriver.switchTo().window(window);
		}

		String priceProductPage = getWebElement(cDriver, "(//div[@class='ProductDetailsMainCard__price']/h3)").getText()
				.replaceAll("[^0-9]", "");
		String priceResultPage = priceList.get(0).replaceAll("[^0-9]", "");

		if (priceProductPage.equals(priceResultPage)) {
			System.out.println("The price on the product page matches the result page");
		} else {
			System.out.println("The price on the product page doesnt matches the result page");
		}

		getWebElement(cDriver, "//span[text()='ADD TO BAG']").click();

		System.out.println("The count of Items in Cart is : "
				+ getWebElement(cDriver, "//span[@class='DesktopHeader__cartCount']").getText());

		getWebElement(cDriver, "//div[@class='DesktopHeader__myBagShow']").click();

		Thread.sleep(2000);
		File screenShot = cDriver.getScreenshotAs(OutputType.FILE);
		storeScreenShot(screenShot, "tataCliqCart");

		for (String window : browserWindows) {
			cDriver.switchTo().window(window).close();
		}

	}

}
