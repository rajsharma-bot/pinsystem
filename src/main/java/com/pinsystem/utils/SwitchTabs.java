package com.pinsystem.utils;

import org.openqa.selenium.WebDriver;

import com.pinsystem.pageObjects.MenuObjects;

public class SwitchTabs {

	WebDriver driver;

	public SwitchTabs(WebDriver driver) {
		this.driver = driver;
	}


	public void schedule_search() throws InterruptedException {
		MenuObjects Mo = new MenuObjects(driver);

		Mo.Schedule_PendingTab();
		Thread.sleep(10000);
		if (Mo.labelText().contains("1")) {
			Mo.clickOnRecord();
		} else
			Mo.Schedule_ConfirmedTab();
		Thread.sleep(2000);
		if (Mo.labelText().contains("1")) {
			Mo.clickOnRecord();
		} else
			Mo.Schedule_RevisionTab();
		Thread.sleep(2000);
		if (Mo.labelText().contains("1")) {
			Mo.clickOnRecord();
		} else
			Mo.Schedule_CancelledTab();
		Thread.sleep(2000);
		if (Mo.labelText().contains("1")) {
			Mo.clickOnRecord();
		} else {
			System.out.println("NO result found");
		}
	}

}
