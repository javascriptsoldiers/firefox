package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class TopNandFavoriteContactUI extends SuiteBase {

	// Adding topN contact to To field
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

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickMessages();
		msgpg.clickSendNewMessage().clickSendNewMessage().verifyPlaceholderTextDisplayed()
				.verifyCursorAutofocusedToField().verifySuggestionandContactListDisplayed().selectContactFromSuggestions().verifyToFieldChipName();
	}

	// TopN & Favorite & Full contact preview Details
	public void topNFavoriteFullContactPreviewDetails(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Goto Mesages/Calls tab 2. Click on 'Send a Message/Make a Call' button.
		 * 3.Cursor is placed on 'To/Call' field,dropdown/Ui page is displayed
		 */
		hmMenuPage.clickMainMenu().clickTab("Calls");
		callPage.EnteraNameOrNum();
		
		/*
		 * 1.Verify Favorite,TopN and User's contact list is displayed with Avatar or
		 * picture inside a circle if added
		 */
		callPage.verifySuggestionandContactListDisplayed();

		// Verify Avatar contains the first alphabet of the name of contact saved
		// Ex:avatar has ''S" from contact named Sam
		msgPage.verifyAvatarContainsFirstAlphabetOfContactNameInSuggestions();
		msgPage.verifyAvatarContainsFirstAlphabetOfContactNameInAllContacts();

		/*
		 * Verify contact name pop up with pic and label
		 * callPage.verifyContactNamePopUp(data);
		 */

		// Refresh page
		Utils.uBase.refresh();
		hmMenuPage.clickMainMenu().clickTab("MessagesTab");
		msgPage.clickSendNewMessage();

		/*
		 * 1.Verify Favorite,TopN and User's contact list is displayed with Avatar or
		 * picture inside a circle if added
		 */
		msgPage.verifySuggestionandContactListDisplayed();

		/*
		 * Verify Avatar contains the first alphabet of the name of contact saved
		 * Ex:avatar has ''S" from contact named Sam
		 */
		msgPage.verifyAvatarContainsFirstAlphabetOfContactNameInSuggestions();
		msgPage.verifyAvatarContainsFirstAlphabetOfContactNameInAllContacts();
	}

	// Call UI page Items display
	public void callUIPageItemsDisplay(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Procedure: 1. Go to Call tab 2. Click on 'Make a Call' button 3. Cursor is
		 * placed on 'Call' field,Ui page is displayed
		 */
		hmMenuPage.clickMainMenu().clickTab("Calls");
		callPage.EnteraNameOrNum();

		/*
		 * Verification: 1. TopN and Favorite contact can display together maximum of
		 * Eight contacts in One horizontal row. 2. Full Contact list is displayed below
		 * the TopN and Favorite contact list i.e Vertical list. Please note - as per
		 * new UI, TopN and Favorite are not displayed. Suggestions and all contacts are
		 * displayed.
		 */

		/*
		 * 1.Verify Favorite,TopN and User's contact list is displayed with Avatar or
		 * picture inside a circle if added
		 */
		callPage.verifySuggestionandContactListDisplayed();
	}

	// Call Select Contact TopN & Favorite & Contacts list
	public void callSelectContactTopNFavoriteContactsList(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Procedure: 
		  		1. Login 
		 		2. Click on Call 
		 		3. Click on 'Make a Call' button
		 */
		hmMenuPage.clickMainMenu().clickTab("Calls");
		//callPage.clickOnMakeACall();
		callPage.MakeACall();
		/*
		 * Verification:
		 1. Cursor is auto focused in the recipient picker field of calls section. 
		 2. Place holder text of 'Call' field is 'Type a name or phone number' 
		 3. Verify UI page displayed with TopN and Favorite contacts and followed by full Contact suggestion list. */
		
		callPage.verifyCursorAutoFousedInCallField();
		callPage.verifyPlaceHolderInCallField();
		callPage.verifySuggestionandContactListDisplayed();

		/* Procedure: 4.Select any contact in the UI list by clicking on it. */
		callPage.clickContactFromDropDown();
		Utils.uBase.clickOnNotificationAllowBtn();

		/* Verification: 
		 		4.Verify that Call is placed when clicking on any contact in list. 
		 		5.Verify that selected contact number is displayed in recipient picker i.e 'Call' field. Please note: contact number is not displayed in call filed  */
		callPage.verifyAbleToMakeCall().verifySelectedContactDuringCall();
		
	}

	// Use Up/Down arrow keys to select contact
	public void useUpDownArrowKeyToSelectContact(String email, String password, String data) throws Exception {
		// Launching google voice web application
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmMenuPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/*
		 * Procedure: 1. Login 2. Click on Call 3. Click on 'Make a Call' button
		 */
		hmMenuPage.clickMainMenu().clickTab("Calls");
		callPage.EnteraNameOrNum();

		/*
		 * Verification: 1.Verify that only first 8 favorite contacts are displayed -
		 * TopN contacts are always 8 (favorites + Suggested) Please Note: *As per new
		 * UI, only suggestions and all contacts are shown 2.Verify able to use UP/DOWN
		 * arrow key to navigate through the contact in the list.
		 */
		callPage.verifyCursorAutoFousedInCallField();
		callPage.verifySuggestionandContactListDisplayed();
		callPage.verifyDownArrowKeyToNavigateSuggestionList().verifyDownArrowKeyToNavigateContactList();
		callPage.verifyUpArrowKeyToNavigateContactList().verifyUpArrowKeyToNavigateSuggestionList();

		/*
		 * 3.Verify by using ENTER key from keyboard able to select the contact from the
		 * list. 4.Verify Selected contact is displayed at recipient picker.
		 */
		callPage.enterKeyToSelectContactFromDropDown();
		Utils.uBase.clickOnNotificationAllowBtn();
		callPage.verifyAbleToMakeCall();
		callPage.clickOnCallEndBtn();

		/* Refresh Page */
		
		  Utils.uBase.refresh();
		  
		  /* Procedure: 1. Login 2. Click on Messages 3. Click on 'Send new message' button */
		  hmMenuPage.clickMainMenu().clickTab("MessagesTab");
		  msgPage.clickSendNewMessage();
		  
		  /* Verification: 1.Verify that only first 8 favorite contacts are displayed -
		  TopN contacts are always 8 (favorites + Suggested) Please Note: *As per new
		  UI, only suggestions and all contacts are shown 2.Verify able to use UP/DOWN
		  arrow key to navigate through the contact in the list. */
		  msgPage.verifySuggestionandContactListDisplayed();
		  
		  callPage.verifyDownArrowKeyToNavigateSuggestionList().
		  verifyDownArrowKeyToNavigateContactList();
		  callPage.verifyUpArrowKeyToNavigateContactList().verifyUpArrowKeyToNavigateSuggestionList();
		  
		  /* 3.Verify by using ENTER key from keyboard able to select the contact from the
		  list. 4.Verify Selected contact is displayed at recipient picker. */
		  callPage.enterKeyToSelectContactFromDropDown();
		  // callPage.verifyAbleToMakeCall();
		  msgPage.verifyPhoneChipCreated();
	}

	// Able to add multiple contacts to send Group message
	public void groupMessageSelectMultipleMaxiumNumberContact(String email, String password, String data)
			throws Exception {
		Utils.uBase.launchWebApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/*
		 * Procedure: 1. Click on Messages tab 2. Click on 'Send a Message' button 3.
		 * Select a contact from Favorite contacts or TopN contact suggestions list from
		 * dropdown. 4.Click on multiple contacts to add and form a group.
		 */

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickMainMenu().clickTab(Constants.Messages);
		msgPage.clickSendNewMessage().addPhoneNumbersList(Constants.SingleMsg, Constants.phoneNo);

		// Verification:
		// 1.Verify that selected contact number is added to 'To' field.
		// 2.Verify "Phone chip" is displayed and cursor is still present in 'To' filed.
		// 3.Verify Place holder displays a text "Add recipients".

		msgPage.verifyPlaceholderText().verifySelectedNoAddedInToField(data);

		// 4.Verify multiple contacts can be added.
		msgPage.addPhoneNumbersList(Constants.GroupMsg, data).verifyContactsDisplayed(data);

		// 5.The maximum number of members/contacts that can be added in a group
		// conversation is 19 i.e 19 phone chips can be displayed.*/
		msgPage.verifyChipsCount(Constants.chipCount);

	}
}
