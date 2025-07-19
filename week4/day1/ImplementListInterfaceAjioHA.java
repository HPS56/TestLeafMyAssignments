/*
 * Automate the process of searching for men's fashion bags on the Ajio website
 * Apply specific filters, and gather information including the count of items found,
 * list of brands, and the list of product names
 * Psuedo Code:
 * 	1.Create an instance of chrome web driver and use implicitly wait
 * 	2.Perform browser action using selenium methods to get results for Mens HandBags
 * 	3.Print the number of results found
 * 	4.Use WebElments to get the results found
 * 	5.Use List interface to store the list of brands and bag names from the result
 * 	6.Print the results to the end user 
 * 
 */
package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ImplementListInterfaceAjioHA {

	public static void main(String[] args) throws InterruptedException {
		final int wait = 2000; // Declaring variable for wait time in milliseconds

		ChromeOptions options = new ChromeOptions(); // Initialise ChromeOptions to pass arguments as guest
		options.addArguments("guest");

		ChromeDriver newChromeBrowser = new ChromeDriver(); // Getting new instance of the Chromedriver

		newChromeBrowser.get("https://www.myntra.com/"); // Launching myntra (ajio not working) and maximising window
		newChromeBrowser.manage().window().maximize();

		// Adding ImplicitlyWait to driver instance
		newChromeBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		/*
		 * Logic to search for bags and narrowing the results by filtering Gender -->
		 * Men and Category --> Handbags
		 */
		newChromeBrowser.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("bags", Keys.ENTER);
		newChromeBrowser.findElement(By.xpath("//label[text()='Men']")).click();
		Thread.sleep(wait); // Using explicit wait to register click on the radio button
		newChromeBrowser.findElement(By.xpath("//ul[@class='categories-list']//label[text()='Handbags']")).click();
		Thread.sleep(wait); // Using explicit wait to register click on the radio button

		// Getting the total results to print to the user
		System.out.println("The total number of handbags found for Men"
				+ newChromeBrowser.findElement(By.xpath("//span[@class='title-count']")).getText());

		// Initialising array list to hold web elements for the brands
		List<WebElement> bagsBrandElements = newChromeBrowser.findElements(By.xpath("//h3[@class='product-brand']"));

		List<String> bagsBrand = new ArrayList<String>();// ArrayList to hold the value of the brand names

		for (WebElement brand : bagsBrandElements) { // Using for each to iterate each web element to get brand name

			bagsBrand.add(brand.getText());

		}

		// Initialising arraylist to hold web elements for the bag names
		List<WebElement> bagsProductElements = newChromeBrowser
				.findElements(By.xpath("//h4[@class='product-product']"));

		List<String> bagsProduct = new ArrayList<String>(); // ArrayList to hold the value of the brand names
		for (WebElement product : bagsProductElements) { // Using for each to iterate each web element to get brand name

			bagsProduct.add(product.getText());

		}

		Collections.sort(bagsBrand);// Sorting the values
		Collections.sort(bagsProduct);

		// Printing Bag Brand and name details to the user
		System.out.println("-----------------------------------------------\n");
		System.out.println("The list of Bag Brands availble are : ");
		System.out.println(bagsBrand);
		System.out.println("-----------------------------------------------\n");
		System.out.println("The list of Bag Products availble are : ");
		System.out.println(bagsProduct);

		newChromeBrowser.quit();// Closing browser instance
	}

}
