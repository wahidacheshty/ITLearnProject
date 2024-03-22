package com.ITLearn.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	WebDriver driver;
	/*Requirement:
	 * Scenario
	 * payment 
	 * Go to the Dash Board
	 * from dash board go to the   Offered Academies option
	 * from Offered Academies option click on Subscribe Now button
	 * then click on Pay with Stripe  Radio button
	 * press the place Order Button
	 * enter the card details
	 * click on Pay Now Button
	 * 
	 */
	 public PaymentPage(WebDriver pdriver) {
		
		this .driver = pdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"login-list\"]/li[1]/a") WebElement dashBoardClick;
     @FindBy(xpath="//*[@id=\"learn-press-user-profile\"]/ul/li[3]/a") WebElement offeredAcademiesOption;
     @FindBy(xpath="//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form/div/button") WebElement subscribeNowBtn;
     @FindBy(xpath="//*[@id=\"learn-press-payment\"]/ul/li/label") WebElement payWithStripeBtn;
     @FindBy(xpath="//*[@id=\"learn-press-checkout-place-order\"]") WebElement placeOrderBtn;
     @FindBy(xpath="//*[@id=\"card-element\"]/div/iframe")WebElement frameCardDetails;
     @FindBy(name="cardnumber")WebElement cardNum;
     @FindBy(name="exp-date")WebElement expDate;
     @FindBy(name="cvc")WebElement cvcNum;
     @FindBy(xpath="//*[@id=\"payment-button\"]")WebElement paynowBtn;
     
     public void offeredAcademiesPayment(String cardDetails, String exp,String cvcnum) throws InterruptedException{
    	
    	 System.out.println(cardDetails+ " "+exp + " "+cvcnum);
    	 dashBoardClick.click(); 
    	offeredAcademiesOption.click();
    	subscribeNowBtn.click();
    	 payWithStripeBtn.click();
    	 Thread.sleep(5000);
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("window.scrollBy(0,750)", "");
    	 
    	 placeOrderBtn.click();
    	 driver.switchTo().frame(frameCardDetails);
    	 cardNum.sendKeys(cardDetails);
    	 expDate.sendKeys(exp);
    	 cvcNum.sendKeys(cvcnum);
    	 
    	 driver.switchTo().defaultContent();
    	 
    	 paynowBtn.click();
     }
}
