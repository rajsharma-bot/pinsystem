package com.pin.automation.utils;

public class ResourceHelper {
	public static String getResourcePath(String path) {
		String basePath = System.getProperty("user.dir");
		System.out.println(basePath + "/" + path);
		return basePath + "/" + path;
	}

	
	public static String getCampaignCode() {
        return getResourcePath("src/main/resources/Data/CampaignNo.txt");
    }
	
	public static String getInvoiceCode() {
        return getResourcePath("src/main/resources/Data/Invoice.txt");
    }
	
	public static String getCreditNoteCode() {
        return getResourcePath("src/main/resources/Data/CN_No.txt");
    }
	
	public static String getScheduleNo() {
		 return getResourcePath("src/main/resources/Data/Schedule.txt");
	}
	
	public static String getAAno() {
		 return getResourcePath("src/main/resources/Data/aaNo.txt");
	}
	
	public static String getMONumber() {
		 return getResourcePath("src/main/resources/Data/MO_NO.txt");
	}
}
