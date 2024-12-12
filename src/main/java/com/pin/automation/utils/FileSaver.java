package com.pin.automation.utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {

	public static void saveTextToFile(String text, String filePath) {
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
