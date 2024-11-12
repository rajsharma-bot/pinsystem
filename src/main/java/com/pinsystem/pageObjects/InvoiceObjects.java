package com.pinsystem.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.pinsystem.utils.FileSaver;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.ResourceHelper;

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
//		if (driver.switchTo().alert() != null) {
//			driver.switchTo().alert().accept();
//			selectAll_CheckBox();	
//		}else {
//			System.out.println("Issue with selecting checkbox");
//		}
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
		boolean visible= driver.findElement(InvoicePageObjects.checkBox_visible).isSelected();
		return visible;
	}
	
	public void selectAll_CheckBox() {
		
		try {
			driver.findElement(InvoicePageObjects.selectAll_checkBox).click();
			log.info("selectAll_CheckBox");
			Thread.sleep(10000);
			Boolean d =driver.findElement(InvoicePageObjects.selectAll_checkBox).isSelected();
			log.info(d);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			String invoiceNo= driver.findElement(InvoicePageObjects.getInvoiceNumber).getText();
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
