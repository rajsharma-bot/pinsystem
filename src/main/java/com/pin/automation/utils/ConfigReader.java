package com.pin.automation.utils;

public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	
	public String getUrl();	
	public String getUserName();
	public String getPassword();
	public String getEnv();
	
	public String getIntegratedUrl();
	public String getIntegratedUsername();
	public String getIntegratedPassword();
	
	public String getValue(String key);
	
	public String getClientName(String key);
	public String getJobClientName(String key);
	public String getOldJobClientName(String key);
	public String getSoldToParty(String key);
	public String getProduct(String key);
	public String getContract(String key);
	public String getService(String key);
//	public String getStartDate(String key);
//	public String getEndDate(String key);
//	public String getmixMediaEndtDate(String key);
	
	public String getStartDate();
	public String getEndDate();
	public String getmixMediaEndtDate();
	
	public String invalidUsername();
	public String invalidPassword();
	public String topframe();
	public String leftframe();
	public String rightframe();
	public String Edit_layout_frame();
	public String HOME();
	public String MEDIA();
	public String IT_DEPT();
	public String ACCOUNTS();
	public String FINANCE();

	public String SALES();
	public String HR_ADMIN();
	public String CORPORATE_INFO();
	public String TRAFFIC();
	public String Add_line();
	public String pop_up_frame();
	
}
