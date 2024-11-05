package com.pinsystem;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.LoginObjects;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;

public class LoginTestCase extends TestBase {

	private static Logger log = LogManager.getLogger(LoginTestCase.class);

	@Test(description = "PINSYS-1755 : Verifying login with valid username and password")
	public void verify_login_page_withValid_creds() throws InterruptedException, IOException {

		String text = "PIN System";
		ObjectReader.reader = new PropertyReader();
		LoginObjects lg = new LoginObjects(driver);
		log.info("Broswer has been invoked");
		lg.login(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		lg.remMe();
		lg.submit();
		log.info("Clicked on submit");
		String title = lg.loginSuccess();
		Assert.assertEquals(title, text);

	}

	@Test(description = "PINSYS-1755 : Verifying login with invalid username and password")
	public void verify_login_page_withInValid_creds() throws InterruptedException, IOException {

		ObjectReader.reader = new PropertyReader();
		LoginObjects lg = new LoginObjects(driver);
		lg.login(ObjectReader.reader.invalidUsername(), ObjectReader.reader.invalidPassword());
		lg.submit();
		assertEquals(lg.errorIsDisplayed(), true);

	}

	 @Test(description = "PINSYS-1755 : Verifying login with invalid username")
	public void verify_login_page_withOut_username() throws IOException, InterruptedException {

		ObjectReader.reader = new PropertyReader();
		LoginObjects lg = new LoginObjects(driver);
		Thread.sleep(3000);
		lg.userName(ObjectReader.reader.getUserName());
		lg.submit();
		Assert.assertEquals(lg.errorIsDisplayed(), true);

	}

}
