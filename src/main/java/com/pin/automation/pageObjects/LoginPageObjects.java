package com.pin.automation.pageObjects;

import org.openqa.selenium.By;

public class LoginPageObjects {
	public static final By username= By.id("txtLoginID");
	public static final By password =By.id("txtPwd");
	public static final By rememberMe= By.id("chkRemember");
	public static final By submit =By.id("btnSubmit");
	public static final By forget=By.id("lnkForgetPass");
	public static final By error= By.id("lblMsg");
}
