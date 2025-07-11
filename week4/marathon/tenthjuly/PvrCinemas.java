package week4.marathon.tenthjuly;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PvrCinemas {

	// Creating a method to get web elements by passing web driver and xpath
	public static WebElement GetWebElementByXpath(WebDriver webDriverName, String xPath) throws InterruptedException {

		Thread.sleep(2000); // explicit wait to handle dynamic data values
		// creating webdrivewait instance to check visibility of webelement
		WebDriverWait wait = new WebDriverWait(webDriverName, Duration.ofSeconds(60));
		WebElement getWebElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
		return getWebElement;
	}

	public static void main(String[] args) throws InterruptedException {

		// Initialise ChromeOptions to pass arguments
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");

		// Getting new instance of the Chromedriver
		ChromeDriver newChromeBrowser = new ChromeDriver(options);

		// Launching pvr cinemas url and maximising window
		newChromeBrowser.get("https://www.pvrcinemas.com/");
		newChromeBrowser.manage().window().maximize();

		// Selecting location
		WebElement locationChennai = GetWebElementByXpath(newChromeBrowser, "//h6[text()='Chennai']");
		locationChennai.click();

		// Switching to cinema
		WebElement cinema = GetWebElementByXpath(newChromeBrowser, "//span[text()='Cinema']");
		cinema.click();

		// Clicking on Cinema to get cinmea avenue names
		WebElement clickCinema = GetWebElementByXpath(newChromeBrowser, "//div[@id='cinema']");
		clickCinema.click();

		// Selecting active list options for cinema
		WebElement selectCinema = GetWebElementByXpath(newChromeBrowser, "//li[@class='p-dropdown-item'][1]");
		selectCinema.click();

		// Selecting date as tomorrow
		WebElement selectDate = GetWebElementByXpath(newChromeBrowser, "//span[contains(text(),'Tomorrow')]");
		selectDate.click();

		// Selecting active movie from list
		WebElement selectMovie = GetWebElementByXpath(newChromeBrowser, "//li[@class='p-dropdown-item'][1]");
		selectMovie.click();

		// Selecting available time
		WebElement selectTiming = GetWebElementByXpath(newChromeBrowser, "//li[@class='p-dropdown-item'][1]");
		selectTiming.click();

		// Processing booking of tickets
		WebElement bookBtn = GetWebElementByXpath(newChromeBrowser, "//button[@type='submit']");
		bookBtn.click();

		// Accepting terms and conditions
		WebElement termsAccept = GetWebElementByXpath(newChromeBrowser, "//button[text()='Accept']");
		termsAccept.click();

		// Selecting the first available seats
		WebElement selectSeat = GetWebElementByXpath(newChromeBrowser, "//span[@class='seat-current-pvr']");
		selectSeat.click();

		// Proceed to purchase tickets
		WebElement proceedBtn = GetWebElementByXpath(newChromeBrowser, "//button[text()='Proceed']");
		proceedBtn.click();

		// Creating instance of string builder to print ticket and cost details
		StringBuilder message = new StringBuilder();

		// Getting seat class
		WebElement seatClass = GetWebElementByXpath(newChromeBrowser, "//div[@class='ticket-value']/p");
		message.append("Your seat has been booked successfully, Your seat class is : " + seatClass.getText());

		// Getting seat number
		WebElement seatNumber = GetWebElementByXpath(newChromeBrowser, "//div[@class='seat-number']/p");
		message.append(" and seat number is : " + seatNumber.getText());

		// Getting total cost
		WebElement grandTotal = GetWebElementByXpath(newChromeBrowser, "//div[@class='all-grand']//span");
		message.append(" Total cost of the ticket is : " + grandTotal.getText());

		System.out.println(message.toString());

		// Continue to payment
		WebElement continueBtn = GetWebElementByXpath(newChromeBrowser, "//button[text()='Continue']");
		continueBtn.click();

		// Dismiss login
		WebElement crossIcon = GetWebElementByXpath(newChromeBrowser, "(//i[contains(@class,'pi-times')])[2]");
		crossIcon.click();

		// Getting current page to print
		System.out.println("Title of the current page is : " + newChromeBrowser.getTitle());

		// Closing browser window
		newChromeBrowser.close();

	}

}
