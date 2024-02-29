package com.pinsystem;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.HomeNavigationObjects;
import com.pinsystem.pageObjects.LoginObjects;
import com.pinsystem.pageObjects.MenuObjects;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;

public class NavigateToCampaignMenuTabs extends TestBase {

	private static Logger log = LogManager.getLogger(NavigateToCampaignMenuTabs.class);

	@Test(description = "Navigation To List Campaign All Tabs")
	public void NavigationToListCampaignAllTabs() throws IOException, InterruptedException {

		ObjectReader.reader = new PropertyReader();
		LoginObjects lg = new LoginObjects(driver);
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		HomeNavigationObjects HN = new HomeNavigationObjects(driver);
		lg.login(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		lg.submit();
		fh.switchToFrame(ObjectReader.reader.topframe());
		HN.MEDIA();
		Assert.assertEquals(true, HN.MEDIA(ObjectReader.reader.MEDIA()));
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.leftframe());
		Mo.ListCampaign_page();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Mo.BuyingTab();
		Mo.PlanningTab();
		Mo.ReadyToBillTab();
		Mo.CancelTab();
		Mo.CloseTab();
		fh.switchTodefault();

	}

	@Test(dependsOnMethods = "NavigationToListCampaignAllTabs", description = "Navigation To List Schedule All Tabs")
	public void navigateToListScheduleTab() {
		ObjectReader.reader = new PropertyReader();
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		fh.switchToFrame(ObjectReader.reader.leftframe());
		Mo.ListSchedule_page();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Mo.ConfirmedS_Tab();
		Mo.RevisionS_Tab();
		Mo.CancelledS_Tab();
		Mo.PendingS_Tab();
		
	}

	
	@Test(dependsOnMethods = "navigateToListScheduleTab", description = "Navigation To List MO All Tabs")
	public void navigateToListAA() {
		//code
	}
	
	@Test(dependsOnMethods = "navigateToListScheduleTab", description = "Navigation To List MO All Tabs", priority = 2)
	public void searchSchedule() {
		//code
	}
}
