package objs;

/*
 * Test Selenium
Zadatak
Napisati program na programskom jeziku Java koji sluzi za testiranje sajta https://www.saucedemo.com/ 
Pokusati logovanje prvo sa nevalidnim, a potom sa validnim kredencijalima i proveriti da li se nakon toga
 korisnik nalazi na odgovarajucoj staranici. Na stranici https://www.saucedemo.com/inventory.html sortirati proizvode po ceni 
 (od najnize ka najvisoj). Proveriti da li je sortiranje ispravno. 
Program pisati postujuci page object model. Koristiti Test NG za proveru ispravnosti testova.
 Kredencijale procitati iz datoteke data.xlsx. Resenje okaciti na GitHub nalog i svoj folder na google drive-u 
 (napraviti folder pod nazivom kontrolni3).

 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageS {
	public static final String URL = "https://www.saucedemo.com/";
	public static final String USERNAME_XPATH = "//*[@id=\"user-name\"]";
	public static final String PASSWORD_XPATH = "//*[@id=\"password\"]";
	public static final String LOGIN_XPATH = "//*[@id=\"login-button\"]";
	
	public static  void clickUsername(WebDriver driver, String username) {
		WebElement usernamee = driver.findElement(By.xpath(USERNAME_XPATH));
		usernamee.click();
		usernamee.sendKeys(username);
	}

	public static void clickPassword(WebDriver driver, String password){
		WebElement passwordd = driver.findElement(By.xpath(PASSWORD_XPATH));
		passwordd.click();
		passwordd.sendKeys(password);
	}
	public static void clickLogin(WebDriver driver) {
		WebElement login = driver.findElement(By.xpath(LOGIN_XPATH));
		login.click();
		
	}
}
