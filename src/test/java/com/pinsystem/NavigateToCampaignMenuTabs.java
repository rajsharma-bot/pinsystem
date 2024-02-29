package com.pinsystem;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.HomeNavigationObjects;
import com.pinsystem.pageObjects.LoginObjects;
import com.pinsystem.pageObjects.MenuObjects;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.WaitHelper;

public class NavigateToCampaignMenuTabs extends TestBase {

	private static Logger log = LogManager.getLogger(NavigateToCampaignMenuTabs.class);

	@Test(description = "Navigation To List Campaign All Tabs")
	public void NavigationToListCampaignAllTabs() throws IOException, InterruptedException {
//		String CampaignNo = "B004/EIRW/2400010";
		FileReader reader = new FileReader("src/main/resources/configfile/config.properties");
		Properties props = new Properties();
		props.load(reader);
		LoginObjects lg = new LoginObjects(driver);
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		HomeNavigationObjects HN= new HomeNavigationObjects(driver);
		lg.login(props.getProperty("username"), props.getProperty("password"));
		lg.submit();
		fh.switchToFrame(props.getProperty("topframe"));
		HN.MEDIA();
		HN.MEDIA(props.getProperty("MEDIA"));
		fh.switchTodefault();
		fh.switchToFrame(props.getProperty("leftframe"));
		Mo.ListCampaign_page();
		fh.switchTodefault();
		fh.switchToFrame(props.getProperty("rightframe"));
		Mo.List_BuyingCampaign();
	}
	
	@Test
	public void navigateToPlanningTab() {
		
	}

}
