package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_Page extends BasePage
{

	public Search_Page(WebDriver driver) 
	{
		super(driver);
	
	}
	
	@FindBy(linkText = "iMac")
	WebElement search_product;
	
	
	public boolean check_search()
      {
    	  try {
    		  boolean check=search_product.isDisplayed();
    		  return check;
    	     }
      
          catch(Exception e)
    	  {
        	 return false;
    	  }
      
      }
	
	
	
	
}
