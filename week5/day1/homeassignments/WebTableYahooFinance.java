/*
 * 	To grasp and apply the concept of web tables in Selenium by retrieving information from tables within a given application.
 *	Assignment Details: Locate the webtable 'Crypto' in the web page 'https://finance.yahoo.com/' and retrieve the data in the table
 *	Psuedo Code:
 *		1. Create a java class to get an instance of the chrome driver and launch the above url
 *		2. Navigate to Markets and then Crypto
 *		3. Inspect the web page DOM and get the location of the web table using //table
 *		4. Analyse the table structure and get the <tr> and <td> web elements
 *		5. Use suitable looping technique to iterate the web elements and get the data to print to end user
 */
package week5.day1.homeassignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableYahooFinance {

	public static void main(String[] args) throws InterruptedException {
		// Initialise Chrome Driver, set window size to max and launch the url
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get("https://finance.yahoo.com/");
		
		// Implicitly wait to the browser instance
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Location markets and Crypto page to navigate browser to Crypto table
		chromeDriver.findElement(By.xpath("//span[text()='Markets']")).click();
		chromeDriver.findElement(By.xpath("//span[text()='Crypto']")).click();
		
		Thread.sleep(4000); // Using sleep for page load
		
		// Getting total number of table rows
		List<WebElement> tableRows = chromeDriver.findElements(By.xpath("//table/tbody/tr"));

		// Printing Header
		System.out.println(
				"Symbol | Name |  | Price | Price |  Change |  Change% |  MarketCap |  Volume |  VolumeInCurrency |  TotalVolumeCurrenicies |  52WeekChange |  ");

		// Iterating through table rows to access data
		for (int i = 1; i <= tableRows.size(); i++) {
			// Getting list of web elements for the td tags from the current row
			List<WebElement> tableColumns = chromeDriver.findElements(By.xpath("//table/tbody/tr[" + i + "]/td"));
			// Separation Line for each rows
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------");
			// Loop to iterate each td to print the text
			for (WebElement column : tableColumns) {
				System.out.print(column.getText() + " | ");
			}
			System.out.println(); // Inserting new line after printing all td text
		}

		chromeDriver.quit(); //Closing driver instance
	}

}
