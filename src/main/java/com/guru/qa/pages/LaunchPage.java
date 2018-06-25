package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.guru.qa.base.TestBase;

public class LaunchPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Mobile')]")
			WebElement MobileTab;
	
	@FindBy(xpath="//a[@data-target-element='#header-account']//span[contains(text(),'Account')]")
	WebElement AccLink;////*[@id="header"]/div/div[2]/div/a/span[2]
	
	@FindBy(xpath="//div[@id='header-account']//parent::div[@class='links']//parent::ul//parent::li[@class='first']//a[@title='My Account']")
	WebElement MyAccLink;
	
	
	
	
	
	public MobilePage mobilepage;
	
	public LaunchPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	public String VerifyLaunchPageTitle()
	{
		String LaunchPageTitle1 = driver.getTitle();
		Reporter.log("Launch Page Title is------> " +LaunchPageTitle1 );
		return LaunchPageTitle1;
	}
	
	public MobilePage ClickOnMobileTab()
	{
		MobileTab.click();
		 return new MobilePage();
	}
	
	
	public MyAccountPage ClickOnMyAccount()
	{
		//System.out.println("entered");
		Reporter.log("Mouse over to accont and click on My account link");
		//System.out.println("mouse movement");
		//TestUtils.mouseMovement(AccLink,MyAccLink,driver);//
		
		//Actions action = new Actions(driver);
		
	//	WebDriverWait wait = new WebDriverWait(driver,30);
	  //  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-target-element='#header-account']//span[contains(text(),'Account')]")));
		//action.moveToElement(AccLink).build().perform();
		AccLink.click();
		MyAccLink.click();
		
				
		//MyAccLink.click();
		return new MyAccountPage();
		
	}
	
	
	
	

}
