package com.pinsystem;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pinsystem.utils.ExtentManager;
import com.pinsystem.utils.ResourceHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase3 {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	public static File reportDirectery;
	private static Logger log = LogManager.getLogger(TestBase3.class);

	@BeforeSuite
	public void beforeSuite() throws Exception {
		extent = ExtentManager.getInstance();
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		reportDirectery = new File(ResourceHelper.getResourcePath("src/main/resources/screenShots"));
		startUp();
		test = extent.createTest(getClass().getSimpleName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "**************test started***************");
		log.info("**************" + method.getName() + "Started***************");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreen(result.getName());
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		log.info("**************" + result.getName() + "Finished***************");
		extent.flush();

	}

	
	@AfterTest
	public void afterTest() throws Exception {
		if(driver!=null){
			driver.quit();
		}
	}
	
	public void startUp() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Initialize Web driver: " + driver.hashCode());
		getApplicationUrl();

	}

	public void getApplicationUrl() throws IOException {
		FileReader reader = new FileReader("src/main/resources/configfile/config.properties");
		Properties props = new Properties();
		props.load(reader);
		driver.get(props.getProperty("applicationUrl"));
	}

	public String captureScreen(String fileName) {
		
//		if(driver == null){
//			log.info("driver is null..");
//			return null;
//		}
		if(fileName==""){
			fileName = "blank";
		}

		Reporter.log("captureScreen method called");
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File screFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = new File(reportDirectery + "/" + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			Files.copy(screFile.toPath(), destFile.toPath());
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
					+ "'height='100' width='100'/></a>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destFile.toString();

	}
	
	public static void logExtentReport(String s1){
		test.log(Status.INFO, s1);
	}

}
