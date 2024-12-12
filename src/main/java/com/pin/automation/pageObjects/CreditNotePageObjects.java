package com.pin.automation.pageObjects;

import org.openqa.selenium.By;

public class CreditNotePageObjects {
	
	public static final By Invoice_list= By.xpath("//td[@id='mnu10_5']");
	public static final By Date_listAll= By.xpath("//select[@id='ddlMonth']");
	public static final By Invoice_search = By.xpath("//input[@id='txtInvoiceNo']");
	public static final By Search_Invoice= By.xpath("//input[@id='btnFind']");
	public static final By InvoiceNo_link= By.xpath("//span[@id='rptList_ctl01_lblInvNo']"); // Invoice Link
	public static final By CreditNoteBtn= By.xpath("//input[@id='btnCN']");
	public static final By Generate_CreditNote = By.xpath("//input[@id='btnSubmit']");
	public static final By getCreditNote_No= By.xpath("//span[@id='lblInvNo']");
	public static final By approve_CNbt= By.xpath("//input[@id='btnApprove']");
	/* Import status
	*/
	public static final By Cn_WaitingForImport= By.xpath("//a[@id='lnkImport']");
	public static final By Import_DLL= By.xpath("//select[@id='ddlImport']"); //Success Import
	public static final By ImportSave_btn= By.xpath("//input[@id='btnSave']");
	
	/*
	 * Release All spots
	 */
	public static final By ReleaseAllSpots = By.xpath("//input[@id='btnRI']");
	
	
	/*
	 * CN List
	 */
	

}
