package automationBed_Google.pom.gv;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import automationBed_Google.utility.constants.Constants;
import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class KeyboardActionsPage
{
	//Locators
	@FindBy(xpath="//*[contains(@content,'ProfileNames')]")
	WebElement firstMessage;
	@FindBy(xpath="//*[contains(@id,'dialogContent')]")
	WebElement dialogContent;
	@FindBy(xpath="//*[contains(text(),'Navigation')]")
	WebElement navigation;
	@FindBy(xpath="//button[@aria-label='Close']")
	WebElement closeBtn;
	@FindBy(xpath="//*[contains(@gv-test-id,'greeting')]")
	WebElement greeting;
	String a = "//*[contains(text(),'";
	String b = "')]";
	@FindBy(xpath="//*[contains(@ng-click,'ctrl.onClick($event)')]")
	List <WebElement> CalllistItem;
	@FindBy(xpath="//*[contains(@ng-click,'ctrl.onClick($event)')]/div[1]")
	List <WebElement> avatarSelect;
	@FindBy(xpath="//*[contains(@aria-label,'List of keyboard shortcuts')]")
	WebElement keyboardShortcuts;
	/* Press Shift+'?' to Open keyboard shortcuts help screen. */
	public KeyboardActionsPage shiftQstn() throws Exception
	{
		try
		{
			//Utils.uBase.checkPageReady();
			Thread.sleep(4000);
			Actions keyAction = new Actions(Utils.uBase.webDriver);     
			keyAction.keyDown(Keys.SHIFT).sendKeys("?").keyUp(Keys.SHIFT).perform();
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Verifying the instructions mentioned with title and subheading */
	public KeyboardActionsPage keyboardShortcutContents(String data)
	{
		try
		{
			String instructions = null;
			boolean imgcomp = false;
			JavascriptExecutor js = (JavascriptExecutor) Utils.uBase.webDriver;
			if(data.equalsIgnoreCase("Navigation")) {
				instructions = Constants.Navigation;
			}else if(data.trim().equalsIgnoreCase("Thread List Actions")) {
				instructions = Constants.ThreadListActions;
			}else if(data.trim().equalsIgnoreCase("Message List Actions")) {
				instructions = Constants.MessageListActions;
			}else if(data.trim().equalsIgnoreCase("Thread Actions")) {
				instructions = Constants.ThreadActions;
			}else if(data.trim().equalsIgnoreCase("General Actions")) {
				instructions = Constants.GeneralActions;
			}else if(data.trim().equalsIgnoreCase("Help")) {
				instructions = Constants.Help;
			}			
			String[] str = instructions.split("\\|");
			int strSize = str.length;
			Thread.sleep(2000);
			AdvanceReporting.addLogs("Pass", "Instructions mentioned under " +str[0]+ " subheading are :");
			WebElement title = Utils.uBase.webDriver.findElement(By.xpath(a+str[0]+b));
			js.executeScript("arguments[0].scrollIntoView(true);", title);
			Utils.uBase.takeScreenshotOfWebelement(title, str[0]);
			for(int j = 0; j < strSize; j++) {
				imgcomp = Utils.uBase.imageCompare(str[j]);
				if(imgcomp != false) {if(j!=0) { 
					AdvanceReporting.addLogs("pass", str[j]);}}
			}
			AdvanceReporting.addLogs("pass", "verified that all the instructions are present");
			AdvanceReporting.addLogs("info", "All Image exists in the screen", "All Image exists in the screen");
			Actions action = new Actions(Utils.uBase.webDriver);
			action.sendKeys(Keys.ESCAPE).build().perform();
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Closing Keyboard Shortcuts popup */
	public KeyboardActionsPage closeKeyboardActions() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(closeBtn);
			AdvanceReporting.addLogs("info", "Keyboard Shortcuts");
			AdvanceReporting.addLogs("pass","Closing keyboard", "Closing Keyboard popup");
			AdvanceReporting.addLogs("info", "Closing Keyboard Shortcuts popup");
			Utils.uBase.clickByImage("btnKeyboardShortcutsClose");
			Thread.sleep(1000);
			AdvanceReporting.addLogs("pass","Closing keyboard", "Closing Keyboard");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	} 

	// sub headings in help page
	public KeyboardActionsPage verifySubHeadingsInHelpPage() {
		try {
			String[] str = Constants.options.split("\\|");
			Thread.sleep(2000);
			for(int i=0;i<6;i++) {
				WebElement element = Utils.uBase.webDriver.findElement(By.xpath(a+str[i]+b));
				((JavascriptExecutor) Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500); 
				if(Utils.uBase.isElementPresent_locator(By.xpath(a+str[i]+b))){
					AdvanceReporting.addLogs("info","Verified that "+str[i]+" subheading is available");
				}
				else {
					AdvanceReporting.addLogs("fail", str[i]+" subheading is not available");
				}
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// ShortcutsNavigation
	public KeyboardActionsPage verifyNavigationShortcuts() {
		try {
			String result;
			SoftAssert Assert=new SoftAssert();
			Actions keyAction = new Actions(Utils.uBase.webDriver);     
			keyAction.sendKeys("g").sendKeys("a").build().perform();
			result = Utils.uBase.getCurrentUrl();
			Assert.assertTrue(result.contains("archive"),"Incorrect Navigation");
			AdvanceReporting.addLogs("pass","g then a is navigated to archive page");

			keyAction.sendKeys("g").sendKeys("c").build().perform();
			result = Utils.uBase.getCurrentUrl();
			Assert.assertTrue(result.contains("calls"),"Incorrect Navigation");
			AdvanceReporting.addLogs("pass","g then c is navigated to calls page");

			keyAction.sendKeys("g").sendKeys("m").build().perform();
			result = Utils.uBase.getCurrentUrl();
			Assert.assertTrue(result.contains("messages"),"Incorrect Navigation");
			AdvanceReporting.addLogs("pass","g then m is navigated to messages page");

			keyAction.sendKeys("g").sendKeys("v").build().perform();
			result = Utils.uBase.getCurrentUrl();
			Assert.assertTrue(result.contains("voicemail"),"Incorrect Navigation");
			AdvanceReporting.addLogs("pass","g then v is navigated to voicemail page");		

			keyAction.sendKeys("g").sendKeys("s").build().perform();
			result = Utils.uBase.getCurrentUrl();
			Assert.assertTrue(result.contains("settings"),"Incorrect Navigation");
			AdvanceReporting.addLogs("pass","g then s is navigated to settings page");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
	// ShortcutsListActions
		public KeyboardActionsPage verifyListActionsShortcuts() {
			try {
				HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
				GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
				hmPage.clickMainMenu().clickTab(Constants.Calls);
				GAPage.clickFirstItemInList();
				Actions keyAction = new Actions(Utils.uBase.webDriver);
				for(int i=0;i<3;i++) {
					if(CalllistItem.get(i).getAttribute("class").contains("rkljfb-H9tDt rkljfb-gk6SMd")) {
						AdvanceReporting.addLogs("pass", "Verified that entering j moves to next item in the list");
					}
					else {
						AdvanceReporting.addLogs("fail", "Item is not highlighted");
					}	
					keyAction.sendKeys("j").build().perform();
					AdvanceReporting.addLogs("pass","highligthed item in the list is:"+i);
				}
				for(int i=3;i>=0;i--) {
					if(CalllistItem.get(i).getAttribute("class").contains("rkljfb-H9tDt rkljfb-gk6SMd")) {
						AdvanceReporting.addLogs("pass", "Verified that entering k moves to next item in the list");
					}
					else {
						AdvanceReporting.addLogs("fail", "Item is not highlighted");
					}	
					keyAction.sendKeys("k").build().perform();
					AdvanceReporting.addLogs("pass","highligthed item in the list is:"+i);
				}
				Thread.sleep(3000);
				Utils.uBase.clickWebelement(CalllistItem.get(0));
					keyAction.sendKeys("x").build().perform();
					Thread.sleep(5000);
					if(Utils.uBase.imageCompare("SelectedIconImg")==true) {
						AdvanceReporting.addLogs("pass", "Verified that entering x selectes the thread");	
						AdvanceReporting.addLogs("pass", "Verified that entering x selectes the thread","Verified that entering x selectes the thread");
					}
					else
						AdvanceReporting.addLogs("fail", "Item is not selected");
					Thread.sleep(2000);
					keyAction.sendKeys("x").build().perform();
					Thread.sleep(5000);
					if(Utils.uBase.imageCompare("SelectedIconImg")==true) {
						AdvanceReporting.addLogs("fail", "Item is not unselected");
					}
					else
						AdvanceReporting.addLogs("pass", "Verified that Re-entering x unselectes the thread");
					AdvanceReporting.addLogs("pass", "Verified that Re-entering x unselectes the thread","Verified that Re-entering x unselectes the thread");
					Utils.uBase.refresh();
					Thread.sleep(2000);
					keyAction.sendKeys("ENTER").build().perform();
					Thread.sleep(5000);
					if(Utils.uBase.imageCompare("callButtonOnRightSide")==true) {
						AdvanceReporting.addLogs("pass", "Verified that Enter key expands a log");
						AdvanceReporting.addLogs("pass", "Verified that Enter key expands a log","Verified that Enter key expands a log");
					}
					else
						AdvanceReporting.addLogs("fail", "Item is not expanded");
					
			}
			
			catch(Exception e) {
				AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
				e.printStackTrace(); Assert.fail();
			}
			return this;
		}

	// Help Shortcuts
	public KeyboardActionsPage verifyHelpShortcuts() {
		try {
			if(Utils.uBase.isElementPresent_webelement(keyboardShortcuts)==true) {
				AdvanceReporting.addLogs("pass","Open keyboard shortcuts help screen: ?");
			}
			else {
				AdvanceReporting.addLogs("fail", "Keyboard shortcuts is not opened");
			}
			//Assert.assertEquals(Utils.uBase.imageCompare("KeyboardShortKeyPopUp"),true);
			//AdvanceReporting.addLogs("pass","Open keyboard shortcuts help screen: ?");
			Actions action = new Actions(Utils.uBase.webDriver);
			action.sendKeys(Keys.ESCAPE).build().perform();
			Assert.assertEquals(Utils.uBase.imageCompare("KeyboardShortKeyPopUp"),false);
			AdvanceReporting.addLogs("pass","Close keyboard shortcuts help screen: Esc");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
	public KeyboardActionsPage verifyThreadActions() {
		try {
			Actions keyAction = new Actions(Utils.uBase.webDriver);
			HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
			GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
			//GAPage.reciveMultipleMissCalls(Constants.voipPhoneNo, 1);
			GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, Constants.voipPhoneNo, 2);

			hmPage.clickMainMenu().clickTab(Constants.Calls);
			Thread.sleep(1000);
			keyAction.sendKeys("e").build().perform();
			Thread.sleep(1000);
			Assert.assertTrue(Utils.uBase.imageCompare("callArchiveSnackbar"), "call not archived");
			AdvanceReporting.addLogs("pass", "Call archived by entering :e");
			Utils.uBase.clickByImage("UndoButton");
			keyAction.sendKeys("Keys.SHIFT").sendKeys("!").build().perform();
			Assert.assertTrue(Utils.uBase.imageCompare("callSpammedSnackbar"), "call not archived");
			AdvanceReporting.addLogs("pass", "Call Spammed by entering :!");
			Utils.uBase.clickByImage("UndoButton");
			Utils.uBase.refresh();
			keyAction.sendKeys("Keys.SHIFT").sendKeys("#").build().perform();
			if(Utils.uBase.imageCompare("DeletePermanentlyPopUp")) {
				AdvanceReporting.addLogs("pass", "Delete popup is displayed by entering:#");
			}else if(Utils.uBase.imageCompare("PermanentlyDeleteVoicemailPopUp")) {
				AdvanceReporting.addLogs("pass", "Delete popup is displayed by entering:#");
			}else if(Utils.uBase.imageCompare("PermanentlyDeleteCall")) {
				AdvanceReporting.addLogs("pass", "Delete popup is displayed by entering:#");
				Utils.uBase.clickByImage("DeleteBtnPopUp");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

}