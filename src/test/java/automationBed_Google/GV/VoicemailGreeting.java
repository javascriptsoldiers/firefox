package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

public class VoicemailGreeting extends SuiteBase {

	//Manage All greeting page items
	public void manageAllGreetingPageItems(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application

		Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1.Login 2. Navigate to Moya Settings page. 3. Scroll to voicemail
		 * section 4. Click-on Manage All Greetings link
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickSettings();
		// 1.Pop-up page 'All Greeting' will display with list of Active and All previously recorded greetings
		settPage.clickVoiceMailInSettings().clickOnManageGreeting().verifyAllGreetingsPopUpDisplayed().verifyActiveSectionInAllGreeting().verifyOthersSectionInAllGreeting().clearGreetingsInOtherSection();
		/*
		 * 2.Verify with has 2 sections: a)Active: Greeting which is currently
		 * active,has play button,name and duration . b)Other:Previously recorded
		 * greetings display's with play button name and duration.
		 */			
		settPage.verifyActiveGreetingName().verifyActiveGreetingDuriation().verifyActiveGreetingPlayOptn();
		settPage.verifyGreetingNameAndDuration().verifyGreetingPlayOptnInOtherSection();
		// 3.Verify 'Google voice default' greeting is dislpayed in the list.
		settPage.verifyGoogleVoiceDefaultIsPresent().verifyGoogleVoiceDefault();
		/*
		 * 4.Verify Greeting has minimum count of 1 which is 'Google vocie default' to
		 * maxium of 9 greetings user can add. 5.Verify upon reaching maxium recordings
		 * Alert message is displayed 'You can only save 10 greetings' and Record a
		 * greeting button is disabled. 6.To Close the pop-up page,click on 'X' on top
		 * left hand side or hit ESC from keypad.
		 */
		settPage.closePopUp().totalGreetingsInList().clearGreetingsInOtherSection();
	}

	/*Verify able to Unselect multiple calls thread*/

	public void callThreadSelectUnselect(String email, String password, String data) throws Exception 
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*Pre-Condition: 
		 * Should have calls threads.*/

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu();

		/* Procedure: 
		 * Procedure: 
		 * 1. Click on calls tab 
		 * 2. Click on one or more than one Avatars of call items. 
		 * 3. Click "X" icon and unselect the items*/
		hmPage.clickTab("Calls");

		/* 1.Verify that able to select multiple threads of call items. */
		callPage.verifyIfAvatarsAreSelected();

		/* 2.Verify that able to unselect all the selected items.*/
		callPage.verifyAvatarsAreUnselect();		
	}

}
