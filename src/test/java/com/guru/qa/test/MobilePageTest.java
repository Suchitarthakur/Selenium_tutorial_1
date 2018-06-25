package com.guru.qa.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.CartPage;
import com.guru.qa.pages.DetailsPage;
import com.guru.qa.pages.LaunchPage;
import com.guru.qa.pages.MobilePage;
import com.guru.qa.utilities.TestUtils;

//import junit.framework.Assert;

public class MobilePageTest extends TestBase {

	String sheetName = "MobilePage";
	
	public LaunchPage launchpage;
	public MobilePage mobilepage;
	public DetailsPage detailspage;
	public CartPage cartpage;
	
	public MobilePageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		launchpage = new LaunchPage();
		mobilepage = launchpage.ClickOnMobileTab();
	}

	@Test(priority=1,description="verify Mobile Page title")
	public void verifyMobilePageTitle()
	{
		String Title = mobilepage.VerifyMobilePageTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "Mobile");
	}
	
	
	@DataProvider
	public Object[][] getGuruMobilePageData()
	{
		Object[][] data = TestUtils.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=2,description="verify product sort by Name",dataProvider="getGuruMobilePageData")
	public void verifyprodSortTest(String var_name )
	{
		Reporter.log("Product Sort by " +var_name+ "\n");
		mobilepage.sortProdByName(var_name);
		mobilepage.verifyprodSort();
	}
	
	
	
	@Test(priority=3,description="Verify that cost of product in list page and details page are equal")
	public void compare_Cost_From_List_and_Details_Page_Test()
	{
		
		String mobileprice = mobilepage.getMobilePrice();
		System.out.println("mobileprice on Mobie page = "+mobileprice);
		
		detailspage = mobilepage.clickOnMobile("Xperia");
		
		String price2 = detailspage.getMobilePriceOnDetailsPage();
		System.out.println("mobileprice on details page = "+price2);
		
		Assert.assertEquals(mobileprice, price2, "price are not equal");
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
