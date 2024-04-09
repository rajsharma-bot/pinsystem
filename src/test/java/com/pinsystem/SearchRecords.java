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
		ObjectReader.reader = new PropertyReader();
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		SwitchTabs st= new SwitchTabs(driver);
		HomeNavigationObjects HN = new HomeNavigationObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		LoginClass lc = new LoginClass(driver);
		lc.loginRunner();
		fh.switchToFrame(ObjectReader.reader.topframe());
		HN.MEDIA();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.leftframe());
		Mo.ListSchedule_page();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		dh.selectUsingVisibleText(Mo.monthDll(), "ALL");
		dh.selectUsingVisibleText(Mo.yearDll(), "2024");
		Mo.searchSchedule("TEST123EIRW/TV/2400090");
		Mo.findButton();
		st.schedule_search();
	}
}
