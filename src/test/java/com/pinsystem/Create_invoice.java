package com.pinsystem;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

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

public class Create_invoice extends TestBase {

	private static Logger log = LogManager.getLogger(Create_invoice.class);

	@Test
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
		IO.StartDate("01/01/2024"); //DD/MM/YYYY
		IO.EndDate("31/03/2024");  //DD/MM/YYYY
		dh.selectUsingVisibleText(IO.Search_DDL(), "Campaign Code");
		try {
			
			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			 IO.txt_box(data);
			
		} catch (IOException e) {
			log.error("File not found : " +e);
            e.printStackTrace(); // Handle any I/O exceptions
        }
		IO.UnbilledMedia_find();
		Assert.assertEquals(IO.checkBox_visible(), true);
		IO.selectAll_CheckBox();
		IO.createInvoice();
		IO.Generate_Invoice();
		IO.getInvoice_Number();
		
		
		
	}

}
