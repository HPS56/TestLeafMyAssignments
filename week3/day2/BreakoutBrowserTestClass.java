package week3.day2;

public class BreakoutBrowserTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BreakoutChromeSubClass chromeBrowser = new BreakoutChromeSubClass();
		
		BreakoutEdgeSubClass edgeBrowser = new BreakoutEdgeSubClass();
		
		BreakoutSafariSubClass safariBrowser = new BreakoutSafariSubClass();
		
		chromeBrowser.browserName = "Chrome";
		chromeBrowser.browserVersion = "1.137";
		
		chromeBrowser.OpenURL();
		chromeBrowser.openIncognito();
		chromeBrowser.clearCache();
		chromeBrowser.navigateBack();
		chromeBrowser.closeBrowser();
		
		edgeBrowser.browserName = "Edge";
		edgeBrowser.browserVersion = "1.257";
		
		edgeBrowser.OpenURL();
		edgeBrowser.takeSnap();
		edgeBrowser.clearCookies();
		edgeBrowser.navigateBack();
		edgeBrowser.closeBrowser();
		
		safariBrowser.browserName = "Safari";
		safariBrowser.browserVersion = "1.697";
		
		safariBrowser.OpenURL();
		safariBrowser.readerMode();
		safariBrowser.fullScreenMode();
		safariBrowser.navigateBack();
		safariBrowser.closeBrowser();

	}

}
