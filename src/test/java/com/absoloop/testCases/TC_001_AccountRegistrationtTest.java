package com.absoloop.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.absoloop.pageObject.AccountRegistrationPage;
import com.absoloop.pageObject.HomePage;
import com.absoloop.testBase.BaseClass;

public class TC_001_AccountRegistrationtTest extends BaseClass {
	
	@Test(groups = { "Regression", "Master" }) 
	public void test_account_Registration() {
		logger.info("Starting TC_001_AccountRegistrationtTest");
		
		try {
			HomePage hp = new HomePage(getDriver());
			hp.clickMyAccount();
			logger.info("Clicked on My Account");

			hp.clickRegister();
			logger.info("Clicked on Register");

			AccountRegistrationPage regpage = new AccountRegistrationPage(getDriver());

			regpage.setFirstName(randomeString().toUpperCase());
			logger.info("Provided First Name");

			regpage.setLastName(randomeString().toUpperCase());
			logger.info("Provided Last Name");

			regpage.setEmail(randomeString() + "@gmail.com"); // randomly generated the email
			logger.info("Provided Email");

			regpage.setTelephone(randomeNumber());
			logger.info("Provided Telephone");

			regpage.setPassword("test@123");
			logger.info("Provided Password");

			regpage.setConfirmPassword("test@123");
			logger.info("Provided Confrmed Password");

			regpage.setPrivacyPolicy();
			logger.info("Set Privacy Policy");

			regpage.clickContinue();
			logger.info("Clicked on Continue");

			// relying on Implicit Wait (defined in BaseClass) or Explicit Wait in Page Object.
			
			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			
		} catch (Exception e) {
			// RUTHLESS FIX: Added stack trace to logs and failure message
			logger.error("Test Failed: ", e); 
			Assert.fail("Test failed: " + e.getMessage());
		}

		logger.info("Finished TC_001_AccountRegistrationtTest");
	}

}