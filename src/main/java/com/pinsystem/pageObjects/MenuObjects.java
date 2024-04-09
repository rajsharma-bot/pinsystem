package com.pinsystem.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuObjects {

	private static Logger log = LogManager.getLogger(MenuObjects.class);

	WebDriver driver;

	public MenuObjects(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Element for List Campaign
	 */

	public void ListCampaign_page() {
		driver.findElement(MenuPageObjects.ListCampaign).click();
	}

	public void PlanningTab() {
		log.info("Switched to Planning Tab");
		driver.findElement(MenuPageObjects.PLANNING_TAB).click();
	}

	public void BuyingTab() {
		log.info("Switched to Buying Tab");
		driver.findElement(MenuPageObjects.BUYING_TAB).click();
	}

	public void ReadyToBillTab() {
		log.info("Switched to Ready To Bill Tab");
		driver.findElement(MenuPageObjects.READYTOBILL_TAB).click();
	}

	public void CloseTab() {
		log.info("Switched to Close Tab");
		driver.findElement(MenuPageObjects.CLOSE_TAB).click();
	}

	public void CancelTab() {
		log.info("Switched to Cancel Tab");
		driver.findElement(MenuPageObjects.CANCEL_TAB).click();
	}

	/**
	 * Element for List Schedule
	 */

	public void ListSchedule_page() {
		log.info("List Schedule has been clicked");
		driver.findElement(MenuPageObjects.ListSchedule).click();
	}

	public void ConfirmedS_Tab() {
		log.info("Switched to Confirmed Tab");
		driver.findElement(MenuPageObjects.Confirmed_Tab).click();
	}

	public void PendingS_Tab() {
		log.info("Switched to Pending Tab");
		driver.findElement(MenuPageObjects.Pending_Tab).click();
	}

	public void CancelledS_Tab() {
		log.info("Switched to Cancelled Tab");
		driver.findElement(MenuPageObjects.Cancelled_Tab).click();
	}

	public void RevisionS_Tab() {
		log.info("Switched to Revision Tab");
		driver.findElement(MenuPageObjects.Revision_Tab).click();
	}

	/**
	 * Element for List MO
	 */

	public void ListMO_page() {
		log.info("List MO has been Clicked");
		driver.findElement(MenuPageObjects.ListMO).click();
	}

	public void ConfirmedMO_Tab() {
		log.info("Switched to Confirm MO Tab");
		driver.findElement(MenuPageObjects.ConfirmedMO_Tab).click();
	}

	public void PendingMO_Tab() {
		log.info("Switched to Pending MO Tab");
		driver.findElement(MenuPageObjects.PendingMO_Tab).click();
	}

	public void CancelledMO_Tab() {
		log.info("Switched to Cancelled MO Tab");
		driver.findElement(MenuPageObjects.CancelledMO_Tab).click();
	}

	/**
	 * @category= Search Schedule Page
	 * 
	 * @return
	 */

	public WebElement monthDll() {
		WebElement dropDownMonth = driver.findElement(MenuPageObjects.monthDll);
		return dropDownMonth;

	}

	public WebElement yearDll() {
		WebElement dropDownYear = driver.findElement(MenuPageObjects.yearDll);
		return dropDownYear;

	}

	public void searchSchedule(String ScheduleNo) {
		log.info("Clicked on free text");
		driver.findElement(MenuPageObjects.searchText).click();
		log.info("Passing shedule no");
		driver.findElement(MenuPageObjects.searchText).sendKeys(ScheduleNo);
		log.info("Schedule no is passed");
	}

	public void findButton() {
		log.info("Clicked  on find button");
		driver.findElement(MenuPageObjects.findButton).click();

	}

	public void clickOnRecord() {
		driver.findElement(MenuPageObjects.SearchSchedule).click();
		log.info("Clicked on searched record");
	}

	public boolean tabText() {
		boolean d = driver.findElement(MenuPageObjects.SearchSchedule).isDisplayed();
		log.info(d);
		return d;
	}

	// --------------------------Test Code-------------------------------

	public String labelText() {
		String labelText = driver.findElement(MenuPageObjects.lableText).getText();
		return labelText;
	}

	/**
	 * New Campaign
	 * 
	 */

	public void newCampaign() {
		log.info("New Campaign has been clicked");
		driver.findElement(MenuPageObjects.NewCampaign).click();
	}

	public WebElement clientDDL() throws InterruptedException {
		WebElement DDL_Client = driver.findElement(MenuPageObjects.ClientDDL);
		Thread.sleep(1000);
		return DDL_Client;

	}

	public WebElement soldToParty() throws InterruptedException {
		Thread.sleep(1000);
		WebElement DDL_STP = driver.findElement(MenuPageObjects.SoldToParty);
		return DDL_STP;

	}

	public void StartDate() {
		driver.findElement(MenuPageObjects.StartDate).clear();
		driver.switchTo().alert().accept();
	}

	public void StartDate(String startdate) throws InterruptedException {
		Thread.sleep(1000);
		
		driver.findElement(MenuPageObjects.StartDate).sendKeys(startdate);
		
		
	}

	public void EndDate() {
		driver.findElement(MenuPageObjects.EndDate).clear();
		driver.switchTo().alert().accept();

	}

	public void EndDate(String EndDate) throws InterruptedException {
		Thread.sleep(1000);
		
		driver.findElement(MenuPageObjects.EndDate).sendKeys(EndDate);
		
	}

	public WebElement Product() throws InterruptedException {
		Thread.sleep(1000);
		WebElement DDL_Product = driver.findElement(MenuPageObjects.ProductDDL);
		return DDL_Product;

	}

	public WebElement Contract() throws InterruptedException {
		Thread.sleep(1000);
		WebElement ddl_Contract = driver.findElement(MenuPageObjects.ContractDDL);
		return ddl_Contract;

	}

	public void CampaignName(String campaignName) {
		driver.findElement(MenuPageObjects.Campaign_name).sendKeys(campaignName);
	}

	public void Save() {
		driver.findElement(MenuPageObjects.SaveOnlyAndViewCampaign).click();
		if(driver.switchTo().alert()!=null) {
			driver.switchTo().alert().accept();
		}else {
			System.out.println("No alert");
		}
	}

	
	public WebElement mediaType() throws InterruptedException {
		Thread.sleep(2000);
		WebElement ddl_mediaType = driver.findElement(MenuPageObjects.MediaType);
		return ddl_mediaType;
	}
	
	public void searchTitle(String media_title) throws InterruptedException {
		driver.findElement(MenuPageObjects.Search_MediaTitle).clear();
		driver.findElement(MenuPageObjects.Search_MediaTitle).sendKeys(media_title);
		Thread.sleep(3000);
	}
	
	public boolean checkBox() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(MenuPageObjects.checkBox).click();
		if(driver.findElement(MenuPageObjects.checkBox).isDisplayed()) {
			System.out.println("true");
			return true;
		}
		return false;
	}
	
	public void campaignCode() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		Boolean value= driver.findElement(MenuPageObjects.CampaignCode).isDisplayed();
		if(value==true) {
			log.info("Campaign has been created");
			log.info(driver.findElement(MenuPageObjects.CampaignCode).getText());
		}else {
			log.error("Campaign is not created");
		}
		
	}
	
}
