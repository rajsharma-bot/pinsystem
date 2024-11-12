package com.pinsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestClass  {
	
	private static Logger log = LogManager.getLogger(ForTesting2.class);
	
	@Test
	public void SampleRunner() {
		
	log.info("I'm Info");
	log.debug("I'm Dubug");
	log.error("I'm Error");
	log.trace("I'm Trace");
		
		
	}
	

}
