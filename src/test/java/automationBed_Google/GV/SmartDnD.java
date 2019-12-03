package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CalendarSettingsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.KeyboardActionsPage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class SmartDnD extends SuiteBase {

	// To check the UI of Smart DND
	public void smartDndUi(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 Procedure:
		 		1. Login with GV corp account credentials 
		 		2. Navigate to Settings page
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*
		 Verification
		 		1. Observe that under the Section Heading Do Not Disturb the following toggles are present 
		 		a. Do Not disturb toggle 
		 		b. Follow working hours toggle
		 		c. Follow Out of office toggle */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmPage.clickSettings();
		stngpg.clickDoNotDisturb().verifyDoNotDisturbToogle().verifyFollowWorkingHoursToogle().verifyFollowOutOfOfficeWorkingHoursToogle();
	}

	//To verify the working of GV while contacting the user in OOO timings
	public void smartDndOutOfOffice(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/* Precondition:
				  1. Set the OOO settings in calendar */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		CalendarSettingsPage calendarStngPage = PageFactory.initElements(Utils.uBase.webDriver, CalendarSettingsPage.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
			/* Procedure:
  					1. Login with GV corp account credentials
  					2. Navigate to settings page
  					3. Turn the Follow Out of office toggle on
  					4. Navigate to calls/messagesw/voicemail pages */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmPage.clickSettings();
		/* Verification:
				  1. Observe that extended DonotDisturb banner is present at the top of every page
				  2. Donot disturb banner contains the text 'Donot disturb is on. You are out of office' text 
				  3. Banner also contains 'ENDNOW' and 'SETTINGS' buttons
				  4. Verify that Incoming calls to the GV are redirected to Vociemail and messages are not forwarded to the linked numbers */
		stngpg.clickDoNotDisturb().clickCalendarSettings();
		Utils.uBase.switchToNewWindow();
		Utils.uBase.checkPageReady();
		calendarStngPage.clickWorkingHours().enableWorkingHours().selectSunWorkDay().clickWorkHoursStart().selectWorkStartTime().clickWorkHoursEnd().selectWorkEndTime();
		String W[] = Constants.selectCalendarWorkDays.split("\\|");
		for(int i=0;i<W.length;i++)
		{
			calendarStngPage.selectWorkingDays(W[i]);
		}
		calendarStngPage.selectCopyToAll();
		Thread.sleep(2000);
		Utils.uBase.refresh();
		Utils.uBase.checkPageReady();
		hmweb.switchingToZerothWindow();
		stngpg.selectFollowWorkingHoursToogle().selectFollowOfOfficeToogle();
		Utils.uBase.refresh();
		Utils.uBase.checkPageReady();
		stngpg.dndIsOnText().verifyEndNowDND().verifySettingsDND();
		/* Removing the pre-conditions and setting calendar settings to default*/
		stngpg.selectFollowWorkingHoursToogle().selectFollowOfOfficeToogle();
		Thread.sleep(2000);
		hmweb.switchingToFirstWindow();
		calendarStngPage.clickWorkingHours();
		String U[] = Constants.unSelectCalendarWorkDays.split("\\|");
		for(int j=0;j<U.length;j++)
		{
			calendarStngPage.unSelectWorkingDays(U[j]);
		}
		calendarStngPage.disableWorkingHours();
		Thread.sleep(5000);
		Utils.uBase.refresh();
		Utils.uBase.checkPageReady();		
	}	
}

