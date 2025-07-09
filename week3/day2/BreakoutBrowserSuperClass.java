package week3.day2;

public class BreakoutBrowserSuperClass {
	
	// Declaring variables
	String browserName,browserVersion;
	
	public void OpenURL() {
		System.out.println("SuperClass :: Launching "+browserName+" version "+browserVersion+" with given Url");
	}
	
	public void closeBrowser() {
		System.out.println("SuperClass :: "+browserName+" Closing browser");
	}
	
	public void navigateBack() {
		System.out.println("SuperClass :: "+browserName+" navigating browser backwards");
	}

}
