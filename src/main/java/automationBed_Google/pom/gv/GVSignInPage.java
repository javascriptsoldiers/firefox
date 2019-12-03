package automationBed_Google.pom.gv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.BaseUtility;
import automationBed_Google.utility.base.Utils;

public class GVSignInPage extends BaseUtility
{

	//Locators
	@FindBy(xpath="//a[contains(@class,'signUpLink')]")
	WebElement signInBtn;
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement logInID;
	@FindBy(xpath="//span[.='Next']")
	WebElement logInNxtBtn;
	@FindBy(xpath="//*[contains(@name,'password')]")
	WebElement logInPWD;
	@FindBy(xpath="//*[@id='dialogContent_0']/button|//*[@id='dialogContent_0']/button/div")
	WebElement gotIt;
	String dailyURL = "https://voice-daily-0.sandbox.google.com";

	public GVSignInPage(WebDriver driver) {
		//super(driver);
	}
	public GVSignInPage clickHomeSignIn() throws Exception
	{
		try
		{	
			//Utils.uBase.takeScreenshotOfWebelement(signInBtn, "signInBtn");
			Utils.uBase.waitForElementToBeClickable(signInBtn);
			GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
			GAPage.switchingToWindowByIndex(0);
			AdvanceReporting.addLogs("pass", "SignIn Page","SignIn Page");
			Utils.uBase.clickByImage("signInBtn");
			//Utils.uBase.clickWebelement(signInBtn);
			AdvanceReporting.addLogs("pass", "Clicked on SignIn Button");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}
	public GVSignInPage enterLoginID(String email) throws Exception
	{

		try
		{
			Utils.uBase.waitForElementToBeClickable(logInID);
			AdvanceReporting.addLogs("pass", "logInID Page","logInID Page");
			Utils.uBase.setText(logInID, email);
			AdvanceReporting.addLogs("pass", "Email Id entered is : "+email);
			AdvanceReporting.addLogs("pass", "Email Id entered", "Email Id entered");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	public GVSignInPage clickNextButton() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(logInNxtBtn);
			Thread.sleep(2000);
			Utils.uBase.clickByImage("loginNxtBtn");
			Thread.sleep(2000);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public GVSignInPage enterPassword(String password) throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(logInPWD);
			AdvanceReporting.addLogs("pass", "Password Page");
			AdvanceReporting.addLogs("pass", "logInPWD Page","logInPWD Page");
			Utils.uBase.setText(logInPWD, password);
			AdvanceReporting.addLogs("pass", "Password entered");
			AdvanceReporting.addLogs("pass", "Password entered", "Password entered");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	public GVSignInPage emergencyCallingAlert() throws Exception
	{
		try
		{
			if(Utils.uBase.isElementPresent_webelement(gotIt)==true) {
				Utils.uBase.clickWebelement(gotIt);}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public GVSignInPage dailyURL() throws Exception
    {
           try
           {
                  Thread.sleep(2000);
                
                  Utils.uBase.setUrl(dailyURL);
                  Utils.uBase.webDriver.manage().window().maximize();
                  Utils.uBase.openUrl();
                  Utils.uBase.clickOnNotificationAllowBtn();
           }
           catch (Exception e)
           {
                  AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
                  e.printStackTrace(); Assert.fail();
           }
           return this;
    }   
	
	public GVSignInPage dailyURLSignUp() throws Exception
    {
           try
           {
                  Thread.sleep(2000);
                  Utils.uBase.setUrl(dailyURL+"/u/0/signup");
                  Utils.uBase.openUrl();
           }
           catch (Exception e)
           {
                  AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
                  e.printStackTrace(); Assert.fail();
           }
           return this;
    } 
	
}





