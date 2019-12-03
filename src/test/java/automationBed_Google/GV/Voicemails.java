package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.GmailPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.VoicemailPage;
import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class Voicemails extends SuiteBase{

	/*Verify able to Unselect multiple voicemail thread*/	
	public void voicemailsThreadSelect(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Pre-Condition: GV full account*/

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		VoicemailPage vmPage = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);

		/*Login into Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*Verification of the ability to select multiple voicemail threads*/	
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		vmPage.clickMultipleVoicemailAvatars().verifyIfAvatarsAreSelected();
	}

	/*Verify ability to unselect the selected multiple voicemail threads*/ 
	public void voicemailThreadSelectUnselect(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();		

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		VoicemailPage vmp = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		/*Login into Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		Thread.sleep(3000);

		/* Verification of the ability to unselect voicemails avatars */
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		vmp.clickMultipleVoicemailAvatars().voicemailThreadSelectUnselect().verifyItemsSelectUnselect();
	}

	/* Verify the mail is added to and listed in the Trash folder. */
	public void voicemailDelete(String email, String password, String data) throws Exception
	{	
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		VoicemailPage vmp = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		GeneralActivitiesPage GVPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Pre-Conditions:
		  			Items exist in the Voicemails folder.
		 */	
		//GVPage.multipleVoicemails(data, 2);
		Thread.sleep(5000);
		/*Login into Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GVPage.receiveMultipleVoicemails(Constants.voipTwoId, Constants.pwd2, data, 2);
		/*Navigation to Voicemails Folder*/
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		/* Verification to check if voicemail is deleted*/
		Utils.uBase.refresh();
		GVPage.getTextOfItemsInFirstList(1).clickFirstItemInList().clickThreeDotsMenuWithElement().deleteItem();
		//vmp.voicemailDelete();	
		GVPage.getTextOfItemInSecondList(1);
		GVPage.verifyItemsRemoved();
		// 2. Verify the mail is added to and listed in the Trash folder.
	}

	/*Verification of the ability to delete voicemail threads*/
	public void voicemailThreadSelectDelete(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		VoicemailPage vmp = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		GeneralActivitiesPage GVPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		//GVPage.multipleVoicemails(data, 3);
		/*Login into Application*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*Clicking on the Voicemail tab*/
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);

		/* Verification of the ability to delete the voicemail threads*/
		Utils.uBase.refresh();
		GVPage.getTextOfItemsInFirstList(2);//.clickFirstItemInList().clickThreeDotsMenuWithElement().deleteItem();
		msgPage.clickMultipleAvatars();
		vmp.voicemailThreadDelete();
		GVPage.getTextOfItemInSecondList(2);
		GVPage.verifyItemsRemoved();
		
	}
	/* Verification of the ability that archived items can be successfully restored by selecting Undo option */
	public void voicemailThreadSelectUndoArchive(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		VoicemailPage vmp = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		GeneralActivitiesPage GVPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*Procedure: Login with GV user*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*Clicking on the Voicemail tab*/
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);

		/* Verification of the following are being performed:
	1) Verification of the ability to select multiple voicemail threads		
	2) Verify the pop up saying items Archived with Undo option*/
		GVPage.getTextOfItemsInFirstList(2);
		vmp.clickMultipleVoicemailAvatars().clickingOnArchiveIconInVoicemailPage().clickUndoButton();
		//.avatarsAfterUndo();
		GVPage.getTextOfItemInSecondList(2).compareLists();
	}

	/* Verify that selected voicemail items in voicemail thread can be archived */
	public void voicemailThreadSelectArchive(String email, String password, String data) throws Exception {
		
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		/*Pre-Condition:
				1. Should have voicemail threads.*/

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		VoicemailPage vmp = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
		GeneralActivitiesPage GVPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		/* Generating the new voicemail thread */	
		//GVPage.multipleVoicemails(data, 6);
		/*Procedure:
			1. Click on voicemail tab
			2. Click on more than one voicemail item Avatar icon
			3. Click on Archive icon (Upper Left panel)*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GVPage.receiveMultipleVoicemails(Constants.voipOneId, Constants.pwd2, Constants.voipTwoNo, 3);

		/*Clicking on the Voicemail tab*/
		hmPage.clickMainMenu();
		/* Verification:
			1. Verify that voicemail item selected should be Archived.
			2. Verify the pop up saying items Archived with Undo option.*/
		hmPage.clickTab(Constants.VoiceMail);
		Utils.uBase.refresh();
		GVPage.getTextOfItemsInFirstList(2);
		vmp.captureVoicemailNums().clickVoicemailArchiveIcon();
		hmPage.clickMainMenu().clickTab(Constants.Archive);
		GVPage.getTextOfItemInSecondList(2).compareLists();
	}

	
	/*Verify click on email notification of voicemail redirects to the googlevoice and play */
	public void voicemailClickOnEmail(String email, String password, String data) throws Exception {

		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		HomePageWeb homePage= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		GmailPage gmail= PageFactory.initElements(Utils.uBase.webDriver, GmailPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		
		//Pre-Condition:
		// 1. Get voicemail notification in email using settings page configuration.
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.removeItemsFromSpam();
		homePage.clickGoogleApps().clickGmail();
		GAPage.switchingToWindowByIndex(1);
		gmail.deleteVoiceMailEmail();
		GAPage.switchingToWindowByIndex(0);
		/*Procedure:
			  1. Login gmail
			  2. Click on voicemail notification email.*/
		
		hmPage.clickSettings();
		stngpg.clickVoiceMailInSettings().checkVoicemailviaEmailBtn().clickCloseSettings();
		//GAPage.multipleVoicemails(data, 2);
		GAPage.receiveMultipleVoicemails(Constants.voipOneId, Constants.pwd2, data, 2);
		Thread.sleep(5000);
		//homePage.clickGoogleApps().clickGmail();
		GAPage.switchingToWindowByIndex(1);
		Utils.uBase.refresh();
		/*
		 * Verification:
		 * 1. Verify that, it redirects to google voicemail to play if logged in.
		 */
		gmail.verifyNavigationToGoogleVoicemail();
	}
	
	public void voicemailThreadUnselectbyClickingAgain(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//GAPage.multipleVoicemails(data, 5);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleVoicemails(Constants.voipOneId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		Utils.uBase.refresh();
		//hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		GAPage.clickOnMultipleAvatars().verifyClickOnMultipleAvatars().verifyCountDecrementOnReselect();
	}
	public void voicemailThreadSelectUndoSecondTime(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		//GAPage.multipleVoicemails(data, 4);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleVoicemails(Constants.voipTwoId, Constants.pwd2, data, 2);
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		Utils.uBase.refresh();
		msgPage.clickMultipleAvatars();
		GAPage.getTextOfItemsInFirstList(2);
		msgPage.archiveSelectMultipleAvatars();
		msgPage.verifyArchiveCnfrmPopUp().clickArchiveUndo();
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		//GAPage.getTextOfItemInSecondList(2).compareLists();
		Thread.sleep(1500);
		msgPage.clickArchiveUndo();
		hmPage.clickTab(Constants.Archive);
		Thread.sleep(2000);
		GAPage.getTextOfItemInSecondList(2).compareLists();
	}	
}
