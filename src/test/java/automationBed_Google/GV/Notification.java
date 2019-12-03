package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.DesktopNotificationPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.SpamPage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class Notification extends SuiteBase {

	// Verify desktop notification pops up when received new messages.
	public void notificationNewMessage(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition:
		 * 
		 * GV full account
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePageWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		DesktopNotificationPage deskNotificationPage = PageFactory.initElements(Utils.uBase.webDriver, DesktopNotificationPage.class);
		GeneralActivitiesPage gaPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();
		/*
		 * Procedure: 1. Login with GV full account. 2. Switch to another browser or
		 * application. 3. Send message from non forwarding phone to GV account.
		 */

		homePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		String str[] = data.split("\\|");
		gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).clickNextButton();
		homePageWeb.syncWithLoggedInId();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		homePageWeb.clickSync();

		hmPage.clickMainMenu().clickTab(Constants.Messages);
		msgPage.clickSendNewMessage().setNumMsgToField(str[2]).setTextNewMsg(gaPage.generateUniqueString())
				.clickToMsgTxt().sendComposedMessage();

		/*
		 * Verification: 1. Verify desktop notification received for the every new
		 * unread message. 2. Verify that it disappear after few seconds.
		 */
		
		deskNotificationPage.verifyTxtMsgNotification().verifyTxtMsgNotificationDisappear();
	}

	// Verify desktop notification pops up when received new messages with picture.
	public void notificationNewMessageWithPicture(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition:
		 * 
		 * GV full account
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePageWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		DesktopNotificationPage deskNotificationPage = PageFactory.initElements(Utils.uBase.webDriver,
				DesktopNotificationPage.class);
		/* Login to Application and selecting the home button */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		Utils.uBase.clickOnNotificationAllowBtn();
		/*
		 * Procedure:
		 * 
		 * 1. Login with GV full account. 2. Switch to another browser or application.
		 * 3. Send message from non forwarding phone to GV account. 4. Click on received
		 * picture message notification.
		 */

		homePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		String str[] = data.split("\\|");
		gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).clickNextButton();

		homePageWeb.syncWithLoggedInId();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		homePageWeb.clickSync();

		hmPage.clickMainMenu().clickTab(Constants.Messages);
		msgPage.clickSendNewMessage().setNumMsgToField(str[2]).clickToMsgTxt().clickAddimageIcon().clickDesiredImg()
				.clickSelectAddImgWindow().clickToMsgTxt().sendComposedMessage();
		/*
		 * Verification: 1. Verify desktop notification received for the every new
		 * unread picture message. 2. Verify that it disappears after few seconds. 3.
		 * Verify that by clicking on takes to the right message detail page.
		 */
		deskNotificationPage.verifyPictureMsgNotification().clickPictureMsgNotification();
		msgPage.verifyReceivedMsgContactDetails(str[3]);

	}

	// Verify desktop notification pops up when received new messages.
	public void notificationNewMessageClick(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition:
		 * 
		 * GV full account
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePageWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		DesktopNotificationPage deskNotificationPage = PageFactory.initElements(Utils.uBase.webDriver,
				DesktopNotificationPage.class);
		GeneralActivitiesPage gaPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();
		/*
		 * Procedure:
		 * 
		 * 1. Login with GV full account. 2. Switch to another browser or application.
		 * 3. Send message from non forwarding phone to GV account. 4. Click on the
		 * received desktop notification.
		 */
		
		  homePageWeb.clickGoogleAccountIcon().clickAddAccountOption(); 
		  String str[]=data.split("\\|");
		  gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).
		  clickNextButton();
		  
		  homePageWeb.syncWithLoggedInId();
		  gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).
		  clickNextButton(); homePageWeb.clickSync();
		  
		  hmPage.clickMainMenu().clickTab(Constants.Messages);
		  msgPage.clickSendNewMessage().setNumMsgToField(str[2]).setTextNewMsg(gaPage.
		  generateUniqueString()).clickToMsgTxt().sendComposedMessage(); 
		  
		  //Verification:
		  /* 1. Verify that by click on the notification open the respective message for
		  the user. */
		  //Thread.sleep(8000);
		  deskNotificationPage.verifyTxtMsgNotification();
		  deskNotificationPage.clickTxtMsgNotification().
		  verifyNavigationOnClickingNotification(str[3]);
		 
	}

	// Verify desktop notification pops up when received new missed call.
	public void notificationNewMissedCall(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition:
		 * 
		 * GV full account
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePageWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		DesktopNotificationPage deskNotificationPage = PageFactory.initElements(Utils.uBase.webDriver,
				DesktopNotificationPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*
		 * Procedure: 1. Login with GV full account. 2. Switch to another browser or
		 * application. 3. Send miss call from non forwarding phone to GV account.
		 */

		homePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		String str[] = data.split("\\|");
		gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).clickNextButton();

		homePageWeb.syncWithLoggedInId();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		homePageWeb.clickSync();

		hmPage.clickMainMenu();

		callsPage.EnteraNameOrNum().enterPhoneNumber(str[2]);
		callsPage.clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();
		callsPage.clickOnCallEndBtn();

		/*
		 * Verification: 1. Verify desktop notification received for the new missed
		 * call. 2. Verify that it disappear after few seconds.
		 */
		//Thread.sleep(8000);
		deskNotificationPage.verifyMissedCallNotification().verifyMissedCallNotificationDisappear();
	}

	// Verify desktop notification pops up when received new missed call.
	public void notificationNewMissedCallClick(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition:
		 * 
		 * GV full account
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePageWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);

		DesktopNotificationPage deskNotificationPage = PageFactory.initElements(Utils.uBase.webDriver,
				DesktopNotificationPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();
		/*
		 * Procedure: 1. Login with GV full account. 2. Switch to another browser or
		 * application. 3. Send miss call from non forwarding phone to GV account. 4.
		 * Click on the received notification.
		 */

		homePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		String str[] = data.split("\\|");
		gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).clickNextButton();

		homePageWeb.syncWithLoggedInId();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		homePageWeb.clickSync();

		hmPage.clickMainMenu();

		callsPage.EnteraNameOrNum().enterPhoneNumber(str[2]);
		callsPage.clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();
		callsPage.clickOnCallEndBtn();

		/*
		 * Verification: 1. Verify that by click on the notification open the respective
		 * missed call detail page for the user.
		 */
		//Thread.sleep(8000);
		deskNotificationPage.verifyMissedCallNotification().clickMissedCallNotification()
				.verifyNavigationToCallsOnClickingNotification(str[3]);
	}

	// Verify desktop notification pops up when received new voicemail.
	public void notificationNewVoiceMail(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition:
		 * 
		 * GV full account
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePageWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		DesktopNotificationPage deskNotificationPage = PageFactory.initElements(Utils.uBase.webDriver,
				DesktopNotificationPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*
		 * Procedure: 1. Login with GV full account. 2. Switch to another browser or
		 * application. 3. Send voice mail from non forwarding phone to GV account.
		 */

		homePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		String str[] = data.split("\\|");
		gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).clickNextButton();

		homePageWeb.syncWithLoggedInId();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		homePageWeb.clickSync();

		hmPage.clickMainMenu();

		callsPage.EnteraNameOrNum().enterPhoneNumber(str[2]);
		callsPage.clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();

		Thread.sleep(45000);
		callsPage.clickOnCallEndBtnWhenDisplayed();

		/*
		 * Verification: 1. Verify desktop notification received for the new voice mail.
		 * 2. Verify that it disappear after few seconds.
		 */

		deskNotificationPage.verifyVoicemailNotificationDisplayed().verifyVoicemailNotificationDisappear();
	}

	// Verify desktop notification pops up when received new voicemail.
	public void notificationNewVoiceMailClick(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition:
		 * 
		 * GV full account
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePageWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		DesktopNotificationPage deskNotificationPage = PageFactory.initElements(Utils.uBase.webDriver,
				DesktopNotificationPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*
		 * Procedure: 1. Login with GV full account. 2. Switch to another browser or
		 * application. 3. Send voice mail from non forwarding phone to GV account. 4.
		 * Click on the received notification.
		 * 
		 */

		homePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		String str[] = data.split("\\|");
		gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).clickNextButton();

		homePageWeb.syncWithLoggedInId();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		homePageWeb.clickSync();
		hmPage.clickMainMenu();

		callsPage.EnteraNameOrNum().enterPhoneNumber(str[2]);
		callsPage.clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();

		Thread.sleep(45000);
		callsPage.clickOnCallEndBtn();

		/*
		 * Verification: 1. Verify that by click on the notification open the respective
		 * voicemail detail page for the user..
		 */

		deskNotificationPage.verifyVoicemailNotificationDisplayed().clickVoicemailNotification()
				.verifyNavigationToVoicemailPageOnClickingNotification(str[3]);
	}

	// Verify no desktop notification pops up when GV account window is active.
	public void notificationNoNotification(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition:
		 * 
		 * GV full account
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePageWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		DesktopNotificationPage deskNotificationPage = PageFactory.initElements(Utils.uBase.webDriver,
				DesktopNotificationPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*
		 * Procedure: 1. Login with GV full account. 2. Switch to another browser or
		 * application. 3. Send voice mail from non forwarding phone to GV account.
		 */

		homePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		String str[] = data.split("\\|");
		gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).clickNextButton();

		homePageWeb.syncWithLoggedInId();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		homePageWeb.clickSync();

		hmPage.clickMainMenu();

		callsPage.EnteraNameOrNum().enterPhoneNumber(str[2]);
		callsPage.clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();

		Thread.sleep(45000);
		callsPage.clickOnCallEndBtn();

		/*
		 * Verification: 1. Verify should not get desktop notification, when respective
		 * GV account window is active.
		 */
		Utils.uBase.switchToOldWindow();
		hmPage.clickMainMenu().clickTab("VoiceMailTab");

		Thread.sleep(35000);
		deskNotificationPage.verifyVoicemailNotificationNotDisplayed();
	}

	// Verify no desktop notification pops up when no new items.
	public void notificationNoNotificationForSpammedOrBlocked(String email, String password, String data)
			throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition:
		 * 
		 * GV full account
		 */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePageWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		DesktopNotificationPage deskNotificationPage = PageFactory.initElements(Utils.uBase.webDriver,
				DesktopNotificationPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage gaPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);
		/* Login to Application and selecting the home button */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();

		/*
		 * Procedure: 1. Login with GV full account. 2. Switch to another browser or
		 * application. 3. Send voice mail from non sforwarding phone to GV account.
		 */

		homePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		String str[] = data.split("\\|");
		gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).clickNextButton();

		homePageWeb.syncWithLoggedInId();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		homePageWeb.clickSync();

		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumber(str[2]);
		callsPage.clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();
		Thread.sleep(2000);
		callsPage.clickOnCallEndBtn();

		gaPage.selectRequiredTab(0);
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Calls);
		gaPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();
		Utils.uBase.refresh();

		/*
		 * 1. Navigate to the Spam folder. 2. Select a received item from an account you
		 * manage. 3. Select the More options menu (three vertical dots). 4. Select the
		 * Block caller option. 5. Attempt to call the Voice Account from the blocked
		 * phone.
		 */

		hmPage.clickMainMenu().clickTab(Constants.Spam);
		gaPage.clickFirstItemInList().clickMoreOptn();
		spamPage.clickBlockNumberFrmMoreOptn();
		Thread.sleep(1000);

		gaPage.selectRequiredTab(1);

		Utils.uBase.refresh();

		hmPage.clickMainMenu().clickTab(Constants.Messages);
		msgPage.clickSendNewMessage().setNumMsgToField(str[2]).setTextNewMsg(gaPage.generateUniqueString())
				.clickToMsgTxt().sendComposedMessage();
		Thread.sleep(8000);
		deskNotificationPage.verifyTxtMsgNotificationDisappear();

		hmPage.clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumber(str[2]);
		callsPage.clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();
		Thread.sleep(2000);
		callsPage.clickOnCallEndBtn();
		Thread.sleep(8000);
		deskNotificationPage.verifyMissedCallNotificationDisappear();

		hmPage.clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumber(str[2]);
		callsPage.clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();
		Thread.sleep(45000);
		callsPage.clickOnCallEndBtnWhenDisplayed();
		System.out.println("call is ended");
		Thread.sleep(35000);
		deskNotificationPage.verifyVoicemailNotificationNotDisplayed();

		// Removing pre-conditions

		gaPage.selectRequiredTab(0);
		hmPage.clickTab(Constants.Spam);
		gaPage.clickFirstItemInList().clickMoreOptn();
		spamPage.clickUnBlockNumber();
		hmPage.clickTab(Constants.Spam);
		gaPage.clickFirstItemInList().clickMoreOptn();
		spamPage.selectUnmarkAsSpam();

	}

}
