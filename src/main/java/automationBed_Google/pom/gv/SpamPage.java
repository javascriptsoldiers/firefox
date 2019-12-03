package automationBed_Google.pom.gv;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class SpamPage {

	@FindBy(xpath="//div[@gv-test-id='conversation-avatar-or-checkmark']")
	List<WebElement> avatarsFromSpamList;
	@FindBy(xpath="//div[@aria-selected='false']")
	List <WebElement> listItem;
	@FindBy(xpath="//*[@role='gridcell']/*[@role='img']")
	WebElement threeDotsOption;
	@FindBy(xpath="//*[contains(@aria-label,'Unmark as spam')]")
	WebElement unspamImg;
	@FindBy(xpath="//*[@aria-describedby='cdk-describedby-message-8']")
	WebElement makeACallIcon;
	@FindBy(xpath="//*[@gv-test-id='conversation-avatar-or-checkmark']")
	List<WebElement> AvatarsList;
	@FindBy(xpath="//*[contains(@class,'LKz3Fb-bVEB4e')]")
	List <WebElement> msgList;



	//method to verify if multiple avatars are selected
	public void selectAvatarsFromList()
	{
		try
		{
			Thread.sleep(2000);
			for(int i=0;i<avatarsFromSpamList.size();i++) {
				Utils.uBase.clickWebelement(avatarsFromSpamList.get(i));
				Thread.sleep(1000);}
			if(Utils.uBase.imageCompare("SpamsSelectedIconImg"))
			{
				AdvanceReporting.addLogs("pass", "Spams are selected");
				AdvanceReporting.addLogs("pass", "Spams are selected","SpamsSelected");
			}
			else
			{
				AdvanceReporting.addLogs("info", "Spams are not selected");
				AdvanceReporting.addLogs("fail", "failed","SpamsAreNotSelected");
			}}
		catch (Exception e)
		{                              
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}              
	}

	//Method to unselect the selected call avatars
	public SpamPage verifyAvatarsAreUnselect()
	{
		try{
			Utils.uBase.clickByImage("UnselectSpamImg");
			AdvanceReporting.addLogs("pass", "Able to click on unselect Spam icon");
			AdvanceReporting.addLogs("pass","Able to click on unselect Spam icon","UnSelectedSpam");
		}                                              
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Unable to click on unselect Spam icon");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Method to unspam threads by clicking "Unspam icon"
	public SpamPage unspamThreads(int count)
	{
		try{
			if(Utils.uBase.imageCompare("AllowButtonImg"))
			{
				Utils.uBase.clickOnNotificationAllowBtn();
			}
			Thread.sleep(2000);
			Utils.uBase.clickByImage("UnspamThreads");
			AdvanceReporting.addLogs("pass", "Able to click on Unspam icon");
			AdvanceReporting.addLogs("pass","Able to click on Unspam icon","UnspamThreads");
			//Utils.uBase.refresh();
			Thread.sleep(3000);
		}	                                
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Unable to click on UnSpam icon");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}  

	//Method to undo threads by clicking "Unspam icon"
	public SpamPage verifyUnspamThreadsAreUndo(int count)
	{
		try{

			Thread.sleep(2000);
			int sizeBeforeUndoSpam = avatarsFromSpamList.size();
			Utils.uBase.clickByImage("UndoButton");
			AdvanceReporting.addLogs("pass", "Able to click on Undo Button");
			AdvanceReporting.addLogs("pass","Able to click on Undo Button","Undone UnspamThreads");
			//Utils.uBase.refresh();
			Thread.sleep(6000);
			int sizeAfterUndoSpam = avatarsFromSpamList.size();
			/* verify that Spam items are placed again in calls folder */
			if(sizeBeforeUndoSpam==sizeAfterUndoSpam+count) 
			{
				AdvanceReporting.addLogs("pass", "Verified that spam items are restored into spam folder.");
				AdvanceReporting.addLogs("pass", "Spam items are restored into spam folder.","UnSpamThreadsUndone");
			}else {
				AdvanceReporting.addLogs("info", "Spam items are not restored into spam folder","UnSpamThreadsNotUndone");
			}
		}                                              
		catch (Exception e)
		{
			AdvanceReporting.addLogs("Info", "Unable to click on Undo Button");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Method to delete threads by clicking "delete icon"
	public SpamPage verifyDeleteMultipleSpamThreads()
	{
		try{
			int sizeBeforeDelete = avatarsFromSpamList.size();
			Utils.uBase.clickByImage("DeleteIconImg");
			Utils.uBase.clickByImage("DeleteBtnPopUp");
			AdvanceReporting.addLogs("pass", "Able to click on Delete icon");
			AdvanceReporting.addLogs("pass","Able to click on Delete icon","DeleteThreads");
			//Utils.uBase.refresh();
			int sizeAfterDelete = avatarsFromSpamList.size();
			/* verify that Spam items are placed again in calls folder */
			if(sizeBeforeDelete==sizeAfterDelete-2)
			{
				AdvanceReporting.addLogs("Pass", "Verified that spam threads are deleted from spam folder.");
				AdvanceReporting.addLogs("Pass", "Spam threads are deleted from spam folder.","SpamThreadsDeleted");
			}else {
				AdvanceReporting.addLogs("Pass", "Spam threads are not deleted from spam folder","SpamThreadsNotDeleted");
			}

		}                                              
		catch (Exception e)
		{
			AdvanceReporting.addLogs("Info", "Unable to click on Delete icon");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}  
	//method to verify if multiple avatars are selected
	public void verifyIfAvatarIsSelected()
	{
		try
		{
			Thread.sleep(2000);
			Assert.assertEquals(true, Utils.uBase.imageCompare("multipleAvatarselect"));
			AdvanceReporting.addLogs("pass", "Verified that multiple avatars are selected");
		}
		catch (Exception e)
		{                              
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}              
	}

	public SpamPage clickThreeDots() throws Exception
	{
		try
		{
			Utils.uBase.clickByImage("More options");
			AdvanceReporting.addLogs("info", "Clicked on three dotted more option");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/*public SpamPage clickUnmarkAsSpamImg() throws Exception
	{
		try
		{
			Utils.uBase.clickByImage("unmarkAsSpam");
			AdvanceReporting.addLogs("info", "Clicked on unmark as Spam Img");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}*/
	//Method to unspam threads by clicking "Unspam icon"
	public SpamPage clickAndVerifyItemUnspam()
	{
		try{
			int sizeBeforeUnspam = listItem.size();
			System.out.println("sizeBeforeUnspam           " +sizeBeforeUnspam);
			Utils.uBase.clickByImage("unmarkAsSpam");
			AdvanceReporting.addLogs("pass", "Able to click on Unspam img");
			AdvanceReporting.addLogs("pass","Able to click on Unspam img","UnspamItem");
			//Utils.uBase.refresh();
			Thread.sleep(3000);
			int sizeAfterUnspam = listItem.size();
			System.out.println("sizeAfterUnspam           " +sizeAfterUnspam);
			/* verify that Spam items are placed again in calls folder */
			if(sizeBeforeUnspam==sizeAfterUnspam-1) 
			{
				AdvanceReporting.addLogs("pass", "Spam item is removed from spam folder.","SpamItemRemoved");
			}else {
				AdvanceReporting.addLogs("info", "Spam item is not removed from spam folder","SpamItemNotRemoved");
			}


		}                                              
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Unable to click on UnSpam img");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Method to click on Messages Item"
	public SpamPage clickMessagesItem() throws Exception
	{
		try
		{
			Utils.uBase.clickByImage("MessageItemIcon");
			AdvanceReporting.addLogs("info", "Clicked on message item from spam");
			AdvanceReporting.addLogs("info", "Clicked on message item from spam","MessageItemIcon");

		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Msg input box & Send btn is visible.");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Method to verify message input box and send buttons are invisible */

	public SpamPage verifyMsgInputBoxAndSendBtn() throws Exception
	{
		try
		{
			Assert.assertFalse(Utils.uBase.imageCompare("messageInputBoxAndSendButton"),"Message input box and Send button are visible");
			AdvanceReporting.addLogs("pass", "Verified that message input box and Send button are invisible as expected");
			AdvanceReporting.addLogs("pass", "Message input box is invisible as expected","MsgInputbox invisible");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Msg input box & Send btn is visible.");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	// method to click callItem
	public SpamPage clickItemFromList()
	{
		try
		{
			Thread.sleep(3000);
			Utils.uBase.clickWebelement(listItem.get(0));
			AdvanceReporting.addLogs("info", "Clicked on a spam Item");
		}
		catch (Exception e)
		{                              
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}     
		return this;
	}
	// Click on more options
	public SpamPage clickMoreOptn() {
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
	// Method to delete Item from Spam
	public SpamPage deleteItemFromSpam()
	{
		try{
			Thread.sleep(1000);
			int sizeBeforeDelete = listItem.size();
			Utils.uBase.clickByImage("Delete1");
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("DeletePermanentlyPopUp")) {
				Utils.uBase.clickByImage("IUnderstand");
				Utils.uBase.clickByImage("DeleteBtnPopUp");
			}else if(Utils.uBase.imageCompare("PermanentlyDeleteVoicemailPopUp")) {
				Utils.uBase.clickByImage("DeleteBtnPopUp");
			}else if(Utils.uBase.imageCompare("PermanentlyDeleteCall")) {
				Utils.uBase.clickByImage("DeleteBtnPopUp");
			}
			Thread.sleep(3000);
			int sizeAfterDelete = listItem.size();
			/* verify that Spam items are placed again in calls folder */
			if(sizeBeforeDelete==sizeAfterDelete-1) 
			{
				AdvanceReporting.addLogs("pass", "Spam item is deleted forever from spam folder.","SpamItemDeleted");
			}else {
				AdvanceReporting.addLogs("info", "Spam item is not deleted from spam folder","SpamItemNotDeleted");
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

	// Method to click makeAcall Icon img
	public SpamPage clickmakeAcallIcon()
	{
		try{
			Thread.sleep(3000);
			Utils.uBase.clickByImage("makeAcallIcon");
			AdvanceReporting.addLogs("info", "Able to click on makeAcallIcon img");
			AdvanceReporting.addLogs("pass","Able to call blocked number","MakeAcallIcon");


		}                                              
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Not Able to click on makeAcallIcon img");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	// Method Verify you are able to call the call sender
	public SpamPage verifyAbleToCall()
	{
		try{
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("callingStatus")==true) {
				AdvanceReporting.addLogs("info", "Verified that able to call the sender from spam");
				AdvanceReporting.addLogs("pass","Able to call the sender from spam","callingStatus");
			}
		}                                              
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Not able to call the sender from spam");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	// Method to handle browser notification 
	public SpamPage clickAllowOnBrowserNotification()
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
	//To block the number
	public SpamPage clickBlockNumberFrmMoreOptn(){
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("blockNumber");
			Utils.uBase.clickByImage("BlockButtonPopup");
			AdvanceReporting.addLogs("pass", "Number is Blocked");
			Thread.sleep(1000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Block number not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}  

	//verify the list of calls available in the Spam list
	public SpamPage verifySpamCount() {

		try {
			Thread.sleep(3000);
			AdvanceReporting.addLogs("Info", "size of array in call list is "+avatarsFromSpamList.size());
			if(avatarsFromSpamList.size() == AvatarsList.size())
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

	//To Unblock the number
	public SpamPage clickUnBlockNumber(){
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("UnblockNumber");
			Thread.sleep(1000);
			Utils.uBase.clickByImage("UnblockButton");
			AdvanceReporting.addLogs("info", "UnBlock number clicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "UnBlock number not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	} 

	/* Verified items received from identified spam accounts are sent directly */
	public SpamPage verifySpamSentDirectlyToSpamFolder() {
		try {
			Thread.sleep(1000);
			for(int i=0; i<=msgList.size()-1; i++) {
				String listOfMessages = msgList.get(i).getText();
				Thread.sleep(1000);
				if(listOfMessages.contentEquals("Test message")) {
					msgList.get(i).click();
					AdvanceReporting.addLogs("pass","Received from identified spam accounts are sent directly to the Spam folder");
					AdvanceReporting.addLogs("pass","Received from identified spam accounts are sent directly to the Spam folder","receivedSpamMsg");
					break;
				}else {
					AdvanceReporting.addLogs("fail","Received from identified spam accounts are sent directly not into the Spam folder");
					AdvanceReporting.addLogs("fail","Received from identified spam accounts are sent directly not into the Spam folder","noSpamMsg");
				}
			}
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","Received from identified spam accounts are sent directly not into the Spam folder");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}		

	/* Delete selected Spam */
	public SpamPage deleteSpamWithDifferentBtns(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("threeDots");
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
	/* Verified items received from identified spam accounts are received into the proper folder, and not the spam folder.*/
	public SpamPage verifySpamSentDirectlyNotIntoToSpamFolder() {
		try {
			Thread.sleep(1000);
			for(int i=0; i<=msgList.size()-1; i++) {
				String listOfMessages = msgList.get(i).getText();
				Thread.sleep(1000);
				if(!listOfMessages.contentEquals("Test message")) {
					//msgList.get(i).click();
					AdvanceReporting.addLogs("pass","Received from identified spam accounts are sent directly not into to the Spam folder");
					AdvanceReporting.addLogs("pass","Received from identified spam accounts are sent directly not into to the Spam folder","noSpamMsg");
					break;
				}else {
					AdvanceReporting.addLogs("fail","Received from identified spam accounts are sent directly in the Spam folder");
					AdvanceReporting.addLogs("fail","Received from identified spam accounts are sent directly in the Spam folder","SpamMsg");
				}
			}
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","Received from identified spam accounts are sent directly into the Spam folder");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		} 
		return this; 
	}		
	/* Selecting UnmarkAsSpam */
	public SpamPage selectUnmarkAsSpam()
	{
		try
		{
			Thread.sleep(1000);
			int sizeBeforeUnSpam = listItem.size();
			Utils.uBase.clickByImage("unmarkAsSpam");
			AdvanceReporting.addLogs("info", "Click on spam option sucessfully.");
			Thread.sleep(1000);
			int sizeAfterUnSpam = listItem.size();
			/* verify that Spam items are placed again in folder */
			if(sizeBeforeUnSpam==sizeAfterUnSpam-1) 
			{
				AdvanceReporting.addLogs("pass", "Spam item is UnSpam forever from spam folder.","SpamItemUnSpam");
			}else {
				AdvanceReporting.addLogs("info", "Spam item is not UnSpam from spam folder","SpamItemNotUnSpam");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}	

	// Clicking on close to unselect avatars
	public SpamPage unselectMultipleThreads()
	{
		try
		{
			Utils.uBase.clickByImage("CloseSelectedImg");
			AdvanceReporting.addLogs("info", "Unselected multiple threads of spam items by clicking 'X'");
			AdvanceReporting.addLogs("info", "Multiple avatars are unselected", "Multiple avatars are unselected");
		}
		catch (Exception e)
		{                              
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}     
		return this;
	}

	//method to verify if multiple avatars are unselected
	public void verifyIfAvatarIsunSelected()
	{
		try
		{
			Thread.sleep(6000);
			Assert.assertFalse(Utils.uBase.imageCompare("threeItemsSelected"));
			AdvanceReporting.addLogs("pass", "Multiple avatars are unselected");
		}
		catch (Exception e)
		{                              
			AdvanceReporting.addLogs("fail", "Error Message: "+ e.getMessage());
		}              
	}
}
