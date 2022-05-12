package com.selenium.testbase;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>(); //we want to use only to this class so private, and want load as soon as class is created so
	//static...ThreadLocal is a class from JAVA.
	
	
	public static void setDriver(WebDriver driver) //when we call this method we need to pass driver ,
	//whatever driver we pass, we need to set it for " dr " object, it will place in the one location in threalocal, set is the method from threadLocal Class
	
	{
		dr.set(driver);
	}
	public static WebDriver getDriver() 
	
	{
		return dr.get();
	}
	
	public static void removeDriver() { // once you are done with operation you can destroy the object
		dr.remove();
	}
}
