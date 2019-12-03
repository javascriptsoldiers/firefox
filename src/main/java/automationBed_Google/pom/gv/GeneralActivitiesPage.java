package automationBed_Google.pom.gv;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class GeneralActivitiesPage {

	@FindBy(xpath="(//*[contains(@gv-test-id,'item-contact')])[1]")
	List <WebElement> listItem;
	@FindBy(xpath="//*[@gv-test-id='conversation-avatar-or-checkmark']")
	List<WebElement> AvatarsList;
	@FindBy(xpath="//*[contains(@aria-label,'Contact name')]")
	WebElement contactName;
	@FindBy(xpath="//*[contains(@aria-label,'Contact label')]")
	WebElement contactLabel;
	@FindBy(xpath="//span[@jsname='GYDesb']")
	private List<WebElement> addedContactList;
	@FindBy(xpath="//div[@aria-selected='false']/div/gv-multi-avatar/div")
	List <WebElement> avtarList;
	@FindBy(xpath="//*[contains(@aria-label,'More options')]/mat-icon")
	WebElement threeDotsMenu;
	@FindBy(xpath="//md-menu-item//p[contains(text(),'Archive')]")
	WebElement archiveThreeDots;
	@FindBy(xpath="//*[contains(@gv-test-id,'item-contact')]|//*[contains(@ng-class,'TRANSCRIPT')]")
	List <WebElement> contact;
	@FindBy(xpath="//div[@class='Ng6ome-MZArnb']|//*[contains(@flex,'noshrink')]")
	List <WebElement> timeStamp;
	@FindBy(xpath="//*[contains(@content,'ctrl.getIncomingProfileNames()')]")
	List <WebElement> callName;
	@FindBy(xpath="//*[contains(@aria-label,'People')]")
	WebElement people;
	@FindBy(xpath="(//*[contains(@ng-if,'hasAttachments')])[last()]")
	WebElement unsupported;
	@FindBy(xpath="(//*[contains(@aria-label,'Spam')]//mat-icon)[last()]")
	WebElement menuSpamIcon;
	@FindBy(xpath="//*[contains(@gv-test-id,'unspam_selected')]")
	WebElement unSpamIcon;
	@FindBy(xpath="//*[contains(@gv-test-id,'batch_selected_count')]")
	WebElement batchSelectCount;
	@FindBy(xpath="//*[contains(@gv-test-id,'call-time')]")
	WebElement callTime;
	@FindBy(xpath="//*[contains(@ng-class,'::ctrl.Css.MESSAGE_HEADER')]/div[2]/div/span[1]")
    WebElement callIcon;
    @FindBy(xpath="//*[contains(@ng-class,'::ctrl.Css.MESSAGES')]")
    WebElement msgDetails;
    @FindBy(xpath="(//*[contains(@class,'layout-align-center-stretch layout-column flex')])[1]")
    WebElement contactDetails;
    @FindBy(xpath="//*[contains(@ng-class,'::ctrl.Css.MESSAGE_HEADER')]/div[2]/div/span[2]")
    WebElement msgIcon;


	String[] text = new String[10];
	String[] text2 = new String[10];
	String[] time = new String[10];
	String[] time2 = new String[10];
	String[] calltime = new String[10];
	String[] calltime2 = new String[10];
	String[] textAfterSpam = new String[10];
	String[] timeAfterSpam = new String[10];

	public static String data,strPhoneNo;

	// Clicking Delete from More options
	public GeneralActivitiesPage deleteItem()
	{
		try{
			Thread.sleep(3000);
			int sizeBeforeDelete = listItem.size();
			Utils.uBase.clickByImage("Delete1");
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("DeletePermanentlyPopUp")) {
				Thread.sleep(2000);
				Utils.uBase.clickByImage("IUnderstand");
				Utils.uBase.clickByImage("DeleteBtnPopUp");
			}else if(Utils.uBase.imageCompare("PermanentlyDeleteVoicemailPopUp")) {
				Utils.uBase.clickByImage("DeleteBtnPopUp");
			}else if(Utils.uBase.imageCompare("PermanentlyDeleteCall")) {
				AdvanceReporting.addLogs("pass", "Permanently delete poup appeared");
				Utils.uBase.clickByImage("DeleteBtnPopUp");
			}
			Thread.sleep(3000);
			int sizeAfterDelete = listItem.size();
			/* verify that Spam items are placed again in calls folder */
			if(sizeBeforeDelete==sizeAfterDelete-1) 
			{
				AdvanceReporting.addLogs("pass", "Item is deleted forever from folder.","ItemDeleted");
				AdvanceReporting.addLogs("pass", "Item is deleted forever from folder");
			}else {
				AdvanceReporting.addLogs("info", "Item is not deleted from folder","ItemNotDeleted");
			}

		}                                              
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Unable to click on delete icon img");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Clicking on first item in the list
	public GeneralActivitiesPage clickFirstItemInList()
	{
		try
		{
			Thread.sleep(5000);
			Utils.uBase.waitForElement(listItem.get(0));
			Utils.uBase.clickWebelement(listItem.get(0));
			AdvanceReporting.addLogs("pass", "Clicked on a First Item");
			AdvanceReporting.addLogs("pass", "Clicked on a First Item", "ClickFirstItem");
		}
		catch (Exception e)
		{                              
			AdvanceReporting.addLogs("info", "Not clicked on a First Item");
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}     
		return this;
	}

	// Selecting 3Dot More Option applicable for calls/messages/voicemails/archive/spam
	public GeneralActivitiesPage clickMoreOptn() {
		try {
			Thread.sleep(3000);
			Utils.uBase.waitForElement(threeDotsMenu);
			Utils.uBase.clickWebelement(threeDotsMenu);
			AdvanceReporting.addLogs("Pass", "More Options is displayed");
			AdvanceReporting.addLogs("Pass", "More Options", "MoreOptions");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	// Selecting 3Dot More Option applicable for calls/messages/voicemails/archive/spam
	public GeneralActivitiesPage doubleClickMoreOptn() {
		try {
			Thread.sleep(3000);
			Utils.uBase.waitForElement(threeDotsMenu);
			Utils.uBase.doubleClickWebelement(threeDotsMenu);
			AdvanceReporting.addLogs("Pass", "More Options is displayed");
			AdvanceReporting.addLogs("Pass", "More Options", "MoreOptions");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	// Selecting MarkAsSpam Option applicable for calls/messages/voicemails/archive
	public GeneralActivitiesPage selectMarkAsSpam()
	{
		try
		{
			Utils.uBase.clickByImage("MarkAsSpam");
			AdvanceReporting.addLogs("info", "Click on spam option sucessfully.");
			AdvanceReporting.addLogs("info", "Click on spam option sucessfully","Click on spam option sucessfully");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Selecting People Option applicable for calls/messages/voicemails/archive/Spam
	public GeneralActivitiesPage clickPeople() {
		try {
			Thread.sleep(1000);
			Utils.uBase.clickWebelement(people);
			AdvanceReporting.addLogs("Pass", "People is displayed");
			AdvanceReporting.addLogs("Pass", "People is displayed", "People");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Selecting Archive Option applicable for calls/messages/voicemails
	public GeneralActivitiesPage clickArchiveFrmMoreOptn() {
		try {

			//Thread.sleep(3000);
			//Utils.uBase.clickByImage("Archives");
			Utils.uBase.waitForElement(archiveThreeDots);
			Utils.uBase.clickWebelement(archiveThreeDots);

			AdvanceReporting.addLogs("pass", "Archive from More Options is clicked");
			AdvanceReporting.addLogs("pass", "Archive from More Options is clicked", "Archive3Dot");
			Thread.sleep(2000);

		} catch (Exception e) {

			AdvanceReporting.addLogs("info", "Archive from More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verify delete confirmation pop up do not display after clicking on i undertsand and delete button
	public GeneralActivitiesPage verifyDeleteConfirmationPopUp(){
		try {
			Thread.sleep(5000); 
			Assert.assertEquals(false, Utils.uBase.imageCompare("DeletePopUp"));
			AdvanceReporting.addLogs("pass", "Verified that delete and cancel buttons are displayed");
			AdvanceReporting.addLogs("pass", "Verified that delete Permanently popup with text message is not dispalyed");
			AdvanceReporting.addLogs("pass", "Delete Permanently popup with text message is not dispalyed","DeletePopUp");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// clicking call icon in contact details applicable for calls/messages/voicemails
	public GeneralActivitiesPage clickCallIcon() {
		try {

			Thread.sleep(3000);
			Utils.uBase.clickByImage("calliconToCall");
			AdvanceReporting.addLogs("pass", "Call icon is clicked to make a call");
			Thread.sleep(2000);

		} catch (Exception e) {

			AdvanceReporting.addLogs("info", "Archive from More Options is not clicked");

			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Method to send multiple voicemails
	/*
	 * public GeneralActivitiesPage multipleVoicemails(String number, int count) {
	 * try { for(int i=1;i<=count;i++) { Thread.sleep(1000);
	 * ReceiveCallAndMessages.makeCall(number); Thread.sleep(35000); } } catch
	 * (Exception e) { AdvanceReporting.addLogs("fail", "Error Message: " +
	 * e.getMessage()); e.printStackTrace(); Assert.fail(); } return this; }
	 */
	/* Adding the contact as work label applicable for calls/messages/voicemails/Archive/Spam*/
	public GeneralActivitiesPage addToContact(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("AddContactImg");
			Thread.sleep(1000);
			contactName.sendKeys("TestName");
			Thread.sleep(2000);
			contactLabel.click();
			Thread.sleep(2000);
			Utils.uBase.clickByImage("ContactLabelImg");
			Thread.sleep(2000);
			Utils.uBase.clickByImage("AddContactButtonImg");
			AdvanceReporting.addLogs("Pass", "Contact added sucessfully");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not added");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Selected google apps menu option  applicable for calls/messages/voicemails/Archive/Spam*/
	public GeneralActivitiesPage clickOnGoogleAppsMenu(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("menuOptions");
			AdvanceReporting.addLogs("Pass", "Google apps menu opens sucessfully");
			AdvanceReporting.addLogs("Pass", "Google apps menu opened","Google apps menu opened");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Google apps menu not opened");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Selected google apps menu option  applicable for calls/messages/voicemails/Archive/Spam*/
	public GeneralActivitiesPage clickOnContactsOptionFromGoogleApps(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("clickOnContact");
			AdvanceReporting.addLogs("Pass", "Contact option is selected from google apps menu");
			AdvanceReporting.addLogs("Pass", "Contact option is selected","Contact option is selected");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact option is not selected from google apps menu");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Delete added contact  applicable for calls/messages/voicemails/Archive/Spam*/
	public GeneralActivitiesPage deleteAddedContact(){
		try {
			Thread.sleep(2000);
			Utils.uBase.switchWindowByTitle("Google Contacts");
			Thread.sleep(2000);
			for(int i=0; i<addedContactList.size(); i++) {
				String allContacts = addedContactList.get(i).getText();
				if(allContacts.contentEquals(Constants.addContactName)) {
					Thread.sleep(1000);
					addedContactList.get(i).click();
					Thread.sleep(2000);
					Utils.uBase.clickByImage("contactThreeDotsOption");
					Thread.sleep(2000);
					Utils.uBase.clickByImage("contactDeleteOption");
					Thread.sleep(2000);
					Utils.uBase.clickByImage("deleteContactBtn");
					Thread.sleep(2000);
					AdvanceReporting.addLogs("pass", "Contact deleted sucessfully");
					AdvanceReporting.addLogs("pass", "Contact deleted sucessfully","Contact deleted sucessfully");
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not deleted");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Unmark As Spam  applicable for calls/messages/voicemails/Archive*/
	public GeneralActivitiesPage selectUnmarkAsSpam(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("UnmarkAsSpam");
			AdvanceReporting.addLogs("pass", "Unmark As Spam sucessfully");
			AdvanceReporting.addLogs("pass", "Unmark As Spam sucessfully", "unmarkSpam");
			Thread.sleep(2000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Unmark As Spam button not available");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Generates unique string
	public String generateUniqueString()
	{				
		data= "Message "+new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());	
		return data;
	}

	//Changes number from xxxxxxxxxx format to (xxx) xxx-xxxx	
	public String convertNumberToRequiredFormat(String number)
	{
		strPhoneNo="("+number.substring(0, 3)+") "+number.substring(3,6)+"-"+number.substring(6,number.length());
		return strPhoneNo;
	}

	// Clicking on first item in the list
	public GeneralActivitiesPage selectMultipleItemInList(int count)
	{
		try
		{
			int i;
			for(i=0;i<count;i++){
				Thread.sleep(2000);
				Utils.uBase.clickWebelement(avtarList.get(i));}
			AdvanceReporting.addLogs("info", "Selected "+i+" Items");
			AdvanceReporting.addLogs("info", "Multiple avatars are selected", "Multiple avatars are selected");
		}
		catch (Exception e)
		{                              
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}     
		return this;
	}

	/*
	 * // Method to send multiple miss calls public GeneralActivitiesPage
	 * reciveMultipleMissCalls(String number, int count) { try { for(int
	 * i=1;i<=count;i++) { Thread.sleep(1000);
	 * ReceiveCallAndMessages.makeMissedCall(number); Thread.sleep(3000); } } catch
	 * (Exception e) { AdvanceReporting.addLogs("fail", "Error Message: " +
	 * e.getMessage()); e.printStackTrace(); Assert.fail(); } return this; }
	 */

	/*
	 * // Method to send multiple test messages public GeneralActivitiesPage
	 * reciveMultipleTestMsgs(String number, int count) { try { for(int
	 * i=1;i<=count;i++) { Thread.sleep(1000);
	 * ReceiveCallAndMessages.receiveMessage(number); Thread.sleep(3000); } } catch
	 * (Exception e) { AdvanceReporting.addLogs("fail", "Error Message: " +
	 * e.getMessage()); e.printStackTrace(); Assert.fail(); } return this; }
	 */

	public GeneralActivitiesPage switchingToWindowByIndex(int windowID) {
		try {
			ArrayList<String> tabs = new ArrayList<String> (Utils.uBase.webDriver.getWindowHandles());
			Utils.uBase.webDriver.switchTo().window(tabs.get(windowID));
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Method to click three dots menu in any conversation box in order to enable more options drop down
	public GeneralActivitiesPage clickThreeDotsMenuWithElement() {
		try {
			Utils.uBase.waitForElement(threeDotsMenu);
			Utils.uBase.clickWebelement(threeDotsMenu);
			AdvanceReporting.addLogs("pass", "Three dots menu in the conversation box is clicked");
			AdvanceReporting.addLogs("pass", "Three dots menu is clicked","Three dots menu is clicked");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("infol", "Three dot menu in conversation bo is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicking on add contact icon in People option under Threedots menu*/
	public GeneralActivitiesPage addContactPeople()
	{
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("AddContactImg");
			AdvanceReporting.addLogs("pass", "Clicked on Add Contact icon on People page");
			AdvanceReporting.addLogs("pass", "Clicked on Add Contact","Clicked on Add Contact");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not added");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Entering contact name in contact name field in People option under Threedots menu*/
	public GeneralActivitiesPage enterContactNamePeople(){
		try {
			Thread.sleep(1000);
			contactName.sendKeys("TestName");	
			AdvanceReporting.addLogs("pass", "Contact name entered in the contact name text field : TestName");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not added");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicking label option in People option under Threedots menu*/
	public GeneralActivitiesPage clickLabelPeopleAddContact(){
		try {
			Thread.sleep(2000);
			contactLabel.click();
			AdvanceReporting.addLogs("pass", "Clicked on label name to navigate the options");
			AdvanceReporting.addLogs("pass", "Clicked on label name","Clicked on label name");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not added");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Selecting label option in People option under Threedots menu*/
	public GeneralActivitiesPage selectLabelPeopleAddContact(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("ContactLabelImg");
			AdvanceReporting.addLogs("pass", "Label is successfully selected : Work");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not added");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Click add button on Addcontact page in People option under Threedots menu*/
	public GeneralActivitiesPage clickAddPeopleAddContact(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("AddContactButtonImg");
			AdvanceReporting.addLogs("Pass", "Contact added sucessfully");
			AdvanceReporting.addLogs("Pass", "Contact added sucessfully","Contact added sucessfully");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not added");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Click required tab*/
	public GeneralActivitiesPage selectRequiredTab(int tabNumber){
		try {
			ArrayList<String> tabs = new ArrayList<String> (Utils.uBase.webDriver.getWindowHandles());
			System.out.println("No.Windows:"+Utils.uBase.webDriver.getWindowHandles());
			Utils.uBase.webDriver.switchTo().window(tabs.get(tabNumber));
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public GeneralActivitiesPage getTextOfItemInSecondList(int data)
	{
		try
		{
			Thread.sleep(3000);
			for(int i=0;i<data;i++) {
				Utils.uBase.waitForElement(contact.get(i));
				text2[i]=contact.get(i).getText();
				time2[i]=timeStamp.get(i).getText();
			}
		}
		catch (Exception e)
		{                              
			AdvanceReporting.addLogs("info", "Unable to get text from list");
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}     
		return this;
	}

	public GeneralActivitiesPage getTextOfItemsInFirstList(int data)
	{
		try
		{
			Thread.sleep(5000);
			for(int i=0;i<data;i++) {
				Utils.uBase.waitForElement(contact.get(i));
				text[i]=contact.get(i).getText();
				time[i]=timeStamp.get(i).getText();
			}
			AdvanceReporting.addLogs("pass", "text in first item:"+text2);
			AdvanceReporting.addLogs("pass", "text in first item:"+text2, "TextInMessage");
		}
		catch (Exception e)
		{                              
			AdvanceReporting.addLogs("info", "text not in first item");
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}     
		return this;
	}

	public GeneralActivitiesPage compareLists() {
		try {
			if(Arrays.equals(text, text2)&&Arrays.equals(time, time2)) {
				AdvanceReporting.addLogs("pass", "Verified that the item is added to and listed in the required folder.");
				AdvanceReporting.addLogs("pass", "Verified required folder", "Verified required folder");
			}
			else {
				AdvanceReporting.addLogs("fail", "miss match");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}
		return this;
	}

	//Audio file is displayed
	public GeneralActivitiesPage verifyAudioFileIsDisplayed(){
		try {
			SoftAssert Assert= new SoftAssert();
			Thread.sleep(2000);
			Assert.assertEquals(true, Utils.uBase.imageCompare("audioFile"));
			AdvanceReporting.addLogs("Pass", "Audio file is displayed with play button and duration");
			AdvanceReporting.addLogs("Pass", "Audio file is displayed with play button and duration","Audio file is displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Audio file is not displayed with play button and duration");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Verify Play and Pause button
	public GeneralActivitiesPage clickPlayNPause(){
		try {
			Utils.uBase.clickByImage("PlayBtn");
			AdvanceReporting.addLogs("Pass", "Audio is playing");
			AdvanceReporting.addLogs("Pass", "Audio is playing","Audio is playing");
			Utils.uBase.clickByImage("PauseBtn");
			AdvanceReporting.addLogs("Pass", "Audio is paused");
			AdvanceReporting.addLogs("Pass", "Audio is paused","Audio is paused");


		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Audio can be played and paused at any time");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Verify Play and Pause button
	public GeneralActivitiesPage clickPause(){
		try {
			if(Utils.uBase.imageCompare("PauseBtn"))
			{
				Utils.uBase.clickByImage("PauseBtn");
				AdvanceReporting.addLogs("Pass", "Audio is paused");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Audio can be paused at any time");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Verify progress bar is displayed
	public GeneralActivitiesPage verifyProgressBar(){
		try {
			SoftAssert Assert= new SoftAssert();
			Utils.uBase.clickByImage("PlayBtn");
			if(Utils.uBase.imageCompare("PauseBtn"))
			{
				Assert.assertEquals(true, Utils.uBase.imageCompare("ProgressBar"));
				AdvanceReporting.addLogs("Pass", "Progress bar is displayed");
				AdvanceReporting.addLogs("Pass", "Progress bar is displayed","Progress bar is displayed");

			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Progress bar is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Verify once progress bar is done Audio file is displayed
	public GeneralActivitiesPage verifyProgressBarIsDoneAudioDisplayed(){
		try {
			Thread.sleep(2000);
			SoftAssert Assert= new SoftAssert();
			if(Utils.uBase.imageCompare("ProgressBarBtn"))
			{
				Thread.sleep(2000);
				Assert.assertEquals(true, Utils.uBase.imageCompare("audioFile"));
				AdvanceReporting.addLogs("Pass", "Audio file is displayed");
				AdvanceReporting.addLogs("Pass", "Audio file is displayed","Audio file is displayed");

			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Audio file is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Unsupported file is displayed
	public GeneralActivitiesPage verifyUnsupportedFileIsDisplayed(){
		try {
			Utils.uBase.refresh();
			Thread.sleep(6000);
			//Utils.uBase.takeScreenshotOfWebelement(unsupported, "unsupported");
			Assert.assertEquals(true, Utils.uBase.imageCompare("unsupported"));
			AdvanceReporting.addLogs("Pass", "File Not supported is displayed");
			AdvanceReporting.addLogs("Pass", "File Not supported is displayed","File Not supported is displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "File Not supported is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//to get text from list of items in calls page
	public GeneralActivitiesPage listInCallsPage(int countOfCallItems) {
		try {
			Thread.sleep(3000);
			for(int i=0;i<countOfCallItems;i++) {
				Utils.uBase.waitForElement(callName.get(i));
				text[i]=callName.get(i).getText();
				//time[i]=timeStamp.get(i).getText();
				callName.get(i).click();
				time[i]=callTime.getText();

			}
			AdvanceReporting.addLogs("info", "text from calls page is taken");

		}catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//to get text of calls from spam or archive page
	public GeneralActivitiesPage listOfCallsInOtherPage(int countOfCallItems) {
		try {
			Thread.sleep(3000);
			for(int i=0;i<countOfCallItems;i++) {
				Utils.uBase.waitForElement(callName.get(i));
				text2[i]=callName.get(i).getText();
				callName.get(i).click();
				time2[i]=callTime.getText();
			}
			AdvanceReporting.addLogs("info", "text from other page is taken");
			AdvanceReporting.addLogs("info", "text from other page is taken","text from other page is taken");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//to get text from list of items in calls page
	public GeneralActivitiesPage listInCallsPageAfterSpam(int countOfCallItems) {
		try {
			Thread.sleep(3000);
			for(int i=0;i<countOfCallItems;i++) {
				Utils.uBase.waitForElement(callName.get(i));
				text[i]=callName.get(i).getText();
				callName.get(i).click();
				//timeAfterSpam[i]=timeStamp.get(i).getText();
				time2[i]=callTime.getText();
				
			}
			AdvanceReporting.addLogs("info", "text from calls page is taken");

		}catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public GeneralActivitiesPage compareListsAfterSpam() {
		try {
			if((Arrays.equals(text, calltime)&&Arrays.equals(time,time2))==false) {
				AdvanceReporting.addLogs("pass", "Verified that the item is removed from the folder.");
			}
			else {
				AdvanceReporting.addLogs("fail", "miss match");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}
		return this;
	}

	public GeneralActivitiesPage verifyItemsRemoved() {
		try {
			if(Arrays.equals(text, text2)&&Arrays.equals(time, time2)) {
				AdvanceReporting.addLogs("fail", "Item is not removed from the folder");
			}
			else {
				AdvanceReporting.addLogs("pass", "Verified that item is removed from the folder");
				AdvanceReporting.addLogs("pass", "Item is removed from the folder", "Verified required folder");

			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}
		return this;
	}

	// Method to clear data in spam
	public GeneralActivitiesPage removeItemsFromSpam() {
		try {
			Utils.uBase.clickWebelement(menuSpamIcon);
			if(Utils.uBase.isElementPresent_locator(By.xpath("//div[@aria-selected='false']//div[contains(@ng-class,'AVATAR_PICTURE')]"))){
				for(WebElement avtar: avtarList) {
					Utils.uBase.clickWebelement(avtar);}
				if(Utils.uBase.isElementPresent_webelement(unSpamIcon)) {
					Utils.uBase.clickWebelement(unSpamIcon);
				}
			}
			Thread.sleep(2000);
			Utils.uBase.refresh();
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public GeneralActivitiesPage verifyClickOnMultipleAvatars() {
		try {
			if(Utils.uBase.imageCompare("multipleAvatarselect")==true) {
				AdvanceReporting.addLogs("pass", "Verified that multiple avatars are selected");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Multiple avatars are not selected");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public GeneralActivitiesPage verifyCountDecrementOnReselect() {
		try {
			String temp=batchSelectCount.getText();
			char temp2 = temp.charAt(0);
			int result = Character.getNumericValue(temp2);
			Thread.sleep(2000); 
			for(int i=1;i<result;i++) {
				AvatarsList.get(i).click(); 
				AdvanceReporting.addLogs("pass", "selection", "selection");
				String temp3=batchSelectCount.getText();
				char temp4 = temp3.charAt(0);
				int result2 = Character.getNumericValue(temp4);
				if(result>result2) {
					AdvanceReporting.addLogs("pass", "Verified that decremented on reselecting"); } 
				else
						AdvanceReporting.addLogs("fail", "Decrementation not occured"); } 
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Multiple avatars are not selected");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public GeneralActivitiesPage clickOnMultipleAvatars() {
		try {
			int count=3;
			for(int i =0; i<count ; i++)
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
	public void receiveMultipleMessages(String email,String password,String data,int count) throws Exception {
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		HomePageWeb HomePageWeb= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		Thread.sleep(3000);
		//System.out.println("Entered");
		removeItemsFromSpam();
		Utils.uBase.clickOnNotificationAllowBtn();
		HomePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		hmPage.clickMainMenu().clickMessages();
		msgPage.clickSendNewMessage().typeNumberinMsgToField(data).typeTestMsg().sendComposedMessage();
		for(int i=0;i<count-1;i++) {
		msgPage.typeTestMsg().sendComposedMessage();
		}
		Utils.uBase.switchToOldWindow();
		    Utils.uBase.refresh();
		}
	public void receiveMultipleCalls(String email,String password,String data,int count) throws Exception {
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb HomePageWeb= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		Thread.sleep(3000);
		removeItemsFromSpam();
		Utils.uBase.clickOnNotificationAllowBtn();
		HomePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		for(int i=0;i<count;i++) {
		callsPage.EnteraNameOrNum().enterNumAndMakeAcall(data).clickOnCallEndBtn();
		}
		Utils.uBase.switchToOldWindow();
		    Utils.uBase.refresh();
		}
		public void receiveMultipleVoicemails(String email,String password,String data,int count) throws Exception {
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb HomePageWeb= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		Thread.sleep(3000);
		removeItemsFromSpam();
		Utils.uBase.clickOnNotificationAllowBtn();
		HomePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		for(int i=0;i<count;i++) {
		callsPage.EnteraNameOrNum().enterNumAndMakeAcall(data);
		Thread.sleep(30000);
		callsPage.clickOnCallEndBtn();
		}
		Utils.uBase.switchToOldWindow();
		    Utils.uBase.refresh();
		}
		public void receiveUniqeMessage(String email,String password,String data,int count) throws Exception {
			GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
			HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
			MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
			HomePageWeb HomePageWeb= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
			Thread.sleep(3000);
			//System.out.println("Entered");
			removeItemsFromSpam();
			Utils.uBase.clickOnNotificationAllowBtn();
			HomePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
			gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
			hmPage.clickMainMenu().clickMessages();
			msgPage.clickSendNewMessage().typeNumberinMsgToField(data).typeUniqeMsg().sendComposedMessage();
			for(int i=0;i<count-1;i++) {
			msgPage.typeTestMsg().sendComposedMessage();
			}
			Utils.uBase.switchToOldWindow();
			    Utils.uBase.refresh();
			}
		public GeneralActivitiesPage clickCallButton() throws Exception
	       {
	              try
	              {
	                     Thread.sleep(2000);
	                     //Utils.uBase.isElementPresent_webelement(callIcon);
	                     Utils.uBase.clickWebelement(callIcon);
	                     Utils.uBase.clickOnNotificationAllowBtn();
	                     AdvanceReporting.addLogs("pass", "Clicked on Call icon");
	              } 


	              catch (Exception e)
	              {
	                     AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
	                     e.printStackTrace(); Assert.fail();
	              }
	              return this;
	       }


	       public GeneralActivitiesPage verifyDailpadKeypad() { 
	              try
	              {
	                     if(Utils.uBase.imageCompare("dailpadkeypad")==true){
	                           AdvanceReporting.addLogs("pass", "User able to see dailpad keypad");
	                           AdvanceReporting.addLogs("pass", "User able to see dailpad keypad","dailpadkeypad");
	                     }
	              }
	              catch (Exception e)
	              {
	                     AdvanceReporting.addLogs("info", "User not able to see dailpad keypad");
	                     AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
	                     e.printStackTrace(); Assert.fail();
	              }
	              return this;

	       }
	       public GeneralActivitiesPage verifycontactItemInList()
	       {
	              try
	              {
	                     if(Utils.uBase.isElementPresent_webelement(listItem.get(0))) {

	                           AdvanceReporting.addLogs("info", "user able to see contact");
	                     }
	              }
	              catch (Exception e)
	              {
	                     AdvanceReporting.addLogs("info", "user not able to see contact");
	                     AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
	                     e.printStackTrace(); Assert.fail();

	              }
	              return this;
	       }
	       public GeneralActivitiesPage verifyMessageDetails()
	       {
	              try
	              {
	                     if(Utils.uBase.isElementPresent_webelement(msgDetails)) {
	                           AdvanceReporting.addLogs("info", "user able to see Message details");
	                     }
	              }
	              catch (Exception e)
	              {
	                     AdvanceReporting.addLogs("info", "user not able to see Message details");
	                     AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
	                     e.printStackTrace(); Assert.fail();

	              }
	              return this;
	       }
	       public GeneralActivitiesPage verifyContactDetails()
	       {
	              try
	              {
	                     if(Utils.uBase.isElementPresent_webelement(contactDetails)) {
	                           AdvanceReporting.addLogs("info", "user able to see contact details");
	                     }
	              }
	              catch (Exception e)
	              {
	                     AdvanceReporting.addLogs("info", "user not able to see contact details");
	                     AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
	                     e.printStackTrace(); Assert.fail();

	              }
	              return this;
	       }
	       public GeneralActivitiesPage verifycallTimeDetails()
	       {
	              try
	              {
	                     if(Utils.uBase.imageCompare("callDetailsExpanded")==true){
	                           AdvanceReporting.addLogs("info", "user able to see calltime details");
	                     }
	              }
	              catch (Exception e)
	              {
	                     AdvanceReporting.addLogs("info", "user not able to see calltime details");
	                     AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
	                     e.printStackTrace(); Assert.fail();

	              }
	              return this;
	       }
	       
	       public GeneralActivitiesPage verifyMessageIcon()
	       {
	              try
	              {
	                     if(Utils.uBase.isElementPresent_webelement(msgIcon)) {
	                           AdvanceReporting.addLogs("info", "user able to see contact details");
	                     }
	              }
	              catch (Exception e)
	              {
	                     AdvanceReporting.addLogs("info", "user not able to see contact details");
	                     AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
	                     e.printStackTrace(); Assert.fail();

	              }
	              return this;
	       }

}
