package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginIn {

	WebDriver ldriver;
	public LoginIn(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(id="login2") WebElement loginlink;
	//@FindBy(xpath="//a[text()='Log in']") WebElement loginlink;
	@FindBy(id="loginusername") WebElement loginusername;
	@FindBy(id="loginpassword") WebElement loginpassword;
	@FindBy(xpath="//button[text()='Log in']") WebElement loginbutton;
	
	public void clickLoginButton() {
		loginbutton.click();
	}
	
	public void giveLPassword(String lpass)
	{
		loginpassword.sendKeys(lpass);
	}
	
	public void giveLUsername(String luser)
	{
		loginusername.sendKeys(luser);
	}
	
	public void clickLoginLink()
	{
		loginlink.click();
	}
	
}
