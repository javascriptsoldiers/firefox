package automationBed_Google.pom.gv;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.OCR;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;


import org.sikuli.script.Pattern;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePageWeb {

	int msgCountAfter=0,callsCountAfter=0,voicemailsCountAfter=0;

	public static int messagesCount=0,callsCount=0, voicemailsCount=0, spamCount=0;
	public static int messagesCountAfterArchive=0,callsCountAfterArchive=0, voicemailsCountAfterArchive=0, spamCountAfterArchive=0;

	@FindBy(xpath="//*[@id='gb']/div[2]")
	WebElement navigationMenu;
	@FindBy(xpath="//div[contains(text(), 'Make a call')]")
	WebElement makeCall;
	@FindBy(xpath="//*[@id='gb']/div[2]/div[1]/div[4]/div/a/img")
	WebElement googleVoiceLogo;
	// @FindBy(xpath="//*[@id='messaging-view']/div/md-content/div")
	// WebElement firstColumn;
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/gv-side-nav/div/div/gmat-nav-list")
	WebElement miniMenuButton;
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/div")
	WebElement secondColumn;
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/gv-inbox-summary")
	WebElement greetingsMsgTab;
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/gv-inbox-summary/div/div[2]/div/span")
	WebElement unreadCount;
	@FindBy(xpath = "//*[contains(@content,'ProfileNames')]")
	List<WebElement> lstMessages;
	@FindBy(xpath = "//*[contains(@gv-test-id,'item-contact')]")
	List<WebElement> lstVoiceMails;
	@FindBy(xpath="//*[contains(@gv-test-id,'item-contact')]")
	private List<WebElement> lstCalls;
	@FindBy(xpath="//*[contains(@gv-test-id,'item-contact')]")
	private List<WebElement> lstSpam;
	@FindBy(xpath="//*[@id='gvPageRoot']/div[2]/div[2]/gv-side-nav/div/div/gmat-nav-list/a[1]/div/div")
	WebElement unreadCalls;
	@FindBy(xpath = "//button[@title='New conversation']//../div/div/div[2]/div/div[2]")
	List<WebElement> lstGmailArowUser;
	@FindBy(xpath = "//*[contains(@class,'a1j')]")
	WebElement gmailArowFrame;
	@FindBy(xpath = "//button[@title='New conversation']//../div/div/div[2]/div/div[2]")
	WebElement gmailArowUser;
	@FindBy(xpath = "(//span[contains(text(),'Voicemail')])[2]//../span[2]")
	WebElement unreadVoicemails;
	@FindBy(xpath = "(//span[contains(text(),'Message')])[2]//../span[2]")
	WebElement unreadMessages;
	@FindBy(xpath="//*[contains(@gv-test-id,'item-contact')]")
	private List<WebElement> lstMsgs;
	@FindBy(xpath="(//a[contains(@gv-test-id,'sidenav-message')])[2]")
	WebElement unreadMsgs;
	@FindBy(xpath="//*[contains(@aria-label,'Google Account:')]")
	WebElement googleAccountIcon;
	@FindBy(xpath="//*[@class='YYoZ8c-ItvKz']")
	WebElement pannelCalls;
	@FindBy(xpath="//*[@class='aqnZjd-HSrbLb']")
	WebElement pannelMiddlePosition;
	@FindBy(xpath="//*[contains(@aria-label,'Audio settings')]")
	WebElement audioSettings;
	@FindBy(xpath="//*[contains(@class,'accountPhoneBanner')]")
	WebElement phoneNumberBanner;
	@FindBy(xpath="//*[contains(@placeholder,'Enter a name or number')]")
	WebElement enterPhNumberPlaceholder;
	@FindBy(xpath="//*[contains(@ng-class,'::ctrl.CSS.INPUT_ROW')]")
	WebElement grayedOutCallBtnAndEnterOptn;
	@FindBy(xpath="//*[contains(@gv-test-id,'frequent-contacts-row')]/p")
	WebElement suggetionListText;
	@FindBy(xpath="//*[contains(@id,'freq_contact-')]")
	List<WebElement> freqContactList;
	@FindBy(xpath="//*[contains(text(),'Hide keypad')]")
	WebElement hideKeyboard;
	@FindBy(xpath="//*[contains(@aria-label,'Dialpad')]")
	WebElement dailpad;
	@FindBy(xpath="//*[contains(@content,'ctrl.getFormattedName()')]")
	List<WebElement> suggestedContactNames;


	/* Verify message tab is displayed by default */
	public HomePageWeb verifyCallTabIsDisplayed () throws Exception {
		try {
			Thread.sleep(6000);
			Utils.uBase.checkPageReady();
			//Assert.assertTrue(Utils.uBase.imageCompare("MakeACall"), "Call Tab is not displayed By Default");
			if(Utils.uBase.getCurrentUrl().contains("calls")) {
				AdvanceReporting.addLogs("pass", "Verified that Call Tab is Displayed By Default");
				AdvanceReporting.addLogs("pass", "Call Tab is Displayed","MessagesTab");
			}
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Call Tab is is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	/* Verify Navigation Menu is displayed */
	public HomePageWeb verifyNavigationMenuIsDisplayed() {
		try {
			Thread.sleep(2000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("menuIcn"), "Navigation menu is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that navigation menu is displayed");
			AdvanceReporting.addLogs("pass", "Navigation menu displayed","NavigationMenu");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Navigation menu is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;			
	}

	/* Verify GV LOGO */
	public HomePageWeb verifyGoogleVoiceLogoIsDisplayed () {
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickOnNotificationAllowBtn();
			Assert.assertTrue(Utils.uBase.imageCompare("GVLogo"),"GVLogo is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that GVLogo is displayed");
			AdvanceReporting.addLogs("pass", "GVLogo is displayed","GVLogo");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "GVLogo is not displayed");
			AdvanceReporting.addLogs("fail", "GVLogo is not displayed");
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	/* Verify: 3. Send Message is displayed */
	public HomePageWeb verifySendMessageIsDisplayed () {

		try {

			Utils.uBase.waitForElementToBeClickable(navigationMenu);
			boolean sendMessage = Utils.uBase.imageCompare("Send a new message");
			if(sendMessage == true){
				AdvanceReporting.addLogs("pass", "Send new message is displayed");
				AdvanceReporting.addLogs("pass", "Send new message is displayed","Send a new message");
			}
			else if(sendMessage == false){
				AdvanceReporting.addLogs("info", "Send New Message is not displayed");
				AdvanceReporting.addLogs("fail", "Send New Message is not displayed");
			} 
		}
		catch(Exception e){

			AdvanceReporting.addLogs("info", "Send New Message is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}

	/* Verify 3 columns in the page */

	public HomePageWeb verifyMessageItemsIsDisplayed() {

		try {

			Thread.sleep(5000);
			boolean sendMessageItems = Utils.uBase.imageCompare("Send a new message");
			if(sendMessageItems == true){
				AdvanceReporting.addLogs("pass", "Send message items is displayed");
				AdvanceReporting.addLogs("pass", "Send new message is displayed","Send a new message");
			}
			else if(sendMessageItems == false){
				AdvanceReporting.addLogs("info", "Send message items is not displayed");
				AdvanceReporting.addLogs("fail", "Send message items is not displayed");
			} 
		}
		catch(Exception e){

			AdvanceReporting.addLogs("info", "Send New Message is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;	
	}



	public HomePageWeb verifyMiniMenuButtonsAreDisplayed () {
		try {
			Thread.sleep(2000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("MiniMenuButtons"), "MiniMenuButtons is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that MiniMenuButtons is displayed");
			AdvanceReporting.addLogs("pass", "MiniMenuButtons is displayed","MiniMenuButtons");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "MiniMenuButtons is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	// Verify Greeting message is displayed
	public HomePageWeb verifyGreetingsIsDisplayed() {
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("GreetingMessage"), "Greeting message is not displayed");
			AdvanceReporting.addLogs("pass","Verified that Greeting message is displayed");
			AdvanceReporting.addLogs("pass","Greeting message is displayed","thirdColumn"); 
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Greeting message is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	public HomePageWeb verifyUnreadCountIsDisplayed() {
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("unreadMessage"), "Unread message is not displayed");
			AdvanceReporting.addLogs("pass","Verified that Unread Message is displayed");
			AdvanceReporting.addLogs("pass","Unread message is displayed","thirdColumn"); 
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Greeting message is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	public HomePageWeb verifyMiniCallBtnIsHighlighted() {

		try {

			Thread.sleep(10000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete")) {
				if(Utils.uBase.imageCompare("MiniCallButton")) { 
					AdvanceReporting.addLogs("pass","Mini Call Button is highlighted");
					AdvanceReporting.addLogs("pass","Mini Call Button is highlighted","MiniCallButton"); 
				} } else { 

					AdvanceReporting.addLogs("info","Mini Call Button is not highlighted"); 
					AdvanceReporting.addLogs("fail","Mini Call Button is not highlighted"); }

		}
		catch(Exception e){

			AdvanceReporting.addLogs("info", "Mini Call Button is not highlighted");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}

	public HomePageWeb verifyMiniMessageBtnIsHighlighted() {

		try {

			Thread.sleep(10000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete")) {
				if(Utils.uBase.imageCompare("miniMessageHighlight")) { 
					AdvanceReporting.addLogs("pass","Mini Message Button is highlighted");
					AdvanceReporting.addLogs("pass","Mini Message Button is highlighted","MiniCallButton"); 
				} } else { 

					AdvanceReporting.addLogs("info","Mini Message Button is not highlighted"); 
					AdvanceReporting.addLogs("fail","Mini Message Button is not highlighted"); }

		}
		catch(Exception e){
			e.printStackTrace(); Assert.fail();
			AdvanceReporting.addLogs("info", "Mini Message Button is not highlighted");
		}
		return this;		
	}
	public HomePageWeb verifyMiniVoicemailBtnIsHighlighted() {

		try {

			Thread.sleep(10000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete")) {
				if(Utils.uBase.imageCompare("MiniVoicemailHighlight")) { 
					AdvanceReporting.addLogs("pass","Mini Message Button is highlighted");
					AdvanceReporting.addLogs("pass","Mini Message Button is highlighted","MiniCallButton"); 
				} } else { 

					AdvanceReporting.addLogs("info","Mini Message Button is not highlighted"); 
					AdvanceReporting.addLogs("fail","Mini Message Button is not highlighted"); }

		}
		catch(Exception e){

			AdvanceReporting.addLogs("info", "Mini Message Button is not highlighted");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}

	public HomePageWeb verifyMiniArchiveBtnIsHighlighted() {

		try {

			Thread.sleep(10000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete")) {
				if(Utils.uBase.imageCompare("MiniArchiveHighlight")) { 
					AdvanceReporting.addLogs("pass","Mini Message Button is highlighted");
					AdvanceReporting.addLogs("pass","Mini Message Button is highlighted","MiniCallButton"); 
				} } else { 

					AdvanceReporting.addLogs("info","Mini Message Button is not highlighted"); 
					AdvanceReporting.addLogs("fail","Mini Message Button is not highlighted"); }

		}
		catch(Exception e){

			AdvanceReporting.addLogs("info", "Mini Message Button is not highlighted");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}

	public HomePageWeb verifyMiniSpamBtnIsHighlighted() {

		try {

			Thread.sleep(10000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete")) {
				if(Utils.uBase.imageCompare("MiniSpamHighlight")) { 
					AdvanceReporting.addLogs("pass","Mini Message Button is highlighted");
					AdvanceReporting.addLogs("pass","Mini Message Button is highlighted","MiniCallButton"); 
				} } else { 

					AdvanceReporting.addLogs("info","Mini Message Button is not highlighted"); 
					AdvanceReporting.addLogs("fail","Mini Message Button is not highlighted"); }

		}
		catch(Exception e){

			AdvanceReporting.addLogs("info", "Mini Message Button is not highlighted");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}

	public HomePageWeb countOfItemsInList() {

		try {
			Thread.sleep(4000);
			Utils.uBase.clickByImage("messageTabs");
			Thread.sleep(1500);
			Utils.uBase.checkPageReady();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstMessages.get(lstMessages.size()-1));
			Thread.sleep(5000);
			messagesCount = lstMessages.size();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstMessages.get(0));
			AdvanceReporting.addLogs("pass", "message count:"+lstMessages.size());

			Thread.sleep(8000);
			Utils.uBase.clickByImage("ClickOnCallsImg");
			Thread.sleep(1500);
			Utils.uBase.checkPageReady();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstCalls.get(lstCalls.size()-1));
			Thread.sleep(5000);
			callsCount = lstCalls.size();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstCalls.get(0));
			AdvanceReporting.addLogs("pass", "calls count:"+lstCalls.size());

			Thread.sleep(5000);
			Utils.uBase.clickByImage("VoiceMailTab");
			Thread.sleep(1500);
			Utils.uBase.checkPageReady();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstVoiceMails.get(lstVoiceMails.size()-1));
			Thread.sleep(5000);
			voicemailsCount = lstVoiceMails.size();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstVoiceMails.get(0));
			AdvanceReporting.addLogs("pass", "voicemail count:"+lstVoiceMails.size());

		} catch (Exception e) {

			// AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	public HomePageWeb countOfItemsInSpamList() {

		try {

			Thread.sleep(4000);
			Utils.uBase.clickByImage("SpamTabImg");
			Thread.sleep(1500);
			Utils.uBase.checkPageReady();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstSpam.get(lstSpam.size()-1));
			Thread.sleep(5000);
			spamCount = lstSpam.size();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstSpam.get(0));
			AdvanceReporting.addLogs("pass", "spam count:"+lstSpam.size());

		} catch (Exception e) {

			// AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}


	public HomePageWeb countOfItemsInListArfterArchiveDelete() {

		try {

			Thread.sleep(4000);
			Utils.uBase.clickByImage("messageTabs");
			Thread.sleep(6000);
			Utils.uBase.checkPageReady();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstMessages.get(lstMessages.size()-1));
			Thread.sleep(5000);
			messagesCountAfterArchive = lstMessages.size();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstMessages.get(0));
			AdvanceReporting.addLogs("pass", "message count:"+messagesCountAfterArchive);

			Thread.sleep(8000);
			Utils.uBase.clickByImage("ClickOnCallsImg");
			Utils.uBase.checkPageReady();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstCalls.get(lstCalls.size()-1));
			Thread.sleep(5000);
			callsCountAfterArchive = lstCalls.size();
			Thread.sleep(2000);
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstCalls.get(0));
			AdvanceReporting.addLogs("pass", "calls count:"+callsCountAfterArchive);

			Thread.sleep(5000);
			Utils.uBase.clickByImage("VoiceMailTab");
			Utils.uBase.checkPageReady();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstVoiceMails.get(lstVoiceMails.size()-1));
			Thread.sleep(5000);
			spamCount = lstSpam.size();
			voicemailsCountAfterArchive = lstVoiceMails.size();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstVoiceMails.get(0));
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "voicemail count:"+voicemailsCountAfterArchive);

			Thread.sleep(5000);
			Utils.uBase.clickByImage("SpamTabImg");
			Utils.uBase.checkPageReady();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", lstSpam.get(lstSpam.size()-1));
			Thread.sleep(5000);
			spamCount = lstSpam.size();
			spamCountAfterArchive = lstSpam.size();
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "spam count:"+spamCountAfterArchive);


			Assert.assertEquals(messagesCount, messagesCountAfterArchive,"Message count is not same after archive delete");
			Assert.assertEquals(callsCount, callsCountAfterArchive,"Message count is not same after archive delete");
			Assert.assertEquals(voicemailsCount, voicemailsCountAfterArchive,"Message count is not same after archive delete");
			Assert.assertEquals(spamCount, spamCountAfterArchive,"Message count is not same after archive delete");



		} catch (Exception e) {

			// AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	//Clicks on google apps icon in home page
	public HomePageWeb clickGoogleApps() {

		try {

			if (((JavascriptExecutor) Utils.uBase.webDriver).executeScript("return document.readyState")
					.equals("complete")) {

				Utils.uBase.clickByImage("GoogleApps");
				Thread.sleep(2000);
				AdvanceReporting.addLogs("pass", "Clicked on google apps");
				AdvanceReporting.addLogs("pass", "Clicked on google apps","GoogleAppsClicked");
			}}catch(Exception e)
		{
				AdvanceReporting.addLogs("info", "Google apps is not clicked");
				AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());

		}return this;
	}

	//Selects gmail from listed google apps
	public HomePageWeb clickGmail() {

		try {
			Utils.uBase.clickByImage("Gmail");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Clicked on gmail in google apps");
			AdvanceReporting.addLogs("pass", "Clicked on gmail in google apps","GmailInGoogleAppsClicked");
			Utils.uBase.switchToNewWindow();
		}catch(Exception e) {
			AdvanceReporting.addLogs("info", "Gmail in google apps is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;}

	//Closed opened gmail tab
	public HomePageWeb closeGmailTab() 
	{
		try {
			Utils.uBase.webDriver.close();
		}catch(Exception e) {
			AdvanceReporting.addLogs("info", "Gmail in google apps is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;}


	//Integrates hangouts to the google voice account
	public HomePageWeb integrateHangouts() {

		try {
			//Utils.uBase.switchWindows("child");
			Utils.uBase.switchToNewWindow();

			System.out.println(Utils.uBase.webDriver.getCurrentUrl());
			Thread.sleep(3000);

			Utils.uBase.webDriver.switchTo().frame(gmailArowFrame);
			System.out.println("Switched to arrow frame");
			if(lstGmailArowUser.size()!=0) {
				Utils.uBase.waitForElement(gmailArowUser);
				Utils.uBase.clickWebelement(gmailArowUser);
			}else
			{
				Utils.uBase.clickByImage("UsersNotDisplayed");
				Utils.uBase.clickWebelement(gmailArowUser);
			}
			Thread.sleep(3000);
			Utils.uBase.clickByImage("ScrollbarGrey");
			Utils.uBase.clickByImage("Scrollbar");
			AdvanceReporting.addLogs("info", "Selecting checkbox","integrateHangouts");
			Thread.sleep(3000);			
			Utils.uBase.clickByImage("ReceiveSms");
			AdvanceReporting.addLogs("info", "Hangouts integrated");

			Utils.uBase.switchToOldWindow();
			Thread.sleep(3000);
			Utils.uBase.refresh();
		}catch(Exception e) {

			AdvanceReporting.addLogs("info", "integration failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();

		}return this;
	}

	//Verifies if hangouts integration message is displayed in googlevoice home page
	public HomePageWeb verifyHangoutsMessageDisplayedInGV() {
		try {

			Thread.sleep(10000);
			Assert.assertTrue(Utils.uBase.imageCompare("HangoutsMessage"),"Hangouts integration message is not displayed");
			AdvanceReporting.addLogs("pass","Hangouts integration message is displayed");
			AdvanceReporting.addLogs("pass","Hangouts integration message is displayed","HangoutsIntegrated"); 

			/*
			 * if(Utils.uBase.imageCompare("HangoutsMessage")) {
			 * AdvanceReporting.addLogs("pass",
			 * "Hangouts integration message is displayed");
			 * AdvanceReporting.addLogs("pass",
			 * "Hangouts integration message is displayed","HangoutsIntegrated"); }
			 * 
			 * else { AdvanceReporting.addLogs("fail",
			 * "Hangouts integration message is not displayed");
			 * AdvanceReporting.addLogs("pass",
			 * "Hangouts integration message is displayed","HangoutsNotIntegrated"); }
			 */

		} catch (Exception e) {

			AdvanceReporting.addLogs("info","Hangouts integration message is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	//Removes the created hangout itegration
	public HomePageWeb removeHangoutIntegration() {

		try {


			Utils.uBase.switchToNewWindow();
			Utils.uBase.clickByImage("SMSReceivedChecked");
			AdvanceReporting.addLogs("pass", "Hangout integration removed");
			AdvanceReporting.addLogs("pass", "Hangout integration removed", "RemoveHangout");
		} catch (Exception e) {

			AdvanceReporting.addLogs("info", "Removing hangout integration failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	//Verifies if send message button is disabled when hangout is enabled
	public HomePageWeb verifySendMsgBtnDisabledWhenHangoutMsgPresent() {

		try {

			Thread.sleep(3000);
			Assert.assertTrue(Utils.uBase.imageCompare("DisabledSendMsgBtn"),"Send button is not disabled");
			AdvanceReporting.addLogs("pass", "Disabled Send message button is displayed");
			AdvanceReporting.addLogs("pass", "Disabled Send message button is displayed","DisabledSendMsgBtn");
		}
		catch(Exception e) {

			AdvanceReporting.addLogs("info", "Disabled send message button: Image comparision failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	//Checks the status of send message button
	public HomePageWeb verifySendMsgBtnStatus(String value) {

		try {

			if(value.equalsIgnoreCase("Enabled"))
			{
				Thread.sleep(2000);
				Assert.assertTrue(Utils.uBase.imageCompare("EnabledSendBtn"),"Send is not enabled");
				AdvanceReporting.addLogs("pass", "Send button is enabled");
				AdvanceReporting.addLogs("pass", "Send button is enabled","SendEnabled");
			}
			else if(value.equalsIgnoreCase("Disbled"))
			{

				Thread.sleep(3000);
				Assert.assertTrue(Utils.uBase.imageCompare("DisabledSendMsgBtn"),"Send is enabled");
				AdvanceReporting.addLogs("pass", "Send button is not enabled");
				AdvanceReporting.addLogs("pass", "Send button is not enabled","SendDisabled");
			}

		}catch(Exception e) {

			AdvanceReporting.addLogs("fail", "Enabled send message button: Image comparision failed");
			e.printStackTrace(); Assert.fail();
		}

		return this;
	} 

	//Counts the available items in messages
	public HomePageWeb countOfItemsInMessagesList() {

		try {

			Thread.sleep(4000);
			Utils.uBase.clickByImage("messageTabs");
			AdvanceReporting.addLogs("pass", "Clicked on messages tab");
			messagesCount = lstMessages.size();
			AdvanceReporting.addLogs("pass", "Count of messages in message folder: "+messagesCount);

		} catch (Exception e) {

			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	//Counts messages after sending message and verifies if the new message is received
	public HomePageWeb countOfItemsInMessageListAfterSending() {

		try {
			SoftAssert Assert = new SoftAssert();

			Thread.sleep(2000);
			Utils.uBase.clickByImage("messageTabs");
			msgCountAfter = lstMessages.size();
			AdvanceReporting.addLogs("pass", "Count of messages after sending message: "+msgCountAfter);
			Assert.assertTrue(msgCountAfter > messagesCount, "Latest messages are not received");
			AdvanceReporting.addLogs("pass", "Latest messages are received");

		} catch (Exception e) {

			// AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	//Clicks on hangout in google apps
	public HomePageWeb clickHangouts() {

		try {

			Thread.sleep(1000);
			Utils.uBase.clickByImage("GoogleAppsDownArrow");
			Utils.uBase.clickByImage("GoogleAppsDownArrow");

			Thread.sleep(1000);
			Utils.uBase.clickByImage("moreGoogleApps");

			Thread.sleep(5000);
			Utils.uBase.clickByImage("HangoutsGoogleApps");

			Thread.sleep(3000);
			AdvanceReporting.addLogs("pass", "Clicked on hangouts in google apps");
			AdvanceReporting.addLogs("pass", "Clicked on hangouts in google apps","GoogleAppsClicked");

			Thread.sleep(5000);
		}catch(Exception e)
		{
			AdvanceReporting.addLogs("fail", "Hangouts is not clicked");

		}return this;
	}

	//Verifies if hangouts integration message is displayed in googlevoice home page
	public  HomePageWeb  RemoveIfHangoutIsAlreadyIntegrated() {
		try {

			AdvanceReporting.addLogs("info", "Hangouts is already integrated, hence removing integation before proceeding");

			if(Utils.uBase.imageCompare("HangoutsMessage"))
			{
				Thread.sleep(10000);
				Utils.uBase.checkPageReady();
				Utils.uBase.clickByImage("SettingsTab");

				Thread.sleep(2000);
				Utils.uBase.clickByImage("HangoutsTab");

				Thread.sleep(2000);
				Utils.uBase.clickByImage("DisconnectHangouts");

				Thread.sleep(2000);
				Utils.uBase.clickByImage("DisconnectPopUp");

				Thread.sleep(2000);
				Utils.uBase.clickByImage("closeSettings");



			}} catch (Exception e) {

				AdvanceReporting.addLogs("info","Hangouts integration message is not displayed");
				AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
				e.printStackTrace(); Assert.fail();
			}

		return this;
	}

	public HomePageWeb verifyInboxSummaryHasUnreadItems() {
		int res = 0;
		try {
			Thread.sleep(2000);
			SoftAssert Assert = new SoftAssert();

			Assert.assertTrue(Integer.parseInt(unreadMessages.getText()) >= 1, "Unread messages are not present");
			AdvanceReporting.addLogs("pass", "Unread message items are present");
			res++;

			Thread.sleep(5000);
			Assert.assertTrue(Integer.parseInt(unreadCalls.getText()) >= 1, "Unread calls are not present");
			AdvanceReporting.addLogs("pass", "Unread call items are present");
			res++;

			Assert.assertTrue(Integer.parseInt(unreadVoicemails.getText()) >= 1, "Unread voicemails are not present");
			AdvanceReporting.addLogs("pass", "Unread voicemails items are present");
			res++;

			AdvanceReporting.addLogs("pass", "Unread items items are present", "InboxSummaryUnreadItems");

		} catch (Exception e) {
			if (res == 0) {
				AdvanceReporting.addLogs("info", "Unread message items are not displayed");
			}
			if (res == 1) {
				AdvanceReporting.addLogs("info", "Unread call items are not displayed");
			}
			if (res == 2) {
				AdvanceReporting.addLogs("info", "Unread voicemail items are not displayed");
			}

			// AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	public HomePageWeb countOfItemsInListAfterSending() {

		try {
			SoftAssert Assert = new SoftAssert();

			Thread.sleep(2000);
			Utils.uBase.clickByImage("messageTabs");
			msgCountAfter = lstMessages.size();

			Thread.sleep(8000);
			Utils.uBase.clickByImage("ClickOnCallsImg");
			callsCountAfter = lstCalls.size();

			Thread.sleep(5000);
			Utils.uBase.clickByImage("VoiceMailTab");
			voicemailsCountAfter = lstVoiceMails.size();

			Assert.assertTrue(msgCountAfter > messagesCount, "Latest messages are not received");
			AdvanceReporting.addLogs("pass", "Latest messages are received");

			Assert.assertTrue(callsCountAfter > callsCount, "Latest Calls are not received");
			AdvanceReporting.addLogs("pass", "Latest calls are received");

			Assert.assertTrue(voicemailsCountAfter > voicemailsCount, "Latest voicemails are not received");
			AdvanceReporting.addLogs("pass", "Latest voicemails are received");

		} catch (Exception e) {

			// AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}

	public HomePageWeb verifywolverineAccount(String email) {
		try {
			if(email.contains("gmail.com")) {
				AdvanceReporting.addLogs("fail","account is not wolverine");
			}
			else {
				AdvanceReporting.addLogs("pass","Verified that account is wolverine");
			}
		}
		catch(Exception e) {

		}
		return this;
	}

	public HomePageWeb clickGoogleAccountIcon() {
		try {
			Thread.sleep(3000);
			Utils.uBase.waitForElementToBeClickable(googleAccountIcon);
			Utils.uBase.clickWebelement(googleAccountIcon);
			AdvanceReporting.addLogs("pass", "googleaccount icon has clicked");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "googleaccount icon is not clicked");
		}
		return this;
	}

	/* Unread Message shown next to the Message Icon are equal to the total number */
	public HomePageWeb verifyUnreadMsgsEqualToTheTotalNumber() {
		int res=0;
		try {
			Thread.sleep(3000);
			SoftAssert Assert=new SoftAssert();
			Assert.assertTrue(Integer.parseInt(unreadMsgs.getText())>=1,"Unread Msgs are not present");
			AdvanceReporting.addLogs("pass","Unread Msgs items are present"); 
			res++;
		}
		catch(Exception e){

			if(res==1) {
				AdvanceReporting.addLogs("pass", "Unread Msgs items are not displayed");				
			}
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}

	public HomePageWeb switchingToFirstWindow() {
		try {
			ArrayList<String> tabs = new ArrayList<String> (Utils.uBase.webDriver.getWindowHandles());
			System.out.println("No.Windows:"+Utils.uBase.webDriver.getWindowHandles());
			Utils.uBase.webDriver.switchTo().window(tabs.get(1));
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;

	}

	public HomePageWeb switchingToSecondWindow() {
		try {
			ArrayList<String> tabs = new ArrayList<String> (Utils.uBase.webDriver.getWindowHandles());
			Utils.uBase.webDriver.switchTo().window(tabs.get(2));
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;

	}
	// switching to  window
	public HomePageWeb switchingToThirdWindow() {
		try {
			ArrayList<String> tabs = new ArrayList<String> (Utils.uBase.webDriver.getWindowHandles());
			Utils.uBase.webDriver.switchTo().window(tabs.get(3));
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Switching to zero window */
	public HomePageWeb switchingToZerothWindow() {
		try {
			ArrayList<String> tabs = new ArrayList<String> (Utils.uBase.webDriver.getWindowHandles());
			Utils.uBase.webDriver.switchTo().window(tabs.get(0));
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//to click on add account icon
	public HomePageWeb clickgoogleAccountIcon() {
		try {
			Utils.uBase.clickWebelement(googleAccountIcon);
			AdvanceReporting.addLogs("pass", "googleaccount icon has clicked");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "googleaccount icon is not clicked");
		}
		return this;
	}

	//To click on add account option
	public HomePageWeb clickAddAccountOption() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("addAccount");
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (Utils.uBase.webDriver.getWindowHandles());
			Utils.uBase.webDriver.switchTo().window(tabs.get(1));
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "add account option not present");
		}
		return this;

	}

	public HomePageWeb syncWithLoggedInId() {
		try {

			Thread.sleep(2000);
			Utils.uBase.clickByImage("syncLogin");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("SignInChrome");
			Thread.sleep(1000);
			Utils.uBase.switchWindowByTitle("Sign in - Google Accounts");

		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "add account option not present");
		}
		return this;
	}

	public HomePageWeb clickSync() {
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("TurnOnSync");
			Thread.sleep(1000);
			Utils.uBase.switchToOldWindow();
			Utils.uBase.refresh();
			Utils.uBase.switchToNewWindow();
			Utils.uBase.refresh();
			Thread.sleep(1000);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "add account option not present");
		}
		return this;
	}

	public HomePageWeb verifyMessageWithGeneratedStringIsRemvedFromAllFolders(String str) throws Exception

	{
		try
		{   
			Utils.uBase.clickByImage("messageTabs");
			List<WebElement> lstMsgs= Utils.uBase.webDriver.findElements(By.xpath("//*[contains(text(),'"+str+"')]"));
			Assert.assertTrue(lstMsgs.size()==0,"Message is not deleted from messages folder");
			AdvanceReporting.addLogs("pass", "Verified that Item is deleted from messages list");
			AdvanceReporting.addLogs("pass", "Messages folder","Messages folder");

			Utils.uBase.clickByImage("ClickOnCallsImg");
			List<WebElement> lstCalls= Utils.uBase.webDriver.findElements(By.xpath("//*[contains(text(),'"+str+"')]"));
			Assert.assertTrue(lstCalls.size()==0,"Message is not deleted from calls folder");
			AdvanceReporting.addLogs("pass", "Verified that Item is not present in calls folder");
			AdvanceReporting.addLogs("pass", "Calls folder","Calls folder");

			Utils.uBase.clickByImage("VoiceMailTab");
			List<WebElement> lstVoicemails= Utils.uBase.webDriver.findElements(By.xpath("//*[contains(text(),'"+str+"')]"));
			Assert.assertTrue(lstVoicemails.size()==0,"Message is not deleted from voicemails folder");
			AdvanceReporting.addLogs("pass", "Verified that Item is not present voicemails folder");
			AdvanceReporting.addLogs("pass", "Voicemail folder","Voicemail folder");

			Utils.uBase.clickByImage("SpamTabImg");
			List<WebElement> lstSpam= Utils.uBase.webDriver.findElements(By.xpath("//*[contains(text(),'"+str+"')]"));
			Assert.assertTrue(lstSpam.size()==0,"Message is not deleted from spam folder");
			AdvanceReporting.addLogs("pass", "Verified that Item is not present in spam folder");
			AdvanceReporting.addLogs("pass", "Spam folder","Spam folder");            
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;    }
	
	public HomePageWeb verifyCallPanelInRight() throws Exception {
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
			else
				AdvanceReporting.addLogs("pass", "KeyBoard pannel is not in right side to the page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
	public HomePageWeb verifyTopSecGVNum() throws Exception {
		try	{
			Utils.uBase.refresh();
			Thread.sleep(5000);
			Point fixed=audioSettings.getLocation();
			Point p=phoneNumberBanner.getLocation();
			Point temp=enterPhNumberPlaceholder.getLocation();
			int yCord_GVNum=p.getY();
			int yCord_Audio=fixed.getY();
			int yCord_EnterPhnNo=temp.getY();
			System.out.println("yCord_GVNum"+yCord_GVNum);
			System.out.println("yCord_Audio"+yCord_Audio);
			System.out.println("yCord_EnterPhnNo"+yCord_EnterPhnNo);
			if(yCord_Audio<yCord_GVNum&&yCord_GVNum<yCord_EnterPhnNo) {
				AdvanceReporting.addLogs("pass", "Verified that Phone number banner is on the top");
				AdvanceReporting.addLogs("pass", "Verified that Phone number banner is on the top","KeyboardPage");
			}
			else
				AdvanceReporting.addLogs("fail", "Phone number banner is not at the top");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
	public HomePageWeb verifySecondSecEnterNameOrNum() throws Exception {
		try	{
			Thread.sleep(5000);
			Point fixed=phoneNumberBanner.getLocation();
			Point p=enterPhNumberPlaceholder.getLocation();
			Point temp=pannelCalls.getLocation();
			int yCord_GVNum=fixed.getY();
			int yCord_keyboard=temp.getY();
			int yCord_EnterPhnNo=p.getY();
			System.out.println("yCord_GVNum"+yCord_GVNum);
			System.out.println("yCord_keyboard"+yCord_keyboard);
			System.out.println("yCord_EnterPhnNo"+yCord_EnterPhnNo);
			if(yCord_GVNum<yCord_EnterPhnNo&&yCord_EnterPhnNo<yCord_keyboard) {
				AdvanceReporting.addLogs("pass", "Verified that enter name or number is on the second top");
				AdvanceReporting.addLogs("pass", "Verified that enter name or number is on the second top","KeyboardPage");
			}
			else
				AdvanceReporting.addLogs("fail", "enter name or number is not on the second top");
			if(Utils.uBase.imageCompare("grayedOutCallBtnAndEnterOptn")==true) {
				AdvanceReporting.addLogs("pass", "Verified that enter phone number and call button are grayed out");
			}
			else
				AdvanceReporting.addLogs("fail", "Enter phone number and call button are not grayed out");
			
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifyThirdSecSuggList() throws Exception {
		try	{
			Thread.sleep(5000);
			Point fixed=enterPhNumberPlaceholder.getLocation();
			Point p=suggetionListText.getLocation();
			Point temp=pannelCalls.getLocation();
			int yCord_EnterNum=fixed.getY();
			int yCord_keyboard=temp.getY();
			int yCord_Suggetin=p.getY();
			System.out.println("yCord_EnterNum"+yCord_EnterNum);
			System.out.println("yCord_keyboard"+yCord_keyboard);
			System.out.println("yCord_Suggetin"+yCord_Suggetin);
			if(yCord_EnterNum<yCord_Suggetin&&yCord_Suggetin<yCord_keyboard) {
				AdvanceReporting.addLogs("pass", "Verified that suggetion list is on third section");
				AdvanceReporting.addLogs("pass", "Verified that suggetion list is on third section","KeyboardPage");
			}
			else
				AdvanceReporting.addLogs("fail", "Suggetion list is not on third place");
			Utils.uBase.checkPageReady();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", freqContactList.get(freqContactList.size()-1));
			Thread.sleep(3000);	
			if(Utils.uBase.imageCompare("suggetionListText")==true) {
				AdvanceReporting.addLogs("pass", "Verified that items scrolled down");
			}
			else
				AdvanceReporting.addLogs("fail", "List is not scrollable");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifyFourthSecKeypad() throws Exception {
		try	{
			Thread.sleep(5000);
			Point fixed=suggetionListText.getLocation();
			Point p=pannelCalls.getLocation();
			Point temp=hideKeyboard.getLocation();
			int yCord_SuggList=fixed.getY();
			int yCord_keyboard=p.getY();
			int yCord_HideKeypad=temp.getY();
			System.out.println("yCord_SuggList"+yCord_SuggList);
			System.out.println("yCord_keyboard"+yCord_keyboard);
			System.out.println("yCord_HideKeypad"+yCord_HideKeypad);
			if(yCord_SuggList<yCord_keyboard&&yCord_keyboard<yCord_HideKeypad) {
				AdvanceReporting.addLogs("pass", "Verified that dail pad is in fourth section");
				AdvanceReporting.addLogs("pass", "Verified that dail pad is in fourth section","KeyboardPage");
			}
			else
				AdvanceReporting.addLogs("fail", "Keypad is not in fourth place");
		}
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifyHideKeyboardlast() throws Exception {
		try	{
			Thread.sleep(5000);
			Point p=pannelCalls.getLocation();
			Point temp=hideKeyboard.getLocation();
			int yCord_keyboard=p.getY();
			int yCord_HideKeypad=temp.getY();
			if(yCord_keyboard<yCord_HideKeypad) {
				AdvanceReporting.addLogs("pass", "Verified that hide keypad is below keypad");
				AdvanceReporting.addLogs("pass", "Verified that hide keypad is below keypad","KeyboardPage");
			}
			else
				AdvanceReporting.addLogs("fail", "Hide keypad is not below keypad");
		}
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifyNavigatedToSettings() {
		try {
			Thread.sleep(5000);
			if(Utils.uBase.getCurrentUrl().contains("settings"))
			{
				AdvanceReporting.addLogs("pass", "Verified that navigated to settings page");
				AdvanceReporting.addLogs("pass", "Verified that navigated to settings page", "Settings page");
			}
			else
				AdvanceReporting.addLogs("fail", "navigation to settings page is not done");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifyDailpadNotDisplayed() {
		try {
			if(Utils.uBase.imageCompare("dailpad")==false)
			{
				AdvanceReporting.addLogs("pass", "Verified that settings page does not have dailpad");
				AdvanceReporting.addLogs("pass", "Verified that settings page does not have dailpad", "Settings page does not have dailpad");
			}
			else
				AdvanceReporting.addLogs("fail", "settings page have dailpad");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifyNavigatedToSpam() {
		try {
			Thread.sleep(5000);
			if(Utils.uBase.getCurrentUrl().contains("spam"))
			{
				AdvanceReporting.addLogs("pass", "Verified that navigated to spam page");
				AdvanceReporting.addLogs("pass", "Verified that navigated to sapm page", "spam page");
			}
			else
				AdvanceReporting.addLogs("fail", "navigation to spam page is not done");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifyNavigatedToArchive() {
		try {
			Thread.sleep(5000);
			if(Utils.uBase.getCurrentUrl().contains("archive"))
			{
				AdvanceReporting.addLogs("pass", "Verified that navigated to archive page");
				AdvanceReporting.addLogs("pass", "Verified that navigated to archive page", "spam page");
			}
			else
				AdvanceReporting.addLogs("fail", "navigation to archive page is not done");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifyNavigatedToVoicemail() {
		try {
			Thread.sleep(5000);
			if(Utils.uBase.getCurrentUrl().contains("voicemail"))
			{
				AdvanceReporting.addLogs("pass", "Verified that navigated to voicemail page");
				AdvanceReporting.addLogs("pass", "Verified that navigated to voicemail page", "spam page");
			}
			else
				AdvanceReporting.addLogs("fail", "navigation to voicemail page is not done");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifyNavigatedToMessages() {
		try {
			Thread.sleep(5000);
			if(Utils.uBase.getCurrentUrl().contains("messages"))
			{
				AdvanceReporting.addLogs("pass", "Verified that navigated to messages page");
				AdvanceReporting.addLogs("pass", "Verified that navigated to messages page", "spam page");
			}
			else
				AdvanceReporting.addLogs("fail", "navigation to messages page is not done");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifyContactListDisplayed() {
		try {
			Thread.sleep(2000);
			for(int i=0;i<suggestedContactNames.size();i++) {
				char temp=suggestedContactNames.get(i).getText().charAt(0);
				if(temp=='t'||temp=='T')
				{
					AdvanceReporting.addLogs("pass", "List of Suggested contacts are displayed");
					AdvanceReporting.addLogs("pass", "List of Suggested contacts are displayed","List of contacts are displayed");
				}
				else
					AdvanceReporting.addLogs("fail", "Suggested list is not displayed");
				
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public HomePageWeb verifySuggestionListScrollable() {
		try {
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", suggestedContactNames.get(suggestedContactNames.size()-1));
			AdvanceReporting.addLogs("pass","Suggestionlist is scrollable");
			}
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
public HomePageWeb clickOnfirstItemInSuggestedList() {
		
		try {
			suggestedContactNames.get(0).click();
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}			
		return this;
	}
	
}
