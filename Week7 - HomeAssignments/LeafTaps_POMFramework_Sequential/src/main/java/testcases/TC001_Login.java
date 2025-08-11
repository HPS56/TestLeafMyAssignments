package testcases;

import org.testng.annotations.Test;

import base.LeafTapsBase;
import pages.LoginPage;

public class TC001_Login extends LeafTapsBase{

	@Test
	public void runLogin() {

		LoginPage loginPage = new LoginPage();

		loginPage.enterUserNameAndPassword().submit();

	}

}
