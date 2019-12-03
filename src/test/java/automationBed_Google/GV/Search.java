package automationBed_Google.GV;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.GeneralActivitiesPage;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.SearchPage;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class Search extends SuiteBase{
	public void searchTextInContactName(String email, String password, String data) throws Exception {

		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/*Pre-Condition: GV full account have multiple messages, calls and voicemails from different contact phone numbers.*/

		// Calling main java pages using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SearchPage searchPge = PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);

		/*
		 * Procedure: 1.  Verify that as soon as typed text, it will display few matched items in the search drop down box itself.
		 * 2.Verify that, it displayed the matched contact names.
		 * 3.Click on that contact name, opens the contact details page.
		 */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		searchPge.enterTextInSearchBox(data).nameSuggestionsList(data).verifyContactDetails();;
	}
	public void searchContactPageMessageItems(String email, String password, String data) throws Exception {

		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/* Pre-Condition:  GV full account have multiple messages, calls and voicemail from different contact phone numbers. */

		// Calling main java pages using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SearchPage searchPge = PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Procedure: 1. Type some text which is in messages.
		 * 2.Verify that, it shows all items which is relevant to the selected user.
 		   3. Verify that, by clicking on message item it opening the message in details. */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		GAPage.receiveMultipleMessages(Constants.voipTwoId, Constants.pwd2,Constants.voipOneNo, 2);
		searchPge.clickOnSearchBar().enterTextInSearchBox(data).verifySearchSuggestionListDisplayed().verifyContactListDisplayed().selectFromContactPopUp().verifyContactDetails().verifyMessageItemsDisplayed().clickMessageItems().verifyMessageDetailsOpened();
	}
	//  Search.ContactPageCallButton - Verify contact page call button functionality.
	public void searchContactPageCallButton(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SearchPage searchPage = PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);
		GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		/* 2. Type some text which is in messages.
    	    3. Select the contact name from the suggestion list.*/
		searchPage.enterTextInSearchBox(data);
		searchPage.verifySearchSuggestionListDisplayed();    
		//searchPage.selectFromSearchSuggestionList();
		searchPage.selectFromContactPopUp();

		/* Verification: 1. Verify that it opens the contact details page. */
		searchPage.verifyContactDetails();

		/* 2. Verify that, it has call button.
    		  3. Verify that, by click on call button takes to call popup to make a call. */
		searchPage.verifyCallButton(); 

		/*4. Click on call button. */
		searchPage.clickCallButton();
		searchPage.verifyAbleToMakeCall();
	}   

	// Search Contact Page Info Button - Verify contact page INFO button functionality.
	public void searchContactPageInfoButton(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SearchPage searchPage = PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
		MessagePage msgPage = PageFactory.initElements(Utils.uBase.webDriver, MessagePage.class);

		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* 2. Type some text which is in messages.
    	    3. Select the contact name from the suggestion list.
    		4. Click on INFO button. */
		searchPage.enterTextInSearchBox(data);
		searchPage.verifySearchSuggestionListDisplayed();    
		//searchPage.selectFromSearchSuggestionList();
		searchPage.selectFromContactPopUp();


		/* Verification: 1. Verify that it opens the contact details page. */
		searchPage.verifyContactDetails();

		/*  2. Verify that, it has INFO button.
    	  3. Verify that, by click on INFO button takes to google contacts page for that user. */
		searchPage.verifyInfoLink();
		searchPage.clickOnInfoLink();
		searchPage.verifyGoogleContactPageDisplayed();
	}   

	// Search .Select Contact Name
	public void searchSelectContactName(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();

		// Initiating java page into object using PageFactory
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		SearchPage searchPage = PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
		
		/* Procedure: Sign in into the application */
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();

		/* 2. Click on Search box
		   3. Select the contact name (which has no transaction) */
		searchPage.enterTextInSearchBox(data);
		
		/* Verification:
			  1. Verify that, selected contact should not have any transaction items.
			  2. Verify that, selected contact should not show other phone number transaction items */
		searchPage.verifyNoTransactionListDisplayed(data);    
	} 


    public void searchTextInMessage(String email, String password, String data) throws Exception {
    	/* Launching google voice application */
    	Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1. Login 2. Type some text which is in messages. 3. Click on
		 * "magnifier" or press Enter key.
		 */
    	GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
    	SearchPage srchPage=PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
		/*
		 * Verification: 1. Verify that as soon as typed text, it will display few
		 * matched items in the search drop down box itself. 2. Verify that, by clicking
		 * on the result items takes to the actual full message conversation details. 3.
		 * Verify that the searched text is "highlighted" all over the found items.
		 */
    	gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
    	srchPage.sendDataInSearchBar(data).verifySearchSuggestionListDisplayed().verifyMatchedItems(data).selectFromSuggestions().verifyMatchedTextHighlight();
    }
    
    public void searchContactPageElements(String email, String password, String data) throws Exception {
    	/* Launching google voice application */
    	Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1. Login 2. Type some text which is in messages. 3. Select the
		 * contact name from the suggestion list.
		 */
    	GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
    	SearchPage srchpage=PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
		/*
		 * Verification: 1. Verify that it opens the contact details page. 2. Verify
		 * that, it has the profile picture avatar, phone number. 3. Verify that, it has
		 * links to "Message", "Calls", "INFO" 4. Verify that, it shows all items which
		 * is relevant to the selected user.
		 */
    	gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
    	srchpage.sendDataInSearchBar(data).verifySearchSuggestionListDisplayed().verifyContactListDisplayed().selectFromContactPopUp().verifyContactDetails().verifyMessageLink().verifyCallLink().verifyInfoLink();
    	srchpage.verifyAvatar().verifyPhoneNumber().verifyReleventItemsOfContactDisplayed(data);
    }
    public void searchContactPageCalltems(String email, String password, String data) throws Exception {
    	/* Launching google voice application */
    	Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1. Login 2. Type some text which is in messages. 3. Select the
		 * contact name from the suggestion list. 4. Click on any of the "call item"
		 */
    	GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
    	SearchPage srchPage=PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
    	GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*
		 * Verification: 1. Verify that it opens the contact details page. 2. Verify
		 * that, it shows all items which is relevant to the selected user. 3. Verify
		 * that, by clicking on call item it opening the call in details.
		 */
    	gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
    	GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2,Constants.voipOneNo, 1);
		/*
		 * Actions keyAction = new Actions(Utils.uBase.webDriver);
		 * keyAction.sendKeys(Keys.ENTER);
		 */
    	srchPage.clickOnSearchBar().enterTextInSearchBox(data).verifySearchSuggestionListDisplayed().verifyContactListDisplayed().selectFromContactPopUp().verifyContactDetails().clickOnCallItems().verifyCallDetailsExpanded();
    }
    public void searchContactPageMessageButton(String email, String password, String data) throws Exception {
    	/* Launching google voice application */
    	Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1. Login 2. Type some text which is in messages. 3. Select the
		 * contact name from the suggestion list. 4. Click on message button
		 */
    	GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
    	SearchPage srchpage=PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
		/*
		 * Verification: 1. Verify that it opens the contact details page. 2. Verify
		 * that, it has message button. 3. Verify that, by click on message button takes
		 * to message folder to send new message.
		 */
    	gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
    	srchpage.sendDataInSearchBar(data).verifySearchSuggestionListDisplayed().verifyContactListDisplayed().selectFromContactPopUp().verifyContactDetails().verifyMessageLink().clickMessageLink().verifyMessageFolder();
    }
    
    public void searchContactPageVoiceMailItems(String email, String password, String data) throws Exception {
    	/* Launching google voice application */
    	Utils.uBase.launchWebApplication();
    	  
		/*
		 * Procedure: 1. Login 2. Type some text which is in messages. 3. Select the
		 * contact name from the suggestion list. 4. Click on any of the
		 * "voicemail item"
		 */
    	GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
    	SearchPage srchpage=PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
    	GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);
		/*
		 * Verification: 1. Verify that it opens the contact details page. 2. Verify
		 * that, it shows all items which is relevant to the selected user. 3. Verify
		 * that, by clicking on voicemail item it opening the voicemal in details.
		 */
    	gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
    	GAPage.receiveMultipleVoicemails(Constants.voipTwoId, Constants.pwd2,Constants.voipOneNo, 2);
    	srchpage.clickOnSearchBar().enterTextInSearchBox(data).verifySearchSuggestionListDisplayed().verifyContactListDisplayed().selectFromContactPopUp().verifyContactDetails().clickOnVoiceMailItems().verifyVoiceMailExpanded();
    }
    
    public void searchClickHistory(String email, String password, String data) throws Exception {
    	/* Launching google voice application */
    	Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1. Login 2. Click on search box to get drop-down (along with
		 * recent search history) 3. Click on any of the history.
		 */
    	GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
    	SearchPage srchpage=PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
		/*
		 * Verification: 1. Verify that it returns the result of items as same as usual
		 * search text by typing on the input box.
		 */
    	gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
    	srchpage.clickOnSearchBar().sendDataInSearchBar(data).pressEnter();
    	srchpage.clearTextInSearchField().clickOnSearchBar().clickFirstHistorySuggestion().verifyBeforeAndAfterEnteringText();
    }
    public void searchMakeHistory(String email, String password, String data) throws Exception {
    	/* Launching google voice application */
    	Utils.uBase.launchWebApplication();
    	/*
		 * Procedure: 1. Login 2. Type some text to search 3. Click on "magnifier" or
		 * press Enter key.
		 */
    	GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
    	SearchPage srchpage=PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
		/*
		 * Verification: 1. Click on search box to get drop-down list. 2. Verify that
		 * the last recent search is updated in the drop-down. 3. Verify that maximum of
		 * recent searched texts are 3.
		 */
    	gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
    	String str[] = data.split("\\|");
    	System.out.println("length" + data.length());
    	for(int i=0;i<str.length;i++) {
    	srchpage.clickOnSearchBar().sendDataInSearchBar(str[i]).pressEnter().clearTextInSearchField();
    	}
    	srchpage.clickOnSearchBar().verifySearchHistoryHasMaxThreeEntries(str[0]);
    }
    public void searchTextInVoicemails(String email, String password, String data) throws Exception {
    	/* Launching google voice application */
    	Utils.uBase.launchWebApplication();
    	/*Procedure:
    		  1. Login
    		  2. Type some text which is in messages.
    		  3. Click on "magnifier" or press Enter key*/
    	GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
    	SearchPage srchpage=PageFactory.initElements(Utils.uBase.webDriver, SearchPage.class);
    	 /*Verification:
    		  1. Verify that as soon as typed text, it will display few matched items in the search drop down box itself.
    		  2. Verify that, by clicking on the result items takes to the actual voice mail details.
    		  3. Verify that the searched text is "highlighted" all over the found items.*/
    	gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
    	srchpage.sendDataInSearchBar(data).verifySearchSuggestionListDisplayed().verifyMatchedItems(data).selectVoiceMailFromSuggestions().verifyMatchedTextVoiceMailHighlight();
    }

}


