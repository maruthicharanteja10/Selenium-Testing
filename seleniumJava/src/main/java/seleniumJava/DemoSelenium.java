package seleniumJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSelenium {
	public static void main(String[] args) {
//	    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
//		WebDriverManager.chromedriver().setup(); //Proxy will be added if there is any issues in a company network
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
}
