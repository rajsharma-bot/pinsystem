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
import com.pinsystem.utils.WaitHelper;

public class MixMediaSchedule {

	private static Logger log = LogManager.getLogger(MenuObjects.class);

	WebDriver driver;

	public MixMediaSchedule(WebDriver driver) {
		this.driver = driver;
	}

	public void selectMultipleMediaTypes() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		// FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);

		dh.selectUsingVisibleText(Mo.mediaType(), "Cinema");
		Mo.searchTitle("Cathay Cineplex");
		Mo.checkBox();
		Thread.sleep(1000);

		dh.selectUsingVisibleText(Mo.mediaType(), "Magazine");
		Mo.searchTitle("3C Digital");
		Mo.checkBox();
		Thread.sleep(1000);

		dh.selectUsingVisibleText(Mo.mediaType(), "Newspaper");
		Mo.searchTitle("CTSJ Newspaper");
		Mo.checkBox();
		Thread.sleep(1000);

		dh.selectUsingVisibleText(Mo.mediaType(), "Others");
		Mo.searchTitle("Aducation Media");
		Mo.checkBox();
		Thread.sleep(1000);

		dh.selectUsingVisibleText(Mo.mediaType(), "Outdoor");
		Mo.searchTitle("Ad-On-Bus");
		Mo.checkBox();
		Thread.sleep(1000);

		dh.selectUsingVisibleText(Mo.mediaType(), "Radio");
		Mo.searchTitle("988 FM");
		Mo.checkBox();
		Thread.sleep(1000);

		dh.selectUsingVisibleText(Mo.mediaType(), "TV");
		Mo.searchTitle("8TV");
		Mo.checkBox();
		Thread.sleep(1000);

	}

	public void digital_media() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		// FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);

		dh.selectUsingVisibleText(Mo.mediaType(), "Digital");
		Mo.searchTitle("Linkedin");
		Mo.checkBox();
		Thread.sleep(1000);
		//New
//		Mo.searchTitle("Youtube");
//		Mo.checkBox();
//		Thread.sleep(1000);
		//New
		

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
		Thread.sleep(10000);
		dh.selectUsingValue(Mo.Vendor1(), "124|MYR|1.0000000|1|1|15|15|0"); // Cinema
		log.info("vendor 1 has been passed");
		dh.selectUsingValue(Mo.Vendor2(), "923|EUR|4.0000000|1|1|15|15|0"); // Magazine
		log.info("vendor 2 has been passed");
		dh.selectUsingValue(Mo.Vendor3(), "3353|USD|1.5000000|1|1|0|0|0"); // Newspaper
		log.info("vendor 3 has been passed");
		dh.selectUsingValue(Mo.Vendor4(), "108|MYR|1.0000000|1|1|15|15|0"); // outdoor
		log.info("vendor 4 has been passed");
		dh.selectUsingValue(Mo.Vendor5(), "2476|IDR|1.3000000|1|1|0|0|0"); // other
		log.info("vendor 5 has been passed");
		dh.selectUsingValue(Mo.Vendor6(), "14|MYR|1.0000000|1|1|15|15|0");// Radio
		log.info("vendor 6 has been passed");
		dh.selectUsingValue(Mo.Vendor7(), "177|MYR|1.0000000|1|1|0|0|0");// TV
		log.info("vendor 7 has been passed");
	}

	public void digital_vendor() throws InterruptedException {
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		dh.selectUsingValue(Mo.Vendor1(), "4640|MYR|1.0000000|1|1|0|0|0"); // digital
		log.info("vendor 1 has been passed");

	}

	public void cinema_placement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(2000);

		fh.switchTodefault();
		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 120);
		Mo.Add_media_line();
		try {
			fh.switchToFrame(ObjectReader.reader.Add_line());
			log.info("Add line");
		} catch (Exception e) {
			log.info("Ignore");
		}

		dh.selectUsingValue(Mo.pop_mediaType(), "657|C");
		dh.selectUsingIndex(Mo.pop_vendor(), 1);
		Mo.Proceed_btn();
		fh.switchTodefault();
		Thread.sleep(2000);

		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.Adtype_Others(), "26275");
		Mo.set_Description("Cinema Placement");
		Mo.setClient_rate("1000");
		Mo.setVendor_rate("800");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		fh.switchTodefault();

	}

	public void Magazine() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(2000);
		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 120);

		Mo.Add_media_line();
		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.pop_mediaType(), "240|M");
		dh.selectUsingIndex(Mo.pop_vendor(), 0);
		Mo.Proceed_btn();
		fh.switchTodefault();
		Thread.sleep(2000);

		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.Adtype_magazine(), "26196");
		Mo.set_Description_m("Magazine Placement");
		Mo.setClient_rate("1000");
		Mo.setVendor_rate("800");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		fh.switchTodefault();

	}

	public void Newspaper() throws InterruptedException {

		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(2000);
		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 120);

		Mo.Add_media_line();
		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.pop_mediaType(), "3109|N");
		dh.selectUsingIndex(Mo.pop_vendor(), 0);
		Mo.Proceed_btn();
		fh.switchTodefault();
		Thread.sleep(2000);

		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.Adtype_newspaper(), "5623");
		Mo.newspaper_h("1");
		Mo.newspaper_w("1");
		Mo.set_Description_n("Newspaper Placement");
		Mo.setClient_rate("1000");
		Mo.setVendor_rate("800");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		fh.switchTodefault();

	}

	public void digital_placement() throws InterruptedException {

		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(2000);
		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 30);
		Mo.Add_media_line();
		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.pop_mediaType(), "3721|I");
		dh.selectUsingIndex(Mo.pop_vendor(), 0);
		Mo.Proceed_btn();
		dh.selectUsingValue(Mo.Adtype_Digital(), "9151");
		Mo.set_Description_d("Digital Placement");
		Mo.Entering_Digital_Spots("2000");
		Mo.Placement_line_add();
		// fh.switchTodefault();

	}

}