package com.pinsystem.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility1 {
	
	private static Logger log = LogManager.getLogger(ScreenshotUtility1.class);

	private WebDriver driver;

	public ScreenshotUtility1(WebDriver driver) {
		this.driver = driver;
	}

	public void captureScreenshot(ITestResult result) {
		String screenshotName = result.getMethod().getMethodName() + "_" + getCurrentDateTime() + ".png";
		//String directory = System.getProperty("user.dir") + "/screenshots/";
		
		String directory = ResourceHelper.getResourcePath("src/main/resources/screenShots/");
		
		Path screenshotPath = Paths.get(directory + screenshotName);
		log.info(screenshotPath);
		

		// Capture screenshot and save to the path
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.createDirectories(Paths.get(directory));
			Files.move(screenshotFile.toPath(), screenshotPath);
			System.out.println("Screenshot captured: " + screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getCurrentDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		return sdf.format(new Date());
	}
}
