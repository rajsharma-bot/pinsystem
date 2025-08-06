package com.pin.automation.pageObjects;

import java.awt.Menu;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pin.automation.utils.FileSaver;
import com.pin.automation.utils.FrameHelper;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.PopupHandler;
import com.pin.automation.utils.ResourceHelper;
import com.pin.automation.utils.WaitHelper;

public class MenuObjects {

	private static Logger log = LogManager.getLogger(MenuObjects.class);

	WebDriver driver;
	WebDriverWait wait;

	public MenuObjects(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //// global WebDriverWait
	}

	// Generic method to click elements
	public void clickElement(By locator, String elementName) {
		WebElement element = waitForElementToBeClickable(locator);
		if (element != null) {
			element.click();
			log.info(elementName + " clicked successfully.");
		}
	}

	private WebElement waitForElementToBeClickable(By locator) {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			log.error("Element not clickable: " + locator);
			return null;
		}
	}

	// Generic method to send text to an element
	public void sendText(By locator, String text, String elementName) {
		WebElement element = waitForElementToBeVisible(locator);
		if (element != null) {
			element.clear();
			element.sendKeys(text);
			log.info("Text '" + text + "' entered in " + elementName);
		}
	}

	// Wait for visibility of an element
	private WebElement waitForElementToBeVisible(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error("Element not visible: " + locator);
			return null;
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////
	public void ListCampaign_page() {
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		clickElement(MenuPageObjects.ListCampaign, "List Campaign");
	}

	public void CampaignPlanningTab() {
		log.info("Switched to Planning Tab");
		clickElement(MenuPageObjects.PLANNING_TAB, "Campaign Planning tab");
	}

	public void CampaignBuyingTab() {
		log.info("Switched to Buying Tab");
		clickElement(MenuPageObjects.BUYING_TAB, "Campaign Buying tab");
	}

	public void CampaignReadyToBillTab() {
		log.info("Switched to Ready To Bill Tab");
		clickElement(MenuPageObjects.READYTOBILL_TAB, "Campaign Ready To bill tab");
	}

	public void CampaignCloseTab() {
		log.info("Switched to Close Tab");
		clickElement(MenuPageObjects.CLOSE_TAB, "Campaign close tab");
	}

	public void CampaignCancelTab() {
		log.info("Switched to Cancel Tab");
		clickElement(MenuPageObjects.CANCEL_TAB, "Campaign Cancel tab");
	}

	public void Campaign_no(String campaignName) {
		sendText(MenuPageObjects.SEARCH_CAM, campaignName, "Campaign Name");
		log.info(campaignName + "Has been passed");
	}

	public void Campaign_searchbutton() {
		driver.findElement(MenuPageObjects.Find_buttonC).click();
	}

	public void click_record() {
		driver.findElement(MenuPageObjects.C_NUMBER).click();
	}

	public void clickOnCampaignNo() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(MenuPageObjects.campaign_number).click();
	}

	// Element for List Schedule
	public void ListSchedule_page() {
		FrameHelper FrameHelper = new FrameHelper(driver);

		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		log.info("List Schedule has been clicked");
		clickElement(MenuPageObjects.ListSchedule, "List Schedule");

		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
	}

	public void Schedule_ConfirmedTab() {
		try {
			Thread.sleep(10000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.Confirmed_Tab));
			log.info("Switched to Confirmed Tab");
			clickElement(MenuPageObjects.Confirmed_Tab, "Schedule Confirmed tab");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Schedule_PendingTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.Pending_Tab));
		log.info("Switched to Pending Tab");
		clickElement(MenuPageObjects.Pending_Tab, "Schedule Pending tab");
	}

	public void Schedule_CancelledTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.Cancelled_Tab));
		log.info("Switched to Cancelled Tab");
		clickElement(MenuPageObjects.Cancelled_Tab, "Schedule Cancelled tab");
	}

	public void Schedule_RevisionTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.Revision_Tab));
		log.info("Switched to Revision Tab");
		clickElement(MenuPageObjects.Revision_Tab, "Schedule Revision tab");
	}

	// Element for List MO
	public void ListMO_page() {
		log.info("List MO has been Clicked");
		clickElement(MenuPageObjects.ListMO, "List MO");

	}

	public void Confirmed_MOTab() {
		log.info("Switched to Confirm MO Tab");
		clickElement(MenuPageObjects.ConfirmedMO_Tab, "Confirm MediaOrder tab");
	}

	public void Pending_MOTab() {
		log.info("Switched to Pending MO Tab");
		clickElement(MenuPageObjects.PendingMO_Tab, "Pending MediaOrder tab");

	}

	public void Cancelled_MOTab() {
		log.info("Switched to Cancelled MO Tab");
		clickElement(MenuPageObjects.CancelledMO_Tab, "Cancelled MediaOrder tab");

	}

	// Search Schedule Page
	public WebElement monthDll() {
		WebElement dropDownMonth = driver.findElement(MenuPageObjects.monthDll);
		return dropDownMonth;

	}

	public WebElement yearDll() {
		WebElement dropDownYear = driver.findElement(MenuPageObjects.yearDll);
		return dropDownYear;

	}

	public void searchSchedule(String ScheduleNo) {
		log.info("Clicked on free text");
		// driver.findElement(MenuPageObjects.searchText).click();
		clickElement(MenuPageObjects.searchText, "Schedule number has been passed");
		log.info("Passing shedule no");
		// driver.findElement(MenuPageObjects.searchText).sendKeys(ScheduleNo);
		sendText(MenuPageObjects.searchText, ScheduleNo, "Schedule number has been passed");
		log.info("Schedule no is passed");
	}

	public void findButton() {
		log.info("Clicked  on find button");
		// driver.findElement(MenuPageObjects.findButton).click();
		clickElement(MenuPageObjects.findButton, "Clicked on Find button");

	}

	public void clickOnRecord() throws InterruptedException {
		Thread.sleep(20000);
		log.info("Clicked on searched record");
		clickElement(MenuPageObjects.SearchSchedule, "Clicked on searched record");

	}

	public boolean tabText() {
		boolean d = driver.findElement(MenuPageObjects.SearchSchedule).isDisplayed();
		log.info(d);
		return d;
	}

	public String labelText() {
		String labelText = driver.findElement(MenuPageObjects.lableText).getText();
		return labelText;
	}

	// New Campaign
	public void newCampaign() {
		FrameHelper FrameHelper = new FrameHelper(driver);

		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());

		log.info("New Campaign has been clicked");
		// driver.findElement(MenuPageObjects.NewCampaign).click();
		clickElement(MenuPageObjects.NewCampaign, "Click on New Schedule button");

