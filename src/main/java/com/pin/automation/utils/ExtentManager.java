package com.pin.automation.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    private static String reportPath;  // Variable to hold the report path
    private static String excelReportPath = "src/main/resources/reports/excel-report.xlsx";  // Define your Excel report path
    private static List<TestData> testDataList = new ArrayList<>(); // List to hold test data for export

    public static ExtentReports getInstance() {
        if (extent == null) {
            reportPath = ResourceHelper.getResourcePath("src/main/resources/reports/extent.html"); // Store path when creating instance
            return createInstance(reportPath);
        } else {
            return extent;
        }
    }

    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("PIN Non-integration report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("PIN Automation Report");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Set system info
        extent.setSystemInfo("QA", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "DevBr");

        return extent;
    }

    public static String getReportPath() {
        return reportPath;
    }

    // Method to add test data to list (this is where you track test details)
    public static void addTestData(String testName, String status, String startTime, String endTime, String details) {
        testDataList.add(new TestData(testName, status, startTime, endTime, details));
    }

    // Method to export report data to Excel
    public static void exportReportToExcel() {
        try {
            // Create a new Excel workbook and sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Extent Report");

            // Create Excel header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Test Name");
            headerRow.createCell(1).setCellValue("Status");
            headerRow.createCell(2).setCellValue("Start Time");
            headerRow.createCell(3).setCellValue("End Time");
            headerRow.createCell(4).setCellValue("Details");

            // Write test data to Excel
            int rowNum = 1;
            for (TestData testData : testDataList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(testData.testName);
                row.createCell(1).setCellValue(testData.status);
                row.createCell(2).setCellValue(testData.startTime);
                row.createCell(3).setCellValue(testData.endTime);
                row.createCell(4).setCellValue(testData.details);
            }

            // Save Excel file
            try (FileOutputStream fileOut = new FileOutputStream(new File(excelReportPath))) {
                workbook.write(fileOut);
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Inner class to hold test data
    public static class TestData {
        String testName;
        String status;
        String startTime;
        String endTime;
        String details;

        public TestData(String testName, String status, String startTime, String endTime, String details) {
            this.testName = testName;
            this.status = status;
            this.startTime = startTime;
            this.endTime = endTime;
            this.details = details;
        }
    }
}
