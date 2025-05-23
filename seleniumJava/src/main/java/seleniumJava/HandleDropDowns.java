package seleniumJava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDowns {
	public static void main(String[] args) throws InterruptedException {

//		Select options and deselect options in 3 ways
		// by Index
		// by Value
		// by Visible Text
//DropDown1
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		Thread.sleep(3000);
		WebElement courseElement = driver.findElement(By.id("course"));
		Select courseNameDropdown = new Select(courseElement);
		List<WebElement> courseNameDropdownOptions = courseNameDropdown.getOptions();
		for (WebElement option : courseNameDropdownOptions) {
			System.out.println(option.getText());
		}
		courseNameDropdown.selectByIndex(1);// Java
		Thread.sleep(3000);
		courseNameDropdown.selectByValue("net"); // Dot net
		Thread.sleep(3000);
		courseNameDropdown.selectByVisibleText("Javascript"); // Javascript
		Thread.sleep(3000);

		String selectedText = courseNameDropdown.getFirstSelectedOption().getText();
		System.out.println("Selected visible text - " + selectedText);
//DropDown2
		WebElement ideElement = driver.findElement(By.id("ide"));
		Select ideDropdown = new Select(ideElement);
		List<WebElement> ideDropdownOptions = ideDropdown.getOptions();
		for (WebElement option : ideDropdownOptions) {
			System.out.println(option.getText());
		}
		ideDropdown.selectByIndex(0);// Eclipse
		Thread.sleep(3000);
		ideDropdown.selectByValue("ij"); // IntelliJ IDEA
		Thread.sleep(3000);
		ideDropdown.selectByVisibleText("NetBeans"); // NetBeans
		Thread.sleep(3000);
		// deselect the optiobn by visible text
		ideDropdown.deselectByVisibleText("IntelliJ IDEA");
		// Print all selected options
		List<WebElement> selectedOptions = ideDropdown.getAllSelectedOptions();
		for (WebElement selectedOption : selectedOptions) {
			System.out.println("Selected visible text - " + selectedOption.getText());
		}
	}
}
