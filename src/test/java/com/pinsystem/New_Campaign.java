package com.pinsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.HomeNavigationObjects;
import com.pinsystem.pageObjects.MenuObjects;
import com.pinsystem.pageObjects.MixMediaSchedule;
import com.pinsystem.utils.DropDownHelper;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;
import com.pinsystem.utils.WaitHelper;

public class New_Campaign extends TestBase {

	private static Logger log = LogManager.getLogger(New_Campaign.class);

	@Test(description = "PINSYS-1808-New Campaign")
	public void new_Campaign() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		WaitHelper wh = new WaitHelper(driver);
		HomeNavigationObjects HN = new HomeNavigationObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		MixMediaSchedule mx = new MixMediaSchedule(driver);
		wh.setImplicitWait(ObjectReader.reader.getExplicitWait());
		LoginClass lc = new LoginClass(driver);
		log.info("Login runner has been invoked");
		lc.loginRunner();
		fh.switchToFrame(ObjectReader.reader.topframe());
		HN.MEDIA();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.leftframe());
		Mo.newCampaign();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		dh.selectUsingVisibleText(Mo.clientDDL(), "1001 MEDIA SDN BHD | DUO1 MYR");
		dh.selectUsingValue(Mo.soldToParty(), "50222");
		Mo.StartDate();
		Mo.StartDate("01/01/2024");
		Mo.EndDate();
		Mo.EndDate("31/01/2024");
		dh.selectUsingValue(Mo.Product(), "11491");
		dh.selectUsingValue(Mo.Contract(), "1047");
		// Mo.CampaignName("PINSYS-1808-New Campaign-Auto");
		Mo.CampaignName("For Testing");
		mx.selectMultipleMediaTypes();
		Mo.Save();
		Mo.campaignCode();
	}

	@Test(dependsOnMethods = "new_Campaign", description = "PINSYS-1813:: New Schedule(New layout)")
	public void new_Schedule() throws InterruptedException {
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		//DropDownHelper dh = new DropDownHelper(driver);
		MixMediaSchedule mx = new MixMediaSchedule(driver);
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Mo.new_schedule();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		mx.selectVendorCurreny();
		Thread.sleep(1000);
		mx.selecMultipleVendors();
		Thread.sleep(1000);
		Mo.Schedule_Grid();
		Thread.sleep(1000);
		Mo.editMedia_popUp();
		fh.switchToFrame(ObjectReader.reader.pop_up_frame());
		Mo.select_media_layout();
		fh.switchTodefault();
		Thread.sleep(1000);
		fh.switchToFrame(ObjectReader.reader.rightframe());
		mx.cinema_placement(); // Cinema_line added correctly
		//mx.Magazine();
		//mx.Newspaper();

	}

}
