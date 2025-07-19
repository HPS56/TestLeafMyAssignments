/*
 * Automate the process of searching for men's fashion bags on the Ajio website
 * Apply specific filters, and gather information including the count of items found,
 * list of brands, and the list of product names
 * Psuedo Code:
 * 	1.Create a instance of chrome web driver and use implicitly wait
 * 	2.Perform browser action using selenium methods to get results for Mens Fashion Bags
 * 	3.Print the number of results found
 * 	4.Use WebElments to get the results found
 * 	5.Use List interface to store the list of brands and bag names from the result
 * 	6.Print the results to the end user 
 * 
 */
package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplementListInterfaceHomeAssignment {

	public static void main(String[] args) throws InterruptedException {
		final int wait=4000;
		// Initialise ChromeOptions to pass arguments as guest
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");

		// Getting new instance of the Chromedriver
		ChromeDriver newChromeBrowser = new ChromeDriver();

		// Launching myntra (ajio not working) and maximising window
		newChromeBrowser.get("https://www.myntra.com/");
		newChromeBrowser.manage().window().maximize();

		// Adding ImplicitlyWait to driver instance
		newChromeBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebDriverWait driverWait = new WebDriverWait(newChromeBrowser, Duration.ofSeconds(60));

		// newChromeBrowser.findElement(By.xpath("//div[@id='closeBtn']")).click();
		newChromeBrowser.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("bags", Keys.ENTER);
		//newChromeBrowser.findElement(By.xpath("//ul[@class='categories-list']//label[text()='Handbags']")).click();
		
		WebElement radioBtnMen = driverWait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Men']")));
		do {
			radioBtnMen.click();
			
		} while (!radioBtnMen.isEnabled());
		
		WebElement checkboxHandbag = driverWait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='categories-list']//label[text()='Handbags']")));
		checkboxHandbag.click();	
		Thread.sleep(wait);
		String searchResult = newChromeBrowser.findElement(By.xpath("//span[@class='title-count']")).getText();
		List<WebElement> bagsBrandElements = newChromeBrowser.findElements(By.xpath("//h3[@class='product-brand']"));
		List<String> bagsBrand = new ArrayList<String>();

		for (WebElement brand : bagsBrandElements) {

			bagsBrand.add(brand.getText());

		}
		List<WebElement> bagsProductElements = newChromeBrowser.findElements(By.xpath("//h4[@class='product-product']"));
		List<String> bagsProduct = new ArrayList<String>();
		for (WebElement product : bagsProductElements) {

			bagsProduct.add(product.getText());

		}
		System.out.println(searchResult);
		System.out.println(bagsBrand);
		System.out.println(bagsProduct);
	}

}
