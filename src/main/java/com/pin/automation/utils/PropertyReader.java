package com.pin.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		try {
			String filePath = ResourceHelper.getResourcePath("src/main/resources/configfile/config.properties");
			file = new FileInputStream(new File(filePath));
			OR = new Properties();
			OR.load(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImpliciteWait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public String getUrl() {
		if (System.getProperty("url") != null) {
			return System.getProperty("url");
		}
		return OR.getProperty("applicationUrl");
	}

	public String getUserName() {
		if (System.getProperty("username") != null) {
			return System.getProperty("username");
		}
		return OR.getProperty("username");
	}

	public String getPassword() {
		if (System.getProperty("password") != null) {
			return System.getProperty("password");
		}
		return OR.getProperty("password");
	}

	public String invalidUsername() {
		if (System.getProperty("invalidUsername") != null) {
			return System.getProperty("invalidUsername");
		}
		return OR.getProperty("invalidUsername");
	}

	public String invalidPassword() {
		if (System.getProperty("invalidPassword") != null) {
			return System.getProperty("invalidPassword");
		}
		return OR.getProperty("invalidPassword");
	}

	public String topframe() {
		if (System.getProperty("topframe") != null) {
			return System.getProperty("topframe");
		}
		return OR.getProperty("topframe");
	}

	public String leftframe() {
		if (System.getProperty("leftframe") != null) {
			return System.getProperty("leftframe");
		}
		return OR.getProperty("leftframe");
	}

	public String rightframe() {
		if (System.getProperty("rightframe") != null) {
			return System.getProperty("rightframe");
		}
		return OR.getProperty("rightframe");
	}

	public String Add_line() {
		if (System.getProperty("Add_line") != null) {
			return System.getProperty("Add_line");
		}
		return OR.getProperty("Add_line");
	}

	public String pop_up_frame() {
		if (System.getProperty("pop_up_frame") != null) {
			return System.getProperty("pop_up_frame");
		}
		return OR.getProperty("pop_up_frame");
	}

	public String Edit_layout_frame() {
		if (System.getProperty("pop_up_frame") != null) {
			return System.getProperty("pop_up_frame");
		}
		return OR.getProperty("pop_up_frame");
	}

	public String HOME() {
		if (System.getProperty("HOME") != null) {
			return System.getProperty("HOME");
		}
		return OR.getProperty("HOME");
	}

	public String MEDIA() {
		if (System.getProperty("MEDIA") != null) {
			return System.getProperty("MEDIA");
		}
		return OR.getProperty("MEDIA");
	}

	public String IT_DEPT() {
		if (System.getProperty("IT/DEPT") != null) {
			return System.getProperty("IT/DEPT");
		}
		return OR.getProperty("IT/DEPT");
	}

	public String ACCOUNTS() {
		if (System.getProperty("ACCOUNTS") != null) {
			return System.getProperty("ACCOUNTS");
		}
		return OR.getProperty("ACCOUNTS");
	}

	public String FINANCE() {
		if (System.getProperty("FINANCE") != null) {
			return System.getProperty("FINANCE");
		}
		return OR.getProperty("FINANCE");
	}

	public String SALES() {
		if (System.getProperty("SALES") != null) {
			return System.getProperty("SALES");
		}
		return OR.getProperty("SALES");
	}

	public String HR_ADMIN() {
		if (System.getProperty("HR/ADMIN") != null) {
			return System.getProperty("HR/ADMIN");
		}
		return OR.getProperty("HR/ADMIN");
	}

	public String CORPORATE_INFO() {
		if (System.getProperty("CORPORATE_INFO") != null) {
			return System.getProperty("CORPORATE_INFO");
		}
		return OR.getProperty("CORPORATE_INFO");
	}

	public String TRAFFIC() {
		if (System.getProperty("TRAFFIC") != null) {
			return System.getProperty("TRAFFIC");
		}
		return OR.getProperty("TRAFFIC");
	}



	public String getIntegratedUrl() {
		if (System.getProperty("applicationUrl_INT") != null) {
			return System.getProperty("applicationUrl_INT");
		}
		return OR.getProperty("applicationUrl_INT");
	}

	public String getIntegratedUsername() {
		if (System.getProperty("INT_USER") != null) {
			return System.getProperty("INT_USER");
		}
		return OR.getProperty("INT_USER");
	}

	public String getIntegratedPassword() {
		if (System.getProperty("INT_PASS") != null) {
			return System.getProperty("INT_PASS");
		}
		return OR.getProperty("INT_PASS");
	}

	public String getValue(String key) {
		if (System.getProperty(key) != null) {
			return System.getProperty(key);
		}
		return OR.getProperty(key);
	}

	@Override
	public String getClientName(String key) {
		return System.getProperty(key, OR.getProperty(key));
	}
	
	public String getJobClientName(String key) {
		return System.getProperty(key, OR.getProperty(key));
	}
	
	public String getOldJobClientName(String key) {
		return System.getProperty(key, OR.getProperty(key));
	}

	@Override
	public String getSoldToParty(String key) {
		return System.getProperty(key, OR.getProperty(key));
	}

	@Override
	public String getProduct(String key) {
		return System.getProperty(key, OR.getProperty(key));
	}

	@Override
	public String getContract(String key) {
		return System.getProperty(key, OR.getProperty(key));
	}
	
	

	public String getEnv() {
		return System.getProperty("env");
	}

	@Override
	public String getService(String key) {
		return System.getProperty(key,OR.getProperty(key));
	}
	
//	public String getUserName() {
//		if (System.getProperty("username") != null) {
//			return System.getProperty("username");
//		}
//		return OR.getProperty("username");
//	}
	
	public String getStartDate () {
		if(System.getProperty("startDate")!=null) {
			return System.getProperty("startDate");
		}
		
		return OR.getProperty("startDate");
	}



	public String getmixMediaEndtDate() {
		if(System.getProperty("mixMediaEndDate")!=null) {
			return System.getProperty("mixMediaEndDate");
		}
		return OR.getProperty("mixMediaEndDate");
	}

@Override
public String getEndDate() {
	if(System.getProperty("endDate")!= null) {
		return System.getProperty("endDate");
	}
	return OR.getProperty("endDate");
}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
