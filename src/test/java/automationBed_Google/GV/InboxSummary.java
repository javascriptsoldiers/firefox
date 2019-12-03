package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.VoicemailPage;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class InboxSummary extends SuiteBase{
	
	/* Verify correct unread items count. */
	public void inboxSummaryRedirectToCalls(String email, String password, String data) throws Exception {
	
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		VoicemailPage voicemails =PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Login to Application */	
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickMessages();
		
		//Pre-Condition: Having few unread items in messages, calls and voicemails.
		
		// msgPage.uiCheckForMessage(data);	
		/*
		 * Procedure: 1, Login 2. Click the inbox summary page, unread call items.
		 * Verification: Verify that by clicking on unread call items, redirecting to
		 * calls folder.
		 */
		// hmPage.clickTab("Calls");
		callsPage.clickUnreadItems().verifyCallsTabIsAccessible();	
		
	}

	
	/* Verify correct unread items count. */
	public void inboxSummaryRedirectToVoiceMails(String email, String password, String data) throws Exception {
	
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		VoicemailPage voicemails =PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GVPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Login to Application */	
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickMessages();
		
		//Pre-Condition: Having few unread items in messages, calls and voicemails.
		GVPage.receiveMultipleVoicemails(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*
		 * Procedure: 1, Login 2. Click the inbox summary page, unread voicemail items.
		 * 
		 * Verification: Verify that by clicking on unread vicemail items, redirecting
		 * to voicemail folder.
		 */
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		voicemails.verifyVoicemailsPresent();
		
		//Clean created data		
		msgPage.cleanCreatedMessageLog(Constants.phoneNumber);
		voicemails.cleanCreatedVoicemailLog(Constants.phoneNumber);
		callsPage.cleanCreatedCallLog(Constants.phoneNumber);
		
	}
	
	/* Verify correct unread items count. */
	public void inboxSummaryRedirectToMessage(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
	
		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		VoicemailPage voicemails =PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GVPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Procedure:
		* 1. Login */ 
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GVPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		//hmPage.clickMainMenu();
		
		//Pre-Condition: Having few unread items in messages, calls and voicemails.
		//msgPage.uiCheckForMessage(data);
		/*
		 * ReceiveCallAndMessages.makeCall(data); Thread.sleep(30000);
		 * ReceiveCallAndMessages.makeMissedCall(data);
		 */
		/* 2. Click the inbox summary page, unread message items.*/		
		hmPage.clickMainMenu().clickTab(Constants.Calls);
				
		/* Verification: Verify that by clicking on unread message items, redirecting to
		* message folder.*/		
		msgPage.clickOnMsgUnreadItems().verifyMessagesTabIsAccessible();		
	}
	
	/* Verify correct unread items count. */
	public void inboxSummaryUnreadItems(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		// ReceiveCallAndMessages.makeMissedCall(data);
		 //ReceiveCallAndMessages.receiveThreeMessages(data);
		
		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		VoicemailPage voicemails =PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		HomePageWeb homePage= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		GeneralActivitiesPage GVPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		HomePageWeb homePageWeb=PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		/* Procedure:
		* 1. Login */ 
		//GVPage.multipleVoicemails(data, 2);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		//GVPage.receiveMultipleVoicemails(Constants.voipTwoId, Constants.pwd2, data, 2);
		GVPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 3);
		Utils.uBase.switchToNewWindow();

        //GAPage.receiveMultipleVoicemails(Constants.voipTwoId,Constants.pwd2,data,2);
            callsPage.EnteraNameOrNum().enterNumAndMakeAcall(data);
            Thread.sleep(30000);
            callsPage.clickOnCallEndBtn();
            
            Thread.sleep(3000);

            callsPage.EnteraNameOrNum().enterNumAndMakeAcall(data).clickOnCallEndBtn();
            Utils.uBase.switchToOldWindow();
            Utils.uBase.refresh();
        hmPage.clickMainMenu().clickTab(Constants.Messages);
      //  homePage.verifyUnreadItemsInDefaultPage().verifyInboxSummaryHasUnreadItems(); 

}

}


