package automationBed_Google.pom.gv;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.security.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;
import automationBed_Google.utility.dataManager.DmConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MessagePageAndroid
{

	// Message Tab
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Messages']")
	private AndroidElement messagesTab;
	// Send a new message
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView")
	private AndroidElement sendNewMessage;
	// To message
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText")
	private AndroidElement toMessage;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
	private AndroidElement contact;
	// Send Text message
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/send_message_text")
	private AndroidElement sendTxtMsgTxtBox;

	// Send msg button
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/send_message_button")
	private AndroidElement sendMsgBtn;

	@AndroidFindBy(xpath="//*[contains(@text,'Google Voice verification code')]")
	AndroidElement messageCode;

	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='2 2 0 0 0 ']")
	AndroidElement messageWithText;

	@AndroidFindBy(xpath="//*[@resource-id='com.samsung.android.messaging:id/content_text_view']")
	List<AndroidElement> lstMesText;

	@AndroidFindBy(xpath="//*[@resource-id='com.samsung.android.messaging:id/subject']")
	List<AndroidElement> lstMessages;

	@AndroidFindBy(xpath="//*[@resource-id='com.samsung.android.messaging:id/list_avatar_name']")
	List<AndroidElement> lstMessagesFrom;

	@AndroidFindBy(xpath="//*[@resource-id='com.samsung.android.messaging:id/unread_count']")
	List<AndroidElement> lstUnreadMsg;

	@AndroidFindBy(xpath="//*[@resource-id='com.samsung.android.messaging:id/list_item_content']")
	List<AndroidElement> lstLinkedMsgs;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc=\"Compose new message\"]")
	AndroidElement composeMsgIconNtvApp;

	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.samsung.android.messaging:id/btn_menu_compose']")
	AndroidElement composeMsgBtnNtvApp;

	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.samsung.android.messaging:id/recipients_editor_to']")
	AndroidElement recepientTxtNtvApp;

	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.samsung.android.messaging:id/message_edit_text']")
	AndroidElement newMsgTxtFldNtvApp;

	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.samsung.android.messaging:id/send_button']")
	AndroidElement msgSndBtnNtvApp;

	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Search\"]")
	AndroidElement msgSearch;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView")
	AndroidElement selectContact;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.samsung.android.messaging:id/attach_button']")
	AndroidElement attachBtn;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Audio\"]/android.widget.TextView")
	private AndroidElement audioBtn;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView")
	AndroidElement audioFile;

	@AndroidFindBy(xpath="//*[@text='Done']")
	AndroidElement doneBtn;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Send']")
	AndroidElement sendBtn;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Contacts\"]/android.widget.TextView")
	AndroidElement attachContact;
	
	@AndroidFindBy(xpath="//*[@text='vCard file (VCF)']")
	AndroidElement vcfFile;
	
	
	

	//	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='⁨(504) 233-0455⁩']")
	//	AndroidElement LinkedNumMsgSender;

	@AndroidFindBy(xpath="//*[@resource-id='com.samsung.android.messaging:id/list_avatar_name']")
	AndroidElement LinkedNumMsgSender;

	@AndroidFindBy(xpath="//*[@resource-id='com.samsung.android.messaging:id/content_text_view']")
	List<AndroidElement> linkedNumMsgTxt;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText")
	AndroidElement searchTab;

	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Send message']")
	AndroidElement messageBox;

	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Not checked, Check box,Test One\"]")
	AndroidElement unsupportedFile;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
	AndroidElement messageBackBtn;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Conversation settings']")
	AndroidElement msgThreedotsMenu;

	@AndroidFindBy(xpath="//*[@resource-id='com.samsung.android.messaging:id/composer_drawer_delete_conversation']")
	AndroidElement deleteMsgConvers;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
	AndroidElement selectAllMsgs;

	@AndroidFindBy(xpath="//android.widget.Button[@content-desc='Delete, Button']")
	AndroidElement deleteIcon;

	@AndroidFindBy(xpath="//*[@resource-id='android:id/button1']")
	AndroidElement deleteConfirmTab;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc='Video']/android.widget.TextView")
	AndroidElement video;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")
	AndroidElement folder;
	
	@AndroidFindBy(xpath="(//android.widget.FrameLayout[@content-desc=\"Button\"])[1]/android.widget.ImageView")
	AndroidElement videoSelect;
	
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Stop']")
	AndroidElement stop;
	
	int count=0, countAfterVoicemail=0;

	public static String code=null;

	public MessagePageAndroid(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public MessagePageAndroid clickMessagesTab(){
		try {
			Utils.uBase.clickAndroidelement(messagesTab);
			AdvanceReporting.addLogs("pass", "Messages Page","Messages Page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePageAndroid composeNewMessage(){
		try {
			Utils.uBase.clickAndroidelement(sendNewMessage);
			String numb = DmConfig.getString("GV.Number");
			Utils.uBase.setText(toMessage, numb);
			Utils.uBase.clickAndroidelement(contact);
			Utils.uBase.setTextAndroidelement(sendTxtMsgTxtBox, "Test Message");
			Utils.uBase.clickAndroidelement(sendMsgBtn);
			AdvanceReporting.addLogs("pass", "New Message Sent","New Message Sent");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePageAndroid getCodeFromMessage()
	{
		try {
			System.out.println("Entered getCodeFromMessage");
			AdvanceReporting.addMobileImageLogs("pass", "Opened message","Opened message");
			Thread.sleep(6000);
			String message=lstMesText.get(lstMesText.size()-1).getText();
			code= message.substring(0, 6);		
		}		
		catch(Exception e) {
			System.out.println("Quitting mdriver");
			Utils.uBase.mDriver.quit();
		}return this;
	}

	public MessagePageAndroid clickOnMessageWithText()
	{
		try {
			Thread.sleep(2000);
			messageWithText.click();
			AdvanceReporting.addMobileImageLogs("pass", "New Message Sent","New Message Sent");
		}catch(Exception e) {

		}return this;
	}


	//verify if message is recieved in linked phone no when toggle is on/off
	public MessagePageAndroid verifyMessageForwardedStatusToLinkedMobile(String data, String msgsFwdCondition) {

		try {		
			
			if(msgsFwdCondition.equalsIgnoreCase("true"))
			{
				String str=Double.toString((Math.random()*1000)+1)+" message";
				AdvanceReporting.addLogs("info", "Randomly generated string is : "+str);
				//ReceiveCallAndMessages.receiveMessage(data,str);          	 
				Thread.sleep(5000);
				clickSmsForwardedLinkedNum();
				AdvanceReporting.addLogs("pass", "Clicked on the forwarded message in linked number inbox");
				Thread.sleep(3000);
				String fwdMessage=linkedNumMsgTxt.get(linkedNumMsgTxt.size()-1).getText();
				Assert.assertTrue(fwdMessage.contains(str),"Text message is not received");
				AdvanceReporting.addLogs("pass", "Message to be contained : "+str);
				AdvanceReporting.addLogs("pass", "Message forwarded to linked number : "+fwdMessage);
				Utils.uBase.mDriver.quit();
			}
			if(msgsFwdCondition.equalsIgnoreCase("false"))
			{
				String str1=Double.toString((Math.random()*1000)+1)+" message";
				AdvanceReporting.addLogs("info", "Randomly generated string is : "+str1);
				//ReceiveCallAndMessages.receiveMessage(data,str1);          	 
				Thread.sleep(5000);
				clickSmsForwardedLinkedNum();
				AdvanceReporting.addLogs("pass", "Clicked on the forwarded message in linked number inbox");
				Thread.sleep(3000);
				String fwdMessage=linkedNumMsgTxt.get(linkedNumMsgTxt.size()-1).getText();
				Assert.assertFalse(fwdMessage.contains(str1),"Text message is not received");
				AdvanceReporting.addLogs("pass", "Message are not forwarded to linked number when toggle is off in GV");
				Utils.uBase.mDriver.quit();
			}}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "Message list is not updated according to the requirement");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}

	//This methods triggers a call from twillio and verifies if SMS is received or not
	//@data=number to which call should be made
	public MessagePageAndroid verifyIfSMSVoicemailIsTriggeredToMobile(String data,String smsFwdCondition)
	{
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		try {
			//			for(AndroidElement element:lstMessagesFrom )
			//			{
			//				System.out.println(element.getText());
			//				if(element.getText().contains("Testing"))
			//				{
			//					Utils.uBase.clickAndroidelement(element);
			//					count=lstLinkedMsgs.size();
			//					AdvanceReporting.addLogs("info", "Count of messages already present with "+Constants.phoneNumber+" :"+ count+" ");
			//				break;}
			//			}
			if(smsFwdCondition.equalsIgnoreCase("true"))
			{
				AdvanceReporting.addLogs("info", "Triggering a call from Twillio to GV");
				//ReceiveCallAndMessages.makeCall(data);
				GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
				Thread.sleep(30000);
				AdvanceReporting.addLogs("info", "Call made from Twillio to GV");	
				for(AndroidElement element:lstMessagesFrom )
				{
					if(element.getText().contains("Testing"))
					{
						Utils.uBase.clickAndroidelement(element);
						int i=lstLinkedMsgs.size();
						Assert.assertTrue(i!=0,"Text message is not received");
						AdvanceReporting.addLogs("pass", " Verified that after few seconds, the selected phone number able to get voicemail notification");
						Utils.uBase.clickAndroidelement(messageBackBtn);
						break;}
				}
			}
			if(smsFwdCondition.equalsIgnoreCase("false"))
			{
				AdvanceReporting.addLogs("info", "Triggering a call from Twillio to GV");
				//ReceiveCallAndMessages.makeCall(data);
				GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
				Thread.sleep(30000);
				AdvanceReporting.addLogs("info", "Call made from Twillio to GV");
				for(AndroidElement element:lstMessagesFrom )
				{
					if(element.getText().contains("Testing"))
					{
						Utils.uBase.clickAndroidelement(element);
						Assert.assertTrue(lstLinkedMsgs.size()>1,"Text message is not received");
						AdvanceReporting.addLogs("pass", " Verified that if not enabled after few seconds, the selected phone number not getting SMS notification for the received voicemails");
						Utils.uBase.clickAndroidelement(messageBackBtn);
						break;}
				}
			}
		}catch(Exception e) {   		

			AdvanceReporting.addLogs("fail", "Call forwarding to linked mobile number failed");
		}return this;
	}

	public MessagePageAndroid tapComposeNewMsgNtvApp(String data){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(composeMsgIconNtvApp);
			Utils.uBase.setText(recepientTxtNtvApp, data);
			Utils.uBase.setText(newMsgTxtFldNtvApp, "Test Message");
			Thread.sleep(1000);
			Utils.uBase.clickAndroidelement(sendBtn);
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "New Message is composed and send to the GV account");
			AdvanceReporting.addLogs("pass", "New Message is composed and send to the GV account","New Message is composed and send to the GV account");
			if(Utils.uBase.mDriver!=null) {
				Utils.uBase.mDriver.quit();}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public MessagePageAndroid enterRecipientNewMsgNtvApp(){
		try {
			String numb = DmConfig.getString("GV.Number");
			Utils.uBase.setText(recepientTxtNtvApp, numb);
			Utils.uBase.clickAndroidelement(newMsgTxtFldNtvApp);
			Utils.uBase.setText(newMsgTxtFldNtvApp, numb);
			Utils.uBase.clickAndroidelement(contact);
			Utils.uBase.setTextAndroidelement(sendTxtMsgTxtBox, "Test Message");
			Utils.uBase.clickAndroidelement(sendMsgBtn);
			AdvanceReporting.addLogs("pass", "New Message Sent","New Message Sent");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePageAndroid clickSearchEnterPhoneNumber(){
		try {
			Utils.uBase.clickAndroidelement(msgSearch);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(selectContact);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(selectContact);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(attachBtn);
			Thread.sleep(5000);
			Utils.uBase.clickAndroidelement(audioBtn);
			Thread.sleep(5000);
			Utils.uBase.clickAndroidelement(audioFile);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(doneBtn);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(sendBtn);
			Thread.sleep(5000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();

		}
		return this;
	}      
	public MessagePageAndroid sendAudioFile(String data){
		try {
			Utils.uBase.clickAndroidelement(composeMsgIconNtvApp);
			Thread.sleep(2000);
			Utils.uBase.setText(recepientTxtNtvApp, data);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(attachBtn);
			Thread.sleep(5000);
			Utils.uBase.clickAndroidelement(audioBtn);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(audioFile);
			Thread.sleep(5000);
			Utils.uBase.clickAndroidelement(doneBtn);
			Thread.sleep(3000);
			Utils.uBase.clickAndroidelement(sendBtn);
			Thread.sleep(3000);
			if(Utils.uBase.mDriver!=null) {
				Utils.uBase.mDriver.quit();}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePageAndroid sendUnsupportedFile(String data){
		try {
			Utils.uBase.clickAndroidelement(composeMsgIconNtvApp);
			Thread.sleep(2000);
			Utils.uBase.setText(recepientTxtNtvApp, data);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(attachBtn);
			Thread.sleep(5000);
			Utils.uBase.clickAndroidelement(attachContact);
			Thread.sleep(5000);
			Utils.uBase.clickAndroidelement(unsupportedFile);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(doneBtn);
			Thread.sleep(4000);
			Utils.uBase.clickAndroidelement(vcfFile);
			Thread.sleep(4000);
			Utils.uBase.clickAndroidelement(sendBtn);
			Thread.sleep(8000);
			if(Utils.uBase.mDriver!=null) {
				Utils.uBase.mDriver.quit();}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	public MessagePageAndroid clickSmsForwardedLinkedNum()
	{
		try {
			Thread.sleep(2000);
			LinkedNumMsgSender.click();
			AdvanceReporting.addMobileImageLogs("pass", "Clicked on the message","Clicked on the message");
		}catch(Exception e) {

		}return this;
	}

	public MessagePageAndroid sendTextMessage(String data){
		try {
			Utils.uBase.clickAndroidelement(msgSearch);
			Thread.sleep(2000);
			Utils.uBase.setText(searchTab, data);
			Thread.sleep(2000);

			Utils.uBase.clickAndroidelement(selectContact);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(messageBox);
			Thread.sleep(5000);
			Utils.uBase.clickAndroidelement(attachBtn);
			Thread.sleep(5000);
			Utils.uBase.clickAndroidelement(audioBtn);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(audioFile);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(doneBtn);
			Thread.sleep(3000);
			Utils.uBase.clickAndroidelement(sendBtn);
			Thread.sleep(3000);
			if(Utils.uBase.mDriver!=null) {
				Utils.uBase.mDriver.quit();}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePageAndroid sendNewMessage(){
		try {
			Utils.uBase.setText(newMsgTxtFldNtvApp, "Test Message");
			Utils.uBase.clickAndroidelement(sendBtn);
			AdvanceReporting.addLogs("pass", "New Message is composed and send to the GV account");
			AdvanceReporting.addLogs("pass", "New Message is composed and send to the GV account","New Message is composed and send to the GV account");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Will delete the current list of messages
	public MessagePageAndroid deleteCurrentListMsgs(){
		try {
			for(AndroidElement element:lstMessagesFrom )
			{
				System.out.println(element.getText());
				if(element.getText().contains("Testing"))
				{
					Utils.uBase.clickAndroidelement(element);		
					AdvanceReporting.addLogs("info", "Count of messages already present with "+Constants.phoneNumber+" :"+ count+" ");
					Utils.uBase.clickAndroidelement(msgThreedotsMenu);
					AdvanceReporting.addLogs("pass", "Tapped on three dots menu in message conversation box");
					Utils.uBase.clickAndroidelement(deleteMsgConvers);
					AdvanceReporting.addLogs("pass", "Tapped on delete button from pop up menu in message conversation box");
					Utils.uBase.clickAndroidelement(selectAllMsgs);
					AdvanceReporting.addLogs("pass", "All messages are selected");
					Utils.uBase.clickAndroidelement(deleteIcon);
					AdvanceReporting.addLogs("pass", "Tapped on delete button in message conversation box");
					Utils.uBase.clickAndroidelement(deleteConfirmTab);
					AdvanceReporting.addLogs("pass", "Delete tab is selected from confirmation menu");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public MessagePageAndroid sendVideoFile(String data){
		try {
			Utils.uBase.clickAndroidelement(composeMsgIconNtvApp);
			Thread.sleep(2000);
			Utils.uBase.setText(recepientTxtNtvApp, data);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(attachBtn);
			Thread.sleep(5000);
			Utils.uBase.clickAndroidelement(video);
			Thread.sleep(2000);
			/*
			 * Utils.uBase.clickAndroidelement(folder); Thread.sleep(2000);
			 */
			Utils.uBase.clickAndroidelement(videoSelect);
			Thread.sleep(2000);
			Utils.uBase.clickAndroidelement(sendBtn);
			Thread.sleep(6000);
			if(Utils.uBase.mDriver!=null) {
				Utils.uBase.mDriver.quit();}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
}


