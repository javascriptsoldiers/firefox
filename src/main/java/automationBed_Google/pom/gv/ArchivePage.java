package automationBed_Google.pom.gv;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class ArchivePage {
	
	@FindBy(xpath="//*[@gv-test-id='conversation-avatar-or-checkmark']")
    List<WebElement> AvatarsList;
	
	public ArchivePage clickMultipleAvatars() {
		try {
			System.out.println("size of array list is "+AvatarsList.size());
             for(int i =0; i <=(AvatarsList.size()-(AvatarsList.size()-1)) ; i++)
		       {                         
		       AvatarsList.get(i).click();
		       }
		       AdvanceReporting.addLogs("pass", "Able to click more than one  avatar");
		       AdvanceReporting.addLogs("pass", "Able to click more than one  avatar", "SelectMultipleAvatar");
		       }
		       catch (Exception e)
		       {
		       AdvanceReporting.addLogs("fail", "Unable to click more than one  avatar");  
		       AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
				   e.printStackTrace(); Assert.fail();
		       }
		           return this;
		       }
	
	public ArchivePage unSelectMultipleAvatars() {

		try {
			
			Utils.uBase.clickByImage("unSelectAll");
			AdvanceReporting.addLogs("pass", "Able to UnSelect the selected Multiple Avatars ");
		       AdvanceReporting.addLogs("pass", "Able to UnSelect the selected Multiple Avatars", "UnselectAvatars");
		       }
		       catch (Exception e)
		       {
		       AdvanceReporting.addLogs("fail", "Unable to click Unselect the  Avatars");
		       AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		      	e.printStackTrace(); Assert.fail();
		       }
	           return this;
		       }
	public ArchivePage clickRestoreBtn() {

		try {
			
			Utils.uBase.clickByImage("restoreBtn");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Able to restore the selected Avatars");
		       AdvanceReporting.addLogs("pass", "Able to restore the selected Avatars", "restoreAvatars");
		       }
		       catch (Exception e)
		       {
		       AdvanceReporting.addLogs("fail", "Unable to restore the selected Avatars");
		      AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		       }
	           return this;
		       }
	
	public ArchivePage verifyRestoreCnfrmPopUp() {

		try {
				Thread.sleep(2000);
  			  if(Utils.uBase.imageCompare("restoreCnfrm"))
  			  {
  			  AdvanceReporting.addLogs("pass", "Verified that restore pop up gets displayed for Avatars getting Restore");
  			  AdvanceReporting.addLogs("pass", "Restore pop up gets displayed for Avatars getting Restore","RestoreAvatars");
  			  }
  			  else
  				  { 
  					  AdvanceReporting.addLogs("info","No confirmation pop up for Avatars getting Restore");
  					  AdvanceReporting.addLogs("fail", "No Archive confirmation");
  					  
  				  }
  			  
      			  }
      			catch(Exception e){
      			AdvanceReporting.addLogs("info", "No confirmation pop up for Avatars getting Restore");
      			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
      			e.printStackTrace(); Assert.fail();
      			} 
      			return this; 
      	}
	
	public ArchivePage clickUndoBtn() {

        try {
        
               Utils.uBase.clickByImage("Undobutton");
               Thread.sleep(2000);
               AdvanceReporting.addLogs("pass", "Able to restore the selected Avatars");
               AdvanceReporting.addLogs("pass", "Able to restore the selected Avatars", "restoreAvatars");
               }
               catch (Exception e)
               {
               AdvanceReporting.addLogs("fail", "Unable to restore the selected Avatars");
              AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
               e.printStackTrace(); Assert.fail();
               }
            return this;
               }
	
	//click on block number
		public ArchivePage clickBlockNumberFrmMoreOptn(){
			try {
				Thread.sleep(3000);
				Utils.uBase.clickByImage("blockNumber");
				AdvanceReporting.addLogs("info", "Block number clicked");
				AdvanceReporting.addLogs("pass", "Block number clicked");
				Thread.sleep(2000);
			} catch (Exception e) {
				AdvanceReporting.addLogs("info", "Block number not clicked");
				AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
				e.printStackTrace(); Assert.fail();
			}
			return this;
		}        	
		
		// verify block number pop up
		public ArchivePage verifyBlockNumberPopup(){
			try {
				Thread.sleep(5000);
				Assert.assertTrue(Utils.uBase.imageCompare("archiveBlockPopUp"), "Block number pop up didn't appear");
				AdvanceReporting.addLogs("pass", "Block number pop up appeared");
				AdvanceReporting.addLogs("pass", "Block number pop up appeared","BlockPopUp");
			} catch(Exception e) {
				AdvanceReporting.addLogs("info", "Block number pop up didn't appear");
				AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
				e.printStackTrace(); Assert.fail();
			} 
			return this;
		}

		//click on block number
		public ArchivePage clickBlockNumber(){
			try {
				Thread.sleep(3000);
				Utils.uBase.clickByImage("archiveBlock");
				AdvanceReporting.addLogs("info", "Block number clicked");
				AdvanceReporting.addLogs("pass", "Block number clicked");
				Thread.sleep(2000);
			} catch (Exception e) {
				AdvanceReporting.addLogs("info", "Block number not clicked");
				AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
				e.printStackTrace(); Assert.fail();
			}
			return this;
		}    
		
		// click EndNow to disable Do Not Disturb
		public ArchivePage clickEndNowToDisableDoNotDisturb(){
			try {
				Thread.sleep(10000);
				Utils.uBase.clickByImage("EndNow");
				Thread.sleep(5000);
				AdvanceReporting.addLogs("info","Clicked on end now");
				AdvanceReporting.addLogs("pass","Clicked on end now","End Now");
			} catch(Exception e){
				AdvanceReporting.addLogs("fail", "Not clicked on end now");
				AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
				e.printStackTrace(); Assert.fail();
			}	
			return this;		
		}
		
		//Verify do not disturb banner goes off of the screen
		public ArchivePage verifyDoNotDisturbIsNotDisplayed() {
			try {
				Thread.sleep(15000);
				Utils.uBase.checkPageReady();
				Assert.assertFalse(Utils.uBase.imageCompare("DoNotDisturbBanner"), "Do not disturb banner is displayed");
				AdvanceReporting.addLogs("pass", "Do not disturb banner is not displayed");
				AdvanceReporting.addLogs("pass", "Do not disturb banner","DoNotDisturbBanner");
			} catch(Exception e) {
				AdvanceReporting.addLogs("info", "Do not disturb banner is displayed");
				AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
				e.printStackTrace(); Assert.fail();
			}			
			return this;		
		}
		
		//To Unblock the number
				public ArchivePage clickUnBlockNumberFrmMoreOptn(){
					try {
						Thread.sleep(5000);
						Utils.uBase.clickByImage("threeDots");
						AdvanceReporting.addLogs("pass", "Click Three Dots BtnImg");
						Thread.sleep(4000);
						Utils.uBase.clickByImage("UnblockNumber");
						AdvanceReporting.addLogs("info", "UnBlock number clicked");
						AdvanceReporting.addLogs("pass", "UnBlock number clicked");
						Thread.sleep(4000);
						Utils.uBase.clickByImage("UnblockButton");
						AdvanceReporting.addLogs("info", "UnBlock number clicked");
						AdvanceReporting.addLogs("pass", "UnBlock number clicked");
						Thread.sleep(2000);
					} catch (Exception e) {
						AdvanceReporting.addLogs("info", "UnBlock number not clicked");
						AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
						e.printStackTrace(); Assert.fail();
					}
					return this;
				} 
}
