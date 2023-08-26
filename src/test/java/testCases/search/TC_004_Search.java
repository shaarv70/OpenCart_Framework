package testCases.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Search_Page;
import testBase.BaseClass;
import testBase.Routes;

public class TC_004_Search extends BaseClass
{


	@Test	
	public void  test_search()
	{  
       try { 
      
		logger.info("*** Starting TC_001_AccountRegistrationTest *** ");
		HomePage hp = new HomePage(driver);
		logger.info("Entering product name");
		hp.search(rb.getString(Routes.product));
		logger.info("Clicking on search button");
		hp.search_button();
		Search_Page sp= new Search_Page(driver);
		Assert.assertEquals(sp.check_search(),true,"Element not found");

       }
       catch(Exception e )
       {
    	   Assert.fail();
       }

       logger.info("*** Finishing TC_001_AccountRegistrationTest ***");


	}





}
