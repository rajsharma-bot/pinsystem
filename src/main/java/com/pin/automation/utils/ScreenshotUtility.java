package com.pin.automation.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotUtility {

	private static final Logger log = LogManager.getLogger(ScreenshotUtility.class);

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			// Validate driver session
			if (driver == null) {
				log.warn("WebDriver is null. Skipping screenshot.");
				return null;
			}
			if (!(driver instanceof RemoteWebDriver)) {
				log.warn("Driver is not an instance of RemoteWebDriver. Skipping screenshot.");
				return null;
			}
			RemoteWebDriver remoteDriver = (RemoteWebDriver) driver;
			if (remoteDriver.getSessionId() == null) {
				log.warn("WebDriver session is null or already closed. Skipping screenshot.");
				return null;
			}

			// Create directory and timestamp
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String screenshotDirectory = ResourceHelper.getResourcePath("src/main/resources/screenShots");
			File directory = new File(screenshotDirectory);
			if (!directory.exists()) {
				directory.mkdirs();
				log.info("Created screenshot directory: " + screenshotDirectory);
			}

			String screenshotPath = screenshotDirectory + "/" + screenshotName + "_" + timeStamp + ".png";

			// Use AShot to take full-page screenshot
			Screenshot screenshot = new AShot()
					.shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(driver);
			BufferedImage image = screenshot.getImage();
			ImageIO.write(image, "PNG", new File(screenshotPath));

			log.info("Full-page screenshot saved: " + screenshotPath);
			return screenshotPath;

		} catch (Exception e) {
			log.error("Failed to capture full-page screenshot: " + e.getMessage(), e);
			return null;
		}
	}
}
