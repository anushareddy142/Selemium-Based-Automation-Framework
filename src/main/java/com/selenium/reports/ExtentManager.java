package com.selenium.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	//private static  ExtentManager extentManager = new ExtentManager();
		private static ExtentManager extentManager = null;
		
		private ExtentManager()  //Restricting other class from creating object of this class, 
		//to acess that object we will create below method so when we call that method it will return 
		//object of this class, therefore you have to create object like in the above line and return in the below method.
		//since we are creating only one object ,this is called singleton patteren.
	 {
		 
	 }
		
		
		
		
		private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //we will make private so that only this class willuse , 
		//and also static because it will load when class is loaded

		
		//for singleton patteren
	public static ExtentManager getInstance() {
			
			
			//it has to return object of this class
		
			if(Objects.isNull(extentManager))
	{
		extentManager = new ExtentManager();
		
	}
				return extentManager;
			
		}

	//since it is private we need to impliment getters and setters if any class wants to use 
	public void setExtentTest(ExtentTest extentTestObj)
	{
		extentTest.set(extentTestObj); //it will creat object in thread local
	}

	public ExtentTest getExtentTest() {
		return  extentTest.get();
		
	}
	 //once work is over you have to remove object from threadlocal

	public void removeExtentTestObj()
	{
		extentTest.remove();
	}
}
