package seleniumJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrames {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.findElement(By.id("name")).sendKeys("ViratKohli");
		Thread.sleep(3000);

		driver.switchTo().frame("frm1");//frame1
		Select selectdata = new Select(driver.findElement(By.id("course")));
		selectdata.selectByVisibleText("Java");
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Kohli");
		Thread.sleep(3000);

		driver.switchTo().frame("frm2"); //frame2
		driver.findElement(By.id("firstName")).sendKeys("CharanTeja");
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();//Main document
		driver.switchTo().frame("frm1"); 
		selectdata.selectByVisibleText("Dot Net");
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();//Main document
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("ViratKohli");
		Thread.sleep(3000);
		
		driver.switchTo().frame("frm3");//frame3
		driver.findElement(By.id("name")).sendKeys("sachin");
		Thread.sleep(3000);
		
		driver.switchTo().frame("frm1");//sub frame1 of frame3
		Select selectdata1 = new Select(driver.findElement(By.id("course")));
		selectdata1.selectByVisibleText("Python");
		Thread.sleep(3000);
		
//		driver.switchTo().frame("frm2"); //sub frame2 of frame3
//		driver.findElement(By.id("firstName")).sendKeys("CharanTeja");
//		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Maruthi Teja");
		driver.quit();
	}
}
