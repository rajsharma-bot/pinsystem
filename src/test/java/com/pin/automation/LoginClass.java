package com.pin.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pin.automation.pageObjects.LoginObjects;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.PropertyReader;

public class LoginClass {

	private static final Logger log = LogManager.getLogger(LoginClass.class);

	private WebDriver driver;
	private String env;

	// Constructor now accepts env parameter
	public LoginClass(WebDriver driver, String env) {
		this.driver = driver;
		this.env = env != null ? env.toLowerCase() : "devbr"; 
	}

	public void loginRunner() {
		try {
			if (ObjectReader.reader == null) {
				ObjectReader.reader = new PropertyReader();
			}

			String username;
			String password;


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

			log.info("Starting login with user: " + username + " on environment: " + env);

			LoginObjects loginPage = new LoginObjects(driver);
			loginPage.login(username, password);
			loginPage.submit();

			log.info("Login process completed.");
		} catch (Exception e) {
			log.error("Login failed: ", e);
			throw new RuntimeException("Login execution failed.", e);
		}
	}
}
