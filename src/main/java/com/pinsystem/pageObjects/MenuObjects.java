package com.pinsystem.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MenuObjects {
	
	private static Logger log = LogManager.getLogger(MenuObjects.class);
	
	WebDriver driver;
	
	public MenuObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ClickMenu() {
		driver.findElement(MenuPageObjects.module).click();
	}
	
	public void ListCampaign_page() {
		driver.findElement(MenuPageObjects.ListCampaign).click();
	}
	
	public void List_BuyingCampaign() {
		driver.findElement(MenuPageObjects.BuyingCampaignList).click();
	}

	public void openingRecord() {
		driver.findElement(MenuPageObjects.recordOpen).click();
	}
	
	public boolean campaignCode(String campaignCode) {
		String CampaignNumber =driver.findElement(MenuPageObjects.CampaignCode).getText();
		
		if(campaignCode == CampaignNumber) {
			log.info("Both Campaign code matches");
			return true;
		}else 
		log.info(" Campaign code doesn't matches");
		return false;
		
		
	}
}
