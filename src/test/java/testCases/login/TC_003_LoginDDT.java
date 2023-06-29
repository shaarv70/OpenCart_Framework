package testCases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass 

{
     
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void loginDDT(String email, String password,String expected )//Since excel contains 3 columns so we are passing 3 arguments as it will return 3 columns data  
	{
		
		try
		{
		logger.info("*** Starting TC_003_LoginDDT ***" );
		HomePage hp=new HomePage(driver);
		logger.info("Clicked on Account");
		hp.ClickonmyAccount();
		logger.info("Clicked on login option");
		hp.Clickonlogin();

		LoginPage lp= new LoginPage(driver);
		logger.info("Providing login details");
		lp.enterEmail(email);
		lp.enterPassword(password);
		logger.info("Clicked on login btn");
		lp.clickOnlogin();

		MyAccountPage mp= new MyAccountPage(driver);
		boolean target =mp.checkMess();

		if(expected.equals("Valid"))
		{
			if(target==true)
			{
				mp.clickLogout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}

		if(expected.equals("Invalid"))
		{
			if(target==true)
			{
				Assert.assertTrue(false);
			}

			else
			{
				Assert.assertTrue(true);
			}
		}

		logger.info("*** Finishing TC_003_LoginDDT ***" );
	}
	
	catch(Exception f)
	{
		Assert.fail();
	}

}}
