package com.pin.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AlertOnBrowser {

	WebDriver driver;

	public AlertOnBrowser(WebDriver driver) {
		this.driver = driver;
	}
	
	public void showAlert() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Data Not found try with some different data');");
	}

}
