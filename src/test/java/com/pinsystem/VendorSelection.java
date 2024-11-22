package com.pinsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class VendorSelection {
    WebDriver driver;

    public VendorSelection(WebDriver driver) {
        this.driver = driver;
    }

    // Method to select a vendor by row index and vendor value with dropdown click first
    public void selectVendor(int rowIndex, String vendorValue) {
        // Construct the XPath using the row index
        String xpath = "//select[starts-with(@id, 'rptTV_ctl" + String.format("%02d", rowIndex) + "') and contains(@id, '_ddlVendor')]";
        System.out.println("XPath used: " + xpath);

        try {
            // Locate the dropdown element
            WebElement vendorDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            // Click on the dropdown to expand options
            vendorDropdown.click();

            // Re-locate the dropdown to use it with Select
            WebElement ddlVendor = driver.findElement(By.xpath(xpath));
            Select dropdown = new Select(ddlVendor);

            // Verify if the required option is available by value
            boolean optionFound = dropdown.getOptions().stream()
                    .anyMatch(option -> option.getAttribute("value").equals(vendorValue));
                    
            if (optionFound) {
                dropdown.selectByValue(vendorValue); // Select by value if available
                System.out.println("Selected vendor by value: " + vendorValue);
            } else {
                System.out.println("Option with value '" + vendorValue + "' not found. Available options:");
                dropdown.getOptions().forEach(option -> 
                    System.out.println("Option value: " + option.getAttribute("value") + ", text: " + option.getText()));
            }
        } catch (Exception e) {
            System.out.println("Error selecting vendor for row " + rowIndex + " with value " + vendorValue);
            e.printStackTrace();
        }
    }
}
