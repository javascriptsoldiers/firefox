package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.CallingRatesPage;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.SettingsPayments;
import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class Wolverine extends SuiteBase {

	// Enterprise users have the following experience
	public void enterpriseGVUserHasNoAccessToCreditsMenu(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Click the three dot menu from the left panel 4. Click the
		 * Settings > Payments menu item
		 */ 
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		/*
		 * Verification: 4a. User should not be given the option to add credit or allow
		 * refunds to his account 4b. The only clickable link in the Payments section is
		 * 'Billing History'
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.verifyBillingHistoryIsClickable().movingFromBillingHistoryToSettingsPage()
		.verifyAddCreditDisplayedInWolverine();

	}

	// No opt in to have Google analyze voicemail transcripts - to improve VM tanscription quality
	public void enterpriseGVUserDoesNotHaveTheOptionToToggleON(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User is signed into his Enterprize GV account
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments setPmntPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Click the three dot menu from the left panel 4. Click the
		 * Voicemail menu item
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		settPage.clickVoicemailTab();
		/*
		 * Verification: 4a. User should not see the following toggle (available for
		 * consumer accounts): Let Google analyze voicemail transcripts"
		 */
		setPmntPage.verifyVoicemailTranscriptsToggle();
	}

	//GV Enterprise user has access to corp. directory for his organization when he initiates a GV call or Message 
	public void enterpriseGVUserShallHaveAccessToCorpdirectory(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/* Pre-Condition:
							1. User is signed into his Enterprize GV account*/
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb hmweb= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/*Procedure:		1. Log into Gmail account
		  					2. Navigate to Google Voice URL's Landing Page
		  					3. Initiate a call/Message - click Send a message Or Place a call
		  					4. Start typing a name or a Phone number in the text box labelled To:*/

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmweb.verifywolverineAccount(email);
		hmPage.clickMainMenu().clickTab(Constants.Calls); 
		callPage.EnteraNameOrNum().enterPhoneNumberForSearch();


		/* Verification:
		 * 4a. User should see the first 10 entries from his personal contacts*/
		settPage.verifyPersonalContacts();

		/*4b. User should see the next set of entries from his corporate directory in a scrollable list*/
		settPage.verifyCorpDirectoryContacts();

		/*4c. Both sets of contacts should be separated by a label 'Directory' (for dierctory contacts)*/
		settPage.verifyCorpDirectorySeperation();
	}

	// Enterprise GV user shall not have access to his balance column in Billing history
	public void enterpriseGVUserShallNotHaveAccessToHisBalanceColumn(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments setPmntPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Launch settings from the left three dot menu > Settings >
		 * Payments > Billing History
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		settPage.clickPaymentTab();
		setPmntPage.clickBillingHistoryTab();
		/*
		 * Verification: 4a. User should only see the following columns : Date, Time,
		 * Type, Destination, Duration, Amount 4b. Unlike consumer GV accountholders,
		 * Enterprise user should not see his Balance column
		 */

		setPmntPage.verifyAllColumnsInBillingHistory().verifyBalanceColumn();
		
	}

	// Enterprise GV user shall not have access to Legacy GV site
	public void tappingTheLinkToCheckCallingRatesShouldNotLand(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments setPmntPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		CallingRatesPage callRtPage = PageFactory.initElements(Utils.uBase.webDriver, CallingRatesPage.class);

		/*
		 * Procedure: 
			 		1. Log into Gmail account 
			 		2. Navigate to Google Voice URL's Landing Page 
			 		3. Launch settings from the left three dot menu > Settings > Payments > Billing History 
			 		4. Clicks the link next to check rates menu item */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		settPage.clickPaymentTab();
		setPmntPage.clickCallingRatesIcon();
		Thread.sleep(1000);
		Utils.uBase.switchToNewWindow();
		Utils.uBase.checkPageReady();
		/*
			 Verification: 
			 4a. User should not land on the legacy GV page by clicking the Google Voice logo in the calling rates page" */
		callRtPage.clickGoogleVoiceLogo().verifyNavigationOnClickingGvLogo();
	}

	//  User shall not have access to CHANGE, TRANSFER and DELETE his GV number 
	public void gVEnterpriseUserShouldNotSeeTheOptions(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account (takeover
		 * account/managed account)
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Navigate to settings from the hamburger menu 4. Observe GV
		 * number under Phone numbers
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmPage.clickSettings();
		/*
		 * Verification:4a. User does not have the options to CHANGE, TRANSFER and
		 * DELETE his GV number
		 */
		settPage.verifyChangeTrfrAndDelBtnsInWolvAcc();
	}

	// User shall no longer have incoming call options Record call (4), Switch linked phone (*), Start conference call (5)
	public void gVEnterpriseUserShouldNotSeeTheIncomingCall(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account (takeover
		 * account/managed account)
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Launch settings from the left three dot menu 4. Scroll to
		 * CALLS sub-heading
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmPage.clickSettings();
		/*
		 * Verification:4a. User no longer sees the incoming call options to : Record
		 * call (4), Switch linked phone (*), Start conference call (5)
		 */
		settPage.clickCallsInSettings().verifyIncomingCallOptions();
	}

	//  Call Screening defaults to OFF for enterprise accounts (managed accounts) 
	public void callScreeningDefaultsToOffForEnterpriseAccounts(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/* Pre-Condition:
					1.  User is signed into his Enterprize GV account (managed account)*/
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*Procedure:	1. Log into Gmail account
	  						2. Navigate to Google Voice URL's Landing Page
	  						3. Click the hamburger menu for quick navigation panel
	  						4. Under the calls subheading - Check the toggle for Screen calls*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmPage.clickSettings();
		/* Verification:4a. Screen calls toggle must be defaulted to OFF position for new managed accounts*/
		settPage.clickCallsInSettings().verifyScreenCallsToggleEnabled();
	}

	// Enterprise user with UK GV number should not have messaging section in settings
	public void enterpriseUserShouldNotHaveMessagingSectionInSettings(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		//			Utils.uBase.launchWebApplication();
		Utils.uBase.getDriverInstance();
		Utils.uBase.setUrl("https://accounts.google.com");
		Utils.uBase.openUrl();
		Utils.uBase.checkPageReady();
		AdvanceReporting.addLogs("pass","Launched Accounts.google.com ");
		AdvanceReporting.addLogs("pass","Launched Accounts google","Launched Accounts google");

		/*Pre-Condition:
	  				1. UK GV number should be assigned to the user from admin provisioning page 
	  				2. User is signed into his Enterprise GV account (managed account) */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/*  Procedure:
				  1. Log into Accounts.google.com with valid credentials
				  2. Navigate to Google Voice URL's Landing Page
				  3. Click the three dot menu from the left panel
				  4. Click the Settings */
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().emergencyCallingAlert();
		Thread.sleep(2000);
		Utils.uBase.openNewTab();
		Utils.uBase.setUrl("https://voice.google.com");
		Utils.uBase.openUrl();
		hmweb.verifywolverineAccount(email);

		/* Verification:
				  4a. User should not see the messaging section in the settings page */

		hmPage.clickSettings();
		settPage.verifyMessagesInSettings();
	}

	// Enterprise user should not have messaging forwarding section in settings as they dont support message forwarding
	public void enterpriseUserShouldNotHaveMessagingForwardingFunctionality(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/* Pre-Condition: 
		 			1. User is signed into his Enterprise GV account 
		 			2. User should have a US GV number */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/* Procedure: 
		 		1. Log into Gmail account 
		 		2. Navigate to Google Voice URL's Landing Page 
		 		3. Click the three dot menu from the left panel 
		 		4. Click the Settings>Messages section */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		//settPage.verifyUsGvNum();
		settPage.clickMessageTab();
		/* Verification: 
		 		4a. User should not see the message forwarding section in the settings page" */
		settPage.verifyMessageForwardingSection();
	}

	// Enterprise user should see the country picker with the country flags while adding linked number
	public void enterpriseUserShouldSeeTheCountryPickerWhileAddingLinkedNumber(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account 2. User
		 * should have a US GV number
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/*
		 * Procedure: 1. Log into Accounts.google.com with valid credentials 2. Navigate
		 * to Google Voice URL's Landing Page 3. Click the three dot menu from the left
		 * panel 4. Click the Settings>Phone number section 5. Click on add a new linked
		 * number 6. Click on the drop down near the country picker on the verification
		 * pop up
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmweb.verifywolverineAccount(email);
		gvSignInPage.emergencyCallingAlert();
		hmPage.clickSettings();
		settPage.verifyUsGvNum();
		settPage.clickNewLinkedNumberBtn().clickCountryDropdown();
		/*
		 * Verification:6a. User should see country flags(right now US and UK flags)
		 * when clicking on the list in verification pop up
		 */
		settPage.verifyCountryFlags();
	}
	public void enterpriseGVUserShouldNotSeeLinksToLegacyGVPageFromTheSettingsMenu(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/*
		 * Pre-Condition: 1. User is signed into his Enterprize GV account (takeover
		 * account/managed account)
		 */
		hmweb.verifywolverineAccount(email);
		gvSignInPage.emergencyCallingAlert();
		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Launch settings from the left three dot menu > Legacy GV
		 */
		hmPage.clickMainMenu().verifyLegacyVoiceOptn();
	}
	public void enterpriseGVUserShouldNotSeeAutoRechargeSectionInTheSettingsMenu(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		SettingsPayments settPay=PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account (takeover
		 * account/managed account)
		 */
			 
		hmweb.verifywolverineAccount(email);
		/* Procedure:
			 1. Log into Accounts.google.com with valid credentials
			 2. Navigate to Google Voice URL's Landing Page
			 3. Click the three dot menu from the left panel
			 4. Click the Settings > Payments menu item*/
		gvSignInPage.emergencyCallingAlert();
		hmPage.clickSettings();
		settPage.clickPaymentTab();
		/*
		 * Verification: 4a. User should not see the auto recharge section in the
		 * payments
		 */
		settPay.verifyAutoRechargeNotPresent();
		
}
}
