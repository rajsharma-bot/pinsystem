package com.pin.automation.pageObjects;

import org.openqa.selenium.By;

public class MenuPageObjects {

	/*** Left Menu options */
	public static final By ListCampaign = By.id("mnu2_2");
	public static final By ListSchedule = By.id("mnu2_3");
	public static final By ListMO = By.xpath("//td[@id='mnu2_4']");
	public static final By NewCampaign = By.xpath("//td[@id='mnu2_1']");
	public static final By ListAA = By.xpath("//td[@id='mnu2_5']");
	// popShowAddedLayout_CIF-1
	/** New Campaign Element * {@Date}= DD/MM/YYYY */
	public static final By ClientDDL = By.xpath("//select[@id='ddlMediaClient']");
	public static final By ServiceBy= By.xpath("//select[@id='ddlPersonnel']"); //New added
	public static final By SoldToParty = By.xpath("//select[@id='ddlThirdParty']");
	public static final By StartDate = By.xpath("//input[@id='txtFrom']");
	public static final By EndDate = By.xpath("//input[@id='txtTo']");
	public static final By ContractDDL = By.xpath("//select[@id='ddlDepartment']");
	public static final By ProductDDL = By.xpath("//select[@id='ddlProduct']");
	public static final By Campaign_name = By.xpath("//textarea[@id='txtDescription']");
	public static final By MediaType = By.xpath("//select[@id='ddlMediaCat']");
	public static final By Search_MediaTitle = By.xpath("//input[@id='txtTitle']");
	public static final By SaveOnlyAndViewCampaign = By.xpath("//input[@id='btnSave']");
	public static final By CampaignCode = By.xpath("//span[@id='CM1_lblCampaignCode']");
	public static final By New_schedule = By.xpath("//input[@id='CM1_btnAddSchedule']");
	public static final By Schedule_Grid = By.xpath("//input[@id='btnSubmit3']");
	public static final By checkBox = By.xpath("//input[@id='chkLstMediaCat_0']");
	public static final By client_currency = By.xpath("//select[@id='ddlCurrency']");
	public static final By vendor_currency = By.xpath("//select[@id='ddlCurrency1']");
	public static final By schedule_grid_error = By.xpath("//*[@id='pnlError']");
	//public static final By label_digital=By.xpath("//label[text()='Linkedin']"); ///
	public static final By label_digital=By.xpath("//input[@id='chkLstMediaCat_0']");
	

	// Vendors
	public static final By VendorDDL = By.xpath("//select[@id='rptTV_ctl01_ddlVendor']");
	public static final By VendorDDL2 = By.xpath("//select[@id='rptTV_ctl02_ddlVendor']");
	public static final By VendorDDL3 = By.xpath("//select[@id='rptTV_ctl03_ddlVendor']");
	public static final By VendorDDL4 = By.xpath("//select[@id='rptTV_ctl04_ddlVendor']");
	public static final By VendorDDL5 = By.xpath("//select[@id='rptTV_ctl05_ddlVendor']");
	public static final By VendorDDL6 = By.xpath("//select[@id='rptTV_ctl06_ddlVendor']");
	public static final By VendorDDL7 = By.xpath("//select[@id='rptTV_ctl07_ddlVendor']");

	// New Schedule Page
	public static final By editMediaOrder_popup = By.xpath("//div[@id='popEditMediaSchedule_PW-1']");
    public static final By close_edit_popup= By.xpath("//div[@id='popEditMediaSchedule_HCB-1']//img[@alt='Close']");
	public static final By Close_media_schedule = By.xpath("//div[@id='popEditMediaSchedule_HCB-1']");
	
	public static final By nestedMediaOrder_popup= By.xpath("//div[@id='popShowAddedLayout_PWC-1']"); //New Added
	public static final By nestedMediaOrder_popup_closed= By.xpath("//div[@id='popShowAddedLayout_HCB-1']//img[@alt='Close']"); //New added
	
	public static final By layout_popUp = By.xpath("//div[@id='popShowAddedLayout_PW-1']");
	public static final By selectMediaLayout = By.xpath("//td[normalize-space()='Mix Media Type']");
	public static final By AddMediaLine = By.xpath("//input[@id='btnAddMediaLine']");
	public static final By AddMediaLine_PopUp = By.xpath("//input[@id='btnProceed']");
	public static final By AdvanceCosting = By.xpath("//td[@align='right']");
	public static final By Duration = By.xpath("//input[@id='txtO_Duration']");
	public static final By ClientRate = By.xpath("//input[@id='txtClientRate']");
	public static final By VendorRate = By.xpath("//input[@id='txtBuyingRate']");
	public static final By fee1 = By.xpath("//input[@id='rptTV_ctl01_txtFee']");
	public static final By fee2 = By.xpath("//input[@id='rptTV_ctl02_txtFee']");
	public static final By layout_popup_close = By
			.xpath("//div[contains(@id,'popShowAddedLayout')]//div[@class='dxpc-closeBtn']");

	///////////
	public static final By pop_up_vendor = By.xpath("//select[@id='ddlVendor']"); // Common //*[@id="ddlVendor"]
	public static final By c_vendor = By.xpath(
			"//option[@value='124|70AF3163-992C-4950-98F3-20FEF23FF82D|MYR|1.0000000|1|1|15|15|0|1047|MYR|1.0000000']");
	public static final By proceed_btn = By.xpath("//input[@id='btnProceed']");
	public static final By Add_Placement_line = By.xpath("//input[@id='btnAddAsNewLine']");
	public static final By pop_media = By.xpath("//select[@id='ddlMedia']");

