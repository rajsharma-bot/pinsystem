package com.pinsystem;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pinsystem.utils.FileUtil;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;
import com.pinsystem.utils.ResourceHelper;

public class Create_invoiceAndCreditNote extends TestBase {

	private static Logger log = LogManager.getLogger(Create_invoiceAndCreditNote.class);

	@Test(description = "Creating Invoice")
	public void digital_invoice() throws InterruptedException {
		String filePath = ResourceHelper.getCampaignCode();
		ObjectReader.reader = new PropertyReader();
		FileUtil fileUtil = new FileUtil(filePath);
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		LoginClass lc = new LoginClass(driver);
		log.info("Login runner has been invoked");
		lc.loginRunner();
		FrameHelper.switchToFrame(ObjectReader.reader.topframe());
		HomeNavigationObjects.FINANCE();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		InvoiceObjects.UnbilledMedia_PI();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		InvoiceObjects.StartDate("01/01/2024"); // DD/MM/YYYY
		InvoiceObjects.EndDate("31/03/2024"); // DD/MM/YYYY
		DropDownHelper.selectUsingVisibleText(InvoiceObjects.Search_DDL(), "Campaign Code");
		try {

			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			InvoiceObjects.txt_box(data);

		} catch (IOException e) {
			log.error("File not found : " + e);
			e.printStackTrace(); // Handle any I/O exceptions
		}
		InvoiceObjects.UnbilledMedia_find();
		//Assert.assertEquals(InvoiceObjects.checkBox_visible(), true);
		InvoiceObjects.selectAll_CheckBox();
		InvoiceObjects.createInvoice();
		InvoiceObjects.Generate_Invoice();
		InvoiceObjects.getInvoice_Number();
		InvoiceObjects.Confirm_invoice();

	}

	
	@Test(dependsOnMethods="digital_invoice" , description = "Creating Credit Note")
	public void CreditNote() throws InterruptedException {
		String filePath = ResourceHelper.getInvoiceCode();
		ObjectReader.reader = new PropertyReader();
		FileUtil fileUtil = new FileUtil(filePath);
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.topframe());
		HomeNavigationObjects.FINANCE();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.leftframe());
		CreditNoteObjects.Invoice_list();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		DropDownHelper.selectUsingVisibleText(CreditNoteObjects.ListAll_MonthDDL(), "List All");
		log.info(CreditNoteObjects.ListAll_MonthDDL());
		try {

			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			CreditNoteObjects.Invoice_search(data);

		} catch (IOException e) {
			log.error("File not found : " + e);
			e.printStackTrace(); // Handle any I/O exceptions
		}
		CreditNoteObjects.SearchInvoice();
		CreditNoteObjects.Invoice_link();
		CreditNoteObjects.Create_CreditNoteBtn();
		CreditNoteObjects.generate_CreditNote();
		CreditNoteObjects.approve_CN();
		CreditNoteObjects.getInvoice_Number();
		CreditNoteObjects.ImportStatus();
		FrameHelper.switchTodefault();
		pop.switchToChildWindow(driver);		
		DropDownHelper.selectUsingValue(CreditNoteObjects.ImportDDL(), "Success");
		CreditNoteObjects.ImportSave_btn();
		pop.switchToParentWindow(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
		Assert.assertEquals(CreditNoteObjects.GetImportStatus(), "Import Success");
		CreditNoteObjects.ReleaseAllSpots();
		

	}

}
