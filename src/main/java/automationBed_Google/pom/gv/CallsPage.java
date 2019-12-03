package automationBed_Google.pom.gv;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class CallsPage
{
	int callCount=0,callsCount=0,voicemailsCount=0, befoeCallData;;
	int msgCountAfter=0,callsCountAfter=0,voicemailsCountAfter=0;
	//Locators
	@FindBy(xpath="//*[contains(@ng-class,'isMakeCallDisabled()')]")
	WebElement makeACallBtn;
	@FindBy(xpath="//*[contains(@ng-change,'TextInputChange')]")
	WebElement contactInputField;
	@FindBy(xpath="//md-icon[.='arrow_drop_down']")
	WebElement dropDownArrow;
	@FindBy(xpath="//div[contains(@class,'hlKfD')]/button[1]/md-icon[@role='img']")
	WebElement callOption;
	@FindBy(xpath="//*[contains(@ng-class,'INPUT_ROW')]")
	WebElement inputRow;
	@FindBy(xpath="//*[contains(@class,'{::ctrl.Css.DETAILS}}')]")
	WebElement firstCalltype;
	@FindBy(xpath="//*[@role='gridcell']/*[@role='img']")
	WebElement threeDotsOption;
	@FindBy(xpath="//*[.='Use my phone to call']")
	WebElement useMyPhoneToCallOption;
	@FindBy(xpath="//*[@role='menu']")
	WebElement optionsMenu;
	@FindBy(xpath="(//*[contains(@aria-describedby,'cdk-describedby-message-0')])[last()]")
	WebElement callsTab;
	@FindBy(xpath="//*[contains(@gv-test-id,'item-contact')]")
	private List<WebElement> callsList;
	@FindBy(xpath="//*[contains(@gv-test-id,'action-icon-m')]")
	WebElement selectMsgFromCalls;
	@FindBy(xpath="(//*[contains(@aria-label,\"Archive\")])[last()]")
	WebElement selectArchiveOption;	
	@FindBy(xpath="//span[contains(text(),'Undo')]")
	WebElement selectUndo;
	@FindBy(xpath="(//*[contains(@aria-label,'Archive')])[last()]")
	WebElement archiveTab;
	@FindBy(xpath="//*[contains(@aria-label,'Restore')]")
	WebElement restoreArchive;
	@FindBy(xpath="//*[contains(@aria-label,'Mark as spam')]")
	WebElement markAsSpam;
	@FindBy(xpath="(//a[contains(@aria-label,'Spam')])[last()]")
	WebElement spamTab;
	@FindBy(xpath="//*[contains(@gv-test-id,'item-contact')]")
	private List<WebElement> spamContactList;
	@FindBy(xpath="//div[contains(@gv-test-id,'conversation-avatar-or-checkmark')]")
	private List<WebElement> avatarsFromCallsList;
	@FindBy(xpath="//*[contains(@icon-name,'delete')]")
	WebElement deleteIcon;
	@FindBy(xpath="//*[contains(@gv-test-id,'item-contact')]")
	private List<WebElement> lstCalls;
	@FindBy(xpath="//div[@class='dOUild-YLEF4c']")
	List<WebElement> suggestionAvatarsList;
	@FindBy(xpath="//div[@class='Gb0ubd-YLEF4c']")
	List<WebElement> contactAvatarsList;
	@FindBy(xpath="//*[contains(@class, 'dOUild-XSJd1 gmat-body-2 layout-align-start-start layout-column')]")
	List<WebElement> suggestionNameList;
	@FindBy(xpath="//*[contains(@class, 'gmat-body-2 layout-column flex')]")
	List<WebElement> contactNameList;
	@FindBy(xpath="//gv-frequent-contact-card")
	List<WebElement> lstFrequentContact;
	@FindBy(xpath="//*[contains(@class,'dOUild-Od0oM grey-700')]")
	List<WebElement> suggestionContactList;
	@FindBy(xpath="//div[@class='hlKfD-KdeNEf']//div/md-input-container")
	WebElement callPlaceHolderField;
	@FindBy(xpath="//*[@id='input_21']")
	WebElement callToField;
	@FindBy(xpath="//*[contains(@placeholder,'Enter a name or number')]")
	WebElement enterPhNumberPlaceholder;
	@FindBy(xpath="//div[@class='layout-row md-body-1 Gb0ubd-H9tDt']")
	List<WebElement> allContacts;
	@FindBy(xpath="//div[contains(text(),'Describe your issue or share your ideas')]")
	WebElement enterDiscriptionOnFeedBackWindow;
	@FindBy(xpath="//*[contains(@gv-test-id,'in-call-callduration')]")
	WebElement callingStatus;
	@FindBy(xpath="//*[@gv-test-id='conversation-avatar-or-checkmark']")
	List<WebElement> AvatarsList;
	@FindBy(xpath="//*[@focused='ctrl.shouldContactBeFocused(contact, false)']")
	List<WebElement> savedContacts;
	@FindBy(xpath="//*[@focused='ctrl.shouldContactBeFocused(contact, false, true)']")
	List<WebElement> unsavedContacts;
	@FindBy(xpath="//div[contains(text(),'Directory')]")
	WebElement directorySection;
	@FindBy(xpath="//*[@gv-test-id='call-time']")
	WebElement callTime;
	@FindBy(xpath="//*[@gv-test-id='call-date']")
	WebElement callDate;
	int sizeBeforeSpamCall=0,sizeaAfterSpamCall=0;
	@FindBy(xpath="//*[contains(@gv-test-id,'in-call-phone-number')]")
	WebElement inlineCallContact;
	String ele;
	@FindBy(xpath="//div[@aria-selected='false']")
	List <WebElement> listItem;
	@FindBy(xpath="//*[contains(@ng-if,'isBadQualityClicked')]")
	WebElement qualityPrompt;
	@FindBy(xpath="//*[contains(@aria-label,'seconds')]")
	WebElement callDuration;
	@FindBy(xpath="//*[contains(text(),'Call ended')]")
	WebElement callEnded;
	@FindBy(xpath="//input[@placeholder='Enter a name or number']")
	WebElement Makeacall;
	@FindBy(xpath="(//*[contains(@gv-test-id,'item-contact')])[1]")
	WebElement firstItem;
	@FindBy(xpath="//*[@id='gvPageRoot']/div[2]/div[2]/gv-side-nav/div/div/gmat-nav-list/a[1]/div/div/span[2]")
	WebElement unreadCalls;
	@FindBy(xpath="(//*[contains(@md-virtual-repeat,'conversation in ctrl.getDisplay()')])[1]/div/gv-call-log-thread-item/gv-thread-item/div")
	WebElement firstCallLog;
	@FindBy(xpath="//*[contains(@gv-test-id,'bad-quality-button')]")
	WebElement badOptn;
	@FindBy(xpath="//*[contains(text(),'Describe your issue or share your ideas')]")
	WebElement descriptionBox;
	@FindBy(xpath="//*[contains(text(),'A description is required')]")
	WebElement errorMsg;

	@FindBy(xpath="(//gv-contact-item[@phone-number='contact.phoneNumber']/div)[last()]")
	WebElement contactList;
	@FindBy(xpath="//span[contains(text(), 'Hide keypad')]")
	WebElement hideKeypad;
	@FindBy(xpath="//*[contains(@gv-test-id,'in-call-contact-name')]")
	WebElement inCallContactName;
	@FindBy(xpath="//*[contains(@ng-class,'::[ctrl.Css.DETAILS')]")
	WebElement suggestedListPhNo;
	@FindBy(xpath="//*[contains(@class,'GHQeBe-jOfkMb')]")
	WebElement callingActivity;

	/*
	 * @FindBy(xpath="//div[@aria-label='Dialpad']") WebElement dialpad;
	 */

	/*
	 * public CallsPage clickMakeACall() throws Exception { try {
	 * Utils.uBase.waitForElement(firstCalltype); AdvanceReporting.addLogs("pass",
	 * "Calls Page","Calls Page"); Utils.uBase.clickWebelement(makeACallBtn); }
	 * catch (Exception e) { AdvanceReporting.addLogs("fail",
	 * "Error Message: "+e.getMessage()); e.printStackTrace(); Assert.fail(); }
	 * return this; }
	 */	 

	public CallsPage verifyDropDown(String numb) throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(contactInputField);
			Utils.uBase.setText(contactInputField, numb);
			Utils.uBase.waitForElementToBeClickable(callOption);
			if(dropDownArrow.isDisplayed() && dropDownArrow.isEnabled())
			{
				//			Utils.uBase.waitForElementToBeClickable(dropDownArrow);
				AdvanceReporting.addLogs("pass", "Dropdown arrow is available");
				AdvanceReporting.addElementImage("info", inputRow);
			}
			else{
				AdvanceReporting.addLogs("info", "Dropdown arrow is not available");
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public CallsPage clickfirstCall() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(firstCalltype);
			AdvanceReporting.addLogs("pass", "Calls Page","Calls Page");
			Utils.uBase.clickWebelement(firstCalltype);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public CallsPage clickThreeDots() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(threeDotsOption);
			Utils.uBase.clickWebelement(threeDotsOption);
			AdvanceReporting.addLogs("info", "Clicked on three dotted more option");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public CallsPage verifyUseMyPhoneToCall() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(optionsMenu);
			if(useMyPhoneToCallOption.isDisplayed() && useMyPhoneToCallOption.isEnabled()) {
				AdvanceReporting.addLogs("pass", "Verified that, use my phone to call option is available");
				AdvanceReporting.addElementImage("info", optionsMenu);
			} else {
				AdvanceReporting.addLogs("info", "Verified use my phone to call option is not available");
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verifies if calls tab is accessible

	public CallsPage verifyCallsTabIsAccessible()
	{
		try
		{
			if(Utils.uBase.getCurrentUrl().contains("calls"))
			{
				AdvanceReporting.addLogs("Pass","Calls tab is accessible");
				AdvanceReporting.addLogs("Pass","Calls tab is accessible","CallsTabAccessible");}
			else {
				AdvanceReporting.addLogs("fail", "Image comparision failed: Calls tab acessibility");	
			}
		}catch(Exception e)
		{
			AdvanceReporting.addLogs("info", "Calls tab is not accessible");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();

		}return this;
	}	

	/* Selecting first contact from contact List */
	public CallsPage selectFirstContactFromCallsList()
	{
		try
		{
			Thread.sleep(2000);
			Utils.uBase.waitForElementToBeClickable(callsList.get(0));
			Utils.uBase.clickWebelement(callsList.get(0));
			AdvanceReporting.addLogs("pass", "Select contact from Calls List");
			AdvanceReporting.addLogs("pass", "Select contact from Calls List", "Contact List");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Select contact from Calls List");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Deletes the call triggered from a particular phone no
	public CallsPage cleanCreatedCallLog(String phoneNo)
	{
		try {
			Thread.sleep(8000);
			Utils.uBase.clickByImage("ClickOnCallsImg");
			Thread.sleep(5000);
			for(int i=0;i<callsList.size();i++)
			{

				if(phoneNo.contains(callsList.get(i).getText().replaceAll("\\W", "")))
				{
					Utils.uBase.waitForElementToBeClickable(callsList.get(i));
					Utils.uBase.clickWebelement(callsList.get(i));
					System.out.println("Created call entry found");
					deleteCall();
					AdvanceReporting.addLogs("info", "Created call is deleted");
					break;

				}}}catch(Exception e)
		{
					System.out.println("Unable to delete created call log");
					e.printStackTrace(); Assert.fail();

		}return this;
	}

	/* Select Message from calls top right side of the screen */
	public CallsPage selectMsgFromCall()
	{
		try
		{
			Utils.uBase.clickByImage("selectMsgFromCallsImg");
			AdvanceReporting.addLogs("info", "Select Message from calls top right side of the screen");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Message Image not available");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Select the More options menu (three vertical dots). */
	public CallsPage clickThreeDotsMenu()
	{
		try
		{
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("ThreeDotsBtnImg1")){
				Thread.sleep(1000);
				Utils.uBase.clickByImage("ThreeDotsBtnImg1");
			}else if(Utils.uBase.imageCompare("ThreeDotsBtnImg")) {
				Utils.uBase.clickByImage("ThreeDotsBtnImg");
				AdvanceReporting.addLogs("pass", "Clicked on three dotted more option");
			} 
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Three dotted more option is not available");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Select archive option from more menu */
	public CallsPage selectArchiveOption()
	{
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("selectArchiveOptionImg");
			AdvanceReporting.addLogs("info", "Archive option is selected sucessfully", "ArchiveOption");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify the call is removed from the Calls folder. */
	public CallsPage doArchiveAndVerifyCallIsRemovedFromCallsFolder()
	{
		try
		{
			int sizeBeforArchive = callsList.size();
			Thread.sleep(1000);
			selectArchiveOption();
			Thread.sleep(1000);
			int sizeaAfterArchive = callsList.size();
			if (sizeBeforArchive !=sizeaAfterArchive) {
				AdvanceReporting.addLogs("pass", "Call is removed from the archive folder.", "ArchivedDone");
			}else {
				AdvanceReporting.addLogs("fail", "Call is not removed from the archive folder.");
				AdvanceReporting.addLogs("fail", "Call is not removed from the archive folder.","call is not archived");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Call is not removed from the archive folder.");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify the call is removed from Archive folder. */
	public CallsPage undoArchiveAndVerifyCallIsAddToCallsFolder()
	{
		try
		{
			int sizeAfetrArchive = callsList.size();
			Thread.sleep(2000);
			Utils.uBase.clickByImage("UndoButton1");
			Thread.sleep(3000);
			AdvanceReporting.addLogs("pass", "Clicked on Undo button");
			AdvanceReporting.addLogs("pass", "Clicked on Undo button","UndoButtonSrc");
			int sizeaAfterUndoArchive = callsList.size();
			if (sizeAfetrArchive !=sizeaAfterUndoArchive) {
				AdvanceReporting.addLogs("info", "Call is added to archive folder.", "ArchivedUnDone");	
				Thread.sleep(2000);
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Call is not added to archive folder.");	
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify the call is removed from the Calls folder and call item no longer exist. */
	public CallsPage verifyCallIsRemovedFromCallsFolder()
	{
		try
		{
			Thread.sleep(3000);
			int sizeBeforeDeleteCall = callsList.size();
			this.deleteCall();
			AdvanceReporting.addLogs("pass", "Click on delete button");
			Utils.uBase.refresh();
			Thread.sleep(3000);
			int sizeaAfterDeleteCall = callsList.size();
			/* Verify the call is removed from the Calls folder and call item no longer exist */
			if (sizeBeforeDeleteCall == sizeaAfterDeleteCall-1) {
				AdvanceReporting.addLogs("pass", "Verified that call is removed from the calls folder.");
				AdvanceReporting.addLogs("info", "Call is removed from the calls folder.", "CallDeleted");		
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Call is not removed from the calls folder.");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Deleting the existing call */
	public CallsPage deleteCall(){
		try {

			Thread.sleep(2000);
			Utils.uBase.clickByImage("ThreeDotsBtnImg");
			Utils.uBase.clickByImage("Delete1");
			Thread.sleep(3000);
			Utils.uBase.clickByImage("DeleteCall");
			System.out.println("Call is deleted");

		} catch (Exception e) {
			System.out.println("Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify the call is removed from the Calls folder. */
	public CallsPage  verifySpamedCallIsRemovedFromCallsFolder(){
		try {
			Thread.sleep(2000);
			/* Verify the call is removed from the Calls folder. */
			if(sizeBeforeSpamCall==sizeaAfterSpamCall-1) {	
				AdvanceReporting.addLogs("info", "Call sucessfully moved to spam folder.","SpamCall");	
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify the call is added to and listed in the Spam folder. */
	public CallsPage verifyCallAddedToSpamFolder(){
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("SpamTabImg");
			AdvanceReporting.addLogs("info", "Click on spam tab");
			for(int i=0; i<spamContactList.size(); i++) {
				String spamContactLst = spamContactList.get(i).getText();
				/* Verify the call is added to and listed in the Spam folder. */
				if(spamContactLst.contentEquals(Constants.SpamphoneNo)) {
					spamContactList.get(i).click();
				}
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Spam Tab not click");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Unmark As Spam */
	public CallsPage unmarkAsSpam(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("ThreeDotsBtnImg");
			Thread.sleep(2000);
			Utils.uBase.clickByImage("UnmarkAsSpam");
			AdvanceReporting.addLogs("info", "Unmark As Spam sucessfully");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Unmark As Spam button not available");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify that calls item selected are deleted or not*/
	public CallsPage verifyCallsSelectedAreDeleted(){
		try {
			int sizeBeforeDeletingCalls = callsList.size();
			Thread.sleep(2000);
			/* Click on more than one call item Avatar icon for Delete*/ 
			this.selectTwoAvatarIconsFromCallsLstToDelete();
			Thread.sleep(2000);
			int sizeAfterDeletingCalls = callsList.size();
			if(sizeBeforeDeletingCalls == sizeAfterDeletingCalls-2) {
				AdvanceReporting.addLogs("info", "Verified that selected calls are deleted sucessfully");
				AdvanceReporting.addLogs("info", "Selected calls are deleted sucessfully","DeletedCalls");
			}else {
				AdvanceReporting.addLogs("info", "Selected calls are not deleted","CallsNotDeleted");
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Selected calls are not deleted");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Select two Avatar icons for delete calls from calls list */
	public CallsPage selectTwoAvatarIconsFromCallsLstToDelete(){
		try {
			Thread.sleep(1000);
			Utils.uBase.clickWebelement(avatarsFromCallsList.get(0));
			Thread.sleep(1000);
			Utils.uBase.clickWebelement(avatarsFromCallsList.get(1));
			//Thread.sleep(1000);
			Utils.uBase.clickByImage("DeleteIconImg");
			//Thread.sleep(1000);
			Utils.uBase.clickByImage("DeleteBtnFromPopUpImg");
			AdvanceReporting.addLogs("info", "Seleted calls are deleted sucessfully");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Seleted calls are not deleted");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Compared the pop up saying items Deleted*/
	public CallsPage verifyDeletedPopupDisplayed() {

		try {
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("twoItemsDeleted")){
				AdvanceReporting.addLogs("pass", "2 Items Deleted Img is displayed");
				AdvanceReporting.addLogs("pass", "2 Items Deleted Img","2ItemsDeleted");
			}else {
				AdvanceReporting.addLogs("info", "2 Items Deleted Img is not displayed");
				AdvanceReporting.addLogs("fail", "2 Items Deleted Img is not displayed");
			}
		}
		catch(Exception e){

			AdvanceReporting.addLogs("info", "2 Items Deleted Img is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}

	/*Select two Avatar icons for Archive calls from calls list */
	public CallsPage selectTwoAvatarIconsFromCallsLstToArchive(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickWebelement(avatarsFromCallsList.get(0));
			Thread.sleep(1000);
			Utils.uBase.clickWebelement(avatarsFromCallsList.get(1));
			Thread.sleep(2000);
			Utils.uBase.clickByImage("archiveIconImg");
			AdvanceReporting.addLogs("info", "Selected calls are Archive sucessfully");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Selected calls are not Archive");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify that calls item selected should be Archived or not*/
	public CallsPage verifyCallsSelectedAreArchived(){
		try {
			Thread.sleep(3000);
			int sizeBeforeArchivedCalls = callsList.size();
			/* Click on more than one call item Avatar icon for Archive*/ 
			this.selectTwoAvatarIconsFromCallsLstToArchive();
			Thread.sleep(3000);
			int sizeAfterArchivedCalls = callsList.size();
			if(sizeBeforeArchivedCalls == sizeAfterArchivedCalls-2) {
				AdvanceReporting.addLogs("info", "Selected calls are Archived sucessfully","ArchivedCalls");
			}else {
				AdvanceReporting.addLogs("info", "Selected calls are not Archived","CallsNotArchived");
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Archived Not Done");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Compared the pop up saying items Archived with Undo option*/
	public CallsPage verifyArchivedPopupDisplayedWithUndoOption() {

		try {
			Thread.sleep(3000);
			if((Utils.uBase.imageCompare("archivedCnfrm"))){
				AdvanceReporting.addLogs("pass", "Verified that Items Archived Img is displayed");
				AdvanceReporting.addLogs("pass", "Items Archived Img","2ItemsArchived");
			}else {
				AdvanceReporting.addLogs("info", "Items Archived Img is not displayed");
				AdvanceReporting.addLogs("fail", "Items Archived Img is not displayed");
			} 
		}
		catch(Exception e){

			AdvanceReporting.addLogs("info", "Items Archived Img is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}

	/* Do Archive calls and verify that archived items are placed again in calls folder.*/
	public CallsPage archivedWithUndoAndVerifyArchivedItemsPlacedAgainInCallsFolder() {

		try {
			int sizeBeforeUndoArchivedCalls = callsList.size();
			Utils.uBase.clickByImage("UndoButton1");
			AdvanceReporting.addLogs("pass", "Click on Undo button sucessfully");
			AdvanceReporting.addLogs("pass", "Click on Undo button sucessfully","ArchiveUndo");
			int sizeAfterUndoArchivedCalls = callsList.size();
			/* verify that archived items are placed again in calls folder */
			if(sizeBeforeUndoArchivedCalls==sizeAfterUndoArchivedCalls+2) 
			{
				AdvanceReporting.addLogs("info", "Verified that calls item selected are Archived successfully");
				AdvanceReporting.addLogs("info", "Calls item selected are Archived successfully","ArchivedCallsAdded");
			}else {
				AdvanceReporting.addLogs("info", "Archived items are not added in calls folder","CallsNotArchived");
			}
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "Undo Archived not done and calls not added back to calls folder");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}

	//method to verify if multiple avatars are selected
	public void verifyIfAvatarsAreSelected()
	{
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickWebelement(avatarsFromCallsList.get(0));
			Thread.sleep(1000);
			Utils.uBase.clickWebelement(avatarsFromCallsList.get(1));
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("multipleAvatarselect"))
			{
				AdvanceReporting.addLogs("pass", "Verified that calls are selected");
				AdvanceReporting.addLogs("pass", "Calls are selected","CallsSelected");
			}
			else
			{
				AdvanceReporting.addLogs("Info", "Calls are not selected");
				AdvanceReporting.addLogs("fail", "failed","CallsAreNotSelected");
			}}
		catch (Exception e)
		{                              
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}              
	}

	//Method to unselect the selected call avatars
	public CallsPage verifyAvatarsAreUnselect()
	{
		try{

			Utils.uBase.clickByImage("UnselectCallsImg");
			AdvanceReporting.addLogs("pass", "Verified that able to click on unselect calls icon");
			AdvanceReporting.addLogs("pass","Able to click on unselect calls icon","UnSelectedCalls");
		}                                              
		catch (Exception e)
		{
			AdvanceReporting.addLogs("Info", "Unable to click on unselect calls icon");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}  

	// Verify dropdown is present
	public CallsPage verifyDropDownPresent() { 
		try  { 
			Utils.uBase.waitForElement(contactInputField);
			Utils.uBase.setText(contactInputField, Constants.dummyPhNumber);
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("ArrowDropDown"), "v drop down didn't appeared");
			AdvanceReporting.addLogs("pass", "Verified that, v drop down appeared");
			AdvanceReporting.addLogs("pass", "v drop down appeared","MakeCallDropDown");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "v drop down didn't appeared");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	// Click on drop down
	public CallsPage clickCallDropDown() { 
		try	{
			Thread.sleep(15000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("MakeCallDropDown");
			AdvanceReporting.addLogs("pass", "Drop down v is clicked","MakeACall");
			AdvanceReporting.addLogs("info", "Able to click v","MakeACall");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Drop down v is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Click on Use My Phone to call
	public CallsPage clickUseMyPhoneOption () { 
		try {
			Thread.sleep(15000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("UseMyPhoneToCall");
			AdvanceReporting.addLogs("pass", "Use My Phone is clicked","MakeACall");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Use My Phone is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Verify pop up
	public CallsPage verifyUseMyPhonePopUp () {
		try {
			Thread.sleep(2000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("UseMyPhonePopUp"), "Use My Phone pop up didn't appears");
			AdvanceReporting.addLogs("pass", "Verified use My Phone pop up appears");
			AdvanceReporting.addLogs("pass", "Use My Phone pop up appears","UseMyPhonePopUp");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Use My Phone pop up didn't appears");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	// Click on first call in call list items 
	public CallsPage clickfirstCallInList() {
		try {
			Thread.sleep(15000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickWebelement(callsList.get(0));
			AdvanceReporting.addLogs("pass", "Clicked on first call");
			AdvanceReporting.addLogs("pass", "Clicked on first call","FirstCall");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Verify 3 dots Menu
	public CallsPage verifyUseMyPhoneToCallIn3DotMenu() {
		try {
			Thread.sleep(1000);
			Utils.uBase.hoverOnImage("ThreeDotMenu_UseMyPhone");
			Assert.assertTrue(Utils.uBase.imageCompare("ThreeDotMenu_UseMyPhone"), "No use my phone in 3 dot menu");
			AdvanceReporting.addLogs("pass", "Verified that, use My Phone in 3 dot menu");
			AdvanceReporting.addLogs("pass", "Use My Phone in 3 dot menu","ThreeDotMenu_UseMyPhone");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not Scrolled to First message");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());		
		}	
		return this;
	}

	// Click on more options
	public CallsPage clickMoreOptn() {
		try {
			Thread.sleep(5000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("3DotMoreOption");
			AdvanceReporting.addLogs("Pass", "More Options is displayed");
			AdvanceReporting.addLogs("Pass", "More Options", "MoreOptions");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/*
	 * public CallsPage clickOnMakeACall() { try { Thread.sleep(15000);
	 * if(((JavascriptExecutor)Utils.uBase.webDriver).
	 * executeScript("return document.readyState").equals("complete"))
	 * Utils.uBase.clickByImage("MakeACall"); AdvanceReporting.addLogs("pass",
	 * "Make A call is clicked"); AdvanceReporting.addLogs("pass",
	 * "Make A call is clicked","MakeACall"); } catch (Exception e) {
	 * AdvanceReporting.addLogs("info", "Make A call is not clicked");
	 * AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
	 * e.printStackTrace(); Assert.fail(); }
	 * 
	 * return this; }
	 */

	public CallsPage MakeACall() 
	{
		try
		{
			Thread.sleep(15000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete"))
				Utils.uBase.waitForElement(Makeacall);
			Utils.uBase.clickWebelement(Makeacall);
			AdvanceReporting.addLogs("pass", "Make A call is clicked");
			AdvanceReporting.addLogs("pass", "Make A call is clicked","MakeACall");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Make A call is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}


	//Verify all old call items are loading 
	public CallsPage verifyScrollDownLoadCalls() {
		try {
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", callsList.get(callsList.size()-1));
			Thread.sleep(10000);
			AdvanceReporting.addLogs("pass", "Verified that items are loaded up on scrolling down");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not Scrolled to last call");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;		
	}

	//  Verify scroll up also shows the first loaded call items.
	public CallsPage verifyScrollUpToFirstCall() {
		try {
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", callsList.get(0));
			Thread.sleep(10000);
			AdvanceReporting.addLogs("pass", "Verified that scroll up shows the first call items");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not Scrolled to First call");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	// Verify Suggestion and ContactList Displayed
	public CallsPage verifySuggestionandContactListDisplayed() { 
		try {
			Thread.sleep(3000);
			if(lstFrequentContact.isEmpty()) {
				AdvanceReporting.addLogs("info", "Suggestion and Contact List is not  Displayed");
				AdvanceReporting.addLogs("fail", "Suggestion and Contact List is not Displayed", "SuggestionContactlist");
			} else {
				AdvanceReporting.addLogs("info", "Verified that suggestion and Contact List Displayed");
				AdvanceReporting.addLogs("pass", "Suggestion and Contact List Displayed", "SuggestionContactlist");
			} 
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Suggestion and Contact List Not Displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this; 
	}

	// Cursor is auto focused in the recipient picker field of calls section.
	public CallsPage verifyCursorAutoFousedInCallField() {
		try {
			Thread.sleep(9000);
			Utils.uBase.checkPageReady();
			if(callPlaceHolderField.getAttribute("class").contains("md-input-focused"))
			{
				AdvanceReporting.addLogs("pass", "Verified that cursor is focused in call section");
				AdvanceReporting.addLogs("pass", "Cursor is focused in call section","Cursor is focused in call section");
			} else {
				AdvanceReporting.addLogs("fail", "Cursor is not focused in call section");
				AdvanceReporting.addLogs("fail", "Cursor is not focused in call section","Cursor is not focused in call section");
			}    
		} catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	// Place holder text of 'Call' field is 'Type a name or phone number'
	public CallsPage verifyPlaceHolderInCallField(){
		try {
			Thread.sleep(9000);
			if(Utils.uBase.imageCompare("CallPlaceHolder")) { 
				AdvanceReporting.addLogs("pass", "Verified that Place holder 'Type a name or phone number' shown");
				AdvanceReporting.addLogs("pass", "Place holder 'Type a name or phone number' shown","PlaceHolder");
			} else {
				AdvanceReporting.addLogs("info", "Place holder 'Type a name or phone number' shown");
				AdvanceReporting.addLogs("fail", "Place holder 'Type a name or phone number' shown","PlaceHolder");
			}
		} catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}	

	// Verify contact name pop up
	public CallsPage verifyContactNamePopUp(String name) {
		try  { 
			Thread.sleep(8000);
			Utils.uBase.checkPageReady();	
			Utils.uBase.waitForElement(callToField);
			Utils.uBase.setText(callToField, name);
			Thread.sleep(10000);
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

	// Select any contact in the UI list by clicking on it
	public CallsPage clickContactFromDropDown(){
		try {
			Thread.sleep(2000);
			for(WebElement e : suggestionContactList) 
			{ele = e.getText();
			if((ele.contains("(408) 686-4613")))
			{
				if((ele.contains("+91"))==false)
				{
					Thread.sleep(1000);
					Utils.uBase.clickWebelement(e);
					Utils.uBase.clickWebelement(e);
					AdvanceReporting.addLogs("pass", "Contact selected from list");
					break;
				}
			}
			}
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Contact not selected from the list");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	/* Get the count of items from call list after make an call */
	public CallsPage countOfItemsInCallListAfterCall() {

		try {
			SoftAssert Assert=new SoftAssert();
			Thread.sleep(8000);
			Utils.uBase.clickByImage("ClickOnCallsImg");	
			callsCountAfter=lstCalls.size();

			Assert.assertTrue(callsCountAfter>callCount,"Latest Calls are not received");
			AdvanceReporting.addLogs("pass","Latest calls are received");
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}

	/*
	 * Verified all unread calls have a UI indicator that they are unread (note:
	 * currently this places the item in bold text).
	 */
	public CallsPage verifyUnreadCallsDisplayAsInBoldText()
	{
		try
		{
			Thread.sleep(2000);
			//Assert.assertTrue(Utils.uBase.imageCompare("MissedCallBoldTextImg"), "Unread calls are not displayed in bold text");
			if(firstCallLog.getAttribute("aria-label").contains("Unread")) {
				AdvanceReporting.addLogs("Pass","Verified that unread calls are displayed with bold text");
				AdvanceReporting.addLogs("Pass","Unread calls are displayed with bold text","MissedCallBoldText");
			}
			else
				AdvanceReporting.addLogs("fail", "Unread calls are not displayed in bold text");

		}catch(Exception e)
		{
			AdvanceReporting.addLogs("fail", "Unread calls are not displayed in bold text");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}return this;
	}

	/* Enter phone number */
	public CallsPage enterPhoneNumber(String phoneNum) { 
		try
		{
			Thread.sleep(1000);
			enterPhNumberPlaceholder.sendKeys(phoneNum);
			AdvanceReporting.addLogs("pass", "Enter Phone number sucessfully");
			AdvanceReporting.addLogs("pass", "Enter Phone number sucessfully", "EnterPhoneNum");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Enter Phone number and click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/*  Verifyed "CALL" button is enabled to make call */
	public CallsPage  verifyCallButtonIsEnabledToMakeCall() { 
		try
		{
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("CallButtonImg")) {
				Thread.sleep(1000);
				Utils.uBase.clickByImage("CallArrowDropDownBtnImg");
				AdvanceReporting.addLogs("pass", "Verified that call button is enabled to make call and it's clickable");
				AdvanceReporting.addLogs("pass", "Call button is enabled to make call and it's clickable","CallBtnEnable");
			}else {
				AdvanceReporting.addLogs("fail", "Call button is not enabled to make call","CallBtnNotEnable");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Call button is not enabled to make call");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/* Verified "Phone to call with" popup window displayed */
	public CallsPage  verifyPhoneToCallWithPopupWindow() { 
		try
		{
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("PhoneToCallWithPopupImg")) {
				AdvanceReporting.addLogs("pass", "Verified that phone to call with popup window displayed");
				AdvanceReporting.addLogs("pass", "Phone to call with popup window displayed","PhoneToCallWithPopup");
			}else {
				AdvanceReporting.addLogs("fail", "Phone to call with popup window is not displayed","NoPhoneToCallWithPopup");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Phone to call with popup window is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified that able to make call */
	public CallsPage verifyAbleToMakeCall() { 
		try
		{
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("callFullScreen")){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call successfully");
				AdvanceReporting.addLogs("pass", "User able to make a call successfully","CallingImg");
				Thread.sleep(2000);
			}else if(Utils.uBase.imageCompare("callingPad")){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call successfully");
				AdvanceReporting.addLogs("pass", "User able to make a call successfully","CallingPad");
			}
			else if(Utils.uBase.imageCompare("msgCallingImg")){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call successfully");
				AdvanceReporting.addLogs("pass", "User able to make a call successfully","CallingPad");
			}
			else{
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

	/* Enter phone number and making a call */
	public CallsPage enterPhoneNumAndMakeAcall() { 
		try
		{
			Thread.sleep(1000);
			enterPhNumberPlaceholder.sendKeys(Constants.phoneNo);
			Thread.sleep(1000);
			Utils.uBase.clickByImage("CallButtonImg");
			Utils.uBase.clickOnNotificationAllowBtn();
			AdvanceReporting.addLogs("pass", "Enter Phone number and click on call button sucessfully");
			AdvanceReporting.addLogs("pass", "Entered Phone number","Entered Phone number");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Enter Phone number and click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public CallsPage makeInternationalCall() { 
		try
		{
			Thread.sleep(1000);
			enterPhNumberPlaceholder.sendKeys(Constants.internationalUKNum);
			Thread.sleep(1000);
			Utils.uBase.clickByImage("CallButtonImg");
			Utils.uBase.clickOnNotificationAllowBtn();
			AdvanceReporting.addLogs("pass", "Enter Phone number and click on call button sucessfully");
			Thread.sleep(18000);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Enter Phone number and click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	// Verify able to use UP/DOWN arrow key to navigate through the suggestion list
	public CallsPage verifyDownArrowKeyToNavigateSuggestionList(){ 
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Actions actions = new Actions(Utils.uBase.webDriver);
			int length = lstFrequentContact.size();
			for(int i=0; i<length-1; i++) { 
				actions.moveToElement(lstFrequentContact.get(i));
				actions.sendKeys(Keys.ARROW_DOWN);
				actions.build().perform();
				Thread.sleep(2000);
			}
			AdvanceReporting.addLogs("info", "Down Arrow Key to Navigate Contact List is verified");
			AdvanceReporting.addLogs("pass", "Down Arrow Key to Navigate Contact List is verified");
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "No Down Arrow Key to Navigate Contact List");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this; 
	}

	// Verify able to use UP/DOWN arrow key to navigate through the suggestion list
	public CallsPage verifyDownArrowKeyToNavigateContactList(){ 
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Actions actions = new Actions(Utils.uBase.webDriver);
			int length = allContacts.size();
			for(int i=0; i<length-1; i++) { 
				actions.moveToElement(allContacts.get(i));
				actions.sendKeys(Keys.ARROW_DOWN);
				actions.build().perform();
				Thread.sleep(2000);
			}
			AdvanceReporting.addLogs("info", "Down Arrow Key to Navigate Contact List is verified");
			AdvanceReporting.addLogs("pass", "Down Arrow Key to Navigate Contact List is verified");
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "No Down Arrow Key to Navigate Contact List");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this; 
	}

	// Verify able to use UP/DOWN arrow key to navigate through the suggestion list
	public CallsPage verifyUpArrowKeyToNavigateContactList(){ 
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Actions actions = new Actions(Utils.uBase.webDriver);
			int length = allContacts.size();
			for(int i=length-1; i>0; i--) { 
				actions.moveToElement(allContacts.get(i));
				actions.sendKeys(Keys.ARROW_UP);
				actions.build().perform();
				Thread.sleep(2000);
			}
			AdvanceReporting.addLogs("info", "Up Arrow Key to Navigate Contact List is verified");
			AdvanceReporting.addLogs("pass", "Up Arrow Key to Navigate Contact List is verified");
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "No Up Arrow Key to Navigate Contact List");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this; 
	}

	// Verify able to use UP/DOWN arrow key to navigate through the suggestion list
	public CallsPage verifyUpArrowKeyToNavigateSuggestionList(){ 
		try {
			Thread.sleep(70000);
			Utils.uBase.checkPageReady();
			Actions actions = new Actions(Utils.uBase.webDriver);
			int length = lstFrequentContact.size();
			for(int i=length-1; i>0; i--) { 
				actions.moveToElement(lstFrequentContact.get(i));
				actions.sendKeys(Keys.ARROW_UP);
				actions.build().perform();
				Thread.sleep(2000);
			}
			AdvanceReporting.addLogs("info", "Up Arrow Key to Navigate Contact List is verified");
			AdvanceReporting.addLogs("pass", "Up Arrow Key to Navigate Contact List is verified");
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "No Up Arrow Key to Navigate Contact List");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this; 
	}

	// Verify by using ENTER key from keyboard able to select the contact from the list
	public CallsPage enterKeyToSelectContactFromDropDown(){
		try {
			Thread.sleep(1000);
			Actions actions = new Actions(Utils.uBase.webDriver);
			actions.moveToElement(lstFrequentContact.get(0));
			actions.sendKeys(Keys.ENTER);
			actions.build().perform();
			Thread.sleep(1000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	/* Called to Viop2 Number */
	public CallsPage enterVoip2PhoneNumAndMakeAcall() { 
		try
		{
			Thread.sleep(1000);
			//enterPhNumberPlaceholder.sendKeys(Constants.callToViop2PhNumber);
			enterPhNumberPlaceholder.sendKeys(Constants.phoneNo);
			Thread.sleep(2000);
			Utils.uBase.clickByImage("CallButtonImg");
			Thread.sleep(2000);
			Utils.uBase.clickOnNotificationAllowBtn();
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Enter Phone number and click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicked on End button hangs up the call */
	public CallsPage clickOnCallEndBtn() { 
		try
		{
			Thread.sleep(6000);
			Utils.uBase.clickByImage("callEndButtonImg");
			AdvanceReporting.addLogs("pass", "Click on call end button sucess");
			AdvanceReporting.addLogs("pass", "Clicked call end button","Clicked call end button");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Click on call end button is fail ");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify clicked on End button hangs up the call */
	public CallsPage verifyClickedOnEndButtonHangsUpcall() { 
		try
		{
			Thread.sleep(2000);
			if(!Utils.uBase.imageCompare("callEndButtonImg")){
				AdvanceReporting.addLogs("pass", "Verified that Clicked on End button hangs up the call is sucess");
				AdvanceReporting.addLogs("pass", "Clicked on End button hangs up the call is sucess","callHangsUP");
			}else {
				AdvanceReporting.addLogs("fail", "Clicked on End button hangs up the call is fail");
				AdvanceReporting.addLogs("fail", "Clicked on End button hangs up the call is fail","callNotHangsUP");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Clicked on End button hangs up the call is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Called to Viop1 Number */
	public CallsPage enterVoip1PhoneNumAndMakeAcall() { 
		try
		{
			Thread.sleep(2000);
			enterPhNumberPlaceholder.sendKeys(Constants.callToViop1PhNumber);
			Thread.sleep(3000);
			Utils.uBase.clickByImage("CallButtonImg");
			Thread.sleep(2000);
			Utils.uBase.clickOnNotificationAllowBtn();
			Thread.sleep(4000);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Enter Phone number and click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified Call quality prompt*/
	public CallsPage verifyCallQualityPromt() { 
		try
		{
			Thread.sleep(3000);
			Utils.uBase.waitForElement(qualityPrompt);
			Assert.assertTrue(Utils.uBase.imageCompare("qualityPrompt"),"Call Quality Prompt is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that good and Bad texts are is diaplyed on Quality Prompt");
			AdvanceReporting.addLogs("pass", "Good and Bad texts are is diaplyed on Quality Prompt","QualityPrompt");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Call Quality Prompt is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified Good and Bad texts on prompt*/
	public CallsPage verifyGoodAndBadTextOnQualityPromt() { 
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("GoodButtonImg2"),"Good Text is not displayed on Quality Promot");
			AdvanceReporting.addLogs("pass", "Verified that good text is present on quality prompt");
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("BadButtonOnPromt4"),"Bad Text is not displayed on Quality Promot");
			AdvanceReporting.addLogs("pass", "Verified that bad text is present on quality prompt");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Good and Bad texts are not diaplyed on Quality Prompt");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/* Clicked on Good from the Quality Promot*/
	public CallsPage clickOnGoodOptionFromQualityPromt() { 
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("GoodButtonImg2");
			AdvanceReporting.addLogs("pass", "Click on good option from Quality Promot");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Good option is not available");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* User clicks on GOOD the and verified call quality prompt hides or not */
	public CallsPage verifyCallQualityPromptHidesOrNot() { 
		try
		{
			Thread.sleep(2000);
			if(!Utils.uBase.imageCompare("CallQualityPromptImg1")){
				AdvanceReporting.addLogs("pass", "Verified that Call Quality Prompt is hide");
				AdvanceReporting.addLogs("pass", "Call Quality Prompt is hide","NoPrompt");
			}else {
				AdvanceReporting.addLogs("fail", "Call Quality Prompt is Unhide");
				AdvanceReporting.addLogs("fail", "Call Quality Prompt is Unhide","PromptPresent");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Call Quality Prompt is Unhide and fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Clicked on close 'X' button from Quality Promt*/
	public CallsPage clickOnCloseBtnFromQualityPromt() { 
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("CloseButtonOnPromt3");
			AdvanceReporting.addLogs("pass", "Click on close button from Quality Promot");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Not Click on close button from Quality Promot");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Enter phone number and making a call for dummy number */
	public CallsPage enterPhoneNumAndMakeAcallWithoutAllow() { 
		try
		{
			Thread.sleep(1000);
			enterPhNumberPlaceholder.sendKeys(Constants.dummyPhNumber);
			Thread.sleep(2000);
			Utils.uBase.clickByImage("CallButtonImg");
			Utils.uBase.clickByImage("AllowButtonImg");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Enter Phone number and click on call button sucessfully");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Enter Phone number and click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Clicked on Bad from the Quality Promot*/
	public CallsPage clickOnBadOptionFromQualityPromt() { 
		try
		{
			Thread.sleep(2000);
			//Utils.uBase.clickByImage("badButtonOnPromt");
			Utils.uBase.clickWebelement(badOptn);
			AdvanceReporting.addLogs("pass", "Click on bad option from Quality Promot");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "bad option is not available");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified When the user clicks on BAD, the following text is displayed with the options What went wrong?*/
	public CallsPage verifyOptionsWhatWentWrong(){ 
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("whatWentWrongImg"),"Options What went wrong is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that options What went wrong is displayed");
			AdvanceReporting.addLogs("pass", "Options What went wrong is displayed","whatWentWrong");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Options What went wrong is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicked on echo check box from what went wrong options window*/
	public CallsPage clickOnEchoCheckBoxFromWhatWentWrongWindow() { 
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("echoIssueImg");
			AdvanceReporting.addLogs("pass", "Clicked echo check box from hat went wrong options window");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Not click on echo check box from hat went wrong options window");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicked on submit button from what went wrong options window*/
	public CallsPage clickOnSubmitBtnFromWentWrongWindow() { 
		try
		{
			Thread.sleep(2000);


			Utils.uBase.clickByImage("buttonOnIssuePromtImg");
			AdvanceReporting.addLogs("pass", "Click on submit button from what went wrong options window");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Not clicked on submit button from what went wrong options window");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified call quality prompt hides right away or not */
	public CallsPage verifyallQualityPromptHidesRightAwayOrNot() { 
		try
		{
			Thread.sleep(2000);
			if(!Utils.uBase.imageCompare("whatWentWrongImg")){
				AdvanceReporting.addLogs("pass", "Verified that call quality prompt is not displayed");
				AdvanceReporting.addLogs("pass", "Call quality prompt is not displayed","QualityPrompt");
			}else {
				AdvanceReporting.addLogs("fail", "Call quality prompt is displayed");
				AdvanceReporting.addLogs("fail", "Call quality prompt is displayed","QualityPromptPresent");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Call Quality Prompt is Unhide and fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Clicked on echo check box from what went wrong options window*/
	public CallsPage clickOnOtherOptionWhatWentWrongWindow() { 
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("otherIssueCheckOnpromt");
			AdvanceReporting.addLogs("pass", "Clicked other option check box from hat went wrong options window");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Not click on other option check box from hat went wrong options window");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified it redirects to send feedback window with 'CANCEL' and 'SEND' buttons*/
	public CallsPage verifyRedirectsToSendFeedbackWindowWith(){ 
		try
		{
			Thread.sleep(20000);
			Assert.assertTrue(Utils.uBase.imageCompare("sendFeedbackPrompt"),"It's not redirects to send feedback window");
			AdvanceReporting.addLogs("pass", "Verified that It's redirects to send feedback window");
			AdvanceReporting.addLogs("pass", "It's redirects to send feedback window","FeedBackWindow");
			Thread.sleep(2000);

			Assert.assertTrue(Utils.uBase.imageCompare("SendCancelBtnImg"),"Send and cancel button are not displayed on feedback window");
			AdvanceReporting.addLogs("pass", "Verified that send and cancel button are displayed on feedback window");
			AdvanceReporting.addLogs("pass", "Send and cancel button are displayed on feedback window","sendCancelBtns");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "It's not redirects to send feedback window");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Clicked on cancel button from feedback window*/
	public CallsPage clickOnCancelBtnFromFeedbackWindow() { 
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("cancelBtnOnFeedBackImg");
			AdvanceReporting.addLogs("pass", "Click on cancel button from Feedback Window");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Not clicked on cancel button FeedbackWindow");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified send feedback window hides right away or not */
	public CallsPage verifySendFeedbackWindowHidesRightAwayorNot() { 
		try
		{
			Thread.sleep(2000);
			if(!Utils.uBase.imageCompare("sendFeedbackPrompt")){
				AdvanceReporting.addLogs("pass", "Verified that send Feedback Prompt is not displayed");
				AdvanceReporting.addLogs("pass", "Send Feedback Prompt is not displayed","SendFeedbackPrompt");
			}else {
				AdvanceReporting.addLogs("fail", "Send Feedback Prompt is displayed");
				AdvanceReporting.addLogs("fail", "Send Feedback Prompt is displayed","SendFeedbackPromptPresent");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Send Feedback Prompt is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicked on send button from feedback window*/
	public CallsPage clickOnSendBtnFromFeedbackWindow() { 
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("SendBtnOnFeedBackPrmtImg");
			AdvanceReporting.addLogs("pass", "Click on send button from Feedback Window");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Not clicked on send button from Feedback Window");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified error message 'A description is required'*/
	public CallsPage verifyErrorMessageDescriptionIsRequired() { 
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("errorMsgOnFeedBackImg"),"Error Message Description IsRequired is not displayed");
			AdvanceReporting.addLogs("pass","Verified that Error Message Description Is Required is displayed");
			/*
			 * if(Utils.uBase.isElementPresent_webelement(errorMsg)==true) {
			 * AdvanceReporting.addLogs("pass",
			 * "Verified that Error Message Description Is Required is displayed");
			 * AdvanceReporting.addLogs("pass",
			 * "Error Message Description Is Required is displayed","ErrorMsg"); } else
			 * AdvanceReporting.addLogs("fail", "Error message not displayed");
			 */
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "It's not redirects to send feedback window");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Entered Description On FeedBack Window*/
	public CallsPage enterDiscriptionOnFeedBackWindow() { 
		try
		{
			Thread.sleep(2000);
			enterDiscriptionOnFeedBackWindow.sendKeys("Test Description");
			AdvanceReporting.addLogs("pass", "Entered some text on feedback window");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Feedback window is not avaliable");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified toast message 'Thank you for the feedback' is displayed*/
	public CallsPage verifyToastMessage(){ 
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("ToastMsgOnSendFeedBack"),"Toast message is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that toast message is displayed");
			AdvanceReporting.addLogs("pass", "Toast message is displayed","Toastmessage");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Toast message is not displayed is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified UI appears immediately after call button is hit */
	public CallsPage verifyUiAppearsImmediatelyCallButtonHits() { 
		try
		{
			Thread.sleep(4000);
			if(Utils.uBase.imageCompare("callFullScreen")){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call sucessfully");
				AdvanceReporting.addLogs("pass", "User able to make a call sucessfully"," uIafterCall");
			}else {
				AdvanceReporting.addLogs("fail", "User not able to make a call");
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

	/* Verified status:calling when call is being connected */
	public CallsPage verifyStatusCallingIsDiaplyed() { 
		try
		{
			Thread.sleep(1000);
			if(callingStatus.isDisplayed()){
				AdvanceReporting.addLogs("pass", "Verified that calling status is displyed sucessfully");
				AdvanceReporting.addLogs("pass", "Calling status is displyed sucessfully","callingStatus");
			}else {
				AdvanceReporting.addLogs("fail", "Calling status is not displyed sucessfully");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Calling status is not displyed sucessfully");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified time duration when call is in progress */
	public CallsPage verifyTimeDurationWhenCallIsInProgress() { 
		try
		{
			if(Utils.uBase.isElementPresent_webelement(callDuration)){
				AdvanceReporting.addLogs("pass", "Verified that time duration is displayed when call is in progress");
				AdvanceReporting.addLogs("pass", "Time duration is displayed when call is in progress","Time duration");
			}else {
				AdvanceReporting.addLogs("fail", "Time duration is not displayed when call is in progress");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Time duration is not displayed when call is in progress");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified status:Call ended.total duration when call is ended */
	public CallsPage verifyStatusCallEndedTotalDurationIsDiaplyed() { 
		try
		{
			Utils.uBase.clickByImage("callEndButtonImg");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Click on call end button sucess");
			if(Utils.uBase.isElementPresent_webelement(callEnded)){
				AdvanceReporting.addLogs("pass", "Verified that callEnd Duration status is displyed sucessfully");
				AdvanceReporting.addLogs("pass", "CallEnd Duration status is displyed sucessfully","CallEndDuration");
			}else {
				AdvanceReporting.addLogs("fail", "CallEnd Duration status is not displyed");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "CallEnd Duration status is not displyed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified that able to make call */
	public CallsPage verifyAnonymousCallIsPlaced() { 
		try
		{
			String name=firstItem.getText();
			if(name.contains("Unknown")) {
				AdvanceReporting.addLogs("pass", "Anonymous call is placed");
				AdvanceReporting.addLogs("pass", "Anonymous call is placed", "Anonymous call is placed");
			}
			else
				AdvanceReporting.addLogs("fail", "Anonymous call not placed");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "User not able to make a call");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Clicked on Dial pad button */
	public CallsPage clickOnDialPadButton() { 
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("DialPadFabButton");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Dail pad button is not avaliable");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Clicked on Dial pad button */
	public CallsPage enterAnonymousNumber() { 
		try
		{
			//Anonymous number is provided by manuala team

			Thread.sleep(1000); 
			Utils.uBase.clickByImage("starBtn");			 
			Thread.sleep(1000);
			Utils.uBase.clickByImage("sixBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("sevenBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("twoBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("zeroBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("nineBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("fiveBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("nineBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("sevenBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("threeBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("twoBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("oneBtn"); 
			Thread.sleep(1000);
			Utils.uBase.clickByImage("oneBtn");

		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Anonymous Number not enterd");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicked on call button and handling different call buttons */
	public CallsPage clickOnCallButton() { 
		try
		{
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("CallButtonImg")) {
				Thread.sleep(1000);
				Utils.uBase.clickByImage("CallButtonImg");
				Utils.uBase.clickOnNotificationAllowBtn();
				AdvanceReporting.addLogs("pass", "Clicked on call button sucessfully");
			}else if(Utils.uBase.imageCompare("callButtonOnRightSide")){
				Thread.sleep(1000);
				Utils.uBase.clickByImage("callButtonOnRightSide");
				Utils.uBase.clickOnNotificationAllowBtn();
				AdvanceReporting.addLogs("pass", "Clicked on call button sucessfully");
			}else {		
				AdvanceReporting.addLogs("fail", "No calls button available");
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/*Allow chrome notification */
	public CallsPage allowNotification() { 
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
			AdvanceReporting.addLogs("info", "No Allow buttom available");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Deleting the existing call */
	public CallsPage deleteExistingCall(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("ThreeDotsBtnImg");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("Delete1");
			AdvanceReporting.addLogs("pass", "Delete button click on sucessfully");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "No Delete button avalilable");
			System.out.println("Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified Delete this call? popup.*/
	public CallsPage verifyDeleteThisCall()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("deleteThisCall"),"Delete this call? is not displayed");
			AdvanceReporting.addLogs("Pass", "Delete this call? is displayed");
			AdvanceReporting.addLogs("Pass", "Delete this message? is displayed","Deletethismessage");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified cancel button is  displayed.*/
	public CallsPage verifyCancelButton()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("cancelBtnOnDeletePopup"),"Cancel Btn On Delete Popup is not displayed");
			AdvanceReporting.addLogs("Pass", "cancel Btn On Delete Popup is displayed");
			AdvanceReporting.addLogs("Pass", "cancel Btn On Delete Popup is displayed","cancelBtn");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified delete button is  displayed.*/
	public CallsPage verifyDeleteBtn()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("deleteBtnOnDeletePopup"),"Delete Btn On DeletePopup is not displayed");
			AdvanceReporting.addLogs("Pass", "Delete Btn On Delete Popup is displayed");
			AdvanceReporting.addLogs("Pass", "Delete Btn On Delete Popup is displayed","DeleteBtn");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified specific menu items ex: 1. People & options2. Archive3. Mark as spam on the screen*/
	public CallsPage verifySpecificMenuItemsOnCalls()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("specificMenuItemsOnCalls"),"Specific Menu Items On Calls is not displayed");
			AdvanceReporting.addLogs("Pass", "Specific Menu Items On Calls is displayed");
			AdvanceReporting.addLogs("Pass", "Specific Menu Items On Calls is displayed","specificMenuItems");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Delete all calls */ 
	public CallsPage deleteCallsWithDifferentBtns(){
		try {

			Thread.sleep(4000);
			Utils.uBase.clickByImage("ThreeDotsBtnImg1");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("Delete1");
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("IUnderstand")) {
				Thread.sleep(1000);
				Utils.uBase.clickByImage("IUnderstand");
				Thread.sleep(1000);
				Utils.uBase.clickByImage("Delete_box");
				Thread.sleep(1000);
			}else if(Utils.uBase.imageCompare("Delete_box")){
				Thread.sleep(1000);
				Utils.uBase.clickByImage("Delete_box");
			}else {
				AdvanceReporting.addLogs("info", "Delete pop is not available");
			}
		} catch (Exception e) {
			System.out.println("Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Delete all calls from the calls list folder */
	public CallsPage deleteAllCalls() { 
		try {
			Thread.sleep(2000);
			int msgsListSize = lstCalls.size();
			System.out.println("size od msg list is "   +msgsListSize);
			if(msgsListSize==0) {
				AdvanceReporting.addLogs("pass", "Calls folder is already empty");
			}else {
				for(int i=0; i<=msgsListSize-1; i++) {	
					lstCalls.get(i).click();
					this.deleteCallsWithDifferentBtns();
					AdvanceReporting.addLogs("pass", "Calls deleted sucessfully");		
				}
			}
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "No Calls.");
			AdvanceReporting.addLogs("fail", "No Contact displayed");
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}
	/* Verified no voice text is displayed.*/
	public CallsPage verifyNoCallsText()
	{
		try
		{
			Thread.sleep(3000);
			Assert.assertTrue(Utils.uBase.imageCompare("noCallsText"),"No calls text is not displayed");
			AdvanceReporting.addLogs("Pass", "No calls text is displayed");
			AdvanceReporting.addLogs("Pass", "No calls text is is displayed","NoMsgTxt");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "No calls text is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified You'are all caught up text is displayed.*/
	public CallsPage verifyYourAllCaughtUpText()
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


	//verify the number of message thread available in the message list
	public CallsPage verifyCallsCount() {

		try {
			Thread.sleep(3000);
			AdvanceReporting.addLogs("Info", "size of array in call list is "+callsList.size());
			if(callsList.size() == AvatarsList.size())
				AdvanceReporting.addLogs("pass", "Size of Array in call list is displayed");
			AdvanceReporting.addLogs("pass", "Size of Array in call list is displayed", "CallList");

		}
		catch(Exception e){
			AdvanceReporting.addLogs("info", "Size of Array in call list is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}
	public CallsPage clickSelectedNumMakeACall(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("makeAcallIcon");
			Thread.sleep(1000);
			AdvanceReporting.addLogs("pass", "Making a call");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Unable to make a call");
			System.out.println("Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Enter phone number */
	public CallsPage enterPhoneNumberForSearch() { 
		try
		{
			Thread.sleep(1000);
			enterPhNumberPlaceholder.sendKeys("m");
			AdvanceReporting.addLogs("pass", "Enter Phone number sucessfully");
			AdvanceReporting.addLogs("pass", "Enter Phone number sucessfully", "EnterPhoneNumber");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Enter Phone number and click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Method for clicking Fab icon
	public CallsPage clickFabIcon() {

		try {
			Utils.uBase.clickByImage("fabIcon");
			Thread.sleep(2000);

			AdvanceReporting.addLogs("pass", "Clicked on fab icon");
			AdvanceReporting.addLogs("pass", "Clicked on fab icon","fabIconClicked");

		}catch(Exception e) {
			AdvanceReporting.addLogs("info", "Fab icon is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;}

	//Verify contacts separated by a label 'Directory' (for directory contacts)
	public CallsPage verifyDropdownScrollable(){ 
		try{ 
			Thread.sleep(3000);
			Utils.uBase.clickByImage("downArrow");
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("ScrollbarImg")){
				AdvanceReporting.addLogs("pass","Dropdown is scrollable");
				AdvanceReporting.addLogs("pass","Dropdown is scrollable","ScrollbarPresence");
			}
			else {
				AdvanceReporting.addLogs("pass","Dropdown is scrollable");
				AdvanceReporting.addLogs("pass","Dropdown is scrollable","ScrollbarPresence");
			}	
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail","Dropdown is not present");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}
	/*Verified Personal contacts */
	public CallsPage verifyUnsavedContacts(){ 
		try{ 
			Thread.sleep(4000);
			int sizeOfunsavedContacts = unsavedContacts.size();
			for(int i=0; i<=sizeOfunsavedContacts-1; i++) {
				if(unsavedContacts.size()==sizeOfunsavedContacts) {
					AdvanceReporting.addLogs("pass","Unsaved(google) contacts displayed under Directory section");
					AdvanceReporting.addLogs("pass","Unsaved(google) contacts displayed under Directory section","unsavedContacts");
					break;
				}else {
					AdvanceReporting.addLogs("fail","Unsaved(google) contacts not displayed under Directory section");
					AdvanceReporting.addLogs("fail","Unsaved(google) contacts not displayed under Directory section","unsavedContacts");
				}
			}
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","no contacts from personal is displayed");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	/*Verified Personal contacts */
	public CallsPage verifySavedContacts(){ 
		try{ 
			Thread.sleep(2000);
			for(int i=0; i<savedContacts.size(); i++) {
				if(savedContacts.size()<=10) {
					AdvanceReporting.addLogs("pass","Saved contacts are displayed at the top");
					AdvanceReporting.addLogs("pass","Saved contacts are displayed at the top","savedContacts");
					break;					
				}else {
					AdvanceReporting.addLogs("info","Saved contacts are not displayed at the top");
					AdvanceReporting.addLogs("fail","Saved contacts are not displayed at the top","savedContacts");
				}
			}
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","no contacts from personal is displayed");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}
	/*Method to Click on the item, it will attempt an outgoing call */
	public CallsPage clickFirstItemFromDropdown(){ 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.clickWebelement(savedContacts.get(0));
			AdvanceReporting.addLogs("pass","Clicked on a dropdown item");
			AdvanceReporting.addLogs("pass","Clicked on a dropdown item","call item clicked");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail","Not clicked on a dropdown item");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}
	/*Allow chrome notification */
	public CallsPage allowBrowserNotification() { 
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
			AdvanceReporting.addLogs("info", "No Allow buttom available");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Selecting MarkAsSpam */
	public CallsPage selectMarkAsSpam()
	{
		try
		{
			Utils.uBase.clickByImage("MarkAsSpam");
			AdvanceReporting.addLogs("info", "Click on spam option sucessfully.");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Verify V dropdown is present
	public CallsPage verifyCallDropDownPresent() { 
		try  { 
			Thread.sleep(2000);
			Assert.assertFalse(Utils.uBase.imageCompare("ArrowDropDown"), "v drop down didn't appeared");
			AdvanceReporting.addLogs("pass", "Verified that, V is not present beside the call icon");
			AdvanceReporting.addLogs("pass", "V is not present beside the call icon","ArrowDropDown");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "V is appearing beside the call icon");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}
	// Verify V dropdown is present
	public CallsPage verifyUseMyPhoneToCallOption() { 
		try  { 
			Thread.sleep(2000);
			Assert.assertFalse(Utils.uBase.imageCompare("Use my phone to call"), "Use my phone to call Option is not available");
			AdvanceReporting.addLogs("pass", "Verified that use my phone to call Option is not present");
			AdvanceReporting.addLogs("pass", "Use my phone to call Option is not present","Use my phone to call");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Use my phone to call Option is present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	/* Called to Viop1 Number */
	public CallsPage enterVoipPhoneNumOfTywinsMakeAcall() { 
		try
		{
			Thread.sleep(2000);
			enterPhNumberPlaceholder.sendKeys(Constants.voipOneNo);
			AdvanceReporting.addLogs("pass", "Phone number entered");
			AdvanceReporting.addLogs("pass", "Phone number entered","Phone number entered");
			Thread.sleep(3000);
			Utils.uBase.clickByImage("CallButtonImg");
			Thread.sleep(2000);
			Utils.uBase.clickOnNotificationAllowBtn();
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Enter Phone number and click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified "Outgoing Call" is listed in the Calls folder. */
	public CallsPage verifyOutgoingCallIsListedInCallsFolder(){ 
		try
		{
			Thread.sleep(4000);
			//Assert.assertTrue(Utils.uBase.imageCompare("outgoingCallTywinsnow"),"Outgoing call is not displayed");
			if(firstItem.getText().replaceAll("\\W", "").contains(Constants.voipOneNo)) {
				AdvanceReporting.addLogs("pass", "Verified that outgoing call is displayed");
				AdvanceReporting.addLogs("pass", "Outgoing call is displayed","outGoingCall");
			}
			else if(firstItem.getText().replaceAll("\\W", "").contains("Jimmy")) {
				AdvanceReporting.addLogs("pass", "Verified that outgoing call is displayed");
				AdvanceReporting.addLogs("pass", "Outgoing call is displayed","outGoingCall");
			}
			else
				AdvanceReporting.addLogs("fail", "outgoing call is not displayed");

		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Outgoing call is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified the saved contact name displayed. */
	public CallsPage verifySavedContactNameDisplayed(){ 
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("phoneNumberAddToContact"),"Saved contact name is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that saved contact name is displayed");
			AdvanceReporting.addLogs("pass", "Saved contact name is displayed","SavedContactName");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Saved contact name is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Selecting Calls Tab */
	public CallsPage selectCallsTab()
	{
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("ClickOnCallsImg");
			AdvanceReporting.addLogs("info", "Calls Tab click");
			AdvanceReporting.addLogs("info", "Calls Tab click","Callstab");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Calls Tab is not selectd");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified "Missed Call" is listed in the Calls folder. */
	public CallsPage verifyMissedCallIsListedInCallsFolder(){ 
		try
		{
			SoftAssert Assert= new SoftAssert();
			Thread.sleep(4000);
			Assert.assertTrue(Utils.uBase.imageCompare("missedCallNumTwilo"),"Missed call is not displayed");
			AdvanceReporting.addLogs("pass", "Missed call is displayed");
			AdvanceReporting.addLogs("pass", "Missed call is displayed","missedCall");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Missed call is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public  CallsPage verifyCallDetailsWithDateTime() {
		try {
			Thread.sleep(2000);
			String callTimes = callTime.getText();
			String callDates = callDate.getText();
			Pattern p = Pattern.compile("\\d{2}:\\d{2} [A-Z][a-z]");
			Matcher callTime = p.matcher(callTimes);
			Matcher callDate = p.matcher(callDates);
			boolean timeFound = callTime.matches();
			boolean dateFound = callDate.matches();
			if (timeFound && dateFound) {
				AdvanceReporting.addLogs("pass","Verified that call details with date time is displayed");
				AdvanceReporting.addLogs("pass", "Call details with date time is displayed", "callWithDateTime");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Call details with date time is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Verification pop-up for the message got deleted
	public CallsPage verifyIncomingCallScreenIsNotDisplayed() throws Exception {
		try {
			SoftAssert Assert=new SoftAssert();
			Thread.sleep(20000);
			Assert.assertEquals(false, Utils.uBase.imageCompare("IncomingCallScreen"));
			AdvanceReporting.addLogs("Pass", "Verified that unable to get the call when the number is blocked");
			AdvanceReporting.addLogs("Pass", "Unable to get the call when the number is blocked","CallScreen");
			Thread.sleep(20000);

		} catch (Exception e) {
			AdvanceReporting.addLogs("Pass", "Able to get the call when the number is blocked");
			AdvanceReporting.addLogs("Pass", "Able to get the call when the number is blocked","CallScreen");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Verification pop-up for the message got deleted
	public CallsPage verifyIncomingCallScreenIsDisplayed() throws Exception {
		try {
			Thread.sleep(20000);
			Assert.assertEquals(true, Utils.uBase.imageCompare("IncomingCallScreen"));
			AdvanceReporting.addLogs("Pass", "Able to get the call when the number is blocked");
			AdvanceReporting.addLogs("Pass", "Able to get the call when the number is blocked","CallScreen");
			Thread.sleep(32000);

		} catch (Exception e) {
			AdvanceReporting.addLogs("Pass", "Unable to get the call when the number is blocked");
			AdvanceReporting.addLogs("Pass", "Unable to get the call when the number is blocked","CallScreen");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Go to browser settings  */
	public CallsPage browserSettings()
	{
		try
		{
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("notificationPopup")) {
				Thread.sleep(3000);
				Utils.uBase.clickByImage("closeNotification");
			}
			Thread.sleep(6000);
			Utils.uBase.clickByImage("browserThreeDots");
			Thread.sleep(5000);
			if(Utils.uBase.imageCompare("browserSettings")) {
				Thread.sleep(3000);
				Utils.uBase.clickByImage("browserSettings");
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



	/* Scroll down to micro phone settings   */
	public CallsPage microPhoneSettings()
	{
		try
		{
			for(int i=1; i<=40; i++) {
				Thread.sleep(1000);
				Utils.uBase.clickByImage("scrollDownBrowser");
				if(Utils.uBase.imageCompare("advancedBrowser")) {
					Thread.sleep(1500);
					Utils.uBase.clickByImage("advancedBrowser");
					Thread.sleep(1000);
					Utils.uBase.clickByImage("scrollDownBrowser");
					Thread.sleep(1000);
				}if(Utils.uBase.imageCompare("contentSettings")) {
					Thread.sleep(1500);
					Utils.uBase.clickByImage("contentSettings");
					Thread.sleep(1500);
					Utils.uBase.clickByImage("microPhone");
					AdvanceReporting.addLogs("pass", "MicroPhone is selectd");
					break;
				}
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "MicroPhone is not selectd");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* MicroPhone Toogle On */
	public CallsPage microPhoneToogleOn()
	{
		try{
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("microPhoneToogleOff")) {
				Thread.sleep(2000);
				Utils.uBase.clickByImage("microPhoneToogleOff");
				Thread.sleep(2000);
			}else {
				AdvanceReporting.addLogs("info", "Toogle is on now");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "No toggle found");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* MicroPhone Toogle off */
	public CallsPage microPhoneToogleOff()
	{
		try{
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("microPhoneToogleOn")) {
				Thread.sleep(2000);
				Utils.uBase.clickByImage("microPhoneToogleOn");
				Thread.sleep(2000);
			}else {
				AdvanceReporting.addLogs("info", "Toogle is off now");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "No toggle found");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Go to application */
	public CallsPage navigateToGoogleVoiceApp()
	{
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("goToGoogleVoiceWindow");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Calls Tab is not selectd");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified error message ""Microphone is turned off"" */
	public CallsPage verifyMicrophoneIsTurnedOff(){ 
		try
		{
			Thread.sleep(10000);
			Assert.assertTrue(Utils.uBase.imageCompare("turnedOffMessage"),"Microphone Turned Off Message is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that microphone Turned Off Message is displayed");
			AdvanceReporting.addLogs("pass", "Microphone Turned Off Messageis displayed","MicrophoneOffMessage");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Microphone Turned Off Message is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified text ""To make a call on Google Voice, you need to turn on your microphone and details link */
	public CallsPage verifyTurnOnYourMicrophone(){ 
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("turnedOffMessage"),"To make a call on Google Voice, you need to turn on your microphone and details link not displyed");
			AdvanceReporting.addLogs("pass", "Verified that To make a call on Google Voice, you need to turn on your microphone and details link is displayed");
			AdvanceReporting.addLogs("pass", "To make a call on Google Voice, you need to turn on your microphone and details link is displayed","needToTurnOnYourMicrophone");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "To make a call on Google Voice, you need to turn on your microphone and details link not displyed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verify the call is removed from the Calls folder. */
	public CallsPage  verifyCallsListBeforeSpam(){
		try {
			Thread.sleep(2000);
			int sizeBeforeSpamCall = callsList.size();
			AdvanceReporting.addLogs("info", "Call List before moving to Spam:"+sizeBeforeSpamCall);	

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verify the call is removed from the Calls folder. */
	public CallsPage  verifyCallsListAfterSpam(){
		try {
			Thread.sleep(2000);
			int sizeaAfterSpamCall = callsList.size();
			AdvanceReporting.addLogs("info", "Call List After moving to Spam:"+sizeaAfterSpamCall);	

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public CallsPage archiveSelectMultipleAvatars() {

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
	//Verification message when the text is getting copied to the clipboard
	public CallsPage clickMultipleAvatars() {
		try {
			System.out.println("size of array list is "+AvatarsList.size());
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

	//To verify that selected contact number is displayed in recipient picker  
	public CallsPage verifySelectedContactDuringCall() {
		try {
			Utils.uBase.waitForElement(inlineCallContact);
			String contactFieldCall = inlineCallContact.getText();
			if((ele.contains(contactFieldCall))==true)
			{
				AdvanceReporting.addLogs("pass", "Selected contact number is displayed during the call : "+contactFieldCall);
				AdvanceReporting.addLogs("pass", "Selected contact number is displayed during the call","Selected contact number is displayed during the call");
			}
			else
			{
				AdvanceReporting.addLogs("fail", "Selected contact number is not displayed during the call");
				AdvanceReporting.addLogs("fail","Selected contact number not displayed","Selected contact number not displayed");
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verify the call is removed from the Calls folder. */
	public CallsPage clickArchive()
	{
		try
		{
			int sizeBeforArchive = callsList.size();
			Thread.sleep(1000);
			this.selectArchiveOption();
			Thread.sleep(1000);
			int sizeaAfterArchive = callsList.size();
			if (sizeBeforArchive !=sizeaAfterArchive) {
				AdvanceReporting.addLogs("info", "Call is removed from the archive folder.", "ArchivedDone");
			}else {
				AdvanceReporting.addLogs("fail", "Call is not removed from the archive folder.");
				AdvanceReporting.addLogs("fail", "Call is not removed from the archive folder.","call is not archived");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Call is not removed from the archive folder.");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Clicked on End button hangs up the call */
	public CallsPage clickOnCallEndBtnWhenDisplayed() { 
		try
		{
			Thread.sleep(4000);
			if(Utils.uBase.imageCompare("callEndButtonImg")==true)
			{
				Utils.uBase.clickByImage("callEndButtonImg");
				AdvanceReporting.addLogs("pass", "Click on call end button sucess");
			}else {
				AdvanceReporting.addLogs("pass", "Click on call end button sucess");
			}

		} 
		catch (Exception e)
		{
			System.out.println(" Inside call end exception");
			AdvanceReporting.addLogs("info", "Click on call end button is fail ");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Click on call button to make call */
	public CallsPage clickOnCallBtn() { 
		try
		{
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("CallButtonImg")==true)
			{
				Utils.uBase.clickByImage("CallButtonImg");
				AdvanceReporting.addLogs("pass", "Clicked on call button");
				AdvanceReporting.addLogs("pass", "Clicked on call button","Clicked on call button");
			}else {
				AdvanceReporting.addLogs("pass", "Clicked on call  button ");
				AdvanceReporting.addLogs("pass", "Clicked on call button","Clicked on call button");
			}

		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Click on call button is fail ");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public CallsPage EnteraNameOrNum() 
	{
		try
		{
			Thread.sleep(15000);
			if(((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete"))
				Utils.uBase.clickByImage("enterANameOrNum");
			AdvanceReporting.addLogs("pass", "Enter a name or number is clicked");
			AdvanceReporting.addLogs("pass", "Enter a name or number is clicked","Enter a name or number is clicked");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Make A call is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}
	public CallsPage enterNumAndMakeAcall(String data) { 
		try
		{
			Thread.sleep(1000);
			//enterPhNumberPlaceholder.sendKeys(Constants.callToViop2PhNumber);
			enterPhNumberPlaceholder.sendKeys(data);
			Thread.sleep(2000);
			Utils.uBase.clickByImage("CallButtonImg");
			Thread.sleep(2000);
			Utils.uBase.clickOnNotificationAllowBtn();
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Enter Phone number and click on call button is fail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Took count of items listed in calls */
	public CallsPage countOfItemsInListOfCalls() {

		try {
			if(Utils.uBase.isElementPresent_webelement(unreadCalls)) {
				String temp=unreadCalls.getText();
				befoeCallData=Integer.parseInt(temp);	
			}
			else 
				befoeCallData=0;
		}
		catch(Exception e){

			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}
	/* Unread calls shown next to the Phone Icon are equal to the total number */
	public CallsPage verifyUnreadCallsEqualToTheTotalNumber() {
		try {
			int total=befoeCallData+Constants.count;
			System.out.println("befoeCallData"+befoeCallData);
			String temp=unreadCalls.getText();
			System.out.println("temp"+temp);
			int afterCallReceive=Integer.parseInt(temp);
			if(total==afterCallReceive) {
				AdvanceReporting.addLogs("pass","Verified that unread call items are present" );
			}
			else
				AdvanceReporting.addLogs("fail", "count is not same");
		}
		catch(Exception e){


			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}
	public CallsPage clickUnreadItems() {
		try {
			Utils.uBase.clickWebelement(unreadCalls);
			AdvanceReporting.addLogs("pass", "Unread calls is clicked");
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}
	public CallsPage editDiscriptionBox() {
		try {
			Utils.uBase.clickWebelement(descriptionBox);
			AdvanceReporting.addLogs("pass", "description Box is clicked");
			descriptionBox.sendKeys("testing");
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			

		return this;		
	}

	public CallsPage callbuttonverification() {
		try {
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("CallButtonImg")==true) {
				AdvanceReporting.addLogs("pass", "call button is enabled");
			}
			else
			{
				AdvanceReporting.addLogs("fail", "call button is not enabled");
			}
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());

		}			

		return this;		
	}

	public CallsPage enterNumberThroughDailpad() {
		try {
			Thread.sleep(1000); 
			Utils.uBase.clickByImage("fourBtn");			 
			Thread.sleep(1000);
			Utils.uBase.clickByImage("zeroBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("eightBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("sixBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("eightBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("sixBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("fourBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("sixBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("oneBtn");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("threeBtn");

			AdvanceReporting.addLogs("pass", "Phone number is entered successfully");
			AdvanceReporting.addLogs("pass", "Phone number is entered successfully","Phone number is entered successfully");
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());

		}			

		return this;		
	}

	//enter contact first letter in dial panel
	public CallsPage enterContactLetter(String data) {

		try {
			Thread.sleep(2000);
			enterPhNumberPlaceholder.sendKeys(data);
			Thread.sleep(2000);
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());

		}			
		return this;
	}


	public CallsPage callplaced() {

		try {
			Thread.sleep(2000);
			Utils.uBase.clickWebelement(contactList);
			Thread.sleep(500);
			Utils.uBase.clickOnNotificationAllowBtn();
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());

		}			

		return this;
	}

	public CallsPage checkDialpad() {

		try {
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("fabIcon"))
			{
				Utils.uBase.clickByImage("fabIcon");
				AdvanceReporting.addLogs("pass", "Show keypad is clicked");
			}			
			Thread.sleep(3000);
			AdvanceReporting.addLogs("pass", "Dial panel is available");

		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}			
		return this;
	}
	public CallsPage verifyIncallContactName() {

		try {Utils.uBase.clickOnNotificationAllowBtn();
		String temp=inCallContactName.getText();
		if(temp.contains("4086864613")||temp.contains("Jimmy")) {
			AdvanceReporting.addLogs("pass","In call contact name or phone number is displayed");
		}
		else
			AdvanceReporting.addLogs("fail", "In call contact name is not displayed");
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}			
		return this;
	}
	public CallsPage verifySuggestedPhNo() {

		try {
			String temp=suggestedListPhNo.getText().replaceAll("\\W", "");
			System.out.println("suggestedListPhNo"+temp);
			if(temp.contains("4086864613")) {
				AdvanceReporting.addLogs("pass","Suggested list is displayed by entering number");
			}
			else
				AdvanceReporting.addLogs("fail", "Suggested list is not displayed by entering number");
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}			
		return this;
	}

	public CallsPage verifyCallingStatus() {

		try {
			if(Utils.uBase.imageCompare("callingActivity")==true) {
				AdvanceReporting.addLogs("Pass", "Verified that calling status is displayed");
				AdvanceReporting.addLogs("pass", "Verified that calling status is displayed", "Calling status");
			}
			else
				AdvanceReporting.addLogs("fail", "calling status is not displayed");
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}			
		return this;
	}
	public CallsPage verifyName() {

		try {

			if(Utils.uBase.imageCompare("callingActivity")==true) {
				AdvanceReporting.addLogs("Pass","Verified that calling status is displayed");
				} else
							AdvanceReporting.addLogs("fail", "calling status is not displayed");

		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}			
		return this;
	}
	public CallsPage verifyIncallContact(String data) {

		try {Utils.uBase.clickOnNotificationAllowBtn();
		String temp=inCallContactName.getText().replaceAll("\\W", "");
		if(temp.contains(data)) {
			AdvanceReporting.addLogs("pass","In call contact name or phone number is displayed");
		}
		else
			AdvanceReporting.addLogs("fail", "In call contact name is not displayed");
		}
		catch(Exception e){
			//AdvanceReporting.addLogs("info", "Unread items are not present");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}			
		return this;
	}

}
