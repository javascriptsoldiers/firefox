package automationBed_Google.pom.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.BaseUtility;
import automationBed_Google.utility.base.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TrialPage {

	//Locators
	@AndroidFindBy(xpath = "//*[@text='Calls']|//*[contains(@content-desc, 'Calls') ]")
	private AndroidElement callsHeader;
	@AndroidFindBy(xpath = "//*[contains(@content-desc, 'Make a call') ]")
	private AndroidElement fabIcon;
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialed_number")
	private AndroidElement dialField;
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/call_button")
	private AndroidElement callBtn;

	// DailPad 1
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialpad_one")
	private AndroidElement dailPadOne;

	// DailPad 2
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialpad_two")
	private AndroidElement dailPadTwo;

	// DailPad 3
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialpad_three")
	private AndroidElement dailPadThree;

	// DailPad 4
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialpad_four")
	private AndroidElement dailPadFour;

	// DailPad 5
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialpad_five")
	private AndroidElement dailPadFive;

	// DailPad 6
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialpad_six")
	private AndroidElement dailPadSix;

	// DailPad 7
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialpad_seven")
	private AndroidElement dailPadSeven;

	// DailPad 8
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialpad_eight")
	private AndroidElement dailPadEight;

	// DailPad 9
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialpad_nine")
	private AndroidElement dailPadNine;

	// DailPad 0
	@AndroidFindBy(id = "com.google.android.apps.googlevoice:id/dialpad_zero")
	private AndroidElement dailPadZero;

	// DailPad *
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"*\"]/android.widget.TextView")
	private AndroidElement dailPadStar;

	// DailPad #
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"#\"]/android.widget.TextView")
	private AndroidElement dailPadPound;


	public TrialPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public TrialPage clickCallsTabheader(){
		//		this.driver=driver;
		//		click(callsHeader);
		try {
			Utils.uBase.clickAndroidelement(callsHeader);
			AdvanceReporting.addLogs("pass", "Calls Page","Calls Page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public TrialPage clickFabIcon(){
		try {
			Utils.uBase.clickAndroidelement(fabIcon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public TrialPage dialNumb(String num) {
		try {
			for (int i = 0; i < num.length(); i++) {
			switch (num.charAt(i)) {
			case '1':
				Utils.uBase.clickAndroidelement(dailPadOne);

				break;
			case '2':
				Utils.uBase.clickAndroidelement(dailPadTwo);
				break;
			case '3':
				Utils.uBase.clickAndroidelement(dailPadThree);
				break;
			case '4':
				Utils.uBase.clickAndroidelement(dailPadFour);
				break;
			case '5':
				Utils.uBase.clickAndroidelement(dailPadFive);
				break;
			case '6':
				Utils.uBase.clickAndroidelement(dailPadSix);
				break;
			case '7':
				Utils.uBase.clickAndroidelement(dailPadSeven);
				break;
			case '8':
				Utils.uBase.clickAndroidelement(dailPadEight);
				break;
			case '9':
				Utils.uBase.clickAndroidelement(dailPadNine);
				break;
			case '0':
				Utils.uBase.clickAndroidelement(dailPadZero);
				break;
			default:

			}
		}} catch (Exception e) {
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public TrialPage clickCallBtn(){
		try {
			Utils.uBase.clickAndroidelement(callBtn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
}





