package com.pinsystem;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pinsystem.pageObjects.HomeNavigationObjects;
import com.pinsystem.pageObjects.LoginObjects;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;

public class TestClass extends TestBase {
	
	@Test
	public void SampleRunner() throws IOException, InterruptedException {
		
		ObjectReader.reader = new PropertyReader();
		LoginObjects lg = new LoginObjects(driver);
		HomeNavigationObjects hm= new HomeNavigationObjects(driver);
		FrameHelper fh= new FrameHelper(driver);
		lg.login(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		lg.remMe();
		lg.submit();
		fh.switchToFrame(ObjectReader.reader.topframe());
		
		hm.FINANCE();
		Thread.sleep(1000);
		hm.FINANCE(ObjectReader.reader.FINANCE());
	
		
		
	}
	

}
