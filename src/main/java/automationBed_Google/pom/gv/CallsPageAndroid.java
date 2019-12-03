package automationBed_Google.pom.gv;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.ReceiveCallAndMessages;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.constants.Constants;
import automationBed_Google.utility.dataManager.DmConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CallsPageAndroid
{
	
	@AndroidFindBy(xpath="//*[@resource-id='com.samsung.android.contacts:id/log_contents']")
	List<WebElement> callsList;
	@FindBy(xpath="//*[@gv-test-id='conversation-avatar-or-checkmark']")
    List<WebElement> AvatarsList;
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='(647) 490-8123'])")
	List<WebElement> lstCalls;
	

	public CallsPageAndroid(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	  public CallsPageAndroid verifyIfCallIsTriggeredToMobile(String data,String callsFwdCondition)
	    {
			GeneralActivitiesPage GAPage = PageFactory.initElements(Utils.uBase.webDriver, GeneralActivitiesPage.class);

	    	try {
	    		String str3="("+ Constants.phoneNumber.replace("+1", "");
	    		String strPhoneNo=str3.substring(0, 4)+") "+str3.substring(4,7)+"-"+str3.substring(7,str3.length());	
	    		List<AndroidElement> lstCountOfCalls=Utils.uBase.mDriver.findElements(By.xpath("(//android.widget.TextView[@text='"+strPhoneNo+"'])//../android.widget.TextView[2]"));
	    		int initialSizeOfList=lstCountOfCalls.size();
	    		AdvanceReporting.addMobileImageLogs("info", "Initial calls count in mobile", "calls list count initially in mobile");
				int count=0;
				
				if(initialSizeOfList>0){
	    			
					if(lstCountOfCalls.get(0).getText().contains("Unsaved")){
	    				count++;
	    				AdvanceReporting.addLogs("info", "Calls are newly triggered to this number");
	    				AdvanceReporting.addMobileImageLogs("info", "Calls triggered to mobile", "calls triggered");
	        		}else if(lstCountOfCalls.get(0).getText().contains("(")){
	    				 
	    				String s=lstCountOfCalls.get(0).getText().replaceAll("\\(", "").replaceAll("\\)", "");
	    				 AdvanceReporting.addLogs("info", "Initial call count :"+s);
	    				 AdvanceReporting.addMobileImageLogs("info", "Calls triggered to mobile", "calls triggered");
	    				 count=Integer.parseInt(s);   				
	    			}}		
				AdvanceReporting.addLogs("info", "Triggering a call from Twillio to GV");
	 			//ReceiveCallAndMessages.makeCall(data);
				GAPage.receiveMultipleCalls(Constants.voipTwoId, Constants.pwd2, data, 2);
	 			Thread.sleep(25000);
	 			AdvanceReporting.addLogs("info", "Call sent from Twillio to GV");
	    		  
	 			if(callsFwdCondition.equalsIgnoreCase("true")){	
	    			  
			    		if(lstCountOfCalls.get(0).getText().contains("Unsaved")){
			    			
			    			if(lstCalls.get(0).getText().contains(strPhoneNo)){
			    				
			    				AdvanceReporting.addLogs("pass", "Call is forwarded to linked mobile number");
			    				AdvanceReporting.addMobileImageLogs("info", "Calls triggered to mobile", "calls triggered");
			    			}}else{
			    			if(lstCountOfCalls.get(0).getText().contains("(")){
			    				
			    				try {
			    				int updatedCount=Integer.parseInt(lstCountOfCalls.get(0).getText().replaceAll("\\(", "").replaceAll("\\)", ""));
			    				AdvanceReporting.addLogs("info", "Calls count after call is triggered"+updatedCount);
			    				Assert.assertTrue(updatedCount>count,"Call's not received");
			    				AdvanceReporting.addLogs("Pass", "Call is forwarded to linked mobile number");
			    				AdvanceReporting.addMobileImageLogs("info", "Calls triggered to mobile", "calls triggered");
			    				}catch(Exception e) {
			    					AdvanceReporting.addLogs("fail", "Call is not forwarded to linked mobile number");
			    				}
			    				
			    			}}}
	 			else { 
			    				
			    				if(lstCountOfCalls.get(0).getText().contains("Unsaved")){
	        			  
			    					if(!lstCalls.get(0).getText().contains(strPhoneNo)){
			    				
			    						AdvanceReporting.addLogs("pass", "Call is not forwarded to linked mobile number when toggle is off");
			    						AdvanceReporting.addMobileImageLogs("info", "Calls are not triggered to mobile", "calls not triggered");
			    					}}else{
			    			if(lstCountOfCalls.get(0).getText().contains("(")){
			    				
			    				int updatedCount=Integer.parseInt(lstCountOfCalls.get(0).getText().replaceAll("\\(", "").replaceAll("\\)", ""));
			    				Assert.assertTrue(updatedCount==count,"Call is triggered received");
			    				AdvanceReporting.addLogs("info", "Call count in mobile after call is made to GV when toggle is OFF:"+updatedCount);
			    				AdvanceReporting.addLogs("Pass", "Call is not forwarded to linked mobile number when toggle is off");
			    				AdvanceReporting.addMobileImageLogs("info", "Calls not triggered to mobile", "calls triggered");
			    			}}}}catch(Exception e) {   		
	    		
			    				AdvanceReporting.addLogs("fail", "Call forwarding to linked mobile number failed");
	    	}return this;
	    }

		


}


