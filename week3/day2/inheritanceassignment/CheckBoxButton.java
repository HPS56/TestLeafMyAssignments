package week3.day2.inheritanceassignment;

// sub class to handle checkbox webelements extends from button class
public class CheckBoxButton extends Button{
	
	public void clickCheckButton() {
		// method to perform click action on checkbox
		System.out.println("From Sub Class of Button--CheckBoxButton :: Checkbox clicked");
	}
	
}
