package com.guru.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.guru.qa.base.TestBase;

public class CartPage extends TestBase {
	
	
	@FindBy(xpath="//input[@title='Qty']")
	WebElement qty;
	
	@FindBy(xpath="//button[@type='submit' and @title='Update'] //span[contains(text(),'Update')]")
	WebElement updatebtn;
	
	@FindBy(xpath="//span[contains(text(),'Empty Cart')]")
	WebElement emptycartbtn;
	
	
	@FindBy(xpath="//div[@class='page-title']")
	WebElement emptycartmsg;
	
	
	public CartPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	
	public void clickonUpdateButton(int i)
	{
		
		qty.sendKeys(Integer.toString(i));
		updatebtn.click();
		
		//return new CartPage() ;
		
	}
	
	public String getErrorMessage()
	{
		 
				String errmsg = driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]"
				+ "//parent::h2[@class='product-name']//following-sibling::p[@class='item-msg error']")).getText();
				
				Reporter.log("Error message on Cart page is " +errmsg) ;
				return errmsg; 
	}
	
	public String clickonEmptyCartBtn()
	{
		
		emptycartbtn.click();
		return emptycartmsg.getText();
		
		//return new CartPage() ;
		
	}

}
