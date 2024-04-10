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
import com.pinsystem.utils.WaitHelper;

public class New_Campaign extends TestBase {

	private static Logger log = LogManager.getLogger(New_Campaign.class);

	@Test(description = "PINSYS-1808-New Campaign")
	public void new_Campaign() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		SwitchTabs st = new SwitchTabs(driver);
		WaitHelper wh = new WaitHelper(driver);
		HomeNavigationObjects HN = new HomeNavigationObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		wh.setImplicitWait(ObjectReader.reader.getExplicitWait());
		LoginClass lc = new LoginClass(driver);
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
		Mo.EndDate("30/04/2024");
		dh.selectUsingValue(Mo.Product(), "11491");
		dh.selectUsingValue(Mo.Contract(), "1047");
		Mo.CampaignName("PINSYS-1808-New Campaign");
		dh.selectUsingVisibleText(Mo.mediaType(), "Cinema");
		Mo.searchTitle("Cathay Cineplex");
		Mo.checkBox();
		dh.selectUsingVisibleText(Mo.mediaType(), "Digital");
		Mo.searchTitle("Linkedin");
		Mo.checkBox();
		Mo.Save();
		Mo.campaignCode();
	}
	
	@Test(dependsOnMethods = "new_Campaign", description = "PINSYS-1813:: New Schedule(New layout)")
	public void new_Schedule() throws InterruptedException {
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		SwitchTabs st = new SwitchTabs(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Mo.new_schedule();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		dh.selectUsingValue(Mo.Vendor1(), "124|MYR|1.0000000|1|1|15|15|0");
		Mo.fee("5");
		dh.selectUsingValue(Mo.Vendor2(), "4640|MYR|1.0000000|1|1|0|0|0");
		Mo.fee2("3.5");
		Mo.Schedule_Grid();
		
		
		
	}

}
