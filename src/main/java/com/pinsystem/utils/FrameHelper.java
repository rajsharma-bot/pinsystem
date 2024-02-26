package com.pinsystem.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {

private WebDriver driver;
	
	public FrameHelper(WebDriver driver){
		this.driver = driver;
	}

	public void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
		
	}
	
	public void switchToFrame(String framename) {
		driver.switchTo().frame(framename);
	}
	
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
}
