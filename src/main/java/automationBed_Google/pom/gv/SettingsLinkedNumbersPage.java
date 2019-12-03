package automationBed_Google.pom.gv;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class SettingsLinkedNumbersPage
{

	//Locators
	@FindBy(xpath="//*[contains(@class,'lQP0Od-wKtwcc')]")
	WebElement gvNumb;
	@FindBy(xpath="//*[contains(@aria-label,'Change Google Voice number')]")
	WebElement gvChangeBtn;
	@FindBy(xpath="//*[contains(@aria-label,'Transfer Google Voice number')]")
	WebElement gvTransferBtn;
	@FindBy(xpath="//*[contains(@aria-label,'Delete Google Voice number')]")
	WebElement gvDeleteBtn;
	@FindBy(xpath="//*[contains(@ng-click,'BillingHistoryClick')]")
	WebElement gvBillingHistoryBtn;	
	@FindBy(xpath="//*[contains(@class,'b1gcZe-vyJ3zc')]//*[contains(@gv-test-id,'number')]")
	WebElement gvlinkedNum;
	@FindBy(xpath="//*[contains(@aria-label,'Edit ')]")
	WebElement gvEditBtn;	
	@FindBy(xpath="//*[contains(@gv-test-id,'linked-phone-name')]")
	WebElement gvlinkedphname;
	@FindBy(xpath="//*[contains(@aria-label,'Remove ')]")
	WebElement gvRemoveBtn;
	@FindBy(xpath="//input[@placeholder='Phone Name']")
	WebElement gvNewlinkedNum;
	
	public SettingsLinkedNumbersPage getGvLinkedNum(String data) throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(gvlinkedNum);
			AdvanceReporting.addLogs("pass", "Settings Page","Settings Page");
			String expGVNum[] = data.split("\\|");
			int numbs = expGVNum.length;
			for(int i=0;i<numbs;i++)
			{
				List<WebElement> allElements = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@class,'b1gcZe-vyJ3zc')]//*[contains(@gv-test-id,'number')]"));				
				for(WebElement ele : allElements) {
					String gvlinkedNumber = ele.getText();
					if(gvlinkedNumber.equals(expGVNum[i]))
					{
						AdvanceReporting.addLogs("pass", "Google Voice Linked Number: "+gvlinkedNumber +" is matched with : "+expGVNum[i]);
					}
					/*else
					{
						AdvanceReporting.addLogs("info", "Google Voice Linked Number: "+gvlinkedNumber +"is not matched with : "+expGVNum[i]);
					}*/
				}
			}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}

	public SettingsLinkedNumbersPage verifyEditIcon(String data) throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(gvEditBtn);
			String expGVNum[] = data.split("\\|");
			int numbs = expGVNum.length;
			for(int i=0;i<numbs;i++)
			{
				List<WebElement> allElements = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@class,'b1gcZe-vyJ3zc')]//*[contains(@gv-test-id,'number')]"));				
				for(WebElement ele : allElements) 
				{
					String gvlinkedNumber = ele.getText();
					if(gvlinkedNumber.equals(expGVNum[i]))
					{						
						Utils.uBase.waitForElementToBeClickable(gvEditBtn);
						AdvanceReporting.addLogs("pass", "Google Voice Edit Button is Available for the Number "+expGVNum[i]);
//						AdvanceReporting.addElementImage("pass", gvEditBtn);
//						AdvanceReporting.addLogs("pass", "Google Voice Linked Number: "+gvlinkedNumber +" is matched with : "+expGVNum[i]);
					}					
				}
			}
			
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
	public SettingsLinkedNumbersPage verifyCloseIcon(String data) throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(gvRemoveBtn);
			String expGVNum[] = data.split("\\|");
			int numbs = expGVNum.length;
			for(int i=0;i<numbs;i++)
			{
				List<WebElement> allElements = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@class,'b1gcZe-vyJ3zc')]//*[contains(@gv-test-id,'number')]"));				
				for(WebElement ele : allElements) 
				{
					String gvlinkedNumber = ele.getText();
					if(gvlinkedNumber.equals(expGVNum[i]))
					{						
						Utils.uBase.waitForElementToBeClickable(gvRemoveBtn);
						AdvanceReporting.addLogs("pass", "Google Voice Delete Button available for the Number "+expGVNum[i]);
//						AdvanceReporting.addElementImage("pass", gvRemoveBtn);
//						AdvanceReporting.addLogs("pass", "Google Voice Linked Number: "+gvlinkedNumber +" is matched with : "+expGVNum[i]);
					}					
				}
			}
			
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public SettingsLinkedNumbersPage verifyNameoflinkedphone(String data) throws Exception
	{
		try
		{
			String expGVNum[] = data.split("\\|");
			int numbs = expGVNum.length;
			for(int i=0;i<numbs;i++)
			{
				List<WebElement> allElements = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@class,'b1gcZe-vyJ3zc')]//*[contains(@gv-test-id,'number')]"));				
				for(WebElement ele : allElements) 
				{
					String gvlinkedNumber = ele.getText();
					if(gvlinkedNumber.equals(expGVNum[i]))
					{						
						Utils.uBase.waitForElementToBeClickable(gvlinkedphname);
						AdvanceReporting.addLogs("pass", "GoogleVoice Linked Phone name for the Number ("+expGVNum[i] + ") is " + gvlinkedphname.getText());
						AdvanceReporting.addElementImage("pass", gvlinkedphname);
					}					
				}
			}
			
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	public SettingsLinkedNumbersPage changeAliasPhoneName(String data, String newName) throws Exception
	{
		try
		{
			String expGVNum[] = data.split("\\|");
			int numbs = expGVNum.length;
			for(int i=0;i<numbs;i++)
			{
				List<WebElement> allElements = Utils.uBase.webDriver.findElements(By.xpath("//*[contains(@class,'b1gcZe-vyJ3zc')]//*[contains(@gv-test-id,'number')]"));				
				for(WebElement ele : allElements) 
				{
					String gvlinkedNumber = ele.getText();
					if(gvlinkedNumber.equals(expGVNum[i]))
					{						
						Utils.uBase.waitForElementToBeClickable(gvEditBtn);												
						Utils.uBase.clickWebelement(gvEditBtn);
						gvNewlinkedNum.sendKeys(newName);
						Thread.sleep(1000);
						Utils.uBase.focusWebelement(gvChangeBtn);
						Thread.sleep(2000);
						AdvanceReporting.addLogs("pass", "GoogleVoice Linked Phone name for the Number ("+expGVNum[i]+") is changed to " +newName);											
					}break;
				}
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
	
	public SettingsLinkedNumbersPage verifyNameoflinkedphoneallpage(String data, String newName) throws Exception
	{
		try
		{
			String expGVNum[] = data.split("\\|");
			int numbs = expGVNum.length;
			for(int i=0;i<numbs;i++)
			{
				List<WebElement> allElements = Utils.uBase.webDriver.findElements(By.xpath("//*//*[contains(@gv-test-id,'phone-number')]"));
				int numbs1 = allElements.size();
				AdvanceReporting.addLogs("pass", "Found ("+ numbs1 +") matches of GoogleVoice Linked Phone Number - "+expGVNum[i]);
				for(WebElement ele : allElements) 
				{
					String gvlinkedNumber = ele.getText();
					if(gvlinkedNumber.equals(expGVNum[i]))
					{	
						if(newName.equals(gvlinkedphname.getText()))
						{
//							AdvanceReporting.addLogs("pass", "The expected name("+ newName +") for GoogleVoice Linked Phone Number ("+expGVNum[i] + ") is changed to " + gvlinkedphname.getText());
							AdvanceReporting.addElementImage("pass", gvlinkedphname);							
						}						
					}					
				}
			}			
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace(); Assert.fail();
		}
		return this;
	}
}

