package com.pin.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pin.automation.pageObjects.LoginObjects;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.PropertyReader;

public class LoginClass {
	
	private static Logger log = LogManager.getLogger(LoginClass.class);

	WebDriver driver;
	
	public LoginClass(WebDriver driver) {
		this.driver=driver;
	}

	public void loginRunner() {
		ObjectReader.reader = new PropertyReader();
		LoginObjects lg = new LoginObjects(driver);
		log.info("Login Runner has been invoke");
		lg.login(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		lg.submit();
	}
	
}
