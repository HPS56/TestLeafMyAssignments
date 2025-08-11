package pages;

import org.openqa.selenium.By;

import base.LeafTapsBase;

public class MyLeadsPage extends LeafTapsBase {

	public CreateLeadPage clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage();
	}

}
