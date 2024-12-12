package com.pin.automation.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Reader {

	@SuppressWarnings("unused")
	private static FileInputStream file;
	public static Properties props;

	public static String ProReader(String value) throws IOException {

		FileReader reader = new FileReader("src/main/resources/configfile/config.properties");
		Properties props = new Properties();
		props.load(reader);
		return props.getProperty(value);
	}
	
	
	
}
