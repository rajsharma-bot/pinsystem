package com.pinsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.ViewLineBylineObjects;
import com.pinsystem.utils.ObjectReader;

public class ForTesting2 extends TestBase{
	
	private static Logger log = LogManager.getLogger(ForTesting2.class);
	
	@Test(description = "Creating Invoice")
	public void digital_invoice() throws InterruptedException {
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		ViewLineBylineObjects vo = new ViewLineBylineObjects(driver);
		LoginClass lc = new LoginClass(driver);
		log.info("Login runner has been invoked");
		lc.loginRunner();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		
		Thread.sleep(10000);
		
//		WebElement  sd =driver.findElement(By.xpath("//span[@id='gvMoDetail_header0_cbPage']"));
		boolean sd =driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected();
		
		
		System.out.println(sd);

	}


}
