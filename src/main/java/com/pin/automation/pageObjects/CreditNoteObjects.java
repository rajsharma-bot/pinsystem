package com.pin.automation.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pin.automation.utils.FileSaver;
import com.pin.automation.utils.FrameHelper;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.ResourceHelper;

public class CreditNoteObjects {

	private static Logger log = LogManager.getLogger(CreditNoteObjects.class);

	WebDriver driver;

	public CreditNoteObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void Invoice_list() {

		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());

		log.info("Clicked on Invoice List Page");
		driver.findElement(CreditNotePageObjects.Invoice_list).click();

		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
	}

	public WebElement ListAll_MonthDDL() {
		log.info("Clicked on Invoice List Page"); //
		WebElement Month_DDL = driver.findElement(CreditNotePageObjects.Date_listAll);
		return Month_DDL;
	}

	public void Invoice_search(String code) {
		log.info("Passing Invoice number");
		driver.findElement(CreditNotePageObjects.Invoice_search).sendKeys(code);
	}

	public void SearchInvoice() {

		driver.findElement(CreditNotePageObjects.Search_Invoice).click();
	}

	public void Invoice_link() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(CreditNotePageObjects.InvoiceNo_link).click();
	}

	public void Create_CreditNoteBtn() {
		driver.findElement(CreditNotePageObjects.CreditNoteBtn).click();
	}

	public void generate_CreditNote() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(CreditNotePageObjects.Generate_CreditNote).click();
	}

	public void getCreditNote_Number() throws InterruptedException {
		String filePath = ResourceHelper.getCreditNoteCode();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Boolean value = driver.findElement(CreditNotePageObjects.getCreditNote_No).isDisplayed();
		if (value == true) {
			log.info("Invoice has been created");
			log.info(driver.findElement(CreditNotePageObjects.getCreditNote_No).getText());
			FileSaver.saveTextToFile(driver.findElement(CreditNotePageObjects.getCreditNote_No).getText(), filePath);
		} else {
			log.error("Creditnote is not created");
		}
		Thread.sleep(10000);
	}

	public String validateCreditNote_Number() throws InterruptedException {
		String creditNote = driver.findElement(CreditNotePageObjects.getCreditNote_No).getText();
		return creditNote;

	}

	public void approve_CN() {
		driver.findElement(CreditNotePageObjects.approve_CNbt).click();
		driver.switchTo().alert().accept();
	}

	public void ReleaseAllSpots() throws InterruptedException {
		Thread.sleep(10000);
		log.info("Clicked on Release All Spots");
		driver.findElement(CreditNotePageObjects.ReleaseAllSpots).click();
		driver.switchTo().alert().accept();

	}

}
