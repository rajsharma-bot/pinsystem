package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class InvoicePageObjects {
	
	public static By UnbilledMedia_PI= By.xpath("//td[@id='mnu10_2']");
	public static By StartDate= By.xpath("//input[@id='txtStartDate']");
	public static By EndDate= By.xpath("//input[@id='txtEndDate']");
	public static By UnbilledMedia_find = By.xpath("//input[@id='btnFind']");
	public static By Create_Invoice= By.xpath("//input[@type='submit' and @name='btnNext1']");
	public static By search_ddl= By.xpath("//select[@id='ddlSearch']");
	public static By Search_txt=By.xpath("//input[@id='txtSearch']");
	public static By checkBox_visible =By.xpath("//td[@class='dxgv dxgvPBVC']");
	public static By selectAll_checkBox = By.xpath("//span[@id='gvUnBilledMediaPI_gr0_2_checkBox_S_D']");
	public static By Generate_Invoice = By.xpath("//input[@id='btnSubmit']");
	public static By getInvoiceNumber = By.xpath("//span[@id='lblInvNo']");
	public static By confirm_invoice= By.xpath("//input[@id='btnApprove']");
	
	
	
	
	

}
