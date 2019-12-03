package automationBed_Google.pom.gv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;



public class HangoutsPage {
	
	@FindBy(xpath="//*[@aria-label='Enter name, email, or phone']")
	WebElement searchText;
	
	@FindBy(xpath="//*[contains(text(),'New ')]")
	WebElement newConversation;
	
	@FindBy(xpath="//*[contains(text(),'Disabled')]")
	WebElement msgDisableText;
	
	@FindBy(xpath="//iframe[@aria-label=\"Contacts and conversations\"]")
	WebElement iFrame;
	
	@FindBy(xpath="//iframe[@aria-label='Test']")
	WebElement iframeUnreadMsg;
	
	@FindBy(xpath="//iframe[contains(@aria-label,'Test')]")
	WebElement chatFrame;
	
	//@FindBy(xpath="//iframe[@aria-label='Test']")
	@FindBy(xpath="//div[@class='vE dQ editable']")
	WebElement msgInputBox;
	
	@FindBy(xpath="//span[contains(text(),'Send an SMS message')]")
	WebElement span;
	
	//Switches to the new hangout window opened
	public HangoutsPage switchToHangoutsWindow()
	{
		try {
			
			Utils.uBase.switchWindowByTitle("Google Hangouts");
		   		
		}catch(Exception e) {
			
		}return this;
	}
	
	//Clicks on new conversation in hangouts window
	public HangoutsPage clickNewConversation()
	{
		try
		{
			Thread.sleep(1000);
			Utils.uBase.clickByImage("plus");
			AdvanceReporting.addLogs("pass","Clicked on new conversation in hangouts page");
			AdvanceReporting.addLogs("pass","Clicked on new conversation in hangouts page","NewConversation");
			
		}catch(Exception e) {
			AdvanceReporting.addLogs("fail","Failed to click on new conversation in hangouts page");
			
		}return this;
	}
	
	//Enters contact name in hangouts window
	public HangoutsPage enterContactName()
	{
		try
		{			
			Utils.uBase.switchToFrame_byWebElement(iFrame);
			searchText.sendKeys("Test");
			Thread.sleep(3000);
			Utils.uBase.clickByImage("TestName");
			//Utils.uBase.pressKeyEnter(searchText);
			AdvanceReporting.addLogs("pass","Contact name entered");
			AdvanceReporting.addLogs("pass","Entered","ContactEntered");
		Utils.uBase.webDriver.switchTo().defaultContent();
		}catch(Exception e) {
			AdvanceReporting.addLogs("fail","Unable to enter contact in hangouts page");
			
		}return this;
	}
	
	//Verifies if messages are disabled in hangouts page
	public HangoutsPage verifyMsgDisabledTxtDisplayed()
	{
		try
		
		{
			Thread.sleep(3000);
			Assert.assertTrue(Utils.uBase.imageCompare("DisabledMsHangouts"),"Mismatch: disabled is not displayed");
			AdvanceReporting.addLogs("pass","Hangouts messages are disbaled");
			AdvanceReporting.addLogs("pass","Hangouts messages are disbaled","HangoutsMsg");
			
			Utils.uBase.switchToDefaultContent();
			
		}catch(Exception e) {
			AdvanceReporting.addLogs("fail"," Unable to verify if messages are disabled in hangouts");
			
		}return this;
	}
	
	//Sends a message in hangouts page
	public HangoutsPage sendMessageInHangouts()
	{
		try
		
		{
			Thread.sleep(2000);
			Utils.uBase.switchToFrame_byWebElement(chatFrame);
			Utils.uBase.setText(msgInputBox, Constants.TestMsg);
			AdvanceReporting.addLogs("pass","Entered test message","TestMsg");
			Utils.uBase.pressKeyEnter(msgInputBox);
			AdvanceReporting.addLogs("pass","MEssage sent","HiMsgSent");
			AdvanceReporting.addLogs("pass","Hangouts messages are enabled");
			AdvanceReporting.addLogs("pass","Hangouts messages are enabled","SentMessage");
			Thread.sleep(3000);
			Assert.assertTrue(Utils.uBase.imageCompare("MsgSuccess"),"Hangout message not sent");
			
		}catch(Exception e) {
			AdvanceReporting.addLogs("fail"," Unable to send  messages  in hangouts");
			
		}return this;
	}
	
	//When a new user opens hangout, few screens are displayed, this method navigates forward to home page 
	public HangoutsPage navigateToHomePage()
	{
		try {
				for(int i=0;i<=3;i++)
				{
					Thread.sleep(2000);
				if(Utils.uBase.imageCompare("NextHangouts"))
				{
					Thread.sleep(2000);
					Utils.uBase.clickByImage("NextHangouts");
					Thread.sleep(1000);
				}else if(Utils.uBase.imageCompare("HangoutsTick"))
				{
					Thread.sleep(2000);
					Utils.uBase.clickByImage("HangoutsTick");
				}
			}
			
		}catch(Exception e) {
			
		}return this;
		
	}
	
	
	}
