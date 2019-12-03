package automationBed_Google.pom.gv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class CalendarSettingsPage 
{

	@FindBy(xpath="(//*[contains(@class,'Kb2sf QGLPie nXeosb t4IwDf CDELXb')])[1]")
	WebElement workTimeCol1;
	@FindBy(xpath="(//*[contains(@class,'w8UdJc')]/*[contains(text(),'3:00am')])[1]")
	WebElement startWorkTime;
	@FindBy(xpath="(//*[contains(@class,'Kb2sf QGLPie nXeosb t4IwDf CDELXb')])[2]")
	WebElement workTimeCol2;
	@FindBy(xpath="(//*[contains(@class,'w8UdJc')]/*[contains(text(),'5:00am')])[2]")
	WebElement endWorkTime;	
	@FindBy(xpath="//*[contains(@aria-label,'Enable working hours')]")
	WebElement enableWorkingHrs;
	@FindBy(xpath="//*[contains(@class,'IuSHYd')and @aria-label='Sunday']")
	WebElement sunWorkdDay;
	

	//To click on Working hours tab in Calendar settings
	public CalendarSettingsPage clickWorkingHours(){ 
		try{ 
			Thread.sleep(3000);
			Utils.uBase.clickByImage("workingHours");
			AdvanceReporting.addLogs("pass", "Clicked on working hours tab in calendar settings");
			AdvanceReporting.addLogs("pass", "Clicked on working hours","Clicked on working hours");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	//To enable Working hours check box in working hours section
	public CalendarSettingsPage enableWorkingHours(){ 
		try{ 
			Thread.sleep(2500);
			if(enableWorkingHrs.getAttribute("aria-checked").contains("true")) {
				AdvanceReporting.addLogs("pass", "Working hours is enabled");
				AdvanceReporting.addLogs("pass", "Working hours is enabled","working hours is enabled");
			}
			else {
				Utils.uBase.clickByImage("enableWorkingHours");
				AdvanceReporting.addLogs("pass", "Working hours successfully enabled");
				AdvanceReporting.addLogs("pass", "Working hours successfully enabled","Working hours successfully enabled");
			}
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	//To select the working days in calendar settings
	public CalendarSettingsPage selectWorkingDays(String workDayImg){ 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.clickByImage(workDayImg);
			AdvanceReporting.addLogs("pass", ""+workDayImg+" is selected as work day");
			AdvanceReporting.addLogs("pass",""+workDayImg+" is selected",""+workDayImg+"is selected");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	//To Unselect the working days in calendar settings
	public CalendarSettingsPage unSelectWorkingDays(String workDayImg){ 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.clickByImage(workDayImg);
			AdvanceReporting.addLogs("pass", ""+workDayImg+" is unselected as work day");
			AdvanceReporting.addLogs("pass",""+workDayImg+" is unselected",""+workDayImg+"is selected");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	//To select the time from the time section
	public CalendarSettingsPage selectWorkingHourTime(){ 
		try{ 

			Thread.sleep(2000);
			Utils.uBase.clickByImage("enableWorkingHours");
			AdvanceReporting.addLogs("pass", "Working hours successfully enabled");
			AdvanceReporting.addLogs("pass", "Working hours successfully enabled","Working hours successfully enabled");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	// To select Sunday as working day in the working hours section
	public CalendarSettingsPage selectSunWorkDay(){ 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.waitForElement(sunWorkdDay);
			Utils.uBase.clickWebelement(sunWorkdDay);
			AdvanceReporting.addLogs("pass", "Sunday selected as working day and successfully enabled");
			AdvanceReporting.addLogs("pass", "Sunday selected as working day","Sunday selected as working day");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	// To select start working hours in calendar settings
	public CalendarSettingsPage clickWorkHoursStart(){ 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.waitForElement(workTimeCol1);
			Utils.uBase.clickWebelement(workTimeCol1);
			AdvanceReporting.addLogs("pass", "Clicked on the time box to select the start time");
			AdvanceReporting.addLogs("pass", "Clicked on the time box","Clicked on the time box");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	// To select work start time in working hours section
	public CalendarSettingsPage selectWorkStartTime(){ 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.waitForElement(startWorkTime);
			Utils.uBase.scrolltoElement(startWorkTime);
			Utils.uBase.clickWebelement(startWorkTime);
			AdvanceReporting.addLogs("pass", "Clicked on the time box to select the start time");
			AdvanceReporting.addLogs("pass", "Clicked on the time box","Clicked on the time box");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	// To select end working hours in calendar settings
	public CalendarSettingsPage clickWorkHoursEnd(){ 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.waitForElement(workTimeCol2);
			Utils.uBase.clickWebelement(workTimeCol2);
			AdvanceReporting.addLogs("pass", "Clicked on the time box to select the start time");
			AdvanceReporting.addLogs("pass", "Clicked on the time box","Clicked on the time box");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	// To select work end time in working hours section
	public CalendarSettingsPage selectWorkEndTime(){ 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.waitForElement(endWorkTime);
			Utils.uBase.scrolltoElement(endWorkTime);
			Utils.uBase.clickWebelement(endWorkTime);
			AdvanceReporting.addLogs("pass", "Clicked on the time box to select the start time");
			AdvanceReporting.addLogs("pass", "Clicked on the time box","Clicked on the time box");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	//To select copy to all option under working hours section
	public CalendarSettingsPage selectCopyToAll(){ 
		try{ 
			Thread.sleep(2000);
			Utils.uBase.clickByImage("copyToAll");
			AdvanceReporting.addLogs("pass", "Clicked on Copy to all option");
			AdvanceReporting.addLogs("pass", "Clicked on Copy to all option","Clicked on Copy to all option");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}

	//To enable Working hours check box in working hours section
	public CalendarSettingsPage disableWorkingHours(){ 
		try{ 
			Thread.sleep(2500);
			Utils.uBase.clickByImage("disableWorkHours");
			AdvanceReporting.addLogs("pass", "Working hours are successfully disabled");
			AdvanceReporting.addLogs("pass", "Working hours successfully disabled","Working hours successfully disabled");
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail", e.getMessage()); 
		}
		return this; 
	}
}
