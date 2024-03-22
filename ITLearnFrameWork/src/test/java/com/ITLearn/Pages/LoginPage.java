package com.ITLearn.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver driver)
	{
	this.ldriver = driver;
	
	PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath ="//*[@id=\"loginlabel\"]")WebElement loginClick;
	@FindBy (id ="user_login")WebElement userName;
    @FindBy(id ="user_pass")WebElement passWord;
    @FindBy(id ="wp-submit")WebElement submittBtn;
   
    @FindBy(xpath="//*[@id=\"gk-login-toggle\"]/i") WebElement logoutimage;
    	
    	@FindBy(xpath="//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a") WebElement logoutclick;
    
    
    public  void loginPortal( String username,String password ) {
    	
    	loginClick.click();
    	userName.sendKeys(username);
    	passWord.sendKeys(password);
    	submittBtn.click();
    	//logoutimage.click();
    	//logoutclick.click();
    }
    
    public void logout() {
    	logoutimage.click();
    	logoutclick.click();
    	
    }
}
