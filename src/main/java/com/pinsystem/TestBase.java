package com.pinsystem;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pinsystem.pageObjects.CreditNoteObjects;
import com.pinsystem.pageObjects.HomeNavigationObjects;
import com.pinsystem.pageObjects.InvoiceObjects;
import com.pinsystem.pageObjects.MenuObjects;
import com.pinsystem.pageObjects.MixMediaSchedule;
import com.pinsystem.pageObjects.ScheduleObjects;
import com.pinsystem.utils.DropDownHelper;
import com.pinsystem.utils.EmailUtility;
import com.pinsystem.utils.ExtentManager;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;
import com.pinsystem.utils.ScreenshotUtility;
import com.pinsystem.utils.WaitHelper;
import com.pinsystem.utils.WindowHandler;
import com.pinsystem.utils.FileUtil;
import com.pinsystem.utils.FrameHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	public static File reportDirectory;
	private static Logger log = LogManager.getLogger(TestBase.class);

    // Declare helper and page object instances
    
    protected FrameHelper fh;
    protected MenuObjects Mo;
    protected WaitHelper wh;
    protected HomeNavigationObjects HN;
    protected DropDownHelper dh;
    protected MixMediaSchedule mx;
    protected InvoiceObjects IO;
    protected ScheduleObjects so;
    protected WindowHandler pop;
    protected CreditNoteObjects CO;

	@BeforeSuite
	public void beforeSuite() throws Exception {
		extent = ExtentManager.getInstance();
	}

	@BeforeClass
	public void BeforeClass() throws IOException {
		startUp();
		test = extent.createTest(getClass().getSimpleName());

        // Initialize helper and page objects
        fh = new FrameHelper(driver);
        Mo = new MenuObjects(driver);
        wh = new WaitHelper(driver);
        HN = new HomeNavigationObjects(driver);
        dh = new DropDownHelper(driver);
        mx = new MixMediaSchedule(driver);
        IO = new InvoiceObjects(driver);
        so = new ScheduleObjects(driver);
        pop= new WindowHandler(driver);
        CO= new CreditNoteObjects(driver);
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "**************test started***************");
		log.info("**************" + method.getName() + " Started ***************");
	}

	@AfterClass
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
		ExtentManager.getInstance().flush(); 
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        test.log(Status.FAIL, "Test failed: " + result.getThrowable());
	        String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName() + "_failure");
	        test.addScreenCaptureFromPath(screenshotPath);
	    } else if (result.getStatus() == ITestResult.SUCCESS) {
	        test.log(Status.PASS, result.getName() + " passed successfully.");
	        String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName() + "_success");
	        test.addScreenCaptureFromPath(screenshotPath);
	    } else if (result.getStatus() == ITestResult.SKIP) {
	        test.log(Status.SKIP, "Test skipped: " + result.getThrowable());
	    }
	    
	    log.info("************** " + result.getName() + " Finished ***************");
	    test.log(Status.INFO, result.getName() + " test ended.");
	}

	public void startUp() throws IOException {
		ObjectReader.reader = new PropertyReader();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Initialize Web driver: " + driver.hashCode());

		wh = new WaitHelper(driver); // Initialize WaitHelper here as it's used in startUp
		wh.setImplicitWait(ObjectReader.reader.getExplicitWait());
		wh.pageLoadTime(ObjectReader.reader.getPageLoadTime());
		
		getApplicationUrl();
		driver.manage().window().maximize();
	}

	public void getApplicationUrl() throws IOException {
		ObjectReader.reader = new PropertyReader();
		driver.get(ObjectReader.reader.getUrl());
	}

	public static void logExtentReport(String message) {
		test.log(Status.INFO, message);
	}
}
