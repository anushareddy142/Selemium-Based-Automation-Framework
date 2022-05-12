package com.selenium.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageElements extends BasePage {

	public CreateAccountPageElements(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[normalize-space()='My Account']")
	WebElement myAccount;

	@FindBy(css = "input[type='email']")
	WebElement enterEmail;

	@FindBy(xpath = "//button[@name='register']")
	WebElement clickOnRegister;

	public WebElement getMyAccountLink() {
		return myAccount;
	}

	public WebElement getEmail() {
		return enterEmail;
	}

	public WebElement getRegisterButton() {
		return clickOnRegister;
	}
}
