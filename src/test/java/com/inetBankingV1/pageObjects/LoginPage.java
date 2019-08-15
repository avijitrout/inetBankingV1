package com.inetBankingV1.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.ID,using="ap_email")
	WebElement username;
	
	@FindBy(how=How.ID,using="continue")
	WebElement btnContinue;
	
	@FindBy(how=How.ID,using="ap_password")
	WebElement password;
	
	@FindBy(how=How.ID,using="signInSubmit")
	WebElement btnLogin;
	
	@FindBy(how=How.XPATH,using=".//*[@id='nav-link-accountList']")
	WebElement Accounts_list;
	
		
	@FindBy(how=How.XPATH,using="//span[text()='Sign Out']")
	WebElement logout;
	
	@FindBy(how=How.ID,using="auth-error-message-box")
	WebElement error;
	
	
	
	
	
	public void amazonLogin(String UserId,String Password)
	
	{
		//System.out.println("Test in login method");	
		username.sendKeys(UserId);
		btnContinue.click();
		password.sendKeys(Password);		
		btnLogin.click();
	}		
    public void amazonLogout() throws InterruptedException
    {
    	Actions action = new Actions(ldriver);
	    //WebElement elementToHover=driver.findElement(By.xpath(".//*[@id='nav-link-accountList']"));
	    //action.moveToElement(ele).perform();
	    //WebElement elementToClick=driver.findElement(By.xpath("//span[text()='Sign Out']"));
	    action.moveToElement(Accounts_list).click(logout).build().perform();
	    System.out.println("Amazon is loogged out successfully.");
    	
    	
    }
    
    public String verfiyErrormessage()
    {
    	
    	return error.getText();
    	 
    }
	
	
}
