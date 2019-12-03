package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;
import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

public class DomainContact extends SuiteBase {

	//Matching contacts with the search text should be displayed correctly 
	public void searchCorpAcccountSearchResults(String email, String password, String data) throws Exception {
		// Launching Google Voice Web Application
		Utils.uBase.launchWebApplication();

		/* Pre-Condition:
							1. Login uisng Corp Account(abcd@google.com)*/
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		HomePageWeb hmweb= PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		CallsPage callPage = PageFactory.initElements(Utils.uBase.webDriver, CallsPage.class);

		/*Procedure:	 
		 * 1. Login 2. Click on call fab icon 3. Type any alphabets or numbers*/

		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmweb.verifywolverineAccount(email);
		hmPage.clickMainMenu().clickTab("Calls");
		callPage.EnteraNameOrNum().clickFabIcon().enterPhoneNumberForSearch();


		/* Verification:
				1. Drop down appears just below the search bar
 				2. All contacts(saved and unsaved) are displayed in the dropdown in an alphabetical order 
 				and the dropdown should be scrollable."*/
		callPage.verifyDropdownScrollable();
		
		// 3. Saved contacts are displayed at the top.
		callPage.verifySavedContacts();

		/*4. Unsaved contacts(google contacts) are displayed under ""Directory"" section*/
		callPage.verifyUnsavedContacts();

		/*5. Click on the item, it will attempt an outgoing call*/
		callPage.clickFirstItemFromDropdown().allowBrowserNotification();
		callPage.verifyStatusCallingIsDiaplyed();
	}

}
