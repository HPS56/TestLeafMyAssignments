package week5.day1.breakout;

import java.time.Duration;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableErail {
	

	public static void main(String[] args) throws InterruptedException {

		// Instance of Chrome Driver, maxmising window and launching Erail url
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get("https://erail.in/");
		
		// Adding implicitly wait to the browser instance
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Locating From Station, clearing values and entering "MAS"
		chromeDriver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		chromeDriver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("MAS",Keys.ENTER);
		
		// Locating To Station, clearing values and entering "MDU"		
		chromeDriver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		chromeDriver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys("MDU",Keys.ENTER);
		
		// Locating Sort by Date and clicking to uncheck
		chromeDriver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
		Thread.sleep(2000); // adding sleep for page to load
		
		// Locating the table <td> which contains the train names and getting the web elements
		List<WebElement> trains = chromeDriver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tbody/tr/td[2]"));
		
		// Creating Treeset to store the train names
		TreeSet<String> trainList = new TreeSet<String>();
		TreeSet<String> duplicatetrains = new TreeSet<String>();
		
		// Iterating through the web elements 
		for (WebElement train : trains) {
			
			if (!trainList.add(train.getText())) { // Checking whether if the value already exists and if yes--> add to another treeset
				duplicatetrains.add(train.getText());
			}
		}
		// Printing output to the end user
		System.out.println("\nThe below are the list of trains starting from MAS to MDU :");
		System.out.println("---------------------------------------------------------");
		System.out.println(trainList);
		System.out.println("\nThe below are the list of duplicate trains starting from MAS to MDU :");
		System.out.println("---------------------------------------------------------");
		System.out.println(duplicatetrains);
		
		chromeDriver.quit(); // Closing driver instance

	}

}
