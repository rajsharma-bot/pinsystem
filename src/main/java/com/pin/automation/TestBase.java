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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pin.automation.pageObjects.CreditNoteObjects;
import com.pin.automation.pageObjects.GenericElementObjects;
import com.pin.automation.pageObjects.HomeNavigationObjects;
import com.pin.automation.pageObjects.InvoiceObjects;
import com.pin.automation.pageObjects.JobObjects;
import com.pin.automation.pageObjects.MenuObjects;
import com.pin.automation.pageObjects.MixMediaSchedule;
import com.pin.automation.pageObjects.ScheduleObjects;
import com.pin.automation.pageObjects.ViewLineBylineObjects;
import com.pin.automation.utils.DropDownHelper;
import com.pin.automation.utils.EnvConfig;
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
	protected JobObjects JobObjects;

	@Parameters("env")
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(@Optional("pi2") String env) throws Exception {
		EnvConfig.setEnvironment(env);
		extent = ExtentManager.getInstance();
	}

	@Parameters("env")
	@BeforeClass(alwaysRun = true)
	// if need to run manually then set env in optional
	public void BeforeClass(@Optional("pi2") String env) throws IOException {
		System.setProperty("env", env);
		ExtentManager.getInstance();

		if (driver == null) { // Only start if driver not initialized yet
			startUp();
		}

		test = extent.createTest(getClass().getSimpleName());

		// Initialize helper and page objects
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
		reader = new PropertyReader();
		GenericElementObjects = new GenericElementObjects(driver);
		ViewLineBylineObjects = new ViewLineBylineObjects(driver);
		JobObjects = new JobObjects(driver);

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		test = extent.createTest(method.getName()); // Create test for every method
		test.log(Status.INFO, method.getName() + " ************** test started ***************");
		log.info("************** " + method.getName() + " Started ***************");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test failed: " + result.getThrowable());
			String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName() + "_failure");
			if (screenshotPath != null) {
				test.addScreenCaptureFromPath(screenshotPath);
			}
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " passed successfully.");
			String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName() + "_success");
			if (screenshotPath != null) {
				test.addScreenCaptureFromPath(screenshotPath);
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test skipped: " + result.getThrowable());
		}

		log.info("************** " + result.getName() + " Finished ***************");
		test.log(Status.INFO, result.getName() + " test ended.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		try {
			if (driver != null) {
				driver.quit();
				log.info("Driver quit successfully.");
			}
		} catch (Exception e) {
			log.error("Error quitting driver: ", e);
		} finally {
			driver = null; // Nullify so next class will start fresh
		}

		ExtentManager.exportReportToExcel();
		ExtentManager.getInstance().flush();
	}

	public void startUp() throws IOException {
		ObjectReader.reader = new PropertyReader();
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false);

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		log.info("Initialize Web driver: " + driver.hashCode());

		WaitHelper = new WaitHelper(driver);
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		WaitHelper.pageLoadTime(ObjectReader.reader.getPageLoadTime());

		getApplicationUrl();
		driver.manage().window().maximize();
	}

	public void getApplicationUrl() throws IOException {
		ObjectReader.reader = new PropertyReader();

		String env = System.getProperty("env");
		if (env == null || env.isEmpty()) {
			env = "devbr"; // default environment
			System.setProperty("env", env);
		}
		env = env.toLowerCase();

		String url;
		switch (env) {
		case "pi2":
			url = ObjectReader.reader.getValue("url.pi2");
			break;
		case "devbr":
			url = ObjectReader.reader.getValue("url.devbr");
			break;
		case "pdt":
			url = ObjectReader.reader.getValue("url.pdt");
			break;
		case "prsmpdt":
			url = ObjectReader.reader.getValue("url.prsmpdt");
			break;
		default:
			throw new IllegalArgumentException("Invalid environment: " + env);
		}

		log.info(">>> Launching URL: " + url);
		driver.get(url);
	}
}
