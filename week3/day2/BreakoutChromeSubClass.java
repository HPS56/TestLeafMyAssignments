package week3.day2;

public class BreakoutChromeSubClass extends BreakoutBrowserSuperClass{

	public void openIncognito() {
		System.out.println("SubClassChrome :: Opening browser in incognito mode");
	}
	
	public void clearCache() {
		System.out.println("SubClassChrome :: Browser cache is cleared");
	}
}
