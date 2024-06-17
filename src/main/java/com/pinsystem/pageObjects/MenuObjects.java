package com.pinsystem.pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pinsystem.utils.WaitHelper;

public class MenuObjects {

	private static Logger log = LogManager.getLogger(MenuObjects.class);

	WebDriver driver;

	public MenuObjects(WebDriver driver) {
		this.driver = driver;
	}

	// Element for List Campaign
	public void ListCampaign_page() {
		driver.findElement(MenuPageObjects.ListCampaign).click();
	}

	public void PlanningTab() {
		log.info("Switched to Planning Tab");
		driver.findElement(MenuPageObjects.PLANNING_TAB).click();
	}

	public void BuyingTab() {
		log.info("Switched to Buying Tab");
		driver.findElement(MenuPageObjects.BUYING_TAB).click();
	}

	public void ReadyToBillTab() {
		log.info("Switched to Ready To Bill Tab");
		driver.findElement(MenuPageObjects.READYTOBILL_TAB).click();
	}

	public void CloseTab() {
		log.info("Switched to Close Tab");
		driver.findElement(MenuPageObjects.CLOSE_TAB).click();
	}

	public void CancelTab() {
		log.info("Switched to Cancel Tab");
		driver.findElement(MenuPageObjects.CANCEL_TAB).click();
	}

	// Element for List Schedule
	public void ListSchedule_page() {
		log.info("List Schedule has been clicked");
		driver.findElement(MenuPageObjects.ListSchedule).click();
	}

	public void ConfirmedS_Tab() {
		log.info("Switched to Confirmed Tab");
		driver.findElement(MenuPageObjects.Confirmed_Tab).click();
	}

	public void PendingS_Tab() {
		log.info("Switched to Pending Tab");
		driver.findElement(MenuPageObjects.Pending_Tab).click();
	}

	public void CancelledS_Tab() {
		log.info("Switched to Cancelled Tab");
		driver.findElement(MenuPageObjects.Cancelled_Tab).click();
	}

	public void RevisionS_Tab() {
		log.info("Switched to Revision Tab");
		driver.findElement(MenuPageObjects.Revision_Tab).click();
	}

	// Element for List MO
	public void ListMO_page() {
		log.info("List MO has been Clicked");
		driver.findElement(MenuPageObjects.ListMO).click();
	}

	public void ConfirmedMO_Tab() {
		log.info("Switched to Confirm MO Tab");
		driver.findElement(MenuPageObjects.ConfirmedMO_Tab).click();
	}

	public void PendingMO_Tab() {
		log.info("Switched to Pending MO Tab");
		driver.findElement(MenuPageObjects.PendingMO_Tab).click();
	}

	public void CancelledMO_Tab() {
		log.info("Switched to Cancelled MO Tab");
		driver.findElement(MenuPageObjects.CancelledMO_Tab).click();
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

	public WebElement soldToParty() throws InterruptedException {
		Thread.sleep(1000);
		WebElement DDL_STP = driver.findElement(MenuPageObjects.SoldToParty);
		return DDL_STP;

	}

	public void StartDate() {
		driver.findElement(MenuPageObjects.StartDate).clear();
		driver.switchTo().alert().accept();
	}

	public void StartDate(String startdate) throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(MenuPageObjects.StartDate).sendKeys(startdate);

	}

	public void EndDate() {
		driver.findElement(MenuPageObjects.EndDate).clear();
		driver.switchTo().alert().accept();

	}

