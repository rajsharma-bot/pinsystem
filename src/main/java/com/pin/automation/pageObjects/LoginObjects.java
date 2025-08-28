package com.pin.automation.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginObjects {

	private static final Logger log = LogManager.getLogger(LoginObjects.class);

	private WebDriver driver;
	private WebDriverWait wait;
	private String env;

	// Constructor
	public LoginObjects(WebDriver driver) {
		this.driver = driver;
		this.env = System.getProperty("env", "devbr").toLowerCase();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		log.info("Environment set to: " + env);
	}

	// Enter username
	public void userName(String username) {
		By locator = getUsernameLocator();
		WebElement element = waitForElement(locator);
		element.clear();
		element.sendKeys(username);
		log.info("Entered username: " + username);
	}

	// Enter password
	public void password(String password) {
		By locator = getPasswordLocator();
		WebElement element = waitForElement(locator);
		element.clear();
		element.sendKeys(password);
		log.info("Entered password");
	}

	// Click submit/login
	public void submit() {
		By locator = getSubmitLocator();
		WebElement element = waitForElement(locator);
		element.click();
		log.info("Clicked submit/login button");
	}

	// Click remember me checkbox
	public void remember() {
		try {
			WebElement element = waitForElement(getRememberMeLocator());
			if (!element.isSelected()) {
				element.click();
				log.info("Remember Me checkbox was not selected. Clicked to select.");
			} else {
				log.info("Remember Me checkbox is already selected. No action taken.");
			}
		} catch (Exception e) {
			log.error("Failed to interact with Remember Me checkbox.", e);
		}
	}


	// Login with username and password
	public void login(String username, String password) {
		userName(username);
		password(password);
		//submit();
		log.info("Login attempted with username and password.");
	}

	// Login with username only
	public void loginWithUsernameOnly(String username) {
		userName(username);
		submit();
		log.info("Login attempted with username only.");
	}

	// Login with password only
	public void loginWithPasswordOnly(String password) {
		password(password);
		submit();
		log.info("Login attempted with password only.");
	}

	// Check if username required error is displayed
	public boolean usernameRequired() {
		try {
			return waitForElement(getErrorLocator()).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Check if password required error is displayed
	public boolean passwordRequired() {
		try {
			return waitForElement(getErrorLocator()).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Check if error message is displayed
	public boolean errorIsDisplayed() {
		try {
			WebElement errorElement = waitForElement(getErrorLocator());
			boolean displayed = errorElement.isDisplayed();
			log.info("Error Message: " + errorElement.getText());
			return displayed;
		} catch (Exception e) {
			log.warn("Error message not displayed.");
			return false;
		}
	}

	// Check if Remember Me checkbox is selected
	public boolean rememberIsSelected() {
		try {
			return waitForElement(getRememberMeLocator()).isSelected();
		} catch (Exception e) {
			log.warn("Remember Me checkbox not found or not selected.");
			return false;
		}
	}


	// Get page title after login attempt
	public String loginSuccess() {
		return driver.getTitle();
	}

	// Get username locator based on env
	private By getUsernameLocator() {
		if (env.equals("pi2") || env.equals("prsmpdt")) {
			log.info("Using IntegrationLogin username locator for env: " + env);
			return LoginPageObjects.IntegrationLogin.username;
		}
		log.info("Using default username locator for env: " + env);
		return LoginPageObjects.username;
	}

	// Get password locator based on env
	private By getPasswordLocator() {
		if (env.equals("pi2") || env.equals("prsmpdt")) {
			log.info("Using IntegrationLogin password locator for env: " + env);
			return LoginPageObjects.IntegrationLogin.password;
		}
		log.info("Using default password locator for env: " + env);
		return LoginPageObjects.password;
	}

	// Get submit/login button locator based on env
	private By getSubmitLocator() {
		if (env.equals("pi2") || env.equals("prsmpdt")) {
			log.info("Using IntegrationLogin login button locator for env: " + env);
			return LoginPageObjects.IntegrationLogin.Login;
		}
		log.info("Using default submit locator for env: " + env);
		return LoginPageObjects.submit;
	}

	private By getRememberMeLocator() {
		return LoginPageObjects.rememberMe;
	}

	private By getErrorLocator() {
	    if (env.equals("pi2") || env.equals("prsmpdt")) {
	        log.info("Using IntegrationLogin error locator for env: " + env);
	        return LoginPageObjects.IntegrationLogin.error;
	    }
	    log.info("Using default error locator for env: " + env);
	    return LoginPageObjects.error;
	}

	// Wait for element to be visible
	private WebElement waitForElement(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error("Element not found or not visible: " + locator.toString(), e);
			throw e;
		}
	}
	
	// Original method kept intact for backward compatibility
	/*
	 * private WebElement waitForElement(By locator) { return
	 * waitForElement(locator, false); }
	 * 
	 * // New overloaded method with option to wait for clickable instead of visible
	 * private WebElement waitForElement(By locator, boolean waitForClickable) { try
	 * { wait.until((WebDriver driver) -> ((JavascriptExecutor)
	 * driver).executeScript("return document.readyState").equals("complete") );
	 * 
	 * if (waitForClickable) { return
	 * wait.until(ExpectedConditions.elementToBeClickable(locator)); } else { return
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); } } catch
	 * (Exception e) { log.error("Element not found or not visible/clickable: " +
	 * locator.toString(), e); throw e; } }
	 */
}
