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
		Mo.EndDate("31/03/2024");
		dh.selectUsingValue(Mo.Product(), "11491");
		dh.selectUsingValue(Mo.Contract(), "1047");
		Mo.CampaignName("Sample digital record");
		mx.digital_media();
		Mo.Save();
		Mo.campaignCode();
	}
	
	
	@Test(dependsOnMethods = "digital_campaign", description = "Digital Schedule")
	public void new_Schedule() throws InterruptedException {
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		WaitHelper w=  new WaitHelper(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		MixMediaSchedule mx = new MixMediaSchedule(driver);
		ScheduleObjects so= new ScheduleObjects(driver);
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Mo.new_schedule();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		mx.selectVendorCurreny();
		mx.digital_vendor();
		Thread.sleep(30000);
		Mo.Schedule_Grid();
		Mo.editMedia_popUp();
		mx.digital_placement();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		so.confirm_schedule();
		so.Create_MO_By_Vendor();
		w.waitForElementVisibility(so.MO_number(), 30);
		so.Select_checkBox();
		Thread.sleep(30000);
		so.Confirm_mo();
		so.MO_status();
		
}
}
