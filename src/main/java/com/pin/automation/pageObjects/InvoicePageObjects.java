package com.pin.automation.pageObjects;

import org.openqa.selenium.By;

public class InvoicePageObjects {
	
	public static final By UnbilledMedia_PI= By.xpath("//td[@id='mnu10_2']");
	public static final By StartDate= By.xpath("//input[@id='txtStartDate']");
	public static final By EndDate= By.xpath("//input[@id='txtEndDate']");
	public static final By UnbilledMedia_find = By.xpath("//input[@id='btnFind']");
	public static final By Create_Invoice= By.xpath("//input[@type='submit' and @name='btnNext1']");
	public static final By search_ddl= By.xpath("//select[@id='ddlSearch']");
	public static final By Search_txt=By.xpath("//input[@id='txtSearch']");
	public static final By checkBox_visible =By.xpath("//td[@class='dxgv dxgvPBVC']");
	public static final By selectAll_checkBox = By.xpath("//span[@id='gvUnBilledMediaPI_gr0_2_checkBox_S_D']");
	public static final By Generate_Invoice = By.xpath("//input[@id='btnSubmit']");
	public static final By getInvoiceNumber = By.xpath("//span[@id='lblInvNo']");
	public static final By confirm_invoice= By.xpath("//input[@id='btnApprove']");
	
	
	
	
	

}
