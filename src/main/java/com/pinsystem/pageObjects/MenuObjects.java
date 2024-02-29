package com.pinsystem.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		driver.findElement(MenuPageObjects.Confirmed_Tab).click();
	}

	public void PendingMO_Tab() {
		log.info("Switched to Pending MO Tab");
		driver.findElement(MenuPageObjects.Pending_Tab).click();
	}
	
	public void CancelledMO_Tab() {
		log.info("Switched to Cancelled MO Tab");
		driver.findElement(MenuPageObjects.Cancelled_Tab).click();
	}
	
	
	
	
	
	
	public void openingRecord() {
		driver.findElement(MenuPageObjects.recordOpen).click();
	}

	public boolean campaignCode(String campaignCode) {
		String CampaignNumber = driver.findElement(MenuPageObjects.CampaignCode).getText();

		if (campaignCode == CampaignNumber) {
			log.info("Both Campaign code matches");
			return true;
		} else
			log.info(" Campaign code doesn't matches");
		return false;

	}
}
