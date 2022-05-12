package com.selenium.listeners;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.selenium.testbase.PropertyReader;

public class RetryAnalyzerImpl implements IRetryAnalyzer {
int minCount = 1;
int maxCount = 2;
	
	
	public boolean retry(ITestResult result) {
		try {
			if(PropertyReader.readProperty("retryfailedtestcases").equalsIgnoreCase("yes"))
			{
				if(minCount<maxCount)
				{
					minCount++;
					return true;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
