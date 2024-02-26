package com.pinsystem.pageObjects;

import org.openqa.selenium.WebDriver;

public class LoginObjects {
	
	WebDriver driver;

	public LoginObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void userName(String username) {
		driver.findElement(LoginPageObjects.username).clear();
		driver.findElement(LoginPageObjects.username).sendKeys(username);
	}

	public void password(String password) {
		driver.findElement(LoginPageObjects.password).clear();
		driver.findElement(LoginPageObjects.password).sendKeys(password);

	}

//	public void submit(WebDriver driver) {
//		driver.findElement(LoginPageObjects.submit).click();
//	}
//	
	public void submit() {
		driver.findElement(LoginPageObjects.submit).click();
	}

//	public void remember(WebDriver driver) {
//		driver.findElement(LoginPageObjects.rememberMe).click();
//	}
	
	public void remember() {
		driver.findElement(LoginPageObjects.rememberMe).click();
	}

	public void login(String username, String password) {
		userName(username);
		password(password);
	}

	public void loginwithUsername(String username) {
		userName(username);
		submit();
	}

	public void loginWithPassword(String password) {
		password(password);
		submit();
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
