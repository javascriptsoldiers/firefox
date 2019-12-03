package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.VoicemailPage;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class InlineClick2Call extends SuiteBase {

	/* UI Check for Click 2 Call */
	public void clickToCallIsAvailableInCallPage(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* Procedure: Go to the call page tap on "make a call" and Enter valid number */
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum();

		/* Verify: A "v" icon appear along with call icon and its clickable */
		callsPage.verifyDropDownPresent();
		callsPage.clickCallDropDown();
	}

	/* Ui check on "Use my phone to call" in 3 dot menu */
	public void checkUseMyPhoneToCallOption(String email, String password, String data) throws Exception {
		// For generating call and voice mail
		//ReceiveCallAndMessages.makeCall(data);
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		VoicemailPage voicePage = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		GeneralActivitiesPage gAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		

		/* Procedure: 
		  		1. Go to the message tab and click first message, Select the 3 dot option to open the menu 
		 		2. Go to the voice tab and click first message, Select the 3 dot option to open the menu
		 		3. Select the 3 dot option to open the menu*/
		
		/*Verify:
		  The top option is "Use my phone to call".*/
		
		//msgPage.uiCheckForFirstMessage(data, Constants.TestMsg);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Thread.sleep(15000);
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		callsPage.clickfirstCallInList();
		gAPage.clickThreeDotsMenuWithElement();
		callsPage.verifyUseMyPhoneToCallIn3DotMenu();
		Thread.sleep(5000);
		hmPage.clickTab(Constants.Messages);
		msgPage.clickfirstMessageInList();
		gAPage.clickThreeDotsMenuWithElement();
		msgPage.verifyUseMyPhoneIn3DotMenu();
		Thread.sleep(5000);
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		voicePage.clickfirstVoiceInList();
		gAPage.clickThreeDotsMenuWithElement();
		voicePage.verifyUseMyPhoneIn3DotMenu();		
	}

	/* Wolverine check inline click to call is not available */
	public void uiCheckForClickToCallForWolverineAccount(String email, String password, String data) throws Exception {
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage messagePage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmPage.clickMainMenu().clickCalls();

		// No "v" is present beside the call icon
		callsPage.EnteraNameOrNum().verifyDropDown(data);

		// No "Use my phone to call" option is present for

		// Calls
		callsPage.clickfirstCall().clickThreeDots().verifyUseMyPhoneToCall();
		// Messages
		hmPage.clickMainMenu().clickMessages();
		messagePage.clickFirstMessage();
		callsPage.clickThreeDots().verifyUseMyPhoneToCall();
		// Voicemails
		hmPage.clickMainMenu().clickVoicemail();
		// vMPage.clickfirstVoicemail();
		callsPage.clickThreeDots().verifyUseMyPhoneToCall();
	}

	/* Functionality check for drop-down option */
	public void dropdownOptionUseMyPhoneToCall(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* Procedure: Go to the call page tap on "make a call" and Enter valid number */
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum();

		/* click on the "v" for drop-down option "Use my phone to call" and select it */
		callsPage.verifyDropDownPresent();
		callsPage.clickCallDropDown();
		callsPage.clickUseMyPhoneOption();

		/* Verify User able to select "Use my phone to call" and a pop up window appears after it. */
		callsPage.verifyUseMyPhonePopUp();
	}

	// Ui check for click to call for Wolverine account
	public void wolverineCheckInlineClickToCallIsNotAvailable(String email, String password, String data) throws Exception {
		// For generating call 
		//ReceiveCallAndMessages.makeCall(data);

		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account 2. User
		 * should have a US GV number
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		VoicemailPage voicemailPage = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//msgPage.uiCheckForFirstMessage(data, Constants.TestMsg);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		Thread.sleep(25000);

		/* 	Procedure: Scenario A:
  			1. Login to google voice using wolverine Account
  			2. Go to the call page tap on "make a call"
  			3. Enter a valid number in call field */
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		callPage.EnteraNameOrNum().enterPhoneNumber(Constants.dummyPhNumber);
		/*Verify: A. No "v" is present beside the call icon*/
		callPage.verifyCallDropDownPresent();

		Thread.sleep(25000);

		/* Scenario B(for Calls):
  			1.Select message/voicemail/calls tab 
  			2.Tap on any existing conversation/call
  			3. Select the 3 dot option to open the menu 
		 */
		hmPage.clickTab(Constants.Calls);
		callPage.selectFirstContactFromCallsList().clickMoreOptn();
		/*Verify:B. No "Use my phone to call" option is present.*/
		callPage.verifyUseMyPhoneToCallOption();
		Utils.uBase.refresh();

		Thread.sleep(36000);

		/* Scenario B(for Message):
			1.Select message/voicemail/calls tab 
			2.Tap on any existing conversation/call
			3. Select the 3 dot option to open the menu 
		 */
		hmPage.clickMainMenu().clickMessages();
		msgPage.selectFirstItemFromList().clickMoreOptn();
		/*Verify:B. No "Use my phone to call" option is present.*/
		callPage.verifyUseMyPhoneToCallOption();
		Utils.uBase.refresh();

		/* Scenario B(for Voicemail):
		1.Select message/voicemail/calls tab 
		2.Tap on any existing conversation/call
		3. Select the 3 dot option to open the menu 
		 */
		hmPage.clickMainMenu().clickVoiceMail();
		voicemailPage.selectFirstItemFromList().clickMoreOptn();
		/*Verify:B. No "Use my phone to call" option is present.*/
		callPage.verifyUseMyPhoneToCallOption();		
	}
}