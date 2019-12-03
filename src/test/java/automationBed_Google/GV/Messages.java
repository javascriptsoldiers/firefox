package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.MessagePageAndroid;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class Messages extends SuiteBase {

	//Verify visibility of required message elements
	public void messageVisibleElements(String email, String password, String data) throws Exception {
		/*Pre-Condition:
			Google voice account with messages. */
		String str[]=data.split("\\|");
		//ReceiveCallAndMessages.receiveMessage(str[0]);
		
		Thread.sleep(5000);

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//GAPage.reciveMultipleTestMsgs(str[0], 1);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, str[0], 2);
		hmPage.clickMainMenu().clickMessages();
		msgPage.clickSendNewMessage().typeNumberinMsgToField(Constants.phoneNo).typeAMsgAndCheckSendBtn().sendComposedMessage();
		Utils.uBase.refresh();
		/*Procedure:
  			1. Navigate to the Voice Messages folder.
  			2. Select a message that has been received from an account you manage.
  			3. Click on "More option" button.

  			Verification:
    			Verify the element visibility of the following:
  					1. Message input box with place holder text of "Type a message"
  					2. Picture icon with "Add image" tool tip.
  					3. Arrow Icon with "Send message" tool tip.
  					4. Phone icon with "make a call" tool tip.
  					5. Dotted icon with "More option" tool tip.

  				Verify the below menu items:
  					1. People & options
  					2. Archive
  					3. Delete
  					4. Mark as Spam
  					5. Block Number */
		GAPage.clickFirstItemInList();
		msgPage.clickMsgConvNum().verifyTypMsgPlcHolder().setTextNewMsg(str[1]).clickMsgConvNum().verifyAddImgToolTip()
		.verifySendMsgToolTip().verifyMsgCallToolTip().verifyMsgThreeDotsToolTip().clickMsgThreeDots().verifyMsgThreeDotsOptionsText();
	}

	//Verify new received messages appear in Messages folder.
	public void messageReceive(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*Pre-Condition:
	           Should have Google voice number.

	     /*Procedure:
		  1. Send a new text message to the Voice account. 
		  2. Click on same the message item on the UI.*/
		//GAPage.reciveMultipleTestMsgs(data, 2);
		Thread.sleep(3000);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.clickFirstItemInList();

		/*Verification:
		 		1. Verify message is listed in the message folder. 
		 		2. Verify the phone number of the sender is listed. 
		 		3. Verify the received messages are on the left side or the conversation. 
		 		4. Verify the body of the text message thread is displayed when you click on the message item.*/
		msgPage.verifyMsgListedInMsgFolder().verifyPhoneNumber();
		//Cleaning the data
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.clickFirstItemInList().clickMoreOptn().deleteItem();
	}

	//Verify able to compose and send new message.
	public void messageSendNewMessage(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		/*Pre-Condition:
	           Should have Google voice number.

	           /* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickMessages();
		/*Procedure:
	                 1. Click on "Send a message" button
	                 2. To: type non forwarding phone number to send the message.
	                 3. click Send arrow button or ENTER key.*/
		msgPage.clickSendNewMessage().typeNumberinMsgToField(data).typeAMsgAndCheckSendBtn().sendMessage();
		/*Verification:
		 *  1. Verify message is listed in the message conversation item. 2. Verify
		 * before typing message "Send" Arrow button is disabled, after completing to
		 * address and message, Arrow button will be enabled. 3. Verify the message
		 * marked as "Sending.." first then "Just now" later the actual time of sent */
		msgPage.verifytimeStamp().verifyMsgIsListedInMsgFolder();
	}

	/* Verify able to see the details of sender or receiver. */
	public void messageMenuItemPeopleAndOptions(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Pre-Condition: GV full account */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 1);
		/*Procedure:
  				1. Login
  				2. Click on message tab
  				3. Select any message item.
  				4. Click on "More options" button on top right of the message panel.
  				5. Select "People & options" menu item.*/
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.clickFirstItemInList().clickMoreOptn().clickPeople();

		/*Verification:
  				1. Verify that it has two category "People" and "Options"
  				2. Verify that it displayed all the contact details of the message participants.
  				3. Verify that it has options to "Block user" and "Mark as Spam"(options is not present)*/
		msgPage.verifyPeople().verifyContactDetailsMsgParticipants();
		Utils.uBase.refresh();
		GAPage.clickMoreOptn();
		msgPage.verifyBlockAndSpamOptions();

		// Reverting Test Data
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.clickFirstItemInList().clickMoreOptn().deleteItem();
	}

	/*Verify items in the Messages folder can be marked as archive.*/
	public void messageMenuItemArchive(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/*
		 * Pre-Conditions: Items exist in the Messages folder.
		 */

		// Twillio call for generating dummy message. Image with this dummy message is
		// already stored in images folder
		//GAPage.reciveMultipleTestMsgs(data, 2);
		//msgPage.receiveTestMessage(data);
		Thread.sleep(3000);
		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickMessages();

		/*
		 * Procedure: 1. Navigate to the Messages folder. 2. Select a message. 3. Select
		 * the More options menu (three vertical dots). 4. Select the mark as Archive
		 * option.
		 */

		GAPage.getTextOfItemsInFirstList(1).clickFirstItemInList().clickMoreOptn().clickArchiveFrmMoreOptn();

		/*
		 * Verification: 1. Verify the message is removed from the Messages folder.
		 */
		msgPage.verifyMsgGetsArchived();
		/* 2. Verify the message is added to and listed in the Archive folder. */

		msgPage.clickArchive();
		Utils.uBase.refresh();
		GAPage.getTextOfItemInSecondList(1).compareLists();
		//verifyArchivedFolder()
		// Cleaning Test data
		msgPage.clickFirstMessage().clickMoreOptn().restoreMsgFrmArchivedFolder();
		//hmPage.clickMessages();
		//GAPage.clickFirstItemInList().clickMoreOptn().deleteItem();

	}

	// Verify items in the Messages folder can be marked as Spam.
	public void messageMenuItemSpam(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Pre-Conditions: Items exist in the Messages folder. */
		//GAPage.reciveMultipleTestMsgs(data, 2);
		//ReceiveCallAndMessages.receiveMessage(data);
		Thread.sleep(3000);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		GAPage.removeItemsFromSpam();
		hmPage.clickMainMenu().clickTab(Constants.Messages);

		/* Procedure: 
		 		1. Navigate to the Voice Messages folder. 
		 		2. Select a message. 
		 		3. Select theMore options menu (three vertical dots). 
		 		4. Select the mark as Spam option. */

		GAPage.getTextOfItemsInFirstList(1).clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();

		/* Verification: 
		 		1. Verify the message is removed from the Messages folder. */
		msgPage.verifyMsgGetsSpam();
		/* 2. Verify the message is added to and listed in the Spam folder. */
		hmPage.clickTab(Constants.Spam);
		GAPage.getTextOfItemInSecondList(1).compareLists();
		//msgPage.verifyPhoneNumber();
		// Cleaning the data
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		GAPage.clickFirstItemInList().clickMoreOptn().selectUnmarkAsSpam();

	}

	//Verify items in the spam folder can be get back.
	public void messageMenuItemRemoveFromSpam(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Pre-Conditions: Items exist in the Messages folder. */
		//ReceiveCallAndMessages.receiveMessage(data);
		Thread.sleep(3000);
		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 1);
		hmPage.clickMainMenu().clickTab(Constants.Messages);

		/* Procedure: 
		 		1. Navigate to the Messages folder. 
		 		2. Select Spam menu item from the Navigational menu. 
		 		3. Select the message. 
		 		4. Select the more option menu item "Remove from Spam" */

		GAPage.clickFirstItemInList().clickMoreOptn().selectMarkAsSpam();
		Utils.uBase.refresh();

		/* Verification: 1. Verify the message is removed from the Spam folder. */
		hmPage.clickMainMenu().clickTab(Constants.Spam);
		GAPage.getTextOfItemsInFirstList(1).clickFirstItemInList().clickMoreOptn().selectUnmarkAsSpam();
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.getTextOfItemInSecondList(1).compareLists();
	}

	//Verify able to send/receive messages with links
	public void messageSendMessageWithLinks(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//Twillio call for generating dummy message. Image with this dummy message is already stored in images folder
		//msgPage.receiveTestMessage(data);
		Thread.sleep(3000);
		/*
		 * Pre-Condition: Should have Google voice number. Procedure: 1. Click on any
		 * existing message conversation item or Compose new mssage to the
		 * non-forwarding phone. 2. type message with one or more hyperlinks like
		 * https://www.google.com/*/

		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 1);
		hmPage.clickMainMenu().clickTab(Constants.Messages);

		/*Verification: 1. Verify able send/received message
		 * with hyperlinks.  
		 * 2. Verify by clicking on the hyperlink able navigating to
		 * the respective websites.*/   
		Utils.uBase.refresh();
		GAPage.clickFirstItemInList();
		msgPage.sendMsgToExistingConversationForHyperLink().sendComposedMessage();
		Thread.sleep(2000);
		msgPage.clickLinkMessage().verifyNavigationToAnotherWindow();

		// Cleaning the data
		GAPage.switchingToWindowByIndex(0).clickMoreOptn().deleteItem();

	}

	// Verify that selected text message can be deleted
	public void messageThreadDeleteTextMessage(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Pre-Conditions: Messages thread. */
		//GAPage.reciveMultipleTestMsgs(data,2);


		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		//GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 1);
		GAPage.receiveUniqeMessage(Constants.voipTwoId, Constants.pwd2, data, 1);
		/* Procedure:

  				1. Navigate to the Voice Messages folder.
  				2. Select a message thread.
  				3. Select the individual message bubble 
  				4. Click on three dot menu present beside each message bubble
  				5. select the popup menu item "Delete"*/
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.clickFirstItemInList();
		msgPage.clickMessageText().clickSingleMsgThreeDots().deleteSingleMsg();
		/* Verification: 
		   1. Verify that text message is removed from the Messages thread permanently with confirmation "Delete". */
		msgPage.verifyMsgDeletCnfrm().verifyUniqeMsgDeleted();
		//GAPage.clickThreeDotsMenuWithElement().deleteItem();
		//GAPage.reciveMultipleTestMsgs(data,2);
		//GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*
		 * Utils.uBase.refresh(); GAPage.clickFirstItemInList();
		 * GAPage.clickThreeDotsMenuWithElement().deleteItem();
		 */
	}

	// Verify that selected text message can be copied to clipboard
	public void messageThreadCopyTextMessage(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Pre-Conditions: Messages thread. */
		//msgPage.uiCheckForFirstMessage(data, Constants.TestMsg);
		Thread.sleep(4000);
		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickMessages();

		/*
		 * Procedure: 1. Navigate to the Voice Messages folder. 2. Select a message
		 * thread. 3.Select the individual message bubble 4. Click on three dot menu
		 * which is present beside each message bubble 5. select the popup menu item
		 * "CopyText" */

		GAPage.clickFirstItemInList();
		msgPage.clickMessageText().clickSingleMsgThreeDots().clickCopyText();
		/*
		 * Verification: 1. Verify that text message is copied to clipboard
		 */
		msgPage.verifyTxtCopied();
		GAPage.clickMoreOptn().deleteItem();

	}

	//Verify that selected picture message can be deleted
	public void messageThreadDeletePictureMessage(String email, String password, String data) throws Exception {


		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/*Pre-Conditions: Messages thread.*/
		//ReceiveCallAndMessages.receiveMessage(data);
		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 1);
		hmPage.clickMainMenu().clickTab(Constants.Messages);

		/* Procedure:
		 * 1. Navigate to the Voice Messages folder. 2. Select a message thread. 3.
		 * Select the individual message bubble 4. Click on three dot menu which is
		 * present beside each picture message 5. select the popup menu item "Delete"*/
		GAPage.clickFirstItemInList();
		msgPage.clickAddImage().sendComposedMessage();
		Thread.sleep(3000);
		Utils.uBase.refresh();
		Thread.sleep(6000);
		msgPage.clickSingleMsgThreeDots().deleteSingleMsg();
		Utils.uBase.refresh();
		/* Verification: 
		 * 1. Verify that picture message is removed from the Messages thread
		 * permanently with confirmation "Delete".*/
		msgPage.verifyImageExist();
		GAPage.clickMoreOptn().deleteItem();
	}
	//Verify able to send message to group with image.
	public void groupMessageSendPhoto(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/*Pre-Condition:
	   GV account*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/* Procedure:
		  		1. Login
		 	 	2. Click on "Send a message" button
		 		3. Type multiple phone numbers using comma delimiters.
		 		4. Click on Add Image icon and select the photo need to send.
		 		5 Click Send arrow button.*/
		hmPage.clickMainMenu().clickTab(Constants.Messages);   
		msgPage.clickSendNewMessage();
		msgPage.addPhoneNumbersList(Constants.GroupMsg,data).clickAddImageGrpMsg().sendComposedMessage();
		hmPage.clickTab(Constants.Messages);
		/* Verification:
		    1. Verify message listed in the conversation list item. 
		    2. Verify left side conversation item displayed the recent message like "You:(Sent a photo)" with tiny preview of image.*/
		msgPage.verifyMsgFolderForGrpMsg();
	}

	//Verify by click on "Send a message" not clearing already composed message
	public void messageSendNewMessageNotClearExistingMessage(String email, String password, String data) throws Exception 
	{   
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Pre-Conditions: Should have Google voice number.*/
		//msgPage.receiveTestMessage(data);

		//Logging in as Google Voice user
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		//Navigate to the Messages folder. 
		hmPage.clickMainMenu().clickMessages();		

		/* Procedure: 	1. Click on some existing conversation 
			  				2. Type message for them 
			  				3.Click on "Send a message" button */
		GAPage.clickFirstItemInList();
		msgPage.sendMsgToExistingConversation(data).sendComposedMessage();
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickMessages();
		GAPage.clickFirstItemInList();
		//  1. Verify that already composed message should not be cleared, still able to see in the "Message" input box.

		msgPage.verifyCurrentAndPreviousMsg();
	}

	//Verify able to turn off "Do not disturb" from message tab
	public void messageDoNotDisturbOff(String email, String password, String data) throws Exception {
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
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		
		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickSettings();
		settPage.clickDoNotDisturb().clickDoNotDisturbToggle(Constants.ON).clickCloseSettings();
		hmPage.clickMainMenu().clickTab("Calls");
		callPage.verifyCallsCount();


		msgPage.clickMessages().clickEndNowToDisableDoNotDisturb().verifyDoNotDisturbIsNotDisplayed();

		//ReceiveCallAndMessages.makeCall(data);
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickTab(Constants.Calls);  
		//hmPage.clickTab("Calls");
		callPage.verifyCallsCount();

	}    

	//Verify group message available menu items.
	public void groupMessageMenuItems(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/*Pre-Condition: * GV full account*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		msgPage.clickEndNowToDisableDoNotDisturb();
		hmPage.clickMainMenu().clickTab(Constants.Messages);   

		msgPage.clickSendNewMessage();

		//4.Verify multiple contacts can be added. 
		msgPage.addPhoneNumbersList(Constants.GroupMsg,data).sendMsgToGroupConversation(data).sendComposedMessage();
		Utils.uBase.refresh();
		msgPage.clickfirstMessageInList().clickThreeDots();
		msgPage.verifyMenuOptionsForGroupMsg().verifyMarkAsSpamAndBlockNum();

	}

	//Verify able to see all people phone number in the group message.
	public void groupMessagePeople(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/*Pre-Condition: * GV full account*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/* Procedure:
		 * 1. Login 2. Click on message tab 3. Select any group message item which has
		 * phone in contact and not in contact list. 4. Click on "More options" button
		 * on top right of the message panel. 5. Select "People" menu item.*/
		hmPage.clickMainMenu().clickTab(Constants.Messages);   
		msgPage.clickSendNewMessage();
		msgPage.addPhoneNumbersList(Constants.GroupMsg,data).sendMsgToGroupConversation(data).sendComposedMessage();
		Utils.uBase.refresh();
		msgPage.clickfirstMessageInList().clickThreeDots();
		/*Verification:
		 * 1. Verify that it displayed all the contact details of the message
		 * participants. 2. Verify that if person in contact list displayed with contact
		 * name and phone number. 3. Verify that if person not in contact list displayed
		 * with phone number only. */
		msgPage.clickPeopleGrpMsg().verifyPeople();
		// msgPage.verifyContactDetails();
	}

	//Verify items in the group Messages folder can be marked as archive.
	public void groupMessageMenuItemArchive(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/*Pre-Conditions:Items exist in the Messages folder.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/* Procedure:
		 * 1. Navigate to the Voice Messages folder.
		 * 2. Select a message.
		 * 3. Select the More options menu (three vertical dots).
		 * 4. Select the mark as Archive option.*/
		hmPage.clickMainMenu().clickTab(Constants.Messages);   
		msgPage.clickSendNewMessage();
		msgPage.addPhoneNumbersList(Constants.GroupMsg,data).sendMsgToGroupConversation(data).sendComposedMessage();
		Thread.sleep(3000);
		Utils.uBase.refresh();
		msgPage.clickfirstMessageInList().clickThreeDots();
		/*Verification:
		 * 1. Verify the message is removed from the Messages folder. 2. Verify the
		 * message is added to and listed in the Archive folder.*/
		msgPage.clickArchiveFrmMoreOptnGrpMsg().verifyMessagesCount();
		hmPage.clickMainMenu().clickArchive();
		GAPage.clickFirstItemInList();
		msgPage.verifyArchivedFolderForGrpMsg();


	}

	//Verify the confirmation warning for the delete message thread
	public void messageDeleteThreadUI(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//msgPage.receiveTestMessage(data);

		/*Pre-Conditions:Messages thread.*/
		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickMessages();
		/* Procedure:
			           1. Click on message tab
			           2. click on the message conversation item, which has more number of conversations.
			           3. Click on "More option" button
			           4. Click on "Delete" menu item */
		/*Verification: 
		 * 1. Verify that you able to see the "Delete Permanently" popup with text message of "Deleting a conversation with a person or group will remove the entire conversation. It's permanent and cannot be undone."
		 * with "CANCEL" and "DELETE" button. 
		 * 2. Also verify to see "I understand" checkbox.*/
		GAPage.clickFirstItemInList().clickMoreOptn().deleteItem();
		
		/*3. Verify that this message popup not shows up, after selected "I understand" checkbox, and "DELETE"*/
		GAPage.verifyDeleteConfirmationPopUp();
	}

	//Verify able to delete the entire message thread
	public void messageDeleteThread(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		/*Pre-Condition: GV full account */
		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*Pre-Conditions: Messages thread.*/
		//msgPage.receiveTestMessage(data);
		
		Thread.sleep(3000);
		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickMessages();

		/*Procedure: 1. Click on message tab 2. click on the message conversation item,
		 * which has more number of conversations. 3. Click on "More option" button 4.
		 * Click on "Delete" menu item*/
		GAPage.clickFirstItemInList().clickMoreOptn().deleteItem();
		/* Verification: 1. Verify that messages are deleted from the recent conversation. */
		msgPage.verifyMsgListAfterConversationDeleted();

		/* 2. Also verify toast message "Conversation deleted" */
		msgPage.verifyConversationDeleted();
	}

	// Verify that able to select multiple threads of messages items
	public void messagesThreadSelect(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Pre-Condition: Should have messages thread. */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//msgPage.receiveTestMessage(data);


		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickMessages();
		/*
		 * Procedure: 1. Click on messages tab 2. Click on one or more than one Avatars
		 * of messages items.
		 */

		/*
		 * Verification: 1. Verify that able to select multiple threads of messages
		 * items.
		 */
		msgPage.clickMultipleAvatars();
		//Cleaning the data
		msgPage.unSelectMultipleAvatars();

	}

	// Verify able to Unselect multiple messages thread
	public void messagesThreadSelectArchive(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Pre-Condition: Should have messages thread. */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//msgPage.receiveTestMessage(data);

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickMessages();

		/*
		 * Procedure: 1. Click on messages tab 2. Click on one or more than one Avatars
		 * of messages items. 3. Click on Archive icon (Upper Left panel)
		 */

		msgPage.clickMultipleAvatars();
		/* 1. Verify that messages item selected should be Archived. */
		msgPage.archiveSelectMultipleAvatars();
		/* 2.Verify the pop up saying items Archived with Undo option. */
		msgPage.verifyArchiveCnfrmPopUp().clickArchiveUndo();

	}

	// Verify that archived items can be successfully restored by selecting Undo option
	public void messagesThreadSelectUndoArchive(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Pre-Condition: Should have messages thread. */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickMessages();
		/* Pre-Condition: 1. Should have messages threads. */

		//msgPage.receiveTestMessage(data);
		msgPage.verifyCountOfMsgs();
		/*
		 * Procedure: 1. Click on messages tab 2. Click on more than one message item
		 * Avatar icon 3. Click on Archive icon (Upper Left panel) 4. Click on UNDO
		 */
		msgPage.clickMultipleAvatars();
		/*
		 * Verification: 1. Verify that messages item selected should be Archived. 2.
		 * Verify the pop up saying items Archived with Undo option. 3. Verify that
		 * archived items should be placed again in messages folder.
		 */
		msgPage.archiveSelectMultipleAvatars();
		msgPage.verifyArchiveCnfrmPopUp().clickArchiveUndo();
		msgPage.verifyCountOfMsgs();

		GAPage.clickFirstItemInList().clickMoreOptn().deleteItem();
	}

	// Verify able to Unselect multiple messages thread
	public void messagesThreadSelectUnselect(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Pre-Condition: Should have messages thread. */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//msgPage.receiveTestMessage(data);

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickMessages();
		/*Procedure: 1. Click on messages tab 2. Click on one or more than one Avatars
		 * of messages items. 3. Click "X" icon and unselect the items*/
		/* Verification: 1. Verify that able to select multiple threads of messages
		 * items*/
		msgPage.clickMultipleAvatars();
		callPage.verifyIfAvatarsAreSelected();
		/* 2. Verify that able to unselect all the selected items */
		msgPage.unSelectMultipleAvatars();
	}

	//Verify that able to select multiple messages in message item thread.
	public void messagesBatchMessageSelect(String email, String password, String data) throws Exception {
		//ReceiveCallAndMessages.receiveThreeMessages(data);
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/*Pre-Condition: Should have messages in a message thread.*/
		//GAPage.reciveMultipleTestMsgs(data, 5);
		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		//GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 5);
		hmPage.clickMainMenu();
		msgPage.clickMessagesTab();
		/* Procedure: 
		  	1. Click on messages tab 
		  	2. Click on one message item thread 
		  	3. Click on three dot menu present beside each message and click on Select menu item 
		  	4. Click on select button for few more messages */
		GAPage.clickFirstItemInList();
		msgPage.clickMessageText().clickOnThreeDotMenuBesideMsg().selectButtonForFewMoreMessages();
		/*Verification: 
		 	1. Verify that able to select multiple messages items.*/
		msgPage.clickMultipleSelectCheckBox();
	}

	/* Verify able to Unselect multiple messages items */
	public void messagesBatchSelectUnselect(String email, String password, String data) throws Exception 
	{   

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/* Pre-Condition: 
		    	Should have messages in a message thread. */
		//GAPage.reciveMultipleTestMsgs(data, 5);

		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 5);
		hmPage.clickOnNotificationAllowBtn();
		msgPage.clickEndNowToDisableDoNotDisturb();
		/*
		 * Procedure: 
		 * 1.Click on messages tab 
		 * 2.Click on one message item thread
		 * 3.Click on three dot menu present beside each message and click on select button 
		 * 4. Click on select button for few more messages 
		 * 5. Click "X" icon and unselect the messages
		 */
		hmPage.clickMainMenu().clickMessages();
		msgPage.clickFirstMessage().clickMessageText().clickOnThreeDotMenuBesideMsg();
		msgPage.selectButtonForFewMoreMessages().selectFewMoreMessages().unselectMessages();

		/*Verification: 
		 * 1. Verify that able to unselect all the selected items.*/
		msgPage.verifySelectedMsgsUnselected();

		/* Clear Test Data */
		msgPage.deleteMsg();
	}

	/* Verify able to Unselect multiple messages items */
	public void messagesBatchMessageSelectDelete(String email, String password, String data) throws Exception 
	{   

		//ReceiveCallAndMessages.receiveThreeMessages(data);

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/*Pre-Condition: 
		 * Should have messages in a message thread.*/
		//GAPage.reciveMultipleTestMsgs(data, 10);

		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 5);
		/*Procedure:
         1. Click on messages tab
         2. Click on one message item thread
         3. Click on three dot menu present beside each message and click on select button
         4. Click on select button for few more messages 
         5. Click on delete icon on right top panel*/
		hmPage.clickMainMenu().clickMessages();
		msgPage.clickFirstMessage().clickMessageText().clickOnThreeDotMenuBesideMsg();
		msgPage.selectButtonForFewMoreMessages().selectFewMoreMessages();

		/*Verification: 
		 * 1. Verify that able to unselect all the selected items.*/
		msgPage.verifyAbleToDeleteMultipleMsgs();
	}

	/* Verify that able to delete multiple messages in message item thread. */
	public void messagesMessageHoverMenu(String email, String password, String data) throws Exception 
	{   

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*Pre-Condition: 
		 * Should have messages in a message thread.*/
		//GAPage.reciveMultipleTestMsgs(data, 5);

		/* Initiating the java page into object using PageFactory */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 1);
		/*Procedure:
         1. Click on messages tab
         2. Click on one message item thread
         3. Keep cursor on a message and click on options (3 vertical dots) button*/
		hmPage.clickMainMenu().clickMessages();
		msgPage.clickFirstMessage().clickMessageText().clickOnThreeDotMenuBesideMsg();

		/*Verification:
         1. Verify that able to see "Copy text", "Delete" and "Select" messages options.*/
		msgPage.verifyCopytextDeleteAndSelectMsgoptions();

		/*2. For picture message it should show 'Select' , 'Delete' Menu options*/
		msgPage.clickMsgThread().clickAddImage().clickSelectAddImgWindow().sendComposedMessage();
	
		//Utils.uBase.refresh();
		Thread.sleep(3000);
		Utils.uBase.refresh();
		Thread.sleep(5000);
		msgPage.clickImage();
		msgPage.verifySelectDeleteMenuOptionsforImage();
		//msgPage.clickFirstMessage();
		//hmPage.clickMainMenu();
		GAPage.doubleClickMoreOptn().deleteItem();
	}

	//Verify able to reply to the received message conversation thread.
	public void messageReceiveToRestoreArchiveItem(String email, String password, String data) throws Exception {
		
		// Launching google voice web application
		  Utils.uBase.launchWebApplication();
		// Launch the mobile driver
		Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAME2,
				Constants.MESSAGE_APP_ACTIVITY2);
		MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);

		/*Procedure:
  				1. Select the message from X phone number already received.
  				2. click on "Archive" menu item from "More option" menu*/

		msgMobPage.tapComposeNewMsgNtvApp(data);
		
		  
		  GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver,
		  GVSignInPage.class); HambergerMenuPage hmPage =
		  PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		  MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver,
		  MessagePage.class); GeneralActivitiesPage GAPage =
		  PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		  
		  gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().
		  enterPassword(password).clickNextButton();
		  hmPage.clickMainMenu().clickTab(Constants.Messages);
		  GAPage.clickFirstItemInList().clickMoreOptn().clickArchiveFrmMoreOptn();
		  Utils.uBase.refresh();
		 
		// Launch the mobile driver
		
		Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAME2,
				Constants.MESSAGE_APP_ACTIVITY2);
		MessagePageAndroid msgMobPages = new MessagePageAndroid(Utils.uBase.mDriver);
		Thread.sleep(8000);
		//3. Send new message from "X" phone number to the GV#
		msgMobPages.tapComposeNewMsgNtvApp(data);
		/* Verification:
			1. Archived message item, should be restored.
			2. Restored item with new message as unread item. */
		Thread.sleep(8000);
		msgPage.verifyMobileNumberGetsRestore();
		GAPage.clickFirstItemInList().clickMoreOptn().deleteItem();	
	}

	//Verify group message tiny avatars are appropriate..
	public void groupMessageAvatars(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*Pre-Condition:
		 *  GV account with group message item with people of two to four people.*/
		hmPage.clickMainMenu().clickTab(Constants.Messages);   
		msgPage.clickSendNewMessage();
		msgPage.addPhoneNumbersList(Constants.GroupMsg,data).sendMsgToGroupConversation(data).sendComposedMessage();
		Utils.uBase.refresh();

		/* Procedure:
		 * 1. Login 
		 * 2. Click on messages tab.
		 * 3. Scroll to the group message item.*/
		hmPage.clickMainMenu().clickTab(Constants.Messages);

		/*Verification:  
		 * 1. Verify that group message tiny avatar shows each avatar for each people.
		 * 2. Verify that, the tiny avatars follow the other test cases Message.AvatarPerson,
		 *  Message.AvatarText, and Message.AvatarProfileImage.*/
		msgPage.verifyTinyAvatar().verifyAvatarTextAndPersonImg();

		/* Clear Test Data */
		msgPage.cleanCreatedMessageLog(data);
	}
	public void messageThreadSelectUndoSecondTime(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		
		//GAPage.reciveMultipleTestMsgs(data, 2);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, Constants.voipOneNo, 1);
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		//msgPage.clickSendNewMessage().typeNumberinMsgToField(Constants.phoneNo).typeAMsgAndCheckSendBtn().sendMessage();
		msgPage.clickSendNewMessage().setNumMsgToField(data).setTextNewMsg("Test")
		.clickToMsgTxt().sendComposedMessage();
		msgPage.clickMultipleAvatars();
		GAPage.getTextOfItemsInFirstList(2);
		msgPage.archiveSelectMultipleAvatars();
		msgPage.verifyArchiveCnfrmPopUp().clickArchiveUndo();
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.getTextOfItemInSecondList(2).compareLists();
		Thread.sleep(1500);
		msgPage.clickArchiveUndo();
		hmPage.clickMainMenu().clickTab(Constants.Archive);
		GAPage.getTextOfItemInSecondList(2).compareLists();
	}
	
	public void messagesThreadUnselectbyClickingagain(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		HomePageWeb hmWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, Constants.voipOneNo, 2);
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		//msgPage.clickSendNewMessage().typeNumberinMsgToField(Constants.phoneNo).typeAMsgAndCheckSendBtn().sendMessage();
		msgPage.clickSendNewMessage().setNumMsgToField(data).setTextNewMsg("Test")
		.clickToMsgTxt().sendComposedMessage();
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		GAPage.clickOnMultipleAvatars().verifyClickOnMultipleAvatars().verifyCountDecrementOnReselect();
	}
	
	public void messagesbatchSelectclickagaintoUnselect(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		
		//GAPage.reciveMultipleTestMsgs(data, 10);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 10);
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		Thread.sleep(2000);
		GAPage.clickFirstItemInList();
		msgPage.clickMessageText().clickSingleMsgThreeDots();
		msgPage.selectButtonForFewMoreMessages().selectFewMoreMessages().verifyMessagesSelected().selectFewMoreMessages().verifyMessagesUnselected();
		GAPage.clickMoreOptn().deleteItem();
	}
}