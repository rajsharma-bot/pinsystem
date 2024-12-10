package com.pinsystem.pageObjects;

import java.time.Duration;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pinsystem.utils.DropDownHelper;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;
import com.pinsystem.utils.WaitHelper;

public class MixMediaSchedule {

	private static Logger log = LogManager.getLogger(MenuObjects.class);

	WebDriver driver;
	WebDriverWait wait;

	public MixMediaSchedule(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //// global WebDriverWait
	}

	public void selectMultipleMediaTypes() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);

		// Map of media types and corresponding search titles
		Map<String, String> mediaTypeTitleMap = Map.of("Cinema", "Cathay Cineplex", "Magazine", "3C Digital",
				"Newspaper", "CTSJ Newspaper", "Others", "Aducation Media", "Outdoor", "Ad-On-Bus", "Radio", "988 FM",
				"TV", "8TV");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		for (Map.Entry<String, String> entry : mediaTypeTitleMap.entrySet()) {
			String mediaType = entry.getKey();
			String title = entry.getValue();

			// Select the media type from the dropdown
			dh.selectUsingVisibleText(Mo.mediaType(), mediaType);

			// Search for the title
			Mo.searchTitle(title);

			// Wait until the checkbox is clickable and then select it
			Thread.sleep(5000);
			Mo.checkBox();
		}
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
		// New
//		Mo.searchTitle("Youtube");
//		Mo.checkBox();
//		Thread.sleep(1000);
		// New

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

