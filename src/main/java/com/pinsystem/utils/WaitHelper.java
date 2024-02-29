package com.pinsystem.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WaitHelper {
	
	private WebDriver driver;
	private static Logger log = LogManager.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setImplicitWait(long timeout) {
		log.info("Implicit Wait has been set to: " + timeout);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		
	}
	
	public void pageLoadTime(long timeout) {
		log.info("waiting for page to load for : "+ timeout);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
		log.info("page is loaded");
	}

}
