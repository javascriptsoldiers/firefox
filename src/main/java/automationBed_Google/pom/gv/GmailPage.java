package automationBed_Google.pom.gv;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;
import io.appium.java_client.android.AndroidElement;



public class GmailPage {

	@FindBy(xpath="//a[contains(text(),'Inbox')]//..//../div")
	WebElement unreadMailsCount;

	@FindBy(xpath="//*[contains(text(),'New voicemail')]")
	List<WebElement> voicemailEmail;

	@FindBy(xpath="//div[@class='y6']/span/span[contains(text(),'New voicemail')]")
	List<WebElement> lstMailsWithVoicemailTxt;

	@FindBy(xpath="//a[contains(text(),'play message')]")
	WebElement playMesssage;

	@FindBy(xpath="//*[contains(@class,'T-I J-J5-Ji ash T-I-ax7 L3')]")
	WebElement gmailSttngIcon;

	@FindBy(xpath="//div[@class='y6']/span/span[contains(text(),'New text message')]//..//..//..//span[@class='y2']")
	List<WebElement> lstTextMessagesNotifications;

	@FindBy(xpath="//table[contains(@class,'F cf zt')]//tr")
	List<WebElement> gmailItems;

	@FindBy(xpath="//*[contains(@class,'ar6 T-I-J3 J-J5-Ji')]")
	WebElement backBtnGmail;

	@FindBy(xpath="//img[contains(@role,'menu')]")
	WebElement expandVoicemail;
	@FindBy(xpath="(//*[contains(@src,'//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif')])[last()]")
	WebElement opnHidden;
	@FindBy(xpath="(//span[contains(text(),'New voicemail from (647) 490-8123.')])[2]")
	WebElement twilioVoiceMail;
	@FindBy(xpath="//*[contains(@data-tooltip,'Delete')]/div")
	WebElement mailDelete;
	@FindBy(xpath="//span[contains(@class,'asa bjy')]")
	WebElement moreOptnMail;
	int h;
	int m;
	int hA;
	int mA;
	
