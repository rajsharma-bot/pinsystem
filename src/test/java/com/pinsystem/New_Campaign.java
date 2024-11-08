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

		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		LoginClass lc = new LoginClass(driver);
		log.info("Login runner has been invoked");
		lc.loginRunner();
		FrameHelper.switchToFrame(ObjectReader.reader.topframe());
		HomeNavigationObjects.MEDIA();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		MenuObjects.newCampaign();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		DropDownHelper.selectUsingVisibleText(MenuObjects.clientDDL(), "1001 MEDIA SDN BHD | DUO1 MYR");
		DropDownHelper.selectUsingValue(MenuObjects.soldToParty(), "50222");
		//Mo.StartDate();
		MenuObjects.StartDate("01/01/2024");
		//Mo.EndDate();
		MenuObjects.EndDate("31/01/2024");
		DropDownHelper.selectUsingValue(MenuObjects.Product(), "11491");
		DropDownHelper.selectUsingValue(MenuObjects.Contract(), "1047");
		MenuObjects.CampaignName("For Testing");
		MixMediaSchedule.selectMultipleMediaTypes();
		MenuObjects.Save();
		MenuObjects.campaignCode();
	}

	@Test(dependsOnMethods = "new_Campaign", description = "PINSYS-1813:: New Schedule(New layout)")
	public void new_Schedule() throws InterruptedException {
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		MenuObjects.new_schedule();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		MixMediaSchedule.selectVendorCurreny();
		Thread.sleep(1000);
		MixMediaSchedule.selecMultipleVendors();
		Thread.sleep(1000);
		MenuObjects.Schedule_Grid();
		Thread.sleep(1000);
		MenuObjects.editMedia_popUp();
		FrameHelper.switchToFrame(ObjectReader.reader.pop_up_frame());
		MenuObjects.select_media_layout();
		FrameHelper.switchTodefault();
		Thread.sleep(1000);
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		MixMediaSchedule.cinema_placement(); // Cinema_line added correctly
		//mx.Magazine();
		//mx.Newspaper();

	}

}
