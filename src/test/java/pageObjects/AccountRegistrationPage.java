package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage 

{

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
		
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	
	@FindBy(xpath="//input[@id='input-password']")
    WebElement 	password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
    WebElement confirmPAss;
	
    @FindBy(xpath="//input[@name='agree']")
     WebElement checkbox;
    
    @FindBy(xpath="//input[@value='Continue']")
    WebElement continueButton;
    
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement chkMess;
    
    public void setFirstname(String fname)
    {
    	firstName.sendKeys(fname);
    }
    
    public void setSecondname(String sname)
    {
    	lastName.sendKeys(sname);
    }

    public void setEmail(String emal)
    {
    	email.sendKeys(emal);
    }
    
    public void setTelephone(String tele)
    {
    	telephone.sendKeys(tele);
    }

    public void setPassword(String pass)
    {
    	password.sendKeys(pass);
    }
    
    public void setconfirmPass(String confpass)
    {
    	confirmPAss.sendKeys(confpass);
    }
    
    public void clickCheckbox()
    {
    	checkbox.click();
    }

   public void clickOncontinue()
   {
	   continueButton.click();
   }
   
   public String getConfirmMess()
   {
	   try
	   {
		   return (chkMess.getText());
	   }
      catch(Exception e)
	   {
    	 return( e.getMessage());
	   }
   }

}


