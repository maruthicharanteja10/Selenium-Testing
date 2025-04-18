package XpathJava;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
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
		highlight(driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[@type='text']")));
		driver.findElement(By.xpath("//td[text()='Maria Anders']/preceding-sibling::td/child::input")).click();
		highlight(driver.findElement(By.xpath("//label[text()='Password']/following::input")));
		//td[text()='Helen Bennett']/ancestor-or-self::*
		//table[@id='contactList']/descendant-or-self::*
		//label[text()='Password']/preceding::input[1]
	}
}
