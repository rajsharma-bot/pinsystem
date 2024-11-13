package com.pinsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.CancelObjects;
import com.pinsystem.utils.ObjectReader;

public class ForTesting2 extends TestBase{
	
	private static Logger log = LogManager.getLogger(ForTesting2.class);
	
	@Test(description = "Creating Invoice")
	public void digital_invoice() throws InterruptedException {
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		//ViewLineBylineObjects vo = new ViewLineBylineObjects(driver);
		CancelObjects co= new CancelObjects(driver);
		LoginClass lc = new LoginClass(driver);
		log.info("Login runner has been invoked");
		lc.loginRunner();
		driver.get("https://devbr.pinsystem.com/MediaSchedule.aspx?Id=S6CBAm3ssPAl7Ul1d1%3d%3d%3dY68f%3d%3d%3dgSy6K9ky1sjAXuRC6xc%3d&bid=eDO0izlStC8%3d&history=3%3d%3d%3dCNlgJ8OM4%3d");
		co.selectCheckBox();
		co.cancelMObtn();
		co.verifyMOisCancelled();

	}


}
