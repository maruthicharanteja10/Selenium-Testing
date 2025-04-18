package seleniumJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplicationProperties {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");

		// URL
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL - " + currentUrl);

		// Title
		String title = driver.getTitle();
		System.out.println("Title - " + title);

		// HTML Page Source
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);

		driver.quit();
	}
}
