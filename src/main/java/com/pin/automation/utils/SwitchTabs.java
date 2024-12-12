package com.pin.automation.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pin.automation.pageObjects.MenuObjects;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class SwitchTabs {

	private static Logger log = LogManager.getLogger(SwitchTabs.class);

	WebDriver driver;
	WebDriverWait wait;

	public SwitchTabs(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void schedule_search() throws InterruptedException {
		MenuObjects Mo = new MenuObjects(driver);

		// Map of tab actions with log messages for each tab
		Map<String, Consumer<MenuObjects>> tabs = new LinkedHashMap<>();
		tabs.put("Pending Tab", MenuObjects::Schedule_PendingTab);
		tabs.put("Confirmed Tab", MenuObjects::Schedule_ConfirmedTab);
		tabs.put("Revision Tab", MenuObjects::Schedule_RevisionTab);
		tabs.put("Cancelled Tab", MenuObjects::Schedule_CancelledTab);

		// Iterate over each tab
		for (Map.Entry<String, Consumer<MenuObjects>> entry : tabs.entrySet()) {
			entry.getValue().accept(Mo); // Call the method to navigate to the tab
			Thread.sleep(20000); // Pause for 20 seconds

			// Check if the label text contains "1"
			if (Mo.labelText().contains("1")) {
				log.info("In " + entry.getKey());
				Mo.clickOnRecord();
				return; // Exit method once a record is found and clicked
			}
		}

	}
}
