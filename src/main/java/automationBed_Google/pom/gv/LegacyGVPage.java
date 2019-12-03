package automationBed_Google.pom.gv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class LegacyGVPage {

	@FindBy(xpath="(//*[contains(@class,'goog-tab')])[4]")
	WebElement callsTab;
	@FindBy(xpath="//*[contains(@class,'settings-button')]")
	WebElement legacySettngBtn;
	@FindBy(xpath="//*[contains(@class,'goog-menuitem-content') and contains(text(),'Settings')]")
	WebElement legacySettngOptn;
	@FindBy(xpath="//span[contains(@class,'phoneNumber')]")
	WebElement gvInLegacyPage;
	@FindBy(xpath="//span[contains(@class,'phoneNumber')]")
	WebElement phnNumLabelLegacyPge;
	@FindBy(xpath="//*[contains(text(),'Edit')]")
	WebElement editBtnLegacySttngs;
	@FindBy(xpath="//*[contains(@class,'button-base-content')][contains(text(),'Edit')]")
	WebElement phoneTypeLegacyPge;
	@FindBy(xpath="//*[contains(@id,'gc-edit-phonetype')]")
	WebElement phoneTypeMenuLegacyPge;
	@FindBy(xpath="//*[contains(@class,'save-button goog-button goog-button-base')]")
	WebElement phoneTypeSaveLegacy;
	@FindBy(xpath="//input[contains(@class,'sms-enable-checkbox')]")
	WebElement receiveTxtMsgCheckBox;
	@FindBy(xpath="//*[contains(@class,'voicemail-enable-checkbox')]")
	WebElement voicemailViaTxtCheckBox;
	@FindBy(xpath="//*[contains(text(),'Changes saved')]")
	WebElement legacyPgeChangesSaved;
	@FindBy(xpath="//*[contains(@class,'lQP0Od-wKtwcc')]")
	WebElement gvNumb;



	public static String gvNum2;

	public LegacyGVPage goToSettings() {
		try
		{	
			Thread.sleep(8000);	
			Utils.uBase.clickByImage("legacySettngBtn");
			AdvanceReporting.addLogs("pass", "Settings icon is clicked");
			AdvanceReporting.addLogs("pass", "Settings icon is clicked","Settings icon is clicked");
			Thread.sleep(1000);	
			Utils.uBase.clickByImage("legacySettngOptn");
			AdvanceReporting.addLogs("pass", "Settings option from drop down is clicked");
			AdvanceReporting.addLogs("pass", "Settings option is clicked","Settings option is clicked");
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	public LegacyGVPage clickCalls() throws Exception
	{
		try
		{
			Thread.sleep(3000);	
			Utils.uBase.clickByImage("callsTab");
			Thread.sleep(3000);	
			AdvanceReporting.addLogs("pass", "Calls tab is clicked successfully");
			AdvanceReporting.addLogs("pass", "Calls tab is clicked successfully","Calls tab is clicked successfully");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Calls tab is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public LegacyGVPage verifySpamFiltersEnabled() {
		try
		{	
			Thread.sleep(4000);	
			Assert.assertTrue(Utils.uBase.imageCompare("legacySpamCheckBox"),"Global spam filtering is not enabled");
			{
				AdvanceReporting.addLogs("pass","Global spam filtering is enabled");
				AdvanceReporting.addLogs("pass","Global spam filtering is enabled", "Global spam filtering is enabled");
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//to get gv number from legacy page
	public LegacyGVPage getGvNum() {
		try {
			gvNum2=gvInLegacyPage.getText().replaceAll("\\W", "");
			AdvanceReporting.addLogs("pass", "gv number in legacy page"+gvNum2);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "can not find elements");
		}
		return this;
	}

	//to verify gv number in setting page and legacy page
	public LegacyGVPage compareGvNum() {
		try {
			if(SettingsPage.gvNum1.equals(gvNum2)) {
				Thread.sleep(1000);
				AdvanceReporting.addLogs("pass","gv numbers matched");
			}else {
				AdvanceReporting.addLogs("fail","gv numbers not matched");	
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail","gv numbers does not match");
		}
		return this;
	}

	//to click on the Phone label present on the left side of legacy home page
	public LegacyGVPage clickPhoneLabel() {
		try {
			Utils.uBase.waitForElement(phnNumLabelLegacyPge);
			Utils.uBase.clickWebelement(phnNumLabelLegacyPge);
			AdvanceReporting.addLogs("pass","Cliked on Phone number label");
			AdvanceReporting.addLogs("pass","Cliked on Phone number label","Cliked on Phone number label");		
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail","Phone label not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	//to click on the edit button to change phone type
	public LegacyGVPage clickEditPhoneType() {
		try {
			Utils.uBase.waitForElement(editBtnLegacySttngs);
			Utils.uBase.clickWebelement(editBtnLegacySttngs);
			AdvanceReporting.addLogs("pass","Clicked on edit button to change phone type");
			AdvanceReporting.addLogs("pass","Clicked on edit button","Clicked on edit button");	
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail","Edit button is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//to select "Mobile" as the phone type in Edit phone number settings on legacypage
	public LegacyGVPage selectMobilePhoneType() {
		try {
			Thread.sleep(1000);
			if(phoneTypeMenuLegacyPge.isEnabled())
			{
				Utils.uBase.waitForElement(phoneTypeMenuLegacyPge);
				Utils.uBase.selectElementByName(phoneTypeMenuLegacyPge, "Mobile");
				AdvanceReporting.addLogs("pass","Selected Mobile as the phone type");
				AdvanceReporting.addLogs("pass","Selected Mobile","Selected Mobile");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail","Mobile not selected as Phone type");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//to select "Mobile" as the phone type in Edit phone number settings on legacypage
	public LegacyGVPage savePhoneTypeSttng() {
		try {
			Utils.uBase.waitForElement(phoneTypeSaveLegacy);
			Utils.uBase.clickWebelement(phoneTypeSaveLegacy);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail","Mobile not selected as Phone type");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	//to enable checkbox for receiving text messages on the phone
	public LegacyGVPage ReceiveTxtMsgCheckBox() {
		try {
			Utils.uBase.waitForElement(receiveTxtMsgCheckBox);
			Utils.uBase.checkbox_Checking(receiveTxtMsgCheckBox);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail","Mobile not selected as Phone type");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//to enable checkbox for receiving notifications of new voicemails via text
	public LegacyGVPage voicemailViaTxtCheckBox() {
		try {
			Utils.uBase.waitForElement(voicemailViaTxtCheckBox);
			Utils.uBase.checkbox_Checking(voicemailViaTxtCheckBox);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail","Mobile not selected as Phone type");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//to confirm that the changes have been saved
	public LegacyGVPage confrmChangesSaved() {
		try {
			Utils.uBase.waitForElement(legacyPgeChangesSaved);
			AdvanceReporting.addLogs("pass","The changes have been saved");
			Thread.sleep(3000);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail","The changes have not been saved");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
}
