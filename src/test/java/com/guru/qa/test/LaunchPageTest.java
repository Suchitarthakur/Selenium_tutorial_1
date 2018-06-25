package com.guru.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.LaunchPage;

public class LaunchPageTest extends TestBase{

	public LaunchPage launchpage;
	public LaunchPageTest()
	{
		super();
		
				
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		launchpage= new LaunchPage();
		
	}
	
	@Test(priority=1,description="verify Launch Page title")
	public void launchPageTitleTest()
	{
		System.out.println("entering method");
		String Title = launchpage.VerifyLaunchPageTitle();
		//System.out.println("entering method inside launchpage");
		Assert.assertEquals(Title, "Home page", "Home Page Title is not correct");
	}
	
	@Test(priority=2, description="Click on Mobile Tab")
	public void clickOnMobileTabTest()
	{
		launchpage.ClickOnMobileTab();
	}
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();	
	}
	
}
