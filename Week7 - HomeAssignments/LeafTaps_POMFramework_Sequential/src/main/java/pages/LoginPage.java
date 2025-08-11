package pages;

import org.openqa.selenium.By;

import base.LeafTapsBase;

public class LoginPage extends LeafTapsBase {
	
	public LoginPage enterUserNameAndPassword() {
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}
	
	public WelcomePage submit() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage();
	}

}
