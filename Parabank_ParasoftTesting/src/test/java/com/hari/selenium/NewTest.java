//Author is Harikrishna neerukonda
package com.hari.selenium;

import org.testng.annotations.Test;

import com.hari.selenium.utility.TestUtil;
import com.hari.selenium.utility.Xls_Reader;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class NewTest 
{
	public WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		 System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
		  //driver.get("http://parabank.parasoft.com/parabank/index.htm");

		
	}
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData=TestUtil.getDataFromExcel();
		return testData.iterator();
		
	}
	
  @Test(priority=1,dataProvider="getTestData")
  
  public void customerRegisteration(String firstname,String lastname,String address,String city,String state,String pincode,String phonenumber,String ssn,String username,String password) throws InterruptedException
  {
	 
	 		
	
		 driver.findElement(By.linkText("Register")).click();
			
	  
	  driver.findElement(By.xpath("//input[contains(@name,'customer.firstName')]")).sendKeys(firstname+Keys.TAB+lastname+Keys.TAB+address+Keys.TAB+city+Keys.TAB+state+Keys.TAB+pincode+Keys.TAB+phonenumber+Keys.TAB+ssn);
	  driver.findElement(By.xpath("//input[contains(@name,'customer.username')]")).sendKeys(username+Keys.TAB+password+Keys.TAB+password);
	  driver.findElement(By.xpath("//input[@value='Register']")).click();
	  Thread.sleep(20000);
		}
	  


	@Test(priority=2)
    @Parameters({"url","username","password"})
  public void customerLoginAndLogout(String url,String username,String password) throws IOException, InterruptedException
  {
	  driver.get(url);
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@value='Log In']")).click();
	  EventFiringWebDriver e=new EventFiringWebDriver(driver);
	 File f1= e.getScreenshotAs(OutputType.FILE);
	 File f2=new File("c://screenshot//loginpage.jpg");
	 FileUtils.moveFile(f1, f2);
	 Thread.sleep(20000);
	 if(driver.findElement(By.linkText("Log Out")).isEnabled())
	 {
		 System.out.println("login is done successfully");
	 driver.findElement(By.linkText("Log Out")).click();
	 System.out.println("logout is done successfully");
	 }
	 else
	 {
		 System.out.println("login and Logout is not happening");
	 }
	  
	  
	  
  }

  @Test(priority=3)
  @Parameters({"url","username","password"})
  public void openNewAccount(String url,String username,String password)
  {
	  driver.get(url);
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@value='Log In']")).click();
	  System.out.println("login succes and going to click on open new account link");
	  driver.findElement(By.linkText("Open New Account")).click();
	 WebElement w= driver.findElement(By.xpath("//select[@ng-model='types.selectedOption']"));
	  
	  Select s=new Select(w);
	  s.selectByVisibleText("SAVINGS");
	WebElement w2=  driver.findElement(By.xpath("//select[@ng-init='getAccounts()']"));
	Select s2=new Select(w2);
	s2.selectByIndex(0);
	driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
  }

  @AfterMethod
  public void tearDown()
  {
	  System.out.println("tearDown() called");
	  driver.quit();
  }

}
