/*
 * Objective	:	Learn to automate interactions using Selenium WebDriver's Actions class to simulate mouse and keyboard actions
 * Details		:	Launch Amazon website and search for 'oneplus 13s', get the price of the first product result, print details
 * 					and verify the price. use the action class to navigate and take screenshot
 * Psuedo Code	:
 * 					1.	Create a browser instance and launch 'Amazon.in'
 * 					2.	Search for 'oneplus 9 pro' and get the first result
 * 					3.	Using action class, get customer rating, click on the first link text
 * 					4.	Take screen shot and add the product to cart
 * 					5.	Validate the cart total is correct and close the browser instance
 */

package week5.day2.homeassignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassAmazon {
	public void storeScreenShot(File file,String fileName) throws IOException {
		/*
		 * Reusable method to save screenshot in the project folder
		 * Creates new / replace the existing file
		 * Accepts file and filename, paths are fixed to test objective
		 */
		String projectPath = System.getProperty("user.dir");
		File destFile = new File(projectPath + "/screenshots/amazon/"+fileName+".png");
		destFile.getParentFile().mkdirs();
		FileUtils.copyFile(file, destFile);
		System.out.println(destFile.getAbsolutePath());
	}

	@Test
	public void runActionClassAmazon() throws InterruptedException, IOException {

		// Creating new driver instance for Chrome with options -> guest and adding
		// implicit wait
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("guest");
		ChromeDriver cDriver = new ChromeDriver(cOptions);
		cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Launching Amazon.in and setting window size -> Max
		cDriver.get("https://www.amazon.in/");
		cDriver.manage().window().maximize();

		// Locating search input, to enter -> print the price of first result
		cDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 13s", Keys.ENTER);
		String price = cDriver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("The price of the mobile is : " + price);

		File screenShot = cDriver.getScreenshotAs(OutputType.FILE);
		storeScreenShot(screenShot, "amazon_product");
		
		// Using action class to perform user actions
		Actions action = new Actions(cDriver);

		// Mouse hover action to diplay review and print
		WebElement review = cDriver.findElement(By.xpath("//i[contains(@class,'a-icon a-icon-star-small')]"));
		action.moveToElement(review).click().perform();
		System.out.println("Average review for this product : "
				+ cDriver.findElement(By.xpath("//h2[@id='acr-popover-title']")).getText());
		System.out.println("Total # of customer reviews : "
				+ cDriver.findElement(By.xpath("//span[contains(text(),'ratings')]")).getText());

		Thread.sleep(3000); // Using sleep to get view of action above

		// Locating first text link associate to img to click
		WebElement productImg = cDriver.findElement(By.xpath("//img[@class='s-image']/ancestor::a"));
		action.moveToElement(productImg).click().perform();

		// Locating add cart and processing it
		WebElement addCart = cDriver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
		action.moveToElement(addCart).click().perform();

		// Get Cart total to check against product price
		String cartPrice = cDriver.findElement(By.xpath("//div[@id='sw-subtotal']//span[@class='a-price-whole']"))
				.getText();

		if (cartPrice.equals(price)) {
			System.out.println("The product price and cart total is correct");
		} else {
			System.out.println("The product price and cart total is incorrect");

		}

		cDriver.quit(); // Closing driver instance

	}

}
