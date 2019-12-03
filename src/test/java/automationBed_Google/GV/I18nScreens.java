package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.VoicemailPage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class I18nScreens extends SuiteBase {

	/* Verify right click on messages texts. */
	public void i18nRightClickMenuScreen(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/*
		 * Pre-Condition: Login with Full GV user
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Procedure:1) Navigate to Moya home page (/) Or message page (/message/) 2)
		 * Click on individual message conversation item. (not the group conversation
		 * item) 3) Right click on any existing individual message on the conversation,
		 * which has sent/received.
		 */

		hmPage.clickMainMenu().clickMessages();
		msgPage.clickSendNewMessage().typeNumberAndComposeMsg(data).sendComposedMessage().rightClickOnExistingSentMsg();

		/*
		 * Verification: Verify right click menu items texts, 1. "Copy text" 2. "Delete"
		 */
		msgPage.verifyMenuHasCopyTextDeleteOptions();

		/* Clear the test data */
		msgPage.cleanCreatedMessageLog(data);
	}

	/* Verify right click menu item "Copy to" action status texts. */
	public void i18nMessageCopyTextStatusScreen(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/*
		 * Pre-Condition: Login with Full GV user
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Procedure:1) Navigate to Moya home page (/) Or message page (/message/) 2)
		 * Click on individual message conversation item. (not the group conversation
		 * item) 3) Right click on any existing individual message on the conversation,
		 * which has sent/received. 4. Click on "Copy to"
		 */

		hmPage.clickMainMenu().clickMessages();
		msgPage.clickSendNewMessage().typeNumberAndComposeMsg(data).sendComposedMessage().clickOnCopyToTextOption();

		/*
		 * Verification: 1. Message copied to clipboard.
		 */
		msgPage.verifyMessageCopiedToClipboard();

		/* Clear the test data */
		msgPage.cleanCreatedMessageLog(data);
	}

	/* Verify Message Delete Confirm Screen action status texts. */
	public void i18nMessageDeleteConfirmScreen(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/*
		 * Pre-Condition: Login with Full GV user
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Procedure:1) Navigate to Moya home page (/) Or message page (/message/) 2)
		 * Click on individual message conversation item. (not the group conversation
		 * item) 3) Right click on any existing individual message on the conversation,
		 * which has sent/received. 4. Click on "Delete"
		 */
		hmPage.clickMainMenu().clickMessages();
		msgPage.clickSendNewMessage().typeNumberAndComposeMsg(data).sendComposedMessage().clickOnDeleteOption();

		/*
		 * Verification: 1. "Delete this message?
		 */
		msgPage.verifyDeleteThisMessage();

		/* 2. "CANCEL" */
		msgPage.verifyCancelButton();

		/* 3. "DELETE" */
		msgPage.verifyDeleteBtn();

		/* Clear the test data */
		msgPage.cleanCreatedMessageLog(data);
	}

	/* Verify delete call item confirmation screen and texts. */
	public void i18nCallsItemDeleteConfirmScreen(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/*
		 * Pre-Condition: Login with Full GV user
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Procedure: 1) Navigate to Moya Call page (/calls) 2) Click on any call item
		 * 3) Click on "More option" button on the right (three vertical dots) 4) Click
		 * on "Delete" menu item.
		 */
		hmPage.clickMainMenu().clickTab("Calls");
		callPage.selectFirstContactFromCallsList().deleteExistingCall();

		/*
		 * Verification: 1. "Delete this message?
		 */
		callPage.verifyDeleteThisCall();

		/* 2. "CANCEL" */
		callPage.verifyCancelButton();

		/* 3. "DELETE" */
		callPage.verifyDeleteBtn();
	}

	/* Verify delete voicemail item confirmation screen and texts */
	public void i18nVoicemailItemDeleteConfirmScreen(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		VoicemailPage vmp = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);

		/*
		 * Pre-Condition: Login with Full GV user
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Procedure: 1) Navigate to Moya voicemail page (/voicemail) 2) Click on any
		 * voicemail item 3) Click on "More option" button on the right (three vertical
		 * dots) 4) Click on "Delete" menu item.
		 */
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		vmp.selectFirstContactFromVoiceMailList().deleteExistingVoiceMail();

		/*
		 * Verification: Verify confirmation screen texts, 1. Delete this voicemail?
		 */
		vmp.verifyDeleteThisVoiceMail();

		/* 2. CANCEL */
		vmp.verifyCancelButton();

		/* 3. DELETE */
		vmp.verifyDeleteBtn();
	}

	/* Verify Moya with no messages screen texts. */
    public void i18nMoyaWithNoMessagesScreen(String email, String password, String data) throws Exception 
    {   
          /* Launching google voice application */
          Utils.uBase.launchWebApplication();

          GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
          HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
          MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

          /*Login with Full GV user*/
         gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

          /*
          * Pre-Condition: 
           * Login with GV Full user. 
           * 1. With no messages on the message folder.
          * Procedure: 
           * 1) Navigate to Moya home page (/) or message page (/messages)
          */
          hmPage.clickMainMenu().clickMessages();
          msgPage.deleteAllMessages();

          /*
          * Verification: 
           * The empty message display text, 
           * 1. No messages */
          msgPage.verifyNoMessageText();

          /*
          * 2. You'are allcaught up
          */        
          msgPage.verifyYourAllCaughtUpText();
    }

	public void i18nRemovePhoneNumberScreen(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settingsPage=PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*Pre-Condition:
				1. Login with GV Full user.
				2. With one or more forwarding phone numbers.*/
    
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		// settingsPage.linkMobileIfNotAlreadyLinked(Constants.phoneNoToBeLinked,
		// Constants.SAMSUNGGalaxyS8Plus_SM_DUT1);

		/*
		 * Procedure: 1) Navigate to Moya settings page (/settings/ 2) click on "X"
		 * button adjacent to the phone number you wish to remove.
		 */
		hmPage.clickSettings();
		settingsPage.removeLinkedNum();
		/*
		 * Verification: Delete link number confirmation screen texts are, 1. Remove
		 * linked number? 2. you won't be able to call using your Google Voice number or
		 * forward calls and messages to that devices 3. CANCEL 4. REMOVE
		 */
	}

	/* Verify Moya with no calls screen texts. */
	public void i18nMoyaWithNoCallItemsScreen(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login with Full GV user */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Pre-Condition: Login with GV Full user. 1. With no calls on the calls folder.
		 * Procedure: 1) Navigate to Moya calls page (/calls/
		 */
		hmPage.clickMainMenu().clickTab("Calls");
		callPage.deleteAllCalls();

		/*
		 * Verification: The empty message display text, 1. No messages
		 */
		callPage.verifyNoCallsText();

		/*
		 * 2. You'are allcaught up
		 */
		callPage.verifyYourAllCaughtUpText();
	}

	/* Verify Moya with no voicemail screen texts. */
	public void i18nMoyaWithNoVoicemailItemsScreen(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*
		 * Pre-Condition: 1. Login with GV Full user. 2. With one or more forwarding
		 * phone numbers.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.setupMDriver(1, Constants.SAMSUNGGalaxyS8Plus_SM_DUT1, Constants.MESSAGE_APP_PACKAGE_NAME, Constants.MESSAGE_APP_ACTIVITY);
//		settingsPage.linkMobileNumberToGV(Constants.SAMSUNGGalaxyS8Plus_Numb);
		/*
		 * Procedure: 1) Navigate to Moya settings page (/settings/ 2) click on "X"
		 * button adjacent to the phone number you wish to remove.
		 */
		hmPage.clickSettings();
		/*
		 * Verification: Delete link number confirmation screen texts are, 1. Remove
		 * linked number? 2. you won't be able to call using your Google Voice number or
		 * forward calls and messages to that devices 3. CANCEL 4. REMOVE
		 */
		VoicemailPage vmp = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);

		/*
		 * Pre-Condition: Login with Full GV user
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Pre-Condition: Login with GV Full user. 1. With no voicemail on the voicemail
		 * folder. Procedure:1) Navigate to Moya calls page (/voicemail
		 */
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		vmp.deleteAllVoiceMails();

		/*
		 * Verification: The empty message display text, 1. No messages
		 */
		vmp.verifyVoiceMailsText();

		/*
		 * 2. You'are allcaught up
		 */
		vmp.verifyYourAllCaughtUpText();
	}

	public void i18nSendNewMessageScreen(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		/*
		 * Pre-Condition: Login with Full GV user
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		// settingsPage.linkMobileIfNotAlreadyLinked(Constants.phoneNoToBeLinked,
		// Constants.SAMSUNGGalaxyS8Plus_SM_DUT1);

		/*
		 * Procedure: 1) Navigate to Moya home page (/) Or message page (/message/) 2)
		 * Click on "Send a message" button
		 * 
		 * Verification: Verify specific texts on the screen, 1. To: 2. Type a name or
		 * phone number 3. Type a message 4. Verify tool-tips texts, "Add images",
		 * "Send message"/
		 */
		hmPage.clickMainMenu().clickMessages();
		String str[] = data.split("\\|");
		msgPage.clickSendNewMessage().verifyToScrnTxt().clickToMsgTxt().verifyTypNamePhoneScrnTxt().setNumMsgToField(str[0]).clickToMsgTxt().verifyTypMsgPlcHolder().setTextNewMsg(str[1]).clickToMsgTxt().verifyAddImgToolTip().verifySendMsgToolTip();
	}

}
