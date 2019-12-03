package automationBed_Google.utility.base;


/*
The MIT License (MIT)
        Copyright (c) 2016 Szymon Kazmierczak
        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:
        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.
        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE.
 */

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;

//import com.android.dx.util.FileUtils;

import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import automationBed_Google.utility.ReportManager.AdvanceReporting;

import javax.imageio.ImageIO;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OCR {
	public WebDriver driver;
	public Screen screen= new Screen();
	private final double DEFAULT_MIN_SIMILARITY = 0.8;


	public OCR() {

		Settings.MinSimilarity = DEFAULT_MIN_SIMILARITY;
		System.out.println(Settings.MinSimilarity);
	}


	public BufferedImage takeScreenshot() {
		Debug.setDebugLevel(3);
		//File scrFile = ((TakesScreenshot) Utils.uBase.driver).getScreenshotAs(OutputType.FILE);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println(scrFile.getAbsolutePath());
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(scrFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bufferedImage;
	}

	public BufferedImage takeCroppedScreenshot(WebElement ele) {
		Debug.setDebugLevel(3);
		String CroppedImageLocation = (new StringBuilder(System.getProperty("user.dir")).append(File.separator).append("src").append(File.separator).append("main").append(File.separator).append("resources").append(File.separator).append("output").append(File.separator)).toString();
		SimpleDateFormat df = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
		Calendar calobj = Calendar.getInstance();
		String FileName = String.format("%s9887bc374655364831_Element_screenshot_%s.png", CroppedImageLocation,df.format(calobj.getTime()));
		System.out.println("File Name is"+FileName);
		File CroppedImage = new File(FileName);

		BufferedImage bufferedImage = null;
		File screenshot = ((TakesScreenshot) Utils.uBase.webDriver).getScreenshotAs(OutputType.FILE);
		//		File screenshot=Utils.uBase.takeScreenshotOfWebelement(ele,"snapshotName");

		BufferedImage fullImg = null;
		try {
			fullImg = ImageIO.read(screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		org.openqa.selenium.Point point =  ele.getLocation();
		int  eleWidth =  ele.getSize().getWidth();
		int  eleHeight =  ele.getSize().getHeight();
		BufferedImage  eleScreenshot=  fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);

		try {
			ImageIO.write(eleScreenshot, "png", screenshot);


			FileUtils.copyFile(screenshot, CroppedImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("takeCroppedScreenshot() : ImageIO.read");			

			bufferedImage = ImageIO.read(CroppedImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bufferedImage;


	}

	/**
	 * Convenience method that returns true if the element is visible on the screen.
	 * Used as an expected condition in waitUntilImageExists
	 */
	public Point2D getCoords(BufferedImage baseImg, String targetImgPath) {
		Match m;
		Finder f = new Finder(baseImg);
		Point2D coords = new Point2D.Double(-1, -1);

		f.find(targetImgPath);
		if (f.hasNext()) {
			m = f.next();
			coords.setLocation(m.getTarget().getX(), m.getTarget().getY());
		}
		System.out.println("getCoords " + coords.toString());		
		return coords;
	}

	public Point2D getCoords(BufferedImage baseImg, String targetImgPath, double minSimilarityValue) {
		// set new minimum similarity
		Settings.MinSimilarity = minSimilarityValue;
		Match m;
		Finder f = new Finder(baseImg);
		Point2D coords = new Point2D.Double(-1, -1);

		f.find(targetImgPath);
		if (f.hasNext()) {
			m = f.next();
			coords.setLocation(m.getTarget().getX(), m.getTarget().getY());
		}
		// revert to default similarity
		Settings.MinSimilarity = DEFAULT_MIN_SIMILARITY;
		return coords;
	}

	public Boolean elementExists(String targetImgPath) {
		Point2D coords = getCoords(takeScreenshot(), targetImgPath);
		return (coords.getX() >= 0) && (coords.getY() >= 0);
	}

	public Boolean elementExistsCompare(String targetImgPath,AndroidElement ele) {
		//System.out.println("In elementExistsCompare");
		Point2D coords = getCoords(takeCroppedScreenshot(ele),targetImgPath);
		return (coords.getX() >= 0) && (coords.getY() >= 0);
	}


	/**
	 * Custom explicit wait method that waits for @timeoutDuration until element is
	 * visible.
	 * @throws Exception 
	 */




	public boolean imageCompare(Pattern path){
		boolean isDisplayed=false;
		Settings.OcrTextSearch =true;
		Settings.OcrTextRead=true;

		/*
		 * int x = takeScreenshot().getMinX();
		 * 
		 * int y =takeScreenshot().getMinY();
		 * 
		 * int height = takeScreenshot().getTileHeight(); int width =
		 * takeScreenshot().getWidth();
		 */
		Finder finder = new Finder(screen.capture().getImage());
		finder.find(path);	
		if (finder.hasNext())
		{
			Match m = finder.next();
//			AdvanceReporting.addLogs("pass", "Image exists in the screen");
			isDisplayed=true;
			finder.destroy();
		}
		else{
			/*
			 * System.err.println("Image not exists in the screen");
			 * AdvanceReporting.addLogs("fail", "Image not exists in the screen");
			 */
			finder.destroy();
			isDisplayed=false;
		}
		return isDisplayed;
	}

	public String convertImageToText(File croppedimage) {
		Settings.OcrTextSearch =true;
		Settings.OcrTextRead=true;
		ITesseract instance = new Tesseract();
		instance.setDatapath(System.getProperty("user.dir")+"\\src\\test\\resources\\Images\\");
		String result = "";
		try {
			result = instance.doOCR(croppedimage);
			System.out.println("Convert Image to Text"+result);
			return result;
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
			return "Error while reading image";
		}

	}


	public String captureScreenshot(String methodName) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		new File(System.getProperty("user.dir")+"/test-output/screenshots/").mkdirs();

		new File(System.getProperty("user.dir")+"/test-output/screenshots/"+methodName).mkdirs();
		String DestPath = new StringBuilder(System.getProperty("user.dir"))+"/test-output/screenshots/"+methodName+"/";
		// Capture screenshot.
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Set date format to set It as screenshot file name.
		//	SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy");
		String destFile=DestPath+methodName+dateName+".png";
		try {
			// Copy paste file at destination folder location
			FileUtils.copyFile(srcFile, new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return destFile;
	}

	public void clickByImage(String targetImgPath) {
		try {
		Screen screen = new Screen();
		Pattern pattern = new Pattern(targetImgPath).similar(0.8f);
        screen.wait(targetImgPath, 15);
        Thread.sleep(3000);
		Region region = screen.exists(pattern);
		region.setAutoWaitTimeout(5000);
		region.click(pattern);
			} catch (FindFailed | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		Actions mouseAction = new Actions(Utils.uBase.driver);     
//		mouseAction.click(pattern).perform();
	}
	
	public void hoverOnImage(String targetImgPath) {
		try {
		Screen screen = new Screen();
		Pattern pattern = new Pattern(targetImgPath).similar(0.8f);
		Region region = screen.exists(pattern);
		region.hover(pattern);
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		Actions mouseAction = new Actions(Utils.uBase.driver);     
//		mouseAction.click(pattern).perform();
	}
	
	public boolean verifyifImageExistsOnScreen(String targetImgPath) {
		boolean result=false;
		try {
		Screen screen = new Screen();	
		//screen.wait(targetImgPath, 1200);
		if(screen.exists(targetImgPath,50)!=null) {
			result=true;
			AdvanceReporting.addLogs("pass", "Image found");			
			AdvanceReporting.addLogs("pass", "Image found","Image");
		}else {
			AdvanceReporting.addLogs("pass", "Image not displayed on screen");
			AdvanceReporting.addLogs("pass", "Image not found","Image not found");
		}
		
			} catch (FindFailed e) {
				e.printStackTrace();
			}
		catch(Exception e) {
			
		}return result;
	} 
	
}
