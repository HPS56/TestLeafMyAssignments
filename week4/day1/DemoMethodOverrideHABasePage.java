/*
 * Super Class BasePage with methods which will be inherited by a subclass LoginPage
 * Override method will be implemented in subclass for method performCommonTasks
 */
package week4.day1;

public class DemoMethodOverrideHABasePage {

	public void findElement() {
		// Method to find web element on the given page
		System.out.println("Base Page	: This method will find web element");

	}

	public void clickElement() {
		// Method to click web element
		System.out.println("Base Page	: This method will click the web element");

	}

	public void enterText() {
		// Method to enter text in web element
		System.out.println("Base Page	: This method will enter text in the web element");

	}

	public void performCommonTask() {
		// Method to perform common tasks
		System.out.println("Base Page	: This is a common method to handle other tasks");

	}

}
