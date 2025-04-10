package com.pin.automation.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pin.automation.utils.FrameHelper;

public class GenericElementObjects {

	
	private static Logger log = LogManager.getLogger(GenericElementObjects.class);
	
	WebDriver driver;
	WebDriverWait wait;

	public GenericElementObjects(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //// global WebDriverWait
	}
	
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
	
	
	
	public void ImportStatus() throws InterruptedException {
		FrameHelper FrameHelper = new FrameHelper(driver);
		
		log.info("Clicked on Import Status");
		clickElement(GenericElementPageObjects.WaitingForImport, "Clicked on Import Status Hyperlink");
		
		Thread.sleep(20000);
		FrameHelper.switchTodefault();
	}
	
	public WebElement ImportStatus_DDL() {
		log.info("Getting all option from Import DDL");
		WebElement ImportDDl= driver.findElement(GenericElementPageObjects.Import_DLL);
		return ImportDDl;
	}
	
	
	public void ImportStatus_SaveBtn() {
		log.info("Clicked on import save button");
		//driver.findElement(CreditNotePageObjects.ImportSave_btn).click();
		clickElement(GenericElementPageObjects.ImportSave_btn, "Clicked on Import Save button");
	}
	
	public String GetImportStatus() {
		log.info("Getting Import status text");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String status =driver.findElement(GenericElementPageObjects.WaitingForImport).getText();
		log.info("Status of Import Status is "+ status);
		return status;
	}
	
	
}
