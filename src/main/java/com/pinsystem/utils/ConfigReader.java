package com.pinsystem.utils;

public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public String getUrl();
	public String getUserName();
	public String getPassword();
	public String invalidUsername();
	public String invalidPassword();
	public String topframe();
	public String leftframe();
	public String rightframe();
	public String HOME();
	public String MEDIA();
	public String IT_DEPT();
	public String ACCOUNTS();
	public String FINANCE();
	public String SALES();
	public String HR_ADMIN();
	public String CORPORATE_INFO();
	public String TRAFFIC();
	
	

}
