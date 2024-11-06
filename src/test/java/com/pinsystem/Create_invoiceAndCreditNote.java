package com.pinsystem;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pinsystem.pageObjects.CreditNoteObjects;
import com.pinsystem.pageObjects.HomeNavigationObjects;
import com.pinsystem.pageObjects.InvoiceObjects;
import com.pinsystem.pageObjects.MenuObjects;
import com.pinsystem.pageObjects.MixMediaSchedule;
import com.pinsystem.utils.DropDownHelper;
import com.pinsystem.utils.FileUtil;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;
import com.pinsystem.utils.ResourceHelper;
import com.pinsystem.utils.WaitHelper;
import com.pinsystem.utils.WindowHandler;

public class Create_invoiceAndCreditNote extends TestBase {

	private static Logger log = LogManager.getLogger(Create_invoiceAndCreditNote.class);

	@Test(description = "Creating Invoice")
	public void digital_invoice() throws InterruptedException {
//		String filePath = "C:\\Users\\rasharma\\Automation\\pinsystem\\src\\main\\resources\\Data\\output.txt";
		String filePath = ResourceHelper.getCampaignCode();
		ObjectReader.reader = new PropertyReader();
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		WaitHelper wh = new WaitHelper(driver);
		HomeNavigationObjects HN = new HomeNavigationObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		MixMediaSchedule mx = new MixMediaSchedule(driver);
		InvoiceObjects IO = new InvoiceObjects(driver);
		FileUtil fileUtil = new FileUtil(filePath);
		wh.setImplicitWait(ObjectReader.reader.getExplicitWait());
		LoginClass lc = new LoginClass(driver);
		log.info("Login runner has been invoked");
		lc.loginRunner();
		fh.switchToFrame(ObjectReader.reader.topframe());
		HN.FINANCE();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.leftframe());
		IO.UnbilledMedia_PI();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		IO.StartDate("01/01/2024"); // DD/MM/YYYY
		IO.EndDate("31/03/2024"); // DD/MM/YYYY
		dh.selectUsingVisibleText(IO.Search_DDL(), "Campaign Code");
		try {

			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			IO.txt_box(data);

		} catch (IOException e) {
			log.error("File not found : " + e);
			e.printStackTrace(); // Handle any I/O exceptions
		}
		IO.UnbilledMedia_find();
		Assert.assertEquals(IO.checkBox_visible(), true);
		IO.selectAll_CheckBox();
		IO.createInvoice();
		IO.Generate_Invoice();
		IO.getInvoice_Number();
		IO.Confirm_invoice();

	}

	@SuppressWarnings({ "static-access", "static-access", "static-access" })
	@Test(dependsOnMethods="digital_invoice" , description = "Creating Credit Note")
	public void CreditNote() throws InterruptedException {
		String filePath = ResourceHelper.getInvoiceCode();
		ObjectReader.reader = new PropertyReader();
		FrameHelper fh = new FrameHelper(driver);
		MenuObjects Mo = new MenuObjects(driver);
		WaitHelper wh = new WaitHelper(driver);
		HomeNavigationObjects HN = new HomeNavigationObjects(driver);
		DropDownHelper dh = new DropDownHelper(driver);
		MixMediaSchedule mx = new MixMediaSchedule(driver);
		CreditNoteObjects CO = new CreditNoteObjects(driver);
		FileUtil fileUtil = new FileUtil(filePath);
	    WindowHandler pop = new WindowHandler(driver); // window
		wh.setImplicitWait(ObjectReader.reader.getExplicitWait());
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.topframe());
		HN.FINANCE();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.leftframe());
		CO.Invoice_list();
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		dh.selectUsingVisibleText(CO.ListAll_MonthDDL(), "List All");
		log.info(CO.ListAll_MonthDDL());
		try {

			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			CO.Invoice_search(data);

		} catch (IOException e) {
			log.error("File not found : " + e);
			e.printStackTrace(); // Handle any I/O exceptions
		}
		CO.SearchInvoice();
		CO.Invoice_link();
		CO.Create_CreditNoteBtn();
		CO.generate_CreditNote();
		CO.approve_CN();
		CO.getInvoice_Number();
		CO.ImportStatus();
		fh.switchTodefault();
		pop.switchToChildWindow(driver);		
		dh.selectUsingValue(CO.ImportDDL(), "Success");
		CO.ImportSave_btn();
		pop.switchToParentWindow(driver);
		fh.switchTodefault();
		fh.switchToFrame(ObjectReader.reader.rightframe());
		Assert.assertEquals(CO.GetImportStatus(), "Import Success");
		CO.ReleaseAllSpots();
		

	}

}
