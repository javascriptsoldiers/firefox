package automationBed_Google.utility.base;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.excelManager.ExcelUtility;
import automationBed_Google.utility.excelManager.Read_XLS;
import automationBed_Google.utility.logsManager.LogsManager;
import automationBed_Google.utility.mailManager.MailManager;

public class SuiteBase {

	public static Read_XLS TestSuite= null;


	@BeforeSuite
	public void beforeSuite() throws Exception {
		init();
	}

	@AfterSuite
	public void afterSuite() {
		//MailManager.sendMail();
	}

	public void init(){
		TestSuite = new Read_XLS(System.getProperty("user.dir")+"//src//main//resources//datafiles//TestSuite.xlsx");
		Utils.uBase=new BaseUtility();
		Utils.addLog=LogsManager.createLogger("application");
	}

	private String suiteName = this.getClass().getSimpleName();

	@BeforeTest
	@Parameters("browser")

	public void beforeTest(String browser) throws Exception
	{
		Utils.uBase.setupDriver(browser);
		Utils.uBase.intializeReport(suiteName, browser);
	}

	@AfterTest
	public void afterTest() 
	{
		Utils.uBase.finalizeReport();
		if(Utils.uBase.webDriver!=null) {
			Utils.uBase.webDriver.quit();}
		if(Utils.uBase.mDriver!=null) {
			Utils.uBase.mDriver.quit();}

	}

	// Data Provider
	@DataProvider(name = "GoogledataProvider")
	public Object[][] GoogledataProvider() {
		return new ExcelUtility().getData(TestSuite, suiteName);
	}

	@Test(dataProvider = "GoogledataProvider")
	public void Googletesting(String testCase, String email, String password, String data) throws Exception
	{
		String status = "pass";
		Utils.uBase.StartTest(testCase);

		try {

			if (new ExcelUtility().getToRunFlag(TestSuite, suiteName, testCase))
			{
				try 
				{
					String methodName=Utils.uBase.lowerCaseFirst(testCase.replaceAll("\\s+",""));

					Method method = this.getClass().getMethod(methodName, String.class, String.class, String.class);
					method.invoke(this, email, password, data);
				} 
				catch (NoSuchMethodException e) 
				{
					status = "skip";
				}
			} else
			{
				status = "skip";
			}

		} catch (Exception e)
		{
			status = "fail";
			e.printStackTrace();
		}
		finally {
			Utils.uBase.writeResult(suiteName, status);
			AdvanceReporting.addLogs(status, testCase + " " + status);

			Utils.uBase.EndTest();
		}
	}


}
