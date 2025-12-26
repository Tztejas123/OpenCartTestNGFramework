package com.absoloop.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.absoloop.pageObject.HomePage;
import com.absoloop.pageObject.LoginPage;
import com.absoloop.pageObject.MyAccountPage;
import com.absoloop.testBase.BaseClass;
import com.absolooplab.Utility.DataProviders;

/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven") // getting data
																										// provider in
																										// deffernt
	// class
	public void verify_loginDDT(String email, String password, String exp) {
		logger.info("**** Starting TC_003_LoginDDT *****");

		try {

			// Home page
			HomePage hp = new HomePage(getDriver());
			hp.clickMyAccount();
			hp.clickLogin(); // Login link under MyAccount

			// Login page
			LoginPage lp = new LoginPage(getDriver());
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin(); // Login button

			// My Account Page
			MyAccountPage macc = new MyAccountPage(getDriver());
			boolean targetPage = macc.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			logger.error("Test Failed: ", e); 
			Assert.fail("Test failed: " + e.getMessage());
		}

		logger.info("**** Finished TC_003_LoginDDT *****");
	}

}
