package com.pin.automation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pin.automation.pageObjects.CreditNoteObjects;
import com.pin.automation.pageObjects.GenericElementObjects;
import com.pin.automation.pageObjects.HomeNavigationObjects;
import com.pin.automation.pageObjects.InvoiceObjects;
import com.pin.automation.pageObjects.MenuObjects;
import com.pin.automation.pageObjects.MixMediaSchedule;
import com.pin.automation.pageObjects.ScheduleObjects;
import com.pin.automation.pageObjects.ViewLineBylineObjects;
import com.pin.automation.utils.DropDownHelper;
import com.pin.automation.utils.ExtentManager;
import com.pin.automation.utils.FrameHelper;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.PropertyReader;
import com.pin.automation.utils.ScreenshotUtility;
import com.pin.automation.utils.SwitchTabs;
import com.pin.automation.utils.WaitHelper;
import com.pin.automation.utils.WindowHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	public static File reportDirectory;
	private static Logger log = LogManager.getLogger(TestBase.class);

	// Declare helper and page object instances

	protected FrameHelper FrameHelper;
	protected MenuObjects MenuObjects;
	protected WaitHelper WaitHelper;
	protected HomeNavigationObjects HomeNavigationObjects;
	protected DropDownHelper DropDownHelper;
	protected MixMediaSchedule MixMediaSchedule;
	protected InvoiceObjects InvoiceObjects;
	protected ScheduleObjects ScheduleObjects;
	protected WindowHandler pop;
	protected CreditNoteObjects CreditNoteObjects;
	protected SwitchTabs SwitchTabs;
	protected static PropertyReader reader;
	protected GenericElementObjects GenericElementObjects;
	protected ViewLineBylineObjects ViewLineBylineObjects;

	@BeforeSuite
	public void beforeSuite() throws Exception {
		extent = ExtentManager.getInstance();

	}

	@BeforeClass
	public void BeforeClass() throws IOException {
		startUp();

		test = extent.createTest(getClass().getSimpleName());

		// Initialize helper and page objects methods
		FrameHelper = new FrameHelper(driver);
		MenuObjects = new MenuObjects(driver);
		WaitHelper = new WaitHelper(driver);
		HomeNavigationObjects = new HomeNavigationObjects(driver);
		DropDownHelper = new DropDownHelper(driver);
		MixMediaSchedule = new MixMediaSchedule(driver);
		InvoiceObjects = new InvoiceObjects(driver);
		ScheduleObjects = new ScheduleObjects(driver);
		pop = new WindowHandler(driver);
		CreditNoteObjects = new CreditNoteObjects(driver);
		SwitchTabs = new SwitchTabs(driver);
		reader = new PropertyReader(); // Sample
		GenericElementObjects = new GenericElementObjects(driver);
		ViewLineBylineObjects = new ViewLineBylineObjects(driver);
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "**************test started***************");
		log.info("**************" + method.getName() + " Started ***************");
	}

	@AfterClass
	public void afterClass() {
		if (driver != null) {
			driver.quit(); // Close the WebDriver
		}

		// Export the Extent report data to Excel
		ExtentManager.exportReportToExcel();

		// Flush the ExtentReports to finalize the report
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
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		//ChromeDriver driver = new ChromeDriver(chromeOptions);
		log.info("Initialize Web driver: " + driver.hashCode());

		WaitHelper = new WaitHelper(driver); // Initialize WaitHelper here as it's used in startUp
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		WaitHelper.pageLoadTime(ObjectReader.reader.getPageLoadTime());

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
