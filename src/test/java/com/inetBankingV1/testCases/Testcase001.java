package com.inetBankingV1.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;

public class Testcase001 extends BaseClass{
	
	@Test
	public void logintest() throws IOException, InterruptedException
	
	{
		
		//driver.get(baseURL);
		
		logger.info("URL is entered.");
		
		LoginPage lp=new LoginPage(driver);
		lp.amazonLogin(username, password);
		logger.info("PASS:Login");
		
		
		if (driver.getTitle().equalsIgnoreCase("Amazon.in - Your Account"))
		{
			Assert.assertTrue(true);
		}
		else
		{   
			captureScreenshot(driver,"logintest");
			Assert.assertTrue(false);
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	

}
