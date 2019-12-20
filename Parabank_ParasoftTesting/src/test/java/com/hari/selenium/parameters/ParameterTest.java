package com.hari.selenium.parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest 
{
	WebDriver driver;
	@Test(priority=1)
	@Parameters({"url","username","password"})
	 public void testCustomerLoginAndLogout(String url,String username,String password) throws IOException, InterruptedException
	  {
		 System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 System.out.println(url);
		  driver.get(url);
		  driver.findElement(By.name("username")).clear();
		  driver.findElement(By.name("username")).sendKeys(username);
		  driver.findElement(By.name("password")).clear();
		  driver.findElement(By.name("password")).sendKeys(password);
		  driver.findElement(By.xpath("//input[@value='Log In']")).click();

	  }
}
