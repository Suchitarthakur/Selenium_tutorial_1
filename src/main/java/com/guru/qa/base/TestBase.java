package com.guru.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.guru.qa.utilities.TestUtils;




public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
				try {
				prop = new Properties();
				FileInputStream in = new FileInputStream("E:/JAPAN/Study/Selenium_Tutorial_Guru99_Test/src/main/java/com/guru/qa/config/data.properties");
				
				prop.load(in);
					} 
			
				catch (FileNotFoundException e)
					{
				// TODO Auto-generated catch block
				e.printStackTrace();
					}
			catch (IOException e) 
					{
				// TODO Auto-generated catch block
				e.printStackTrace();
					}
			
		
	}
	public static void initialization()
	{
		
	
		
		//ChromeOptions opt = new ChromeOptions();
		
		
		
		
		String browserName = prop.getProperty("browserName");
		if(browserName.equals("chrome"))
		{

			System.setProperty("webdriver.chrome.driver","C:/Users/Suchita/Downloads/chromedriver_win32 (2)/chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("disable-extensions");
			opt.addArguments("--start-maximized");
			driver = new ChromeDriver ();
			
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:/Users/Suchita/Downloads/geckodriver-v0.20.1-win32/geckodriver.exe");
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("disable-extensions");
			opt.addArguments("--start-maximized");
			driver = new FirefoxDriver(opt);
			
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
	
		
		
	}

}
