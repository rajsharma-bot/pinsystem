package com.pinsystem.utils;

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
		if(System.getProperty("url")!=null){
			return System.getProperty("url");
		}
		return OR.getProperty("applicationUrl");
	}

	public String getUserName() {
		if(System.getProperty("username")!=null){
			return System.getProperty("username");
		}
		return OR.getProperty("username");
	}

	public String getPassword() {
		if(System.getProperty("password")!=null){
			return System.getProperty("password");
		}
		return OR.getProperty("password");
	}

	
	public String invalidUsername() {
		if(System.getProperty("invalidUsername")!=null) {
			return System.getProperty("invalidUsername");
		}
			return OR.getProperty("invalidUsername");
	}

	
	public String invalidPassword() {
		if(System.getProperty("invalidPassword")!=null) {
			return System.getProperty("invalidPassword");
		}
			return OR.getProperty("invalidPassword");
	}


	public String topframe() {
		if(System.getProperty("topframe")!=null) {
			return System.getProperty("topframe");
		}
			return OR.getProperty("topframe");
	}


	public String leftframe() {
		if(System.getProperty("leftframe")!=null) {
			return System.getProperty("leftframe");
		}
			return OR.getProperty("leftframe");
	}


	public String rightframe() {
		if(System.getProperty("rightframe")!=null) {
			return System.getProperty("rightframe");
		}
			return OR.getProperty("rightframe");
	}


	public String HOME() {
		if(System.getProperty("HOME")!=null) {
			return System.getProperty("HOME");
		}
			return OR.getProperty("HOME");
	}

	@Override
	public String MEDIA() {
		if(System.getProperty("MEDIA")!=null) {
			return System.getProperty("MEDIA");
		}
			return OR.getProperty("MEDIA");
	}


	public String IT_DEPT() {
		if(System.getProperty("IT/DEPT")!=null) {
			return System.getProperty("IT/DEPT");
		}
			return OR.getProperty("IT/DEPT");
	}

	
	public String ACCOUNTS() {
		if(System.getProperty("ACCOUNTS")!=null) {
			return System.getProperty("ACCOUNTS");
		}
			return OR.getProperty("ACCOUNTS");
	}

	
	public String FINANCE() {
		if(System.getProperty("FINANCE")!=null) {
			return System.getProperty("FINANCE");
		}
			return OR.getProperty("FINANCE");
	}

	
	public String SALES() {
		if(System.getProperty("SALES")!=null) {
			return System.getProperty("SALES");
		}
			return OR.getProperty("SALES");
	}


	public String HR_ADMIN() {
		if(System.getProperty("HR/ADMIN")!=null) {
			return System.getProperty("HR/ADMIN");
		}
			return OR.getProperty("HR/ADMIN");
	}

	
	public String CORPORATE_INFO() {
		if(System.getProperty("CORPORATE_INFO")!=null) {
			return System.getProperty("CORPORATE_INFO");
		}
			return OR.getProperty("CORPORATE_INFO");
	}

	@Override
	public String TRAFFIC() {
		if(System.getProperty("TRAFFIC")!=null) {
			return System.getProperty("TRAFFIC");
		}
			return OR.getProperty("TRAFFIC");
	}
	
	

}
