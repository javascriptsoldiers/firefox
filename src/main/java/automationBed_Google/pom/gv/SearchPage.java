package automationBed_Google.pom.gv;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.Screen;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SearchPage {
	public static final String IMAGES_BASE_FOLDER_NAME = "\\src\\test\\resources\\Images\\";
	Screen screen = new Screen();
	public AndroidDriver<AndroidElement> mDriver = null;
	public WebDriver wDriver=null;
	public static String[] dataString;

	//	Locators
	@FindBy(xpath="//*[contains(@placeholder,'Search Google Voice')]")
	WebElement searchTxtField;
	@FindBy(xpath="//*[@role='gridcell']/*[@role='img']")
	WebElement threeDotsOption;
	@FindBy(xpath="(//*[contains(@class,'Bqxti')]//*[contains(@content,'Content')])[last()]")
	WebElement msgConversationContent;
	@FindBy(xpath="//*[contains(@class,'Gb0ubd-sn54Q')]")
	List<WebElement>contactList;
	@FindBy(xpath="//div[contains(@class,'er layout-column')]//*[contains(@class,'grey-900')]")
	WebElement contactDetails;
	@FindBy(xpath="//*[contains(@class,'Vupfr-ibnC6b')]//*[contains(@content,'ctrl.previewText')]")
	WebElement clickMessage;
	@FindBy(xpath="//mat-divider[@class='mat-divider mat-divider-horizontal']/parent::div")
	List<WebElement> suggestionList;
	//@FindBy(xpath="//*[contains(@class,'gb_Ze gb_Ec')]")
	@FindBy(xpath="//*[@id='gb']/div[2]/div[2]/div[2]/form/div/input")
	WebElement searchField;
	@FindBy(xpath="//div[@class='rkljfb-MZArnb flex']")
	List<WebElement> transactionList;
	@FindBy(xpath="(//*[contains(@ng-repeat,'searchResult in ctrl.getConversationSearchResults()')])[1]")
	List<WebElement> matchedContentSuggestions;
	@FindBy(xpath="//*[contains(@ng-class,'DETAILS')]//gv-annotation[contains(@content,'ProfileNames')]")
	//md-virtual-repeat-container[@class='md-virtual-repeat-container md-orient-vertical flex']//gv-annotation[@gv-test-id='item-contact']
	List<WebElement> nameList=new ArrayList<>();
	@FindBy(xpath="//*[contains(@class,'md-ink-ripple layout-align-start-center layout-row gmat-body-2 rkljfb-H9tDt')]")
	List<WebElement> entries;
	@FindBy(xpath="//*[contains(@ng-repeat,'recentSearch in ctrl.getRecentSearches()')]")
	List<WebElement> searchHistory;

	@FindBy(xpath="//*[contains(@md-virtual-repeat,'conversation in ctrl.getDisplay()')]")
	List<WebElement> searchHistoryListByEnteringTxt;
	@FindBy(xpath="//*[contains(@md-virtual-repeat,'conversation in ctrl.getDisplay()')]")
	List<WebElement> searchHistoryListBySelectingFromHistory;
	@FindBy(xpath="//*[contains(@class,'layout-row wAp0Zd-H9tDt')]")
	WebElement fistSearchHistory;
	@FindBy(xpath="//*[contains(@class,'V8G9F-H9tDt gvPageRoot')]/gv-contact-list/div/div/div/gv-frequent-contact-card")
	List<WebElement> searchSuggestionList;
	@FindBy(xpath="(//*[contains(@svg-icon,'voicemail')])[last()]")
	WebElement voicemailIconInSuggestion;
	@FindBy(xpath="//*[contains(@class,'Gb0ubd-sn54Q')]")
	List<WebElement> searchNameList;
	@FindBy(xpath="//span[contains(@class,'Gb0ubd-sn54Q')]")
    List<WebElement> contactNameList;


	public SearchPage nameSuggestionsList(String data)
	{ 
		try
		{
			Thread.sleep(5000);
			if(searchNameList.size()!=0) {
				for (int j = 0; j < searchNameList.size(); j++) {
					WebElement eleSearchNameList = searchNameList.get(j);
					String msgText = eleSearchNameList.getText();
					if(msgText.contains(data)) {
						AdvanceReporting.addLogs("pass","Contact name found : "+msgText );
						Utils.uBase.waitForElementToBeClickable(eleSearchNameList);
						Utils.uBase.clickWebelement(eleSearchNameList);
					}
				}
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SearchPage clickSearchField(String data)
	{ 
		try
		{
			Thread.sleep(5000);
			Utils.uBase.setText(searchTxtField,data);
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Text entered : "+data);
			AdvanceReporting.addLogs("pass", "text from messasge entered","text");
			List<WebElement> searchTextList = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@ng-class,'(searchResult) ? ctrl.Css.HIGHLIGHT')]//*[contains(@content,'ctrl.previewText')]"));			
			if(searchTextList.size()!=0) {
				for (int j = 0; j < searchTextList.size(); j++) {
					WebElement eleSearchTextList = searchTextList.get(j);
					String msgText = eleSearchTextList.getText();
					if(msgText.contains(data)) {
						AdvanceReporting.addLogs("pass","message text found : "+msgText );
						Utils.uBase.waitForElementToBeClickable(eleSearchTextList);
						Utils.uBase.clickWebelement(eleSearchTextList);
						Thread.sleep(4000);
						Utils.uBase.waitForElementToBeClickable(clickMessage);
						Utils.uBase.clickWebelement(clickMessage);
						AdvanceReporting.addLogs("pass","message details displayed based on text search", "Message view");
						AdvanceReporting.addLogs("Pass","message details displayed");
						Thread.sleep(4000);
					}
					Thread.sleep(2000);
				}
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}



	// Enter text in search field */
	public SearchPage enterTextInSearchBox(String data) { 
		try {
			Thread.sleep(5000);
			Utils.uBase.clickOnNotificationAllowBtn();
			Thread.sleep(2000);
			Utils.uBase.setText(searchField,data);
			Thread.sleep(2000);
			AdvanceReporting.addLogs("pass", "Search text entered: "+data);
			AdvanceReporting.addLogs("info", "Search text entered","SearchText");
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Search text not entered");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;	
	}


	// Verify suggestion list is displayed on typing contact name in search 
	public SearchPage selectFromSearchSuggestionList(){ 
		try {
			Thread.sleep(5000);
			Utils.uBase.checkPageReady();
			Utils.uBase.clickWebelement(searchSuggestionList.get(0));
			Thread.sleep(3000);
			AdvanceReporting.addLogs("pass", "Contact selected from list");
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Contact not selected from the list");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	// Verify that, it has call button. 
	public SearchPage verifyCallButton(){ 
		try {
			Thread.sleep(8000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("callButton"), "Call button not displayed");
			AdvanceReporting.addLogs("info","Verified that call button displayed");
			AdvanceReporting.addLogs("Pass","Call button displayed","ConatctDetails");
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Call button not displayed");
			AdvanceReporting.addLogs("fail", "Call button not displayed");
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	// click on call button
	public SearchPage clickCallButton() { 
		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("callButton");
			Utils.uBase.clickOnNotificationAllowBtn();
			AdvanceReporting.addLogs("info", "Clicked on call button");
			AdvanceReporting.addLogs("pass", "Clicked on call button", "CallButton");

		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Not clicked on call");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// verify able to make call
	public SearchPage verifyAbleToMakeCall() { 
		try
		{
			if(Utils.uBase.imageCompare("searchCallingImg")==true){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call sucessfully");
				AdvanceReporting.addLogs("pass", "User able to make a call sucessfully","ableToCall");
			}else if(Utils.uBase.imageCompare("callFullScreen")==true){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call sucessfully");
				AdvanceReporting.addLogs("pass", "User able to make a call sucessfully","ableToCall");
			}
			else if(Utils.uBase.imageCompare("callValidationMsgTab")==true){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call sucessfully");
				AdvanceReporting.addLogs("pass", "User able to make a call sucessfully","ableToCall");
			}
			else if(Utils.uBase.imageCompare("callSearch")==true){
				AdvanceReporting.addLogs("pass", "Verified that user able to make a call sucessfully");
				AdvanceReporting.addLogs("pass", "User able to make a call sucessfully","ableToCall");		
			}else {
				AdvanceReporting.addLogs("fail", "User not able to make a call");
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "User not able to make a call");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// click on onfo link
	public SearchPage clickOnInfoLink() {
		try {
			Thread.sleep(8000);
			Utils.uBase.clickByImage("infoOptnInContactDetailPg");
			AdvanceReporting.addLogs("info", "Clicked on info link");
			AdvanceReporting.addLogs("pass", "Clicked on info link", "infolink");
		} catch(Exception e) {
			AdvanceReporting.addLogs("fail", "info option link is not present in contact details");
			AdvanceReporting.addLogs("info", "info option link is not present in contact details");
		}
		return this;
	}

	// click on onfo link
	public SearchPage verifyGoogleContactPageDisplayed() {
		try {
			Utils.uBase.switchToNewWindow();
			Thread.sleep(8000);
			Utils.uBase.checkPageReady();
			Assert.assertTrue(Utils.uBase.imageCompare("contactsPage"), "Google contact page not displayed");
			AdvanceReporting.addLogs("info", "Verified that google contact page displayed");
			AdvanceReporting.addLogs("pass", "Google contact page displayed", "googlecontact");
		} catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Google contact page not displayed");
			AdvanceReporting.addLogs("info", "Google contact page not displayed");
		}
		return this;
	}

	// Verify suggestion list is displayed on typing contact name in search 
	public SearchPage verifyNoTransactionListDisplayed(String name) { 
		try {
			Thread.sleep(15000);
			Utils.uBase.checkPageReady();
			if(transactionList.isEmpty()) {
				AdvanceReporting.addLogs("info", "Verified that no Transaction list displayed");
				AdvanceReporting.addLogs("pass", "No Transaction list displayed", "TransactionList");
			} else {
				int length = transactionList.size();
				for(int i=0; i<length; i++) {
					String contactName = transactionList.get(i).getText();
					if(contactName.equalsIgnoreCase(name)) {
						AdvanceReporting.addLogs("info", "Transaction list displayed");
						AdvanceReporting.addLogs("fail", "Transaction list displayed", "TransactionList");
					} else {
						AdvanceReporting.addLogs("info", "Verified that no Transaction list displayed");
						AdvanceReporting.addLogs("pass", "No Transaction list displayed", "TransactionList");
					}
				}}
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Transaction list displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}
	//To click on search bar
	public SearchPage clickOnSearchBar() {
		try {
			Utils.uBase.clickOnNotificationAllowBtn();
			Thread.sleep(4000);
			Utils.uBase.clickByImage("searchBar");
			Thread.sleep(4000);
			AdvanceReporting.addLogs("pass", "searchbar is clicked");
			AdvanceReporting.addLogs("pass", "searchbar is clicked","searchbarisclicked");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "searchbar is not clicked");
		}
		return this;
	}
	//To send data into search bar
	public SearchPage sendDataInSearchBar(String data) {
		try {
			Thread.sleep(4000);
			Utils.uBase.setText(searchTxtField, data);
			Thread.sleep(500);
			AdvanceReporting.addLogs("pass", "data is set in text field");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "text has been not set");
		}
		return this;
	}
	//To verify suggested list have matched text
	public SearchPage verifyMatchedItems(String data) {
		try {
			if(matchedContentSuggestions.get(0).getText().replaceAll("\\W", "").contains(data)) {
				AdvanceReporting.addLogs("pass", "Verified that items with matched content listed");
			}
			else {
				AdvanceReporting.addLogs("fail","no items with the given data");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail","no items with the given data");
		}
		return this;
	}
	// Verify suggestion list is displayed on typing contact name in search 
	public SearchPage verifySearchSuggestionListDisplayed() { 
		try {
			Thread.sleep(8000);
			Utils.uBase.checkPageReady();
			if(suggestionList.isEmpty()) {
				AdvanceReporting.addLogs("info", "Search Suggestion list not displayed");
				AdvanceReporting.addLogs("fail", "Search Suggestion list not displayed", "SuggestionContactlist");
			} else {
				AdvanceReporting.addLogs("info", "Verified that search Suggestion list displayed");
				AdvanceReporting.addLogs("pass", "Search Suggestionlist displayed", "SuggestionContactlist");
			} 
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Relevant contact list not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//To select the message from the suggestion list
	public SearchPage selectFromSuggestions() {
		try {
			Thread.sleep(9000);
			Utils.uBase.clickWebelement(matchedContentSuggestions.get(0));
			Thread.sleep(5000);
			AdvanceReporting.addLogs("pass", "selected the matched content text");
			AdvanceReporting.addLogs("pass", "selected the matched content text","selected the matched content text");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "can not select the matched content text");
		}
		return this;
	}
	//To verify selected message conversation has opened
	public SearchPage verifyConversationOpened() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("sendNewMsgInConversation"),"conversation not opened");
			AdvanceReporting.addLogs("pass", "matched conversation opened");
			AdvanceReporting.addLogs("pass", "matched conversation opened","matched conversation opened");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "matched conversation not opened");
		}
		return this;
	}
	//To verify matched text has been highlighted
	public SearchPage verifyMatchedTextHighlight() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("highlightedText"), "text not highlighted");
			AdvanceReporting.addLogs("pass", "Verified that text has highlighted");
			AdvanceReporting.addLogs("pass", "text has highlighted", "text has highlighted");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("pass", "text is not highlighted");
		}

		return this;
	}
	// Verify Suggestion and ContactList Displayed
	public SearchPage verifyContactListDisplayed() { 
		try {
			Thread.sleep(1000);
			if(contactNameList.isEmpty()) {
				AdvanceReporting.addLogs("info", "Relevant contact list not displayed");
				AdvanceReporting.addLogs("fail", "Relevant contact list not displayed", "SuggestionContactlist not present");
			} else {
				AdvanceReporting.addLogs("info", "Verified that relevant contact list displayed");
				AdvanceReporting.addLogs("pass", "Relevant contact list displayed", "SuggestionContactlist");
			} 
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Relevant contact list not displayed");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail(); 
		}
		return this; 
	}
	// Select a contact from the popup
	public SearchPage selectFromContactPopUp() { 
		try {
			Thread.sleep(1000);
			Utils.uBase.waitForElementToBeClickable(contactNameList.get(0));
			Utils.uBase.clickWebelement(contactNameList.get(0));
			AdvanceReporting.addLogs("info", "Relevant contact is selected");
			AdvanceReporting.addLogs("pass", "Relevant contact is selected", "RelevantContact");							
		} catch(Exception e) {
			AdvanceReporting.addLogs("info", "Contact not displayed");
			AdvanceReporting.addLogs("fail", "No Contact displayed");
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	// Verify suggestion list is displayed on typing contact name in search 
	public SearchPage verifyContactDetails(){ 
		try {
			Thread.sleep(1500);
			Assert.assertTrue(Utils.uBase.imageCompare("searchContactDetails"), "Contact details not displayed");
			AdvanceReporting.addLogs("info","Verified that contact details displayed");
			Thread.sleep(2000);
			AdvanceReporting.addLogs("Pass","Contact details displayed","ConatctDetails");
		} catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Contact details not displayed");
			e.printStackTrace(); Assert.fail(); 
		}
		return this;
	}

	//verify messageLink in contact details
	public SearchPage verifyMessageLink() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("msgOptnInContactDetailPg"), "message link not found in contact details");
			AdvanceReporting.addLogs("pass", "Verified that message option link present in contact details");
			AdvanceReporting.addLogs("pass", "message option link present in contact details","message option link present in contact details");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "message option link is not present in contact details");
		}
		return this; 

	}

	//verify callLink in contact details
	public SearchPage verifyCallLink() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("callOptnInContactDetailPg"), "call link not found in contact details");
			AdvanceReporting.addLogs("pass", "Verified that call option link present in contact details");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "call option link is not present in contact details");
		}
		return this; 
	}

	//verify infoLink in contact details
	public SearchPage verifyInfoLink() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("infoOptnInContactDetailPg"), "info link not found in contact details");
			AdvanceReporting.addLogs("pass", "Verified that info option link present in contact details");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "info option link is not present in contact details");
		}
		return this; 
	}

	//verify avatar in contact details
	public SearchPage verifyAvatar() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("avatarInContactDetails"), "avatar is not present in contact details");
			AdvanceReporting.addLogs("pass", "Verified that avatar is present in contact details");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "avatar is not present in contact details");
		}
		return this;
	}

	//verify phone number in contact details
	public SearchPage verifyPhoneNumber() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("numberInContactDetails"), "number is not present in contact details");
			AdvanceReporting.addLogs("pass", "Verified that number is present in contact details");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("pass", "number is not present in contact details");
		}
		return this;
	}

	//verify relevent items in contact details
	public SearchPage verifyReleventItemsOfContactDisplayed(String data) {
		try {
			Thread.sleep(1000);
			for(int i=0;i<3;i++) {
				String contactList = nameList.get(i).getText();
				if(contactList.contentEquals(data)) {
					AdvanceReporting.addLogs("pass", "Verified that relevent items of contact are present");
				}else {
					AdvanceReporting.addLogs("fail", "relevent items of contact are not present");
				}
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "relevent items are not present in contact details");
		}
		return this;
	}

	//To click on call items in the relevent items
	public SearchPage clickOnCallItems() {
		try {
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("outGngImg")) {
				Utils.uBase.clickByImage("outGngImg");
				AdvanceReporting.addLogs("pass", "clicked on relevent call item");
				AdvanceReporting.addLogs("pass", "clicked on relevent call item","clicked on relevent call item");
			}
			else if(Utils.uBase.imageCompare("MsdCalImg")) {
				Utils.uBase.clickByImage("MsdCalImg");
				AdvanceReporting.addLogs("pass", "clicked on relevent call item");
				AdvanceReporting.addLogs("pass", "clicked on relevent call item","clicked on relevent call item");
			}
			else if(Utils.uBase.imageCompare("IncomingcallList")) {
				Utils.uBase.clickByImage("IncomingcallList");
				AdvanceReporting.addLogs("pass", "clicked on relevent call item");
				AdvanceReporting.addLogs("pass", "clicked on relevent call item","clicked on relevent call item");
			}
			else
				AdvanceReporting.addLogs("fail", "can not click on call items");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "can not click on call items");
		}
		return this;
	}

	//To click on message link in call details
	public SearchPage clickMessageLink() {
		try {
			Thread.sleep(6000);
			Utils.uBase.clickByImage("msgOptnInContactDetailPg");
			AdvanceReporting.addLogs("pass", "clicked on message link in contact details");
			AdvanceReporting.addLogs("pass", "clicked on message link in contact details","clicked on message link in contact details");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "can not click on message link in contact details");
		}
		return this;
	}

	//To verify redirected to message folder
	public SearchPage verifyMessageFolder() {
		try {
			Thread.sleep(4000);
			Assert.assertTrue(Utils.uBase.imageCompare("addImageDetail"),"not directed to message folder");
			AdvanceReporting.addLogs("pass", "Verified that redirected to message folder");
			AdvanceReporting.addLogs("pass", "redirected to message folder","redirected to message folder");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "not redirected to message folder");
		}
		return this;
	}

	//To verify call details expanded
	public SearchPage verifyCallDetailsExpanded() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(Utils.uBase.imageCompare("callDetailsExpanded"), "call detail not expanded");
			AdvanceReporting.addLogs("pass", "Verified that call details expanded");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "call detail not expanded");
		}
		return this;
	}


	//To click on voicemail items in the relevent items
	public SearchPage clickOnVoiceMailItems() {
		try {
			if(Utils.uBase.imageCompare("voiceMailDetails")) {
				Thread.sleep(1000);
				Utils.uBase.clickByImage("voiceMailDetails");
				AdvanceReporting.addLogs("pass", "clicked on voicemail details");
				AdvanceReporting.addLogs("pass", "clicked on voicemail details","clicked on voicemail details");
			}
			else if(Utils.uBase.imageCompare("unreadVoiceMailDetails")) {
				Utils.uBase.clickByImage("unreadVoiceMailDetails");
				AdvanceReporting.addLogs("pass", "clicked on voicemail details");
				AdvanceReporting.addLogs("pass", "clicked on voicemail details","clicked on voicemail details");
			}
			else
				AdvanceReporting.addLogs("fail", "can not click on voicemail details");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "can not click on call items");
		}
		return this;
	}

	//To verify voicemail detail expanded
	public SearchPage verifyVoiceMailExpanded() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("voiceMailPlayBtn"), "voice mail detail expanded");
			AdvanceReporting.addLogs("pass", "Verified that voice mail detail expanded");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "voice mail detail not expanded");
		}
		return this;

	}
	//To verify search history is present
	public SearchPage verifySearchHistory() {
		try {
			if(searchHistory.isEmpty()) {
				AdvanceReporting.addLogs("info", "No search history present");
			}
			else {
				AdvanceReporting.addLogs("pass","search history is present");
				AdvanceReporting.addLogs("pass", "search history is present", "search history is present");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("info", "No search history present");
		}
		return this;
	}
	//To verify search history is present
	public SearchPage clearTextInSearchField() {
		try {
			Utils.uBase.clearTextField(searchTxtField);
			Thread.sleep(1000);
			AdvanceReporting.addLogs("pass", "text field is cleared");
			AdvanceReporting.addLogs("pass","text field is cleared", "text field is cleared");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "text field is not cleared");
		}
		return this;
	}
	//to verify results by entering text and by selecting from history in home page
	public SearchPage verifyBeforeAndAfterEnteringText() {
		try {
			Thread.sleep(3000);
			int length1=searchHistoryListByEnteringTxt.size();
			int length2=searchHistoryListBySelectingFromHistory.size();
			for(int i=0,j=0;i<length1&&j<length2;i++,j++) {
				if(searchHistoryListByEnteringTxt.indexOf(i)==searchHistoryListBySelectingFromHistory.indexOf(j)) {
					AdvanceReporting.addLogs("pass", "Verified that both results are matched");
				}	
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "results are not matched");
		}

		return this;
	}
	//To press enter
	public SearchPage pressEnter() {
		try {
			searchTxtField.sendKeys(Keys.ENTER);
			AdvanceReporting.addLogs("pass", "pressed enter");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "can not press enter");
		}
		return this;
	}
	//To click on first search history in home page
	public SearchPage clickFirstHistorySuggestion() {
		try {
			Thread.sleep(4000);
			Utils.uBase.clickWebelement(fistSearchHistory);
			AdvanceReporting.addLogs("pass", "clicked on search history");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "can not click on search history");
		}
		return this;
	}
	//To verify search history has only three entries
	public SearchPage verifySearchHistoryHasMaxThreeEntries(String data) {
		try {
			Thread.sleep(7000);
			int length=searchHistory.size();
			System.out.println("length is:"+length);
			if(length == 3) {
				for(int i=0;i<length;i++) {
					if(searchHistory.get(i).getText().contains(data)) {
						AdvanceReporting.addLogs("fail", "contains first entry");
					}
					else {
						AdvanceReporting.addLogs("pass", "Verified that history does not contains first entry");
						AdvanceReporting.addLogs("info", "Verified that search history has only three entries");
					}
				}
			} else {
				AdvanceReporting.addLogs("fail", "contains more than three entries");
			}
		} catch(Exception e) {
			AdvanceReporting.addLogs("fail", "contains more than three entries");
		}
		return this;
	}
	/* Clicked on End button hangs up the call */
	public SearchPage clickOnCallEndBtn() { 
		try
		{
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("callEndButtonImg")==true) {
				Utils.uBase.clickByImage("callEndButtonImg");
				AdvanceReporting.addLogs("pass", "Click on call end button sucess");
			}
			else if(Utils.uBase.imageCompare("endBtn")==true) {
				Utils.uBase.clickByImage("endBtn");
				AdvanceReporting.addLogs("pass", "Click on call end button sucess");
			}
			else
				AdvanceReporting.addLogs("fail", "Click on call end button is fail ");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("info", "Click on call end button is fail ");
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//To select the message from the suggestion list
	public SearchPage selectVoiceMailFromSuggestions() {
		try {
			Thread.sleep(9000);
			Utils.uBase.clickWebelement(matchedContentSuggestions.get(0));
			Thread.sleep(5000);
			AdvanceReporting.addLogs("pass", "selected the matched content text");
			AdvanceReporting.addLogs("pass", "selected the matched content text","selected the matched content text");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "can not select the matched content text");
		}
		return this;
	}
	//To verify matched text has been highlighted
	public SearchPage verifyMatchedTextVoiceMailHighlight() {
		try {
			if(Utils.uBase.imageCompare("voiceMailMatchedContent")==true) {
				AdvanceReporting.addLogs("pass", "Verified that text has highlighted");
				AdvanceReporting.addLogs("pass", "text has highlighted", "text has highlighted");
			}
			else if(Utils.uBase.imageCompare("unReadVoicemail")==true) {
				AdvanceReporting.addLogs("pass", "Verified that text has highlighted");
				AdvanceReporting.addLogs("pass", "text has highlighted", "text has highlighted");
			}
			else
				AdvanceReporting.addLogs("fail", "Text is not highlighted");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("pass", "text is not highlighted");
		}

		return this;
	}
	public SearchPage verifyMessageItemsDisplayed() {
		try {
			Thread.sleep(4000);
			Assert.assertTrue(Utils.uBase.imageCompare("msgIcon"), "message items are not present");
			AdvanceReporting.addLogs("pass", "Verified that message items are present");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "message items are not present");
		}
		return this;
	}
	public SearchPage clickMessageItems() {
		try {
			Utils.uBase.clickByImage("msgIcon");
			AdvanceReporting.addLogs("pass", "message items opened");
			AdvanceReporting.addLogs("pass", "message items opened","message items opened");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "message items not opened");
		}
		return this;
	}
	public SearchPage verifyMessageDetailsOpened() {
		try {
			Thread.sleep(2000);
			Assert.assertTrue(Utils.uBase.imageCompare("sendNewMsgInConversation"), "message conversation not expanded");
			AdvanceReporting.addLogs("pass", "Verified that message conversation detail expanded");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "message conversation detail not expanded");
		}
		return this;
	}
}