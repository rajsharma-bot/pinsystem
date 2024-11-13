package com.pinsystem.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CancelObjects {

	private static Logger log = LogManager.getLogger(CancelObjects.class);

	WebDriver driver;
	WebDriverWait wait;

	public CancelObjects(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // global WebDriverWait

	}

	// Generic method to click elements
	public void clickElement(By locator, String elementName) {
		WebElement element = waitForElementToBeClickable(locator);
		if (element != null) {
			element.click();
			log.info(elementName + " clicked successfully.");
		}
	}

	private WebElement waitForElementToBeClickable(By locator) {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			log.error("Element not clickable: " + locator);
			return null;
		}
	}

	// Generic method to send text to an element
	public void sendText(By locator, String text, String elementName) {
		WebElement element = waitForElementToBeVisible(locator);
		if (element != null) {
			element.clear();
			element.sendKeys(text);
			log.info("Text '" + text + "' entered in " + elementName);
		}
	}

	// Wait for visibility of an element
	private WebElement waitForElementToBeVisible(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error("Element not visible: " + locator);
			return null;
		}
	}

	public void selectCheckBox() {
		log.info("Selecting checking box on Schedule grid page");
		clickElement(CancelPageObjects.cancelMOCheckBox, "Checkbox selected");
	}

	public void cancelMObtn() throws InterruptedException {
		log.info("Clicking on Cancel Mo button");
		clickElement(CancelPageObjects.cancelMObtn, "Clikced Cancel MO button");
		Thread.sleep(20000);
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
		} else {
			log.info("No alert");
			clickElement(CancelPageObjects.cancelMObtn, "Clikced Cancel MO button");
		}
	}

	public void verifyMOisCancelled() throws InterruptedException {
		
		Thread.sleep(30000);
		String molink= driver.findElement(SchedulePageObjects.MOLink).getText();
		System.out.println(molink);
		
		if (molink.isEmpty()) {
			
		    log.info("MO is cancelled");
		} else {
		    log.info("MO is not cancelled");
		}
		

	}

}
