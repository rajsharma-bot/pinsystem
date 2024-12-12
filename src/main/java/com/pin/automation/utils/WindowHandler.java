package com.pin.automation.utils;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowHandler {

	private WebDriver driver;

	private static Logger log = LogManager.getLogger(WindowHandler.class);

	public WindowHandler(WebDriver driver) {
		this.driver = driver;
	}

	// Method to switch to child window
	public static void switchToChildWindow(WebDriver driver) {
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindow = it.next(); // Save the parent window handle
		log.info("Parent Window: " + parentWindow);
		//System.out.println("Parent Window: " + parentWindow);

		String childWindow = it.next(); // Get the child window handle
		//System.out.println("Child Window: " + childWindow);
		log.info("Child Window: " + childWindow);

		// Switch to the child window
		driver.switchTo().window(childWindow);
	}

	// Method to switch back to parent window
	public static void switchToParentWindow(WebDriver driver) {
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindow = it.next(); // Save the parent window handle
		driver.switchTo().window(parentWindow); // Switch to the parent window
		log.info("Switched back to Parent Window: " + parentWindow);
		//System.out.println("Switched back to Parent Window: " + parentWindow);
	
	}

}
