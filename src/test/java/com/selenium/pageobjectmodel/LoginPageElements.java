package com.selenium.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements extends BasePage {

	public LoginPageElements() {
		super();

	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@name='login']")
	WebElement loginBtn;


public WebElement getUserName() {
	return username;
}
 public WebElement getPassword() {
	 return password;
 }
 
 public WebElement getLoginBtn() {
	 return loginBtn;
 }
}
