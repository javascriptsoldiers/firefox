package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.SearchPage;
import automationBed_Google.pom.gv.VoicemailPage;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class Voip extends SuiteBase {

	/* Verify anonymous/unknown calls are placed */
	public void makeVoipCallUnknownCall(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		HomePageWeb HomePageWeb= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu();

		/*
		 * Procedure: 1. Click on dial pad button present in the top right corner of
		 * calls ""To"" field 2. Make an Unknown call
		 */
		hmPage.clickTab("Calls");
		callsPage.EnteraNameOrNum().enterAnonymousNumber().clickOnCallButton().clickOnCallEndBtn();
		HomePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		gvSignInPage.enterLoginID(Constants.voipTwoId).clickNextButton().enterPassword(password).clickNextButton();
		//Utils.uBase.switchToOldWindow();
		//Utils.uBase.refresh();
		/* Anonymous call is placed after call button is hit */
		callsPage.verifyAnonymousCallIsPlaced();
	}

	/* Verify that call status is displayed after placing a call */
	public void voipCallUiCallStatus(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu();

		/*
		 * Procedure: 1. Place a VOIP call to any number 2. Check for call status
		 */
		hmPage.clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumAndMakeAcall();
		callsPage.allowNotification();

		/*
		 * Verification: 1. VOIP call UI appears immediately after call button is hit
		 */
		callsPage.verifyUiAppearsImmediatelyCallButtonHits();

		/* 2. It shows status:calling when call is being connected */
		callsPage.verifyStatusCallingIsDiaplyed();

		/* 3. It shows ripples and time duration when call is in progress */
		callsPage.verifyTimeDurationWhenCallIsInProgress();

		/* 4. It shows status:Call ended.total duration when call is ended" */
		callsPage.verifyStatusCallEndedTotalDurationIsDiaplyed();
	}

	/* Verify VOIP call UI End Button */
	public void voipCallUiEndButton(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu();

		/*
		 * Procedure: 1. Place a VOIP call to any number 2. Check for action on End
		 * button
		 */
		hmPage.clickTab("Calls");
		callsPage.EnteraNameOrNum().enterVoip2PhoneNumAndMakeAcall().clickOnCallEndBtn();

		/*
		 * Verification: Clicking on End button hangs up the call
		 */
		callsPage.verifyClickedOnEndButtonHangsUpcall();
	}

	public void callInitiateVoipCall(String email, String password, String data) throws Exception {

        /* Generating voiceMail */
        //ReceiveCallAndMessages.makeCall(Constants.unellafrey);

        /* Launching google voice application */
        Utils.uBase.launchWebApplication();

        /* Initiating the java page into object using PageFactory */
        GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
        HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
        CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
        MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
        VoicemailPage vmp = PageFactory.initElements(Utils.uBase.webDriver, VoicemailPage.class);
        SearchPage searchPage = PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
        GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
        
         
        /*
        * Login to Application and selecting the home button
        */
        gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
        GAPage.receiveMultipleMessages(Constants.voipTwoId,Constants.pwd2,data,2);
        Utils.uBase.switchToNewWindow();

        //GAPage.receiveMultipleVoicemails(Constants.voipTwoId,Constants.pwd2,data,2);
               callsPage.EnteraNameOrNum().enterNumAndMakeAcall(data);
               Thread.sleep(30000);
               callsPage.clickOnCallEndBtn();
               
               Thread.sleep(3000);

               callsPage.EnteraNameOrNum().enterNumAndMakeAcall(data).clickOnCallEndBtn();
               Utils.uBase.switchToOldWindow();
               Utils.uBase.refresh();
               
        
        
        hmPage.clickMainMenu();

        
        /* Procedure: 1. Login with GV credentials 2. Click on Callstab 3. Click on any
          call item 4. Click on Call button*/
         
        
          hmPage.clickTab("Calls");
          callsPage.selectFirstContactFromCallsList().clickOnCallButton();
         
         
        // Verification: 1.VOIP call is placed
         
          callsPage.verifyAbleToMakeCall().clickOnCallEndBtn();
         
         
          /*Procedure: 1. Login with GV credentials 2. Click on Message tab 3. Click on
          any call item 4. Click on Call button*/
         
          hmPage.clickMessages(); msgPage.clickFirstMessage().clickOnCallButton();
         
         
          //Verification: 1.VOIP call is placed
          Thread.sleep(2000);
         
          msgPage.verifyAbleToMakeCall().clickOnCallEndBtn();
         
         
        /* Procedure: 1. Login with GV credentials 2. Click on voice tab 3. Click on any
          call item 4. Click on Call button*/
         
          hmPage.clickTab(Constants.VoiceMail);
          vmp.clickfirstVoiceInList().clickOnCallButton();
         
         
        // Verification: 1.VOIP call is placed
         
          vmp.verifyAbleToMakeCall(); msgPage.clickOnCallEndBtn();
         
        /*
        * Procedure: 1. Search empty text 2. All the saved contacts are displayed with
        * Neighborhood message button and call button 3. Click on Call button
        */
         
        // searchPage.clickOnSearchBar().selectFromSearchSuggestionList().clickCallButton();
        searchPage.clickOnSearchBar().selectFromSearchSuggestionList().clickCallButton();

        /*
        * Verification: 1. VOIP call is placed
        */
        searchPage.verifyAbleToMakeCall().clickOnCallEndBtn();

        /*
        * Procedure: 1. Select any searched contact 2. Contact details page is opened
        * 3. Click on Call button
        */
        searchPage.clickOnSearchBar().sendDataInSearchBar(Constants.phoneNo).pressEnter().clearTextInSearchField()
                     .selectFromSearchSuggestionList().clickCallButton();

        /*
        * Verification: 1. VOIP call is placed"
        */
        searchPage.verifyAbleToMakeCall().clickOnCallEndBtn();
 }


	/* Verify VOIP call UI End Button */
	public void callQualityPromptGood(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu();

		/*
		 * Procedure: 1. Make a VOIP call 2. Receiver accepts the call,call is
		 * established 3. End the call after media 4. Call quality prompt is displayed
		 */
		hmPage.clickTab(Constants.Calls);
		callsPage.EnteraNameOrNum().enterPhoneNumAndMakeAcall();
		// enterVoip1PhoneNumAndMakeAcall();

		/*
		 * Verification 1. Call quality prompt is displayed when a. The call is
		 * established and b. The receiver does not picks up the call
		 */
		hmPage.clickOnNotificationAllowBtn();
		Thread.sleep(5000);
		callsPage.clickOnCallEndBtn();
		callsPage.verifyCallQualityPromt();

		/*
		 * 2. There is the following text How was the call quality? GOOD and BAD
		 */
		callsPage.verifyGoodAndBadTextOnQualityPromt();

		/* 3. When user clicks on GOOD the call quality prompt hides right away */
		callsPage.clickOnGoodOptionFromQualityPromt().verifyCallQualityPromptHidesOrNot();

		/* 4. Call quality prompt window is closed when user clicks on 'X' button" */
		callsPage.enterPhoneNumAndMakeAcallWithoutAllow().clickOnCallEndBtn();
		callsPage.clickOnCloseBtnFromQualityPromt().verifyCallQualityPromptHidesOrNot();
	}

	/* Call quality prompt.BAD */
	public void callQualityPromptBad(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu();

		/*
		 * "Procedure 1. Make a VOIP call 2. Receiver accepts the call,call is
		 * established 3. End the call after media 4. Call quality prompt is displayed
		 */
		hmPage.clickTab(Constants.Calls);
		callsPage.EnteraNameOrNum().enterPhoneNumAndMakeAcall();
		Thread.sleep(2000);
		callsPage.clickOnCallEndBtn();

		/*
		 * Verification: 1. When the user clicks on BAD, the following text is displayed
		 * with the options What went wrong? No ringing Call never connected Call
		 * dropped in the middle Echo Garbled or unclear audio Other issues
		 */
		callsPage.verifyCallQualityPromt().clickOnBadOptionFromQualityPromt().verifyOptionsWhatWentWrong();

		/*
		 * 2. Select any one of the above options and click SUBMIT. The call quality
		 * prompt hides right away
		 */
		callsPage.clickOnEchoCheckBoxFromWhatWentWrongWindow().clickOnSubmitBtnFromWentWrongWindow()
				.verifyallQualityPromptHidesRightAwayOrNot();

		/*
		 * 3. When the user selects the option 'other issues' and clicks SUBMIT button,
		 * it redirects to send feedback window with 'CANCEL' and 'SEND' buttons
		 */
		callsPage.enterPhoneNumAndMakeAcallWithoutAllow().clickOnCallEndBtn().verifyCallQualityPromt()
				.clickOnBadOptionFromQualityPromt();
		callsPage.clickOnOtherOptionWhatWentWrongWindow().clickOnSubmitBtnFromWentWrongWindow()
				.verifyRedirectsToSendFeedbackWindowWith();

		/* 4. When CANCEL button is hit, the send feedback window hides right away */
		callsPage.clickOnCancelBtnFromFeedbackWindow().verifySendFeedbackWindowHidesRightAwayorNot();

		/*
		 * 5. When SEND button is hit without any description, it throws an error
		 * message 'A description is required'
		 */
		callsPage.enterPhoneNumAndMakeAcall().clickOnCallEndBtn().verifyCallQualityPromt()
				.clickOnBadOptionFromQualityPromt();
		callsPage.clickOnOtherOptionWhatWentWrongWindow().clickOnSubmitBtnFromWentWrongWindow()
				.clickOnSendBtnFromFeedbackWindow().verifyErrorMessageDescriptionIsRequired();

		/*
		 * 6. When SEND button is hit after giving the description, it shows status
		 * 'sending feedback' and after that a toast message 'Thank you for the
		 * feedback' is displayed"
		 */
		Utils.uBase.refresh();
		callsPage.enterPhoneNumAndMakeAcall().clickOnCallEndBtn().verifyCallQualityPromt()
		.clickOnBadOptionFromQualityPromt();
callsPage.clickOnOtherOptionWhatWentWrongWindow().clickOnSubmitBtnFromWentWrongWindow();
		callsPage.enterDiscriptionOnFeedBackWindow().clickOnSendBtnFromFeedbackWindow().verifyToastMessage();
	}

	/* Caller does not give microphone permission */
	public void callerDoesnotGiveMicrophonePermission(String email, String password, String data) throws Exception {

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
		 * Procedure: 1. Goto browser settings 2. Disable microphone by selecting Block
		 * option 3.Make a VOIP call
		 */
		// callsPage.browserSettings().microPhoneSettings().microPhoneToogleOff().navigateToGoogleVoiceApp();
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumAndMakeAcallWithoutAllow();
		hmPage.clickOnNotificationBlockBtn();
		/*
		 * verify that, 1. It shows an error message "Microphone is turned off"
		 */
		callsPage.verifyMicrophoneIsTurnedOff();

		/*
		 * 2. It also displays a text ""To make a call on Google Voice, you need to turn
		 * on your microphone"" and details link"
		 */
		callsPage.verifyTurnOnYourMicrophone();
	}

	/* Caller gives microphone permission */
	public void callerGivesMicrophonePermission(String email, String password, String data) throws Exception {

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
		 * "Procedure: 1. Goto browser settings 2. Enable microphone by selecting Allow
		 * option 3. Make a VOIP call
		 */
		callsPage.browserSettings().microPhoneSettings().microPhoneToogleOn().navigateToGoogleVoiceApp();
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumAndMakeAcall();
		hmPage.clickOnNotificationAllowBtn();
		/*
		 * verify that, 1. VOIP call is placed"
		 */
		callsPage.verifyAbleToMakeCall();
	}
	public void voipAnonymousCallerIncomingCallAnonymousCallerUIPageButtons(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		HomePageWeb HomePageWeb= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		GAPage.removeItemsFromSpam();
		Utils.uBase.clickOnNotificationAllowBtn();
		HomePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		gvSignInPage.enterLoginID(Constants.voipOneId).clickNextButton().enterPassword(Constants.pwd2).clickNextButton();
		for(int i=0;i<1;i++) {
		callsPage.EnteraNameOrNum().enterNumAndMakeAcall(data);
		Thread.sleep(5000);
		Utils.uBase.switchToOldWindow();
		callsPage.verifyCallingStatus();
		
		callsPage.clickOnCallEndBtn();
		}
		    Utils.uBase.refresh();
		    callsPage.verifyIncallContact("Unknown");
	}
}
