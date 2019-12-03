package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.SpamPage;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class CallSidebarVoicemailTab extends SuiteBase {

	public void voicemailInitiateCallbyEnteringPhoneNumber(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		
		/*
		 * Procedure: 
		 * 1. Login with Moya account. 
		 * 2. Select Voicemail tab. 
		 * 3. On the CallSideBar enter the phone number using keypad on CallSideBar. 
		 * 3. Click call button.
		 */
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail);
		
		/* Verification:
		 * 1. Verify that user is able to enter the phone number by using keypad on CallSideBar. 
		 * 2. Verify that call button becomes blue.
		 */
		
		callPage.EnteraNameOrNum().checkDialpad().enterNumberThroughDailpad().callbuttonverification().clickOnCallBtn();
		Utils.uBase.clickOnNotificationAllowBtn();
		Thread.sleep(5000);
		callPage.clickOnCallEndBtn();
		Thread.sleep(1000);
		Utils.uBase.refresh();
		
	}
	public void switchToTheSettingsVoicemailTab(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		HomePageWeb homePage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*Procedure:
			1. Login with Moya account.
			2. Select Archive tab.
			3. Observe CallSideBar.
			4. Navigate to the settings.
			5. Close the settings.*/

		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/*
		 * Verification: 1. Verify that after login contact the CallSideBar remains on
		 * the right side of the page. 2. After user navigates to the settings verify
		 * that settings page is open and CallSide Bar is not presented on the settings
		 * page. 3. After user closes settings verify user is landing back and
		 * CallSideBar should be on the right side of the page.
		 */
		homePage.verifyCallPanelInRight();
		hmPage.clickMainMenu().clickTab(Constants.VoiceMail).clickSettings();
		homePage.verifyNavigatedToSettings().verifyDailpadNotDisplayed();
		stngpg.clickCloseSettings();
		homePage.verifyNavigatedToVoicemail();
		homePage.verifyCallPanelInRight();
	}
    public void initiateCallFromVoicemailDetailsBar(String email, String password, String data) throws Exception {

        /* Launching google voice application */
        Utils.uBase.launchWebApplication();

        GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
        HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
        GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
        CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

        /*            Procedure:
            1. Login with Moya account.
                       2. Select voicemail tab.
                       3. Select Contact from the list on the left side.
                       4. Click on call button on top of the Archive details section.
        */

        gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
        GAPage.receiveMultipleVoicemails(Constants.voipTwoId,Constants.pwd2,Constants.voipOneNo,2);
        hmPage.clickMainMenu().clickTab(Constants.VoiceMail);

        /* Verification:
                        1. Verify that call is initiated and CallSideBar becomes UI Call panel.|   */

        GAPage.verifyDailpadKeypad();
        GAPage.clickFirstItemInList().clickCallButton();
        Thread.sleep(5000);
        callsPage.verifyAbleToMakeCall().clickOnCallEndBtn();

}

	
}
