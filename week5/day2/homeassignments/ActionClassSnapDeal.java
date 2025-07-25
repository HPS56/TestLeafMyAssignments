/*
 * Objective	:	Learn to automate interactions using Selenium WebDriver's Actions class to simulate mouse and keyboard actions
 * Details		:	Launch 'SnapDeal' website, navigate to 'Sports Shoes' using mouse over menu
 * 					select 'Training Shoes', sort by price Low to High and validate whether the results are sorted
 * 					set the price slider, View the first product from the result and print price and discount 
 * Psuedo Code	:
 * 					1.	Create a browser instance and launch 'SnapDeal'
 * 					2.	Use Action Class to mouse over and navigate to 'mens Fashion'->'Sports Shoe'
 * 					3.	Sort by Price Low to High by locating the list
 * 					4.  Get all the results price and compare to see if the price are higher than the previous
 * 					5.	Locate the slider (left and right), use 'movetooffset' to set a price range
 * 					6.	Mouse over the first result in the result page and click on 'Quick View'
 * 					7.	Print the cost and discount price
 * 					8.	Take screenshot of the 'Quick View' page
 * 					9.	Close the browser
 */

package week5.day2.homeassignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassSnapDeal {
	public void storeScreenShot(File file, String fileName) throws IOException {
		/*
		 * Reusable method to save screenshot in the project folder Creates new /
		 * replace the existing file Accepts file and filename, paths are fixed to test
		 * objective
		 */
		String projectPath = System.getProperty("user.dir");
		File destFile = new File(projectPath + "/screenshots/snapdeal/" + fileName + ".png");
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
	public void runActionSanpDeal() throws InterruptedException, IOException {
		// Instance for Chrome with options->guest & adding implicit wait
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("guest");
		ChromeDriver cDriver = new ChromeDriver(cOptions);
		cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Launching snapdeal and setting window size -> Max
		cDriver.get("https://www.snapdeal.com/");
		cDriver.manage().window().maximize();

		Actions action = new Actions(cDriver);

		// Get WebElement->'Men Fashion' and then 'Sports Shoes' to perform Clcik
		WebElement menFashion = getWebElement(cDriver, "(//span[contains(text(),'Fashion')])[1]");
		action.moveToElement(menFashion).pause(30).perform();
		Thread.sleep(2000); // To wait for menu load
		WebElement sportShoes = getWebElement(cDriver, "(//span[contains(text(),'Sports Shoes')])[1]");
		action.moveToElement(sportShoes).pause(30).click().perform();

		// Get WebElement-> to print the total results
		WebElement shoesCount = getWebElement(cDriver, "//span[@class='category-name category-count']");
		// using regular expression to print only the numbers
		System.out.println("Total no of results : " + shoesCount.getText().replaceAll("[^0-9]", ""));

		// Get WebElement -> to get Training Shoes, set sort by - Price low to high
		WebElement trainingShoes = getWebElement(cDriver, "//div[text()='Training Shoes']");
		trainingShoes.click();
		WebElement sortList = getWebElement(cDriver, "//div[@class='sort-drop clearfix']");
		sortList.click();
		WebElement sortPriceLTH = getWebElement(cDriver, "//li[@data-sorttype='plth']");
		sortPriceLTH.click();

		// Getting the elements for all price returned as part of result to validate
		// whether its sorted as expected
		List<WebElement> priceElements = cDriver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		int prePrice = 0, nextPrice; // Variables to hold price value
		boolean priceSortedLTH = true; // Assumming the results are sorted from price Low to High
		for (WebElement priceElement : priceElements) {
			
			// Getting numbers only and storing as int to compare
			nextPrice = Integer.parseInt(priceElement.getText().replaceAll("[^0-9]", "")); 
			
			// Checking whether the price of each element is either higher or equal to the previous
			if (!(nextPrice >= prePrice)) {
				priceSortedLTH = false;	// Setting flag as false if the price is not higher or same
				break;
			}
			prePrice = nextPrice; // switching the values for next iteration
		}
		
		if (priceSortedLTH) {
			System.out.println("The results are sorted by price Low to High");
		}else {
			System.out.println("The results are Not sorted by price Low to High");
		}

		// Get WebElement for left and righ Price slide controls -> to move right and left using action class  
		WebElement priceSliderLeft = getWebElement(cDriver, "(//a[contains(@class,'price-slider-scroll')])[1]");
		action.clickAndHold(priceSliderLeft).moveByOffset(2, 0).release().perform();
		Thread.sleep(2000); // Using sleep for page load
		WebElement priceSliderright = getWebElement(cDriver, "(//a[contains(@class,'price-slider-scroll')])[2]");
		action.clickAndHold(priceSliderright).moveByOffset(-251, 0).release().perform();
		Thread.sleep(2000); // Using sleep for page load
		
		// Getting the first product from the result -> to perform 'quick view'
		WebElement product = getWebElement(cDriver, "(//div[contains(@class,'product-tuple-listing')])//a[1]");
		action.moveToElement(product).pause(30).perform();
		Thread.sleep(2000); // Using sleep for page load
		WebElement quickView = getWebElement(cDriver, "(//div[contains(text(),'Quick View')])");
		action.moveToElement(quickView).pause(30).click().perform();
		Thread.sleep(2000); // Using sleep for page load

		// Getting ScreenGrab of the Product
		File screenShot = cDriver.getScreenshotAs(OutputType.FILE);
		storeScreenShot(screenShot, "snapdealProduct");

		// Printing Price and discount details of the product
		System.out.println("The price of the product is : "+cDriver.findElement(By.xpath("(//span[@class='payBlkBig'])")).getText());
		System.out.println("The discount for the product is : "+cDriver.findElement(By.xpath("(//span[contains(@class,'percent-desc')])")).getText());

		cDriver.quit(); // Closing Browser

	}
}