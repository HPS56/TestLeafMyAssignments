/*
 * Create a Java class to demonstrate method overridding by inheriting from a base class
 * Psuedo Code:
 * 	1. Inherit from the base class "DemoMethodOverrideHABasePage" using extends keyword
 * 	2. Create an instance from the main method for both child and base class and call the methods to demo overridding
 */
package week4.day1;

public class DemoMethodOverrideHALoginPage extends DemoMethodOverrideHABasePage {

	public void performCommonTask() {
		// Method which performs common task, this will override the method from the
		// base class
		System.out.println("Login Page	: Overridded method in LoginPage Class to perform common tasks");

	}

	public static void main(String[] args) {
		// Creating an instance of the BasePage (Base Class) and LoginPage (Child class)
		DemoMethodOverrideHABasePage basePage = new DemoMethodOverrideHABasePage();
		DemoMethodOverrideHALoginPage loginPage = new DemoMethodOverrideHALoginPage();

		// Calling methods in basepage using its instance
		basePage.findElement();
		basePage.enterText();
		basePage.clickElement();
		basePage.performCommonTask();

		System.out.println("		======================================		");

		// Calling methods in basepage and overridded in loginpage using loginpage
		// instance
		loginPage.findElement();
		loginPage.enterText();
		loginPage.clickElement();
		loginPage.performCommonTask();

	}

}
