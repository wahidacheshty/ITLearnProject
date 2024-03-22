package com.ITLearn.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ITLearn.Pages.Base;
import com.ITLearn.Pages.LoginPage;
import com.ITLearn.Pages.SearchPage;
import com.ITLearn.Utility.ReadExcelFile;

public class SearchTest extends Base {
	
	
	
String filename= System.getProperty("user.dir")+"\\TestData\\loginData.xlsx";
	
	@Test
	public void verify()
	{
		LoginPage lp= new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(filename, "login", 1, 0);
		String password=ReadExcelFile.getCellValue(filename, "login", 1, 1);
		
		
		lp.loginPortal(username, password);
		if(username.equals("Demo12")&&password.equals("Test123456$")) {
			Assert.assertTrue(true);
//			lp.logout();	
		}
		else {
			Assert.assertTrue(false);
		}
	}
	@Test(dependsOnMethods="verify")
	public void coreSearch() {
		
	SearchPage srp = new SearchPage( driver);
	String cor= ReadExcelFile.getCellValue(filename, "DashBoard",0, 0);
	
	srp.searchCourses(cor);
	
		
	}
	
	

}
