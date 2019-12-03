package automationBed_Google.pom.gv;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class CallingRatesPage {

	@FindBy(xpath="//*[contains(@class,'gb_oc gb_Ic gb_la')]")
	WebElement GoogleVoiceLogo;	//Method To move from billing history to settings page
	@FindBy(xpath="(//mat-select[contains(@class,'ng-star-inserted')])[1]")
	WebElement currencyDropDown;
	@FindBy(xpath="//div[contains(@class,'cdk-overlay-pane')]/div/div/mat-option")
	List<WebElement> currencyList;
	@FindBy(xpath="//*[contains(@class,'rate-row__prices')]")
	List<WebElement> ratePerMin;
	@FindBy(xpath="//*[contains(@aria-labelledby,'mat-form-field-label-1')]/div/div/span")
	WebElement activeCurrency;
	@FindBy(xpath="//*[contains(@class,'gmat-body-2 mat-list mat-list-base ng-star-inserted')]/h2/div/div/div")
	WebElement callingRateHeading;
	@FindBy(xpath="(//mat-select[contains(@class,'ng-star-inserted')])[2]")
	WebElement countryDropDown;
	@FindBy(xpath="//*[contains(@class,'mat-option-text')]")
	List<WebElement> countryList;
	@FindBy(xpath="//*[contains(text(),' Rate Per Minute')]")
	WebElement ratePerMinClmn;
	@FindBy(xpath="//*[contains(text(),'VAT Included')]")
	WebElement vatClmn;
	@FindBy(xpath="//mat-icon[contains(@class,'rate-row__vat-info-icon')]")
	WebElement infoBtn;
	@FindBy(xpath="//*[contains(text(),'VAT is charged at the time of purchase')]")
	WebElement vatInfo;
	@FindBy(xpath="(//mat-select[contains(@class,'ng-star-inserted')])[2]")
	WebElement currencyDropDownWolverine;
	public CallingRatesPage clickGoogleVoiceLogo() {
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("GoogleVoiceLogo");
			AdvanceReporting.addLogs("pass","Clicked on GV logo");
			AdvanceReporting.addLogs("pass","Clicked on GV logo","GoogleVoiceLogo");		
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;
	}
	//User should not land on the legacy GV page by clicking the Google Voice logo in the calling rates page
	public CallingRatesPage verifyNavigationOnClickingGvLogo() {
		try {
			Utils.uBase.checkPageReady();
			Thread.sleep(2000);
			Assert.assertFalse(Utils.uBase.imageCompare("LegacyGvContent"), "Page is not navigating to legacy page");
			AdvanceReporting.addLogs("pass","Verified that page is not navigating to legacy page");
			AdvanceReporting.addLogs("pass","Page is not navigating to legacy page","LegacyGvContent");
			Thread.sleep(4000);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public CallingRatesPage verifyCurrencyRpmToCurrency() {
		try {
			Utils.uBase.waitForElementToBeClickable(currencyDropDown);
			Utils.uBase.clickWebelement(currencyDropDown);
			for(int i=0;i<currencyList.size();i++) {
				currencyList.get(i).click();
				Thread.sleep(3000);
				AdvanceReporting.addLogs("pass", "clicked on"+i+"item");
				if(callingRateHeading.getText().contains(activeCurrency.getText())) {
					AdvanceReporting.addLogs("pass", "Verified that rate per minute is updated to respective currency");
				}
				else
					AdvanceReporting.addLogs("fail", "Rate per minute is not updated to respective currency");
				Utils.uBase.clickWebelement(currencyDropDown);
				}	
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
		}
	public CallingRatesPage verifyRPMAndVATAccordingToCountry() {
		try {
			Thread.sleep(5000);
			Utils.uBase.clickWebelement(countryDropDown);
			for(int i=0;i<countryList.size();i++) {
				countryList.get(i).click();
				Thread.sleep(2000);
				if(countryDropDown.getText().contains("U.S. & others")) {
					if((Utils.uBase.isElementPresent_webelement(ratePerMinClmn)==true)&&(Utils.uBase.isElementPresent_webelement(vatClmn)==false)) {
						AdvanceReporting.addLogs("pass", "Verified that U.S. & others have only rate per minute but not VAT");
					}
					else
						AdvanceReporting.addLogs("fail", "Verified that U.S. & others have both rate per minute and VAT");
				}
				else {
					if((Utils.uBase.isElementPresent_webelement(ratePerMinClmn))==true&&(Utils.uBase.isElementPresent_webelement(vatClmn)==true)) {
						AdvanceReporting.addLogs("pass", "RPM and VAT columns are present for"+countryDropDown.getText());
					}
					else
						AdvanceReporting.addLogs("fail", "RPM and VAT columns are not displayed");
				}	
				Utils.uBase.clickWebelement(countryDropDown);
				Thread.sleep(2000);
				}		
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
		}
	public CallingRatesPage verifyHelpShowsVatDetails() {
		try {
			Utils.uBase.clickWebelement(countryList.get(0));
			Thread.sleep(3000);
			Utils.uBase.hoverWebelement(infoBtn);
			if(Utils.uBase.isElementPresent_webelement(vatInfo)==true) {
				AdvanceReporting.addLogs("pass", "Verified that VAT info is displayed on hovering info Btn");
			}
			else
				AdvanceReporting.addLogs("fail", "VAT info is not displayed on hovering info btn");
			
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public CallingRatesPage verifyCurrencyRpmToCurrencyForWolverine() {
		try {
			Utils.uBase.waitForElementToBeClickable(currencyDropDownWolverine);
			Utils.uBase.clickWebelement(currencyDropDownWolverine);
			for(int i=0;i<currencyList.size();i++) {
				currencyList.get(i).click();
				Thread.sleep(3000);
				AdvanceReporting.addLogs("pass", "clicked on"+i+"item");
				if(callingRateHeading.getText().contains(activeCurrency.getText())) {
					AdvanceReporting.addLogs("pass", "Verified that rate per minute is updated to respective currency");
				}
				else
					AdvanceReporting.addLogs("fail", "Rate per minute is not updated to respective currency");
				Utils.uBase.clickWebelement(currencyDropDownWolverine);
				}	
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
		}
}
