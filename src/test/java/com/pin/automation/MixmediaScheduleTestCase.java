package com.pin.automation;

import static org.testng.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pin.automation.utils.ObjectReader;

public class MixmediaScheduleTestCase extends TestBase {

	private static Logger log = LogManager.getLogger(MixmediaScheduleTestCase.class);

	@Test(description = "PINSYS-1808-New Campaign")
	public void new_Campaign() throws InterruptedException {

		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"));
		String env = System.getProperty("env", "devbr"); // Default env
		System.out.println(env);

		// Fetch properties using environment prefix
		String clientName = ObjectReader.reader.getClientName(env + ".clientName");
		String soldToParty = ObjectReader.reader.getSoldToParty(env + ".soldToParty");
		String product = ObjectReader.reader.getProduct(env + ".product");
		String contract = ObjectReader.reader.getContract(env + ".contract");
		String serviceBy = ObjectReader.reader.getService(env + ".serviceby");
		String startDate=  ObjectReader.reader.getStartDate();
		String endDate = ObjectReader.reader.getmixMediaEndtDate();


		// Log to confirm values
		log.info("Using environment: " + env);
		log.info("Client Name: " + clientName);
		log.info("Sold To Party: " + soldToParty);
		log.info("Product: " + product);
		log.info("Contract: " + contract);
		log.info("ServiceBy: " + serviceBy);
		log.info("StartDate:" +startDate);
		log.info("EndDate :"+endDate);

		LoginClass lc = new LoginClass(driver, env);
		log.info("Login runner has been invoked for env: " + env);
		lc.loginRunner();
		HomeNavigationObjects.MEDIA();
		MenuObjects.newCampaign();
		if (env.equalsIgnoreCase("pdt")) {
			DropDownHelper.selectUsingVisibleText(MenuObjects.serviceBy(), serviceBy);
			log.info("Service by is selected :" + serviceBy);
		} else {
			log.info("Service By has been ignored");
		}
		DropDownHelper.selectUsingVisibleText(MenuObjects.clientDDL(), clientName);
		if (env.equals("devbr") || env.equals("pdt")) {
			DropDownHelper.selectUsingValue(MenuObjects.soldToParty(), soldToParty);
		} else {
			log.info("Sold To Party is ignored for env: " + env);
		}
		MenuObjects.StartDate(startDate);
		MenuObjects.EndDate(endDate);
		DropDownHelper.selectUsingValue(MenuObjects.Product(), product);
		if (env.equals("devbr") || env.equals("pdt")) {
			DropDownHelper.selectUsingValue(MenuObjects.Contract(), contract);
		} else {
			log.info("Contract is ignored for env: " + env);
		}
		MenuObjects.CampaignName("Regression for mix Media - "+ today);
		
		MixMediaSchedule.selectMultipleMediaTypes();
		MenuObjects.Save();
		MenuObjects.campaignCode();
	}

	@Test(dependsOnMethods = "new_Campaign", description = "PINSYS-1813:: New Schedule(New layout)")
	public void new_Schedule() throws InterruptedException {


		MenuObjects.new_schedule();

		MixMediaSchedule.selectVendorCurreny();

		MixMediaSchedule.selectMultipleVendors();
		MenuObjects.Schedule_Grid();
		MenuObjects.editMedia_popUp();
//		MenuObjects.select_media_layout();

		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		
		// in mix media schedule
		MixMediaSchedule.cinemaPlacement();
		MixMediaSchedule.magazinePlacement();
		MixMediaSchedule.newspaperPlacement();
		MixMediaSchedule.outdoorPlacement();
		MixMediaSchedule.otherPlacement();
		MixMediaSchedule.radioPlacement();
		MixMediaSchedule.tvPlacement();

		// Schedule confirm
		ScheduleObjects.confirm_schedule();

		// Creating Auto Monthly MO
		ScheduleObjects.createAutoMonthlyMO();
		WaitHelper.waitForElementVisibility(ScheduleObjects.MO_number(), 30);
		ScheduleObjects.Select_checkBox();
		ScheduleObjects.Confirm_mo();
		ScheduleObjects.MO_status();
		ScheduleObjects.getScheduleCode();
		assertNotNull(ScheduleObjects.verifyScheduleNo(), "Schedule number should not be null!");
	}


	
}
