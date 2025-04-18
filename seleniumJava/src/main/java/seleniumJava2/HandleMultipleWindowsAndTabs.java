package seleniumJava2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleWindowsAndTabs {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		// Multiple Windows
		String ParentWindow = driver.getWindowHandle();
		System.out.println("Parent Windows" + ParentWindow + " " + driver.getTitle());
		driver.findElement(By.id("newWindowsBtn")).click();
		Set<String> WindowsHandles = driver.getWindowHandles();
		for (String windowHandle : WindowsHandles) {
			System.out.println(windowHandle + "" + driver.getTitle());
			if (!windowHandle.equals(ParentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		driver.manage().window().maximize();
		driver.findElement(By.name("name")).sendKeys("Teja");
		Thread.sleep(3000);
		driver.switchTo().window(ParentWindow);
		driver.findElement(By.id("name")).sendKeys("Tej");

		// Comment above lines when working with multiple tabs
		// Multiple Tabs
		String ParentWindow1 = driver.getWindowHandle();
		System.out.println("Parent Windows" + ParentWindow1 + " " + driver.getTitle());
		driver.findElement(By.id("newTabsBtn")).click();
		Set<String> WindowsHandles1 = driver.getWindowHandles();
		for (String windowHandle : WindowsHandles1) {
			System.out.println(windowHandle + "" + driver.getTitle());
			if (!windowHandle.equals(ParentWindow1)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		driver.manage().window().maximize();
		System.out.println(driver.findElement(By.id("output")).getText());
		driver.findElement(By.id("alertBox")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("output")).getText());
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(ParentWindow1);
		driver.findElement(By.id("name")).sendKeys("Tej");
		Thread.sleep(3000);
		driver.quit();
	}
}
