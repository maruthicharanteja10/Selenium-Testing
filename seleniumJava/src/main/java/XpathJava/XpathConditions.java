package XpathJava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathConditions {
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
		System.out.println(driver.findElements(By.xpath("//input")).size());
		
		List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength<=15 and @name='name' and @type='text']"));
		System.out.println(elements.size());

		List<WebElement> elementss = driver.findElements(By.xpath("//input[@maxlength<=15 or @name='namgge' or @type='tegggxt']"));
		System.out.println(elementss.size());

		List<WebElement> elementsss = driver.findElements(By.xpath("//input[not(@maxlength=10)]"));
		System.out.println(elementsss.size());
	}
}
