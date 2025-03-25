package com.absoloop.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.absoloop.pageObject.AccountRegistrationPage;
import com.absoloop.pageObject.HomePage;
import com.absoloop.testBase.BaseClass;

public class TC_001_AccountRegistrationTestChatGpt extends BaseClass {
	@Test(groups = { "Regression", "Master" })
	public void test_account_Registration() {
		logger.info("Starting TC_001_AccountRegistrationTest");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");

			hp.clickRegister();
			logger.info("Clicked on Register");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			regpage.setFirstName(randomeString().toUpperCase());
			logger.info("Provided First Name");

			regpage.setLastName(randomeString().toUpperCase());
			logger.info("Provided Last Name");

			regpage.setEmail(randomeString() + "@gmail.com");
			logger.info("Provided Email");

			regpage.setTelephone(randomeNumber());
			logger.info("Provided Telephone");

			regpage.setPassword("test@123");
			regpage.setConfirmPassword("test@123");
			logger.info("Provided and confirmed Password");

			regpage.setPrivacyPolicy();
			logger.info("Set Privacy Policy");

			regpage.clickContinue();
			logger.info("Clicked on Continue");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));

			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test failed due to exception: " + e.getMessage(), e);
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		logger.info("Finished TC_001_AccountRegistrationTest");
	}
}
