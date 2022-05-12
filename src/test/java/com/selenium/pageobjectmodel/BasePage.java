package com.selenium.pageobjectmodel;

import org.openqa.selenium.support.PageFactory;

import com.selenium.testbase.BrowserUtilityImpl;
import com.selenium.testbase.DriverManager;

public class BasePage {

	BrowserUtilityImpl utilities;
	
	public BasePage() {
		//TestBaseClass.initSEtup will create the driver and set to DriverManager
		utilities = new BrowserUtilityImpl(DriverManager.getDriver());
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

}
