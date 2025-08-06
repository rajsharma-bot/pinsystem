package com.pin.automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pin.automation.utils.FileUtil;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.ResourceHelper;

public class OldJob_testCase extends TestBase {

	private static Logger log = LogManager.getLogger(OldJob_testCase.class);

	@Test
	public void old_job() throws InterruptedException {
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		String env = System.getProperty("env", "devbr"); // Default env
		System.out.println("Selecteted environment is " + env);
		String clientName = ObjectReader.reader.getOldJobClientName(env + ".oldJobclient");
		String product = ObjectReader.reader.getProduct(env + ".product");

		log.info("Using environment: " + env);
		log.info("Client Name: " + clientName);
		log.info("Product: " + product);

		LoginClass lc = new LoginClass(driver, env);
		log.info("Login runner has been invoked for env: " + env);
		lc.loginRunner();
		HomeNavigationObjects.TRAFFIC();
		JobObjects.oldJob();
		DropDownHelper.selectUsingVisibleText(JobObjects.oldJob_clientDDL(), clientName);
		DropDownHelper.selectUsingValue(JobObjects.Product(), product);
		JobObjects.setSubject("Sample Old format job for testing");
		JobObjects.setProducttxt("Agenvy");
		JobObjects.setEstSales("20000");
		JobObjects.setEstCost("20000");
		JobObjects.setDate("01/07/2025");
		JobObjects.saveAddAttachment();
		JobObjects.getOldJobCode();
		JobObjects.setStatus();
		FrameHelper.switchToFrame(JobObjects.switchToJobStatusPopFrame());
		JobObjects.setStatusAsNew();
		JobObjects.updateStatus();
		Assert.assertEquals(JobObjects.selectTaskIsDisplayed(), true, "Status has been updated");
	}

	@Test(dependsOnMethods = { "old_job" }, description = "Creating Cost Estimate for Old job format")
	public void creatingCostEstimate() {

		DropDownHelper.selectUsingVisibleText(JobObjects.selectTask(), "Cost Estimate");
		JobObjects.clickOnNew();
		pop.switchToChildWindow(driver);
		JobObjects.setTemplate();
		JobObjects.templateProceedbtn();
		pop.switchToParentWindow(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		DropDownHelper.selectUsingValue(JobObjects.setCostType(), "6157");
		JobObjects.confirmBtn();

	}

	@Test(dependsOnMethods = { "creatingCostEstimate" }, description = "Creating Invoice for CE")
	public void wipInvoice() {
		String filePath = ResourceHelper.getProductionInvoiceNo();
		FileUtil fileUtil = new FileUtil(filePath);
		JobObjects.createInvoice();
		JobObjects.clickPartialBill();
		JobObjects.setPartialBill("40");
		JobObjects.clickOk();
		JobObjects.createWIPInvoice();
		JobObjects.getProductionInvoice();
		JobObjects.redirectToJob();
		try {

			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file: " + data);
			String inv = JobObjects.ppInvoice();
			Assert.assertEquals(data, inv, "Invoice number match");

		} catch (IOException e) {
			log.error("File not found : " + e.getMessage());
			Assert.fail("Failed to read campaign code file.");
		}
	}
	
	@Test(dependsOnMethods = { "wipInvoice" }, description = "Edit estimate")
	public void editEstimate() throws InterruptedException {
		JobObjects.editEstimate();
		JobObjects.selectEstPOCheckboxesAndCreatePO();
		JobObjects.getOfficeAddress();
		JobObjects.saveAsDraft();
		JobObjects.clickEmailForApproval();
		JobObjects.redirectToJobFromClientPO();
		
	}

}
