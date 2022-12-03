package com.StepsDefinition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.LoginIn;
import com.utilities.ExcelUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DDTlogin {

	WebDriver driver;
	@Test(dataProvider="loginData")
	public void loginUsingDDT(String user,String pwd,String welcomemsg) throws IOException, InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com");
		
		LoginIn lp = new LoginIn(driver);	
		lp.clickLoginLink();
		Thread.sleep(3000);
		 lp.giveLUsername(user);
		   lp.giveLPassword(pwd);
		   lp.clickLoginButton();
		   Thread.sleep(3000);
		
		   String valusername = driver.findElement(By.id("nameofuser")).getText();
		   
		    if(valusername.equals(welcomemsg))
		    {
		    	System.out.println("User logged in succussfully");
		    	 System.out.println(valusername);
		    
		    Thread.sleep(5000);
		    WebElement logoutbutton = driver.findElement(By.xpath("//a[text()='Log out']"));
		    Thread.sleep(5000);
		    logoutbutton.click();
		    Thread.sleep(3000);
		    driver.close();
		  }
		
		    		 
	}


	@DataProvider
	public String[][] loginData() throws Exception
	{

		String path = "D:\\projects\\DemoBlaze\\src\\test\\java\\com\\TestData\\BlazeData.xlsx";
		
		int rowcount = ExcelUtilities.getRowCount(path,"Sheet1");
		int colcount = ExcelUtilities.getColCount(path,"Sheet1",0);
		System.out.println("No.of Rows :"+rowcount);
		System.out.println("No. of Columns :"+colcount);

		String [][] data = new String[rowcount][colcount];
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i][j] = ExcelUtilities.getCellData(path,"Sheet1",i,j);

			}
		}

		return data;
	}
	
}
