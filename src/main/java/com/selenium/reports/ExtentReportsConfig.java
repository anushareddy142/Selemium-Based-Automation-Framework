package com.selenium.reports;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.constants.ProjectConstants;
import com.selenium.testbase.PropertyReader;

public class ExtentReportsConfig {
//this is the class where we keep all global settings for extent reports.

	


	public static ExtentReports setUpExtentReports() throws IOException {
        
		//get date 
		DateFormat dateformat = new SimpleDateFormat("yyyyMMdd_HHMMss");
		Date date = new Date();
		String todayDate = dateformat.format(date);
		
		
		//GENERATE REPORTS FILE NAME DYNAMICALLY
		String reportFileName = ProjectConstants.getExtentreportsPath() + "/" +"ExtentReports_" +todayDate+ ".html";
		
		//SET UP EXTENT REPORTS HTML FILE
		//html = new ExtentSparkReporter(ProjectConstants.getExtentreportsPath());
		ExtentSparkReporter html = new ExtentSparkReporter(reportFileName);
		ExtentReports reports = new ExtentReports();

		// ATTACH REPORTS
		reports.attachReporter(html);
		// TO SET THE TITLE
		html.config().setDocumentTitle(ProjectConstants.getExtentreportTitle());

		// to set reports name
		html.config().setReportName(ProjectConstants.getExtentreportName());

		// to set THEME
		html.config().setTheme(Theme.DARK);

		// TO SET THE META INFORMATION TO REPORTS
		reports.setSystemInfo("OperatingSystem", System.getProperty("os.name"));//reports.setSystemInfo("Operating", "Windows");
		
		reports.setSystemInfo("Browser", PropertyReader.readProperty("browser"));
		return reports;

	}
}
