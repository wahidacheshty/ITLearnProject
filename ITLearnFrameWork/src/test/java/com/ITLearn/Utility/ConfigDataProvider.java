package com.ITLearn.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	public  ConfigDataProvider(){
		 
	File src = new File( "./Configration/config.properties"); 
		 
		 try {
			FileInputStream fis = new  FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} 
		 
		 catch (Exception e) {
	
			e.printStackTrace();
		}
		 
		 
}
	
	 public String getBrowserName()
	 {
		 return pro.getProperty("browser");
	 }
	 
	 public String getUrl()
	 {
		 return pro.getProperty("url");
	 }
	
	
	
}
