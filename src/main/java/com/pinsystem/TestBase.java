package com.pinsystem;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

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
import com.pinsystem.utils.ExtentManager;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;
import com.pinsystem.utils.ScreenshotUtility;
import com.pinsystem.utils.WaitHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	public static File reportDirectery;
	private static Logger log = LogManager.getLogger(TestBase.class);

	@BeforeSuite
	public void beforeSuite() throws Exception {
		extent = ExtentManager.getInstance();
	}

	@BeforeClass
	public void BeforeClass() throws IOException {
		startUp();
		test = extent.createTest(getClass().getSimpleName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "**************test started***************");
		log.info("**************" + method.getName() + "Started***************");
	}

	@AfterClass
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			ScreenshotUtility.captureScreenshot(driver, result.getName() + "_failure");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is pass");
			ScreenshotUtility.captureScreenshot(driver, result.getName() + "_success");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		log.info("**************" + result.getName() + "Finished***************");
		test.log(Status.INFO, result.getName() + "**************test Ended***************");
		System.out.println(result.getName());
		extent.flush();
	}

	public void startUp() throws IOException {
		ObjectReader.reader = new PropertyReader();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WaitHelper wh = new WaitHelper(driver);
		log.info("Initialize Web driver: " + driver.hashCode());
		wh.setImplicitWait(ObjectReader.reader.getExplicitWait());
		wh.pageLoadTime(ObjectReader.reader.getPageLoadTime());
		getApplicationUrl();
		// driver.manage().window().maximize();

	}

	public void getApplicationUrl() throws IOException {
		ObjectReader.reader = new PropertyReader();
		driver.get(ObjectReader.reader.getUrl());

	}

	public static void logExtentReport(String s1) {
		test.log(Status.INFO, s1);
	}

}
