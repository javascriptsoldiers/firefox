package automationBed_Google.pom.gv;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class SettingsPayments {
	// Locators
	@FindBy(xpath = "//*[contains(@class,'ReOlrf-rxYATc')]")
	WebElement gvCredit;
	@FindBy(xpath = "//*[contains(@gv-test-id,'add-credit-button')]")
	WebElement gvAddCreditBtn;
	@FindBy(xpath = "//*[contains(@ng-click,'ctrl.onBillingHistoryClick()')]")
	WebElement gvBillingHistoryBtn;
	@FindBy(xpath = "//*[contains(@ng-model,'ctrl.selectedPurchaseOption')]")
	WebElement gvAddcreditPurchaseOptions;
	@FindBy(xpath = "//*[contains(@aria-label,'Cancel')]")
	WebElement gvAddCreditCancel;
	@FindBy(xpath = "//*[contains(@aria-label,'Add Credit')]")
	WebElement gvAddCreditpopupBtn;
	@FindBy(xpath = "//*[contains(@aria-label,'Refund balance')]")
	WebElement gvverifyBillingHistoryRefundBalanceBtn;
	@FindBy(xpath = "//*[contains(@class,'aKQtkf-jyrRxf')]")
	WebElement gvBillinghistorytable;
	@FindBy(xpath = "//*[contains(@aria-label,'Lookup calling rates by country')]")
	WebElement gvCallingrateslink;
	@FindBy(xpath="(//*[contains(@class,'EPj1Ff-v2oa7b EPj1Ff-VZ45Xc')])[2]")
	WebElement updatedBalance;
	@FindBy(xpath="(//*[contains(@class,'EPj1Ff-v2oa7b EPj1Ff-VZ45Xc')])[1]")
	WebElement callCost;
	@FindBy(xpath="(//*[contains(@class,'EPj1Ff-v2oa7b EPj1Ff-VZ45Xc')])[4]")
	WebElement balance;
	@FindBy(xpath="//tr[contains(@class,'EPj1Ff-m8HfHb')]")
	List<WebElement> billItemRows;
	@FindBy(xpath="//button[contains(@class,'on md-button')]")
	List<WebElement> hoverThreeDots;
	@FindBy(xpath="//*[@id=\"menu_container_5\"]/md-menu-content")
	WebElement refundRqstMenu;
	@FindBy(xpath="//*[contains(@class,'full-snackbar')]")
	WebElement refundSnackBar;
	@FindBy(xpath="//*[contains(@class,'md-headline')]")
	WebElement refndHeadline;
	@FindBy(xpath="//*[contains(@class,'PZFBrb-K0un0e')]")
	WebElement callInfoDetails;
	@FindBy(xpath="//*[contains(@class,'ReOlrf-rxYATc')]")
	WebElement creditBalance;
	
	String creditBala;
	int creditBalA;
	String creditBalb;
	int creditBalB;
	String creditBalc;
	int creditBalC;
	@FindBy(xpath="//div[16]/div[2]/md-dialog/md-dialog-actions/gv-flat-button/span/button/span")
	WebElement requestRefund;
	@FindBy(xpath="//button[contains(@aria-label,'Cancel')]")
	WebElement cancelPopup;
	



	public SettingsPayments getGvCreditBal() throws Exception {
		try {
			Utils.uBase.waitForElement(gvCredit);
			AdvanceReporting.addLogs("pass", "Payments Page", "Payments Page");
			AdvanceReporting.addLogs("pass", "GoogleVoice current balance is : " + gvCredit.getText());
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyAddCreditBtn() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvAddCreditBtn);
			AdvanceReporting.addLogs("pass", "'ADD CREDIT' Button is Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyBillingHistoryBtn() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvBillingHistoryBtn);
			AdvanceReporting.addLogs("pass", "'Billing history' Button is Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments clickAddCreditBtn() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvAddCreditBtn);
			Utils.uBase.clickWebelement(gvAddCreditBtn);
			AdvanceReporting.addLogs("pass", "Clicked on 'ADD CREDIT' Button");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments clickBillingHistoryBtn() throws Exception {
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("billingHistory");
			AdvanceReporting.addLogs("pass","Clicked on the Billing History button to open the billing history page");
			AdvanceReporting.addLogs("pass","Clicked on Billing History","Clicked on Billing History");
			Thread.sleep(2000);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail","BillingHistory is not clicked " +e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	public SettingsPayments verifyAddCreditpopupoptions() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvAddcreditPurchaseOptions);
			AdvanceReporting.addLogs("pass", "Google Voice 'ADD CREDIT' pop up page credit options are Available");
			AdvanceReporting.addElementImage("pass", gvAddcreditPurchaseOptions);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyAddCreditpopupBtn() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvAddCreditpopupBtn);
			AdvanceReporting.addLogs("pass", "Google Voice ADD CREDIT pop up page's 'ADD CREDIT' Button is Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyAddCreditpopupcancelBtn() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvAddCreditCancel);
			AdvanceReporting.addLogs("pass", "Google Voice ADD CREDIT pop up page's 'CANCEL' Button is Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments clickAddCreditpopupcancelBtn() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvAddCreditCancel);
			Utils.uBase.clickWebelement(gvAddCreditCancel);
			AdvanceReporting.addLogs("pass", "Google Voice ADD CREDIT pop up page's 'CANCEL' Button is clicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyBillingHistoryRefundBalanceBtn() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvverifyBillingHistoryRefundBalanceBtn);
			AdvanceReporting.addLogs("pass", "Billing History page - 'Refund balance' Button is Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyBillingHistorytable() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvBillinghistorytable);
			AdvanceReporting.addLogs("pass", "Billing History page - Billing history table Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyCallingrateslink() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvCallingrateslink);
			AdvanceReporting.addLogs("pass", "Calling rates Link Available");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments clickCallingrateslink() throws Exception {
		try {
			Utils.uBase.waitForElementToBeClickable(gvCallingrateslink);
			Utils.uBase.clickWebelement(gvCallingrateslink);
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyGvCurrentBalDispalyed() throws Exception {
		try {
			if(Utils.uBase.imageCompare("currentBalance")==true){
				AdvanceReporting.addLogs("pass","Current balance is present");
				AdvanceReporting.addLogs("pass","Current balance is present","current balance");
			}
			else
				AdvanceReporting.addLogs("fail","Current balance is not present");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyAddCreditBtnDisplayed() throws Exception {
		try {
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("addCredits")==true){
				AdvanceReporting.addLogs("pass","AddCredits is present on payments page");
				AdvanceReporting.addLogs("pass","AddCredits is present","add credits");
			}
			else {
				AdvanceReporting.addLogs("fail","AddCredits is not present on payments page");
				AdvanceReporting.addLogs("fail","AddCredits is not present","AddCredits is not present");
			}
		} 
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyBillingHistoryBtnDisplayed() throws Exception {
		try {
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("billingHistory")) {
				AdvanceReporting.addLogs("pass","BillingHistory is present");
				AdvanceReporting.addLogs("pass","BillingHistory is present","BillingHistoryDisplayed");
			}
			else {
				AdvanceReporting.addLogs("fail","BillingHistory is not present");
				AdvanceReporting.addLogs("fail","BillingHistory is not present","BillingHistoryNotDisplayed");
			}
		}
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyCallPageDisplayed(){
		try{
			Utils.uBase.clickByImage("callRatebtn");
			Thread.sleep(4000);
			Utils.uBase.switchToNewWindow();
			Thread.sleep(7000);
			Assert.assertTrue(Utils.uBase.getCurrentUrl().contains("rates"),"click on does not redirects to rate page");
			AdvanceReporting.addLogs("pass", "calling rate window opened");
			AdvanceReporting.addLogs("pass", "calling rate window opened","calling rates tab");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;
	}
	public SettingsPayments verifyPopUpPresence(String expectedResult) throws Exception {
		try {
			Thread.sleep(3000);
			if(expectedResult.equalsIgnoreCase("displayed"))
			{
				if(Utils.uBase.imageCompare("cancelPopup"))
				{
					AdvanceReporting.addLogs("pass", "Pop up is displayed on clicking add credit button");
				}else
				{
					AdvanceReporting.addLogs("fail", "Pop up is not displayed on clicking add credit button");
				}}
			else if(expectedResult.equalsIgnoreCase("not displayed"))
			{
				if(!Utils.uBase.imageCompare("cancelPopup"))
				{
					AdvanceReporting.addLogs("pass", "Pop up is closed on clicking cancel button");
				}else
				{
					AdvanceReporting.addLogs("fail", "Pop up is not closed on clicking cancel button");
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyAddCreditPopupBtnDisplayed() throws Exception {
		try {
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("popUpAddCredit")){		
				AdvanceReporting.addLogs("pass", "Add credits button is displayed");
				AdvanceReporting.addLogs("pass", "add credits clicked","AddCreditsDisplayed");
			}else {
				AdvanceReporting.addLogs("pass", "Add credits button is not displayed");
				AdvanceReporting.addLogs("pass", "add credits clicked","AddCreditsNotDisplayed");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments clickAddCreditPopUpCancelBtn() throws Exception {
		try {
			//Utils.uBase.takeScreenshotOfWebelement(cancelPopup, "cancelPopup");
			Utils.uBase.clickByImage("cancelPopup");
			AdvanceReporting.addLogs("pass", "Google Voice ADD CREDIT pop up page's 'CANCEL' Button is clicked");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public SettingsPayments verifyAddCreditsDisplayedInBillingHistory() {
		try {
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("addCreditInBillinghistory")) {
				AdvanceReporting.addLogs("pass", "Add credits button is present on Billing history page");
				AdvanceReporting.addLogs("pass", "Add credits button is present","Add credits button is present");
			}
			else if(Utils.uBase.imageCompare("addCredits")==true)
			{
				AdvanceReporting.addLogs("pass","Add credits button is present on Billing history page");
				AdvanceReporting.addLogs("pass", "Add credits button is present","Add credits button is present");
			}
			else {
				AdvanceReporting.addLogs("fail", "refundBalanceInBillinghistory option is not present");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Add credits option is not present on Billing history page " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;

	}
	public SettingsPayments verifyRefundOptionBillingHistory() {
		try {
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("refundBalanceInBillinghistory")) {
				AdvanceReporting.addLogs("pass", "refundBalanceInBillinghistory option is present");
			}
			else {
				AdvanceReporting.addLogs("fail", "refundBalanceInBillinghistory option is not present");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;

	}
	public SettingsPayments verifyCorrectBillingHistory() {
		try {
			Thread.sleep(2000);
			String temp1=updatedBalance.getText().replaceAll("\\W", "");
			float upblnc = Float.parseFloat(temp1);
			String temp2=balance.getText().replaceAll("\\W", "");
			float blnc= Float.parseFloat(temp2);
			String temp3=callCost.getText().replaceAll("\\W", "");
			float clcst= Float.parseFloat(temp3);
			System.out.println("updated blnc"+upblnc);
			System.out.println(blnc);
			System.out.println(clcst);
			if(upblnc==blnc-clcst) {
				AdvanceReporting.addLogs("pass", "Call cost is mentioned correctly");
			}

		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Call cost is not mentioned correctly");
			AdvanceReporting.addLogs("fail", e.getMessage());
			e.printStackTrace(); Assert.fail();

		}
		return this;

	}

	public SettingsPayments verifyLinkLookupCallingRatesByCountry() {
		try {
			Assert.assertTrue(Utils.uBase.imageCompare("callRatebtn"), "link for lookup call rates is not present");
			AdvanceReporting.addLogs("pass", "link for lookup call rates is present");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return this;

	}

	//To verify billing history is clickable
	public SettingsPayments verifyBillingHistoryIsClickable() {
		try {
			String before=Utils.uBase.getCurrentUrl();
			Utils.uBase.clickByImage("billingHistory");
			Thread.sleep(2000);
			String after=Utils.uBase.getCurrentUrl();
			if(before.equals(after)) {
				AdvanceReporting.addLogs("fail", "billing history is not clickable");
			}
			else {
				AdvanceReporting.addLogs("pass", "Verified that billing history is clickable");
			}
		}
		catch(Exception e) {

		}
		return this;
	}

	//To move from billing history to settings page
	public SettingsPayments movingFromBillingHistoryToSettingsPage() {
		try {
			Utils.uBase.clickByImage("backBtnInBillingHistory");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;

	}

	//To  verify add credits in wolverine account
	public SettingsPayments verifyAddCreditDisplayedInWolverine() {
		try {
			Assert.assertFalse(Utils.uBase.imageCompare("addCredits"), "AddCredits is not present");
			AdvanceReporting.addLogs("pass","Verified that addCredits is not present");
			AdvanceReporting.addLogs("pass","AddCredits is not present","No add credits option");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}



	public SettingsPayments verifyBillingHistoryItem(){
		try {
			Thread.sleep(2000);
			for(int i=1;i<=billItemRows.size();i++) 
			{
				Utils.uBase.hoverWebelement(Utils.uBase.webDriver.findElement(By.xpath("(//tr[contains(@class,'EPj1Ff-m8HfHb')])["+i+"]")));
				{if(Utils.uBase.imageCompare("hoverCallInBilling")==true) 
				{
					Assert.assertTrue(Utils.uBase.imageCompare("hoverCallInBilling"), "Hovering over is not highlight");
					AdvanceReporting.addLogs("pass","Verified Hovering over the log highlights the items in the list");
					AdvanceReporting.addLogs("pass","Hovering over is highlight","Hovering over highlights item");
					break;}
				}}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;
	}

	public SettingsPayments captureLogData(){
		try {
			Thread.sleep(2000);
			for(int i=1;i<=billItemRows.size();i++) 
			{
				Utils.uBase.hoverWebelement(Utils.uBase.webDriver.findElement(By.xpath("(//tr[contains(@class,'EPj1Ff-m8HfHb')])["+i+"]")));
				{if(Utils.uBase.imageCompare("hoverThreeDots")==true) 
				{
					String date = Utils.uBase.webDriver.findElement(By.xpath("((//tr[contains(@class,'EPj1Ff-m8HfHb')])["+i+"]/td)[2]")).getText();
					AdvanceReporting.addLogs("pass","Date fetched : "+date);
					String time = Utils.uBase.webDriver.findElement(By.xpath("((//tr[contains(@class,'EPj1Ff-m8HfHb')])["+i+"]/td)[3]")).getText();
					AdvanceReporting.addLogs("pass","Time fetched : "+time);
					String number = Utils.uBase.webDriver.findElement(By.xpath("((//tr[contains(@class,'EPj1Ff-m8HfHb')])["+i+"]/td)[5]")).getText();
					AdvanceReporting.addLogs("pass","Number fetched : "+number);
					Thread.sleep(1000);
					Utils.uBase.clickByImage("hoverThreeDots");
					Utils.uBase.clickByImage("reqstRefund");
					//					Thread.sleep(3000);
					AdvanceReporting.addLogs("pass","Refund request menu is clicked");
					AdvanceReporting.addLogs("pass","Refund request menu is clicked","Refund request menu is clicked");
					String callInfo = callInfoDetails.getText();
					Assert.assertTrue(callInfo.contains(date));
					{					
						AdvanceReporting.addLogs("pass","Assert pass, The date is matched : "+date);
						AdvanceReporting.addLogs("pass","The date is matched","The date is matched");
					}
					Assert.assertTrue(callInfo.contains(time));
					{					
						AdvanceReporting.addLogs("pass","Assert pass, The time is matched : "+time);
						AdvanceReporting.addLogs("pass","The time is matched","The time is matched");
					}
					Assert.assertTrue(callInfo.contains(number));
					{					
						AdvanceReporting.addLogs("pass","Assert pass, The number is matched : "+number);
						AdvanceReporting.addLogs("pass","The number is matched","The number is matched");
					}
					break;
				}
				}
			}			
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;
	}

	public SettingsPayments verifyAndClickThreedotsMenu(){
		try {
			Thread.sleep(2000);
			for(WebElement e : billItemRows) {
				Utils.uBase.hoverWebelement(e);
				if(Utils.uBase.imageCompare("hoverThreeDots")==true) 
				{
					Utils.uBase.clickByImage("hoverThreeDots"); 
					break;
				}
			}
			AdvanceReporting.addLogs("pass","Since the call is eligible for a refund, three dots menu appears on the highlighted item is verified");
			AdvanceReporting.addLogs("pass","Three dots menu is present","Three dots menu is present");
			Thread.sleep(2000);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;
	}

	public SettingsPayments verifyRequestRefundMenu(){
		try {
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("reqstRefund")==true){
				AdvanceReporting.addLogs("pass","Request Refund button popped up while clicking on the threedots menu is verified");
				AdvanceReporting.addLogs("pass","Refund request menu is enabled","Refund request menu is enabled");
				Thread.sleep(2000);
			}
			else {
				AdvanceReporting.addLogs("fail","Refund request menu is not enabled");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;
	}

	public SettingsPayments clickRequestRefund(){
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("reqstRefund");
			Thread.sleep(1500);
			AdvanceReporting.addLogs("pass","Refund request menu is clicked");
			AdvanceReporting.addLogs("pass","Refund request menu is clicked","Refund request menu is clicked");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;
	}

	public SettingsPayments clickReasonBtn(){
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("slctReasonBttn");
			Thread.sleep(1500);
			AdvanceReporting.addLogs("pass","Select reason menu is clicked");
			AdvanceReporting.addLogs("pass","Select reason menu is clicked","Select reason menu is clicked");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;

	}

	public SettingsPayments selectReason(){
		try {
			Utils.uBase.clickByImage("refundReason");
			AdvanceReporting.addLogs("pass","Selected a reason from the drop down menu");
			AdvanceReporting.addLogs("pass","Refund reason selected","The reason for refund is selected");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;

	}

	public SettingsPayments verifyRequestRefundBtn(){
		try {
			Thread.sleep(1000);
			if(Utils.uBase.imageCompare("requestRefundBttn")==true){
				AdvanceReporting.addLogs("pass","Verified that refund request button is enabled");
				AdvanceReporting.addLogs("pass","Refund request button is enabled","Refund request menu is enabled");
			}
			else
				AdvanceReporting.addLogs("fail","Refund request button is not enabled");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;

	}

	public SettingsPayments clickRequestRefundBtn(){
		try {
			Utils.uBase.clickByImage("requestRefundBttn");
			AdvanceReporting.addLogs("pass","Refund request button is clicked");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;

	}

	public SettingsPayments verifySnackBar(){
		try {
			Utils.uBase.waitForElement(refundSnackBar);
			Thread.sleep(4000);
			if(Utils.uBase.imageCompare("refundSnackBar")==true){
				AdvanceReporting.addLogs("pass","Verified that refund snackbar popped up with confirmation message ");
				AdvanceReporting.addLogs("pass","Refund snackbar popped up","Refund snackbar popped up");
				Thread.sleep(2000);
			}
			else
				AdvanceReporting.addLogs("fail","Refund snackbar is not issued");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;

	}

	public SettingsPayments clickOutside(){
		try {
			Utils.uBase.waitForElement(refndHeadline);
			Utils.uBase.clickWebelement(refndHeadline);
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;

	}

	public SettingsPayments verifyReasonError(){
		try {			
			if(Utils.uBase.imageCompare("selectReasonBar")==true){
				AdvanceReporting.addLogs("pass","Verified that select reason bar highlighted in red color");
				AdvanceReporting.addLogs("pass","Select reason bar highlighted in red color","Select reason bar highlighted in red color");
			}
			else
				AdvanceReporting.addLogs("fail","Select reason bar is not highlighted in red color");			
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;

	}

	public SettingsPayments clickCancelBtn(){
		try {			
			Utils.uBase.clickByImage("refundCancelButtn");
			AdvanceReporting.addLogs("pass","Cancel button for refund is clicked");
			AdvanceReporting.addLogs("pass","Cancel button for refund is clicked","Cancel button for refund is clicked");	
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;

	}

	public SettingsPayments verifyWindoClose(){
		try {			
			if(Utils.uBase.imageCompare("billHistryPage")==true){
				AdvanceReporting.addLogs("pass","Verified that pop up window is closed");
				AdvanceReporting.addLogs("pass","Pop up window is closed","Pop up window is closed");
			}
			else
				AdvanceReporting.addLogs("fail","Pop up window is not closed");			
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;
	}	
	//Method To move from billing history to settings page
	public SettingsPayments clickBackArrowIcon() {
		try {
			Thread.sleep(1000);
			Utils.uBase.clickByImage("backArrowIcon");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}

		return this;

	}
	//To  verify User should not be given the option to add credit or allow refunds to his account
	public SettingsPayments verifyAddCreditButton() {
		try {
			Assert.assertFalse(Utils.uBase.imageCompare("addCredits"), "AddCredits is not present");
			AdvanceReporting.addLogs("pass","AddCredits is not present");
			AdvanceReporting.addLogs("pass","AddCredits is not present","No add credits option");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//To verify calling rates is clickable
	public SettingsPayments verifyCallingRatesIsClickable() {
		try {
			String before=Utils.uBase.getCurrentUrl();
			Utils.uBase.clickByImage("callingRatebtn");
			Utils.uBase.refresh();
			Thread.sleep(3000);
			Utils.uBase.switchToNewWindow();
			String after=Utils.uBase.getCurrentUrl();
			if(before.equals(after)) {
				AdvanceReporting.addLogs("pass", "calling rates is not clickable");
			}
			else {
				AdvanceReporting.addLogs("fail", "calling rates is clickable");
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//Method To verify calling rates is clickable
	public SettingsPayments verifyCallingRatesButton() { 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.clickByImage("callingRatebtn");
			AdvanceReporting.addLogs("info","CallingRate btn clicked");
			AdvanceReporting.addLogs("pass","CallingRate btn clicked","callingRatebtn");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","CallingRate btn not clickable");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}
	//Method To verify calling rates is clickable
	public SettingsPayments clickCallingRatesIcon() { 
		try{ 
			Thread.sleep(1000);
			Utils.uBase.clickByImage("callingRatebtn");
			AdvanceReporting.addLogs("info","CallingRate button clicked");
			AdvanceReporting.addLogs("pass","CallingRate button clicked","callingRatebtn");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","CallingRate button not clicked");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	//Method To verify Date, Time, Type, Destination, Duration, Amount
	public SettingsPayments verifyAllColumnsInBillingHistory() { 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.imageCompare("columnsInBillingHistory");
			AdvanceReporting.addLogs("info","Verified that Only Date,Time,Type,Destination,Duration,Amount are Visible");
			AdvanceReporting.addLogs("pass","Only Date,Time,Type,Destination,Duration,Amount are Visible","columnsInBillingHistory");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","Date,Time,Type,Destination,Duration,Amount are not Visible");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}
	//Method to verify invisibility Balance column in enterprise account
	public SettingsPayments verifyBalanceColumn() {
		try {
			Assert.assertFalse(Utils.uBase.imageCompare("balanceColumn"), "Balance Column is not present");
			AdvanceReporting.addLogs("pass","Verified that balance Column is not present");
			AdvanceReporting.addLogs("pass","Balance Column is not present","balanceColumn");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("info","Balance Column is present");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//Method to verify invisibility Balance column in enterprise account
	public SettingsPayments verifyVoicemailTranscriptsToggle() {
		try {
			Assert.assertFalse(Utils.uBase.imageCompare("voicemailTranscriptsToggle"), "voicemail Transcripts Toggle is not present");
			AdvanceReporting.addLogs("pass","voicemail Transcripts Toggle is not present");
			AdvanceReporting.addLogs("pass","voicemail Transcripts Toggle is not present","voicemailTranscriptsToggle");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("info","Verified that voicemail Transcripts Toggle is present");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments clickBillingHistoryTab() {
		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("billingHistory");


		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	//verify auto recharge
	public SettingsPayments verifyAutoRecharge() { 
		try{ 
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("autoRecharge")==true) {
				AdvanceReporting.addLogs("info","Verified that auto Recharge displayed");
				AdvanceReporting.addLogs("pass","Auto Recharge displayed","autoRecharge");
			}
			else
				AdvanceReporting.addLogs("fail","Auto Recharge not displayed");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","Auto Recharge not displayed");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	// verify balance falls below text $2.00
	public SettingsPayments verifyBalanceFallsBelowText() { 
		try{ 
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("balanceFalls")==true) {
				AdvanceReporting.addLogs("info","Auto Recharge displayed");
				AdvanceReporting.addLogs("pass","Auto Recharge displayed","autoRecharge");
			}
			else
				AdvanceReporting.addLogs("fail","Auto Recharge not displayed");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","Auto Recharge not displayed");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	// click on off
	public SettingsPayments clickAutoBalanceOff() {
		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("autoRechargeOff");
			AdvanceReporting.addLogs("pass", "clicked on off");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	// verify drop down
	public SettingsPayments verifyDropDownResponseAction() { 
		try{ 
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("dropDownResponse")==true) {
				AdvanceReporting.addLogs("info","Verified that drop down displayed");
				AdvanceReporting.addLogs("pass","Drop down displayed","autoRecharge");
			}
			else
				AdvanceReporting.addLogs("fail","Drop down not displayed");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("info","Drop down not displayed");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	// verify drop down
	public SettingsPayments verifyDropDownResponseActionCollapse() { 
		try{ 
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("dropDownResponse")) {
				AdvanceReporting.addLogs("info","Drop down displayed");
				AdvanceReporting.addLogs("pass","Drop down displayed","autoRecharge");
			} else {
				AdvanceReporting.addLogs("info","Drop down collapsed");
				AdvanceReporting.addLogs("pass","Drop down collapsed","collapsed");	
			}
		} catch(Exception e){
			AdvanceReporting.addLogs("info","Auto Recharge displayed");
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	// click on highlighted off
	public SettingsPayments clickAutoBalanceHighlight() {
		try {
			Thread.sleep(5000);
			Utils.uBase.clickByImage("autoRechargeOff");
			AdvanceReporting.addLogs("pass", "clicked on off");

		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public SettingsPayments captureCurrentBalanceBeforeCall() {
		try {
			Utils.uBase.waitForElement(creditBalance);
			AdvanceReporting.addLogs("pass", "Credit balance before call is : "+creditBalance.getText());
			AdvanceReporting.addLogs("pass", "Credit balance before call captured","Credit balance before call captured");
			creditBala=creditBalance.getText().replace("$","");
			creditBala = creditBala.replace(".","");
			creditBalA = Integer.parseInt(creditBala);
		} 
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments captureCallAmountDebited(){
		try {
			Thread.sleep(2000);
			Utils.uBase.refresh();
			Thread.sleep(2000);
			for(int i=1;i<=billItemRows.size();i++) 
			{
				Utils.uBase.hoverWebelement(Utils.uBase.webDriver.findElement(By.xpath("(//tr[contains(@class,'EPj1Ff-m8HfHb')])["+i+"]")));
				{if(Utils.uBase.imageCompare("hoverThreeDots")==true) 
				{
					creditBalc=Utils.uBase.webDriver.findElement(By.xpath("((//tr[contains(@class,'EPj1Ff-m8HfHb')])["+i+"]/td)[7]")).getText().replace("$","");
					AdvanceReporting.addLogs("pass", "Amount credited for call : "+"$"+creditBalc);
					AdvanceReporting.addLogs("pass","Amount credited for call captured","Amount credited for call captured");
					creditBalc = creditBalc.replace(".","");
					creditBalC = Integer.parseInt(creditBalc);
				}
				else 
				{
					AdvanceReporting.addLogs("fail","Amount debited for call not available");
				}
				}
				break;
			}
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
		}
		return this;
	}

	public SettingsPayments captureCurrentBalanceAfterCall() {
		try {
			Utils.uBase.checkPageReady();
			Thread.sleep(4000);
			Utils.uBase.waitForElement(creditBalance);
			AdvanceReporting.addLogs("pass", "Credit balance before call is : "+creditBalance.getText());
			AdvanceReporting.addLogs("pass", "Credit balance before call captured","Credit balance before call captured");
			creditBalb=creditBalance.getText().replace("$","");	
			creditBalb=creditBalb.replace(".","");
			creditBalB = Integer.parseInt(creditBalb);
		} 
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsPayments verifyCurrentBalanceAfterCall() {
		try {
			Thread.sleep(2000);
			Utils.uBase.refresh();
			Thread.sleep(6000);
			int creditBalD = creditBalA-creditBalB;
			//take the two decimal places of float creditBalD as it is saving the decimals to 6 places
			AdvanceReporting.addLogs("pass", "Credit balance after call : "+creditBalD);
			if(((creditBalD)==(creditBalC))==true)
			{
				Thread.sleep(1000);
				AdvanceReporting.addLogs("pass", "Verified that the amount is successfully deprecated by the amount of credit used for the call");	
				AdvanceReporting.addLogs("pass", "Credit balance after call captured","Credit balance after call captured");	
			}
			else 
			{
				AdvanceReporting.addLogs("fail", "The amount shown for credit is not deprecated by the amount of credit used for the call");
			}
		} 
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	public SettingsPayments verifyBillHistoryItems() {
		try {
			Thread.sleep(3000);
			if(Utils.uBase.imageCompare("billHistoryItemsList")==true){
				AdvanceReporting.addLogs("pass","Billing history titles are displayed in the correct format");
				AdvanceReporting.addLogs("pass","Billing history titles are displayed","Billing history titles are displayed");
			}
			else {
				AdvanceReporting.addLogs("fail","Billing history items are not displayed in the intended order");
			}
		}
		catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public SettingsPayments clickAddCreditInPopUp() {
		try {
			Thread.sleep(3000);
			Utils.uBase.clickByImage("popUpAddCredit");
			AdvanceReporting.addLogs("pass","Clicked on add credit option in popup");
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public SettingsPayments verifyCreditPopUP() {
		try {
			Thread.sleep(15000);
			if(Utils.uBase.imageCompare("completePurchase")==true) {
				AdvanceReporting.addLogs("pass","Verified that complete your purchase popup is displayed");
				Thread.sleep(15000);
				AdvanceReporting.addLogs("pass","Verified that complete your purchase popup is displayed","completePurchasePOpUp");
			}
			
		}
		catch(Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	//verify auto recharge
		public SettingsPayments verifyAutoRechargeNotPresent() { 
			try{ 
				Thread.sleep(2000);
				if(Utils.uBase.imageCompare("autoRecharge")==false) {
					AdvanceReporting.addLogs("info","Verified that auto Recharge is not displayed");
					AdvanceReporting.addLogs("pass","Auto Recharge not displayed","autoRecharge");
				}
				else
					AdvanceReporting.addLogs("fail","Auto Recharge displayed");
			}
			catch(Exception e){
				AdvanceReporting.addLogs("info","Auto Recharge not displayed");
				AdvanceReporting.addLogs("fail", e.getMessage()); 
			}
			return this; 
		}

}