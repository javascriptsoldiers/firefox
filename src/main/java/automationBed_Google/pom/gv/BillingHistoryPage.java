package automationBed_Google.pom.gv;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class BillingHistoryPage
{

	//Locators
	@FindBy(xpath="//*[contains(@ng-repeat,'BillingTransactionList')]")
	WebElement bTransactionList;
	@FindBy(xpath="//*[contains(@class,'md-icon-button md-button')]/md-icon")
	WebElement bnOptionsList;
	@FindBy(xpath="(//*[contains(@ng-click, 'RequestRefundClick')]/following::p)[last()]")
	WebElement requestRefundBtn;
	
	

	public BillingHistoryPage refundOption() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(bTransactionList);
			AdvanceReporting.addLogs("pass", "Billing History Page","Billing History Page");
			List<WebElement> allElements = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@class,'md-icon-button md-button')]/md-icon"));
			for(WebElement ele : allElements) {
			  Utils.uBase.hoverWebelement(ele);
			  AdvanceReporting.addLogs("pass", "Three dots menu is avalable for below transaction");
			  AdvanceReporting.addElementImage("info", bTransactionList);
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public BillingHistoryPage refundRequest() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(bTransactionList);
			AdvanceReporting.addLogs("pass", "Billing History Page","Billing History Page");
//			List<WebElement> allElements = Utils.uBase.driver.findElements(By.xpath("//*[contains(@class,'md-icon-button md-button')]/md-icon"));
//			for(WebElement ele : allElements) {
			  Utils.uBase.hoverWebelement(bnOptionsList);
//			  AdvanceReporting.addLogs("pass", "Three dots menu is avalable for below transaction");
//			  AdvanceReporting.addElementImage("info", bTransactionList);
			  Utils.uBase.clickWebelement(bnOptionsList);
			  AdvanceReporting.addLogs("pass", "Clicked on Three dots menu");
			  AdvanceReporting.addElementImage("info",requestRefundBtn);
//			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
}





