package com.pin.automation.pageObjects;

import org.openqa.selenium.By;

public class JobPageObjects {

	// Left Menu
	public static final By newJobButton = By.xpath("//td[@id='mnu1_1']");
	public static final By clientDDL = By.id("ddlClient_chosen");
	public static final By productDDL = By.xpath("//select[@id='ddlProduct']");
	public static final By currencyDDL = By.xpath("//select[@id='ddlCurrency']");
	public static final By budget = By.xpath("//input[@id='txtBudget']");
	public static final By startDate = By.xpath("//input[@id='txtStartDate']");
	public static final By endDate = By.xpath("//input[@id='txtEndDate']");
	public static final By JobName = By.xpath("//textarea[@id='txtDescription']");
	public static final By saveAsDraft = By.xpath("//input[@id='btnSave']");
	public static final By saveAs_newJob = By.xpath("//input[@id='btnSaveAsNewJob']");
	public static final By getJobNumber = By.xpath("//span[@id='ctl00_lblJobNo']");
	public static final By selectTask = By.xpath("//select[@id='ctl00_ddlTask']");
	public static final By newBtn = By.xpath("//input[@id='ctl00_btnNew']");

	public static class oldJob {
		// Left Menu
		public static final By oldJobButton = By.xpath("//td[@id='mnu1_2']");
		public static final By oldJobclientDDL = By.xpath("//select[@id='ddlClient']");
		public static final By oldJobSubject = By.xpath("//input[@id='txtDesc']");
		public static final By productTxt = By.xpath("//input[@id='txtProduct']");
		public static final By estSales = By.xpath("//input[@id='txtBudget']");
		public static final By estCost = By.xpath("//input[@id='txtCost']");
		public static final By deliveryDate = By.xpath("//input[@id='txtPeriod']");
		public static final By saveAddAttachment = By.xpath("//a[@id='lnkAttach']");
		public static final By getOldJobNumber = By.xpath("//span[@id='ctl00_lblJobNo']");
		public static final By SetJOBStatusLink = By.xpath("//span[@id='ctl00_lblStatus']/a");
		public static final By setStatusNew = By.id("rdStatus_1");
		public static final By updateStatus = By.id("btnSave");
		public static final By newFrame = By.xpath("//iframe[contains(@src, 'JRUpdateStatus.aspx')]");

	}

	public static class selectTemplate {
		public static final By selectCheckBox = By.xpath("//input[@id='chk_1']");
		public static final By proceedBtn = By.xpath("//input[@id='btnProceed']");
		public static final By selectOldFormatTemplate = By.xpath("//input[@id='chk_2']");

	}

	public static class costEstimatePage {
		public static final By setCostType = By.xpath("//select[@id='ctl00_cph_rptIn_ctl01_ddlWork']");
		public static final By submitAndConfirm = By.xpath("//input[@id='ctl00_cph_btnConfirm']");
		public static final By createPObtn= By.xpath("//input[@id='ctl00_cph_btnPO']");
		public static final By OfficeAddress = By.xpath("//a[@id='lnkOfficeAddress']");
		public static final By clientAddress = By.xpath("//a[@id='lnkClientAddress']");
		public static final By saveAsDraft = By.xpath("//input[@id='btnSave']");

	}

	public static class costEstimateInvoice {
		public static final By createInvoice = By.xpath("//input[@id='ctl00_cph_btnInv']");
		public static final By partialBill = By.xpath("//input[@id='btnPartial']");
		public static final By partialValue = By.xpath("//input[@id='txtPartial']");
		public static final By partialAccept = By.xpath("//input[@id='btnOkPartial']");
		public static final By generateInvoice = By.xpath("//input[@id='btnSubmit']");
		public static final By getJobInvoiceNumber = By.xpath("//span[@id='lblInvNo']");
	}

	public static class productionInvoice {
		public static final By redirectJobNo = By.xpath("//span[@id='lblRefNo']");
		public static final By invoiceNumberOnEstimate = By.xpath("//*[@id='ctl00_cph_gvJobs_cell0_15_lblInvNo']/a");
		public static final By generateWIPInv = By.xpath("//input[@id='btnAdvance']");

	}

	public static class JobSummaryPage {
		public static final By estimateEdit = By.xpath("//img[@id='ctl00_cph_gvJobs_cell0_2_btnEditJobImg']");
	}
	
	public static class clientPO{
		public static final By getPOnumber = By.cssSelector("span[id='lblTitle'] small");
		public static final By emailForApproval = By.xpath("//input[@id='btnEmail']");
		public static final By redirectToJOB = By.xpath("//span[@id='lblJobNo']");
	}
}
