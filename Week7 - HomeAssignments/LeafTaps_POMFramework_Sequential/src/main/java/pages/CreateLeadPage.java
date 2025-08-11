package pages;

import org.openqa.selenium.By;

import base.LeafTapsBase;

public class CreateLeadPage extends LeafTapsBase{
	
	public CreateLeadPage enterLeadsDetails () {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ThoughWorks");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Harikumar");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Panneer");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryPhoneNumber']")).sendKeys("9633200969");
		return this;
	}
	
	public ViewLeadPage clickSubmit() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage();
   
	}

}
