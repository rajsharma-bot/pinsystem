package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class CreditNotePageObjects {
	
	public static By Invoice_list= By.xpath("//td[@id='mnu10_5']");
	public static By Date_listAll= By.xpath("//select[@id='ddlMonth']");
	public static By Invoice_search = By.xpath("//input[@id='txtInvoiceNo']");
	public static By Search_Invoice= By.xpath("//input[@id='btnFind']");
	public static By InvoiceNo_link= By.xpath("//span[@id='rptList_ctl01_lblInvNo']"); // Invoice Link
	public static By CreditNoteBtn= By.xpath("//input[@id='btnCN']");
	public static By Generate_CreditNote = By.xpath("//input[@id='btnSubmit']");
	public static By getCreditNote_No= By.xpath("//span[@id='lblInvNo']");
	public static By approve_CNbt= By.xpath("//input[@id='btnApprove']");
	/* Import status
	*/
	public static By Cn_WaitingForImport= By.xpath("//a[@id='lnkImport']");
	public static By Import_DLL= By.xpath("//select[@id='ddlImport']"); //Success Import
	public static By ImportSave_btn= By.xpath("//input[@id='btnSave']");
	
	/*
	 * Release All spots
	 */
	public static By ReleaseAllSpots = By.xpath("//input[@id='btnRI']");
	
	
	/*
	 * CN List
	 */
	

}
