package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage

{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);/*here super method will invoke the parent class constructor as the constructor in the BasePage class will be same for all page object classes
                     In inheritance concept super keyword can be used to invoke the parent class constructor, method, variable    */
	}

	//Elements 
	@FindBy (xpath = "//span[normalize-space()='My Account']")
	WebElement myAccount;


	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;

	@FindBy(linkText = "Login")
	WebElement login;  

	@FindBy(xpath="//input[@name=\"search\"]")
	WebElement searchtextbox;

    @FindBy(xpath="//button[@class=\"btn btn-default btn-lg\"]")
    WebElement search_button;
    

	//Actions 
	public void ClickonmyAccount() 
	{
		myAccount.click(); 
	}

	public void Clickonregister()
	{
		register.click();
	}

	public void Clickonlogin()
	{
		login.click();
	}

	public void search(String product)
	{
		searchtextbox.sendKeys(product);
	}
  
	public void search_button()
	{
		search_button.click();
	}






}
