package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingItemstoCart{
	WebDriver ldriver;
	public AddingItemstoCart(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(linkText="Phones") WebElement phones;
	@FindBy(xpath="//button[text()='Next']") WebElement nextbutton;
	@FindBy(xpath="//a[text()='MacBook air']") WebElement selectlaptop;
	@FindBy(xpath="//a[text()='Add to cart']") WebElement addtocartoption;
	
	
	
	public void clickOnAddtocart()
	{
		addtocartoption.click();
	}
	
	public void selectRequiredLaptop() {
		selectlaptop.click();
	}
	
	public void clickOnnextbutton() {
		nextbutton.click();
	}
	
	public void clickOnLaptopoption()
	{
		phones.click();
	}
	
}
