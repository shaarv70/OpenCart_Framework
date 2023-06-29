package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage 
{

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
		
	}

     
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logoutBtn;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	 WebElement mess;
	 
	 public boolean checkMess()
	   {
		   try {
		   boolean check =mess.isDisplayed();
	        return check;
		   }
	
	   catch(Exception e )
		   {   
		        return false;
		   }
		   }
		
	   public void clickLogout()
	   {
		   logoutBtn.click();
	   }


}
