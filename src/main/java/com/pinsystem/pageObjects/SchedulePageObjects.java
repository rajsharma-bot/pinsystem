package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class SchedulePageObjects {

	
	public static final By confirm_schedule=By.xpath("//input[@id='btnConfirmSchedule']");
	//public static By Create_MO_By_Vendor=By.id("btnCreateMOByVendor");
	public static final By Create_MO_By_Vendor=By.xpath("//input[@id='btnCreateMOByVendor']");
	public static final By MO_created =By.xpath("//a[@id='gvMoDetail_cell0_6_hyperMoNo']"); //element for checking if MO number is generated
	public static final By confirm_mo_checkBox= By.id("gvMoDetail_header0_cbPage_S_D");//Seleting all checkbox
	public static final By Confirm_mo= By.xpath("//input[@id='btnConfirmMO']");
	public static By mo_status= By.xpath("//tr[@id='gvMoDetail_DXDataRow0']//td[@class='dxgv'][normalize-space()='Confirm']");
	public static final By createAutoMonthly_MO=By.xpath("//input[@id='btnCreateAutoMonthlyMO']");
	
	// Schedule MO
	
	public static final By MOLink = By.xpath("//a[@id='gvMoDetail_cell0_6_hyperMoNo']"); 
	public static final By verifyMOpage = By.xpath("//span[@id='lblOrderNo']");
	public static final By viewMOPageStatus = By.xpath("//span[@id='lblStatus']");
	
	
			}
