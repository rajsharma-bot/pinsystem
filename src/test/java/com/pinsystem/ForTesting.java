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

public class ForTesting extends TestBase {
	
	private static Logger log = LogManager.getLogger(ForTesting.class);
	
	
	@Test
	public void ForTest() throws InterruptedException {

		ObjectReader.reader = new PropertyReader();
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		WaitHelper wh = new WaitHelper(driver);
		HomeNavigationObjects HN = new HomeNavigationObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		MixMediaSchedule mx= new MixMediaSchedule(driver);
		wh.setImplicitWait(ObjectReader.reader.getExplicitWait());
		LoginClass lc = new LoginClass(driver);
		log.info("Login runner has been invoked");
		lc.loginRunner();
		Thread.sleep(5000);
//		Mo.new_schedule();
//		//fh.switchTodefault();
//		//fh.switchToFrame(ObjectReader.reader.rightframe());
//		mx.selectVendorCurreny();
//		Thread.sleep(1000);
//		mx.digital_vendor();
//		Thread.sleep(1000);
//		Mo.Schedule_Grid();
//		
//		
//		Thread.sleep(1000);
//		Mo.editMedia_popUp();
//		
//		Mo.Add_media_line();
//		fh.switchToFrame(ObjectReader.reader.Add_line());
//		dh.selectUsingValue(Mo.pop_mediaType(), "3721|I");
//		dh.selectUsingIndex(Mo.pop_vendor(), 0);
//		Mo.Proceed_btn();
//		//fh.switchTodefault();
		
		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.Adtype_Digital(), "9151");
		Mo.set_Description_d("Digital Placement");
		Mo.Daily_Budget("2000");
		Mo.Entering_Digital_Spots();
		Mo.Placement_line_add();
		fh.switchTodefault();
		
	}
	
	//
	
	

}
