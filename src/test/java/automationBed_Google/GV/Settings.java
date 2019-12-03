package automationBed_Google.GV;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.CallsPageAndroid;
import automationBed_Google.pom.gv.DesktopNotificationPage;
import automationBed_Google.pom.gv.CallingRatesPage;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.GmailPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HangoutsPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.pom.gv.LegacyGVPage;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.MessagePageAndroid;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.SettingsPayments;
import automationBed_Google.pom.gv.SpamPage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Settings extends SuiteBase {
	/* Verify correct Google Voice number is displayed. */
	public void settingsGoogleVoiceNumber(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/* Pre-Condition: Google Voice account is activated for this account. */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		/* Procedure: 1. Navigate to the Moya settings page. */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		/*
		 * Verification: 1. Verify that, displaying correct google voice phone
		 * number.(In Current Build country code is visible) 2. Verify that, it also
		 * displayed with buttons to "Change" number, "Transfer" number, and "Delete" GV
		 * number.
		 */
		stngpg.verifygvNumDisplayed(data);
		stngpg.verifyChangeBtnDisplayed().verifyTransferDisplayed().verifyDeleteBtnDisplayed();
	}

	/* Verify "Change or port" links to the legacy page for the action. */
	public void settingsGVNmberChangeOrPort(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Google Voice account is activated for this account.
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*
		 * Procedure: 1. Navigate to the Moya settings page.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		/*
		 * Verification: 1. Verify that, displaying correct google voice phone number
		 * with country code.(In Current Build country code is visible) 2. Verify that,
		 * it also displayed with buttons to "Change" number, "Transfer" number, and
		 * "Delete" GV number. 3. Verify that, by clicking on redirects to legacy page
		 * of "Change or port" screen.
		 */
		stngpg.verifygvNumDisplayed(data).verifyChangeBtnDisplayed().verifyTransferDisplayed()
				.verifyDeleteBtnDisplayed();
		stngpg.changeRedirection();
	}

	// Verify "Transfer" links to the legacy page for the action.
	public void settingsGVNmberTransfer(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/* Pre-Condition:Google Voice account is activated for this account. */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		/* Procedure: 1. Navigate to the Moya settings page. */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		/*
		 * Verification: 1. Verify that, displaying correct google voice phone number
		 * with country code. 2. Verify that, it also displayed with buttons to "Change"
		 * number, "Transfer" number, and "Delete" GV number. 3. Verify that, by
		 * clicking on 'Transfer' button redirects to legacy page of "Transfer" screen.
		 */
		stngPage.verifygvNumDisplayed(data).verifyChangeBtnDisplayed().verifyTransferDisplayed()
				.verifyDeleteBtnDisplayed();
		stngPage.transferRedirection();
	}

	// Verify new phone can be added to account.
	public void settingsLinkedNumbers(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		/*
		 * Pre-Condition: Already having GV number with at least one forwarding phone.
		 */
		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to Linked
		 * Numbers section.
		 */
		hmPage.clickSettings();
		WebElement btnNewLinkedNo = Utils.uBase.webDriver.findElement(By.xpath("//h3[contains(text(),'Message')]"));
		Utils.uBase.scrolltoElement(btnNewLinkedNo);
		settingsPage.verifyGVPhoneNumAlreadyAdded(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2,
				Constants.MESSAGE_APP_PACKAGE_NAMES9Plus, Constants.MESSAGE_APP_ACTIVITYS9Plus);
		/*
		 * Verification: 1. Verify that, all the Google voice forwarding numbers listed.
		 * 2. Verify that, each linked numbers displayed in a single row. 3. Verify
		 * that, name of the linked numbers, "Edit" button, "X" delete button displayed
		 * in the same row.
		 */
		settingsPage.verifPhoneNosAreListed().verifyEachPhoneNoDisplayedInSingleRow()
				.verifyElementsDisplayedInSameRow();
	}

	// Verify new phone can be added to account.
	public void settingsAddPhoneNumber(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		WebElement btnNewLinkedNo = Utils.uBase.webDriver.findElement(By.xpath("//h3[contains(text(),'Message')]"));
		Utils.uBase.scrolltoElement(btnNewLinkedNo);
		/*
		 * Pre-Condition: Already having GV number with at least one forwarding phone.
		 */
		settingsPage.verifyGVPhoneNumAlreadyAdded(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2,
				Constants.MESSAGE_APP_PACKAGE_NAMES9Plus, Constants.MESSAGE_APP_ACTIVITYS9Plus);
		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to Linked
		 * Numbers section. 4. Click on "Add a Number" button 5. Enter phone number in
		 * the pop-up screen. 6. Enter name of the phone number. 7. Click on "Send Code"
		 * 8. Enter the "Verification code" once you received in the non-forwarding
		 * phone. 9. "Success" message box appears once all verification done.
		 */
		settingsPage.clickNewLinkedNumber().enterMobileNoToBeLinked(Constants.SAMSUNGGalaxyNote9_Numb2)
				.clickSendBtnLinkedNoDialog().clickVerifyLnkdNum();
		/*
		 * Verification: 1. Verify that, the newly added forwarded phone number appear
		 * in the "Linked number" section. 2. Verify that, all the Text/Calls/Voicemail
		 * to the GV number forwarding to the recently added phone number as well.
		 */
		settingsPage.verifPhoneNosAreListed();
		// GApage.reciveMultipleTestMsgs(data, 1);
		// TODO Verification point no. 2 need to developed
	}

	// Verify able to edit the phone alias name.
	public void settingsNotAbleToEditPhoneName(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		/*
		 * Pre-Condition: Already having GV number with at least one forwarding phone.
		 */
		Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to Linked
		 * Numbers section. 4. Click on pencil Icon button to edit the respective Phone
		 * name. 5. Change/Replace phone alias name 6. Press Enter/TAB key or Click
		 * somewhere.
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*
		 * Verification: 1. Verify that, the alias phone name modified, across all the
		 * respective references. 2. Verify the changed name exist after re-login/Page
		 * refresh.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		WebElement btnNewLinkedNo = Utils.uBase.webDriver.findElement(By.xpath("//h3[contains(text(),'Message')]"));
		Utils.uBase.scrolltoElement(btnNewLinkedNo);
		settingsPage.verifyGVPhoneNumAlreadyAdded(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2,
				Constants.MESSAGE_APP_PACKAGE_NAMES9Plus, Constants.MESSAGE_APP_ACTIVITYS9Plus);
		settingsPage.verifyEditOptnInLinkedNum();
	}

	// Verify that phone number already linked warming message.
	public void settingsAddPhoneNumberAlreadyExist(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		HomePageWeb hmWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		/*
		 * Pre-Condition: Already having GV number with at least one forwarding phone.
		 */
		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to Linked
		 * Numbers section. 4. Click on "Add a Number" button 5. Enter already linked
		 * phone number in the pop-up screen. 6. Click "ok"
		 */
		hmPage.clickSettings();
		settingsPage.verifyGVPhoneNumAlreadyAdded(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2,
				Constants.MESSAGE_APP_PACKAGE_NAMES9Plus, Constants.MESSAGE_APP_ACTIVITYS9Plus);
		settingsPage.verifyGVPhoneNumAlreadyAdded_1();

		// hmPage.clickAccountLabel().clickAddAccount();
//		GAPage.switchingToWindowByIndex(1);

		hmWeb.clickGoogleAccountIcon().clickAddAccountOption();
		// hmPage.clickAccountLabel().clickAddAccount();
		Thread.sleep(10000);
		Utils.uBase.checkPageReady();
		GAPage.switchingToWindowByIndex(1);

		hmPage.loginToOtherAccount(Constants.voipthreeId, Constants.voipPwd);
		hmPage.clickSettings();
		Thread.sleep(1000);
		settingsPage.verifyGVPhoneNumAlreadyAdded_1();

		// hmPage.clickAccountLabel().clickAddAccount();
		// Thread.sleep(2000);

		hmWeb.clickGoogleAccountIcon().clickAddAccountOption();
		// hmPage.clickAccountLabel().clickAddAccount();
		Thread.sleep(10000);
		Utils.uBase.checkPageReady();

		GAPage.switchingToWindowByIndex(2);
		gvSignInPage.enterLoginID(Constants.voipOneId).clickNextButton().enterPassword(Constants.voipPwd)
				.clickNextButton();
		// hmPage.loginToOtherAccount(Constants.voipOneId, Constants.voipPwd);
		hmPage.clickSettings();
		settingsPage.verifyGVPhoneNumAlreadyAdded_2();
		/*
		 * Verification: 1. Verify that, you can link same number to 2 different
		 * accounts as type "Home". 2. Verify that if you add the same number with 3rd
		 * account it should show warning message that "Phone number" already linked and
		 * should be able to reclaim.
		 */
		settingsPage.verifyClaimLinkedNumberPopUp().clickClaimLnkdNum().clickFinishTabLnkdNum();
		Utils.uBase.refresh();
		Utils.uBase.checkPageReady();
		Thread.sleep(2000);
		settingsPage.verifyClaimedLinkedNumber();
	}

	/* Verify "Change or port" links to the legacy page for the action. */
	public void settingsDeletePhoneNumber(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Verify able to remove existing forwarding phone number.
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to Linked
		 * Numbers section. 4. Click on "X" button to remove the forwarding phone
		 * number. 5. Click "Delete" on the confirmation pop-up window.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		WebElement btnNewLinkedNo = Utils.uBase.webDriver.findElement(By.xpath("//h3[contains(text(),'Message')]"));
		Utils.uBase.scrolltoElement(btnNewLinkedNo);
		Thread.sleep(1000);
		settingsPage.verifyGVPhoneNumAlreadyAdded_1();
		settingsPage.deleteSamsungGalaxyNum_2();
		/*
		 * Verification: 1. Verify that, confirmation pop-up screen messages
		 * "Delete this linked number?" and
		 * "Phone number-name will no longer receive calls and messages from your Google Voice number"
		 * 2. Verify that, respective phone number-name removed from the
		 * "Linked numbers" section.
		 */
		settingsPage.verifyRemoveLnkdNumScreenMsgs().clickRemoveButton().verifyContactNumberIsNotDisplayed();
	}

	/* Verify able to get payment details */
	public void settingsPaymentsCredit(String email, String password, String data) throws Exception {

		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Google Voice account is activated for this account.
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/*
		 * Procedure: 1. Navigate to the Moya settings page.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		/*
		 * Verification: 1. Verify that, payment section shows the below items. i)
		 * "Credit" balance, ii) "Add credit" button to add more fund. iii)
		 * "Billing history" button to show the recent call and their rates.
		 */
		stngpg.clickPaymentTab();
		stngpay.verifyGvCurrentBalDispalyed();
		stngpay.verifyAddCreditBtnDisplayed();
		stngpay.verifyBillingHistoryBtnDisplayed();

	}

	/* Verify settings page "Add credit" button redirect to legacy billing page. */
	public void settingsPaymentsAddCredit(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/* Pre-Condition:Google Voice account is activated for this account. */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/* Procedure:1. Navigate to the Moya settings page. */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		hmPage.clickSettings();
		/*
		 * 1. Verify that, payment section shows the below items. "Add credit" button is
		 * clearly visible. 2. Verify that, click on that button will give you popup
		 * window and you will be able to select amount and add credit. 3. Verify that,
		 * click on cancel button close the add credit window.
		 */
		stngpg.clickPaymentTab();
		stngpay.clickAddCreditBtn().verifyPopUpPresence(Constants.displayed).verifyAddCreditPopupBtnDisplayed()
				.clickAddCreditPopUpCancelBtn().verifyPopUpPresence(Constants.notDisplayed).clickAddCreditBtn()
				.verifyPopUpPresence(Constants.displayed).verifyAddCreditPopupBtnDisplayed().clickAddCreditInPopUp()
				.verifyCreditPopUP();

	}

	// Verify settings page "LookBilling history" button redirect to legacy billing
	// page.
	public void settingsPaymentsCallingRate(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Google Voice account is activated for this account.
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/*
		 * Procedure: 1. Navigate to the Moya settings page.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		/*
		 * Verification: 1. Verify that, payment section shows the link for
		 * "Lookup calling rates by country" 2. Verify click on that link redirects to
		 * "rate" page.
		 */
		stngpg.clickPaymentTab();

		stngpay.verifyLinkLookupCallingRatesByCountry().verifyCallPageDisplayed();
	}

	// Verify that, "Legacy Google Voice" button redirects to legacy GV setting
	// page.
	public void settingsLegacyGoogleVoice(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Google Voice account is activated for this account.
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		/*
		 * Procedure: 1. 2. Click on main navigational side bar. 3. click on
		 * "legacy google voice" button.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		/*
		 * Verification:
		 * 
		 * 1. Verify that, it redirects to legacy google voice web application.
		 */
		hmPage.clickMainMenu().clickLegacyGoogleVoice().verifyLegacyWindow();
	}

	// Message.Select.Contact.TopN.&.Favorite.&.Contacts.list
	public void messageSelectContactTopNFavoriteContactslist(String email, String password, String data)
			throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Google Voice account is activated for this account.
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgpg = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/*
		 * 1. Cursor is auto focused in the recipient picker field of message section.
		 * 2. Place holder text of 'To' field is 'Type a name or phone number' 3.Verify
		 * dropdown displayed with first TopN and Favorite contacts and followed by Full
		 * contact suggestion list. 4.Verify that selected contact number is added to
		 * recipient picker i.e 'To' field.
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickMainMenu().clickMessages();
		msgpg.clickSendNewMessage().clickSendNewMessage().verifyPlaceholderTextDisplayed()
				.verifyCursorAutofocusedToField().selectcontactDetails();
	}

	// Verify that by click on respective section button scroll to the section
	// position visible.
	public void settingsSectionButtons(String email, String password, String data) throws Exception {

		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * 2. Navigate to setting page 3. Click on any section link buttons on the left
		 * side. [Phone numbers, Messages, Calls, Voicemails, Web notifications,
		 * Payments, Security, Accessibilty]
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		// Verify that by click on "Section Link button" it navigate to the respective
		// section and it is visible on the screen.
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		stngpg.clickAccountInSettings().verifyAccountSectionDisplayed().clickMessagesInSettings()
				.verifyMessagesSectionDisplayed().clickCallsInSettings();
		stngpg.verifyCallsSectionDisplayed().clickDonotDisturbInSettings().verifyDoNotDisturbSectionDisplayed()
				.clickVoiceMailInSettings();
		stngpg.verifyVoiceMailsectionDisplayed().clickwebNotifyInSettings().verifyWebNotificationSectionDisplayed();
		stngpg.clickPaymentTab().verifyPaymentsSectionDisplayed().clickSecurityInSettings()
				.verifySecuritySectionDisplayed().clickAccesibilityInSettings().verifyAccesibilitySectionDisplayed()
				.verifyClickOnPrivacyTerms().comparePrivacyTerms();
	}

	// Verify the analyze voicemail transcripts toggle.
	public void settingsVoicemailsTranscript(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * 2. Navigate to setting page 3. Click on any section link buttons on the left
		 * side. [Phone numbers, Messages, Calls, Voicemails, Web notifications,
		 * Payments, Security, Accessibilty]
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		/*
		 * Verification If enabled: 1. Verify the toggle is turned on.
		 * 
		 * Verification if not enabled: 1. Verify the toggle is turned off.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		stngpg.voicemailToggleEnable().VerifyVoicemailToggleEnable().voicemailToggleDisable()
				.VerifyVoicemailToggleDisable();
	}

	// Verify settings page "Billing history" button redirect to legacy billing
	// page.
	public void settingsPaymentsBillingHistory(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Google Voice account is activated for this account.
		 * 
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to
		 * "Payments" section. 4. Click on "Billing History"
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/*
		 * Verification: 1. Verify that, payment section shows the below items
		 * "Add credit" , "Billing History" buttons 2. Verify that, Billing page must
		 * have "Add Credit" and "Refund" button clearly visible. 3. Verify that, the
		 * billing history is correctly displayed.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.verifyAddCreditBtnDisplayed().verifyBillingHistoryBtnDisplayed().clickBillingHistoryBtn()
				.verifyAddCreditsDisplayedInBillingHistory().verifyRefundOptionBillingHistory().verifyBillHistoryItems()
				.verifyCorrectBillingHistory();
	}

	// To check the UI of Smart DND
	public void smartDndUi(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1. Login with GV corp account credentials 2. Navigate to Settings
		 * page
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		/*
		 * 1. Observe that under the Section Heading Do Not Disturb the following
		 * toggles are present a. Do Not disturb toggle b. Follow working hours toggle
		 * c. Follow Out of office toggle
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		stngpg.clickDoNotDisturb().verifyDoNotDisturbToogle().verifyFollowWorkingHoursToogle()
				.verifyFollowOutOfOfficeWorkingHoursToogle();
	}

	// Enterprise users have the following experience
	public void enterpriseGVuserHasNoAccessToCreditsMenu(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Click the three dot menu from the left panel 4. Click the
		 * Settings > Payments menu item
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		/*
		 * Verification: 4a. User should not be given the option to add credit or allow
		 * refunds to his account 4b. The only clickable link in the Payments section is
		 * 'Billing History'
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.verifyBillingHistoryIsClickable().movingFromBillingHistoryToSettingsPage()
				.verifyAddCreditDisplayedInWolverine().verifyCallingRatesIsClickable();

	}

	// Verify able to turn off hang out integration using "Turn off" option
	public void settingsHangoutsIntegrationDisconnect(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		HangoutsPage hangoutsPage = PageFactory.initElements(Utils.uBase.webDriver, HangoutsPage.class);

		// Pre-Condition: Hangout Integrated user.

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		hmPage.clickMainMenu().clickMessages();
		homePage.RemoveIfHangoutIsAlreadyIntegrated();

		/*
		 * Pre-Condition:
		 * 
		 * Hangouts integration is turned on.
		 */
		homePage.clickGoogleApps();
		homePage.clickGmail().integrateHangouts();

		/*
		 * Procedure:
		 * 
		 * 1. Navigate to Moya Settings. 2. Click on "DISCONNECT" button on the Hangout
		 * section
		 */
		hmPage.clickSettings();
		settingsPage.clickHangoutsTab().clickDisconnect().clickDisconnectHangoutsPopUp().clickCloseSettings();

		/*
		 * Verification:
		 * 
		 * 1. Verify after few seconds able to send/receive messages from google voice,
		 * not from hangout.
		 */
		homePage.verifySendMsgBtnStatus(Constants.enabled);
		homePage.clickGoogleApps().clickHangouts();
		hangoutsPage.switchToHangoutsWindow().navigateToHomePage().clickNewConversation().enterContactName()
				.verifyMsgDisabledTxtDisplayed();
		homePage.RemoveIfHangoutIsAlreadyIntegrated();

	}

	// Verify Hangouts can be configured to use for Voice SMS/MMS and Voicemail.
	public void settingsHangoutsIntegrationOn(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		HangoutsPage hangoutsPage = PageFactory.initElements(Utils.uBase.webDriver, HangoutsPage.class);
		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		hmPage.clickMainMenu().clickMessages();
		homePage.RemoveIfHangoutIsAlreadyIntegrated();

		/*
		 * Pre-Condition:
		 * 
		 * Hangouts integration is turned on.
		 */
		homePage.clickGoogleApps();
		homePage.clickGmail().integrateHangouts();

		/*
		 * Verification:
		 * 
		 * 1. Verify unable to send messages from Google voice, send message button is
		 * disabled.
		 */

		homePage.verifySendMsgBtnStatus(Constants.disabled);

		/*
		 * 2. Verify you can now send and receive text messages from Hangouts, using
		 * this account.
		 */
		homePage.clickGoogleApps().clickHangouts();
		hangoutsPage.switchToHangoutsWindow().navigateToHomePage().clickNewConversation().enterContactName()
				.sendMessageInHangouts();
	}

	// Verify that hovering over the billing history log will highlight the three
	// dots menu
	public void hoverOverBillingHistory(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Gvaccount should have billing history with international calls
		 * more than 30 sec
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/*
		 * Procedure: 1. Login to the Google Voice account 2. Navigate to Settings page
		 * 3. Click on the 'Billing History' button to open the billing history page 4.
		 * Hover over the mouse on the items in the billing history
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		/*
		 * Verification: 4a. Hovering over the log should highlight the items in the
		 * list. 4b. If the call is eligible for a refund then there will be a three
		 * dots menu on the highlighted item
		 */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().verifyBillingHistoryItem().verifyAndClickThreedotsMenu();
	}

	// Verify that clicking on the threedots option will open refund request
	public void clickingThreedotsRefundRequest(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Gvaccount should have billing history with international calls
		 * more than 30 sec
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/*
		 * Procedure: 1. Login to the Google Voice account 2. Navigate to Settings page
		 * 3. Click on the 'Billing History' button to open the billing history page 4.
		 * Hover over the mouse on the items in the billing history 5. Click on
		 * threedots menu near an eligible history
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		/*
		 * Verification: 4a. 'Request Refund' button should pop up while clicking on the
		 * threedots menu
		 */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().verifyAndClickThreedotsMenu().verifyRequestRefundMenu();
	}

	// Verify request refund
	public void requestTheRefund(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Gvaccount should have billing history with international calls
		 * more than 30 sec
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		/*
		 * Procedure: 1. Login to the Google Voice account 2. Navigate to Settings page
		 * 3. Click on the 'Billing History' button to open the billing history page 4.
		 * Hover over the mouse on the items in the billing history 5. Click on
		 * threedots menu near an eligible history 6. Click on the 'Request Refund'
		 * button 7. Select a reason from the drop down menu 8. Click on the 'Request
		 * Refund' button
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		Utils.uBase.clickOnNotificationAllowBtn();
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().enterPhoneNumAndMakeAcall();

		/*
		 * Verification:
		 * 
		 * 6a. 'Request a Refund' pop up should pop up 7a. 'Request Refund' button
		 * should become active 8a. Snackbar should pop up saying 'Refund issued'
		 */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().verifyAndClickThreedotsMenu().verifyRequestRefundMenu().clickRequestRefund()
				.clickReasonBtn().selectReason().verifyRequestRefundBtn().verifyRequestRefundBtn()
				.clickRequestRefundBtn().verifySnackBar();
	}

	// Verify the Error notification in the request a refund pop up
	public void errorInRequestRefundPopUp(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Gvaccount should have billing history with international calls
		 * more than 30 sec
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/*
		 * Procedure: 1. Login to the Google Voice account 2. Navigate to Settings page
		 * 3. Click on the 'Billing History' button to open the billing history page 4.
		 * Hover over the mouse on the items in the billing history 5. Click on
		 * threedots menu near an eligible history 6. Click on the 'Request Refund'
		 * button 7. Select a reason from the drop down menu 8. Click somewhere else in
		 * the pop up to close the dropdown
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		/*
		 * Verification: 8a. 'Select a reason' should highlight in red color
		 */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().verifyAndClickThreedotsMenu().verifyRequestRefundMenu().clickRequestRefund()
				.clickReasonBtn().clickOutside().verifyReasonError();
	}

	// Verify that clicking on cancel button will close the pop up
	public void clickCancelButtonCloseThePopUp(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Gvaccount should have billing history with international calls
		 * more than 30 sec
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments stngpay = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		/*
		 * Procedure: 1. Login to the Google Voice account 2. Navigate to Settings page
		 * 3. Click on the 'Billing History' button to open the billing history page 4.
		 * Hover over the mouse on the items in the billing history 5. Click on
		 * threedots menu near an eligible history 6. Click on the 'Request Refund'
		 * button 7. Click on the 'Cancel' button
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		/*
		 * Verification: 7a. Pop up window should close when clicking on the 'cancel'
		 * button
		 */
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		stngpay.clickBillingHistoryBtn().verifyAndClickThreedotsMenu().verifyRequestRefundMenu().clickRequestRefund()
				.clickCancelBtn().verifyWindoClose();
	}

	// Verify able to forward calls on/off to the selected forwarding phone number.
	public void settingsCallsForwardingPhone(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GeneralActivitiesPage gaPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*
		 * Pre-Condition : Already having GV number with at least one forwarding phone.
		 */
		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to "Calls"
		 * section. 4. Check/Uncheck the existing phone number.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		settingsPage.verifyGVPhoneNumAlreadyAdded(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2,
				Constants.MESSAGE_APP_PACKAGE_NAMES9Plus, Constants.MESSAGE_APP_ACTIVITYS9Plus);
		WebElement settingsCallsColumn = Utils.uBase.webDriver
				.findElement(By.xpath("//gv-settings-section-block[contains(@header,'Incoming call options')]"));
		Utils.uBase.scrolltoElement(settingsCallsColumn);
		/*
		 * Verification: 1. Verify after few seconds, if checked the forwarding phone
		 * number, you are able to receive calls, which forwarding from the GV number.
		 * 2. Verify after few seconds, if unchecked forwarding phone number, you are
		 * not able to receive calls, which forwarding from the GV number.
		 */

		settingsPage.callsFwdToggleActions(Constants.ON);
		// gaPage.reciveMultipleMissCalls(data,2);
		gaPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
		Thread.sleep(3000);
		Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAMES9Plus,
				Constants.MESSAGE_APP_ACTIVITYS9Plus);
		CallsPageAndroid callsMobPage = new CallsPageAndroid(Utils.uBase.mDriver);
		Thread.sleep(3000);
		Utils.uBase.mDriver.pressKey(new KeyEvent(AndroidKey.HOME));
		callsMobPage.verifyIfCallIsTriggeredToMobile(data, Constants.True);
		settingsPage.callsFwdToggleActions(Constants.OFF);
		callsMobPage.verifyIfCallIsTriggeredToMobile(data, Constants.False);
	}

	// Verify able to forward messages on/off to the selected forwarding phone
	// number.
	public void settingsSMSForwardingPhone(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		/*
		 * Pre-Condition: Already having GV number with at least one forwarding phone.
		 */
		hmPage.clickSettings();
		WebElement btnNewLinkedNo = Utils.uBase.webDriver.findElement(By.xpath("//h3[contains(text(),'Message')]"));
		Utils.uBase.scrolltoElement(btnNewLinkedNo);
		settingsPage.verifyGVPhoneNumAlreadyAdded(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2,
				Constants.MESSAGE_APP_PACKAGE_NAMES9Plus, Constants.MESSAGE_APP_ACTIVITYS9Plus);
		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to
		 * "Messages" section. 4. Check/Uncheck the existing phone number.
		 */
		settingsPage.clickMessagesInSettings();
		settingsPage.msgFwdToggleActions(Constants.ON);
		/*
		 * Verification : 1. Verify after few seconds, if checked the forwarding phone
		 * number, you are able to receive messages, which forwarding from the GV
		 * number. 2. Verify after few seconds, if unchecked forwarding phone number,
		 * you are not able to receive messages, which forwarding from the GV number.
		 */
		Thread.sleep(3000);
		Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAME2,
				Constants.MESSAGE_APP_ACTIVITY2);
		MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
		msgMobPage.verifyMessageForwardedStatusToLinkedMobile(data, Constants.True);
		settingsPage.clickCloseSettings();
		hmPage.clickSettings();
		settingsPage.clickMessagesInSettings().msgFwdToggleActions(Constants.OFF);
		Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2, Constants.MESSAGE_APP_PACKAGE_NAME2,
				Constants.MESSAGE_APP_ACTIVITY2);
		msgMobPage.verifyMessageForwardedStatusToLinkedMobile(data, Constants.OFF);
	}

	// Verify able to forward messages on/off to the selected email address.
	public void settingsSMSForwardingEmail(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GmailPage gmailPage = PageFactory.initElements(Utils.uBase.webDriver, GmailPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		/*
		 * Pre-Condition: Already having GV number with at least one forwarding phone.
		 */
		hmPage.clickSettings();
		WebElement btnNewLinkedNo = Utils.uBase.webDriver.findElement(By.xpath("//h3[contains(text(),'Message')]"));
		Utils.uBase.scrolltoElement(btnNewLinkedNo);
		settingsPage.verifyGVPhoneNumAlreadyAdded(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2,
				Constants.MESSAGE_APP_PACKAGE_NAMES9Plus, Constants.MESSAGE_APP_ACTIVITYS9Plus);
		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to
		 * "Messages" section. 4. Check/Uncheck the existing phone number.
		 */
		Thread.sleep(3000);
		settingsPage.clickMessagesInSettings().msgEmailToggleActions(Constants.ON);
		/*
		 * Verification: 1. Verify after few seconds, if checked the forwarding email
		 * address, you are able to receive messages, which forwarding from the GV
		 * number. 2. Verify after few seconds, if unchecked forwarding phone number,
		 * you are not able to receive messages, which forwarding from the GV number.
		 */
		Thread.sleep(3000);
		gmailPage.verifyEmailIsSentWhenToggleIsturned(data, Constants.True);
		Utils.uBase.switchToOldWindow();
		settingsPage.msgEmailToggleActions(Constants.OFF);
		gmailPage.verifyEmailIsSentWhenToggleIsturned(data, Constants.False);
	}

	// User should not be allowed to add or refund credit - Account is billed to
	// company
	public void verifyCreditsAccess(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User has a dasher Account 2. User's account has been
		 * wolverine licensed 3. User account has a GV number assigned
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments setPmntPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Click the three dot menu from the left panel 4. Click the
		 * Settings > Payments menu item
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		settPage.clickPaymentTab();
		/*
		 * Verification: 4a. User should not be given the option to add credit or allow
		 * refunds to his account 4b. The only clickable link in the Payments section is
		 * 'Billing History'
		 */
		setPmntPage.verifyBillingHistoryIsClickable().clickBackArrowIcon().verifyAddCreditButton()
				.verifyCallingRatesButton();
		Thread.sleep(4000);

	}

	// Enterprise GV user shall not have access to his balance column in Billing
	// history
	public void verifyBalanceColumnAndBillingHistory(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments setPmntPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Launch settings from the left three dot menu > Settings >
		 * Payments > Billing History
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		settPage.clickPaymentTab();
		setPmntPage.clickBillingHistoryTab();
		/*
		 * Verification: 4a. User should only see the following columns : Date, Time,
		 * Type, Destination, Duration, Amount 4b. Unlike consumer GV accountholders,
		 * Enterprise user should not see his Balance column
		 */

		setPmntPage.verifyAllColumnsInBillingHistory().verifyBalanceColumn();
		Thread.sleep(4000);

	}

	// Enterprise GV user shall not have access to Legacy GV site
	public void verifyLegacyAccessEnterpriseAccount(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments setPmntPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		CallingRatesPage callRtPage = PageFactory.initElements(Utils.uBase.webDriver, CallingRatesPage.class);

		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Launch settings from the left three dot menu > Settings >
		 * Payments > Billing History 4. Clicks the link next to check rates menu item
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		settPage.clickPaymentTab();
		setPmntPage.clickCallingRatesIcon();
		Thread.sleep(1000);
		Utils.uBase.switchToNewWindow();
		/*
		 * Verification: 4a. User should not land on the legacy GV page by clicking the
		 * Google Voice logo in the calling rates page"
		 */
		callRtPage.clickGoogleVoiceLogo().verifyNavigationOnClickingGvLogo();
		Thread.sleep(4000);

	}

	// No opt in to have Google analyze transcripts - to improve VM
	// tanscription quality
	public void verifyGoogleAnalyzeVoicemailTranscripts(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User is signed into his Enterprize GV account
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments setPmntPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Click the three dot menu from the left panel 4. Click the
		 * Voicemail menu item
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		settPage.clickVoicemailTab();
		/*
		 * Verification: 4a. User should not see the following toggle (available for
		 * consumer accounts): Let Google analyze voicemail transcripts"
		 */
		setPmntPage.verifyVoicemailTranscriptsToggle();
		Thread.sleep(4000);

	}

	// Enterprise user should not have messaging forwarding section in settings as
	// they dont support message forwarding
	public void verifyMessageForwardingFunction(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account 2. User
		 * should have a US GV number
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Click the three dot menu from the left panel 4. Click the
		 * Settings>Messages section
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		settPage.verifyUsGvNum();
		settPage.clickMessageTab();
		/*
		 * Verification: 4a. User should not see the message forwarding section in the
		 * settings page"
		 */
		settPage.verifyMessageForwardingSection();
	}

	// Enterprise user should see the country picker with the country flags while
	// adding linked number
	public void verifyCountryPickerAndFlags(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account 2. User
		 * should have a US GV number
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb hmweb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/*
		 * Procedure: 1. Log into Accounts.google.com with valid credentials 2. Navigate
		 * to Google Voice URL's Landing Page 3. Click the three dot menu from the left
		 * panel 4. Click the Settings>Phone number section 5. Click on add a new linked
		 * number 6. Click on the drop down near the country picker on the verification
		 * pop up
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmweb.verifywolverineAccount(email);
		hmPage.clickSettings();
		settPage.verifyUsGvNum();
		settPage.clickNewLinkedNumberBtn().clickCountryDropdown();
		/*
		 * Verification:6a. User should see country flags(right now US and UK flags)
		 * when clicking on the list in verification pop up
		 */
		settPage.verifyCountryFlags();
		Thread.sleep(4000);
	}

	// User shall not have access to CHANGE, TRANSFER and DELETE his GV number
	public void verifyModifyOrDeleteGvNum(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: 1. User is signed into his Enterprise GV account (takeover
		 * account/managed account)
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Navigate to settings from the hamburger menu 4. Observe GV
		 * number under Phone numbers
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		/*
		 * Verification:4a. User does not have the options to CHANGE, TRANSFER and
		 * DELETE his GV number
		 */
		settPage.verifyChangeTrfrAndDelBtnsInWolvAcc();
		Thread.sleep(4000);

	}

	public void settingsPaymentsSecurity(String email, String password, String data) throws Exception {

		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Already having GV number with at least one forwarding phone.
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		LegacyGVPage legacyGVPage = PageFactory.initElements(Utils.uBase.webDriver, LegacyGVPage.class);
		HomePageWeb homePage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to
		 * "Security" section. 4. Enable "Spam filter"
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		settPage.clickSecurity().spamFilterToggleOn().clickCloseSettings();
		/*
		 * Verification: 1. Verify that, security section shows the spam filter option
		 * with "Filtering calls, messages and voicemails" 2. Verify by clicking on
		 * that, sync with legacy page "Spam filter" option.
		 */
		hmPage.clickMainMenu().clickLegacyGoogleVoice();
		homePage.switchingToFirstWindow();
		legacyGVPage.goToSettings().clickCalls().verifySpamFiltersEnabled();
		Thread.sleep(2000);
		homePage.switchingToZerothWindow();
		// Clearing the pre-condition
		hmPage.clickSettings();
		settPage.clickSecurity().spamFilterToggleOff();
	}

	// Verify able to get SMS notification for the received voicemail.
	public void settingsVoicemailsSMSNotification(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		/*
		 * Pre-Condition: 1. Already having GV number with at least one forwarding
		 * phone. 2. Check if the Phone type is mobile.
		 */
		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to
		 * "Voicemails" section. 4. Check/Uncheck the forwarding phone number to get
		 * notified of every newly received voicemails.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		settingsPage.clickVoiceMailInSettings().voicemailFwdViaSMSToggleActions(Constants.ON);
		Thread.sleep(3000);
		Utils.uBase.setupMDriver(3, Constants.SAMSUNGGalaxyNote9_SM_DUT1, Constants.MESSAGE_APP_PACKAGE_NAME2,
				Constants.MESSAGE_APP_ACTIVITY2);
		MessagePageAndroid msgMobPage = new MessagePageAndroid(Utils.uBase.mDriver);
		/*
		 * Verification If enabled: 1. Verify after few seconds, the selected phone
		 * number able to get voicemail notifications with SMS.
		 * 
		 * if not enabled: 1. Verify after few seconds, the selected phone number not
		 * getting SMS notification for the received voicemails.
		 */
		msgMobPage.deleteCurrentListMsgs().verifyIfSMSVoicemailIsTriggeredToMobile(data, Constants.True);
		settingsPage.voicemailFwdViaSMSToggleActions(Constants.OFF);
		msgMobPage.verifyIfSMSVoicemailIsTriggeredToMobile(data, Constants.False);

	}

	// Verify able to get Email notification for the received voicemail.
	public void settingsVoicemailsEmailNotification(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		GmailPage gmail = PageFactory.initElements(Utils.uBase.webDriver, GmailPage.class);
		HomePageWeb homePage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		WebElement btnNewLinkedNo = Utils.uBase.webDriver.findElement(By.xpath("//h3[contains(text(),'Message')]"));
		Utils.uBase.scrolltoElement(btnNewLinkedNo);
		settingsPage.verifyGVPhoneNumAlreadyAdded(3, Constants.SAMSUNGGalaxyS9Plus_SM_DUT2,
				Constants.MESSAGE_APP_PACKAGE_NAMES9Plus, Constants.MESSAGE_APP_ACTIVITYS9Plus);
		/*
		 * Pre-Condition: Already having GV number with at least one forwarding phone.
		 * 
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to
		 * "Voicemails" section. 4. Check/Uncheck the forwarding email to get notified
		 * of every newly received voicemails.
		 */
		settingsPage.clickVoiceMailInSettings().voicemailFwdViaEmailToggleActions(Constants.ON);
		homePage.clickGoogleApps();
		homePage.clickGmail();
		/*
		 * Verification : Verification If enabled: 1. Verify after few seconds, the
		 * selected email address able to get voicemail notification. Verification if
		 * not enabled: 1. Verify after few seconds, the unselected email address not
		 * getting email notification for the received voicemails.
		 */
		gmail.verifyIfVoicemailNotificationIsReceived(Constants.ON, data);
		Utils.uBase.switchToOldWindow();
		settingsPage.voicemailFwdViaEmailToggleActions(Constants.OFF);
		Utils.uBase.switchToNewWindow();
		gmail.verifyIfVoicemailNotificationIsReceived(Constants.OFF, data);

	}

	// Call Screening defaults to OFF for enterprise accounts (managed accounts)
	public void verifyCallToggleOffWolvAcc(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: 1. User is signed into his Enterprize GV account (managed
		 * account)
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		/*
		 * Procedure: 1. Log into Gmail account 2. Navigate to Google Voice URL's
		 * Landing Page 3. Click the hamburger menu for quick navigation panel 4. Under
		 * the calls subheading - Check the toggle for Screen calls
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		/*
		 * Verification:4a. Screen calls toggle must be defaulted to OFF position for
		 * new managed accounts
		 */
		settPage.clickCallsInSettings().verifyScreenCallsToggleEnabled();

	}

	// Manage All greeting page items
	public void manageAllGreetingPageItems(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application

		Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1.Login 2. Navigate to Moya Settings page. 3. Scroll to voicemail
		 * section 4. Click-on Manage All Greetings link
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		// 1.Pop-up page 'All Greeting' will display with list of Active and All
		// previously recorded greetings
		settPage.clickVoiceMailInSettings().clickOnManageGreeting().verifyAllGreetingsPopUpDisplayed()
				.verifyActiveSectionInAllGreeting().verifyOthersSectionInAllGreeting().clearGreetingsInOtherSection();
		/*
		 * 2.Verify with has 2 sections: a)Active: Greeting which is currently
		 * active,has play button,name and duration . b)Other:Previously recorded
		 * greetings display's with play button name and duration.
		 */
		settPage.verifyActiveGreetingName().verifyActiveGreetingDuriation().verifyActiveGreetingPlayOptn();
		settPage.verifyGreetingNameAndDuration().verifyGreetingPlayOptnInOtherSection();
		// 3.Verify 'Google voice default' greeting is dislpayed in the list.
		settPage.verifyGoogleVoiceDefaultIsPresent().verifyGoogleVoiceDefault();
		/*
		 * 4.Verify Greeting has minimum count of 1 which is 'Google vocie default' to
		 * maxium of 9 greetings user can add. 5.Verify upon reaching maxium recordings
		 * Alert message is displayed 'You can only save 10 greetings' and Record a
		 * greeting button is disabled. 6.To Close the pop-up page,click on 'X' on top
		 * left hand side or hit ESC from keypad.
		 */
		settPage.closePopUp().totalGreetingsInList().clearGreetingsInOtherSection();
	}

	/* Verify Automatic Spam filtering works as expected. */
	public void settingsAutomaticSpamFilteringOn(String email, String password, String data) throws Exception {

		/* Launching Google Voice Web Application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb homeWebPage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();

		/*
		 * Pre-Condition : Automatic Spam filtering is turned off.
		 */
		settPage.clickSecurityInSettings().spamFilterToggleOn().verifySpamFilterToggleOn().clickCloseSettings();
		/*
		 * Procedure : 1. Navigate to Moya Settings. 2. Select the radio slider to turn
		 * on Automatic Spam filtering.
		 */

		/*
		 * Verification : 1. Verify the slider moves from the left to the right, and
		 * turns from grey to blue. 2. Verify items received from identified spam
		 * accounts are sent directly to the Spam folder.
		 */
		homeWebPage.clickGoogleAccountIcon();
		hmPage.clickAddAccount();
		homeWebPage.switchingToFirstWindow();
		gvSignInPage.enterLoginID(Constants.voipspamId).clickNextButton().enterPassword(Constants.voipPwd)
				.clickNextButton();
		hmPage.clickMainMenu().clickMessages();
		msgPage.clickSendNewMessage().composeNewMessage(data).sendComposedMessage();
		Thread.sleep(5000);
		homeWebPage.switchingToZerothWindow();
		/*
		 * hmPage.clickMainMenu().clickMessages();
		 * msgPage.clickfirstMessageInList().markAsSpam();
		 */
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab("Spam");
		msgPage.clickfirstMessageInList();
		Thread.sleep(5000);
		homeWebPage.switchingToFirstWindow();
		hmPage.clickMessages();
		msgPage.clickSendNewMessage().composeNewMessage(data).sendComposedMessage();
		Thread.sleep(5000);
		homeWebPage.switchingToZerothWindow();
		Utils.uBase.refresh();
		Utils.uBase.checkPageReady();
		hmPage.clickMainMenu().clickTab("Spam");
		msgPage.clickfirstMessageInList();
		Thread.sleep(5000);
		/*
		 * spamPage.clickItemFromList().clickMoreOptn(); spamPage.selectUnmarkAsSpam();
		 * hmPage.clickMainMenu().clickMessages(); msgPage.clickfirstMessageInList();
		 */
		hmPage.clickSettings();
		settPage.clickSecurityInSettings().spamFilterToggleOff();
	}

	/* Verify Automatic Spam filtering can be turned off. */
	public void settingsAutomaticSpamFilteringOff(String email, String password, String data) throws Exception {

		/* Launching Google Voice Web Application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb homeWebPage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		SpamPage spamPage = PageFactory.initElements(Utils.uBase.webDriver, SpamPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		hmPage.clickSettings();

		// Pre-Condition: Automatic Spam filtering is turned on
		settPage.clickSecurityInSettings().spamFilterToggleOff().clickCloseSettings();

		/* Login to another account for sending message */
		homeWebPage.clickGoogleAccountIcon();
		hmPage.clickAddAccount();
		homeWebPage.switchingToFirstWindow();
		gvSignInPage.enterLoginID(Constants.voipspamId).clickNextButton().enterPassword(Constants.voipPwd)
				.clickNextButton();
		hmPage.clickMainMenu().clickTab("MessagesTab");
		msgPage.clickSendNewMessage().composeNewMessage(data).sendComposedMessage();
		Thread.sleep(8000);
		/*
		 * Procedure: 1. Navigate to Moya Settings. 2. Select the radio slider to turn
		 * off Automatic Spam filtering.
		 */
		homeWebPage.switchingToZerothWindow();
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickMessages();
		msgPage.clickfirstMessageInList();
		hmPage.clickSettings();
		settPage.clickSecurityInSettings().spamFilterToggleOff();
		/*
		 * Verification: 1. Verify the slider moves from the right to the left, and
		 * turns from blue to grey.
		 */
		settPage.verifyspamFilterToggleOff().clickCloseSettings();
		Thread.sleep(8000);
		homeWebPage.switchingToFirstWindow();
		hmPage.clickTab("MessagesTab");
		Thread.sleep(2000);
		msgPage.clickSendNewMessage().composeNewMessage(data).sendComposedMessage();
		Thread.sleep(6000);
		homeWebPage.switchingToZerothWindow();
		Thread.sleep(5000);
		Utils.uBase.refresh();
		/*
		 * 2. Verify items received from identified spam accounts are received into the
		 * proper folder, and not the spam folder.
		 */
		hmPage.clickMainMenu().clickTab("MessagesTab");
		msgPage.verifyMsgsSentDirectlyToMsgFolder();
		hmPage.clickOnSpamTab();
		spamPage.verifySpamSentDirectlyNotIntoToSpamFolder();
		hmPage.clickSettings();
		settPage.spamFilterToggleOn();
	}

	// Verify able to received missed calls email alert.
	public void settingsCallsMissedEmailAlert(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);

		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to "Calls"
		 * section. 4. Check/Uncheck the existing email addresses to receive missed call
		 * alert.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.clickSettings();
		// settingsPage.clickNewLinkedNumber().enterMobileNoToBeLinked(Constants.SAMSUNGGalaxyNote9_Numb1).clickSendBtnLinkedNoDialog().addLnkdNum();
		/*
		 * Verification: 1. Verify after few seconds, if checked the forwarding phone
		 * number, you are able to receive missed calls email alert, which forwarding
		 * from the GV number. 2. Verify after few seconds, if unchecked forwarding
		 * phone number, you are not able to receive missed calls email alert, which
		 * forwarding from the GV number.
		 */

		settingsPage.clickCallsInSettings().voicemailFwdViaEmailToggleActions(Constants.ON);
		// homePage.clickGoogleApps();
		// homePage.clickGmail();
		// gmail.verifyIfVoicemailNotificationIsReceived(Constants.ON, data);
		//
		// settingsPage.voicemailFwdViaEmailToggleActions(Constants.OFF);
		// gmail.verifyIfVoicemailNotificationIsReceived(Constants.OFF, data);

		// settingsPage.clickMessagesInSettings().msgEmailToggleActions(Constants.ON);
		// gmailPage.verifyEmailIsSentWhenToggleIsOn(data, Constants.True);
		// settingsPage.msgEmailToggleActions(Constants.OFF);
		// gmailPage.verifyEmailIsSentWhenToggleIsOn(data,Constants.False);
	}

	public void settingsRedirectToRightUser(String email, String password, String data) throws Exception {

		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		/*
		 * Pre-Condition: Google Voice account is activated for this account.
		 */

		// Calling main java pages using PageFactory

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		HomePageWeb hmWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		LegacyGVPage leagacyPage = PageFactory.initElements(Utils.uBase.webDriver, LegacyGVPage.class);
		GeneralActivitiesPage GAPage= PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmWeb.clickgoogleAccountIcon().clickAddAccountOption();

		gvSignInPage.enterLoginID(Constants.voipTwoId).clickNextButton().enterPassword(Constants.pwd2)
				.clickNextButton();
		hmPage.clickSettings();
		settPage.getGvNum().clickCloseSettings();
		hmPage.clickMainMenu().clickLegacyGoogleVoice();
		Thread.sleep(7000);
		GAPage.switchingToWindowByIndex(2);
		hmPage.verifyLegacyWindow();
		leagacyPage.getGvNum().compareGvNum();
		hmWeb.switchingToZerothWindow();
		hmPage.clickSettings();
		settPage.getGvNum().clickCloseSettings();
		hmPage.clickMainMenu().clickLegacyGoogleVoice();
		GAPage.switchingToWindowByIndex(3);
		hmPage.verifyLegacyWindow();
		leagacyPage.getGvNum().compareGvNum();
	}

	public void settingsWebNotifications(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SettingsPage settPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		HomePageWeb homePageWeb = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		DesktopNotificationPage deskNotificationPage = PageFactory.initElements(Utils.uBase.webDriver,
				DesktopNotificationPage.class);
		GeneralActivitiesPage gaPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		/*
		 * Pre-Condition: 1. Shouldn't have accept or denied the notification option. 2.
		 * Already having GV number with at least one forwarding phone.
		 */
		Thread.sleep(2000);

		/*
		 * Verification If enabled: 1. Verify after few seconds, that particular Google
		 * voice account is getting desktop notification, when inactive.
		 */
		settPage.desktopNotifications_ChromeSettingsPage("enable");

		/*
		 * Procedure: 1. Login 2. Navigate to Moya Settings page. 3. Scroll to
		 * "Web notifications" section. 4. Enable the
		 * "Get notifications of Google voice activity through your browser".
		 */

		hmPage.clickSettings();
		settPage.clickWebNotificationsInSettings().verifyWebNotificationStatus(true);

		homePageWeb.clickGoogleAccountIcon().clickAddAccountOption();
		String str[] = data.split("\\|");
		gvSignInPage.enterLoginID(str[0]).clickNextButton().enterPassword(str[1]).clickNextButton();
		homePageWeb.syncWithLoggedInId();
		gvSignInPage.enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		homePageWeb.clickSync();

		hmPage.clickMainMenu().clickTab(Constants.Messages);
		msgPage.clickSendNewMessage().setNumMsgToField(str[2]).setTextNewMsg(gaPage.generateUniqueString())
				.clickToMsgTxt().sendComposedMessage();
		deskNotificationPage.verifyTxtMsgNotification();

		settPage.navigate_ChromeBrowserSettings();
		settPage.navigate_ChromeBrowserNotificationSettings();

		/*
		 * Verification if not enabled: 1. Verify after few seconds, that particular
		 * Google voice account is not getting desktop notification, when inactive.
		 * 
		 */
		settPage.desktopNotifications_ChromeSettingsPage("disable");
		Thread.sleep(5000);
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		msgPage.clickSendNewMessage().setNumMsgToField(str[2]).setTextNewMsg(gaPage.generateUniqueString())
				.clickToMsgTxt().sendComposedMessage();
		Thread.sleep(8000);
		deskNotificationPage.verifyTxtMsgNotificationDisappear();

		Thread.sleep(2000);

		Utils.uBase.switchToOldWindow();
		settPage.desktopNotifications_ChromeSettingsPage("enable");
	}

	// UI Privacy Terms
	public void settingsPrivacyAndTerms(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage settingPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		HomePageWeb hmWebPage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();

		/* Verifications : Click Settings on home page */
		hmMenuPage.clickSettings();

		// To dismiss notification
		Utils.uBase.clickOnNotificationAllowBtn();

		/* Verify: redirected to setting page */
		hmMenuPage.verifyRedirectedtoSettingPage();

		/* Verifications : Click on Privacy and Terms */
		settingPage.verifyClickOnPrivacyTerms();

		/* Verify: Click on Privacy */
		settingPage.verifyClickOnPrivacy();
		hmWebPage.switchingToFirstWindow();

		/* Verify: Redirected to Privacy */
		settingPage.verifyRedirectedToPrivacy();

		hmWebPage.switchingToZerothWindow();

		/* Verify: Click on Terms */
		settingPage.verifyClickOnTerms();
		// hmWebPage.switchingToFirstWindow();

		/* Verifications : Redirected to terms */
		settingPage.verifyRedirectedToTerms();
	}

	/* Verify correct Google Voice number is displayed. */
	public void settingsKeyBoard(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/* Pre-Condition: Google Voice account is activated for this account. */

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);

		/* Procedure: 1. Navigate to the Moya settings page. */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton()
				.dailyURL();
		hmPage.verifyCallPanelInRight();
		/*
		 * hmPage.clickSettings(); Verification: 1. Verify that, displaying correct
		 * google voice phone number.(In Current Build country code is visible) 2.
		 * Verify that, it also displayed with buttons to "Change" number, "Transfer"
		 * number, and "Delete" GV number. stngpg.verifygvNumDisplayed(data);
		 * stngpg.verifyChangeBtnDisplayed().verifyTransferDisplayed().
		 * verifyDeleteBtnDisplayed();
		 */
	}
}
