package seleniumJava2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitTime {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1000, 1000));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.withTimeout(Duration.ofSeconds(10));

		driver.get("https://www.cricbuzz.com/");
		WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("cb-plus-user-icon")));
		userIcon.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cb-user-email-input")));
		driver.findElement(By.id("cb-user-email-input")).sendKeys("teja");
	}

}
