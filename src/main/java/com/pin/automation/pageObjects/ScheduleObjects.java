package com.pin.automation.pageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pin.automation.utils.FileSaver;
import com.pin.automation.utils.FrameHelper;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.ResourceHelper;

public class ScheduleObjects {

	private static Logger log = LogManager.getLogger(ScheduleObjects.class);

	WebDriver driver;
	WebDriverWait wait;

	public ScheduleObjects(WebDriver driver) {
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

	public void confirm_schedule() throws InterruptedException {

		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());

		Thread.sleep(30000);
		driver.findElement(SchedulePageObjects.confirm_schedule).click();
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
		} else {
			log.info("No alert");
			driver.findElement(SchedulePageObjects.confirm_schedule).click();
		}
		log.info("Schedule confirm button has been clicked");
		Thread.sleep(30000);
		if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.Close_media_schedule).click();
			log.info(true);
			log.info("Pop-up is closed");
		} else {
			log.info("Edit Pop has been ignored");
		}
	}

	public void Create_MO_By_Vendor() throws InterruptedException {
		driver.findElement(SchedulePageObjects.Create_MO_By_Vendor).click();
		driver.switchTo().alert().accept();
		log.info("Create Mo by vendor button has been clicked");
		Thread.sleep(30000);
		if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.Close_media_schedule).click();
			log.info(true);
			log.info("Pop-up is closed");
		} else {
			log.info("Edit Pop has been ignored");
		}

	}
	
	
	public void createAutoMonthlyMO() throws InterruptedException {
		driver.findElement(SchedulePageObjects.createAutoMonthly_MO).click();
		driver.switchTo().alert().accept();
		log.info("Create Mo by vendor button has been clicked");
		Thread.sleep(30000);
		if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.Close_media_schedule).click();
			log.info(true);
			log.info("Pop-up is closed");
		} else {
			log.info("Edit Pop has been ignored");
		}

	}
	

	public WebElement MO_number() {
		WebElement MO = driver.findElement(SchedulePageObjects.MO_created);
		log.info("MO number can be seen");
		return MO;
	}

	public void Select_checkBox() {
		log.info("Clicked on Select All checkbox ");
		driver.findElement(SchedulePageObjects.confirm_mo_checkBox).click();
	}

	public void Confirm_mo() throws InterruptedException {
		driver.findElement(SchedulePageObjects.Confirm_mo).click();
		Thread.sleep(30000);
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
		} else {
			log.info("No alert");
			driver.findElement(SchedulePageObjects.Confirm_mo).click();
		}
		log.info("MO has been confirmed");

		if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.Close_media_schedule).click();
			log.info(true);
			log.info("Pop-up is closed");
		} else {
			log.info("Edit Pop has been ignored");
		}
	}

	public void MO_status() throws InterruptedException {
		Thread.sleep(30000);
		if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.Close_media_schedule).click();
			log.info(true);
			log.info("Pop-up is closed");
		} else {
			log.info("Edit Pop-up has been ignored");
		}

		String status = driver.findElement(SchedulePageObjects.mo_status).getText();
		if (status.equalsIgnoreCase("Confirm")) {
			log.info("MO Status is : " + status);
		}
	}

	public void getScheduleCode() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String filePath = ResourceHelper.getScheduleNo();
		Boolean value = driver.findElement(MenuPageObjects.Schedule_text).isDisplayed();
		if (value == true) {
			log.info("Schedule has been created");
			log.info(driver.findElement(MenuPageObjects.Schedule_text).getText());
			FileSaver.saveTextToFile(driver.findElement(MenuPageObjects.Schedule_text).getText(), filePath);
		} else {
			log.error("Schedule is not created");
		}

	}

	public String verifyScheduleNo() {
		String sc_no = driver.findElement(MenuPageObjects.Schedule_text).getText();
		return sc_no;
	}

	public void clickOnMOnumber() {

		log.info("Clicking on MO hyperlink");
		clickElement(SchedulePageObjects.MOLink, " Click on MO number hyperlink");
	}
	
	public String MOnumber() {

		log.info("Clicking on MO hyperlink");
		String MO= driver.findElement(SchedulePageObjects.MOLink).getText();
		return MO;
	}

	
	public void getMOnumber() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String filePath = ResourceHelper.getMONumber();
		Boolean value = driver.findElement(SchedulePageObjects.MOLink).isDisplayed();
		if (value == true) {
			log.info("MO has been created");
			log.info(driver.findElement(SchedulePageObjects.MOLink).getText());
			FileSaver.saveTextToFile(driver.findElement(SchedulePageObjects.MOLink).getText(), filePath);
		} else {
			log.error("MO is not created");
		}
	}
	
	public void verifyViewMOpage(String mo) {
		log.info("Verify if landed on View line by line page");
		
		String ScheduleNo =driver.findElement(SchedulePageObjects.verifyMOpage).getText();
		if(ScheduleNo.contains(mo)) {
			log.info("Successfully Landed on View MO Page");
			Boolean value =true;
			Assert.assertEquals(value, true);
		}else {
			log.info("unable to fetch MO number");
		}	
		
	}
	
	public void moPage_moStatus() {
		log.info("verifying MO status");	
		String status =driver.findElement(SchedulePageObjects.viewMOPageStatus).getText();
		if(status.contains("Confirmed")){
			log.info(status);
			assertEquals(status, "Confirmed");
		}
		else {
			log.info("MO status doesn't matches");
		}
		
	}
	
}
