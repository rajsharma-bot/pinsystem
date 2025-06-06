package com.pin.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pin.automation.TestBase;
import com.pin.automation.pageObjects.CancelObjects;
import com.pin.automation.utils.ObjectReader;

public class ForTesting2 extends TestBase{
	
	private static Logger log = LogManager.getLogger(ForTesting2.class);
	
	 @Test(description = "Creating Invoice")
	    public void digital_invoice() throws InterruptedException {
	        WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());

	        String env = System.getProperty("env", "pi2");  // Default to pi2 if not set

	        LoginClass lc = new LoginClass(driver, env);
	        log.info("Login runner has been invoked for env: " + env);

	        lc.loginRunner();
	        
	        // You can continue with your other test steps here
	    }
}