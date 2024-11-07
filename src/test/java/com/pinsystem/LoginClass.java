package com.pinsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pinsystem.pageObjects.LoginObjects;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;

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
