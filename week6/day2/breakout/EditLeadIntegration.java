package week6.day2.breakout;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLeadIntegration extends BaseClass {
	@BeforeTest
	public void setValues() {
		fileName = "EditLead";
	}
	@Test(dataProvider = "fetchData")
	public void runEditLead(String cNmae,String pNumber) throws InterruptedException {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cNmae);
		driver.findElement(By.name("submitButton")).click();
		driver.close();
	}
}
