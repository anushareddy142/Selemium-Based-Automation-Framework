package com.selenium.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.jira.JiraAnnotation;
import com.selenium.jira.JiraHelper;
import com.selenium.reports.ExtentManager;
import com.selenium.reports.ExtentReportsConfig;
import com.selenium.testbase.BrowserUtilityImpl;
import com.selenium.testbase.DriverManager;
import com.selenium.testbase.PropertyReader;

public class TestListenerImpl implements ITestListener {
	
	ExtentReports etReports;
	ExtentTest etTest;
	BrowserUtilityImpl browserUtilityImpl;

	 // it will execute before all test cases //so intialize extent reports. // we
				// already intialized in ExtentConfig class so just call method
	public void onStart(ITestContext context) {
		try {
			etReports = ExtentReportsConfig.setUpExtentReports();
			browserUtilityImpl = new BrowserUtilityImpl(DriverManager.getDriver());
		}

		catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {

		// Create a test in reports
		etTest = etReports.createTest(result.getMethod().getMethodName());
		// Initializing ExtentTest Object
		ExtentManager.getInstance().setExtentTest(etTest);

	}


	public void onTestSuccess(ITestResult result) {

		// we need to report the success status in Extentreports
		ExtentManager.getInstance().getExtentTest().log(Status.PASS, "Testcase is passed");

		// once the testcase is passed you need to remove the object
		ExtentManager.getInstance().removeExtentTestObj();
	}


	public void onTestFailure(ITestResult result) {
		// we need to report the failure of testcases with screenShot in ExtentReports
		ExtentManager.getInstance().getExtentTest().log(Status.FAIL, "Testcase iss Failed");

		// SAVE AN IMAGE PHYSICALLY IN SCREEN SHOT FOLDER
		//ts = new UtilitiesImpl(DriverManager.getDriver());
			
	//	String screenShot = ts.takePageScreenshot(result.getMethod().getMethodName());
	//	ExtentManager.getInstance().getExtentTest().log(Status.FAIL,
	//			MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
//
		// 1: you need to attach the screenShot in extentReport

		// String base64Screenshot =
		// ts.takesScreenShotBase64(result.getMethod().getMethodName());
		// ExtentManager.getInstance().getExtentTest().addScreenCaptureFromBase64String(base64Screenshot);
		// ExtentManager.getInstance().getExtentTest().log(Status.FAIL,
		// MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
		// 2:Attach ScreenShot in jira also.

		ExtentManager.getInstance().removeExtentTestObj();
		
		//Report ISSUE IN JIRA
		try {
		JiraAnnotation jiraAnnotation =	result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraAnnotation.class);
		boolean  issueStatus = jiraAnnotation.createIssue();
			if(issueStatus)
				{
				JiraHelper jiraHelper = new JiraHelper();
				
			jiraHelper.authenticateJira();
			String issuetype = PropertyReader.readProperty("jiraissuetype");
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()+ "is failed due to some error";
			String issueDescription =result.getThrowable().getMessage(); // to get exception message
			jiraHelper.createJiraIssue(issuetype, issueSummary, issueDescription);
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {

		// we need to report the Skipped testcases with screenShot in ExtentReports
		ExtentManager.getInstance().getExtentTest().log(Status.FAIL, "Testcase is Failed");

		// SAVE AN IMAGE PHYSICALLY IN SCREEN SHOT FOLDER
		browserUtilityImpl.takePageScreenshot(result.getMethod().getMethodName());

		// 1: you need to attach the screenShot in extentReport

		String base64Screenshot = browserUtilityImpl.takesScreenShotBase64(result.getMethod().getMethodName());

		ExtentManager.getInstance().getExtentTest().addScreenCaptureFromPath(base64Screenshot);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {

		ExtentManager.getInstance().getExtentTest().log(Status.FAIL, "TestCase is Failed due to timeout");

		ExtentManager.getInstance().removeExtentTestObj();
	}

	public void onFinish(ITestContext context) {
		// generate final copy of extent reports with all test related data
		etReports.flush();
	}

}
