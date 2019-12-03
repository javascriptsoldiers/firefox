package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.ArchivePage;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.SearchPage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.VoicemailPage;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class Archive extends SuiteBase{

	//Verify able to select multiple archive threads
	public void archiveThreadSelect(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		ArchivePage archPage = PageFactory.initElements(Utils.uBase.webDriver, ArchivePage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Procedure: 1. Click on Navigation bar (3 horizonatal lines) 
		 * 2. Click on archive tab 
		 * 3. Click on one or more than one Avatars of archive items.*/
		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		
		//Data creation
		//msgPage.uiCheckForMessages(data,Constants.messages);	
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		msgPage.clickMultipleAvatars();
		msgPage.archiveSelectMultipleAvatars();


		hmPage.clickMainMenu().clickArchive();
		/*Verification: 
		 * 1. Verify that able to select multiple threads of archive items.*/
		archPage.clickMultipleAvatars();
		callPage.verifyIfAvatarsAreSelected();


	}

	//Verify able to select multiple archive threads and unselect it.
	public void archiveThreadSelectUnselect(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		ArchivePage archPage = PageFactory.initElements(Utils.uBase.webDriver, ArchivePage.class);
		VoicemailPage vmp = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Procedure: 1. Click on Navigation bar (3 horizonatal lines) 
		 * 2. Click on archive tab 
		 * 3. Click on one or more than one Avatars of archive items.*/

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		
		//Data creation
		//msgPage.uiCheckForMessages(data,Constants.messages);	
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		msgPage.clickMultipleAvatars();
		msgPage.archiveSelectMultipleAvatars();
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickArchive();
		/*Verification: 
		 * 1. Verify that able to select multiple threads of archive items.*/
		archPage.clickMultipleAvatars();
		/* 2. Verify that able to unselect multiple threads of archive items. */
		archPage.unSelectMultipleAvatars();
		vmp.verifyItemsSelectUnselect();
	}

	//Verify able to restore multiple archive threads.
	public void archiveThreadSelectRestore(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		ArchivePage archPage = PageFactory.initElements(Utils.uBase.webDriver, ArchivePage.class);
		GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Procedure:
	                  1. Click on Navigation bar (3 horizonatal lines)
	                  2. Click on archive tab
	                  3. Click on one or more than one Avatars of archive items.
	                  4. Click on "restore" icon in upper left side */

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		
		//Data creation
		//msgPage.uiCheckForMessages(data,Constants.messages);	
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		msgPage.clickMultipleAvatars();
		msgPage.archiveSelectMultipleAvatars();

		hmPage.clickMainMenu().clickArchive();
		archPage.clickMultipleAvatars();
		/* Verification: 1. Verify that able to restore multiple threads of archive items. */
		archPage.clickRestoreBtn().verifyRestoreCnfrmPopUp();

	}

	// Verify items in the Archive folder can be deleted.
    public void archiveDelete(String email, String password, String data) throws Exception {

           /* Launching google voice application */
           Utils.uBase.launchWebApplication();
           
           GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
           HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
           MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
           HomePageWeb homePage= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
           GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
           
           // Pre-Conditions:
           // Items exist in the Archive folder.
           /*
           * Procedure: 1. Navigate to the Archive folder. 2. Select an item. 3. Select
           * the More options menu (three vertical dots). 4. Select the Delete option.
           */
           gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
           GAPage.receiveUniqeMessage(Constants.voipTwoId, Constants.pwd2, data, 1);
           hmPage.clickMainMenu().clickMessages();
          // ReceiveCallAndMessages.receiveMessage(data,GAPage.generateUniqueString());

           //msgPage.uiCheckForMessage(data,GAPage.generateUniqueString());
           msgPage.clicKMessageWithGeneratedString(GeneralActivitiesPage.data).clickMoreOptn().clickArchiveFrmMoreOptn();
           /*
           * Verification:
           *
           * 1. Verify the item is removed from the Archive folder. 2. Verify the item is
           * no found in any folder in Moya.
           */

           msgPage.clickArchive().clicKMessageWithGeneratedString(GeneralActivitiesPage.data).clickMoreOptn();
           GAPage.deleteItem();
           homePage.verifyMessageWithGeneratedStringIsRemvedFromAllFolders(GeneralActivitiesPage.data);

    }
    
	// Verify items in the Archive folder can be restored.
	public void archiveRestore(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage=PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//GAPage.reciveMultipleTestMsgs(data, 2);
		//msgPage.uiCheckForMessages(data,Constants.messages);
		/*
		 * Pre-Conditions:
		 * 
		 * Items exist in the Archive folder.
		 * 
		 * Procedure:
		 * 
		 * 1. Navigate to the Archive folder. 2. Select an item. 3. Select the More
		 * options menu (three vertical dots). 4. Select the "Restore" option.
		 */

		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.getTextOfItemsInFirstList(1);
		msgPage.clickFirstMessage().clickMoreOptn().clickArchiveFrmMoreOptn();

		/*
		 * Verification:
		 * 
		 * 1. Verify the item is removed from the Archive folder. 2. Verify the item is
		 * added to and listed in the All folder. 3. Verify that also added to the
		 * respective message or calls or voicemail folder.
		 */
		hmPage.clickTab(Constants.Archive);
		GAPage.getTextOfItemInSecondList(1).compareLists();
		msgPage.clickFirstMessage().clickMoreOptn();

		msgPage.restoreMsgFrmArchivedFolder();
		hmPage.clickMessages();
		GAPage.getTextOfItemInSecondList(1).compareLists();
		//Data cleanup
		msgPage.cleanCreatedMessageLog(Constants.phoneNumber);
	}

	public void archiveThreadSelectUndo(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		ArchivePage archPage = PageFactory.initElements(Utils.uBase.webDriver, ArchivePage.class);
		GeneralActivitiesPage GAPage=PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//Data creation
		//GAPage.reciveMultipleTestMsgs(data, 3);
		/* Pre-Condition: Should have archive threads.
                   Procedure:
                    1. Click on Navigation bar (3 horizonatal lines) 
                    2. Click on archive tab
                    3. Click on one or more than one Avatars of archive items. 
                    4. Click on "restore" icon in upper left side 
                    5. Click on Undo

                     Verification:
                      1. Verify that able to restore multiple threads of archive items. 
                      2. Verify the restored items are still there in archived folder after clicking undo. */

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 3);
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		//msgPage.uiCheckForMessages(data,Constants.messages);			
		msgPage.clickMultipleAvatars();
		msgPage.archiveSelectMultipleAvatars();


		hmPage.clickArchive();
		Utils.uBase.refresh();
		GAPage.getTextOfItemsInFirstList(2);
		archPage.clickMultipleAvatars();

		/* Verification: 1. Verify that able to restore multiple threads of archive items. */
		archPage.clickRestoreBtn().verifyRestoreCnfrmPopUp().clickUndoBtn();
		Utils.uBase.refresh();
		//hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.getTextOfItemInSecondList(2).compareLists();
		//Data cleanup
		//msgPage.cleanCreatedMessageLog(Constants.phoneNumber);
	}

	// Archive BlockNumber - Verify call senders can be blocked from the Archive folder
		public void archiveBlockNumber(String email, String password, String data) throws Exception {
			/* Launching google voice application */
			Utils.uBase.launchWebApplication();

			GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
			HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
			MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
			ArchivePage archPage = PageFactory.initElements(Utils.uBase.webDriver, ArchivePage.class);
			CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
			GeneralActivitiesPage GAPage=PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

			/* Pre-Condition:  Items exist in the Trash folder from known senders.
		                    Procedure:  
		  						1. Navigate to the Archive folder.
		  						2. Select a received item from an account you manage.
		  						3. Select the More options menu (three vertical dots).
		  						4. Select the Block number option.
		  						5. Attempt to call the Voice Account from the blocked phone.

		                     Verification: 1. Verify the call is not completed. */
			/* Login to Application */
			gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
			hmPage.clickMainMenu().clickMessages();

			// create data
			msgPage.clickSendNewMessage().composeMessage(data).sendComposedMessage();
			Utils.uBase.refresh();

			//Switch to other account
			hmPage.clickAccountLabel().clickAddAccount();
			GAPage.switchingToWindowByIndex(1);
			hmPage.loginToOtherAccount(Constants.voipTwoId, Constants.voipPwd);

			// Check in other account for message 
			hmPage.clickMainMenu().clickTab(Constants.Messages);
			msgPage.clickfirstMessageInList();
			// msgPage.clickMoreOptn().clickArchiveFrmMoreOptn();
			msgPage.clickMoreOptn();
			GAPage.clickArchiveFrmMoreOptn();
			//.clickArchiveHighlightedFrmMoreOptn();

			// Move to archive folder
			hmPage.clickMainMenu().clickTab(Constants.Archive);
			msgPage.clickfirstMessageInList().clickMoreOptn();
			archPage.clickBlockNumberFrmMoreOptn().verifyBlockNumberPopup().clickBlockNumber();

			Utils.uBase.switchToOldWindow();
			hmPage.clickMainMenu().clickTab(Constants.Calls);
			callPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall();
			Utils.uBase.switchToNewWindow();
			callPage.verifyIncomingCallScreenIsNotDisplayed();
			Utils.uBase.switchToOldWindow();
			callPage.clickOnCallEndBtn();
			 Utils.uBase.switchToNewWindow();
			 hmPage.clickMainMenu().clickArchive();
			 msgPage.clickfirstMessageInList();
			 archPage.clickUnBlockNumberFrmMoreOptn();
			 
		/*
		 * Utils.uBase.switchToNewWindow(); hmPage.clickArchive();
		 * msgPage.clickfirstMessageInList(); archPage.clickUnBlockNumberFrmMoreOptn();
		 * Utils.uBase.refresh(); Utils.uBase.switchToOldWindow();
		 * callPage.clickOnMakeACall().enterVoip2PhoneNumAndMakeAcall();
		 * Utils.uBase.switchToNewWindow();
		 * callPage.verifyIncomingCallScreenIsDisplayed();
		 */					
		}
	// Archive call sender
	public void archiveCallSender(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		SearchPage searchPage = PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
		GeneralActivitiesPage GAPage=PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Pre-Condition: Trash has items from "known" sender (note: phone number should be listed with call).

					    Procedure: 1. Navigate to the Archive folder.
					     2. Select an item that has been received from an account you manage.
					     3. Select the phone icon.

					  Verification: 1. Verify you are able to call the call sender. */

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickTab("Calls");

		// create data
		callPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall();

		//Switch to other account
		hmPage.clickAccountLabel().clickAddAccount();
		GAPage.switchingToWindowByIndex(1);
		hmPage.loginToOtherAccount(Constants.voipTwoId, Constants.voipPwd);

		// Check in other account for message 
		hmPage.clickMainMenu().clickTab("Calls");
		Utils.uBase.refresh();
		callPage.clickfirstCallInList();
		hmPage.clickMainMenu();
		// msgPage.clickMoreOptn().clickArchiveFrmMoreOptn();
		msgPage.clickMoreOptn().clickArchiveHighlightedFrmMoreOptn();

		// Move to archive folder
		hmPage.clickMainMenu().clickArchive();
		Utils.uBase.refresh();
		callPage.clickfirstCallInList();
		//searchPage.clickOnCallItems();
		callPage.clickSelectedNumMakeACall();
		callPage.verifyAbleToMakeCall();
		callPage.clickOnCallEndBtn();
		
		hmPage.clickMainMenu().clickTab("Messages");
		callPage.clickfirstCallInList();
		hmPage.clickMainMenu();
		// msgPage.clickMoreOptn().clickArchiveFrmMoreOptn();
		msgPage.clickMoreOptn().clickArchiveHighlightedFrmMoreOptn();
		hmPage.clickMainMenu().clickArchive();
		Utils.uBase.refresh();
		callPage.clickfirstCallInList();
		//searchPage.clickOnCallItems();
		callPage.clickSelectedNumMakeACall();
		callPage.verifyAbleToMakeCall();
		callPage.clickOnCallEndBtn();
		
		
	}
	 //Verify items in the Archive folder can be deleted.
    public void archiveDoNotDisturbOff(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: GV full account
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		ArchivePage archPage = PageFactory.initElements(Utils.uBase.webDriver, ArchivePage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage=PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickSettings();
		settPage.clickDoNotDisturb().clickDoNotDisturbToggle(Constants.ON).clickCloseSettings();
	    /* Procedure:
	     * 1. Navigate to "Archive" page 2. Click on "Do not disturb" bar 3. Click on
	     * "Turn off " button */
		hmPage.clickMainMenu().clickArchive();
	
		archPage.clickEndNowToDisableDoNotDisturb().verifyDoNotDisturbIsNotDisplayed();
    	/*Verification: 1. Verify that option is disabled, and new incoming calls are
	    * forwarded to the respective forwarding phones. 2. Also verify the setting
	     * page's "Do not disturb" options is disabled. */
		//ReceiveCallAndMessages.makeCall(data);
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickSettings();
		settPage.clickDoNotDisturb().verifyDoNotDisturbToggleStatus(Constants.OFF).clickCloseSettings();	
    }
    
    public void archiveThreadUnselectbyClickingAgain(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		for(int i=0;i<3;i++) {
			callPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall().clickOnCallBtn();
			Utils.uBase.clickOnNotificationAllowBtn();
			Thread.sleep(1500);
			callPage.clickOnCallEndBtn();
			Utils.uBase.refresh();
		}
		Utils.uBase.refresh();
		msgPage.SelectAvtars(2).archiveSelectMultipleAvatars();
		hmPage.clickMainMenu().clickTab(Constants.Archive);
		msgPage.SelectAvtars(2);
		GAPage.verifyClickOnMultipleAvatars().verifyCountDecrementOnReselect();
		msgPage.SelectAvtars(2);
		Utils.uBase.clickByImage("DeleteIconImg");
	}
    
    public void archiveThreadSelectUndoSecondTime(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		
		  for(int i=0;i<4;i++) {
		  callPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall().clickOnCallBtn();
		  Utils.uBase.clickOnNotificationAllowBtn(); callPage.clickOnCallEndBtn();
		  Utils.uBase.refresh(); }
		 
		Utils.uBase.refresh();
		msgPage.SelectAvtars(2);
		msgPage.archiveSelectMultipleAvatars();
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Archive);
		msgPage.SelectAvtars(2);
		GAPage.getTextOfItemsInFirstList(2);
		Utils.uBase.clickByImage("restoreBtn");
		hmPage.clickTab(Constants.Calls);
		msgPage.clickArchiveUndo();
		hmPage.clickTab(Constants.Archive);
		GAPage.getTextOfItemInSecondList(2).compareLists();
		msgPage.clickArchiveUndo();
		hmPage.clickTab(Constants.Calls);
		GAPage.getTextOfItemInSecondList(2).compareLists();
	}
}