	//When a new user opens hangout, few screens are displayed, this method navigates forward to home page 
	public GmailPage verifyIfVoicemailNotificationIsReceived(String toggleStatus,String callToNumber)
	{
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		try {
			System.out.println(Utils.uBase.webDriver.getCurrentUrl());
			Thread.sleep(4000);
			//			int countUnreadEmailsInitially=Integer.parseInt(unreadMailsCount.getText()),
			//					countUnreadAfterReceivingNotification=0;
			//Fetching the time of recent voicemail email
			String timeInitially=getTimeOfVoicemailEmail(Constants.phoneNumber); 
			//Removing AM/PM from time and storing time of email in array before any call is explicitly triggered
			String[] res=timeInitially.replaceAll("([A-Z])", "").split(":");
			String def = res[1].replaceAll("\\s", "");
			String timeInEmailAfterCall=null; 
			AdvanceReporting.addLogs("info","Triggering a call from Twillio to GV");
			//ReceiveCallAndMessages.makeCall(callToNumber); 
			Thread.sleep(30000);
			Utils.uBase.refresh();
			Thread.sleep(420000);
			Utils.uBase.refresh();
			Utils.uBase.checkPageReady();
			AdvanceReporting.addLogs("info", "Calls sent from Twillio to GV");
			//variable for getting count of unread items in inbox after receiving voicemail email
			//Verify email is received when toggle is ON
			if(toggleStatus.equalsIgnoreCase(Constants.ON)) {
				//Time taken to receive voicemail notification in gmail after triggerring call is 6 minutes
				//Checks if inbox unread count is updated after email is received
				//				countUnreadAfterReceivingNotification=Integer.parseInt(unreadMailsCount.getText());
				//				Assert.assertTrue(countUnreadEmailsInitially<
				//						countUnreadAfterReceivingNotification,"Notification is not recevied when toggle is ON"
				//						); 
				//Fetches the time of email notification received after call is triggered
				timeInEmailAfterCall=getTimeOfVoicemailEmail(Constants.phoneNumber);
				//Storing hours and minutes of time in email received after call is triggered
				String[] resAfterEmail=timeInEmailAfterCall.replaceAll("([A-Z])","").split(":");
				String abc = resAfterEmail[1].replaceAll("\\s", "");
				System.out.println("Array length : "+resAfterEmail.length);
				hA=Integer.parseInt(resAfterEmail[0]);
				System.out.println("resAfterEmail[0]"+hA);
				mA=Integer.parseInt(abc);
				//If call is triggered at 12:54, voicemail will be received after 6 minutes, so time changes to 1:00, the following verification handles it
				h=Integer.parseInt(res[0]);
				m=Integer.parseInt(def);
				System.out.println(h+""+m+""+hA+""+mA);
				if((h==12) && m>53){
					//Checking only hours component of latest received email, whether it is changing to 1
					if(hA==1) { AdvanceReporting.addLogs("pass",
							"Notification is  recevied when toggle is ON");
					AdvanceReporting.addLogs("pass",
							"Notification is  recevied when toggle is ON","Notifications received"); } }
				//Verifies if hours component of email time received after call is greater than earlier one
				if(hA>h) {
					AdvanceReporting.addLogs("pass",
							"Notification is  recevied when toggle is ON");
					AdvanceReporting.addLogs("pass",
							"Notification is  recevied when toggle is ON","Notifications received");

				}else if(hA==h) { 

					//Verifies the condition when hours component is same
					if(hA==h) {
						if(mA>m) {
							AdvanceReporting.addLogs("pass",
									"Notification is  recevied when toggle is ON");
							AdvanceReporting.addLogs("pass",
									"Notification is  recevied when toggle is ON","Notifications received"); } }
					else { AdvanceReporting.addLogs("fail",
							"Notification is not recevied when toggle is ON");
					AdvanceReporting.addLogs("fail",
							"Notification is not recevied when toggle is ON","Notifications received"); }
				} 
				if(toggleStatus.equalsIgnoreCase(Constants.OFF)) {
					int countUnreadEmailsInitially=Integer.parseInt(unreadMailsCount.getText()),
							countUnreadAfterReceivingNotification=0;
					AdvanceReporting.addLogs("info","Triggering a call from Twillio to GV");
					//ReceiveCallAndMessages.makeCall(callToNumber); 
					GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, callToNumber, 2);

					Thread.sleep(30000);
					Utils.uBase.refresh();
					Thread.sleep(420000);
					Utils.uBase.refresh();
					Utils.uBase.checkPageReady();
					Assert.assertTrue(countUnreadEmailsInitially==
					countUnreadAfterReceivingNotification,"Notification is not recevied when toggle is ON");
					AdvanceReporting.addLogs("pass",
							"Notification is not recevied when toggle is OF");
					AdvanceReporting.addLogs("pass",
							"Notification is  not recevied when toggle is ON"
							,"Notifications not received"); }


			}}
		catch(Exception e) {

			AdvanceReporting.addLogs("fail", "Notification count mismatch");

		}return this;

	}

	public GmailPage openFirstMailWithVoicemailText() {
		try {

			if(lstMailsWithVoicemailTxt.size()!=0)
			{
				Thread.sleep(30000);
				Utils.uBase.clickWebelement(lstMailsWithVoicemailTxt.get(0));
				AdvanceReporting.addLogs("info", "Clicked on voicemail email");
				AdvanceReporting.addLogs("info", "Clicked on voicemail email","Email");
			}

		}catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Voicemail email is not clicked");
		}
		return this;}

	public GmailPage clickPlayMessage() {
		try {

			Utils.uBase.clickWebelement(playMesssage);
			AdvanceReporting.addLogs("info", "Clicked on play message");
			AdvanceReporting.addLogs("info", "Clicked on play message","playmsg");

		}catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Play message in email is not clicked");
		}
		return this;}

	public GmailPage verifyNavigationToGoogleVoicemail() {
		try {
			Thread.sleep(5000);
			GeneralActivitiesPage GAPAge = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
			GAPAge.switchingToWindowByIndex(1);
			Thread.sleep(4000);
			openFirstMailWithVoicemailText();
			if(Utils.uBase.isElementPresent_webelement(playMesssage)) {
				Thread.sleep(1500);		
				clickPlayMessage();
			}
			else {
				Utils.uBase.scrolltoElement(expandVoicemail);
				Utils.uBase.clickWebelement(opnHidden);
				Thread.sleep(2000);			
				clickPlayMessage();
			}
			GAPAge.switchingToWindowByIndex(2);
			HomePageWeb home=PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
			Utils.uBase.waitForElement(home.googleVoiceLogo);
			Assert.assertTrue(Utils.uBase.getCurrentUrl().contains("voicemail"),"Redirection to voicemail page unsuccessful");
			AdvanceReporting.addLogs("pass", "Verified that redirected to voicemails page");


		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Not redirected to voicemails page");
		}
		return this;

	}

	public String getTimeOfVoicemailEmail(String number) {

		String res=null;
		try {

			//Converting phone number to (xxx) xxx-xxxx format
			String str="("+ number.replace("+1", ""); String strPhoneNo=str.substring(0,
					4)+") "+str.substring(4,7)+"-"+str.substring(7,str.length());

			//Identifying the time of latest voicemail email 
			List<WebElement> lstCountOfEmails=Utils.uBase.webDriver.findElements(By.
					xpath("//div[@class='y6']/span/span[contains(text(),'New voicemail from "
							+strPhoneNo+"')]//..//..//..//..//..//..//td[@class='xW xY ']/span/span")); 

			if(lstCountOfEmails.size()!=0) {
				//res= lstCountOfEmails.size();
				res=lstCountOfEmails.get(0).getText();
			}
			else {
				res="No old emails";
			}

			//res=Utils.uBase.webDriver.findElements(By.xpath("//div[@class='y6']/span/span[contains(text(),'New voicemail from "+Constants.phoneNumber+"')]//..//..//..//..//..//..//td[@class='xW xY ']/span/span")).get(0).getText();
			AdvanceReporting.addLogs("info", "");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Not redirected to voicemails page");
		}

		return res;
	}

	//When a new user opens hangout, few screens are displayed, this method navigates forward to home page 
	public GmailPage verifyMissedCallAlertNotificationIsReceived(String toggleStatus,String data)
	{
		try {
			GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
			Utils.uBase.switchToNewWindow();

			System.out.println(Utils.uBase.webDriver.getCurrentUrl());
			Thread.sleep(4000);

			int countUnreadEmailsInitially=Integer.parseInt(unreadMailsCount.getText()),
					countUnreadAfterReceivingNotification=0;

			//Fetching the time of recent voicemail email
			String timeInitially=getTimeOfVoicemailEmail(Constants.phoneNumber); 



			//Removing AM/PM from time and storing time of email in array before any call is explicitly triggered
			String[] res=timeInitially.replaceAll("([A-Z])", "").split(":");

			String timeInEmailAfterCall=null; 
			AdvanceReporting.addLogs("info","Triggering a call from Twillio to GV");
			//ReceiveCallAndMessages.makeCall(data); 
			GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
			Thread.sleep(25000);
			AdvanceReporting.addLogs("info", "Calls sent from Twillio to GV");


			//Verify email is received when toggle is ON
			if(toggleStatus.equalsIgnoreCase(Constants.ON)) {

				//Time taken to receive voicemail notification in gmail after triggerring call is 6 minutes
				Thread.sleep(380000); Utils.uBase.refresh();


				//variable for getting count of unread items in inbox after receiving voicemail email
				countUnreadAfterReceivingNotification=Integer.parseInt(unreadMailsCount.
						getText());

				//Checks if inbox unread count is updated after email is received
				Assert.assertTrue(countUnreadEmailsInitially<
						countUnreadAfterReceivingNotification,"Notification is not recevied when toggle is ON"
						); 


				//Fetches the time of email notification received after call is triggered
				timeInEmailAfterCall=getTimeOfVoicemailEmail(Constants.phoneNumber);

				//Storing hours and minutes of time in email received after call is triggered
				String[] resAfterEmail=timeInEmailAfterCall.replaceAll("([A-Z])",
						"").split(":");


				//If call is triggered at 12:54, voicemail will be received after 6 minutes, so time changes to 1:00, the following verification handles it
				if((Integer.parseInt(res[0])==12) && Integer.parseInt(res[1])>53){

					//Checking only hours component of latest received email, whether it is changing to 1
					if(Integer.parseInt(resAfterEmail[0])==1) { AdvanceReporting.addLogs("pass",
							"Notification is  recevied when toggle is ON");
					AdvanceReporting.addLogs("pass",
							"Notification is  recevied when toggle is ON","Notifications received"); } }


				//Verifies if hours component of email time received after call is greater than earlier one
				if(Integer.parseInt(resAfterEmail[0])>Integer.parseInt(res[0])) {
					AdvanceReporting.addLogs("pass",
							"Notification is  recevied when toggle is ON");
					AdvanceReporting.addLogs("pass",
							"Notification is  recevied when toggle is ON","Notifications received");

				}else { 

					//Verifies the condition when hours component is same
					if(Integer.parseInt(resAfterEmail[0])==Integer.parseInt(res[0])) {
						if(Integer.parseInt(resAfterEmail[1])>Integer.parseInt(res[1])) {
							AdvanceReporting.addLogs("pass",
									"Notification is  recevied when toggle is ON");
							AdvanceReporting.addLogs("pass",
									"Notification is  recevied when toggle is ON","Notifications received"); } }

					else { AdvanceReporting.addLogs("fail",
							"Notification is not recevied when toggle is ON");
					AdvanceReporting.addLogs("fail",
							"Notification is not recevied when toggle is ON","Notifications received"); }
				} 



				if(toggleStatus.equalsIgnoreCase(Constants.OFF)) {
					Assert.assertTrue(countUnreadEmailsInitially==
							countUnreadAfterReceivingNotification,"Notification is not recevied when toggle is ON"
							);

					AdvanceReporting.addLogs("pass",
							"Notification is not recevied when toggle is OF");
					AdvanceReporting.addLogs("pass",
							"Notification is  not recevied when toggle is ON"
							,"Notifications not received"); }

			}
		}
		catch(Exception e) {

			AdvanceReporting.addLogs("fail", "Notification count mismatch");

		}return this;
	}

	public GmailPage verifyEmailIsSentWhenToggleIsturned(String data, String msgsFwdCondition) {

		try {
			String str=Double.toString((Math.random()*1000)+1)+" message";
			AdvanceReporting.addLogs("info", "generated string is :"+str);
			//ReceiveCallAndMessages.receiveMessage(data,str);
			Thread.sleep(3000);
			HomePageWeb homePage= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
			homePage.clickGoogleApps().clickGmail();          	 
			Utils.uBase.switchToNewWindow();
			System.out.println(Utils.uBase.webDriver.getCurrentUrl());
			Utils.uBase.refresh();
			Utils.uBase.checkPageReady();
			Thread.sleep(4000);
			if(msgsFwdCondition.equalsIgnoreCase("true"))
			{
				Utils.uBase.waitForElement(gmailItems.get(0));
				Utils.uBase.clickWebelement(gmailItems.get(0));
				Utils.uBase.clickByImage("gmailBackBtn");	
				Thread.sleep(3000);
				Utils.uBase.waitForElement(lstTextMessagesNotifications.get(0));
				String mailText = lstTextMessagesNotifications.get(0).getText();
				Assert.assertTrue(lstTextMessagesNotifications.get(0).getText().contains(str),"Email notifications is not received");
				AdvanceReporting.addLogs("pass","Notification is recevied when toggle is ON");
				AdvanceReporting.addLogs("pass","Notification is recevied when toggle is ON","Notification received");
			}else if(msgsFwdCondition.equalsIgnoreCase("false")){
				Utils.uBase.waitForElement(gmailItems.get(0));
				Utils.uBase.clickWebelement(gmailItems.get(0));
				Utils.uBase.clickByImage("gmailBackBtn");	
				Thread.sleep(3000);
				Utils.uBase.waitForElement(lstTextMessagesNotifications.get(0));
				String mailText = lstTextMessagesNotifications.get(0).getText();
				Assert.assertFalse(lstTextMessagesNotifications.get(0).getText().contains(str),"Email notification is not received");
				AdvanceReporting.addLogs("pass","Notification is not recevied when toggle is OFF");
				AdvanceReporting.addLogs("pass","Notification is recevied when toggle is OFF","Notification received");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Verification for Email forwarding toggle on failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public GmailPage deleteVoiceMailEmail() {
		try {
			Thread.sleep(1500);
			if(Utils.uBase.isElementPresent_webelement(twilioVoiceMail)) {
				Utils.uBase.clickWebelement(twilioVoiceMail);
				Utils.uBase.clickByImage("mailDelete");
				AdvanceReporting.addLogs("pass", "mail box cleared");
			}
			else {
				AdvanceReporting.addLogs("info", "mail box already cleared");
			}

		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "mail box not cleared");
		}
		return this;
	}
}
