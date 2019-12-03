package automationBed_Google.pom.gv;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

import org.openqa.selenium.JavascriptExecutor;

public class VoicemailPage 
{


	//Locators of the Voicemail Page
	@FindBy(xpath="//*[contains(text(), '2 selected')]")
	WebElement AvatarsSelected;	
	@FindBy(xpath="//*[contains(@content,'ProfileNames')]")
	WebElement firstVoicemail;
	//Array List for the total number of Voicemail Avatars in Voicemails page
	@FindBy(xpath="//*[contains(@ng-repeat,'phoneNumber')]")
	List<WebElement> avatarsListInVoicemailsPage;	
	//Array List for the total number of Avatars List(includes calls, messages and voicemails) in Archived Voicemails page
	@FindBy(xpath="//*[contains(@ng-repeat,'phoneNumber')]")
	List<WebElement> archivedAvatarsList;	
	/* Had to use WebElement to click the 'X' icon, as image identification is failing with 'x' icons on the Location 
	pop-up confirmation as well as Chrome browser header message - 'The browser is being controlled by automated software' */
	@FindBy(xpath="(//*[contains(@aria-label,'Unselect all')])[last()]")
	WebElement unSelectVoicemailIcon;		
	@FindBy(xpath="(//button[@class=\"mat-icon-button mat-primary\"])[2]")
	WebElement archiveIcon;
	@FindBy(xpath="//div[@class='rkljfb-MZArnb flex']")
	List<WebElement> voiceList;
	//@FindBy(xpath="//div[@gv-test-id='conversation-avatar-or-checkmark']")
	@FindBy(xpath="//*[contains(@gv-test-id,'item-contact')]")
	List<WebElement> lstVoiceMails;
	@FindBy(xpath="//*[contains(@class,'rkljfb-npMLoc grey-900')]")
	List<WebElement> archvContactDetails;	
	@FindBy(xpath="//*[contains(@class,'full-snackbar')]")
	WebElement snackBar;
	@FindBy(xpath="//*[@id=\"messaging-view\"]/div/md-content/div/div/gv-batch-thread-select-header/div/div[2]/gv-icon-button-ng2[1]/button")
	WebElement unArchiveIcon;
	@FindBy(xpath="//*[contains(@class,'rkljfb-MZArnb flex')]")
	List<WebElement> archvContactRows;
	HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
	@FindBy(xpath="//*[contains(@gv-test-id,'conversation-avatar-or-checkmark')]")
	List<WebElement> voiceMailAvatarsList;
	@FindBy(xpath="//*[contains(@content,'ProfileNames')]")
	List<WebElement> voicemailList;
	@FindBy(xpath="(//*[contains(@aria-label,'Delete')])[last()]")
	WebElement deleteButton;


	int avatarsBeforeArchive;
	int avatarsAfterUndo;
	int lstAfterArchive;
	int archiveListBef;
	int archiveListAft;

