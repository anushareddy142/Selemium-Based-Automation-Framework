package com.selenium.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.constants.ProjectConstants;
import com.selenium.jira.JiraAnnotation;
import com.selenium.pageobjectmodel.HomePageElements;
import com.selenium.pageobjectmodel.LoginPageElements;
import com.selenium.testbase.TestBaseClass;
import com.selenium.testdata.ExcelDataReader;

public class LoginPageAndHomePageTest extends TestBaseClass {
	private LoginPageElements loginPageElement;
	private ExcelDataReader dataReader;
	private HomePageElements homepageElement;

	@BeforeClass
	public void initAccountSetupPageElements() throws IOException {
		loginPageElement = new LoginPageElements();
		homepageElement = new HomePageElements();
		
	}
//Log in
	@Test(dataProvider = "login_testdata", priority = 1)
	@JiraAnnotation(createIssue = true)
	public void loginPageTest(String userName, String password) throws IOException {
		//XSSFSheet sheet = dataReader.getWorkSeet("Login Details");
		//XSSFRow row = sheet.getRow(1); // row 0 is header columns
		
		
		loginPageElement.getUserName().sendKeys(userName);
		loginPageElement.getPassword().sendKeys(password);
		// AlbrowserUtilityImpl.clickOnElement(accountPageElement.getRegisterButton()
        loginPageElement.getLoginBtn().click();
		}
	

//
	@Test(dataProvider = "testdata", priority =3 )
	@JiraAnnotation(createIssue = true)
	public void homePageTest(String itemName) throws IOException, InterruptedException {

		//XSSFSheet sheet = dataReader.getWorkSeet("Item Name");
		// XSSFRow row = sheet.getRow(1); // row 0 is header columns
	
				homepageElement.getSearchBox().sendKeys(itemName);
				homepageElement.getSearchButton().click();
				homepageElement.getAddtoCartBtn().click();
				Thread.sleep(1000);
			

			// WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),20);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-btn"))).click();

		//	homepageElement.getCartBtn().click();
			//Thread.sleep(2000);
		} 
	

@Test(priority = 2)
public void clearCart() throws InterruptedException {
	homepageElement.getCartBtn().click();
	Thread.sleep(1000);
	List<WebElement> items = homepageElement.getClearItems();
	for (WebElement webElement : items) {
		webElement.click();
		Thread.sleep(1000);
	}
	homepageElement.getCloseCart().click();
}
@DataProvider(name="testdata")
public Object[][] homePageTestData() throws IOException{
	int rows = dataReader.getRowCount("Item Name");	
	Object[][] addingItems = new Object[rows][1];
	
	for(int i=1;i<=rows;i++) {
		try {
			addingItems[i-1][0]= dataReader.getTestData("Item Name", i, 0);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	return addingItems;

}




@DataProvider(name="login_testdata")
public Object[][] loginPageTestData() throws IOException{
	dataReader = new ExcelDataReader(ProjectConstants.ACCOUNTSETUP_TESTDATA_PATH);
	int rows = dataReader.getRowCount("Login Details");
	Object[][] addingItems = new Object[rows][2];
	
	for(int i=1;i<=rows;i++) {
		try {
			addingItems[i-1][0]= dataReader.getTestData("Login Details", i, 0);
			addingItems[i-1][1]= dataReader.getTestData("Login Details", i, 1);
			
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	return addingItems;

}








}
