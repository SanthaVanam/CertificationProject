package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlacingOrder {
	
	WebDriver ldriver;
	public PlacingOrder(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
		
	@FindBy(xpath="//a[.='Cart']") WebElement cart;
	@FindBy(className="btn-success") WebElement placeorder;
	@FindBy(id="name") WebElement nametxt;
	@FindBy(id="country") WebElement countrytxt;
	@FindBy(id="city") WebElement citytxt;
	@FindBy(id="card") WebElement cardtxt;
	@FindBy(id="month") WebElement monthtxt;
	@FindBy(id="year") WebElement yeartxt;
	@FindBy(xpath="//button[text()='Purchase']") WebElement purchaseoption;

	
	public void enterCity() {
		citytxt.sendKeys("vijayawada");
	}
	
	public void enterCardDetails() {
		cardtxt.sendKeys("123456789");
	}
	
	public void enterMonth()
	{
		monthtxt.sendKeys("05");
	}
	
	public void enterYear()
	{
		yeartxt.sendKeys("2023");
	}
	
	public void clickOnPurchaseOption() {
		purchaseoption.click();
	}
	
	public void enterCountryData()
	{
		countrytxt.sendKeys("India");
	}
	public void enterUserData()
	{
		nametxt.sendKeys("Kumar");
			}
	
	public void clickOnPlaceOrder()
	{
		placeorder.click();
	}
	
	public void clickOncart() {
		cart.click();
	}
	
}
