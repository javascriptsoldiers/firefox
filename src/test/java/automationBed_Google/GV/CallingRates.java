package automationBed_Google.GV;

import org.openqa.selenium.support.PageFactory;

import automationBed_Google.pom.gv.CallingRatesPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.SettingsPayments;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

public class CallingRates extends SuiteBase{
	public void selectedCurrencyForConsumerAccount(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments setPmntPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		CallingRatesPage callRAtesPg= PageFactory.initElements(Utils.uBase.webDriver, CallingRatesPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		setPmntPage.clickCallingRatesIcon();
		Utils.uBase.switchToNewWindow();
		Thread.sleep(4000);
		callRAtesPg.verifyCurrencyRpmToCurrency();
	}
	public void selectedCountryForConsumerAccount(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments setPmntPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		CallingRatesPage callRAtesPg= PageFactory.initElements(Utils.uBase.webDriver, CallingRatesPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL();
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		setPmntPage.clickCallingRatesIcon();
		Utils.uBase.switchToNewWindow();
		callRAtesPg.verifyRPMAndVATAccordingToCountry().verifyHelpShowsVatDetails();
	}
	public void selectedCurrencyForWolverineAccount(String email, String password, String data) throws Exception {

		/* Launching google voice application */
		Utils.uBase.launchWebApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.webDriver, GVSignInPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.webDriver, HambergerMenuPage.class);
		SettingsPage stngpg = PageFactory.initElements(Utils.uBase.webDriver, SettingsPage.class);
		SettingsPayments setPmntPage = PageFactory.initElements(Utils.uBase.webDriver, SettingsPayments.class);
		CallingRatesPage callRAtesPg= PageFactory.initElements(Utils.uBase.webDriver, CallingRatesPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton().dailyURL().emergencyCallingAlert();
		hmPage.clickSettings();
		stngpg.clickPaymentTab();
		setPmntPage.clickCallingRatesIcon();
		Utils.uBase.switchToNewWindow();
		Thread.sleep(4000);
		callRAtesPg.verifyCurrencyRpmToCurrencyForWolverine();
	}
}
