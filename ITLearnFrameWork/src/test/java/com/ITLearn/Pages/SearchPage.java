package com.ITLearn.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	
WebDriver ldriver;
	
	public SearchPage(WebDriver driver)
	{
	this.ldriver = driver;
	
	PageFactory.initElements(driver, this);
		
	}
	
	
    @FindBy(xpath="//*[@id=\"primary_menu\"]/nav[1]/form/button")WebElement searchbar;
    @FindBy(id ="search_course")WebElement searchClick;
	
	
	public void searchCourses(String course ) {
		searchClick.sendKeys(course);
		searchbar.click();
	}
	
	
	
	
	
	
	

}
