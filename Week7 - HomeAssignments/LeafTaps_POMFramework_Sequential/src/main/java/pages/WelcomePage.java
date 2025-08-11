package pages;

import org.openqa.selenium.By;

import base.LeafTapsBase;

public class WelcomePage extends LeafTapsBase {

	public MyHomePage clickCRMSFA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();

	}

}
