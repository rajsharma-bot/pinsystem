package com.pinsystem;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pinsystem.utils.FileUtil;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.ResourceHelper;

public class Digital_Campaign_scheduleTestCase extends TestBase {

	private static Logger log = LogManager.getLogger(Digital_Campaign_scheduleTestCase.class);

	@Test(description = "Digital Campaign")
	public void digital_campaign() throws InterruptedException {

		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		LoginClass lc = new LoginClass(driver);
		log.info("Login runner has been invoked");
		lc.loginRunner();
		HomeNavigationObjects.MEDIA();
		MenuObjects.newCampaign();

		// Entering Campaign Details
		DropDownHelper.selectUsingVisibleText(MenuObjects.clientDDL(), ObjectReader.reader.clientname());
		DropDownHelper.selectUsingValue(MenuObjects.soldToParty(), ObjectReader.reader.soldToParty());
		MenuObjects.StartDate("01/01/2024");
		MenuObjects.EndDate("31/03/2024");
		DropDownHelper.selectUsingValue(MenuObjects.Product(), ObjectReader.reader.product());
		DropDownHelper.selectUsingValue(MenuObjects.Contract(), ObjectReader.reader.Contract());
		MenuObjects.CampaignName("Digital Record");

		// Save and generate campaign code
		MixMediaSchedule.digital_media();
		MenuObjects.Save();
		MenuObjects.campaignCode();
		assertNotNull(MenuObjects.verifycampaignCode(), "Campaign code should not be null!");
	}

	@Test(dependsOnMethods = { "digital_campaign" }, description = "Digital Schedule")
	public void Digital_Schedule() throws InterruptedException {

		// Creating New Schedule
		MenuObjects.new_schedule();
		MixMediaSchedule.selectVendorCurreny();
		MixMediaSchedule.digital_vendor();
		// Thread.sleep(30000);
		MenuObjects.Schedule_Grid();

		// Passing placement details
		MenuObjects.editMedia_popUp();
		MixMediaSchedule.digital_placement();

		ScheduleObjects.confirm_schedule();

		// Creating MO and MO c
		ScheduleObjects.Create_MO_By_Vendor();
		WaitHelper.waitForElementVisibility(ScheduleObjects.MO_number(), 30);
		ScheduleObjects.Select_checkBox();
		ScheduleObjects.Confirm_mo();
		ScheduleObjects.MO_status();
		ScheduleObjects.getScheduleCode();
		assertNotNull(ScheduleObjects.verifyScheduleNo(), "Schedule number should not be null!");

	}

	/**
	 * 
	 * @throws InterruptedException
	 * @toggle value =True or False
	 * @true will run Insertion detail hyper link pop-up to update placement line
	 * @false will run Pencil edit to update placement line
	 */
	@Parameters("isEditMO")
	@Test(dependsOnMethods = { "Digital_Schedule" }, description = "Performing operation on view line by line page")
	public void view_line_by_line(boolean isEditMO) throws InterruptedException {
		log.info("Value has set as "+ isEditMO);
		toggle_pencilEditAndEditMO(isEditMO); // true = Insertion Hyperlink popup & False= Pencil edit icon
	}

	@Test(dependsOnMethods = { "view_line_by_line" }, description = "View MO page")
	public void viewMOpage() throws InterruptedException {

		String filePath = ResourceHelper.getMONumber();
		FileUtil fileUtil = new FileUtil(filePath);

		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());

		ScheduleObjects.getMOnumber();
		assertNotNull(ScheduleObjects.MOnumber(), "MO number should not be null!");
		ScheduleObjects.clickOnMOnumber();
		pop.switchToChildWindow(driver);

		try {

			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			ScheduleObjects.verifyViewMOpage(data);

		} catch (IOException e) {
			log.error("File not found : " + e.getMessage());
			Assert.fail("Failed to read MO number number file.");
		}
		
		ScheduleObjects.moPage_moStatus();

	}
	
	
	
	
	

	/*
	 * Performing operation on view line by line page for creating AA Created
	 * Separate method to handle pencil edit and edit Media order Pop-up
	 */

	private void toggle_pencilEditAndEditMO(boolean isEditMO) throws InterruptedException {

		String filePath = ResourceHelper.getScheduleNo();
		FileUtil fileUtil = new FileUtil(filePath);

		// Click on view line by line
		ViewLineBylineObjects.clickOnViewLineBylineBtn();
		pop.switchToChildWindow(driver);

		try {
			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			ViewLineBylineObjects.verifyRedirectToViewLineByLine(data);
		} catch (IOException e) {
			log.error("File not found : " + e.getMessage());
			Assert.fail("Failed to read schedule number file.");
		}

		if (isEditMO) {
			// Edit MO case
			ViewLineBylineObjects.clientInvoiceRemark_btn();
			ViewLineBylineObjects.clientInvoiceRemark_PopUp();
			ViewLineBylineObjects.clientInvoiceRemarkText();
			ViewLineBylineObjects.clientInvoiceRemark_SaveBtn();
			ViewLineBylineObjects.insertionDetail();
			log.info("Clicking on insertion hyperlink");
			FrameHelper.switchToFrame(ObjectReader.reader.Add_line());
			MenuObjects.Entering_Digital_Spots("3500");
			ViewLineBylineObjects.changeReason("Creating AA for Testing Reason");
		} else {
			// Pencil Edit case
			ViewLineBylineObjects.clientInvoiceRemark_btn();
			ViewLineBylineObjects.clientInvoiceRemark_PopUp();
			ViewLineBylineObjects.clientInvoiceRemarkText();
			ViewLineBylineObjects.clientInvoiceRemark_SaveBtn();
			ViewLineBylineObjects.pencilEdit();
			log.info("Clicking on Pencil edit icon");
			FrameHelper.switchToFrame(ObjectReader.reader.Add_line());
			ViewLineBylineObjects.SettingClientRate("3000");
			ViewLineBylineObjects.settingBuyingRate("2000");
			ViewLineBylineObjects.changeReason("Creating AA for Testing Reason");
		}

		ViewLineBylineObjects.updateAA();

		// Back to View line by line page
		FrameHelper.switchTodefault();
		ViewLineBylineObjects.getAA_no();
		assertNotNull(ViewLineBylineObjects.verifygetAA_no(), "AA number should not be null!");
		driver.close();
		pop.switchToParentWindow(driver);
	}
}
