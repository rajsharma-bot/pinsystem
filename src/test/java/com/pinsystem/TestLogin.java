package com.pinsystem;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.LoginObjects;

public class TestLogin extends TestBase {

	//WebDriver driver;

	private static Logger log = LogManager.getLogger(TestLogin.class);

	@Test(description = "PINSYS-1755 : Verifying login with valid username and password", priority = 2)
	public void verify_login_page_withValid_creds() throws InterruptedException, IOException {

		String text = "PIN Systemm";
		FileReader reader = new FileReader("src/main/resources/configfile/config.properties");
		Properties props = new Properties();
		props.load(reader);
		LoginObjects lg = new LoginObjects(driver);
		log.info("Broswer has been invoked");
		Thread.sleep(3000);
		lg.login(props.getProperty("username"), props.getProperty("password"));
		log.info("Username and Password has been passed");
		log.info(props.getProperty("username"));
		log.info(props.getProperty("password"));
		lg.remMe();
		lg.submit();
		Thread.sleep(3000);
		log.info("Clicked on submit");
		String title = lg.loginSuccess();
		Assert.assertEquals(title, text);
		
		


	}

	@Test(description = "PINSYS-1755 : Verifying login with invalid username and password", priority = 0)
	public void verify_login_page_withInValid_creds() throws InterruptedException, IOException {

		FileReader reader = new FileReader("src/main/resources/configfile/config.properties");
		Properties props = new Properties();
		props.load(reader);
		LoginObjects lg = new LoginObjects(driver);
		Thread.sleep(3000);
		lg.login(props.getProperty("invalidUsername"), props.getProperty("invalidPassword"));
		log.info("Username is " + props.getProperty("invalidUsername") + "and Password has been passed"
				+ props.getProperty("invalidPassword"));
		lg.submit();
		assertEquals(lg.errorIsDisplayed(), true);

	}

	@Test(description = "PINSYS-1755 : Verifying login with invalid username", priority = 1)
	public void verify_login_page_withOut_username() throws IOException, InterruptedException {

		FileReader reader = new FileReader("src/main/resources/configfile/config.properties");
		Properties props = new Properties();
		props.load(reader);
		LoginObjects lg = new LoginObjects(driver);
		Thread.sleep(3000);
		lg.userName(props.getProperty("username"));
		lg.submit();
		Assert.assertEquals(lg.errorIsDisplayed(), true);
		
	}

}
