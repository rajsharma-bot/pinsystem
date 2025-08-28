package com.pin.automation.pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pin.automation.utils.FileSaver;
import com.pin.automation.utils.FrameHelper;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.ResourceHelper;

public class JobObjects {
	private static Logger log = LogManager.getLogger(JobObjects.class);

	WebDriver driver;
	WebDriverWait wait;

	public JobObjects(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //// global WebDriverWait
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

	public void newJob() {
		FrameHelper FrameHelper = new FrameHelper(driver);

		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		log.info("New job has been clicked");
		clickElement(JobPageObjects.newJobButton, "Clicked on New Job");
	}

	public void oldJob() {
		FrameHelper FrameHelper = new FrameHelper(driver);

		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		log.info("Clicked on Old job button");
		clickElement(JobPageObjects.oldJob.oldJobButton, "Clicked on old Job");
	}

	public void selectClient(String clientName) throws InterruptedException {
		FrameHelper frameHelper = new FrameHelper(driver);
		frameHelper.switchTodefault();
		frameHelper.switchToFrame(ObjectReader.reader.rightframe());

		// Click the dropdown to open it
		WebElement dropdown = driver.findElement(JobPageObjects.clientDDL);
		dropdown.click();

		// Wait and find all options
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='chosen-results']/li"));

		boolean found = false;
		for (WebElement option : options) {
			if (option.getText().trim().equalsIgnoreCase(clientName.trim())) {
				option.click(); // Click the matching client name
				found = true;
				break;
			}
		}

		if (!found) {
			throw new NoSuchElementException("Client '" + clientName + "' not found in the dropdown.");
		}

		log.info("Client selected: " + clientName);
	}

	public WebElement Product() throws InterruptedException {
		Thread.sleep(10000);
		WebElement DDL_Product = driver.findElement(JobPageObjects.productDDL);
		return DDL_Product;
	}

	public WebElement currency() throws InterruptedException {
		Thread.sleep(1000);
		WebElement DDL_currency = driver.findElement(JobPageObjects.currencyDDL);
		return DDL_currency;
	}

	public WebElement selectTask() {
		log.info("Selecting Task");
		WebElement selectTask = driver.findElement(JobPageObjects.selectTask);
		return selectTask;
	}

