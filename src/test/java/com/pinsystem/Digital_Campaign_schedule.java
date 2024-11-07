package com.pinsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.HomeNavigationObjects;
import com.pinsystem.pageObjects.MenuObjects;
import com.pinsystem.pageObjects.MixMediaSchedule;
import com.pinsystem.pageObjects.ScheduleObjects;
import com.pinsystem.utils.DropDownHelper;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;
import com.pinsystem.utils.WaitHelper;

public class Digital_Campaign_schedule extends TestBase {

	private static Logger log = LogManager.getLogger(Digital_Campaign_schedule.class);
	
	@Test(description = "Digital Campaign")
	public void digital_campaign() throws InterruptedException {
		
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
		MenuObjects.StartDate("01/01/2024");
		MenuObjects.EndDate("31/03/2024");
		DropDownHelper.selectUsingValue(MenuObjects.Product(), "11491");
		DropDownHelper.selectUsingValue(MenuObjects.Contract(), "1047");
		MenuObjects.CampaignName("Sample digital record");
		MixMediaSchedule.digital_media();
		MenuObjects.Save();
		MenuObjects.campaignCode();
	}
	
	
	@Test(dependsOnMethods  = "digital_campaign", description = "Digital Schedule")
	public void new_Schedule() throws InterruptedException {
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		MenuObjects.new_schedule();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		MixMediaSchedule.selectVendorCurreny();
		MixMediaSchedule.digital_vendor();
		Thread.sleep(30000);
		MenuObjects.Schedule_Grid();
		MenuObjects.editMedia_popUp();
		MixMediaSchedule.digital_placement();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		ScheduleObjects.confirm_schedule();
		ScheduleObjects.Create_MO_By_Vendor();
		WaitHelper.waitForElementVisibility(ScheduleObjects.MO_number(), 30);
		ScheduleObjects.Select_checkBox();
		Thread.sleep(30000);
		ScheduleObjects.Confirm_mo();
		ScheduleObjects.MO_status();
		
}
}
