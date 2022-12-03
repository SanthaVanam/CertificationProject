package com.StepsDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.AddingItemstoCart;
import com.PageObjects.Homepage;
import com.PageObjects.LoginIn;
import com.PageObjects.PlacingOrder;
import com.PageObjects.UserRegistration;
import com.utilities.ExcelUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsDefinitionClass {
	WebDriver driver;
	LoginIn login;
	UserRegistration register;
	Homepage home;
	AddingItemstoCart addtocart;
	PlacingOrder place;
	
	
	@Given("Lauching chrome browser")
	public void lauching_chrome_browser() 
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		home = new Homepage(driver);
		register = new UserRegistration(driver);
		login = new LoginIn(driver);
		addtocart = new AddingItemstoCart(driver);
		place = new PlacingOrder(driver);
		
	}

	@When("User opens url {string} and clicking on signup")
	public void user_opens_url_and_clicking_on_signup(String string) 
	{
	    driver.get(string);
	    register.clickSignupLink();
	}

	@When("User enter new user name {string} and password {string}")
	public void user_enter_new_user_name_and_password(String stringu, String stringp) throws InterruptedException 
	{
		Thread.sleep(5000);
	    register.newUsernamevalue(stringu);
	    register.newPasswordValue(stringp);
	    
	    
	}

	@Then("click on ok button")
	
	public void click_on_ok_button() throws InterruptedException
	{
		register.clickSignup();
		Thread.sleep(2000);
		Alert ale = driver.switchTo().alert();
		System.out.println(ale.getText());
		ale.accept();
	}	
	
	@When("User opens url {string} and clicking on signinlink")
	public void user_opens_url_and_clicking_on_signinlink(String string) throws InterruptedException {
	    driver.get(string);
	    login.clickLoginLink();
	    Thread.sleep(2000);
	}

	@When("User enter valid user name {string} and password {string}")
	public void user_enter_valid_user_name_and_password(String string, String string2) {
	   login.giveLUsername(string);
	   login.giveLPassword(string2);
	   login.clickLoginButton();
	   	}
	
	@Then("close browser")
	public void close_browser() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.close();
	}
	 
	@Then("In home page the username should be {string}")
	public void in_home_page_the_username_should_be(String string) 
	{
	    String valusername = driver.findElement(By.xpath("//a[text()='Welcome santha12345678']")).getText();
	    System.out.println(valusername);
	    if(valusername.equals(string))
	    {
	    	System.out.println("User logged in succussfully");
	    }
	    else
	    	System.out.println("Given id is invalid");
	}
	
	
	@Then("click logout button")
	public void click_logout_button() throws InterruptedException 
	{
	    WebElement logoutbutton = driver.findElement(By.xpath("//a[text()='Log out']"));
	    Thread.sleep(5000);
	    logoutbutton.click();
	    Thread.sleep(3000);
	    driver.close();
	}

		
	@Then("click on laptop option, select {string} amd click on add to cart")
	public void click_on_laptop_option_select_amd_click_on_add_to_cart(String string) throws InterruptedException 
	{		
		Thread.sleep(3000);
		addtocart.clickOnLaptopoption();
		Thread.sleep(3000);
		List<WebElement> items = driver.findElements(By.xpath("//div//h4/a"));
		Thread.sleep(3000);
		for(WebElement item:items)
		{
			String it =item.getText();
			Thread.sleep(3000);
			if(it.equals(string))
			{
				Thread.sleep(3000);
				item.click();
				Thread.sleep(3000);
				addtocart.clickOnAddtocart();
				Thread.sleep(3000);
				driver.switchTo().alert();
			}
			
				
			}
		
		
	}
	

	
	
	@Then("go to cart")
	public void go_to_cart() throws InterruptedException {
		//driver.findElement(By.xpath("//a[normalize-space(text())='Home']")).click();
		Thread.sleep(5000);
		place.clickOncart();
			}

	@When("clicking on place order")
	public void clicking_on_place_order() throws InterruptedException {
		Thread.sleep(6000);
		place.clickOnPlaceOrder();
	}

	@When("Giving valid credentials and credit card details")
	public void giving_valid_credentials_and_credit_card_details() {
		place.enterUserData();
		place.enterCountryData();
		place.enterCity();
		place.enterCardDetails();
		place.enterMonth();
		place.enterYear();
	}

	@Then("click on purchase option")
	public void click_on_purchase_option() throws InterruptedException {
		place.clickOnPurchaseOption();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[.='OK']")).click();
		
	}
	

	

}
