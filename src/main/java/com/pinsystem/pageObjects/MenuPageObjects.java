package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class MenuPageObjects {
	/**
	 *  Left Menu options
	 */
	
	public static By ListCampaign =By.id("mnu2_2");
	public static By ListSchedule= By.id("mnu2_3");
	public static By ListMO= By.id("mnu2_4");
	
	
	/**
	 * Element for ListCampaig Tabs
	 */
	 
	public static By PLANNING_TAB = By.xpath("//input[@id='btnCamp0']");
	public static By BUYING_TAB =By.id("btnCamp1");
	public static By READYTOBILL_TAB=By.xpath("//input[@id='btnCamp2']");
	public static By CLOSE_TAB= By.xpath("//input[@id='btnCamp3']");
	public static By CANCEL_TAB=By.xpath("//input[@id='btnCamp4']");

	/**
	 * Elements for List Schedule
	 */
	
	public static By Confirmed_Tab=By.xpath("//input[@id='btn3']");
	public static By Pending_Tab=By.xpath("//input[@id='btn0']");
	public static By Revision_Tab=By.xpath("//input[@id='btn6']");
	public static By Cancelled_Tab=By.xpath("//input[@id='btn4']");
	
	/**
	 * Elements for List MO
	 */
	
	public static By ConfirmedMO_Tab=By.id("btn3");
	public static By PendingMO_Tab=By.id("btn0");
	public static By CancelledMO_Tab=By.id("btn4");
	
	
	
	
	
	public static By recordOpen =By.xpath("//a[normalize-space()='B004/EIRW/2400010']");
	public static By CampaignCode= By.id("CM1_lblCampaignCode");
	
	
}
