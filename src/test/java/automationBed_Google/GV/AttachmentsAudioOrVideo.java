package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.MessagePageAndroid;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class AttachmentsAudioOrVideo extends SuiteBase {

	//Message conversation audio file details
	public void messageConversationAudioFileDetails(String email, String password, String data) throws Exception {

		// Launching google voice web application
		Utils.uBase.launchWebApplication();
		// Launch the mobile driver
		Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAMES9Plus,
				Constants.MESSAGE_APP_ACTIVITYS9Plus);
		MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
		// Send a audio file from the mobile to Gv web account
		msgMobPage.sendAudioFile(data);


		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		/*
		 * Verification: 1.Verify Audio file display's: the audio bubble with title text
		 * ""Audio Clip"" with play button and duration. 2.Verify user can play/pause
		 * audio file anytime. 3.Verify when the audio is playing progress bar will
		 * appear. 4.Verify once finished, progress bar is gone, and text 'Audio Clip'
		 * is displayed.
		 */
		GAPage.clickFirstItemInList().verifyAudioFileIsDisplayed().clickPlayNPause().verifyProgressBar()
		.verifyProgressBarIsDoneAudioDisplayed();
		// delete the content
		msgPage.deleteMsg();


	}
	//Message conversation unsupported file type details
	public void messageConversationUnsupportedFileType(String email, String password, String data) throws Exception {

		// Launching google voice web application

		Utils.uBase.launchWebApplication();
		// Launch the mobile driver
		Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAMES9Plus,
				Constants.MESSAGE_APP_ACTIVITYS9Plus);
		MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
		// Send a audio file from the mobile to Gv web account
		msgMobPage.sendUnsupportedFile(data);


		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver,GVSignInPage.class); 
		HambergerMenuPage hmPage =PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver,MessagePage.class); 
		GeneralActivitiesPage GAPage =PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickTab(Constants.Messages);

		/* Verification: 1.Verify bubble display's: 'File type not supported' with the
		 * attachment mime type.*/	
		Utils.uBase.refresh();
		GAPage.clickFirstItemInList().verifyUnsupportedFileIsDisplayed();
		//Clean the data
		msgPage.deleteMsg();


	}

	//Receive audio file when HO integrated
	public void receivingAnAttachmentWhileHOIntegrated(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		// Launch the mobile driver
		Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAMES9Plus,
				Constants.MESSAGE_APP_ACTIVITYS9Plus);
		MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
		// Send a audio file from the mobile to Gv web account
		msgMobPage.sendAudioFile(data);
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePage=PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		// Pre-condition:
		//1.Enable HO integration by check-boxing "Receive SMS and Voicemail in HO".  
		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		/*
		 * Procedure: 1.Login to HO integrated GV account 2.Receive an audio clip.
		 */

		hmPage.clickMainMenu().clickMessages();
		homePage.RemoveIfHangoutIsAlreadyIntegrated();
		/*
		 * Verification: 1.Verify able to receive audio file in HO web/app. 2.Verify
		 * Audio file display:the audio bubble with tile text Web :" Audio Clip".
		 * 2.Verify user can play/pause audio file anytime. 3.Verify when the audio is
		 * playing progress bar will appear. 4.Verify once finished, progress bar is
		 * gone, and text 'Audio Clip' is displayed */

		homePage.clickGoogleApps().clickGmail().integrateHangouts().verifyHangoutsMessageDisplayedInGV();
		GAPage.clickFirstItemInList().verifyAudioFileIsDisplayed().clickPlayNPause().verifyProgressBar().verifyProgressBarIsDoneAudioDisplayed();
		// delete the content
		msgPage.deleteMsg();
		homePage.removeHangoutIntegration();


	}
	//Receiving only GV incoming audio message folder and preview in message items list
		public void receivingAnAudioFileInMessage(String email, String password, String data) throws Exception {

			// Launching google voice web application
			Utils.uBase.launchWebApplication();
			// Launch the mobile driver
			Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAME2,
					Constants.MESSAGE_APP_ACTIVITY2);
			MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
			// Send a audio file from the mobile to Gv web account
			msgMobPage.sendAudioFile(data);


			GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
			HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
			MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
			GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

			gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
			hmPage.clickMainMenu().clickTab(Constants.Messages);
			/*
			 * Verification: 1.Verify can able to receive an incoming audio message to GV
			 * 2.Verify message items list on LHS is displaying text as:'Sent an audio clip'
			 */
			GAPage.clickFirstItemInList();
			msgPage.verifyMsgPreview("Sent an audio clip");
			GAPage.verifyAudioFileIsDisplayed();
			/*
			 * Verification: 3.Verify message items list on LHS is displaying 'text content'
			 * in preview.
			 */
			Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAME2,
					Constants.MESSAGE_APP_ACTIVITY2);
			MessagePageAndroid msgMobPages = new MessagePageAndroid(Utils.uBase.mDriver);
			msgMobPages.tapComposeNewMsgNtvApp(data);
			msgPage.verifyMsgPreview("Test Message");
			// delete the content
			msgPage.deleteMsg();
		}
		//Receiving an unsupported file type in messages item list preview
		public void receivingAnUnsupportedTypeFile(String email, String password, String data) throws Exception {

			// Launching google voice web application

			Utils.uBase.launchWebApplication();
			// Launch the mobile driver
			Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAME2,
					Constants.MESSAGE_APP_ACTIVITY2);
			MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
			// Send a audio file from the mobile to Gv web account
			msgMobPage.sendUnsupportedFile(data);


			GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver,GVSignInPage.class); 
			HambergerMenuPage hmPage =PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
			MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver,MessagePage.class); 
			GeneralActivitiesPage GAPage =PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

			gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
			hmPage.clickMainMenu().clickTab(Constants.Messages);
			/*
			 * Verification: 1.Verify can able to receive an incoming unsupported file to GV
			 * 2.Verify message items list on LHS is displaying text as:'File type not
			 * supported'
			 */
			Utils.uBase.refresh();
			GAPage.clickFirstItemInList();
			msgPage.verifyMsgPreview("File type not supported");
			GAPage.verifyUnsupportedFileIsDisplayed();
			/*
			 * Verification: 3.Verify message items list on LHS is displaying 'text content'
			 * in preview .
			 */
			Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAME2,
					Constants.MESSAGE_APP_ACTIVITY2);
			MessagePageAndroid msgMobPages = new MessagePageAndroid(Utils.uBase.mDriver);
			msgMobPages.tapComposeNewMsgNtvApp(data);
			msgPage.verifyMsgPreview("Test Message");
			//Clean the data
			msgPage.deleteMsg();
		}
		//Receiving only GV incoming video file in message folder and preview in message items list
		public void receivingAnVideoFileInMessage(String email, String password, String data) throws Exception {

			// Launching google voice web application

			Utils.uBase.launchWebApplication();
			// Launch the mobile driver
			Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAME2,
					Constants.MESSAGE_APP_ACTIVITY2);
			MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
			// Send a audio file from the mobile to Gv web account
			msgMobPage.sendVideoFile(data);


			GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver,GVSignInPage.class); 
			HambergerMenuPage hmPage =PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
			MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver,MessagePage.class); 
			GeneralActivitiesPage GAPage =PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

			gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
			hmPage.clickMainMenu().clickTab(Constants.Messages);
			msgPage.verifyMsgPreview("Sent a video");

}
}
