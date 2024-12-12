package com.pin.automation.utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

    private String filePath;

    // Constructor to initialize the file path
    public FileUtil(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads all lines of text from the specified file and returns it as a single string.
     * 
     * @return All lines of text from the file as a single string.
     * @throws IOException If an I/O error occurs.
     */
    public String readAllTextFromFile() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString().trim(); // Return the complete content
    }
}