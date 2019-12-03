package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.VoicemailPage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class UserType extends SuiteBase {



	/*Verify that GV full user display all the tabs.
	 * Pre-Condition: GV full user account.
	 * 
	 * Procedure: 1. Login with GV user
	 * 
	 * Verification: 1. Verify that user can able to access, message tab, calls tab
	 * and voice mail tabs.
	 */

	public void userGvFull(String email, String password, String data) throws Exception 
	{
		//Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		CallsPage callsPage= PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		VoicemailPage vmPage = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		/*Procedure:
           1. Login with GV user*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*Verification:
           1. Verify that user can able to access message tab, calls tab and voice mail tabs.*/
		hmPage.clickMainMenu();
		hmPage.clickTab("Calls");
		callsPage.verifyCallsTabIsAccessible();

		hmPage.clickMessages();
		msgPage.verifyMessageTabIsAccessible();

		hmPage.clickVoiceMail();
		vmPage.verifyVoicemailAccesible();

	}

	//Verify hangout integrated user not receiving any messages in GV.
	public void userHangoutIntegrated(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePage=PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		//	Pre-Condition: Hangout Integrated user.	
		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*Procedure:
			1. Login with HO integrated user.
			2. Click on message tab.
		 */
		hmPage.clickMainMenu().clickMessages();
		homePage.RemoveIfHangoutIsAlreadyIntegrated();

		/*
		 * Verification: 1. Verify that bottom line display
		 * "It is hangout integrated user" also you have option to "Turn it off" by
		 * selection "Google Voice"
		 * 
		 */		
		homePage.clickGoogleApps().clickGmail().integrateHangouts();
		GAPage.switchingToWindowByIndex(0);
		homePage.verifyHangoutsMessageDisplayedInGV().removeHangoutIntegration();			
	}

	//Verify able to turn off hang out integration using "Turn off" option
	public void userHODisconnect(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePage=PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		SettingsPage settingsPage=PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		//	Pre-Condition: Hangout Integrated user.

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage=PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*
		 * Procedure: 1. Login with HO integrated user. 2. Click on message tab.
		 */
		hmPage.clickMainMenu().clickMessages();	
		homePage.RemoveIfHangoutIsAlreadyIntegrated();

		/*
		 * Verification: 1. Verify disabled "Send a message" button.
		 */
		homePage.clickGoogleApps().clickGmail().integrateHangouts().verifySendMsgBtnDisabledWhenHangoutMsgPresent();

		/*Procedure:
					1. Navigate to settings page.
					2. Click "Disconnect" on the hangout section button.*/


		hmPage.clickSettings();
		settingsPage.clickHangoutsTab().clickDisconnect().clickDisconnectHangoutsPopUp().clickCloseSettings();

		/*
		 * Verification: 1. Verify able to send/receive messages from Google voice.
		 */
		homePage.verifySendMsgBtnStatus(Constants.enabled);
		Thread.sleep(2000);

		hmPage.clickMainMenu().clickTab(Constants.Messages);
		String str[]=data.split("\\|");

		//Sending message from current account to a second account
		msgPage.clickSendNewMessage().setNumMsgToField(str[2]).setTextNewMsg(GAPage.generateUniqueString()).clickToMsgTxt().sendComposedMessage();

		//navigating to the new account to verify if message is sent after hangout is disconnected
		homePage.clickGoogleAccountIcon().clickAddAccountOption();
		Utils.uBase.switchWindowByTitle("Google Voice");
		gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).clickNextButton();
		hmPage.clickMainMenu().clickTab(Constants.Messages);

		msgPage.verifyMessageWithGeneratedStringIsDisplayed(GeneralActivitiesPage.data);

		//Sending message from new account to old one to verify messages are received after user hangout disconnect
		msgPage.clickSendNewMessage().setNumMsgToField(str[3]).setTextNewMsg(GAPage.generateUniqueString()).clickToMsgTxt().sendComposedMessage();			
		Utils.uBase.refresh();
		GAPage.switchingToWindowByIndex(0);
		Utils.uBase.refresh();
		msgPage.verifyMessageWithGeneratedStringIsDisplayed(GeneralActivitiesPage.data);
	}


}
