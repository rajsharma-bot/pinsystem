package com.pinsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.HomeNavigationObjects;
import com.pinsystem.pageObjects.MenuObjects;
import com.pinsystem.utils.DropDownHelper;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;
import com.pinsystem.utils.SwitchTabs;

public class SearchRecords extends TestBase {

	private static Logger log = LogManager.getLogger(SearchRecords.class);

	@Test(description = "Search Schedule")
	public void searchSchedule() throws InterruptedException {
		LoginClass lc = new LoginClass(driver);
		log.info("Runner has been invoked");
		lc.loginRunner();
		FrameHelper.switchToFrame(ObjectReader.reader.topframe());
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
