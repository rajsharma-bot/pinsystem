package com.pinsystem.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginObjects {
	
	private static Logger log = LogManager.getLogger(LoginObjects.class);
	
	WebDriver driver;

	public LoginObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void userName(String username) {
		driver.findElement(LoginPageObjects.username).clear();
		driver.findElement(LoginPageObjects.username).sendKeys(username);
		log.info("Passing Only username : " + username);
	}

	public void password(String password) {
		driver.findElement(LoginPageObjects.password).clear();
		driver.findElement(LoginPageObjects.password).sendKeys(password);
		log.info("Passing Only Password : " + password);

	}


	public void submit() {
		driver.findElement(LoginPageObjects.submit).click();
		log.info("Clicked on submit");
	}


	
	public void remember() {
		driver.findElement(LoginPageObjects.rememberMe).click();
		log.info("Clicked on Remember Me");
	}

	public void login(String username, String password) {
		userName(username);
		password(password);
		log.info("Both username = "+username + " Password= " +password + " Is Passed");
		
	}

	public void loginwithUsername(String username) {
		userName(username);
		submit();
		log.info("Username "+ username + " Is Passed" );
	}

	public void loginWithPassword(String password) {
		password(password);
		submit();
		log.info("Password "+ password + " Is Passed" );
	}

	public boolean username_required() {
		return driver.findElement(LoginPageObjects.error).isDisplayed();

	}

	public boolean password_required() {
		return driver.findElement(LoginPageObjects.error).isDisplayed();

	}

	public boolean errorIsDisplayed() {
		boolean d = driver.findElement(LoginPageObjects.error).isDisplayed();
		System.out.println(driver.findElement(LoginPageObjects.error).getText());
		return d;

	}

	public boolean rememberIsSelected() {
		return driver.findElement(LoginPageObjects.rememberMe).isSelected();
	}

	public void remMe() {
		boolean d = driver.findElement(LoginPageObjects.rememberMe).isSelected();
		if (d == true) {
		} else {
			remember();
		}

	}

	public String loginSuccess() {
		String title = driver.getTitle();
		return title;
		
	}

}
