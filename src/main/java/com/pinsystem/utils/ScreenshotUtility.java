package com.pinsystem.utils;

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

	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotDirectory = ResourceHelper.getResourcePath("src/main/resources/screenShots");
		String screenshotPath = screenshotDirectory + "/" + screenshotName + "_" + timeStamp + ".png";
		File destinationFile = new File(screenshotPath);

		try {
			FileUtils.copyFile(screenshotFile, destinationFile);
			System.out.println("Screenshot saved as: " + destinationFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}
		log.info("Screenshot has been captured");
	}
}
