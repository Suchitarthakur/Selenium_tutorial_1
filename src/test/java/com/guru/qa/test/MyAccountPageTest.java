package com.guru.qa.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.LaunchPage;
import com.guru.qa.pages.MyAccountPage;
import com.guru.qa.utilities.TestUtils;

//import junit.framework.Assert;

public class MyAccountPageTest extends TestBase
{
	String sheetName ="AccountPage";
	public LaunchPage launchpage;
	public MyAccountPage myaccountpage;
	
	
	public MyAccountPageTest()
	{
		super();
	
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		launchpage = new LaunchPage();
		myaccountpage = launchpage.ClickOnMyAccount();
	}
	
	@DataProvider
	public Object[][] getGuruMyAccountPageData()
	{
		
		Object[][] data1 = TestUtils.getTestData(sheetName);
		return data1;
		
	}
	
	@Test(description="Create New Account and Share wishlist and Remove Item from wishList",
			dataProvider="getGuruMyAccountPageData")
	public void createAccount_shareWishlistTest(String FirstName,String LastName,String EmailID)
	{
		String msg;
		int flag=0,flag2=0;
		
		try {
			msg = myaccountpage.createAcc(FirstName, LastName, EmailID);
			Assert.assertEquals(msg, "Hello, "+FirstName+" "+LastName+"!","Registraion failed with mail id "+EmailID);
			System.out.println(msg);
			Reporter.log("Registartion successful with mail id"+ EmailID);
			flag=1;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			Reporter.log("Registration NOT SUCCESSFUL " +e);
		}
		
		
		if(flag==1)
			
		{
		try {
			myaccountpage.ClickonTVTab();
			String msg1 = myaccountpage.shareWishList();
			System.out.println(msg1);
			Assert.assertEquals(msg1, "Your Wishlist has been shared.","Wishlist could not be shared for email id" +EmailID);
			
			//
			Reporter.log("Hello !!"+FirstName+" "+LastName +" Your Wishlist has been shared. emailid " +EmailID);
			flag2=1;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Reporter.log("Could not be able to share wish list " +e);
		}
		}
		
		if(flag2==0)
		{
		try {
			String msg2 = myaccountpage.removeItenfromCart();
			System.out.println(msg2);
			Assert.assertEquals(msg2, "You have no items in your wishlist.", "Not able to empty wishlist");
			Reporter.log("Wishlist cart is empty sucessfully :" +EmailID );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			Reporter.log("Wish list could not be empty:" +e );
		}
		}
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
