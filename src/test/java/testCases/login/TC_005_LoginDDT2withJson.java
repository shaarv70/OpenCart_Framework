package testCases.login;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_005_LoginDDT2withJson extends BaseClass 

{
     
	@Test(dataProvider = "LoginDatawithJson",dataProviderClass = DataProviders.class)
	public void loginDDTtest(HashMap<String,String>input )  
	{
		
		try
		{
		logger.info("*** Starting TC_005_LoginDDT2withJson ***" );
		HomePage hp=new HomePage(driver);
		logger.info("Clicked on Account");
		hp.ClickonmyAccount();
		logger.info("Clicked on login option");
		hp.Clickonlogin();

		LoginPage lp= new LoginPage(driver);
		logger.info("Providing login details");
		lp.enterEmail(input.get("username"));
		lp.enterPassword(input.get("password"));
		logger.info("Clicked on login btn");
		lp.clickOnlogin();

		MyAccountPage mp= new MyAccountPage(driver);
		boolean target =mp.checkMess();

		if(input.get("res").equals("Valid"))
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

		if(input.get("res").equals("Invalid"))
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

		logger.info("*** Finishing TC_005_LoginDDT2withJson ***" );
	}
	
	catch(Exception f)
	{
		Assert.fail();
	}

}}