	////////////

	// Unique Element of cinema include other & Outdoor media type record
	public static final By Adtype_Others = By.xpath("//select[@id='ddlO_AdType']");
	public static final By txt_Others_Description = By.id("txtO_Remarks");
	public static final By cinema_add_line = By.xpath("//optgroup[@label='Cinema']");

	// Unique Element of Digital record
	public static final By Adtype_D = By.xpath("//select[@id='ddlD_AdType']");
	public static final By txt_Digital_Description = By.id("txtD_Description");

	// Unique Element of Magazine record
	public static final By Adtype_M = By.xpath("//select[@id='ddlM_AdType']");
	public static final By txt_Magazine_Description = By.xpath("//textarea[@id='txtM_Remarks']");

	// Unique Element of Newspaper record
	public static final By AdType_N = By.xpath("//select[@id='ddlN_AdType']");
	public static final By Newspaper_H = By.xpath("//input[@id='txtN_H']");
	public static final By Newspaper_W = By.xpath("//input[@id='txtN_W']");
	public static final By txt_News_Description = By.xpath("//textarea[@id='txtN_Remarks']");

	// Unique Element of Radio record
	public static final By AdType_R = By.xpath("//select[@id='ddlR_AdType']");
	public static final By txt_Radio_Description = By.xpath("//textarea[@id='txtR_Program']");
	public static final By dur_radio = By.xpath("//select[@id='ddlR_Loading']");

	// Unique Element of TV record
	public static final By AdType_TV = By.xpath("//select[@id='ddlTV_AdType']");
	public static final By txt_TV_Description = By.xpath("//textarea[@id='txtTV_Remarks']");
	public static final By dur_TV = By.xpath("//select[@id='ddlTV_Loading']");

	// Passing Spot QTY
	public static final By divCalendar = By.id("divCalendar");
	public static final By txt_Spot = By.xpath(".//input[@type='text']");
	public static final By digital_rate = By.xpath("//input[@class='dxeEditArea_DevEx dxeEditAreaSys']");
	public static final By budget = By.xpath("//input[@id='txtDailyBudget']");
	public static final By ClientAndVendorRates = By.xpath(
			"//input[starts-with(@name, 'gvDigitalSpots$cell') and (contains(@name, '$txtClientCost') or contains(@name, '$txtBuyingCost'))]\r\n"
					+ "");
	

	// Element for ListCampaig Tabs
	public static final By PLANNING_TAB = By.xpath("//input[@id='btnCamp0']");
	public static final By BUYING_TAB = By.id("btnCamp1");
	public static final By READYTOBILL_TAB = By.xpath("//input[@id='btnCamp2']");
	public static final By CLOSE_TAB = By.xpath("//input[@id='btnCamp3']");
	public static final By CANCEL_TAB = By.xpath("//input[@id='btnCamp4']");
	public static final By SEARCH_BY = By.xpath("//select[@id='ddlItem']");
	public static final By SEARCH_CAM = By.xpath("//input[@id='txtClientName']");
	public static final By Find_buttonC = By.xpath("//input[@id='btnFind']");
	public static final By C_NUMBER = By.xpath("//a[normalize-space()='B004/JSR/2400191']");

	// Elements for List Schedule
	public static final By Confirmed_Tab = By.xpath("//input[@id='btn3']");
	public static final By Pending_Tab = By.xpath("//input[@id='btn0']");
	public static final By Revision_Tab = By.xpath("//input[@id='btn6']");
	public static final By Cancelled_Tab = By.xpath("//input[@id='btn4']");

	// Search Schedule
	public static final By monthDll = By.xpath("//select[@id='ddlMonth']");
	public static final By yearDll = By.xpath("//select[@id='ddlYear']");
	public static final By searchBY = By.xpath("//select[@id='ddlPersonnel']");
	public static final By searchText = By.xpath("//input[@id='txtClientName']");
	public static final By findButton = By.id("btnFind");
	public static final By SearchSchedule = By.xpath("//a[@id='gvOrder_ctl02_hypOrderNo']");
	public static final By text_2 = By.cssSelector("#lblRecord");
	public static final By Schedule_text = By.xpath("//td[@class='title']//small");

	// Elements for List MO
	public static final By ConfirmedMO_Tab = By.xpath("//input[@id='btn3']");
	public static final By PendingMO_Tab = By.xpath("//input[@id='btn0']");
	public static final By CancelledMO_Tab = By.xpath("//input[@id='btn4']");

	public static final By lableText = By.xpath("//span[@id='lblRecord']");
	public static final By schedule_no = By.xpath("//a[@id='hyprScheduleNo']");
	public static final By pop_up = By.xpath("//div[@id='popShowAddedLayout_PW-1']");

	// ListAA
	
	public static final By AA_ALL=By.xpath("//select[@id='ddlMonth']");
	public static final By Find_AA= By.xpath("//input[@id='btnFind']");
	public static final By AA_number = By.xpath("//a[@id='gvAAList_ctl02_hypAANo']");
	public static final By AA_label = By.xpath("//span[@id='lblAANo']");

	
	
}
