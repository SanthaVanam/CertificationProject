package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegistration {
	
	WebDriver ldriver;
	public UserRegistration(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	
	@FindBy(id="signin2") WebElement signuplink;
	@FindBy(id="sign-username") WebElement newusername;
	@FindBy(id="sign-password") WebElement newpassword;
	@FindBy(xpath="//button[text()='Sign up']") WebElement signupbutton;
	
	public void clickSignup() {
		signupbutton.click();
	}
	
	public void newPasswordValue(String password)
	{
		newpassword.sendKeys(password);
	}
	
	public void clickSignupLink()
	{
		signuplink.click();
	}
	
	public void newUsernamevalue(String user)
	{
		newusername.sendKeys(user);
	}
	
	
}
