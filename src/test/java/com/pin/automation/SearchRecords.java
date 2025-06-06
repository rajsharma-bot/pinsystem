package com.pin.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pin.automation.TestBase;
import com.pin.automation.utils.ObjectReader;

public class SearchRecords extends TestBase {

	private static Logger log = LogManager.getLogger(SearchRecords.class);

	@Test(description = "Search Schedule")
	public void searchSchedule() throws InterruptedException {
		String env = System.getProperty("env", "pi2");  // Default to pi2 if not set
        LoginClass lc = new LoginClass(driver, env);
        log.info("Login runner has been invoked for env: " + env);
		lc.loginRunner();
		HomeNavigationObjects.MEDIA();
		log.info("Media has been cliked");
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		MenuObjects.ListSchedule_page();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		DropDownHelper.selectUsingVisibleText(MenuObjects.monthDll(), "ALL");
		DropDownHelper.selectUsingVisibleText(MenuObjects.yearDll(), "2024");
		MenuObjects.searchSchedule("TEST123EIRW/TV/2400090");
		MenuObjects.findButton();
		SwitchTabs.schedule_search();
	}
}