	public void startDate(String startdate) {
		WebElement dateInput = driver.findElement(JobPageObjects.startDate);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + startdate + "';", dateInput);

	}

	public void endDate(String endDate) {
		WebElement dateInput = driver.findElement(JobPageObjects.endDate);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + endDate + "';", dateInput);
	}

	public void setBudget(String value) {
		driver.findElement(JobPageObjects.budget).sendKeys(value);
	}

	public void setJobName(String value) {
		driver.findElement(JobPageObjects.JobName).sendKeys(value);
	}

	public void SaveNewJOB() {
		driver.findElement(JobPageObjects.saveAs_newJob).click();
	}

	public void getJobCode() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		String filePath = ResourceHelper.getJobcode();
		Boolean value = driver.findElement(JobPageObjects.getJobNumber).isDisplayed();
		if (value == true) {
			log.info("New JOb has been created");
			log.info(driver.findElement(JobPageObjects.getJobNumber).getText());
			FileSaver.saveTextToFile(driver.findElement(JobPageObjects.getJobNumber).getText(), filePath);
		} else {
			log.error("New Job is not created");
		}

	}

	public void getProductionInvoice() {
		String filePath = ResourceHelper.getProductionInvoiceNo();
		Boolean value = driver.findElement(JobPageObjects.costEstimateInvoice.getJobInvoiceNumber).isDisplayed();
		if (value == true) {
			log.info("Job Invoice number is generated");
			log.info(driver.findElement(JobPageObjects.costEstimateInvoice.getJobInvoiceNumber).getText());
			FileSaver.saveTextToFile(
					driver.findElement(JobPageObjects.costEstimateInvoice.getJobInvoiceNumber).getText(), filePath);
		} else {
			log.error("Job Invoice number is not generated");
		}

	}

	public void clickOnNew() {
		log.info("Clicked on new button");
		clickElement(JobPageObjects.newBtn, "Cliked on new button on Job page");
	}

	public void templateProceedbtn() {
		log.info("Clicked on proceed btn");
		clickElement(JobPageObjects.selectTemplate.proceedBtn, "Clicked on proceed Button on Template pop-up");
	}

	public void setTemplate() {
		log.info("Select CE templated");
		clickElement(JobPageObjects.selectTemplate.selectCheckBox, "Selecting CE template");
	}

	public WebElement setCostType() {
		WebElement setCostType = driver.findElement(JobPageObjects.costEstimatePage.setCostType);
		return setCostType;
	}

	public void confirmBtn() {
		log.info("Clicked on confirm and submit button");
		clickElement(JobPageObjects.costEstimatePage.submitAndConfirm, "Clicked on Submit and confirm button");
	}

	public void createInvoice() {
		log.info("Click on create Invoice");
		clickElement(JobPageObjects.costEstimateInvoice.createInvoice, "Clicked on Create Invoice button");
	}

	public void clickPartialBill() {
		log.info("Clicking on Partial Bill button");
		clickElement(JobPageObjects.costEstimateInvoice.partialBill, "Clicked on Partial Bill button");
	}

	public void setPartialBill(String value) {
		log.info("passing Partial Bill percentage");
		sendText(JobPageObjects.costEstimateInvoice.partialValue, value, "Passed value for Partial Billing");
	}

	public void clickOk() {
		log.info("Click on OK button");
		clickElement(JobPageObjects.costEstimateInvoice.partialAccept, "Clicked on Ok button");
	}

	public void generateInvoice() {
		log.info("Clicked on Invoice button");
		clickElement(JobPageObjects.costEstimateInvoice.generateInvoice, "click on Invoice button");
	}

	public void redirectToJob() {
		log.info("Navigation back to JOB");
		clickElement(JobPageObjects.productionInvoice.redirectJobNo, "Clicked on Job Number hyperlink");
	}

	public String ppInvoice() {
		log.info("");
		String ppInvoice = driver.findElement(JobPageObjects.productionInvoice.invoiceNumberOnEstimate).getText();
		return ppInvoice;
	}

	public WebElement oldJob_clientDDL() throws InterruptedException {
		Thread.sleep(10000);
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());

		log.info("Selecting client from DDL");
		WebElement old_clientDDL = driver.findElement(JobPageObjects.oldJob.oldJobclientDDL);
		return old_clientDDL;
	}

	public void setSubject(String subject) {
		log.info("Passing subject");
		driver.findElement(JobPageObjects.oldJob.oldJobSubject).sendKeys(subject);
	}

	public void setProducttxt(String product) {
		log.info("Passing Product in text box");
		driver.findElement(JobPageObjects.oldJob.productTxt).sendKeys(product);
	}

	public void setEstSales(String value) {
		log.info("passing est sales ");
		WebElement setEstSales = driver.findElement(JobPageObjects.oldJob.estSales);
		setEstSales.sendKeys(value);
	}

	public void setEstCost(String value) {
		log.info("passing est cost ");
		WebElement setEstCost = driver.findElement(JobPageObjects.oldJob.estCost);
		setEstCost.sendKeys(value);
	}

	public void setDate(String date) {
		log.info("Passing Delivery Date");
		WebElement deliveryDate = driver.findElement(JobPageObjects.oldJob.deliveryDate);
		deliveryDate.sendKeys(date);
	}

	public void saveAddAttachment() {
		clickElement(JobPageObjects.oldJob.saveAddAttachment, "Clicked on Save and Add attachment");
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
		} else {
			log.info("No alert");
			clickElement(JobPageObjects.oldJob.saveAddAttachment, "Clicked on Save and Add attachment");
		}

	}

	public void getOldJobCode() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		String filePath = ResourceHelper.getOldJobcode();
		Boolean value = driver.findElement(JobPageObjects.oldJob.getOldJobNumber).isDisplayed();
		if (value == true) {
			log.info("New JOb has been created");
			log.info(driver.findElement(JobPageObjects.oldJob.getOldJobNumber).getText());
			FileSaver.saveTextToFile(driver.findElement(JobPageObjects.oldJob.getOldJobNumber).getText(), filePath);
		} else {
			log.error("New Job is not created");
		}

	}

	public void setStatus() {
		log.info("Clicked on Draft status hyperlink");
		clickElement(JobPageObjects.oldJob.SetJOBStatusLink, "Changing job status from Draft to New");
	}

	public void setStatusAsNew() {
		log.info("Setting status as new");
		clickElement(JobPageObjects.oldJob.setStatusNew, "New Status has been selected");
	}

	public void updateStatus() {
		log.info("Clicking on Update status");
		clickElement(JobPageObjects.oldJob.updateStatus, "Clicked on Update status button");
	}

	public boolean selectTaskIsDisplayed() {

		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());

		WebElement selectTask = driver.findElement(JobPageObjects.selectTask);
		boolean isDisplayed = selectTask.isDisplayed();
		return isDisplayed;
	}

	public WebElement switchToJobStatusPopFrame() {

		WebElement newFrame = driver.findElement(JobPageObjects.oldJob.newFrame);
		return newFrame;

	}

	public void setOldJoBTemplate() {
		log.info("Select CE templated");
		clickElement(JobPageObjects.selectTemplate.selectOldFormatTemplate, "Selecting CE template");
	}

	public void createWIPInvoice() {
		clickElement(JobPageObjects.productionInvoice.generateWIPInv, "Creating WIP Invoice");
	}

	public void editEstimate() {
		log.info("Clicking on Edit Estimate ");
		clickElement(JobPageObjects.JobSummaryPage.estimateEdit, "Clicked on Estimate edit icon");
	}

	public void createPObtn() {
		log.info("Clicked on client PO button");
		clickElement(JobPageObjects.costEstimatePage.createPObtn, "Clicked on PO button");
	}

	public void selectEstPOCheckboxesAndCreatePO() {
		log.info("Selecting checkboxes with Est. PO and clicking Create PO button");

		List<WebElement> rows = driver
				.findElements(By.xpath("//tr[contains(@id,'ctl00_cph_rptIn_ctl') and contains(@id,'_trItem')]"));

		for (WebElement row : rows) {
			try {
				WebElement estPOElement = row.findElement(By.xpath(".//td[@class='sidebar']/a[contains(@id,'lnkEstPO')]"));
				String estPOValue = estPOElement.getText().trim();

				if (!estPOValue.isEmpty()) {
					WebElement checkbox = row.findElement(By.xpath(".//input[contains(@id,'chkItem')]"));
					if (!checkbox.isSelected()) {
						checkbox.click();
						log.info("Selected checkbox for row with Est. PO value: " + estPOValue);
					}
				}
			} catch (NoSuchElementException e) {
				log.warn("Skipping a row without Est. PO or checkbox.");
			}
		}

		// Click the Create PO button after selecting relevant checkboxes
		createPObtn(); // Reuse your existing method
	}
	
	public void getOfficeAddress() {
		log.info("Clicked on Office address hyperlink");
		clickElement(JobPageObjects.costEstimatePage.OfficeAddress, "Clicked on Office Address");
	}
	
	public void getClientAddress() {
		log.info("Clicked on Client address hyperlink");
		clickElement(JobPageObjects.costEstimatePage.clientAddress, "Clicked on Client Address");
	}
	
	public void saveAsDraft() throws InterruptedException {
		log.info("Clicked on Draft button");
		Thread.sleep(10000);
		clickElement(JobPageObjects.costEstimatePage.saveAsDraft, "Clicked on Save as Draft on PO page");
		
	}
	
	public void clickEmailForApproval() {
		log.info("Clicked on E-mail for Approval");
		clickElement(JobPageObjects.clientPO.emailForApproval, "E-mail for Approval");
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
		} else {
			log.info("No alert");
			//clickElement(JobPageObjects.clientPO.emailForApproval, "E-mail for Approval");
		}
	}
	
	public void redirectToJobFromClientPO() {
		log.info("Clicked on job no hyperlink");
		clickElement(JobPageObjects.clientPO.redirectToJOB, "Backed to view Estimate page");
	}
	
	
	
	
}
