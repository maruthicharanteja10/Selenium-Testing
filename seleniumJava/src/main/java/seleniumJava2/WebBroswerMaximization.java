package seleniumJava2;

import java.awt.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebBroswerMaximization {
	public static void main(String[] args) throws Exception {
		
		//Only one work at a time in specific browser
		
		// Way 1 - Chrome
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver1 = new ChromeDriver();
		 driver1.manage().window().maximize( );
//		 driver1.manage().window().setSize(new org.openqa.selenium.Dimension(1000, 1000));
		 driver1.get("https://www.google.com/");

		// Way 1 - Firefox
		 WebDriverManager.firefoxdriver().setup();
		 WebDriver driver2 = new FirefoxDriver();
		 driver2.manage().window().maximize();
		 driver2.get("https://www.google.com/");

		// Way 1 - Edge
		 WebDriverManager.edgedriver().setup();
		 WebDriver driver3 = new EdgeDriver();
		 driver3.manage().window().maximize();
		 driver3.get("https://www.google.com/");

		// Way 2 - Chrome
		WebDriverManager.chromedriver().setup();
		ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("start-maximized");
		WebDriver driver4 = new ChromeDriver(options1);
		driver4.get("https://www.google.com/");

		// Way 2 - Edge
		WebDriverManager.edgedriver().setup();
		EdgeOptions options2 = new EdgeOptions();
		options2.addArguments("start-maximized");
		WebDriver driver5 = new EdgeDriver(options2);
		driver5.get("https://www.google.com/");
	}
}
