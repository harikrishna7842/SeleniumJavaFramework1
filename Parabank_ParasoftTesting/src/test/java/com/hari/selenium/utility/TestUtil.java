package com.hari.selenium.utility;

import java.util.ArrayList;

public class TestUtil
{
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
	
		try
		{
			
			reader=new Xls_Reader("F:\\java\\selinium programs\\Parabank_ParasoftTesting\\src\\test\\java\\com\\hari\\selenium\\testdata\\parasoft_registration-data.xlsx");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		int rowCount= reader.getRowCount("Registration");
		for(int rowNum=2;rowNum<=rowCount;rowNum++)
		{
			 String firstname= reader.getCellData("Registration", "firstname", rowNum);
			 System.out.println(firstname);
			 String lastname= reader.getCellData("Registration", "lastname", rowNum);
			 System.out.println(lastname);
			 String address= reader.getCellData("Registration", "address", rowNum);
			 System.out.println(address);
			 String city= reader.getCellData("Registration", "city", rowNum);
			 System.out.println(city);
			 String state= reader.getCellData("Registration", "state", rowNum);
			 System.out.println(state);
			 String pincode= reader.getCellData("Registration", "pincode", rowNum);
			 System.out.println(pincode);
			 String phonenumber= reader.getCellData("Registration", "phonenumber", rowNum);
			 System.out.println(phonenumber);
			 String ssn= reader.getCellData("Registration", "ssn", rowNum);
			 System.out.println(ssn);
			 String username= reader.getCellData("Registration", "username", rowNum);
			 System.out.println(username);
			 String password= reader.getCellData("Registration", "password", rowNum);
			 System.out.println(password);
			 Object ob[]= {firstname,lastname,address,city,state,pincode,phonenumber,ssn,username,password};
			 myData.add(ob);
		
		
	}
		return myData;
	}

}
