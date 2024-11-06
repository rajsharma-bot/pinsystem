package com.pinsystem.utils;

public class ResourceHelper {
	public static String getResourcePath(String path) {
		String basePath = System.getProperty("user.dir");
		System.out.println(basePath + "/" + path);
		return basePath + "/" + path;
	}

	
	public static String getCampaignCode() {
        return getResourcePath("src/main/resources/Data/output.txt");
    }
	
	public static String getInvoiceCode() {
        return getResourcePath("src/main/resources/Data/Invoice.txt");
    }
	
	public static String getCreditNoteCode() {
        return getResourcePath("src/main/resources/Data/CN_No.txt");
    }
	
}
