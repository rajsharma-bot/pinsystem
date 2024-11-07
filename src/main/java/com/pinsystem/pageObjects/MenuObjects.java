package com.pinsystem.pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pinsystem.utils.FileSaver;
import com.pinsystem.utils.WaitHelper;

public class MenuObjects {

	private static Logger log = LogManager.getLogger(MenuObjects.class);

	WebDriver driver;
	WebDriverWait wait;

	public MenuObjects(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //// global WebDriverWait
	}
///////////////////////////////////////////////////////////Just for Testing
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

	// Element for List Schedule
	public void ListSchedule_page() {
		log.info("List Schedule has been clicked");
		clickElement(MenuPageObjects.ListSchedule, "List Schedule");
	}

	public void Schedule_ConfirmedTab() {
		log.info("Switched to Confirmed Tab");
		clickElement(MenuPageObjects.Confirmed_Tab, "Schedule Confirmed tab");
	}

	public void Schedule_PendingTab() {
		log.info("Switched to Pending Tab");
		clickElement(MenuPageObjects.Pending_Tab, "Schedule Pending tab");
	}

	public void Schedule_CancelledTab() {
		log.info("Switched to Cancelled Tab");
		clickElement(MenuPageObjects.Cancelled_Tab, "Schedule Cancelled tab");
	}

	public void Schedule_RevisionTab() {
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
		driver.findElement(MenuPageObjects.searchText).click();
		log.info("Passing shedule no");
		driver.findElement(MenuPageObjects.searchText).sendKeys(ScheduleNo);
		log.info("Schedule no is passed");
	}

	public void findButton() {
		log.info("Clicked  on find button");
		driver.findElement(MenuPageObjects.findButton).click();

	}

	public void clickOnRecord() {
		driver.findElement(MenuPageObjects.SearchSchedule).click();
		log.info("Clicked on searched record");
	}

	public boolean tabText() {
		boolean d = driver.findElement(MenuPageObjects.SearchSchedule).isDisplayed();
		log.info(d);
		return d;
	}

	// --------------------------Test Code-------------------------------

	public String labelText() {
		String labelText = driver.findElement(MenuPageObjects.lableText).getText();
		return labelText;
	}

	// New Campaign
	public void newCampaign() {
		log.info("New Campaign has been clicked");
		driver.findElement(MenuPageObjects.NewCampaign).click();
	}

	public WebElement clientDDL() throws InterruptedException {
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
		//driver.findElement(MenuPageObjects.Find_AA).click();
		clickElement(MenuPageObjects.Find_AA, "Find AA button");
	}

	public WebElement soldToParty() throws InterruptedException {
		Thread.sleep(1000);
		WebElement DDL_STP = driver.findElement(MenuPageObjects.SoldToParty);
		return DDL_STP;

	}

	public WebElement Campaign_search() {
		WebElement DDL_SEARCH = driver.findElement(MenuPageObjects.SEARCH_BY);
		return DDL_SEARCH;
	}

//	public void StartDate() {
//		driver.findElement(MenuPageObjects.StartDate).clear();
//		driver.switchTo().alert().accept();
//	}

	public void StartDate(String startdate) throws InterruptedException {
		
		driver.findElement(MenuPageObjects.StartDate).clear();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		driver.findElement(MenuPageObjects.StartDate).sendKeys(startdate);

	}

//	public void EndDate() {
//		driver.findElement(MenuPageObjects.EndDate).clear();
//		driver.switchTo().alert().accept();
//
//	}

	public void EndDate(String EndDate) throws InterruptedException {
		driver.findElement(MenuPageObjects.EndDate).clear();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.EndDate).sendKeys(EndDate);

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
		driver.findElement(MenuPageObjects.Campaign_name).sendKeys(campaignName);
	}

	public void Save() {
		driver.findElement(MenuPageObjects.SaveOnlyAndViewCampaign).click();
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
		} else {
			log.info("No alert");
			driver.findElement(MenuPageObjects.SaveOnlyAndViewCampaign).click();
		}
	}

	public WebElement mediaType() throws InterruptedException {
		Thread.sleep(2000);
		WebElement ddl_mediaType = driver.findElement(MenuPageObjects.MediaType);
		return ddl_mediaType;
	}

	public void searchTitle(String media_title) throws InterruptedException {
		driver.findElement(MenuPageObjects.Search_MediaTitle).clear();
		driver.findElement(MenuPageObjects.Search_MediaTitle).sendKeys(media_title);
		Thread.sleep(3000);
	}

	public boolean checkBox() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(MenuPageObjects.checkBox).click();
		if (driver.findElement(MenuPageObjects.checkBox).isDisplayed()) {
			log.info("true");
			return true;
		}
		return false;
	}

	public void campaignCode() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Boolean value = driver.findElement(MenuPageObjects.CampaignCode).isDisplayed();
		if (value == true) {
			log.info("Campaign has been created");
			log.info(driver.findElement(MenuPageObjects.CampaignCode).getText());
			// FileSaver.saveTextToFile(driver.findElement(MenuPageObjects.CampaignCode).getText(),
			// "output.txt");
			FileSaver.saveTextToFile(driver.findElement(MenuPageObjects.CampaignCode).getText(),
					"C:\\Users\\rasharma\\Automation\\pinsystem\\src\\main\\resources\\Data\\output.txt");
		} else {
			log.error("Campaign is not created");
		}

	}

	/**
	 * @Case :: New schedule
	 */

	public void new_schedule() {
		driver.findElement((MenuPageObjects.New_schedule)).click();
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

	public void Proceed_btn() {
		driver.findElement(MenuPageObjects.proceed_btn).click();
	}

	public void Schedule_Grid() throws InterruptedException {

		Thread.sleep(1000);
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

	public void Entering_Spots() {
		WebElement parentElement = driver.findElement(MenuPageObjects.divCalendar);
		List<WebElement> childElements = parentElement.findElements(MenuPageObjects.txt_Spot);

		// Iterate through each text box element and send keys
		for (WebElement txt_spots : childElements) {

			txt_spots.click();
			txt_spots.sendKeys("1");
			txt_spots.sendKeys(Keys.TAB);
		}

	}

	public void Daily_Budget(String budget) {
		driver.findElement(MenuPageObjects.budget).sendKeys(budget);
		log.info("Daily Budget has been passed" + " " + budget);
	}

	public void Entering_Digital_Spots() {
		// Find all text boxes matching the XPath
		List<WebElement> inputFields = driver.findElements(MenuPageObjects.ClientAndVendorRates);
		// Iterate over the found elements and set their values
		for (WebElement inputField : inputFields) {
			inputField.click();
			inputField.clear();
			inputField.sendKeys("2000");
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

	public void editMedia_popUp() {
		if (driver.findElement(MenuPageObjects.editMediaOrder_popup).isDisplayed() == true) {
			driver.findElement(MenuPageObjects.Close_media_schedule).click();
			log.info(true);
			log.info("Pop-up is closed");
		} else {
			log.info("Edit Pop has been ignored");
		}
	}

	// ----------------List AA

	public void listAA() {
		log.info("Switched to list AA");
		//driver.findElement(MenuPageObjects.ListAA).click();
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

		driver.findElement(MenuPageObjects.selectMediaLayout).click();
		log.info("Media layout is selected");

	}

	public void Add_media_line() {
		driver.findElement(MenuPageObjects.AddMediaLine).click();
		log.info("Clicked on media line");
	}

	public WebElement media_line() {
		WebElement menu = driver.findElement(MenuPageObjects.AddMediaLine);
		log.info("Adding Media line");
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
}
