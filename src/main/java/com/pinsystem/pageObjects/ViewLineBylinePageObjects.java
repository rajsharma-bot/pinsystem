package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class ViewLineBylinePageObjects {
	

	public static final By viewlinebyline =By.xpath("//input[@id='btnViewLineByPopUp']");
	public static final By scheduleNumber_linebyline = By.xpath("//div[@id='tblHeader']//div[3]"); // getting schedule number to verify
	public static final By clientInvoiceRemark_btn= By.xpath("//img[@id='gvMOView_ByLine_DXCBtn1Img']");// CIR button
	public static final By clientInvoiceRemark_popup = By.xpath("//div[@id='popClientInvoiceRemarks_PW-1']"); // CIR popup
	public static final By clientInvoiceRemark_textBox= By.xpath("//textarea[@id='popClientInvoiceRemarks_memoClientInvoiceRemarks_I']");//CIR remark
	public static final By clientInvoiceRemark_SaveBtn= By.xpath("//div[@id='popClientInvoiceRemarks_btnSaveClientInvoiceRemarks_CD']"); // CIR save
	public static final By get_CIRremark=By.xpath("a[id='gvMOView_ByLine_DXCBtn1'] span[class='dx-vam']"); //CIR remark on view line by line
	public static final By pencilEdit = By.xpath("//img[@id='gvMOView_ByLine_DXCBtn0Img']");
	public static final By editMediaSchedulePopUp= By.xpath("//div[@id='popEditMediaSchedule_PW-1']"); // Edit Media Schedule post pencil edit
	public static final By updatingClientRate= By.xpath("//input[@id='txtLBL_ClientCost']");
	public static final By updatingBuyingRate= By.xpath("//input[@id='txtLBL_BuyingCost']");
	public static final By changeReason_remark=By.xpath("//input[@id='txtLBL_ChangeReason']"); //AA change reason remark
	public static final By UpdateAA=By.xpath("//input[@id='btnUpdateMediaSchedule']");
	public static final By AAHyperLink =By.xpath("//td[@id='gvMOView_ByLine_tccell1_40']");
	public static final By getScheduleNo =By.xpath("//td[@class='title']//small");
	
	public static final By insertionDetailHyperLink =By.xpath("//a[@id='gvMOView_ByLine_cell1_7_hyperInsDetails']");
	
	
	
	
	
	
	
}
