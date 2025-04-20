package seleniumJava3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		// Create Actions object
		Actions actions = new Actions(driver);

		// Locate elements
		WebElement ClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

		// Click Action
		System.out.println("Performing Click on 'right click me' button");
		actions.click(ClickBtn).perform();
		Thread.sleep(3000);
		
		// Context Click (Right Click)
		System.out.println("Performing Right Click");
		actions.contextClick(rightClickBtn).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[.='Edit']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		// Double Click
		System.out.println("Performing Double Click");
		actions.doubleClick(doubleClickBtn).perform();

		// Handle alert from double-click
		driver.switchTo().alert().accept();
	}
}
