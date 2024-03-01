package com.pinsystem;

import org.openqa.selenium.WebDriver;

import com.pinsystem.pageObjects.LoginObjects;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;

public class LoginClass {
	
	WebDriver driver;
	
	public LoginClass(WebDriver driver) {
		this.driver=driver;
	}

	public void loginRunner() {
		ObjectReader.reader = new PropertyReader();
		LoginObjects lg = new LoginObjects(driver);
		lg.login(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		lg.submit();
	}
	
}
