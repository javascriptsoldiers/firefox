package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.KeyboardActionsPage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class KeyboardShortcuts extends SuiteBase {

	/*verifyThatKeyboardShortcutsUnderNavigationIsWorkingAsExpected*/
	public void keyboardShortcutsNavigation(String email, String password, String data) throws Exception
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/*Pre-Condition:
		1. Login with GV number.
		2. Mod of keyboardShortcuts should be added to voice daily link.*/
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		KeyboardActionsPage keyActionPage = PageFactory.initElements(Utils.uBase.webDriver, KeyboardActionsPage.class);

		/*Procedure:
		  	1. Login with GV credentials.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*2. Press Shift+'?' to Open keyboard shortcuts help screen.*/
		keyActionPage.shiftQstn();

		/*Verification:
			1. Verify that the help page contains subheading as "Navigation", "Thread List Actions", "Message List Actions", "Thread Actions", "General Actions", "Help" .
			keyActionPage.shiftQstn();
			2. Verify that by following the instructions mentioned there under "Navigation" subheading is working as expected.
			3. Verify that the instructions mentioned under Navigation subheading will be:
				"Go to the archives page	: g then a"
				"Go to the calls page: g then c"
				"Go to the messages page: g then m"
				"Go to the settings page: g then s"
				"Go to the voicemail page: g then v"
				"Search: /"*/
		keyActionPage.keyboardShortcutContents(data).verifyNavigationShortcuts();		
	}
	
	/*verifyThatKeyboardShortcutsUnderThreadListActionsIsWorkingAsExpected*/
	public void keyboardShortcutsThreadListActions(String email, String password, String data) throws Exception
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		KeyboardActionsPage keyActionPage = PageFactory.initElements(Utils.uBase.webDriver, KeyboardActionsPage.class);

		/*Procedure:
		1. Login with GV credentials.
		2. Press Shift+'?' to Open keyboard shortcuts help screen.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*Verification:
			1. Verify that the help page contains subheading as "Navigation", "Thread List Actions", "Message List Actions", "Thread Actions", "General Actions", "Help" .
			2. Verify that by following the instructions mentioned there under "Thread List Actions" subheading is working as expected.
			3. Verify that the instructions mentioned under List Actions subheading will be:
			"Next item in list: j or |"
			"Previous item in list: k or |"
			"Select/Unselect a thread: x"
			"Enter a thread: <Enter>"*/
		keyActionPage.shiftQstn().keyboardShortcutContents(data).verifyListActionsShortcuts();	
	}
	/*verifyThatKeyboardShortcutsUnderMessageListActionsIsWorkingAsExpected*/
	public void keyboardShortcutsMessageListActions(String email, String password, String data) throws Exception
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		KeyboardActionsPage keyActionPage = PageFactory.initElements(Utils.uBase.webDriver, KeyboardActionsPage.class);

		/*Procedure:
		1. Login with GV credentials.
		2. Press Shift+'?' to Open keyboard shortcuts help screen.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*Verification:
			1. Verify that the help page contains subheading as "Navigation", "Thread List Actions", "Message List Actions", "Thread Actions", "General Actions", "Help" .
			2. Verify that by following the instructions mentioned there under "Message List Actions" subheading is working as expected.
			3. Verify that the instructions mentioned under List Actions subheading will be:
			"Next item in list: |"
			"Previous item in list: |"
			"Select/Unselect a message: x or <space>"*/
		keyActionPage.shiftQstn().keyboardShortcutContents(data);		
	}
	/*verifyThatKeyboardShortcutsUnderThreadActionsIsWorkingAsExpected*/
	public void keyboardShortcutsThreadActions(String email, String password, String data) throws Exception
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		KeyboardActionsPage keyActionPage = PageFactory.initElements(Utils.uBase.webDriver, KeyboardActionsPage.class);
		GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		//GAPage.reciveMultipleMissCalls(Constants.voipPhoneNo, 1);
		/*Procedure:
		1. Login with GV credentials.
		2. Press Shift+'?' to Open keyboard shortcuts help screen.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, Constants.voipOneNo, 2);

		/*Verification:
			1. Verify that the help page contains subheading as "Navigation", "Thread List Actions", "Message List Actions", "Thread Actions", "General Actions", "Help" .
			2. Verify that by following the instructions mentioned there under "Thread Actions" subheading is working as expected.
			3. Verify that the instructions mentioned under Thread Actions subheading will be:
			"Archive a thread: e"
			"Mark thread as spam: !"
			"Delete thread: #"*/
		keyActionPage.shiftQstn().keyboardShortcutContents(data).verifyThreadActions();		
	}
	/*verifyThatKeyboardShortcutsUnderGeneralActionsIsWorkingAsExpected*/
	public void keyboardShortcutsGeneralActions(String email, String password, String data) throws Exception
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		KeyboardActionsPage keyActionPage = PageFactory.initElements(Utils.uBase.webDriver, KeyboardActionsPage.class);

		/*Procedure:
		1. Login with GV credentials.
		2. Press Shift+'?' to Open keyboard shortcuts help screen.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*Verification:
			1. Verify that the help page contains subheading as "Navigation", "Thread List Actions", "Message List Actions", "Thread Actions", "General Actions", "Help" .
			2. Verify that by following the instructions mentioned there under "General Actions" subheading is working as expected.
			3. Verify that the instructions mentioned under General Actions subheading will be:
			"Make a new call: c"
			"Send a new message: m"*/
		keyActionPage.shiftQstn().keyboardShortcutContents(data);		
	}
	/*verifyThatKeyboardShortcutsUnderHelpIsWorkingAsExpected*/
	public void keyboardShortcutsHelp(String email, String password, String data) throws Exception
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		KeyboardActionsPage keyActionPage = PageFactory.initElements(Utils.uBase.webDriver, KeyboardActionsPage.class);

		/*Procedure:
		1. Login with GV credentials.
		2. Press Shift+'?' to Open keyboard shortcuts help screen.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*Verification:
			1. Verify that the help page contains subheading as "Navigation", "Thread List Actions", "Message List Actions", "Thread Actions", "General Actions", "Help" .
			2. Verify that by following the instructions mentioned there under "Help" subheading is working as expected.
			3. Verify that the instructions mentioned under Help subheading will be:
			"Open keyboard shortcuts help screen: ?"
			"Close keyboard shortcuts help screen: <Esc>"*/
		keyActionPage.shiftQstn().keyboardShortcutContents(data).shiftQstn().verifyHelpShortcuts();		
	}

	/*Verify that by clicking "Close" button keyboard shortcuts help screen should close*/
	public void keyboardShortcutsClose(String email, String password, String data) throws Exception
	{
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		/*Procedure:
			1. Login with GV credentials.
			2. Press Shift+'?' to Open keyboard shortcuts help screen.*/
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		KeyboardActionsPage keyActionPage = PageFactory.initElements(Utils.uBase.webDriver, KeyboardActionsPage.class);

		/*Procedure:
		1. Login with GV credentials.
		2. Press Shift+'?' to Open keyboard shortcuts help screen.*/
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/*Verification:
			1. Verify that the help page contains subheading as "Navigation", "Thread List Actions", "Message List Actions", "Thread Actions", "General Actions", "Help" .
			2. Verify that, clicking on "Close" button should close the keyboard shortcut help screen.*/
		keyActionPage.shiftQstn().verifySubHeadingsInHelpPage().closeKeyboardActions();
	}
}