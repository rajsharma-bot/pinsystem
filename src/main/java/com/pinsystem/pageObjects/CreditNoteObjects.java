package com.pinsystem.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pinsystem.utils.FileSaver;
import com.pinsystem.utils.ResourceHelper;

public class CreditNoteObjects {

	private static Logger log = LogManager.getLogger(CreditNoteObjects.class);

	WebDriver driver;

	public CreditNoteObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Invoice_list() {
		log.info("Clicked on Invoice List Page");
		driver.findElement(CreditNotePageObjects.Invoice_list).click();
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
	
	public void getInvoice_Number() throws InterruptedException {
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
	
	public void approve_CN() {
		driver.findElement(CreditNotePageObjects.approve_CNbt).click();
		driver.switchTo().alert().accept();
	}
	
	public void ImportStatus() throws InterruptedException {
		driver.findElement(CreditNotePageObjects.Cn_WaitingForImport).click();
		Thread.sleep(20000);
	}
	
	public WebElement ImportDDL() {
		log.info("Getting all option from Import DDL");
		WebElement ImportDDl= driver.findElement(CreditNotePageObjects.Import_DLL);
		return ImportDDl;
	}
	public void ImportSave_btn() {
		log.info("Clicked on import save button");
		driver.findElement(CreditNotePageObjects.ImportSave_btn).click();
	}
	
	public String GetImportStatus() {
		log.info("I'm Inside to get text");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String status =driver.findElement(CreditNotePageObjects.Cn_WaitingForImport).getText();
		log.info("Status of Import Status is "+ status);
		return status;
	}
	
	public void ReleaseAllSpots() throws InterruptedException {
		Thread.sleep(10000);
		log.info("Clicked on Release All Spots");
		driver.findElement(CreditNotePageObjects.ReleaseAllSpots).click();
		driver.switchTo().alert().accept();
		
	}
	
}
