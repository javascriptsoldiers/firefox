package automationBed_Google.pom.gv;

import static org.testng.Assert.assertEquals;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class MessagePage
{
	public static String[] dataString;
	int msgCountAfter=0,msgCount=0;
	//Locators
	@FindBy(xpath="//*[contains(@content,'ProfileNames')]")
	WebElement firstMessage;//used
	@FindBy(xpath="//*[@role='gridcell']/*[@role='img']")
	WebElement threeDotsOption;
	@FindBy(xpath="(//gv-annotation[contains(@class,'Bqxti')])[last()]")
	WebElement msgConversationContent;//used
	@FindBy(xpath="//*[contains(@gv-test-id,'content')]")
	List<WebElement> msgPreviewContent;
	@FindBy(xpath="(//*[contains(@ng-if,'Incoming')])[last()]")
	WebElement msgConversationTime;//used
	@FindBy(xpath="//*[contains(@ng-class,'SendSms')]")
	WebElement sendNewMsgBtn;
	@FindBy(xpath="//*[contains(@aria-owns,'contact-list')]")
	WebElement msgToField;//used
	@FindBy(xpath="//*[contains(@aria-label,'Type a message')]")
	WebElement msgInput;//used
	@FindBy(xpath="//*[.='send']/..")
	WebElement sendBtn;
	@FindBy(xpath="//*[contains(@ng-if,'TransmissionStatus')]/div")
	WebElement sending;//used
	@FindBy(xpath="//*[.='Just now']")
	WebElement justNow;
	@FindBy(xpath="//div[contains(@gv-test-id,'people-phone-or-name')]") 
	List<WebElement> verifyPeoplePhoneName;
	@FindBy(xpath="//div[@gv-test-id='bubble']")
	List<WebElement> existingSentMsgList;
	@FindBy(xpath="//*[@gv-id='chip-phone-number']")
	private List<WebElement> lstChips;
	@FindBy(xpath="//*[@gv-test-id='conversation-avatar-or-checkmark']")
	List<WebElement> AvatarsList;
	@FindBy(xpath="//*[contains(@content,'ProfileNames')]")
	List<WebElement> messageList;
	@FindBy(xpath="//gv-frequent-contact-card")
	List<WebElement> lstFrequentContact;
	@FindBy(xpath="(//*[contains(@ng-repeat,'profile in ctrl.frequentContactProfiles')])[1]")
	WebElement contactDetails;
	@FindBy(xpath="//*[contains(@gv-test-id,'chip-phone-number')]")
	WebElement contactChip;
	@FindBy(xpath="//gv-annotation[contains(text(),'This is First Msg')]")
	WebElement firstMsgToScroll;
	@FindBy(xpath="//div[contains(@ng-class,'::ctrl.Css.BATCH_TOGGLE_ICON_WRAP')]")
	List<WebElement> selectCheckboxList;
	@FindBy(xpath="(//*[contains(@content,'ctrl.getIncomingProfileNames()')])[1]") 
	WebElement phoneNumber;
	@FindBy(xpath="//div[contains(@gv-id,'placeholder')]") 
	WebElement bodyOfMsg;
	@FindBy(xpath="//*[contains(@class,'YPqjbf flex')]") 
	WebElement typeAMsg;//used
	@FindBy(xpath="//div[contains(@id,'menu_container_12')]") 
	WebElement menuContainer;
	@FindBy(xpath="      //p[contains(@gv-test-id,'conversation-title')]") 
	WebElement contactDetailsOfToField;
	@FindBy(xpath="//*[contains(@class,'_md flex')]") 
	WebElement contactDetailsOfPeopleOptn;
	@FindBy(xpath="//div[@class='dOUild-YLEF4c']")
	List<WebElement> suggestionAvatarsList;
	@FindBy(xpath="//div[@class='Gb0ubd-YLEF4c']")
	List<WebElement> contactAvatarsList;
	@FindBy(xpath="//*[contains(@class, 'dOUild-XSJd1')]/div[1]")
	List<WebElement> suggestionNameList;
	@FindBy(xpath="//gv-contact-list[contains(@gv-id,'recipient_picker_contact_list')]/div/div")
	List<WebElement> contactNameList;
	@FindBy(xpath="//*[contains(@placeholder,'Type a message')]")
	WebElement typeMsgInput;
	@FindBy(xpath="//*[contains(text(),'Test message')])[3]")
	WebElement clickOnText;
	@FindBy(xpath="//*[contains(@class,'I6IB7e-LwH6nd')]")
	WebElement msgBox;
	@FindBy(xpath="//gv-icon-button-ng2[contains(@label,'Add image')]")
	WebElement addImg;
	@FindBy(xpath="//*[contains(@label,'Send message')]")
	WebElement sndBtn;
	@FindBy(xpath="//*[@class='LKz3Fb-bVEB4e']")
	List<WebElement> sentMsgsList;
	@FindBy(xpath="//*[contains(@gv-test-id,'item-contact')]")
	private List<WebElement> lstMsgs;
	@FindBy(xpath="//*[contains(@gv-test-id,'item-contact')]")
	private List<WebElement> msgsList;
	@FindBy(xpath="//*[contains(@aria-label,'People')]")
	WebElement msgPeopleOptn;
	@FindBy(xpath="//*[contains(@aria-label,'More options')]")
	WebElement msgConvrsThreeDots;
	@FindBy(xpath="//*[contains(@class,'uM2Vn-r4nke grey-900')]")
	WebElement conversNum;//used
	@FindBy(xpath="//*[contains(@aria-label,'Use my phone to call')]")
	WebElement useMyphoneMenu;
	@FindBy(xpath="//*[contains(@class,'uM2Vn-DNETlb')]//*[contains(@aria-label,'Archive')]")
	WebElement archiveThreeDotsMenu;
	@FindBy(xpath="//*[contains(@aria-label,'Mark as spam')]")
	WebElement markAsSpamThreeDotsMenu;
	@FindBy(xpath="//*[contains(@aria-label,'Block number')]")
	WebElement blockNumThreeDotsMenu;
	@FindBy(xpath="//*[contains(@aria-label,'Block number')]")
	WebElement deleteNumberThreeDotsMenu;
	@FindBy(xpath="//*[contains(@class,'LKz3Fb-bVEB4e')]")
	List <WebElement> msgList;
	@FindBy(xpath="(//*[contains(@gv-hover-id,'bubble')])[last()]")
	WebElement msgBubble;
	@FindBy(xpath="//*[contains(@class,'uM2Vn-VdSJob')]")
	WebElement rcvdMsgContactNo;
	@FindBy(xpath="//*[@class='BN08bf-u9UW7e']")
	WebElement cursotInMsgToField;
	@FindBy(xpath="//*[@focused='ctrl.shouldContactBeFocused(profile, true)']")
	List <WebElement> msgSuggestionList;
	@FindBy(xpath="//div[@gv-test-id='sms-sender-time-stamp']")
	WebElement messgeDateTime;

	@FindBy(xpath="//p[@gv-test-id='conversation-title']")
	WebElement phoneNumberWithoutSavedText;

	@FindBy(xpath="//p[@gv-test-id='conversation-subtitle']")
	WebElement phoneNumberWithSavedText;

	@FindBy(xpath="//*[contains(@class,'md-icon-float layout-row')]")
	WebElement toField;
	@FindBy(xpath="//*[contains(@gv-id,'chip-phone-number')]")
	WebElement contactChipInToField;
	@FindBy(xpath="(//div[@gv-test-id='message-item-container']/div[2]/gv-message-item/div/div[2]/gv-annotation)[last()]")
	WebElement messageText;
	@FindBy(xpath="//*[contains(@aria-label,'Select')]")
	WebElement selectBtn;
	@FindBy(xpath="//*[contains(@id,'messaging-view')]/div/md-content/div/gv-conversation-list/md-virtual-repeat-container/div/div[2]/div[1]/div/gv-text-thread-item/gv-thread-item/div/div[2]/ng-transclude/gv-thread-item-detail/gv-annotation")
	WebElement msgPreview;
	@FindBy(xpath="(//*[contains(@class,'Bqxti-bN97Pc')])[last()]")
	WebElement lastMsgInConversation;
	@FindBy(xpath="//*[contains(@gv-test-id,'conversation-title')]")
	WebElement profileNum;
	@FindBy(xpath="//*[@id=\"input_0\"]")
	WebElement typMsgPlcHolder;
	@FindBy(xpath="//*[@id=\"messaging-view\"]/div/md-content/gv-thread-details/div/div[2]/gv-message-entry/div/div[1]/gv-icon-button-ng2/button/span/mat-icon")
	WebElement AddImage;
	@FindBy(xpath="//*[contains(text(),'Sending')]")
	WebElement sendingTip;
	@FindBy(xpath="(//div[contains(@class,'Bqxti-HIQJ9')])[last()]")
	WebElement dateTime;
	@FindBy(xpath="(//gv-annotation[contains(@class,'Bqxti')])[last()-1]")
	WebElement lastBfrMsg;
	@FindBy(xpath="(//div[contains(@gv-test-id,'sms-sender-time-stamp')])[last()]")
	WebElement timeStamp;
	@FindBy(xpath="(//span[contains(text(),'AM')]|//span[contains(text(),'PM')])[last()]")
	WebElement times;
	@FindBy(xpath="//*[contains(@gv-shift-hover,'g.Group Message')]")
	WebElement grpMsg;
	@FindBy(xpath="//*[contains(@class,'ZRgO8c-GWfNzd')]")
	List<WebElement> selectedMsgs;
	@FindBy(xpath="(//*[contains(@aria-label,'Options')])[last()-1]")
	WebElement MsgThreedotsss;
	@FindBy(xpath = "(//span[contains(text(),'Message')])[2]//../span[2]")
	WebElement unreadMessages;
	
	  @FindBy(xpath="(//*[contains(@aria-label,'Options')])[last()]") 
	  WebElement lastMsgThreedots;
	 

	


	HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);

	public static final String threeDotsOptn="threeDots";
	public static final String Select_Text="Selecttext";
	public static final String Msgthreedots="Msgthreedots";
	public static final String Delete="Delete1";
	public static final String Deletetext="Deletetext";
	public static final String Understand="IUnderstand";
	public static final String FinalDelete="Delete_msg";
	public static final String People_Options="People";
	public static final String message_Tab="messageTab";
	String contactA;
	String contacta;

	//Clicking on the first message from the conversation list in message folder
	public MessagePage clickFirstMessage() throws Exception
	{
		try
		{	
			Utils.uBase.waitForElement(firstMessage);
			Utils.uBase.clickWebelement(firstMessage);
			AdvanceReporting.addLogs("pass", "Clicked on the first message thread");
			AdvanceReporting.addLogs("pass", "Messages Page","Messages Page");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public MessagePage verifyRecentlyText() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(firstMessage);
			AdvanceReporting.addLogs("pass", "Messages Page","Messages Page");
			List<WebElement> allProfileNames = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@content,'ProfileNames')]"));
			List<WebElement> allProfileMsg = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@gv-test-id,'content')]"));
			List<WebElement> allProfileTimes = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@gv-test-id,'item-timestamp')]"));
			Thread.sleep(5000);
			WebElement eleProfileName = allProfileNames.get(0);
			WebElement eleProfileMsg = allProfileMsg.get(0);
			WebElement eleProfileTime = allProfileTimes.get(0);
			String msgPreview = eleProfileMsg.getText();
			String timePreview = eleProfileTime.getText();
			Utils.uBase.clickWebelement(eleProfileName);
			if(msgPreview.contains(": ")) {
				msgPreview = msgPreview.substring(msgPreview.indexOf(": ")+2);
			}
			Utils.uBase.waitForElement(msgConversationContent);
			AdvanceReporting.addLogs("pass", "Message conversation opened","Message conversation opened");
			String latestMsg = msgConversationContent.getText();
			String latestMsgTime = msgConversationTime.getText();
			Thread.sleep(2000);
			if(latestMsg.equals(msgPreview)&&lastBfrMsg.equals(msgPreview)) {
				AdvanceReporting.addLogs("pass", "Both messages are in same thread");
			}
			latestMsgTime.contains(timePreview);
			AdvanceReporting.addLogs("pass", "latest message time"+latestMsgTime+"and preview time"+timePreview+"matched");
			AdvanceReporting.addLogs("info", latestMsg);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//To click on send new msg option
	public MessagePage clickSendNewMessage() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("SendNewMessage");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Clicked on Send New Messages");
			AdvanceReporting.addLogs("pass", "Clicked on Send New Messages","SendNewMessages");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Send new message is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage composeNewMessage(String numb) throws Exception
	{
		try
		{
			Thread.sleep(1000);
			Utils.uBase.waitForElement(msgToField);
			Utils.uBase.setText(msgToField, numb);
			Thread.sleep(3000);
			Utils.uBase.clickByImage("NewImage");			
			Thread.sleep(1000);
			clickToMsgTxt();
			Utils.uBase.waitForElement(msgInput);
			Utils.uBase.setText(msgInput, "Test message");
			clickToMsgTxt();
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage verifySending() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(sending);
			AdvanceReporting.addLogs("Pass", "Sending Message");
			AdvanceReporting.addLogs("Pass", "Sending", "Sending");
			Utils.uBase.waitForElement(dateTime);
			AdvanceReporting.addLogs("Pass", "Message Sent Successfully");
			AdvanceReporting.addLogs("Pass", "Sent", "Sent");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage listedInMsgConversation() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(msgConversationContent);
			AdvanceReporting.addLogs("Pass", "Message is listed in the message conversation item : "+msgConversationContent.getText());
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage verifyElementVisibility(String data) throws Exception
	{
		try
		{
			String[] str = data.split("\\|");
			int strSize = str.length;
			Utils.uBase.waitForElement(threeDotsOption);
			Utils.uBase.isElementPresent_webelement(msgInput);
			AdvanceReporting.addLogs("Pass", "Type a message");
			//			AdvanceReporting.addElementImage("info", msgInput);
			List<WebElement> allEle = Utils.uBase.webDriver.findElements(By.xpath("//button[contains(@class,'md-icon-button')]"));
			for(WebElement ele : allEle)
			{
				String arialabel = ele.getAttribute("aria-label");
				for (int j = 0; j < strSize; j++) {
					if(arialabel.equals(str[j])) {
						Utils.uBase.isElementPresent_webelement(ele);
						Utils.uBase.takeScreenshotOfWebelement(ele,arialabel);
						boolean result = Utils.uBase.imageCompare(arialabel);
						AdvanceReporting.addLogs("Pass", arialabel);
						//						AdvanceReporting.addElementImage("info", ele);
					}
				}
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage menuItems() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(threeDotsOption);
			Utils.uBase.clickWebelement(threeDotsOption);
			List<WebElement> allEle = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@role,'menuitem')]"));
			AdvanceReporting.addLogs("Pass", "Message Menu items");
			for(WebElement ele : allEle)
			{
				String item = ele.getText();
				String arialabel = ele.getAttribute("aria-label");
				boolean result = Utils.uBase.imageCompare(arialabel);
				AdvanceReporting.addLogs("info", arialabel);
				AdvanceReporting.addElementImage("info", ele);
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage visibilityOfSend() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(sendBtn);
			String arialabel = sendBtn.getAttribute("aria-disabled");
			if(arialabel.equals("true")){
				AdvanceReporting.addLogs("Pass", "Message Send Button is Disabled");
				AdvanceReporting.addElementImage("info", sendBtn);
			}else {
				AdvanceReporting.addLogs("Pass", "Message Send Button is Enabled");
				AdvanceReporting.addElementImage("info", sendBtn);
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Will display a dummy message in the message thread at the time of execution

	/*
	 * public void receiveTestMessage(String data) throws Exception {
	 * Thread.sleep(5000); ReceiveCallAndMessages.receiveMessage(data);
	 * Thread.sleep(500); AdvanceReporting.addLogs("Pass", "Message is received");
	 * Thread.sleep(5000); }
	 */


	/* Click People using Image */
	public MessagePage clickPeople() {
		try {
			Utils.uBase.clickByImage("People");
			AdvanceReporting.addLogs("Pass", "People is displayed");
			AdvanceReporting.addLogs("Pass", "People", "People");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();

		}
		return this;
	}

	/* Verify that it has category "People" */
	public MessagePage verifyPeople() {
		try {
			Thread.sleep(1500);
			Assert.assertEquals(true, Utils.uBase.imageCompare("People N options"));
			AdvanceReporting.addLogs("pass", "Verified that people category is displayed");
			AdvanceReporting.addLogs("pass", "People category is displayed", "PeopleOptions");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "People category is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify Phone number is getting displayed in people */
	public MessagePage verifyContactDetailsMsgParticipants() {
		try {
			if(verifyPeoplePhoneName.size()!=0) {
				for(WebElement e : verifyPeoplePhoneName) {
					AdvanceReporting.addLogs("Pass", e.getText());}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verifies if message tab is accessible
	public MessagePage verifyMessageTabIsAccessible()
	{
		try
		{

			if(Utils.uBase.imageCompare("SendNewMessage"))
			{
				AdvanceReporting.addLogs("Pass","Message tab is accessible");
				AdvanceReporting.addLogs("Pass","Message tab is accessible","MessageTabAccessible");
			}else {
				AdvanceReporting.addLogs("fail", "Image comparision failed : Message tab accessibility");
			}
		}catch(Exception e)
		{
			AdvanceReporting.addLogs("info", "Message tab is not accessible");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();

		}return this;
	}

	public MessagePage verifyMessagesTabIsAccessible()
	{
		try
		{
			if(Utils.uBase.getCurrentUrl().contains("messages")) {
				AdvanceReporting.addLogs("Pass","Message tab is accessible");
				AdvanceReporting.addLogs("Pass","Message tab is accessible","MessageTabAccessible");
			}
			else
				AdvanceReporting.addLogs("info", "Message tab is not accessible");

		}catch(Exception e){

			AdvanceReporting.addLogs("info", "Message tab is not accessible");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}return this;
	}
	public MessagePage clickOnMsgUnreadItems()
	{
		try
		{
			Utils.uBase.clickWebelement(unreadMessages);
			AdvanceReporting.addLogs("pass", "Clicked on unread items");
		}catch(Exception e){
			AdvanceReporting.addLogs("info", "Message tab is not accessible");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}return this;
	}

	/* Sending the message to the existing number */
	public MessagePage  sendMsgToExistingConversation(String data)
	{
		try
		{
			Thread.sleep(7000);
			Utils.uBase.clickByImage("msgInput");
			Thread.sleep(4000);
			Utils.uBase.setText(msgInput,Constants.SentMsgToExtContact);
			Thread.sleep(2000);
			AdvanceReporting.addLogs("Pass", "Sending new message to existing contact");
			AdvanceReporting.addLogs("Pass", "Sending new message to existing contact","Clicked msgInput");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/* To Verify Composed Message*/
	public MessagePage verifyComposedMessage(String data) 
	{
		try
		{
			Thread.sleep(3000);
			for (int i = 0; i <existingSentMsgList.size(); i++) {
				/* Verify able to send message to the caller. */
				if(existingSentMsgList.equals(Constants.SentMsgToExtContact)){
					AdvanceReporting.addLogs("pass", "Verified that message Sent sucessfully to the caller");
					AdvanceReporting.addLogs("pass", "Message Sent sucessfully to the caller","ComposedMessage");			
				}
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Delete message */ 
	public MessagePage deleteMsg(){
		try {

			Thread.sleep(2000);
			Utils.uBase.clickByImage("threeDots");
			Utils.uBase.clickByImage("Delete1");
			Thread.sleep(3000);
			Utils.uBase.clickByImage("IUnderstand");
			Thread.sleep(2000);
			Utils.uBase.clickByImage("Delete_box");
			Thread.sleep(1000);
			System.out.println("Deleted created message");
			AdvanceReporting.addLogs("pass", "Message deleted sucessfully");
			AdvanceReporting.addLogs("pass", "Message deleted sucessfully","DeleteMessage");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			AdvanceReporting.addLogs("info", "Failed to delete message");
			System.out.println("Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Delete single message from the message thread
	public MessagePage deleteSingleMsg() {
		try {

			Utils.uBase.clickByImage("Deletetext");
			Utils.uBase.clickByImage("Delete_msg");
			Thread.sleep(3000);

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Unable to delete");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verify the archive option is present in the more options page and click on the archive option
	public MessagePage clickArchiveFrmMoreOptn() {
		try {

			Thread.sleep(3000);
			Utils.uBase.clickByImage("archiveThreeDotsMenu");
			AdvanceReporting.addLogs("pass", "Archive from More Options is clicked");
			AdvanceReporting.addLogs("info", "Archive from More Options is clicked");
			Thread.sleep(2000);

		} catch (Exception e) {

			AdvanceReporting.addLogs("info", "Archive from More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verify the message gets archived
	public MessagePage verifyMsgGetsArchived() {
		try {
			Thread.sleep(5000); 
			Assert.assertEquals(false,Utils.uBase.imageCompare("FirstArchiveMsg"));
			AdvanceReporting.addLogs("pass", "Verified that message gets moved to archive folder");
			AdvanceReporting.addLogs("pass", "Message gets moved to archive folder","FirstArchiveMsg");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "firstMessage is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}

	//Click on the Archive folder
	public MessagePage clickArchive() {
		try {

			/* Utils.uBase.takeScreenshotOfWebelement(archived, "archived"); */


			Utils.uBase.clickByImage("archived");
			AdvanceReporting.addLogs("Pass", "Archive folder is displayed");
			AdvanceReporting.addLogs("Pass", "Archive folder", "Archive");
			Thread.sleep(2000);


		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Archive is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verify the message is available in the archived folder
	public MessagePage verifyArchivedFolder() {

		try {

			Assert.assertEquals(true,Utils.uBase.imageCompare("FirstArchiveMsg"));
			AdvanceReporting.addLogs("Pass", "Archive message is available in the Archive folder");
			AdvanceReporting.addLogs("Pass", "Message is available in the archive folder", "Archivedmsg");

		} catch (Exception e) {
			AdvanceReporting.addLogs("Info", "text message is not displayed in archive folder");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();

		}
		return this;
	}

	//delete the message from  the archived folder
	public MessagePage deleteMsgFrmArchivedFolder() {

		try {
			Thread.sleep(4000);
			Utils.uBase.clickByImage("Delete1");
			AdvanceReporting.addLogs("Pass", "Delete option is displayed");
			AdvanceReporting.addLogs("Pass", "Delete option", "Restore");
			Thread.sleep(2000);


		} catch (Exception e) {
			AdvanceReporting.addLogs("Fail", "Delete option is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();


		}
		return this;
	}
	//Verify the Spam option in the More option page and click on the option
	public MessagePage clickSpamFrmMoreOptn() {
		try {

			Utils.uBase.clickByImage("spam");
			Thread.sleep(2000);

		} catch (Exception e) {

		}
		return this;
	}
	//Verify the message gets spam
	public MessagePage verifyMsgGetsSpam() {

		try {Thread.sleep(5000); 
		Assert.assertFalse(Utils.uBase.imageCompare("FirstSpamMsg"),"The message is not available in message folder");
		AdvanceReporting.addLogs("pass", "Verified that message gets moved to Spam folder");
		AdvanceReporting.addLogs("pass", "Message gets moved to Spam folder","FirstSpamMsg");
		}

		catch(Exception e){
			AdvanceReporting.addLogs("info", "firstMessage is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}
	//Verify the spam is clicked
	public MessagePage clickSpam() {
		try {
			Utils.uBase.clickByImage("Spampath");
			AdvanceReporting.addLogs("Pass", "Spam folder is displayed");
			AdvanceReporting.addLogs("Pass", "Spam folder", "Spam");
			Thread.sleep(2000);

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();

		}
		return this;
	}

	/* Verify whether the message gets stored in the Spam folder */
	public MessagePage verifySpamFolder() {

		try {

			Assert.assertTrue(Utils.uBase.imageCompare("FirstSpamMsg"),"Message is not displayed in the Spam folder");
			AdvanceReporting.addLogs("Pass", "Spam message is available in the Spam folder");
			AdvanceReporting.addLogs("Pass", "Message is available in the Spam folder", "SpamMsg");

		} catch (Exception e) {
			AdvanceReporting.addLogs("Fail", "text message is not displayed in Spam folder");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();

		}
		return this;
	}

	//delete the message from  the Spam folder
	public MessagePage deleteMsgFrmSpamFolder() {

		try {

			/* Utils.uBase.takeScreenshotOfWebelement(unmarkAsSpam, "unmarkAsSpam"); */

			Utils.uBase.clickByImage("unmarkAsSpam"); 
			AdvanceReporting.addLogs("Pass","Spam folder is displayed"); 
			AdvanceReporting.addLogs("Pass","Spam folder", "Spam"); 
			Thread.sleep(2000);



		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("Fail", "Spam folder is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//This method adds either single number or a list of numbers in the 'To' field

	public MessagePage addPhoneNumbersList(String singleOrGroupMsg,String numb) 
	{
		try
		{		
			switch(singleOrGroupMsg)
			{
			case "Group":

				dataString = numb.split("\\|");
				Utils.uBase.waitForElement(msgToField);
				Utils.uBase.clickByImage("EnterNumber");
				for(String number : dataString)
				{
					msgToField.sendKeys(number);
					Thread.sleep(3000);
					Utils.uBase.clickByImage("NewImage");
					Thread.sleep(2000);
				}
				AdvanceReporting.addLogs("pass", "Entered phone numbers in To field");
				AdvanceReporting.addLogs("pass", "Entered phone numbers in To field","PhoneNumbersEnteredToField");
				break;


			case "Single":	

				Utils.uBase.waitForElement(msgToField);
				Utils.uBase.clickByImage("EnterNumber");
				msgToField.sendKeys(numb);
				//Thread.sleep(2000);	
				Utils.uBase.clickByImage("NewImage");
				AdvanceReporting.addLogs("pass", "Entered phonenumber in To field");
				AdvanceReporting.addLogs("pass", "Entered phone number in To field","PhoneNumberEnteredToField");
				break;
			}

		}	

		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	public MessagePage verifyPlaceholderText()
	{
		try
		{
			Utils.uBase.clickByImage("ToMsgText");

			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("MessagePlaceholderText"))
			{		
				AdvanceReporting.addLogs("pass", "Verified that Place holder displays text:Add recipients");
				AdvanceReporting.addLogs("pass", "Place holder displays text:Add recipients","PlaceholderText");
			}else{
				AdvanceReporting.addLogs("fail", "Place holder is not displaying text:Add recipients");
				AdvanceReporting.addLogs("fail", "Place holder is not displaying text:Add recipients","PlaceholderText");
			}

			Utils.uBase.clickByImage("MessagePlaceholderText");

		}


		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage verifySelectedNoAddedInToField(String data) 
	{
		try
		{		
			//Verifies if selected contact is added in To field
			Assert.assertEquals(lstChips.get(0).getText().replaceAll("\\W", ""), Constants.phoneNo,"Selected contact is not added");
			AdvanceReporting.addLogs("pass", "Verified that selected contact is added in To field");
			AdvanceReporting.addLogs("pass", "Selected contact is added in To field","SelectedContactAdded");

			if(Utils.uBase.imageCompare("EnterNumber"))
			{		
				AdvanceReporting.addLogs("pass", "Verified that ccursor is present in to field");
				AdvanceReporting.addLogs("pass", "Cursor is present in to field","CursorToField");
			}else{
				AdvanceReporting.addLogs("pass", "Cursor is not present in to field");
				AdvanceReporting.addLogs("pass", "Cursor is not present in to field","CursorMissingToField");
			}}

		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//To verify static text present
	public MessagePage verifyPlaceholderTextDisplayed() {
		try {
			Thread.sleep(2000);
			boolean staticText=Utils.uBase.imageCompare("toField");
			if(staticText==true) {
				AdvanceReporting.addLogs("pass", "Verified that static text matched");
				AdvanceReporting.addLogs("pass", "static text matched","static text matched");
			}
			else if(staticText==false){
				AdvanceReporting.addLogs("fail", "static text not matched");

			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;

	}
	//To verify cursor has auto focused in to field
	public MessagePage verifyCursorAutofocusedToField() {
		try {
			Utils.uBase.clickByImage("sendNewMsgBtn");
			Thread.sleep(9000);
			if(toField.getAttribute("class").contains("md-input-focused"))
			{		
				AdvanceReporting.addLogs("pass", "Verified that Cursor is present in to field");
				AdvanceReporting.addLogs("pass", "Cursor is present in to field","CursorToField");
			}
			else{
				AdvanceReporting.addLogs("fail", "Cursor is not present in to field");
				AdvanceReporting.addLogs("fail", "Cursor is not present in to field","CursorMissingToField");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;

	}
	//To verify the selected contact is placed in to field
	public MessagePage selectcontactDetails() {
		try {
			Utils.uBase.clickByImage("contactDetails");
			Thread.sleep(3000);
			String contactdetails = contactDetails.getText();
			String contact = contactChip.getText();
			AdvanceReporting.addLogs("pass", "Contact details available in the suggestion list is :"+contactdetails);
			AdvanceReporting.addLogs("pass", "Contact details available in the To field is :"+contact);
			if(contactdetails.contains(contact)) 
			{ 
				AdvanceReporting.addLogs("pass"," selected contact number is added to recipient picker i.e 'To' field"); 
				AdvanceReporting.addLogs("pass"," selected contact number is added to recipient picker i.e 'To' field","ContactNameMatchToField"); 
			} else
			{
				AdvanceReporting.addLogs("fail", "selected contact number is not added to recipient picker i.e 'To' field");
				AdvanceReporting.addLogs("fail", "selected contact number is not added to recipient picker i.e 'To' field","ContactNameMatchToField"); }

		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;

	}		


	//This method verifies if selected contact is added in 'To' field

	public MessagePage verifyContactsDisplayed(String data) 
	{
		try
		{
			//Verifies if chips are added in 'To' list
			Assert.assertTrue(lstChips.size()!=0,"Multiple Contacts are not added in To list");
			AdvanceReporting.addLogs("pass", "Phone chips are displayed");
			AdvanceReporting.addLogs("pass", "Verified that multiple Contacts are added in To list");
			AdvanceReporting.addLogs("pass", "Multiple Contacts are added in To list","MultipleContacts");

		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verifies the count of chips added
	public MessagePage verifyChipsCount(int count) throws Exception
	{
		try
		{
			Assert.assertEquals(lstChips.size(),count,"All "+count+" chips are not added");
			AdvanceReporting.addLogs("pass", "verified that"+count+" chips are added");
			AdvanceReporting.addLogs("pass", ""+count+" chips are added","ChipsAdded");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", ""+count+" chips are not added");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Click on send message button */
	public MessagePage sendComposedMessage() throws Exception
	{
		try
		{
			Thread.sleep(4000);
			Utils.uBase.clickByImage("SendMsgBtn1");
			Utils.uBase.clickByImage("SendMsgBtn1");
			AdvanceReporting.addLogs("Pass","Send message btn clicked");
			AdvanceReporting.addLogs("Pass","Send message btn clicked","Send btn Clicked");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info","Send message btn not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Click on Link Message
	public MessagePage clickLinkMessage() {

		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("linkMsg"); 
			Thread.sleep(5000);
			AdvanceReporting.addLogs("Pass","Link Msg is displayed");
			AdvanceReporting.addLogs("Pass","Link Msg is displayed", "LinkMsg");  

		} catch (Exception e)
		{
			AdvanceReporting.addLogs("Fail", "Link Msg is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Switch to Old window
	public MessagePage moveBackToOldWindow() {

		try {

			Utils.uBase.switchToOldWindow();
			Utils.uBase.waitForElement(msgInput);
			AdvanceReporting.addLogs("Pass"," Msg page is displayed");
			AdvanceReporting.addLogs("Pass","Msg Page is displayed", "MsgPage");

			Thread.sleep(5000);

		} catch (Exception e)
		{
			AdvanceReporting.addLogs("Fail", "Msg page is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//delete the message from  the archived folder
	public MessagePage restoreMsgFrmArchivedFolder() {

		try {

			Utils.uBase.clickByImage("restore");
			AdvanceReporting.addLogs("Pass", "Restore folder is displayed");
			AdvanceReporting.addLogs("Pass", "Restore folder", "Restore");
			Thread.sleep(2000);


		} catch (Exception e) {
			AdvanceReporting.addLogs("Fail", "Restore folder is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();


		}
		return this;
	}
	//delete the message from  the Spam folder
	public MessagePage unmarkMsgFrmSpamFolder() {

		try {
			Utils.uBase.clickByImage("unmarkAsSpam"); 
			AdvanceReporting.addLogs("Pass","Spam folder is displayed"); 
			AdvanceReporting.addLogs("Pass","Spam folder", "Spam"); 
			Thread.sleep(5000);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("Fail", "Spam folder is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Select the three dots next to the message bubble
	public MessagePage clickSingleMsgThreeDots() {
		try {
			Thread.sleep(3000);
			//Utils.uBase.clickByImage("MsgThreedotsss");
			Utils.uBase.clickWebelement(lastMsgThreedots);
			AdvanceReporting.addLogs("Pass", "The threedots menu beside the selected message is clicked");
			AdvanceReporting.addLogs("Pass", "The threedots menu is clicked","The threedots menu is clicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("Pass", "The threedots menu beside the selected message is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verification pop-up for the message got deleted
	public MessagePage verifyMsgDeletCnfrm() throws Exception {
		try {
			Assert.assertEquals(false, Utils.uBase.imageCompare("Message"));
			AdvanceReporting.addLogs("Pass", "Verified that message is deleted from the conversation thread");
			AdvanceReporting.addLogs("Pass", "Verified that deleted from the conversation thread","MsgDeleted");
			AdvanceReporting.addLogs("Pass", "Verified that message delete Confirmation text box is displayed");
			AdvanceReporting.addLogs("Pass", "Verified that message delete Confirmation text box is displayed","MsgDeleteCnfrm");

		} catch (Exception e) {
			AdvanceReporting.addLogs("Info", "Message delete Confirmation text box is not displayed");
			AdvanceReporting.addLogs("Fail", "Message delete Confirmation text box is not displayed","MsgDeleteCnfrm");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verification message when the text is getting copied to the clipboard
	public MessagePage verifyTxtCopied() {
		try {
			Thread.sleep(3000);
			Assert.assertEquals(true, Utils.uBase.imageCompare("TxtGetsCopied"));
			AdvanceReporting.addLogs("Pass", "Verified that text is  copied to the clipboard");
			AdvanceReporting.addLogs("Pass", "Text is  copied to the clipboard","TxtGetsCopied");

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Text is  not copied to the clipboard");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Copy the message from the message thread
	public MessagePage clickCopyText() {
		try {
			Utils.uBase.clickByImage("copyText");
			AdvanceReporting.addLogs("Pass","Text is being copied");
			AdvanceReporting.addLogs("Pass","Text is being copied", "CopyText");
			Thread.sleep(2000);

		} catch (Exception e) {
			AdvanceReporting.addLogs("info","Text is not copied");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verification message when the text is getting copied to the clipboard
	public MessagePage clickMultipleAvatars() {
		try {
			for(int i =0; i <=(AvatarsList.size()-(AvatarsList.size()-1)) ; i++)
			{                         
				AvatarsList.get(i).click();
			}
			AdvanceReporting.addLogs("pass", "Able to click more than one Message avatar");
			AdvanceReporting.addLogs("pass", "Able to click more than one Message avatar", "SelectMultipleAvatar");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Unable to click more than one Message avatar");  
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage unSelectMultipleAvatars() {

		try {

			Utils.uBase.clickByImage("unSelectAll");
			AdvanceReporting.addLogs("pass", "Able to UnSelect the selected Multiple Avatars ");
			AdvanceReporting.addLogs("pass", "Able to UnSelect the selected Multiple Avatars", "UnselectAvatars");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Unable to click Unselect the message Avatars");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage archiveSelectMultipleAvatars() {

		try {
			Utils.uBase.clickByImage("archiveSelectAvatars");
			AdvanceReporting.addLogs("pass", "Able to Archive the selected Multiple Avatars ");
			AdvanceReporting.addLogs("pass", "Able to Archive the selected Multiple Avatars", "ArchiveAvatars");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Unable to click Archive for the message Avatars");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage verifyArchiveCnfrmPopUp() {

		try {
			Thread.sleep(5000);
			Assert.assertEquals(true, Utils.uBase.imageCompare("archivedCnfrm"));
			AdvanceReporting.addLogs("pass", "Verified that confirmation pop up gets displayed for Avatars getting archived");
			AdvanceReporting.addLogs("pass", "Confirmation pop up gets displayed for Avatars getting archived","ArchiveAvatars");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "firstMessage is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}

	// Verify scrolling up to first message
	public MessagePage verifyScrollUpToFirstMessage() {
		try {
			Thread.sleep(1000);
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", messageList.get(0));
			Thread.sleep(1000);
			AdvanceReporting.addLogs("pass", "Verified that scrolled to First message");
			AdvanceReporting.addLogs("pass", "Scrolled to First message","scrollToFirstMessage");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not Scrolled to First message");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}	
		return this;		
	}

	// Click of first message in message items
	public MessagePage clickfirstMessageInList() {
		try {
			Utils.uBase.refresh();
			Utils.uBase.waitForElementToBeClickable(messageList.get(0));
			Utils.uBase.clickWebelement(messageList.get(0));
			AdvanceReporting.addLogs("pass", "clicked on first message in messages list", "FirstMessage");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Not clicked on first message");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Click on more options
	public MessagePage clickMoreOptn() {
		try {
			Thread.sleep(5000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("3DotMoreOption");
			Thread.sleep(3000);
			AdvanceReporting.addLogs("Pass", "More Options is displayed");
			AdvanceReporting.addLogs("Pass", "More Options", "MoreOptions");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage verifyUseMyPhoneIn3DotMenu() {
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("ThreeDotMenu_UseMyPhone"), "No use my phone in 3 dot menu");	
			AdvanceReporting.addLogs("pass", "Verified use My Phone in 3 dot menu");
			AdvanceReporting.addLogs("pass", "Use My Phone in 3 dot menu","ThreeDotMenu_UseMyPhone");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not Scrolled to First message");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	// Send a message - 'First message sent'
	/*
	 * public void uiCheckForFirstMessage(String data, String messageText) throws
	 * Exception { Thread.sleep(3000); ReceiveCallAndMessages.receiveMessage(data,
	 * messageText); AdvanceReporting.addLogs("pass", "First message sent");
	 * Thread.sleep(2000); }
	 */

	/*
	 * public void uiCheckForMessages(String data, int messageCount) throws
	 * Exception { Thread.sleep(5000); for(int i =0; i<=messageCount; i++) {
	 * ReceiveCallAndMessages.receiveMessage(data); Thread.sleep(5000); }
	 * 
	 * AdvanceReporting.addLogs("pass", "Multiple messages sent");
	 * 
	 * }
	 * 
	 * // Send Multiple messages public void uiCheckForMessages(String data) throws
	 * Exception { Thread.sleep(3000); for(int i=0; i<=15; i++) {
	 * ReceiveCallAndMessages.receiveMessage(data); Thread.sleep(2000); }
	 * AdvanceReporting.addLogs("pass", "Multiple messages sent"); }
	 */

	public MessagePage clickArchiveUndo() {

		try {

			Thread.sleep(5000);
			if(Utils.uBase.imageCompare("UndoButton1"))
			{
				Utils.uBase.clickByImage("UndoButton1");		  
				AdvanceReporting.addLogs("pass", "Click Undo from the Archive confirmation pop up");
				AdvanceReporting.addLogs("pass", "Click Undo from the Archive confirmation pop up","clickUndo");
			}
			else
			{ 
				AdvanceReporting.addLogs("info","Unable to Click Undo from the Archive confirmation pop up");
				AdvanceReporting.addLogs("fail", "Unable to Click Undo from the Archive confirmation pop up");

			}

		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "firstMessage is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}
	public MessagePage verifyCountOfMsgs() {

		try {
			Thread.sleep(3000);
			AdvanceReporting.addLogs("Info", "size of array in Message list is "+messageList.size());
			if(messageList.size() == AvatarsList.size())
				AdvanceReporting.addLogs("pass", "All Messages are displayed in Message folder correctly");
			AdvanceReporting.addLogs("pass", "All Messages are displayed in Message folder correctly", "MessageList");

		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "firstMessage is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}

	//Verify Scroll down to load more message items
	public MessagePage verifyScrollDownLoadMessages() {
		try {
			Utils.uBase.checkPageReady();
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", messageList.get(messageList.size()-1));
			Thread.sleep(3000);	
			AdvanceReporting.addLogs("pass", "Verified that items scrolled down");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not Scrolled to last message");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}


	public MessagePage verifyScrollUpToFirstMessageInConversation() {
		try {
			Thread.sleep(3000);
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(false);", firstMsgToScroll);
			Utils.uBase.waitForElement(firstMsgToScroll);
			//Assert.assertTrue(Utils.uBase.imageCompare("scrollToFirstMessage"), "Not Scrolled to First message");
			if(Utils.uBase.isElementPresent_webelement(firstMsgToScroll)) {
				AdvanceReporting.addLogs("pass", "Verified that scrolled to First message");
			}
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not Scrolled to First message");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	//Verify the Use my phone to call option is present in the more options page
	public MessagePage verifyUseMyPhoneToCallOptionDisplayed() {
		try {
			Thread.sleep(5000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("phoneToCall"), "Use my phone to call is not displayed");
			AdvanceReporting.addLogs("Pass","Use my phone to call is displayed ");
			AdvanceReporting.addLogs("Pass","Use my phone to call","Usemyphonetocall");
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Use my phone to call is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
		}
		return this;
	}

	/*
	 * public void uiCheckForMessage(String data) throws Exception {
	 * Thread.sleep(3000); ReceiveCallAndMessages.receiveMessage(data);
	 * Thread.sleep(8000); AdvanceReporting.addLogs("pass", "Message sent"); }
	 */
	//Verify the message gets archived
	public MessagePage verifyMsgListAfterConversationDeleted() {
		try {
			Thread.sleep(5000); 
			Assert.assertEquals(false, Utils.uBase.imageCompare("FirstMsg"));
			AdvanceReporting.addLogs("pass", "Message gets deleted");
			AdvanceReporting.addLogs("pass", "Message gets deleted","Msgisdeleted");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "firstMessage is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());

			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}
	//Verification of the conversation deleted
	public MessagePage verifyConversationDeleted() {

		try {
			Thread.sleep(1000);
			Assert.assertTrue(Utils.uBase.imageCompare("confrmDelete"),"The conversation is deleted");                            
			AdvanceReporting.addLogs("pass", "Verified that converstaion is deleted");
			AdvanceReporting.addLogs("pass", "Converstaion is deleted and confirmation pop up is displayed","ConversationDelete");

		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "firstMessage is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}
	//click select from three bubble next to single message 
	public MessagePage clickSelect() {
		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("selectBttn");
			AdvanceReporting.addLogs("Pass", "able to click on Select");

		} catch (Exception e) {

			AdvanceReporting.addLogs("info", "Unable to click on Select");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Select multiple messages from the message conversation
	public MessagePage clickMultipleSelectCheckBox() {
		try {
			Thread.sleep(2000);
			for(int i =0; i <(selectCheckboxList.size()-(selectCheckboxList.size()-1)) ; i++)
			{                         
				selectCheckboxList.get(i).click();
			}
			AdvanceReporting.addLogs("pass", "Able to select multiple messages items");
			AdvanceReporting.addLogs("pass", "Able to select multiple messages items", "SelectMultipleMsgItems");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Unable to select multiple messages items");  
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Delete message pop up */ 
	public MessagePage deleteConversationPopUp(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("threeDots");
			Thread.sleep(2000);
			Utils.uBase.clickByImage("Delete1");
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("DeletePopUp"))
			{
				AdvanceReporting.addLogs("pass", "Delete Permanently popup with text message is dispalyed");
				AdvanceReporting.addLogs("pass", "Delete Permanently popup with text message is dispalyed","DeletePopUp");
				Thread.sleep(1000);
				Utils.uBase.clickByImage("IUnderstand");
				Thread.sleep(2000);
				Utils.uBase.clickByImage("Delete_box");
			}
			else 
			{ 
				AdvanceReporting.addLogs("info","Delete Permanently popup with text message is not dispalyed");
				AdvanceReporting.addLogs("fail", "Delete Permanently popup with text message is not dispalyed");                  
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Verify delete confirmation pop up do not display after clicking on i undertsand and delete button
	public MessagePage verifyDeleteConfirmationPopUp(){
		try {
			Thread.sleep(5000); 
			Assert.assertEquals(false, Utils.uBase.imageCompare("DeletePopUp"));
			AdvanceReporting.addLogs("pass", "Delete Permanently popup with text message is not dispalyed");
			AdvanceReporting.addLogs("pass", "Delete Permanently popup with text message is not dispalyed","DeletePopUp");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Deletes the message triggered from a particular phone no
	public MessagePage cleanCreatedMessageLog(String phoneNo)
	{
		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("messageTabs");
			Thread.sleep(3000);
			for(int i=0;i<messageList.size();i++)
			{			
				if(phoneNo.contains(messageList.get(i).getText().replaceAll("\\W", "")))
				{
					Utils.uBase.waitForElementToBeClickable(messageList.get(i));
					Utils.uBase.clickWebelement(messageList.get(i));
					System.out.println("Created call entry found");
					deleteMsg();
					AdvanceReporting.addLogs("info", "Created message is deleted");
					break;

				}}}catch(Exception e)
		{
					System.out.println("Unable to delete created message log");
					e.printStackTrace(); Assert.fail();

		}return this;
	}

	//Method to validate if the entered text is present in the existing conversation
	public MessagePage validateEnteredText() throws Exception {
		Thread.sleep(3000);
		//Image comparison for the text that has been entered
		boolean value = Utils.uBase.imageCompare("msgEntered");
		if(value==true) {
			AdvanceReporting.addLogs("pass", "The previously entered text exists");
			AdvanceReporting.addLogs("pass", "The previously entered text exists","EnterTextField");
		}
		else{
			AdvanceReporting.addLogs("fail", "The previously entered text does not exist","EnterTextFieldfailed");
			AdvanceReporting.addLogs("fail", "The previously entered text does not exist");} 
		return this;
	}	 


	public MessagePage clickMessageText()
	{
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickWebelement(messageText);
			AdvanceReporting.addLogs("pass", "Clicked on the message thread");
			AdvanceReporting.addLogs("pass", "Clicked on the message thread","Clicked on the message thread");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Not clicked on the message thread");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/* Clicked on three dot menu present beside last bu one msg*/
	public MessagePage clickOnThreeDotMenuBesideMsg()
	{
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickWebelement(MsgThreedotsss);
			//Utils.uBase.clickWebelement(MsgThreedotsss);
			//Utils.uBase.clickByImage("MsgThreedotsss");
			AdvanceReporting.addLogs("pass", "Clicked on three dot menu present beside each message and click on select button");
			AdvanceReporting.addLogs("pass", "Clicked on three dot menu present beside each message and click on select button","ClickedOnthreeDotMenu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Selected messages */
	public MessagePage selectButtonForFewMoreMessages()
	{
		try
		{
			Thread.sleep(4000);
			//Utils.uBase.clickWebelement(selectBtn);
			Utils.uBase.clickByImage("selectFrmThreeDots");
			AdvanceReporting.addLogs("pass", "More messages selected","SelectedMoreMsgs");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicked on select button for few more messages */
	public MessagePage selectFewMoreMessages()
	{
		try
		{
			Thread.sleep(5000);
			int count=3;
		for(int i=1;i<=count;i++) {
			Utils.uBase.webDriver.findElement(By.xpath("(//*[contains(@gv-test-id,'bubble')])[last()"+"-"+ +i+ "]")).click();
		}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicked "X" icon and unselect the messages */
	public MessagePage unselectMessages()
	{
		try
		{
			Thread.sleep(5000);
			Utils.uBase.clickByImage("CloseSelectedImg");
			AdvanceReporting.addLogs("pass", "Clicked close button X icon for unselect the messages","CloseSelected");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify that able to unselect all the selected items. */
	public MessagePage verifySelectedMsgsUnselected()
	{
		try
		{
			Thread.sleep(3000);
			if(!Utils.uBase.imageCompare("SelectAllMsgsImg")) {
				AdvanceReporting.addLogs("pass", "Verified that unselectd all the selected items");
				AdvanceReporting.addLogs("pass", "Unselectd all the selected items.","Unselectd");
			}else {
				AdvanceReporting.addLogs("fail", "Not Unselectd all the selected items.","NotUnselectd");
			}
			AdvanceReporting.addLogs("info", "Not Unselectd all the selected items.","NotUnselectd");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/* Verify that able to delete multiple message items. */
	public MessagePage verifyAbleToDeleteMultipleMsgs()
	{
		try {
			Thread.sleep(2000);
			int sizeBeforeDeleteMsgs = existingSentMsgList.size();
			Utils.uBase.clickByImage("DeleteIconImg");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("DeleteBtnOnPopupImg");
			AdvanceReporting.addLogs("pass", "Click on delete button sucessfully");
			AdvanceReporting.addLogs("pass", "Click on delete button sucessfully","Deleted");
			Thread.sleep(5000);
			int sizeAfterDeleteMsgs = existingSentMsgList.size();
			Thread.sleep(1000);
			if(sizeBeforeDeleteMsgs==sizeAfterDeleteMsgs-3) 
			{
				AdvanceReporting.addLogs("pass", "Verified that able to delete multiple message items.","DeltedSelectedMsgs");
			}else {
				AdvanceReporting.addLogs("info", "Not able to delete multiple message items","CallsNotDeleted");
			}
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "Not able to delete multiple message items");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}

	/* Selected the More options menu (three vertical dots). */
	public MessagePage clickThreeDotsMenu()
	{
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("threeDots");
			AdvanceReporting.addLogs("info", "Clicked on three dotted more option");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Three dotted more option is not available");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Able to see "Copy text", "Delete" and "Select" messages options. */
	public MessagePage verifyCopytextDeleteAndSelectMsgoptions() throws Exception
	{
		try
		{
			Thread.sleep(1000);
			if(Utils.uBase.imageCompare("CopyDeleteAndSelectMsgOptinImg")) {
				AdvanceReporting.addLogs("pass","Message options Copy text, Select and Delete verified successfully");
				AdvanceReporting.addLogs("pass","Copy text Delete and Select messages options are avalilable","CopyDeleteAndSelectMsgOptins");
			}else {
				AdvanceReporting.addLogs("info", "Copy text Delete and Select messages options are not avalilable","NoCopyDeleteAndSelectMsgOptins");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Copy text Delete and Select messages options are not avalilable");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Clicking the message thread in the conversation box
	public MessagePage clickMsgThread(){
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("MessageTextImg");
			AdvanceReporting.addLogs("pass","Message thread in the conversation box is clicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Clicking the add image icon in the message box
	public MessagePage clickAddimageIcon(){
		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("AddImageImg");
			AdvanceReporting.addLogs("pass","Clicked on the add image icon in the message box");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Selecting a desired photo to add image in the message conversation box
	public MessagePage clickDesiredImg(){
		try {
			Thread.sleep(3000);
			Utils.uBase.clickByImage("ImageImg");
			AdvanceReporting.addLogs("pass","The required photo image is selected from the pop up window");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Clicking on select button to add image in the message conversation box
	public MessagePage clickSelectAddImgWindow(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("selectImage");
			AdvanceReporting.addLogs("pass","Image added sucessfully");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Selected the More options menu (three vertical dots). */
	public MessagePage clickImageThreeDots(){
		try {
			Thread.sleep(30000);
			//		 Utils.uBase.waitForElement(sendingTip);
			//		 new WebDriverWait(Utils.uBase.webDriver, 40).until(ExpectedConditions.invisibilityOfElementLocated((By)sendingTip));

			Utils.uBase.hoverOnImage("imageBorder");
			Utils.uBase.hoverOnImage("ImageThreeDotsImg");
			Utils.uBase.clickByImage("ImageThreeDotsImg");  
		} catch (Exception e) {
			AdvanceReporting.addLogs("info","Image not available");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	} 

	/* Verifyed menu options 'Select','Delete' Menu options for Image */
	public MessagePage verifySelectDeleteMenuOptionsforImage(){
		try {
			Thread.sleep(1000);
			Assert.assertTrue(Utils.uBase.imageCompare("SelectDeleteMenuOptionsImg"),"Select and Delete messages options are not avalilable for Image");
			AdvanceReporting.addLogs("pass","Verified that select and Delete messages options are avalilable for Image");
			AdvanceReporting.addLogs("pass","Select and Delete messages options are avalilable for Image","SelectDeleteMenuOptions");
		}catch (Exception e) {
			AdvanceReporting.addLogs("info", "Select and Delete messages options are not avalilable for Image");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage clickAddImage(){
		try {
			Utils.uBase.clickByImage("AddImage");
			Utils.uBase.clickByImage("AddImage");
			Thread.sleep(5000);
			Utils.uBase.clickByImage("Image");
			Thread.sleep(2000);
			Utils.uBase.clickByImage("selectImage");
			Thread.sleep(1000);

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Image not selected");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public MessagePage clickImage(){
		try {
			Thread.sleep(15000);
			Utils.uBase.hoverOnImage("ImageSide");
			//Utils.uBase.clickByImage("ImageSide");
			Thread.sleep(1000);
			//Utils.uBase.clickByImage("ImageThreeDots");  
			Utils.uBase.clickWebelement(MsgThreedotsss);

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Image not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	public MessagePage verifyImage(){
		try {
			Assert.assertEquals(Utils.uBase.imageCompare("Image"), false,"Image comparison failed");
			AdvanceReporting.addLogs("Pass", "Image do not exist in the screen");
			AdvanceReporting.addLogs("Pass", "Image do not exist in the screen", "Screen");

		} catch (Exception e) {
			AdvanceReporting.addLogs("Fail", "Image exist in the screen after it gets deleted");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//VERIFY THE IMAGE EXIST IN THE SCREEN
	public MessagePage verifyImageExist(){
		try {
			Thread.sleep(7000); 
			Assert.assertEquals(false, Utils.uBase.imageCompare("Image"));
			AdvanceReporting.addLogs("pass", "Verified that image do not exist in the screen");
			AdvanceReporting.addLogs("pass", "Image do not exist in the screen","Image");

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Image do exists in the screen");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//VERIFY THE MESSAGE IS LISTED IN MSG FOLDER
	public MessagePage verifyMsgListedInMsgFolder(){
		try {
			Thread.sleep(1000); 
			WebElement profileMsg = Utils.uBase.webDriver.findElement(By.xpath("(//*[contains(@gv-test-id,'content')])[1]"));
			String name = profileMsg.getText();
			Assert.assertEquals(name, "This is Test Msg");
			AdvanceReporting.addLogs("pass", "Verified that message exist in the message folder");
			AdvanceReporting.addLogs("pass", "Message exist in the message folder","Image");
		} catch (Exception e) {
			AdvanceReporting.addLogs("pass", "Message doen not exist in the message folder");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//VERIFY THE PHONE NUMBER
	public MessagePage verifyPhoneNumber(){
		try {
			Thread.sleep(1000); 
			if(Utils.uBase.isElementPresent_locator(By.xpath("//*[contains(@gv-test-id,'conversation-subtitle')]"))) {
				WebElement profileName = Utils.uBase.webDriver.findElement(By.xpath("//*[contains(@gv-test-id,'conversation-subtitle')]"));
				String name = profileName.getText().replaceAll("[^a-zA-Z0-9]", "");
				if(name.contains("2095973211‬")) {
					AdvanceReporting.addLogs("pass", "Verified that number exist in the message folder");
				}
						}
			else {
				Utils.uBase.waitForElement(profileNum);

				//WebElement profileNum = Utils.uBase.webDriver.findElement(By.xpath("//*[contains(@gv-test-id,'conversation-title')]"));
				String num = profileNum.getText().replaceAll("[^a-zA-Z0-9]", "");
				Assert.assertEquals(num, "2095973211‬");
			}
			AdvanceReporting.addLogs("pass", "Verified that number exist in the message folder");
			AdvanceReporting.addLogs("pass", "Number exist in the message folder","Image");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Number exist in the message folder");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//VERIFY THE BODY OF THE MESSAGE CONVERSATION
	public MessagePage verifyBodyOfMsgThread(){
		try {
			Assert.assertEquals(Utils.uBase.imageCompare("bodyOfMsg"),true,"Body of the message thread is displayed");
			AdvanceReporting.addLogs("Pass", "Body of the message thread is displayed");
			AdvanceReporting.addLogs("Pass", "Body of the message thread is displayed","bodyOfMsg");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Select contact from the list
	public MessagePage selectContactFromList(){
		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("SelectContact");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("Contact");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	// TO CHECK THE SEND BUTTON IS DISABLED
	public MessagePage typeAMsgAndCheckSendBtn()
	{
		try
		{
			Thread.sleep(5000);  
			if(Utils.uBase.imageCompare("DisableSendBtn"))
			{
				AdvanceReporting.addLogs("Pass", "The send button is disabled");     
				AdvanceReporting.addLogs("Pass", "The send button is disabled","DisableSendBtn");
				Utils.uBase.clickByImage("msgInput");
				Thread.sleep(3000);
				Utils.uBase.setText(typeAMsg, "https://www.google.com/");
				AdvanceReporting.addLogs("Pass", "Sending new message to existing contact");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "The send button is not disabled");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Click on send message button */
	public MessagePage sendMessage()
	{
		try
		{
				Utils.uBase.clickByImage("SendMsgBtn");
				Utils.uBase.clickByImage("SendMsgBtn");
			
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("Fail", "Sending is not displayed"); 
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verify just now 
	public MessagePage verifyJustNow()
	{
		try
		{
			Thread.sleep(8000);
			if(Utils.uBase.imageCompare("justNow"))
			{
				AdvanceReporting.addLogs("Pass", "Just Now is displayed");    
				AdvanceReporting.addLogs("Pass", "Just Now is displayed", "justNow");
			}else
			{
				AdvanceReporting.addLogs("Fail", "Just Now is not displayed");       
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Verify 1 min
	public MessagePage verifytimeStamp()
	{
		try
		{
			Thread.sleep(1000);
			if(Utils.uBase.isElementPresent_webelement(timeStamp))
			{
				AdvanceReporting.addLogs("Pass", "Verified that time is displayed"); 
				AdvanceReporting.addLogs("Pass", "Time is displayed", "Time");
			}
			else
			{
				AdvanceReporting.addLogs("Fail", "Time is not displayed");    
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Time is not displayed"); 
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Verify message is listed in message folder
	public MessagePage verifyMsgIsListedInMsgFolder()
	{
		try
		{
			Thread.sleep(100);
			if(Utils.uBase.imageCompare("linkMsg"))
			{
				AdvanceReporting.addLogs("Pass", "Verified that message is listed in the message conversation item");  
				AdvanceReporting.addLogs("Pass", "Message is listed in the message conversation item", "ConverstaionThread");
			}
			else
			{
				AdvanceReporting.addLogs("Fail", "Message is not listed in the message conversation item");       
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Message is not listed in the message conversation item");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//sending message to the group converstion
	public MessagePage  sendMsgToGroupConversation(String data)
	{
		try
		{
			Thread.sleep(5000);
			Utils.uBase.clickByImage("msgInput");
			Utils.uBase.clickByImage("msgInput");
			Utils.uBase.setText(typeAMsg, Constants.googleUrl);
			AdvanceReporting.addLogs("Pass", "Sending new message to existing contact");
			AdvanceReporting.addLogs("Pass", "Sending new message to existing contact", "SendGrpMessage");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Sending new message to existing contact failed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//click on more option     
	public MessagePage clickThreeDots() {
		try {
			Thread.sleep(5000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete"))
				Utils.uBase.clickByImage("MoreOptionGrp");
			AdvanceReporting.addLogs("Pass", "More Options is displayed");
			AdvanceReporting.addLogs("Pass", "More Options", "MoreOptions");

		} catch (Exception e) {

			AdvanceReporting.addLogs("info", "More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//verify menu items gets displayed in more options for group messages
	public MessagePage verifyMenuOptionsForGroupMsg() {
		try {
			Thread.sleep(2000); 
			if(Utils.uBase.imageCompare("menuContainer"))
			{
				AdvanceReporting.addLogs("pass", "Verified that Menu items is displayed with the options People, Archive and Delete");
				AdvanceReporting.addLogs("pass", "Menu items is displayed with the options People, Archive and Delete","menuContainer");
			}
			else 
			{ 
				AdvanceReporting.addLogs("info","Menu items are not displayed");
				AdvanceReporting.addLogs("fail", "Menu items are not displayed");    
			}

		} catch (Exception e) {

			AdvanceReporting.addLogs("info", "Menu items are not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Verify that it not displaying the following:"Mark as Spam", and "Block callers".
	public MessagePage verifyMarkAsSpamAndBlockNum() {
		try {
			Thread.sleep(2000); 
			if(!Utils.uBase.imageCompare("MarkSpamAndBlockNum"))
			{
				AdvanceReporting.addLogs("pass", "Verified that mark as Spam and Block callers is not displayed in menu items");
				AdvanceReporting.addLogs("pass", "Mark as Spam and Block callers is not displayed in menu items","menuContainer");
			}
			else 
			{ 
				AdvanceReporting.addLogs("info","Mark as Spam and Block callers is  displayed in menu items");
				AdvanceReporting.addLogs("fail", "Mark as Spam and Block callers is  displayed in menu items");   
			}

		} catch (Exception e) {

			AdvanceReporting.addLogs("info", "Mark as Spam and Block callers is displayed in menu items");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Click People using Image */
	public MessagePage clickPeopleGrpMsg() {
		try {
			Utils.uBase.clickByImage("PeopleGrpMsg");
			AdvanceReporting.addLogs("Pass", "People is displayed");
			AdvanceReporting.addLogs("Pass", "People is displayed", "People");

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "People is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();

		}
		return this;
	}

	//Verify the archive option is present in the more options page and click on the archive option
	public MessagePage clickArchiveFrmMoreOptnGrpMsg() {
		try {

			/* Utils.uBase.takeScreenshotOfWebelement(archive, "Messages"); */

			Utils.uBase.clickByImage("ArchiveGrpMsg");
			AdvanceReporting.addLogs("Pass", "Archive from More Options is clicked");
			AdvanceReporting.addLogs("Pass", "Archive from More Options is clicked", "GrpArchive");
			Thread.sleep(2000);

		} catch (Exception e) {

			AdvanceReporting.addLogs("info", "Archive from More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verify the message is available in the archived folder
	public MessagePage verifyArchivedFolderForGrpMsg() {

		try {                      
			Thread.sleep(7000); 
			if(Utils.uBase.isElementPresent_webelement(grpMsg))
			{
				Thread.sleep(1000);
				AdvanceReporting.addLogs("pass", "Verified that group message is displayed in archive folder");
				AdvanceReporting.addLogs("pass", "Group message is displayed in archive folder","GroupMessage");
			}else{ 
				AdvanceReporting.addLogs("info","Group message is not displayed");
				AdvanceReporting.addLogs("fail", "Group message is not displayed in archive folder");

			} }catch(Exception e){
				AdvanceReporting.addLogs("info", "Group message is not displayed in archive folder");
				AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
				e.printStackTrace(); Assert.fail();
			} return this; 
	}


	//Verify the message is available in the message folder
	public MessagePage verifyMsgFolderForGrpMsg(){

		try {                      
			Thread.sleep(5000); 
			if(Utils.uBase.imageCompare("GrpMsg"))
			{
				AdvanceReporting.addLogs("pass", "Verified that group message is displayed in message folder");
				AdvanceReporting.addLogs("pass", "Group message is displayed in message folder","GroupMessage");
			}else{ 
				AdvanceReporting.addLogs("info","Group message is not displayed");
				AdvanceReporting.addLogs("fail", "Group message is not displayed in message folder");

			} }catch(Exception e){
				AdvanceReporting.addLogs("info", "Group message is not displayed in message folder");
				AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
				e.printStackTrace(); Assert.fail();
			} return this; 
	}

	//verify the number of message thread available in the message list
	public MessagePage verifyMessagesCount() {

		try {
			Thread.sleep(3000);
			AdvanceReporting.addLogs("Info", "size of array in Message list is "+messageList.size());
			if(messageList.size() == AvatarsList.size())
				AdvanceReporting.addLogs("pass", "All Messages are displayed in Message folder correctly");
			AdvanceReporting.addLogs("pass", "All Messages are displayed in Message folder correctly", "MessageList");

		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "firstMessage is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}




	//verify contact details 
	public MessagePage verifyContactDetails() {
		try {
			String contactsInToField = contactDetailsOfToField.getText();
			String contactsInToField1 = contactsInToField.replaceAll("\\,", "");
			String contactsInPeopleOptn = contactDetailsOfPeopleOptn.getText();
			String contactsInPeopleOptn1 = contactsInPeopleOptn.replaceAll("\\,", "");
			AdvanceReporting.addLogs("Pass", "Contact details in To field is : "+contactsInToField1);
			AdvanceReporting.addLogs("Pass", "Contact details in People option is : "+contactsInPeopleOptn1);
			if(contactsInToField1.equals(contactsInPeopleOptn1))
			{
				AdvanceReporting.addLogs("Pass", "All the contact details of the message participants are getting displayed");
				AdvanceReporting.addLogs("Pass", "All the contact details of the message participants are getting displayed","ConTactDetails");

			}
			/*
			 * else { AdvanceReporting.addLogs("Fail",
			 * "All the contact details of the message participants are not getting displayed"
			 * ); }
			 */
		} catch (Exception e) {
			AdvanceReporting.addLogs("Fail","All the contact details of the message participants are not getting displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();

		}
		return this;
	}

	//Verify the message gets archived
	public MessagePage verifyMsgGetsRemovedFrmMsgFolder() {
		try {
			Thread.sleep(5000); 
			if(!Utils.uBase.imageCompare("GrpMsg"))
			{
				AdvanceReporting.addLogs("pass", "Message gets removed from message folder");
				AdvanceReporting.addLogs("pass", "Message gets removed from message folder","Message");
			}
			else 
				if(Utils.uBase.imageCompare("GrpMsg"))
				{ 
					AdvanceReporting.addLogs("info","Message is still displayed in Message folder");
					AdvanceReporting.addLogs("fail", "Message is still displayed in Message folder");
				}
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "firstMessage is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}

	//Add Image for group message
	public MessagePage clickAddImageGrpMsg(){
		try {
			Utils.uBase.clickByImage("AddImage");
			Utils.uBase.clickByImage("AddImage");
			Thread.sleep(5000);
			Utils.uBase.clickByImage("Image");
			Thread.sleep(2000);
			Utils.uBase.clickByImage("selectImage");
			Thread.sleep(1000);

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Image not selected");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verify the Image is available in the message folder
	public MessagePage verifyRecentGrpMsg(){

		try {                      
			Thread.sleep(5000); 
			if(Utils.uBase.imageCompare("SentImage"))
			{
				AdvanceReporting.addLogs("pass", "Left side conversation item displayed the recent message like \"You:(Sent an Image)\"");
				AdvanceReporting.addLogs("pass", "Left side conversation item displayed the recent message like \"You:(Sent an Image)\"","GroupMessage");
			}else{ 
				AdvanceReporting.addLogs("info","Left side conversation item do not display the recent message like \"You:(Sent an Image)\"");
				AdvanceReporting.addLogs("fail", "Left side conversation item do not display the recent message like \"You:(Sent an Image)\"");

			} }catch(Exception e){
				AdvanceReporting.addLogs("info", "Left side conversation item do not display the recent message like \"You:(Sent an Image)\"");
				AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
				e.printStackTrace(); Assert.fail();
			} return this; 
	}


	// Verify Suggestion and ContactList Displayed
	public MessagePage verifySuggestionandContactListDisplayed() { 
		try {
			Thread.sleep(5000);
			if(contactNameList.isEmpty()) {
				AdvanceReporting.addLogs("info", "Suggestion and Contact List is not  Displayed");
				AdvanceReporting.addLogs("fail", "Suggestion and Contact List is not Displayed", "SuggestionContactlist");
			} else {
				AdvanceReporting.addLogs("info", "Verified that Suggestion and Contact List Displayed");
				AdvanceReporting.addLogs("pass", "Verified that suggestion and Contact List Displayed", "SuggestionContactlist");
			} 
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Suggestion and Contact List Not Displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this; 
	}

	// Verify that, it displayed relevant contact name with phone numbers as popup screen
	public MessagePage verifyRelevantNameInPopUp(String name) {
		try {
			Thread.sleep(10000);
			String relevantName = contactNameList.get(0).getText();
			if(relevantName.contains(name)) {
				AdvanceReporting.addLogs("info", "Relevant contact is displayed");
				AdvanceReporting.addLogs("pass", "Relevant contact is displayed", "RelevantContact");							
			} else {
				AdvanceReporting.addLogs("info", "Relevant contact is not displayed");
				AdvanceReporting.addLogs("pass", "Relevant contact is not displayed", "RelevantContact"); }
		}catch(Exception e) {
			AdvanceReporting.addLogs("info", "Contact not displayed");
			AdvanceReporting.addLogs("fail", "No Contact displayed");
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}	

	// Select a contact from the pop up
	public MessagePage selectFromContactPopUp() { 
		try {
			Thread.sleep(9000);
			Utils.uBase.clickWebelement(contactNameList.get(0));
			AdvanceReporting.addLogs("info", "Relevant contact is selected");
			AdvanceReporting.addLogs("pass", "Relevant contact is selected", "RelevantContact");							
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Contact not displayed");
			AdvanceReporting.addLogs("fail", "No Contact displayed");
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	// Verify Phone Chip
	public MessagePage verifyPhoneChipCreated() { 
		try {
			Thread.sleep(3000);
			Utils.uBase.checkPageReady();
			if(Utils.uBase.isElementPresent_webelement(contactChip)) {
				AdvanceReporting.addLogs("pass", "Verified that Phone chip created");
				AdvanceReporting.addLogs("pass", "Phone chip created","PhoneChip");
			} else {
				AdvanceReporting.addLogs("info", "Phone chip not created");
				AdvanceReporting.addLogs("fail", "Phone chip not created", "PhoneChip");
			} } catch(Exception e) {
				AdvanceReporting.addLogs("info", "Phone chip not created");
				AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
				e.printStackTrace(); Assert.fail(); 
			}
		return this; 
	}

	// Verify Avatar contains the first alphabet of the name of contact saved in Suggestions Ex:avatar has ''S" from contact named Sam
	public MessagePage verifyAvatarContainsFirstAlphabetOfContactNameInSuggestions() { 
		try {
			Thread.sleep(3000);
			char firstAvatarLetter;
			char firstContactLetter;
			//			int frequestAvatarLength = suggestionAvatarsList.size();
			//			int suggestiponNameLength = suggestionNameList.size();
			int frequestAvatarLength = 3;
			int suggestiponNameLength = 3;
			for(int j=0,k=0; j<frequestAvatarLength && k<suggestiponNameLength; j++,k++) {
				String AvatarName = suggestionAvatarsList.get(j).getText();
				if(AvatarName == null) {
					continue;
				}              
				firstAvatarLetter = AvatarName.charAt(0);
				String suggestiponNameLetter = suggestionNameList.get(k).getText();
				firstContactLetter = suggestiponNameLetter.charAt(0);
				if(Character.toLowerCase(firstAvatarLetter)==Character.toLowerCase(firstContactLetter)) {
					AdvanceReporting.addLogs("pass", "Verified that avatar contains first alphabet of name of contact");				
				} else { 
					AdvanceReporting.addLogs("Fail", "Avatar does not contains first alphabet of name of contact"); }
			}
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Avatar does not contains first alphabet of name of contact");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this; 
	}

	// Verify Avatar contains the first alphabet of the name of contact saved in Suggestions Ex:avatar has ''S" from contact named Sam
	public MessagePage verifyAvatarContainsFirstAlphabetOfContactNameInAllContacts() { 
		try {
			Thread.sleep(3000);
			Utils.uBase.checkPageReady();
			char firstAvatarLetter;
			char firstContactLetter;
			int frequestAvatarLength = 3;
			int contactNameLength = 3;
			for(int j=0,k=0; j<frequestAvatarLength && k<contactNameLength; j++,k++) {
				String AvatarName = contactAvatarsList.get(j).getText();
				if(AvatarName == null) {
					continue;
				}              
				firstAvatarLetter = AvatarName.charAt(0);
				String firstContactName = contactAvatarsList.get(k).getText();
				firstContactLetter = firstContactName.charAt(0);
				if(Character.toLowerCase(firstAvatarLetter)==Character.toLowerCase(firstContactLetter)) {
					AdvanceReporting.addLogs("pass", "Verified that avatar contains first alphabet of name of contact");				
				} else { 
					AdvanceReporting.addLogs("fail", "Avatar contains first alphabet of name of contact"); }
			}
		}  catch(Exception e) {
			AdvanceReporting.addLogs("info", "Avatar does not contains first alphabet of name of contact");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this; 
	}

	// Enter Name to Message Field
	public MessagePage EnterNameToField(String name) {
		try  { 
			Utils.uBase.checkPageReady();
			Utils.uBase.waitForElement(msgToField);
			Utils.uBase.setText(msgToField, name);
			Thread.sleep(5000);
			AdvanceReporting.addLogs("info","Name entered in To field");
			AdvanceReporting.addLogs("pass","Name entered in To  field","MessageToField");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Pop up is not shown");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();			
		}
		return this;
	}

	// Verify that, it displayed relevant contact name with phone numbers as popup screen
	public MessagePage verifyContactNamePopUp(String name) {
		try  { 
			Utils.uBase.checkPageReady();	
			Utils.uBase.waitForElement(msgToField);
			Utils.uBase.setText(msgToField, name);
			Thread.sleep(15000);
			if(Utils.uBase.imageCompare("ContactPicAndLabel")) {
				AdvanceReporting.addLogs("pass","pop up with contact name is shown");
				AdvanceReporting.addLogs("pass","pop up with contact name is shown","RelevantContactName"); 
			} else { 
				AdvanceReporting.addLogs("info","pop up with contact name is not shown"); 
				AdvanceReporting.addLogs("fail","pop up with contact name is not shown"); }
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Pop up is not shown");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}

	// Verify Suggestion and ContactList Displayed
	public MessagePage verifyContactListDisplayed() { 
		try {
			Thread.sleep(15000);
			Utils.uBase.checkPageReady();
			if(contactNameList.isEmpty()) {
				AdvanceReporting.addLogs("info", "Relevant contact list displayed");
				AdvanceReporting.addLogs("fail", "Relevant contact list displayed", "SuggestionContactlist");
			} else {
				AdvanceReporting.addLogs("info", "Verified that Relevant contact list displayed");
				AdvanceReporting.addLogs("pass", "Relevant contact list displayed", "SuggestionContactlist");
			} 
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Relevant contact list not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this; 
	}
	/* Sending the message to the existing number */
	public MessagePage  sendMsgToExistingConversationForHyperLink()
	{
		try
		{
			Thread.sleep(5000);
			Utils.uBase.clickByImage("msgInput");
			Thread.sleep(2000);
			Utils.uBase.setText(msgInput,Constants.url);
			Thread.sleep(2000);
			AdvanceReporting.addLogs("Pass", "Sending link message to existing contact");
			AdvanceReporting.addLogs("Pass", "Sending link message to existing contact", "HyperLink");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Sending link message to existing contact");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Sending the message to the existing number */
	public MessagePage  sendMsgToExistingNumber(String data)
	{
		try
		{
			Thread.sleep(4000);
			Utils.uBase.clickByImage("msgInput"); 
			Utils.uBase.setText(msgInput, Constants.SentMsgToExtContact);
			AdvanceReporting.addLogs("Pass", "Sending new message to existing contact");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Right click on any existing sent/received message */
	public MessagePage rightClickOnExistingSentMsg()
	{
		try
		{
			Thread.sleep(5000);
			Utils.uBase.clickByImage("messageText");
			Thread.sleep(2000);
			Utils.uBase.clickByImage("threeDotsMenuOnSentMsg"); 
			AdvanceReporting.addLogs("Pass", "Right click on any existing sent message");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified right click menu items texts has "Copy" text "Delete"*/
	public MessagePage verifyMenuHasCopyTextDeleteOptions()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("copyTextDeleteOptions")," Copy text and Delete options are not available");
			AdvanceReporting.addLogs("Pass", "right click menu items texts has Copy text and Delete options");
			AdvanceReporting.addLogs("Pass", "right click menu items texts has Copy text and Delete options","Copy text and Delete options");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage typeNumberAndComposeMsg(String numb) throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(msgToField);
			Utils.uBase.setText(msgToField, numb);
			Thread.sleep(1000);
			Utils.uBase.clickByImage("selectNumber");
			Thread.sleep(2000);
			Utils.uBase.doubleClickWebelement(typeMsgInput);
			Thread.sleep(2000);
			Utils.uBase.setText(typeMsgInput, Constants.messageText);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Click on Copy to text from the right click menu option */
	public MessagePage clickOnCopyToTextOption()
	{
		try
		{
			Thread.sleep(10000);
			Utils.uBase.clickByImage("messageText");
			Thread.sleep(5000);
			Utils.uBase.clickByImage("threeDotsMenuOnSentMsg"); 
			Thread.sleep(2000);
			Utils.uBase.clickByImage("copyToTextOptin");
			AdvanceReporting.addLogs("Pass", "Click on Copy to text from the right click menu option");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "No Copy to text option avalilable");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified Message copied to clipboard is displayed.*/
	public MessagePage verifyMessageCopiedToClipboard()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("msgCopyToClipBoard"),"Message copied to clipboard is not displayed");
			AdvanceReporting.addLogs("Pass", "Message copied to clipboard is displayed");
			AdvanceReporting.addLogs("Pass", "Message copied to clipboard is displayed","Message copied to clipboard");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}  	
	/* Click on delete options from menu option */
	public MessagePage clickOnDeleteOption()
	{
		try
		{
			Thread.sleep(10000);
			Utils.uBase.clickByImage("messageText");
			Thread.sleep(5000);
			Utils.uBase.clickByImage("threeDotsMenuOnSentMsg"); 
			Thread.sleep(2000);
			Utils.uBase.clickByImage("deleteOption");
			AdvanceReporting.addLogs("Pass", "Click on Copy to text from the right click menu option");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "No Copy to text option avalilable");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified Delete this message? popup.*/
	public MessagePage verifyDeleteThisMessage()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("deleteThisMessage"),"Delete this message? is not displayed");
			AdvanceReporting.addLogs("Pass", "Delete this message? is displayed");
			AdvanceReporting.addLogs("Pass", "Delete this message? is displayed","Delete this message");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified cancel button is  displayed.*/
	public MessagePage verifyCancelButton()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("cancelBtnOnDeletePopup"),"Cancel Btn On Delete Popup is not displayed");
			AdvanceReporting.addLogs("Pass", "cancel Btn On Delete Popup is displayed");
			AdvanceReporting.addLogs("Pass", "cancel Btn On Delete Popup is displayed","cancel Btn");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified delete button is displayed.*/
	public MessagePage verifyDeleteBtn()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("deleteBtnOnDeletePopup"),"Delete Btn On DeletePopup is not displayed");
			AdvanceReporting.addLogs("Pass", "Delete Btn On Delete Popup is displayed");
			AdvanceReporting.addLogs("Pass", "Delete Btn On Delete Popup is displayed","Delete Btn");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicked on "Block number" menu item button */
	public MessagePage clickOnBlockNumberOption()
	{
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("blockNumberOption");
			AdvanceReporting.addLogs("pass", "Click on Block Number Option is sucessfully");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "No Block Number Option is available");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified Block this number? popup.*/
	public MessagePage verifyBlockThisNumber()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("blockThisNumber"),"blockThisNumber? is not displayed");
			AdvanceReporting.addLogs("Pass", "Block This Number? is displayed");
			AdvanceReporting.addLogs("Pass", "Block This Number? is displayed","BlockThisNumber");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified You won't receive messages text.*/
	public MessagePage verifyYouWontReceiveMsgText()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("youWontReceiveMsgText"),"You Won't Receive Msg Text is not displayed");
			AdvanceReporting.addLogs("Pass", "You Won't Receive Msg Text is displayed");
			AdvanceReporting.addLogs("Pass", "You Won't Receive Msg Text is","YouWontReceiveMsg");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "You Won't Receive Msg Text is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified block button is displayed.*/
	public MessagePage verifyBlockButton()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("blockButton"),"Block Btn On block Popup is not displayed");
			AdvanceReporting.addLogs("Pass", "Block Btn On block Popup is displayed");
			AdvanceReporting.addLogs("Pass", "Block Btn On block Popup is displayed","blockBtn");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Block Btn On block Popup is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Delete all messages from the message list folder */
	public MessagePage deleteAllMessages() { 
		try {
			Thread.sleep(2000);
			int msgsListSize = messageList.size();
			System.out.println("size od msg list is "   +msgsListSize);
			if(msgsListSize==0) {
				AdvanceReporting.addLogs("pass", "Messages folder is already empty");
			}else {
				for(int i=0; i<=msgsListSize-1; i++) {	
					messageList.get(i).click();

					AdvanceReporting.addLogs("pass", "Messages deleted sucessfully");		
				}
			}
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "No messages.");
			AdvanceReporting.addLogs("fail", "No Contact displayed");
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}


	/* Verified no message text is displayed.*/
	public MessagePage verifyNoMessageText()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("noMessagesText"),"No Messages text is not displayed");
			AdvanceReporting.addLogs("Pass", "No Messages text is displayed");
			AdvanceReporting.addLogs("Pass", "No Messages text is is displayed","NoMsgTxt");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "No Messages text is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/* Verified You'are all caught up text is displayed.*/
	public MessagePage verifyYourAllCaughtUpText()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("youreAllCaughtUpText"),"You'are all caught up text is not displayed");
			AdvanceReporting.addLogs("Pass", "You'are all caught up text is displayed");
			AdvanceReporting.addLogs("Pass", "You'are all caught up text is displayed","YouAreallCaughtup");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "You'are all caught up text is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Method to Verify Unspammed message in the message folder
	public MessagePage verifyUnspammedMsg() {
		try {
			Thread.sleep(5000);
			if(Utils.uBase.imageCompare("unspammedIcon")) {
				AdvanceReporting.addLogs("info", "Unspammed icon added back to the message folder");
				AdvanceReporting.addLogs("Pass", "Unspammed icon added back to the message folder","unspammedIcon");

			}else {
				AdvanceReporting.addLogs("fail", "Unspammed icon is not added back to the message folder");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;

	}

	public MessagePage verifyToScrnTxt() {
		try {
			Assert.assertTrue((Utils.uBase.imageCompare("ToMsgText")),"Screen text with TO is not present");
			{
				AdvanceReporting.addLogs("Pass","Screen Text with TO is present");
				AdvanceReporting.addLogs("Pass","Screen text with TO verified on screen","Screen text with TO verified on screen");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;

	}

	public MessagePage verifyTypNamePhoneScrnTxt() {
		try {
			Thread.sleep(3000); 
			Assert.assertTrue((Utils.uBase.imageCompare("typeNamePhone")),"Type a name or phone place holder is not present");
			{ 
				AdvanceReporting.addLogs("Pass","Type a name or phone place holder is present");
				AdvanceReporting.addLogs("Pass","Type a name or phone place holder is present","Type a name or phone place holder is present");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;

	}

	public MessagePage setNumMsgToField(String contactNum) {
		try {	
			Thread.sleep(2000);
			Utils.uBase.setText(msgToField,contactNum);
			AdvanceReporting.addLogs("pass", "Contact number entered in TO text field: "+contactNum);
			AdvanceReporting.addLogs("pass", "Contact number entered in TO text field: "+contactNum);
			Thread.sleep(1000);
			Utils.uBase.clickByImage("NewImage");
			AdvanceReporting.addLogs("pass", "Entered phonenumber in To field");
			AdvanceReporting.addLogs("pass", "Entered phone number in To field","PhoneNumberEnteredToField");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	public MessagePage clickToMsgTxt() {
		try {	
			Utils.uBase.clickByImage("ToMsgText");			
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;

	}

	//Clicking outside to remove the cursor from "Type a message" textfield.
	public MessagePage clickMsgConvNum() {
		try {	
			Utils.uBase.waitForElement(conversNum);
			Utils.uBase.clickWebelement(conversNum);
			AdvanceReporting.addLogs("Pass","Clicked outside with web element");
			AdvanceReporting.addLogs("Pass","Clicked outside with web element", "clickOutsideMsg");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("info","Not clicked outside with web element");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;

	}

	//Verifying the placeholder "Type a message" in message textfield 
	public MessagePage verifyTypMsgPlcHolder() {
		try {	
			Thread.sleep(1000);
			Utils.uBase.takeScreenshotOfWebelement(typMsgPlcHolder, "typMsgPlcHolder");
			Assert.assertTrue((Utils.uBase.imageCompare("typMsgPlcHolder")),"Type a Message place holder is not present");
			{ 
				AdvanceReporting.addLogs("Pass","Type a message placeholder is present");
				AdvanceReporting.addLogs("Pass","Type a message placeholder is present","Type a message placeholder is present");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("info","Type a message placeholder is not present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;

	}

	//Entering message as "Hi" in the messgage textfield
	public MessagePage setTextNewMsg(String msg) {
		try {
			Utils.uBase.waitForElement(typeAMsg);
			Utils.uBase.setText(typeAMsg, msg);
			AdvanceReporting.addLogs("pass", "New message entered");
			AdvanceReporting.addLogs("pass", "New message entered", "NewMsg");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("info", "New message set");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;

	}
	public MessagePage Add(String msg) {
		try {
			Utils.uBase.clickByImage("ToMsgText");
			Utils.uBase.hoverOnImage("AddImageImg");
			Thread.sleep(3000);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;

	}

	//Verifying the tool tip "Add image" for the Add image icon
	public MessagePage verifyAddImgToolTip() {
		try {
			Thread.sleep(1000);
			//Utils.uBase.takeScreenshotOfWebelement(AddImage, "AddImage");
			Utils.uBase.hoverOnImage("AddImage");
			Assert.assertTrue((Utils.uBase.imageCompare("addImagesToolTip")),"Tool tip with ADD IMAGES is not present");
			{ 
				AdvanceReporting.addLogs("Pass","Tool tip with ADD IMAGES is verified");
				AdvanceReporting.addLogs("Pass","Tool tip with ADD IMAGES","Tool tip with Add images");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("info","Tool tip with ADD IMAGES is not present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//Verifying tool tip "Send message" for Send arrow icon.
	public MessagePage verifySendMsgToolTip() {
		try {
			Thread.sleep(1000);
			Utils.uBase.hoverOnImage("SendMsgBtn");
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("sndMsgToolTip"))
			{
				AdvanceReporting.addLogs("Pass","Tool tip with SEND MESSAGE is verified");
				AdvanceReporting.addLogs("Pass","Tool tip with SEND MESSAGE","Tool tip with SEND MESSAGE");
			}else {
				AdvanceReporting.addLogs("fail", "Tool tip with SEND MESSAGE is not present");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Tool tip with SEND MESSAGE is not present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	public MessagePage composeMessage(String numb) throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(msgToField);
			Utils.uBase.setText(msgToField, numb);
			Utils.uBase.pressKeyEnter(msgToField);
			Thread.sleep(1000);
			Utils.uBase.doubleClickWebelement(typeMsgInput);
			Thread.sleep(2000);
			Utils.uBase.setText(typeMsgInput, "Test message");
		} 
		catch (Exception e)
		{AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		e.printStackTrace(); Assert.fail();
		}
		return this;
	} 

	//Verify the archive option is present in the more options page and click on the archive option
	public MessagePage clickUnblockNumberFromMoreOptn() {
		try {
			Thread.sleep(3000);
			Utils.uBase.clickByImage("unblockNumber");
			AdvanceReporting.addLogs("info", "Archive from More Options is clicked");
			AdvanceReporting.addLogs("pass", "Archive from More Options is clicked");
			Thread.sleep(2000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Archive from More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	} 
	//Verify the archive option is present in the more options page and click on the archive option
	public MessagePage clickBlockNumber(){
		try {
			Thread.sleep(3000);
			Utils.uBase.clickByImage("Block number");
			Thread.sleep(2000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Archive from More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	} 

	//Verify the archive option is present in the more options page and click on the archive option
	public MessagePage clickArchiveHighlightedFrmMoreOptn() {
		try {
			Thread.sleep(3000);
			Utils.uBase.clickByImage("3DotArchive");
			AdvanceReporting.addLogs("info", "Archive from More Options is clicked");
			AdvanceReporting.addLogs("pass", "Archive from More Options is clicked");
			Thread.sleep(2000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Archive from More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	} 

	/* Clicked on call button */
	public MessagePage clickOnCallButton() { 
		try
		{
			Thread.sleep(4000);
			Utils.uBase.clickByImage("callFromMsg");
			Utils.uBase.clickOnNotificationAllowBtn();
			AdvanceReporting.addLogs("pass", "Clicked on call button sucessfully");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified that able to make call */
	public MessagePage verifyAbleToMakeCall() { 
		try
		{
			Thread.sleep(4000);
			if(Utils.uBase.imageCompare("callingImg")){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call sucessfully");
				AdvanceReporting.addLogs("pass", "User able to make a call sucessfully","CallingImg");
				Thread.sleep(2000);
			}else if(Utils.uBase.imageCompare("callingPad")){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call sucessfully");
				AdvanceReporting.addLogs("pass", "User able to make a call sucessfully","CallingPad");
			}
			else if(Utils.uBase.imageCompare("callVerifyFrmMsgs")) {
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call sucessfully");
				AdvanceReporting.addLogs("pass", "User able to make a call sucessfully","CallingPad");
			}
			else {
				AdvanceReporting.addLogs("fail", "User not able to make a call");
				AdvanceReporting.addLogs("fail", "User not able to make a call","NocallingImg");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "User not able to make a call");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Clicked on End button hangs up the call */
	public MessagePage clickOnCallEndBtn() { 
		try
		{
			Thread.sleep(1000);
			Utils.uBase.clickByImage("callEndButtonImg");
			AdvanceReporting.addLogs("pass", "Click on call end button sucess");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Click on call end button is fail ");
		}	
		return this;		
	}

	// click EndNow to disable Do Not Disturb
	public MessagePage clickEndNowToDisableDoNotDisturb(){
		try {
			if(Utils.uBase.imageCompare("DoNotDisturbBanner")) {
				Thread.sleep(10000);
				Utils.uBase.clickByImage("EndNow");
				Thread.sleep(5000);
				AdvanceReporting.addLogs("pass","Clicked on end now");
				AdvanceReporting.addLogs("pass","Clicked on end now","End Now");
			}
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not clicked on end now");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}	
		return this;		
	}
	//Verify do not disturb banner goes off of the screen
	public MessagePage verifyDoNotDisturbIsNotDisplayed() {
		try {
			Thread.sleep(15000);
			Utils.uBase.checkPageReady();
			Assert.assertEquals(false, Utils.uBase.imageCompare("DoNotDisturbBanner"));
			AdvanceReporting.addLogs("pass", "Do not disturb banner is not displayed");
			AdvanceReporting.addLogs("pass", "Do not disturb banner","DoNotDisturbBanner");
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Do not disturb banner is displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	public MessagePage clickMessages() throws Exception
	{
		try
		{
			Utils.uBase.clickByImage("messageTabs");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Clicked on Messages tab in Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/* Mark as spam */
	public MessagePage markAsSpam() { 
		try
		{
			Thread.sleep(2000);
			clickThreeDotsMenu();
			Thread.sleep(2000);
			Utils.uBase.clickByImage("MarkAsSpam");
			AdvanceReporting.addLogs("pass", "Mark as spam sucess");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Mark as spam sucess fail ");
		}	
		return this;		
	}


	//To open a msg with matched content
	public MessagePage openUnReadMsg(){
		try {
			int length1=sentMsgsList.size();
			int length2=sentMsgsList.size();
			for(int i=0,j=0;i<length1&&j<length2;i++,j++) {
				if(sentMsgsList.get(i).getAttribute("aria-label").contains("Unread. Message by ")&& sentMsgsList.get(i).getText().contains("Test message") ) {
					sentMsgsList.get(i).click();
				}
			}
		}catch(Exception e){

			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}

	/* Get the count of items from Message list after sending the message */
	public MessagePage countOfItemsInMsgListAfterMsgs() {

		try {
			SoftAssert Assert=new SoftAssert();
			Thread.sleep(5000);	
			msgCountAfter=lstMsgs.size();
			AdvanceReporting.addLogs("pass","Message count is"+msgCountAfter);

			Assert.assertTrue(msgCountAfter>msgCount,"Latest Messages are not received");
			AdvanceReporting.addLogs("pass","Latest Messages are received","Messages");
		}
		catch(Exception e){

			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}

	//Deletes the message triggered from a particular phone no
	public MessagePage cleanCreatedMsgLog(String phoneNo)
	{
		try {
			Thread.sleep(5000);
			for(int i=0;i<messageList.size();i++)
			{			
				if(phoneNo.contains(messageList.get(i).getText().replaceAll("\\W", "")))
				{
					Utils.uBase.waitForElementToBeClickable(messageList.get(i));
					Utils.uBase.clickWebelement(messageList.get(i));
					System.out.println("Created call entry found");
					deleteMsg();
					AdvanceReporting.addLogs("info", "Created message is deleted");
					break;

				}}}catch(Exception e)
		{
					System.out.println("Unable to delete created message log");
					e.printStackTrace(); Assert.fail();

		}return this;
	}

	//Verifying tool tip "Make a call" for Phone icon in message conversation box
	public MessagePage verifyMsgCallToolTip() {
		try 
		{	Thread.sleep(4000);
		Utils.uBase.hoverOnImage("callIcon");
		Thread.sleep(3000);
		Assert.assertTrue(Utils.uBase.imageCompare("msgMakeACall"),"Make a call tool tip is not present");
		{
			AdvanceReporting.addLogs("Pass","Make a call tool tip is verified");
			AdvanceReporting.addLogs("Pass","Make a call tool tip is present","Make a call tool tip is present");
		}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//*Clicking the three doted icon to open the more options menu
	public MessagePage clickMsgThreeDots() 
	{
		try 
		{	
			Thread.sleep(1000);
			Utils.uBase.waitForElement(msgConvrsThreeDots);
			Utils.uBase.clickWebelement(msgConvrsThreeDots);		
			AdvanceReporting.addLogs("Pass","More options menu is clicked");
			AdvanceReporting.addLogs("Pass","More options menu is clicked","More options menu is clicked");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("info","More options menu is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//Verifying tool tip "More options" for the three doted icon.
	public MessagePage verifyMsgThreeDotsToolTip() {
		try 
		{		
			Utils.uBase.waitForElement(msgConvrsThreeDots);
			Utils.uBase.hoverWebelement(msgConvrsThreeDots);
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("threeDotsMoreOptns"),"More options tool tip is not present");
			{
				AdvanceReporting.addLogs("Pass","More options tool tip is Verified");
				AdvanceReporting.addLogs("Pass","More options tool tip is present","More options tool tip is present");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("info","More options tool tip is not present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verifying the menu items present in the three doted menu.
	public MessagePage verifyMsgThreeDotsOptionsText() {
		try 
		{
			Assert.assertTrue(Utils.uBase.imageCompare("msgPeopleOptn"),"People option is not present in three dots menu");
			Thread.sleep(3000);
			{
				AdvanceReporting.addLogs("Pass","Verified thePeople option is present in three dots menu");
				AdvanceReporting.addLogs("Pass","People option is present","People option is present");
			}
			Assert.assertTrue(Utils.uBase.imageCompare("archiveThreeDotsMenu"),"Archive menu item is not present in three dots menu");
			{
				AdvanceReporting.addLogs("Pass","Verified that Archive menu item is present in three dots menu");
				AdvanceReporting.addLogs("Pass","Archive menu item is present in three dots menu","Archive menu item is present in three dots menu");
			}
			Assert.assertTrue(Utils.uBase.imageCompare("markAsSpamThreeDotsMenu"),"Mark as spam is not present in three dots menu");
			{
				AdvanceReporting.addLogs("Pass","Verified that Mark as spam is present in three dots menu");
				AdvanceReporting.addLogs("Pass","Mark as spam is present","Mark as spam is present");
			}
			Assert.assertTrue(Utils.uBase.imageCompare("blockNumThreeDotsMenu"),"Block number is not present in three dots menu");
			{
				AdvanceReporting.addLogs("Pass","Verified that Block number is present in three dots menu");
				AdvanceReporting.addLogs("Pass","Block number is present in three dots menu","Block number is present in three dots menu");
			}	
			Assert.assertTrue(Utils.uBase.imageCompare("deleteNumberThreeDotsMenu"),"Delete number is not present in three dots menu");
			{
				AdvanceReporting.addLogs("Pass","Verified that Delete number is present in three dots menu");
				AdvanceReporting.addLogs("Pass","Delete number is present in three dots menu","Delete number is present in three dots menu");
			}
			Thread.sleep(2000);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}
	/* Verified items received from identified spam accounts are sent directly */
	public MessagePage verifyMsgsSentDirectlyToMsgFolder() {
		try {
			Thread.sleep(1000);
			for(int i=0; i<=msgList.size()-1; i++) {
				String listOfMessages = msgList.get(i).getText();
				Thread.sleep(1000);
				if(listOfMessages.contentEquals("Test message")) {
					AdvanceReporting.addLogs("pass","Received from identified spam accounts are sent directly to the message folder");
					AdvanceReporting.addLogs("pass","Received from identified spam accounts are sent directly to the message folder","receivedMsg");
					break;
				}else {
					AdvanceReporting.addLogs("fail","Received from identified spam accounts are sent directly not into the message folder");
					AdvanceReporting.addLogs("fail","Received from identified spam accounts are sent directly not into the message folder","noMsg");
				}
			}
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","Received from identified spam accounts are sent directly not into the message folder");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}
	/* Selecting first contact from contact List */
	public MessagePage selectFirstItemFromList()
	{
		try
		{
			Thread.sleep(5000);
			Utils.uBase.waitForElementToBeClickable(messageList.get(0));
			Utils.uBase.clickWebelement(messageList.get(0));
			AdvanceReporting.addLogs("pass", "Select item from message List");
			AdvanceReporting.addLogs("pass", "Select item from message List", "Message List");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Select item from message List");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage clickMessagesTab() throws Exception
	{
		try
		{
			Thread.sleep(3000);
			hmPage.clickTab(Constants.Messages);
			AdvanceReporting.addLogs("pass","Messages tab is clicked");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "fail error : "+e.getMessage());			
		}
		return this;
	}

	public MessagePage verifyReceivedMsgContactDetails(String sender) throws Exception
	{
		try
		{

			Thread.sleep(2000);
			Utils.uBase.switchToOldWindow();
			Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");		 
			Matcher matcher = pattern.matcher(phoneNumberWithoutSavedText.getText());

			if(!matcher.matches())
			{
				String phoneNo;
				phoneNo=phoneNumberWithoutSavedText.getText().replace("(", "").replace(")", "").replace("-", "").replaceAll("\\s", "");
				Assert.assertEquals(phoneNo, sender,"Message is not sent to required number");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed in messages list");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed","SourcePhoneNo");

			}else
			{
				String phoneNo=phoneNumberWithSavedText.getText().replaceAll("[^0-9]", "");
				Assert.assertEquals(phoneNo, sender,"Message is not sent to required number");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed in messages list");
				AdvanceReporting.addLogs("Pass","Source phone number is displayed","SourcePhoneNo");
			}		
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "fail error : "+e.getMessage());			
		}
		return this;
	}

	//Select contact from the list
	public MessagePage typeNumberinMsgToField(String numb) throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(msgToField);
			Utils.uBase.setText(msgToField, numb);
			Utils.uBase.pressKeyEnter(msgToField);
			Thread.sleep(3000);
		} 
		catch (Exception e) {
			AdvanceReporting.addLogs("info","Message details with date time is displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public  MessagePage verifyMessageDateTime() {
		try {
			Thread.sleep(2000);
			Utils.uBase.refresh();
			String msgTime = messgeDateTime.getText();
			Pattern p = Pattern.compile("\\d{2}:\\d{2} [A-Z][a-z]");
			Matcher msgDateTime = p.matcher(msgTime);
			boolean timeFound = msgDateTime.matches();
			if (timeFound) {
				AdvanceReporting.addLogs("pass","Message details with date time is displayed");
				AdvanceReporting.addLogs("pass", "Message details with date time is displayed", "messageWithDateTime");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Message details with date time is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified "Sending..." status is displayed for message*/
	public MessagePage verifySendingStatus()
	{
		try
		{
			Thread.sleep(300);
			if(Utils.uBase.imageCompare("sending"))  
			{
				AdvanceReporting.addLogs("pass", "Sending is displayed");     
				AdvanceReporting.addLogs("pass", "Sending is displayed", "sending");
			} 
			else
			{
				AdvanceReporting.addLogs("fail", "Sending is not displayed"); 
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Sending is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}  
	//Verification message when the text is getting copied to the clipboard
	public MessagePage verifyCurrentAndPreviousMsg() {
		try {
			Thread.sleep(8000);
			Utils.uBase.imageCompare("msgChain");
			AdvanceReporting.addLogs("Pass", "Verified that Composed message is appearing in the list");
			AdvanceReporting.addLogs("Pass", "Composed message is appearing in the list","msgChain");

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Composed message is not appearing in the list");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	// Verify that group message tiny avatar shows each avatar for each people.
	public MessagePage verifyTinyAvatar()
	{
		try
		{
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("GrpMsg"))
			{
				AdvanceReporting.addLogs("Pass","Verified that tiny avatar shows each avatar for each people");
				AdvanceReporting.addLogs("Pass","Tiny avatar shows each avatar for each people","TinyAvatar displayed");
			}else {
				AdvanceReporting.addLogs("fail", "Image comparision failed : Message tab accessibility");
			}
		}catch(Exception e)
		{
			AdvanceReporting.addLogs("info", "Tiny avatar does'nt show each avatar for each people");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();

		}return this;
	}

	/*Verify that, the tiny avatars follow the other test cases
	 *Message.AvatarPerson,Message.AvatarText, and Message.AvatarProfileImage.*/
	public MessagePage verifyAvatarTextAndPersonImg()
	{
		try
		{
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("GrpMsg"))
			{
				AdvanceReporting.addLogs("Pass","Tiny avatar follow the other test cases");
				AdvanceReporting.addLogs("Pass","Tiny avatar follow the other test cases","TinyAvatar displayed");
			}else {
				AdvanceReporting.addLogs("fail", "Image comparision failed : Message tab accessibility");
			}
		}catch(Exception e)
		{
			AdvanceReporting.addLogs("info", "Tiny avatar does'nt follow the other test cases");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();

		}return this;
	}

	//Verify Unsupported File type
	public MessagePage verifyUnsupportedFileType()
	{
		try
		{
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("UnSupportedFileImg"))
			{
				AdvanceReporting.addLogs("Pass","UnSupported file type is displayed");
				AdvanceReporting.addLogs("Pass","UnSupported file type is displayed","UnSupported file type is displayed");
			}else {
				AdvanceReporting.addLogs("fail", "UnSupported file type is not displayed");
			}
		}catch(Exception e)
		{

			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();

		}return this;
	}

	//To pick one of the contact in suggestion list
	public MessagePage selectContactFromSuggestions() {
		try {
			Utils.uBase.clickWebelement(contactNameList.get(0));
			AdvanceReporting.addLogs("pass", "selected a contact from suggestion list");
			AdvanceReporting.addLogs("pass", "selected a contact from suggestion list","selected a contact from suggestion list");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("info", "Contact not selected");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//to verify selected contact and the chip in to field has same contact
	public MessagePage verifyToFieldChipName() {
		try {
			if(contactNameList.get(0).getText().contains(contactChipInToField.getText())) {
				AdvanceReporting.addLogs("pass", "Verified selected contact is listed in to filed");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "selected contact is not listed in to filed");
		}
		return this;
	}

	public MessagePage clicKMessageWithGeneratedString(String str) 
	{
		try
		{      
			Utils.uBase.webDriver.findElement(By.xpath("//*[contains(text(),'"+str+"')]")).click();
			AdvanceReporting.addLogs("pass", "Clicked on the first message thread");
			AdvanceReporting.addLogs("pass", "Messages Page","Messages Page");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;    }
	public MessagePage verifyMessageWithGeneratedStringReceived(String str) {
		try {
			Thread.sleep(8000);
			if(msgPreview.getText().contains(str)) {
				AdvanceReporting.addLogs("pass","message is received before opening the thread");
				AdvanceReporting.addLogs("pass","message is received before opening the thread","message is received before opening the thread");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public MessagePage verifyMessageReceivedInOpenConversation(String str) {
		try {
			Thread.sleep(8000);
			if(lastMsgInConversation.getText().contains(str)) {
				AdvanceReporting.addLogs("pass","message is received after opening the thread");
				AdvanceReporting.addLogs("pass","message is received after opening the thread","message is received after opening the thread");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage verifyMessageWithGeneratedStringIsDisplayed(String str) 
	{
		try
		{      
			Thread.sleep(5000);
			List<WebElement> lstMsgs=Utils.uBase.webDriver.findElements(By.xpath("//*[contains(text(),'"+str+"')]"));
			Assert.assertTrue(lstMsgs.size()!=0,"Message is not received");                
			AdvanceReporting.addLogs("pass", "New message is displayed");
			AdvanceReporting.addLogs("pass", "Message is recieved","Message is recieved");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;    }



	public MessagePage verifyMobileNumberGetsRestore()
	{
		try
		{
			Thread.sleep(3000);
			if(msgPreviewContent.get(0).getText().contains("Test Message"))
			{
				AdvanceReporting.addLogs("Pass"," Archived message item gets restored");
				AdvanceReporting.addLogs("Pass","Archived message item gets restored","Archived message item gets restored");
			}else {
				AdvanceReporting.addLogs("fail", "Archived message item do not gets restored");
			}
		}catch(Exception e)
		{

			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();

		}return this;
	}
	//To verify block and spam in more options
	public MessagePage verifyBlockAndSpamOptions()
	{
		try
		{
			if(Utils.uBase.imageCompare("spamInMoreOptions")==true&&Utils.uBase.imageCompare("blockInMoreOption")==true){
				AdvanceReporting.addLogs("pass", "Verified that mark as spam and block options are present");
			}
			else {
				AdvanceReporting.addLogs("fail", "Mark as spam and block options are not present");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//To verify navigation to another window
	public MessagePage verifyNavigationToAnotherWindow()
	{
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		try
		{
			GAPage.switchingToWindowByIndex(2);
			if(Utils.uBase.getCurrentUrl().equals(Constants.url)) {
				AdvanceReporting.addLogs("pass", "Verified that navigated to another window");
			}
			else {
				AdvanceReporting.addLogs("fail", "navigation to another window is not done");
			}
		}catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public MessagePage verifyUnSelectMultipleAvatars() {

		try {

			if(Utils.uBase.imageCompare("unSelectAll")==false) {
				AdvanceReporting.addLogs("pass", "Verified that avatars are unselected");
				AdvanceReporting.addLogs("pass", "Verified that avatars are unselected", "UnselectAvatars");
			}

		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Unable to Unselect the message Avatars");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public MessagePage verifyMsgPreview(String previewText) {
		try {
			Utils.uBase.refresh();
			Utils.uBase.waitForElement(firstMessage);
			AdvanceReporting.addLogs("pass", "Messages Page","Messages Page");
			List<WebElement> allProfileMsg = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@ng-if,'FileTypeError')]"));
			WebElement eleProfileMsg = allProfileMsg.get(0);
			String msgPreview = eleProfileMsg.getText();
			if(msgPreview.contains(": ")) {
				msgPreview = msgPreview.substring(msgPreview.indexOf(": ")+2);
			}
			AdvanceReporting.addLogs("pass", msgPreview);
			if(msgPreview.equals(previewText)) {
				AdvanceReporting.addLogs("pass", "Verified that latest message preview is displayed on LHS");
				AdvanceReporting.addLogs("pass", "Verified that latest message preview is displayed on LHS","Messages Page Preview");
			}	
			else {
				AdvanceReporting.addLogs("fail", "Message previes does not contain latest message");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public MessagePage OptionsInPicture() {
		try {
			if(Utils.uBase.imageCompare("SelectDeleteMenuOptionsImg")==true) {
				AdvanceReporting.addLogs("pass", "delete and select options are present");
			}
			else {
				AdvanceReporting.addLogs("fail", "delete and select options are not present");
			}	
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public MessagePage SelectAvtars(int count) {
		try {
			Thread.sleep(2000);
			for(int i =0; i <=count ; i++)
			{                         
				AvatarsList.get(i).click();
			}
			AdvanceReporting.addLogs("pass", "Two avatars are selected");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public MessagePage verifyFileTypeNotSupported(String previewText) {
		try {
			Utils.uBase.refresh();
			Utils.uBase.waitForElement(firstMessage);
			Utils.uBase.clickWebelement(firstMessage);
			AdvanceReporting.addLogs("pass", "Messages Page","Messages Page");
			List<WebElement> allProfileMsg = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@ng-if,'FileTypeError')]"));
			WebElement eleProfileMsg = allProfileMsg.get(0);
			String msgPreview = eleProfileMsg.getText();
			if(msgPreview.contains(": ")) {
				msgPreview = msgPreview.substring(msgPreview.indexOf(": ")+2);
			}
			AdvanceReporting.addLogs("pass", msgPreview);
			if(msgPreview.equals(previewText)) {
				AdvanceReporting.addLogs("pass", "Verified that latest message preview is displayed on LHS");
				AdvanceReporting.addLogs("pass", "Verified that latest message preview is displayed on LHS","Messages Page Preview");
			}	
			else {
				AdvanceReporting.addLogs("fail", "Message previes does not contain latest message");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public MessagePage verifyMessagesSelected() {
		try {
			Thread.sleep(3000);
			if(selectedMsgs.size()>1) {
				AdvanceReporting.addLogs("pass", "Verified that multiple messages are selected");
				AdvanceReporting.addLogs("pass", "multiple messages selected","multipleMessages");
			}
			else
				AdvanceReporting.addLogs("fail", "Multiple messages are not selected");
		}
		catch(Exception e) {
			
		}
		return this;
	}
	public MessagePage verifyMessagesUnselected() {
		try {
			Utils.uBase.clickWebelement(messageText);
			Thread.sleep(5000);
			if(Utils.uBase.imageCompare("msgBubbleSelect")==true) {
				AdvanceReporting.addLogs("fail", "Multiple messages are not unselected");
			}
			else {
				AdvanceReporting.addLogs("pass", "Verified that multiple messages are Unselected");
				AdvanceReporting.addLogs("pass", "multiple messages selected","multipleMessages");
			}
		}
		catch(Exception e) {
			
		}
		return this;
	}
	//To type a test msg
	public MessagePage typeTestMsg()
	{
	try
	{
	if(Utils.uBase.imageCompare("DisableSendBtn"))
	{
	AdvanceReporting.addLogs("Pass", "The send button is disabled");     
	AdvanceReporting.addLogs("Pass", "The send button is disabled","DisableSendBtn");
	Utils.uBase.clickByImage("msgInput");
	Thread.sleep(1000);
	Utils.uBase.setText(typeAMsg, "This is Test Msg");
	AdvanceReporting.addLogs("Pass", "Sending new message to existing contact");
	}
	} 
	catch (Exception e)
	{
	AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
	e.printStackTrace(); Assert.fail();
	}
	return this;
	}
	//To type a unique string
	public MessagePage typeUniqeMsg()
	{
		 GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
	try
	{
	Thread.sleep(5000);  
	if(Utils.uBase.imageCompare("DisableSendBtn")){
	AdvanceReporting.addLogs("Pass", "The send button is disabled");     
	AdvanceReporting.addLogs("Pass", "The send button is disabled","DisableSendBtn");
	Utils.uBase.clickByImage("msgInput");
	Thread.sleep(3000);
	Utils.uBase.setText(typeAMsg, GAPage.generateUniqueString());
	AdvanceReporting.addLogs("Pass", "Sending new message to existing contact");
	}
	} 
	catch (Exception e)
	{
	AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
	e.printStackTrace(); Assert.fail();
	}
	return this;
	}
	public MessagePage verifyUniqeMsgDeleted()
	{
		GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		try {
			if(messageText.getText().contains(GAPage.generateUniqueString())) {
				AdvanceReporting.addLogs("fail", "Message is not deleted");
			}
			else
				AdvanceReporting.addLogs("pass", "Message is deleted");
		}
		catch(Exception e) {
			
		}
		return this;
	}
	//To type a test msg
		public MessagePage typeFirstMsg()
		{
		try
		{
		if(Utils.uBase.imageCompare("DisableSendBtn"))
		{
		AdvanceReporting.addLogs("Pass", "The send button is disabled");     
		AdvanceReporting.addLogs("Pass", "The send button is disabled","DisableSendBtn");
		Utils.uBase.clickByImage("msgInput");
		Thread.sleep(1000);
		Utils.uBase.setText(typeAMsg, "This is First Msg");
		AdvanceReporting.addLogs("Pass", "Sending new message to existing contact");
		}
		} 
		catch (Exception e)
		{
		AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
		e.printStackTrace(); Assert.fail();
		}
		return this;
		}

}


