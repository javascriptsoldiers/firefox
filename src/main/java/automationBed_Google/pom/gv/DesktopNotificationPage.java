package automationBed_Google.pom.gv;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class DesktopNotificationPage {

	@FindBy(xpath="//p[@gv-test-id='conversation-title']")
	WebElement phoneNumber;

	@FindBy(xpath="//p[@gv-test-id='conversation-subtitle']")
	WebElement phoneNumberWithSavedText;

	//To verify the desktop notification image for new unread messages
	public DesktopNotificationPage verifyTxtMsgNotification() {
		try {
			
			Assert.assertTrue((Utils.uBase.verifyImageExists("messageImgNotification")),"New message notification didnt appear");
			{ 
				AdvanceReporting.addLogs("Pass","New message desktop notification verified successfully");
				AdvanceReporting.attachScreenPrintToReport("pass","MessageNotification","MessageNotification");
			}
		}catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//To verify the desktop notification image disappears for new unread messages
	public DesktopNotificationPage verifyTxtMsgNotificationDisappear() {
		try {
			Thread.sleep(8000);
				if((Utils.uBase.verifyImageExists("newUnreadMsg"))==true)
			{ 
				AdvanceReporting.addLogs("fail","New message desktop notification is displayed");
				AdvanceReporting.addLogs("fail","Desktop notification did not disappear","Desktop notification did not disappear");
			}
			else
			{
				AdvanceReporting.addLogs("pass","New message desktop notification is not displayed");
				AdvanceReporting.addLogs("pass","desktop notification successfully disappeared","desktop notification successfully disappeared");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//To verify the desktop notification image disappears for new unread messages
	public DesktopNotificationPage clickTxtMsgNotification() {
		try {

			Utils.uBase.clickByImage("messageImgNotification");
			AdvanceReporting.addLogs("Pass","New message desktop notification is clicked");
			AdvanceReporting.addLogs("Pass","New message desktop notification is clicked","New message desktop notification is clicked");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//To verify the desktop notification that has an attached picture
	public DesktopNotificationPage verifyPictureMsgNotification() {
		try {
			Assert.assertTrue(Utils.uBase.verifyImageExists("messageImgNotification"),"Desktop notification for new message with attached picture could not be verified");
			{ 
				AdvanceReporting.addLogs("Pass","Desktop notification for new message with attached picture is verified successfully");
				AdvanceReporting.attachScreenPrintToReport("pass","PictureMessageNotification","PictureMessageNotification");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//Clicking on the desktop notification that has an attached picture
	public DesktopNotificationPage clickPictureMsgNotification() {
		try {
			Utils.uBase.clickByImage("messageImgNotification");
			AdvanceReporting.addLogs("Pass","New message desktop notification with attached picture is clicked");
			AdvanceReporting.addLogs("Pass","Desktop notification with attached picture is clicked","Desktop notification with attached picture is clicked");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}


	//To verify if user is navigated to respective message window after clicking on notification
	public DesktopNotificationPage verifyNavigationOnClickingNotification(String sourceMsgNumber) {
		try {
			Thread.sleep(1000);
			Utils.uBase.switchToOldWindow();

			List<WebElement> msgData= Utils.uBase.webDriver.findElements(By.xpath("//gv-annotation[contains(text(),'"+GeneralActivitiesPage.data+"')]"));
			Assert.assertTrue(msgData.size()!=0,"No such message is displayed");
			AdvanceReporting.addLogs("Pass","Message is received");

			Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");		 
			Matcher matcher = pattern.matcher(phoneNumber.getText());

			if(!matcher.matches())
			{
				String phoneNo=phoneNumber.getText().replace("(", "").replace(")", "").replace("-", "").replaceAll("\\s", "");
				Assert.assertEquals(phoneNo, sourceMsgNumber,"Message is not sent to required number");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed in messages list");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed","SourcePhoneNo");
			}else
			{
				String phoneNo=phoneNumberWithSavedText.getText().replaceAll("[^0-9]", "");
				Assert.assertEquals(phoneNo, sourceMsgNumber,"Message is not sent to required number");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed in messages list");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed","SourcePhoneNo");
			}			
		}
		catch(Exception e) {

			AdvanceReporting.addLogs("info", "Failed in verifyNavigationOnClickingNotification");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//To verify the desktop notification image for new  missed call
	public DesktopNotificationPage verifyMissedCallNotification() {
		try {
			Assert.assertTrue(Utils.uBase.verifyImageExists("messageImgNotification"),"New missed call notification didnt appear");
			AdvanceReporting.addLogs("Pass","New missed call desktop notification verified successfully");
			AdvanceReporting.attachScreenPrintToReport("pass","MissedCallNotification","MissedCallNotification");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//To verify the desktop notification image disappears for new missed call
	public DesktopNotificationPage verifyMissedCallNotificationDisappear() {
		try {
			Thread.sleep(8000);
			if((Utils.uBase.verifyImageExists("messageImgNotification"))==true)
			{ 
				AdvanceReporting.addLogs("fail","New message desktop notification did not disappear after few seconds");
				AdvanceReporting.attachScreenPrintToReport("fail", "Message Notification", "Message Notification");
			}
			else
			{
				AdvanceReporting.addLogs("pass","New message desktop notification successfully disappeared after few seconds");
				AdvanceReporting.attachScreenPrintToReport("pass", "Message Notification", "Message Notification");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//Clicks on missed call notifcation
	public DesktopNotificationPage clickMissedCallNotification() {
		try {

			Utils.uBase.clickByImage("messageImgNotification");
			AdvanceReporting.addLogs("Pass","New missed call notification is clicked");
			AdvanceReporting.addLogs("Pass","New missed call notification is clicked","New message desktop notification is clicked");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//To verify if user is navigated to respective message window after clicking on notification
	public DesktopNotificationPage verifyNavigationToCallsOnClickingNotification(String sourceMsgNumber) {
		try {

			Thread.sleep(2000);
			Utils.uBase.switchToOldWindow();
			Thread.sleep(2000);
			Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");		 
			Matcher matcher = pattern.matcher(phoneNumber.getText());

			if(!matcher.matches())
			{
				String phoneNo=phoneNumber.getText().replaceAll("[^0-9]", "");				
				Assert.assertEquals(phoneNo, sourceMsgNumber,"Message is not sent to required number");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed in messages list");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed","SourcePhoneNo");
			}else
			{
				String phoneNo=phoneNumberWithSavedText.getText().replaceAll("[^0-9]", "");
				Assert.assertEquals(phoneNo, sourceMsgNumber,"Message is not sent to required number");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed in messages list");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed","SourcePhoneNo");
			}			
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//To verify if user is navigated to respective voicemail window after clicking on notification
	public DesktopNotificationPage verifyNavigationToVoicemailPageOnClickingNotification(String sourceMsgNumber) {
		try {

			Thread.sleep(3000);
			Utils.uBase.switchToOldWindow();
			Thread.sleep(3000);
			Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");		 
			Matcher matcher = pattern.matcher(phoneNumber.getText());

			if(!matcher.matches())
			{
				String phoneNo=phoneNumber.getText().replace("(", "").replace(")", "").replace("-", "").replaceAll("\\s", "");
				Assert.assertEquals(phoneNo, sourceMsgNumber,"Message is not sent to required number");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed in messages list");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed","SourcePhoneNo");
			}else
			{
				String phoneNo=phoneNumberWithSavedText.getText().replaceAll("[^0-9]", "");
				Assert.assertEquals(phoneNo, sourceMsgNumber,"Message is not sent to required number");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed in messages list");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed","SourcePhoneNo");
			}			
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//To verify the desktop notification image for new voicemail
	public DesktopNotificationPage verifyVoicemailNotificationDisplayed() {
		try {
			Assert.assertTrue(Utils.uBase.verifyImageExists("VoicemailNotification"),"New missed call notification didnt appear");
			AdvanceReporting.addLogs("Pass","New voicemail desktop notification verified successfully");
			AdvanceReporting.attachScreenPrintToReport("Pass","VoicemailNotification","VoicemailNotification");
		}
		catch(Exception e) {

			AdvanceReporting.addLogs("info", "Failed in checking if voicemail notification is received or not");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//Clicks on voicemail notifcation
	public DesktopNotificationPage clickVoicemailNotification() {
		try {
			Utils.uBase.clickByImage("VoicemailNotification");
			AdvanceReporting.addLogs("Pass","New voicemail  notification is clicked");
			AdvanceReporting.addLogs("Pass","New voicemail notification is clicked","New voicemail desktop notification is clicked");
			Thread.sleep(1000);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}	

	//To verify the desktop notification image disappears for new voicemail notification
	public DesktopNotificationPage verifyVoicemailNotificationDisappear() {
		try {
			Thread.sleep(8000);
			if((Utils.uBase.verifyImageExists("voicemailNotification"))==true)
			{ 
				AdvanceReporting.addLogs("fail","New voicemail desktop notification did not disappear after few seconds");
				AdvanceReporting.attachScreenPrintToReport("fail", "New voicemail desktop notification", "New voicemail desktop notification");
			}
			else
			{
				AdvanceReporting.addLogs("pass","New voicemail desktop notification successfully disappeared after few seconds");
				AdvanceReporting.addLogs("pass","desktop notification successfully disappeared","desktop notification successfully disappeared");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//To verify the desktop notification is not displayed when in same window
	public DesktopNotificationPage verifyVoicemailNotificationNotDisplayed() {
		try {
			Thread.sleep(4000);
			Assert.assertFalse((Utils.uBase.imageCompare("voicemailNotification")),"New voicemail notification didnt appear");
			AdvanceReporting.addLogs("Pass","New voicemail desktop notification verified successfully");
			AdvanceReporting.addLogs("Pass","New voicemail desktop notification","New voicemail desktop notification");

		}
		catch(Exception e) {

			AdvanceReporting.addLogs("info", "Voicemail notification is received when in same window");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}
	
	public DesktopNotificationPage verify() {
		try {
			
				AdvanceReporting.addLogs("Pass","New message desktop notification verified successfully");
				AdvanceReporting.attachScreenPrintToReport("pass","MessageNotification","MessageNotification");
			}catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}
}
