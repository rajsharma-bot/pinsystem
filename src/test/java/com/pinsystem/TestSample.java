package com.pinsystem;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestSample {
	
	private static Logger log = LogManager.getLogger(TestSample.class);
	
	@Test
	public void logRunner() {
		
		log.info("Info");
		log.warn("Warn");
		log.error("Error");
		log.debug("debug");
		
		
	}

}
