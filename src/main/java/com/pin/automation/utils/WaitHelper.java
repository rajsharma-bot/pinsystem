package com.pin.automation.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	private WebDriver driver;
	private final int implicitWait = 5000;
	private static Logger log = LogManager.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
		
	
	public void setImplicitWait(long timeout) {
		log.info("Implicit Wait has been set to: " + timeout);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		
	}
	
	public void pageLoadTime(long timeout) {
		log.info("waiting for page to load for : "+ timeout);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
		log.info("page is loaded");
	}


	public WebElement waitForElementVisibility(WebElement element, int implicitTimeoutInMilli) {
        long start = System.currentTimeMillis();
        long timePassedInSeconds;
        try {
            // Set implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(implicitTimeoutInMilli));

            // Set explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // Adjust the timeout as needed

            // Wait until the element is visible
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
            
            timePassedInSeconds = (System.currentTimeMillis() - start) / 1000;
            if (timePassedInSeconds > 0) {
                log.info(timePassedInSeconds + " second(s) passed waiting for visibility of element => " + element.toString());
            }
            return visibleElement;
        } catch (Exception e) {
            log.info("Exception occurred: " + e.getMessage());
            return null;
        }
    }
	
	public WebElement waitForElementVisibility(By locator, int timeoutInSeconds) {
		long start = System.currentTimeMillis();
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	        long timePassedInSeconds = (System.currentTimeMillis() - start) / 1000;
	        log.info(timePassedInSeconds + " second(s) passed waiting for visibility of element => " + locator.toString());

	        return element;
	    } catch (Exception e) {
	        log.error("Exception while waiting for visibility: " + e.getMessage());
	        return null;
	    }
	}
	
	
	public boolean waitForInvisibilityofElementLocatedBy(WebElement element, int implicitTimeoutInMilli) throws InterruptedException {
		long start =System.currentTimeMillis();
		long timePassedinSS;
		try {
			
			this.setImplicitWait(implicitTimeoutInMilli);
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
			
			boolean isElementNotPresent = w.until(ExpectedConditions.invisibilityOfElementLocated(By.id(element.getAttribute("id"))));
			timePassedinSS = (System.currentTimeMillis() - start) / 1000;
			if(timePassedinSS > 0){
				log.info(timePassedinSS + "(s) passed waiting for invisibility of element => " + element.getAttribute("id") , true);
			}
			return isElementNotPresent;
			
		} catch (Exception e) {
			if(e.getMessage().contains("can't access dead object")){
				return true;
			}else{
				log.info((System.currentTimeMillis() - start) / 1000 + "(s) passed waiting for invisibility of element, then came in exception", true);
			}
		}finally{
			Thread.sleep(implicitTimeoutInMilli);
		}
		return false;
	}
	
	
}
