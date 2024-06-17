package com.pinsystem.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pinsystem.utils.DropDownHelper;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;

public class MixMediaSchedule {

	private static Logger log = LogManager.getLogger(MenuObjects.class);

	WebDriver driver;

	public MixMediaSchedule(WebDriver driver) {
		this.driver = driver;
	}

	public void selectMultipleMediaTypes() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		
		dh.selectUsingVisibleText(Mo.mediaType(), "Cinema");
		Mo.searchTitle("Cathay Cineplex");
		Mo.checkBox();

		dh.selectUsingVisibleText(Mo.mediaType(), "Magazine");
		Mo.searchTitle("3C Digital");
		Mo.checkBox();

		dh.selectUsingVisibleText(Mo.mediaType(), "Newspaper");
		Mo.searchTitle("Adstream Cost");
		Mo.checkBox();

		dh.selectUsingVisibleText(Mo.mediaType(), "Others");
		Mo.searchTitle("Aducation Media");
		Mo.checkBox();

		dh.selectUsingVisibleText(Mo.mediaType(), "Outdoor");
		Mo.searchTitle("Ad-On-Bus");
		Mo.checkBox();

		dh.selectUsingVisibleText(Mo.mediaType(), "Radio");
		Mo.searchTitle("988 FM");
		Mo.checkBox();

		dh.selectUsingVisibleText(Mo.mediaType(), "TV");
		Mo.searchTitle("8TV");
		Mo.checkBox();

	}

	public void selectVendorCurreny() throws InterruptedException {

		DropDownHelper dh = new DropDownHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		WebElement client_currency = driver.findElement(MenuPageObjects.client_currency);
		Select select = new Select(client_currency);
		WebElement selectedOption = select.getFirstSelectedOption();
		String selectedValue = selectedOption.getText();
		dh.selectUsingVisibleText(Mo.vendorCurrency(), selectedValue);
	}

	public void selecMultipleVendors() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		dh.selectUsingValue(Mo.Vendor1(), "124|MYR|1.0000000|1|1|15|15|0");
		// Mo.fee("5");
		dh.selectUsingValue(Mo.Vendor2(), "254|MYR|1.0000000|1|1|15|15|0");
		dh.selectUsingValue(Mo.Vendor3(), "1435|MYR|1.0000000|1|1|0|0|0");
		dh.selectUsingValue(Mo.Vendor4(), "108|MYR|1.0000000|1|1|15|15|0");
		dh.selectUsingValue(Mo.Vendor5(), "2476|IDR|1.3000000|1|1|0|0|0");
		dh.selectUsingValue(Mo.Vendor6(), "14|MYR|1.0000000|1|1|15|15|0");
		dh.selectUsingValue(Mo.Vendor7(), "226|MYR|1.0000000|1|1|0|0|0");
	}

	
	public void cinema_placement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		dh.selectUsingValue(Mo.Adtype_ddl(), "26275");
		Mo.set_Description("Cinema Placement");
		Mo.setClient_rate("1000");
		Mo.setVendor_rate("800");
		//fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.EditMediaFrame());
		Mo.Entering_Spots();
	}
	
	
	
	
}
