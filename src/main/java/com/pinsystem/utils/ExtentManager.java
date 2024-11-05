package com.pinsystem.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    private static String reportPath;  // Variable to hold the report path

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
        return reportPath;  // Method to get the report path
    }
}
