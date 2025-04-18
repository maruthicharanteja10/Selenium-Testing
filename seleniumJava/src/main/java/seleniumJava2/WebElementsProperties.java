package seleniumJava2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementsProperties {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/login");

// TagName
		System.out.println(driver.findElement(By.name("commit")).getTagName());

// HTML attribute value
		System.out.println(driver.findElement(By.name("commit")).getAttribute("type"));

// HTML attribute value - Textbox Text
		WebElement usernameTxt = driver.findElement(By.id("login_field"));
		usernameTxt.sendKeys("Teja@gmail.com");
		System.out.println(usernameTxt.getAttribute("value"));

// HTML element text (except textbox)
		System.out
				.println(driver.findElement(By.xpath("//input[@id='login_field']/preceding-sibling::label")).getText());
// CSS attribute Value
		System.out.println(driver.findElement(By.name("commit")).getCssValue("background-color"));
//Element enable check
		System.out.println(driver.findElement(By.name("commit")).isEnabled());
//Element displayed check
		System.out.println(driver.findElement(By.name("commit")).isDisplayed());
//Get Size of btn
		System.out.println(driver.findElement(By.name("commit")).getSize().getWidth());
		driver.quit();
	}
}
