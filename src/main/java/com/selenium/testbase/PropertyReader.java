package com.selenium.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	static String propertyFileLoc = "src/main/resources/config.properties";
	// When ever we want to callthis method we will create object in the test case
	// for this class and we will call with that object
	// we need to request which value we want so we need to pass parameter

	public static FileInputStream stream;
	public static Properties prop;
	//So that any one can access above values;

	public static String readProperty(String propvalue) throws IOException {
		String propertiesValue = null; // in future if we change anything and if it doesnt return any value it has to
										// return null
		 prop = new Properties();

		try {

			stream = new FileInputStream(propertyFileLoc);
			prop.load(stream);
			propertiesValue = prop.getProperty(propvalue);// it should return propertyValue so we need to change

			// return type to string

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return propertiesValue;

	}




}
