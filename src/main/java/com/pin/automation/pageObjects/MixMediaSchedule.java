package com.pin.automation.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pin.automation.utils.DropDownHelper;
import com.pin.automation.utils.FrameHelper;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.PropertyReader;
import com.pin.automation.utils.VendorReader;
import com.pin.automation.utils.WaitHelper;

public class MixMediaSchedule {

	private static Logger log = LogManager.getLogger(MenuObjects.class);

	WebDriver driver;
	WebDriverWait wait;
	private String env;

	public MixMediaSchedule(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //// global WebDriverWait
	}

	public void selectMultipleMediaTypes() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);

		// Get env from system property or fallback to "pi2"
		String env = System.getProperty("env", "pi2").toLowerCase();

		Map<String, String> mediaTypeTitleMap;

		switch (env) {
		case "devbr":
		case "pdt":
			mediaTypeTitleMap = Map.of("Cinema", "Cathay Cineplex", "Magazine", "3C Digital", "Newspaper",
					"CTSJ Newspaper", "Others", "Aducation Media", "Outdoor", "Ad-On-Bus", "Radio", "988 FM", "TV",
					"8TV");
			break;
		case "prsmpdt":
			mediaTypeTitleMap = Map.of("Cinema", "Cinema outlet1", "Newspaper", "Newspaper outlet1", "Radio",
					"PerfOutlet1", "TV", "Television outlet1");
			break;
		case "pi2":
		default:
			mediaTypeTitleMap = Map.of("Cinema", "Disney", "Magazine", "Business India", "Newspaper", "Dainik Jagran",
					"Others", "Cobrapost", "Outdoor", "BILLBOARD", "Radio", "Red FM 93.5", "TV", "Star Sport");
			break;
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		for (Map.Entry<String, String> entry : mediaTypeTitleMap.entrySet()) {
			String mediaType = entry.getKey();
			String title = entry.getValue();

			dh.selectUsingVisibleText(Mo.mediaType(), mediaType);
			Mo.searchTitle(title);

			By titleLocator = Mo.getMediaTitleLabel(title);

			if (!driver.findElements(titleLocator).isEmpty()) {
				Thread.sleep(2000); // Ideally use WebDriverWait instead
				Mo.checkBox();
			} else {
				System.out.println("Media title not found on UI: " + title);
			}
		}
	}

	public void digital_media() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		// FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);

		Thread.sleep(3000);
		dh.selectUsingVisibleText(Mo.mediaType(), "Digital");

		String env = ObjectReader.reader.getEnv(); // make sure getEnv() method is available
		String mediaTitle = "";
		if (env.equalsIgnoreCase("pi2")) {
			mediaTitle = "Facebook";
		} else if (env.equalsIgnoreCase("devbr") || env.equalsIgnoreCase("pdt")) { /// (env.equals("devbr") ||
																					/// env.equals("pdt")) {
			mediaTitle = "Linkedin";
		} else {
			mediaTitle = "YouTube & IG"; // 👈 Custom media title for unknown env
			log.warn("Unknown environment: " + env + ". Setting default media title: " + mediaTitle);

		}

		Mo.searchTitle(mediaTitle);

		Thread.sleep(5000);
		Mo.label();

		// Mo.checkBox();
		Thread.sleep(3000);

	}

	public void selectVendorCurreny() throws InterruptedException {

		DropDownHelper dh = new DropDownHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());

		WebElement client_currency = driver.findElement(MenuPageObjects.client_currency);
		Select select = new Select(client_currency);
		WebElement selectedOption = select.getFirstSelectedOption();
		String selectedValue = selectedOption.getText();
		dh.selectUsingVisibleText(Mo.vendorCurrency(), selectedValue);
	}

	public void selectMultipleVendors() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		String env = System.getProperty("env", "devbr"); // fallback if not set
		List<String> vendors = VendorReader.getVendorsForEnv(env);
		Thread.sleep(10000);

		if (vendors.size() < 7) {
			log.warn("Expected 7 vendors but found only " + vendors.size() + " in the Excel sheet for env: " + env);
		}

		try {
			dh.selectUsingVisibleText(Mo.Vendor1(), vendors.get(0));
			log.info("Vendor 1 selected: " + vendors.get(0));

			dh.selectUsingVisibleText(Mo.Vendor2(), vendors.get(1));
			log.info("Vendor 2 selected: " + vendors.get(1));

			dh.selectUsingVisibleText(Mo.Vendor3(), vendors.get(2));
			log.info("Vendor 3 selected: " + vendors.get(2));

			dh.selectUsingVisibleText(Mo.Vendor4(), vendors.get(3));
			log.info("Vendor 4 selected: " + vendors.get(3));

			dh.selectUsingVisibleText(Mo.Vendor5(), vendors.get(4));
			log.info("Vendor 5 selected: " + vendors.get(4));

			dh.selectUsingVisibleText(Mo.Vendor6(), vendors.get(5));
			log.info("Vendor 6 selected: " + vendors.get(5));

			dh.selectUsingVisibleText(Mo.Vendor7(), vendors.get(6));
			log.info("Vendor 7 selected: " + vendors.get(6));

		} catch (IndexOutOfBoundsException e) {
			log.error("Failed to select vendor: Missing entry in Excel for one or more vendors.");
		} catch (Exception e) {
			log.error("Unexpected error while selecting vendors", e);
		}

