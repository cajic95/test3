package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

			List<String> asc = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				asc.add(list.get(i).getText().substring(1));
			}
			List<Double> listOfDouble = Inventory.convertStringListToDoubleList(asc, Double::parseDouble);
			System.out.println("Lista" + listOfDouble.toString());

			List<Double> ascSorted = new ArrayList<Double>(listOfDouble);
			ascSorted.sort(Comparator.naturalOrder());
			System.out.println("Lista" + ascSorted.toString());

			Assert.assertEquals(listOfDouble, ascSorted);

			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

	}

}
