package com.selenium.testbase;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class TestBaseClass{
	protected BrowserUtilityImpl browserUtilityImpl ;
	@BeforeClass
	public void initSetUp() throws IOException {
		BrowserManager.initBrowser(PropertyReader.readProperty("browser")); //driver manager driver is created here
		browserUtilityImpl = new BrowserUtilityImpl(DriverManager.getDriver());
	
	}

	@AfterClass
	public void tearDown()
	{
		BrowserManager.quitDriver();
	} 
}
