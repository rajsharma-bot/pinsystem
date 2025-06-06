package com.pin.automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pin.automation.pageObjects.LoginObjects;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.PropertyReader;

public class LoginTestCase extends TestBase {

	private static final Logger log = LogManager.getLogger(LoginTestCase.class);

	@Test(priority = 2, description = "PINSYS-1755 : Verifying login with valid username and password")
	public void verify_login_with_valid_credentials() throws IOException, InterruptedException {

		String username;
		String password;
		String expectedTitle = "PIN System";
		ObjectReader.reader = new PropertyReader();
		LoginObjects loginPage = new LoginObjects(driver);
		String env = System.getProperty("env", "devbr").toLowerCase();

		log.info("Logging in with valid credentials");
		if ("pi2".equals(env)) {
			username = ObjectReader.reader.getValue("user.pi2");
			password = ObjectReader.reader.getValue("password.pi2");

		} else if ("devbr".equals(env) || "pdt".equals(env)) {
			username = ObjectReader.reader.getValue("user.devbr");
			password = ObjectReader.reader.getValue("password.devbr");

		} else {
			// default
			username = ObjectReader.reader.getValue("user.prsmpdt");
			password = ObjectReader.reader.getValue("password.prsmpdt");
		}
		loginPage.login(username,password);
		if (env.equals("devbr") || env.equals("pdt")) {
			loginPage.remember();
		} else {
			log.info("Remember Me checkbox ignored for env: " + env);
		}
		loginPage.submit();
		log.info("Clicked on Submit");
		Thread.sleep(3000);
		String actualTitle = loginPage.loginSuccess();
		log.info("Login successful, validating title");
		assertEquals(actualTitle, expectedTitle, "Page title mismatch after login.");
	}

	@Test(priority = 1, description = "PINSYS-1755 : Verifying login with invalid username and  password")
	public void verify_login_with_invalid_credentials() throws IOException {
		log.info("Logging in with invalid credentials");
		ObjectReader.reader = new PropertyReader();
		LoginObjects loginPage = new LoginObjects(driver);
		loginPage.login(ObjectReader.reader.invalidUsername(), ObjectReader.reader.invalidPassword());
		loginPage.submit();

		log.info("Checking for error message");
		assertTrue(loginPage.errorIsDisplayed(), "Expected error message not displayed.");
	}

	@Test(priority = 0, description = "PINSYS-1755 : Verifying login without username and password")
	public void verify_login_without_username_and_Password() throws IOException, InterruptedException {
		log.info("Attempting login without entering username & password");
		ObjectReader.reader = new PropertyReader();
		LoginObjects loginPage = new LoginObjects(driver);
		// loginPage.userName(""); // Empty username
		Thread.sleep(3000);
		loginPage.loginWithUsernameOnly("");
		loginPage.submit();
		log.info("Checking for error message due to missing username");
		assertTrue(loginPage.errorIsDisplayed(), "Expected error message for missing username.");
	}

}
