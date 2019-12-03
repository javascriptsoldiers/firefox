package automationBed_Google.GV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.PeopleAndOptionPage;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class PeopleAndOption extends SuiteBase {
	
	/* Verify able to add new phone number in to contact */
	public void peopleAndOptionAddContactLocalNumber(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		
		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		PeopleAndOptionPage peopOptinpage = PageFactory.initElements(Utils.uBase.webDriver, PeopleAndOptionPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Login to Application and selecting the home button */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().enterVoip1PhoneNumAndMakeAcall().clickOnCallEndBtn();
		Utils.uBase.clickByImage("CloseButtonOnPromt3");
		Utils.uBase.refresh();
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		/*
		 * Pre-Condition: Message, call, voicemail items from non-contact phone numbers.
		 */
		//ReceiveCallAndMessages.receiveMessage(data);
		msgPage.clickSendNewMessage().composeNewMessage(data).sendComposedMessage();
		Utils.uBase.refresh();
		Thread.sleep(2000);
		/*
		 * Procedure: 1. click on conversation item. 2. Get "People and option" panel 3.
		 * click on "Add contact" icon 4. Type contact name 5. Type "phone type"
		 * optional 6. Click "Add"
		 */
		msgPage.clickFirstMessage().clickThreeDotsMenu();
		peopOptinpage.clickPeople().addToContact();

		/*
		 * Verification: 1. Verify that, after completion of the dialog the respective
		 * conversation item and "People and option" phone number should be added with
		 * new contact name.
		 */
		peopOptinpage.verifyPhoneNumberAddedWithNewContactName();

		/*
		 * 2. Verify that, all the relevant conversation items should be replaced
		 * withthat new contact name. 3. Verify that, the phone type you
		 * selected/typedshould be reflected in "People and option" panel as well as"To"
		 * address
		 */
		peopOptinpage.verifyAllContactNameReplacedWithNewContact();
		/* Deleted addad contact and test data cleared */
		peopOptinpage.clickOnGoogleAppsMenu().clickOnContactsOptionFromGoogleApps().deleteAddedContact();
	}

	/* Verify able to add new international phone number in to contact */
	public void peopleAndOptionAddContactInternationalNumber(String email, String password, String data)
			throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		
		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		PeopleAndOptionPage peopOptinpage = PageFactory.initElements(Utils.uBase.webDriver, PeopleAndOptionPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		
		/*
		 * Pre-Condition: 
		 * Message, call, voicemail items from non-contact phone numbers.
		 */
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.EnteraNameOrNum().enterVoip1PhoneNumAndMakeAcall().clickOnCallEndBtn();
		hmPage.clickMessages();
		Utils.uBase.clickByImage("CloseButtonOnPromt3");
		msgPage.clickSendNewMessage().composeNewMessage(data).sendComposedMessage();
		Utils.uBase.refresh();
		Thread.sleep(2000);
	
		/*
		 * Procedure: 1. click on conversation item. 2. Get "People and option" panel 3.
		 * click on "Add contact" icon on the international phone number. 4. Type
		 * contact name 5. Type "phone type" optional 6. Click "Add"
		 */
		msgPage.clickFirstMessage().clickThreeDotsMenu();
		peopOptinpage.clickPeople().addToContact();
		
		/*
		 * Verification for calls: 1. Verify that, after completion of the dialog the respective
		 * conversation item and "People and option" phone number should be added with
		 * new contact name.
		 */
		peopOptinpage.verifyInterNationalPhNumAddedWithNewContactName();
		/*
		 * 2. Verify that, all the relevant conversation items should be replaced with
		 * that new contact name. 3. Verify that, the phone type you selected/typed
		 * should be reflected in "People and option" panel as well as "To" address
		 * peopOptinpage.verifyContactNameReplacedWithNewContact();
		 */
		//peopOptinpage.verifyContactNameReplacedWithNewContact();
	
		/*
		 * Verification for messages: 1. Verify that, after completion of the dialog the respective
		 * conversation item and "People and option" phone number should be added with
		 * new contact name.
		 */
		hmPage.clickMainMenu().clickTab("Calls");
		callsPage.selectFirstContactFromCallsList();
		peopOptinpage.verifyInterNationalPhNumAddedWithNewContactName();
		
		/*
		 * 2. Verify that, all the relevant conversation items should be replaced with
		 * that new contact name. 3. Verify that, the phone type you selected/typed
		 * should be reflected in "People and option" panel as well as "To" address
		 * peopOptinpage.verifyContactNameReplacedWithNewContact();
		 */
		callsPage.clickThreeDotsMenu();
		peopOptinpage.clickPeople().verifyContactNameReplacedWithNewContact();

		/* Deleted addad contact and test data cleared */
		peopOptinpage.clickOnGoogleAppsMenu().clickOnContactsOptionFromGoogleApps().deleteAddedContact();
	}
	
	/* Verify able to add new short code phone number in to contact */
	public void peopleAndOptionContactShortCode(String email, String password, String data)
			throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		/* Initiating the java page into object using PageFactory */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		PeopleAndOptionPage peopOptinpage = PageFactory.initElements(Utils.uBase.webDriver, PeopleAndOptionPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		
		/* Login to Application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 Pre-Condition:Message, call, voicemail items from non-contact phone numbers.
		 */
		hmPage.clickMainMenu().clickMessages();
		msgPage.clickSendNewMessage().composeNewMessage(data).sendComposedMessage();

		/*
		 * Procedure: 1. click on conversation item. 2. Get "People and option" panel 3.
		 * click on "Add contact" icon on the international phone number. 4. Type
		 * contact name 5. Type "phone type" optional 6. Click "Add"
		 */
		//Thread.sleep(3000);
		//GAPage.clickFirstItemInList();
		msgPage.selectFirstItemFromList().clickThreeDotsMenu();
		peopOptinpage.clickPeople().addToContact();
		Thread.sleep(2000);
		Utils.uBase.refresh();
		Thread.sleep(2000);
				/*
		 * Verification for message: 1. Verify that, after completion of the dialog the respective
		 * conversation item and "People and option" phone number should be added with
		 * new contact name.*/
		peopOptinpage.verifyShortCodeContactNameReplacedWithNewContact();
		
		/*2. Verify that, all the relevant conversation items should be replaced with
		  that new contact name.3. Verify that, the phone type you selected/typed
		 should be reflected in "People and option" panel as well as "To" address*/
		peopOptinpage.verifyShortCodeContactNameReplacedWithSelectedType();
		
		/* Test data clearance: Deleted added contact*/
		peopOptinpage.clickOnGoogleAppsMenu().clickOnContactsOptionFromGoogleApps().deleteAddedContact();
	}
}


