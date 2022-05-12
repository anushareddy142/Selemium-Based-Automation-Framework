package com.selenium.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements extends BasePage {

	public HomePageElements() {
		super();
	}

	@FindBy(xpath="//input[contains(@autocomplete,'off')]")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@name='dgwt-wcas-search-submit']")
	WebElement searchButton;
	
	@FindBy(xpath = "//button[@name='add-to-cart']")
	WebElement addToCart;
	
	@FindBy(xpath = "//i[@class='mdi mdi-cart']")
	WebElement cartBtn;
	
	
	@FindBy(xpath="//a[@aria-label='Remove this item']")
	List<WebElement> clearItems;
	
	@FindBy(xpath="//a[@class='float-right']//i[@class='mdi mdi-close']")
	WebElement closeCart;
	
	public WebElement getSearchBox() {
		return searchBox;
		
	}

   public WebElement getSearchButton() {
		return searchButton;
		}
   public WebElement getAddtoCartBtn() {
		return addToCart;
		
	}
   
   public WebElement getCartBtn() {
	   return cartBtn;
   }

	public List<WebElement> getClearItems() {
		return clearItems;
	}

	public WebElement getCloseCart() {
		return closeCart;
	}

}
