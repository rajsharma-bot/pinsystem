package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class MenuPageObjects {
	/**
	 * Left Menu options
	 */

	public static By ListCampaign = By.id("mnu2_2");
	public static By ListSchedule = By.id("mnu2_3");
	public static By ListMO = By.xpath("//td[@id='mnu2_4']");
	public static By NewCampaign = By.xpath("//td[@id='mnu2_1']");

	/**
	 * New Campaign Element
	 * 
	 * {@Date}= DD/MM/YYYY
	 */
	public static By ClientDDL = By.xpath("//select[@id='ddlMediaClient']");
	public static By SoldToParty= By.xpath("//select[@id='ddlThirdParty']");
	public static By StartDate = By.xpath("//input[@id='txtFrom']");
	public static By EndDate = By.xpath("//input[@id='txtTo']");
	public static By ContractDDL= By.xpath("//select[@id='ddlDepartment']");
	public static By ProductDDL= By.xpath("//select[@id='ddlProduct']");
	public static By Campaign_name= By.xpath("//textarea[@id='txtDescription']");
	public static By MediaType = By.xpath("//select[@id='ddlMediaCat']");
	public static By Search_MediaTitle= By.xpath("//input[@id='txtTitle']");
	public static By SaveOnlyAndViewCampaign= By.xpath("//input[@id='btnSave']");
	public static By CampaignCode=By.xpath("//span[@id='CM1_lblCampaignCode']");
	public static By New_schedule= By.xpath("//input[@id='CM1_btnAddSchedule']");
	public static By VendorDDL= By.xpath("//select[@id='rptTV_ctl01_ddlVendor']");
	public static By VendorDDL2= By.xpath("//select[@id='rptTV_ctl02_ddlVendor']");
	public static By Schedule_Grid= By.xpath("//input[@id='btnSubmit3']");
	
	public static By checkBox= By.xpath("//input[@id='chkLstMediaCat_0']");
	
	/**
	 * New Schedule Page
	 */
	
	public static By Close_media_schedule= By.xpath("//div[@id='popEditMediaSchedule_HCB-1']");
	public static By AddMediaLine= By.xpath("//input[@id='btnAddMediaLine']");
	public static By AddMediaLine_PopUp= By.xpath("//input[@id='btnProceed']");
	public static By AdType= By.xpath("//select[@id='ddlN_AdType']");
	public static By Placement_remark= By.xpath("//textarea[@id='txtN_Remarks']");
	public static By AdvanceCosting= By.xpath("//td[@align='right']");
	public static By ClientRate= By.xpath("//input[@id='txtClientRate']");
	public static By VendorRate= By.xpath("//input[@id='txtBuyingRate']");
	public static By Newspaper_H= By.xpath("//input[@id='txtN_H']");
	public static By Newspaper_N= By.xpath("//input[@id='txtN_W']");
	public static By fee1= By.xpath("//input[@id='rptTV_ctl01_txtFee']");
	public static By fee2= By.xpath("//input[@id='rptTV_ctl02_txtFee']");
	

	
	
	
	

	/**
	 * Element for ListCampaig Tabs
	 */

	public static By PLANNING_TAB = By.xpath("//input[@id='btnCamp0']");
	public static By BUYING_TAB = By.id("btnCamp1");
	public static By READYTOBILL_TAB = By.xpath("//input[@id='btnCamp2']");
	public static By CLOSE_TAB = By.xpath("//input[@id='btnCamp3']");
	public static By CANCEL_TAB = By.xpath("//input[@id='btnCamp4']");

	/**
	 * Elements for List Schedule
	 */

	public static By Confirmed_Tab = By.xpath("//input[@id='btn3']");
	public static By Pending_Tab = By.xpath("//input[@id='btn0']");
	public static By Revision_Tab = By.xpath("//input[@id='btn6']");
	public static By Cancelled_Tab = By.xpath("//input[@id='btn4']");

	/**
	 * Elements for List MO
	 */

	public static By ConfirmedMO_Tab = By.xpath("//input[@id='btn3']");
	public static By PendingMO_Tab = By.xpath("//input[@id='btn0']");
	public static By CancelledMO_Tab = By.xpath("//input[@id='btn4']");

	/**
	 * Search Schedule
	 */

	public static By monthDll = By.xpath("//select[@id='ddlMonth']");
	public static By yearDll = By.xpath("//select[@id='ddlYear']");
	public static By searchBY = By.xpath("//select[@id='ddlItem']");
	public static By searchText = By.xpath("//input[@id='txtClientName']");
	public static By findButton = By.id("btnFind");
	public static By SearchSchedule = By.xpath("//a[@id='gvOrder_ctl02_hypOrderNo']");
	public static By text_2 = By.cssSelector("#lblRecord");

	/**
	 * @category= ListAA
	 */

	public static By lableText = By.xpath("//span[@id='lblRecord']");
	public static By schedule_no = By.xpath("//a[@id='hyprScheduleNo']");
	public static By pop_up = By.xpath("//div[@id='popShowAddedLayout_PW-1']");

}
