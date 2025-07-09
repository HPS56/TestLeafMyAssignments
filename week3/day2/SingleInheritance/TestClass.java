package week3.day2.SingleInheritance;

public class TestClass {

	public static void main(String[] args) {
		// creating instance of the subclass LoginTestData
		
		LoginTestData loginTestData = new LoginTestData();
		
		loginTestData.enterUsername(); // method from sub class LoginTestData
		loginTestData.enterPassowrd(); // method from sub class LoginTestData
		loginTestData.enterCredentials(); // method from super class TestData
		loginTestData.navigateToHomePage(); // method from super class TestData
	}
	
}
