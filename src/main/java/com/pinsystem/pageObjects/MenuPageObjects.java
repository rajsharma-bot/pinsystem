package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class MenuPageObjects {
	/**
	 * Left Menu options
	 */

	public static By ListCampaign = By.id("mnu2_2");
	public static By ListSchedule = By.id("mnu2_3");
	public static By ListMO = By.xpath("//td[@id='mnu2_4']"); 

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
	public static By SearchSchedule = By.linkText("TEST123EIRW/I/2400062");
	public static By text_2=By.xpath("//span[@id='lblRecord']");

	/**
	 * @category= ListAA
	 */
	
	
}
