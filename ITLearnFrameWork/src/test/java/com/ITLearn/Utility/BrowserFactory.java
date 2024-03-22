package com.ITLearn.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	public static  WebDriver openBroser(WebDriver driver,String browserName,String url) {
		
	if( browserName.equals("chrome")) {
		
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	//ChromeOptions op = new ChromeOptions();
	driver = new ChromeDriver();	
	}
	
	else if(browserName.equals("fireFox")) {	
		
		
		System.setProperty("webdriver.fireFox.driver", "./drivers/fireFoxdriver.exe");
		driver = new ChromeDriver();	
		
		
	}
	
else if(browserName.equals("edg")) {	
		
		
		System.setProperty("webdriver.edge.driver", "./drivers/edgedriver.exe");
		driver = new ChromeDriver();	
	
	
	
	
	}
	driver.manage().window().maximize();
	
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
	
	
	}
	//public static void quitBrowser(WebDriver driver) {
		//driver.quit();
	//}
}
