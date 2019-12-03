package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.SpamPage;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class SpamTest extends SuiteBase {

	/*Verify sender of received item can be called from Spam folder.*/
	public void spamCallSender(String email, String password, String data) throws Exception 
	{
		//ReceiveCallAndMessages.makeMissedCall(data);
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*Pre-Condition:
		Spam has items from "known" sender (note: phone number should be listed with call).*/
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		callsPage.clickfirstCallInList().clickMoreOptn().selectMarkAsSpam();
		Utils.uBase.refresh();

		/*	1. Navigate to the Spam folder.*/
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		/* 2. Select an item that has been received from an account you manage.*/
		callsPage.clickfirstCallInList();
		/*3. Select the phone icon.*/
		spamPage.clickmakeAcallIcon();
		Utils.uBase.clickOnNotificationAllowBtn();
		/*Verification:
			1.  Verify you are able to call the call sender.*/
		spamPage.verifyAbleToCall();
		Utils.uBase.refresh();

		// Reverting Test Data
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		spamPage.clickItemFromList().clickMoreOptn();
		spamPage.selectUnmarkAsSpam();
	}

	/* Verify items in the Spam folder can be deleted.*/
	public void spamDelete(String email, String password, String data) throws Exception 
	{
		//ReceiveCallAndMessages.makeMissedCall(data);
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*Pre-Condition:
		Items exist in the Spam folder.*/
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		callsPage.clickfirstCallInList().clickMoreOptn().selectMarkAsSpam();
		Utils.uBase.refresh();

		/*	Procedure:
			1. Navigate to the Spam folder.
			2. Select an item.
			3. Select the More options menu (three vertical dots).
			4. Select the "Delete forever" option.*/

		hmPage.clickMainMenu().clickTab("Spam");
		callsPage.clickfirstCallInList();
		spamPage.clickMoreOptn();
		/* Verification:
			1. Verify the item is removed from the Spam folder.
			2. Verify that, only "Delete Forever" menu item, no "Delete" menu item.
			3. Verify the item is deleted forever.*/
		spamPage.deleteItemFromSpam();
		// Removing pre-conditions
		//ReceiveCallAndMessages.makeMissedCall(data);
		//GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		Utils.uBase.switchToNewWindow();
		for(int i=0;i<1;i++) {
			callsPage.EnteraNameOrNum().enterNumAndMakeAcall(data).clickOnCallEndBtn();
			}
			Utils.uBase.switchToOldWindow();
		Thread.sleep(4000);
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab("Spam");
		callsPage.clickfirstCallInList();
		spamPage.clickMoreOptn();
		spamPage.selectUnmarkAsSpam();
	}

	/*Verify items in the Spam folder can be removed.*/
	public void spamNotSpam(String email, String password, String data) throws Exception 
	{
		//ReceiveCallAndMessages.makeMissedCall(data);
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//GAPage.reciveMultipleMissCalls(data,1);
		
		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*Pre-Condition:
		Items exist in the Spam folder.*/
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();
		Utils.uBase.refresh();

		/*	Procedure:
			1. Navigate to the Spam folder.
			2. Select an item.
			3. Select the More options menu (three vertical dots).
			4. Select the Not Spam option.*/
		hmPage.clickMainMenu().clickTab("Spam");
		Thread.sleep(3000);
		GAPage.clickFirstItemInList().getTextOfItemsInFirstList(1).clickMoreOptn();

		/* Verification:
			1. Verify the item is removed from the Spam folder.
  			2. Verify the item is added to and listed in the All folder.*/
		spamPage.selectUnmarkAsSpam();
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		GAPage.getTextOfItemInSecondList(1).compareLists();
	}

	//Verify call senders can be blocked from the Spam folder.
	public void spamBlockUnblockCaller(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		HomePageWeb homeWebPage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*Pre-Condition:
		Spam has items from "known" sender (note: phone number should be listed with call).*/
		homeWebPage.clickGoogleAccountIcon();
		hmPage.clickAddAccount();
		homeWebPage.switchingToFirstWindow();
		gvSignInPage.enterLoginID(Constants.voipTwoId).clickNextButton().enterPassword(Constants.voipPwd).clickNextButton();
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumber(data).clickOnCallButton();
		Thread.sleep(8000);
		Utils.uBase.refresh();
		homeWebPage.switchingToZerothWindow();
		Thread.sleep(5000);
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();
		Utils.uBase.refresh();

		/*	1. Navigate to the Spam folder.
  			2. Select a received item from an account you manage.
  			3. Select the More options menu (three vertical dots).
  			4. Select the Block caller option.
  			5. Attempt to call the Voice Account from the blocked phone.*/
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		GAPage.clickFirstItemInList().clickMoreOptn();
		spamPage.clickBlockNumberFrmMoreOptn();
		homeWebPage.switchingToFirstWindow();

		/*Verification:  
			  1. Verify the call is not completed.*/
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumber(data).clickOnCallButton();
		homeWebPage.switchingToZerothWindow();
		callsPage.verifyIncomingCallScreenIsNotDisplayed();
		// Removing pre-conditions
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		GAPage.clickFirstItemInList().clickMoreOptn();
		spamPage.clickUnBlockNumber();hmPage.clickTab(Constants.Spam);
		GAPage.clickFirstItemInList().clickMoreOptn();
		spamPage.selectUnmarkAsSpam();
	}

	/*Verify unread items in Trash folder is tabulated correctly.*/
	public void spamMessagesUnableToReply(String email, String password, String data) throws Exception 
	{
		//ReceiveCallAndMessages.receiveMessage(data);
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*Pre-Condition:
		 Message items are in the Spam folder.*/
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();
		Utils.uBase.refresh();

		/*	Procedure:
			1. Click on "Spam" folder
 			2. Click on "message" item*/
		hmPage.clickMainMenu().clickTab("Spam");
		GAPage.clickFirstItemInList();

		/*Verification:
			1. Verify that message item, message input box and send button elements are invisible, and unable to access.*/
		spamPage.verifyMsgInputBoxAndSendBtn();

		// Reverting Test Data
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab("Spam");
		spamPage.clickItemFromList().clickMoreOptn();
		spamPage.selectUnmarkAsSpam();

	}

	/*Verify able to select multiple spam threads*/
	public void spamThreadSelect(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		int count = 3;
		//GAPage.reciveMultipleMissCalls(data, count);

		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*Pre-Condition:
		 Message items are in the Spam folder.*/
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		for(int i=0;i<count;i++){
			GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();
			}
		Utils.uBase.refresh();

		/*	Procedure:
			1. Click on Navigation bar (3 horizonatal lines)
			2. Click on spam tab
			3. Click on one or more than one Avatars of spam items.*/
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		GAPage.selectMultipleItemInList(count);

		/*Verification:
			1. Verify that able to select multiple threads of spam items.*/
		spamPage.verifyIfAvatarIsSelected();
		// cleaning pre-condition
		spamPage.unspamThreads(count);
		/*
		 * Utils.uBase.refresh(); hmPage.clickMainMenu().clickTab(Constants.Spam);
		 * for(int i=0;i<count;i++){ GAPage.clickFirstItemInList().clickMoreOptn();
		 * spamPage.selectUnmarkAsSpam(); Utils.uBase.refresh();
		 
		}*/
	}		

	/*Verify able to unselect multiple spam threads*/
	public void spamThreadSelectUnselect(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		int count = 3;
		//GAPage.reciveMultipleMissCalls(data, count);

		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		GAPage.removeItemsFromSpam();
		/*Pre-Condition:
		 Message items are in the Spam folder.*/
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		for(int i=0;i<count;i++){
			GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();}
		Utils.uBase.refresh();

		/*	Procedure:
  				1. Click on Navigation bar (3 horizonatal lines)
  				2. Click on spam tab
  				3. Click on one or more than one Avatars of spam items.
  				4. Click "X" icon on letf upper corner to unselect items.*/
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		GAPage.selectMultipleItemInList(count);
		/*  Verification:
  				1. Verify that able to unselect multiple threads of spam items by clicking "X".*/
		spamPage.unselectMultipleThreads().verifyIfAvatarIsunSelected();

		// cleaning pre-condition
		Utils.uBase.refresh();
		GAPage.selectMultipleItemInList(count);
		spamPage.unspamThreads(count);
		GAPage.removeItemsFromSpam();
		/*
		 * Utils.uBase.refresh(); hmPage.clickMainMenu().clickTab(Constants.Spam);
		 * for(int i=0;i<count;i++){ GAPage.clickFirstItemInList().clickMoreOptn();
		 * spamPage.selectUnmarkAsSpam(); }
		 */	}		

	/*Verify able to select multiple spam threads and make it unspam*/
	public void spamThreadSelectUnspam(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		int count = 3;
		//GAPage.reciveMultipleMissCalls(data, count);

		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		
		/*Pre-Condition:
		Should have spam threads.*/
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		
		for(int i=0;i<count;i++){
			GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();}
		Utils.uBase.refresh();

		/*	Procedure:
			1. Click on Navigation bar (3 horizonatal lines)
			2. Click on spam tab
			3. Click on one or more than one Avatars of spam items.
			4. Click "Unspam" icon on letf upper corner.*/
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		GAPage.getTextOfItemsInFirstList(3);
		GAPage.selectMultipleItemInList(count);

		/*Verification:
			1. Verify that able to unspam multiple threads of spam items by clicking "Unspam icon".*/
		spamPage.unspamThreads(count);
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		GAPage.getTextOfItemInSecondList(3).compareLists();
		
	}

	/*Verify able to do undo the threads unspam*/
	public void spamThreadSelectUnspamUndo(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		int count = 3;
		//GAPage.reciveMultipleMissCalls(data, count);

		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*Pre-Condition:
		Should have spam threads.*/
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		for(int i=0;i<count;i++){
			GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();}
		Utils.uBase.refresh();

		/*	Procedure:
			1. Click on Navigation bar (3 horizonatal lines)
			2. Click on spam tab
			3. Click on one or more than one Avatars of spam items.
			4.  Click "Unspam" icon on letf upper corner.
			5. Click on Undo button*/
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		GAPage.selectMultipleItemInList(count);

		/*Verification:
			1. Verify that able to unspam multiple threads of spam items by clicking "Unspam icon".*/
		spamPage.unspamThreads(count);
		/*2. Verify that able to Undo the multiple threads of unspam items by clicking "Undo".*/
		spamPage.verifyUnspamThreadsAreUndo(count);
		// cleaning pre-condition
		spamPage.unspamThreads(count);
		/*
		 * Utils.uBase.refresh(); hmPage.clickMainMenu().clickTab(Constants.Spam);
		 * for(int i=0;i<count;i++){ GAPage.clickFirstItemInList().clickMoreOptn();
		 * spamPage.selectUnmarkAsSpam(); }
		 */
	}

	/*Verify able to delete multiple spam threads.*/
	public void spamThreadSelectDelete(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		int count = 3;
		//GAPage.reciveMultipleMissCalls(data, count);

		/* Login to Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*Pre-Condition:
		Should have spam threads.*/
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		for(int i=0;i<count;i++){
			GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();}
		Utils.uBase.refresh();

		/*	Procedure:
			1. Click on Navigation bar (3 horizonatal lines)
			2. Click on spam tab
			3. Click on one or more than one Avatars of spam items.
			4. Click "Delete" icon on letf upper corner*/

		hmPage.clickMainMenu().clickTab(Constants.Spam);
		GAPage.selectMultipleItemInList(count);

		/*Verification:
			1. Verify that able to Delete multiple threads of spam items by clicking "Delete" icon.".*/
		spamPage.verifyDeleteMultipleSpamThreads();

		// Removing pre-conditions
		//ReceiveCallAndMessages.makeMissedCall(data);
		//GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		Utils.uBase.switchToNewWindow();
		for(int i=0;i<1;i++) {
			callsPage.EnteraNameOrNum().enterNumAndMakeAcall(data).clickOnCallEndBtn();
			}
			Utils.uBase.switchToOldWindow();
		Thread.sleep(4000);
		Thread.sleep(4000);
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab("Spam");
		spamPage.clickItemFromList().clickMoreOptn();
		spamPage.selectUnmarkAsSpam();
	}
	
	public void spamThreadSelectUndoSecondTime(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		callPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall().clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();
		Thread.sleep(5000);
		callPage.clickOnCallEndBtn();
		Utils.uBase.refresh();
		GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();
		for(int i=0;i<3;i++) {
			callPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall().clickOnCallBtn();
			Utils.uBase.clickOnNotificationAllowBtn();
			Thread.sleep(5000);
			callPage.clickOnCallEndBtn();
			Utils.uBase.refresh();
		}
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		msgPage.SelectAvtars(3);
		GAPage.getTextOfItemsInFirstList(2);
		Utils.uBase.clickByImage("UnspamThreads");
		hmPage.clickTab(Constants.Calls);
		GAPage.getTextOfItemInSecondList(2).compareLists();
		Thread.sleep(1500);
		msgPage.clickArchiveUndo();
		hmPage.clickTab(Constants.Spam);
		GAPage.getTextOfItemInSecondList(2).compareLists();
		msgPage.SelectAvtars(3);
		Utils.uBase.clickByImage("UnspamThreads");
	}
	
	public void spamThreadUnselectbyClickingAgain(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		callPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall().clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();
		Thread.sleep(5000);
		callPage.clickOnCallEndBtn();
		Utils.uBase.refresh();
		GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();
		for(int i=0;i<3;i++) {
			callPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall().clickOnCallBtn();
			Utils.uBase.clickOnNotificationAllowBtn();
			Thread.sleep(5000);
			callPage.clickOnCallEndBtn();
			Utils.uBase.refresh();
		}
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		msgPage.SelectAvtars(3);
		GAPage.verifyClickOnMultipleAvatars().verifyCountDecrementOnReselect();
		msgPage.SelectAvtars(3);
		Utils.uBase.clickByImage("UnspamThreads");
	}
}
