package pages;

import org.openqa.selenium.By;

import base.LeafTapsBase;

public class MyHomePage extends LeafTapsBase {

	public MyLeadsPage clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeadsPage();

	}

}
