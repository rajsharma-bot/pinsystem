package com.pin.automation;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleCaseRunner {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
        
   
        
		WebDriverManager.chromedriver().setup();

		

		 ChromeDriver driver = new ChromeDriver(chromeOptions);
		
		//WebDriver driver = new ChromeDriver();

		driver.get("https://devbr.pinsystem.com/login.aspx");

		WebElement username = driver.findElement(By.xpath("//input[@id='txtLoginID']"));
		username.sendKeys("agency@blueocean.net.my");

		WebElement password = driver.findElement(By.xpath("//input[@id='txtPwd']"));
		password.sendKeys("asd123");

		WebElement submit = driver.findElement(By.xpath("//input[@id='btnSubmit']"));
		submit.click();

		Thread.sleep(5000);

		System.out.println(driver.getTitle());
		
		driver.quit();
		

	}

}
