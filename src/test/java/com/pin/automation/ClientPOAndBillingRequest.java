package com.pin.automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pin.automation.utils.FileUtil;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.ResourceHelper;

public class ClientPOAndBillingRequest extends TestBase {

	private static Logger log = LogManager.getLogger(ClientPOAndBillingRequest.class);
	protected String value;

	@Test
	public void clientPO() throws InterruptedException {
		String filePath = ResourceHelper.getCampaignCode();
		FileUtil fileUtil = new FileUtil(filePath);
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		String env = System.getProperty("env", "devbr"); // Default to pi2 if not set
		System.out.println("Selecteted environment is " + env);
		LoginClass lc = new LoginClass(driver, env);
		log.info("Login runner has been invoked for env: " + env);
		lc.loginRunner();
		HomeNavigationObjects.MEDIA();
		MenuObjects.ListCampaign_page();
		
		DropDownHelper.selectUsingVisibleText(MenuObjects.Campaign_search(), "Campaign No.");
		try {

			String data = fileUtil.readAllTextFromFile();
			value=data;
			log.info("Data read from file:\n" + data);
			MenuObjects.Campaign_no(data);
			
		} catch (IOException e) {
			log.error("File not found : " + e.getMessage());
			Assert.fail("Failed to read campaign code file.");
		}
		log.info("value :"+value);
		
		MenuObjects.Campaign_searchbutton();
		MenuObjects.clickOnCampaignNo();
		MenuObjects.campaignCode();
		MenuObjects.getScheduleSummary();
		MenuObjects.selectCheckBox();
		MenuObjects.uploadClientPO();
		MenuObjects.setClientPONumber("PO-18/CE/CO9294");
		MenuObjects.setFileInput();
		MenuObjects.setAmount();
		MenuObjects.inclFeeCheckbox();
		MenuObjects.inclTaxCheckbox();
		MenuObjects.saveclientPO();
		MenuObjects.getClientPONumber();
		MenuObjects.tickCheckBox();
		MenuObjects.uploadScheduleDoc();
		MenuObjects.setFileScheduleDoc();
		MenuObjects.saveUploadScheduleDoc();
		MenuObjects.getAttachedIcon();	
	}
	
	@Test(dependsOnMethods = { "clientPO" }, description = "Billing Request Send for Bill")
	public void billingRequest() throws InterruptedException {
		
		String startDate=  ObjectReader.reader.getStartDate();
		String endDate = ObjectReader.reader.getEndDate();
		
		log.info("StartDate:" +startDate);
		log.info("EndDate :"+endDate);
		log.info("value :"+value);
		
		MenuObjects.clickOnBillingRequest();
		MenuObjects.clientPOStartDate(startDate);
		MenuObjects.clientPOEndDate(endDate);
		DropDownHelper.selectUsingVisibleText(MenuObjects.setSearchBY(), "Campaign");
		MenuObjects.searchByText(value);
		MenuObjects.clickOnFind();
		

		
	}
}
