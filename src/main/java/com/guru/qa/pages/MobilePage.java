package com.guru.qa.pages;

//import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.guru.qa.base.TestBase;
import com.guru.qa.utilities.TestUtils;

public class MobilePage extends TestBase {
	////*[@id="top"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select
	@FindBy(xpath="//select[@title= 'Sort By']")
	WebElement select1;
	
	@FindBy(xpath="//a[@title='Sony Xperia']/parent::h2/parent::div[@class='product-info']//preceding-sibling::div[@class='price-box']//span[@class='price']")
			WebElement price;
	
	public MobilePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyMobilePageTitle()
	{
		//MobileTab.click();
		 return driver.getTitle();
	}
	
	public void sortProdByName(String var)
	{
		//MobileTab.click();
		
		TestUtils.selectDropDown(select1,var);
		
	}
	
	public void verifyprodSort()
	{
		List<WebElement> prod = driver.findElements(By.xpath("//li[@class='item last']//div//h2[@class='product-name']"));
		
		for(WebElement ele : prod)
		{
			System.out.println("element is : "+ ele.getText());
			Reporter.log("Product name is : "+ ele.getText());
		}
	}
	
	public String getMobilePrice()
	{
		
		String price = driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/parent::div[@class='product-info']//preceding-sibling::div[@class='price-box']//span[@class='price']")).getText();
		Reporter.log("Mobile Price  : "+ price);
		return price;
		
	}
	
	public DetailsPage clickOnMobile(String mobileName)
	{
		Reporter.log("click on Mobile " + mobileName);
		driver.findElement(By.xpath("//a[@class='product-image']//img[contains(@alt,mobileName)]")).click();
		return new DetailsPage();
	}
	
	public CartPage clickonAddToCart(String MobileName)
	{
		Reporter.log("Click on Add to Cart button for mobile " + MobileName);
		driver.findElement(By.xpath("//li[@class='item last']//a[@title='Sony Xperia']//parent::h2//parent::div//following"
				+ "-sibling::div[@class='actions']//span[contains(text(),'Add to Cart')]")).click();
		return new CartPage() ;
		
	}
	
	

}
