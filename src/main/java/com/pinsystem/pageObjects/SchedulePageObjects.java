package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class SchedulePageObjects {

	
	public static By confirm_schedule=By.xpath("//input[@id='btnConfirmSchedule']");
	//public static By Create_MO_By_Vendor=By.id("btnCreateMOByVendor");
	public static By Create_MO_By_Vendor=By.xpath("//input[@id='btnCreateMOByVendor']");
	public static By MO_created =By.xpath("//a[@id='gvMoDetail_cell0_6_hyperMoNo']"); //element for checking if MO number is generated
	public static By confirm_mo_checkBox= By.id("gvMoDetail_header0_cbPage_S_D");//Seleting all checkbox
	public static By Confirm_mo= By.xpath("//input[@id='btnConfirmMO']");
	public static By mo_status= By.xpath("//tr[@id='gvMoDetail_DXDataRow0']//td[@class='dxgv'][normalize-space()='Confirm']");
	
			}