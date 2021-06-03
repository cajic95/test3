package objs;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inventory {
	public static final String URL = "https://www.saucedemo.com/inventory.html";
	public static final String BTN_SORT_XPATH = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select";
	public static final String SORT_LTH = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]";
	
	////*[@id="header_container"]/div[2]/div[2]/span/select
	////*[@id="header_container"]/div[2]/div[2]/span/select
	
	public static void clickSort(WebDriver driver) {
		WebElement btn = driver.findElement(By.xpath(BTN_SORT_XPATH));
		btn.click();
		btn.findElement(By.xpath(SORT_LTH)).click();
		
	}

	public static <T, U> List<U> convertStringListToDoubleList(List<T> listOfString, Function<T, U> function) 
   { 
       return listOfString.stream() 
           .map(function) 
           .collect(Collectors.toList()); 
   }
}
