package week3.day2.inheritanceassignment;

// sub class for text field elements inheriting from super class webelement
public class TextField extends WebElement{
	
	public void getText() {
		// method to get text from a text field
		System.out.println("From Sub Class of WebElement--TextField :: Getting text from the input filed");
	}

}
