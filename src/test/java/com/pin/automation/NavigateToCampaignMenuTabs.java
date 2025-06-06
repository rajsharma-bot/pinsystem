package com.pin.automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pin.automation.utils.ObjectReader;

public class NavigateToCampaignMenuTabs extends TestBase {

	private static Logger log = LogManager.getLogger(NavigateToCampaignMenuTabs.class);

	@Test(description = "Navigation To List Campaign All Tabs", priority =0)
	public void NavigationToListCampaignAllTabs() throws IOException, InterruptedException {
		String env = System.getProperty("env", "pi2");  // Default to pi2 if not set
        LoginClass lc = new LoginClass(driver, env);
        log.info("Login runner has been invoked for env: " + env);
		lc.loginRunner();
		HomeNavigationObjects.MEDIA();
		Assert.assertEquals(true, HomeNavigationObjects.MEDIA(ObjectReader.reader.MEDIA()));
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		MenuObjects.ListCampaign_page();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		MenuObjects.CampaignBuyingTab();
		MenuObjects.CampaignPlanningTab();
		MenuObjects.CampaignReadyToBillTab();
		MenuObjects.CampaignCancelTab();
		MenuObjects.CampaignCloseTab();
		FrameHelper.switchTodefault();

	}

	@Test(dependsOnMethods = "NavigationToListCampaignAllTabs", description = "Navigation To List Schedule All Tabs")
	public void navigateToListScheduleTab() {
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		MenuObjects.ListSchedule_page();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		MenuObjects.Schedule_ConfirmedTab();;
		MenuObjects.Schedule_RevisionTab();
		MenuObjects.Schedule_CancelledTab();
		MenuObjects.Schedule_PendingTab();
		FrameHelper.switchTodefault();

	}
	
	
	@Test(dependsOnMethods = "navigateToListScheduleTab", description = "Navigation To List MenuObjects All Tabs")
	public void navigateTo_ListMO() {
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		MenuObjects.ListMO_page();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		MenuObjects.Cancelled_MOTab();
		MenuObjects.Confirmed_MOTab();
		MenuObjects.Pending_MOTab();
	}

	@Test(dependsOnMethods = "navigateTo_ListMO", description = "Navigation To List MenuObjects All Tabs")
	public void navigateTo_ListAA() {
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		MenuObjects.listAA();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		DropDownHelper.selectUsingVisibleText(MenuObjects.AA_ALL(), "ALL");
		MenuObjects.Find_ALL();
		MenuObjects.AA_Label();
		
		
	}
	
}
