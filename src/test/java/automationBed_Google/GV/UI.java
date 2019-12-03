package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.SettingsPayments;
import automationBed_Google.pom.gv.VoicemailPage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class UI extends SuiteBase {

	// Verify Home page UI - UIHomePage
	public void uiHomePage(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		
		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();	

		/*Verifications : Verify it landing on calls tab by default.*/
		homePage.verifyCallTabIsDisplayed();

		/* Verify Navigational menu button on top left.*/
		homePage.verifyNavigationMenuIsDisplayed();

		/* Verify the new "Google Voice" logo.*/
		homePage.verifyGoogleVoiceLogoIsDisplayed();

		/* Receiving message to check unread message label */
		//msgPage.uiCheckForMessage(data);
		//GAPage.reciveMultipleMissCalls(data, 3);
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*Verify it has 3 columns, 1st column is mini buttons, 2nd column is message items, 3rd column with Greeting and unread items count.*/
		homePage.verifyMiniMenuButtonsAreDisplayed().verifyGreetingsIsDisplayed().verifyUnreadCountIsDisplayed();
	}	

	// UI Privacy Terms 
	public void uiPrivacyTerms(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settingPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb hmWebPage= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* Verifications : Click Settings on home page */
		hmMenuPage.clickSettings();

		// To dismiss notification
		Utils.uBase.clickOnNotificationAllowBtn();

		/*Verify: redirected to setting page */
		hmMenuPage.verifyRedirectedtoSettingPage();

		/* Verifications : Click on Privacy and Terms */
		settingPage.verifyClickOnPrivacyTerms();

		/*Verify: Click on Privacy */
		settingPage.verifyClickOnPrivacy();
		hmWebPage.switchingToFirstWindow();

		/* Verify: Redirected to Privacy */
		settingPage.verifyRedirectedToPrivacy();

		hmWebPage.switchingToZerothWindow();

		/*Verify: Click on Terms */
		settingPage.verifyClickOnTerms();
		//hmWebPage.switchingToFirstWindow();

		/* Verifications : Redirected to terms */
		settingPage.verifyRedirectedToTerms();
	}

	/* UI Google Voice Logo	 */
	public void uiGoogleVoiceLogo(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* Verify the new "Google Voice" logo. */
		homePage.verifyGoogleVoiceLogoIsDisplayed();
	}

	/* UI Settings	 */
	public void uiSettings(String email, String password, String data) throws Exception	{
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settingPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* Verifications : Click Settings on home page */
		hmMenuPage.clickSettings();

		// To dismiss notification
		Utils.uBase.clickOnNotificationAllowBtn();

		/* Verify: Navigated to Settings page */
		hmMenuPage.verifyRedirectedtoSettingPage();

		/* Verifications : Click on Do not disturb */
		settingPage.clickDoNotDisturb();

		/* Verifications : Enable do not disturb */
		settingPage.enableDoNotDisturb();

		/* 'Do not disturb is turn on' banner should be visible on all the tabs (Calls, Messages, Voice mails, Archive, Spam) */
		settingPage.verifyDoNotDisturbIsOnBanner();

		/* Disable do not disturb */
		settingPage.clickEndNowToDisableDoNotDisturb();
	}

	/* UI Navigational Menu	 */
	public void uiNavigationalMenu(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* Procedure : Click on main menu */
		/* Verifications : Verify the all the navigational menu items are present and visible */
		hmMenuPage.clickMainMenu().selectCallsTab().verifyNavigationalMenu();

		/* Verify the displayed navigational menu will be auto hide if click on main menu again */
		hmMenuPage.clickMainMenu().verifyHidingNavigationalMenu();
	}

	/* UI Message Items Scroll */
	public void uiMessageItemsScroll(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* Navigate to messages */
		hmMenuPage.clickMainMenu().clickTab("MessagesTab");

		/*	2. Click on "Message" tab
			3. Scroll down to load more message items.
			4. Scroll up */ 
		msgPage.verifyScrollDownLoadMessages();
		msgPage.verifyScrollUpToFirstMessage();
	}

	// UI MessageConversationsScroll
	public void uiMessageConversationsScroll(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GVPage=PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		HomePageWeb HomePageWeb= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		//msgPage.uiCheckForFirstMessage(data, Constants.messageText);
		//GVPage.reciveMultipleTestMsgs(data, 15);
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
        //GVPage.receiveUniqeMessage(Constants.voipTwoId,Constants.pwd2,data,1);
        Utils.uBase.clickOnNotificationAllowBtn();
        HomePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
        gvSignInPage.enterLoginID(Constants.voipTwoId).clickNextButton().enterPassword(password).clickNextButton();
        hmMenuPage.clickMainMenu().clickMessages();
        msgPage.clickSendNewMessage().typeNumberinMsgToField(data).typeFirstMsg().sendComposedMessage();
        msgPage.clickSendNewMessage().typeNumberinMsgToField(data).typeTestMsg().sendComposedMessage();
        int count=10;
        for(int i=0;i<count-1;i++) {
               msgPage.typeTestMsg().sendComposedMessage();
        }
        Utils.uBase.switchToOldWindow();
        Utils.uBase.refresh();

        /* Navigate to messages */
        hmMenuPage.clickMainMenu().clickTab(Constants.Messages);

        /* To generate messages */

        //msgPage.uiCheckForMessages(data);

        /*Click on first message and Scroll down to load more messages and Scroll up*/
        msgPage.clickfirstMessageInList();
        msgPage.verifyScrollUpToFirstMessageInConversation();
      //  msgPage.cleanCreatedMessageLog(data);

	}

	// UI CallItemsScroll
	public void uiCallItemsScroll (String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Procedure: 1. Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* 	2. Click on "Call" tab
			3. Scroll down to load more call items.
			4. Scroll up */
		hmMenuPage.clickMainMenu().clickTab("Calls");
		callPage.verifyScrollDownLoadCalls();
		callPage.verifyScrollUpToFirstCall();
	}

	// UI.VoiceMailItemsScroll
	public void uiVoiceMailItemsScroll (String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		VoicemailPage voicemailPage = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);

		/* Procedure: 1. Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* 	2. Click on "Call" tab
				3. Scroll down to load more call items.
				4. Scroll up */
		hmMenuPage.clickMainMenu().clickTab("VoicemailsTab");
		voicemailPage.verifyScrollDownLoadVoicemail();
		voicemailPage.verifyScrollUpToFirstVoicemail();
	}

	// UI PopupRelevantUserContactNames
	public void uiPopupRelevantUserContactNames (String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* Procedure:
		2. Compose new message "Send a message"
		3. Click on "To" input box
		4. Type few characters of contact name */
		hmMenuPage.clickMainMenu().clickTab("MessagesTab");
		msgPage.clickSendNewMessage();

		// 4. Type few characters of contact name */
		msgPage.EnterNameToField(data);

		/* Verification: 1. Verify that, it displayed relevant contact name with phone numbers as popup screen. */
		/* 2. Verify that, by scrolling it display multiple contact name with all their type of phone (e.g. Home, work, mobile, etc) */
		msgPage.verifySuggestionandContactListDisplayed();
		msgPage.verifyRelevantNameInPopUp(data);		
	}

	// UI Select User From Contact
	public void uiSelectUserFromContact(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* Procedure: 2. Compose new message "Send a message"
				3. Click on "To" input box */

		hmMenuPage.clickMainMenu().clickTab("MessagesTab");
		msgPage.clickSendNewMessage();

		/* 4. Type few characters of contact name */ 
		msgPage.EnterNameToField(data);
		//msgPage.verifySuggestionandContactListDisplayed();

		/* 1. Verify that, it displayed relevant contact name with phone numbers as popup screen. */
		msgPage.verifyContactListDisplayed();

		// msgPage.verifyRelevantNameInPopUp(data);	
		/* Select the contact name/phone number */
		msgPage.selectFromContactPopUp();

		/* Verify by selecting them, will create the "Phone chip" */
		msgPage.verifyPhoneChipCreated();
	}

	//Verify all the mini navigational buttons are visible and operational.
	public void uiMiniNavigationalButtons(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition:
		 * 
		 * 1. Current view has 3 columns (folders, items, and item content)
		 */
		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
//		hmMenuPage.clickTab(Constants.Calls);

		/*
		 Procedure:

		 1. Select the mini navigational buttons.
		 */
		/*
		 Verification:
		 1. Verify that all the mini navigational buttons are present and visible.
		 2. Verify that these buttons visible all the time, except when main navigational menu displayed. 
		 3. Verify that clicked or selected mini buttons highlighted with vertical color on left side of the mini button. 
		 4. Verify that, tool tip for the mini nav buttons are available.
		 */
		Thread.sleep(2000);
		Utils.uBase.checkPageReady();
		Thread.sleep(2000);
		callsPage.EnteraNameOrNum();
		//hmMenuPage.verifyMiniNavigationMenu();
		String A[] = Constants.imgUnselected.split("\\|");
		String B[] = Constants.imgToolTip.split("\\|");
		String C[] = Constants.imgSelected.split("\\|");
		for(int i=0;i<A.length;i++)
		{
			hmMenuPage.verifyMiniNavigationBtnsAndToolTip(A[i], B[i], C[i]);
		}
		
	}
	
	//Verify Credit is displayed correctly.
	public void uiCreditBalance(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: 
		 *  Test account is set up to use voice, and has existing credit.
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);

		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		/*
		 * Procedure: 
					1. Make a call that uses credit from this account. (Note: typically international calls will use credit).
	  				2. Make a note of how much credit was used for the call.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.captureCurrentBalanceBeforeCall();
		stngpg.clickCloseSettings();

		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().makeInternationalCall();

		/*
		 * Verification:
	  				1. Verify that the amount shown for credit is deprecated by the amount of credit used for the call.
		 */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().captureCallAmountDebited().clickBackArrowIcon().captureCurrentBalanceAfterCall().verifyCurrentBalanceAfterCall();
	}
	
	public void uiMoreOptionMenuItem(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GeneralActivitiesPage GVPage=PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//GVPage.reciveMultipleTestMsgs(data, 2);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		Utils.uBase.clickOnNotificationAllowBtn();
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GVPage.clickFirstItemInList().clickThreeDotsMenuWithElement();
		callsPage.verifySpecificMenuItemsOnCalls();
	}
	
	public void uiSettingsNavigationalButtons(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
				Utils.uBase.launchWebApplication();
				
				GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
				HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
				SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
				
				gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
				Utils.uBase.clickOnNotificationAllowBtn();
				hmPage.clickSettings();
				stngpg.verifyNavigatedToSettings().clickCloseSettings();
				hmPage.clickOnHelpIcon().verifyHelpPopup();
	}
}