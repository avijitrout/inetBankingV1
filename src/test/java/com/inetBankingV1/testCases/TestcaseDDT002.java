package com.inetBankingV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;
import com.inetBankingV1.utilities.ExcellUtils;

public class TestcaseDDT002 extends BaseClass {
	
	
	@Test(dataProvider="Data")
	public void DDT(String Username,String Password) throws InterruptedException
	
	{
	    LoginPage lp=new LoginPage(driver);
	    lp.amazonLogin(Username, Password);
	    if (loginValidation()==true)
	    {
	    	System.out.println("The Login was successfull");
	    	Assert.assertTrue(true);
	    }
	    lp.amazonLogout();	
	    Thread.sleep(2000);
		
		
	}	
		
	public boolean loginValidation()
	
	{
		String Title=driver.getTitle();
		if (Title.contains("Amazon.in"))
		{
			return true;
		}
		
		else
		{
			
			return false;
		}
	
	
	}
    
	@DataProvider(name="Data")
	public String [] [] getDataFromExcel() throws IOException
	
	{
		String Exelpath=System.getProperty("user.dir") + "/src/test/java/com/inetBankingV1/testdata/Testdata.xlsx";
		int rownum=ExcellUtils.getRowcount(Exelpath, "Sheet1");
		int colnum=ExcellUtils.getcolCount(Exelpath, "Sheet1", 1);
		System.out.println(Exelpath);
		String logindata [] []=new String [rownum] [colnum];
		
		for (int i=1;i<=rownum;i++)
		{
			for (int j = 0; j < colnum; j++) 
				
			{
				System.out.println(ExcellUtils.getCelldata(Exelpath, "Sheet1", i,j));
				logindata [i-1] [j]= ExcellUtils.getCelldata(Exelpath, "Sheet1", i,j);
				
				
			}
		}
		
		return logindata;		
	     	
	}

}
