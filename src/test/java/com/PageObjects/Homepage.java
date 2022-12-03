package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver ldriver;
	public Homepage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
@FindBy(id="nameofuser") WebElement validateusername;

public void validatingUsername() {
//	String valusername = validateusername.getText();
	
	}

}
