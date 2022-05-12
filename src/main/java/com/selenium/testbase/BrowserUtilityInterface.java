package com.selenium.testbase;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public interface BrowserUtilityInterface {

	//*************Utility Methods for Navigation Interface************
	
		public void clickOnBrowserButton();
		public void clickOnBrowserBackButton();
		public void pageRefresh();
		void navigateToURL(String webURL);

		//*************Utility Methods for Options Interface********

		public Set<Cookie> getAllCookiesInpage();
		public void deleteAllCookiesInpage();
		Cookie getCookiesInfoByName(String cookieName);
		boolean deleteCookiesByName(String cookieName);
		boolean addNewCookie(String cookieName, String cookieValue);
		


		//***** Utility Methods for Window Interface**************
		public void setFullScreenMode();
		public void setBrowserMaximize();
		void setWindowPosition(int xCorValue, int yCorValue);
		void setWindowSize(int browserHeight, int browserWidth);
		public Point getWindowPosition();
		public Dimension getWindowSize();


		//************Utility Methods For Alert Interface*******************
		public void acceptJSAlertBox();
		public void dismissJSAlertBox();
		public String getTextFromJSAlertBox();
		void setTextToJSAlertBox(String dataToAlertBox);
		
		
		public void checkAlertBoxPresent();


		//**************Utility Methods For Frames**********************
		void switchToFrameByIndex(int sendFrameIndex);
		void switchToFrameByFrameElement(WebElement frameElement);
		void switchToFrameByNameOrID(String nameOrId);
		public void switchToParentFrame();


		//****************Utility Methods for Handling Multiple Windows************
		public void switchToWindowByTitle(String windowTitleText);
		public void switchToWindowByIndex(int windowIndex);
		public void switchToParentWindow();

		//****************Utility Methods for TimeOuts******************
		public void setImplicitWaitPage();
		public void setPageLoadTime();
		public void setScriptPageLoad();

		//***************Utility for common Actions***********
		public String getPageTitleText();
		public String getCurrentPageURL();
		public String getCurrentPageSource();
		public void closeActiveWindow();
		public void closeBrowser();
		public void loadAUTURL(String autURL);
		public void clearData(WebElement element);
		public void clickOnElement(WebElement element);
		public String getAttributeValue(WebElement element, String attributeName);
		public String getCssAttributeValue(WebElement element, String cssAtribute);
		public String getTextOfElement(WebElement element);
		public boolean verifyElementVisibility(WebElement element);
		public boolean verifyElementActiveness(WebElement element);
		public boolean verifyElementIsSelected(WebElement element);
		public void sendDataToElement(WebElement element ,String data);
		public void submitOperations(WebElement element);


		//***************Utility Methods for Actions Class************
		public void clickOnCurrentMouseLocatin_Actions();
		public void clickOnElementUsingActions(WebElement element);
		public void doubleClickOnCurrentMouseLocation_Actions();
		public void doubleClickOnElementUsingActions(WebElement element);
		public void rightClickOnCurrentMouseLocation_Actions();
		public void rightClickOnElementUsingActions(WebElement element);
		public void dragAndDrop(WebElement src, WebElement target);
		public void mouseHover(WebElement element);
		public void sendDataUsingActions(WebElement element, String data);
		public void sendKeysUsingActions(WebElement element, Keys key);


		//************** Utility Methods for JavaScriptExecutor******************
		public String getPageTitleUsingJS();
		public String getInnerPageTextUsingJS();
		public void refreshPageusingJS();
		public void scrollPageUsingJS(String direction);
		public void scrollToElementUsingJS(WebElement element);
		public void highlightElementUsingJS(WebElement element );


		//************Utility Methods for TakeScreenShot Interface**********
		public String takesScreenShotBase64(String methodName);
		public String takePageScreenshot(String methodName);
		public void takeElementScreenShot();
		
		//************************UTILITY Methods for DRopdowns***********//
		public void selectOptionByVisibleText(WebElement dropDownElement, String optionText);
		public void selectOptionByValue(WebElement dropDownElement, String optionValue);
		public void selectOptionByIndex(WebElement dropDownElement, int optionIndex);
		public List<WebElement> getAllOptionsFromDropdown(WebElement dropDownElement );
		public List<WebElement> getSelectedOptionsFromDropdown(WebElement dropDownElement);
		public WebElement getFirstSelecectedOptionFromDropDown(WebElement dropDownElement );
		public void deselecteAllOptions(WebElement dropDownElement );
		public void deselectOptionByVisibleText(WebElement dropDownElement, String visibleText );
		public void deselectOptionByValue(WebElement dropDownElement, String optionvalue );
		public void deselectOptionByIndex(WebElement dropDownElement, int optionIndex );
		public  boolean verifyDropDownType(WebElement dropDownElement) ;
		
}
