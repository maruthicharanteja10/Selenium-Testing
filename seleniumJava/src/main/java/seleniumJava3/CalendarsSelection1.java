package seleniumJava3;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarsSelection1 {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the jQuery UI Datepicker demo page
        driver.get("https://jqueryui.com/datepicker/");

        // Switch to the iframe that contains the datepicker
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Click on the datepicker input field to open the calendar
        driver.findElement(By.id("datepicker")).click();

        // Desired month and year
        String targetMonth = "May";
        String targetYear = "2025";

        // Navigate until we find May 2025
        while (true) {
            String displayedMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            String displayedYear = driver.findElement(By.className("ui-datepicker-year")).getText();

            if (displayedMonth.equals(targetMonth) && displayedYear.equals(targetYear)) {
                break;
            }

            // Click the next button
            driver.findElement(By.xpath("//a[@title='Next']")).click();
        }

        // Select the 20th of the displayed month
        driver.findElement(By.xpath("//a[text()='20']")).click();

        // Just to see the result before closing
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(
            driver.findElement(By.id("datepicker")), "value"));

        // Print the selected date
        String selectedDate = driver.findElement(By.id("datepicker")).getAttribute("value");
        System.out.println("Selected Date: " + selectedDate);

//        driver.quit();
	}
}
