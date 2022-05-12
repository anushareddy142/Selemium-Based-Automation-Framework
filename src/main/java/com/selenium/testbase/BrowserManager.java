package com.selenium.testbase;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.selenium.constants.ProjectConstants;



public class BrowserManager {
	public static void initBrowser(String browser) throws IOException {
		// VERIFY THE OPERATING SYSTEM
		String OS = System.getProperty("os.name").toLowerCase();
		System.out.println(OS);

		// Verify That Driver object is null
		if (Objects.isNull(DriverManager.getDriver())) // Verifying weather the passed driver is null, so that we can
														// set driver object
		{
			// Set The Driver Object

			if (OS.contains("win")) {
				// Windows area -browser drivers

				if (browser.equalsIgnoreCase("chrome")) {
					// Verify HEADLESS Condition

					if (PropertyReader.readProperty("headless").equalsIgnoreCase("true")) {
						// Chrome Driver path
						System.setProperty(ProjectConstants.getChromeDriverKey(),
								ProjectConstants.getChromeDriverLocation());
						ChromeOptions co = new ChromeOptions();
						co.setHeadless(true);
						DriverManager.setDriver(new ChromeDriver(co));

					} else {
						System.setProperty(ProjectConstants.getChromeDriverKey(),
								ProjectConstants.getChromeDriverLocation());
						// set driver with Chrome
						DriverManager.setDriver(new ChromeDriver());
					}
					try {
						DriverManager.getDriver().get(PropertyReader.readProperty("url"));
						// ExtentManager.getInstance().getExtentTest().log(Status.PASS, "WebSite Loading
						// is Passed") ;
						DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
					}

					catch (Exception ex) {
						// log launch in extentreports
						// ExtentManager.getInstance().getExtentTest().log(Status.FAIL, "WebSite Loading
						// is Failed");

					}
				} else if (browser.equalsIgnoreCase("firefox")) {

				} else if (browser.equalsIgnoreCase("opera")) {
					// opera path
				} else if (browser.equalsIgnoreCase("edge")) {
					// Edge browser Path
				}

				// launch Website
				DriverManager.getDriver().get(PropertyReader.readProperty("url"));

			}

		}

		else if (OS.contains("linux")) {
			// Linux area
		}

		else if (OS.contains("mac")) {
			// MAC AREA

		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();

			// remove the driver instance from threadlocal
			DriverManager.removeDriver();
		}
	}

}

