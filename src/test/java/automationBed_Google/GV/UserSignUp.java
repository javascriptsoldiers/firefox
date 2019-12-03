package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GVSignUpPage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

public class UserSignUp extends SuiteBase {

	/* Verify able to select the google voice number by city name. */
	public void signUpSearchByCityName(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		GVSignUpPage gvSignUpPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignUpPage.class);

		/*Pre-Condition:
			Login with gmail, who doesn't have any type of GV account. (Brand new to get GV account) */
		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURLSignUp();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*	Procedure:
  				1) Navigate to Moya signup page (/signup)
  				2) Click "CONTINUE" on the "Welcome google voice" screen
  				3) Type City name without state.
  				4) Press "Enter" */
		gvSignUpPage.setTextInSearchBy("Coulterville");

		/*Verification:
  			1. Verify city name based phone number are listed to select.*/
		gvSignUpPage.verifyPhoneNumberListDisplayed();
	}

	/* Verify able to select the google voice number by city name with State. */
	public void signUpSearchByCityNameWithState(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		GVSignUpPage gvSignUpPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignUpPage.class);

		/*Pre-Condition:
			Login with gmail, who doesn't have any type of GV account. (Brand new to get GV account) */
		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURLSignUp();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*	Procedure:
  				1) Navigate to Moya signup page (/signup)
  				2) Click "CONTINUE" on the "Welcome google voice" screen
  				3) Type City name with state (ex; Sunnyvale, CA)
  				4) Press "Enter" */
		gvSignUpPage.setTextInSearchBy("Coulterville, CA");

		/*Verification:
  			1. Verify city name based phone number are listed to select.*/
		gvSignUpPage.verifyPhoneNumberListDisplayed();
	}

	/* Verify able to see error message saying "Try different area code/ city name" */	
	public void signUpSearchByInvalidCityName(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		GVSignUpPage gvSignUpPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignUpPage.class);

		/*Pre-Condition:
			Login with gmail, who doesn't have any type of GV account. (Brand new to get GV account) */
		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURLSignUp();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*	Procedure:
  				1) Navigate to Moya signup page (/signup)
  				2) Click "CONTINUE" on the "Welcome google voice" screen
  				3) Type invalid city name (ex; Asdf, CA)s
  				4) Press "Enter" */
		gvSignUpPage.setTextInSearchBy("Asdf, CA");

		/*Verification:
  			1. Verify city name based phone number are listed to select.*/
		gvSignUpPage.verifyErrorMsgForInvalidSearch();
	}
	
	/* Verify able to select the google voice number by area code. */	
	public void signUpSearchByAreaCode(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		GVSignUpPage gvSignUpPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignUpPage.class);

		/*Pre-Condition:
			Login with gmail, who doesn't have any type of GV account. (Brand new to get GV account) */
		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURLSignUp();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*	Procedure:
  				1) Navigate to Moya signup page (/signup)
  				2) Click "CONTINUE" on the "Welcome google voice" screen
  				3) Type area code
  				4) Press "Enter" */
		gvSignUpPage.setTextInSearchBy("209");

		/*Verification:
  			1. Verify city name based phone number are listed to select.*/
		gvSignUpPage.verifyPhoneNumberListDisplayed();
	}
	
	/* Verify able to see error messages saying "city name/ area code" unable to find. */	
	public void signUpSearchByInvalidAreaCode(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		GVSignUpPage gvSignUpPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignUpPage.class);

		/*Pre-Condition:
			Login with gmail, who doesn't have any type of GV account. (Brand new to get GV account) */
		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURLSignUp();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*	Procedure:
  				1) Navigate to Moya signup page (/signup)
  				2) Click "CONTINUE" on the "Welcome google voice" screen
  				3) Type invalid area code
  				4) Press "Enter" */
		gvSignUpPage.setTextInSearchBy("123");

		/*Verification:
  			1. Verify city name based phone number are listed to select.*/
		gvSignUpPage.verifyErrorMsgForInvalidSearch();
	}
	
	/* Verify able to select the google voice number by area code. */	
	public void signUpSearchByAreaCodeWithAllDelimiterCharacters(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		GVSignUpPage gvSignUpPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignUpPage.class);

		/*Pre-Condition:
			Login with gmail, who doesn't have any type of GV account. (Brand new to get GV account) */
		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURLSignUp();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*	Procedure:
  				1) Navigate to Moya signup page (/signup)
  				2) Click "CONTINUE" on the "Welcome google voice" screen
  				3) Type area code with some special characters ,(comma) . / - ; ' ~ ! @ # $ % ^ & * ( )
  				4) Press "Enter" */
		gvSignUpPage.setTextInSearchBy(",./ - ; ' ~ !209@ # $ % ^ & * ( )");

		/*Verification:
  			1. Verify city name based phone number are listed to select.*/
		gvSignUpPage.verifyPhoneNumberListDisplayed();
	}

}
