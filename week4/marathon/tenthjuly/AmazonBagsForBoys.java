package week4.marathon.tenthjuly;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AmazonBagsForBoys {

	public static WebElement GetWebElementByXpath(WebDriver webDriverName, String xPath) {

		return webDriverName.findElement(By.xpath(xPath));

	}

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

		// Check to see if the browser is on the correct page as sometimes it goes to a different page
		if (!newChromeBrowser.getTitle().equals(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			WebElement continueToAmazon = GetWebElementByXpath(newChromeBrowser, "//button[@type='submit']");
			continueToAmazon.click();
		}
		
		// Locating search box and entering search text
		WebElement searchBox = GetWebElementByXpath(newChromeBrowser, "//input[@id='twotabsearchtextbox']");
		searchBox.sendKeys("bags for boys");
		
		// Locating search button and clicking to get results
		WebElement searchButton = GetWebElementByXpath(newChromeBrowser, "//input[@id='nav-search-submit-button']");
		searchButton.click();
		
		// Locating search results and printing the result details
		WebElement searchResults = GetWebElementByXpath(newChromeBrowser, "//h1[@data-csa-c-slot-id='nav-ribContainer']//h2");
		System.out.println(searchResults.getText());
		
		// Locating checkbox by brand div and clicking on the first two brand checkboxes 
		WebElement selectBrand1 = GetWebElementByXpath(newChromeBrowser,
				"(//div[@id='brandsRefinements']//div[contains(@class,'a-checkbox')])[1]");
		selectBrand1.click();
		WebElement selectBrand2 = GetWebElementByXpath(newChromeBrowser,
				"(//div[@id='brandsRefinements']//div[contains(@class,'a-checkbox')])[2]");
		selectBrand2.click();
		
		// Locating dropdown menu to sort by newest arrivals
		Select sortSelect = new Select(GetWebElementByXpath(newChromeBrowser, "//select[@id='s-result-sort-select']"));
		sortSelect.selectByVisibleText("Newest Arrivals");

		// Clicking on newest arrivals again to ensure correct results are loaded		
		WebElement selectNewArrivals = GetWebElementByXpath(newChromeBrowser,"//a[text()='Newest Arrivals']");
		selectNewArrivals.click();

		// Locating the div and its childs to get details of the top listed product from the results page
		// Brand Details
		WebElement productBrand = GetWebElementByXpath(newChromeBrowser,
				"//div[@data-component-type='s-search-result'][1]//h2[contains(@class,'a-size-mini')]");
		System.out.println("Product Brand		: " + productBrand.getText());
		
		// Product Details
		WebElement productDescription = GetWebElementByXpath(newChromeBrowser,
				"//div[@data-component-type='s-search-result'][1]//h2[contains(@class,'normal')]");
		System.out.println("Product Details		: " + productDescription.getText());
		
		// Price Details
		WebElement productPriceSymbol = GetWebElementByXpath(newChromeBrowser,
				"//div[@data-component-type='s-search-result'][1]//span[contains(@class,'a-price-symbol')]");
		WebElement productPrice = GetWebElementByXpath(newChromeBrowser,
				"//div[@data-component-type='s-search-result'][1]//span[contains(@class,'a-price-whole')]");
		System.out.println("Product Price is	: " + productPriceSymbol.getText() + " " + productPrice.getText());

		// Confirming current page details
		System.out.println("The brwoser is currently on page : " + newChromeBrowser.getTitle());
		
		//Closing browser instance
		newChromeBrowser.close();

	}

}
