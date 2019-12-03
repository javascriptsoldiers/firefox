package automationBed_Google.pom.gv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class SettingsPage {
	// Locators
	@FindBy(xpath = "//*[contains(@class,'lQP0Od-wKtwcc')]")
	WebElement gvNumb;
	@FindBy(xpath = "//*[contains(@aria-label,'Change Google Voice number')]")
	WebElement gvChangeBtn;
	@FindBy(xpath = "//*[contains(@aria-label,'Transfer Google Voice number')]")
	WebElement gvTransferBtn;
	@FindBy(xpath = "//*[contains(@aria-label,'Delete Google Voice number')]")
	WebElement gvDeleteBtn;
	@FindBy(xpath = "//*[contains(@ng-click,'BillingHistoryClick')]")
	WebElement gvBillingHistoryBtn;
	@FindBy(xpath = "//*[contains(@aria-label,'Send voicemail transcript to email')]")
	WebElement vEmailtoggleBtn;
	@FindBy(xpath = "//*[contains(@aria-label,'Go to accessibility settings page')]")
	WebElement gvAccessibilitylink;
	@FindBy(xpath = "(//*[contains(@class,'VfPpkd-yNh9Ed')])[last()]")
	WebElement gvHighcontrastcolorstoggleBtn;
	@FindBy(xpath = "//*[contains(@class,'md-cancel')]")
	WebElement gvverifyMarkAllasReadCancelBtn;
	@FindBy(xpath = "//*[contains(@class,'md-confirm-button')]")
	WebElement gvverifyMarkAllasReadBtn;
	@FindBy(xpath = "//*[contains(@aria-label,'Voicemail')]//*[contains(@aria-label,'Unread count')]")
	WebElement voicemailUnreadCount;
	// @FindBy(xpath="//*[contains(@aria-label, 'Do not disturb')]/div/div")
	@FindBy(xpath = "(//*[contains(@class,'mat-slide-toggle-label')])[1]")
	WebElement doNotDisturbToggle;
	@FindBy(xpath = "//*[contains(@aria-label, 'Do not disturb')]/div")
	WebElement turnOff;
	@FindBy(xpath = "//*[contains(@aria-label,'Improve voicemail transcription quality')]")
	WebElement voicemailToggle;
	@FindBy(xpath = "//input[@class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored']")
	WebElement clearTextBox;
	@FindBy(xpath = "//*[contains(@class,'mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored')]")
	WebElement deviceNameTextBox;
	@FindBy(xpath = "//div[contains(text(),'Privacy & Terms')]")
	WebElement privacyTerms;
	@FindBy(xpath = "//h3[contains(text(),'Message')]")
	WebElement btnNewLinkedNo;
	@FindBy(xpath = "//input[@aria-label='Enter a phone number']")
	WebElement inputLinkedNoDialogBox;
	@FindBy(xpath = "//input[contains(@aria-label,'First verification code number')]")
	WebElement inputVerificationBox;
	@FindBy(xpath = "//*[contains(@ng-if,'!!ctrl.obs_deviceDetails')]|//*[contains(@aria-label,'Remove ‪')]/ancestor::div[2]/div[1]/div/div[1]")
	List<WebElement> lstLinkedNumbers;
	@FindBy(xpath = "//*[contains(@gv-test-id,'remove_linked_device')]")
	List<WebElement> lstCloseButtonsLinkednos;
	@FindBy(xpath = "//*[contains(@gv-test-id,'edit-linked-phone-name-button')]")
	List<WebElement> lstEditButtonsLinkedNos;
	@FindBy(xpath = "//span[contains(text(),'Verify')]//..//..//..")
	WebElement verify;
	@FindBy(xpath = "//div[contains(text(),'Call forwarding')]//../div[6]//md-switch")
	WebElement callsFwdToggle;
	@FindBy(xpath = "(//div[contains(text(),'Forward messages')]//..//..//..//..//..//md-switch)[1]")
	WebElement msgsFwdToggle;
	@FindBy(xpath = "//md-switch[contains(@aria-label,'Forward messages to email')]")
	WebElement msgsEmailToggle;
	@FindBy(xpath = "//*[contains(@ng-if, 'ctrl.isDisplayAddress')]")
	WebElement addressField;
	@FindBy(xpath = "//*[contains(@aria-label,'Add new linked number')]/*[contains(@class,'mat-button-focus-overlay')]")
	WebElement newLinkedNumberBtn;
	@FindBy(xpath = "//*[contains(@class,'gmat-headline-6 iZWCF-MnozTc grey-900')]")
	WebElement msgHeadlineSttng;
	@FindBy(xpath = "//*[@id=\"gvPageRoot\"]/div[2]/div[2]/div[1]/gv-settings-view/div/md-content[2]/div/div[1]/gv-account-number/div/div/gv-settings-section-block[3]/div/div[2]/ng-transclude/gv-settings-section-block-content/gv-linked-device/div/div[2]/gv-icon-button-ng2/button\r\n")
	WebElement rmvLnkdNumCross;
	@FindBy(xpath = "//*[contains(@class,'md-dialog-content rEZ2Jf-haAclf')]")
	WebElement rmvLnkdNumPopUp;
	@FindBy(xpath = "//button[contains(@class,'mat-button mat-primary')]")
	WebElement rmvLnkdNumCancelBtn;
	@FindBy(xpath = "//button[contains(@class,'mat-flat-button mat-primary')]")
	WebElement rmvLnkdNumRemoveBtn;
	@FindBy(xpath = "//*[contains(@class,'gmat-subhead-1 grey-900 rEZ2Jf-AiAbsc')]")
	WebElement rmvLnkdNumConfMsg;
	@FindBy(xpath = "//*[@class='gmat-headline-6 iNtirf-MnozTc grey-900']")
	WebElement doNotDisturbText;
	@FindBy(xpath = "//*[@id=\"gvPageRoot\"]/div[2]/div[2]/div[1]/gv-settings-view/div/md-content[1]/gmat-nav-list/gv-nav-list-item[9]/a/div")
	WebElement settngSecurityTab;
	@FindBy(xpath = "//gv-settings-section[@sectiontitle='Security']/div/div/div/div/gv-settings-block-header/div/mat-slide-toggle")
	WebElement spamFilterToggle;
	@FindBy(xpath = "//*[contains(@href,'policies.google.com/privacy')]")
	WebElement privPolic;
	@FindBy(xpath = "//*[contains(@class,'gb_Xb gb_2b')]")
	WebElement sttngClose;
	@FindBy(xpath = "//div[contains(text(),'Get voicemail via message')]//..//..//..//..//..//md-switch")
	WebElement voicemailFwdViaSMSToggle;

	@FindBy(xpath = "//div[contains(text(),'Get voicemail via email')]//..//..//..//..//..//md-switch")
	WebElement voicemailFwdViaEmailToggle;
	@FindBy(xpath = "//div[contains(text(),'Get email alerts')]//..//..//..//../md-switch")
	WebElement callsEmailAlertToggle;
	// @FindBy(xpath="(//div[contains(text(),'Do not
	// disturb')])[2]//..//..//..//../md-switch")
	@FindBy(xpath = "(//*[contains(@class,'mat-slide-toggle-label')])[1]")
	WebElement doNotDisturbToggleOnOff;
	@FindBy(xpath = "//IMG[@src='https://www.gstatic.com/images/branding/product/2x/calendar_48dp.png']")
	WebElement calenderIcon;
	@FindBy(xpath = "//*[@focused='ctrl.shouldContactBeFocused(contact, false)']")
	List<WebElement> savedContacts;
	@FindBy(xpath = "//*[@focused='ctrl.shouldContactBeFocused(contact, false, true)']")
	List<WebElement> unsavedContacts;
	@FindBy(xpath = "//div[contains(text(),'Directory')]")
	WebElement directorySection;
	@FindBy(xpath = "//*[contains(@id,'dialogContent')]/div[2]/gv-voicemail-greeting/div/div[1]/div/div/div[2]/span[1]")
	WebElement activeUserGreetingDuriation;
	@FindBy(xpath = "(//div[@class='sMgtJb-rtUoue'])[last()]//div[@gv-test-id='greeting-name']")
	List<WebElement> greetingNameInOtherSection;
	@FindBy(xpath = "(//div[@class='sMgtJb-rtUoue'])[last()]//div[@gv-test-id='greeting-time']")
	List<WebElement> greetingDuriationInOtherSection;
	@FindBy(xpath = "(//div[@class='sMgtJb-rtUoue'])[last()]//span[@aria-label='Play']")
	List<WebElement> playBtnInOtherSection;
	@FindBy(xpath = "//*[contains(@aria-label,'All Voicemail Greetings')]")
	WebElement manageGreetingPopUp;
	@FindBy(xpath = "(//*[contains(@id,'dialogContent')]/div[3]/gv-voicemail-greeting[1]/div/div/div)[last()]")
	WebElement threeDotOptionVoiceDefault;
	@FindBy(xpath = "(//*[contains(@id,'dialogContent')]/div[3]/gv-voicemail-greeting[2]/div/div/div)[last()]")
	WebElement threeDotSecondGreeting;
	@FindBy(xpath = "(//*[contains(@id,'dialogContent')]/div[3]/gv-voicemail-greeting[3]/div/div/div)[last()]")
	WebElement threeDotThirdGreeting;
	@FindBy(xpath = "(//*[contains(@id,'dialogContent')]/div[3]/gv-voicemail-greeting[4]/div/div/div)[last()]")
	WebElement threeDotFourthGreeting;
	@FindBy(xpath = "//*[contains(@id,'dialogContent')]/div[2]//div/div[1]/div/div/div[1]")
	WebElement activeUserName;
	@FindBy(xpath = "//div[contains(text(),'Get voicemail via email')]//..//..//..//..//..//md-switch")
	WebElement callsEmailFwdToggle;
	@FindBy(xpath = "//*[contains(text(),'Finish')]")
	WebElement finishTab;
	@FindBy(xpath = "//div[contains(text(),'Screen')]/..//..//..//md-switch")
	WebElement screenCallsToggle;
	@FindBy(xpath = "//mat-slide-toggle[contains(@aria-label,'outside of working hours')]")
	WebElement fllwWorkingHrsToggle;
	@FindBy(xpath = "//mat-slide-toggle[contains(@aria-label,'when out of office')]")
	WebElement followOutOfOffice;
	@FindBy(xpath = "//*[@aria-label='Go to do not disturb settings']")
	WebElement dndSettings;
	@FindBy(xpath = "//*[contains(@gv-test-id,'dnd-text')]")
	WebElement dndBannerText;
	@FindBy(xpath = "(//*[contains(@gv-test-id,'linked-device-name')])[last()]")
	WebElement deviceName;
	@FindBy(xpath = "//gv-linked-device//*[contains(@label,'(425) 835-6586‬')]")
	WebElement samsungGalaxyNum_2;
	@FindBy(xpath = "//gv-linked-device//*[contains(@label,'(425) 591-2989')]")
	WebElement samsungGalaxyNum_1;
	@FindBy(xpath = "(//*[contains(@class,'fullRow')])[1]")
	WebElement toogleDoNotDisturb;
	@FindBy(xpath = "(//*[contains(@class,'fullRow')])[3]")
	WebElement toogleDoNotDisturbOutsideOfWorkingHours;
	@FindBy(xpath = "(//*[contains(@class,'fullRow')])[4]")
	WebElement toogleDoNotDisturbWhenOutOfOffice;
	@FindBy(xpath = "//h3[contains(text(),'Message')]")
	WebElement msgHeading;
	@FindBy(xpath = "//*[contains(@header,'Linked numbers')]/div")
	WebElement linkedNumSec;
	@FindBy(xpath = "(//*[contains(@class,'textBlock')])[1]")
	WebElement verifyDoNotDisturb;
	@FindBy(xpath = "//div[contains(text(),'Linked numbers')]/following-sibling::div/ng-transclude")
	WebElement linkedNumbers;
	@FindBy(xpath="//*[contains(@aria-label,'Remove ‪')]/span")
	List<WebElement> linkedNumRemove;
	@FindBy(xpath="//h3[contains(text(),' Web notifications ')]")
	WebElement verifyWebNotification;
	@FindBy(xpath="//*[contains(@ng-controller,'DialogCtrl as dialogCtrl')]")
	WebElement termsOfService;
	@FindBy(xpath="//*[contains(@aria-label,'Click to stop recording')]")
	WebElement stopRcd;
	@FindBy(xpath="//*[contains(@gv-test-id,'record-a-greeting-button')]")
	WebElement recordGreeting;
	@FindBy(xpath="//*[contains(text(),'You can only save 10 greetings')]")
	WebElement maxGreetingAlert;

	public static String gvNum1;

	/*
	 * public SettingsPage getGvNum() throws Exception { try {
	 * Utils.uBase.waitForElement(gvNumb); AdvanceReporting.addLogs("pass",
	 * "Settings Page","Settings Page"); String gvNumber = gvNumb.getText(); String
	 * expGVNum = DmConfig.getString("GV.Number"); assertEquals(gvNumber, expGVNum);
	 * AdvanceReporting.addLogs("pass", "Google Voice Number is : "+gvNumber); }
	 * catch (Exception e) { AdvanceReporting.addLogs("fail",
	 * "Error Message: "+e.getMessage()); e.printStackTrace(); Assert.fail(); }
	 * return this; }
	 */

	// verifying change button is present with in the settings page
	public SettingsPage verifyChangeBtn() throws Exception {
		try {
			boolean changeIcon = Utils.uBase.imageCompare("gvChangeBtn");
			if (changeIcon == true) {
				AdvanceReporting.addLogs("pass", "Google Voice Change Number Button is Available");
				AdvanceReporting.addElementImage("pass", gvChangeBtn);
			} else if (changeIcon == false) {
				AdvanceReporting.addLogs("fail", "Google Voice Change Number Button is not Available");
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// verifying transfer button is present with in the settings page
	public SettingsPage verifyTransfer() throws Exception {
		try {
			// Utils.uBase.waitForElementToBeClickable(gvTransferBtn);

			boolean verifyIcon = Utils.uBase.imageCompare("gvTransferBtn");
			if (verifyIcon == true) {
				AdvanceReporting.addLogs("pass", "Google Voice Transfer Number Button is Available");
				AdvanceReporting.addElementImage("pass", gvTransferBtn);
			} else if (verifyIcon == false) {
				AdvanceReporting.addLogs("fail", "Google Voice Transfer Number Button is not Available");
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// verifying delete button is present with in the settings page
	public SettingsPage verifyDelete() throws Exception {
		try {
			// Utils.uBase.waitForElementToBeClickable(gvDeleteBtn);
			// Utils.uBase.takeScreenshotOfWebelement(gvDeleteBtn, "gvDeleteBtn");
			boolean deleteIcon = Utils.uBase.imageCompare("gvDeleteBtn");
			if (deleteIcon == true) {
				AdvanceReporting.addLogs("pass", "Google Voice Delete Number Button is Available");
				AdvanceReporting.addElementImage("pass", gvDeleteBtn);
			} else if (deleteIcon == false) {
				AdvanceReporting.addLogs("fail", "Google Voice Delete Number Button is not Available");
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// verifying after clicking on delete button it redirects to number porting page
	public SettingsPage deleteRedirection() throws Exception {
		try {
			Utils.uBase.switchToOldWindow();
			Utils.uBase.waitForElementToBeClickable(gvDeleteBtn);
			Utils.uBase.clickWebelement(gvDeleteBtn);
			AdvanceReporting.addLogs("pass", "Clicked on Delete Button");
			Utils.uBase.switchToNewWindow();

			Utils.uBase.getCurrentUrl();
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickBillingHistoryBtn() throws Exception {
		try {
			Utils.uBase.scrolltoElement(gvBillingHistoryBtn);
			AdvanceReporting.addElementImage("info", gvBillingHistoryBtn);
			Utils.uBase.clickWebelement(gvBillingHistoryBtn);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/*
	 * public SettingsPage clickVoicemailTranscriptAnalysisBtn() throws Exception {
	 * try { Utils.uBase.scrolltoElement(vtranscriptiontoggleBtn);
	 * if(Utils.uBase.isElementEnabled(vtranscriptiontoggleBtn)) {
	 * AdvanceReporting.addLogs("info",
	 * "'Improve voicemail transcription quality' toggle Button already Enabled so disabling now."
	 * ); Utils.uBase.clickWebelement(vtranscriptiontoggleBtn); } else {
	 * AdvanceReporting.addLogs("info",
	 * "'Improve voicemail transcription quality' toggle Button already disabled so Enabling now."
	 * ); Utils.uBase.clickWebelement(vtranscriptiontoggleBtn); } } catch (Exception
	 * e) { AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
	 * e.printStackTrace(); Assert.fail(); } return this; }
	 */
	public SettingsPage checkVoicemailviaEmailBtn() throws Exception {
		try {
			Utils.uBase.scrolltoElement(vEmailtoggleBtn);
			if (Utils.uBase.isElementEnabled(vEmailtoggleBtn)) {
				AdvanceReporting.addLogs("info", "voicemail via email toggle Button Enabled");
				AdvanceReporting.addLogs("info", "voicemail via email toggle Button Enabled",
						"voicemail via email toggle Button Enabled");
				// AdvanceReporting.addElementImage("info", vEmailtoggleBtn);
			} else {
				Utils.uBase.clickWebelement(vEmailtoggleBtn);
				AdvanceReporting.addLogs("info", "voicemail via email toggle Button Enabled");
				AdvanceReporting.addLogs("info", "voicemail via email toggle Button Enabled",
						"voicemail via email toggle Button Enabled");
				// AdvanceReporting.addElementImage("info", vtranscriptiontoggleBtn);
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage verifyAccessibilitylink() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvAccessibilitylink);
			AdvanceReporting.addLogs("pass", "Accessibility link Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickAccessibilitylink() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvAccessibilitylink);
			Utils.uBase.clickWebelement(gvAccessibilitylink);

			// Utils.uBase.switchToNewWindow();

			// ArrayList<String> tabs = new ArrayList<String>
			// (Utils.uBase.driver.getWindowHandles());
			Utils.uBase.switchToNewWindow();

			Utils.uBase.waitForElementToBeClickable(gvHighcontrastcolorstoggleBtn);
			Utils.uBase.clickWebelement(gvHighcontrastcolorstoggleBtn);

			Utils.uBase.switchToOldWindow();

			/*
			 * if(Utils.uBase.isElementEnabled(gvHighcontrastcolorstoggleBtn)) {
			 * AdvanceReporting.addLogs("info",
			 * "'High-contrast colors' toggle Button Enabled so disabling now");
			 * AdvanceReporting.addElementImage("info", gvHighcontrastcolorstoggleBtn);
			 * Utils.uBase.clickWebelement(gvHighcontrastcolorstoggleBtn);
			 * AdvanceReporting.addLogs("info",
			 * "'High-contrast colors' toggle Button is now disenabled");
			 * AdvanceReporting.addElementImage("info", gvHighcontrastcolorstoggleBtn); }
			 * else { AdvanceReporting.addElementImage("info",
			 * gvHighcontrastcolorstoggleBtn); AdvanceReporting.addLogs("info",
			 * "'High-contrast colors' toggle Button disabled so enabling now");
			 * Utils.uBase.clickWebelement(gvHighcontrastcolorstoggleBtn);
			 * AdvanceReporting.addElementImage("info", gvHighcontrastcolorstoggleBtn);
			 * AdvanceReporting.addLogs("info",
			 * "'High-contrast colors' toggle Button is now enabled"); }
			 */

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage verifyMarkAllasReadBtn() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvverifyMarkAllasReadBtn);
			AdvanceReporting.addLogs("pass", "'Mark all as read' pop up - MARK AS READ Button is Available");
			// AdvanceReporting.addElementImage("pass", gvverifyMarkAllasReadBtn);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage verifyMarkAllasReadCancelBtn() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvverifyMarkAllasReadCancelBtn);
			AdvanceReporting.addLogs("pass", "'Mark all as read' pop up - CANCEL Button is Available");
			// AdvanceReporting.addElementImage("pass", gvverifyMarkAllasReadCancelBtn);
			Thread.sleep(100);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickMarkAllasReadCancelBtn() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvverifyMarkAllasReadCancelBtn);
			Utils.uBase.clickWebelement(gvverifyMarkAllasReadCancelBtn);
			AdvanceReporting.addLogs("pass", "'Mark all as read' pop up - CANCEL Button is clicked");
			Thread.sleep(500);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public int getUnreadCount(String key) throws Exception {
		int Unreadcount = 0;
		String Xpath = null;
		switch (key) {
		case "Calls":
			Xpath = "//*[contains(@aria-label,'Calls')]//*[contains(@aria-label,'Unread count')]";
			break;
		case "Messages":
			Xpath = "//*[contains(@aria-label,'Messages')]//*[contains(@aria-label,'Unread count')]";
			break;
		case "Voicemail":
			Xpath = "//*[contains(@aria-label,'Voicemail')]//*[contains(@aria-label,'Unread count')]";
			break;
		case "Archive":
			Xpath = "//*[contains(@aria-label,'Archive')]//*[contains(@aria-label,'Unread count')]";
			break;
		case "Spam":
			Xpath = "//*[contains(@aria-label,'Spam')]//*[contains(@aria-label,'Unread count')]";
			break;
		}
		try {
			try {
				Utils.uBase.turnOffImplicitWaits();
				Unreadcount = Integer.parseInt(Utils.uBase.webDriver.findElement(By.xpath(Xpath)).getText());
				AdvanceReporting.addLogs("pass", key + " Unread Count: " + Unreadcount);
			} catch (Exception e) {
				AdvanceReporting.addLogs("pass", key + " Unread Count: " + Unreadcount);
				Utils.uBase.addImplicitWait(20);
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return Unreadcount;
	}

	public SettingsPage clickMarkAllasReadCancelBtnwithvalidation() throws Exception {
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		hmPage.clickMainMenu();
		Thread.sleep(1000);
		int messagesCountPre, CallsCountPre, VoicemailCountPre, ArchiveCountPre, SpamCountPre;
		int messagesCountPost, CallsCountPost, VoicemailCountPost, ArchiveCountPost, SpamCountPost;
		try {
			// Getting Unread Count before clicking CANCEL buttom
			messagesCountPre = getUnreadCount("Messages");
			CallsCountPre = getUnreadCount("Calls");
			VoicemailCountPre = getUnreadCount("Voicemail");
			ArchiveCountPre = getUnreadCount("Archive");
			SpamCountPre = getUnreadCount("Spam");

			hmPage.clickMarkallasread();
			Utils.uBase.waitForElementToBeClickable(gvverifyMarkAllasReadCancelBtn);
			Utils.uBase.clickWebelement(gvverifyMarkAllasReadCancelBtn);
			AdvanceReporting.addLogs("pass", "'Mark all as read' pop up - CANCEL Button is clicked");
			Thread.sleep(1000);
			hmPage.clickMainMenu();
			Thread.sleep(1000);

			// Getting Unread Count after clicking CANCEL buttom
			messagesCountPost = getUnreadCount("Messages");
			CallsCountPost = getUnreadCount("Calls");
			VoicemailCountPost = getUnreadCount("Voicemail");
			ArchiveCountPost = getUnreadCount("Archive");
			SpamCountPost = getUnreadCount("Spam");

			// Logging
			AdvanceReporting.addLogs("info", "Following are the Unread count Before Clicking CANCEL button");
			AdvanceReporting.addLogs("info",
					"Message Unread count:" + messagesCountPre + "; Voicemail Unread count:" + VoicemailCountPre
							+ "; Calls Unread count:" + CallsCountPre + "; Spam Unread count:" + SpamCountPre
							+ "; Archive Unread count:" + ArchiveCountPre);
			AdvanceReporting.addLogs("info", "Following are the Unread count after Clicking CANCEL button");
			AdvanceReporting.addLogs("info",
					"Message Unread count:" + messagesCountPost + "; Voicemail Unread count:" + VoicemailCountPost
							+ "; Calls Unread count:" + CallsCountPost + "; Spam Unread count:" + SpamCountPost
							+ "; Archive Unread count:" + ArchiveCountPost);
			if (messagesCountPre == messagesCountPost && VoicemailCountPre == VoicemailCountPost
					&& CallsCountPre == CallsCountPost && SpamCountPre == SpamCountPost
					&& ArchiveCountPre == ArchiveCountPost) {
				AdvanceReporting.addLogs("pass", "No change in Unread Count after clicking CANCEL button");
			} else {
				AdvanceReporting.addLogs("fail", "Change in Unread Count after clicking CANCEL button");
				Assert.fail("Change in Unread Count after clicking CANCEL button");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickMarkAllasReadBtnwithvalidation() throws Exception {
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		// hmPage.clickMainMenu();
		int messagesCountPre, CallsCountPre, VoicemailCountPre, ArchiveCountPre, SpamCountPre;
		int messagesCountPost, CallsCountPost, VoicemailCountPost, ArchiveCountPost, SpamCountPost;
		try {
			// Getting Unread Count before clicking CANCEL buttom
			messagesCountPre = getUnreadCount("Messages");
			CallsCountPre = getUnreadCount("Calls");
			VoicemailCountPre = getUnreadCount("Voicemail");
			ArchiveCountPre = getUnreadCount("Archive");
			SpamCountPre = getUnreadCount("Spam");

			hmPage.clickMarkallasread();
			Utils.uBase.waitForElementToBeClickable(gvverifyMarkAllasReadBtn);
			Utils.uBase.clickWebelement(gvverifyMarkAllasReadBtn);
			AdvanceReporting.addLogs("pass", "'Mark all as read' pop up - MARKASREAD Button is clicked");
			Thread.sleep(1000);
			hmPage.clickMainMenu();
			Thread.sleep(500);

			// Getting Unread Count after clicking CANCEL buttom
			messagesCountPost = getUnreadCount("Messages");
			CallsCountPost = getUnreadCount("Calls");
			VoicemailCountPost = getUnreadCount("Voicemail");
			ArchiveCountPost = getUnreadCount("Archive");
			SpamCountPost = getUnreadCount("Spam");

			// Logging
			AdvanceReporting.addLogs("info", "Following are the Unread count Before Clicking MARKASREAD button");
			AdvanceReporting.addLogs("info",
					"Message Unread count:" + messagesCountPre + "; Voicemail Unread count:" + VoicemailCountPre
							+ "; Calls Unread count:" + CallsCountPre + "; Spam Unread count:" + SpamCountPre
							+ "; Archive Unread count:" + ArchiveCountPre);
			AdvanceReporting.addLogs("info", "Following are the Unread count after Clicking MARKASREAD button");
			AdvanceReporting.addLogs("info",
					"Message Unread count:" + messagesCountPost + "; Voicemail Unread count:" + VoicemailCountPost
							+ "; Calls Unread count:" + CallsCountPost + "; Spam Unread count:" + SpamCountPost
							+ "; Archive Unread count:" + ArchiveCountPost);
			// if(messagesCountPre == messagesCountPost && VoicemailCountPre ==
			// VoicemailCountPost && CallsCountPre == CallsCountPost && SpamCountPre ==
			// SpamCountPost && ArchiveCountPre == ArchiveCountPost ) {
			if (messagesCountPost == 0 && VoicemailCountPost == 0 && CallsCountPost == 0 && SpamCountPost == 0
					&& ArchiveCountPost == 0) {
				AdvanceReporting.addLogs("pass", "All Unread Count resest to '0' after clicking MARKASREAD button");
			} else {
				AdvanceReporting.addLogs("fail", "Unreadcount didn't resest to '0' after clicking MARKASREAD button");
				Assert.fail("Unread Count didn't resest to '0' after clicking MARKASREAD button");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;

	}

	// to verify gv number with the expected gv number
	public SettingsPage verifygvNum(String data) {
		try {

			String num1 = gvNumb.getText();
			if (num1.contentEquals(data)) {
				AdvanceReporting.addLogs("pass", "correct gv number");
			} else {
				AdvanceReporting.addLogs("fail", "gv number is incorrect" + gvNumb.getText());
			}
		} catch (Exception e) {

			AdvanceReporting.addLogs("info", "GV number verification failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;
	}

	/* Verify Click on Terms */
	public SettingsPage verifyClickOnTerms() {
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("TermsOfService");
			AdvanceReporting.addLogs("pass", "Terms is clicked");
			AdvanceReporting.addLogs("pass", "Terms is clicked", "Terms");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Terms is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/* Verify Redirected to Terms page */
	public SettingsPage verifyRedirectedToTerms() {
		try {
			/*
			 * // Utils.uBase.switchToNewWindow();
			 * Utils.uBase.switchWindowByTitle("Google Voice"); Thread.sleep(8000);
			 * Utils.uBase.checkPageReady();
			 */
			Thread.sleep(9000);
			Assert.assertTrue(Utils.uBase.imageCompare("TermsPage"), "Term Page is not displayed");
				AdvanceReporting.addLogs("pass", "Verified that terms page is displayed");
				AdvanceReporting.addLogs("pass", "Rediredted to Terms page", "TermsPage");
			
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Term Page is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/* Verify click on Do not disturb */
	public SettingsPage clickDoNotDisturb() {
		try {
			Thread.sleep(5000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("Donotdisturb");
			AdvanceReporting.addLogs("pass", "Clicked on Do not disturb");
			// AdvanceReporting.addLogs("pass", "Clicked on Do not disturb","Donotdisturb");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Do not disturb is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/* Verify enable Do not disturb */
	public SettingsPage enableDoNotDisturb() {
		try {
			((JavascriptExecutor) Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);",
					doNotDisturbToggle);
			Thread.sleep(3000);
			if (doNotDisturbToggle.getAttribute("class").contains("checked")) {
				AdvanceReporting.addLogs("info", "Already do not disturb is enabled");
			} else {
				Utils.uBase.clickWebelement(doNotDisturbToggle);
				AdvanceReporting.addLogs("info", "Enabled do not disturb toggle");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Do not disturb is not clicked" + e.getMessage());
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/*
	 * 'Do not disturb is turn on' banner should be visible on all the tabs (Calls,
	 * Messages, Voice mails, Archive, Spam)
	 */

	public SettingsPage verifyDoNotDisturbIsOnBanner() {
		try {
			Thread.sleep(15000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("DoNotDisturbBanner"), "Do not disturb banner is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that do not disturb banner is displayed");
			AdvanceReporting.addLogs("pass", "Do not disturb banner", "DoNotDisturbBanner");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Do not disturb banner is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// to verify gv number with the expected gv number
	public SettingsPage verifygvNumDisplayed(String data) {
		try {
			// String gvNum = gvNumb.getText().replaceAll("\\W", "");
			Assert.assertTrue(gvNumb.getText().replaceAll("\\W", "").equals(data), "Incorrect gv number");
			AdvanceReporting.addLogs("pass", "correct gv number");
			AdvanceReporting.addLogs("pass", "correct gv number", "CorrectGvNumber");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;
	}

	// Verifying change button is present with in the settings page
	public SettingsPage verifyChangeBtnDisplayed() throws Exception {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("gvChangeBtn"),
					"Google Voice Change Number Button is not Available");
			AdvanceReporting.addLogs("pass", "Google Voice ChangeNumber Button is Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// verifying transfer button is present with in the settings page
	public SettingsPage verifyTransferDisplayed() throws Exception {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("gvTransferBtn"),
					"Google Voice Transfer Number Button is not Available");
			AdvanceReporting.addLogs("pass", "Google Voice Transfer Number Button is Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// verifying delete button is present with in the settings page
	public SettingsPage verifyDeleteBtnDisplayed() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("gvDeleteBtn"),
					"Google Voice Delete Number Button is not Available");
			AdvanceReporting.addLogs("pass", "Google Voice Delete Number Button is Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// verifying after clicking on change button it redirects to number porting page
	public SettingsPage changeRedirection() throws Exception {
		try {
			Utils.uBase.clickByImage("gvChangeBtn");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Clicked on Change Button");
			Utils.uBase.switchToNewWindow();
			Assert.assertTrue(Utils.uBase.getCurrentUrl().contains("phones"), "Porting page is not displayed");
			AdvanceReporting.addLogs("pass", "Clicked on Change Button", "porting page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// verifying after clicking on transfer button it redirects to number porting
	// page
	public SettingsPage transferRedirection() throws Exception {
		try {
			Utils.uBase.clickByImage("gvTransferBtn");
			AdvanceReporting.addLogs("pass", "Clicked on Transfer Button");
			AdvanceReporting.addLogs("pass", "Clicked on Transfer Button", "Clicked on Transfer Button");
			Thread.sleep(2000);
			Utils.uBase.switchToNewWindow();
			Assert.assertTrue(Utils.uBase.getCurrentUrl().contains("phones"), "Transfer page is not displayed");
			AdvanceReporting.addLogs("pass", "Redirected to transfer page");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Redirected to transfer page", "Redirected to porting page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Not redirected to transfer page");
			AdvanceReporting.addLogs("fail", "Not redirected to transfer page", "Not Redirected to transfer page");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// To click on account option in settings page
	public SettingsPage clickAccountInSettings() {
		try {
			Utils.uBase.clickByImage("account");
			AdvanceReporting.addLogs("pass", "account option clicked in settings page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("pass", "");
		}
		return this;
	}

	// To verify account section in settings page
	public SettingsPage verifyAccountSectionDisplayed() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("accountSection"), "account section not displayed");
			AdvanceReporting.addLogs("pass", "account section displayed");
			AdvanceReporting.addLogs("pass", "account section displayed", "account section displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "account section not displayed");
		}
		return this;
	}

	// To click on messages option in settings page
	public SettingsPage clickMessagesInSettings() {
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("Messages");
			AdvanceReporting.addLogs("pass", "Messages option clicked in settings page");
			AdvanceReporting.addLogs("pass", "Messages in settings page clicked", "Messages in settings page clicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Messages option is not clicked in settings page");
		}
		return this;
	}

	// To verify message section in settings page
	public SettingsPage verifyMessagesSectionDisplayed() {
		try {
			Thread.sleep(1000);
			Assert.assertTrue(Utils.uBase.imageCompare("messageSection"), "messageSection section not displayed");
			AdvanceReporting.addLogs("pass", "messageSection section displayed");
			AdvanceReporting.addLogs("pass", "messageSection section displayed", "messageSection section displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "account section not displayed");
		}
		return this;

	}

	// To click on calls option in settings page
	public SettingsPage clickCallsInSettings() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("settingsCalls");
			AdvanceReporting.addLogs("pass", "Calls option in settings page is clicked");
			AdvanceReporting.addLogs("pass", "Calls option in settings page clicked",
					"Calls option in settings page clicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "calls option in settings page is not clicked");
		}
		return this;
	}

	// To verify calls section in settings page
	public SettingsPage verifyCallsSectionDisplayed() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("callssSection"), "callssSection section not displayed");
			AdvanceReporting.addLogs("pass", "callssSection section displayed");
			AdvanceReporting.addLogs("pass", "callssSection section displayed", "messageSection section displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "calls section not displayed");
		}
		return this;
	}

	// To click on DoNotDisturb option in settings page
	public SettingsPage clickDonotDisturbInSettings() {
		try {
			Utils.uBase.clickByImage("donotDisturb");
			AdvanceReporting.addLogs("pass", "donotDisturb option clicked in settings page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("pass", "donotDisturb");
		}
		return this;
	}

	// To verify DoNotDisturb section in settings page
	public SettingsPage verifyDoNotDisturbSectionDisplayed() {
		try {
			Thread.sleep(500);
			// Utils.uBase.takeScreenshotOfWebelement(verifyDoNotDisturb,
			// "verifyDoNotDisturb");
			Assert.assertTrue(Utils.uBase.imageCompare("verifyDonotDisturb"), "doNotDisturbSec section not displayed");
			AdvanceReporting.addLogs("pass", "doNotDisturbSec section displayed");
			AdvanceReporting.addLogs("pass", "doNotDisturbSec section displayed", "messageSection section displayed");
		} catch (Exception e) {

		}
		return this;
	}

	// To click on VoiceMail option in settings page
	public SettingsPage clickVoiceMailInSettings() {
		try {
			Utils.uBase.clickByImage("voiceMail");
			AdvanceReporting.addLogs("pass", "voiceMail option clicked in settings page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("pass", "voiceMail");
		}
		return this;
	}

	// To verify voicemail section in settings page
	public SettingsPage verifyVoiceMailsectionDisplayed() {
		try {
			Thread.sleep(500);
			Assert.assertTrue(Utils.uBase.imageCompare("voiceMailSec"), "voiceMail section not displayed");
			AdvanceReporting.addLogs("pass", "voiceMail section displayed");
			AdvanceReporting.addLogs("pass", "voiceMail section displayed", "messageSection section displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "voiceMail section not displayed");
		}
		return this;
	}

	// To click on audio option in settings page
	public SettingsPage clickAudioInSettings() {
		try {
			Utils.uBase.clickByImage("audio");
			AdvanceReporting.addLogs("pass", "audio option clicked in settings page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("pass", "audio");
		}
		return this;
	}

	// To verify audio section in settings page
	public SettingsPage verifyAudioSectionDisplayed() {
		try {
			Thread.sleep(500);
			Assert.assertTrue(Utils.uBase.imageCompare("audioSec"), "audioSec section not displayed");
			AdvanceReporting.addLogs("pass", "audioSec section displayed");
			AdvanceReporting.addLogs("pass", "audioSec section displayed", "messageSection section displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "audioSec section not displayed");
		}
		return this;
	}

	// To click on WebNotifications option in settings page
	public SettingsPage clickwebNotifyInSettings() {
		try {
			Utils.uBase.clickByImage("webNotify");
			AdvanceReporting.addLogs("pass", "webNotify option clicked in settings page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("pass", "webNotify");
		}
		return this;
	}

	// To verify webnotifications section in settings page
	public SettingsPage verifyWebNotificationSectionDisplayed() {
		try {
			if(Utils.uBase.isElementPresent_webelement(verifyWebNotification)) {
				AdvanceReporting.addLogs("pass", "webNotificationSec section displayed");
				AdvanceReporting.addLogs("pass", "webNotificationSec section displayed",
						"messageSection section displayed");
			}
			else
				AdvanceReporting.addLogs("fail", "webNotificationSec section not displayed");
			
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "webNotificationSec section not displayed");
		}
		return this;
	}

	// To click on payment option in settings page
	public SettingsPage clickPaymentInSettings() {
		try {
			Utils.uBase.clickByImage("payment");
			AdvanceReporting.addLogs("pass", "payment option clicked in settings page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("pass", "payment");
		}
		return this;
	}

	// To verify payments section in settings page
	public SettingsPage verifyPaymentsSectionDisplayed() {
		try {
			Thread.sleep(500);
			Assert.assertTrue(Utils.uBase.imageCompare("paymentSec"), "paymentSec section not displayed");
			AdvanceReporting.addLogs("pass", "paymentSec section displayed");
			AdvanceReporting.addLogs("pass", "paymentSec section displayed", "messageSection section displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "paymentSec section not displayed");
		}
		return this;
	}

	// To click on security option in settings page
	public SettingsPage clickSecurityInSettings() {
		try {
			Utils.uBase.clickByImage("security");
			AdvanceReporting.addLogs("pass", "security option clicked in settings option clicked in settings");
		} catch (Exception e) {
			AdvanceReporting.addLogs("pass", "security option not clicked in settings option clicked in settings");
		}
		return this;
	}

	// To verify security section in settings page
	public SettingsPage verifySecuritySectionDisplayed() {
		try {
			Thread.sleep(500);
			Assert.assertTrue(Utils.uBase.imageCompare("securitySec"), "securitySec section not displayed");
			AdvanceReporting.addLogs("pass", "securitySec section displayed");
			AdvanceReporting.addLogs("pass", "securitySec section displayed", "messageSection section displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "securitySec section not displayed");
		}
		return this;
	}

	// To click on accessibility option in settings page
	public SettingsPage clickAccesibilityInSettings() {
		try {
			Utils.uBase.clickByImage("accessibility");
			AdvanceReporting.addLogs("pass", "accesibility option clicked in settings");
		} catch (Exception e) {
			AdvanceReporting.addLogs("pass", "accesibility option not clicked in settings");
		}
		return this;
	}

	// To verify accessibility section in settings page
	public SettingsPage verifyAccesibilitySectionDisplayed() {
		try {
			Thread.sleep(500);
			Assert.assertTrue(Utils.uBase.imageCompare("accesibilitySec"), "accesibilitySec section not displayed");
			AdvanceReporting.addLogs("pass", "accountSection section displayed");
			AdvanceReporting.addLogs("pass", "accountSection section displayed", "messageSection section displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "accesibilitySec section not displayed");
		}
		return this;
	}

	// To ebit phone name in devices section
	public SettingsPage settingsEditPhoneName(String data) {
		try {
			Thread.sleep(5000);
			String str[] = data.split("\\|");
			for (int i = 0; i < str.length; i++) {
				Utils.uBase.clickByImage("deviceNameEdit");
				AdvanceReporting.addLogs("pass", "clicked on device name edit option" + str.length);
				Utils.uBase.clickWebelement(clearTextBox);
				Thread.sleep(3000);
				clearTextBox.sendKeys(Keys.chord(Keys.CONTROL + "a"));
				clearTextBox.sendKeys(Keys.BACK_SPACE);
				AdvanceReporting.addLogs("pass", "text box is cleared");
				Thread.sleep(2000);
				AdvanceReporting.addLogs("pass", "text box is cleared", "text box is cleared");
				deviceNameTextBox.sendKeys(str[i]);
				AdvanceReporting.addLogs("pass", "name is set in text box");
				Thread.sleep(1000);
				Utils.uBase.clickByImage("deviceNameSave");
				AdvanceReporting.addLogs("pass", "device name saved");
				Thread.sleep(1000);
				// Utils.uBase.refresh();
				String temp = deviceName.getText();
				AdvanceReporting.addLogs("pass", "device name saved" + temp + str[0]);
				if (str[i].equalsIgnoreCase(temp)) {
					AdvanceReporting.addLogs("pass", "Device name has updated");
					AdvanceReporting.addLogs("pass", "Device name has updated", "Device name has updated");
				} else {
					AdvanceReporting.addLogs("fail", "Device name is not updated");
					AdvanceReporting.addLogs("pass", "Device name is not updated", "Device name is not updated");
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "device name not updated");
		}
		return this;
	}

	// To enable voicemail toggle
	public SettingsPage voicemailToggleEnable() {
		try {
			Utils.uBase.clickByImage("voiceMail");
			Utils.uBase.focusWebelement(voicemailToggle);

			if (voicemailToggle.getAttribute("class").contains("not-empty")) {
				AdvanceReporting.addLogs("info", "Already voicemail transcript is enabled");
				AdvanceReporting.addLogs("pass", "Already voicemail transcript is enabled",
						"Already voicemail transcript is enabled");
			} else {
				Utils.uBase.clickWebelement(voicemailToggle);
				Thread.sleep(1000);
				AdvanceReporting.addLogs("info", "Enabled voice mail toggle");
				AdvanceReporting.addLogs("pass", "Enabled voice mail toggle");
				AdvanceReporting.addLogs("info", "Enabled voice mail toggle", "Enabled voice mail toggle");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "voiceMail toggle is not enabled");
		}
		return this;
	}

	// To verify voicemail toggle is enabled
	public SettingsPage VerifyVoicemailToggleEnable() {
		try {
			if (Utils.uBase.imageCompare("voicemailToggleEnabled")) {
				AdvanceReporting.addLogs("pass", " voicemail transcript toggle is enabled");
			} else {
				AdvanceReporting.addLogs("fail", " voicemail transcript is not enabled");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", " voicemail transcript is not enabled");
		}
		return this;
	}

	// To disable voicemail toggle
	public SettingsPage voicemailToggleDisable() {
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("voiceMail");
			Utils.uBase.focusWebelement(voicemailToggle);
			if (voicemailToggle.getAttribute("class").contains("ng-empty")) {
				Thread.sleep(1000);
				AdvanceReporting.addLogs("info", "Already voicemail transcript is Disabled");
				AdvanceReporting.addLogs("pass", "Already voicemail transcript is Disabled",
						"Already voicemail transcript is Disabled");
			} else {
				Utils.uBase.clickWebelement(voicemailToggle);
				Thread.sleep(1000);
				AdvanceReporting.addLogs("pass", " voicemail transcript toggle is disabled");
				AdvanceReporting.addLogs("pass", " voicemail transcript toggle is disabled",
						" voicemail transcript toggle is disabled");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", " voicemail transcript is not enabled");
		}
		return this;
	}

	// To verify voicemail toggle is disabled
	public SettingsPage VerifyVoicemailToggleDisable() {
		try {
			Thread.sleep(500);
			if (Utils.uBase.imageCompare("voicemailToggleDisabled")) {
				AdvanceReporting.addLogs("pass", " voicemail transcript toggle is disabled");
			} else {
				AdvanceReporting.addLogs("fail", " voicemail transcript is not disabled");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", " voicemail transcript is not disabled");
		}
		return this;
	}

	/* Verify Redirected to Setting Page */
	public SettingsPage verifyRedirectedToSettings() {
		try {
			Utils.uBase.switchToNewWindow();
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("SettingPage"), "Not redirected to setting page");
			AdvanceReporting.addLogs("pass", "Setting page is displayed");
			AdvanceReporting.addLogs("pass", "Rediredted to Setting page", "SettingPage");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Not redirected to setting page");
			AdvanceReporting.addLogs("fail", "Not redirected to setting page");
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// click EndNow to disable Do Not Disturb
	public SettingsPage clickEndNowToDisableDoNotDisturb() {
		try {
			Thread.sleep(10000);
			Utils.uBase.clickByImage("EndNow");
			Thread.sleep(5000);
			AdvanceReporting.addLogs("info", "Clicked on end now");
			AdvanceReporting.addLogs("pass", "Clicked on end now", "End Now");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Not clicked on end now");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/* Verify Click on Privacy and Terms */
	public SettingsPage verifyClickOnPrivacyTerms() {
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("PrivacyTerms");
			AdvanceReporting.addLogs("pass", "Privacy & Terms is clicked");
			AdvanceReporting.addLogs("pass", "Privacy & Terms is clicked", "Terms");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Privacy & Terms is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/* Verify Click on Privacy */
	public SettingsPage verifyClickOnPrivacy() {
		try {
			Thread.sleep(10000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickByImage("Privacy");
			AdvanceReporting.addLogs("pass", "Privacy is clicked");
			AdvanceReporting.addLogs("pass", "Privacy is clicked", "Terms");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Privacy is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/* Verify Redirected to Privacy page */
	public SettingsPage verifyRedirectedToPrivacy() {
		try {
			Utils.uBase.switchToNewWindow();
			Thread.sleep(8000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("privacyPolicy"), "Privacy Page is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that privacy page is displayed");
			AdvanceReporting.addLogs("pass", "Rediredted to Privacy page", "TermsPage");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Privacy Page is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// Clicks hangout option in settings
	public SettingsPage clickHangoutsTab() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("HangoutsTab");
			AdvanceReporting.addLogs("info", "Hangouts clicked");
			AdvanceReporting.addLogs("info", "Hangouts clicked", "HangoutsTabClicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Hangouts tab is not clicked");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// Clicks on disconnect hangout in settings page
	public SettingsPage clickDisconnect() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("DisconnectHangouts");
			AdvanceReporting.addLogs("info", "Disconnect clicked");
			AdvanceReporting.addLogs("info", "Disconnect clicked", "Disconnect");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Disconnect button is not clicked");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// Clicks disconnect in hangouts pop up
	public SettingsPage clickDisconnectHangoutsPopUp() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("DisconnectPopUp");
			AdvanceReporting.addLogs("info", "Disconnect clicked in hangouts pop up");
			AdvanceReporting.addLogs("info", "Disconnect clicked in hangouts pop up", "DisconnectPopUpHangouts");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Disconnect button is not clicked in hangouts pop up");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// Click close in settings
	public SettingsPage clickCloseSettings() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("closeSettings");
			AdvanceReporting.addLogs("pass", "Close settings is clicked in settings page");
			AdvanceReporting.addLogs("info", "Close settings is clicked in settings page", "CloseClicked");
			Thread.sleep(4000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Close settings is not clicked");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	public SettingsPage addLnkdNum(int bellevue, String deviceId, String appPackage, String appActivity) {
		try {
			Thread.sleep(3000);
			Utils.uBase.setupMDriver(bellevue, deviceId, appPackage, appActivity);
			// Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyNote9_SM_DUT1,
			// Constants.MESSAGE_APP_PACKAGE_NAME2, Constants.MESSAGE_APP_ACTIVITY2);
			MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
			msgMobPage.clickOnMessageWithText().getCodeFromMessage();
			enterVerificationCode().clickVerifyLnkdNum();
			if (Utils.uBase.mDriver != null) {
				Utils.uBase.mDriver.quit();
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Could not link number to GV account");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickNewLinkedNumber() {
		try {

			Utils.uBase.scrolltoElement(msgHeading);
			Thread.sleep(2000);
			Utils.uBase.clickByImage("NewLinkedNumber");
			AdvanceReporting.addLogs("pass", "Clicked on New linked Number button");
			AdvanceReporting.addLogs("pass", "New linked number clicked", "NewLinkedImg");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage enterMobileNoToBeLinked(String phoneNoToBeLinked) {
		try {

			Utils.uBase.waitForElement(inputLinkedNoDialogBox);
			Utils.uBase.clickWebelement(inputLinkedNoDialogBox);
			Utils.uBase.setText(inputLinkedNoDialogBox, phoneNoToBeLinked);
			AdvanceReporting.addLogs("pass", "Enter phone number in the pop-up screen.");
			AdvanceReporting.addLogs("pass", "Entered phone number", "EnterPhno");
			Thread.sleep(2000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickSendBtnLinkedNoDialog() {
		try {
			Thread.sleep(3000);
			Utils.uBase.clickByImage("SendLinkedDialog");
			AdvanceReporting.addLogs("pass", "Send button is clicked in input verification box");
			AdvanceReporting.addLogs("pass", "Send button is clicked in input verification box", "SendClicked");
			Thread.sleep(5000);
		} catch (Exception e) {

			AdvanceReporting.addLogs("fail", "Clicking on send button failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage enterVerificationCode() {
		try {
			Utils.uBase.setText(inputVerificationBox, MessagePageAndroid.code);
			Thread.sleep(2000);
			AdvanceReporting.addLogs("info", "Code successfully entered in input verification box");
			AdvanceReporting.addLogs("info", "Code successfully entered in input verification box", "CodeEntered");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Code entered in input verification box");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickVerifyLnkdNum() {
		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("verifyButtonVerificationDialog");
			Thread.sleep(4000);
			if (Utils.uBase.imageCompare("claimOptn") == true) {
				Utils.uBase.clickByImage("claimOptn");
				AdvanceReporting.addLogs("pass", "Clicked on claim option successfully");
				AdvanceReporting.addLogs("pass", "Clicked on claim option", "Clicked on claim option");
				Thread.sleep(4000);
				Utils.uBase.clickByImage("finishTab");
				AdvanceReporting.addLogs("pass", "Clicked on finish button successfully");
				AdvanceReporting.addLogs("pass", "Clicked on finish button", "Clicked on finish button");
			} else {
				Thread.sleep(4000);
				Utils.uBase.clickByImage("finishTab");
				AdvanceReporting.addLogs("pass", "Clicked on finish button successfully");
				AdvanceReporting.addLogs("pass", "Clicked on finish button", "Clicked on finish button");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickVerify() {
		try {

			Utils.uBase.clickByImage("VerifyButton");
			AdvanceReporting.addLogs("info", "Clicked on verify in input verification box");
			AdvanceReporting.addLogs("info", "Clicked on verify in input verification box", "verifyClicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Verify in input verification box is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage verifyElementsDisplayedInSameRow() {
		try {
			//Point p;
			if (lstLinkedNumbers.size() != 0) {
				AdvanceReporting.addLogs("pass", "Verified that name of the Linked number is available");
				AdvanceReporting.addLogs("pass", "Linked number is available", "Linked number is available");
			}
			if (lstCloseButtonsLinkednos.size() != 0) {
				AdvanceReporting.addLogs("pass", "Verified that Close button is available");
				AdvanceReporting.addLogs("pass", "Close button is available", "Close button is available");
			}
			/*
			 * Point phnxco=((lstLinkedNumbers).get(0).getLocation()); Point
			 * clsbtn=((linkedNumRemove).get(0).getLocation());
			 * System.out.println("phnxco"+phnxco); System.out.println("clsbtn"+clsbtn);
			 */
				int phoneNoYCordinate=(lstLinkedNumbers.get(0).getLocation().getY());
				int closeButtonYCordinate=(linkedNumRemove.get(0).getLocation().getY());
				int phoneNoXCordinate=(lstLinkedNumbers.get(0).getLocation().getX());
				int closeButtonXCordinate=(linkedNumRemove.get(0).getLocation().getX());
				if((phoneNoYCordinate+1==closeButtonYCordinate||phoneNoYCordinate+2==closeButtonYCordinate||phoneNoYCordinate-1==closeButtonYCordinate||phoneNoYCordinate-2==closeButtonYCordinate)) {
					AdvanceReporting.addLogs("pass", "verified that linked number and remove bottonsa are in same line");
				}		
				else
					AdvanceReporting.addLogs("fail", "Linked number and remove button are not in the same row ");
			
			/*
			 * if(lstEditButtonsLinkedNos.size()!=0) {
			 * AdvanceReporting.addLogs("pass","Verified that Edit button is available");
			 * AdvanceReporting.addLogs("pass","Edit button is available"
			 * ,"Edit button is available"); }
			 */
			/*p = lstLinkedNumbers.get(0).getLocation();
			
			 * int phoneNoYCordinate=p.getY();
			 * p=lstCloseButtonsLinkednos.get(0).getLocation(); int
			 * closeButtonYCordinate=p.getY();
			 * 
			 * p=lstEditButtonsLinkedNos.get(0).getLocation(); int
			 * editbuttonYCordinate=p.getY();
			 * 
			 * if((phoneNoYCordinate+1==closeButtonYCordinate||
			 * phoneNoYCordinate+2==closeButtonYCordinate||phoneNoYCordinate-1==
			 * closeButtonYCordinate||phoneNoYCordinate-2==closeButtonYCordinate))
			 * //&&(phoneNoYCordinate+1==editbuttonYCordinate
			 * ||editbuttonYCordinate==phoneNoYCordinate+2
			 * ||phoneNoYCordinate-1==editbuttonYCordinate||phoneNoYCordinate-2==
			 * editbuttonYCordinate )) { AdvanceReporting.addLogs("pass",
			 * "Verified that, name of the linked numbers, 'Edit' button, 'X' delete button are displayed in the same row"
			 * ); AdvanceReporting.addLogs("pass",
			 * "All buttons are displayed in the same row","AllInSameRow"); }else {
			 * AdvanceReporting.addLogs("fail",
			 * "Phone number, edit button and close button are not in same row"); }
			 */
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Verification of elements in same row failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage verifPhoneNosAreListed() {
		try {
			for (WebElement element : lstLinkedNumbers) {
				Thread.sleep(1000);
				if (element.getText().replaceAll("\\W", "").contains(Constants.SAMSUNGGalaxyNote9plus_Numb1)) {
					AdvanceReporting.addLogs("pass", "Verified that, the Google voice forwarding number is listed");
					AdvanceReporting.addLogs("pass", "Forwarding number is listed", "LinkedNoListed");
					break;
				}
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Verification of elements in same row failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	//
	public SettingsPage verifyEachPhoneNoDisplayedInSingleRow() {
		try {
			ArrayList<Integer> phoneNosXCordinates = new ArrayList<Integer>();
			// Set<Integer> numbers;
			for (int i = 0; i < lstLinkedNumbers.size(); i++) {
				phoneNosXCordinates.add(lstLinkedNumbers.get(i).getLocation().getX());
			}
			String number = linkedNumbers.getText();
			char[] temp = number.toCharArray();
			char val = temp[0];
			int count = phoneNosXCordinates.size();
			int a = Character.getNumericValue(val);
			System.out.println("count" + count);
			System.out.println("a" + a);
			if (count == a) {
				AdvanceReporting.addLogs("pass", "Verified that, each linked number is displayed in a single row.");
			} else
				AdvanceReporting.addLogs("fail", "single row contains more than two numbers");
			/*
			 * numbers = new HashSet(Arrays.asList(phoneNosXCordinates));
			 * Assert.assertTrue(numbers.size()==phoneNosXCordinates.size()
			 * ,"Numbers are not added in separate rows"); AdvanceReporting.addLogs("pass",
			 * "Verified that, each linked number is displayed in a single row.");
			 */
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage callsFwdToggleActions(String switchStatus) {
		try {
			if (switchStatus.equalsIgnoreCase("on")) {
				if (callsFwdToggle.getAttribute("aria-checked").equalsIgnoreCase("true")) {
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is ON", "CallsToggleOn");
				} else {
					Utils.uBase.clickWebelement(callsFwdToggle);
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is ON", "CallsToggleOn");
				}
			}
			if (switchStatus.equalsIgnoreCase("off")) {
				if (callsFwdToggle.getAttribute("aria-checked").equalsIgnoreCase("false")) {
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is OFF", "CallsToggleOff");
				} else {
					Utils.uBase.clickWebelement(callsFwdToggle);
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is OFF", "CallsToggleOff");
				}
			}
		} catch (Exception e) {

			AdvanceReporting.addLogs("fail", "Calls forward toggle action failed");
		}
		return this;
	}

	public SettingsPage msgFwdToggleActions(String switchStatus) {
		try {
			if (switchStatus.equalsIgnoreCase("on")) {
				Utils.uBase.waitForElement(msgsFwdToggle);
				if ((Utils.uBase.isElementDisabled(msgsFwdToggle)) == true) {
					clickCloseSettings();
					HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
					hmPage.clickMainMenu().clickLegacyGoogleVoice();
					LegacyGVPage legacyGVPage = PageFactory.initElements(Utils.uBase.webDriver, LegacyGVPage.class);
					legacyGVPage.clickPhoneLabel().clickEditPhoneType().selectMobilePhoneType().savePhoneTypeSttng()
							.ReceiveTxtMsgCheckBox().confrmChangesSaved().voicemailViaTxtCheckBox()
							.confrmChangesSaved();
					Utils.uBase.switchToOldWindow();
					hmPage.clickSettings();
					Utils.uBase.refresh();
					clickMessagesInSettings();
					AdvanceReporting.addLogs("pass", "Message forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Message forwarding toggle is ON", "MsgsToggleOn");
				} else if ((Utils.uBase.isElementDisabled(msgsFwdToggle)) == false) {
					if (msgsFwdToggle.getAttribute("aria-checked").equalsIgnoreCase("false")) {
						Utils.uBase.clickWebelement(msgsFwdToggle);
						AdvanceReporting.addLogs("pass", "Message forwarding toggle has been switched to ON");
						AdvanceReporting.addLogs("pass", "Message forwarding toggle is switched ON", "MsgsToggleON");
					} else {
						AdvanceReporting.addLogs("info", "Message forwarding toggle is already switched ON");
						AdvanceReporting.addLogs("pass", "Message forwarding toggle is switched ON", "MsgsToggleON");
					}
				} else {
					AdvanceReporting.addLogs("fail", "Could find the webelement");
					AdvanceReporting.addLogs("fail", "Could find the webelement", "Could find the webelement");
				}
			}

			if (switchStatus.equalsIgnoreCase("off")) {
				if (msgsFwdToggle.getAttribute("aria-checked").equalsIgnoreCase("false")) {
					AdvanceReporting.addLogs("pass", "Message forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Message forwarding toggle is OFF", "MsgsToggleOff");
				} else {
					Utils.uBase.clickWebelement(msgsFwdToggle);
					AdvanceReporting.addLogs("pass", "Message forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Message forwarding toggle is OFF", "MsgsToggleOff");
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Message forward toggle action failed");
		}
		return this;
	}

	public SettingsPage msgEmailToggleActions(String switchStatus) {
		try {
			Utils.uBase.waitForElementToBeClickable(msgsEmailToggle);
			if (switchStatus.equalsIgnoreCase("on")) {
				if (msgsEmailToggle.getAttribute("aria-checked").equalsIgnoreCase("true")) {
					AdvanceReporting.addLogs("pass", "Message Email forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Message Email forwarding toggle is ON", "MsgsToggleOn");
				} else {
					Utils.uBase.clickWebelement(msgsEmailToggle);
					AdvanceReporting.addLogs("pass", "Message Email forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Message Email forwarding toggle is ON", "MsgsToggleOn");
				}
			}

			if (switchStatus.equalsIgnoreCase("off")) {
				if (msgsEmailToggle.getAttribute("aria-checked").equalsIgnoreCase("false")) {
					AdvanceReporting.addLogs("pass", "Message Email forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Message Email forwarding toggle is OFF", "MsgsToggleOff");
				} else {
					Utils.uBase.clickWebelement(msgsEmailToggle);
					AdvanceReporting.addLogs("pass", "Message Email forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Message Email forwarding toggle is OFF", "MsgsToggleOff");
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Message Email forwarding toggle action failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// To click Payment Tab
	public SettingsPage clickPaymentTab() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("PaymentsTab");
			AdvanceReporting.addLogs("info", "Payments clicked");
			AdvanceReporting.addLogs("pass", "Payments clicked", "pay");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Payments is not clicked");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// To click Voicemail Tab
	public SettingsPage clickVoicemailTab() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("VoiceMailSettingsTab");
			AdvanceReporting.addLogs("info", "Voicemail tab clicked");
			AdvanceReporting.addLogs("pass", "Voicemail tab clicked", "VoiceMailSettingsTab");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Voicemail tab not clicked");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// To click Message Tab
	public SettingsPage clickMessageTab() {
		try {
			Thread.sleep(2000);
			if (Utils.uBase.imageCompare("MsgSettingsTab")) {
				Utils.uBase.clickByImage("MsgSettingsTab");
				AdvanceReporting.addLogs("info", "MsgSettings tab clicked");
				AdvanceReporting.addLogs("pass", "MsgSettings tab clicked", "VoiceMailSettingsTab");
			} else {
				AdvanceReporting.addLogs("info", "MsgSettings tab not prsent");
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "MsgSettings tab not clicked");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	public SettingsPage verifyUsGvNum() {
		try {
			Utils.uBase.waitForElement(addressField);
			String add = addressField.getText();
			AdvanceReporting.addLogs("pass", "This account have US Gv number " + add);
			Assert.assertTrue(add.contains("United States"));
			AdvanceReporting.addLogs("pass", "Verified that this account have US Gv number");
			AdvanceReporting.addLogs("pass", "This account have US Gv number", "US GV Number");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "This account does not have US Gv number");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;

	}

	// Method to verify User should not see the message forwarding section in the
	// settings page
	public SettingsPage verifyMessageForwardingSection() {
		try {
			if (!Utils.uBase.imageCompare("msgFrwdToggle")) {
				AdvanceReporting.addLogs("info", "Verified that msg Forward Toggle is  not present");
				AdvanceReporting.addLogs("pass", "msg Forward Toggle is not present", "msgFrwdToggle");
			} else {
				AdvanceReporting.addLogs("fail", "msg Forward Toggle is present");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "msg Forward Toggle is not present");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// To click New Linked Number Btn
	/*
	 * public SettingsPage clickNewLinkedNumberBtn(){ try{ Thread.sleep(2000);
	 * Utils.uBase.clickByImage("newLinkedNumberButton");
	 * AdvanceReporting.addLogs("info","New Linked Number Button clicked");
	 * AdvanceReporting.addLogs("pass","New Linked Number Button clicked"
	 * ,"newLinkedNumberButton"); } catch(Exception e){
	 * AdvanceReporting.addLogs("info","New Linked Number Button not clicked");
	 * AdvanceReporting.addLogs("fail", e.getMessage()); } return this; }
	 */
	/* Verify enable Do not disturb */
	public SettingsPage clickNewLinkedNumberBtn() {

		try {
			((JavascriptExecutor) Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);",
					newLinkedNumberBtn);
			Thread.sleep(3000);
			Utils.uBase.clickByImage("newLinkedNumberButton");
			AdvanceReporting.addLogs("info", "New Linked Number Button clicked");
			AdvanceReporting.addLogs("pass", "New Linked Number Button clicked", "newLinkedNumberButton");

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "New Linked Number Button not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}

		return this;
	}

	public SettingsPage removeLinkedNum() {

		try {
			Utils.uBase.scrolltoElement(msgHeadlineSttng);
			Thread.sleep(1500);
			Utils.uBase.clickByImage("crossLinkedNum");
			AdvanceReporting.addLogs("pass", "Clicked on X to remove linked number successfully");
			AdvanceReporting.addLogs("pass", "Clicked on X to remove", "Clicked on X to remove");
			Thread.sleep(1500);
			Utils.uBase.hoverOnImage("rmvLnkdNumConfMsg");
			Assert.assertTrue(Utils.uBase.imageCompare("rmvLnkdNumConfMsg"), "Remove linked number is not present");
			{
				AdvanceReporting.addLogs("pass", "Message with Remove linked number is present");
				AdvanceReporting.addLogs("pass", "Remove linked number is present", "Remove linked number is present");
			}
			Thread.sleep(1000);
			Utils.uBase.hoverOnImage("rmvLnkdNumPopUp");
			Assert.assertTrue(Utils.uBase.imageCompare("rmvLnkdNumPopUp"),
					"Declaration Message is not present in popup window");
			{
				AdvanceReporting.addLogs("pass", "Declaration Message is present in popup window");
				AdvanceReporting.addLogs("pass", "Declaration Message is present in popup window",
						"Declaration Message is present in popup window");
			}
			Thread.sleep(1000);
			Utils.uBase.hoverOnImage("rmvLnkdNumCancelBtn");
			Assert.assertTrue(Utils.uBase.imageCompare("rmvLnkdNumCancelBtn"),
					"Cancel button in remove linked number window is not present");
			{
				AdvanceReporting.addLogs("pass", "Cancel button in remove linked number window is present");
				AdvanceReporting.addLogs("pass", "Cancel button is present", "Cancel button is present");
			}
			Thread.sleep(1000);
			Utils.uBase.hoverOnImage("rmvLnkdNumRemoveBtn");
			Assert.assertTrue(Utils.uBase.imageCompare("rmvLnkdNumRemoveBtn"), "Assert pass");
			{
				AdvanceReporting.addLogs("pass", "Remove button in remove linked number is present");
				AdvanceReporting.addLogs("pass", "Remove button is present", "Remove button is present");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// To click New Linked Number Btn
	public SettingsPage clickCountryDropdown() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("dropdownButton");
			AdvanceReporting.addLogs("info", "Dropdown Button clicked");
			AdvanceReporting.addLogs("pass", "Dropdown Button clicked", "dropdownButton");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Dropdown Button not clicked");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	public SettingsPage verifyCountryFlags() {
		try {
			if (Utils.uBase.imageCompare("countryFlagsImg")) {
				AdvanceReporting.addLogs("pass", "Verified that US and UK country Flag Imgs are Available");
				AdvanceReporting.addLogs("pass", "US and UK country Flag Imgs are Available", "countryFlagsImg");
			} else {
				AdvanceReporting.addLogs("fail", "US and UK country Flag Imgs are not Available");
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// Method to verify that User shall not have access to CHANGE, TRANSFER and
	// DELETE his GV number
	public SettingsPage verifyChangeTrfrAndDelBtnsInWolvAcc() {
		try {
			Assert.assertFalse(Utils.uBase.imageCompare("modifyOrDeleteNumber"),
					"Change,Transfer & Delete Buttons Not Present");
			AdvanceReporting.addLogs("pass",
					"Verified that change,Transfer & Delete Buttons Not Present in GV Enterprise account");
			AdvanceReporting.addLogs("pass", "Change,Transfer & Delete Buttons Not Present in GV Enterprise account",
					"modifyOrDeleteNumber");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Change,Transfer & Delete Buttons are Present in GV Enterprise account");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// Method to clickNewLinkedNumberBtn
	public SettingsPage verifyIncomingCallOptions() {
		try {
			// ((JavascriptExecutor)Utils.uBase.webDriver).executeScript("arguments[0].scrollIntoView(true);",
			// doNotDisturbText);
			Thread.sleep(3000);
			Assert.assertFalse(Utils.uBase.imageCompare("incomingCallOptionsTxt"), "Incoming Call Options Not Present");
			AdvanceReporting.addLogs("pass", "Verified that incoming Call Options is Not Present");
			AdvanceReporting.addLogs("pass", "Incoming Call Options is Not Present", "incomingCallOptionsTxt");

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Incoming Call Options is Present");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage voicemailFwdViaSMSToggleActions(String switchStatus) {
		try {
			if (switchStatus.equalsIgnoreCase("on")) {
				if (voicemailFwdViaSMSToggle.getAttribute("aria-checked").equalsIgnoreCase("true")) {
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is ON", "VoicemailToggleOn");
				} else {
					Utils.uBase.clickWebelement(voicemailFwdViaSMSToggle);
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is ON", "VoicemailToggleOn");
				}
			}

			if (switchStatus.equalsIgnoreCase("off")) {
				if (voicemailFwdViaSMSToggle.getAttribute("aria-checked").equalsIgnoreCase("false")) {
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is OFF", "VoicemailToggleOff");
				} else {
					Utils.uBase.clickWebelement(voicemailFwdViaSMSToggle);
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is OFF", "VoicemailToggleOff");
				}
			}

		} catch (Exception e) {

			AdvanceReporting.addLogs("fail", "Voicemail forward toggle action failed");
		}
		return this;
	}

	public SettingsPage voicemailFwdViaEmailToggleActions(String switchStatus) {
		try {
			if (switchStatus.equalsIgnoreCase("on")) {
				if (voicemailFwdViaEmailToggle.getAttribute("aria-checked").equalsIgnoreCase("true")) {
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is ON", "VoicemailToggleOn");
				} else {
					Utils.uBase.clickWebelement(voicemailFwdViaEmailToggle);
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is ON", "VoicemailToggleOn");
				}
			}

			if (switchStatus.equalsIgnoreCase("off")) {
				if (voicemailFwdViaEmailToggle.getAttribute("aria-checked").equalsIgnoreCase("false")) {
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Voicemail forwarding toggle is OFF", "VoicemailToggleOff");
				} else {
					Utils.uBase.clickWebelement(voicemailFwdViaEmailToggle);
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is OFF", "VoicemailToggleOff");
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Security tab is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickSecurity() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("settngSecurityTab");
			AdvanceReporting.addLogs("pass", "Security tab is clicked");
			AdvanceReporting.addLogs("pass", "Security tab is clicked", "Security tab is clicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Security tab is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}

		return this;
	}

	public SettingsPage enableSpamFilter() {
		try {
			Thread.sleep(2000);
			Utils.uBase.scrolltoElement(privPolic);
			Utils.uBase.clickWebelement(spamFilterToggle);
			AdvanceReporting.addLogs("pass", "Spam filter toggle is clicked successfully");
			AdvanceReporting.addLogs("pass", "Spam filter toggle is clicked", "Spam filter toggle is clicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Spam filter toggle is not clicked");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}

		return this;
	}

	public SettingsPage callsEmailAlertToggle(String switchStatus) {
		try {
			if (switchStatus.equalsIgnoreCase("on")) {
				if (callsEmailAlertToggle.getAttribute("aria-checked").equalsIgnoreCase("true")) {
					AdvanceReporting.addLogs("pass", "Calls Email alert toggle is ON");
					AdvanceReporting.addLogs("pass", "Calls Email alert toggle is ON", "CallsToggleOn");
				} else {
					Utils.uBase.clickWebelement(callsEmailAlertToggle);
					AdvanceReporting.addLogs("pass", "Calls Email alert toggle is OFF");
					AdvanceReporting.addLogs("pass", "Calls Email alert toggle is OFF", "CallsToggleOn");
				}
			}

			if (switchStatus.equalsIgnoreCase("off")) {
				if (callsEmailAlertToggle.getAttribute("aria-checked").equalsIgnoreCase("false")) {
					AdvanceReporting.addLogs("pass", "Calls Email alert toggle is OFF");
					AdvanceReporting.addLogs("pass", "Calls Email alert toggle is OFF", "CallsToggleOff");
				} else {
					Utils.uBase.clickWebelement(callsEmailAlertToggle);
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Calls forwarding toggle is ON", "CallsToggleOff");
				}
			}

		} catch (Exception e) {

			AdvanceReporting.addLogs("fail", "Calls forward toggle action failed");
		}
		return this;
	}

	// To click on do not disturb option in settings page
	public SettingsPage clickDoNotDisturbInSettings() {
		try {
			Utils.uBase.clickByImage("Donotdisturb");
			AdvanceReporting.addLogs("pass", "Do not disturb option in settings page is clicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Do not disturb in settings page is not clicked");
		}
		return this;
	}

	// Click Do not disturb toggle
	public SettingsPage clickDoNotDisturbToggle(String switchStatus) {
		try {
			if (switchStatus.equalsIgnoreCase("on")) {
				if (doNotDisturbToggleOnOff.getAttribute("class").equalsIgnoreCase("checked")) {
					AdvanceReporting.addLogs("pass", "Do not disturb toggle is ON");
					AdvanceReporting.addLogs("pass", "Do not disturb toggle is ON", "DoNotDistrbToggleOn");
				} else {
					Utils.uBase.clickWebelement(doNotDisturbToggleOnOff);
					AdvanceReporting.addLogs("pass", "Do not disturb toggle is ON");
					AdvanceReporting.addLogs("pass", "Do not disturb toggle is ON", "DoNotDistrbToggleOn");
				}
			}

			if (switchStatus.equalsIgnoreCase("off")) {
				if (doNotDisturbToggleOnOff.getAttribute("class").equalsIgnoreCase("focused")) {
					AdvanceReporting.addLogs("pass", "Do not disturb toggle is OFF");
					AdvanceReporting.addLogs("pass", "Do not disturb toggle is OFF", "DoNotDistrbToggleOn");
				} else {
					Utils.uBase.clickWebelement(doNotDisturbToggleOnOff);
					AdvanceReporting.addLogs("pass", "Do not disturb toggle is OFF");
					AdvanceReporting.addLogs("pass", "Do not disturb toggle is OFF", "DoNotDistrbToggleOn");
				}
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Do not disturb toggle action failed");
		}
		return this;
	}

	// Verify do not disturb toggle status
	public SettingsPage verifyDoNotDisturbToggleStatus(String switchStatus) {
		try {
			if (switchStatus.equalsIgnoreCase("off")) {
				if (doNotDisturbToggleOnOff.getAttribute("class").equalsIgnoreCase("focused")) {
					AdvanceReporting.addLogs("pass", "Verified that Do not disturb toggle is OFF");
					AdvanceReporting.addLogs("pass", "Do not disturb toggle is OFF", "DoNotDistrbToggleOff");
				}

				else if (switchStatus.equalsIgnoreCase("on")) {
					if (doNotDisturbToggleOnOff.getAttribute("class").equalsIgnoreCase("checked")) {
						AdvanceReporting.addLogs("fail", "Do not disturb toggle is OFF");
						AdvanceReporting.addLogs("fail", "Do not disturb toggle is OFF", "DoNotDistrbToggleOn");
					}
				}
			}
		}

		catch (Exception e) {

			AdvanceReporting.addLogs("fail", "Do not disturb toggle action failed");
		}
		return this;
	}

	// To verify screen calls toggle is enabled
	public SettingsPage verifyScreenCallsToggleEnabled() throws Exception {
		try {
			Thread.sleep(3000);
			Utils.uBase.scrolltoElement(screenCallsToggle);
			Thread.sleep(3000);
			if (screenCallsToggle.getAttribute("aria-checked").equalsIgnoreCase("false")) {
				AdvanceReporting.addLogs("pass", "Verified that screen call toggle is not enabled");
				AdvanceReporting.addLogs("pass", "Screen call toggle is not enabled", "ScreencalltoggleEnabled");
			} else {
				AdvanceReporting.addLogs("fail", "Screen call toggle is not enabled");
				AdvanceReporting.addLogs("fail", "Screen call toggle is not enabled", "calltoggleNotenabled");
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Screen call toggle is enabled");
			AdvanceReporting.addLogs("fail", " Screen call toggle is enabled :" + e.getMessage());
		}
		return this;
	}

	// To click on manage greetings option
	public SettingsPage clickOnManageGreeting() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("manageAllGreeting");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "clicked on manage all greetings option");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "can not click on manage all greetings option");
		}
		return this;
	}

	// To verify all greetings popup displayed or not
	public SettingsPage verifyAllGreetingsPopUpDisplayed() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("allGreetingPopUp"), "all greetings popup not displayed");
			AdvanceReporting.addLogs("pass", "Verified that all greetings popup displayed");
			AdvanceReporting.addLogs("pass", "all greetings popup displayed", "all greetings popup displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "all greetings popup not displayed");
		}
		return this;
	}

	// To verify active section in all greetings popup
	public SettingsPage verifyActiveSectionInAllGreeting() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("activeInAllGreetings"), "active section is not displayed");
			AdvanceReporting.addLogs("pass", "Verified that active section is displayed");
			AdvanceReporting.addLogs("pass", "active section is displayed", "active section is displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "active section is not displayed");
		}
		return this;
	}

	// To verify other section displayed in all greetings popup
	public SettingsPage verifyOthersSectionInAllGreeting() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("otherInAllGreeting"),
					"others option not present in all greeting popup");
			AdvanceReporting.addLogs("pass", "Verified that others  option is present in all greeting popup");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "others  option is present in all greeting popup");
		}
		return this;
	}

	// To verify active currently active greeting has name
	public SettingsPage verifyActiveGreetingName() {
		try {
			if (activeUserName.getText() != null) {
				AdvanceReporting.addLogs("pass", "Verified that active recording has a name");
				AdvanceReporting.addLogs("pass", "active recording has a name", "active recording has a name");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "active recording does not contain any name");
		}
		return this;
	}

	// To verify active greeting has duriation
	public SettingsPage verifyActiveGreetingDuriation() {
		try {
			if (activeUserGreetingDuriation.getText() != null) {
				AdvanceReporting.addLogs("pass", "Verified that duriation exist in active duriation of greeting");
			} else
				AdvanceReporting.addLogs("fail", "call duriation does not exist in active duriation of greeting");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "call duriation does not exist in active duriation of greeting");
		}
		return this;
	}

	// To verify active greeting has play button
	public SettingsPage verifyActiveGreetingPlayOptn() {
		try {
			if (Utils.uBase.imageCompare("activePlayButtonWithEdit")) {
				AdvanceReporting.addLogs("pass", "Verified that play button exist in active greeting");
			} else if (Utils.uBase.imageCompare("activePlayBtnDefault")) {
				AdvanceReporting.addLogs("pass", "Verified that play button exist in active default greeting");
			} else
				AdvanceReporting.addLogs("fail", "play button does not exist in default greeting");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "play button does not exist in default greeting");
		}
		return this;
	}

	// To verify greeting Name In Other Section
	public SettingsPage verifyGreetingNameAndDuration() {
		try {
			int length = greetingNameInOtherSection.size();
			AdvanceReporting.addLogs("pass", "Greeting has following names and durations:");
			for (int i = 0; i < length; i++) {
				if (greetingNameInOtherSection.get(i).getText() != null
						&& greetingDuriationInOtherSection.get(i).getText() != null) {
					AdvanceReporting.addLogs("info", "Verified that" + greetingNameInOtherSection.get(i).getText()
							+ " has duration " + greetingDuriationInOtherSection.get(i).getText());
				} else
					AdvanceReporting.addLogs("fail", "Greeting does not have any name");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Greeting does not have any name");
		}
		return this;
	}

	// To verify greeting play option in other section
	public SettingsPage verifyGreetingPlayOptnInOtherSection() {
		try {
			int length = playBtnInOtherSection.size();
			for (int i = 0; i < length; i++) {
				Assert.assertTrue(playBtnInOtherSection.get(i).isDisplayed(), "Greeting does not have play button");
			}
			AdvanceReporting.addLogs("pass", "Verified that Greeting have play button");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Greeting does not have play button");
		}
		return this;
	}

	// To verify google voice default is present in list
	public SettingsPage verifyGoogleVoiceDefaultIsPresent() {
		try {
			int length = greetingNameInOtherSection.size();
			for (int i = 0; i < length; i++) {
				if (greetingNameInOtherSection.get(i).getText().contains("Google Voice default")
						|| activeUserName.getText().contains("Google Voice default")) {
					AdvanceReporting.addLogs("pass", "Verified that google voice Default is present");
					break;
				} else
					AdvanceReporting.addLogs("fail", "google voice Default is not present");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "google voice Default is not present");
		}
		return this;
	}

	// To verify google voice can not be removed from list
	public SettingsPage verifyGoogleVoiceDefault() {
		try {
			Utils.uBase.clickWebelement(threeDotOptionVoiceDefault);
			if (Utils.uBase.imageCompare("deleteOptnGreeting")) {
				AdvanceReporting.addLogs("fail", "google voice default can not have delete option");
			} else {
				AdvanceReporting.addLogs("pass", "Verified that google voice default can not be deleted");
				AdvanceReporting.addLogs("pass", "google voice default can not be deleted",
						"google voice default can not be deleted");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "google voice default can not have delete option");
		}
		return this;
	}

	// To close the popup alert
	public SettingsPage closePopUp() {
		try {
			Utils.uBase.clickByImage("closePopUp");
			AdvanceReporting.addLogs("pass", "popup is closed");
			AdvanceReporting.addLogs("pass", "popup is closed", "popup is closed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "popup is not closed");
		}
		return this;
	}

	// to add new greeting into the list
	public SettingsPage addingGreetings() throws Exception {
		try {
			SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
			if ((Utils.uBase.isElementPresent_webelement(maxGreetingAlert)==false)) {
				//Utils.uBase.clickByImage("recordGreetingOptn");
				Utils.uBase.waitForElementToBeClickable(recordGreeting);
				Utils.uBase.clickWebelement(recordGreeting);
				AdvanceReporting.addLogs("pass", "clicked on record greeting");
				Utils.uBase.clickOnNotificationAllowBtn();
				Utils.uBase.clickByImage("recordIcon");
				Thread.sleep(3000);
				//Utils.uBase.clickByImage("stopIcon");
				Utils.uBase.clickWebelement(stopRcd);
				Utils.uBase.clickByImage("saveOptnGreeting");
				Thread.sleep(1000);
				Utils.uBase.clickByImage("saveOptnGreeting");
				Thread.sleep(25000);
				//AdvanceReporting.addLogs("pass", "greeting added");
				Utils.uBase.refresh();
				settPage.clickVoiceMailInSettings();
			} else {
				AdvanceReporting.addLogs("pass", "only 10 greetings can be saved");
				AdvanceReporting.addLogs("pass", "only 10 greetings can be saved", "only 10 greetings can be saved");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "greeting is not added");
			AdvanceReporting.addLogs("fail", "greeting is not added", "greeting is not added");
		}
		return this;
	}

	// to add maximum greetings into the list
	public SettingsPage totalGreetingsInList() {
		try {
			int greetingLength = greetingNameInOtherSection.size() + 1;
			int requiredGreetingLength = Constants.maxGreetingSizeInList - greetingLength;
			if (requiredGreetingLength != 0) {
				//Utils.uBase.clickOnNotificationAllowBtn();
				for (int i = 0; i < requiredGreetingLength; i++) {
					addingGreetings();
				}
				AdvanceReporting.addLogs("pass", "New greetings added successfully");
				AdvanceReporting.addLogs("pass", "record greeting option is disabled");
			} else {
				/*
				 * if(Utils.uBase.imageCompare("recordGreetingOptn")==false) {
				 * AdvanceReporting.addLogs("info",
				 * "Verified:Record greeting optn is not enabled");
				 */
				AdvanceReporting.addLogs("pass", "Verified:Maximum greeting count reached");
				AdvanceReporting.addLogs("pass", "Maximum greeting count reached", "Maximum greeting count reached");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "greeting not saved");
		}
		return this;
	}

	// To remove greetings in others list
	public SettingsPage clearGreetingsInOtherSection() {
		try {
			if (greetingNameInOtherSection.size() <= 3) {
				AdvanceReporting.addLogs("pass", "greetings can be added");
			} else {
				for (int i = 0; i < greetingNameInOtherSection.size() - 3; i++) {
					Utils.uBase.clickWebelement(threeDotSecondGreeting);
					Utils.uBase.clickByImage("deleteOptnGreeting");
					Thread.sleep(500);
					Utils.uBase.clickByImage("deleteConfirmGreeting");
					Thread.sleep(2000);
					clickOnManageGreeting();
				}
				// closePopUp();
				// clickOnManageGreeting();
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "can not be deleted");
		}
		return this;
	}

	// Calls Email forward toggle On
	public SettingsPage callsEmailFwdToggleActions(String switchStatus) {
		try {
			if (switchStatus.equalsIgnoreCase("on")) {
				if (callsEmailFwdToggle.getAttribute("aria-checked").equalsIgnoreCase("true")) {
					AdvanceReporting.addLogs("pass", "Calls Email forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Calls Email forwarding toggle is ON", "CallsToggleOn");
				} else {
					Utils.uBase.clickWebelement(callsEmailFwdToggle);
					AdvanceReporting.addLogs("pass", "Calls Email forwarding toggle is ON");
					AdvanceReporting.addLogs("pass", "Calls Email forwarding toggle is ON", "CallsToggleOn");
				}
			}

			if (switchStatus.equalsIgnoreCase("off")) {
				if (callsEmailFwdToggle.getAttribute("aria-checked").equalsIgnoreCase("false")) {
					AdvanceReporting.addLogs("pass", "Calls Email forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Calls Email forwarding toggle is OFF", "CallsToggleOff");
				} else {
					Utils.uBase.clickWebelement(callsEmailFwdToggle);
					AdvanceReporting.addLogs("pass", "Calls Email forwarding toggle is OFF");
					AdvanceReporting.addLogs("pass", "Calls Email forwarding toggle is OFF", "CallsToggleOff");
				}
			}

		} catch (Exception e) {

			AdvanceReporting.addLogs("fail", "Calls forward toggle action failed");
		}
		return this;
	}

	public SettingsPage verifyElementsDisplayed() {
		try {
			Point p;
			Utils.uBase.scrolltoElement(btnNewLinkedNo);
			if (lstLinkedNumbers.size() != 0) {
				AdvanceReporting.addLogs("Pass", "Linked number is available");
				AdvanceReporting.addLogs("Pass", "Linked number is  available", "LinkedNo");
				Thread.sleep(2000);
			}

			else {

				if (lstLinkedNumbers.size() == 0) {
					AdvanceReporting.addLogs("fail", "Linked number is not available");
					AdvanceReporting.addLogs("fail", "Linked number is not available", "LinkedNo");
				}
			}

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Linked number is not available");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage linkAnotherMobileIfNotAlreadyLinked(String phoneNum, String SM_DUT) {
		try {

			if (lstLinkedNumbers.size() != 0) {

				clickNewLinkedNumber();
				enterMobileNoToBeLinked(phoneNum);
				clickSendBtnLinkedNoDialog();
				Utils.uBase.setupMDriver(1, Constants.SAMSUNGGalaxyS8Plus_SM_DUT1, Constants.MESSAGE_APP_PACKAGE_NAME,
						Constants.MESSAGE_APP_ACTIVITY);
				Thread.sleep(3000);

				MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
				msgMobPage.clickOnMessageWithText().getCodeFromMessage();
				enterVerificationCode();
			}

			else {
				AdvanceReporting.addLogs("info", "Mobile is already having a linked number");
				System.out.println("Mobile is already having a linked number");
			}
		} catch (Exception e) {

			AdvanceReporting.addLogs("fail", "Linking number to GV account failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// To verify spam filter toggle is turned on
	public SettingsPage verifySpamFilterToggleOn() {
		try {
			Thread.sleep(2000);
			if (Utils.uBase.imageCompare("tuggleTurnOn")) {
				AdvanceReporting.addLogs("pass", "spam filter toggle is On now", "spamFilterToggleOn");
			} else {
				AdvanceReporting.addLogs("fail", "spam filter is off only", "spamFilterToggleOff");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "spam filter is off only");
		}
		return this;
	}

	// To verify spam filter toggle is disabled
	public SettingsPage verifyspamFilterToggleOff() {
		try {
			Thread.sleep(2000);
			if (Utils.uBase.imageCompare("turnOffToggle")) {
				AdvanceReporting.addLogs("pass", "spam filter toggle is off now", "turnToggleOff");
			} else {
				AdvanceReporting.addLogs("pass", "spam filter is on only", "turnToggleOn");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "spam filter is on only");
		}
		return this;
	}

	// To get gv number from active account
	public SettingsPage getGvNum() {
		try {
			gvNum1 = gvNumb.getText().replaceAll("\\W", "");
			AdvanceReporting.addLogs("pass", "gv number in settings page:" + gvNum1);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "no such element");
		}
		return this;

	}

	// To verify voicemail toggle is enabled
	public SettingsPage clickXIcon() {
		try {
			Utils.uBase.clickByImage("xIcon");
			AdvanceReporting.addLogs("pass", "Clicked on del icon");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Clicked on del icon :" + e.getMessage());
		}
		return this;
	}

	/* Turn on the spam filter toggle */
	public SettingsPage spamFilterToggleOn() {
		try {
			Thread.sleep(2000);
			Utils.uBase.waitForElement(spamFilterToggle);
			if (spamFilterToggle.getAttribute("class").contains("checked")) {
				Thread.sleep(2000);
				AdvanceReporting.addLogs("pass", "Spam filter toggle is switched on");
				AdvanceReporting.addLogs("pass", "Spam filter toggle is switched on", "Spam filter toggle switched on");
			} else {
				Utils.uBase.clickWebelement(spamFilterToggle);
				AdvanceReporting.addLogs("pass", "Spam filter toggle switch is already on");
				AdvanceReporting.addLogs("pass", "Spam filter toggle switch already on",
						"Spam filter toggle switch already on");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "spam filter toggle is not enabled");
		}
		return this;
	}

	/* Turn off the spam filter toggle */
	public SettingsPage spamFilterToggleOff() {
		try {
			Thread.sleep(2000);
			Utils.uBase.focusWebelement(spamFilterToggle);
			if (spamFilterToggle.getAttribute("class").contains("checked")) {
				Thread.sleep(1000);
				Utils.uBase.clickWebelement(spamFilterToggle);
				AdvanceReporting.addLogs("info", "SpamFilter Toggle is Disabled");
				AdvanceReporting.addLogs("pass", "SpamFilterToggle is Disabled", "SpamFilterToggleDisabled");
			} else {
				AdvanceReporting.addLogs("info", "Already spamFilter Toggle is Disabled");
				AdvanceReporting.addLogs("pass", "Already spamFilterToggle is Disabled", "AlreadyspamFilterToggleDisabled");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "spamFilter Toggle is not enabled");
		}
		return this;
	}

	// Verify that, confirmation pop-up screen messages
	public SettingsPage verifyConfirmationPopup() {
		try {
			Thread.sleep(2000);
			Utils.uBase.imageCompare("removeLinkNumPopup");
			AdvanceReporting.addLogs("info", "remove Link Number Popup appeared");
			AdvanceReporting.addLogs("pass", "remove Link Number Popup appeared", "removeLinkNumPopup");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "remove Link Number Popup not appeared");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// Verify that, confirmation pop-up screen messages
	public SettingsPage verifyRemoveLnkdNumScreenMsgs() {
		try {
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("removeLnkdNumScreenMsg"),
					" Screen message to remove linked number not present");
			AdvanceReporting.addLogs("Pass", "Remove linked number screen message is present");
			AdvanceReporting.addLogs("Pass", "screen message is present", "screen message is present");
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("ScreenMsgRmvLnkdNum"),
					" Screen message to remove linked number not present");
			AdvanceReporting.addLogs("Pass", "'You'll no longer be able to ' screen message is present");
			AdvanceReporting.addLogs("Pass", "screen message is present", "screen message is present");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Linked Number not removed");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// To click New Linked Number Btn
	public SettingsPage clickRemoveButton() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("RemoveButton");
			AdvanceReporting.addLogs("pass", "Remove Button is clicked");
			AdvanceReporting.addLogs("pass", "Remove Button clicked", "dropdownButton");
			Thread.sleep(2000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Remove Button not clicked");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// Verified Personal contacts
	public SettingsPage verifyPersonalContacts() {
		try {
			Thread.sleep(2000);
			for (int i = 0; i < savedContacts.size(); i++) {
				if (savedContacts.size() <= 10) {
					AdvanceReporting.addLogs("pass",
							"Verified that user able to see the first 10 entries from personal contacts");
					AdvanceReporting.addLogs("pass", "User able to see the first 10 entries from personal contacts",
							"personalContacts");
					break;
				} else {
					AdvanceReporting.addLogs("fail",
							"User not able to see the first 10 entries from personal contacts");
					AdvanceReporting.addLogs("fail", "User not able to see the first 10 entries from personal contacts",
							"personalContacts");
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "no contacts from personal is displayed");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	/* Verified Personal contacts */
	public SettingsPage verifyCorpDirectoryContacts() {
		try {
			Thread.sleep(2000);
			int sizeOfunsavedContacts = unsavedContacts.size();
			for (int i = 0; i <= sizeOfunsavedContacts - 1; i++) {
				if (unsavedContacts.size() == sizeOfunsavedContacts) {
					AdvanceReporting.addLogs("info",
							"Verified that user able to see next set of entries from corporate directory");
					AdvanceReporting.addLogs("pass", "User able to see next set of entries from corporate directory",
							"unsavedContacts");
					break;
				} else {
					AdvanceReporting.addLogs("fail",
							"User not able to see next set of entries from corporate directory");
					AdvanceReporting.addLogs("fail",
							"User not able to see next set of entries from corporate directory", "unsavedContacts");
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "no contacts from personal is displayed");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// Verify contacts separated by a label 'Directory' (for dierctory contacts)
	public SettingsPage verifyCorpDirectorySeperation() {
		try {
			Thread.sleep(2000);
			Utils.uBase.scrolltoElement(directorySection);
			Thread.sleep(2000);
			Utils.uBase.imageCompare("directoryImg");
			AdvanceReporting.addLogs("pass", "Verified that directory Section is displayed");
			AdvanceReporting.addLogs("pass", "Directory Section is displayed", "Directory Section");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Directory Section is not displayed");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// Click cross button
	public SettingsPage clickLinkedNumberCrossBtn() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("linkedNumberCrossBtn");
			AdvanceReporting.addLogs("info", "Linked Number Cross icon is clicked");
			AdvanceReporting.addLogs("pass", "Linked Number Cross icon is clicked", "linkedNumberRemoved");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Linked Number Cross icon is not clicked");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// verify linked number is not available
	public SettingsPage verifyContactNumberIsNotDisplayed() {
		try {

			Thread.sleep(3000);
			Assert.assertFalse(Utils.uBase.isElementPresent_webelement(samsungGalaxyNum_2),
					"Respective phone number-name has not been removed from the 'Linked numbers' section.");
			AdvanceReporting.addLogs("pass", "Able to reclaim the same number in the third account");
			AdvanceReporting.addLogs("pass", "Able to reclaim the same number in the third account", "ClaimOptn");
			if (Utils.uBase.imageCompare("linkdNumInList") == false) {
				AdvanceReporting.addLogs("Pass",
						"Verified that respective phone number-name has been removed from 'Linked numbers' section");
				AdvanceReporting.addLogs("Pass", "Linked number has been removed", "Linked number has been removed");
				Thread.sleep(2000);
			} else {
				AdvanceReporting.addLogs("fail", "Linked number is  available");
				AdvanceReporting.addLogs("fail", "Linked number is  available", "LinkedNo");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Verification for display of contact number failed");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	// To verify if the Messages section is available on Settings page or not
	public SettingsPage verifyMessagesInSettings() {
		try {
			Thread.sleep(3000);
			if (Utils.uBase.imageCompare("Messages")) {
				AdvanceReporting.addLogs("fail", "Messages section is present in the Settings page");
				AdvanceReporting.addLogs("fail", "Messages section is present", "Messages section is present");
			} else {
				AdvanceReporting.addLogs("pass", "Verified that messages section is not present in the Settings page");
				AdvanceReporting.addLogs("pass", "Messages section is not present", "Messages section is not present");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// To verify "Do not disturb is on text" on DND banner
	public SettingsPage dndIsOnText() {
		try {
			Thread.sleep(3000);
			String dndBnnerTxt = dndBannerText.getText();
			if ((dndBnnerTxt).contains("Do not disturb is on")) {
				if ((dndBnnerTxt).contains("You're outside your working hours")) {
					AdvanceReporting.addLogs("pass", "Banner text is present : " + dndBannerText.getText());
					AdvanceReporting.addLogs("pass", "Banner text is present", "Banner text is present");
				}
			} else {
				AdvanceReporting.addLogs("fail", "Banner text is not present ");
				AdvanceReporting.addLogs("fail", "Banner text is not present", "Banner text is not present");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// To verify End now button on DND banner
	public SettingsPage verifyEndNowDND() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(Utils.uBase.imageCompare("EndNow"), "End now button is not present on DND banner");
			AdvanceReporting.addLogs("pass", "End now button is present on DND banner");
			AdvanceReporting.addLogs("pass", "End now button is present", "End now button is present");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// To verify Settings button on DND banner
	public SettingsPage verifySettingsDND() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(Utils.uBase.imageCompare("dndSettings"), "Settings button is not present on DND banner");
			AdvanceReporting.addLogs("pass", "Verified that settings button is present on DND banner");
			AdvanceReporting.addLogs("pass", "Settings button is present", "Settings button is present");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/* To click Calendar settings in DND section on Settings page */
	public SettingsPage clickCalendarSettings() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("calendarSettings");
			AdvanceReporting.addLogs("pass", "Clicked on Calendar settings option in DND section");
			AdvanceReporting.addLogs("pass", "Clicked on Calendar settings", "Clicked on Calendar settings");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	/* To switch the toggle on for Follow working hours below DND section */
	public SettingsPage selectFollowWorkingHoursToogle() {
		try {
			Utils.uBase.waitForElement(fllwWorkingHrsToggle);
			Utils.uBase.scrolltoElement(fllwWorkingHrsToggle);
			Utils.uBase.clickWebelement(fllwWorkingHrsToggle);
			AdvanceReporting.addLogs("pass", "Follow working hours toggle is clicked");
			AdvanceReporting.addLogs("pass", "Toggle is switched on", "Toggle is clicked");
			Thread.sleep(2000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	/* To switch the toggle on for Follow out of office below DND section */
	public SettingsPage selectFollowOfOfficeToogle() {
		try {
			Utils.uBase.waitForElement(followOutOfOffice);
			Utils.uBase.scrolltoElement(followOutOfOffice);
			Utils.uBase.clickWebelement(followOutOfOffice);
			AdvanceReporting.addLogs("pass", "Follow out of office toggle is clicked");
			AdvanceReporting.addLogs("pass", "Toggle is switched on", "Toggle is clicked");
			Thread.sleep(2000);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}

	public SettingsPage linkMobileIfNotAlreadyLinkedToAnotherAccnt(String phoneNum, String SM_DUT) {
		try {

			if (lstLinkedNumbers.size() == 0) {

				clickNewLinkedNumber();
				enterMobileNoToBeLinked(phoneNum);
				clickSendBtnLinkedNoDialog();
				// Utils.uBase.setupMDriver(Constants.SAMSUNGGalaxyS8Plus_SM_DUT1);
				Thread.sleep(3000);

				MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
				msgMobPage.clickOnMessageWithText().getCodeFromMessage();
				enterVerificationCode();
			}

			else {
				AdvanceReporting.addLogs("info", "Mobile is already having a linked number");
				System.out.println("Mobile is already having a linked number");
			}
		} catch (Exception e) {

			AdvanceReporting.addLogs("fail", "Linking number to GV account failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage verifyClaimLinkedNumberPopUp() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(Utils.uBase.imageCompare("claimOptn"), "Claim option is not displayed");
			AdvanceReporting.addLogs("pass", "Claim option is displayed");
			AdvanceReporting.addLogs("pass", "Claim option is displayed", "ClaimOptn");
		}

		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage removeGVLinkedNum() {

		try {
			Utils.uBase.scrolltoElement(msgHeadlineSttng);
			Thread.sleep(1500);
			Utils.uBase.clickByImage("crossLinkedNum");
			AdvanceReporting.addLogs("pass", "Clicked on X to remove linked number successfully");
			AdvanceReporting.addLogs("pass", "Clicked on X to remove", "Clicked on X to remove");
			Thread.sleep(1500);
			Utils.uBase.clickByImage("rmvLnkdNumRemoveBtn");
			Thread.sleep(1000);
			AdvanceReporting.addLogs("pass", "Removed linked number");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage enterOTPForLinkNum() {
		try {
			if (Utils.uBase.imageCompare("phoneNumberAlreadyAdded") == true) {
				Utils.uBase.clickByImage("finishBtn");
			} else {
				Thread.sleep(3000);
				MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
				msgMobPage.clickOnMessageWithText().getCodeFromMessage();
				Utils.uBase.setText(inputVerificationBox, MessagePageAndroid.code);
				Thread.sleep(1000);
				AdvanceReporting.addLogs("info", "Code entered in input verification box");
				AdvanceReporting.addLogs("info", "Code entered in input verification box", "CodeEntered");
				Thread.sleep(3000);
				Utils.uBase.clickByImage("verifyButtonVerificationDialog");
				Thread.sleep(4000);
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Linking number to GV account failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage deleteLnkdNum() {
		try {

			if ((Utils.uBase.isElementPresent_webelement(samsungGalaxyNum_2) == false)) {
				clickNewLinkedNumber().enterMobileNoToBeLinked(Constants.SAMSUNGGalaxyNote9_Numb2)
						.clickSendBtnLinkedNoDialog();
				Thread.sleep(3000);
				Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyNote9_SM_DUT1, Constants.MESSAGE_APP_PACKAGE_NAME2,
						Constants.MESSAGE_APP_ACTIVITY2);
				MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
				msgMobPage.clickOnMessageWithText().getCodeFromMessage();
				enterVerificationCode().clickVerifyLnkdNum();
				Thread.sleep(2000);
				Utils.uBase.clickByImage("finishBtn");
				Thread.sleep(3000);
				Utils.uBase.clickWebelement(samsungGalaxyNum_2);
				AdvanceReporting.addLogs("pass", "Click on 'X' button to remove the forwarding phone number");
				AdvanceReporting.addLogs("pass", "Clicked on remove button", "deleteNumber");
			} else {
				Thread.sleep(3000);
				Utils.uBase.clickWebelement(samsungGalaxyNum_2);
				AdvanceReporting.addLogs("pass", "Click on 'X' button to remove the forwarding phone number");
				AdvanceReporting.addLogs("pass", "Clicked on remove button", "deleteNumber");
			}

			if ((Utils.uBase.isElementPresent_webelement(samsungGalaxyNum_2) == false)) {
				clickNewLinkedNumber().enterMobileNoToBeLinked(Constants.SAMSUNGGalaxyNote9_Numb2)
						.clickSendBtnLinkedNoDialog();
				Thread.sleep(3000);
				Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyNote9_SM_DUT1, Constants.MESSAGE_APP_PACKAGE_NAME2,
						Constants.MESSAGE_APP_ACTIVITY2);
				MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
				msgMobPage.clickOnMessageWithText().getCodeFromMessage();
				enterVerificationCode().clickVerifyLnkdNum();
				Thread.sleep(2000);
				Utils.uBase.clickByImage("finishBtn");

			} else {
				Thread.sleep(3000);
				Utils.uBase.clickWebelement(samsungGalaxyNum_2);
				verifyRemoveLnkdNumScreenMsgs().clickRemoveButton().verifyContactNumberIsNotDisplayed();
				AdvanceReporting.addLogs("pass",
						"Verified that, confirmation pop-up screen messages 'Delete this linked number' and 'Phone number-name will no longer receive calls and messages from your Google Voice number'");
				AdvanceReporting.addLogs("pass", "Deleted the linked number", "Deleted the linked number");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Deleting number linked with GV account failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickCrossLnkdNum() {

		try {
			Utils.uBase.scrolltoElement(msgHeadlineSttng);
			Thread.sleep(1500);
			Utils.uBase.clickByImage("crossLinkedNum");
			AdvanceReporting.addLogs("pass", "Clicked on X to remove linked number successfully");
			AdvanceReporting.addLogs("pass", "Clicked on X to remove", "Clicked on X to remove");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickRemoveBtnInWindow() {

		try {
			Thread.sleep(1500);
			Utils.uBase.clickByImage("rmvLnkdNumRemoveBtn");
			Thread.sleep(1000);
			AdvanceReporting.addLogs("pass", "Removed linked number");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/* Go to browser settings */
	public SettingsPage navigate_ChromeBrowserSettings() {
		try {
			Thread.sleep(3000);
			if (Utils.uBase.imageCompare("notificationPopup")) {
				Thread.sleep(3000);
				Utils.uBase.clickByImage("closeNotification");
			}
			Thread.sleep(6000);
			Utils.uBase.clickByImage("browserThreeDots");
			Thread.sleep(5000);
			if (Utils.uBase.imageCompare("browserSettings")) {
				Thread.sleep(1000);
				Utils.uBase.clickByImage("browserSettings");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Calls Tab is not selectd");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/* Scroll down to notification settings */
	public SettingsPage navigate_ChromeBrowserNotificationSettings() {
		try {
			for (int i = 1; i <= 40; i++) {
				Thread.sleep(500);
				Utils.uBase.clickByImage("scrollDownBrowser");
				Thread.sleep(500);
				if (Utils.uBase.imageCompare("advancedBrowser")) {
					Thread.sleep(1000);
					Utils.uBase.clickByImage("advancedBrowser");
					Thread.sleep(500);
					Utils.uBase.clickByImage("scrollDownBrowser");
					Thread.sleep(1000);
				}
				if (Utils.uBase.imageCompare("contentSettings")) {
					Thread.sleep(1000);
					Utils.uBase.clickByImage("contentSettings");
					Thread.sleep(1000);
					Utils.uBase.clickByImage("noticationSelection");
					AdvanceReporting.addLogs("pass", "Notication Selection is selectd");
					break;
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Notication Selection is not selectd");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	/* Go to google voice application */
	public SettingsPage navigateToGoogleVoiceApp() {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("goToGoogleVoiceWindow");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Google voice tab not selected");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage desktopNotifications_ChromeSettingsPage(String enableOrDisable) {
		try {

			if (enableOrDisable.equalsIgnoreCase("enable")) {
				Utils.uBase.refresh();
				Thread.sleep(2000);
				Utils.uBase.clickOnNotificationAllowBtn();
				AdvanceReporting.addLogs("info", "Clicked on allow button in pop up");
				navigateToGoogleVoiceApp();
			}
			if (enableOrDisable.equalsIgnoreCase("disable")) {

				Thread.sleep(1000);
				if (Utils.uBase.imageCompare("googleVoiceUrl")) {
					Thread.sleep(1500);
					Utils.uBase.clickByImage("ThreeDotmenu_ChromeSettings");
					AdvanceReporting.addLogs("info", "Three dot menu is clicked");
					Utils.uBase.clickByImage("removeGoogleVoiceUrl");
					AdvanceReporting.addLogs("info", "Google voice url is removed");
				} else if (Utils.uBase.imageCompare("googleVoiceUrlwitout443")) {
					Thread.sleep(1500);
					Utils.uBase.clickByImage("browserThreeDotsOne");
					Thread.sleep(1000);
					Utils.uBase.clickByImage("removeGoogleVoiceUrl");
					AdvanceReporting.addLogs("info", "Google voice url is removed");
					AdvanceReporting.addLogs("pass", "More option is selectd");
					Thread.sleep(1000);
				} else if (Utils.uBase.imageCompare("googleVoiceUrlwitout443")
						| Utils.uBase.imageCompare("googleVoiceUrl") == false) {
					AdvanceReporting.addLogs("pass", "Google voice Url is not present");

				} else {
					AdvanceReporting.addLogs("fail", "Page is not present");

				}
				navigateToGoogleVoiceApp();
			}

		} catch (Exception s) {
			AdvanceReporting.addLogs("fail", "Error Message: " + s.getMessage());
			s.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage clickWebNotificationsInSettings() {
		try {
			Utils.uBase.clickByImage("Seetings_WebNotifications");
			AdvanceReporting.addLogs("pass", "Web notifications option clicked in settings page");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Web notifications is not clicked");
		}
		return this;
	}

	public SettingsPage verifyWebNotificationStatus(boolean res) {
		try {
			if (res == true) {
				Thread.sleep(2000);
				Assert.assertTrue(Utils.uBase.imageCompare("Settings_WebNotificationsOn"));
				AdvanceReporting.addLogs("pass", "Web notifications is turned on");
			} else {
				Assert.assertTrue(Utils.uBase.imageCompare("Seetings_WebNotificationsOFF"));
				AdvanceReporting.addLogs("pass", "Web notifications is off");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Web notifications comparision failed ");
		}
		return this;
	}

	public SettingsPage addNewLnkdNum() {
		try {
			if (Utils.uBase.imageCompare("phoneNumberAlreadyAdded") == true) {
				Utils.uBase.clickByImage("finishBtn");
				Utils.uBase.waitForElement(samsungGalaxyNum_2);
				Utils.uBase.clickWebelement(samsungGalaxyNum_2);
				clickRemoveButton();
				Thread.sleep(2000);
				clickNewLinkedNumber();
				enterMobileNoToBeLinked(Constants.SAMSUNGGalaxyNote9_Numb2);
				clickSendBtnLinkedNoDialog();
				Thread.sleep(3000);
				// Initializing mobile driver
				Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9_SM_DUT1, Constants.MESSAGE_APP_PACKAGE_NAME2,
						Constants.MESSAGE_APP_ACTIVITY2);
				MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
				msgMobPage.clickOnMessageWithText().getCodeFromMessage();
				enterVerificationCode().clickVerifyLnkdNum();
				if (Utils.uBase.mDriver != null) {
					Utils.uBase.mDriver.quit();
				}
			} else {
				Thread.sleep(3000);
				Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9_SM_DUT1, Constants.MESSAGE_APP_PACKAGE_NAME2,
						Constants.MESSAGE_APP_ACTIVITY2);
				MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
				msgMobPage.clickOnMessageWithText().getCodeFromMessage();
				enterVerificationCode().clickVerifyLnkdNum();
				if (Utils.uBase.mDriver != null) {
					Utils.uBase.mDriver.quit();
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Linking number to GV account failed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage verifyGVPhoneNumAlreadyAdded(int bellevue, String deviceId, String appPackage,
			String appActivity) {
		try {
			if ((Utils.uBase.isElementPresent_webelement(samsungGalaxyNum_1) == false)) {
				clickNewLinkedNumber().enterMobileNoToBeLinked(Constants.SAMSUNGGalaxyNote9plus_Numb1)
						.clickSendBtnLinkedNoDialog().addLnkdNum(bellevue, deviceId, appPackage, appActivity);
				Utils.uBase.refresh();
				Utils.uBase.checkPageReady();
				Thread.sleep(2000);
			} else {
				AdvanceReporting.addLogs("pass", "GV account already have one forwarding phone");
				AdvanceReporting.addLogs("pass", "Already one forwarding phone", "Already one forwarding phone");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Pre condition could not be fulfilled");
		}
		return this;
	}

	// Verified doNotDisturb toggle is present
	public SettingsPage verifyDoNotDisturbToogle() {
		try {
			Utils.uBase.waitForElement(toogleDoNotDisturb); // This will also verify the presence of toggle
			AdvanceReporting.addLogs("pass", "Verified that Do Not disturb toggle is displayed", "doNotDisturbToggle");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Do Not disturb toggle is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// Verified follow working hours toggle is present in wolverine account
	public SettingsPage verifyFollowWorkingHoursToogle() {
		try {
			Utils.uBase.waitForElement(toogleDoNotDisturbOutsideOfWorkingHours); // This will also verify the presence
																					// of toggle
			AdvanceReporting.addLogs("pass", "Verified that follow working hours toggle is displayed",
					"followWorkingHoursToggle");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Follow working hours toggle is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	// Verified out of office toggle is present in wolverine account
	public SettingsPage verifyFollowOutOfOfficeWorkingHoursToogle() {
		try {
			Utils.uBase.waitForElement(toogleDoNotDisturbWhenOutOfOffice); // This will also verify the presence of
																			// toggle
			AdvanceReporting.addLogs("pass", "Verified that follow Out Of Office toggle is displayed",
					"followOutOfOfficeToggle");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Follow Out Of Office toggle is not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage verifyGVPhoneNumAlreadyAdded_1() {
		try {
			if (((Utils.uBase.isElementPresent_webelement(samsungGalaxyNum_2)) == false)) {
				clickNewLinkedNumber().enterMobileNoToBeLinked(Constants.SAMSUNGGalaxyNote9_Numb2)
						.clickSendBtnLinkedNoDialog().addNewLnkdNum();
				AdvanceReporting.addLogs("pass", "Verified that, same number can be linked to 2 different accounts");
				AdvanceReporting.addLogs("pass", "linked to 2 different accounts", "linked to 2 different accounts");
			} else {
				AdvanceReporting.addLogs("pass", "Number linked in this account");
				AdvanceReporting.addLogs("pass", "Linked in the first account", "Linked in the first account");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Pre condition could not be fulfilled");
		}
		return this;
	}

	public SettingsPage verifyGVPhoneNumAlreadyAdded_2() {
		try {
			if (((Utils.uBase.isElementPresent_webelement(samsungGalaxyNum_2)) == false)) {
				clickNewLinkedNumber().enterMobileNoToBeLinked(Constants.SAMSUNGGalaxyNote9_Numb2)
						.clickSendBtnLinkedNoDialog();
				Thread.sleep(3000);
				Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9_SM_DUT1, Constants.MESSAGE_APP_PACKAGE_NAME2,
						Constants.MESSAGE_APP_ACTIVITY2);
				MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
				msgMobPage.clickOnMessageWithText().getCodeFromMessage();
				enterVerificationCode().clickVerifyTabLnkdNum();
			} else {
				AdvanceReporting.addLogs("pass", "Number linked in this account");
				AdvanceReporting.addLogs("pass", "Linked in the first account", "Linked in the first account");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Pre condition could not be fulfilled");
		}
		return this;
	}

	public SettingsPage verifyClaimedLinkedNumber() {
		try {
			if (((Utils.uBase.isElementPresent_webelement(samsungGalaxyNum_2)) == true)) {
				AdvanceReporting.addLogs("pass",
						"Verified that if you add the same number with 3rd account it shows warning message that 'Phone number' already linked and is succsessfully able to reclaim.");
				AdvanceReporting.addLogs("pass", "Able to reclaim the same number in the third account", "ClaimOptn");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail",
					"Not able to reclaim the same number in the third account : " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
		return this;
	}

	public SettingsPage deleteSamsungGalaxyNum_2() {
		try {
			Utils.uBase.waitForElement(samsungGalaxyNum_2);
			Utils.uBase.clickWebelement(samsungGalaxyNum_2);
			AdvanceReporting.addLogs("pass", "Clicked on 'X' button to remove the forwarding phone number");
			AdvanceReporting.addLogs("pass", "Clicked on X button", "ClickedonXbutton");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Pre condition could not be fulfilled");
		}
		return this;
	}

	public SettingsPage clickClaimLnkdNum() {
		try {
			if (Utils.uBase.imageCompare("claimOptn") == true) {
				Utils.uBase.clickByImage("claimOptn");
				AdvanceReporting.addLogs("pass", "Clicked on claim option successfully");
				AdvanceReporting.addLogs("pass", "Clicked on claim option", "Clicked on claim option");

			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Could not click on claim option");
		}
		return this;
	}

	public SettingsPage clickFinishTabLnkdNum() {
		try {
			Thread.sleep(3000);
			Utils.uBase.clickByImage("finishTab");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Clicked on finish button successfully");
			AdvanceReporting.addLogs("pass", "Clicked on finish button", "Clicked on finish button");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Could not click on claim option");
		}
		return this;
	}

	public SettingsPage clickVerifyTabLnkdNum() {
		try {
			Thread.sleep(3000);
			Utils.uBase.clickByImage("verifyButtonVerificationDialog");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Clicked on Verify tab successfully");
			AdvanceReporting.addLogs("pass", "Clicked on finish button", "Clicked on finish button");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Could not click on claim option");
		}
		return this;
	}

	public SettingsPage comparePrivacyTerms() {
		try {
			Thread.sleep(1000);
			if (Utils.uBase.imageCompare("comparePrivacyTerms") == true) {
				Thread.sleep(2000);
				AdvanceReporting.addLogs("pass", "Verified that privacy and Terms are displayed");
			} else
				AdvanceReporting.addLogs("fail", "privacy and Terms are not displayed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Could not click on claim option");
		}
		return this;
	}

	public SettingsPage verifyEditOptnInLinkedNum() {
		try {
			if (Utils.uBase.imageCompare("NoEditIcon") == true) {
				AdvanceReporting.addLogs("pass", "Verified that linked numbers section does not have any edit option");
			} else
				AdvanceReporting.addLogs("fail", "linked numbers section have edit option");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "linked numbers section have edit option");
		}
		return this;
	}

	public SettingsPage verifyNavigatedToSettings() {
		try {
			Thread.sleep(2000);
			if (Utils.uBase.getCurrentUrl().contains("settings")) {
				AdvanceReporting.addLogs("pass", "Verified that navigated to settings page");
			} else
				AdvanceReporting.addLogs("fail", "Settings navigation failed");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Settings navigation failed");
		}
		return this;
	}

}
