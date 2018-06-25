package com.guru.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.guru.qa.base.TestBase;

public class TestUtils extends TestBase {
	
	public static int IMPLICIT_WAIT = 40;
	
	//public static WebElement element;
	//public static String TexttoBeSelected;
	
	static Workbook book;
	static Sheet sheet;
	
	public static void mouseMovement(WebElement element,WebElement element2, WebDriver driver )
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		element2.click();
	}
	public static void selectDropDown(WebElement element, String TexttoBeSelected)
	{
	Select oSelect = new Select(element);
	oSelect.selectByVisibleText(TexttoBeSelected);
	}
	
	public static String TESTDATA_SHEET_PATH = 
			"E:/JAPAN/Study/Selenium_Tutorial_Guru99_Test/src/main/java/com/guru/qa/testdata/Guru_Site_TestData.xlsx";
	
	

	
	
	
	
	public static  void switchToAlert_accept(WebDriver driver)
	{
		
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".jpg"));
		
		}

}
