package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objs.HomePageS;
import objs.Inventory;


public class TestSort {
	public static final String LOW_PRICE_ITEM = "//*[@id=\"item_2_title_link\"]/div";
	
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\Chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();

	}
	@Test
	public void testLoging2() {
		File f = new File("data.xlsx");
		
		try {
			InputStream in = new FileInputStream(f);
			
			XSSFWorkbook wb;
			wb = new XSSFWorkbook(in);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(0);
			Cell cell2 = row.getCell(1);
			
			
			driver.manage().window().maximize();
			driver.get(HomePageS.URL);
			HomePageS.clickUsername(driver, cell.toString());
			HomePageS.clickPassword(driver, cell2.toString());
			HomePageS.clickLogin(driver);
			
			Inventory.clickSort(driver);
			
			
		
			
			List<WebElement> list = driver.findElements(By.className("inventory_item_price"));
			
			
			
			String actualPrice1= list.get(0).getText();;
			String expectedPrice1 = "$7.99";
			String actualPrice2 = list.get(list.size()-1).getText();
			String expectedPrice2 = "$49.99";
			
			Assert.assertEquals(actualPrice1, expectedPrice1);
			Assert.assertEquals(actualPrice2, expectedPrice2);
			
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		
		
	}


}
