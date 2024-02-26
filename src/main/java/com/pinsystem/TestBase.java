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

public class TestBase {

	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriver driver;
	public static File reportDirectery;
	private static Logger log = LogManager.getLogger(TestBase.class);
	
	

	@BeforeSuite
	public void beforeSuite() throws Exception {
		extent = ExtentManager.getInstance();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "**************test started***************");
		log.info("**************" + method.getName() + "Started***************");
	}

	@BeforeTest
	public void setUp() throws IOException {
		FileReader reader = new FileReader("src/main/resources/configfile/config.properties");
		Properties props = new Properties();
		props.load(reader);
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver = new ChromeDriver(options);
		
		log.info("Initialize Web driver");
		// driver.manage().window().maximize();
	
		String s= props.getProperty("applicationUrl");
		
		System.out.println(s);
		driver.get(props.getProperty("applicationUrl"));
		reportDirectery = new File(ResourceHelper.getResourcePath("src/main/resources/screenShots"));
		test = extent.createTest(getClass().getSimpleName());

	}
	
	

	@AfterTest()
	public void AfterTest() {
		driver.quit();
		//driver.close();
		log.info("Driver closed in invoked");
		}

	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreen(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is pass");
			 String imagePath = captureScreen(result.getName(),driver);
			 test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		log.info("**************" + result.getName() + " Finished***************");
		test.log(Status.INFO, result.getName() + "**************test Finished***************");
		extent.flush();
		
		
	}

	public String captureScreen(String fileName, WebDriver driver) {
		if (driver == null) {
			log.info("driver is null..");
			return null;
		}
		if (fileName == "") {
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

	public static void logExtentReport(String s1) {
		test.log(Status.INFO, s1);
	}

}