//		FrameHelper.switchTodefault();
//		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
	}

	public WebElement clientDDL() throws InterruptedException {
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		Thread.sleep(1000);
		WebElement DDL_Client = driver.findElement(MenuPageObjects.ClientDDL);
		Thread.sleep(1000);
		return DDL_Client;

	}

	public WebElement AA_ALL() {
		WebElement DDL_AA = driver.findElement(MenuPageObjects.AA_ALL);
		log.info("Click on List All dropdown");
		return DDL_AA;
	}

	public void Find_ALL() {
		// driver.findElement(MenuPageObjects.Find_AA).click();
		clickElement(MenuPageObjects.Find_AA, "Find AA button");
	}

	public WebElement soldToParty() throws InterruptedException {
		Thread.sleep(1000);
		WebElement DDL_STP = driver.findElement(MenuPageObjects.SoldToParty);
		return DDL_STP;

	}

	public WebElement serviceBy() throws InterruptedException {
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		WebElement DDL_Service = driver.findElement(MenuPageObjects.searchBY);
		return DDL_Service;
	}

	public WebElement Campaign_search() {
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		WebElement DDL_SEARCH = driver.findElement(MenuPageObjects.SEARCH_BY);
		return DDL_SEARCH;
	}

	public void StartDate(String startdate) throws InterruptedException {

		driver.findElement(MenuPageObjects.StartDate).clear();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		// driver.findElement(MenuPageObjects.StartDate).sendKeys(startdate);
		sendText(MenuPageObjects.StartDate, startdate, "Passing Start Date");
	}

	public void EndDate(String EndDate) throws InterruptedException {
		driver.findElement(MenuPageObjects.EndDate).clear();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// driver.findElement(MenuPageObjects.EndDate).sendKeys(EndDate);
		sendText(MenuPageObjects.EndDate, EndDate, "Passing End Date");

	}

	public void label() {
		if (driver.findElements(MenuPageObjects.label_digital).size() > 0) {
			checkBox(); // Call your method to click the checkbox
		} else {
			System.out.println("Linkedin label not found on UI.");
		}
	}

	public static By getMediaTitleLabel(String title) {
		return By.xpath("//label[text()='" + title + "']");
	}

	public WebElement Product() throws InterruptedException {
		Thread.sleep(1000);
		WebElement DDL_Product = driver.findElement(MenuPageObjects.ProductDDL);
		return DDL_Product;

	}

	public WebElement Contract() throws InterruptedException {
		Thread.sleep(1000);
		WebElement ddl_Contract = driver.findElement(MenuPageObjects.ContractDDL);
		return ddl_Contract;

	}

	public void CampaignName(String campaignName) {
		log.info("Passing Campaign Name");
//		driver.findElement(MenuPageObjects.Campaign_name).sendKeys(campaignName);
		sendText(MenuPageObjects.Campaign_name, campaignName, "Passing Campaign name has been passed");
	}

	public void Save() {
		log.info("Clicking on Save button");
		// driver.findElement(MenuPageObjects.SaveOnlyAndViewCampaign).click();
		clickElement(MenuPageObjects.SaveOnlyAndViewCampaign, "Click on Save Only And View Campaign ");
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
		} else {
			log.info("No alert");
//			driver.findElement(MenuPageObjects.SaveOnlyAndViewCampaign).click();
			clickElement(MenuPageObjects.SaveOnlyAndViewCampaign, "Click on Save Only And View Campaign ");
		}
	}

	public WebElement mediaType() throws InterruptedException {
		Thread.sleep(2000);
		WebElement ddl_mediaType = driver.findElement(MenuPageObjects.MediaType);
		return ddl_mediaType;
	}

	public void searchTitle(String media_title) throws InterruptedException {
		driver.findElement(MenuPageObjects.Search_MediaTitle).clear();
		// driver.findElement(MenuPageObjects.Search_MediaTitle).sendKeys(media_title);
		sendText(MenuPageObjects.Search_MediaTitle, media_title, "Searching media title");
		Thread.sleep(3000);
	}

	public boolean checkBox() {
		try {
			WebElement checkbox = driver.findElement(MenuPageObjects.checkBox);
			if (!checkbox.isSelected()) {
				clickElement(MenuPageObjects.checkBox, "Select Checkbox");
			}
			return checkbox.isDisplayed();
		} catch (NoSuchElementException e) {
			log.error("Checkbox not found", e);
			return false;
		}
	}

	public void campaignCode() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		String filePath = ResourceHelper.getCampaignCode();
		Boolean value = driver.findElement(MenuPageObjects.CampaignCode).isDisplayed();
		if (value == true) {
			log.info("Campaign has been created");
			log.info(driver.findElement(MenuPageObjects.CampaignCode).getText());
			FileSaver.saveTextToFile(driver.findElement(MenuPageObjects.CampaignCode).getText(), filePath);
		} else {
			log.error("Campaign is not created");
		}

	}

	public String verifycampaignCode() {
		String campaign_code = driver.findElement(MenuPageObjects.CampaignCode).getText();
		return campaign_code;
	}

	/**
	 * @Case :: New schedule
	 */

	public void new_schedule() {
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());

		// driver.findElement((MenuPageObjects.New_schedule)).click();
		clickElement(MenuPageObjects.New_schedule, "New schedule");

