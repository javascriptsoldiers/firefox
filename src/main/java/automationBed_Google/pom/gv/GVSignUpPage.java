package automationBed_Google.pom.gv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.BaseUtility;
import automationBed_Google.utility.base.Utils;

public class GVSignUpPage extends BaseUtility{

	// Locators
	@FindBy(xpath="//input[contains(@placeholder,'Search by')]")
	WebElement searchBy;
	@FindBy(xpath="//*[contains(@id,'phonenumberresultid')]")
	WebElement phoneNumSuggList;
	@FindBy(xpath="//*[contains(@id,'noresultsid')]")
	WebElement noResultsId;

	// Search by city or area code
	public GVSignUpPage setTextInSearchBy(String searchText)
	{
		try
		{
			Utils.uBase.waitForElement(searchBy);
			AdvanceReporting.addLogs("pass", "SignUp Page","SignUp Page");
			Utils.uBase.setText(searchBy, searchText);
			Utils.uBase.pressKeyEnter(searchBy);
			AdvanceReporting.addLogs("pass", "Searching with "+searchText);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public GVSignUpPage verifyPhoneNumberListDisplayed()
	{
		try
		{
			Assert.assertEquals(true, phoneNumSuggList.isDisplayed());
			AdvanceReporting.addLogs("pass", "SignUp Page","SignUp Page");
			AdvanceReporting.addLogs("pass", "Phone Number Suggesion List is Displayed");
		} 
		catch (Exception e)
		{
			e.printStackTrace(); Assert.fail();
			AdvanceReporting.addLogs("fail", "Phone Number Suggesion List is Not Displayed");
		}
		return this;
	}
	
	public GVSignUpPage verifyErrorMsgForInvalidSearch()
	{
		try
		{
			Assert.assertEquals(true, noResultsId.isDisplayed());
			AdvanceReporting.addLogs("pass", "SignUp Page","SignUp Page");
			AdvanceReporting.addLogs("pass", "No Google Voice numbers are available");
		} 
		catch (Exception e)
		{
			e.printStackTrace(); Assert.fail();
			AdvanceReporting.addLogs("fail", "Phone Number Suggesion List is Not Displayed");
		}
		return this;
	}
}





