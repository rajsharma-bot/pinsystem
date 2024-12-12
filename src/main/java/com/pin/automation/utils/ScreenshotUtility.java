package com.pin.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	private static Logger log = LogManager.getLogger(ScreenshotUtility.class);

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		// Create a timestamp for the screenshot name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotDirectory = ResourceHelper.getResourcePath("src/main/resources/screenShots");

		// Create the directory if it doesn't exist
		File directory = new File(screenshotDirectory);
		if (!directory.exists()) {
			directory.mkdirs(); // Create directory if it does not exist
			log.info("Created directory for screenshots: " + screenshotDirectory);
		}

		// Construct the full screenshot path
		String screenshotPath = screenshotDirectory + "/" + screenshotName + "_" + timeStamp + ".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(screenshotPath);

		try {
			// Copy the screenshot to the destination file
			FileUtils.copyFile(screenshotFile, destinationFile);
			log.info("Screenshot saved as: " + destinationFile.getAbsolutePath());
		} catch (IOException e) {
			log.error("Failed to capture screenshot: " + e.getMessage());
		}

		return screenshotPath; // Return the path for reporting
	}
}
