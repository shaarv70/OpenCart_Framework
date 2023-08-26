package testCases.login;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import testBase.Routes;


public class TC_002_LoginTest extends BaseClass

{    
	@Test(groups = {"Sanity","Master"})
	public void test_login()
	{
		try
		{ 
			logger.info("*** Starting TC_002_LoginTest ***");

			HomePage hp=new HomePage(driver);
			logger.info("Clicked on Account");
			hp.ClickonmyAccount();
			logger.info("Clicked on login option");
			hp.Clickonlogin();

			LoginPage lp= new LoginPage(driver);
			logger.info("Providing login details");
			lp.enterEmail(rb.getString(Routes.email));
	        lp.enterPassword(rb.getString(Routes.password));
			logger.info("Clicked on login btn");
			lp.clickOnlogin();

             MyAccountPage mp= new MyAccountPage(driver);
             Assert.assertEquals(mp.checkMess(), true, "Invalid login data");
		}
		catch(Exception s)
		{
			Assert.fail();
		}

		logger.info("*** Finishing TC_002_LoginTest *** ");



	}}
