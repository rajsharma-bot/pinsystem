package com.pin.automation.pageObjects;

import org.openqa.selenium.By;

public class LoginPageObjects {

    // Locators for devbr environment
    public static final By username = By.id("txtLoginID");
    public static final By password = By.id("txtPwd");
    public static final By rememberMe = By.id("chkRemember");
    public static final By submit = By.id("btnSubmit");
    public static final By forget = By.id("lnkForgetPass");
    public static final By error = By.id("lblMsg");

    // Nested static class for pi2 environment
    public static class IntegrationLogin {
        public static final By username = By.xpath("//input[@name='j_username']");
        public static final By password = By.xpath("//input[@name='j_password']");
        public static final By Login = By.xpath("//button[@type='submit']");
        public static final By error=By.xpath("//p[@class='form-element form-error']");
    }
}
