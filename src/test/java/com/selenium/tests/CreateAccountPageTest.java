package com.selenium.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.constants.ProjectConstants;
import com.selenium.jira.JiraAnnotation;
import com.selenium.pageobjectmodel.CreateAccountPageElements;
import com.selenium.testbase.DriverManager;
import com.selenium.testbase.TestBaseClass;
import com.selenium.testdata.ExcelDataReader;

public class CreateAccountPageTest extends TestBaseClass{
	
	private CreateAccountPageElements accountPageElement;
	private ExcelDataReader dataReader;
	@BeforeClass
	public void initAccountSetupPageElements() throws IOException {
		accountPageElement = new CreateAccountPageElements(DriverManager.getDriver());
		dataReader = new ExcelDataReader(ProjectConstants.ACCOUNTSETUP_TESTDATA_PATH);
	}
	
  @Test
  @JiraAnnotation(createIssue = true)
  public void accountPageTest() throws IOException {

	  accountPageElement.getEmail().sendKeys(dataReader.getTestData("Sheet1",1,3));
	  accountPageElement.getRegisterButton().click();
	  //AlbrowserUtilityImpl.clickOnElement(accountPageElement.getRegisterButton());
	  
  }
}
 
  
  

