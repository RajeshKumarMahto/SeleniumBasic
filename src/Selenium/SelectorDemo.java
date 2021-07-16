package Selenium;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ntp.TimeStamp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorDemo {

	public static void main(String[] args) throws WebDriverException, IOException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		//By Link Text
		WebElement ele = driver.findElement(By.linkText("A/B Testing"));
		System.out.println("---->"+ele.getText());
		//Take Screenshot
//		TakesScreenshot screenshot = (TakesScreenshot)driver;
//		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
//		File destFile = new File("G:\\Eclipse-workspace\\SeleniumBasic\\Screenshot"+ LocalDateTime.now());
//		FileUtils.copyDirectory(srcFile, destFile);
		ele.click();
		System.out.println("---->"+driver.findElement(By.xpath("//p")).getText());
		//Add/Remove Element
		driver.navigate().back();
		WebElement addAndRemoveElement = driver.findElement(By.xpath("//a[text()= 'Add/Remove Elements']"));
//		addAndRemoveElement.click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", addAndRemoveElement);
		
		String str = driver.findElement(By.xpath("//button[text()= 'Add Element']")).getText();
		System.out.println("---->"+str);
		
		driver.findElement(By.xpath("//button")).click();
		boolean deleteBtn = driver.findElement(By.xpath("//button[@class='added-manually']")).isDisplayed();
		if(deleteBtn) {
			System.out.println("Delete button is added");
		}
		else {
			System.out.println("Delete button is not added");
		}
		driver.quit();
	}

}
