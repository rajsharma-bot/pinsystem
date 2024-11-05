package com.pinsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.pinsystem.pageObjects.LoginObjects;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingSpotQTY2 {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String TXT_COSTDATE = "//input[@id='txtDate_%s']";
		// String Url =
		// "https://devbr.pinsystem.com/MediaSchedule.aspx?Id=S6CBAm3ssPAl7Ul1d1===Y61:::rObVCk4L7z21OKjrIIoE=&bid=eDO0izlStC8=&history=3===CNlgJ8OM4=";

		String Url = "https://devbr.pinsystem.com/mediabuying_new1.aspx?a=1&s=1&mode=2&id=JoMTCIynUD2nUAdpfLajODVj6erR2CGB&bid=eDO0izlStC8=";
		FrameHelper fh = new FrameHelper(driver);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get(Url);
		ObjectReader.reader = new PropertyReader();
		LoginObjects lg = new LoginObjects(driver);
		lg.login(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		lg.submit();
		Thread.sleep(3000);
		WebElement Client = driver.findElement(By.xpath("//select[@id='ddlCurrency']"));

		Select select = new Select(Client);
		WebElement selectedOption = select.getFirstSelectedOption();
		String selectedValue = selectedOption.getText();
		System.out.println(selectedValue);

		// driver.switchTo().frame("popEditMediaSchedule_CIF-1");

//		WebElement parentElement = driver.findElement(By.id("divCalendar"));		
//		List<WebElement> childElements = parentElement.findElements(By.xpath(".//input[@type='text']"));
//
//        // Iterate through each text box element and send keys
//        for (WebElement textBox : childElements) {
//        	
//        	textBox.click();
//            textBox.sendKeys("1");
//            textBox.sendKeys(Keys.TAB);
//        }

		driver.quit();
	}
}