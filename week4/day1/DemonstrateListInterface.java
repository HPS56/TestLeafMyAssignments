/*
 * Class to demonstrate list iterface by getting all the mobile phone prices from Amazon website
 */
package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemonstrateListInterface {

	public static void main(String[] args) throws InterruptedException {
		// Initialise ChromeOptions to pass arguments
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");

		// Getting new instance of the Chromedriver
		ChromeDriver newChromeBrowser = new ChromeDriver(options);

		// Launching Amazon url and maximising window
		newChromeBrowser.get("https://www.amazon.in/");
		newChromeBrowser.manage().window().maximize();

		// Adding ImplicitlyWait to driver instance
		newChromeBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Check to see if the browser is on the correct page as sometimes it goes to a
		// different page
		if (!newChromeBrowser.getTitle().equals(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			WebElement continueToAmazon = newChromeBrowser.findElement(By.xpath("//button[@type='submit']"));
			continueToAmazon.click();
		}

		// Locating search box and entering search text
		WebElement searchBox = newChromeBrowser.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("Phones");

		// Locating search button and clicking to get results
		WebElement searchButton = newChromeBrowser.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();

		// Finding all web elements with a tag span with class attributes as 'a-price-whole'
		Thread.sleep(3000); // Using wait for the page to fully load
		List<WebElement> mobileResults = newChromeBrowser.findElements(By.xpath("//span[@class='a-price-whole']"));

		// Creating a new array list to store the prices of mobile phones from the list
		List<Integer> mobilePrices = new ArrayList<Integer>();

		// Using for each to iterate each web elements to get the text which is price
		for (WebElement webElement : mobileResults) {

			// getting price from each element and adding to new list
			String price = webElement.getText().toString().trim().replaceAll(",", "");
			mobilePrices.add(Integer.parseInt(price));

		}
		// Sorting the price list
		Collections.sort(mobilePrices);
		// Printing all prices
		System.out.println("The mobiles price list is : " + mobilePrices);
		// Printing the lowest price
		System.out.println("The lowest priced mobile availble is : " + mobilePrices.get(0));

		// Closing Browser
		newChromeBrowser.close();

	}

}
