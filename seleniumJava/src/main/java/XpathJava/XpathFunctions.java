package XpathJava;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathFunctions {
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
		highlight(driver.findElement(By.xpath("//a[text()='Sign in']")));
		highlight(driver.findElement(By.xpath("//a[contains(text(),'account')]")));
		highlight(driver.findElement(By.xpath("//div[contains(@class,'signin')]")));
		highlight(driver.findElement(By.xpath("//a[starts-with(text(),'Sign in into')]")));
		highlight(driver.findElement(By.xpath("//label[normalize-space(text())='First Name']")));
		highlight(driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr)[last()]")));
		System.out.println(driver.findElements(By.xpath("(//table[@id='contactList']/tbody/tr)[position()>2]")).size());
	}
}
