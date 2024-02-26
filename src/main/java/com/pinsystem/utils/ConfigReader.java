package com.pinsystem.utils;

public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public String getUrl();
	public String getUserName();
	public String getPassword();

}
