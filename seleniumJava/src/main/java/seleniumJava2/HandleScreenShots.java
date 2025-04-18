package seleniumJava2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleScreenShots {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		// File
		File sourceFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/img1.jpg");
		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screenshot saved successfully");

		// Bytes
		byte[] byteArr = driver.getScreenshotAs(OutputType.BYTES);
		File destFile1 = new File("./Screenshots/img2.jpg");
		FileOutputStream fos = new FileOutputStream(destFile1);
		fos.write(byteArr);
		fos.close();
		System.out.println("Screenshot saved successfully");

		// Base64
		String base64code = driver.getScreenshotAs(OutputType.BASE64);
		byte[] byteArr1 = Base64.getDecoder().decode(base64code);
		File destFile2 = new File("./Screenshots/img3.jpg");
		FileOutputStream fos1 = new FileOutputStream(destFile2);
		fos1.write(byteArr1);
		fos1.close();
		System.out.println("Screenshot saved successfully");
		
		////////////

		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();

		driver1.get("https://www.cricbuzz.com/");

		// File
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver1;
		File sourceFiles = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFiles = new File("./Screenshots/img4.jpg");
		FileUtils.copyFile(sourceFiles, destFiles);
		System.out.println("Screenshot saved successfully");

		// Bytes
		TakesScreenshot takesScreenshot2 = (TakesScreenshot) driver1;
		byte[] byteArr2 = takesScreenshot2.getScreenshotAs(OutputType.BYTES);
		File destFiles2 = new File("./Screenshots/img5.jpg");
		FileOutputStream foss = new FileOutputStream(destFiles2);
		foss.write(byteArr2);
		foss.close();
		System.out.println("Screenshot saved successfully");

		// Base64
		TakesScreenshot takesScreenshot3 = (TakesScreenshot) driver1;
		String base64code2 = takesScreenshot3.getScreenshotAs(OutputType.BASE64);
		byte[] byteArr3 = Base64.getDecoder().decode(base64code2);
		File destFiles3 = new File("./Screenshots/img6.jpg");
		FileOutputStream fosss = new FileOutputStream(destFiles3);
		fosss.write(byteArr3);
		fosss.close();
		System.out.println("Screenshot saved successfully");

		driver.quit();
		driver1.quit();
	}
}
