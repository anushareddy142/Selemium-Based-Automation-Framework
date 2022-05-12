package com.selenium.constants;

public class ProjectConstants {

	private ProjectConstants()

	{
	
	}
	
	
	
	//***********Project related Constants***************
private static final String CHROMEDRIVERKEY = "webdriver.chrome.driver";
private static final String CHROMEDRIVER_LOCATION = "src/main/resources/Drivers/chromedriver1.exe";

private static final String PROPERTIESFILE_LOCATION = "src/main/resources/config.properties";
private static final long PAGELOAD_TIMEOUT = 3000;
private static final long SCRIPTLOAD_TIMEOUT = 5000;
private static final long IMPLICITWAIT_TIME = 3000;
private static final String SCREENSHOTS_PATH ="src/test/resources/ScreenShots";
private static final String PHANTOMJSDRIVER_PATH = "src/main/resources/config/Drivers/PhantomJsDriver/phantomjs.exe";
private static final String EXTENTREPORTS_PATH ="src/test/resources/ExtentReports";
public static final String ACCOUNTSETUP_TESTDATA_PATH = "src/test/resources/testdata/Login and items test data1.xlsx";

private static final String EXTENTREPORT_TITLE = "BASIC EXTENT REPORTS";
private static final String EXTENTREPORT_NAME = "SANITY ROUND 1";


public static String getChromeDriverKey() 
{
return 	CHROMEDRIVERKEY;

}
public static String getChromeDriverLocation() {
	return CHROMEDRIVER_LOCATION;
	
}
public static String getPropertyFlieLocation() {
	return PROPERTIESFILE_LOCATION;
	
}

public static long getPageLoadTimeOut() {
	return PAGELOAD_TIMEOUT;
	
}

public static long getScriptLoadTimeOut() {
	return SCRIPTLOAD_TIMEOUT;
	
}
public static long getImplicitWaitTime() {
	
return IMPLICITWAIT_TIME;

	}
public static String getScreenshotsPath() {
	return SCREENSHOTS_PATH;
}
public static String getPhantomjsdriverPath() {
	return PHANTOMJSDRIVER_PATH;
}
public static String getExtentreportsPath() {
	return EXTENTREPORTS_PATH;
}
public static String getExtentreportTitle() {
	return EXTENTREPORT_TITLE;
}
public static String getExtentreportName() {
	return EXTENTREPORT_NAME;
}

}

