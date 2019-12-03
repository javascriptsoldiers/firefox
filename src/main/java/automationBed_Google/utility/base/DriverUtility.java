package automationBed_Google.utility.base;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.lowagie.text.List;

import automationBed_Google.utility.webDriverManager.Architecture;
import automationBed_Google.utility.webDriverManager.ChromeDriverManager;
import automationBed_Google.utility.webDriverManager.EdgeDriverManager;
import automationBed_Google.utility.webDriverManager.FirefoxDriverManager;
import automationBed_Google.utility.webDriverManager.InternetExplorerDriverManager;
import automationBed_Google.utility.webDriverManager.OperaDriverManager;
import automationBed_Google.utility.webDriverManager.PhantomJsDriverManager;
import automationBed_Google.utility.webDriverManager.WdmConfig;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverUtility {
	
	private static WebDriver driver;
	private static String browser;
	private static String architecture;
	private static String version;
	
	public static void stpDriver(String browser,String architecture,String version) throws Exception {
		DriverUtility.browser =browser;
		DriverUtility.architecture=architecture;
		DriverUtility.version=version;
		Utils.addLog.traceEntry();
		Architecture arch=getArchitecture(architecture);
		
		Utils.addLog.info("setting {} Driver(Architecture= {}, Version={})",browser,arch, version);
	    switch (browser) {
	    	case "gecko":
	    		System.out.println("ëntered geko");	       
	        //    FirefoxDriverManager.getInstance().setup(arch, version);
	            System.out.println("e geko");	    
	            break;

	        case "chrome":
	        	System.out.println("ëntered1");	        	
	        	ChromeDriverManager.getInstance().setup(arch, version);
	            break;

	        case "opera":
	            OperaDriverManager.getInstance().setup(arch, version);
	            break;

	        case "internet":
	            InternetExplorerDriverManager.getInstance().setup(arch, version);
	            break;

	        case "edge":
	            EdgeDriverManager.getInstance().setup(arch, version);
	            break;

	        case "phantom":
	            PhantomJsDriverManager.getInstance().setup(arch, version);
	            break;

	        default:
	        	Utils.addLog.traceExit("Invalid browser entry in webdrivermanager.properties");
	            throw new Exception("not a valid browser entry");
	        }
	        Utils.addLog.traceExit();
	    }
	 
	 public static Architecture getArchitecture(String architecture) {
	    	Utils.addLog.traceEntry();
	        if (architecture.equalsIgnoreCase("32")) {
	        	return Utils.addLog.traceExit(Architecture.x32); 
	        } else {
	            return Utils.addLog.traceExit(Architecture.x64); 
	        }
	        
	    }

	    public static Capabilities getCapabilities() {
	    	Utils.addLog.traceEntry("1");
	        DesiredCapabilities capInstance = new DesiredCapabilities();

	        if (WdmConfig.getBoolean("wdm.capabilities.ACCEPT_SSL_CERTS")){
	        	Utils.addLog.info("Adding ACCEPT_SSL_CERTS capapility to driver");
	            capInstance.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	        	System.out.println("getCapabilities1");
	        }
	        if (WdmConfig.getBoolean("wdm.capabilities.javascriptEnabled")){
	        	Utils.addLog.info("Adding javascriptEnabled capapility to driver");
	            capInstance.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
	        	System.out.println("getCapabilities2");
	        }
	        if (browser.equalsIgnoreCase("chrome")){
	        	ChromeOptions myChromeOptions = new ChromeOptions();		
		        ArrayList<String> options=new ArrayList<String>();
		        options.add("disable-sync");
		        myChromeOptions.setExperimentalOption("excludeSwitches",options);		 
	        	myChromeOptions.addArguments("-enable-sync");
	        	capInstance.setCapability(ChromeOptions.CAPABILITY, myChromeOptions);
	        	Utils.addLog.traceEntry("2");
	        }
	        
	     
	        
        	/*IE specific capabilities*/
	        if(browser.equalsIgnoreCase("internet")){
	            if(WdmConfig.getBoolean("wdm.capabilities.session")){
	            	Utils.addLog.info("Adding IE_ENSURE_CLEAN_SESSION capapility to IE driver");
	                capInstance.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
	            }
	            if(WdmConfig.getBoolean("wdm.capabilities.protectedMode")){
	            	Utils.addLog.info("Adding INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS capapility to IE driver");
	                capInstance.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	            }
	        }
	    	System.out.println("end of capabilities"+capInstance);
	       return Utils.addLog.traceExit(capInstance);
	   
	    }
	    
	    public static WebDriver getDriverInstance() throws Exception {
	    	System.out.println("LAUNCH"+driver);
	    	Utils.addLog.traceEntry();
	    	Utils.addLog.info("Instantaiting : {}",browser);
	        switch (browser) {

	        case "gecko":
	        	System.out.println("gecko driver switch");
	           // driver = new FirefoxDriver(getCapabilities());
	        	//System.out.println("LAUNCH"+driver);
	        System.out.println("**********************");
			 System.setProperty("webdriver.gecko.driver","D:\\Download\\geckodriver.exe");
			  driver = new FirefoxDriver();
	            break;

	        case "chrome":
	        	Utils.addLog.info("Entered into switch");
	            driver = new ChromeDriver(getCapabilities());
	            break;

	        case "opera":
	            driver = new OperaDriver(getCapabilities());
	            break;

	        case "internet":
	            driver = new InternetExplorerDriver(getCapabilities());
	            break;

	        case "edge":
	            driver = new EdgeDriver(getCapabilities());
	            break;
	        case "mobile":
	            driver = new AndroidDriver<AndroidElement>(null);
	            break;

	        default:
	        	Utils.addLog.traceExit("Invalid browser entry in webdrivermanager.properties");
	            throw new Exception("not a valid browser entry");
	        }
	    	System.out.println("LAUNCH"+driver);
	        return driver;
	    }
	  
}
