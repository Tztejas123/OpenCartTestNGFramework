package com.absoloop.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.absoloop.pageObject.HomePage;
import com.absoloop.pageObject.LoginPage;
import com.absoloop.pageObject.MyAccountPage;
import com.absoloop.testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void test_Login()
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
						
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rb.getString("email")); // valid email, get it from properties file
			
			lp.setPassword(rb.getString("password")); // valid password, get it from properties file
			
			lp.clickLogin();
			
			MyAccountPage macc=new MyAccountPage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");
		
	}
	
	
}


