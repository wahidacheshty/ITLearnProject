package com.ITLearn.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ITLearn.Pages.Base;
import com.ITLearn.Pages.LoginPage;
import com.ITLearn.Pages.PaymentPage;
import com.ITLearn.Utility.ReadExcelFile;

public class PaymentTest extends Base{
	
	
	
String filename= System.getProperty("user.dir")+"\\TestData\\loginData.xlsx";
	
	
	
	
	@Test(priority=1)
	public void doPayment() throws InterruptedException, IOException {
		LoginPage lp= new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(filename, "login", 1, 0);
		String password=ReadExcelFile.getCellValue(filename, "login", 1, 1);
		
		
		lp.loginPortal(username, password);
		
		
		PaymentPage pp = new PaymentPage(driver);
		
		
		String  cardNum = ReadExcelFile.getCellValue( filename, "Payment", 0, 0);
		System.out.println(cardNum);
		String expDate = ReadExcelFile.getCellValue( filename, "Payment", 0, 1);
		String  cvcNum = ReadExcelFile.getCellValue( filename, "Payment", 0, 2);
		
		pp.offeredAcademiesPayment(cardNum,expDate,cvcNum);
		
}
	
	
	
	
	
	
	

}
