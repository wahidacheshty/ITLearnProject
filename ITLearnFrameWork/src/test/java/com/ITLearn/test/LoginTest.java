

package com.ITLearn.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ITLearn.Pages.Base;
import com.ITLearn.Pages.LoginPage;
import com.ITLearn.Utility.ReadExcelFile;

public class LoginTest extends Base{
	
	String filename= System.getProperty("user.dir")+"\\TestData\\loginData.xlsx";
	
	@Test(dataProvider="loginDataProvider")
	public void verify(String username,String password) throws IOException
	{
		
		
		LoginPage lp= new LoginPage(driver);
		lp.loginPortal(username, password);
		if(username.equals("Demo12")&&password.equals("Test123456$")) {
			Assert.assertTrue(true);
			lp.logout();	
		}
		else {
			captureScreenShot(driver,"verify");
			Assert.assertTrue(false);
		}
	}
	@DataProvider()
	public String[][] loginDataProvider()
	{
		int row= ReadExcelFile.getRowCount(filename, "login");
		int column =ReadExcelFile.getColCount(filename, "login");
		
		String data[][]= new String[row-1][column];
		
		for(int i=1;i<row;i++)
		{
			for (int j=0;j<column;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(filename, "login", i, j);
			}
		}
		
		return data;
		
	}
}