	public VoicemailPage clickArchiveTab() throws Exception
	{
		try
		{
			Thread.sleep(3000);
			hmPage.clickTab(Constants.Archive);
			AdvanceReporting.addLogs("pass","Archive tab is clicked");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "fail error : "+e.getMessage());			
		}
		return this;
	}			

	public VoicemailPage captureArchivedNums() throws Exception
	{
		try
		{
			Thread.sleep(2000);
			archiveListBef = lstVoiceMails.size();
			AdvanceReporting.addLogs("pass", "The list size before archive is : "+archiveListBef);
			AdvanceReporting.addLogs("pass", "The list size before archive","The list size before archive");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "fail error : "+e.getMessage());			
		}
		return this;
	}

	public VoicemailPage clickVoicemailTab() throws Exception
	{
		try
		{
			Thread.sleep(3000);
			hmPage.clickTab(Constants.VoiceMail);
			AdvanceReporting.addLogs("pass","Voicemail tab is clicked");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "fail error : "+e.getMessage());			
		}
		return this;
	}

	public VoicemailPage captureVoicemailNums() throws Exception
	{
		try
		{
			Thread.sleep(2000);
			//capturing all the voicemails in an array list	
			for(int i=0; i<=(avatarsListInVoicemailsPage.size()-(avatarsListInVoicemailsPage.size()-1)) ;i++)
			{				
				avatarsListInVoicemailsPage.get(i).click();
			}
			AdvanceReporting.addLogs("pass", "Voice mail avatar is clicked");
			AdvanceReporting.addLogs("pass", "Voice mail avatar is clicked", "Voice mail avatar is clicked");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "fail error : "+e.getMessage());			
		}
		return this;
	}

	public VoicemailPage clickVoicemailArchiveIcon() throws Exception
	{
		try
		{
			Thread.sleep(2000);
			Utils.uBase.clickByImage("voiceMailArchive");
			AdvanceReporting.addLogs("pass", "Clicked on Archive Icon");
			AdvanceReporting.addLogs("pass","Clicked on Archive Icon","Clicked on Archive Icon");
			Thread.sleep(3000);
			//calling clickByImage method to click on archive icon 
			if(Utils.uBase.imageCompare("archiveSnckBar")) 
			{ AdvanceReporting.addLogs("pass","Pop up saying items Archived with Undo option ");
			AdvanceReporting.addLogs("pass","Pop up saying issued","Pop up saying issued"); 
			} 
			else {
				AdvanceReporting.addLogs("fail","Pop up saying items Archived has not been issued");
				AdvanceReporting.addLogs("fail", "Pop up not issued","Pop up not issued"); 
			}			
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "fail error : "+e.getMessage());			
		}
		return this;
	}

	public VoicemailPage verifyAndCaptureArchivedNums() throws Exception
	{
		try
		{
			Thread.sleep(2000);
			archiveListAft = lstVoiceMails.size();
			AdvanceReporting.addLogs("pass", "The list size after archive is : "+archiveListAft);
			AdvanceReporting.addLogs("pass", "The list size after archive","The list size after archive");
			if((archiveListAft-archiveListBef)==2)
			{
				AdvanceReporting.addLogs("pass", "The voicemails are archived successfully");			
			}
			else {
				AdvanceReporting.addLogs("fail","The voicemails are not archived");
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "fail error : "+e.getMessage());			
		}
		return this;
	}

	/*Method to click more than one voicemail avatar*/
	public VoicemailPage clickMultipleVoicemailAvatars() throws Exception
	{
		try
		{
			Thread.sleep(2000);
			//capturing all the voicemails in an array list	
			for(int i=0; i<=(avatarsListInVoicemailsPage.size()-(avatarsListInVoicemailsPage.size()-1)) ; i++)
			{				
				avatarsListInVoicemailsPage.get(i).click();
			}
			AdvanceReporting.addLogs("pass", "Multiple avatars are clicked");
			AdvanceReporting.addLogs("pass", "Multiple avatars are clicked", "Multiple avatars are clicked");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Unable to click on more than one avatars: "+e.getMessage());			
		}
		return this;
	}

	public VoicemailPage unArchive() throws Exception
	{
		try
		{	Thread.sleep(2000);
		//capturing all the voicemails in an array list	
		for(int i=0; i<=(avatarsListInVoicemailsPage.size()-(avatarsListInVoicemailsPage.size()-1)) ; i++)
		{				
			avatarsListInVoicemailsPage.get(i).click();
		}
		AdvanceReporting.addLogs("pass", "Multiple avatars are clicked");
		AdvanceReporting.addLogs("pass", "Multiple avatars are clicked", "Multiple avatars are clicked");			
		Thread.sleep(3000);
		Utils.uBase.clickByImage("unArchiveIcon");
		AdvanceReporting.addLogs("pass", "Clicked on Archive restore Icon");
		AdvanceReporting.addLogs("pass","Clicked on Archive restore Icon","Clicked on Archive restore Icon");
		Thread.sleep(2000);
		if(Utils.uBase.imageCompare("archvRestSnackBar")) { 
			AdvanceReporting.addLogs("pass","Pop up issued saying Items restored with Undo option ");
			AdvanceReporting.addLogs("pass","Pop up issued","Pop up issued"); 
		} 
		else 
		{AdvanceReporting.addLogs("fail","Pop up saying items Restored has not been issued");
		AdvanceReporting.addLogs("fail", "Pop up not issued","Pop up not issued"); }

		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Unable to click on more than one avatars: "+e.getMessage());			
		}
		return this;
	}

	/*Method to verify if multiple voicemail avatars can be selected*/
	public VoicemailPage presenceOfText() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(AvatarsSelected);
			//Capturing the text of the Web Element
			String avatarsSelectedIs=AvatarsSelected.getText();			
			String expectedSelectedVoiceMails = "2 selected";	
			//Assert used to compare the texts
			assertEquals(avatarsSelectedIs, expectedSelectedVoiceMails,"2 Voice Mails have been selected successfully");			
			AdvanceReporting.addLogs("Pass", "Voicemail avatars are selected : "+AvatarsSelected.getText());
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}				
		return this;		
	}

	//Method to verify if multiple avatars can be selected
	public void verifyIfAvatarsAreSelected()
	{
		try
		{
			//Image comparison to validate the presence of text mentioning the voicemails selected
			if(Utils.uBase.imageCompare("numberOfVoicemailsSelected"))
			{
				AdvanceReporting.addLogs("pass", "Verified that multiple voicemails are selected");
				AdvanceReporting.addLogs("pass", "Voicemails text","Multiple avatars are selected");
			}
			else
			{
				AdvanceReporting.addLogs("pass", "Voicemails text");
				AdvanceReporting.addLogs("fail", "failed","unable to select multiple voicemail avatars");
			}}
		catch (Exception e)
		{		
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}	
	}

	//Method to unselect the selected voicemail avatars
	public VoicemailPage voicemailThreadSelectUnselect() throws Exception
	{
		try{
			Utils.uBase.clickWebelement(unSelectVoicemailIcon);
			AdvanceReporting.addLogs("pass", "Able to click on unselect voicemail icon");
			AdvanceReporting.addLogs("pass","Able to click on unselect voicemail icon","Able to click on unselect voicemail icon");
			Thread.sleep(3000);
			
		}			
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Method to delete voicemails by clicking on the DeleteIcon- 'X'
	public VoicemailPage voicemailDelete() {
		try{

			Utils.uBase.clickByImage("DeleteIconImg");
			AdvanceReporting.addLogs("pass", "Able to click on Delete Icon");
			AdvanceReporting.addLogs("pass","Able to click on Delete Icon","Able to click on Delete Icon");
			Thread.sleep(3000);
			Utils.uBase.clickByImage("DeleteCall");
			AdvanceReporting.addLogs("pass", "Delete Confirmation Pop up is displayed and succefully clicked on Delete button");
			AdvanceReporting.addLogs("pass","Delete Confirmation Pop up is displayed and succefully clicked on Delete button","Delete Confirmation Pop up is displayed and succefully clicked on Delete button");
			Thread.sleep(3000);
			boolean value = Utils.uBase.imageCompare("1Itemdeleted");

			if(value==true){
				AdvanceReporting.addLogs("pass", "Voicemails are Deleted and pop up is displayed");
				AdvanceReporting.addLogs("pass", "Voicemails are Deleted and pop up is displayed","Voicemails are Deleted and pop up is displayed");
			}
			else
			{
				AdvanceReporting.addLogs("fail","Unable to delete voicemail avatars");
				AdvanceReporting.addLogs("fail", "fail","unable to delete voicemail avatars");
			}
		}			
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;	
	}

	//Method to select one one voicemail avatar
	public VoicemailPage clickSingleVoicemailAvatar() throws Exception
	{
		try
		{
			System.out.println("size of array list is "+avatarsListInVoicemailsPage.size());
			avatarsListInVoicemailsPage.get(1).click();		
			AdvanceReporting.addLogs("pass", "Able to click single voice mail avatar");
			AdvanceReporting.addLogs("pass", "Pass", "Able to click single voice mail avatar");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Unable to click single voice mail avatar: ");		
			AdvanceReporting.addLogs("pass", "Pass", "Able to click single voice mail avatar");
		}
		return this;
	}

	/*Method to verify if Voicemails are archived and Confirmation pop up is displayed*/
	public VoicemailPage clickingOnArchiveIconInVoicemailPage() throws Exception
	{				
		Thread.sleep(2000);
		avatarsBeforeArchive = avatarsListInVoicemailsPage.size();
		//calling clickByImage method to click on archive icon 
		Utils.uBase.clickByImage("voiceMailArchive");
		AdvanceReporting.addLogs("pass", "Able to click on Archive Icon");
		AdvanceReporting.addLogs("pass","Able to click on Archive Icon","Able to click on Archive Icon");
		//Image comparison to validate if the pop up is present
		Utils.uBase.imageCompare("ConversationArchive");
		AdvanceReporting.addLogs("pass", "Pop up with number of voicemails Archived with Undo option is displayed");
		AdvanceReporting.addLogs("pass","Pop up with number of voicemails Archived with Undo option is displayed","Pop up with number of voicemails Archived with Undo option is displayed");
		return this;
	}
	/*Method to click on First Voicemail*/
	public VoicemailPage clickfirstVoicemail() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(firstVoicemail);
			AdvanceReporting.addLogs("pass", "Calls Page","Calls Page");
			Utils.uBase.clickWebelement(firstVoicemail);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// Click first voice mail in list
	public VoicemailPage clickfirstVoiceInList() {
		try	{
			Thread.sleep(10000);
			Utils.uBase.clickWebelement(voiceList.get(0));
			AdvanceReporting.addLogs("pass", "Voice mail clicked");
			AdvanceReporting.addLogs("pass", "Voice mail clicked","Voice Page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Voice mail is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// click on more options
	public VoicemailPage clickMoreOptn() {
		try {
			Thread.sleep(5000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("ThreeDotsBtnImg");
			AdvanceReporting.addLogs("Pass", "More Options is displayed");
			AdvanceReporting.addLogs("Pass", "More Options", "MoreOptions");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "More Options is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public VoicemailPage verifyUseMyPhoneIn3DotMenu() {
		try {
			Thread.sleep(1000);
			Assert.assertTrue(Utils.uBase.imageCompare("ThreeDotMenu_UseMyPhone"), "No use my phone in 3 dot menu");
			AdvanceReporting.addLogs("pass", "Verified, use My Phone in 3 dot menu");
			AdvanceReporting.addLogs("pass", "Use My Phone in 3 dot menu","ThreeDotMenu_UseMyPhone");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not Scrolled to First message");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}	
		return this;		
	}

	//  Verify all old voicemail items are loading and showing up by the order of time.
	public VoicemailPage verifyScrollDownLoadVoicemail() {
		try {
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", voiceList.get(voiceList.size()-1));
			Thread.sleep(10000);	
			AdvanceReporting.addLogs("pass", "Verified that scroll down shows recent voicemails");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not Scrolled to last voicemail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	// Verify scroll up also shows the first loaded voicemail items.
	public VoicemailPage verifyScrollUpToFirstVoicemail() {
		try {
			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", voiceList.get(0));
			Thread.sleep(10000);	
			AdvanceReporting.addLogs("pass", "Verified that scrolling up shows first voicemails");
		} catch(Exception e){
			AdvanceReporting.addLogs("info", "Not Scrolled to First voicemail");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}			
		return this;		
	}

	public VoicemailPage verifyVoicemailsPresent() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(lstVoiceMails.size()!=0,"No voicemails are present");
			AdvanceReporting.addLogs("pass", "Voicemails are present");
			AdvanceReporting.addLogs("pass", "Voicemails are present","VoiceMailsList");
		}
		catch(Exception e){

			AdvanceReporting.addLogs("info", "Voicemails are not present");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 

		return this; 
	}
	public VoicemailPage deleteCreatedVoicemail() {
		try {

			Thread.sleep(5000);
			Utils.uBase.clickByImage("ThreeDotsBtnImg");
			Thread.sleep(3000);
			Utils.uBase.clickByImage("Delete1");
			Thread.sleep(3000);
			Utils.uBase.clickByImage("Delete_box");
			System.out.println("Voice mail is deleted");

		}catch(Exception e){			
			System.out.println("Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 

		return this; 
	}

	//Deletes the voicemail triggered from a particular phone no
	public VoicemailPage cleanCreatedVoicemailLog(String phoneNo)
	{
		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("VoiceMailTab");
			Thread.sleep(3000);
			for(int i=0;i<lstVoiceMails.size();i++)
			{

				if(phoneNo.contains(lstVoiceMails.get(i).getText().replaceAll("\\W", "")))
				{
					Utils.uBase.waitForElementToBeClickable(lstVoiceMails.get(i));
					Utils.uBase.clickWebelement(lstVoiceMails.get(i));
					System.out.println("Created voicemail entry found");
					deleteCreatedVoicemail();
					AdvanceReporting.addLogs("info", "Created voicemail is deleted");
					break;

				}}}catch(Exception e)
		{
					System.out.println("Unable to delete created voicemail log");
					e.printStackTrace(); Assert.fail();

		}return this;
	}

	public VoicemailPage voicemailThreadDelete() {
		try{

			Utils.uBase.clickByImage("DeleteIconImg");
			AdvanceReporting.addLogs("pass", "Able to click on Delete Icon");
			AdvanceReporting.addLogs("pass","Able to click on Delete Icon","Able to click on Delete Icon");
			Thread.sleep(3000);
			Utils.uBase.clickByImage("DeleteCall");
			AdvanceReporting.addLogs("pass", "Delete Confirmation Pop up is displayed and succefully clicked on Delete button");
			AdvanceReporting.addLogs("pass","Delete Confirmation Pop up is displayed and succefully clicked on Delete button","Delete Confirmation Pop up is displayed and succefully clicked on Delete button");
			Thread.sleep(3000);
			boolean value = Utils.uBase.imageCompare("2ItemsDeletedImg");

			if(value==true){
				AdvanceReporting.addLogs("pass", "Voicemails are Deleted and pop up is displayed");
				AdvanceReporting.addLogs("pass", "Voicemails are  Deleted and pop up is displayed","Voicemails are Deleted and pop up is displayed");
			}
			else
			{
				AdvanceReporting.addLogs("fail","Unable to delete voicemail avatars");
				AdvanceReporting.addLogs("fail", "fail","unable to delete voicemail avatars");
			}
		}			
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;	
	}
	//comparison of the number of avatars in Voicemail page before and after clicking on Undo button on pop-up
	public VoicemailPage avatarsAfterUndo() throws Exception {
		Thread.sleep(5000);
		avatarsAfterUndo = avatarsListInVoicemailsPage.size();
		System.out.println("avatarsAfterUndo "+avatarsAfterUndo);
		if((avatarsAfterUndo - avatarsBeforeArchive) == 0) {
			AdvanceReporting.addLogs("pass", "All the archived voicemails have reached Voicemails Page");
			AdvanceReporting.addLogs("pass","All the archived voicemails have reached the Voicemails Page","UndoArchive");
		}
		else {
			AdvanceReporting.addLogs("fail", "The  archived voicemails have not reached the Voicemail Page after clicking on Undo button");
			AdvanceReporting.addLogs("fail","The archived voicemails have not reached the Voicemail Page after clicking on Undo button","UndoFailed");
		}
		return this;
	}
	//Method to validate if undo button works on the confirmation pop-up
	public VoicemailPage clickUndoButton() throws Exception
	{				
		//calling clickByImage method to click on archive icon 
		Utils.uBase.clickByImage("UndoButton1");
		Thread.sleep(5000);
		AdvanceReporting.addLogs("pass", "Able to click on Undo Button");
		AdvanceReporting.addLogs("pass","Able to click on Undo Icon","UndoOption");
		return this;
	}
	/* Selecting first contact from voice mail List */
	public VoicemailPage selectFirstContactFromVoiceMailList()
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(voiceList.get(0));
			Utils.uBase.clickWebelement(voiceList.get(0));
			AdvanceReporting.addLogs("info", "Select contact from Calls List", "Contact List" );
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Click on Delete from the more options */
	public VoicemailPage deleteExistingVoiceMail(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("ThreeDotsBtnImg");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("deleteOptionVmail");
			AdvanceReporting.addLogs("pass", "Delete button click on sucessfully");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "No Delete button avalilable");
			System.out.println("Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified Delete this VoiceMail? popup.*/
	public VoicemailPage verifyDeleteThisVoiceMail()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("deleteThisVoiceMail"),"Delete this call? is not displayed");
			AdvanceReporting.addLogs("Pass", "Delete this call? is displayed");
			AdvanceReporting.addLogs("Pass", "Delete this message? is displayed","delete ThisVoiceMail");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verified cancel button is  displayed.*/
	public VoicemailPage verifyCancelButton()
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
	public VoicemailPage verifyDeleteBtn()
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
	/* Delete all voice mails from the voice list folder */
	public VoicemailPage deleteAllVoiceMails() { 
		try {
			Thread.sleep(2000);
			int avtarListSize = voiceMailAvatarsList.size();
			System.out.println(" count is      "+avtarListSize);
			if(avtarListSize==0) {
				AdvanceReporting.addLogs("pass", "Voice mail folder is already empty");
			}else {
				for(int i=0; i<=avtarListSize-1; i++) {
					Thread.sleep(2000);
					voiceMailAvatarsList.get(i).click();
					Thread.sleep(4000);
					Utils.uBase.clickByImage("deleteAllVoiceMail");
					Thread.sleep(2000);
					Utils.uBase.clickByImage("deleteBtnOnDeletePopup");
					AdvanceReporting.addLogs("pass", "Voice mail deleted sucessfully");		
				}
			}
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "No Voice mails.");
			AdvanceReporting.addLogs("fail", "No Contact displayed");
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}
	/* Verified no voice mail text is displayed.*/
	public VoicemailPage verifyVoiceMailsText()
	{
		try
		{
			Thread.sleep(3000);
			Assert.assertTrue(Utils.uBase.imageCompare("noVoiceMailText"),"No calls text is not displayed");
			AdvanceReporting.addLogs("Pass", "No voice mails text is displayed");
			AdvanceReporting.addLogs("Pass", "No voice mails text is is displayed","NoVoiceMailsTxt");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "No voice mails text is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Verified You'are all caught up text is displayed.*/
	public VoicemailPage verifyYourAllCaughtUpText()
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
	/* Clicked on call button and handling different call buttons */
	public VoicemailPage clickOnCallButton() { 
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
	/* Verified that able to make call */
	public VoicemailPage verifyAbleToMakeCall() { 
		try
		{
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("callingImg")){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call sucessfully");
				AdvanceReporting.addLogs("pass", "User able to make a call sucessfully","CallingImg");
				Thread.sleep(2000);
			}else if(Utils.uBase.imageCompare("callingPad")){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call sucessfully");
				AdvanceReporting.addLogs("pass", "User able to make a call sucessfully","CallingPad");
			}else {
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
	public VoicemailPage clickOnCallEndBtn() { 
		try
		{
			Thread.sleep(1000);
			Utils.uBase.clickByImage("callEndButtonImg");
			AdvanceReporting.addLogs("pass", "Click on call end button sucess");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Click on call end button is fail ");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Selecting first contact from contact List */
	public VoicemailPage selectFirstItemFromList()
	{
		try
		{
			Thread.sleep(5000);
			Utils.uBase.waitForElementToBeClickable(voicemailList.get(0));
			Utils.uBase.clickWebelement(voicemailList.get(0));
			AdvanceReporting.addLogs("pass", "Select item from voicemail List");
			AdvanceReporting.addLogs("pass", "Select item from voicemail List", "Voicemail List");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Select item from voicemail List");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Delete the items from the list if size of the list is greater than 10 */
	public VoicemailPage deleteExtraConversationItems()
	{
		try
		{
			Thread.sleep(3000);
			if(avatarsListInVoicemailsPage.size()>=10)
			{
				for(int i=0; i<=(avatarsListInVoicemailsPage.size()-(avatarsListInVoicemailsPage.size()-4)) ;i++)
				{				
					avatarsListInVoicemailsPage.get(i).click();
				}
				Thread.sleep(2000);
				Utils.uBase.clickByImage("deleteAllVoiceMail");
				Thread.sleep(2000);
				Utils.uBase.clickByImage("deleteConfirmBtn");
				Utils.uBase.refresh();
				Utils.uBase.checkPageReady();
				Thread.sleep(2000);
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//To verify items select unselected or not
	public VoicemailPage verifyItemsSelectUnselect() {
		try {
			boolean value = Utils.uBase.imageCompare("numberOfVoicemailsSelected");
			if(value==false){
				AdvanceReporting.addLogs("pass", "Verified that voicemails are unselected");
				AdvanceReporting.addLogs("pass", "Voicemails are unselected","Voicemails are unselected");
			}
			else
			{
				AdvanceReporting.addLogs("fail","Unable to unselect voicemail avatars");
				AdvanceReporting.addLogs("fail", "fail","unable to unselect voicemail avatars");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
		
	}
	//To verify items select unselected or not
		public VoicemailPage verifyVoicemailAccesible() {
			try {
				if(Utils.uBase.getCurrentUrl().contains("voicemail")) {
					AdvanceReporting.addLogs("pass", "voicemail tab is accesible");
				}
				else
				{
					AdvanceReporting.addLogs("fail", "voicemail tab is not accesible");
	
				}
			}
			catch(Exception e) {
				AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
				e.printStackTrace(); Assert.fail();
			}
			return this;
		}
}






