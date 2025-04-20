package seleniumJava3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorDemo {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//Find elements and entering text in textbox in a webpage using Javascript executor
	WebElement element = (WebElement) jsExecutor.executeScript("return document.evaluate(\"//input[@id='email']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue;");
	element.sendKeys("xpath");
	jsExecutor.executeScript("document.getElementById('email').value='id';");
	Thread.sleep(3000);
	jsExecutor.executeScript("document.getElementsByName('email')[0].value='name';");
	Thread.sleep(3000);
	jsExecutor.executeScript("document.getElementsByClassName('inputtext')[0].value='classname';");
	Thread.sleep(3000);
	jsExecutor.executeScript("document.getElementsByTagName('input')[2].value='tagname';");
	Thread.sleep(3000);
	jsExecutor.executeScript("document.querySelector('#email').value='css';");
	Thread.sleep(3000);
	jsExecutor.executeScript("document.evaluate(\"//input[@id='email']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.value='xpath';");

//Click 
	jsExecutor.executeScript("document.getElementsByName('login')[0].click()");

//highlight using javascript executor
	jsExecutor.executeScript("document.getElementById('email').style.border='5px red solid';");
	Thread.sleep(3000);
	jsExecutor.executeScript("document.getElementById('email').style.background='yellow';");
	jsExecutor.executeScript("document.getElementById('email').setAttribute('style','border:5px red solid;background:yellow');");

//Scroll 
	jsExecutor.executeScript("window.scrollTo(0,500)");
	Thread.sleep(3000);
	jsExecutor.executeScript("window.scrollBy(0,500)");
	jsExecutor.executeScript("document.getElementById('ty_footer').scrollIntoView();");

//Identify By using  findelement and colored by javascriptexecutor
		WebElement username = driver.findElement(By.id("email"));
		jsExecutor.executeScript("arguments[0].setAttribute('style','border:5px red solid;background:yellow');",
				username);
	}


}
