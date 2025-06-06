package com.pin.automation.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pin.automation.pageObjects.MenuPageObjects;

public class PopupHandler {

	public static void closeEditMediaOrderPopups(WebDriver driver, Logger log) {
        try {
            if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed()) {
                driver.findElement(MenuPageObjects.Close_media_schedule).click();
                log.info("Main pop-up closed");

                if (driver.findElement(MenuPageObjects.nestedMediaOrder_popup).isDisplayed()) {
                    driver.findElement(MenuPageObjects.nestedMediaOrder_popup_closed).click();
                    log.info("Nested pop-up closed");
                } else {
                    log.info("Nested pop-up was not displayed");
                }
            } else {
                log.info("Edit Media Order pop-up was not displayed");
            }
        } catch (Exception e) {
            log.warn("Exception while closing pop-ups: " + e.getMessage());
        }
    }
}