//
//		dh.selectUsingVisibleText(Mo.Vendor1(), "Digital Cinema Media Sdn Bhd"); // Cinema
//		log.info("vendor 1 has been passed");
//		Thread.sleep(2000);
//		dh.selectUsingVisibleText(Mo.Vendor2(), "MunSang Poh"); // Magazine
//		log.info("vendor 2 has been passed");
//		Thread.sleep(2000);
//		dh.selectUsingVisibleText(Mo.Vendor3(), "Exponential Interactive Singapore Pte (USD)"); // Newspaper
//		log.info("vendor 3 has been passed");
//		Thread.sleep(2000);
//		dh.selectUsingVisibleText(Mo.Vendor4(), "Ad-On-Bus Sdn Bhd"); // outdoor
//		log.info("vendor 4 has been passed");
//		Thread.sleep(2000);
//		dh.selectUsingVisibleText(Mo.Vendor5(), "APRILIS MAJU MEDIA"); // other
//		log.info("vendor 5 has been passed");
//		Thread.sleep(2000);
//		dh.selectUsingVisibleText(Mo.Vendor6(), "Adscreen Media Sdn Bhd");// Radio
//		log.info("vendor 6 has been passed");
//		Thread.sleep(2000);
//		dh.selectUsingVisibleText(Mo.Vendor7(), "CH-9 MEDIA SDN BHD");// TV
//		log.info("vendor 7 has been passed");

	}

	public void digital_vendor() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		String env = ObjectReader.reader.getEnv();

		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);

		String vendorValue;

		Thread.sleep(3000);
		if (env.equalsIgnoreCase("pi2")) {
			vendorValue = "7467|AUD|55.1900000|1|0|0|0|0";
		} else if (env.equalsIgnoreCase("devbr")) {
			vendorValue = "4640|MYR|1.0000000|1|1|1.5|1.5|0";
		} else if (env.equalsIgnoreCase("pdt")) {
			vendorValue = "3974|MYR|1.0000000|0|0|0|0|8";
		} else {
			vendorValue = "3974|MYR|1.0000000|0|0|0|0|8"; // default
			log.warn("Unknown environment: " + env + ". Using default vendor value: " + vendorValue);
		}
		dh.selectUsingValue(Mo.Vendor1(), vendorValue);
		log.info("Vendor1 selected based on env: " + env + " → " + vendorValue);

		log.info("vendor 1 has been passed");

	}

	public void cinemaPlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		String env = ObjectReader.reader.getEnv();
		log.info("Adding Cinema Placement.........");
		List<String> vendors = VendorReader.getVendorsForEnv(env); // Fetch vendors from Excel
		String vendor1 = vendors.size() >= 1 ? vendors.get(0) : "";

		if (vendor1.isEmpty()) {
			log.error("Vendor 1 not found for environment: " + env);
			return;
		}
		Thread.sleep(10000);

		WaitHelper w = new WaitHelper(driver);
		w.waitForElementVisibility(Mo.media_line(), 120);
		Mo.Add_media_line();
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());
		Thread.sleep(2000);

		// --------- mediaType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "657|C");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "8776|C");
		} else {
			log.warn("Unknown env for mediaType. Using default: 657|C");
			dh.selectUsingValue(Mo.pop_mediaType(), "657|C");
		}

		dh.selectUsingVisibleText(Mo.pop_vendor(), vendor1);
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());

		// --------- AdType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.Adtype_Others(), "26275");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.Adtype_Others(), "2286");
		} else {
			log.warn("Unknown env for AdType. Using default: 26275");
			dh.selectUsingValue(Mo.Adtype_Others(), "26275");
		}
		Mo.set_duration(5);
		Mo.set_Description("Cinema Placement");
		Mo.setClient_rate("1000");
		Mo.setVendor_rate("800");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		log.info("Ending of Cinema Placement line insertion.........");
		fh.switchTodefault();

	}

	public void magazinePlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		log.info("Adding Magazine Placement.........");
		String env = ObjectReader.reader.getEnv();
		List<String> vendors = VendorReader.getVendorsForEnv(env); // Fetch vendors from Excel
		String vendor2 = vendors.size() >= 2 ? vendors.get(1) : "";

		if (vendor2.isEmpty()) {
			log.error("Vendor 2 not found for environment: " + env);
			return;
		}
		Thread.sleep(10000);

		// fh.switchTodefault();
		WaitHelper w = new WaitHelper(driver);
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		w.waitForElementVisibility(Mo.media_line(), 120);
		Thread.sleep(10000);
		Mo.Add_media_line();
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());

		Thread.sleep(2000);

		// --------- mediaType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "240|M");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "8778|M");
		} else {
			log.warn("Unknown env for mediaType. Using default: 240|M");
			dh.selectUsingValue(Mo.pop_mediaType(), "240|M");
		}

		dh.selectUsingVisibleText(Mo.pop_vendor(), vendor2);
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());

		// --------- AdType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.Adtype_magazine(), "26196");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.Adtype_magazine(), "2290");
		} else {
			log.warn("Unknown env for AdType. Using default: 26196");
			dh.selectUsingValue(Mo.Adtype_magazine(), "26196");
		}
		// Mo.set_duration(5);

		Mo.set_Description_m("Magazine Placement");
		Mo.setClient_rate("1000");
		Mo.setVendor_rate("800");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		log.info("Ending of Magazine Placement line insertion.........");
		fh.switchTodefault();
	}

	public void newspaperPlacement() throws InterruptedException {

		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		log.info("Adding Newspaper Placement.........");
		String env = ObjectReader.reader.getEnv();
		List<String> vendors = VendorReader.getVendorsForEnv(env); // Fetch vendors from Excel
		String vendor3 = vendors.size() >= 3 ? vendors.get(2) : "";

		if (vendor3.isEmpty()) {
			log.error("Vendor 3 not found for environment: " + env);
			return;
		}
		Thread.sleep(10000);

		// fh.switchTodefault();
		WaitHelper w = new WaitHelper(driver);
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		w.waitForElementVisibility(Mo.media_line(), 120);
		Thread.sleep(10000);
		Mo.Add_media_line();
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());

		Thread.sleep(2000);

		// --------- mediaType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "4485|N");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "8779|N");
		} else {
			log.warn("Unknown env for mediaType. Using default: 4485|N");
			dh.selectUsingValue(Mo.pop_mediaType(), "4485|N");
		}

		dh.selectUsingVisibleText(Mo.pop_vendor(), vendor3);
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());

		// --------- AdType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.Adtype_newspaper(), "9395");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.Adtype_newspaper(), "2291");
		} else {
			log.warn("Unknown env for AdType. Using default: 26196");
			dh.selectUsingValue(Mo.Adtype_newspaper(), "26196");
		}
		Mo.newspaper_h("1");
		Mo.newspaper_w("1");
		Mo.set_Description_n("Newspaper Placement");
		Mo.setClient_rate("1000");
		Mo.setVendor_rate("800");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		log.info("Ending of Newspaper Placement line insertion.........");
		fh.switchTodefault();
	}

	public void outdoorPlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		log.info("Adding Outdoor Placement.........");
		String env = ObjectReader.reader.getEnv();
		List<String> vendors = VendorReader.getVendorsForEnv(env); // Fetch vendors from Excel
		String vendor4 = vendors.size() >= 4 ? vendors.get(3) : "";

		if (vendor4.isEmpty()) {
			log.error("Vendor 4 not found for environment: " + env);
			return;
		}
		Thread.sleep(10000);

		// fh.switchTodefault();
		WaitHelper w = new WaitHelper(driver);
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		w.waitForElementVisibility(Mo.media_line(), 120);
		Thread.sleep(10000);
		Mo.Add_media_line();
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());

		Thread.sleep(2000);

		// --------- mediaType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "618|O");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "8781|O");
		} else {
			log.warn("Unknown env for mediaType. Using default: 618|O");
			dh.selectUsingValue(Mo.pop_mediaType(), "618|O");
		}

		dh.selectUsingVisibleText(Mo.pop_vendor(), vendor4);
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());

		// --------- AdType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.Adtype_Others(), "26276");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.Adtype_Others(), "2293");
		} else {
			log.warn("Unknown env for AdType. Using default: 26276");
			dh.selectUsingValue(Mo.Adtype_Others(), "26276");
		}
		Mo.set_duration(5);
		Mo.set_Description("Outdoor Placement");
		Mo.setClient_rate("400");
		Mo.setVendor_rate("200");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		log.info("Ending of Outdoor Placement line insertion.........");
		fh.switchTodefault();
	}

	public void otherPlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		log.info("Adding Other Placement.........");
		String env = ObjectReader.reader.getEnv();
		List<String> vendors = VendorReader.getVendorsForEnv(env); // Fetch vendors from Excel
		String vendor5 = vendors.size() >= 5 ? vendors.get(4) : "";

		if (vendor5.isEmpty()) {
			log.error("Vendor 5 not found for environment: " + env);
			return;
		}
		Thread.sleep(2000);

		// fh.switchTodefault();
		WaitHelper w = new WaitHelper(driver);
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		w.waitForElementVisibility(Mo.media_line(), 120);
		Thread.sleep(10000);
		Mo.Add_media_line();
		fh.switchToFrame(ObjectReader.reader.Add_line());

		Thread.sleep(2000);

		// --------- mediaType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "4477|OT");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "8780|OT");
		} else {
			log.warn("Unknown env for mediaType. Using default: 4477|OT");
			dh.selectUsingValue(Mo.pop_mediaType(), "4477|OT");
		}

		dh.selectUsingVisibleText(Mo.pop_vendor(), vendor5);
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());

		// --------- AdType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.Adtype_Others(), "9374");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.Adtype_Others(), "2292");
		} else {
			log.warn("Unknown env for AdType. Using default: 9374");
			dh.selectUsingValue(Mo.Adtype_Others(), "9374");
		}
		Mo.set_duration(5);
		Mo.set_Description("Other Placement");
		Mo.setClient_rate("400");
		Mo.setVendor_rate("200");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		log.info("Ending of Others Placement line insertion.........");
		fh.switchTodefault();

	}

	public void radioPlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		log.info("Adding Radio Placement.........");
		String env = ObjectReader.reader.getEnv();
		List<String> vendors = VendorReader.getVendorsForEnv(env); // Fetch vendors from Excel
		String vendor6 = vendors.size() >= 6 ? vendors.get(5) : "";

		if (vendor6.isEmpty()) {
			log.error("Vendor 6 not found for environment: " + env);
			return;
		}
		Thread.sleep(2000);

		// fh.switchTodefault();
		WaitHelper w = new WaitHelper(driver);
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		w.waitForElementVisibility(Mo.media_line(), 120);
		Thread.sleep(10000);
		Mo.Add_media_line();
		fh.switchToFrame(ObjectReader.reader.Add_line());

		Thread.sleep(2000);

		// --------- mediaType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "615|R");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "8782|R");
		} else {
			log.warn("Unknown env for mediaType. Using default: 615|R");
			dh.selectUsingValue(Mo.pop_mediaType(), "615|R");
		}

		dh.selectUsingVisibleText(Mo.pop_vendor(), vendor6);
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());

		// --------- AdType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.Adtype_radio(), "276");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.Adtype_radio(), "2294");
		} else {
			log.warn("Unknown env for AdType. Using default: 276");
			dh.selectUsingValue(Mo.Adtype_radio(), "276");
		}
		Mo.set_Description_R("Radio Placement");
		Mo.setClient_rate("400");
		Mo.setVendor_rate("200");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		log.info("Ending of Radio Placement line insertion.........");
		fh.switchTodefault();

	}

	public void tvPlacement() throws InterruptedException {
		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		log.info("Adding TV Placement.........");
		String env = ObjectReader.reader.getEnv();
		List<String> vendors = VendorReader.getVendorsForEnv(env); // Fetch vendors from Excel
		String vendor7 = vendors.size() >= 7 ? vendors.get(6) : "";

		if (vendor7.isEmpty()) {
			log.error("Vendor 7 not found for environment: " + env);
			return;
		}
		Thread.sleep(2000);

		// fh.switchTodefault();
		WaitHelper w = new WaitHelper(driver);
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		w.waitForElementVisibility(Mo.media_line(), 120);
		Thread.sleep(10000);
		Mo.Add_media_line();
		fh.switchToFrame(ObjectReader.reader.Add_line());

		Thread.sleep(2000);

		// --------- mediaType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "613|TV");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "8783|TV");
		} else {
			log.warn("Unknown env for mediaType. Using default: 613|TV");
			dh.selectUsingValue(Mo.pop_mediaType(), "613|TV");
		}

		dh.selectUsingVisibleText(Mo.pop_vendor(), vendor7);
		Thread.sleep(2000);
		Mo.Proceed_btn();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(2000);
		fh.switchToFrame(ObjectReader.reader.Add_line());

		// --------- AdType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.Adtype_TV(), "10588");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.Adtype_TV(), "2327");
		} else {
			log.warn("Unknown env for AdType. Using default: 10588");
			dh.selectUsingValue(Mo.Adtype_TV(), "10588");
		}
		Mo.set_Description_TV("TV Placement");
		Mo.setClient_rate("400");
		Mo.setVendor_rate("200");
		Mo.Entering_Spots();
		Mo.Placement_line_add();
		log.info("Ending of TV Placement line insertion.........");
		fh.switchTodefault();

	}

	public void digital_placement() throws InterruptedException {

		ObjectReader.reader = new PropertyReader();
		MenuObjects Mo = new MenuObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		FrameHelper fh = new FrameHelper(driver);
		WaitHelper w = new WaitHelper(driver);
		log.info("Adding Digital Placement.........");
		String env = ObjectReader.reader.getEnv();

		Thread.sleep(2000);
		w.waitForElementVisibility(Mo.media_line(), 30);
		Thread.sleep(10000);
		Mo.Add_media_line();
		fh.switchToFrame(ObjectReader.reader.Add_line());

		// --------- mediaType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "3721|I");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.pop_mediaType(), "8777|I");
		} else {
			log.warn("Unknown env for mediaType. Using default: 3721|I");
			dh.selectUsingValue(Mo.pop_mediaType(), "3721|I");
		}

		// --------- vendor index fix ---------
		dh.selectUsingIndex(Mo.pop_vendor(), 0);
		Mo.Proceed_btn();

		// --------- AdType env-wise select ---------
		if (env.equalsIgnoreCase("devbr")) {
			dh.selectUsingValue(Mo.Adtype_Digital(), "9151");
		} else if (env.equalsIgnoreCase("pi2")) {
			dh.selectUsingValue(Mo.Adtype_Digital(), "2328");
		} else {
			log.warn("Unknown env for AdType. Using default: 9151");
			dh.selectUsingValue(Mo.Adtype_Digital(), "9151");
		}

		// --------- Remaining steps ---------
		Mo.set_Description_d("Digital Placement");
		Mo.Entering_Digital_Spots("2000");
		Mo.Placement_line_add();
		log.info("Ending of Digital Placement line insertion.........");
	}
}