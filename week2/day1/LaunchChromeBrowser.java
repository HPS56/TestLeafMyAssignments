package week2.day1;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) {
		
		// Getting new instance of the chrome driver
		
		ChromeDriver newChromeBrowser = new ChromeDriver();
		
		
		// Launching facebook url
		
		newChromeBrowser.get("https://www.facebook.com/");
		
		// Maximising browser window
		newChromeBrowser.manage().window().maximize();

		// Printing current Page Title from the browser 
		System.out.println(newChromeBrowser.getTitle());
		
		// Closing the current browser window
		newChromeBrowser.close();
		
		

		
		
	}

}