//		FrameHelper.switchTodefault();
//		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
	}

	public WebElement pop_mediaType() {
		driver.findElement(MenuPageObjects.pop_media);
		WebElement selectElement = driver.findElement(MenuPageObjects.pop_media);
		log.info("Selecting Media title");
		return selectElement;
	}

	public WebElement pop_vendor() {
		driver.findElement(MenuPageObjects.pop_up_vendor);
		WebElement selectElement = driver.findElement(MenuPageObjects.pop_up_vendor);
		log.info("Selecting vendor");
		return selectElement;
	}

	public void Proceed_btn() throws InterruptedException {
//		Thread.sleep(5000);
//		log.info("Clicking on Proceed Btn");
//		driver.findElement(MenuPageObjects.proceed_btn).click();
//		Thread.sleep(5000);

		WaitHelper waitHelper = new WaitHelper(driver);
		WebElement proceed_btn = waitHelper.waitForElementVisibility(MenuPageObjects.proceed_btn, 40);
		try {
			proceed_btn.click();
		} catch (Exception e) {
			log.info("Unable to click with Proceed btn");
		}

	}

	public void Schedule_Grid() throws InterruptedException {

		Thread.sleep(10000);
		driver.findElement(MenuPageObjects.Schedule_Grid).click();
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
		} else if (driver.findElement(MenuPageObjects.schedule_grid_error).isDisplayed()) {
			driver.findElement(MenuPageObjects.Schedule_Grid).click();
			if (driver.switchTo().alert() != null) {
				driver.switchTo().alert().accept();
			}

		} else {
			log.info("No alert");
		}

	}

	public void newspaper_h(String height) {
		driver.findElement(MenuPageObjects.Newspaper_H).sendKeys(height);
	}

	public void newspaper_w(String width) {
		driver.findElement(MenuPageObjects.Newspaper_W).sendKeys(width);
	}

	public void fee(String fee1) {

		if (driver.findElement(MenuPageObjects.fee1).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.fee1).clear();
			driver.findElement(MenuPageObjects.fee1).sendKeys(fee1);
		} else {
			log.info("field is not visible due to contract has been selected ");
		}
	}

	public void fee2(String fee2) {

		if (driver.findElement(MenuPageObjects.fee2).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.fee2).clear();
			driver.findElement(MenuPageObjects.fee2).sendKeys(fee2);
		} else {
			log.info("field is not visible due to contract has been selected ");
			driver.findElement(MenuPageObjects.fee2).isDisplayed();
		}

	}

	public void close_popUp() {
		try {
			if (driver.findElement(MenuPageObjects.layout_popup_close).isDisplayed()) {
				driver.findElement(MenuPageObjects.layout_popup_close).click();
				WebElement layout_pop = driver.findElement(MenuPageObjects.layout_popup_close);
				WaitHelper a = new WaitHelper(driver);
				a.waitForInvisibilityofElementLocatedBy(layout_pop, 300);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Failed to close layout pop up", e);
		}
	}

//	public void Entering_Spots() {
//		WebElement parentElement = driver.findElement(MenuPageObjects.divCalendar);
//		List<WebElement> childElements = parentElement.findElements(MenuPageObjects.txt_Spot);
//
//		// Iterate through each text box element and send keys
//		for (WebElement txt_spots : childElements) {
//
//			txt_spots.click();
//			txt_spots.sendKeys("1");
//			txt_spots.sendKeys(Keys.TAB);
//		}
//
//	}
//	
	public void Entering_Spots() {
		WebElement parentElement = driver.findElement(MenuPageObjects.divCalendar);
		List<WebElement> childElements = parentElement.findElements(MenuPageObjects.txt_Spot);

		// Shuffle the list to randomize the order
		Collections.shuffle(childElements);

		// Select the first 20 text boxes from the shuffled list
		List<WebElement> selectedTextBoxes = childElements.subList(0, Math.min(10, childElements.size()));

		// Iterate through the selected text boxes and send keys
		for (WebElement txt_spots : selectedTextBoxes) {
			txt_spots.click();
			txt_spots.sendKeys("1");
			txt_spots.sendKeys(Keys.TAB);
		}
	}

	public void Daily_Budget(String budget) {
		driver.findElement(MenuPageObjects.budget).sendKeys(budget);
		log.info("Daily Budget has been passed" + " " + budget);
	}

	public void Entering_Digital_Spots(String value) {
		// Find all text boxes matching the XPath
		List<WebElement> inputFields = driver.findElements(MenuPageObjects.ClientAndVendorRates);
		// Iterate over the found elements and set their values
		for (WebElement inputField : inputFields) {
			inputField.click();
			inputField.clear();
			inputField.sendKeys(value);
		}
		log.info("rate has been passed");
	}

	public void setClient_rate(String txt_client) {
		driver.findElement(MenuPageObjects.ClientRate).click();
		driver.findElement(MenuPageObjects.ClientRate).clear();
		driver.findElement(MenuPageObjects.ClientRate).sendKeys(txt_client);
	}

	public void setVendor_rate(String txt_vendor) {
		driver.findElement(MenuPageObjects.VendorRate).click();
		driver.findElement(MenuPageObjects.VendorRate).clear();
		driver.findElement(MenuPageObjects.VendorRate).sendKeys(txt_vendor);
	}

	public void set_Description(String txt) {
		driver.findElement(MenuPageObjects.txt_Others_Description).isDisplayed();
		driver.findElement(MenuPageObjects.txt_Others_Description).sendKeys(txt);
		log.info("Remark has been passed for Other media type placement line");
	}

	public void set_Description_m(String txt) {
		driver.findElement(MenuPageObjects.txt_Magazine_Description).isDisplayed();
		driver.findElement(MenuPageObjects.txt_Magazine_Description).sendKeys(txt);
		log.info("Remark has been passed for magazine placement line");
	}

	public void set_Description_n(String txt) {
		driver.findElement(MenuPageObjects.txt_News_Description).isDisplayed();
		driver.findElement(MenuPageObjects.txt_News_Description).sendKeys(txt);
		log.info("Remark has been passed for newspaper placement line");
	}

	public void set_Description_R(String txt) {
		driver.findElement(MenuPageObjects.txt_Radio_Description).isDisplayed();
		driver.findElement(MenuPageObjects.txt_Radio_Description).sendKeys(txt);
		log.info("Remark has been passed for Radio placement line");
	}

	public void set_duration(int value) {
		log.info("Adding duration");
		driver.findElement(MenuPageObjects.Duration).sendKeys(String.valueOf(value));
	}

	public void set_Description_TV(String txt) {
		driver.findElement(MenuPageObjects.txt_TV_Description).isDisplayed();
		driver.findElement(MenuPageObjects.txt_TV_Description).sendKeys(txt);
		log.info("Remark has been passed for TV placement line");
	}

	public void set_Description_d(String txt) {
		driver.findElement(MenuPageObjects.txt_Digital_Description).isDisplayed();
		driver.findElement(MenuPageObjects.txt_Digital_Description).sendKeys(txt);
		log.info("Remark has been passed for Digital placement line");
	}

	public WebElement vendorCurrency() throws InterruptedException {
		Thread.sleep(2000);
		WebElement ddl_vendor_curr = driver.findElement(MenuPageObjects.vendor_currency);
		return ddl_vendor_curr;
	}

	public void editMedia_popUp() throws InterruptedException {
		Thread.sleep(20000);
		PopupHandler.closeEditMediaOrderPopups(driver, log);
	}

	// ----------------List AA

	public void listAA() {
		log.info("Switched to list AA");
		// driver.findElement(MenuPageObjects.ListAA).click();
		clickElement(MenuPageObjects.ListAA, "List AA page");
	}

	public void AA_Label() {
		driver.findElement(MenuPageObjects.AA_number).click();
		boolean isDisplayed = driver.findElement(MenuPageObjects.AA_label).isDisplayed();
		String AA_Nos = driver.findElement(MenuPageObjects.AA_label).getText();
		if (isDisplayed == true) {
			log.info("Successfully landed on AA page " + AA_Nos);
		} else {
			log.info("Unable to redirect to AA page");
		}
	}

	public void media_layout() {
		if (driver.findElement(MenuPageObjects.layout_popUp).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.selectMediaLayout).click();
			log.info("Media layout is displayed");
		}
	}

	public void select_media_layout() {

		FrameHelper FrameHelper = new FrameHelper(driver);

		if (driver.findElement(MenuPageObjects.selectMediaLayout).isDisplayed()) {
			FrameHelper.switchTodefault();
			FrameHelper.switchToFrame(ObjectReader.reader.pop_up_frame());
			driver.findElement(MenuPageObjects.selectMediaLayout).click();
			log.info("Media layout is selected");
		} else {
			log.info("Media layout is ignored");
		}
		FrameHelper.switchTodefault();
		// Thread.sleep(1000);
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());

	}

	public void Add_media_line() throws InterruptedException {
		Thread.sleep(10000);
		log.info("Clicked on media line");
		driver.findElement(MenuPageObjects.AddMediaLine).click();
		Thread.sleep(10000);

	}

	public WebElement media_line() throws InterruptedException {
		Thread.sleep(5000);
		WebElement menu = driver.findElement(MenuPageObjects.AddMediaLine);
		log.info("Add Media line button is visible");
		return menu;
	}

	public void Placement_line_add() {
		driver.findElement(MenuPageObjects.Add_Placement_line).click();
	}

	public WebElement Adtype_Others() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for up to 20 seconds

		try {
			WebElement adTypeElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.Adtype_Others));
			if (adTypeElement.isDisplayed()) {
				adTypeElement.click();
				log.info("Other (cinema, Other & outdoor) ad type has been selected");
				return adTypeElement;
			}

			log.info("No ad type element is displayed");
		} catch (Exception e) {
			log.error("Exception occurred while selecting ad type: " + e.getMessage());
		}
		return null;
	}

	public WebElement Adtype_newspaper() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for up to 20 seconds

		try {
			WebElement adTypeElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.AdType_N));
			if (adTypeElement.isDisplayed()) {
				adTypeElement.click();
				log.info("Newspaper ad type has been selected");
				return adTypeElement;
			}

			log.info("No ad type element is displayed");
		} catch (Exception e) {
			log.error("Exception occurred while selecting ad type: " + e.getMessage());
		}
		return null;
	}

	public WebElement Adtype_magazine() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for up to 20 seconds

		try {
			WebElement adTypeElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.Adtype_M));
			if (adTypeElement.isDisplayed()) {
				adTypeElement.click();
				log.info("Newspaper ad type has been selected");
				return adTypeElement;
			}

			log.info("No ad type element is displayed");
		} catch (Exception e) {
			log.error("Exception occurred while selecting ad type: " + e.getMessage());
		}
		return null;
	}

	public WebElement Adtype_radio() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for up to 20 seconds

		try {
			WebElement adTypeElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.AdType_R));
			if (adTypeElement.isDisplayed()) {
				adTypeElement.click();
				log.info("Newspaper ad type has been selected");
				return adTypeElement;
			}

			log.info("No ad type element is displayed");
		} catch (Exception e) {
			log.error("Exception occurred while selecting ad type: " + e.getMessage());
		}
		return null;
	}

	public WebElement Adtype_TV() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for up to 20 seconds

		try {
			WebElement adTypeElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.AdType_TV));
			if (adTypeElement.isDisplayed()) {
				adTypeElement.click();
				log.info("Newspaper ad type has been selected");
				return adTypeElement;
			}

			log.info("No ad type element is displayed");
		} catch (Exception e) {
			log.error("Exception occurred while selecting ad type: " + e.getMessage());
		}
		return null;
	}

	public WebElement Adtype_Digital() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
		try {
			WebElement adTypeElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.Adtype_D));
			if (adTypeElement.isDisplayed()) {
				adTypeElement.click();
				log.info("Digital ad type has been selected");
				return adTypeElement;
			}

			log.info("No ad type element is displayed");
		} catch (Exception e) {
			log.error("Exception occurred while selecting ad type: " + e.getMessage());
		}
		return null;
	}

	private void handleAlert() {
		try {
			if (driver.switchTo().alert() != null) {
				driver.switchTo().alert().accept();
				log.info("Alert accepted.");
			}
		} catch (Exception e) {
			log.info("No alert to accept.");
		}
	}

	// Vendor Selection
	public WebElement Vendor1() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL);
		log.info("vendor has been passed");
		return DDL_vendor;
	}

	public WebElement Vendor2() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL2).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL2);
		log.info("vendor has been passed");
		return DDL_vendor;
	}

	public WebElement Vendor3() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL3).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL3);
		log.info("vendor has been passed");
		return DDL_vendor;
	}

	public WebElement Vendor4() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL4).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL4);
		log.info("vendor has been passed");
		return DDL_vendor;
	}

	public WebElement Vendor5() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL5).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL5);
		log.info("vendor has been passed");
		return DDL_vendor;
	}

	public WebElement Vendor6() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL6).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL6);
		log.info("vendor has been passed");
		return DDL_vendor;
	}

	public WebElement Vendor7() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL7).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL7);
		log.info("vendor has been passed");
		return DDL_vendor;
	}

	public void getScheduleSummary() {
		log.info("Clicked on Schedule tab");
		driver.findElement(MenuPageObjects.scheduleSummaryTab).click();
	}

	public void selectCheckBox() {
		log.info("Selecting Check box");
		driver.findElement(MenuPageObjects.selectCheckBox).click();
	}

	public void uploadClientPO() {
		log.info("Click On Upload client PO");
		driver.findElement(MenuPageObjects.uploadClientPO).click();
	}

	public void setClientPONumber(String poNumber) {
		log.info("set client PO number");
		driver.findElement(MenuPageObjects.setPONumber).sendKeys(poNumber);
	}

	public void setFileInput() {

		File file = new File("src/main/resources/PO1.JPG");
		String absolutePath = file.getAbsolutePath();
		WebElement fileInput = driver.findElement(MenuPageObjects.setFileInput);
		fileInput.sendKeys(absolutePath);
	}

	public void setAmount() {
		log.info("Getting Gross amount");
		String getAmount = driver.findElement(MenuPageObjects.getAmount).getText(); // Gettting final gross amount
		log.info("Gross amount is :" + getAmount);

		// Remove commas from amount string
		String cleanedAmount = getAmount.replaceAll(",", "");

		log.info("Set PO amount");
		WebElement setAmount = driver.findElement(MenuPageObjects.setAmount); // setting final gross amount in po Amount
		setAmount.sendKeys(cleanedAmount);
	}

	public void inclFeeCheckbox() {
		driver.findElement(MenuPageObjects.inclFee).click();
	}

	public void inclTaxCheckbox() {
		driver.findElement(MenuPageObjects.inclTax).click();
	}

	public void saveclientPO() {
		driver.findElement(MenuPageObjects.saveClientPO).click();
	}

	public void getClientPONumber() {
		Boolean getClientPONumber = driver.findElement(MenuPageObjects.clientPONumber).isDisplayed();
		if (getClientPONumber == true) {
			log.info("Client PO Number is created sucessfully");
		} else {
			log.info("Client PO number is not generated");
		}

	}

	public void uploadScheduleDoc() {
		driver.findElement(MenuPageObjects.uploadScheduleDoc).click();
	}

	public void setFileScheduleDoc() {

		File file = new File("src/main/resources/PO1.JPG");
		String absolutePath = file.getAbsolutePath();
		WebElement fileInput = driver.findElement(MenuPageObjects.fileScheduleDoc);
		fileInput.sendKeys(absolutePath);
	}

	public void saveUploadScheduleDoc() {
		log.info("Clicking on Save button");
		driver.findElement(MenuPageObjects.saveUploadScheduleDoc).click();
	}

	public void tickCheckBox() {
		log.info("Selecting Check box");
		driver.findElement(MenuPageObjects.firstCheckBox).click();
	}

	public void getAttachedIcon() {
		log.info("Checking if doc is uploaded for schedule docs");
		Boolean isdisplayed = driver.findElement(MenuPageObjects.attachmentIcon).isDisplayed();
		if (isdisplayed == true) {
			log.info("Document uploaded successfully");
		} else {
			log.info("document is not uploaded");
		}
	}

	public void clickOnBillingRequest() {
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		driver.findElement(MenuPageObjects.billingRequest.billingRequest).click();
	}

	public WebElement setSearchBY() {
		FrameHelper FrameHelper = new FrameHelper(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		WebElement DDL_SEARCH = driver.findElement(MenuPageObjects.billingRequest.searchBy);
		return DDL_SEARCH;
	}

	public void searchByText(String value) {
		WebElement textSearch = driver.findElement(MenuPageObjects.billingRequest.searchTextBox);
		textSearch.sendKeys(value);
	}

	public void clientPOEndDate(String EndDate) throws InterruptedException {
		driver.findElement(MenuPageObjects.billingRequest.endDate).clear();
		if(driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();	
		}
		Thread.sleep(1000);
		// driver.findElement(MenuPageObjects.EndDate).sendKeys(EndDate);
		sendText(MenuPageObjects.billingRequest.endDate, EndDate, "Passing End Date");

	}
	
	public void clientPOStartDate(String startdate) throws InterruptedException {

		driver.findElement(MenuPageObjects.billingRequest.startDate).clear();
		if(driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();	
		}

		// driver.findElement(MenuPageObjects.StartDate).sendKeys(startdate);
		sendText(MenuPageObjects.billingRequest.startDate, startdate, "Passing Start Date");
	}
	
	public void clickOnFind() {
		log.info("Clicked on Find button");
		WebElement click= driver.findElement(MenuPageObjects.billingRequest.clickFind);
		click.click();
	}
	
}
