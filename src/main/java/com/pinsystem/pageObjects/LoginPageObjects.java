package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class LoginPageObjects {
	public static By username= By.id("txtLoginID");
	public static By password =By.id("txtPwd");
	public static By rememberMe= By.id("chkRemember");
	public static By submit =By.id("btnSubmit");
	public static By forget=By.id("lnkForgetPass");
	public static By error= By.id("lblMsg");
}
