package XpathJava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathShortcuts {
	private static WebDriver driver;

	public static void highlight(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')",
				element);
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

		// text() -> .
		highlight(driver.findElement(By.xpath("//h1[.='Register']")));
		highlight(driver.findElement(By.xpath("//a[contains(.,'account')]")));
		highlight(driver.findElement(By.xpath("//td[starts-with(.,'Maria')]")));
		highlight(driver.findElement(By.xpath("//label[normalize-space(.)='First Name']")));

		// child -> /
		highlight(driver.findElement(By.xpath("//div[@class='container']/h1")));

		//parent - > /..
		highlight(driver.findElement(By.xpath("//h1[.='Register']/..")));

		//descendant -> //
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='contactList']//td"));
		for (WebElement element : elements) {
			highlight(element);
		}
	}
}
