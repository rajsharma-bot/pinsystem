package com.pinsystem.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScheduleObjects {
	
	private static Logger log = LogManager.getLogger(ScheduleObjects.class);

	WebDriver driver;
	public  ScheduleObjects(WebDriver driver) {
		this.driver= driver;
	}
	
	public void confirm_schedule() throws InterruptedException {
		Thread.sleep(30000);
		driver.findElement(SchedulePageObjects.confirm_schedule).click();
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
		} else {
			log.info("No alert");
			driver.findElement(SchedulePageObjects.confirm_schedule).click();
		}
		log.info("Schedule confirm button has been clicked");
		Thread.sleep(30000);
		if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.Close_media_schedule).click();
			log.info(true);
			log.info("Pop-up is closed");
		} else {
			log.info("Edit Pop has been ignored");
		}
	}
	
	public void Create_MO_By_Vendor() throws InterruptedException {
		driver.findElement(SchedulePageObjects.Create_MO_By_Vendor).click();
		driver.switchTo().alert().accept();
		log.info("Create Mo by vendor button has been clicked");
		Thread.sleep(30000);
		if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.Close_media_schedule).click();
			log.info(true);
			log.info("Pop-up is closed");
		} else {
			log.info("Edit Pop has been ignored");
		}
		
	}
	
	public WebElement MO_number() {
		WebElement MO =driver.findElement(SchedulePageObjects.MO_created);
		log.info("MO number can be seen");
		return MO;
	}
	
	public void Select_checkBox() {
		log.info("Clicked on Select All checkbox ");
		driver.findElement(SchedulePageObjects.confirm_mo_checkBox).click();
		Boolean isSelected= driver.findElement(SchedulePageObjects.confirm_mo_checkBox).isSelected();
		log.info(isSelected);
		
	}
	
	public void Confirm_mo() throws InterruptedException {
		driver.findElement(SchedulePageObjects.Confirm_mo).click();
		Thread.sleep(30000);
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
		} else {
			log.info("No alert");
			driver.findElement(SchedulePageObjects.Confirm_mo).click();
		}
		log.info("MO has been confirmed");
		
		if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.Close_media_schedule).click();
			log.info(true);
			log.info("Pop-up is closed");
		} else {
			log.info("Edit Pop has been ignored");
		}
	}
	
	
	public void MO_status() throws InterruptedException {
		Thread.sleep(30000);
		if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.Close_media_schedule).click();
			log.info(true);
			log.info("Pop-up is closed");
		} else {
			log.info("Edit Pop-up has been ignored");
		}
		
		String status = driver.findElement(SchedulePageObjects.mo_status).getText();
		if(status.equalsIgnoreCase("Confirm")){
			log.info("MO Status is : " + status);
		}
	}

}
