package com.pinsystem.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			String location = ResourceHelper.getResourcePath("src/main/resources/reports/extent.html");
			return createInstance(location);
		} else {
			return extent;
		}

	}

	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("PIN Non-integration report");
		htmlReporter.config().setReportName("PIN Automation Report");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		htmlReporter.config().setCss("img.logo { max-height: 50px; }");
		htmlReporter.config().setJs("$('.brand-logo').attr('src', 'C:\\Users\\rasharma\\Automation\\pinsystem\\PIN_LOGO.jpg')");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("QA", System.getProperty("user.name"));
		extent.setSystemInfo("Enviroment", "DevBr");
		return extent;

	}

}
