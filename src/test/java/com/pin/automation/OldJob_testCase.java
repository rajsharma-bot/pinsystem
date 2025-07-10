package com.pin.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pin.automation.utils.ObjectReader;

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
		JobObjects.saveAddAttachment(); //Need to add accept alert
		JobObjects.getOldJobCode();
		
		
		
		
		
	}

}
