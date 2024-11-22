package com.pinsystem;

import static org.testng.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.pinsystem.utils.ObjectReader;

public class NewSampleRunner extends TestBase {

	private static Logger log = LogManager.getLogger(NewSampleRunner.class);

	@Test
	public void testRunner() throws InterruptedException {
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		LoginClass lc = new LoginClass(driver);
		log.info("Login runner has been invoked");
		lc.loginRunner();
//		HomeNavigationObjects.MEDIA();
//		MenuObjects.newCampaign();
//
//		// Entering Campaign Details
//		DropDownHelper.selectUsingVisibleText(MenuObjects.clientDDL(), ObjectReader.reader.clientname());
//		DropDownHelper.selectUsingValue(MenuObjects.soldToParty(), ObjectReader.reader.soldToParty());
//		MenuObjects.StartDate("01/01/2024");
//		MenuObjects.EndDate("31/03/2024");
//		DropDownHelper.selectUsingValue(MenuObjects.Product(), ObjectReader.reader.product());
//		DropDownHelper.selectUsingValue(MenuObjects.Contract(), ObjectReader.reader.Contract());
//		MenuObjects.CampaignName("Digital Record");
//
//		// Save and generate campaign code
//		MixMediaSchedule.digital_media();
//		MenuObjects.Save();
//		MenuObjects.campaignCode();
//		assertNotNull(MenuObjects.verifycampaignCode(), "Campaign code should not be null!");
		driver.get(
				"https://devbr.pinsystem.com/MediaCampaignSummary.aspx?a=1&g=&id=JoMTCIynUD2nUAdpfLajOAhOU:::l8bYZq&bid=eDO0izlStC8=");

		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='CM1_btnAddSchedule']")).click(); // New schedule
		Thread.sleep(10000);
		MixMediaSchedule.selectVendorCurreny();

		driver.findElement(By.xpath("//input[@id='txtTax']")).clear();
		driver.findElement(By.xpath("//input[@id='txtTax']")).clear();
		driver.findElement(By.xpath("//input[@id='txtTax']")).sendKeys("8");
		MixMediaSchedule.digital_vendor();

		VendorSelection vendorSelection = new VendorSelection(driver);
		// Select vendor for the first row (YouTube)
		vendorSelection.selectVendor(1, "3319|MYR|1.0000000|1|1|0|0|0");

		// Select vendor for the second row (LinkedIn)
		vendorSelection.selectVendor(2, "4640|MYR|1.0000000|1|1|0|0|0");

	}

}
