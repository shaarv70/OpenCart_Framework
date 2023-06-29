package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;// for Logger
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass 
{
	public static WebDriver driver;/*(Important) we are making driver instance as static because otherwise two driver instances
	                             will be created, one for BaseClass itself & and the other one is for object of 
	                             BaseClass in Extent report manager which is creating the object of BaseCLass for 
	                             capturing screenshots on failure of the testcases. */
	public Logger logger;
	public ResourceBundle rb;// to load config.properties file

	@BeforeClass(groups ={"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb= ResourceBundle.getBundle("config");/*load config file data(#this file is used to store the variables 
		which are using repeatedly in all test cases like URL, email & pass for login etc. 
		this variables can be used anywhere in the testcase.)
		Note: Dont even click on space in config file because config file consider even spaces also*/ 
		
		logger=LogManager.getLogger(this.getClass());//logging 

		ChromeOptions options=new ChromeOptions();
		EdgeOptions option=new EdgeOptions();


		// Below line is used for removing the statment at run time "Chrome is being controlled by automated test software"
		//   options.setExperimentalOption("excludeSwitches",new String[] {"enable-Automation"});not working in my case so using collections instead of array
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
		



		if (br.equals("Chrome"))
		{
			driver=new ChromeDriver(options);
		}
		else if(br.equals("Edge"))
		{   
			driver= new EdgeDriver(option);
		}

		else if(br.equals("Firefox"))
		{
			driver= new FirefoxDriver();
		}

	//	driver.manage().deleteAllCookies();// it will delete all prepopulated data on the browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(rb.getString("appURL"));// fetching value of appURL from config file 
		driver.manage().window().maximize();
	}

	@AfterClass(groups ={"Master","Sanity","Regression"})
	public void teardown()
	{
		driver.quit();
	}

	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber()
	{    
		String generatedNumber= RandomStringUtils.randomNumeric(10);/*10 is giving because we want to generate telephone
    	                                                             number, if we want to generate otp then we will give 4*/

		return generatedNumber;                                              
	}

	public String alphaNumeric()
	{
		String str= RandomStringUtils.randomAlphanumeric(7);
		return str;
	}

	public String captureScreen(String tname) throws IOException 
	{
/*      SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt=new Date();
		String timeStamp= sf.format(dt);
		The below one line is the combination of above 3 lines 	*/
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try 
		{
			FileUtils.copyFile(source, new File(destination));
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		return destination;

	}}
