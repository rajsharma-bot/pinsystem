package com.pin.automation.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pin.automation.utils.FileSaver;
import com.pin.automation.utils.FrameHelper;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.ResourceHelper;
import com.pin.automation.utils.WaitHelper;

public class InvoiceObjects {

	private static Logger log = LogManager.getLogger(InvoiceObjects.class);

	WebDriver driver;

	public InvoiceObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void UnbilledMedia_PI() {
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());

		driver.findElement(InvoicePageObjects.UnbilledMedia_PI).click();

		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
	}

	public void StartDate(String startdate) {

		WebElement dateInput = driver.findElement(InvoicePageObjects.StartDate);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + startdate + "';", dateInput);

	}

	public void EndDate(String endDate) {

		WebElement dateInput = driver.findElement(InvoicePageObjects.EndDate);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + endDate + "';", dateInput);

	}

	public void createInvoice() throws InterruptedException {
		Thread.sleep(30000);
		driver.findElement(InvoicePageObjects.Create_Invoice).click();
	}

	public WebElement Search_DDL() {
		WebElement Search_DDL = driver.findElement(InvoicePageObjects.search_ddl);
		return Search_DDL;

	}

	public void txt_box(String code) {
		driver.findElement(InvoicePageObjects.Search_txt).sendKeys(code);
	}

	public void UnbilledMedia_find() throws InterruptedException {
		log.info("Clicked on find button");
		driver.findElement(InvoicePageObjects.UnbilledMedia_find).click();
		Thread.sleep(10000);
	}

	public boolean checkBox_visible() {
		log.info("checkBox_visible");
		boolean visible = driver.findElement(InvoicePageObjects.checkBox_visible).isSelected();
		return visible;
	}

	/*
	 * public void selectAll_Checkbox() { WaitHelper waitHelper = new
	 * WaitHelper(driver); WebElement checkbox =
	 * waitHelper.waitForElementVisibility(InvoicePageObjects.selectAll_checkBox,
	 * 40); if (checkbox != null) { checkbox.click();
	 * log.info("Clicked selectAll_CheckBox");
	 * 
	 * boolean isSelected = checkbox.isSelected(); log.info("Checkbox selected: " +
	 * isSelected); } else { log.error("Checkbox not clickable after waiting."); }
	 * 
	 * }
	 */

	public void selectAll_Checkbox() {
	    WaitHelper waitHelper = new WaitHelper(driver);
	    WebElement checkbox = waitHelper.waitForElementVisibility(InvoicePageObjects.selectAll_checkBox, 40);

	    if (isCheckboxClickable(checkbox)) {
	        clickCheckbox(checkbox);
	        return;
	    }

	    log.warn("First attempt to click checkbox failed. Calling UnbilledMedia_find().");

	    try {
	        UnbilledMedia_find();
	    } catch (InterruptedException e) {
	        log.error("Interrupted while waiting after UnbilledMedia_find()", e);
	        Thread.currentThread().interrupt(); // restore interrupt status
	    }

	    checkbox = waitHelper.waitForElementVisibility(InvoicePageObjects.selectAll_checkBox, 40);

	    if (isCheckboxClickable(checkbox)) {
	        clickCheckbox(checkbox);
	    } else {
	        log.error("Checkbox not clickable even after UnbilledMedia_find().");
	    }
	}

	private boolean isCheckboxClickable(WebElement checkbox) {
	    return checkbox != null && checkbox.isDisplayed() && checkbox.isEnabled();
	}

	private void clickCheckbox(WebElement checkbox) {
	    try {
	        checkbox.click();
	        log.info("Checkbox clicked.");
	        log.info("Checkbox selected: " + checkbox.isSelected());
	    } catch (Exception e) {
	        log.error("Exception while clicking checkbox: " + e.getMessage());
	    }
	}



	public void Generate_Invoice() {
		try {
			log.info("Checking Generate invoice button is Enabled");
			Thread.sleep(30000);
			log.info("Generate invoice button is Enabled");
			driver.findElement(InvoicePageObjects.Generate_Invoice).click();

		} catch (InterruptedException e) {
			log.error("Generate Invoice button is not visible");
			e.printStackTrace();
		}
	}

	public void getInvoice_Number() {
		String filePath = ResourceHelper.getInvoiceCode();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Boolean value = driver.findElement(InvoicePageObjects.getInvoiceNumber).isDisplayed();
		if (value == true) {
			log.info("Invoice has been created");
			log.info(driver.findElement(InvoicePageObjects.getInvoiceNumber).getText());
			FileSaver.saveTextToFile(driver.findElement(InvoicePageObjects.getInvoiceNumber).getText(), filePath);
		} else {
			log.error("Invoice is not created");
		}
	}

	public String validateInvoice_Number() {
		String invoiceNo = driver.findElement(InvoicePageObjects.getInvoiceNumber).getText();
		return invoiceNo;
	}

	public void Confirm_invoice() {
		driver.findElement(InvoicePageObjects.confirm_invoice).click();
		driver.switchTo().alert().accept();

	}

	private void handleAlert() {
		try {
			if (driver.switchTo().alert() != null) {
				driver.switchTo().alert().accept();
				log.info("Alert accepted.");
			}
		} catch (Exception e) {
			log.info("No alert to accept.");
		}
	}

}
