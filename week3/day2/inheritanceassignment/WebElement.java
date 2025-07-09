package week3.day2.inheritanceassignment;

// super class for webelement
public class WebElement {
	
	public void click() {
		// method to perform click
		System.out.println("From Super Class WebElement :: Click...");
	}
	
	public void setText(String text) {
		// method to set text to an input
		System.out.println("From Super Class WebElement :: Setting text to input...");
	}

}
