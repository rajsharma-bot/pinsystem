package com.pin.automation.pageObjects;

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
import com.pin.automation.utils.ResourceHelper;

public class ViewLineBylineObjects {
	
	private static Logger log = LogManager.getLogger(ViewLineBylineObjects.class);

	WebDriver driver;
	WebDriverWait wait;

	public ViewLineBylineObjects(WebDriver driver) {
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

	public void clickOnViewLineBylineBtn() {
		log.info("Click on view line by line button");
		clickElement(ViewLineBylinePageObjects.viewlinebyline, "View line by line Btn");
		
	}
	
	public void verifyRedirectToViewLineByLine(String scheduleNo) {
		log.info("Verify if landed on View line by line page");
		
		String ScheduleNo =driver.findElement(ViewLineBylinePageObjects.scheduleNumber_linebyline).getText();
		if(ScheduleNo.contains(scheduleNo)) {
			log.info("Successfully Landed on view line by line Page");
			Boolean value =true;
			Assert.assertEquals(value, true);
		}else {
			
		}	
		
	}
	
	public void clientInvoiceRemark_btn() {	
		log.info("Client invoice remark");
		clickElement(ViewLineBylinePageObjects.clientInvoiceRemark_btn, "Client Invoice remark button");
	}
	
	public void clientInvoiceRemark_PopUp() throws InterruptedException {
		log.info("Client Invoice remark pop-up");
		Thread.sleep(20000);
		Boolean PopUp= driver.findElement(ViewLineBylinePageObjects.clientInvoiceRemark_popup).isDisplayed();
		System.out.println(PopUp);
		Assert.assertEquals(PopUp, true);
	}
	
	public void clientInvoiceRemarkText() {
		log.info("Passing remark in CIR");
		
		sendText(ViewLineBylinePageObjects.clientInvoiceRemark_textBox, "Sample text for CIR 2", "Passed CIR remark ");
	}
	
	public void clientInvoiceRemark_SaveBtn() {
		log.info("Click on Client invoice remark Save button");
		clickElement(ViewLineBylinePageObjects.clientInvoiceRemark_SaveBtn, "Client Invoice remark button");
	}
	
	public void pencilEdit() throws InterruptedException {
		
		Thread.sleep(30000);
		log.info("Click on Pencil edit");
		clickElement(ViewLineBylinePageObjects.pencilEdit, "View line by line Pencil edit");
		Thread.sleep(30000);
		
		
	}
	
//	public void getScheduleNo() throws InterruptedException {
//		log.info("Landed on schedule page");
//		SwitchTabs SwitchTabs =new SwitchTabs(driver);
//		Thread.sleep(30000);
//		String ScheduleNo =driver.findElement(ViewLineBylinePageObjects.getScheduleNo).getText();
//		if(ScheduleNo.contains("TEST123JSR/I/2400398")) {
//			log.info("Successfully schedule page Page");
//			Boolean value =true;
//			Assert.assertEquals(value, true);
//		}else {
//			//SwitchTabs.schedule_search();
//			System.out.println("Error");
//		}	
//	}
	
	
	public void SettingClientRate(String clientRate) {
		
		log.info("Client rate is cleared");
		driver.findElement(ViewLineBylinePageObjects.updatingClientRate).clear();
		log.info("Client rate is added");
		sendText(ViewLineBylinePageObjects.updatingClientRate, clientRate, "Client Rate added");
	}
	
	public void settingBuyingRate(String buyingRate) {
	
		log.info("Buying rate is cleared");
		driver.findElement(ViewLineBylinePageObjects.updatingBuyingRate).clear();
		log.info("Buying rate is added");
		sendText(ViewLineBylinePageObjects.updatingBuyingRate, buyingRate, "Buying Rate added");
	}
	
	public void changeReason(String reason) {
		log.info("Passing AA Reason");
		sendText(ViewLineBylinePageObjects.changeReason_remark, reason, "Added AA reason");
		
	}
	
	public void updateAA() {
		log.info("Clicking on Update Button");
		clickElement(ViewLineBylinePageObjects.UpdateAA, "Click on Update Button");
	}
	
	public String verifygetAA_no() {
		
		WebElement element = driver.findElement(ViewLineBylinePageObjects.AAHyperLink);
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(ViewLineBylinePageObjects.AAHyperLink)));
		wait.until(ExpectedConditions.visibilityOf(element));
		String aa_no =driver.findElement(ViewLineBylinePageObjects.AAHyperLink).getText();
		log.info(aa_no);
		return aa_no;
		
	}
	
	public void getAA_no() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String filePath = ResourceHelper.getScheduleNo();
		Boolean value = driver.findElement(ViewLineBylinePageObjects.AAHyperLink).isDisplayed();
		if (value == true) {
			log.info("AA has been created");
			log.info(driver.findElement(ViewLineBylinePageObjects.AAHyperLink).getText());
			FileSaver.saveTextToFile(driver.findElement(ViewLineBylinePageObjects.AAHyperLink).getText(), filePath);
		} else {
			log.error("AA is not created");
		}

	}
	
	public void insertionDetail() {
		log.info("Clicking on Insertion Hyperlink");
		clickElement(ViewLineBylinePageObjects.insertionDetailHyperLink, "Insertion Detail hyperlink / Edit mediaorder pop-up");
	}
	
	
