package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.guru.qa.base.TestBase;

public class DetailsPage extends TestBase {

	@FindBy(xpath="//div[@class='price-box']//span[@class='price']")
	WebElement priceonDetailsPage;

	
	public DetailsPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	public String getMobilePriceOnDetailsPage()
	{
		String price2 = priceonDetailsPage.getText();
		Reporter.log("Price on Details page is "+ price2);
		return price2;
		
	}
}
