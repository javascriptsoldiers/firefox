package automationBed_Google.pom.gv;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

import automationBed_Google.pom.gv.GVSignInPage;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class HambergerMenuPage
{
	private static final String Voice = null;
	//Locators
	@FindBy(xpath="//*[contains(@aria-label,'Main menu')]")
	WebElement menuIcn;
	@FindBy(xpath="//*[contains(@id,'SETTINGS')]")
	WebElement settingsIcn;
	@FindBy(xpath="//*[contains(@aria-label,'Calls')]/div[contains(@class,'flex md')]")
	WebElement callsTab;
	@FindBy(xpath="//*[contains(@aria-label,'Messages')]/div[contains(@class,'flex md')]")
	WebElement messagesTab;
	@FindBy(xpath="//*[contains(@aria-label,'Voicemail')]/div[contains(@class,'flex md')]")
	WebElement voicemailTab;
	@FindBy(xpath="//*[contains(@aria-label,'Legacy Google Voice')]") 
	WebElement LegacyGoogleVoiceTab;
	@FindBy(xpath="//*[contains(@class,'md-subhead')][text()='Payments']")
	WebElement settingsPaymentsTab;
	@FindBy(xpath="//*[contains(@class,'md-subhead')][text()='Accessibility']")
	WebElement settingsAccessibilityTab;
	@FindBy(xpath="//*[contains(@aria-label,'Mark all as read')]")
	WebElement Markallasreadtab;
	@FindBy(xpath="//*[contains(@ng-repeat,'phoneNumber')]")
	List<WebElement> archivedAvatarsList;   
	@FindBy(xpath="(//*[contains(@class,'mat-list-base mat-nav-list gmat-nav-list gmat-nav-list-reverse')])[3]")
	WebElement miniNavBtns;
	@FindBy(xpath="//*[@id=\"gvPageRoot\"]/div[2]/div[2]/gv-side-nav/div/div/gmat-nav-list/a[2]/div")
	WebElement msgMiniNavgnBtn;
	@FindBy(xpath="//*[@id=\"gvPageRoot\"]/div[2]/div[2]/gv-side-nav/div/div/gmat-nav-list/a[3]/div")
	WebElement voicemailMiniNavgnBtn;
	@FindBy(xpath="(//*[contains(@aria-label,'Calls')]//mat-icon[contains(@class,'ItemIcon mat-icon notranslate mat-icon-no-color')])[2]")
	WebElement miniCallIcon;
	@FindBy(xpath="(//gv-side-nav[contains(@class,'hide-xs')]//mat-icon[contains(@class,'ItemIcon mat-icon notranslate mat-icon-no-color')])[2]")
	WebElement miniMsgIcon;
	@FindBy(xpath="(//gv-side-nav[contains(@class,'hide-xs')]//mat-icon[contains(@class,'ItemIcon mat-icon notranslate mat-icon-no-color')])[3]")
	WebElement miniVoiceMailIcon;
	@FindBy(xpath="(//gv-side-nav[contains(@class,'hide-xs')]//mat-icon[contains(@class,'ItemIcon mat-icon notranslate mat-icon-no-color')])[4]")
	WebElement miniArchiveIcon;
	@FindBy(xpath="(//gv-side-nav[contains(@class,'hide-xs')]//mat-icon[contains(@class,'ItemIcon mat-icon notranslate mat-icon-no-color')])[5]")
	WebElement miniSpamIcon;
	@FindBy(xpath="//*[@class='YYoZ8c-ItvKz']")
	WebElement pannelCalls;
	@FindBy(xpath="//*[@class='aqnZjd-HSrbLb']")
	WebElement pannelMiddlePosition;
	

	int lstBeforeArchive;
	int lstAfterArchive;

	/*Click on home Page menu*/
	public HambergerMenuPage clickMainMenu() throws Exception
	{
		try
		{
			/*Thread.sleep(7000); 
			  Utils.uBase.checkPageReady();
			  Utils.uBase.clickByImage("MainMenuImg"); */
			Utils.uBase.waitForElementToBeClickable(menuIcn);
			Utils.uBase.clickWebelement(menuIcn);
			AdvanceReporting.addLogs("pass", "Clicked on Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	//To click on settings Icon in main page
	public HambergerMenuPage clickSettings() throws Exception {
		try	{
			Thread.sleep(5000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("SettingsTab");
			AdvanceReporting.addLogs("pass", "Navigated to Settings Page");
			AdvanceReporting.addLogs("pass", "Setting page displayed","SettingsPage");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HambergerMenuPage verifyCallPanelInRight() throws Exception {
		try	{
			Thread.sleep(5000);
			Point home=pannelMiddlePosition.getLocation();
			Point p=pannelCalls.getLocation();
			int xCord_Calls=p.getX();
			int xCord_Middle=home.getX();
			if(xCord_Middle<xCord_Calls) {
				AdvanceReporting.addLogs("pass", "Verified that keyBoard pannel is right side to the page");
				AdvanceReporting.addLogs("pass", "Verified that keyBoard pannel is right side to the page","KeyboardPage");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public HambergerMenuPage clickCalls() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(callsTab);
			Utils.uBase.clickWebelement(callsTab);
			AdvanceReporting.addLogs("pass", "Clicked on Call tab in Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
		}

		return this;
	}
	public HambergerMenuPage clickMessages() throws Exception
	{
		try
		{
			Utils.uBase.clickByImage("messageTabs");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Clicked on Messages tab in Hamberger Menu");
			Thread.sleep(2000);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HambergerMenuPage clickVoicemail() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(voicemailTab);
			Utils.uBase.clickWebelement(voicemailTab);
			AdvanceReporting.addLogs("pass", "Clicked on Voice Mail tab in Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/*
	 * public HambergerMenuPage clickLegacyGoogleVoice() throws Exception { try { //
	 * Utils.uBase.waitForElementToBeClickable(LegacyGoogleVoiceTab);
	 * Utils.uBase.scrolltoElement(LegacyGoogleVoiceTab);
	 * Utils.uBase.clickWebelement(LegacyGoogleVoiceTab);
	 * AdvanceReporting.addLogs("pass",
	 * "Clicked on 'Legacy Google Voice' in Hamberger Menu"); } catch (Exception e)
	 * { AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
	 * e.printStackTrace(); Assert.fail(); }
	 * 
	 * return this; }
	 */

	//clicking on legacy google voice option in main menu
	public HambergerMenuPage clickLegacyGoogleVoice() 
	{
		try
		{
			Utils.uBase.clickByImage("LegacyGoogleVoiceTab");
			AdvanceReporting.addLogs("pass", "Clicked on 'Legacy Google Voice' in Hamberger Menu");
			Thread.sleep(8000);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//To verify control switched to legacywindow
	public HambergerMenuPage verifyLegacyWindow() {
		try {
			Thread.sleep(15000);
			if(Utils.uBase.imageCompare("legacyWindowVerification")) {
				Thread.sleep(4000);
				AdvanceReporting.addLogs("pass","Clicked on 'Legacy Google Voice' in Hamberger Menu", "legacy window");
			}
			else {
				AdvanceReporting.addLogs("fail","not clicked on 'Legacy Google Voice' in Hamberger Menu", "legacy window not opened");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;

	}

	public HambergerMenuPage clickMarkallasread() throws Exception
	{
		try
		{
			//			Utils.uBase.waitForElementToBeClickable(Markallasreadtab);
			Utils.uBase.scrolltoElement(Markallasreadtab);
			Utils.uBase.clickWebelement(Markallasreadtab);
			AdvanceReporting.addLogs("pass", "Clicked on 'Mark all as read' in Hamberger Menu");			
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	public HambergerMenuPage clickSettingsPayments() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(settingsPaymentsTab);
			Utils.uBase.clickWebelement(settingsPaymentsTab);
			AdvanceReporting.addLogs("pass", "Clicked on Payments Sub tab in Settings in Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HambergerMenuPage clickSettingsAccessibility() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(settingsAccessibilityTab);
			Utils.uBase.clickWebelement(settingsAccessibilityTab);
			AdvanceReporting.addLogs("pass", "Clicked on AccessibilitySub tab in Settings in Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/*Clicks on a tab

	 @param: Pass the name of the tab as tabName, that should be clicked in Hamburger menu
	 Images folder 'src\test\resources\Images' should have the name of the tab that should be clicked. First letter should be capital.*/

	public HambergerMenuPage clickTab(String tabName) throws Exception
	{
		try
		{		
			Thread.sleep(2000);
			Utils.uBase.clickByImage(tabName);
			AdvanceReporting.addLogs("pass", "Clicked on "+tabName+" tab in Hamberger Menu");
			AdvanceReporting.addLogs("pass", "Clicked on "+tabName+" tab in Hamberger Menu",tabName+"TabClicked");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", tabName + "is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public HambergerMenuPage clickVoiceMail() throws Exception
	{
		try
		{ 
			Thread.sleep(1000);
			Utils.uBase.clickByImage("VoiceMailTab");
			AdvanceReporting.addLogs("Pass", "VoiceMailTab is clicked");	
			Thread.sleep(1000);
			AdvanceReporting.addLogs("Pass", "VoiceMailTab folder", "VoiceMailTab");

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Voicemail is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public HambergerMenuPage clickArchive() throws Exception
	{
		try
		{ 
			Thread.sleep(2000);
			Utils.uBase.clickByImage("archiveImg");
			AdvanceReporting.addLogs("Pass", "Archive folder is displayed");
			AdvanceReporting.addLogs("Pass", "Archive folder", "Archive");
			Thread.sleep(6000);


		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Archive is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public HambergerMenuPage calculateTotalAvatarsBeforeArchivingInArchivedpage() throws Exception {

		Thread.sleep(1000);

		//AdvanceReporting.addLogs("pass", "Able to click on Archive Icon in Home Page");

		//AdvanceReporting.addLogs("pass","Able to click on Archive Icon in Home page","Able to click on Archive Icon in Home Page");

		lstBeforeArchive = archivedAvatarsList.size();

		System.out.println("totalNumberOfElementsInArchivedPageBeforeArchiving ="+ lstBeforeArchive);

		return this;

	}





	public HambergerMenuPage calculateTotalAvatarsAfterArchivingInArchivedpage() throws Exception {

		//Utils.uBase.clickByImage("Archives");

		Thread.sleep(5000);

		//AdvanceReporting.addLogs("pass", "Able to click on Archive Icon");

		//AdvanceReporting.addLogs("pass","Able to click on Archive Icon","Able to click on Archive Icon");

		lstAfterArchive = archivedAvatarsList.size();

		System.out.println("totalNumberOfElementsInArchivedPageAfterArchiving ="+ lstAfterArchive);

		if( (lstAfterArchive - lstBeforeArchive) == 2) {

			AdvanceReporting.addLogs("pass", "All the archived voicemails have reached the Archive Page");

			AdvanceReporting.addLogs("pass","All the archived voicemails have reached the Archive Page","ArchivedMsg");

		}

		else {

			AdvanceReporting.addLogs("fail", "All the archived voicemails have not reached the Archive Page");

			AdvanceReporting.addLogs("fail","All the archived voicemails have not reached the Archive Page","FailedMsg");

		}

		return this;

	}

	// Verify navigational menu
	public HambergerMenuPage verifyNavigationalMenu() {
		try {		
			Thread.sleep(6000);
			Assert.assertTrue(Utils.uBase.imageCompare("MainNavigationMenu2"), "Navigational Menu displayed");
			AdvanceReporting.addLogs("pass", "Verified that Main Navigation Menu is displayed");
			AdvanceReporting.addLogs("pass", "Main Navigation Menu is displayed","MainNavigationMenu");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Navigational Menu not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Verify Navigational menu is hidden
	public HambergerMenuPage verifyHidingNavigationalMenu () {
		try {		
			Thread.sleep(3000);
			Utils.uBase.checkPageReady();
			if(Utils.uBase.imageCompare("MainNavigationMenu2")) {
				AdvanceReporting.addLogs("fail", "Main Navigation Menu not hiding");
				AdvanceReporting.addLogs("info", "Main Navigation Menu not hiding");
			} else {
				AdvanceReporting.addLogs("info", "Verified that main Navigation Menu is hiding");
				AdvanceReporting.addLogs("pass", "Main Navigation Menu is hiding", "nonavigationmenu");
			}
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Main Navigation Menu is not hiding");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;
	}

	public HambergerMenuPage clickMiniCallBtn() 
	{
		try
		{
			Thread.sleep(5000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete"))
				Utils.uBase.clickByImage("MiniCallButton");
		} 

		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}


	public HambergerMenuPage clickMiniMessageBtn() 
	{
		try
		{
			Thread.sleep(5000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete"))
				Utils.uBase.clickByImage("MiniMessageButton");
		} 

		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	public HambergerMenuPage clickMiniVoiceMailBtn () 
	{
		try
		{
			Thread.sleep(5000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete"))
				Utils.uBase.clickByImage("MiniVoioceMailButton");
		} 

		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	public HambergerMenuPage clickMiniArchiveBtn () 
	{
		try
		{
			Thread.sleep(5000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete"))
				Utils.uBase.clickByImage("MiniArchiveButton");
		} 

		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	public HambergerMenuPage clickMiniSpamBtn() 
	{
		try
		{
			Thread.sleep(5000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete"))
				Utils.uBase.clickByImage("MiniSpamButton");
		} 

		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}
	public HambergerMenuPage clickOnSpamTab()
	{

		try
		{
			Thread.sleep(6000);
			Utils.uBase.clickByImage("ClickOnSpamImg1");
			AdvanceReporting.addLogs("pass", "Clicked on Spam Img Tab");
			AdvanceReporting.addLogs("pass", "Clicked on Spam Img Tab","SpamImageTab");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("pass", "Not clicked Spam Tab");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	/* Clicked on allow button from google chrome notification */
	public HambergerMenuPage clickOnNotificationAllowBtn()
	{
		try
		{
			Thread.sleep(10000);
			for(int i=0; i<=5; i++) {
				if(Utils.uBase.imageCompare("AllowButtonImg")) {
					Thread.sleep(1000);
					Utils.uBase.clickByImage("AllowButtonImg");
					AdvanceReporting.addLogs("pass", "Click on allow button from notification alert");}}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public HambergerMenuPage verifyRedirectedtoSettingPage() {
		try {
			Thread.sleep(15000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("SettingPage"), "Setting Page not displayed");
			AdvanceReporting.addLogs("pass", "Setting page displayed");
			AdvanceReporting.addLogs("pass", "Setting page displayed", "Settingpage");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Setting page not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	public HambergerMenuPage verifyMiniNavigationMenu() {
		try {
			Utils.uBase.checkPageReady();
			Thread.sleep(4000);
			Assert.assertTrue(Utils.uBase.imageCompare("miniNavBtns"), "Mini navigational buttons are not present.");
			AdvanceReporting.addLogs("pass", "All the mini navigational buttons are present and visible.");
			AdvanceReporting.addLogs("pass", "Mini navigational buttons are present", "Mini navigational buttons are present");
			//			Utils.uBase.takeScreenshotOfWebelement(miniNavBtns, "minNavBtns");
			//			 AdvanceReporting.addLogs("pass", "Screenshot taken");
		} 
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public HambergerMenuPage clickAddAccount() {
		try {
			Thread.sleep(3000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("addAccount");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Add Account is clicked");
			AdvanceReporting.addLogs("pass", "Add Account is clicked", "AccountName");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Account Label is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HambergerMenuPage verifyClickedMiniBtnHghlghtd() {
		try {
			Thread.sleep(15000);
			if(Utils.uBase.imageCompare("MiniMenuButtons")==true)
			{
				AdvanceReporting.addLogs("pass", "Mini navigation menu is displayed");
				AdvanceReporting.addLogs("pass", "Mini navigation menu is displayed", "Mini navigation menu is displayed");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HambergerMenuPage loginToOtherAccount(String email, String password){
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			//Utils.uBase.switchToNewWindow();
			GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
			gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
			AdvanceReporting.addLogs("pass", "Account is clicked");
			AdvanceReporting.addLogs("pass", "Account is clicked", "AccountName");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Account Label is not clicked");
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}	
	public HambergerMenuPage clickAccountLabel() {
		try {
			Thread.sleep(4000);
			//Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("voipAcc1");
			AdvanceReporting.addLogs("pass", "Account is clicked");
			AdvanceReporting.addLogs("pass", "Account is clicked", "AccountName");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Account Label is not clicked");
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Switch to Old window
	public HambergerMenuPage moveBackToOldWindow() {

		try {

			Thread.sleep(2000);
			Utils.uBase.switchToOldWindow();
			AdvanceReporting.addLogs("Pass","Google Voice page is displayed");
			AdvanceReporting.addLogs("Pass","Google Voice Page is displayed", "GoogleVoicePage");


		} catch (Exception e)
		{
			AdvanceReporting.addLogs("Fail", "Google Voice page is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Click on Calls Tab */
	public HambergerMenuPage selectCallsTab()
	{
		try
		{
			Thread.sleep(1000);
			if(Utils.uBase.imageCompare("ClickOnCallsImg")){
				Thread.sleep(2000);
				Utils.uBase.clickByImage("ClickOnCallsImg");
				AdvanceReporting.addLogs("pass", "Calls Tab click");
				AdvanceReporting.addLogs("pass", "Calls Tab click","Callstab");
				Thread.sleep(1000);
			}else if(Utils.uBase.imageCompare("CallsTabImg")) {
				Thread.sleep(2000);
				Utils.uBase.clickByImage("CallsTabImg");
				AdvanceReporting.addLogs("pass", "Calls Tab click");
				AdvanceReporting.addLogs("pass", "Calls Tab click","Callstab");
			}else {
				AdvanceReporting.addLogs("fail", "Calls Tab not click");
				AdvanceReporting.addLogs("fail", "Calls Tab not  click","CallstabNotClick");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Calls Tab is not selectd");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//To select and verify highlight and tool tip of Mini navigational menu 
	public HambergerMenuPage verifyMiniNavigationBtnsAndToolTip(String imgUnselected, String imgToolTip, String imgSelected) {
		try {
			SoftAssert Assert=new SoftAssert();
			Thread.sleep(2000);
			Utils.uBase.hoverWebelement(Utils.uBase.webDriver.findElement(By.xpath("(//*[contains(@aria-label,'"+imgUnselected+"')]//mat-icon[contains(@class,'ItemIcon mat-icon notranslate mat-icon-no-color')])[2]"))); 
			//AdvanceReporting.addLogs("pass","Hovered on call icon");
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare(imgToolTip),""+imgToolTip+" is not present");
			//Thread.sleep(2000); 
			//Utils.uBase.hoverOnImage(imgUnselected);
			AdvanceReporting.addLogs("pass","Hovered on "+imgUnselected+" navigational menu");
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare(imgToolTip),""+imgToolTip+" is not present");
			AdvanceReporting.addLogs("pass","Verified that "+imgToolTip+" is present for mini navigational menu");
			AdvanceReporting.addLogs("pass", "Tooltip for buttons is present","Tooltip for buttons is present");
			Thread.sleep(2000);
			Utils.uBase.clickByImage(imgUnselected);
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare(imgSelected),""+imgSelected+" navigation menu is not present");
			AdvanceReporting.addLogs("pass","Verified that "+imgSelected+" navigational menu is highlighted");
			AdvanceReporting.addLogs("pass", "Mini menu is selected and highlighted","Mini menu is selected and highlighted");
		} 
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Clicked on block button from google chrome notification */
	public HambergerMenuPage clickOnNotificationBlockBtn()
	{
		try
		{
			Thread.sleep(10000);
			for(int i=0; i<=5; i++) {
				if(Utils.uBase.imageCompare("blockBtnImg")) {
					Thread.sleep(1000);
					Utils.uBase.clickByImage("blockBtnImg");
					AdvanceReporting.addLogs("pass", "Click on block button from notification alert");}}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
	public HambergerMenuPage clickOnHelpIcon()
	{
		try
		{
			Thread.sleep(6000);
			Utils.uBase.clickByImage("helpIcon");
			AdvanceReporting.addLogs("pass", "Clicked on help icon");
			AdvanceReporting.addLogs("pass", "Clicked on help icon","Clicked on help icon");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("pass", "Not clicked on help icon");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}
	
	public HambergerMenuPage verifyHelpPopup() {
		try {
			Thread.sleep(15000);
			if(Utils.uBase.imageCompare("verifyHelpPopup")==true)
			{
				AdvanceReporting.addLogs("pass", "Verified that help popup is displayed");
				AdvanceReporting.addLogs("pass", "Verified that help popup is displayed", "Verified that help popup is displayed");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
	public HambergerMenuPage verifyLegacyVoiceOptn() {
		try {
			Thread.sleep(15000);
			if(Utils.uBase.imageCompare("LegacyGoogleVoiceTab")==false)
			{
				AdvanceReporting.addLogs("pass", "Verified that legacy page is not present");
				AdvanceReporting.addLogs("pass", "Verified that legacy page is not present", "Verified that legacy page is not present");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
	
}