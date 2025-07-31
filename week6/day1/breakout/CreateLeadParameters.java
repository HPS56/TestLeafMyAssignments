package week6.day1.breakout;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLeadParameters extends BaseClass {

	@Test(dataProvider = "fetchData")
	public void runCreateLead(String cName,String fName,String lName) {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();

	}

	@DataProvider(name = "fetchData")
	public String[][] sendData() {
		String[][] data = new String[3][3];

		data[0][0] = "TestLeaf";
		data[0][1] = "NameOne";
		data[0][2] = "LastOne";

		data[1][0] = "TestLeaf";
		data[1][1] = "SecondName";
		data[1][2] = "SecondLast";

		data[2][0] = "TestLeaf";
		data[2][1] = "ThridName";
		data[2][2] = "ThirdLast";

		return data;

	}
}
