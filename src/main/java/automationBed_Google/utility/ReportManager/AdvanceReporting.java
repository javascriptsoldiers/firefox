package automationBed_Google.utility.ReportManager;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automationBed_Google.utility.base.Constant;
import automationBed_Google.utility.base.Utils;

public class AdvanceReporting {

	private static ExtentReports report;
	private static ExtentTest logger;
	public static String reportPath;
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(Calendar.getInstance().getTime());
	
	public static void refreshTimestamp() {
    	Utils.addLog.traceEntry();
        timeStamp = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(Calendar.getInstance().getTime());
        Utils.addLog.traceExit();
	}

	public static void intializeReport(String suiteName, String browser){
		 refreshTimestamp();
		Utils.addLog.debug("setting path for report : {}",suiteName+"\\AdvanceReport"+"_"+browser+"_"+timeStamp+".html");
		Constant.SuiteName.setConstant(suiteName);
		
		reportPath=Constant.ReportPath.getConstant()+"\\AdvanceReport"+"_"+browser+"_"+timeStamp+".html";
		Utils.addLog.debug("Initializing report for : {}",Constant.SuiteName.getConstant());
		report= new ExtentReports(reportPath);

	}

	public static void intializeLoger(String testCase){
		Utils.addLog.debug("Initializing Testcase instance for {} in report",testCase);
		logger=report.startTest(testCase);
	}
	public static void addLogs(String status, String value){

		switch (status.toLowerCase()) {
		case "info":
			logger.log(LogStatus.INFO, value);
			break;
		case "pass":
			logger.log(LogStatus.PASS, value);
			break;
		case "fail":
			logger.log(LogStatus.FAIL, value);
			break;
		case "skip":
			logger.log(LogStatus.SKIP, value);
			break;
		case "error":
			logger.log(LogStatus.ERROR, value);
			break;

		default:
			break;
		}
	}

	public static void addLogs(String status, String value, String snapshotName) throws Exception{

		//capturing Snaps and getting image String
		String image =logger.addScreenCapture(Utils.uBase.takeScreenshot(snapshotName));

		switch (status.toLowerCase()) {
		case "info":
			logger.log(LogStatus.INFO, value, image);
			break;
		case "pass":
			logger.log(LogStatus.PASS, value, image);
			break;
		case "fail":
			logger.log(LogStatus.FAIL, value, image);
			break;
		case "skip":
			logger.log(LogStatus.SKIP, value, image);
			break;
		case "error":
			logger.log(LogStatus.ERROR, value, image);
			break;

		default:
			break;
		}


	}

	public static void addLogsAshot(String status, String value, String snapshotName) throws Exception{

		//capturing Snaps and getting image String
		String image =logger.addScreenCapture(Utils.uBase.takeScreenShot_Ashot(snapshotName));

		switch (status.toLowerCase()) {
		case "info":
			logger.log(LogStatus.INFO, value, image);
			break;
		case "pass":
			logger.log(LogStatus.PASS, value, image);
			break;
		case "fail":
			logger.log(LogStatus.FAIL, value, image);
			break;
		case "skip":
			logger.log(LogStatus.SKIP, value, image);
			break;
		case "error":
			logger.log(LogStatus.ERROR, value, image);
			break;

		default:
			break;
		}


	}

	public static void addElementImage(String status, WebElement element) throws Exception{

//capturing Snaps and getting image String

		String snapshotName = "snap";
		String image =logger.addScreenCapture(Utils.uBase.takeScreenshotOfWebelement(element,snapshotName));
		String value = "CropedImage";
		switch (status.toLowerCase()) {
		case "info":
			logger.log(LogStatus.INFO, value, image);
			break;
		case "pass":
			logger.log(LogStatus.PASS, value, image);
			break;
		case "fail":
			logger.log(LogStatus.FAIL, value, image);
			break;
		case "skip":
			logger.log(LogStatus.SKIP, value, image);
			break;
		case "error":
			logger.log(LogStatus.ERROR, value, image);
			break;

		default:
			break;
		}


	}


	public static void endTest(){
		Utils.addLog.debug("Ending current Testcase instance in report");
		report.endTest(logger);
	}

	public static void endReport() {
		Utils.addLog.debug("Ending report for current Suite");
		report.flush();
	}

	public static void getReport(){
		//		Utils.driver.get(reportPath);
	}
	
	public static void addMobileImageLogs(String status, String value, String snapshotName) throws Exception{

		//capturing Snaps and getting image String
		String image =logger.addScreenCapture(Utils.uBase.takeScreenshot(snapshotName));

		switch (status.toLowerCase()) {
		case "info":
			logger.log(LogStatus.INFO, value, image);
			break;
		case "pass":
			logger.log(LogStatus.PASS, value, image);
			break;
		case "fail":
			logger.log(LogStatus.FAIL, value, image);
			break;
		case "skip":
			logger.log(LogStatus.SKIP, value, image);
			break;
		case "error":
			logger.log(LogStatus.ERROR, value, image);
			break;

		default:
			break;
		}


	}
	
	public static void attachScreenPrintToReport(String status, String value,String screnPrintPath) throws Exception{
		
		Robot robot = new Robot();	
		
		// create rectangle for full screenshot
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());	
		
		// capture screen of the desktop
		BufferedImage screenFullImage = robot.createScreenCapture(screenRect);		
		
		// save the screenshot to local system
		String snapPath = Constant.ReportPath.getConstant() +Constant.SuiteName.getConstant()+"\\"+Constant.TestCase.getConstant()+"\\"+ screnPrintPath +"_"+ timeStamp + ".png";
		
		//ImageIO.write(screenFullImage, "png", new File(snapPath));
		ImageIO.write(screenFullImage, "png", new File(snapPath));
		File CP_file = new File(snapPath);
		String encodstring = encodeFileToBase64Binary(CP_file);
		String image =logger.addScreenCapture(encodstring);
		
		switch (status.toLowerCase()) {
		case "info":
			logger.log(LogStatus.INFO, value, image);
			break;
		case "pass":
			logger.log(LogStatus.PASS, value, image);
			break;
		case "fail":
			logger.log(LogStatus.FAIL, value, image);
			break;
		case "skip":
			logger.log(LogStatus.SKIP, value, image);
			break;
		case "error":
			logger.log(LogStatus.ERROR, value, image);
			break;

		default:
			break;
		}

		
		}	
	
	 public static String encodeFileToBase64Binary(File file){
         String encodedfile = null;
         try {
             FileInputStream fileInputStreamReader = new FileInputStream(file);
             byte[] bytes = new byte[(int)file.length()];
             fileInputStreamReader.read(bytes);
             encodedfile = Base64.getEncoder().encodeToString(bytes);
             //.encodeBase64(bytes).toString();
         } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();       
     }
		return "data:image/png;base64,"+encodedfile;}

}
