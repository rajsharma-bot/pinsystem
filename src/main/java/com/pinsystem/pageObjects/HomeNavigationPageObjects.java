package com.pinsystem.pageObjects;

import org.openqa.selenium.By;

public class HomeNavigationPageObjects {
	/*
	 * WebElement for Menu Links
	 */

	public static By HOME = By.linkText("HOME");
	public static By TRAFFIC = By.linkText("TRAFFIC");
	public static By MEDIA = By.linkText("MEDIA");
	public static By IT_DEPT = By.linkText("IT/DEPT");
	public static By ACCOUNTS = By.linkText("ACCOUNTS");
	public static By SALES = By.linkText("SALES");
	public static By FINANCE = By.linkText("FINANCE");
	public static By HR_ADMIN = By.linkText("HR/ADMIN");
	public static By CORPORATE_INFO = By.linkText("CORPORATE INFO");

	/*
	 * Webelement for user & logout
	 */

	public static By UserLink = By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[3]/a[1]");
	public static By Logout = By.linkText("Logout");

}
