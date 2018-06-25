package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.guru.qa.base.TestBase;
import com.guru.qa.utilities.TestUtils;

public class MyAccountPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Create an Account')]")
	WebElement createaccbtn;
	
	
	
	@FindBy(xpath="//input[@title='First Name']")
	WebElement FN;
	
	
	@FindBy(xpath="//input[@title='Last Name']")
	WebElement LN;
	
	@FindBy(xpath="//input[@title='Email Address']")
	WebElement email;
	
	
	@FindBy(xpath="//input[@title='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@title='Confirm Password']")
	WebElement confirmPass;
	
	
	
	
	@FindBy(xpath="//button[@title='Register']")
	WebElement Register_btn;
	
	@FindBy(xpath="//div[@class='welcome-msg']//p[@class='hello']//strong")
	WebElement welcomeMsg;
	
	public MyAccountPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'TV')]")
	WebElement tvLink;
	
	
	@FindBy(xpath="//div[@class='actions']//button[@title='Add to Cart']//following-sibling::ul[@class='add-to-links']//a[@class='link-wishlist']")
	WebElement wishlistbtn;
	
	@FindBy(xpath="//span[contains(text(),'Share Wishlist')]")
	WebElement SharewishListBtn;
	
	@FindBy(xpath="//textarea[@id='email_address']")
	
	WebElement enterEmailText;
	
	@FindBy(xpath="//span[contains(text(),'Share Wishlist')]")
	WebElement SharewishListBtn2;
	
	@FindBy(xpath="//li[@class='success-msg']//ul//li//span")
	WebElement successmsg;
	
	@FindBy(xpath="//a[contains(text(),'Remove item')]")
	WebElement removeItemBtn;
	
	@FindBy(xpath="//p[@class='wishlist-empty']")
	WebElement emptycartmsg;
	

	
	public String createAcc(String firstname, String lastname,String mailid)
	{
		Reporter.log("User Registration");
		createaccbtn.click();
		FN.clear();
		FN.sendKeys(firstname);
		LN.clear();
		LN.sendKeys(lastname);
		email.clear();
		email.sendKeys(mailid);
		password.clear();
		password.sendKeys("Suchi@1987");
		confirmPass.clear();
		confirmPass.sendKeys("Suchi@1987");
		Register_btn.click();
		
		String msg = welcomeMsg.getText();
		return msg;
		
		
	}
	
	public void ClickonTVTab()
	{
		tvLink.click();
		//return new TVPage();
	}
	
	
	public String shareWishList()
	{
		wishlistbtn.click();
		SharewishListBtn.click();
		enterEmailText.sendKeys("abc@abc.com");
		SharewishListBtn2.click();
		
		String successMessage = successmsg.getText();
		
		return successMessage;
	}
	 public String removeItenfromCart()
	 {
		 removeItemBtn.click();
		 TestUtils.switchToAlert_accept(driver);
		 //You have no items in your wishlist.


		return emptycartmsg.getText();
	 }

	

}
