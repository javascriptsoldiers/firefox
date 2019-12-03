package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HomePageWeb;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

public class CallSideBarUI extends SuiteBase{
	
	public void callTabDefault(String email, String password, String data) throws Exception {
		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		/*
		 * Procedure: 1. Login with Moya account. 2. Observe CallSideBar.
		 */
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HomePageWeb homePage = PageFactory.initElements(Utils.uBase.webDriver, HomePageWeb.class);
		
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		
		/*
		 * Verification: 1. Verify that by default Call tab should be selected (then it
		 * would be any other tab last time user selected). 2. Verify CallSideBar is
		 * located on the right side of the page. 3. Verify top section shows GV number:
		 * " Call as (408) 909-3427" 4. Verify Second field from the top:
		 * "Enter a name or number" and 'Call Button' (grayed out). 5. Verify third
		 * section from the top: "Suggestions" and contact list, make sure its
		 * scrollable. 6. Verify Keypad below third section. 7. Verify "Hide keypad"
		 * button below Keypad.
		 */
		homePage.verifyCallTabIsDisplayed().verifyCallPanelInRight().verifyTopSecGVNum().verifySecondSecEnterNameOrNum().verifyThirdSecSuggList().verifyFourthSecKeypad().verifyHideKeyboardlast();

	}
}
