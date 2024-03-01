package com.pinsystem.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {

private WebDriver driver;

private static Logger log = LogManager.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver){
		this.driver = driver;
	}

	public void switchToFrame(int frameIndex) {
	//	log.info("Frame has been switched to " + frameIndex );
		driver.switchTo().frame(frameIndex);
		log.info("Frame has been switched to " + frameIndex );
		
	}
	
	public void switchToFrame(String framename) {
	//	log.info("Frame has been switched to " + framename );
		driver.switchTo().frame(framename);
		log.info("Frame has been switched to " + framename );
	}
	
	public void switchToFrame(WebElement element) {
		//log.info("Frame has been switched to " + element );
		driver.switchTo().frame(element);
		log.info("Frame has been switched to " + element );
	}
	
	public void switchTodefault() {
		//log.info("Frame has been switched default or parent frame" );
		driver.switchTo().defaultContent();
		log.info("Frame has been switched default or parent frame" );
	}
}
