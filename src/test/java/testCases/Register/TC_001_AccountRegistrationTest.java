package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import testBase.Routes;

public class TC_001_AccountRegistrationTest extends BaseClass

{    
	@Test(groups = {"Regression","Master"} )
	public void test_account_Registration()  
	
	{    
		logger.debug("application logs....");// debug log means client and server communication also included in those logs
		logger.info("*** Starting TC_001_AccountRegistrationTest *** ");
		try
		{
			HomePage hp=new HomePage(driver);
			hp.ClickonmyAccount();
			logger.info("Clicked on myAccount");
			hp.Clickonregister();
			logger.info("Clicked on register link");
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			logger.info("Providing customer data");
			regpage.setFirstname(randomString().toUpperCase());
			regpage.setSecondname(randomString().toUpperCase());
			regpage.setEmail(randomString()+Routes.randomemail);// has to be generated randomly
			regpage.setTelephone(randomNumber());
			String pass= alphaNumeric();
			regpage.setPassword(pass);
			regpage.setconfirmPass(pass);
			regpage.clickCheckbox();
			regpage.clickOncontinue();
			logger.info("Clicked on continue");
			String text= regpage.getConfirmMess();
			logger.info("Validating expected message");
			Assert.assertEquals(text, "Your Account Has Been Created!","Account hasn't been created");
		}
		catch (Exception s)
		{    logger.error("Test Failed");
			Assert.fail();
		}

      logger.info("*** Finishing TC_001_AccountRegistrationTest *** ");

	}}
