package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.LeafTapsBase;

public class ViewLeadPage extends LeafTapsBase {
	
	public void viewLeadPage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leads']")));
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.toLowerCase().contains("view lead"));
		System.out.println(pageTitle);
	}


}
