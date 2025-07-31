package week6.day2.breakout;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLeadIntegration extends BaseClass {
	@BeforeTest
	public void setValues() {
		fileName = "CreateLead";
	}

	@Test(dataProvider = "fetchData")
	public void runCreateLead(String cName, String fName, String lName) {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();

	}


}
