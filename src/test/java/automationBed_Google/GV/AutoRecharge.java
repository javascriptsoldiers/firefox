package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.SettingsPayments;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

public class AutoRecharge extends SuiteBase {

	// AutoRecharge UI
	public void autoRechargeUi(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settingPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments settingPayment = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		
		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();	
		
		/* Steps:  2. Navigate to the settings page (hamburger menu > Settings)
  		3. Click on the Payments sub heading or scroll to Payments section */
		
		hmMenuPage.clickSettings();
		settingPage.clickPaymentTab();
		  
		  /* Verify:
		  1. UI shows Auto-recharge section below Your current balance section
		  2. Text Auto-recharge appears with an info popup clickable link
		  3. When balance falls below $2.00: text is visible
		  4. A Dropdown showing a bunch of response actions will be available to the user" */
				
		// Verify auto-recharge text
		settingPayment.verifyAutoRecharge().verifyBalanceFallsBelowText();
		settingPayment.clickAutoBalanceOff().verifyDropDownResponseAction();
	}	
	
	// AutoRechage action drop down
		public void autoRechargeActionDropDown(String email, String password, String data) throws Exception {
			// Launching google voice web application
			Utils.uBase.launchWebApplication();

			// Initiating java page into object using PageFactory
			GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
			HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
			SettingsPage settingPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
			SettingsPayments settingPayment = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
			
			/* Procedure: Sign in into the application */
			gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();	
			
			/* Steps:  2. Navigate to the settings page (hamburger menu > Settings)
	  		3. Click on the Payments sub heading or scroll to Payments section */
			
			hmMenuPage.clickSettings();
			settingPage.clickPaymentTab();
			  
			/* Verify:
				  The box expands to show the following actions:
				  Off, Send an email, Auto-recharge $10.00, Auto-recharge $25.00, Auto-recharge $50.00
				  Also, verify that the dropdown collapses upon clicking the arrow again or clicking the back button of the browser"" */
					
			// Verify auto-recharge text
			settingPayment.clickAutoBalanceOff().verifyDropDownResponseAction();
			settingPayment.clickAutoBalanceHighlight().verifyDropDownResponseActionCollapse();
		}	
}
