package com.pinsystem.pageObjects;

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


}
