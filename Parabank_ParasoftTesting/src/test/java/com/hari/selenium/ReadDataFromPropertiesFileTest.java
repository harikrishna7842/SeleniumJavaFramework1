package com.hari.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReadDataFromPropertiesFileTest
{
	public static WebDriver driver;
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
	@Test
	public static void getPropertiesAndLogin() throws IOException
	{
		File file = new File("F:\\java\\selinium programs\\Parabank_ParasoftTesting\\src\\test\\java\\com\\hari\\selenium\\testdata\\testdata.properties");
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//WebDriver driver = new ChromeDriver();

		 driver.get(prop.getProperty("url"));
		  driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		  driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		  driver.findElement(By.xpath("//input[@value='Log In']")).click();
		

	}
	@Test
	public void setProperties() throws IOException
	{
		OutputStream out=new FileOutputStream("F:\\java\\selinium programs\\Parabank_ParasoftTesting\\src\\test\\java\\com\\hari\\selenium\\testdata\\testdata.properties");
		Properties prop=new Properties();
		prop.setProperty("message", "welcome to selenium");
		prop.store(out, null);
	
	}
	 @AfterMethod
	  public void tearDown()
	  {
		  System.out.println("tearDown() called");
		  driver.close();
	  }



}
