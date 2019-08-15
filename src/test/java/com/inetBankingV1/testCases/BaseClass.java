package com.inetBankingV1.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.utilities.ReadConfig;


public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public String chromepath=readconfig.getChromepath();
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	
	{
		
		logger=Logger.getLogger("inetBankingV1");
		PropertyConfigurator.configure("log4j.properties");
		if (browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();							
			//Add chrome switch to disable notification - "**--disable-notifications**"
			options.addArguments("--disable-notifications");
			
			//rootpath=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",chromepath);
			// Initialize browser
			driver=new ChromeDriver(options);
						
		}
		
		else {
			System.out.println("Browser is not provided.");
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		
	}
	
	
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	public void captureScreenshot(WebDriver driver,String tname) throws IOException
	
	{
      TakesScreenshot ts=	(TakesScreenshot) driver;
      File source=ts.getScreenshotAs(OutputType.FILE);
      File target=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
      FileUtils.copyFile(source, target);
      System.out.println("Screenshot is taken");
      
      
      
      
	}
	
	
	
	
	
}
