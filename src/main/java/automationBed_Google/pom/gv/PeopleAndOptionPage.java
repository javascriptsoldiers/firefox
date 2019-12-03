package automationBed_Google.pom.gv;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;

public class PeopleAndOptionPage {

	@FindBy(xpath="//*[contains(@aria-label,'Contact name')]")
	WebElement contactName;
	@FindBy(xpath="//*[contains(@aria-label,'Contact label')]")
	WebElement contactLabel;
	@FindBy(xpath="//span[@jsname='GYDesb']")
	private List<WebElement> addedContactList;



	/* Clicked People using Image */
	public PeopleAndOptionPage clickPeople() {
		try {
			Thread.sleep(3000);
			Utils.uBase.clickByImage("PeopleGrpMsg");
			AdvanceReporting.addLogs("Pass", "Clicked on people option");
			AdvanceReporting.addLogs("Pass", "Clicked on people option", "peopleGrpMsg");
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/* Adding the contact as work label */
	public PeopleAndOptionPage addToContact(){
		try {
			Thread.sleep(4000);
			Utils.uBase.clickByImage("AddContactImg");
			Thread.sleep(4000);
			contactName.sendKeys("TestName");
			Thread.sleep(2000);
			contactLabel.click();
			Thread.sleep(4000);
			Utils.uBase.clickByImage("ContactLabelImg");
			Thread.sleep(5000);
			Utils.uBase.clickByImage("AddContactButtonImg");
			AdvanceReporting.addLogs("Pass", "Contact added sucessfully");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not added");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/* Verify phone number is added with new contact name. */
	public PeopleAndOptionPage verifyPhoneNumberAddedWithNewContactName(){
		try {
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("phoneNumberAddToContact")) {
				AdvanceReporting.addLogs("pass", "Verified that phone number is added with new contact name");
				AdvanceReporting.addLogs("pass", "Phone number is added with new contact name","ContactSavedwithName");
			}else {
				AdvanceReporting.addLogs("fail", "Phone number is not added with new contact name","ContactNotSavedwithName");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}


	/* All the relevant conversation items to be replaced with that new contact name and phone type.*/
	public PeopleAndOptionPage verifyAllContactNameReplacedWithNewContact(){
		try {
			Thread.sleep(2000);
			if(Utils.uBase.imageCompare("phoneNumberAddToContact")) {
				AdvanceReporting.addLogs("pass", "Verified that conversation item is replaced with that new contact name and phone type");
				AdvanceReporting.addLogs("pass", "Conversation item is replaced with that new contact name and phone type","ContactReplaced");
			}else {
				AdvanceReporting.addLogs("fail", "Conversation item is not replaced with that new contact name and phone type","ContactNotReplaced");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Varied International phone number is added with new contact name. */
	public PeopleAndOptionPage verifyInterNationalPhNumAddedWithNewContactName(){
		try {
			Thread.sleep(4000);
			if(Utils.uBase.imageCompare("phoneNumberAddToContact")) {
				AdvanceReporting.addLogs("pass", "Verified that phone number added with new contact name");
				AdvanceReporting.addLogs("pass", "Phone number added with new contact name","ContactSavedwithName");
			}else {
				AdvanceReporting.addLogs("pass", "Phone number is added with new contact name","ContactNotSavedwithName");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not added");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public PeopleAndOptionPage verifyContactNameReplacedWithNewContact(){
		try {
			Thread.sleep(6000);
			if(Utils.uBase.imageCompare("phoneNumberAddToContact")) {
				AdvanceReporting.addLogs("pass", "Verified that conversation item is replaced with that new contact name and phone type");
				AdvanceReporting.addLogs("pass", "Conversation item is replaced with that new contact name and phone type","ContactReplaced");
			}else {
				AdvanceReporting.addLogs("fail", "Conversation item is not replaced with that new contact name and phone type","ContactNotReplaced");
			}
		}catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not replaced with  phone type");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}



	/* Delete added contact */
	public PeopleAndOptionPage deleteAddedContact(){
		try {
			Thread.sleep(2000);
			Utils.uBase.switchWindowByTitle("Google Contacts");
			Thread.sleep(2000);
			for(int i=0; i<addedContactList.size(); i++) {
				String allContacts = addedContactList.get(i).getText();
				if(allContacts.contentEquals(Constants.addContactName)) {
					Thread.sleep(1000);
					addedContactList.get(i).click();
					Thread.sleep(2000);
					Utils.uBase.clickByImage("contactThreeDotsOption");
					Thread.sleep(2000);
					Utils.uBase.clickByImage("contactDeleteOption");
					Thread.sleep(2000);
					Utils.uBase.clickByImage("deleteContactBtn");
					Thread.sleep(2000);
					AdvanceReporting.addLogs("pass", "Contact deleted sucessfully");
				}
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not deleted");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Selected google apps menu option */
	public PeopleAndOptionPage clickOnGoogleAppsMenu(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("menuOptions");
			AdvanceReporting.addLogs("Pass", "Google apps menu opens sucessfully");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Google apps menu not opened");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	/* Selected google apps menu option */
	public PeopleAndOptionPage clickOnContactsOptionFromGoogleApps(){
		try {
			Thread.sleep(2000);
			Utils.uBase.clickByImage("clickOnContact");
			AdvanceReporting.addLogs("Pass", "Contact option is selected from google apps menu");
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact option is not selected from google apps menu");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	/* Varied short code phone number should be added with new contact name. */
	public PeopleAndOptionPage verifyShortCodePhNumAddedWithNewContactName(){
		try {
			Thread.sleep(4000);
			if(Utils.uBase.imageCompare("shortCodeAddedToContact")) {
				AdvanceReporting.addLogs("pass", "Short code phone number added with new contact name","ContactSavedwithName");
			}else {
				AdvanceReporting.addLogs("fail", "Short code phone number is added with new contact name","ContactNotSavedwithName");
			}
		} catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not added");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public PeopleAndOptionPage verifyShortCodeContactNameReplacedWithNewContact(){
		try {
			Thread.sleep(6000);
			if(Utils.uBase.imageCompare("shotCodePhNumWithSeletedType")) {
				AdvanceReporting.addLogs("pass", "Verified that conversation item is replaced with that new contact name and phone type");
				AdvanceReporting.addLogs("pass", "Conversation item is replaced with that new contact name and phone type","ContactReplaced");
			}else {
				AdvanceReporting.addLogs("fail", "Conversation item is not replaced with that new contact name and phone type","ContactNotReplaced");
			}
		}catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not replaced with  phone type");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
	public PeopleAndOptionPage verifyShortCodeContactNameReplacedWithSelectedType(){
		try {
			Thread.sleep(5000);
			if(Utils.uBase.imageCompare("shotCodePhNumWithSeletedType")) {
				AdvanceReporting.addLogs("pass", "Verified that conversation item is replaced with that new contact name and phone type");
				AdvanceReporting.addLogs("pass", "Conversation item is replaced with that new contact name and phone type","ContactReplaced");
			}else {
				AdvanceReporting.addLogs("fail", "Conversation item is not replaced with that new contact name and phone type","ContactNotReplaced");
			}
		}catch (Exception e) {
			AdvanceReporting.addLogs("info", "Contact not replaced with  phone type");
			AdvanceReporting.addLogs("fail", "Error Message: " + e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	


}
