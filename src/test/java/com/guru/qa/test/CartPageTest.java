package com.guru.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.CartPage;
//import com.guru.qa.pages.DetailsPage;
import com.guru.qa.pages.LaunchPage;
import com.guru.qa.pages.MobilePage;

public class CartPageTest extends TestBase {
	
	public LaunchPage launchpage;
	public MobilePage mobilepage;
	//public DetailsPage detailspage;
	public CartPage cartpage;
	
	public CartPageTest()
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
	
	
	@Test(priority=1,description = "Verify that you cannot add "
			+ "more product in cart than the product available in store \n Empty cart and verify Cart is empty")
	public void cartTest()
	{
		cartpage = mobilepage.clickonAddToCart("Sony Xperia");
		cartpage.clickonUpdateButton(1000);
		String errmsg = cartpage.getErrorMessage();
		System.out.println(errmsg);
		Assert.assertEquals(errmsg, "* The maximum quantity allowed for purchase is 500.", "diiff in error msg while update");
		
		String errmsg2 = cartpage.clickonEmptyCartBtn();
		System.out.println(errmsg2);
		
		Assert.assertEquals(errmsg2, "SHOPPING CART IS EMPTY", "difference in error msg in cart");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
