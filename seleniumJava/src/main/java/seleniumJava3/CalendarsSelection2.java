package seleniumJava3;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarsSelection2 {
    public static void main(String[] args) throws Exception {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to the site
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

        // Click first date picker
        driver.findElement(By.id("first_date_picker")).click();

        // Select the date
        selectDate(driver, "05/June/2025");

        driver.findElement(By.id("second_date_picker")).click();
		selectDate(driver, "10/May/2025");
    }

    public static void selectDate(WebDriver driver, String date) throws Exception {
        Calendar calendar = Calendar.getInstance();

        // Handle date format
        SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
        targetDateFormat.setLenient(false);
        Date formattedTargetDate;
        try {
            formattedTargetDate = targetDateFormat.parse(date);
            calendar.setTime(formattedTargetDate);
        } catch (Exception e) {
            throw new Exception("Invalid date provided! Use format dd/MMMM/yyyy like 05/June/2015.");
        }

        int targetMonth = calendar.get(Calendar.MONTH);
        int targetYear = calendar.get(Calendar.YEAR);
        int targetDay = calendar.get(Calendar.DAY_OF_MONTH);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Read current calendar title
        String currentDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ui-datepicker-title"))).getText(); // e.g., June 2015
        calendar.setTime(new SimpleDateFormat("MMMM yyyy").parse(currentDate));
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);

        // Navigate to target month/year
        while (currentMonth < targetMonth || currentYear < targetYear) {
            WebElement next = wait.until(ExpectedConditions.elementToBeClickable(
                    By.className("ui-datepicker-next")));
            try {
                next.click();
            } catch (ElementClickInterceptedException e) {
                js.executeScript("arguments[0].click();", next); // Fallback
            }

            currentDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("ui-datepicker-title"))).getText();
            calendar.setTime(new SimpleDateFormat("MMMM yyyy").parse(currentDate));
            currentMonth = calendar.get(Calendar.MONTH);
            currentYear = calendar.get(Calendar.YEAR);
        }

        while (currentMonth > targetMonth || currentYear > targetYear) {
            WebElement prev = wait.until(ExpectedConditions.elementToBeClickable(
                    By.className("ui-datepicker-prev")));
            try {
                prev.click();
            } catch (ElementClickInterceptedException e) {
                js.executeScript("arguments[0].click();", prev); // Fallback
            }

            currentDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("ui-datepicker-title"))).getText();
            calendar.setTime(new SimpleDateFormat("MMMM yyyy").parse(currentDate));
            currentMonth = calendar.get(Calendar.MONTH);
            currentYear = calendar.get(Calendar.YEAR);
        }

        // Finally, click the target day
        if (currentMonth == targetMonth && currentYear == targetYear) {
            String dayXpath = "//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()=" + targetDay + "]";
            WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath)));
            day.click();
        } else {
            throw new Exception("Failed to reach the correct month/year.");
        }
    }
}
