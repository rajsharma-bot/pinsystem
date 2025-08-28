
import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pin.automation.utils.FileUtil;
import com.pin.automation.utils.ObjectReader;
import com.pin.automation.utils.ResourceHelper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Digital_Campaign_scheduleTestCase extends TestBase {

	private static Logger log = LogManager.getLogger(Digital_Campaign_scheduleTestCase.class);

	@Test(description = "Digital Campaign")
	public void digital_campaign() throws InterruptedException {

		WaitHelper.setImplicitWait(ObjectReader.reader.getExplicitWait());
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"));

		String env = System.getProperty("env", "devbr"); // Default env
		System.out.println("Selecteted environment is "+ env);

		// Fetch properties using environment prefix
		String clientName = ObjectReader.reader.getClientName(env + ".clientName");
		String soldToParty = ObjectReader.reader.getSoldToParty(env + ".soldToParty");
		String product = ObjectReader.reader.getProduct(env + ".product");
		String contract = ObjectReader.reader.getContract(env + ".contract");
		String serviceBy = ObjectReader.reader.getService(env + ".serviceby");
		String startDate=  ObjectReader.reader.getStartDate();
		String endDate = ObjectReader.reader.getEndDate();


		// Log to confirm values
		log.info("Using environment: " + env);
		log.info("Client Name: " + clientName);
		log.info("Sold To Party: " + soldToParty);
		log.info("Product: " + product);
		log.info("Contract: " + contract);
		log.info("ServiceBy: " + serviceBy);
		log.info("StartDate:" +startDate);
		log.info("EndDate :"+endDate);


		// Login and navigate
		LoginClass lc = new LoginClass(driver, env);
		log.info("Login runner has been invoked for env: " + env);
		lc.loginRunner();

		HomeNavigationObjects.MEDIA();
		MenuObjects.newCampaign();

		if (env.equalsIgnoreCase("pdt")) {
			DropDownHelper.selectUsingVisibleText(MenuObjects.serviceBy(), serviceBy);
			log.info("Service by is selected :" + serviceBy);
		} else {
			log.info("Service By has been ignored");
		}

		// Enter campaign details
		DropDownHelper.selectUsingVisibleText(MenuObjects.clientDDL(), clientName);

		if (env.equals("devbr") || env.equals("pdt")) {
			DropDownHelper.selectUsingValue(MenuObjects.soldToParty(), soldToParty);
		} else {
			log.info("Sold To Party is ignored for env: " + env);
		}

		
		MenuObjects.StartDate(startDate);
		MenuObjects.EndDate(endDate);
		DropDownHelper.selectUsingValue(MenuObjects.Product(), product);

		if (env.equals("devbr") || env.equals("pdt")) {
			DropDownHelper.selectUsingValue(MenuObjects.Contract(), contract);
		} else {
			log.info("Contract is ignored for env: " + env);
		}

		MenuObjects.CampaignName("Regression for Digital Media - " + today);

		// Save and generate campaign code
		MixMediaSchedule.digital_media();
		MenuObjects.Save();
		MenuObjects.campaignCode();
		assertNotNull(MenuObjects.verifycampaignCode(), "Campaign code should not be null!");
	}

	@Test(dependsOnMethods = { "digital_campaign" }, description = "Digital Schedule")
	public void Digital_Schedule() throws InterruptedException {

		// Creating New Schedule
		MenuObjects.new_schedule();
		MixMediaSchedule.selectVendorCurreny();
		MixMediaSchedule.digital_vendor();

		MenuObjects.Schedule_Grid();

		// Passing placement details
		MenuObjects.editMedia_popUp();
		Thread.sleep(10000);
		MixMediaSchedule.digital_placement();
		ScheduleObjects.confirm_schedule();

		// Creating MO and MO Confirm
		ScheduleObjects.Create_MO_By_Vendor();
		WaitHelper.waitForElementVisibility(ScheduleObjects.MO_number(), 30);
		ScheduleObjects.Select_checkBox();
		ScheduleObjects.Confirm_mo();
		ScheduleObjects.MO_status();
		ScheduleObjects.getScheduleCode();
		assertNotNull(ScheduleObjects.verifyScheduleNo(), "Schedule number should not be null!");
	}

	/**
	 * @toggle value =True or False
	 * @true will run Insertion detail hyper link pop-up to update placement line
	 * @false will run Pencil edit to update placement line
	 */
	@Parameters("isEditMO")
	@Test(dependsOnMethods = { "Digital_Schedule" }, description = "Performing operation on view line by line page")
	public void view_line_by_line(boolean isEditMO) throws InterruptedException {
		log.info("Value has set as " + isEditMO);
		toggle_pencilEditAndEditMO(isEditMO); // true = Insertion Hyperlink popup & False= Pencil edit icon
	}

	@Test(dependsOnMethods = { "view_line_by_line" }, description = "View MO page")
	public void viewMOpage() throws InterruptedException {

		String filePath = ResourceHelper.getMONumber();
		FileUtil fileUtil = new FileUtil(filePath);

		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());

		ScheduleObjects.getMOnumber();
		assertNotNull(ScheduleObjects.MOnumber(), "MO number should not be null!");
		ScheduleObjects.clickOnMOnumber();
		pop.switchToChildWindow(driver);

		try {

			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			ScheduleObjects.verifyViewMOpage(data);

		} catch (IOException e) {
			log.error("File not found : " + e.getMessage());
			Assert.fail("Failed to read MO number file.");
		}

		ScheduleObjects.moPage_moStatus();
		driver.close();
		pop.switchToParentWindow(driver);

	}

	@Test(dependsOnMethods = { "viewMOpage" }, description = "Client Invoice Remark")
	public void clientInvoiceRemark() throws InterruptedException {
		String env = ObjectReader.reader.getEnv();
		FrameHelper.switchTodefault();
		FrameHelper.switchToFrame(ObjectReader.reader.rightframe());

		ViewLineBylineObjects.clickOnViewLineBylineBtn();
		pop.switchToChildWindow(driver);

		if(env.equalsIgnoreCase("devbr") || env.equalsIgnoreCase("pdt")){
			handleClientInvoiceRemark();
		}else {
			log.info("Env is " +env + "so Client Invoice remark is ignored");
		}
		
		

		driver.close();
		pop.switchToParentWindow(driver);
	}

	/*
	 * Performing operation on view line by line page for creating AA Created
	 * Separate method to handle pencil edit and edit Media order Pop-up
	 */
	private void toggle_pencilEditAndEditMO(boolean isEditMO) throws InterruptedException {

		String filePath = ResourceHelper.getScheduleNo();
		FileUtil fileUtil = new FileUtil(filePath);

		// Click on view line by line
		ViewLineBylineObjects.clickOnViewLineBylineBtn();
		pop.switchToChildWindow(driver);

		try {
			String data = fileUtil.readAllTextFromFile();
			log.info("Data read from file:\n" + data);
			ViewLineBylineObjects.verifyRedirectToViewLineByLine(data);
		} catch (IOException e) {
			log.error("File not found : " + e.getMessage());
			Assert.fail("Failed to read schedule number file.");
		}

		// handleClientInvoiceRemark();

		if (isEditMO) {
			// Edit MO case
			Thread.sleep(10000);
			ViewLineBylineObjects.insertionDetail();
			log.info("Clicking on insertion hyperlink");
			FrameHelper.switchToFrame(ObjectReader.reader.Add_line());
			MenuObjects.Entering_Digital_Spots("3500");
			ViewLineBylineObjects.changeReason("Creating AA");
		} else {
			// Pencil Edit case
			Thread.sleep(10000);
			ViewLineBylineObjects.pencilEdit();
			log.info("Clicking on Pencil edit icon");
			FrameHelper.switchToFrame(ObjectReader.reader.Add_line());
			ViewLineBylineObjects.SettingClientRate("3000");
			ViewLineBylineObjects.settingBuyingRate("2000");
			ViewLineBylineObjects.changeReason("Creating AA ");
		}

		ViewLineBylineObjects.updateAA();

		// Back to View line by line page
		FrameHelper.switchTodefault();
		ViewLineBylineObjects.getAA_no();
		assertNotNull(ViewLineBylineObjects.verifygetAA_no(), "AA number should not be null!");
		driver.close();
		pop.switchToParentWindow(driver);
	}

	private void handleClientInvoiceRemark() throws InterruptedException {
		log.info("Handling Client Invoice Remark...");
		ViewLineBylineObjects.clientInvoiceRemark_btn();
		ViewLineBylineObjects.clientInvoiceRemark_PopUp();
		ViewLineBylineObjects.clientInvoiceRemarkText();
		ViewLineBylineObjects.clientInvoiceRemark_SaveBtn();
	}

}