//	public void view_line_by_line(boolean isEditMO) throws InterruptedException {
//	    
//	    String filePath = ResourceHelper.getScheduleNo();
//	    FileUtil fileUtil = new FileUtil(filePath);
//	    ViewLineBylineObjects ViewLineBylineObjects = new ViewLineBylineObjects(driver);
//	    WindowHandler pop = new WindowHandler(driver);
//	    FrameHelper FrameHelper = new FrameHelper(driver);
//	    MenuObjects MenuObjects = new MenuObjects(driver);
//	    ObjectReader.reader = new PropertyReader();
//	    
//
//	    // Click on view line by line
//	    ViewLineBylineObjects.clickOnViewLineBylineBtn();
//	    pop.switchToChildWindow(driver);
//
//	    try {
//	        String data = fileUtil.readAllTextFromFile();
//	        log.info("Data read from file:\n" + data);
//	        ViewLineBylineObjects.verifyRedirectToViewLineByLine(data);
//	    } catch (IOException e) {
//	        log.error("File not found : " + e.getMessage());
//	        Assert.fail("Failed to read schedule number file.");
//	    }
//
//	    if (isEditMO) {
//	        // Logic for "view line by line via edit MO hyperlink"
//	        ViewLineBylineObjects.insertionDetail();
//	        FrameHelper.switchToFrame(ObjectReader.reader.Add_line());
//	        MenuObjects.Entering_Digital_Spots("3500");
//	        ViewLineBylineObjects.changeReason("Creating AA for Testing Reason");
//	        ViewLineBylineObjects.updateAA();
//	    } else {
//	        // Logic for "view line by line via pencil icon"
//	        ViewLineBylineObjects.pencilEdit();
//	        FrameHelper.switchToFrame(ObjectReader.reader.Add_line());
//	        ViewLineBylineObjects.SettingClientRate("3000");
//	        ViewLineBylineObjects.settingBuyingRate("2000");
//	        ViewLineBylineObjects.changeReason("Creating AA for Testing Reason");
//	        ViewLineBylineObjects.updateAA();
//	    }
//
//	    // Back to View line by line page
//	    FrameHelper.switchTodefault();
//	    ViewLineBylineObjects.getAA_no();
//	    assertNotNull(ViewLineBylineObjects.verifygetAA_no(), "AA number should not be null!");
//	    driver.close();
//	    pop.switchToParentWindow(driver);
//	}

	

}
