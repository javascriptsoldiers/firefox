package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.SettingsPayments;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

public class RefundRequestPerCall extends SuiteBase {

	// Verify that hovering over the billing history log will highlight the three dots menu
	public void hoverOverBillingHistory(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*  Pre-Condition: 
		 			Gvaccount should have billing history with international calls */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/* Procedure:
		 		 1. Login to the Google Voice account
		 		 2. Navigate to Settings page
		 		 3. Click on the 'Billing History' button to open the billing history page
		 		 4. Hover over the mouse on the items in the billing history */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/* Verification: 
		 		4a. Hovering over the log should highlight the items in the list.
  				4b. If the call is eligible for a refund then there will be a three dots menu on the highlighted item */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().verifyBillingHistoryItem().verifyAndClickThreedotsMenu();
	}

	// Verify that clicking on the threedots option will open refund request
	public void clickingThreedotsRefundRequest(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 Pre-Condition: Gvaccount should have billing history with international calls  */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		/* Procedure:
		 		  1. Login to the Google Voice account
		 		  2. Navigate to Settings page 
		 		  3. Click on the 'Billing History' button to open the billing history page
		 		  4. Hover over the mouse on the items in the billing history
		 		  5. Click on threedots menu near an eligible history */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();		
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().makeInternationalCall();
		/* Verification:
		 			4a. 'Request Refund' button should pop up while clicking on the threedots menu */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().verifyAndClickThreedotsMenu().verifyRequestRefundMenu();
	}

	// Verify request refund
	public void requestTheRefund(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/* Pre-Condition: 
		 		Gvaccount should have billing history with international calls */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/* Procedure: 
		 		1. Login to the Google Voice account
		 		2. Navigate to Settings page
		 		3. Click on the 'Billing History' button to open the billing history page
		 		4. Hover over the mouse on the items in the billing history
		 		5. Click on threedots menu near an eligible history
		 		6. Click on the 'Request Refund' button
		 		7. Select a reason from the drop down menu
		 		8. Click on the 'Request Refund' button	*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();	
		/* Verification:
		 		6a. 'Request a Refund' pop up should pop up 
		 		7a. 'Request Refund' button should become active 
		 		8a. Snackbar should pop up saying 'Refund issued' */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().verifyAndClickThreedotsMenu().verifyRequestRefundMenu().clickRequestRefund()
		.clickReasonBtn().selectReason().verifyRequestRefundBtn().clickRequestRefundBtn().verifySnackBar();
	}

	// Verify the Error notification in the request a refund pop up
	public void errorInRequestRefundPopUp(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/* Pre-Condition: 
		 		Gvaccount should have billing history with international calls  */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/* Procedure: 
		 		1. Login to the Google Voice account 
		 		2. Navigate to Settings page
		 		3. Click on the 'Billing History' button to open the billing history page 
		 		4. Hover over the mouse on the items in the billing history 
		 		5. Click on threedots menu near an eligible history 
		 		6. Click on the 'Request Refund' button 
		 		7. Select a reason from the drop down menu 
		 		8. Click somewhere else in the pop up to close the dropdown  */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/* Verification: 
		 		8a. 'Select a reason' should highlight in red color	 */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().verifyAndClickThreedotsMenu().verifyRequestRefundMenu().clickRequestRefund()
		.clickReasonBtn().clickOutside().verifyReasonError();
	}

	// Verify the the data in the pop up 'request a refund'
	public void verifyDataInRequestRefundPopUp(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/* Pre-Condition: 
		 			Gvaccount should have billing history with international calls	 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);

		/* Procedure: 
		 		1. Login to the Google Voice account
		 		2. Navigate to Settings page
		 		3. Click on the 'Billing History' button to open the billing history page
		 		4. Hover over the mouse on the items in the billing history
		 		5. Click on threedots menu near an eligible history
		 		6. Click on the 'Request Refund' button
		 		7. Select a reson from the drop down menu
		 		8. Obseve the call info in the pop up	 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/* Verification: 
		 		8a. Call info include the recepient number,date and time
  				8b. the info should match that in the billing history log  */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().captureLogData();
	}

	// Verify that clicking on cancel button will close the pop up
	public void clickCancelButtonCloseThePopUp(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/* Pre-Condition: 
		 		Gvaccount should have billing history with international calls */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/* Procedure:
				1. Login to the Google Voice account 
				2. Navigate to Settings page
		 		3. Click on the 'Billing History' button to open the billing history page 
		 		4. Hover over the mouse on the items in the billing history 
		 		5. Click on threedots menu near an eligible history 
		 		6. Click on the 'Request Refund'button  
		 		7. Click on the 'Cancel' button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/* Verification: 
		 		7a. Pop up window should close when clicking on the 'cancel'button */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().verifyAndClickThreedotsMenu().verifyRequestRefundMenu().clickRequestRefund()
		.clickCancelBtn().verifyWindoClose();
	}
}
