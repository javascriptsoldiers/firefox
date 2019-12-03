package automationBed_Google.utility.base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Level;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.internal.Locatable; 
import org.sikuli.script.Pattern;
import org.testng.Assert;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.constants.Constants;
import automationBed_Google.utility.excelManager.ExcelUtility;
import automationBed_Google.utility.webDriverManager.WdmConfig;
import ch.qos.logback.classic.pattern.Util;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class BaseUtility {

	public WebDriver webDriver;
	public AndroidDriver<AndroidElement> mDriver;
	public JavascriptExecutor JSdriver;
	public OCR ocr = new OCR();
	public String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	public DesiredCapabilities cap=null;
	//	public static String chromeexe = "D:\\Softwares\\chromedriver_win32\\chromedriver.exe";

	/*
	 * setting up web app URL
	 * 
	 */

	public void setUrl(String url) {
		Utils.addLog.traceEntry();
		try {
			Constant.URL.setConstant(url);
			AdvanceReporting.addLogs("info", "url has been set : " + url);
		} catch (Exception e) {
			Utils.addLog.error("Exception while setting up url",e);
			AdvanceReporting.addLogs("error", "error in setting up url" + e.getMessage());
		}
		Utils.addLog.traceExit();
	}

	/*
	 * layer for Reporting utilities
	 * 
	 */

	public void intializeReport(String suiteName, String browser) {
		Utils.addLog.traceEntry();
		try {
			AdvanceReporting.intializeReport(suiteName, browser);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Utils.addLog.info("Exceptiom while Initializing report for :",e.getMessage());
		}
		Utils.addLog.traceExit();
	}

	public void StartTest(String testCase) {
		Utils.addLog.traceEntry();
		Constant.TestCase.setConstant(testCase);
		AdvanceReporting.intializeLoger(testCase);
		Utils.addLog.traceExit();
	}

	public void EndTest() {
		Utils.addLog.traceEntry();
		if (webDriver != null) {
			Utils.addLog.debug("closing driver instance : {}",webDriver.getClass().getSimpleName());
			webDriver.quit();;
		}
		AdvanceReporting.endTest();
		Utils.addLog.traceExit();
	}

	public void finalizeReport() {
		Utils.addLog.traceEntry();
		try {
			AdvanceReporting.endReport();
			AdvanceReporting.getReport();
		} catch (Exception e) {
			Utils.addLog.debug("Exception while ending report : ",e.getMessage());
			e.printStackTrace();
		}
		Utils.addLog.traceExit();
	}

	// writing result to Excell
	public void writeResult(String worksheet, String status) {
		Utils.addLog.traceExit();
		new ExcelUtility().writeResult(SuiteBase.TestSuite, worksheet, "status", Constant.TestCase.getConstant(),
				status);
		Utils.addLog.traceExit();
	}

	/*************** Reporting utilities end here 
	 * @throws Exception *************/

	/*
	 * <h1>setupDriver</h1> this method will initiate driver and instantiate it based on user argument.
	 */
	public void setupDriver(String browser,String architecture,String version) throws Exception{
		DriverUtility.stpDriver( browser, architecture, version);
	}





	/*
	 * <h1>setupDriver</h1> this method will initiate driver and instantiate it based on property file.
	 */
	public void setupDriver(String browser) throws Exception {
		switch (browser) {
		case "chrome":
			DriverUtility.stpDriver(browser, WdmConfig.getString("wdm.architecture"), "2.46");
			break;
		case "IE":
			DriverUtility.stpDriver("internet", WdmConfig.getString("wdm.architecture"), "2.53.0");
			break;
		case "edge":
			DriverUtility.stpDriver(browser, WdmConfig.getString("wdm.architecture"), "3.3.0");
			break;
		case "gecko":
			System.out.println("Version");
			DriverUtility.stpDriver(browser, WdmConfig.getString("wdm.architecture"), "v0.26.0");
			/*
			 * System.out.println("**********************");
			 * System.setProperty("webdriver.gecko.driver","D:\\Downloads\\geckodriver.exe")
			 * ; File pathBinary = new
			 * File("C:\\Users\\kp00557866\\Downloads\\Firefox_Installer.exe");
			 * FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
			 * DesiredCapabilities desired = DesiredCapabilities.firefox(); FirefoxOptions
			 * options = new FirefoxOptions();
			 * desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS,
			 * options.setBinary(firefoxBinary)); WebDriver driver = new
			 * FirefoxDriver(options); driver.get("https://voice.google.com");
			 */
			break;
		default:
			System.out.println("default");
			DriverUtility.stpDriver(WdmConfig.getString("wdm.browser"), WdmConfig.getString("wdm.architecture"), WdmConfig.getString("wdm.version"));
			break;
		}
	}

	public void setupMDriver(int Bellevue, String SM_DUT, String packageName, String activityName) throws Exception {

		boolean noReset= false;
		String udid= null;

		try {
			noReset =true; 
			udid = SM_DUT;
		} catch (Exception e) {
			e.printStackTrace();
		}

		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "DeviceUnderTest");
		cap.setCapability("appPackage", packageName);
		cap.setCapability("appActivity", activityName);
		cap.setCapability("platformName", "Android");
		cap.setCapability("noReset", noReset);
		cap.setCapability("autoGrantPermissions", false);
		cap.setCapability("udid", udid);
		cap.setCapability("newCommandTimeout", 60 * 10);
		if(Bellevue == 1) {
			mDriver = new AndroidDriver<AndroidElement>(new URL("https://us-pnw.headspin.io:7012/v0/890c82c7ba1f46ca99b07c867541655b/wd/hub"), cap);}
		else if(Bellevue == 3) {
			mDriver = new AndroidDriver<AndroidElement>(new URL("https://us-pnw.headspin.io:7015/v0/890c82c7ba1f46ca99b07c867541655b/wd/hub"), cap);}
	}

	public void getDriverInstance() throws Exception {
		//webDriver=DriverUtility.getDriverInstance();
		 System.out.println("**********************");
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\RS00557859\\FIREFOX\\GoogleVoiceWeb\\src\\test\\resources\\drivers\\geckodriver\\win32\\0.26.0\\geckodriver.exe");
		 webDriver = new FirefoxDriver();
		System.out.println("LAUNCHeddddd"+webDriver);
	}	


	/*
	 * public void initiateNgWebDriver() throws Exception{ if(driver!=null)
	 * ngDriver = new NgWebDriver((JavascriptExecutor)driver); else throw new
	 * Exception("Web Driver is not initialized, please initiate web driver first."
	 * ); }
	 */

	public void openUrl() {
		Utils.addLog.traceEntry();
		webDriver.manage().window().maximize();
		Utils.addLog.info("setting implicit wait");
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Utils.addLog.info("setting Script timeout");
		webDriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		Utils.addLog.info("Opening URL : {}",Constant.URL.getConstant());
		webDriver.get(Constant.URL.getConstant());
		AdvanceReporting.addLogs("info", "Web application launched successfully");
		Utils.addLog.traceExit();
	}


	public String GetValue(String key)throws Exception{
		String configpropertiespath = (new StringBuilder(System.getProperty("user.dir")).append(File.separator).append("src").append(File.separator).append("main").append(File.separator).append("resources")).append(File.separator).toString();
		String configProperties = String.format("%sconfig.properties", configpropertiespath);
		FileReader reader=new FileReader(configProperties);
		Properties p=new Properties();  
		p.load(reader);
		return p.getProperty(key);}


	public void launchWebApplication() throws Exception {
		
		 Utils.uBase.getDriverInstance();
		 String url = GetValue("APP_URL");
		 Utils.uBase.webDriver.manage().window().maximize();
		 Utils.uBase.setUrl(url);
		 Utils.uBase.openUrl();
		
		
	}

	/**
	 * <h1>takeScreenshot!</h1> This method will capture a screenshot appending
	 * timestamp to it
	 * 
	 * @throws Exception
	 */
	public String takeScreenshot(String screenshotName) throws Exception {
		Utils.addLog.traceEntry();
		String snapPath = "";
		try {
			Utils.addLog.debug("Taking snapShot");
			refreshTimestamp();
			snapPath = Constant.ReportPath.getConstant() +Constant.SuiteName.getConstant()+"\\"+Constant.TestCase.getConstant()+"\\"+ screenshotName +"_"+ timeStamp + ".png";
			Utils.addLog.debug("Taking snapShot at : {}",snapPath);
			if(webDriver!=null) {
				File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(snapPath));
			}else {
				File scrFile = ((TakesScreenshot) mDriver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(snapPath));
			}

			Utils.addLog.debug("SnapShot saved at : {}",snapPath);

		} catch (Exception e) {
			AdvanceReporting.addLogs("error", e.getMessage());
			Utils.addLog.catching(Level.DEBUG, e);
		}
		return snapPath;
	}


	/**
	 * <h1>takeScreenshot!</h1> This method will capture a screenshot appending
	 * timestamp to it using Ashot Api
	 */
	public String takeScreenShot_Ashot(String screenshotName) throws IOException {
		Utils.addLog.traceEntry();
		String snapPath = "";
		//        Screenshot screenshot = new AShot().takeScreenshot(driver);
		Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(webDriver);
		refreshTimestamp();
		snapPath=Constant.ReportPath.getConstant() +Constant.SuiteName.getConstant()+"\\"+Constant.TestCase.getConstant()+"\\"+ screenshotName +"_"+ timeStamp+ ".png";
		ImageIO.write(screenshot.getImage(), "PNG",new File(snapPath));
		Utils.addLog.debug("Screenshot captured at : {}",snapPath);
		//        String image =logger.addScreenCapture(snapPath);
		//        logger.log(LogStatus.PASS, "fullScreen", image);
		//        Utils.addLog.traceExit();
		return snapPath;
	}

	//    public List<WebElement> getlistofelements(WebElement sections) throws IOException {
	//    	Utils.addLog.traceEntry();
	//    	
	//    	List<WebElement> allElements = Utils.uBase.driver.findElements(By.xpath(sections));
	//        
	//    	
	//       // Utils.addLog.debug("Screenshot captured at : {}",snapPath);
	////        String image =logger.addScreenCapture(snapPath);
	////        logger.log(LogStatus.PASS, "fullScreen", image);
	////        Utils.addLog.traceExit();
	//        return allElements;
	//        
	//        
	//    }

	//    public List<WebElement> getSelects(String sections) {
	//    	List<WebElement> selects = Utils.uBase.driver.findElements(By.xpath(sections));
	//        return selects;
	//      }
	////   
	//    



	//List<WebElement> allElements =Utils.uBase.driver.findElements(By.xpath("//*[contains(@class,'style-scope ytd-guide-renderer') and @id='sections']"));
	void takeWebelementScreenshot_Ashot(String outputFilePath, WebElement element) throws IOException {
		Utils.addLog.traceEntry();
		Screenshot screenshot = new AShot().takeScreenshot(webDriver, element);
		refreshTimestamp();
		outputFilePath=Constant.ReportPath.getConstant() +Constant.SuiteName.getConstant()+"\\"+Constant.TestCase.getConstant()+"\\"+ outputFilePath+ timeStamp+ ".png";
		ImageIO.write(screenshot.getImage(), "PNG",
				new File( outputFilePath));
		Utils.addLog.debug("Screenshot of {} captured at : {}",element.getAttribute("name"),outputFilePath);
		Utils.addLog.traceExit();
	}

	/**
	 * <h1>takeScreenshotOfWebelement!</h1> This method will capture a
	 * screenshot of desired webelement
	 */
	public String takeScreenshotOfWebelement(WebElement element, String outputFilePath) throws Exception {
		Utils.addLog.traceEntry();
		Thread.sleep(1000);
		File v = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		BufferedImage bi = ImageIO.read(v);
		org.openqa.selenium.Point p = element.getLocation();
		int n = element.getSize().getWidth();
		int m = element.getSize().getHeight();
		BufferedImage d = bi.getSubimage(p.getX(), p.getY(), n, m);
		ImageIO.write(d, "png", v);
		refreshTimestamp();
		outputFilePath=Constant.ReportPath.getConstant() +Constant.TestCase.getConstant()+"\\"+ outputFilePath+ timeStamp+ ".png";
		FileUtils.copyFile(v, new File(outputFilePath));
		Utils.addLog.debug("Screenshot of {} captured at : {}",element.getAttribute("name"),outputFilePath);
		Utils.addLog.traceExit();
		return outputFilePath;
	}
	public boolean imageCompare(String patternImage)
	{
		boolean result = false;
		try{//SoftAssert soft = new SoftAssert();
			System.out.println("Path in utill::"+patternImage);
			result = ocr.imageCompare(new Pattern((new File("")).getAbsolutePath() + Constants.IMAGES_BASE_FOLDER_NAME + patternImage +".png"));
			System.out.println("testutil imageCompare() "+ result);
			//soft.assertEquals(true, result);
			//soft.assertAll();
		}
		catch(Exception e){
			AdvanceReporting.addLogs("fail","Image not found");
			AdvanceReporting.addLogs("fail", e.getMessage());
		}
		return result;
	}
	/**
	 * <h1>switchToNewWindow!</h1> This method will helps us to switch to a New
	 * window
	 */
	public void switchToNewWindow() {
		Utils.addLog.traceEntry();
		Set<String> s = webDriver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		String w1 = itr.next();
		String w2 = itr.next();
		Utils.addLog.debug("Switching to new window : {} from window : {}",w2,w1);
		webDriver.switchTo().window(w2);
		Utils.addLog.traceExit();
	}

	public void turnOffImplicitWaits() {
		Utils.addLog.traceEntry();
		webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Utils.addLog.debug("implicit wait is turned off");
		Utils.addLog.traceExit();
	}

	/**
	 * <h1>switchToOldWindow!</h1> This method will helps us to switch to a Old
	 * window
	 */
	public void switchToOldWindow() {
		Utils.addLog.traceEntry();
		Set<String> s = webDriver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		String w1 = itr.next();
		String w2 = itr.next();
		Utils.addLog.debug("Switching to old window : {} from window : {}",w1,w2);
		webDriver.switchTo().window(w1);
		Utils.addLog.traceExit();
	}

	public void switchWindowByTitle(String title) {
		Utils.addLog.traceEntry();
		//    	String currentWindow = driver.getWindowHandle();
		Set<String> availableWindows = webDriver.getWindowHandles();
		if (!availableWindows.isEmpty()) {
			for (String windowId : availableWindows) {
				webDriver.switchTo().window(windowId).getTitle().equals(title);
				Utils.addLog.traceExit();
			}}}



	/**
	 * <h1>switchToDefaultContent!</h1> This method will helps us to switch to a
	 * default content
	 */
	public void switchToDefaultContent() {
		Utils.addLog.traceEntry();
		Utils.addLog.debug("Switching to Default content.");
		webDriver.switchTo().defaultContent();
		Utils.addLog.traceExit();
	}

	/**
	 * <h1>switchToFrame_byName!</h1> This method will helps us to switch to a
	 * Frame. Here you need to pass name of the frame
	 */
	public void switchToFrame_byName(String frameName) {
		Utils.addLog.traceEntry();
		Utils.addLog.debug("Switching to frame with name : {}",frameName);
		webDriver.switchTo().frame(frameName);
		Utils.addLog.traceExit();
	}

	/**
	 * <h1>switchToFrame_byIndex!</h1> This method will helps us to switch to a
	 * Frame. Here you need to pass number of the frame
	 */
	public void switchToFrame_byIndex(int frameValue) {
		Utils.addLog.traceEntry();
		Utils.addLog.debug("Switching to frame with index : {}",frameValue);
		webDriver.switchTo().frame(frameValue);
		Utils.addLog.traceExit();
	}

	public void switchToFrame_byWebElement(WebElement element) throws Exception {
		Utils.addLog.traceEntry();
		try {
			Utils.addLog.debug("Switching to frame with name : {}",element.getAttribute("name"));
			webDriver.switchTo().frame(element);
		} catch (Exception e) {
			Utils.addLog.catching(e);
			throw e;
		}
		Utils.addLog.traceExit();
	}

	public String getTestCaseName(String sTestCase) throws Exception {
		Utils.addLog.traceEntry();
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return Utils.addLog.traceExit(value);
		} catch (Exception e) {
			Utils.addLog.catching(e);
			throw e;
		}

	}

	public void refreshTimestamp() {
		Utils.addLog.traceEntry();
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		Utils.addLog.traceExit();
	}

	public void waitForElementToBeClickable(WebElement element) {
		Utils.addLog.traceEntry();
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Utils.addLog.traceExit();
	}

	public void waitForElement(WebElement element) {
		Utils.addLog.traceEntry();
		WebDriverWait wait = new WebDriverWait(webDriver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		Utils.addLog.traceExit();
	}
	/*public void waitUntilElementDisappear(WebElement element) {
		Utils.addLog.traceEntry();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		Utils.addLog.traceExit();
	}*/

	public void addImplicitWait(int i) {
		Utils.addLog.traceEntry();
		webDriver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
		Utils.addLog.traceExit();
	}

	public void setWindowSize(int Dimension1, int dimension2) {
		Utils.addLog.traceEntry();
		webDriver.manage().window().setSize(new Dimension(Dimension1, dimension2));
		Utils.addLog.traceExit();
	}

	public void pressKeyDown(WebElement element) {
		Utils.addLog.traceEntry();
		element.sendKeys(Keys.DOWN);
		Utils.addLog.traceExit();
	}

	public void pressKeyEnter(WebElement element) {
		Utils.addLog.traceEntry();
		element.sendKeys(Keys.ENTER);
		Utils.addLog.traceExit();
	}

	public void pressKeyUp(WebElement element) {
		Utils.addLog.traceEntry();
		element.sendKeys(Keys.UP);
		Utils.addLog.traceExit();
	}

	public void moveToTab(WebElement element) {
		Utils.addLog.traceEntry();
		element.sendKeys(Keys.chord(Keys.ALT, Keys.TAB));
		Utils.addLog.traceExit();
	}
	public void pressTab(WebElement element) {
		Utils.addLog.traceEntry();
		element.sendKeys(Keys.chord(Keys.TAB));
		Utils.addLog.traceExit();
	}


	/* public void clickWebelementwithRobot(WebElement element) throws AWTException, InterruptedException{

    	Robot robot = new Robot();
    	Point coordinate= element.getLocation();
    	robot.mouseMove(coordinate.getX(), coordinate.getY());
    	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }*/

	public boolean clickWebelement(WebElement element) throws Exception {
		Utils.addLog.traceEntry();
		try {
			boolean elementIsClickable = element.isEnabled();
			if (elementIsClickable) {
				String name=element.getAttribute("name");
				element.click();
				Utils.addLog.debug("{} : is clicked",name);
				return true;
			}
			else
				return false;
		} catch (StaleElementReferenceException e) {
			Utils.addLog.catching(e);
			throw e;
		} catch (Exception e) {
			Utils.addLog.catching(e);
			throw e;
		}

	}

	public boolean clickAndroidelement(AndroidElement element) throws Exception {
		Utils.addLog.traceEntry();
		try {
			boolean elementIsClickable = element.isEnabled();
			if (elementIsClickable) {
				String name=element.getAttribute("name");
				element.click();
				Utils.addLog.debug("{} : is clicked",name);
				return true;
			}
			else
				return false;
		} catch (StaleElementReferenceException e) {
			Utils.addLog.catching(e);
			throw e;
		} catch (Exception e) {
			Utils.addLog.catching(e);
			throw e;
		}
	}


	public void clickMultipleElements(WebElement someElement, WebElement someOtherElement) {
		Utils.addLog.traceEntry();
		Actions builder = new Actions(webDriver);
		builder.keyDown(Keys.CONTROL).click(someElement).click(someOtherElement).keyUp(Keys.CONTROL).build().perform();
		Utils.addLog.traceExit();
	}

	public void dragAndDrop(WebElement fromWebElement, WebElement toWebElement) {
		Utils.addLog.traceEntry();
		Actions builder = new Actions(webDriver);
		builder.dragAndDrop(fromWebElement, toWebElement);
		Utils.addLog.traceExit();
	}

	public void dragAndDrop_Method2(WebElement fromWebElement, WebElement toWebElement) {
		Utils.addLog.traceEntry();
		Actions builder = new Actions(webDriver);
		Action dragAndDrop = builder.clickAndHold(fromWebElement).moveToElement(toWebElement).release(toWebElement)
				.build();
		dragAndDrop.perform();
		Utils.addLog.traceExit();
	}

	public void dragAndDrop_Method3(WebElement fromWebElement, WebElement toWebElement) throws InterruptedException {
		Utils.addLog.traceEntry();
		Actions builder = new Actions(webDriver);
		builder.clickAndHold(fromWebElement).moveToElement(toWebElement).perform();
		Thread.sleep(2000);
		builder.release(toWebElement).build().perform();
		Utils.addLog.traceExit();
	}

	public void focusWebelement(WebElement element) throws InterruptedException {
		Utils.addLog.traceEntry();
		((JavascriptExecutor)webDriver).executeScript("arguments[0].focus()", element);
		Utils.addLog.debug("Scrolled down the current frame by 250 coordinates");
		Utils.addLog.traceExit();
	}

	public void hoverWebelement(WebElement HovertoWebElement) throws InterruptedException {
		Utils.addLog.traceEntry();
		Actions builder = new Actions(webDriver);
		builder.moveToElement(HovertoWebElement).perform();
		Thread.sleep(2000);
		Utils.addLog.traceExit();
	}

	public void executeJScript(String script){
		Utils.addLog.traceEntry();
		try {
			((JavascriptExecutor)webDriver).executeScript(script);
		} catch (Exception e) {
			Utils.addLog.catching(e);
		}
		Utils.addLog.traceExit();
	}

	public void clickWebelementWithAction(WebElement element) throws InterruptedException {
		Utils.addLog.traceEntry();
		Actions builder = new Actions(webDriver);
		builder.click(element).perform();
		Thread.sleep(2000);
		Utils.addLog.traceExit();
	}

	public void doubleClickWebelement(WebElement doubleclickonWebElement) throws InterruptedException {
		Utils.addLog.traceEntry();
		Actions builder = new Actions(webDriver);
		builder.doubleClick(doubleclickonWebElement).perform();
		Thread.sleep(2000);
		Utils.addLog.traceExit();    }

	public void selectElementByName(WebElement element, String Name) {
		Utils.addLog.traceEntry();
		Select selectitem = new Select(element);
		selectitem.selectByVisibleText(Name);
		Utils.addLog.traceExit();
	}

	public void selectElementByIndex(WebElement element, int index) {
		Utils.addLog.traceEntry();
		Select selectitem = new Select(element);
		selectitem.selectByIndex(index);
		Utils.addLog.traceExit();
	}

	public void selectElementByValue(WebElement element, String value) {
		Utils.addLog.traceEntry();
		Select selectitem = new Select(element);
		selectitem.selectByValue(value);
		Utils.addLog.traceExit();
	}

	public void verifyExpectedAndActualOptionsInDropdown(WebElement element, List<String> listOfOptions) {
		Utils.addLog.traceEntry();
		Select ele = new Select(element);
		// need to give list of options like below. You can add values from
		// excel or csv
		/*
		 * List<String> ds = new ArrayList<String>(); ds.add("Asia");
		 * ds.add("Europe"); ds.add("Africa");
		 */

		List<String> expectedOptions = listOfOptions;
		List<String> actualOptions = new ArrayList<String>();
		for (WebElement option : ele.getOptions()) {
			System.out.println("Dropdown options are: " + option.getText());
			actualOptions.add(option.getText());

		}
		Utils.addLog.debug("Numbers of options present in the dropdown: " + actualOptions.size());

		Assert.assertEquals(expectedOptions.toArray(), actualOptions.toArray());
		Utils.addLog.traceExit();
	}

	public void deselectElementByName(WebElement element, String Name) {
		Utils.addLog.traceEntry();
		Select selectitem = new Select(element);
		selectitem.deselectByVisibleText(Name);
		Utils.addLog.traceExit();
	}

	public void deselectElementByValue(WebElement element, String value) {
		Utils.addLog.traceEntry();
		Select selectitem = new Select(element);
		selectitem.deselectByValue(value);
		Utils.addLog.traceExit();
	}

	public void deselectElementByIndex(WebElement element, int index) {
		Utils.addLog.traceEntry();
		Select selectitem = new Select(element);
		selectitem.deselectByIndex(index);
		Utils.addLog.traceExit();
	}

	public void verifyDropdownHaveNoMultipleSelection(WebElement element, String Name) {
		Utils.addLog.traceEntry();
		Select ss = new Select(element);
		Assert.assertFalse(ss.isMultiple());
		Utils.addLog.traceExit();
	}

	public void verifyDropdownHaveMultipleSelection(WebElement element, String Name) {
		Utils.addLog.traceEntry();
		Select ss = new Select(element);
		Assert.assertTrue(ss.isMultiple());
		Utils.addLog.traceExit();
	}

	public void verifyOptionsInDropdownInAphabeticalOrder(WebElement element) {
		Utils.addLog.traceEntry();
		Select ele = new Select(element);
		List<String> expectedOptions = new ArrayList<String>();
		List<String> actualOptions = new ArrayList<String>();

		for (WebElement option : ele.getOptions()) {
			System.out.println("Dropdown options are: " + option.getText());
			actualOptions.add(option.getText());
			expectedOptions.add(option.getText());
		}

		Collections.sort(actualOptions);
		Utils.addLog.debug("Numbers of options present in the dropdown: " + actualOptions.size());
		Assert.assertEquals(expectedOptions.toArray(), actualOptions.toArray());
		Utils.addLog.traceExit();
	}

	public void verifyOptionsSizeOfDropdown(WebElement element, int numberOfOptions) {
		Utils.addLog.traceEntry();
		Select ssd = new Select(element);
		Assert.assertEquals(numberOfOptions, ssd.getOptions().size());
		Utils.addLog.traceExit();
	}

	public void clickCheckboxFromList(String xpathOfElement, String valueToSelect) {
		Utils.addLog.traceEntry();
		List<WebElement> lst = webDriver.findElements(By.xpath(xpathOfElement));
		for (int i = 0; i < lst.size(); i++) {
			List<WebElement> dr = lst.get(i).findElements(By.tagName("label"));
			for (WebElement f : dr) {
				System.out.println("value in the list : " + f.getText());
				if (valueToSelect.equals(f.getText())) {
					f.click();
					break;
				}
			}
		}
		Utils.addLog.traceExit();
	}


	/**
	 * basic String Operations
	 * */
	public static String upperCaseFirst(String value) {
		Utils.addLog.traceEntry();
		// Convert String to char array.
		char[] array = value.toCharArray();
		// Modify first element in array.
		array[0] = Character.toUpperCase(array[0]);
		// Return string.
		return Utils.addLog.traceExit(new String(array));
	}

	public String lowerCaseFirst(String value) {
		Utils.addLog.traceEntry();
		// Convert String to char array.
		char[] array = value.toCharArray();
		// Modify first element in array.
		array[0] = Character.toLowerCase(array[0]);
		// Return string.
		return Utils.addLog.traceExit(new String(array));
	}

	/**
	 * download files base on downloadlink and file name
	 * 
	 * @param downloadlink,
	 *            fileName
	 **/
	public void downloadFile(String href, String fileName) throws Exception {
		Utils.addLog.traceEntry();
		URL url = null;
		URLConnection con = null;
		int i;
		url = new URL(href);
		con = url.openConnection();
		File file = new File(".//OutputData//" + fileName);
		BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		while ((i = bis.read()) != -1) {
			bos.write(i);
		}
		bos.flush();
		bos.close();
		bis.close();
		Utils.addLog.traceExit();
	}

	public void downloadFileWithRobot(WebElement element) throws Exception {
		Utils.addLog.traceEntry();
		Robot robot = new Robot();
		clickWebelement(element);


		try {

			switchToNewWindow();
			WebElement downloadPageHead=(webDriver.findElement(By.xpath("//body/h1")));
			if(isElementPresent_webelement(downloadPageHead)){

				if ((downloadPageHead.getText()).contains("Exception")) {
					AdvanceReporting.addLogs("fail", webDriver.findElement(By.xpath("//body/h1")).getText(),
							Constant.TestCase.getConstant() + "//exceptionWhileDownload");
					throw new Exception("download failed");
				} 
			}



			Thread.sleep(10000);
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_ALT);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_ALT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Utils.addLog.traceExit();
	}

	/**
	 * download files base on element
	 * 
	 * @param element
	 **/
	/*
	 * public void downloadFile(WebElement downloadLink) { FileDownloader
	 * downloadTestFile = new FileDownloader(driver); try { String
	 * downloadedFileAbsoluteLocation =
	 * downloadTestFile.downloadFile(downloadLink); Assert.assertEquals(new
	 * File(downloadedFileAbsoluteLocation).exists(), true);
	 * Assert.assertEquals(downloadTestFile.getHTTPStatusOfLastDownloadAttempt()
	 * , 200); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */
	/**
	 * 
	 * upload file with the help of robot class
	 * 
	 * @param templatePath
	 * @throws Exception
	 */
	public void uploadFileWithRobot(WebElement element, StringSelection templatePath) throws Exception {
		Utils.addLog.traceEntry();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(templatePath, null);

		Robot robot = new Robot();

		clickWebelement(element);

		Thread.sleep(5000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		AdvanceReporting.addLogs("pass", "case uploaded", Constant.TestCase.getConstant() + "//fileUploaded");
		Thread.sleep(5000);
		Utils.addLog.traceExit();
	}

	public void navigate_back() {
		Utils.addLog.traceEntry();
		webDriver.navigate().back();
		Utils.addLog.debug("Navigating page Back..");
		Utils.addLog.traceExit();
	}

	public void navigate_forward() {
		Utils.addLog.traceEntry();
		webDriver.navigate().forward();
		Utils.addLog.debug("Navigating page Forward..");
		Utils.addLog.traceExit();
	}

	public void refresh() throws InterruptedException {
		Utils.addLog.traceEntry();
		webDriver.navigate().refresh();
		Thread.sleep(1500);
		if(Utils.uBase.imageCompare("ReloadBtn"))
		{Utils.uBase.clickByImage("ReloadBtn");}
		Utils.addLog.debug("Refreshing Page...");
		Utils.addLog.traceExit();
	}

	public String getToolTip(WebElement toolTipofWebElement) throws InterruptedException {
		Utils.addLog.traceEntry();
		String tooltip = toolTipofWebElement.getAttribute("title");
		System.out.println("Tool text : " + tooltip);
		Utils.addLog.debug("Refreshing Page...");
		return Utils.addLog.traceExit(tooltip);
	}

	public void datepicker_setDateAndTime(String TypeMonth, String TypeYear, String Date, String setHour,
			String setMinute, String setSeconds, String setHourShift) {
		Utils.addLog.traceEntry();
		List<WebElement> date = webDriver.findElements(By.xpath(".//*[@id='ui-datepicker-div']"));
		System.out.println("number of datepickers present : " + date.size());
		for (int i = 0; i < date.size(); i++) {
			System.out.println("element present in the Date picker box " + date.get(i).getText());
			Select month = new Select(date.get(i).findElement(
					By.xpath("//select[@class='form-control datetime-ui-datepicker-month input-width-20']")));
			month.selectByVisibleText(TypeMonth);
			Select year = new Select(date.get(i).findElement(
					By.xpath("//select[@class='form-control datetime-ui-datepicker-year input-width-20']")));
			year.selectByVisibleText(TypeYear);

			webDriver.findElement(By.linkText(Date)).click();

			date.get(i).findElement(By.xpath("//input[contains(@id,'hour')]")).clear();
			date.get(i).findElement(By.xpath("//input[contains(@id,'minute')]")).clear();
			date.get(i).findElement(By.xpath("//input[contains(@id,'second')]")).clear();

			date.get(i).findElement(By.xpath("//input[contains(@id,'hour')]")).sendKeys(setHour);
			date.get(i).findElement(By.xpath("//input[contains(@id,'minute')]")).sendKeys(setMinute);
			date.get(i).findElement(By.xpath("//input[contains(@id,'second')]")).sendKeys(setSeconds);
			Select hourshift = new Select(date.get(i).findElement(By.xpath("//select[@class='hourShift']")));
			hourshift.selectByVisibleText(setHourShift);
			webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[4]/button")).click();
		}
		Utils.addLog.traceExit();
	}

	public void clickAllLinksInPage(String NameOfScreenshot) throws Exception {
		Utils.addLog.traceEntry();
		List<WebElement> Links = webDriver.findElements(By.tagName("a"));
		Utils.addLog.debug("Total number of links  :" + Links.size());

		for (int p = 0; p < Links.size(); p++) {
			Utils.addLog.debug("Elements present the body :" + Links.get(p).getText());
			Links.get(p).click();
			Thread.sleep(3000);
			Utils.addLog.debug("Url of the page  " + p + ")" + webDriver.getCurrentUrl());
			takeScreenshot(NameOfScreenshot + "_" + p);
			navigate_back();
			Thread.sleep(2000);
		}
		Utils.addLog.traceEntry();
	}



	public void clearTextField(WebElement element) {
		Utils.addLog.traceEntry();
		element.clear();
		Utils.addLog.debug("Element {} is cleared",element.getAttribute("name"));
		Utils.addLog.traceExit();

	}

	public void highlightelement(WebElement element) throws InterruptedException {
		Utils.addLog.traceEntry();
		for (int i = 0; i < 3; i++) {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: solid red; border: 5px solid blue;");
			Thread.sleep(1000);
			//  js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");

		}
		Utils.addLog.debug(" Element : {} is highlighted",element.getAttribute("name"));
		Utils.addLog.traceExit();
	}

	public boolean checkAlert() {
		Utils.addLog.traceEntry();
		try {
			Alert a = webDriver.switchTo().alert();
			Utils.addLog.debug(a.getText());
			return Utils.addLog.traceExit(true);
		} catch (Exception e) {
			Utils.addLog.debug("no Alert");
			return Utils.addLog.traceExit(false);
		}
	}

	public boolean acceptAlert() {
		Utils.addLog.traceEntry();
		try {
			Alert a = webDriver.switchTo().alert();
			Utils.addLog.debug(a.getText());
			a.accept();
			return Utils.addLog.traceExit(true);

		} catch (Exception e) {
			Utils.addLog.debug("no Alert");
			return Utils.addLog.traceExit(false);
		}
	}

	public boolean dismissAlert() {
		Utils.addLog.traceEntry();
		try {
			Alert a = webDriver.switchTo().alert();
			Utils.addLog.debug(a.getText());
			a.dismiss();
			return Utils.addLog.traceExit(true);

		} catch (Exception e) {

			Utils.addLog.debug("no Alert");
			return Utils.addLog.traceExit(false);

		}
	}

	public void scrolltoElement(WebElement ScrolltoThisElement) {
		Utils.addLog.traceEntry();
		Coordinates coordinate = ((Locatable) ScrolltoThisElement).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		Utils.addLog.traceExit();
	}

	public void scrollUp(int scrollCount){
		Utils.addLog.traceEntry();
		for (int i = 0; i < scrollCount; i++) {
			((JavascriptExecutor)webDriver).executeScript("window.scrollBy(0,-250)", "");
			Utils.addLog.debug("Scrolled up the current frame by 250 coordinates");
		}
		Utils.addLog.traceExit();
	}

	public void scrollDown(int scrollCount){
		Utils.addLog.traceEntry();
		for (int i = 0; i < scrollCount; i++) {
			((JavascriptExecutor)webDriver).executeScript("window.scrollBy(0,250)", "");
			Utils.addLog.debug("Scrolled down the current frame by 250 coordinates");
		}
		Utils.addLog.traceExit();
	}

	public void scrollUpByElement(WebElement element, int scrollCount){
		Utils.addLog.traceEntry();
		for (int i = 0; i < scrollCount; i++) {
			((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollBy(0,-250)", element);
			Utils.addLog.debug("Scrolled down the current frame by 250 coordinates");
		}
		Utils.addLog.traceExit();
	}

	public void scrollDownByElement(WebElement element, int scrollCount){
		Utils.addLog.traceEntry();
		for (int i = 0; i < scrollCount; i++) {
			((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollBy(0,250)", element);
			Utils.addLog.debug("Scrolled down the current frame by 250 coordinates");
		}
		Utils.addLog.traceExit();
	}

	public void checkbox_Checking(WebElement checkbox) {
		Utils.addLog.traceEntry();
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			Utils.addLog.debug("Checkbox is already checked");
		} else {
			checkbox.click();
			Utils.addLog.debug("Checked the checkbox");
		}
		Utils.addLog.traceExit();
	}

	public void radiobutton_Select(WebElement Radio) {
		Utils.addLog.traceEntry();
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			Utils.addLog.debug("RadioButton is already checked");
		} else {
			Radio.click();
			Utils.addLog.debug("Selected the Radiobutton");
		}
		Utils.addLog.traceExit();
	}

	// Unchecking
	public void checkbox_Unchecking(WebElement checkbox) {
		Utils.addLog.traceEntry();
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			checkbox.click();
			Utils.addLog.debug("Checkbox is unchecked");
		} else {
			Utils.addLog.debug("Checkbox is already unchecked");
		}
		Utils.addLog.traceExit();
	}

	public void radioButton_Deselect(WebElement Radio) {
		Utils.addLog.traceEntry();
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			Radio.click();
			Utils.addLog.debug("Radio Button is deselected");
		} else {
			Utils.addLog.debug("Radio Button is already Deselected");
		}
		Utils.addLog.traceExit();
	}

	public void passThisStep(String reasonForPass) {
		Utils.addLog.traceEntry();
		Assert.assertTrue(true, reasonForPass);
		Utils.addLog.traceExit();
	}

	public void failThisStep(String reasonForFailing) {
		Utils.addLog.traceEntry();
		Assert.fail(reasonForFailing);
		Utils.addLog.traceExit();
	}

	public String generateRandomString(int length) {
		Utils.addLog.traceEntry();
		StringBuilder str = new StringBuilder(RandomStringUtils.randomAlphabetic(length));
		int idx = str.length() - 8;

		while (idx > 0) {
			str.insert(idx, " ");
			idx = idx - 8;
		}
		return Utils.addLog.traceExit(str.toString());

	}

	public String generateRandomPhoneNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String generateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public String generateRandomAlphaNumeric(int length) {
		StringBuilder str = new StringBuilder(RandomStringUtils.randomAlphanumeric(length));
		int idx = str.length() - 8;

		while (idx > 0) {
			str.insert(idx, " ");
			idx = idx - 8;
		}
		return str.toString();

	}

	public String generateRandomStringWithAllowedSplChars(int length, String allowdSplChrs) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + allowdSplChrs
				+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder str1 = new StringBuilder(RandomStringUtils.random(length, allowedChars));
		int idx = str1.length() - 8;

		while (idx > 0) {
			str1.insert(idx, " ");
			idx = idx - 8;
		}
		return str1.toString();
	}

	public String generateRandomEmail(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
		String email = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		email = temp.substring(0, temp.length() - 9) + "@"+generateRandomString(5)+"."+generateRandomString(3);
		return email;
	}

	public String generateRandomUrl(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "-.";
		String url = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		url = temp.substring(0, 3) + "." + temp.substring(4, temp.length() - 4) + "." + "com";
		return url;
	}
	public String getCurrentUrl() {
		String url = webDriver.getCurrentUrl();
		AdvanceReporting.addLogs("info", "Current url : " + url);
		return url;
	}

	public boolean isElementPresent_locator(By by) {
		Utils.addLog.traceEntry();
		try {
			webDriver.findElement(by);
			return Utils.addLog.traceExit(true);
		} catch (NoSuchElementException e) {
			return Utils.addLog.traceExit(false);
		}
	}

	public boolean isElementPresent_webelement(WebElement element) {
		Utils.addLog.traceEntry();
		try {
			element.isDisplayed();
			return Utils.addLog.traceExit(true);
		} catch (NoSuchElementException e) {
			return Utils.addLog.traceExit(false);
		}
	}

	public void verifyCSSvalue(WebElement element, String cssValueOf, String expectedCssValue) {
		Utils.addLog.traceEntry();
		try {
			element.isDisplayed();
			Utils.addLog.debug("CSS Value of " + cssValueOf + " is :" + element.getCssValue(cssValueOf));
			Assert.assertEquals(expectedCssValue, element.getCssValue(cssValueOf));
			Utils.addLog.traceExit();
		} catch (NoSuchElementException e) {
			Utils.addLog.catching(e);
			throw e;
		}
	}

	/**
	 * Verifying the flags in cookie such as httponly, issecure
	 * 
	 * @param Expectedcookie
	 */
	public void verifyFlagsOfCookie(String Expectedcookie) {
		Utils.addLog.traceEntry();
		try {
			Cookie saveMyCookie = webDriver.manage().getCookieNamed(Expectedcookie);
			if (saveMyCookie.isHttpOnly() && saveMyCookie.isSecure()) {
				Assert.assertTrue(true);
			} else {
				Utils.addLog.debug(saveMyCookie.getName() + " doesnt have flags IsHttpOnly & IsSecure");
				Assert.fail("doesnt have flags IsHttpOnly & IsSecure");
			}

		} catch (Exception e) {
			Utils.addLog.error("error", timeStamp + e.getMessage());
		}
		Utils.addLog.traceExit();
	}

	/**
	 * Adding a cookie with name, value, path
	 * 
	 * @param cookieName
	 * @param cookieValue
	 * @param Domain
	 * @param path
	 */
	public void addCookie(String cookieName, String cookieValue, String Domain, String path) {
		Utils.addLog.traceEntry();
		try {
			Cookie name = new Cookie(cookieName, cookieValue, Domain, path, new Date());
			webDriver.manage().addCookie(name);
			refresh();
			Utils.addLog.debug("Added Cookie {}.",cookieName);

		} catch (Exception e) {
			Utils.addLog.error("error", timeStamp + e.getMessage());
		}
		Utils.addLog.traceExit();
	}

	/**
	 * Delete all cookies present in the application
	 */
	public void deleteAllCookies() {
		Utils.addLog.traceEntry();
		webDriver.manage().deleteAllCookies();
		Utils.addLog.debug("All Cookies deleted.");
		Utils.addLog.traceExit();
	}

	/**
	 * getAllCookies, this will get you all the cookies present in the
	 * page/application
	 */
	public Set<Cookie> getAllCookies() {
		Utils.addLog.traceEntry();
		Set<Cookie> cookiesList = webDriver.manage().getCookies();
		for (Cookie getcookies : cookiesList) {
			Utils.addLog.debug(getcookies);
		}
		return  Utils.addLog.traceExit(cookiesList);
	}

	public void verifyPageSourceContains(String stringInPagesource) {
		Utils.addLog.traceEntry();
		String pageSource = webDriver.getPageSource();
		Assert.assertTrue(pageSource.contains(stringInPagesource));
		Utils.addLog.traceExit();
	}

	/**
	 * <h1>getPageLoadTime
	 * <h1>This method can be used to get page load time. This returns Long.
	 */
	public long getPageLoadTime() {
		Utils.addLog.traceEntry();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
		long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
		long loadtime = (loadEventEnd - navigationStart) / 1000;
		Utils.addLog.debug("Page Load Time is " + loadtime + " seconds.");
		return Utils.addLog.traceExit(loadtime);
	}

	public void waitForPageLoadByLoader(String loaderId) throws InterruptedException {
		Utils.addLog.traceEntry();
		try {

			ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					String display="";
					try {
						display=Utils.uBase.webDriver.findElement(By.id(loaderId)).getCssValue("display");
					} catch (Exception e) {
						display ="none";
					}
					return (display.equalsIgnoreCase("none")) ?  true : false;
				}
			};
			Utils.uBase.refreshTimestamp();
			Utils.addLog.debug("call started :" +Utils.uBase.timeStamp); 
			WebDriverWait wait = new WebDriverWait(Utils.uBase.webDriver, 200, 500); 
			wait.until(pendingHttpCallsCondition);
			Utils.uBase.refreshTimestamp();
			Utils.addLog.debug("call ended :" +Utils.uBase.timeStamp);
			Utils.addLog.traceExit();
		} catch (JavascriptException e) {
			Utils.addLog.catching(e);
		}

	}

	public void untilAngularFinishHttpCalls() throws InterruptedException {
		Utils.addLog.traceEntry();
		try {
			final String javaScriptToLoadAngular = "if((document.readyState)==='complete'){"
					+ "console.log('document loaded');" + "var injector = window.angular.element('body').injector();"
					+ "var $http = injector.get('$http');" + "return ($http.pendingRequests.length === 0)}"
					+ "else{return false;}";

			ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript(javaScriptToLoadAngular).equals(true);
				}
			};
			WebDriverWait wait = new WebDriverWait(webDriver, 200, 500); 
			refreshTimestamp();                                     
			String tempTimeStamp=timeStamp;
			wait.until(pendingHttpCallsCondition);
			refreshTimestamp();
			Utils.addLog.debug("waited for angular from :"+tempTimeStamp+" to : "+timeStamp);
			Utils.addLog.traceExit();
		} catch (JavascriptException e) {
			Utils.addLog.catching(e);
		}
	}

	/**
	 * In order to zoom out you need to pass an integer, to zoomout n number of
	 * times
	 */
	public void zoomOut(int toExtent) {
		Utils.addLog.traceEntry();
		for (int i = 0; i < toExtent; i++) {
			webDriver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		}
		Utils.addLog.traceExit();
	}

	/**
	 * In order to zoom In you need to pass an integer, to zoom In n number of
	 * times
	 */
	public void zoomIn(int toExtent) {
		Utils.addLog.traceEntry();
		for (int i = 0; i < toExtent; i++) {
			webDriver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
		}
		Utils.addLog.traceExit();
	}

	public void zoomToDefault() {
		Utils.addLog.traceEntry();
		webDriver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		Utils.addLog.traceExit();
	}

	/**
	 * <h1>verifyVideoUsingVideoElement
	 * <h1>This method can be used to verify a video present in the page with
	 * tag video.
	 * 
	 * @param element
	 * @param srcOfVideo
	 * @param durationOfVideo
	 */
	public void verifyVideoUsingVideoElement(WebElement element, String srcOfVideo, long durationOfVideo) {
		Utils.addLog.traceEntry();
		// Get the HTML5 Video Element
		JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
		String source = (String) jsExecutor.executeScript("return arguments[0].currentSrc;", element);
		long duration = (Long) jsExecutor.executeScript("return arguments[0].duration", element);

		Assert.assertEquals(source, srcOfVideo);
		Assert.assertEquals(duration, durationOfVideo);
		Utils.addLog.traceExit();
	}

	public int getRandomNumberBetween(int min, int max) {
		Utils.addLog.traceEntry();
		Random foo = new Random();
		int randomNumber = foo.nextInt(max - min) + min;
		if (randomNumber == min) {
			return Utils.addLog.traceExit(min + 1);
		} else {
			return Utils.addLog.traceExit(randomNumber);
		}

	}

	/**
	 * 
	 * RandomDataMethods.generateRandomDate("dd MMM yyyy", "18 Jul 2016", "20
	 * Sep 2017")
	 * 
	 * @param Format
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws java.text.ParseException
	 */
	public String generateRandomDate(String Format, String startDate, String endDate) throws java.text.ParseException {
		Utils.addLog.traceEntry();
		DateFormat formatter = new SimpleDateFormat(Format);
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatter.parse(startDate));
		Long value1 = cal.getTimeInMillis();

		cal.setTime(formatter.parse(endDate));
		Long value2 = cal.getTimeInMillis();

		long value3 = (long) (value1 + Math.random() * (value2 - value1));
		cal.setTimeInMillis(value3);
		return Utils.addLog.traceExit(formatter.format(cal.getTime()));
	}

	public int[] getX_Y_cordinates(WebElement element) {
		Utils.addLog.traceEntry();
		int[] xy = null;
		Point p = element.getLocation();
		Utils.addLog.debug("X Position: " + p.getX());
		Utils.addLog.debug("Y Position: " + p.getY());
		int x = p.getX();
		int y = p.getY();
		xy = new int[x * y];
		return Utils.addLog.traceExit(xy);

	}

	public int[] getWidth_HeightOfElement(WebElement element) {
		Utils.addLog.traceEntry();
		int[] xy = null;
		Dimension dimensions = element.getSize();
		Utils.addLog.debug("Width : " + dimensions.width);
		Utils.addLog.debug("Height : " + dimensions.height);
		int x = dimensions.getWidth();
		int y = dimensions.getHeight();
		xy = new int[x * y];
		return Utils.addLog.traceExit(xy);

	}

	/**
	 * encryption method
	 * 
	 * return encypted string
	 */

	public String encryptTxtTo(String txt,String key){
		Utils.addLog.traceEntry();
		String encodedTxt= EncryptUtils.xorMessage(txt, key);
		encodedTxt=EncryptUtils.base64encode(encodedTxt);

		return Utils.addLog.traceExit(encodedTxt);

	}

	/**
	 * decrypetion method
	 * 
	 * return decypted string
	 */
	public String decryptTxtTo(String txt,String key){
		Utils.addLog.traceEntry();
		String decodedTxt= EncryptUtils.base64encode(txt);
		decodedTxt=EncryptUtils.xorMessage(decodedTxt, key);
		return Utils.addLog.traceExit(decodedTxt);

	}



	/****
	 * generic methods for utilities
	 * 
	 * @throws Exception
	 *****/

	/**
	 * <h1>setText</h1>
	 * This method will set the text to specified webelement after clearing the text field.
	 * @throws Exception
	 * */
	public void setText(WebElement element, String text) throws Exception {
		Utils.addLog.traceEntry();
		try {
			clearTextField(element);
			element.sendKeys(text);
			Utils.addLog.debug(" Text : {} is set to element : {}.",text,getElementName(element));
		} catch (Exception e) {
			Utils.addLog.catching(e);
			throw e;
		}
		Utils.addLog.traceExit();
	}

	public void setTextAndroidelement(AndroidElement element, String text) throws Exception {
		Utils.addLog.traceEntry();
		try {
			clearTextField(element);
			element.sendKeys(text);
			Utils.addLog.debug(" Text : {} is set to element : {}.",text,getElementName(element));
		} catch (Exception e) {
			Utils.addLog.catching(e);
			throw e;
		}
		Utils.addLog.traceExit();
	}

	private String getElementName(WebElement element) {
		Utils.addLog.traceEntry();
		try {
			if(element.getAttribute("name")!= null)
			{        	
				String elementName = element.getAttribute("name");
				if(elementName.equals("")||elementName.equals(null)){
					return Utils.addLog.traceExit("no name found.");
				}
				else
				{
					return Utils.addLog.traceExit(elementName);
				}
			}
			return Utils.addLog.traceExit("no name found.");
		} catch (Exception e) {
			Utils.addLog.catching(e);
			throw e;
		}
	}

	public void setPassword(WebElement element, String text) throws Exception {
		Utils.addLog.traceEntry();
		try {
			element.sendKeys(text);
			Utils.addLog.debug(" password : {} is set to element : {}.",text,getElementName(element));
		} catch (Exception e) {
			Utils.addLog.catching(e);
			throw e;
		}
		Utils.addLog.traceExit();
	}

	/*****
	 * Keyword driven operation methods
	 * 
	 * @author YogendraPorwal
	 *****/

	public void keyWordSelect(String property, String propValue, String selectBy, String value) {
		WebElement temp = getElementByKey(property, propValue);
		switch (selectBy) {
		case "value":
			selectElementByValue(temp, value);
			break;
		case "index":
			selectElementByIndex(temp, Integer.parseInt(value));
			break;
		case "text":
			selectElementByName(temp, value);
			break;
		default:
			AdvanceReporting.addLogs("info", "not a valid selectBy param");

		}
	}

	public void keyWordSetText(String property, String propValue, String value) throws Exception {
		WebElement temp = getElementByKey(property, propValue);
		try {
			if (temp.isEnabled()) {
				clearTextField(temp);
				temp.sendKeys(value);
				//AdvanceReporting.addLogs("info", value + " is set to " + temp.getAttribute("name"));
			} else {
				//AdvanceReporting.addLogs("error", "element is disabled : " + temp.getAttribute("name"));
				throw new Exception("element disabled");
			}

		} catch (Exception e) {
			e.printStackTrace();
			// AdvanceReporting.addLogs("error", "unable to click " + temp.getAttribute("name"));
			throw e;
		}
	}

	private WebElement getElementByKey(String Key, String value) {

		switch (Key.toLowerCase()) {
		case "name":
			return webDriver.findElement(By.name(value));
		case "id":
			return webDriver.findElement(By.id(value));
		case "classname":
			return webDriver.findElement(By.className(value));
		case "cssselector":
			return webDriver.findElement(By.cssSelector(value));
		case "xpath":
			return webDriver.findElement(By.xpath(value));

		default:
			Utils.addLog.error("invalid Locator has been passed to method : getElementByKey");
			return null;
		}
	}

	public void KeywordOperationInvoker(String elementType, String eleProperty, String proValue, String value)
			throws Exception {

		switch (elementType.toLowerCase()) {
		case "select":
			keyWordSelect(eleProperty, proValue, "text", value);
			break;
		case "text":
			keyWordSetText(eleProperty, proValue, value);
			break;
		case "textarea":
			keyWordSetText(eleProperty, proValue, value);
			break;
		default:
			break;
		}

	}

	public boolean isElementEnabled(WebElement injuryBtn) {

		if(injuryBtn.isEnabled()){
			Utils.addLog.debug("element "+injuryBtn.getAttribute("name") +" is enabled");
			return true;
		}else{
			Utils.addLog.debug("element "+injuryBtn.getAttribute("name") +" is disabled");
			return false;
		}
	}


	public int convertTimeToMillis(String timeString) {
		String[] time = timeString.split ( ":" );
		int pos = time.length - 1;
		long res = 0;
		if( pos >=0 ){
			res = res + TimeUnit.SECONDS.toMillis( Long.parseLong( time[pos] ));
			pos --;
		}
		if( pos >=0 ){
			res = res + TimeUnit.MINUTES.toMillis( Long.parseLong( time[pos] ));
			pos --;
		}
		if( pos >=0 ){
			res = res + TimeUnit.HOURS.toMillis( Long.parseLong( time[pos] ));
			pos --;
		}
		return (int)res;
	}


	//Mobile Code
	public  AndroidDriver<AndroidElement> getDriver() throws MalformedURLException {

		String packageName= null;
		String activityName= null;
		boolean noReset= false;
		String udid= null;

		try {
			packageName = GetValue("APP_PACKAGE_NAME");
			activityName = GetValue("APP_ACTIVITY");
			noReset =true; 
			udid = GetValue("SM_DUT2");
		} catch (Exception e) {
			e.printStackTrace();
		}

		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "DeviceUnderTest");
		cap.setCapability("appPackage", packageName);
		cap.setCapability("appActivity", activityName);
		cap.setCapability("platformName", "Android");
		cap.setCapability("noReset", noReset);
		cap.setCapability("autoGrantPermissions", false);
		cap.setCapability("udid", udid);
		cap.setCapability("newCommandTimeout", 60 * 10);
		System.out.println("loaded caps");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://us-pnw.headspin.io:7012/v0/890c82c7ba1f46ca99b07c867541655b/wd/hub"), cap);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("returned driver");
		return driver;
	}

	public void clickByImage(String targetImgPath)
	{
		ocr.clickByImage(Constants.IMAGES_BASE_FOLDER_NAME + targetImgPath + ".png");
	}

	public void hoverOnImage(String targetImgPath)
	{
		ocr.hoverOnImage(Constants.IMAGES_BASE_FOLDER_NAME + targetImgPath + ".png");
	}

	public void checkPageReady()
	{
		try {
			if(!((JavascriptExecutor)Utils.uBase.webDriver).executeScript("return document.readyState").equals("complete"))
			{	
				Thread.sleep(2000);
			} }catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	public String takeMobileScreenshot(String screenshotName) throws Exception {
		Utils.addLog.traceEntry();
		String snapPath = "";
		try {
			Utils.addLog.debug("Taking snapShot");
			refreshTimestamp();
			snapPath = Constant.ReportPath.getConstant() +Constant.SuiteName.getConstant()+"\\"+Constant.TestCase.getConstant()+"\\"+ screenshotName +"_"+ timeStamp + ".png";
			Utils.addLog.debug("Taking snapShot at : {}",snapPath);
			if(mDriver!=null) {
				File scrFile = ((TakesScreenshot) mDriver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(snapPath));
			}
			Utils.addLog.debug("SnapShot saved at : {}",snapPath);

		} catch (Exception e) {
			AdvanceReporting.addLogs("error", e.getMessage());
			Utils.addLog.catching(Level.DEBUG, e);
		}

		return snapPath;
	}

	public void clickOnNotificationAllowBtn() throws Exception
	{
		try
		{
			Thread.sleep(2000);
			for(int i=0; i<=5; i++) {
				if(Utils.uBase.imageCompare("AllowButtonImg")) {
					Thread.sleep(1000);
					Utils.uBase.clickByImage("AllowButtonImg");
					Thread.sleep(1000);
					AdvanceReporting.addLogs("pass", "Click on allow button from notification alert");}}
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
	}

	public void switchWindows(String window) {
		Utils.addLog.traceEntry();
		String parentWindowHandle=webDriver.getWindowHandle();

		if (window.equalsIgnoreCase("child")) {

			for(String winHandle : webDriver.getWindowHandles()){

				if(winHandle.equals(parentWindowHandle)) {continue;}

				webDriver.switchTo().window(winHandle);
				Utils.addLog.debug("Switched to new window"); }
		}

		if (window.equalsIgnoreCase("parent")) {
			webDriver.switchTo().defaultContent();
			// .window(parentWindowHandle);
			Utils.addLog.debug("Switched to parent window");
		}
		/* AdvanceReporting.addLogs("pass","Latest voicemails are received"); */
		Utils.addLog.traceExit();
	}

	public void setAndroidText(AndroidElement element, String text) throws Exception {
		Utils.addLog.traceEntry();
		try {
			clearTextField(element);
			element.sendKeys(text);
			Utils.addLog.debug(" Text : {} is set to element : {}.",text,getElementName(element));
		} catch (Exception e) {
			Utils.addLog.catching(e);
			throw e;
		}
		Utils.addLog.traceExit();
	}

	public void switchWindowByPartialTitle(String title) {
		Utils.addLog.traceEntry();
		//    	String currentWindow = driver.getWindowHandle();
		Set<String> availableWindows = webDriver.getWindowHandles();
		if (!availableWindows.isEmpty()) {
			for (String windowId : availableWindows) {
				webDriver.switchTo().window(windowId).getTitle().contains(title);
				Utils.addLog.traceExit();
			}}}

	/**
	 * <h1>openNewTab!</h1> This method will open a new tab in the same browser
	 */
	public void openNewTab() {
		Utils.addLog.traceEntry();
		try {

			((JavascriptExecutor)Utils.uBase.webDriver).executeScript("window.open();");
			switchToNewWindow();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public boolean verifyImageExists(String targetImgPath)
	{
		return ocr.verifyifImageExistsOnScreen((Constants.IMAGES_BASE_FOLDER_NAME + targetImgPath + ".png"));
	}

	public boolean isElementDisabled(WebElement element) {
		if(element.getAttribute("aria-disabled").equalsIgnoreCase("true")){
			Utils.addLog.debug("Element is disabled");
			return true;
		}else{
			Utils.addLog.debug("Element is enabled");
			return false;
		}
	}
}
