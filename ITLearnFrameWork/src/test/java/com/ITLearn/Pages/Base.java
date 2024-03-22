package com.ITLearn.Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ITLearn.Utility.BrowserFactory;
import com.ITLearn.Utility.ConfigDataProvider;

public class Base {
	public WebDriver driver;
	public ConfigDataProvider  cdp = new  ConfigDataProvider(); 
	
	@BeforeClass
	public void setup () {
		
		driver=BrowserFactory.openBroser(driver, cdp.getBrowserName(), cdp.getUrl());
	}
	
	public void captureScreenShot( WebDriver driver, String testName) throws IOException {
		 // Convert webdriver object to TakesScreenshot interface
		 TakesScreenshot screenshot= ((TakesScreenshot)driver);
		 
		 // Step 2 :call getScreenshotAs method to capture image file
		 
		 File src= screenshot.getScreenshotAs(OutputType.FILE);
		 File srcpath=new File("."+"//screenshot//"+ testName + ".png");
		 
		 // Step 3 : copy image file to destination 
		 FileUtils.copyFile(src, srcpath);
		
		
	}
@AfterClass
public void tearDown() {
	driver.close();
}

}
