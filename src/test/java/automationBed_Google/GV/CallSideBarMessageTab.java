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

public class CallSideBarMessageTab extends SuiteBase {
	
	public void messageInitiateCallbyEnteringPhoneNumber(String email, String password, String data) throws Exception 
	{
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		
		/*
		 * Procedure: 
		 * 1. Login with Moya account. 
		 * 2. Select Messages tab. 
		 * 3. On the CallSideBar enter the phone number using keypad on CallSideBar. 
		 * 3. Click call button.
		 */
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		
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
	
	public void messageInitiateCallbySelectingFromSuggestions(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		HomePageWeb homePage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		/*
		 * Procedure: 
		 * 1. Login with Moya account. 
		 * 2. Select Message tab. 
		 * 3. On CallSideBar type 'A'. 
		 * 4. Select any contact from the list and click on it to initiate the call.
		 */
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		
		/*
		 * Verification: 
		 * 1. Verify user is getting suggested list of contact after typing the phone number. 
		 * 2. Verify the call is initiated and CallSideBar becomes calling UI panel.
		 */
		
		callPage.EnteraNameOrNum().enterContactLetter("t");
		homePage.verifyContactListDisplayed();
		callPage.callplaced().verifyAbleToMakeCall();
	}
	public void switchToTheSettingsMessageTab(String email, String password, String data) throws Exception 
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
		hmPage.clickMainMenu().clickTab(Constants.Messages).clickSettings();
		homePage.verifyNavigatedToSettings().verifyDailpadNotDisplayed();
		stngpg.clickCloseSettings();
		homePage.verifyNavigatedToMessages();
		homePage.verifyCallPanelInRight();
	}
    public void initiateCallFromMessageDetailsBar(String email, String password, String data) throws Exception {

        /* Launching google voice application */
        Utils.uBase.launchWebApplication();

        GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
        HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
        GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
        CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

        /*            Procedure:
            1. Login with Moya account.
                       2. Select messages tab.
                       3. Select Contact from the list on the left side.
                       4. Click on call button on top of the Archive details section.
        */

        gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
        GAPage.receiveMultipleMessages(Constants.voipTwoId,Constants.pwd2,Constants.voipOneId,1);
        hmPage.clickMainMenu().clickTab(Constants.Messages);

        /* Verification:
                        1. Verify that call is initiated and CallSideBar becomes UI Call panel.|   */

        GAPage.verifyDailpadKeypad();
        GAPage.clickFirstItemInList().clickCallButton();
        Thread.sleep(5000);
        callsPage.verifyAbleToMakeCall().clickOnCallEndBtn();

}


public void selectContactFromCallList(String email, String password, String data) throws Exception {

        /* Launching google voice application */
        Utils.uBase.launchWebApplication();

        GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
        HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
        GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
        CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
        MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

        /*            Procedure:
            1. Login with Moya account.
                       2. Select Message Tab.
                       3. Select Contact from the list on the left side
                       4. Observe CallSideBar.

        */

        gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
        GAPage.receiveMultipleMessages(Constants.voipTwoId,Constants.pwd2,data,1);
        hmPage.clickMainMenu().clickTab(Constants.Messages);

        /* Verification:
                        1. Verify that after Message Tab was selected and user selected contact from the list on left side the CallSideBar remains on the right side of the page.
                       2. Verify in the middle of the page user should be able to see message details, and on top of that on the left phone number; on the right - call button, message button, and 3 dots menu button.
        */

        GAPage.verifycontactItemInList().verifyDailpadKeypad().clickFirstItemInList();
        Thread.sleep(2000);
        GAPage.verifyMessageDetails().verifyContactDetails();
        msgPage.verifyMsgCallToolTip().verifyMsgThreeDotsToolTip();

}


}
