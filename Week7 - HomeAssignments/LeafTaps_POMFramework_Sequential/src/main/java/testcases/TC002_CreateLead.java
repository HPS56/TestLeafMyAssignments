package testcases;

import org.testng.annotations.Test;

import base.LeafTapsBase;
import pages.LoginPage;

public class TC002_CreateLead extends LeafTapsBase{
	
	@Test
	public void runCreateLead() {
		
		LoginPage loginPage = new LoginPage();
		loginPage.enterUserNameAndPassword()
		.submit()
		.clickCRMSFA()
		.clickLeads()
		.clickCreateLead()
		.enterLeadsDetails()
		.clickSubmit()
		.viewLeadPage();
	}
	
	

}
