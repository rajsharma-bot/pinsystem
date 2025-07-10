package com.pin.automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pin.automation.utils.FileUtil;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.ResourceHelper;

public class NewJob_testCase extends TestBase {

	private static Logger log = LogManager.getLogger(NewJob_testCase.class);

	@Test(description = "Creating New Job")
	public void new_Job() throws InterruptedException {
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		String env = System.getProperty("env", "devbr"); // Default env
		System.out.println("Selecteted environment is " + env);
		String clientName = ObjectReader.reader.getJobClientName(env + ".jobClient");
		String product = ObjectReader.reader.getProduct(env + ".product");

		log.info("Using environment: " + env);
		log.info("Client Name: " + clientName);
		log.info("Product: " + product);

		LoginClass lc = new LoginClass(driver, env);
		log.info("Login runner has been invoked for env: " + env);
		lc.loginRunner();
		HomeNavigationObjects.TRAFFIC();
		JobObjects.newJob();
		JobObjects.selectClient(clientName);
		DropDownHelper.selectUsingValue(JobObjects.Product(), product);
		JobObjects.startDate("01/07/2025");
		JobObjects.endDate("31/07/2025");
		DropDownHelper.selectUsingValue(JobObjects.currency(), "MYR");
		JobObjects.setBudget("30000");
		JobObjects.setJobName("Sample New Job");
		JobObjects.SaveNewJOB();
		JobObjects.getJobCode();
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

	@Test(dependsOnMethods = { "new_Job" }, description = "Creating Invoice for CE")
	public void productionInvoice() {
		String filePath = ResourceHelper.getProductionInvoiceNo();
		FileUtil fileUtil = new FileUtil(filePath);
		JobObjects.createInvoice();
		JobObjects.generateInvoice();
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

}
