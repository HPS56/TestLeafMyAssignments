package week3.day2.inheritanceassignment;

// Execution class inheriting from Button class
public class Element extends Button{

	public static void main(String[] args) {
		
		// Creating new instance of the element classes
		TextField textField = new TextField();
		Button button = new Button();
		CheckBoxButton checkBoxBtn = new CheckBoxButton();
		RadioButton radioBtn = new RadioButton();
		
		// invoking methods from different classes
		
		// TextField Methods
		textField.setText("Hello"); // from super class -- WebElement
		textField.getText(); // from sub class of WebElement -- TextField
		
		// Button Methods
		button.submit(); // from sub class of WebElement -- Button
		button.click(); // from super class -- WebElement
		
		// checkboxbutton methods
		checkBoxBtn.submit(); // from super class -- Button
		checkBoxBtn.clickCheckButton(); // from sub class of Button -- CheckBoxButton
		
		// radiobutton methods
		radioBtn.submit(); // from super class of button -- Button
		radioBtn.selectRadioButton(); // from sub class of Button -- RadioButton 
		

	}

}
