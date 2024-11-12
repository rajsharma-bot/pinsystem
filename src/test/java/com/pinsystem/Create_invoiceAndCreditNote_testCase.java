package com.pinsystem;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pinsystem.utils.FileUtil;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.ResourceHelper;

public class Create_invoiceAndCreditNote_testCase extends TestBase {

	private static Logger log = LogManager.getLogger(Create_invoiceAndCreditNote_testCase.class);

	@Test(description = "Creating Invoice")
	public void createInvoice() throws InterruptedException {
		String filePath = ResourceHelper.getCampaignCode();
		FileUtil fileUtil = new FileUtil(filePath);
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		LoginClass lc = new LoginClass(driver);
		log.info("Login runner has been invoked");
		lc.loginRunner();
		HomeNavigationObjects.FINANCE();
		InvoiceObjects.UnbilledMedia_PI();
		
		// Searching invoice
		InvoiceObjects.StartDate("01/01/2024"); // DD/MM/YYYY
		InvoiceObjects.EndDate("31/03/2024"); // DD/MM/YYYY
		DropDownHelper.selectUsingVisibleText(InvoiceObjects.Search_DDL(), "Campaign Code");
		try {

			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			InvoiceObjects.txt_box(data);

		} catch (IOException e) {
			log.error("File not found : " + e.getMessage());
			Assert.fail("Failed to read campaign code file.");
		}
		InvoiceObjects.UnbilledMedia_find();
		InvoiceObjects.selectAll_CheckBox();
		InvoiceObjects.createInvoice();
		
		//Generating Invoice
		InvoiceObjects.Generate_Invoice();
		InvoiceObjects.getInvoice_Number();
		assertNotNull(InvoiceObjects.validateInvoice_Number(), "Invoice number should not be null!");
		InvoiceObjects.Confirm_invoice();
		
		//Changing Invoice Import Status
		log.info("Changing import status to Success");
		GenericElementObjects.ImportStatus();
		pop.switchToChildWindow(driver);
		DropDownHelper.selectUsingValue(GenericElementObjects.ImportStatus_DDL(), "Success");
		GenericElementObjects.ImportStatus_SaveBtn();
		pop.switchToParentWindow(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
        Assert.assertEquals(GenericElementObjects.GetImportStatus(), "Import Success", "Import status should be 'Import Success'");

		

	}

	
	@Test(dependsOnMethods="createInvoice" , description = "Creating Credit Note")
	public void CreditNote() throws InterruptedException {
		String filePath = ResourceHelper.getInvoiceCode();
		FileUtil fileUtil = new FileUtil(filePath);
		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		HomeNavigationObjects.FINANCE();
		
		//Searching Invoice from Invoice List
		CreditNoteObjects.Invoice_list();
		DropDownHelper.selectUsingVisibleText(CreditNoteObjects.ListAll_MonthDDL(), "List All");
		log.info(CreditNoteObjects.ListAll_MonthDDL());
		try {

			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			CreditNoteObjects.Invoice_search(data);

		} catch (IOException e) {
			log.error("File not found : " + e.getMessage());
			Assert.fail("Failed to read invoice code file.");
		}
		CreditNoteObjects.SearchInvoice();
		CreditNoteObjects.Invoice_link();
		
		//Generating creditNote
		CreditNoteObjects.Create_CreditNoteBtn();
		CreditNoteObjects.generate_CreditNote();
		CreditNoteObjects.approve_CN();
		CreditNoteObjects.getCreditNote_Number();
		assertNotNull(CreditNoteObjects.validateCreditNote_Number(), "CreditNote number should not be null!");
		
		//Changing CN ImportStatus
		 log.info("Changing CN import status to Success");
		GenericElementObjects.ImportStatus();
		pop.switchToChildWindow(driver);
		DropDownHelper.selectUsingValue(GenericElementObjects.ImportStatus_DDL(), "Success");
		GenericElementObjects.ImportStatus_SaveBtn();
		pop.switchToParentWindow(driver);
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());
        Assert.assertEquals(GenericElementObjects.GetImportStatus(), "Import Success", "Credit Note import status should be 'Success'");

		
		//Release All Spots
		CreditNoteObjects.ReleaseAllSpots();
		

	}

}
