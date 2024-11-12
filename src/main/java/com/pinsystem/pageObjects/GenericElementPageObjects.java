package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class GenericElementPageObjects {
	
	/*
	 * Invoice & CreditNote Import Status change
	 */
	
	public static final By WaitingForImport= By.xpath("//a[@id='lnkImport']");
	public static final By Import_DLL= By.xpath("//select[@id='ddlImport']"); //Success Import
	public static final By ImportSave_btn= By.xpath("//input[@id='btnSave']"); //Save btn

}
