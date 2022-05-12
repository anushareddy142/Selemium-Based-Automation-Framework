package com.selenium.testbase;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.selenium.constants.ProjectConstants;
import com.selenium.reports.ExtentManager;

public class BrowserUtilityImpl  implements BrowserUtilityInterface{

protected WebDriver driver;
	
	public BrowserUtilityImpl(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickOnBrowserButton() {
		try {
			driver.navigate().back();
			System.out.println("clicked on back button sucessfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void clickOnBrowserBackButton() {
		try {
			driver.navigate().forward();
			System.out.println("Clicked on Forward button");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void pageRefresh() {

		try {
			driver.navigate().refresh();
			System.out.println("WebPage is Refreshed successfully");
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void navigateToURL(String webURL) {
		try {
			driver.navigate().to(webURL);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// this method will return all cookies in webpage
	
	public Set<Cookie> getAllCookiesInpage() {
		Set<Cookie> allCookies = null; // allCookies is a collection object

		try {
			// Set<Cookie> allCookies = driver.manage().getCookies();
			allCookies = driver.manage().getCookies();
			System.out.println("Captured Allcookies");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return allCookies;

	}

	
	public void deleteAllCookiesInpage() {
		try {
			driver.manage().deleteAllCookies();
			System.out.println("All Cookies are Deleted ");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public Cookie getCookiesInfoByName(String cookieName) {
		Cookie cookieInfo = null;
		try {
			// driver.manage().getCookieNamed(cookieName);//getCookieNamed Method will
			// return Cookie object so you have to write below line

			cookieInfo = driver.manage().getCookieNamed(cookieName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cookieInfo;
	}

	
	public boolean deleteCookiesByName(String cookieName) {
		boolean status = false;
		try {
			driver.manage().deleteCookieNamed(cookieName);
			status = true;
			System.out.println("Cookie Is Deleted Successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	
	public boolean addNewCookie(String cookieName, String cookieValue) {
		boolean status = false;

		// PREPARE COOKIE DETAILS for that we need to call Cookie and create cookieInfo
		// Object
		Cookie cookieInfo = new Cookie(cookieName, cookieValue);
		try {
			driver.manage().addCookie(cookieInfo);
			status = true;
			System.out.println("Cookie is added successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	
	public void setFullScreenMode() {

		try {
			driver.manage().window().fullscreen();
			System.out.println("FullScreen mode is setup Now");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void setBrowserMaximize() {
		try {
			driver.manage().window().maximize();
			System.out.println("Window is Maximized");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	//

	
	public void setWindowPosition(int xCorValue, int yCorValue) {
		// get customer browser positon co-ordinates
		Point position = new Point(yCorValue, yCorValue);

		try {
			driver.manage().window().setPosition(position);
			System.out.println("Window is set with custom x,y coordinates");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void setWindowSize(int browserHeight, int browserWidth) {
		// get custom browser height and width
		Dimension browserSize = new Dimension(browserWidth, browserWidth);
		try {
			driver.manage().window().setSize(browserSize);
			System.out.println("Browser is resized with height and width");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public Point getWindowPosition() {
		try {
			Point position = driver.manage().window().getPosition();
			return position;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public Dimension getWindowSize() {
		try {
			Dimension browserSize = driver.manage().window().getSize();
			System.out.println("captured Browser height and Width");
			return browserSize;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	
	public void acceptJSAlertBox() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("JS Alert is Accepted");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public void dismissJSAlertBox() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Alert box is dismmissed");
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	
	public String getTextFromJSAlertBox() {
		try {
			String alertBoxText = driver.switchTo().alert().getText();
			return alertBoxText;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public void setTextToJSAlertBox(String dataToAlertBox) {
		try {
			driver.switchTo().alert().sendKeys(dataToAlertBox);
			System.out.println("Data entered successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public void checkAlertBoxPresent() {

	}

	
	public void switchToFrameByIndex(int sendFrameIndex) {
		try {
			driver.switchTo().frame(sendFrameIndex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void switchToFrameByFrameElement(WebElement frameElement) {

		try {
			driver.switchTo().frame(frameElement);
			System.out.println("frame is switched by WebElement");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void switchToFrameByNameOrID(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
			System.out.println("frame is switched by name or id");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void switchToParentFrame() {
		try {
			driver.switchTo().parentFrame();
			System.out.println("Switchexd to parent frame");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public void switchToWindowByTitle(String windowTitleText) {
		// collect all window handles
		Set<String> allHandles = driver.getWindowHandles();

		try {
			for (String handle : allHandles) {

				// fetch the current window title and needs to match with the required window

				if (driver.switchTo().window(handle).getTitle().equals(windowTitleText)) {
					// required window is found -you can switch to
					driver.switchTo().window(handle);
					break;
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void switchToWindowByIndex(int windowIndex) {

		int count = 0;
		// collect all window handles
		Set<String> allHandles = driver.getWindowHandles();
		try {
			for (String handle : allHandles) {
				if (count == windowIndex) {
					driver.switchTo().window(handle);
					break;
				} else {
					count++;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public void switchToParentWindow() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}


	public void setImplicitWaitPage() {
try {
	driver.manage().timeouts().implicitlyWait(ProjectConstants.getImplicitWaitTime(),TimeUnit.MICROSECONDS);
	
}
catch(Exception ex) {
	ex.printStackTrace();
}

	}

	
	public void setPageLoadTime() {
		try {
			driver.manage().timeouts().pageLoadTimeout(ProjectConstants.getPageLoadTimeOut(), TimeUnit.MILLISECONDS);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public void setScriptPageLoad() {

	try {
		driver.manage().timeouts().setScriptTimeout(ProjectConstants.getScriptLoadTimeOut(),TimeUnit.MILLISECONDS);
		
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	
	}

	
	public String getPageTitleText() {
		String pageTitle = driver.getTitle();
		return pageTitle;

	}

	
	public String getCurrentPageURL() {
		String pageURL = driver.getCurrentUrl();
		return pageURL;

	}

	
	public String getCurrentPageSource() {
		try {
			return driver.getPageSource();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public void closeActiveWindow() {
		driver.close();

	}

	
	public void closeBrowser() {
		driver.quit();

	}

	
	public void loadAUTURL(String autURL) {
		driver.get(autURL);
	}

	
	public void clearData(WebElement element) {
		element.clear();

	}

	
	public void clickOnElement(WebElement element) {
		// TODO Auto-generated method stub
		try {
			element.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public String getAttributeValue(WebElement element, String attributeName) {
		try {
			String attributeValue = element.getAttribute(attributeName);
			return attributeValue;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return attributeName;

	}

	
	public String getTextOfElement(WebElement element) {
		return element.getText();

	}

	
	public boolean verifyElementVisibility(WebElement element) {
	boolean flag = false;
		try {
			if(element.isDisplayed())
			{
				flag= true;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
return flag;
	}

	
	public boolean verifyElementActiveness(WebElement element) {
		boolean flag = false;
		try {
			if(element.isEnabled())
			{
				
			flag = true;
		}
		}
catch(Exception ex)
{
	ex.printStackTrace();
}
return flag;
	}
	
	
	
	public boolean verifyElementIsSelected(WebElement element) {
		boolean flag = false;
		try {
			if(element.isSelected())
			{
				flag = true;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
return flag;
	}

	
	public void sendDataToElement(WebElement element, String data) {
		try {
			// Clear Any Existing Data
			// clearData(); //this the method we written in the top
			element.clear();
			//LOG STATUS IN EXTENT REPORTS
			ExtentManager.getInstance().getExtentTest().log(Status.PASS, "Data is Cleared");
			
			element.sendKeys(data);
			//LOG STATUS IN EXTENT REPORTS
			ExtentManager.getInstance().getExtentTest().log(Status.PASS, "DATA is entered sucessfully");
		} 
		
		catch (Exception ex) {
			ex.printStackTrace();
			//LOG STATUS IN EXTENT REPORTS
			ExtentManager.getInstance().getExtentTest().log(Status.FAIL, "Required DATA is not entered ");
		}
	}

	
	public void submitOperations(WebElement element) {
		try {
			element.submit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void clickOnCurrentMouseLocatin_Actions() {
		Actions actions = new Actions(driver);
		try {
			actions.click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}


	public void clickOnElementUsingActions(WebElement element) {

		Actions actions = new Actions(driver);
		try {
			actions.click(element).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void doubleClickOnCurrentMouseLocation_Actions() {
		Actions actions = new Actions(driver);
		try {
			actions.doubleClick().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public void doubleClickOnElementUsingActions(WebElement element) {
		Actions action = new Actions(driver);
		try {
			action.doubleClick(element).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void rightClickOnCurrentMouseLocation_Actions() {
		Actions action = new Actions(driver);
		// FOR RIGHT CLICK CONTEXT BUILD IS THE METHOD
		try {
			action.contextClick().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void rightClickOnElementUsingActions(WebElement element) {
		Actions action = new Actions(driver);
		try {
			action.contextClick(element).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void dragAndDrop(WebElement src, WebElement target) {
		Actions action = new Actions(driver);
		try {
			action.dragAndDrop(src, target).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void mouseHover(WebElement element) {
		Actions actions = new Actions(driver);
		try {
			actions.moveToElement(element).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void sendDataUsingActions(WebElement element, String data) {
		Actions actions = new Actions(driver);
		try {
			actions.sendKeys(element, data).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void sendKeysUsingActions(WebElement element, Keys key) {
		Actions actions = new Actions(driver);
		try {
			actions.sendKeys(element, key).build().perform();
			//LOG STATUS IN EXTENT REPORTS
			ExtentManager.getInstance().getExtentTest().log(Status.PASS, "Required key is sucess");
			
		} catch (Exception ex) {
			ex.printStackTrace();
			ExtentManager.getInstance().getExtentTest().log(Status.FAIL, "Required key is Failed");
		}

	}
//javascript

	
	public String getPageTitleUsingJS() {

		// FIRST WE NEED TO DO TYPECASTING
		// i havent understand below code line ask jayram
		String pageTitleText = null;
		JavascriptExecutor je = (JavascriptExecutor) driver;
		try {
			pageTitleText = je.executeScript("return doccument.title").toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pageTitleText;

	}

	
	public String getInnerPageTextUsingJS() {
		String pageInnerText = null;
		JavascriptExecutor je = (JavascriptExecutor) driver;
		try {
			pageInnerText = je.executeScript("return doccument.documentElement.innerText;").toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pageInnerText;

	}

	
	public void refreshPageusingJS() {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		try {
			je.executeScript("history.go(0);");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public void scrollPageUsingJS(String direction) {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		if (direction.equals("Top2Bottom")) {
			je.executeScript("window.scrollTo(0,document.body.scrolHeight);");
		} else if (direction.equals("Bottom2Top")) {
			je.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		}
	}

	
	public void scrollToElementUsingJS(WebElement element) {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		try {
			je.executeScript("arguments[0].scrollIntoView;", element);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void highlightElementUsingJS(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		try {
			je.executeScript("arguments[0].style='border:5px solis red';", element);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public String takesScreenShotBase64(String methodName) {
		
		//save image as base64 format
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		String base64ImageLocation = ts.getScreenshotAs(OutputType.BASE64);
		return base64ImageLocation;
	}
	
	
	
	
	
	public  String takePageScreenshot(String testCasePageName) // (test name as argument ) 
	{
	//get time from system
		long currentTime = System.currentTimeMillis();
		String screenshotLocation = ProjectConstants.getScreenshotsPath() + "/" + testCasePageName + currentTime + ".png";
		
		TakesScreenshot ts =(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	
	//NEED LOCATION AND FILE NAME
	File target = new File (screenshotLocation);
	
	try 
	{
	FileHandler.copy(src, target);	
	}
catch(Exception ex)
	{
	ex.printStackTrace();
}
	return screenshotLocation;
	}

	
	public void takeElementScreenShot() {
		

	}

	
	public String getCssAttributeValue(WebElement element, String cssAtribute) {

		try {
			String cssAtributeValue = element.getCssValue(cssAtribute);
			return cssAtributeValue;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public void selectOptionByVisibleText(WebElement dropDownElement, String optionText) {
		Select select = new Select(dropDownElement);
		try {
			select.selectByVisibleText(optionText);
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	
	public void selectOptionByValue(WebElement dropDownElement, String optionValue) {

		Select select = new Select(dropDownElement);
		try {
			select.selectByValue(optionValue);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	
	public void selectOptionByIndex(WebElement dropDownElement, int optionIndex) {

		Select select = new Select(dropDownElement);
		try {
			select.selectByIndex(optionIndex);
			;
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	
	public List<WebElement> getAllOptionsFromDropdown(WebElement dropDownElement) {
		List<WebElement> getallOptions = null;
		Select select = new Select(dropDownElement);
		try {
			getallOptions = select.getOptions();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getallOptions;

	}

	
	public List<WebElement> getSelectedOptionsFromDropdown(WebElement dropDownElement) {
		List<WebElement> allSelectedOptions = null;
		Select select = new Select(dropDownElement);
		try {
			allSelectedOptions = select.getAllSelectedOptions();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return allSelectedOptions;
	}

	
	public WebElement getFirstSelecectedOptionFromDropDown(WebElement dropDownElement) {
		WebElement getFirstSelectedOption = null;
		Select select = new Select(dropDownElement);
		try {
			getFirstSelectedOption = select.getFirstSelectedOption();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getFirstSelectedOption;
	}

	
	public void deselecteAllOptions(WebElement dropDownElement) {
		Select select = new Select(dropDownElement);
		try {
			select.deselectAll();

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public void deselectOptionByVisibleText(WebElement dropDownElement, String visibleText) {
		Select select = new Select(dropDownElement);
		try {
			select.deselectByVisibleText(visibleText);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void deselectOptionByValue(WebElement dropDownElement, String optionvalue) {
		Select select = new Select(dropDownElement);
		try {
			select.deselectByValue(optionvalue);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void deselectOptionByIndex(WebElement dropDownElement, int optionIndex) {
		Select select = new Select(dropDownElement);
		try {
			select.deselectByIndex(optionIndex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public boolean verifyDropDownType(WebElement dropDownElement) {
		Select select = new Select(dropDownElement);
		return select.isMultiple();
	}


	}
