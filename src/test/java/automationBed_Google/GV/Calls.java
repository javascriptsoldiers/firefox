package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class Calls extends SuiteBase {

	/* Verify Call.MissedCall */
	public void callMissedCall(String email, String password, String data) throws Exception {

		/*
		 * Pre-Condition: GV full account with google voice number.
		 */

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1. Send a missed call to the Voice account.
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		// GAPage.reciveMultipleMissCalls(data, 2);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipfourId, Constants.pwd2, data, 2);
		/*
		 * Verification:
		 * 
		 * 1. Verify missed call is listed in the Calls folder. 2. Verify the phone
		 * number of the sender is listed. 3. Verify the saved contact name displayed.
		 * 4. Verify the call details with date and time.
		 */

		hmPage.clickMainMenu().clickTab(Constants.Calls);
		callsPage.verifyMissedCallIsListedInCallsFolder();
		
		  GAPage.clickFirstItemInList().clickMoreOptn().clickPeople().addContactPeople().enterContactNamePeople().clickLabelPeopleAddContact().selectLabelPeopleAddContact().clickAddPeopleAddContact();
		  callsPage.verifySavedContactNameDisplayed().verifyCallDetailsWithDateTime();
		 // Test data clearance: Deleted added contact
		  GAPage.clickOnGoogleAppsMenu().clickOnContactsOptionFromGoogleApps().
		  deleteAddedContact();
		 
	}

	/* Verify received call. */
	public void callOutgoingCall(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		// ReceiveCallAndMessages.makeMissedCall(data);
		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		// GAPage.reciveMultipleMissCalls(data, 2);
		/*
		 * Pre-Condition: GV full account with google voice number.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		callsPage.EnteraNameOrNum().enterVoipPhoneNumOfTywinsMakeAcall();
		Thread.sleep(4000);
		callsPage.clickOnCallEndBtn();
		Thread.sleep(2000);
		Utils.uBase.refresh();
		/*
		 * Procedure: 1. Call non-forwarding phone from hangout or from google voice.
		 * 
		 * Verification: 1. Verify "Outgoing Call" is listed in the Calls folder. 2.
		 * Verify the phone number of the sender is listed. 3. Verify the saved contact
		 * name displayed 4. Verify the call details with date and time.
		 */
		callsPage.verifyOutgoingCallIsListedInCallsFolder();
		// GAPage.clickFirstItemInList().clickMoreOptn().clickPeople().addContactPeople().enterContactNamePeople().clickLabelPeopleAddContact().selectLabelPeopleAddContact().clickAddPeopleAddContact();
		// callsPage.verifySavedContactNameDisplayed().verifyCallDetailsWithDateTime();
//		/* Test data clearance: Deleted added contact */
		// GAPage.clickOnGoogleAppsMenu().clickOnContactsOptionFromGoogleApps().deleteAddedContact();
	}

	/* Verify unread calls are tabulated correctly. */
	public void callUnread(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		HomePageWeb homePage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu();

		/*
		 * Procedure: 1. Navigate to the Voice Calls folder.
		 */
		callsPage.countOfItemsInListOfCalls();
		// hmPage.clickMainMenu();

		/*
		 * Pre-Condition: Unread calls are in the calls folder.
		 */
		// ReceiveCallAndMessages.makeMissedCall(data);
		// GAPage.reciveMultipleMissCalls(data, 3);
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, Constants.count);
		Thread.sleep(3000);

		/*
		 * 1. Verify that the number of unread calls shown next to the Phone Icon are
		 * equal to the total number of unread calls listed in the folder.
		 */
		callsPage.verifyUnreadCallsEqualToTheTotalNumber();
		hmPage.clickMainMenu();
		callsPage.countOfItemsInCallListAfterCall();

		/* Clean created data */
		// callsPage.cleanCreatedCallLog(Constants.phoneNumber);
	}

	/* Verify unread calls are tabulated correctly. */
	public void callUnreadIndicator(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		/*
		 * Pre-Condition: Unread calls are in the calls folder.
		 */
		// ReceiveCallAndMessages.makeMissedCall(data);
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		Thread.sleep(30000);

		/*
		 * Procedure: 1. Navigate to the Voice Calls folder.
		 */
		hmPage.clickMainMenu().clickTab("Calls");

		/*
		 * Verifyed all unread calls have a UI indicator that they are unread (note:
		 * currently this places the item in bold text).
		 */
		callsPage.verifyUnreadCallsDisplayAsInBoldText();

		/* Clean created data */
		// callsPage.cleanCreatedCallLog(Constants.phoneNumber);
	}

	/* Verify caller item have access to message. */
	public void callSendMessage(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: Voice account has received calls from "known" sender (note:
		 * phone number should be listed with call).
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu().clickTab("Calls");

		/*
		 * Procedure: 1. Navigate to the Voice Calls folder. 2. Select a call item. 3.
		 * Select the Message Icon on the top right side of the screen.
		 */
		callPage.selectFirstContactFromCallsList().selectMsgFromCall();
		/*
		 * Verification: 1. Verify able to compose message to the caller. 2. Verify able
		 * to send message to the caller.
		 */
		msgPage.sendMsgToExistingNumber(data).sendComposedMessage();
		msgPage.verifyComposedMessage(data);
		msgPage.deleteMsg();
	}

	/* Verify items in the Calls folder can be marked as Spam. */
	public void callArchive(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Conditions: Items exist in the Calls folder.
		 */
		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 1);
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		Utils.uBase.refresh();
		GAPage.listInCallsPage(1);
		/*
		 * Procedure: 1. Navigate to the Voice Calls folder. 2. Select a call. 3. Select
		 * the More options menu (three vertical dots). 4. Select the Archive option.
		 */
		GAPage.clickFirstItemInList().clickMoreOptn().clickArchiveFrmMoreOptn();
		/*
		 * Verification: 1. Verify the call is removed from the Calls folder. 2. Verify
		 * the call is added to and listed in the Archive folder.
		 */
		Utils.uBase.refresh();
		// Utils.uBase.checkPageReady();
		GAPage.listInCallsPageAfterSpam(1).verifyItemsRemoved();
		hmPage.clickMainMenu().clickTab(Constants.Archive);
		GAPage.listOfCallsInOtherPage(1).compareLists();
	}

	/* Verify items in the Calls folder can be deleted. */
	public void callDelete(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Conditions: Items exist in the Calls folder.
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu().clickTab("Calls");
		/*
		 * Procedure:
		 * 
		 * 1. Navigate to the Voice Calls folder. 2. Select a call. 3. Select the More
		 * options menu (three vertical dots). 4. Select the Delete option. 5. click on
		 * confirmation popup with "Delete"
		 */
		callPage.selectFirstContactFromCallsList();
		/* Verify the call is removed from the Calls folder. */
		callPage.verifyCallIsRemovedFromCallsFolder();
	}

	/* Verify items in the Calls folder can be marked as Spam. */
	public void callSpam(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*
		 * Pre-Conditions: Items exist in the Calls folder.
		 */
		// ReceiveCallAndMessages.makeMissedCall(data);
		Thread.sleep(20000);
		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*
		 * Procedure: 1. Navigate to the Voice Calls folder. 2. Select a call. 3. Select
		 * the More options menu (three vertical dots). 4. Select the mark as Spam
		 * option.
		 */
		hmPage.clickMainMenu().clickTab("Calls");
		GAPage.listInCallsPage(1).clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();
		Utils.uBase.refresh();
		Utils.uBase.checkPageReady();
		GAPage.listInCallsPageAfterSpam(1).compareListsAfterSpam();
		/*
		 * Verification : 1. Verify the call is removed from the Calls folder. 2. Verify
		 * the call is added to and listed in the Spam folder.
		 */
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		Utils.uBase.refresh();
		Utils.uBase.checkPageReady();
		GAPage.listOfCallsInOtherPage(1).compareLists();
		/* Clearing Test Data(Unmark As Spam) */
		GAPage.clickFirstItemInList().clickMoreOptn().selectUnmarkAsSpam();
	}

	/* Verify able to make call by typing their phone number */
	public void callMakeCall(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		/*
		 * Procedure: 1. Navigate to "Calls" tab 2. Click on "Make a call" button 3.
		 * Type phone number 4. Click on "CALL" button below on the screen. 5. Select
		 * any of the phone to call with option, from the popup. 6. click on "CALL"
		 */
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumAndMakeAcall();
		Utils.uBase.clickOnNotificationAllowBtn();
		/* Verify that able to make call */
		callsPage.verifyAbleToMakeCall();
		/* Clean created data */
	}

	/* Verify able to select multiple calls thread */
	public void callThreadSelect(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: 1. Should have calls threads. 2. Initiating the java page into
		 * object using PageFactory
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu();
		/*
		 * Procedure: 1. Click on calls tab 2. Click on one or more than one Avatars of
		 * call items.
		 */
		hmPage.clickTab("Calls");

		/*
		 * Verification: 1. Verify that able to select multiple threads of call items.
		 */
		callPage.verifyIfAvatarsAreSelected();
	}

	/* Verify able to see make call page elements. */
	public void callMakeCallPage(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		/*
		 * Procedure: 1. Navigate to "Calls" tab 2. Click on "Make a call" button 3.
		 * Type phone number 4. Click on "CALL" button below on the screen. 5. Select
		 * any of the phone to call with option, from the popup. 6. click on "CALL"
		 */
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumber(Constants.dummyPhNumber);

		/* Verify "CALL" button is enabled to make call. */
		callsPage.verifyCallButtonIsEnabledToMakeCall();

		/* Verified "Phone to call with" popup window displayed */
		callsPage.verifyPhoneToCallWithPopupWindow();

		/* Clean created data */
		// callsPage.cleanCreatedCallLog(Constants.phoneNumber);
	}

	/* Verify that selected call items in calls threads should be deleted. */
	public void callThreadSelectDelete(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: Should have calls thread/
		 * 
		 * /* Initiating the java page into object using PageFactory
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu();

		/*
		 * Procedure: 1. Click on calls tab 2. Click on more than one call item Avatar
		 * icon 3. Click on Delete icon (Upper Left panel)
		 */
		hmPage.clickTab("Calls");

		/* Verify that calls item selected should be deleted. */
		callPage.verifyCallsSelectedAreDeleted();

		/* Verify the pop up saying item deleted */
		callPage.verifyDeletedPopupDisplayed();
	}

	/* Verify that selected call items in calls thread can be archived */
	public void callThreadSelectArchive(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: Should have calls threads.
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu();

		/*
		 * * Procedure: 1. Click on calls tab 2. Click on more than one call item Avatar
		 * icon 3. Click on Archive icon (Upper Left panel)
		 */
		hmPage.clickTab("Calls");

		/* Verify that calls item selected should be Archived. */
		callPage.clickMultipleAvatars().archiveSelectMultipleAvatars();
		/* Verify the pop up saying items Archived with Undo option. */
		callPage.verifyArchivedPopupDisplayedWithUndoOption()
				.archivedWithUndoAndVerifyArchivedItemsPlacedAgainInCallsFolder();
	}

	/*
	 * Verify that archived items can be successfully restored by selecting Undo
	 * option
	 */
	public void callThreadSelectUndoArchive(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Should have calls threads.
		 */
		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu();
		/*
		 * Procedure: 1. Click on calls tab 2. Click on more than one call item Avatar
		 * icon 3. Click on Archive icon (Upper Left panel) 4. Click on UNDO
		 */
		hmPage.clickTab("Calls");
		/*
		 * Verification : 1. Verify that calls item selected should be Archived. 2.
		 * Verify the pop up saying items Archived with Undo option. 3. Verify that
		 * archived items should be placed again in calls folder.
		 */
		callPage.clickMultipleAvatars().archiveSelectMultipleAvatars();
		callPage.verifyArchivedPopupDisplayedWithUndoOption()
				.archivedWithUndoAndVerifyArchivedItemsPlacedAgainInCallsFolder();
	}

	public void callThreadSelectUndoSecondTime(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Should have calls threads.
		 */
		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		for (int i = 0; i < 4; i++) {
			callPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall().clickOnCallBtn();
			Utils.uBase.clickOnNotificationAllowBtn();
			Thread.sleep(5000);
			callPage.clickOnCallEndBtn();
		}
		Utils.uBase.refresh();
		msgPage.SelectAvtars(2);
		GAPage.getTextOfItemsInFirstList(2);
		msgPage.archiveSelectMultipleAvatars();
		msgPage.verifyArchiveCnfrmPopUp().clickArchiveUndo();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		GAPage.getTextOfItemInSecondList(2).compareLists();
		Thread.sleep(1500);
		msgPage.clickArchiveUndo();
		hmPage.clickTab(Constants.Archive);
		GAPage.getTextOfItemInSecondList(2).compareLists();
	}

	public void callThreadUnselectbyClickingAgain(String email, String password, String data) throws Exception {
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		for (int i = 0; i < 4; i++) {
			callPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall().clickOnCallBtn();
			Utils.uBase.clickOnNotificationAllowBtn();
			Thread.sleep(5000);
			callPage.clickOnCallEndBtn();
		}
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		GAPage.clickOnMultipleAvatars().verifyClickOnMultipleAvatars().verifyCountDecrementOnReselect();
	}

}
