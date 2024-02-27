package com.pinsystem;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.LoginObjects;
import com.pinsystem.pageObjects.MenuObjects;
import com.pinsystem.utils.FrameHelper;

public class Menu extends TestBase4 {
	
	private static Logger log = LogManager.getLogger(Menu.class);
	
	@Test
	public void listBuyingCampaign() throws IOException, InterruptedException {
		String CampaignNo= "B004/EIRW/2400010";
		FileReader reader = new FileReader("src/main/resources/configfile/config.properties");
		Properties props = new Properties();
		props.load(reader);
		LoginObjects lg = new LoginObjects(driver);
		FrameHelper fh= new FrameHelper(driver);
		MenuObjects Mo =new MenuObjects(driver);
		log.info("Broswer has been invoked");
		Thread.sleep(3000);
		lg.login(props.getProperty("username"), props.getProperty("password"));
		lg.submit();
		log.info("Clicked on submit");
		Thread.sleep(3000);
		fh.switchToFrame(props.getProperty("topframe"));
		log.info("Frame has been switched to TOP frame");
		Mo.ClickMenu();
		fh.switchTodefault();
		fh.switchToFrame(props.getProperty("leftframe"));
		log.info("Frame has been switched to Left frame");
		Mo.ListCampaign_page();
		fh.switchTodefault();
		fh.switchToFrame(props.getProperty("rightframe"));
		log.info("Frame has been switched to Right frame");
		Mo.List_BuyingCampaign();
		Mo.openingRecord();
		Mo.campaignCode(CampaignNo);

		
		
		
		
		
		
		
		
	}

}