//	public void selectMultipleVendors() throws InterruptedException {
//		ObjectReader.reader = new PropertyReader();
//		MenuObjects Mo = new MenuObjects(driver);
//		DropDownHelper dh = new DropDownHelper(driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
//
//		// Arrays for dropdowns and corresponding vendor names
//		WebElement[] dropdowns = { Mo.Vendor1(), Mo.Vendor2(), Mo.Vendor3(), Mo.Vendor4(), Mo.Vendor5(), Mo.Vendor6(),
//				Mo.Vendor7() };
//
//		String[] vendorNames = { "Digital Cinema Media Sdn Bhd", "MunSang Poh",
//				"Exponential Interactive Singapore Pte (USD)", "Ad-On-Bus Sdn Bhd", "APRILIS MAJU MEDIA",
//				"Adscreen Media Sdn Bhd", "CH-9 MEDIA SDN BHD" };
//
//		Thread.sleep(3000);
//		// Iterate over both arrays and perform actions
//		for (int i = 0; i < dropdowns.length; i++) {
//			try {
//				Thread.sleep(3000);
//				// Wait for dropdown to be clickable
//				wait.until(ExpectedConditions.elementToBeClickable(dropdowns[i]));
//				Thread.sleep(3000);
//				// Select vendor
//				dh.selectUsingVisibleText(dropdowns[i], vendorNames[i]);
//
//				log.info("Vendor " + (i + 1) + " (" + vendorNames[i] + ") has been passed");
//			} catch (Exception e) {
//				log.error("Failed to select vendor " + (i + 1) + ": " + vendorNames[i], e);
//			}
//		}
//	}

	public void selectMultipleVendors() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		Thread.sleep(10000);

		dh.selectUsingVisibleText(Mo.Vendor1(), "Digital Cinema Media Sdn Bhd"); // Cinema
		log.info("vendor 1 has been passed");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.Vendor2(), "MunSang Poh"); // Magazine
		log.info("vendor 2 has been passed");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.Vendor3(), "Exponential Interactive Singapore Pte (USD)"); // Newspaper
		log.info("vendor 3 has been passed");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.Vendor4(), "Ad-On-Bus Sdn Bhd"); // outdoor
		log.info("vendor 4 has been passed");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.Vendor5(), "APRILIS MAJU MEDIA"); // other
		log.info("vendor 5 has been passed");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.Vendor6(), "Adscreen Media Sdn Bhd");// Radio
		log.info("vendor 6 has been passed");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.Vendor7(), "CH-9 MEDIA SDN BHD");// TV
		log.info("vendor 7 has been passed");
	}

	public void digital_vendor() throws InterruptedException {
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		dh.selectUsingValue(Mo.Vendor1(), "4640|MYR|1.0000000|1|1|0|0|0"); // digital
		log.info("vendor 1 has been passed");

	}

	public void cinemaPlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(2000);

		// fh.switchTodefault();
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
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.pop_vendor(), "Digital Cinema Media Sdn Bhd");
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
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

	public void magazinePlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(10000);

		fh.switchToFrame(ObjectReader.reader.rightframe());
		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 120);
		Mo.Add_media_line();
		try {
			fh.switchToFrame(ObjectReader.reader.Add_line());
			log.info("Add line");
		} catch (Exception e) {
			log.info("Ignore");
		}

		dh.selectUsingValue(Mo.pop_mediaType(), "240|M");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.pop_vendor(), "MunSang Poh");
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
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

	public void newspaperPlacement() throws InterruptedException {

		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(10000);

		fh.switchToFrame(ObjectReader.reader.rightframe());
		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 120);
		Mo.Add_media_line();
		try {
			fh.switchToFrame(ObjectReader.reader.Add_line());
			log.info("Add line");
		} catch (Exception e) {
			log.info("Ignore");
		}
		dh.selectUsingValue(Mo.pop_mediaType(), "4485|N");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.pop_vendor(), "Exponential Interactive Singapore Pte (USD)");
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.Adtype_newspaper(), "9395");
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

	public void outdoorPlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(10000);

		fh.switchToFrame(ObjectReader.reader.rightframe());
		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 120);
		Mo.Add_media_line();
		try {
			fh.switchToFrame(ObjectReader.reader.Add_line());
			log.info("Add line");
		} catch (Exception e) {
			log.info("Ignore");
		}

		dh.selectUsingValue(Mo.pop_mediaType(), "618|O");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.pop_vendor(), "Ad-On-Bus Sdn Bhd");
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.Adtype_Others(), "26276");
		Mo.set_Description("Outdoor Placement");
		Mo.setClient_rate("400");
		Mo.setVendor_rate("200");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		fh.switchTodefault();

	}

	public void otherPlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(10000);

		fh.switchToFrame(ObjectReader.reader.rightframe());
		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 120);
		Mo.Add_media_line();
		try {
			fh.switchToFrame(ObjectReader.reader.Add_line());
			log.info("Add line");
		} catch (Exception e) {
			log.info("Ignore");
		}

		dh.selectUsingValue(Mo.pop_mediaType(), "4477|OT");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.pop_vendor(), "APRILIS MAJU MEDIA");
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.Adtype_Others(), "9374");
		Mo.set_Description("Other Placement");
		Mo.setClient_rate("400");
		Mo.setVendor_rate("200");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		fh.switchTodefault();

	}

	public void radioPlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(10000);

		fh.switchToFrame(ObjectReader.reader.rightframe());
		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 120);
		Mo.Add_media_line();
		try {
			fh.switchToFrame(ObjectReader.reader.Add_line());
			log.info("Add line");
		} catch (Exception e) {
			log.info("Ignore");
		}

		dh.selectUsingValue(Mo.pop_mediaType(), "615|R");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.pop_vendor(), "Adscreen Media Sdn Bhd");
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());

		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.Adtype_radio(), "276");
		Mo.set_Description_R("Radio Placement");
		Mo.setClient_rate("400");
		Mo.setVendor_rate("200");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		fh.switchTodefault();

	}

	public void tvPlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		Thread.sleep(10000);

		fh.switchToFrame(ObjectReader.reader.rightframe());
		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 120);
		Mo.Add_media_line();
		try {
			fh.switchToFrame(ObjectReader.reader.Add_line());
			log.info("Add line");
		} catch (Exception e) {
			log.info("Ignore");
		}

		dh.selectUsingValue(Mo.pop_mediaType(), "613|TV");
		Thread.sleep(2000);
		dh.selectUsingVisibleText(Mo.pop_vendor(), "CH-9 MEDIA SDN BHD");
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());

		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());
		dh.selectUsingValue(Mo.Adtype_TV(), "10588");
		Mo.set_Description_TV("TV Placement");
		Mo.setClient_rate("400");
		Mo.setVendor_rate("200");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		fh.switchTodefault();

	}
}