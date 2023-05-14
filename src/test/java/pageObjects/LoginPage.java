package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage 
{     
	HomePage hp=new HomePage(driver);

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	
	}

   @FindBy(xpath="//input[@id='input-email']")
   WebElement inputEmail;
   
   @FindBy(xpath="//input[@id='input-password']")
	WebElement inputPass;
   
   @FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
   
  
   public void enterEmail(String email)
   {
	   inputEmail.sendKeys(email);
   }
	
   public void enterPassword(String pass)
   {
	  
	   inputPass.sendKeys(pass);
	  
   }
   
   public void clickOnlogin()
   {
	   loginBtn.click();
   }
   
  
     
	
	
	
}
