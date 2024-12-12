package com.pin.automation.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pin.automation.utils.FrameHelper;
import com.pin.automation.utils.ObjectReader;

public class HomeNavigationObjects {

	private static Logger log = LogManager.getLogger(HomeNavigationObjects.class);
	WebDriver driver;

	public HomeNavigationObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void HOME() {
		driver.findElement(HomeNavigationPageObjects.HOME).click();
		log.info("Clicked on HOME Menu");

	}

	public boolean HOME(String value) {
		String text = driver.findElement(HomeNavigationPageObjects.HOME).getText();
		if (text.contentEquals(value)) {
			log.info("Element are matching");
			return true;
		} else
			log.info(text + " doesn't matches with " + value);
		return false;
	}

	public void TRAFFIC() {
		driver.findElement(HomeNavigationPageObjects.TRAFFIC).click();
		log.info("Clicked on Traffic Menu");

	}

	public boolean TRAFFIC(String value) {
		String text = driver.findElement(HomeNavigationPageObjects.TRAFFIC).getText();
		if (text.contentEquals(value)) {
			log.info("Element are matching");
			return true;
		} else
			log.info(text + " doesn't matches with " + value);
		return false;
	}

	public void MEDIA() {
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchToFrame(ObjectReader.reader.topframe());
		driver.findElement(HomeNavigationPageObjects.MEDIA).click();
		log.info("Clicked on Media ");
	}

	public boolean MEDIA(String value) {
		String text = driver.findElement(HomeNavigationPageObjects.MEDIA).getText();
		if (text.contentEquals(value)) {
			log.info("Element are matching");
			return true;
		} else
			log.info(text + " doesn't matches with " + value);
		return false;
	}

	public void IT_DEPT() {
		driver.findElement(HomeNavigationPageObjects.IT_DEPT).click();
		log.info("Clicked on IT Dept");
	}

	public boolean IT_DEPT(String value) {
		String text = driver.findElement(HomeNavigationPageObjects.IT_DEPT).getText();
		if (text.contentEquals(value)) {
			log.info("Element are matching");
			return true;
		} else
			log.info(text + " doesn't matches with " + value);
		return false;
	}

	public void ACCOUNTS() {
		driver.findElement(HomeNavigationPageObjects.ACCOUNTS).click();
		log.info("Clicked on Accounts");
	}

	public boolean ACCOUNTS(String value) {
		String text = driver.findElement(HomeNavigationPageObjects.ACCOUNTS).getText();
		if (text.contentEquals(value)) {
			log.info("Element are matching");
			return true;
		} else
			log.info(text + " doesn't matches with " + value);
		return false;
	}

	public void SALES() {
		driver.findElement(HomeNavigationPageObjects.SALES).click();
		log.info("Clicked on Sales");
	}

	public boolean SALES(String value) {
		String text = driver.findElement(HomeNavigationPageObjects.SALES).getText();
		if (text.contentEquals(value)) {
			log.info("Element are matching");
			return true;
		} else
			log.info(text + " doesn't matches with " + value);
		return false;
	}

	public void FINANCE() {
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.topframe());
		log.info("Clicked on Finance");
		driver.findElement(HomeNavigationPageObjects.FINANCE).click();
		
	}

	public boolean FINANCE(String value) {
		String text = driver.findElement(HomeNavigationPageObjects.FINANCE).getText();
		if (text.contentEquals(value)) {
			log.info("Element are matching");
			return true;
		} else
			log.info(text + " doesn't matches with " + value);
		return false;
	}

	public void HR_ADMIN() {
		driver.findElement(HomeNavigationPageObjects.HR_ADMIN).click();
		log.info("Clicked on HR/ADMIN");
	}

	public boolean HR_ADMIN(String value) {
		String text = driver.findElement(HomeNavigationPageObjects.HR_ADMIN).getText();
		if (text.contentEquals(value)) {
			log.info("Element are matching");
			return true;
		} else
			log.info(text + " doesn't matches with " + value);
		return false;
	}

	public void CORPORATE_INFO() {
		driver.findElement(HomeNavigationPageObjects.CORPORATE_INFO).click();
		log.info("Clicked on CORPORATE INFO");
	}

	public boolean CORPORATE_INFO(String value) {
		String text = driver.findElement(HomeNavigationPageObjects.CORPORATE_INFO).getText();
		if (text.contentEquals(value)) {
			log.info("Element are matching");
			return true;
		} else
			log.info(text + " doesn't matches with " + value);
		return false;
	}

	public void UserLink() {
		driver.findElement(HomeNavigationPageObjects.UserLink).click();
		log.info("Clicked on User Name");
	}

	public void Logout() {
		driver.findElement(HomeNavigationPageObjects.Logout).click();
		log.info("Clicked on Logout");
	}

}