	public void EndDate(String EndDate) throws InterruptedException {
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		Boolean value = driver.findElement(MenuPageObjects.CampaignCode).isDisplayed();
		if (value == true) {
			log.info("Campaign has been created");
			log.info(driver.findElement(MenuPageObjects.CampaignCode).getText());
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
		return DDL_vendor;
	}

	public WebElement Vendor2() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL2).click();
		WebElement DDL_vendor2 = driver.findElement(MenuPageObjects.VendorDDL2);
		return DDL_vendor2;
	}

	public WebElement Vendor3() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL3).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL3);
		return DDL_vendor;
	}

	public WebElement Vendor4() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL4).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL4);
		return DDL_vendor;
	}

	public WebElement Vendor5() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL5).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL5);
		return DDL_vendor;
	}

	public WebElement Vendor6() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL6).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL6);
		return DDL_vendor;
	}

	public WebElement Vendor7() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MenuPageObjects.VendorDDL7).click();
		WebElement DDL_vendor = driver.findElement(MenuPageObjects.VendorDDL7);
		return DDL_vendor;
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
			if (driver.findElement(MenuPageObjects.layout_popup).isDisplayed()) {
				driver.findElement(MenuPageObjects.layout_popup).click();
				WebElement layout_pop = driver.findElement(MenuPageObjects.layout_popup);
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

	public void setClient_rate(String txt_client) {
		driver.findElement(MenuPageObjects.ClientRate).sendKeys(txt_client);
	}

	public void setVendor_rate(String txt_vendor) {
		driver.findElement(MenuPageObjects.VendorRate).sendKeys(txt_vendor);
	}

	public void set_Description(String txt) {

		if (driver.findElement(MenuPageObjects.txt_Others_Description).isDisplayed()) {
			driver.findElement(MenuPageObjects.txt_Others_Description).sendKeys(txt);

		} else if (driver.findElement(MenuPageObjects.txt_Magazine_Description).isDisplayed()) {
			driver.findElement(MenuPageObjects.txt_Magazine_Description).sendKeys(txt);

		} else if (driver.findElement(MenuPageObjects.txt_News_Description).isDisplayed()) {
			driver.findElement(MenuPageObjects.txt_News_Description).sendKeys(txt);

		} else if (driver.findElement(MenuPageObjects.txt_Radio_Description).isDisplayed()) {
			driver.findElement(MenuPageObjects.txt_Radio_Description).sendKeys(txt);

		} else if (driver.findElement(MenuPageObjects.txt_TV_Description).isDisplayed()) {
			driver.findElement(MenuPageObjects.txt_TV_Description).sendKeys(txt);

		} else if (driver.findElement(MenuPageObjects.txt_Digital_Description).isDisplayed()) {
			driver.findElement(MenuPageObjects.txt_Digital_Description).sendKeys(txt);

		} else {
			log.info("Locator is not correct");
		}

	}

	public WebElement vendorCurrency() throws InterruptedException {
		Thread.sleep(2000);
		WebElement ddl_vendor_curr = driver.findElement(MenuPageObjects.vendor_currency);
		return ddl_vendor_curr;
	}

//	public WebElement Adtype_ddl() throws InterruptedException {
//		// WebElement result = null;
//		Thread.sleep(1000);
//
//		if (driver.findElement(MenuPageObjects.Adtype_Others).isDisplayed()) {
//			driver.findElement(MenuPageObjects.Adtype_Others).click();
//			log.info("Other (cinema,Other & outdoor) adtype has been selected");
//			return driver.findElement(MenuPageObjects.Adtype_Others);
//
//		} else if (driver.findElement(MenuPageObjects.AdType_N).isDisplayed()) {
//			driver.findElement(MenuPageObjects.AdType_N).click();
//			log.info("Newspaper adtype has been selected");
//			return driver.findElement(MenuPageObjects.AdType_N);
//
//		} else if (driver.findElement(MenuPageObjects.Adtype_D).isDisplayed()) {
//			driver.findElement(MenuPageObjects.Adtype_D).click();
//			log.info("Digital adtype has been selected");
//			return driver.findElement(MenuPageObjects.Adtype_D);
//
//		} else if (driver.findElement(MenuPageObjects.Adtype_M).isDisplayed()) {
//			driver.findElement(MenuPageObjects.Adtype_M).click();
//			log.info("Magazine adtype has been selected");
//			return driver.findElement(MenuPageObjects.Adtype_M);
//
//		} else if (driver.findElement(MenuPageObjects.AdType_R).isDisplayed()) {
//			driver.findElement(MenuPageObjects.AdType_R).click();
//			log.info("Radio adtype has been selected");
//			return driver.findElement(MenuPageObjects.AdType_R);
//
//		} else if (driver.findElement(MenuPageObjects.AdType_TV).isDisplayed()) {
//			driver.findElement(MenuPageObjects.AdType_TV).click();
//			log.info("TV adtype has been selected");
//			return driver.findElement(MenuPageObjects.AdType_TV);
//
//		} else {
//			log.info("Select correct ad type locator");
//			
//		}
//		return null;
//	}

	public WebElement Adtype_Others() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for up to 20 seconds

	    try {
	        WebElement adTypeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.Adtype_Others));
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
        WebElement adTypeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.AdType_N));
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
        WebElement adTypeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.Adtype_M));
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
        WebElement adTypeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.AdType_R));
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
        WebElement adTypeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.AdType_TV));
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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for up to 20 seconds

    try {
        WebElement adTypeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPageObjects.Adtype_D));
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
}}
