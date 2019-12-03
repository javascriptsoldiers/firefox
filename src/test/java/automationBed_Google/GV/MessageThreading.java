package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class MessageThreading extends SuiteBase {

	/*Verify that multiple converstaion merged into single conversation*/
	public void messageThreadingSingleConversation(String email, String password, String data) throws Exception
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage messagePage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*Pre-Condition:
			GV Account having multiple conversation with one user*/
		//messagePage.receiveTestMessage(data);
		//GAPage.reciveMultipleTestMsgs(data, 4);
		/*Procedure:
			1. Login GV account
			2. Click on message item to the user.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickMessages();

		//Verify that, all the message conversation to the user exist in the single message conversation thread.
		//Verify that, Single message item displaying recently sent text, and time in the preview
		messagePage.verifyRecentlyText();
	}

	/*Verify that both side message text alignment*/
	public void messageThreadingSendMessage(String email, String password, String data) throws Exception
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage messagePage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/*Procedure:
		1. Login GV account
		2. Click on message item to the user.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickMessages();
		//		Verify that while sending message, it should show "Sending..." status messages.
		//		Verify that after sent message, it should display date & time.
		messagePage.clickSendNewMessage().composeNewMessage(data).sendComposedMessage().verifySending();
	}
	
	/*Verify that both side message text alignment*/
	public void messageThreadingReceiveMessage(String email, String password, String data) throws Exception
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage messagePage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		HomePageWeb homePage= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		/*  Procedure:
        1. Login GV account
        2. Click on message item to the user.
        3. Send message from non-forwarding phone to GV account.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		//hmPage.clickMainMenu();
		//homePage.countOfItemsInMessagesList();
		//ReceiveCallAndMessages.receiveMessage(data,GAPage.generateUniqueString());
		hmPage.clickMainMenu().clickMessages();
		messagePage.verifyMessageWithGeneratedStringReceived(GeneralActivitiesPage.data);
		//messagePage.receiveTestMessage(data);
		/* Verification: 1. Verify that able to receive the messages, while haven't open
		 * the message thread. 2. Verify that able to receive the messages, while opened
		 * that users message thread. */
		/*
		 * homePage.verifyUnreadMsgsEqualToTheTotalNumber();
		 * hmPage.clickMainMenu().clickMessages();
		 * messagePage.countOfItemsInMsgListAfterMsgs();
		 */
		messagePage.clicKMessageWithGeneratedString(GeneralActivitiesPage.data);
		//ReceiveCallAndMessages.receiveMessage(data,GAPage.generateUniqueString());
		Utils.uBase.refresh();
		messagePage.verifyMessageReceivedInOpenConversation(GeneralActivitiesPage.data);
		//Cleaning the data
		hmPage.clickMainMenu().clickMessages();
		messagePage.clicKMessageWithGeneratedString(GeneralActivitiesPage.data).clickMoreOptn();
         GAPage.deleteItem();
         homePage.verifyMessageWithGeneratedStringIsRemvedFromAllFolders(GeneralActivitiesPage.data);
	}
}