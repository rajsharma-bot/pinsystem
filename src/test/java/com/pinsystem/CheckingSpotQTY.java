package com.pinsystem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pinsystem.pageObjects.LoginObjects;
import com.pinsystem.pageObjects.MixMediaSchedule;
import com.pinsystem.utils.FrameHelper;
import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingSpotQTY {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String TXT_COSTDATE = "//input[@id='txtDate_%s']";
		// String Url =
		// "https://devbr.pinsystem.com/MediaSchedule.aspx?Id=S6CBAm3ssPAl7Ul1d1===Y61:::rObVCk4L7z21OKjrIIoE=&bid=eDO0izlStC8=&history=3===CNlgJ8OM4=";

String Url="https://devbr.pinsystem.com/MediaSchedule.aspx?Id=S6CBAm3ssPAl7Ul1d1===Y68l===zpm3j:::6RC7oN1WVHcS4=&bid=eDO0izlStC8=&history=3===CNlgJ8OM4=";
		FrameHelper fh = new FrameHelper(driver);
		MixMediaSchedule mx= new MixMediaSchedule(driver);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get(Url);
		ObjectReader.reader = new PropertyReader();
		LoginObjects lg = new LoginObjects(driver);
		lg.login(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		lg.submit();
		Thread.sleep(3000);
//		driver.switchTo().frame("popEditMediaSchedule_CIF-1");

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