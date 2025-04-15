package seleniumJava;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSingleWindowAndTab {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		// SingleWindow
		String ParentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent Window Handle" + ParentWindowHandle + "" + driver.getTitle());
		driver.findElement(By.id("newWindowBtn")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			System.out.println(windowHandle+""+driver.getTitle());
			if (!windowHandle.equals(ParentWindowHandle)) {
				
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				driver.findElement(By.id("firstName")).sendKeys("CharanTeja");
				Thread.sleep(3000);
				driver.close();
				Thread.sleep(2000);
			}
		}
		driver.switchTo().window(ParentWindowHandle);
		driver.findElement(By.id("name")).sendKeys("Tej");
		
		
		// SingleTab
		String ParentWindowHandle1 = driver.getWindowHandle();
		System.out.println("Parent Window Handle" + ParentWindowHandle1 + "" + driver.getTitle());
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String windowHandle : windowHandles1) {
			System.out.println(windowHandle+""+driver.getTitle());
			if (!windowHandle.equals(ParentWindowHandle1)) {
				
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.findElement(By.id("output")).getText());
				driver.findElement(By.id("alertBox")).click();
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				System.out.println(driver.findElement(By.id("output")).getText());
				Thread.sleep(3000);
				driver.close();
				Thread.sleep(2000);
			}
		}
		driver.switchTo().window(ParentWindowHandle1);
		driver.findElement(By.id("name")).sendKeys("Tej");
		
		
		
		driver.quit();
	}
}
